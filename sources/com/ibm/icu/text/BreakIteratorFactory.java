package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUService;
import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class BreakIteratorFactory extends BreakIterator.BreakIteratorServiceShim {
    static final ICULocaleService service = new BFService();
    private static final String[] KIND_NAMES = {"grapheme", "word", "line", "sentence", "title"};

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class BFService extends ICULocaleService {
        public BFService() {
            super("BreakIterator");
            registerFactory(new ICULocaleService.ICUResourceBundleFactory() { // from class: com.ibm.icu.text.BreakIteratorFactory.BFService.1RBBreakIteratorFactory
                @Override // com.ibm.icu.impl.ICULocaleService.ICUResourceBundleFactory, com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
                public Object handleCreate(ULocale uLocale, int i, ICUService iCUService) {
                    return BreakIteratorFactory.createBreakInstance(uLocale, i);
                }
            });
            markDefault();
        }

        @Override // com.ibm.icu.impl.ICULocaleService
        public String validateFallbackLocale() {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x00b2  */
    public static BreakIterator createBreakInstance(ULocale uLocale, int i) {
        String strConcat;
        String str;
        boolean z;
        RuleBasedBreakIterator instanceFromCompiledRules;
        String keywordValue;
        String keywordValue2;
        ICUResourceBundle bundleInstance = ICUResourceBundle.getBundleInstance(ICUData.ICU_BRKITR_BASE_NAME, uLocale, ICUResourceBundle.OpenType.LOCALE_ROOT);
        if (i == 2) {
            String keywordValue3 = uLocale.getKeywordValue("lb");
            strConcat = (keywordValue3 == null || !(keywordValue3.equals("strict") || keywordValue3.equals("normal") || keywordValue3.equals("loose"))) ? "" : BaseLocale.SEP.concat(keywordValue3);
            String language = uLocale.getLanguage();
            if (language != null && ((language.equals("ja") || language.equals("ko")) && (keywordValue2 = uLocale.getKeywordValue("lw")) != null && keywordValue2.equals("phrase"))) {
                strConcat = cq.k(strConcat, BaseLocale.SEP, keywordValue2);
            }
        } else {
            strConcat = "";
        }
        try {
            if (strConcat.isEmpty()) {
                str = KIND_NAMES[i];
            } else {
                str = KIND_NAMES[i] + strConcat;
            }
            String stringWithFallback = bundleInstance.getStringWithFallback("boundaries/" + str);
            ByteBuffer requiredData = ICUBinary.getRequiredData("brkitr/" + stringWithFallback);
            if (stringWithFallback != null) {
                try {
                    if (stringWithFallback.contains("phrase")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    instanceFromCompiledRules = RuleBasedBreakIterator.getInstanceFromCompiledRules(requiredData, z);
                } catch (IOException e) {
                    Assert.fail(e);
                    instanceFromCompiledRules = null;
                }
            } else {
                z = false;
                instanceFromCompiledRules = RuleBasedBreakIterator.getInstanceFromCompiledRules(requiredData, z);
            }
            ULocale uLocaleForLocale = ULocale.forLocale(bundleInstance.getLocale());
            instanceFromCompiledRules.setLocale(uLocaleForLocale, uLocaleForLocale);
            return (i == 3 && (keywordValue = uLocale.getKeywordValue("ss")) != null && keywordValue.equals("standard")) ? FilteredBreakIteratorBuilder.getInstance(new ULocale(uLocale.getBaseName())).wrapIteratorWithFilter(instanceFromCompiledRules) : instanceFromCompiledRules;
        } catch (Exception e2) {
            throw new MissingResourceException(e2.toString(), "", "");
        }
    }

    @Override // com.ibm.icu.text.BreakIterator.BreakIteratorServiceShim
    public BreakIterator createBreakIterator(ULocale uLocale, int i) {
        ICULocaleService iCULocaleService = service;
        if (iCULocaleService.isDefault()) {
            return createBreakInstance(uLocale, i);
        }
        ULocale[] uLocaleArr = new ULocale[1];
        BreakIterator breakIterator = (BreakIterator) iCULocaleService.get(uLocale, i, uLocaleArr);
        ULocale uLocale2 = uLocaleArr[0];
        breakIterator.setLocale(uLocale2, uLocale2);
        return breakIterator;
    }

    @Override // com.ibm.icu.text.BreakIterator.BreakIteratorServiceShim
    public Locale[] getAvailableLocales() {
        ICULocaleService iCULocaleService = service;
        return iCULocaleService == null ? ICUResourceBundle.getAvailableLocales() : iCULocaleService.getAvailableLocales();
    }

    @Override // com.ibm.icu.text.BreakIterator.BreakIteratorServiceShim
    public ULocale[] getAvailableULocales() {
        ICULocaleService iCULocaleService = service;
        return iCULocaleService == null ? ICUResourceBundle.getAvailableULocales() : iCULocaleService.getAvailableULocales();
    }

    @Override // com.ibm.icu.text.BreakIterator.BreakIteratorServiceShim
    public Object registerInstance(BreakIterator breakIterator, ULocale uLocale, int i) {
        breakIterator.setText(new java.text.StringCharacterIterator(""));
        return service.registerObject(breakIterator, uLocale, i);
    }

    @Override // com.ibm.icu.text.BreakIterator.BreakIteratorServiceShim
    public boolean unregister(Object obj) {
        ICULocaleService iCULocaleService = service;
        if (iCULocaleService.isDefault()) {
            return false;
        }
        return iCULocaleService.unregisterFactory((ICUService.Factory) obj);
    }
}
