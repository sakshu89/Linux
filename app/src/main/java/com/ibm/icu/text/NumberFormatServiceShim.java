package com.ibm.icu.text;

import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUService;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ULocale;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class NumberFormatServiceShim extends NumberFormat.NumberFormatShim {
    public static final /* synthetic */ int a = 0;
    private static ICULocaleService service = new NFService();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NFFactory extends ICULocaleService.LocaleKeyFactory {
        private NumberFormat.NumberFormatFactory delegate;

        public NFFactory(NumberFormat.NumberFormatFactory numberFormatFactory) {
            super(numberFormatFactory.visible());
            this.delegate = numberFormatFactory;
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory, com.ibm.icu.impl.ICUService.Factory
        public Object create(ICUService.Key key, ICUService iCUService) {
            if (!handlesKey(key) || !(key instanceof ICULocaleService.LocaleKey)) {
                return null;
            }
            ICULocaleService.LocaleKey localeKey = (ICULocaleService.LocaleKey) key;
            NumberFormat numberFormatCreateFormat = this.delegate.createFormat(localeKey.canonicalLocale(), localeKey.kind());
            return numberFormatCreateFormat == null ? iCUService.getKey(key, null, this) : numberFormatCreateFormat;
        }

        @Override // com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
        public Set<String> getSupportedIDs() {
            return this.delegate.getSupportedLocaleNames();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NFService extends ICULocaleService {
        public NFService() {
            super("NumberFormat");
            registerFactory(new ICULocaleService.ICUResourceBundleFactory() { // from class: com.ibm.icu.text.NumberFormatServiceShim.NFService.1RBNumberFormatFactory
                @Override // com.ibm.icu.impl.ICULocaleService.ICUResourceBundleFactory, com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
                public Object handleCreate(ULocale uLocale, int i, ICUService iCUService) {
                    return NumberFormat.createInstance(uLocale, i);
                }
            });
            markDefault();
        }
    }

    @Override // com.ibm.icu.text.NumberFormat.NumberFormatShim
    public NumberFormat createInstance(ULocale uLocale, int i) {
        ULocale[] uLocaleArr = new ULocale[1];
        NumberFormat numberFormat = (NumberFormat) service.get(uLocale, i, uLocaleArr);
        if (numberFormat == null) {
            throw new MissingResourceException("Unable to construct NumberFormat", "", "");
        }
        NumberFormat numberFormatClone = numberFormat.clone();
        if (i == 1 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9) {
            numberFormatClone.setCurrency(Currency.getInstance(uLocale));
        }
        ULocale uLocale2 = uLocaleArr[0];
        numberFormatClone.setLocale(uLocale2, uLocale2);
        return numberFormatClone;
    }

    @Override // com.ibm.icu.text.NumberFormat.NumberFormatShim
    public Locale[] getAvailableLocales() {
        return service.isDefault() ? ICUResourceBundle.getAvailableLocales() : service.getAvailableLocales();
    }

    @Override // com.ibm.icu.text.NumberFormat.NumberFormatShim
    public ULocale[] getAvailableULocales() {
        return service.isDefault() ? ICUResourceBundle.getAvailableULocales() : service.getAvailableULocales();
    }

    @Override // com.ibm.icu.text.NumberFormat.NumberFormatShim
    public Object registerFactory(NumberFormat.NumberFormatFactory numberFormatFactory) {
        return service.registerFactory(new NFFactory(numberFormatFactory));
    }

    @Override // com.ibm.icu.text.NumberFormat.NumberFormatShim
    public boolean unregister(Object obj) {
        return service.unregisterFactory((ICUService.Factory) obj);
    }
}
