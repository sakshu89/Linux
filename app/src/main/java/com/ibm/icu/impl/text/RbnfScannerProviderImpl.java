package com.ibm.icu.impl.text;

import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.text.CollationElementIterator;
import com.ibm.icu.text.Collator;
import com.ibm.icu.text.RbnfLenientScanner;
import com.ibm.icu.text.RbnfLenientScannerProvider;
import com.ibm.icu.text.RuleBasedCollator;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RbnfScannerProviderImpl implements RbnfLenientScannerProvider {
    private static final boolean DEBUG = ICUDebug.enabled("rbnf");
    public static final /* synthetic */ int a = 0;
    private final ConcurrentHashMap<String, RbnfLenientScanner> cache = new ConcurrentHashMap<>();

    @Deprecated
    public RbnfScannerProviderImpl() {
    }

    @Deprecated
    public RbnfLenientScanner createScanner(ULocale uLocale, String str) {
        RuleBasedCollator ruleBasedCollator;
        try {
            ruleBasedCollator = (RuleBasedCollator) Collator.getInstance(uLocale.toLocale());
            if (str != null) {
                ruleBasedCollator = new RuleBasedCollator(ruleBasedCollator.getRules() + str);
            }
            ruleBasedCollator.setDecomposition(17);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                System.out.println("++++");
            }
            ruleBasedCollator = null;
        }
        return new RbnfLenientScannerImpl(ruleBasedCollator, 0);
    }

    @Override // com.ibm.icu.text.RbnfLenientScannerProvider
    @Deprecated
    public RbnfLenientScanner get(ULocale uLocale, String str) {
        String strK = cq.k(uLocale.toString(), "/", str);
        RbnfLenientScanner rbnfLenientScanner = this.cache.get(strK);
        if (rbnfLenientScanner != null) {
            return rbnfLenientScanner;
        }
        RbnfLenientScanner rbnfLenientScannerCreateScanner = createScanner(uLocale, str);
        RbnfLenientScanner rbnfLenientScannerPutIfAbsent = this.cache.putIfAbsent(strK, rbnfLenientScannerCreateScanner);
        return rbnfLenientScannerPutIfAbsent != null ? rbnfLenientScannerPutIfAbsent : rbnfLenientScannerCreateScanner;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RbnfLenientScannerImpl implements RbnfLenientScanner {
        private final RuleBasedCollator collator;

        private RbnfLenientScannerImpl(RuleBasedCollator ruleBasedCollator) {
            this.collator = ruleBasedCollator;
        }

        @Override // com.ibm.icu.text.RbnfLenientScanner
        public boolean allIgnorable(String str) {
            CollationElementIterator collationElementIterator = this.collator.getCollationElementIterator(str);
            int next = collationElementIterator.next();
            while (next != -1 && CollationElementIterator.primaryOrder(next) == 0) {
                next = collationElementIterator.next();
            }
            return next == -1;
        }

        @Override // com.ibm.icu.text.RbnfLenientScanner
        public int[] findText(String str, String str2, int i) {
            int iPrefixLength = 0;
            while (i < str.length() && iPrefixLength == 0) {
                iPrefixLength = prefixLength(str.substring(i), str2);
                if (iPrefixLength != 0) {
                    return new int[]{i, iPrefixLength};
                }
                i++;
            }
            return new int[]{-1, 0};
        }

        public int[] findText2(String str, String str2, int i) {
            int offset;
            CollationElementIterator collationElementIterator = this.collator.getCollationElementIterator(str);
            CollationElementIterator collationElementIterator2 = this.collator.getCollationElementIterator(str2);
            collationElementIterator.setOffset(i);
            int next = collationElementIterator.next();
            int next2 = collationElementIterator2.next();
            loop0: while (true) {
                offset = -1;
                while (true) {
                    if (next2 == -1) {
                        break loop0;
                    }
                    while (next != -1 && CollationElementIterator.primaryOrder(next) == 0) {
                        next = collationElementIterator.next();
                    }
                    while (next2 != -1 && CollationElementIterator.primaryOrder(next2) == 0) {
                        next2 = collationElementIterator2.next();
                    }
                    if (next == -1) {
                        return new int[]{-1, 0};
                    }
                    if (next2 == -1) {
                        break loop0;
                    }
                    if (CollationElementIterator.primaryOrder(next) == CollationElementIterator.primaryOrder(next2)) {
                        offset = collationElementIterator.getOffset();
                        next = collationElementIterator.next();
                        next2 = collationElementIterator2.next();
                    } else {
                        if (offset != -1) {
                            break;
                        }
                        next = collationElementIterator.next();
                    }
                }
                collationElementIterator2.reset();
            }
            return new int[]{offset, collationElementIterator.getOffset() - offset};
        }

        @Override // com.ibm.icu.text.RbnfLenientScanner
        public int prefixLength(String str, String str2) {
            CollationElementIterator collationElementIterator = this.collator.getCollationElementIterator(str);
            CollationElementIterator collationElementIterator2 = this.collator.getCollationElementIterator(str2);
            int next = collationElementIterator.next();
            int next2 = collationElementIterator2.next();
            while (next2 != -1) {
                while (CollationElementIterator.primaryOrder(next) == 0 && next != -1) {
                    next = collationElementIterator.next();
                }
                while (CollationElementIterator.primaryOrder(next2) == 0 && next2 != -1) {
                    next2 = collationElementIterator2.next();
                }
                if (next2 == -1) {
                    break;
                }
                if (next == -1 || CollationElementIterator.primaryOrder(next) != CollationElementIterator.primaryOrder(next2)) {
                    return 0;
                }
                next = collationElementIterator.next();
                next2 = collationElementIterator2.next();
            }
            int offset = collationElementIterator.getOffset();
            return next != -1 ? offset - 1 : offset;
        }

        public /* synthetic */ RbnfLenientScannerImpl(RuleBasedCollator ruleBasedCollator, int i) {
            this(ruleBasedCollator);
        }
    }
}
