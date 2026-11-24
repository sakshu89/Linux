package com.ibm.icu.text;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.Norm2AllModes;
import defpackage.kf2;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class Normalizer2 {

    /* JADX INFO: renamed from: com.ibm.icu.text.Normalizer2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$Normalizer2$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$ibm$icu$text$Normalizer2$Mode = iArr;
            try {
                iArr[Mode.COMPOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$Normalizer2$Mode[Mode.DECOMPOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$Normalizer2$Mode[Mode.FCD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$Normalizer2$Mode[Mode.COMPOSE_CONTIGUOUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Mode {
        COMPOSE,
        DECOMPOSE,
        FCD,
        COMPOSE_CONTIGUOUS
    }

    @Deprecated
    public Normalizer2() {
    }

    public static Normalizer2 getInstance(InputStream inputStream, String str, Mode mode) {
        ByteBuffer byteBufferFromInputStreamAndCloseStream;
        if (inputStream != null) {
            try {
                byteBufferFromInputStreamAndCloseStream = ICUBinary.getByteBufferFromInputStreamAndCloseStream(inputStream);
            } catch (IOException e) {
                kf2.h(e);
                return null;
            }
        } else {
            byteBufferFromInputStreamAndCloseStream = null;
        }
        Norm2AllModes norm2AllModes = Norm2AllModes.getInstance(byteBufferFromInputStreamAndCloseStream, str);
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$text$Normalizer2$Mode[mode.ordinal()];
        if (i == 1) {
            return norm2AllModes.comp;
        }
        if (i == 2) {
            return norm2AllModes.decomp;
        }
        if (i == 3) {
            return norm2AllModes.fcd;
        }
        if (i != 4) {
            return null;
        }
        return norm2AllModes.fcc;
    }

    public static Normalizer2 getNFCInstance() {
        return Norm2AllModes.getNFCInstance().comp;
    }

    public static Normalizer2 getNFDInstance() {
        return Norm2AllModes.getNFCInstance().decomp;
    }

    public static Normalizer2 getNFKCCasefoldInstance() {
        return Norm2AllModes.getNFKC_CFInstance().comp;
    }

    public static Normalizer2 getNFKCInstance() {
        return Norm2AllModes.getNFKCInstance().comp;
    }

    public static Normalizer2 getNFKCSimpleCasefoldInstance() {
        return Norm2AllModes.getNFKC_SCFInstance().comp;
    }

    public static Normalizer2 getNFKDInstance() {
        return Norm2AllModes.getNFKCInstance().decomp;
    }

    public abstract StringBuilder append(StringBuilder sb, CharSequence charSequence);

    public int composePair(int i, int i2) {
        return -1;
    }

    public int getCombiningClass(int i) {
        return 0;
    }

    public abstract String getDecomposition(int i);

    public String getRawDecomposition(int i) {
        return null;
    }

    public abstract boolean hasBoundaryAfter(int i);

    public abstract boolean hasBoundaryBefore(int i);

    public abstract boolean isInert(int i);

    public abstract boolean isNormalized(CharSequence charSequence);

    public abstract Appendable normalize(CharSequence charSequence, Appendable appendable);

    public String normalize(CharSequence charSequence) {
        if (charSequence instanceof String) {
            int iSpanQuickCheckYes = spanQuickCheckYes(charSequence);
            String str = (String) charSequence;
            if (iSpanQuickCheckYes == str.length()) {
                return str;
            }
            if (iSpanQuickCheckYes != 0) {
                StringBuilder sb = new StringBuilder(str.length());
                sb.append(charSequence, 0, iSpanQuickCheckYes);
                return normalizeSecondAndAppend(sb, str.subSequence(iSpanQuickCheckYes, str.length())).toString();
            }
        }
        return normalize(charSequence, new StringBuilder(charSequence.length())).toString();
    }

    public abstract StringBuilder normalize(CharSequence charSequence, StringBuilder sb);

    public abstract StringBuilder normalizeSecondAndAppend(StringBuilder sb, CharSequence charSequence);

    public abstract Normalizer.QuickCheckResult quickCheck(CharSequence charSequence);

    public abstract int spanQuickCheckYes(CharSequence charSequence);
}
