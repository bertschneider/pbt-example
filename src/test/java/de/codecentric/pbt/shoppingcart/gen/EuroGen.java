package de.codecentric.pbt.shoppingcart.gen;

import de.codecentric.pbt.shoppingcart.util.Euro;
import org.javamoney.moneta.Money;
import org.quicktheories.core.Gen;

import static org.quicktheories.generators.SourceDSL.integers;

public class EuroGen {

    public static Gen<Money> euros() {
        return integers().between(1, 2000).map(Euro::euro);
    }
    
}
