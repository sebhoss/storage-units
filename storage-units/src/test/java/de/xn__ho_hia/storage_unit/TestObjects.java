/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Helps with the creation of objects that are used for testing.
 *
 * @see <a href="http://martinfowler.com/bliki/ObjectMother.html">Martin Fowler about ObjectMothers</a>
 */
@SuppressWarnings(CompilerWarnings.NULL)
public class TestObjects {

    /** Multiplier for decimal based units. */
    public static final long DECIMAL_MULTIPLIER = 1000L;

    /** Multiplier for binary based units. */
    public static final long BINARY_MULTIPLIER = 1024;

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce a binary-based
     *         {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> highLevelBinaryLongBasedConstructors() {
        final List<Function<Long, StorageUnit<?>>> units = new ArrayList<>();
        units.add(StorageUnits::bytes);
        units.add(StorageUnits::kibibyte);
        units.add(StorageUnits::mebibyte);
        units.add(StorageUnits::gibibyte);
        units.add(StorageUnits::pebibyte);
        units.add(StorageUnits::tebibyte);
        units.add(StorageUnits::exbibyte);
        units.add(StorageUnits::zebibyte);
        units.add(StorageUnits::yobibyte);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link BigInteger} and produce a binary-based
     *         {@link StorageUnit}.
     */
    public static List<Function<BigInteger, StorageUnit<?>>> highLevelBinaryBigIntegerBasedConstructors() {
        final List<Function<BigInteger, StorageUnit<?>>> units = new ArrayList<>();
        units.add(StorageUnits::bytes);
        units.add(StorageUnits::kibibyte);
        units.add(StorageUnits::mebibyte);
        units.add(StorageUnits::gibibyte);
        units.add(StorageUnits::pebibyte);
        units.add(StorageUnits::tebibyte);
        units.add(StorageUnits::exbibyte);
        units.add(StorageUnits::zebibyte);
        units.add(StorageUnits::yobibyte);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce a decimal {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> highLevelDecimalLongBasedConstructors() {
        final List<Function<Long, StorageUnit<?>>> units = new ArrayList<>();
        units.add(StorageUnits::bytes);
        units.add(StorageUnits::kilobyte);
        units.add(StorageUnits::megabyte);
        units.add(StorageUnits::gigabyte);
        units.add(StorageUnits::petabyte);
        units.add(StorageUnits::terabyte);
        units.add(StorageUnits::exabyte);
        units.add(StorageUnits::zettabyte);
        units.add(StorageUnits::yottabyte);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link BigInteger} and produce a decimal
     *         {@link StorageUnit}.
     */
    public static List<Function<BigInteger, StorageUnit<?>>> highLevelDecimalBigIntegerBasedConstructors() {
        final List<Function<BigInteger, StorageUnit<?>>> units = new ArrayList<>();
        units.add(StorageUnits::bytes);
        units.add(StorageUnits::kilobyte);
        units.add(StorageUnits::megabyte);
        units.add(StorageUnits::gigabyte);
        units.add(StorageUnits::petabyte);
        units.add(StorageUnits::terabyte);
        units.add(StorageUnits::exabyte);
        units.add(StorageUnits::zettabyte);
        units.add(StorageUnits::yottabyte);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce a common {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> highLevelCommonLongBasedConstructors() {
        final List<Function<Long, StorageUnit<?>>> units = new ArrayList<>();
        units.add(StorageUnits::bytes);
        units.add(StorageUnits::commonKilobyte);
        units.add(StorageUnits::commonMegabyte);
        units.add(StorageUnits::commonGigabyte);
        units.add(StorageUnits::commonPetabyte);
        units.add(StorageUnits::commonTerabyte);
        units.add(StorageUnits::commonExabyte);
        units.add(StorageUnits::commonZettabyte);
        units.add(StorageUnits::commonYottabyte);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link BigInteger} and produce a common
     *         {@link StorageUnit}.
     */
    public static List<Function<BigInteger, StorageUnit<?>>> highLevelCommonBigIntegerBasedConstructors() {
        final List<Function<BigInteger, StorageUnit<?>>> units = new ArrayList<>();
        units.add(StorageUnits::bytes);
        units.add(StorageUnits::commonKilobyte);
        units.add(StorageUnits::commonMegabyte);
        units.add(StorageUnits::commonGigabyte);
        units.add(StorageUnits::commonPetabyte);
        units.add(StorageUnits::commonTerabyte);
        units.add(StorageUnits::commonExabyte);
        units.add(StorageUnits::commonZettabyte);
        units.add(StorageUnits::commonYottabyte);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce any kind of {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> highLevelLongBasedConstructors() {
        final Stream<Function<Long, StorageUnit<?>>> first = Stream.concat(
                highLevelBinaryLongBasedConstructors().stream(), highLevelDecimalLongBasedConstructors().stream());
        return Stream
                .concat(
                        first,
                        highLevelCommonLongBasedConstructors().stream())
                .collect(Collectors.toList());
    }

    /**
     * @return A list of constructor functions that take in a {@link BigInteger} and produce any kind of
     *         {@link StorageUnit}.
     */
    public static List<Function<BigInteger, StorageUnit<?>>> highLevelBigIntegerBasedConstructors() {
        final Stream<Function<BigInteger, StorageUnit<?>>> first = Stream.concat(
                highLevelBinaryBigIntegerBasedConstructors().stream(),
                highLevelDecimalBigIntegerBasedConstructors().stream());
        return Stream
                .concat(
                        first,
                        highLevelCommonBigIntegerBasedConstructors().stream())
                .collect(Collectors.toList());
    }

    /**
     * @return A list of constructor functions that take in a {@link BigInteger} and produce a decimal
     *         {@link StorageUnit}.
     */
    public static List<Function<BigInteger, StorageUnit<?>>> bigIntegerBasedConstructors() {
        final List<Function<BigInteger, StorageUnit<?>>> units = new ArrayList<>();
        units.add(Byte::valueOf);
        units.add(Exabyte::valueOf);
        units.add(Exbibyte::valueOf);
        units.add(CommonExabyte::valueOf);
        units.add(Gibibyte::valueOf);
        units.add(Gigabyte::valueOf);
        units.add(CommonGigabyte::valueOf);
        units.add(Kibibyte::valueOf);
        units.add(Kilobyte::valueOf);
        units.add(CommonKilobyte::valueOf);
        units.add(Mebibyte::valueOf);
        units.add(Megabyte::valueOf);
        units.add(CommonMegabyte::valueOf);
        units.add(Pebibyte::valueOf);
        units.add(Petabyte::valueOf);
        units.add(CommonPetabyte::valueOf);
        units.add(Tebibyte::valueOf);
        units.add(Terabyte::valueOf);
        units.add(CommonTerabyte::valueOf);
        units.add(Yobibyte::valueOf);
        units.add(Yottabyte::valueOf);
        units.add(CommonYottabyte::valueOf);
        units.add(Zebibyte::valueOf);
        units.add(Zettabyte::valueOf);
        units.add(CommonZettabyte::valueOf);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce a decimal {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> longBasedConstructors() {
        final List<Function<Long, StorageUnit<?>>> units = new ArrayList<>();
        units.add(Byte::valueOf);
        units.add(Exabyte::valueOf);
        units.add(Exbibyte::valueOf);
        units.add(CommonExabyte::valueOf);
        units.add(Gibibyte::valueOf);
        units.add(Gigabyte::valueOf);
        units.add(CommonGigabyte::valueOf);
        units.add(Kibibyte::valueOf);
        units.add(Kilobyte::valueOf);
        units.add(CommonKilobyte::valueOf);
        units.add(Mebibyte::valueOf);
        units.add(Megabyte::valueOf);
        units.add(CommonMegabyte::valueOf);
        units.add(Pebibyte::valueOf);
        units.add(Petabyte::valueOf);
        units.add(CommonPetabyte::valueOf);
        units.add(Tebibyte::valueOf);
        units.add(Terabyte::valueOf);
        units.add(CommonTerabyte::valueOf);
        units.add(Yobibyte::valueOf);
        units.add(Yottabyte::valueOf);
        units.add(CommonYottabyte::valueOf);
        units.add(Zebibyte::valueOf);
        units.add(Zettabyte::valueOf);
        units.add(CommonZettabyte::valueOf);
        return units;
    }

    private TestObjects() {
        // factory/helper class
    }

}
