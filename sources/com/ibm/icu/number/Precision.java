package com.ibm.icu.number;

import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.impl.number.MultiplierProducer;
import com.ibm.icu.impl.number.RoundingUtils;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.Currency;
import defpackage.og;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class Precision {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final MathContext mathContext;
    final NumberFormatter.TrailingZeroDisplay trailingZeroDisplay;

    @Deprecated
    public static final BogusRounder BOGUS_PRECISION = new BogusRounder();
    static final InfiniteRounderImpl NONE = new InfiniteRounderImpl();
    static final FractionRounderImpl FIXED_FRAC_0 = new FractionRounderImpl(0, 0);
    static final FractionRounderImpl FIXED_FRAC_2 = new FractionRounderImpl(2, 2);
    static final FractionRounderImpl DEFAULT_MAX_FRAC_6 = new FractionRounderImpl(0, 6);
    static final SignificantRounderImpl FIXED_SIG_2 = new SignificantRounderImpl(2, 2);
    static final SignificantRounderImpl FIXED_SIG_3 = new SignificantRounderImpl(3, 3);
    static final SignificantRounderImpl RANGE_SIG_2_3 = new SignificantRounderImpl(2, 3);
    static final FracSigRounderImpl COMPACT_STRATEGY = new FracSigRounderImpl(0, 0, 1, 2, NumberFormatter.RoundingPriority.RELAXED, false);
    static final IncrementFiveRounderImpl NICKEL = new IncrementFiveRounderImpl(new BigDecimal("0.05"), 2, 2);
    static final CurrencyRounderImpl MONETARY_STANDARD = new CurrencyRounderImpl(Currency.CurrencyUsage.STANDARD);
    static final CurrencyRounderImpl MONETARY_CASH = new CurrencyRounderImpl(Currency.CurrencyUsage.CASH);

    public Precision(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
        this.mathContext = mathContext;
        this.trailingZeroDisplay = trailingZeroDisplay;
    }

    public static CurrencyPrecision constructCurrency(Currency.CurrencyUsage currencyUsage) {
        if (currencyUsage == Currency.CurrencyUsage.STANDARD) {
            return MONETARY_STANDARD;
        }
        if (currencyUsage == Currency.CurrencyUsage.CASH) {
            return MONETARY_CASH;
        }
        throw new AssertionError();
    }

    public static FractionPrecision constructFraction(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return FIXED_FRAC_0;
        }
        if (i == 2 && i2 == 2) {
            return FIXED_FRAC_2;
        }
        return (i == 0 && i2 == 6) ? DEFAULT_MAX_FRAC_6 : new FractionRounderImpl(i, i2);
    }

    public static Precision constructFractionSignificant(FractionPrecision fractionPrecision, int i, int i2, NumberFormatter.RoundingPriority roundingPriority, boolean z) {
        FractionRounderImpl fractionRounderImpl = (FractionRounderImpl) fractionPrecision;
        int i3 = fractionRounderImpl.minFrac;
        return ((i3 == 0 && fractionRounderImpl.maxFrac == 0 && i == 1 && i2 == 2 && roundingPriority == NumberFormatter.RoundingPriority.RELAXED && !z) ? COMPACT_STRATEGY : new FracSigRounderImpl(i3, fractionRounderImpl.maxFrac, i, i2, roundingPriority, z)).withMode(fractionRounderImpl.mathContext);
    }

    public static Precision constructFromCurrency(CurrencyPrecision currencyPrecision, Currency currency) {
        Precision precisionConstructFraction;
        CurrencyRounderImpl currencyRounderImpl = (CurrencyRounderImpl) currencyPrecision;
        double roundingIncrement = currency.getRoundingIncrement(currencyRounderImpl.usage);
        if (roundingIncrement != 0.0d) {
            precisionConstructFraction = constructIncrement(BigDecimal.valueOf(roundingIncrement));
        } else {
            int defaultFractionDigits = currency.getDefaultFractionDigits(currencyRounderImpl.usage);
            precisionConstructFraction = constructFraction(defaultFractionDigits, defaultFractionDigits);
        }
        return precisionConstructFraction.withMode(currencyRounderImpl.mathContext);
    }

    public static Precision constructIncrement(BigDecimal bigDecimal) {
        IncrementFiveRounderImpl incrementFiveRounderImpl = NICKEL;
        if (bigDecimal.equals(incrementFiveRounderImpl.increment)) {
            return incrementFiveRounderImpl;
        }
        BigDecimal bigDecimal2 = bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
        if (bigDecimal2.precision() == 1) {
            int iScale = bigDecimal.scale();
            int iScale2 = bigDecimal2.scale();
            BigInteger bigIntegerUnscaledValue = bigDecimal2.unscaledValue();
            if (bigIntegerUnscaledValue.intValue() == 1) {
                return new IncrementOneRounderImpl(bigDecimal, iScale, iScale2);
            }
            if (bigIntegerUnscaledValue.intValue() == 5) {
                return new IncrementFiveRounderImpl(bigDecimal, iScale, iScale2);
            }
        }
        return new IncrementRounderImpl(bigDecimal);
    }

    public static Precision constructInfinite() {
        return NONE;
    }

    public static Precision constructSignificant(int i, int i2) {
        if (i == 2 && i2 == 2) {
            return FIXED_SIG_2;
        }
        if (i == 3 && i2 == 3) {
            return FIXED_SIG_3;
        }
        return (i == 2 && i2 == 3) ? RANGE_SIG_2_3 : new SignificantRounderImpl(i, i2);
    }

    public static CurrencyPrecision currency(Currency.CurrencyUsage currencyUsage) {
        if (currencyUsage != null) {
            return constructCurrency(currencyUsage);
        }
        og.i("CurrencyUsage must be non-null");
        return null;
    }

    public static FractionPrecision fixedFraction(int i) {
        if (i >= 0 && i <= 999) {
            return constructFraction(i, i);
        }
        og.i("Fraction length must be between 0 and 999 (inclusive)");
        return null;
    }

    public static Precision fixedSignificantDigits(int i) {
        if (i >= 1 && i <= 999) {
            return constructSignificant(i, i);
        }
        og.i("Significant digits must be between 1 and 999 (inclusive)");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getDisplayMagnitudeFraction(int i) {
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return -i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getDisplayMagnitudeSignificant(DecimalQuantity decimalQuantity, int i) {
        return ((decimalQuantity.isZeroish() ? 0 : decimalQuantity.getMagnitude()) - i) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getRoundingMagnitudeFraction(int i) {
        if (i == -1) {
            return Integer.MIN_VALUE;
        }
        return -i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getRoundingMagnitudeSignificant(DecimalQuantity decimalQuantity, int i) {
        if (i == -1) {
            return Integer.MIN_VALUE;
        }
        return ((decimalQuantity.isZeroish() ? 0 : decimalQuantity.getMagnitude()) - i) + 1;
    }

    public static Precision increment(BigDecimal bigDecimal) {
        if (bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
            return constructIncrement(bigDecimal);
        }
        og.i("Rounding increment must be positive and non-null");
        return null;
    }

    public static FractionPrecision integer() {
        return constructFraction(0, 0);
    }

    public static FractionPrecision maxFraction(int i) {
        if (i >= 0 && i <= 999) {
            return constructFraction(0, i);
        }
        og.i("Fraction length must be between 0 and 999 (inclusive)");
        return null;
    }

    public static Precision maxSignificantDigits(int i) {
        if (i >= 1 && i <= 999) {
            return constructSignificant(1, i);
        }
        og.i("Significant digits must be between 1 and 999 (inclusive)");
        return null;
    }

    public static FractionPrecision minFraction(int i) {
        if (i >= 0 && i <= 999) {
            return constructFraction(i, -1);
        }
        og.i("Fraction length must be between 0 and 999 (inclusive)");
        return null;
    }

    public static FractionPrecision minMaxFraction(int i, int i2) {
        if (i >= 0 && i2 <= 999 && i <= i2) {
            return constructFraction(i, i2);
        }
        og.i("Fraction length must be between 0 and 999 (inclusive)");
        return null;
    }

    public static Precision minMaxSignificantDigits(int i, int i2) {
        if (i >= 1 && i2 <= 999 && i <= i2) {
            return constructSignificant(i, i2);
        }
        og.i("Significant digits must be between 1 and 999 (inclusive)");
        return null;
    }

    public static Precision minSignificantDigits(int i) {
        if (i >= 1 && i <= 999) {
            return constructSignificant(i, -1);
        }
        og.i("Significant digits must be between 1 and 999 (inclusive)");
        return null;
    }

    public static Precision unlimited() {
        return constructInfinite();
    }

    @Deprecated
    public abstract void apply(DecimalQuantity decimalQuantity);

    public int chooseMultiplierAndApply(DecimalQuantity decimalQuantity, MultiplierProducer multiplierProducer) {
        int multiplier;
        int magnitude = decimalQuantity.getMagnitude();
        int multiplier2 = multiplierProducer.getMultiplier(magnitude);
        decimalQuantity.adjustMagnitude(multiplier2);
        apply(decimalQuantity);
        if (decimalQuantity.isZeroish() || decimalQuantity.getMagnitude() == magnitude + multiplier2 || multiplier2 == (multiplier = multiplierProducer.getMultiplier(magnitude + 1))) {
            return multiplier2;
        }
        decimalQuantity.adjustMagnitude(multiplier - multiplier2);
        apply(decimalQuantity);
        return multiplier;
    }

    public abstract Precision createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay);

    public void setResolvedMinFraction(DecimalQuantity decimalQuantity, int i) {
        NumberFormatter.TrailingZeroDisplay trailingZeroDisplay = this.trailingZeroDisplay;
        if (trailingZeroDisplay == null || trailingZeroDisplay == NumberFormatter.TrailingZeroDisplay.AUTO || decimalQuantity.getPluralOperand(PluralRules.Operand.t) != 0.0d) {
            decimalQuantity.setMinFraction(i);
        }
    }

    public Precision trailingZeroDisplay(NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
        return this.trailingZeroDisplay == trailingZeroDisplay ? this : createCopy(this.mathContext, trailingZeroDisplay);
    }

    public Precision withLocaleData(Currency currency) {
        return this instanceof CurrencyPrecision ? ((CurrencyPrecision) this).withCurrency(currency) : this;
    }

    @Deprecated
    public Precision withMode(MathContext mathContext) {
        return this.mathContext.equals(mathContext) ? this : createCopy(mathContext, this.trailingZeroDisplay);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    @Deprecated
    public static class BogusRounder extends Precision {
        @Deprecated
        public BogusRounder() {
        }

        @Override // com.ibm.icu.number.Precision
        @Deprecated
        public void apply(DecimalQuantity decimalQuantity) {
            throw new AssertionError("BogusRounder must not be applied");
        }

        @Override // com.ibm.icu.number.Precision
        public BogusRounder createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            return new BogusRounder(mathContext, trailingZeroDisplay);
        }

        @Deprecated
        public Precision into(Precision precision) {
            return precision.createCopy(this.mathContext, this.trailingZeroDisplay);
        }

        private BogusRounder(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            super(mathContext, trailingZeroDisplay);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class InfiniteRounderImpl extends Precision {
        public InfiniteRounderImpl() {
        }

        @Override // com.ibm.icu.number.Precision
        public void apply(DecimalQuantity decimalQuantity) {
            decimalQuantity.roundToInfinity();
            setResolvedMinFraction(decimalQuantity, 0);
        }

        @Override // com.ibm.icu.number.Precision
        public InfiniteRounderImpl createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            return new InfiniteRounderImpl(mathContext, trailingZeroDisplay);
        }

        public InfiniteRounderImpl(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            super(mathContext, trailingZeroDisplay);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CurrencyRounderImpl extends CurrencyPrecision {
        final Currency.CurrencyUsage usage;

        public CurrencyRounderImpl(Currency.CurrencyUsage currencyUsage) {
            this.usage = currencyUsage;
        }

        @Override // com.ibm.icu.number.Precision
        public void apply(DecimalQuantity decimalQuantity) {
            throw new AssertionError();
        }

        @Override // com.ibm.icu.number.Precision
        public CurrencyRounderImpl createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            return new CurrencyRounderImpl(this.usage, mathContext, trailingZeroDisplay);
        }

        public CurrencyRounderImpl(Currency.CurrencyUsage currencyUsage, MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            super(mathContext, trailingZeroDisplay);
            this.usage = currencyUsage;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class IncrementRounderImpl extends Precision {
        final BigDecimal increment;

        public IncrementRounderImpl(BigDecimal bigDecimal) {
            this.increment = bigDecimal;
        }

        @Override // com.ibm.icu.number.Precision
        public void apply(DecimalQuantity decimalQuantity) {
            decimalQuantity.roundToIncrement(this.increment, this.mathContext);
            setResolvedMinFraction(decimalQuantity, Math.max(0, this.increment.scale()));
        }

        @Override // com.ibm.icu.number.Precision
        public IncrementRounderImpl createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            return new IncrementRounderImpl(this.increment, mathContext, trailingZeroDisplay);
        }

        public IncrementRounderImpl(BigDecimal bigDecimal, MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            super(mathContext, trailingZeroDisplay);
            this.increment = bigDecimal;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class FractionRounderImpl extends FractionPrecision {
        final int maxFrac;
        final int minFrac;

        public FractionRounderImpl(int i, int i2) {
            this.minFrac = i;
            this.maxFrac = i2;
        }

        @Override // com.ibm.icu.number.Precision
        public void apply(DecimalQuantity decimalQuantity) {
            decimalQuantity.roundToMagnitude(Precision.getRoundingMagnitudeFraction(this.maxFrac), this.mathContext);
            setResolvedMinFraction(decimalQuantity, Math.max(0, -Precision.getDisplayMagnitudeFraction(this.minFrac)));
        }

        @Override // com.ibm.icu.number.Precision
        public FractionRounderImpl createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            return new FractionRounderImpl(this.minFrac, this.maxFrac, mathContext, trailingZeroDisplay);
        }

        public FractionRounderImpl(int i, int i2, MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            super(mathContext, trailingZeroDisplay);
            this.minFrac = i;
            this.maxFrac = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class IncrementFiveRounderImpl extends IncrementRounderImpl {
        final int maxFrac;
        final int minFrac;

        public IncrementFiveRounderImpl(BigDecimal bigDecimal, int i, int i2) {
            super(bigDecimal);
            this.minFrac = i;
            this.maxFrac = i2;
        }

        @Override // com.ibm.icu.number.Precision.IncrementRounderImpl, com.ibm.icu.number.Precision
        public void apply(DecimalQuantity decimalQuantity) {
            decimalQuantity.roundToNickel(-this.maxFrac, this.mathContext);
            setResolvedMinFraction(decimalQuantity, this.minFrac);
        }

        @Override // com.ibm.icu.number.Precision.IncrementRounderImpl, com.ibm.icu.number.Precision
        public IncrementFiveRounderImpl createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            return new IncrementFiveRounderImpl(this.increment, this.minFrac, this.maxFrac, mathContext, trailingZeroDisplay);
        }

        public IncrementFiveRounderImpl(BigDecimal bigDecimal, int i, int i2, MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            super(bigDecimal, mathContext, trailingZeroDisplay);
            this.minFrac = i;
            this.maxFrac = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class IncrementOneRounderImpl extends IncrementRounderImpl {
        final int maxFrac;
        final int minFrac;

        public IncrementOneRounderImpl(BigDecimal bigDecimal, int i, int i2) {
            super(bigDecimal);
            this.minFrac = i;
            this.maxFrac = i2;
        }

        @Override // com.ibm.icu.number.Precision.IncrementRounderImpl, com.ibm.icu.number.Precision
        public void apply(DecimalQuantity decimalQuantity) {
            decimalQuantity.roundToMagnitude(-this.maxFrac, this.mathContext);
            setResolvedMinFraction(decimalQuantity, this.minFrac);
        }

        @Override // com.ibm.icu.number.Precision.IncrementRounderImpl, com.ibm.icu.number.Precision
        public IncrementOneRounderImpl createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            return new IncrementOneRounderImpl(this.increment, this.minFrac, this.maxFrac, mathContext, trailingZeroDisplay);
        }

        public IncrementOneRounderImpl(BigDecimal bigDecimal, int i, int i2, MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            super(bigDecimal, mathContext, trailingZeroDisplay);
            this.minFrac = i;
            this.maxFrac = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SignificantRounderImpl extends Precision {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final int maxSig;
        final int minSig;

        public SignificantRounderImpl(int i, int i2) {
            this.minSig = i;
            this.maxSig = i2;
        }

        @Override // com.ibm.icu.number.Precision
        public void apply(DecimalQuantity decimalQuantity) {
            decimalQuantity.roundToMagnitude(Precision.getRoundingMagnitudeSignificant(decimalQuantity, this.maxSig), this.mathContext);
            setResolvedMinFraction(decimalQuantity, Math.max(0, -Precision.getDisplayMagnitudeSignificant(decimalQuantity, this.minSig)));
            if (!decimalQuantity.isZeroish() || this.minSig <= 0) {
                return;
            }
            decimalQuantity.setMinInteger(1);
        }

        @Override // com.ibm.icu.number.Precision
        public SignificantRounderImpl createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            return new SignificantRounderImpl(this.minSig, this.maxSig, mathContext, trailingZeroDisplay);
        }

        public SignificantRounderImpl(int i, int i2, MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            super(mathContext, trailingZeroDisplay);
            this.minSig = i;
            this.maxSig = i2;
        }

        public void apply(DecimalQuantity decimalQuantity, int i) {
            setResolvedMinFraction(decimalQuantity, this.minSig - i);
        }
    }

    public Precision() {
        this(RoundingUtils.DEFAULT_MATH_CONTEXT_UNLIMITED, null);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class FracSigRounderImpl extends Precision {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final int maxFrac;
        final int maxSig;
        final int minFrac;
        final int minSig;
        final NumberFormatter.RoundingPriority priority;
        final boolean retain;

        public FracSigRounderImpl(int i, int i2, int i3, int i4, NumberFormatter.RoundingPriority roundingPriority, boolean z) {
            this.minFrac = i;
            this.maxFrac = i2;
            this.minSig = i3;
            this.maxSig = i4;
            this.priority = roundingPriority;
            this.retain = z;
        }

        @Override // com.ibm.icu.number.Precision
        public void apply(DecimalQuantity decimalQuantity) {
            int roundingMagnitudeFraction = Precision.getRoundingMagnitudeFraction(this.maxFrac);
            int roundingMagnitudeSignificant = Precision.getRoundingMagnitudeSignificant(decimalQuantity, this.maxSig);
            NumberFormatter.RoundingPriority roundingPriority = this.priority;
            NumberFormatter.RoundingPriority roundingPriority2 = NumberFormatter.RoundingPriority.RELAXED;
            int iMin = roundingPriority == roundingPriority2 ? Math.min(roundingMagnitudeFraction, roundingMagnitudeSignificant) : Math.max(roundingMagnitudeFraction, roundingMagnitudeSignificant);
            if (!decimalQuantity.isZeroish()) {
                int magnitude = decimalQuantity.getMagnitude();
                decimalQuantity.roundToMagnitude(iMin, this.mathContext);
                if (!decimalQuantity.isZeroish() && decimalQuantity.getMagnitude() != magnitude && roundingMagnitudeFraction == roundingMagnitudeSignificant) {
                    roundingMagnitudeSignificant++;
                }
            }
            int displayMagnitudeFraction = Precision.getDisplayMagnitudeFraction(this.minFrac);
            int displayMagnitudeSignificant = Precision.getDisplayMagnitudeSignificant(decimalQuantity, this.minSig);
            if (this.retain) {
                displayMagnitudeFraction = Math.min(displayMagnitudeFraction, displayMagnitudeSignificant);
            } else if (this.priority != roundingPriority2 ? roundingMagnitudeSignificant > roundingMagnitudeFraction : roundingMagnitudeSignificant <= roundingMagnitudeFraction) {
                displayMagnitudeFraction = displayMagnitudeSignificant;
            }
            setResolvedMinFraction(decimalQuantity, Math.max(0, -displayMagnitudeFraction));
        }

        @Override // com.ibm.icu.number.Precision
        public FracSigRounderImpl createCopy(MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            return new FracSigRounderImpl(this.minFrac, this.maxFrac, this.minSig, this.maxSig, this.priority, this.retain, mathContext, trailingZeroDisplay);
        }

        public FracSigRounderImpl(int i, int i2, int i3, int i4, NumberFormatter.RoundingPriority roundingPriority, boolean z, MathContext mathContext, NumberFormatter.TrailingZeroDisplay trailingZeroDisplay) {
            super(mathContext, trailingZeroDisplay);
            this.minFrac = i;
            this.maxFrac = i2;
            this.minSig = i3;
            this.maxSig = i4;
            this.priority = roundingPriority;
            this.retain = z;
        }
    }
}
