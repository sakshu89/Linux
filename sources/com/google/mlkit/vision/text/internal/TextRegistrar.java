package com.google.mlkit.vision.text.internal;

import com.google.firebase.components.ComponentRegistrar;
import defpackage.d10;
import defpackage.dk0;
import defpackage.el1;
import defpackage.jz3;
import defpackage.ky0;
import defpackage.lq;
import defpackage.mc0;
import defpackage.nz3;
import defpackage.on4;
import defpackage.qm4;
import defpackage.su0;
import defpackage.tj1;
import defpackage.wj0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TextRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List a() {
        lq lqVarA = d10.a(on4.class);
        lqVarA.a(new mc0(1, 0, tj1.class));
        lqVarA.f = new su0(25);
        d10 d10VarC = lqVarA.c();
        lq lqVarA2 = d10.a(qm4.class);
        lqVarA2.a(new mc0(1, 0, on4.class));
        lqVarA2.a(new mc0(1, 0, wj0.class));
        lqVarA2.f = new el1(25);
        Object[] objArr = {d10VarC, lqVarA2.c()};
        for (int i = 0; i < 2; i++) {
            jz3 jz3Var = nz3.f;
            if (objArr[i] == null) {
                dk0.n(ky0.h(i, "at index "));
                return null;
            }
        }
        return nz3.l(2, objArr);
    }
}
