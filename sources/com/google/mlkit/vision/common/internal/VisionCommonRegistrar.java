package com.google.mlkit.vision.common.internal;

import com.google.firebase.components.ComponentRegistrar;
import defpackage.d10;
import defpackage.dk0;
import defpackage.dl1;
import defpackage.el1;
import defpackage.js4;
import defpackage.kl4;
import defpackage.ky0;
import defpackage.lq;
import defpackage.mc0;
import defpackage.mn4;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class VisionCommonRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List a() {
        lq lqVarA = d10.a(el1.class);
        lqVarA.a(new mc0(2, 0, dl1.class));
        lqVarA.f = el1.k;
        Object[] objArr = {lqVarA.c()};
        for (int i = 0; i < 1; i++) {
            kl4 kl4Var = mn4.b;
            if (objArr[i] == null) {
                dk0.n(ky0.h(i, "at index "));
                return null;
            }
        }
        kl4 kl4Var2 = mn4.b;
        return new js4(1, objArr);
    }
}
