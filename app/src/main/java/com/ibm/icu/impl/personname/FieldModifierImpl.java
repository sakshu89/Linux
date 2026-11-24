package com.ibm.icu.impl.personname;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.CaseMap;
import com.ibm.icu.text.PersonName;
import com.ibm.icu.text.SimpleFormatter;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
abstract class FieldModifierImpl {
    private static final FieldModifierImpl NOOP_MODIFIER = new FieldModifierImpl() { // from class: com.ibm.icu.impl.personname.FieldModifierImpl.1
        @Override // com.ibm.icu.impl.personname.FieldModifierImpl
        public String modifyField(String str) {
            return str;
        }
    };
    private static final FieldModifierImpl NULL_MODIFIER = new FieldModifierImpl() { // from class: com.ibm.icu.impl.personname.FieldModifierImpl.2
        @Override // com.ibm.icu.impl.personname.FieldModifierImpl
        public String modifyField(String str) {
            return "";
        }
    };
    private static final FieldModifierImpl MONOGRAM_MODIFIER = new FieldModifierImpl() { // from class: com.ibm.icu.impl.personname.FieldModifierImpl.3
        @Override // com.ibm.icu.impl.personname.FieldModifierImpl
        public String modifyField(String str) {
            return FieldModifierImpl.getFirstGrapheme(str);
        }
    };

    /* JADX INFO: renamed from: com.ibm.icu.impl.personname.FieldModifierImpl$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier;

        static {
            int[] iArr = new int[PersonName.FieldModifier.values().length];
            $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier = iArr;
            try {
                iArr[PersonName.FieldModifier.INFORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[PersonName.FieldModifier.PREFIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[PersonName.FieldModifier.CORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[PersonName.FieldModifier.ALL_CAPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[PersonName.FieldModifier.INITIAL_CAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[PersonName.FieldModifier.INITIAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[PersonName.FieldModifier.RETAIN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[PersonName.FieldModifier.MONOGRAM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[PersonName.FieldModifier.GENITIVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[PersonName.FieldModifier.VOCATIVE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class AllCapsModifier extends FieldModifierImpl {
        private final Locale locale;

        public AllCapsModifier(Locale locale) {
            this.locale = locale;
        }

        @Override // com.ibm.icu.impl.personname.FieldModifierImpl
        public String modifyField(String str) {
            return UCharacter.toUpperCase(this.locale, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class InitialCapModifier extends FieldModifierImpl {
        private static final CaseMap.Title TO_TITLE_WHOLE_STRING_NO_LOWERCASE = CaseMap.toTitle().wholeString().noLowercase();
        private final Locale locale;

        public InitialCapModifier(Locale locale) {
            this.locale = locale;
        }

        @Override // com.ibm.icu.impl.personname.FieldModifierImpl
        public String modifyField(String str) {
            return TO_TITLE_WHOLE_STRING_NO_LOWERCASE.apply(this.locale, null, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class InitialModifier extends FieldModifierImpl {
        private final SimpleFormatter initialFormatter;
        private final SimpleFormatter initialSequenceFormatter;
        private final Locale locale;
        private boolean retainPunctuation = false;

        public InitialModifier(Locale locale, String str, String str2) {
            this.locale = locale;
            this.initialFormatter = SimpleFormatter.compile(str);
            this.initialSequenceFormatter = SimpleFormatter.compile(str2);
        }

        @Override // com.ibm.icu.impl.personname.FieldModifierImpl
        public String modifyField(String str) {
            String strK;
            BreakIterator wordInstance = BreakIterator.getWordInstance(this.locale);
            wordInstance.setText(str);
            String str2 = null;
            int iFirst = wordInstance.first();
            String strJ = "";
            for (int next = wordInstance.next(); next != -1; next = wordInstance.next()) {
                String strSubstring = str.substring(iFirst, next);
                if (Character.isLetter(strSubstring.charAt(0))) {
                    String firstGrapheme = FieldModifierImpl.getFirstGrapheme(strSubstring);
                    if (str2 == null) {
                        strK = this.initialFormatter.format(firstGrapheme);
                    } else if (this.retainPunctuation) {
                        strK = cq.k(str2, strJ, this.initialFormatter.format(firstGrapheme));
                        strJ = "";
                    } else {
                        strK = this.initialSequenceFormatter.format(str2, this.initialFormatter.format(firstGrapheme));
                    }
                    str2 = strK;
                } else {
                    strJ = Character.isWhitespace(strSubstring.charAt(0)) ? strJ + strSubstring.charAt(0) : ky0.j(strJ, strSubstring);
                }
                iFirst = next;
            }
            return str2;
        }

        public void setRetainPunctuation(boolean z) {
            this.retainPunctuation = z;
        }
    }

    public static FieldModifierImpl forName(PersonName.FieldModifier fieldModifier, PersonNameFormatterImpl personNameFormatterImpl) {
        switch (AnonymousClass4.$SwitchMap$com$ibm$icu$text$PersonName$FieldModifier[fieldModifier.ordinal()]) {
            case 1:
                return NOOP_MODIFIER;
            case 2:
                return NULL_MODIFIER;
            case 3:
                return NOOP_MODIFIER;
            case 4:
                return new AllCapsModifier(personNameFormatterImpl.getLocale());
            case 5:
                return new InitialCapModifier(personNameFormatterImpl.getLocale());
            case 6:
                return new InitialModifier(personNameFormatterImpl.getLocale(), personNameFormatterImpl.getInitialPattern(), personNameFormatterImpl.getInitialSequencePattern());
            case 7:
                return NOOP_MODIFIER;
            case 8:
                return MONOGRAM_MODIFIER;
            case 9:
                return NOOP_MODIFIER;
            case 10:
                return NOOP_MODIFIER;
            default:
                og.i("Invalid modifier ID ".concat(String.valueOf(fieldModifier)));
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstGrapheme(String str) {
        if (str.isEmpty()) {
            return "";
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance(Locale.ROOT);
        characterInstance.setText(str);
        return str.substring(0, characterInstance.next());
    }

    public abstract String modifyField(String str);
}
