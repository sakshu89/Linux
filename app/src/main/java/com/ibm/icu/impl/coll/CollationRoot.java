package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.ICUBinary;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationRoot {
    private static final RuntimeException exception;
    private static final CollationTailoring rootSingleton;

    static {
        CollationTailoring collationTailoring = null;
        try {
            ByteBuffer requiredData = ICUBinary.getRequiredData("coll/ucadata.icu");
            CollationTailoring collationTailoring2 = new CollationTailoring(null);
            CollationDataReader.read(null, requiredData, collationTailoring2);
            e = null;
            collationTailoring = collationTailoring2;
        } catch (IOException unused) {
            e = new MissingResourceException("IOException while reading CLDR root data", "CollationRoot", "data/icudata/coll/ucadata.icu");
        } catch (RuntimeException e) {
            e = e;
        }
        rootSingleton = collationTailoring;
        exception = e;
    }

    public static final CollationData getData() {
        return getRoot().data;
    }

    public static final CollationTailoring getRoot() {
        RuntimeException runtimeException = exception;
        if (runtimeException == null) {
            return rootSingleton;
        }
        throw runtimeException;
    }

    public static final CollationSettings getSettings() {
        return (CollationSettings) getRoot().settings.readOnly();
    }
}
