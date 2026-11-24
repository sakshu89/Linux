package com.ibm.icu.impl.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.StandardPlural;
import java.text.Format;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface Modifier {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Parameters {
        public ModifierStore obj;
        public StandardPlural plural;
        public Signum signum;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Signum {
        NEG,
        NEG_ZERO,
        POS_ZERO,
        POS;

        static final int COUNT = values().length;
        public static final Signum[] VALUES = values();
    }

    int apply(FormattedStringBuilder formattedStringBuilder, int i, int i2);

    boolean containsField(Format.Field field);

    int getCodePointCount();

    Parameters getParameters();

    int getPrefixLength();

    boolean isStrong();

    default boolean semanticallyEquivalent(Modifier modifier) {
        Parameters parameters = getParameters();
        Parameters parameters2 = modifier.getParameters();
        if (parameters == null && parameters2 == null) {
            return strictEquals(modifier);
        }
        if (parameters != null && parameters2 != null) {
            ModifierStore modifierStore = parameters.obj;
            if (modifierStore == null && parameters2.obj == null) {
                return strictEquals(modifier);
            }
            if (modifierStore != null && parameters2.obj != null) {
                for (Signum signum : Signum.VALUES) {
                    for (StandardPlural standardPlural : StandardPlural.VALUES) {
                        Modifier modifier2 = parameters.obj.getModifier(signum, standardPlural);
                        Modifier modifier3 = parameters2.obj.getModifier(signum, standardPlural);
                        if (modifier2 != modifier3 && (modifier2 == null || modifier3 == null || !modifier2.strictEquals(modifier3))) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    boolean strictEquals(Modifier modifier);
}
