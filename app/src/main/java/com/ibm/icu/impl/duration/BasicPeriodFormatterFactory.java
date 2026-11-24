package com.ibm.icu.impl.duration;

import com.ibm.icu.impl.duration.impl.PeriodFormatterData;
import com.ibm.icu.impl.duration.impl.PeriodFormatterDataService;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class BasicPeriodFormatterFactory implements PeriodFormatterFactory {
    private boolean customizationsInUse;
    private PeriodFormatterData data;
    private final PeriodFormatterDataService ds;
    private Customizations customizations = new Customizations();
    private String localeName = Locale.getDefault().toString();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Customizations {
        boolean displayLimit = true;
        boolean displayDirection = true;
        byte separatorVariant = 2;
        byte unitVariant = 0;
        byte countVariant = 0;

        public Customizations copy() {
            Customizations customizations = new Customizations();
            customizations.displayLimit = this.displayLimit;
            customizations.displayDirection = this.displayDirection;
            customizations.separatorVariant = this.separatorVariant;
            customizations.unitVariant = this.unitVariant;
            customizations.countVariant = this.countVariant;
            return customizations;
        }
    }

    public BasicPeriodFormatterFactory(PeriodFormatterDataService periodFormatterDataService) {
        this.ds = periodFormatterDataService;
    }

    public static BasicPeriodFormatterFactory getDefault() {
        return (BasicPeriodFormatterFactory) BasicPeriodFormatterService.getInstance().newPeriodFormatterFactory();
    }

    private Customizations updateCustomizations() {
        if (this.customizationsInUse) {
            this.customizations = this.customizations.copy();
            this.customizationsInUse = false;
        }
        return this.customizations;
    }

    public int getCountVariant() {
        return this.customizations.countVariant;
    }

    public PeriodFormatterData getData() {
        if (this.data == null) {
            this.data = this.ds.get(this.localeName);
        }
        return this.data;
    }

    public boolean getDisplayLimit() {
        return this.customizations.displayLimit;
    }

    public boolean getDisplayPastFuture() {
        return this.customizations.displayDirection;
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterFactory
    public PeriodFormatter getFormatter() {
        this.customizationsInUse = true;
        return new BasicPeriodFormatter(this, this.localeName, getData(), this.customizations);
    }

    public int getSeparatorVariant() {
        return this.customizations.separatorVariant;
    }

    public int getUnitVariant() {
        return this.customizations.unitVariant;
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterFactory
    public PeriodFormatterFactory setCountVariant(int i) {
        updateCustomizations().countVariant = (byte) i;
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterFactory
    public PeriodFormatterFactory setDisplayLimit(boolean z) {
        updateCustomizations().displayLimit = z;
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterFactory
    public PeriodFormatterFactory setDisplayPastFuture(boolean z) {
        updateCustomizations().displayDirection = z;
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterFactory
    public PeriodFormatterFactory setLocale(String str) {
        this.data = null;
        this.localeName = str;
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterFactory
    public PeriodFormatterFactory setSeparatorVariant(int i) {
        updateCustomizations().separatorVariant = (byte) i;
        return this;
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterFactory
    public PeriodFormatterFactory setUnitVariant(int i) {
        updateCustomizations().unitVariant = (byte) i;
        return this;
    }

    public PeriodFormatterData getData(String str) {
        return this.ds.get(str);
    }
}
