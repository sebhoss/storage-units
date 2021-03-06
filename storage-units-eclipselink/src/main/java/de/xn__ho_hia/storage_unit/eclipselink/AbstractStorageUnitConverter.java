/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.eclipselink;

import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectCollectionMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

import de.xn__ho_hia.storage_unit.StorageUnit;

/**
 * Abstract implementation of a EclipseLink {@link Converter} for {@link StorageUnit StorageUnits}.
 *
 * @see <a href=
 *      "https://www.eclipse.org/eclipselink/documentation/2.6/jpa/extensions/annotations_ref.htm#CHDEHJEB">EclipseLink
 *      documentation</a>
 */
abstract class AbstractStorageUnitConverter implements Converter {

    private static final long serialVersionUID = 1696764872656233871L;

    @Override
    public Object convertObjectValueToDataValue(final Object objectValue, final Session session) {
        return ((StorageUnit<?>) objectValue).inByte();
    }

    @Override
    public Object convertDataValueToObjectValue(final Object dataValue, final Session session) {
        final BigInteger value = new BigInteger(dataValue.toString());
        return convertToStorageUnit(value);
    }

    protected abstract StorageUnit<?> convertToStorageUnit(@NonNull BigInteger value);

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(final DatabaseMapping mapping, final Session session) {
        final DatabaseField field;
        if (mapping instanceof DirectCollectionMapping) {
            field = ((DirectCollectionMapping) mapping).getDirectField();
        } else {
            field = mapping.getField();
        }
        field.setSqlType(java.sql.Types.BIGINT);
    }

}
