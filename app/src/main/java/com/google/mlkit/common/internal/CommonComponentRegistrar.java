package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentRegistrar;
import defpackage.ak1;
import defpackage.d10;
import defpackage.dh4;
import defpackage.el1;
import defpackage.ex3;
import defpackage.fl4;
import defpackage.hy;
import defpackage.jk2;
import defpackage.lq;
import defpackage.lx3;
import defpackage.mc0;
import defpackage.p52;
import defpackage.q52;
import defpackage.qs4;
import defpackage.su0;
import defpackage.tj1;
import defpackage.vx3;
import defpackage.wj0;
import defpackage.xy;
import defpackage.y74;
import defpackage.yj1;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CommonComponentRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List a() {
        d10 d10Var = jk2.b;
        lq lqVarA = d10.a(ak1.class);
        lqVarA.a(new mc0(1, 0, tj1.class));
        lqVarA.f = new fl4(22);
        d10 d10VarC = lqVarA.c();
        lq lqVarA2 = d10.a(yj1.class);
        lqVarA2.f = new qs4(22);
        d10 d10VarC2 = lqVarA2.c();
        lq lqVarA3 = d10.a(q52.class);
        lqVarA3.a(new mc0(2, 0, p52.class));
        lqVarA3.f = new xy(23);
        d10 d10VarC3 = lqVarA3.c();
        lq lqVarA4 = d10.a(wj0.class);
        lqVarA4.a(new mc0(1, 1, yj1.class));
        lqVarA4.f = new ak1(23);
        d10 d10VarC4 = lqVarA4.c();
        lq lqVarA5 = d10.a(hy.class);
        lqVarA5.f = new fl4(23);
        d10 d10VarC5 = lqVarA5.c();
        lq lqVarA6 = d10.a(xy.class);
        lqVarA6.a(new mc0(1, 0, hy.class));
        lqVarA6.f = new qs4(23);
        d10 d10VarC6 = lqVarA6.c();
        lq lqVarA7 = d10.a(y74.class);
        lqVarA7.a(new mc0(1, 0, tj1.class));
        lqVarA7.f = new su0(24);
        d10 d10VarC7 = lqVarA7.c();
        lq lqVarA8 = d10.a(p52.class);
        lqVarA8.c = 1;
        lqVarA8.a(new mc0(1, 1, y74.class));
        lqVarA8.f = new el1(24);
        d10 d10VarC8 = lqVarA8.c();
        ex3 ex3Var = lx3.f;
        Object[] objArr = {d10Var, d10VarC, d10VarC2, d10VarC3, d10VarC4, d10VarC5, d10VarC6, d10VarC7, d10VarC8};
        dh4.b(9, objArr);
        return new vx3(9, objArr);
    }
}
