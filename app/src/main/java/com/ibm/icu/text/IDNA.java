package com.ibm.icu.text;

import com.ibm.icu.impl.IDNA2003;
import com.ibm.icu.impl.UTS46;
import defpackage.og;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class IDNA {

    @Deprecated
    public static final int ALLOW_UNASSIGNED = 1;
    public static final int CHECK_BIDI = 4;
    public static final int CHECK_CONTEXTJ = 8;
    public static final int CHECK_CONTEXTO = 64;
    public static final int DEFAULT = 48;
    public static final int NONTRANSITIONAL_TO_ASCII = 16;
    public static final int NONTRANSITIONAL_TO_UNICODE = 32;
    public static final int USE_STD3_RULES = 2;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Error {
        EMPTY_LABEL,
        LABEL_TOO_LONG,
        DOMAIN_NAME_TOO_LONG,
        LEADING_HYPHEN,
        TRAILING_HYPHEN,
        HYPHEN_3_4,
        LEADING_COMBINING_MARK,
        DISALLOWED,
        PUNYCODE,
        LABEL_HAS_DOT,
        INVALID_ACE_LABEL,
        BIDI,
        CONTEXTJ,
        CONTEXTO_PUNCTUATION,
        CONTEXTO_DIGITS
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Info {
        private EnumSet<Error> errors = EnumSet.noneOf(Error.class);
        private EnumSet<Error> labelErrors = EnumSet.noneOf(Error.class);
        private boolean isTransDiff = false;
        private boolean isBiDi = false;
        private boolean isOkBiDi = true;

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.errors.clear();
            this.labelErrors.clear();
            this.isTransDiff = false;
            this.isBiDi = false;
            this.isOkBiDi = true;
        }

        public Set<Error> getErrors() {
            return this.errors;
        }

        public boolean hasErrors() {
            return !this.errors.isEmpty();
        }

        public boolean isTransitionalDifferent() {
            return this.isTransDiff;
        }
    }

    @Deprecated
    public IDNA() {
    }

    @Deprecated
    public static void addError(Info info, Error error) {
        info.errors.add(error);
    }

    @Deprecated
    public static void addLabelError(Info info, Error error) {
        info.labelErrors.add(error);
    }

    @Deprecated
    public static int compare(StringBuffer stringBuffer, StringBuffer stringBuffer2, int i) {
        if (stringBuffer != null && stringBuffer2 != null) {
            return IDNA2003.compare(stringBuffer.toString(), stringBuffer2.toString(), i);
        }
        og.i("One of the source buffers is null");
        return 0;
    }

    @Deprecated
    public static StringBuffer convertIDNToASCII(UCharacterIterator uCharacterIterator, int i) {
        return convertIDNToASCII(uCharacterIterator.getText(), i);
    }

    @Deprecated
    public static StringBuffer convertIDNToUnicode(UCharacterIterator uCharacterIterator, int i) {
        return convertIDNToUnicode(uCharacterIterator.getText(), i);
    }

    @Deprecated
    public static StringBuffer convertToASCII(String str, int i) {
        return convertToASCII(UCharacterIterator.getInstance(str), i);
    }

    @Deprecated
    public static StringBuffer convertToUnicode(String str, int i) {
        return convertToUnicode(UCharacterIterator.getInstance(str), i);
    }

    public static IDNA getUTS46Instance(int i) {
        return new UTS46(i);
    }

    @Deprecated
    public static boolean hasCertainErrors(Info info, EnumSet<Error> enumSet) {
        return (info.errors.isEmpty() || Collections.disjoint(info.errors, enumSet)) ? false : true;
    }

    @Deprecated
    public static boolean hasCertainLabelErrors(Info info, EnumSet<Error> enumSet) {
        return (info.labelErrors.isEmpty() || Collections.disjoint(info.labelErrors, enumSet)) ? false : true;
    }

    @Deprecated
    public static boolean isBiDi(Info info) {
        return info.isBiDi;
    }

    @Deprecated
    public static boolean isOkBiDi(Info info) {
        return info.isOkBiDi;
    }

    @Deprecated
    public static void promoteAndResetLabelErrors(Info info) {
        if (info.labelErrors.isEmpty()) {
            return;
        }
        info.errors.addAll(info.labelErrors);
        info.labelErrors.clear();
    }

    @Deprecated
    public static void resetInfo(Info info) {
        info.reset();
    }

    @Deprecated
    public static void setBiDi(Info info) {
        info.isBiDi = true;
    }

    @Deprecated
    public static void setNotOkBiDi(Info info) {
        info.isOkBiDi = false;
    }

    @Deprecated
    public static void setTransitionalDifferent(Info info) {
        info.isTransDiff = true;
    }

    public abstract StringBuilder labelToASCII(CharSequence charSequence, StringBuilder sb, Info info);

    public abstract StringBuilder labelToUnicode(CharSequence charSequence, StringBuilder sb, Info info);

    public abstract StringBuilder nameToASCII(CharSequence charSequence, StringBuilder sb, Info info);

    public abstract StringBuilder nameToUnicode(CharSequence charSequence, StringBuilder sb, Info info);

    @Deprecated
    public static StringBuffer convertIDNToASCII(StringBuffer stringBuffer, int i) {
        return convertIDNToASCII(stringBuffer.toString(), i);
    }

    @Deprecated
    public static StringBuffer convertIDNToUnicode(StringBuffer stringBuffer, int i) {
        return convertIDNToUnicode(stringBuffer.toString(), i);
    }

    @Deprecated
    public static StringBuffer convertToASCII(StringBuffer stringBuffer, int i) {
        return convertToASCII(UCharacterIterator.getInstance(stringBuffer), i);
    }

    @Deprecated
    public static StringBuffer convertToUnicode(StringBuffer stringBuffer, int i) {
        return convertToUnicode(UCharacterIterator.getInstance(stringBuffer), i);
    }

    @Deprecated
    public static StringBuffer convertIDNToASCII(String str, int i) {
        return IDNA2003.convertIDNToASCII(str, i);
    }

    @Deprecated
    public static StringBuffer convertIDNToUnicode(String str, int i) {
        return IDNA2003.convertIDNToUnicode(str, i);
    }

    @Deprecated
    public static StringBuffer convertToASCII(UCharacterIterator uCharacterIterator, int i) {
        return IDNA2003.convertToASCII(uCharacterIterator, i);
    }

    @Deprecated
    public static StringBuffer convertToUnicode(UCharacterIterator uCharacterIterator, int i) {
        return IDNA2003.convertToUnicode(uCharacterIterator, i);
    }

    @Deprecated
    public static int compare(String str, String str2, int i) {
        if (str != null && str2 != null) {
            return IDNA2003.compare(str, str2, i);
        }
        og.i("One of the source buffers is null");
        return 0;
    }

    @Deprecated
    public static int compare(UCharacterIterator uCharacterIterator, UCharacterIterator uCharacterIterator2, int i) {
        if (uCharacterIterator != null && uCharacterIterator2 != null) {
            return IDNA2003.compare(uCharacterIterator.getText(), uCharacterIterator2.getText(), i);
        }
        og.i("One of the source buffers is null");
        return 0;
    }
}
