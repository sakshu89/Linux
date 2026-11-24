package defpackage;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nk4 {
    public static js4 j;
    public static final a14 k;
    public final String a;
    public final String b;
    public final hk4 c;
    public final jk2 d;
    public final et4 e;
    public final et4 f;
    public final String g;
    public final int h;
    public final HashMap i = new HashMap();

    static {
        Object[] objArr = {"optional-module-barcode", "com.google.android.gms.vision.barcode"};
        objArr[0].getClass();
        objArr[1].getClass();
        k = new a14(1, objArr);
    }

    public nk4(Context context, jk2 jk2Var, hk4 hk4Var) {
        new HashMap();
        this.a = context.getPackageName();
        this.b = t00.a(context);
        this.d = jk2Var;
        this.c = hk4Var;
        fl4.l();
        this.g = "vision-common";
        uf1 uf1VarQ = uf1.q();
        vv0 vv0Var = new vv0(1, this);
        uf1VarQ.getClass();
        this.e = uf1.y(vv0Var);
        uf1 uf1VarQ2 = uf1.q();
        jk2Var.getClass();
        kk4 kk4Var = new kk4(jk2Var, 0);
        uf1VarQ2.getClass();
        this.f = uf1.y(kk4Var);
        a14 a14Var = k;
        this.h = a14Var.containsKey("vision-common") ? sg0.d(context, (String) a14Var.get("vision-common"), false) : -1;
    }
}
