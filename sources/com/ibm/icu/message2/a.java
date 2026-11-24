package com.ibm.icu.message2;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int i) {
        this.a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                return MFDataModelFormatter.sortVariants((MFDataModelFormatter.IntVarTuple) obj, (MFDataModelFormatter.IntVarTuple) obj2);
            default:
                return NumberFunctionFactory.NumberFunctionImpl.pluralComparator((String) obj, (String) obj2);
        }
    }
}
