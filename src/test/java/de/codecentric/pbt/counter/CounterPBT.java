package de.codecentric.pbt.counter;

import org.junit.jupiter.api.Test;
import org.quicktheories.WithQuickTheories;
import org.quicktheories.core.Gen;
import org.quicktheories.core.stateful.Command;
import org.quicktheories.core.stateful.Parallel;
import org.quicktheories.core.stateful.Sequential;

import java.util.List;
import java.util.concurrent.TimeUnit;

// https://raw.githubusercontent.com/ncredinburgh/QuickTheories/master/core/src/test/java/com/example/StatefulTest.java
public class CounterPBT implements WithQuickTheories {

    @Test
    void sequential() {
        Gen<List<Commands>> commandSequences = lists().of(arbitrary()
                .enumValuesWithNoOrder(Commands.class))
                .ofSizeBetween(1, 100);

        qt()
                .forAll(longs().between(0, 10), commandSequences)
                .checkAssert((initialState, commands) -> Sequential.modelCheck(
                        initialState, commands, NotThreadSafeCounter::new, Counter::get));
    }

    @Test
    void parallel() {
        int threads = 4;
        Parallel parallel = new Parallel(100, TimeUnit.MILLISECONDS);

        // use short command sequences only
        Gen<List<Commands>> commandSequences = lists().of(arbitrary()
                .enumValuesWithNoOrder(Commands.class))
                .ofSizeBetween(3, 8);

        qt()
                .withShrinkCycles(100)
                .withExamples(100)
                .forAll(longs().between(0, 10), commandSequences)
                .checkAssert((initialState, commands) -> parallel.parallelCheck(
                        initialState, commands, NotThreadSafeCounter::new, Counter::get, threads));
    }

    enum Commands implements Command<Counter, Long> {

        INC {
            @Override
            public void run(Counter sut) {
                sut.inc();
            }

            @Override
            public Long nextState(Long state) {
                return state + 1;
            }
        },

        DOUBLE {
            @Override
            public void run(Counter sut) {
                sut.doubleIt();
            }

            @Override
            public Long nextState(Long state) {
                return state = state * 2;
            }
        },

        DEC {
            @Override
            public void run(Counter sut) {
                sut.dec();
            }

            @Override
            public Long nextState(Long state) {
                return state - 1;
            }

        },

        GET {
            @Override
            public void run(Counter sut) {
                sut.get();
            }

            @Override
            public Long nextState(Long state) {
                return state;
            }
        },


        RESET {
            @Override
            public void run(Counter sut) {
                sut.reset();
            }

            @Override
            public Long nextState(Long state) {
                return 0L;
            }
        },

    }

    interface Counter {
        void dec();

        void doubleIt();

        void inc();

        long get();

        void reset();
    }

    class NotThreadSafeCounter implements Counter {

        private long n;

        NotThreadSafeCounter(long start) {
            n = start;
        }

        public void dec() {
            n = n - 1;
        }

        public void doubleIt() {
            n = n * 2;
        }

        public void inc() {
            n = n + 1;
        }

        public long get() {
            return n;
        }

        public void reset() {
            n = 0;
        }
    }

}
