package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.Edits;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.util.ULocale;
import defpackage.kf2;
import defpackage.og;
import java.io.IOException;
import java.text.CharacterIterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CaseMapImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char ACUTE = 769;
    private static final Trie2_16 CASE_TRIE = UCaseProps.getTrie();
    private static final int LNS = 251792942;
    public static final int OMIT_UNCHANGED_TEXT = 16384;
    private static final int TITLECASE_ADJUSTMENT_MASK = 1536;
    public static final int TITLECASE_ADJUST_TO_CASED = 1024;
    private static final int TITLECASE_ITERATOR_MASK = 224;
    public static final int TITLECASE_SENTENCES = 64;
    public static final int TITLECASE_WHOLE_STRING = 32;
    private static final int U_GC_M_MASK = 448;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class GreekUpper {
        private static final int AFTER_CASED = 1;
        private static final int AFTER_VOWEL_WITH_COMBINING_ACCENT = 2;
        private static final int AFTER_VOWEL_WITH_PRECOMPOSED_ACCENT = 4;
        private static final int HAS_ACCENT = 16384;
        private static final int HAS_COMBINING_DIALYTIKA = 65536;
        private static final int HAS_DIALYTIKA = 32768;
        private static final int HAS_EITHER_DIALYTIKA = 98304;
        private static final int HAS_OTHER_GREEK_DIACRITIC = 131072;
        private static final int HAS_VOWEL = 4096;
        private static final int HAS_VOWEL_AND_ACCENT = 20480;
        private static final int HAS_VOWEL_AND_ACCENT_AND_DIALYTIKA = 53248;
        private static final int HAS_YPOGEGRAMMENI = 8192;
        private static final int UPPER_MASK = 1023;
        private static final char data2126 = 5033;
        private static final char[] data0370 = {880, 880, 882, 882, 0, 0, 886, 886, 0, 0, 890, 1021, 1022, 1023, 0, 895, 0, 0, 0, 0, 0, 0, 21393, 0, 21397, 21399, 21401, 0, 21407, 0, 21413, 21417, 54169, 5009, 914, 915, 916, 5013, 918, 5015, 920, 5017, 922, 923, 924, 925, 926, 5023, 928, 929, 0, 931, 932, 5029, 934, 935, 936, data2126, 37785, 37797, 21393, 21397, 21399, 21401, 54181, 5009, 914, 915, 916, 5013, 918, 5015, 920, 5017, 922, 923, 924, 925, 926, 5023, 928, 929, 931, 931, 932, 5029, 934, 935, 936, data2126, 37785, 37797, 21407, 21413, 21417, 975, 914, 920, 978, 17362, 33746, 934, 928, 975, 984, 984, 986, 986, 988, 988, 990, 990, 992, 992, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 922, 929, 1017, 895, 1012, 5013, 0, 1015, 1015, 1017, 1018, 1018, 1020, 1021, 1022, 1023};
        private static final char[] data1F00 = {5009, 5009, 21393, 21393, 21393, 21393, 21393, 21393, 5009, 5009, 21393, 21393, 21393, 21393, 21393, 21393, 5013, 5013, 21397, 21397, 21397, 21397, 0, 0, 5013, 5013, 21397, 21397, 21397, 21397, 0, 0, 5015, 5015, 21399, 21399, 21399, 21399, 21399, 21399, 5015, 5015, 21399, 21399, 21399, 21399, 21399, 21399, 5017, 5017, 21401, 21401, 21401, 21401, 21401, 21401, 5017, 5017, 21401, 21401, 21401, 21401, 21401, 21401, 5023, 5023, 21407, 21407, 21407, 21407, 0, 0, 5023, 5023, 21407, 21407, 21407, 21407, 0, 0, 5029, 5029, 21413, 21413, 21413, 21413, 21413, 21413, 0, 5029, 0, 21413, 0, 21413, 0, 21413, data2126, data2126, 21417, 21417, 21417, 21417, 21417, 21417, data2126, data2126, 21417, 21417, 21417, 21417, 21417, 21417, 21393, 21393, 21397, 21397, 21399, 21399, 21401, 21401, 21407, 21407, 21413, 21413, 21417, 21417, 0, 0, 13201, 13201, 29585, 29585, 29585, 29585, 29585, 29585, 13201, 13201, 29585, 29585, 29585, 29585, 29585, 29585, 13207, 13207, 29591, 29591, 29591, 29591, 29591, 29591, 13207, 13207, 29591, 29591, 29591, 29591, 29591, 29591, 13225, 13225, 29609, 29609, 29609, 29609, 29609, 29609, 13225, 13225, 29609, 29609, 29609, 29609, 29609, 29609, 5009, 5009, 29585, 13201, 29585, 0, 21393, 29585, 5009, 5009, 21393, 21393, 13201, 0, 5017, 0, 0, 0, 29591, 13207, 29591, 0, 21399, 29591, 21397, 21397, 21399, 21399, 13207, 0, 0, 0, 5017, 5017, 54169, 54169, 0, 0, 21401, 54169, 5017, 5017, 21401, 21401, 0, 0, 0, 0, 5029, 5029, 54181, 54181, 929, 929, 21413, 54181, 5029, 5029, 21413, 21413, 929, 0, 0, 0, 0, 0, 29609, 13225, 29609, 0, 21417, 29609, 21407, 21407, 21417, 21417, 13225, 0, 0, 0};

        private GreekUpper() {
        }

        private static final int getDiacriticData(int i) {
            if (i == 774) {
                return 131072;
            }
            if (i == 776) {
                return 65536;
            }
            if (i == 785) {
                return 16384;
            }
            if (i == 787 || i == 788) {
                return 131072;
            }
            switch (i) {
                case 768:
                case 769:
                case 770:
                case 771:
                    return 16384;
                case 772:
                    return 131072;
                default:
                    switch (i) {
                        case 834:
                            return 16384;
                        case 835:
                            return 131072;
                        case 836:
                            return 81920;
                        case 837:
                            return 8192;
                        default:
                            return 0;
                    }
            }
        }

        private static final int getLetterData(int i) {
            if (i >= 880 && 8486 >= i && (1023 >= i || i >= 7936)) {
                if (i <= 1023) {
                    return data0370[i - 880];
                }
                if (i <= 8191) {
                    return data1F00[i - 7936];
                }
                if (i == 8486) {
                    return 5033;
                }
            }
            return 0;
        }

        private static boolean isFollowedByCasedLetter(CharSequence charSequence, int i) {
            while (i < charSequence.length()) {
                int iCodePointAt = Character.codePointAt(charSequence, i);
                int typeOrIgnorable = UCaseProps.INSTANCE.getTypeOrIgnorable(iCodePointAt);
                if ((typeOrIgnorable & 4) != 0) {
                    i += Character.charCount(iCodePointAt);
                } else if (typeOrIgnorable != 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:101:0x0107 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:102:0x0109  */
        /* JADX WARN: Code duplicated, block: B:104:0x010f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:105:0x0111  */
        /* JADX WARN: Code duplicated, block: B:108:0x0118  */
        /* JADX WARN: Code duplicated, block: B:109:0x011b  */
        /* JADX WARN: Code duplicated, block: B:111:0x011f  */
        /* JADX WARN: Code duplicated, block: B:113:0x0127  */
        /* JADX WARN: Code duplicated, block: B:115:0x012c  */
        /* JADX WARN: Code duplicated, block: B:117:0x0131 A[LOOP:2: B:116:0x012f->B:117:0x0131, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:122:0x0139 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:74:0x00cc A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:80:0x00db  */
        /* JADX WARN: Code duplicated, block: B:81:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:85:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:88:0x00ec  */
        /* JADX WARN: Code duplicated, block: B:89:0x00ee  */
        /* JADX WARN: Code duplicated, block: B:93:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:97:0x0101  */
        /* JADX WARN: Code duplicated, block: B:98:0x0103  */
        public static <A extends Appendable> A toUpper(int i, CharSequence charSequence, A a, Edits edits) throws IOException {
            int i2;
            boolean z;
            boolean z2;
            int i3;
            int i4;
            int i5;
            int i6;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            int diacriticData;
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequence.length()) {
                int iCodePointAt = Character.codePointAt(charSequence, i7);
                int iCharCount = Character.charCount(iCodePointAt) + i7;
                UCaseProps uCaseProps = UCaseProps.INSTANCE;
                int typeOrIgnorable = uCaseProps.getTypeOrIgnorable(iCodePointAt);
                if ((typeOrIgnorable & 4) != 0) {
                    i2 = i8 & 1;
                } else {
                    i2 = typeOrIgnorable != 0 ? 1 : 0;
                }
                int letterData = getLetterData(iCodePointAt);
                if (letterData > 0) {
                    int i9 = letterData & 1023;
                    if ((letterData & 4096) != 0 && (i8 & 6) != 0 && (i9 == 921 || i9 == 933)) {
                        letterData |= (i8 & 4) != 0 ? 32768 : 65536;
                    }
                    int i10 = (letterData & 8192) != 0 ? 1 : 0;
                    boolean z8 = (letterData & 16384) != 0;
                    while (iCharCount < charSequence.length() && (diacriticData = getDiacriticData(charSequence.charAt(iCharCount))) != 0) {
                        letterData |= diacriticData;
                        if ((diacriticData & 8192) != 0) {
                            i10++;
                        }
                        iCharCount++;
                    }
                    if ((HAS_VOWEL_AND_ACCENT_AND_DIALYTIKA & letterData) == HAS_VOWEL_AND_ACCENT) {
                        i2 |= z8 ? 4 : 2;
                    }
                    if (i9 == 919 && (letterData & 16384) != 0 && i10 == 0 && (i8 & 1) == 0 && !isFollowedByCasedLetter(charSequence, iCharCount)) {
                        if (z8) {
                            i9 = 905;
                        } else {
                            z = true;
                        }
                        if (edits == null || (i & 16384) != 0) {
                            if (charSequence.charAt(i7) == i9 || i10 > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            i3 = HAS_EITHER_DIALYTIKA;
                            i4 = i7 + 1;
                            if ((letterData & HAS_EITHER_DIALYTIKA) != 0) {
                                if (i4 < iCharCount || charSequence.charAt(i4) != 776) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                z2 |= z7;
                                i4 = i7 + 2;
                            }
                            if (z) {
                                if (i4 < iCharCount || charSequence.charAt(i4) != 769) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                z2 |= z6;
                                i4++;
                            }
                            i5 = iCharCount - i7;
                            i6 = (i4 - i7) + i10;
                            if (i5 != i6) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            z4 = z3 | z2;
                            if (z4) {
                                if (edits != null) {
                                    edits.addReplace(i5, i6);
                                }
                                z5 = z4;
                            } else {
                                if (edits != null) {
                                    edits.addUnchanged(i5);
                                }
                                if ((i & 16384) == 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                            }
                        } else {
                            z5 = true;
                            i3 = HAS_EITHER_DIALYTIKA;
                        }
                        if (z5) {
                            a.append((char) i9);
                            if ((letterData & i3) != 0) {
                                a.append((char) 776);
                            }
                            if (z) {
                                a.append(CaseMapImpl.ACUTE);
                            }
                            while (i10 > 0) {
                                a.append((char) 921);
                                i10--;
                            }
                        }
                    } else if ((letterData & 32768) != 0) {
                        if (i9 == 921) {
                            letterData &= -98305;
                            i9 = 938;
                        } else if (i9 == 933) {
                            letterData &= -98305;
                            i9 = 939;
                        }
                    }
                    z = false;
                    if (edits == null) {
                        if (charSequence.charAt(i7) == i9) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        i3 = HAS_EITHER_DIALYTIKA;
                        i4 = i7 + 1;
                        if ((letterData & HAS_EITHER_DIALYTIKA) != 0) {
                            if (i4 < iCharCount) {
                                z7 = true;
                            } else {
                                z7 = true;
                            }
                            z2 |= z7;
                            i4 = i7 + 2;
                        }
                        if (z) {
                            if (i4 < iCharCount) {
                                z6 = true;
                            } else {
                                z6 = true;
                            }
                            z2 |= z6;
                            i4++;
                        }
                        i5 = iCharCount - i7;
                        i6 = (i4 - i7) + i10;
                        if (i5 != i6) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z4 = z3 | z2;
                        if (z4) {
                            if (edits != null) {
                                edits.addReplace(i5, i6);
                            }
                            z5 = z4;
                        } else {
                            if (edits != null) {
                                edits.addUnchanged(i5);
                            }
                            if ((i & 16384) == 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        }
                    } else {
                        if (charSequence.charAt(i7) == i9) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        i3 = HAS_EITHER_DIALYTIKA;
                        i4 = i7 + 1;
                        if ((letterData & HAS_EITHER_DIALYTIKA) != 0) {
                            if (i4 < iCharCount) {
                                z7 = true;
                            } else {
                                z7 = true;
                            }
                            z2 |= z7;
                            i4 = i7 + 2;
                        }
                        if (z) {
                            if (i4 < iCharCount) {
                                z6 = true;
                            } else {
                                z6 = true;
                            }
                            z2 |= z6;
                            i4++;
                        }
                        i5 = iCharCount - i7;
                        i6 = (i4 - i7) + i10;
                        if (i5 != i6) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z4 = z3 | z2;
                        if (z4) {
                            if (edits != null) {
                                edits.addReplace(i5, i6);
                            }
                            z5 = z4;
                        } else {
                            if (edits != null) {
                                edits.addUnchanged(i5);
                            }
                            if ((i & 16384) == 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        }
                    }
                    if (z5) {
                        a.append((char) i9);
                        if ((letterData & i3) != 0) {
                            a.append((char) 776);
                        }
                        if (z) {
                            a.append(CaseMapImpl.ACUTE);
                        }
                        while (i10 > 0) {
                            a.append((char) 921);
                            i10--;
                        }
                    }
                } else {
                    CaseMapImpl.appendResult(uCaseProps.toFullUpper(iCodePointAt, null, a, 4), a, iCharCount - i7, i, edits);
                }
                i7 = iCharCount;
                i8 = i2;
            }
            return a;
        }
    }

    public static int addTitleAdjustmentOption(int i, int i2) {
        int i3 = i & TITLECASE_ADJUSTMENT_MASK;
        if (i3 == 0 || i3 == i2) {
            return i | i2;
        }
        og.i("multiple titlecasing index adjustment options");
        return 0;
    }

    public static int addTitleIteratorOption(int i, int i2) {
        int i3 = i & 224;
        if (i3 == 0 || i3 == i2) {
            return i | i2;
        }
        og.i("multiple titlecasing iterator options");
        return 0;
    }

    private static int appendCodePoint(Appendable appendable, int i) throws IOException {
        if (i <= 65535) {
            appendable.append((char) i);
            return 1;
        }
        appendable.append((char) ((i >> 10) + 55232));
        appendable.append((char) ((i & UCharacterProperty.MAX_SCRIPT) + UTF16.TRAIL_SURROGATE_MIN_VALUE));
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendResult(int i, Appendable appendable, int i2, int i3, Edits edits) throws IOException {
        if (i < 0) {
            if (edits != null) {
                edits.addUnchanged(i2);
            }
            if ((i3 & 16384) != 0) {
                return;
            }
            appendCodePoint(appendable, ~i);
            return;
        }
        if (i <= 31) {
            if (edits != null) {
                edits.addReplace(i2, i);
            }
        } else {
            int iAppendCodePoint = appendCodePoint(appendable, i);
            if (edits != null) {
                edits.addReplace(i2, iAppendCodePoint);
            }
        }
    }

    private static final void appendUnchanged(CharSequence charSequence, int i, int i2, Appendable appendable, int i3, Edits edits) throws IOException {
        if (i2 > 0) {
            if (edits != null) {
                edits.addUnchanged(i2);
            }
            if ((i3 & 16384) != 0) {
                return;
            }
            appendable.append(charSequence, i, i2 + i);
        }
    }

    private static String applyEdits(CharSequence charSequence, StringBuilder sb, Edits edits) {
        if (!edits.hasChanges()) {
            return charSequence.toString();
        }
        StringBuilder sb2 = new StringBuilder(edits.lengthDelta() + charSequence.length());
        Edits.Iterator coarseIterator = edits.getCoarseIterator();
        while (coarseIterator.next()) {
            if (coarseIterator.hasChange()) {
                int iReplacementIndex = coarseIterator.replacementIndex();
                sb2.append((CharSequence) sb, iReplacementIndex, coarseIterator.newLength() + iReplacementIndex);
            } else {
                int iSourceIndex = coarseIterator.sourceIndex();
                sb2.append(charSequence, iSourceIndex, coarseIterator.oldLength() + iSourceIndex);
            }
        }
        return sb2.toString();
    }

    public static String fold(int i, CharSequence charSequence) {
        if (charSequence.length() > 100 || (i & 16384) != 0) {
            return ((StringBuilder) fold(i, charSequence, new StringBuilder(charSequence.length()), null)).toString();
        }
        if (charSequence.length() == 0) {
            return charSequence.toString();
        }
        Edits edits = new Edits();
        return applyEdits(charSequence, (StringBuilder) fold(i | 16384, charSequence, new StringBuilder(), edits), edits);
    }

    public static BreakIterator getTitleBreakIterator(Locale locale, int i, BreakIterator breakIterator) {
        int i2 = i & 224;
        if (i2 != 0 && breakIterator != null) {
            og.i("titlecasing iterator option together with an explicit iterator");
            return null;
        }
        if (breakIterator != null) {
            return breakIterator;
        }
        if (i2 == 0) {
            return BreakIterator.getWordInstance(locale);
        }
        if (i2 == 32) {
            return new WholeStringBreakIterator(0);
        }
        if (i2 == 64) {
            return BreakIterator.getSentenceInstance(locale);
        }
        og.i("unknown titlecasing iterator option");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0051  */
    /* JADX WARN: Code duplicated, block: B:34:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a5 A[PHI: r10 r11
      0x00a5: PHI (r10v11 int) = (r10v6 int), (r10v13 int) binds: [B:52:0x00a2, B:25:0x0038] A[DONT_GENERATE, DONT_INLINE]
      0x00a5: PHI (r11v6 int) = (r11v2 int), (r11v7 int) binds: [B:52:0x00a2, B:25:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b3  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static void internalToLower(int i, int i2, CharSequence charSequence, int i3, int i4, StringContextIterator stringContextIterator, Appendable appendable, Edits edits) throws IOException {
        int delta;
        int i5;
        boolean zIsHighSurrogate;
        int codePoint;
        int fullFolding;
        char cCharAt;
        byte[] bArr = (i == 1 || (i < 0 ? (i2 & 7) == 0 : !(i == 2 || i == 3))) ? UCaseProps.LatinCase.TO_LOWER_NORMAL : UCaseProps.LatinCase.TO_LOWER_TR_LT;
        int i6 = i3;
        while (i3 < i4) {
            int i7 = i2;
            CharSequence charSequence2 = charSequence;
            Appendable appendable2 = appendable;
            Edits edits2 = edits;
            char cCharAt2 = charSequence2.charAt(i3);
            if (cCharAt2 < 383) {
                delta = bArr[cCharAt2];
                if (delta == -128) {
                    i5 = i3 + 1;
                    zIsHighSurrogate = Character.isHighSurrogate(cCharAt2);
                    codePoint = cCharAt2;
                    codePoint = cCharAt2;
                    if (zIsHighSurrogate && i5 < i4) {
                        cCharAt = charSequence2.charAt(i5);
                        codePoint = cCharAt2;
                        if (Character.isLowSurrogate(cCharAt)) {
                            i5 = i3 + 2;
                            codePoint = Character.toCodePoint(cCharAt2, cCharAt);
                        }
                    }
                    appendUnchanged(charSequence2, i6, i3 - i6, appendable2, i7, edits2);
                    if (i >= 0) {
                        if (stringContextIterator == null) {
                            stringContextIterator = new StringContextIterator(charSequence2, i3, i5);
                        } else {
                            stringContextIterator.setCPStartAndLimit(i3, i5);
                        }
                        fullFolding = UCaseProps.INSTANCE.toFullLower(codePoint, stringContextIterator, appendable2, i);
                    } else {
                        fullFolding = UCaseProps.INSTANCE.toFullFolding(codePoint, appendable2, i7);
                    }
                    if (fullFolding >= 0) {
                        appendResult(fullFolding, appendable2, i5 - i3, i7, edits2);
                        i6 = i5;
                    } else {
                        i6 = i3;
                    }
                    i3 = i5;
                } else {
                    i3++;
                    if (delta != 0) {
                        appendUnchanged(charSequence2, i6, (i3 - 1) - i6, appendable2, i7, edits2);
                        appendable2.append((char) (cCharAt2 + delta));
                        if (edits2 != null) {
                            edits2.addReplace(1, 1);
                        }
                        i6 = i3;
                    }
                }
            } else if (cCharAt2 >= 55296) {
                i5 = i3 + 1;
                zIsHighSurrogate = Character.isHighSurrogate(cCharAt2);
                codePoint = cCharAt2;
                codePoint = cCharAt2;
                if (zIsHighSurrogate) {
                    cCharAt = charSequence2.charAt(i5);
                    codePoint = cCharAt2;
                    if (Character.isLowSurrogate(cCharAt)) {
                        i5 = i3 + 2;
                        codePoint = Character.toCodePoint(cCharAt2, cCharAt);
                    }
                }
                appendUnchanged(charSequence2, i6, i3 - i6, appendable2, i7, edits2);
                if (i >= 0) {
                    if (stringContextIterator == null) {
                        stringContextIterator = new StringContextIterator(charSequence2, i3, i5);
                    } else {
                        stringContextIterator.setCPStartAndLimit(i3, i5);
                    }
                    fullFolding = UCaseProps.INSTANCE.toFullLower(codePoint, stringContextIterator, appendable2, i);
                } else {
                    fullFolding = UCaseProps.INSTANCE.toFullFolding(codePoint, appendable2, i7);
                }
                if (fullFolding >= 0) {
                    appendResult(fullFolding, appendable2, i5 - i3, i7, edits2);
                    i6 = i5;
                } else {
                    i6 = i3;
                }
                i3 = i5;
            } else {
                int fromU16SingleLead = CASE_TRIE.getFromU16SingleLead(cCharAt2);
                if (UCaseProps.propsHasException(fromU16SingleLead)) {
                    i5 = i3 + 1;
                    zIsHighSurrogate = Character.isHighSurrogate(cCharAt2);
                    codePoint = cCharAt2;
                    codePoint = cCharAt2;
                    if (zIsHighSurrogate) {
                        cCharAt = charSequence2.charAt(i5);
                        codePoint = cCharAt2;
                        if (Character.isLowSurrogate(cCharAt)) {
                            i5 = i3 + 2;
                            codePoint = Character.toCodePoint(cCharAt2, cCharAt);
                        }
                    }
                    appendUnchanged(charSequence2, i6, i3 - i6, appendable2, i7, edits2);
                    if (i >= 0) {
                        if (stringContextIterator == null) {
                            stringContextIterator = new StringContextIterator(charSequence2, i3, i5);
                        } else {
                            stringContextIterator.setCPStartAndLimit(i3, i5);
                        }
                        fullFolding = UCaseProps.INSTANCE.toFullLower(codePoint, stringContextIterator, appendable2, i);
                    } else {
                        fullFolding = UCaseProps.INSTANCE.toFullFolding(codePoint, appendable2, i7);
                    }
                    if (fullFolding >= 0) {
                        appendResult(fullFolding, appendable2, i5 - i3, i7, edits2);
                        i6 = i5;
                    } else {
                        i6 = i3;
                    }
                    i3 = i5;
                } else {
                    i3++;
                    if (UCaseProps.isUpperOrTitleFromProps(fromU16SingleLead) && (delta = UCaseProps.getDelta(fromU16SingleLead)) != 0) {
                        appendUnchanged(charSequence2, i6, (i3 - 1) - i6, appendable2, i7, edits2);
                        appendable2.append((char) (cCharAt2 + delta));
                        if (edits2 != null) {
                            edits2.addReplace(1, 1);
                        }
                        i6 = i3;
                    }
                }
            }
            charSequence = charSequence2;
            appendable = appendable2;
            i2 = i7;
            edits = edits2;
        }
        appendUnchanged(charSequence, i6, i3 - i6, appendable, i2, edits);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0053 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0067  */
    /* JADX WARN: Code duplicated, block: B:31:0x006e  */
    /* JADX WARN: Code duplicated, block: B:34:0x007e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Code duplicated, block: B:42:0x0097 A[PHI: r2 r12
      0x0097: PHI (r2v5 int) = (r2v2 int), (r2v6 int) binds: [B:40:0x0094, B:16:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r12v11 int) = (r12v6 int), (r12v13 int) binds: [B:40:0x0094, B:16:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a5  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static void internalToUpper(int i, int i2, CharSequence charSequence, Appendable appendable, Edits edits) throws IOException {
        int delta;
        int i3;
        boolean zIsHighSurrogate;
        int codePoint;
        int fullUpper;
        char cCharAt;
        byte[] bArr = i == 2 ? UCaseProps.LatinCase.TO_UPPER_TR : UCaseProps.LatinCase.TO_UPPER_NORMAL;
        int length = charSequence.length();
        int i4 = 0;
        int i5 = 0;
        StringContextIterator stringContextIterator = null;
        while (i4 < length) {
            int i6 = i2;
            CharSequence charSequence2 = charSequence;
            Appendable appendable2 = appendable;
            Edits edits2 = edits;
            char cCharAt2 = charSequence2.charAt(i4);
            if (cCharAt2 < 383) {
                delta = bArr[cCharAt2];
                if (delta == -128) {
                    i3 = i4 + 1;
                    zIsHighSurrogate = Character.isHighSurrogate(cCharAt2);
                    codePoint = cCharAt2;
                    codePoint = cCharAt2;
                    if (zIsHighSurrogate && i3 < length) {
                        cCharAt = charSequence2.charAt(i3);
                        codePoint = cCharAt2;
                        if (Character.isLowSurrogate(cCharAt)) {
                            i3 = i4 + 2;
                            codePoint = Character.toCodePoint(cCharAt2, cCharAt);
                        }
                    }
                    if (stringContextIterator == null) {
                        stringContextIterator = new StringContextIterator(charSequence2, i4, i3);
                    } else {
                        stringContextIterator.setCPStartAndLimit(i4, i3);
                    }
                    appendUnchanged(charSequence2, i5, i4 - i5, appendable2, i6, edits2);
                    fullUpper = UCaseProps.INSTANCE.toFullUpper(codePoint, stringContextIterator, appendable2, i);
                    if (fullUpper >= 0) {
                        appendResult(fullUpper, appendable2, i3 - i4, i6, edits2);
                        i5 = i3;
                    } else {
                        i5 = i4;
                    }
                    i4 = i3;
                } else {
                    i4++;
                    if (delta != 0) {
                        appendUnchanged(charSequence2, i5, (i4 - 1) - i5, appendable2, i6, edits2);
                        appendable2.append((char) (cCharAt2 + delta));
                        if (edits2 != null) {
                            edits2.addReplace(1, 1);
                        }
                        i5 = i4;
                    }
                }
            } else if (cCharAt2 >= 55296) {
                i3 = i4 + 1;
                zIsHighSurrogate = Character.isHighSurrogate(cCharAt2);
                codePoint = cCharAt2;
                codePoint = cCharAt2;
                if (zIsHighSurrogate) {
                    cCharAt = charSequence2.charAt(i3);
                    codePoint = cCharAt2;
                    if (Character.isLowSurrogate(cCharAt)) {
                        i3 = i4 + 2;
                        codePoint = Character.toCodePoint(cCharAt2, cCharAt);
                    }
                }
                if (stringContextIterator == null) {
                    stringContextIterator = new StringContextIterator(charSequence2, i4, i3);
                } else {
                    stringContextIterator.setCPStartAndLimit(i4, i3);
                }
                appendUnchanged(charSequence2, i5, i4 - i5, appendable2, i6, edits2);
                fullUpper = UCaseProps.INSTANCE.toFullUpper(codePoint, stringContextIterator, appendable2, i);
                if (fullUpper >= 0) {
                    appendResult(fullUpper, appendable2, i3 - i4, i6, edits2);
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                i4 = i3;
            } else {
                int fromU16SingleLead = CASE_TRIE.getFromU16SingleLead(cCharAt2);
                if (UCaseProps.propsHasException(fromU16SingleLead)) {
                    i3 = i4 + 1;
                    zIsHighSurrogate = Character.isHighSurrogate(cCharAt2);
                    codePoint = cCharAt2;
                    codePoint = cCharAt2;
                    if (zIsHighSurrogate) {
                        cCharAt = charSequence2.charAt(i3);
                        codePoint = cCharAt2;
                        if (Character.isLowSurrogate(cCharAt)) {
                            i3 = i4 + 2;
                            codePoint = Character.toCodePoint(cCharAt2, cCharAt);
                        }
                    }
                    if (stringContextIterator == null) {
                        stringContextIterator = new StringContextIterator(charSequence2, i4, i3);
                    } else {
                        stringContextIterator.setCPStartAndLimit(i4, i3);
                    }
                    appendUnchanged(charSequence2, i5, i4 - i5, appendable2, i6, edits2);
                    fullUpper = UCaseProps.INSTANCE.toFullUpper(codePoint, stringContextIterator, appendable2, i);
                    if (fullUpper >= 0) {
                        appendResult(fullUpper, appendable2, i3 - i4, i6, edits2);
                        i5 = i3;
                    } else {
                        i5 = i4;
                    }
                    i4 = i3;
                } else {
                    i4++;
                    if (UCaseProps.getTypeFromProps(fromU16SingleLead) == 1 && (delta = UCaseProps.getDelta(fromU16SingleLead)) != 0) {
                        appendUnchanged(charSequence2, i5, (i4 - 1) - i5, appendable2, i6, edits2);
                        appendable2.append((char) (cCharAt2 + delta));
                        if (edits2 != null) {
                            edits2.addReplace(1, 1);
                        }
                        i5 = i4;
                    }
                }
            }
            charSequence = charSequence2;
            appendable = appendable2;
            i2 = i6;
            edits = edits2;
        }
        appendUnchanged(charSequence, i5, i4 - i5, appendable, i2, edits);
    }

    private static boolean isLNS(int i) {
        int type = UCharacterProperty.INSTANCE.getType(i);
        return ((1 << type) & LNS) != 0 || (type == 4 && UCaseProps.INSTANCE.getType(i) != 0);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d  */
    private static <A extends Appendable> int maybeTitleDutchIJ(CharSequence charSequence, int i, int i2, int i3, A a, int i4, Edits edits) throws IOException {
        int i5;
        int i6;
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = i2 + 1;
        char cCharAt = charSequence.charAt(i2);
        if (i == 73) {
            if (cCharAt == 769) {
                if (i11 != i3) {
                    cCharAt = charSequence.charAt(i11);
                    i11 = i2 + 2;
                    i5 = 1;
                }
                return i2;
            }
            i5 = 0;
            i6 = i5;
        } else {
            i5 = 0;
            i6 = 1;
        }
        if (cCharAt != 'j') {
            if (cCharAt == 'J') {
                i5++;
                z = false;
            }
            return i2;
        }
        z = true;
        if (i6 != 0) {
            if (i11 != i3) {
                int i12 = i11 + 1;
                if (charSequence.charAt(i11) == 769) {
                    if (z) {
                        i7 = i5;
                        i8 = i12;
                        i9 = 1;
                    } else {
                        i7 = i5 + 1;
                        i8 = i12;
                    }
                    if (i8 < i3 || ((1 << UCharacter.getType(Character.codePointAt(charSequence, i8))) & U_GC_M_MASK) == 0) {
                        appendUnchanged(charSequence, i2, i7, a, i4, edits);
                        i10 = i2 + i7;
                        if (z) {
                            a.append('J');
                            if (edits != null) {
                                edits.addReplace(1, 1);
                            }
                            i10++;
                        }
                        appendUnchanged(charSequence, i10, i9, a, i4, edits);
                        return i8;
                    }
                }
            }
            return i2;
        }
        i7 = i5;
        i8 = i11;
        i9 = 0;
        if (i8 < i3) {
        }
        appendUnchanged(charSequence, i2, i7, a, i4, edits);
        i10 = i2 + i7;
        if (z) {
            a.append('J');
            if (edits != null) {
                edits.addReplace(1, 1);
            }
            i10++;
        }
        appendUnchanged(charSequence, i10, i9, a, i4, edits);
        return i8;
    }

    public static String toLower(int i, int i2, CharSequence charSequence) {
        if (charSequence.length() > 100 || (i2 & 16384) != 0) {
            return ((StringBuilder) toLower(i, i2, charSequence, new StringBuilder(charSequence.length()), null)).toString();
        }
        if (charSequence.length() == 0) {
            return charSequence.toString();
        }
        Edits edits = new Edits();
        return applyEdits(charSequence, (StringBuilder) toLower(i, i2 | 16384, charSequence, new StringBuilder(), edits), edits);
    }

    public static <A extends Appendable> A toTitle(int i, int i2, BreakIterator breakIterator, CharSequence charSequence, A a, Edits edits) {
        boolean z;
        int next;
        A a2;
        Edits edits2;
        int i3;
        int cPLimit;
        if (edits != null) {
            try {
                edits.reset();
            } catch (IOException e) {
                kf2.h(e);
                return null;
            }
        }
        CharSequence charSequence2 = charSequence;
        StringContextIterator stringContextIterator = new StringContextIterator(charSequence2);
        int length = charSequence2.length();
        boolean z2 = true;
        int i4 = 0;
        while (i4 < length) {
            if (z2) {
                next = breakIterator.first();
                z = false;
            } else {
                z = z2;
                next = breakIterator.next();
            }
            int i5 = (next == -1 || next > length) ? length : next;
            if (i4 < i5) {
                stringContextIterator.setLimit(i5);
                int iNextCaseMapCP = stringContextIterator.nextCaseMapCP();
                if ((i2 & 512) == 0) {
                    boolean z3 = (i2 & 1024) != 0;
                    do {
                        if (!z3) {
                            if (isLNS(iNextCaseMapCP)) {
                                break;
                            }
                            iNextCaseMapCP = stringContextIterator.nextCaseMapCP();
                        } else {
                            if (UCaseProps.INSTANCE.getType(iNextCaseMapCP) != 0) {
                                break;
                            }
                            iNextCaseMapCP = stringContextIterator.nextCaseMapCP();
                        }
                    } while (iNextCaseMapCP >= 0);
                    int i6 = iNextCaseMapCP;
                    int cPStart = stringContextIterator.getCPStart();
                    if (i4 < cPStart) {
                        a2 = a;
                        edits2 = edits;
                        appendUnchanged(charSequence2, i4, cPStart - i4, a2, i2, edits2);
                    } else {
                        a2 = a;
                        edits2 = edits;
                    }
                    iNextCaseMapCP = i6;
                    i4 = cPStart;
                } else {
                    a2 = a;
                    edits2 = edits;
                }
                if (i4 < i5) {
                    int fullTitle = UCaseProps.INSTANCE.toFullTitle(iNextCaseMapCP, stringContextIterator, a2, i);
                    appendResult(fullTitle, a2, stringContextIterator.getCPLength(), i2, edits2);
                    int i7 = i4 + 1;
                    if (i7 >= i5 || i != 5) {
                        i3 = i5;
                        cPLimit = stringContextIterator.getCPLimit();
                    } else {
                        if (fullTitle < 0) {
                            fullTitle = ~fullTitle;
                        }
                        int i8 = fullTitle;
                        if (i8 == 73 || i8 == 205) {
                            A a3 = a2;
                            i3 = i5;
                            cPLimit = maybeTitleDutchIJ(charSequence, i8, i7, i3, a3, i2, edits2);
                            stringContextIterator.moveTo(cPLimit);
                        } else {
                            cPLimit = stringContextIterator.getCPLimit();
                            i3 = i5;
                        }
                    }
                    if (cPLimit < i3) {
                        if ((i2 & 256) == 0) {
                            int i9 = i3;
                            StringContextIterator stringContextIterator2 = stringContextIterator;
                            internalToLower(i, i2, charSequence, cPLimit, i9, stringContextIterator2, a, edits);
                            i5 = i9;
                            stringContextIterator = stringContextIterator2;
                        } else {
                            i5 = i3;
                            appendUnchanged(charSequence, cPLimit, i5 - cPLimit, a, i2, edits);
                        }
                        stringContextIterator.moveToLimit();
                    } else {
                        i5 = i3;
                    }
                }
            }
            charSequence2 = charSequence;
            i4 = i5;
            z2 = z;
        }
        return a;
    }

    public static String toUpper(int i, int i2, CharSequence charSequence) {
        if (charSequence.length() > 100 || (i2 & 16384) != 0) {
            return ((StringBuilder) toUpper(i, i2, charSequence, new StringBuilder(charSequence.length()), null)).toString();
        }
        if (charSequence.length() == 0) {
            return charSequence.toString();
        }
        Edits edits = new Edits();
        return applyEdits(charSequence, (StringBuilder) toUpper(i, i2 | 16384, charSequence, new StringBuilder(), edits), edits);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class WholeStringBreakIterator extends BreakIterator {
        private int length;

        public /* synthetic */ WholeStringBreakIterator(int i) {
            this();
        }

        private static void notImplemented() {
            throw new UnsupportedOperationException("should not occur");
        }

        @Override // com.ibm.icu.text.BreakIterator
        public int current() {
            notImplemented();
            return 0;
        }

        @Override // com.ibm.icu.text.BreakIterator
        public int first() {
            return 0;
        }

        @Override // com.ibm.icu.text.BreakIterator
        public int following(int i) {
            notImplemented();
            return 0;
        }

        @Override // com.ibm.icu.text.BreakIterator
        public CharacterIterator getText() {
            notImplemented();
            return null;
        }

        @Override // com.ibm.icu.text.BreakIterator
        public int last() {
            notImplemented();
            return 0;
        }

        @Override // com.ibm.icu.text.BreakIterator
        public int next(int i) {
            notImplemented();
            return 0;
        }

        @Override // com.ibm.icu.text.BreakIterator
        public int previous() {
            notImplemented();
            return 0;
        }

        @Override // com.ibm.icu.text.BreakIterator
        public void setText(CharacterIterator characterIterator) {
            this.length = characterIterator.getEndIndex();
        }

        private WholeStringBreakIterator() {
        }

        @Override // com.ibm.icu.text.BreakIterator
        public int next() {
            return this.length;
        }

        @Override // com.ibm.icu.text.BreakIterator
        public void setText(CharSequence charSequence) {
            this.length = charSequence.length();
        }

        @Override // com.ibm.icu.text.BreakIterator
        public void setText(String str) {
            this.length = str.length();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class StringContextIterator implements UCaseProps.ContextIterator {
        protected int cpLimit;
        protected int cpStart;
        protected int dir;
        protected int index;
        protected int limit;
        protected CharSequence s;

        public StringContextIterator(CharSequence charSequence) {
            this.s = charSequence;
            this.limit = charSequence.length();
            this.index = 0;
            this.cpLimit = 0;
            this.cpStart = 0;
            this.dir = 0;
        }

        public int getCPLength() {
            return this.cpLimit - this.cpStart;
        }

        public int getCPLimit() {
            return this.cpLimit;
        }

        public int getCPStart() {
            return this.cpStart;
        }

        public void moveTo(int i) {
            this.cpLimit = i;
            this.cpStart = i;
        }

        public void moveToLimit() {
            int i = this.limit;
            this.cpLimit = i;
            this.cpStart = i;
        }

        @Override // com.ibm.icu.impl.UCaseProps.ContextIterator
        public int next() {
            int i;
            if (this.dir > 0 && this.index < this.s.length()) {
                int iCodePointAt = Character.codePointAt(this.s, this.index);
                this.index = Character.charCount(iCodePointAt) + this.index;
                return iCodePointAt;
            }
            if (this.dir >= 0 || (i = this.index) <= 0) {
                return -1;
            }
            int iCodePointBefore = Character.codePointBefore(this.s, i);
            this.index -= Character.charCount(iCodePointBefore);
            return iCodePointBefore;
        }

        public int nextCaseMapCP() {
            int i = this.cpLimit;
            this.cpStart = i;
            if (i >= this.limit) {
                return -1;
            }
            int iCodePointAt = Character.codePointAt(this.s, i);
            this.cpLimit = Character.charCount(iCodePointAt) + this.cpLimit;
            return iCodePointAt;
        }

        @Override // com.ibm.icu.impl.UCaseProps.ContextIterator
        public void reset(int i) {
            if (i > 0) {
                this.dir = 1;
                this.index = this.cpLimit;
            } else if (i < 0) {
                this.dir = -1;
                this.index = this.cpStart;
            } else {
                this.dir = 0;
                this.index = 0;
            }
        }

        public void setCPStartAndLimit(int i, int i2) {
            this.cpStart = i;
            this.cpLimit = i2;
            this.dir = 0;
        }

        public void setLimit(int i) {
            if (i < 0 || i > this.s.length()) {
                this.limit = this.s.length();
            } else {
                this.limit = i;
            }
        }

        public StringContextIterator(CharSequence charSequence, int i, int i2) {
            this.s = charSequence;
            this.index = 0;
            this.limit = charSequence.length();
            this.cpStart = i;
            this.cpLimit = i2;
            this.dir = 0;
        }
    }

    public static BreakIterator getTitleBreakIterator(ULocale uLocale, int i, BreakIterator breakIterator) {
        int i2 = i & 224;
        if (i2 != 0 && breakIterator != null) {
            og.i("titlecasing iterator option together with an explicit iterator");
            return null;
        }
        if (breakIterator != null) {
            return breakIterator;
        }
        if (i2 == 0) {
            return BreakIterator.getWordInstance(uLocale);
        }
        if (i2 == 32) {
            return new WholeStringBreakIterator(0);
        }
        if (i2 == 64) {
            return BreakIterator.getSentenceInstance(uLocale);
        }
        og.i("unknown titlecasing iterator option");
        return null;
    }

    public static <A extends Appendable> A fold(int i, CharSequence charSequence, A a, Edits edits) {
        if (edits != null) {
            try {
                edits.reset();
            } catch (IOException e) {
                kf2.h(e);
                return null;
            }
        }
        internalToLower(-1, i, charSequence, 0, charSequence.length(), null, a, edits);
        return a;
    }

    public static <A extends Appendable> A toLower(int i, int i2, CharSequence charSequence, A a, Edits edits) {
        if (edits != null) {
            try {
                edits.reset();
            } catch (IOException e) {
                kf2.h(e);
                return null;
            }
        }
        internalToLower(i, i2, charSequence, 0, charSequence.length(), null, a, edits);
        return a;
    }

    public static <A extends Appendable> A toUpper(int i, int i2, CharSequence charSequence, A a, Edits edits) {
        if (edits != null) {
            try {
                edits.reset();
            } catch (IOException e) {
                kf2.h(e);
                return null;
            }
        }
        if (i == 4) {
            return (A) GreekUpper.toUpper(i2, charSequence, a, edits);
        }
        internalToUpper(i, i2, charSequence, a, edits);
        return a;
    }

    public static String toTitle(int i, int i2, BreakIterator breakIterator, CharSequence charSequence) {
        if (charSequence.length() <= 100 && (i2 & 16384) == 0) {
            if (charSequence.length() == 0) {
                return charSequence.toString();
            }
            Edits edits = new Edits();
            return applyEdits(charSequence, (StringBuilder) toTitle(i, i2 | 16384, breakIterator, charSequence, new StringBuilder(), edits), edits);
        }
        return ((StringBuilder) toTitle(i, i2, breakIterator, charSequence, new StringBuilder(charSequence.length()), null)).toString();
    }
}
