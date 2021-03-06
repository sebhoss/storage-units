/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import static de.xn__ho_hia.storage_unit.TestUtils.logIncorrectCreation;
import static de.xn__ho_hia.storage_unit.TestUtils.pow;

import java.util.ArrayList;
import java.util.List;

import org.jooq.lambda.tuple.Tuple2;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Test cases for the {@link StorageUnits} class that check the behavior of
 * small binary based units.
 */
@RunWith(Theories.class)
public class StorageUnitsSmallBinaryTest {

    private static final Long MULTIPLIER = Long.valueOf(1024);

    /**
     * @return inputs and expected result types.
     */
    @DataPoints("inputs")
    public static List<Tuple2<Long, Class<? extends StorageUnit<?>>>> inputs() {
        final List<Tuple2<Long, Class<? extends StorageUnit<?>>>> inputs = new ArrayList<>();

        inputs.add(new Tuple2<>(Long.valueOf(1L), Byte.class));
        inputs.add(new Tuple2<>(MULTIPLIER, Kibibyte.class));
        inputs.add(new Tuple2<>(pow(MULTIPLIER, 2), Mebibyte.class));
        inputs.add(new Tuple2<>(pow(MULTIPLIER, 3), Gibibyte.class));
        inputs.add(new Tuple2<>(pow(MULTIPLIER, 4), Tebibyte.class));
        inputs.add(new Tuple2<>(pow(MULTIPLIER, 5), Pebibyte.class));
        inputs.add(new Tuple2<>(pow(MULTIPLIER, 6), Exbibyte.class));

        return inputs;
    }

    /**
     * @param input
     *            The number of bytes to wrap + the expected return class.
     */
    @Theory
    @SuppressWarnings({ CompilerWarnings.STATIC_METHOD })
    public void shouldCreateCorrectUnit(
            @FromDataPoints("inputs") final Tuple2<Long, Class<? extends StorageUnit<?>>> input) {
        // Given
        final long bytes = input.v1.longValue();
        final Class<? extends StorageUnit<?>> expectedClass = input.v2;

        // When
        final StorageUnit<?> unit = StorageUnits.binaryValueOf(bytes);
        final Class<?> unitClass = unit.getClass();

        // Then
        Assert.assertEquals(logIncorrectCreation(bytes, expectedClass, unitClass), expectedClass, unitClass);
    }

}
