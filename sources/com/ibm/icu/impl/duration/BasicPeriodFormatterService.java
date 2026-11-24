package com.ibm.icu.impl.duration;

import com.ibm.icu.impl.duration.impl.PeriodFormatterDataService;
import com.ibm.icu.impl.duration.impl.ResourceBasedPeriodFormatterDataService;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class BasicPeriodFormatterService implements PeriodFormatterService {
    private PeriodFormatterDataService ds;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class DefaultHolder {
        static final BasicPeriodFormatterService SERVICE = new BasicPeriodFormatterService(ResourceBasedPeriodFormatterDataService.getInstance());

        private DefaultHolder() {
        }
    }

    public BasicPeriodFormatterService(PeriodFormatterDataService periodFormatterDataService) {
        this.ds = periodFormatterDataService;
    }

    public static BasicPeriodFormatterService getInstance() {
        return DefaultHolder.SERVICE;
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterService
    public Collection<String> getAvailableLocaleNames() {
        return this.ds.getAvailableLocales();
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterService
    public DurationFormatterFactory newDurationFormatterFactory() {
        return new BasicDurationFormatterFactory(this);
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterService
    public PeriodBuilderFactory newPeriodBuilderFactory() {
        return new BasicPeriodBuilderFactory(this.ds);
    }

    @Override // com.ibm.icu.impl.duration.PeriodFormatterService
    public PeriodFormatterFactory newPeriodFormatterFactory() {
        return new BasicPeriodFormatterFactory(this.ds);
    }
}
