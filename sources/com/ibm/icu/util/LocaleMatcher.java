package com.ibm.icu.util;

import com.ibm.icu.impl.locale.LSR;
import com.ibm.icu.impl.locale.LikelySubtags;
import com.ibm.icu.impl.locale.LocaleDistance;
import defpackage.og;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class LocaleMatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean TRACE_MATCHER = false;
    private final Locale defaultLocale;
    private final ULocale defaultULocale;
    private final int demotionPerDesiredLocale;
    private final Direction direction;
    private final FavorSubtag favorSubtag;
    private final int[] supportedIndexes;
    private final LSR[] supportedLSRs;
    private final int supportedLSRsLength;
    private final Locale[] supportedLocales;
    private final Map<LSR, Integer> supportedLsrToIndex;
    private final ULocale[] supportedULocales;
    private final int thresholdDistance;
    private static final LSR UND_LSR = new LSR("und", "", "", 7);
    private static final ULocale UND_ULOCALE = new ULocale("und");
    private static final Locale UND_LOCALE = new Locale("und");
    private static final Locale EMPTY_LOCALE = new Locale("");

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Demotion {
        NONE,
        REGION
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Direction {
        WITH_ONE_WAY,
        ONLY_TWO_WAY
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum FavorSubtag {
        LANGUAGE,
        SCRIPT
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class LocaleLsrIterator extends LsrIterator {
        private Locale current;
        private Iterator<Locale> locales;
        private Locale remembered;

        public LocaleLsrIterator(Iterator<Locale> it) {
            super(0);
            this.locales = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.locales.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public LSR next() {
            Locale next = this.locales.next();
            this.current = next;
            return LocaleMatcher.getMaximalLsrOrUnd(next);
        }

        @Override // com.ibm.icu.util.LocaleMatcher.LsrIterator
        public void rememberCurrent(int i) {
            this.bestDesiredIndex = i;
            this.remembered = this.current;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ULocaleLsrIterator extends LsrIterator {
        private ULocale current;
        private Iterator<ULocale> locales;
        private ULocale remembered;

        public ULocaleLsrIterator(Iterator<ULocale> it) {
            super(0);
            this.locales = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.locales.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public LSR next() {
            ULocale next = this.locales.next();
            this.current = next;
            return LocaleMatcher.getMaximalLsrOrUnd(next);
        }

        @Override // com.ibm.icu.util.LocaleMatcher.LsrIterator
        public void rememberCurrent(int i) {
            this.bestDesiredIndex = i;
            this.remembered = this.current;
        }
    }

    private LocaleMatcher(Builder builder) {
        Locale locale;
        LSR maximalLsrOrUnd;
        ULocale uLocale = builder.defaultLocale;
        if (uLocale != null) {
            locale = uLocale.toLocale();
            maximalLsrOrUnd = getMaximalLsrOrUnd(uLocale);
        } else {
            locale = null;
            maximalLsrOrUnd = null;
        }
        int i = 0;
        int size = builder.supportedLocales != null ? builder.supportedLocales.size() : 0;
        this.supportedULocales = new ULocale[size];
        this.supportedLocales = new Locale[size];
        LSR[] lsrArr = new LSR[size];
        if (size > 0) {
            int i2 = 0;
            for (ULocale uLocale2 : builder.supportedLocales) {
                this.supportedULocales[i2] = uLocale2;
                this.supportedLocales[i2] = uLocale2.toLocale();
                lsrArr[i2] = getMaximalLsrOrUnd(uLocale2);
                i2++;
            }
        }
        this.supportedLsrToIndex = new HashMap(size);
        this.supportedLSRs = new LSR[size];
        this.supportedIndexes = new int[size];
        byte[] bArr = new byte[size];
        ULocale[] uLocaleArr = this.supportedULocales;
        int length = uLocaleArr.length;
        int i3 = 0;
        int iPutIfAbsent = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            ULocale uLocale3 = uLocaleArr[i3];
            LSR lsr = lsrArr[i5];
            if (maximalLsrOrUnd == null && builder.withDefault) {
                Locale locale2 = this.supportedLocales[i];
                iPutIfAbsent = putIfAbsent(lsr, i, iPutIfAbsent);
                locale = locale2;
                maximalLsrOrUnd = lsr;
                uLocale = uLocale3;
            } else if (maximalLsrOrUnd != null && lsr.isEquivalentTo(maximalLsrOrUnd)) {
                iPutIfAbsent = putIfAbsent(lsr, i5, iPutIfAbsent);
            } else if (LocaleDistance.INSTANCE.isParadigmLSR(lsr)) {
                bArr[i5] = 2;
                i4++;
            } else {
                bArr[i5] = 3;
            }
            i5++;
            i3++;
            i = 0;
        }
        byte b = 3;
        int i6 = i4 + iPutIfAbsent;
        for (int i7 = 0; i7 < size && iPutIfAbsent < i6; i7++) {
            if (bArr[i7] == 2) {
                iPutIfAbsent = putIfAbsent(lsrArr[i7], i7, iPutIfAbsent);
            }
        }
        int i8 = 0;
        while (i8 < size) {
            byte b2 = b;
            if (bArr[i8] == b2) {
                iPutIfAbsent = putIfAbsent(lsrArr[i8], i8, iPutIfAbsent);
            }
            i8++;
            b = b2;
        }
        this.supportedLSRsLength = iPutIfAbsent;
        this.defaultULocale = uLocale;
        this.defaultLocale = locale;
        this.demotionPerDesiredLocale = builder.demotion == Demotion.NONE ? 0 : LocaleDistance.INSTANCE.getDefaultDemotionPerDesiredLocale();
        FavorSubtag favorSubtag = builder.favor;
        this.favorSubtag = favorSubtag;
        Direction direction = builder.direction;
        this.direction = direction;
        this.thresholdDistance = builder.thresholdDistance >= 0 ? builder.thresholdDistance : builder.maxDistanceDesired != null ? LocaleDistance.getDistanceFloor(LocaleDistance.INSTANCE.getBestIndexAndDistance(getMaximalLsrOrUnd(builder.maxDistanceDesired), new LSR[]{getMaximalLsrOrUnd(builder.maxDistanceSupported)}, 1, LocaleDistance.shiftDistance(100), favorSubtag, direction)) + 1 : LocaleDistance.INSTANCE.getDefaultScriptDistance();
    }

    public static Builder builder() {
        return new Builder(0);
    }

    private Result defaultResult() {
        return new Result(null, this.defaultULocale, null, this.defaultLocale, -1, -1, 0);
    }

    private int getBestSuppIndex(LSR lsr, LsrIterator lsrIterator) {
        int i = 0;
        LSR next = lsr;
        int iShiftDistance = LocaleDistance.shiftDistance(this.thresholdDistance);
        int index = -1;
        while (true) {
            Integer num = this.supportedLsrToIndex.get(next);
            if (num != null) {
                int iIntValue = num.intValue();
                if (lsrIterator != null) {
                    lsrIterator.rememberCurrent(i);
                }
                return iIntValue;
            }
            int bestIndexAndDistance = LocaleDistance.INSTANCE.getBestIndexAndDistance(next, this.supportedLSRs, this.supportedLSRsLength, iShiftDistance, this.favorSubtag, this.direction);
            if (bestIndexAndDistance >= 0) {
                iShiftDistance = LocaleDistance.getShiftedDistance(bestIndexAndDistance);
                if (lsrIterator != null) {
                    lsrIterator.rememberCurrent(i);
                }
                index = LocaleDistance.getIndex(bestIndexAndDistance);
            }
            iShiftDistance -= LocaleDistance.shiftDistance(this.demotionPerDesiredLocale);
            if (iShiftDistance <= 0 || lsrIterator == null || !lsrIterator.hasNext()) {
                if (index < 0) {
                    return -1;
                }
                return this.supportedIndexes[index];
            }
            next = lsrIterator.next();
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LSR getMaximalLsrOrUnd(Locale locale) {
        return (locale.equals(UND_LOCALE) || locale.equals(EMPTY_LOCALE)) ? UND_LSR : LikelySubtags.INSTANCE.makeMaximizedLsrFrom(locale);
    }

    private Result makeResult(ULocale uLocale, ULocaleLsrIterator uLocaleLsrIterator, int i) {
        if (i < 0) {
            return defaultResult();
        }
        if (uLocale != null) {
            return new Result(uLocale, this.supportedULocales[i], null, this.supportedLocales[i], 0, i, 0);
        }
        return new Result(uLocaleLsrIterator.remembered, this.supportedULocales[i], null, this.supportedLocales[i], uLocaleLsrIterator.bestDesiredIndex, i, 0);
    }

    private final int putIfAbsent(LSR lsr, int i, int i2) {
        if (this.supportedLsrToIndex.containsKey(lsr)) {
            return i2;
        }
        this.supportedLsrToIndex.put(lsr, Integer.valueOf(i));
        this.supportedLSRs[i2] = lsr;
        int i3 = i2 + 1;
        this.supportedIndexes[i2] = i;
        return i3;
    }

    public ULocale canonicalize(ULocale uLocale) {
        return LikelySubtags.INSTANCE.canonicalize(uLocale);
    }

    public Locale getBestLocale(Iterable<Locale> iterable) {
        Iterator<Locale> it = iterable.iterator();
        if (!it.hasNext()) {
            return this.defaultLocale;
        }
        LocaleLsrIterator localeLsrIterator = new LocaleLsrIterator(it);
        int bestSuppIndex = getBestSuppIndex(localeLsrIterator.next(), localeLsrIterator);
        return bestSuppIndex >= 0 ? this.supportedLocales[bestSuppIndex] : this.defaultLocale;
    }

    public Result getBestLocaleResult(Iterable<Locale> iterable) {
        Iterator<Locale> it = iterable.iterator();
        if (!it.hasNext()) {
            return defaultResult();
        }
        LocaleLsrIterator localeLsrIterator = new LocaleLsrIterator(it);
        return makeResult((Locale) null, localeLsrIterator, getBestSuppIndex(localeLsrIterator.next(), localeLsrIterator));
    }

    public ULocale getBestMatch(Iterable<ULocale> iterable) {
        Iterator<ULocale> it = iterable.iterator();
        if (!it.hasNext()) {
            return this.defaultULocale;
        }
        ULocaleLsrIterator uLocaleLsrIterator = new ULocaleLsrIterator(it);
        int bestSuppIndex = getBestSuppIndex(uLocaleLsrIterator.next(), uLocaleLsrIterator);
        return bestSuppIndex >= 0 ? this.supportedULocales[bestSuppIndex] : this.defaultULocale;
    }

    public Result getBestMatchResult(Iterable<ULocale> iterable) {
        Iterator<ULocale> it = iterable.iterator();
        if (!it.hasNext()) {
            return defaultResult();
        }
        ULocaleLsrIterator uLocaleLsrIterator = new ULocaleLsrIterator(it);
        return makeResult((ULocale) null, uLocaleLsrIterator, getBestSuppIndex(uLocaleLsrIterator.next(), uLocaleLsrIterator));
    }

    public boolean isMatch(Locale locale, Locale locale2) {
        return LocaleDistance.INSTANCE.getBestIndexAndDistance(getMaximalLsrOrUnd(locale), new LSR[]{getMaximalLsrOrUnd(locale2)}, 1, LocaleDistance.shiftDistance(this.thresholdDistance), this.favorSubtag, this.direction) >= 0;
    }

    @Deprecated
    public double match(ULocale uLocale, ULocale uLocale2, ULocale uLocale3, ULocale uLocale4) {
        return (100.0d - LocaleDistance.getDistanceDouble(LocaleDistance.INSTANCE.getBestIndexAndDistance(getMaximalLsrOrUnd(uLocale), new LSR[]{getMaximalLsrOrUnd(uLocale3)}, 1, LocaleDistance.shiftDistance(this.thresholdDistance), this.favorSubtag, this.direction))) / 100.0d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{LocaleMatcher");
        if (this.supportedLSRsLength > 0) {
            sb.append(" supportedLSRs={");
            sb.append(this.supportedLSRs[0]);
            for (int i = 1; i < this.supportedLSRsLength; i++) {
                sb.append(", ");
                sb.append(this.supportedLSRs[i]);
            }
            sb.append('}');
        }
        sb.append(" default=");
        sb.append(this.defaultULocale);
        if (this.favorSubtag != null) {
            sb.append(" favor=");
            sb.append(this.favorSubtag);
        }
        if (this.direction != null) {
            sb.append(" direction=");
            sb.append(this.direction);
        }
        int i2 = this.thresholdDistance;
        if (i2 >= 0) {
            sb.append(String.format(" threshold=%d", Integer.valueOf(i2)));
        }
        sb.append(String.format(" demotion=%d", Integer.valueOf(this.demotionPerDesiredLocale)));
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class LsrIterator implements Iterator<LSR> {
        int bestDesiredIndex;

        private LsrIterator() {
            this.bestDesiredIndex = -1;
        }

        public abstract void rememberCurrent(int i);

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ LsrIterator(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Builder {
        private ULocale defaultLocale;
        private Demotion demotion;
        private Direction direction;
        private FavorSubtag favor;
        private ULocale maxDistanceDesired;
        private ULocale maxDistanceSupported;
        private List<ULocale> supportedLocales;
        private int thresholdDistance;
        private boolean withDefault;

        private Builder() {
            this.thresholdDistance = -1;
            this.withDefault = true;
        }

        public Builder addSupportedLocale(Locale locale) {
            return addSupportedULocale(ULocale.forLocale(locale));
        }

        public Builder addSupportedULocale(ULocale uLocale) {
            if (this.supportedLocales == null) {
                this.supportedLocales = new ArrayList();
            }
            this.supportedLocales.add(uLocale);
            return this;
        }

        public LocaleMatcher build() {
            return new LocaleMatcher(this, 0);
        }

        @Deprecated
        public Builder internalSetThresholdDistance(int i) {
            if (i > 100) {
                i = 100;
            }
            this.thresholdDistance = i;
            return this;
        }

        public Builder setDefaultLocale(Locale locale) {
            this.defaultLocale = ULocale.forLocale(locale);
            this.withDefault = true;
            return this;
        }

        public Builder setDefaultULocale(ULocale uLocale) {
            this.defaultLocale = uLocale;
            this.withDefault = true;
            return this;
        }

        public Builder setDemotionPerDesiredLocale(Demotion demotion) {
            this.demotion = demotion;
            return this;
        }

        public Builder setDirection(Direction direction) {
            this.direction = direction;
            return this;
        }

        public Builder setFavorSubtag(FavorSubtag favorSubtag) {
            this.favor = favorSubtag;
            return this;
        }

        public Builder setMaxDistance(Locale locale, Locale locale2) {
            if (locale != null && locale2 != null) {
                return setMaxDistance(ULocale.forLocale(locale), ULocale.forLocale(locale2));
            }
            og.i("desired/supported locales must not be null");
            return null;
        }

        public Builder setNoDefaultLocale() {
            this.defaultLocale = null;
            this.withDefault = false;
            return this;
        }

        public Builder setSupportedLocales(Collection<Locale> collection) {
            this.supportedLocales = new ArrayList(collection.size());
            Iterator<Locale> it = collection.iterator();
            while (it.hasNext()) {
                this.supportedLocales.add(ULocale.forLocale(it.next()));
            }
            return this;
        }

        public Builder setSupportedULocales(Collection<ULocale> collection) {
            this.supportedLocales = new ArrayList(collection);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{LocaleMatcher.Builder");
            List<ULocale> list = this.supportedLocales;
            if (list != null && !list.isEmpty()) {
                sb.append(" supported={");
                sb.append(this.supportedLocales);
                sb.append('}');
            }
            if (this.defaultLocale != null) {
                sb.append(" default=");
                sb.append(this.defaultLocale);
            }
            if (this.favor != null) {
                sb.append(" distance=");
                sb.append(this.favor);
            }
            int i = this.thresholdDistance;
            if (i >= 0) {
                sb.append(String.format(" threshold=%d", Integer.valueOf(i)));
            }
            if (this.demotion != null) {
                sb.append(" demotion=");
                sb.append(this.demotion);
            }
            sb.append('}');
            return sb.toString();
        }

        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder setMaxDistance(ULocale uLocale, ULocale uLocale2) {
            if (uLocale != null && uLocale2 != null) {
                this.maxDistanceDesired = uLocale;
                this.maxDistanceSupported = uLocale2;
                return this;
            }
            og.i("desired/supported locales must not be null");
            return null;
        }

        public Builder setSupportedLocales(String str) {
            return setSupportedULocales(LocalePriorityList.add(str).build().getULocales());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Result {
        private final int desiredIndex;
        private final Locale desiredLocale;
        private final ULocale desiredULocale;
        private final int supportedIndex;
        private final Locale supportedLocale;
        private final ULocale supportedULocale;

        private Result(ULocale uLocale, ULocale uLocale2, Locale locale, Locale locale2, int i, int i2) {
            this.desiredULocale = uLocale;
            this.supportedULocale = uLocale2;
            this.desiredLocale = locale;
            this.supportedLocale = locale2;
            this.desiredIndex = i;
            this.supportedIndex = i2;
        }

        public int getDesiredIndex() {
            return this.desiredIndex;
        }

        public Locale getDesiredLocale() {
            ULocale uLocale;
            Locale locale = this.desiredLocale;
            return (locale != null || (uLocale = this.desiredULocale) == null) ? locale : uLocale.toLocale();
        }

        public ULocale getDesiredULocale() {
            Locale locale;
            ULocale uLocale = this.desiredULocale;
            return (uLocale != null || (locale = this.desiredLocale) == null) ? uLocale : ULocale.forLocale(locale);
        }

        public int getSupportedIndex() {
            return this.supportedIndex;
        }

        public Locale getSupportedLocale() {
            return this.supportedLocale;
        }

        public ULocale getSupportedULocale() {
            return this.supportedULocale;
        }

        public Locale makeResolvedLocale() {
            ULocale uLocaleMakeResolvedULocale = makeResolvedULocale();
            if (uLocaleMakeResolvedULocale != null) {
                return uLocaleMakeResolvedULocale.toLocale();
            }
            return null;
        }

        public ULocale makeResolvedULocale() {
            ULocale desiredULocale = getDesiredULocale();
            ULocale uLocale = this.supportedULocale;
            if (uLocale == null || desiredULocale == null || uLocale.equals(desiredULocale)) {
                return this.supportedULocale;
            }
            ULocale.Builder locale = new ULocale.Builder().setLocale(this.supportedULocale);
            String country = desiredULocale.getCountry();
            if (!country.isEmpty()) {
                locale.setRegion(country);
            }
            String variant = desiredULocale.getVariant();
            if (!variant.isEmpty()) {
                locale.setVariant(variant);
            }
            Iterator<Character> it = desiredULocale.getExtensionKeys().iterator();
            while (it.hasNext()) {
                char cCharValue = it.next().charValue();
                locale.setExtension(cCharValue, desiredULocale.getExtension(cCharValue));
            }
            return locale.build();
        }

        public /* synthetic */ Result(ULocale uLocale, ULocale uLocale2, Locale locale, Locale locale2, int i, int i2, int i3) {
            this(uLocale, uLocale2, locale, locale2, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LSR getMaximalLsrOrUnd(ULocale uLocale) {
        if (uLocale.equals(UND_ULOCALE)) {
            return UND_LSR;
        }
        return LikelySubtags.INSTANCE.makeMaximizedLsrFrom(uLocale, false);
    }

    public Result getBestLocaleResult(Locale locale) {
        return makeResult(locale, (LocaleLsrIterator) null, getBestSuppIndex(getMaximalLsrOrUnd(locale), null));
    }

    public Result getBestMatchResult(ULocale uLocale) {
        return makeResult(uLocale, (ULocaleLsrIterator) null, getBestSuppIndex(getMaximalLsrOrUnd(uLocale), null));
    }

    public boolean isMatch(ULocale uLocale, ULocale uLocale2) {
        return LocaleDistance.INSTANCE.getBestIndexAndDistance(getMaximalLsrOrUnd(uLocale), new LSR[]{getMaximalLsrOrUnd(uLocale2)}, 1, LocaleDistance.shiftDistance(this.thresholdDistance), this.favorSubtag, this.direction) >= 0;
    }

    public Locale getBestLocale(Locale locale) {
        int bestSuppIndex = getBestSuppIndex(getMaximalLsrOrUnd(locale), null);
        return bestSuppIndex >= 0 ? this.supportedLocales[bestSuppIndex] : this.defaultLocale;
    }

    public ULocale getBestMatch(ULocale uLocale) {
        int bestSuppIndex = getBestSuppIndex(getMaximalLsrOrUnd(uLocale), null);
        return bestSuppIndex >= 0 ? this.supportedULocales[bestSuppIndex] : this.defaultULocale;
    }

    public ULocale getBestMatch(String str) {
        return getBestMatch(LocalePriorityList.add(str).build());
    }

    private Result makeResult(Locale locale, LocaleLsrIterator localeLsrIterator, int i) {
        if (i < 0) {
            return defaultResult();
        }
        ULocale[] uLocaleArr = this.supportedULocales;
        if (locale != null) {
            return new Result(null, uLocaleArr[i], locale, this.supportedLocales[i], 0, i, 0);
        }
        return new Result(null, uLocaleArr[i], localeLsrIterator.remembered, this.supportedLocales[i], localeLsrIterator.bestDesiredIndex, i, 0);
    }

    public LocaleMatcher(LocalePriorityList localePriorityList) {
        this(builder().setSupportedULocales(localePriorityList.getULocales()));
    }

    public LocaleMatcher(String str) {
        this(builder().setSupportedLocales(str));
    }

    public /* synthetic */ LocaleMatcher(Builder builder, int i) {
        this(builder);
    }
}
