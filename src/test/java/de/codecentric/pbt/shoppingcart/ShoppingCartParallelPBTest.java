package de.codecentric.pbt.shoppingcart;

import com.google.common.base.Stopwatch;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.quicktheories.core.Gen;
import org.quicktheories.core.stateful.Command;
import org.quicktheories.core.stateful.Parallel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static de.codecentric.pbt.shoppingcart.gen.CommandGen.addCommands;
import static de.codecentric.pbt.shoppingcart.gen.CommandGen.resetCommands;
import static de.codecentric.pbt.shoppingcart.util.Euro.euro;
import static java.lang.String.format;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.lists;

class ShoppingCartParallelPBTest {

    private Stopwatch stopwatch;

    @BeforeEach
    void setUp() {
        stopwatch = Stopwatch.createStarted();
    }

    @AfterEach
    void tearDown() {
        stopwatch.stop();
        System.out.println(format("Time: %s ms", stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }

    @Test
    void concurrentAddingAndResettingCalculatesTheCorrectCost() {
        int threads = 4;
        Parallel parallel = new Parallel(100, TimeUnit.MILLISECONDS);

        Gen<List<Command<ShoppingCart, Money>>> commandSequences = lists()
                .of(addCommands().mix(resetCommands()))
                .ofSize(4);

        qt()
                .withShrinkCycles(100)
                .withExamples(100000)
                .forAll(commandSequences)
                .checkAssert((commands) ->
                        parallel.parallelCheck(euro(0), commands,
                                model -> new ShoppingCart(),
                                sut -> sut.cost(),
                                threads));
    }

}
