package com.ibm.icu.util;

import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUService;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class CurrencyServiceShim extends Currency.ServiceShim {
    static final ICULocaleService service = new CFService();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CFService extends ICULocaleService {
        public CFService() {
            super("Currency");
            registerFactory(new ICULocaleService.ICUResourceBundleFactory() { // from class: com.ibm.icu.util.CurrencyServiceShim.CFService.1CurrencyFactory
                @Override // com.ibm.icu.impl.ICULocaleService.ICUResourceBundleFactory, com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
                public Object handleCreate(ULocale uLocale, int i, ICUService iCUService) {
                    return Currency.createCurrency(uLocale);
                }
            });
            markDefault();
        }
    }

    @Override // com.ibm.icu.util.Currency.ServiceShim
    public Currency createInstance(ULocale uLocale) {
        ICULocaleService iCULocaleService = service;
        return iCULocaleService.isDefault() ? Currency.createCurrency(uLocale) : (Currency) iCULocaleService.get(uLocale);
    }

    @Override // com.ibm.icu.util.Currency.ServiceShim
    public Locale[] getAvailableLocales() {
        ICULocaleService iCULocaleService = service;
        return iCULocaleService.isDefault() ? ICUResourceBundle.getAvailableLocales() : iCULocaleService.getAvailableLocales();
    }

    @Override // com.ibm.icu.util.Currency.ServiceShim
    public ULocale[] getAvailableULocales() {
        ICULocaleService iCULocaleService = service;
        return iCULocaleService.isDefault() ? ICUResourceBundle.getAvailableULocales() : iCULocaleService.getAvailableULocales();
    }

    @Override // com.ibm.icu.util.Currency.ServiceShim
    public Object registerInstance(Currency currency, ULocale uLocale) {
        return service.registerObject(currency, uLocale);
    }

    @Override // com.ibm.icu.util.Currency.ServiceShim
    public boolean unregister(Object obj) {
        return service.unregisterFactory((ICUService.Factory) obj);
    }
}
