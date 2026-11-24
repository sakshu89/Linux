package com.ibm.icu.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.number.ConstantAffixModifier;
import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.impl.number.MicroProps;
import com.ibm.icu.impl.number.MicroPropsGenerator;
import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.impl.number.MultiplierProducer;
import com.ibm.icu.impl.number.RoundingUtils;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
import defpackage.og;
import java.text.Format;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ScientificNotation extends Notation {
    final int engineeringInterval;
    final NumberFormatter.SignDisplay exponentSignDisplay;
    final int minExponentDigits;
    final boolean requireMinInt;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ScientificModifier implements Modifier {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final int exponent;
        final ScientificHandler handler;

        public ScientificModifier(int i, ScientificHandler scientificHandler) {
            this.exponent = i;
            this.handler = scientificHandler;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public int apply(FormattedStringBuilder formattedStringBuilder, int i, int i2) {
            return this.handler.doApply(this.exponent, formattedStringBuilder, i2);
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public boolean containsField(Format.Field field) {
            return false;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public int getCodePointCount() {
            return RoundingUtils.MAX_INT_FRAC_SIG;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public Modifier.Parameters getParameters() {
            return null;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public int getPrefixLength() {
            return 0;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public boolean isStrong() {
            return true;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public boolean strictEquals(Modifier modifier) {
            return (modifier instanceof ScientificModifier) && this.exponent == ((ScientificModifier) modifier).exponent;
        }
    }

    public ScientificNotation(int i, boolean z, int i2, NumberFormatter.SignDisplay signDisplay) {
        this.engineeringInterval = i;
        this.requireMinInt = z;
        this.minExponentDigits = i2;
        this.exponentSignDisplay = signDisplay;
    }

    public ScientificNotation withExponentSignDisplay(NumberFormatter.SignDisplay signDisplay) {
        return new ScientificNotation(this.engineeringInterval, this.requireMinInt, this.minExponentDigits, signDisplay);
    }

    public MicroPropsGenerator withLocaleData(DecimalFormatSymbols decimalFormatSymbols, boolean z, MicroPropsGenerator microPropsGenerator) {
        return new ScientificHandler(this, decimalFormatSymbols, z, microPropsGenerator, 0);
    }

    public ScientificNotation withMinExponentDigits(int i) {
        if (i >= 1 && i <= 999) {
            return new ScientificNotation(this.engineeringInterval, this.requireMinInt, i, this.exponentSignDisplay);
        }
        og.i("Integer digits must be between 1 and 999 (inclusive)");
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ScientificHandler implements MicroPropsGenerator, MultiplierProducer, Modifier {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        int exponent;
        final ScientificNotation notation;
        final MicroPropsGenerator parent;
        final ScientificModifier[] precomputedMods;
        final DecimalFormatSymbols symbols;

        private ScientificHandler(ScientificNotation scientificNotation, DecimalFormatSymbols decimalFormatSymbols, boolean z, MicroPropsGenerator microPropsGenerator) {
            this.notation = scientificNotation;
            this.symbols = decimalFormatSymbols;
            this.parent = microPropsGenerator;
            if (!z) {
                this.precomputedMods = null;
                return;
            }
            this.precomputedMods = new ScientificModifier[25];
            for (int i = -12; i <= 12; i++) {
                this.precomputedMods[i + 12] = new ScientificModifier(i, this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int doApply(int i, FormattedStringBuilder formattedStringBuilder, int i2) {
            int iInsert;
            int iAbs;
            int i3;
            int iInsert2 = formattedStringBuilder.insert(i2, this.symbols.getExponentSeparator(), NumberFormat.Field.EXPONENT_SYMBOL) + i2;
            if (i >= 0 || this.notation.exponentSignDisplay == NumberFormatter.SignDisplay.NEVER) {
                if (i >= 0 && this.notation.exponentSignDisplay == NumberFormatter.SignDisplay.ALWAYS) {
                    iInsert = formattedStringBuilder.insert(iInsert2, this.symbols.getPlusSignString(), NumberFormat.Field.EXPONENT_SIGN);
                }
                iAbs = Math.abs(i);
                i3 = 0;
                while (true) {
                    if (i3 < this.notation.minExponentDigits && iAbs <= 0) {
                        return iInsert2 - i2;
                    }
                    iInsert2 += formattedStringBuilder.insert(iInsert2 - i3, this.symbols.getDigitStringsLocal()[iAbs % 10], NumberFormat.Field.EXPONENT);
                    i3++;
                    iAbs /= 10;
                }
            } else {
                iInsert = formattedStringBuilder.insert(iInsert2, this.symbols.getMinusSignString(), NumberFormat.Field.EXPONENT_SIGN);
            }
            iInsert2 += iInsert;
            iAbs = Math.abs(i);
            i3 = 0;
            while (true) {
                if (i3 < this.notation.minExponentDigits) {
                }
                iInsert2 += formattedStringBuilder.insert(iInsert2 - i3, this.symbols.getDigitStringsLocal()[iAbs % 10], NumberFormat.Field.EXPONENT);
                i3++;
                iAbs /= 10;
            }
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public int apply(FormattedStringBuilder formattedStringBuilder, int i, int i2) {
            return doApply(this.exponent, formattedStringBuilder, i2);
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public boolean containsField(Format.Field field) {
            return false;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public int getCodePointCount() {
            return RoundingUtils.MAX_INT_FRAC_SIG;
        }

        @Override // com.ibm.icu.impl.number.MultiplierProducer
        public int getMultiplier(int i) {
            ScientificNotation scientificNotation = this.notation;
            int i2 = scientificNotation.engineeringInterval;
            if (!scientificNotation.requireMinInt) {
                i2 = i2 <= 1 ? 1 : (((i % i2) + i2) % i2) + 1;
            }
            return (i2 - i) - 1;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public Modifier.Parameters getParameters() {
            return null;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public int getPrefixLength() {
            return 0;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public boolean isStrong() {
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x002e  */
        @Override // com.ibm.icu.impl.number.MicroPropsGenerator
        public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
            int i;
            MicroProps microPropsProcessQuantity = this.parent.processQuantity(decimalQuantity);
            if (decimalQuantity.isInfinite() || decimalQuantity.isNaN()) {
                microPropsProcessQuantity.modInner = ConstantAffixModifier.EMPTY;
                return microPropsProcessQuantity;
            }
            if (decimalQuantity.isZeroish()) {
                ScientificNotation scientificNotation = this.notation;
                i = 0;
                if (scientificNotation.requireMinInt) {
                    Precision precision = microPropsProcessQuantity.rounder;
                    if (precision instanceof Precision.SignificantRounderImpl) {
                        ((Precision.SignificantRounderImpl) precision).apply(decimalQuantity, scientificNotation.engineeringInterval);
                    } else {
                        microPropsProcessQuantity.rounder.apply(decimalQuantity);
                    }
                } else {
                    microPropsProcessQuantity.rounder.apply(decimalQuantity);
                }
            } else {
                i = -microPropsProcessQuantity.rounder.chooseMultiplierAndApply(decimalQuantity, this);
            }
            ScientificModifier[] scientificModifierArr = this.precomputedMods;
            if (scientificModifierArr != null && i >= -12 && i <= 12) {
                microPropsProcessQuantity.modInner = scientificModifierArr[i + 12];
            } else if (scientificModifierArr != null) {
                microPropsProcessQuantity.modInner = new ScientificModifier(i, this);
            } else {
                this.exponent = i;
                microPropsProcessQuantity.modInner = this;
            }
            decimalQuantity.adjustExponent(i);
            microPropsProcessQuantity.rounder = null;
            return microPropsProcessQuantity;
        }

        @Override // com.ibm.icu.impl.number.Modifier
        public boolean strictEquals(Modifier modifier) {
            return false;
        }

        public /* synthetic */ ScientificHandler(ScientificNotation scientificNotation, DecimalFormatSymbols decimalFormatSymbols, boolean z, MicroPropsGenerator microPropsGenerator, int i) {
            this(scientificNotation, decimalFormatSymbols, z, microPropsGenerator);
        }
    }
}
