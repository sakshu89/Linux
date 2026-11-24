package com.ibm.icu.text;

import java.util.function.IntUnaryOperator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements IntUnaryOperator {
    public final /* synthetic */ int a;

    public /* synthetic */ c(int i) {
        this.a = i;
    }

    @Override // java.util.function.IntUnaryOperator
    public final int applyAsInt(int i) {
        switch (this.a) {
            case 0:
                return RBBITableBuilder.lambda$minimizeLookaheads$5(i);
            case 1:
                return RBBITableBuilder.lambda$buildSafeReverseTable$6(i);
            default:
                return RBBITableBuilder.lambda$buildSafeReverseTable$7(i);
        }
    }
}
