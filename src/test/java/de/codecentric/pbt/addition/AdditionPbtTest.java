package de.codecentric.pbt.addition;

import org.junit.jupiter.api.Test;

import static de.codecentric.pbt.addition.Addition.add;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;

class AdditionPbtTest {

    // Commutative property:
    // When two numbers are added, the sum is the same regardless of the order of the addends. For example 4 + 2 = 2 + 4
    @Test
    void addingTwoIntegersIsCommutative() {
        qt().withExamples(10)
                .forAll(integers().all(), integers().all())
                .check((i, j) ->
                        add(i, j) == add(j, i)
                );
    }

    // Associative Property:
    // When three or more numbers are added, the sum is the same regardless of the grouping of the addends. For example (2 + 3) + 4 = 2 + (3 + 4)
    @Test
    void addingMultiplePositiveIntegersIsAssociative() {
        qt().forAll(integers().all(), integers().all(), integers().all())
                .check((i, j, k) ->
                        add(add(i, j), k) == add(i, add(j, k))
                );
    }

    // Additive Identity Property:
    // The sum of any number and zero is the original number. For example 5 + 0 = 5.
    @Test
    void addingAnyNumberAndZeroIsTheOriginalNumber() {
        qt().forAll(integers().all())
                .check(i ->
                        add(i, 0) == i
                );
    }

    // Distributive property:
    // The sum of two numbers times a third number is equal to the sum of each addend times the third number. For example 4 * (6 + 3) = 4*6 + 4*3
    @Test
    void sumOfTwoNumbersTimesAThird() {
        qt().forAll(integers().all(), integers().all(), integers().all())
                .check((i, j, k) ->
                        i * add(j, k) == add(i * j, i * k)
                );
    }

}
