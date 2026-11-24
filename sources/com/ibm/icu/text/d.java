package com.ibm.icu.text;

import com.ibm.icu.util.CaseInsensitiveString;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ d(int i) {
        this.a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return RBBITableBuilder.lambda$minimizeStates$0((RBBITableBuilder.C1StateType) obj);
            case 1:
                return RBBITableBuilder.lambda$minimizeStates$2((List) obj);
            case 2:
                return TransliteratorRegistry.lambda$registerSTV$0((CaseInsensitiveString) obj);
            default:
                return TransliteratorRegistry.lambda$registerSTV$1((CaseInsensitiveString) obj);
        }
    }
}
