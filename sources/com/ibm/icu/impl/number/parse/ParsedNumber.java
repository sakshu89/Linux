package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StringSegment;
import com.ibm.icu.impl.number.DecimalQuantity_DualStorageBCD;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ParsedNumber {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Comparator<ParsedNumber> COMPARATOR = new Comparator<ParsedNumber>() { // from class: com.ibm.icu.impl.number.parse.ParsedNumber.1
        @Override // java.util.Comparator
        public int compare(ParsedNumber parsedNumber, ParsedNumber parsedNumber2) {
            return parsedNumber.charEnd - parsedNumber2.charEnd;
        }
    };
    public static final int FLAG_FAIL = 256;
    public static final int FLAG_HAS_DECIMAL_SEPARATOR = 32;
    public static final int FLAG_HAS_EXPONENT = 8;
    public static final int FLAG_INFINITY = 128;
    public static final int FLAG_NAN = 64;
    public static final int FLAG_NEGATIVE = 1;
    public static final int FLAG_PERCENT = 2;
    public static final int FLAG_PERMILLE = 4;
    public int charEnd;
    public String currencyCode;
    public int flags;
    public String prefix;
    public DecimalQuantity_DualStorageBCD quantity;
    public String suffix;

    public ParsedNumber() {
        clear();
    }

    public void clear() {
        this.quantity = null;
        this.charEnd = 0;
        this.flags = 0;
        this.prefix = null;
        this.suffix = null;
        this.currencyCode = null;
    }

    public void copyFrom(ParsedNumber parsedNumber) {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = parsedNumber.quantity;
        this.quantity = decimalQuantity_DualStorageBCD == null ? null : (DecimalQuantity_DualStorageBCD) decimalQuantity_DualStorageBCD.createCopy();
        this.charEnd = parsedNumber.charEnd;
        this.flags = parsedNumber.flags;
        this.prefix = parsedNumber.prefix;
        this.suffix = parsedNumber.suffix;
        this.currencyCode = parsedNumber.currencyCode;
    }

    public Number getNumber(int i) {
        int i2 = this.flags;
        boolean z = (i2 & 64) != 0;
        boolean z2 = (i2 & 128) != 0;
        boolean z3 = (i & 4096) != 0;
        boolean z4 = (i & 16) != 0;
        if (z) {
            return Double.valueOf(Double.NaN);
        }
        if (z2) {
            return (i2 & 1) != 0 ? Double.valueOf(Double.NEGATIVE_INFINITY) : Double.valueOf(Double.POSITIVE_INFINITY);
        }
        if (this.quantity.isZeroish() && this.quantity.isNegative() && !z4) {
            return Double.valueOf(-0.0d);
        }
        return (!this.quantity.fitsInLong() || z3) ? this.quantity.toBigDecimal() : Long.valueOf(this.quantity.toLong(false));
    }

    public boolean isBetterThan(ParsedNumber parsedNumber) {
        return COMPARATOR.compare(this, parsedNumber) > 0;
    }

    public void postProcess() {
        DecimalQuantity_DualStorageBCD decimalQuantity_DualStorageBCD = this.quantity;
        if (decimalQuantity_DualStorageBCD == null || (this.flags & 1) == 0) {
            return;
        }
        decimalQuantity_DualStorageBCD.negate();
    }

    public boolean seenNumber() {
        if (this.quantity != null) {
            return true;
        }
        int i = this.flags;
        return ((i & 64) == 0 && (i & 128) == 0) ? false : true;
    }

    public void setCharsConsumed(StringSegment stringSegment) {
        this.charEnd = stringSegment.getOffset();
    }

    public boolean success() {
        return this.charEnd > 0 && (this.flags & 256) == 0;
    }

    public Number getNumber() {
        return getNumber(0);
    }
}
