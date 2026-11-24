package defpackage;

import android.content.Context;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ns4 {
    public static q04 k;
    public static final a14 l;
    public final String a;
    public final String b;
    public final is4 c;
    public final jk2 d;
    public final et4 e;
    public final et4 f;
    public final String g;
    public final int h;
    public final HashMap i = new HashMap();
    public final HashMap j = new HashMap();

    static {
        Object[] objArr = {"optional-module-barcode", "com.google.android.gms.vision.barcode"};
        Objects.requireNonNull(objArr[0]);
        Objects.requireNonNull(objArr[1]);
        l = new a14(0, objArr);
    }

    public ns4(Context context, jk2 jk2Var, is4 is4Var, String str) {
        this.a = context.getPackageName();
        this.b = t00.a(context);
        this.d = jk2Var;
        this.c = is4Var;
        qs4.t();
        this.g = str;
        uf1 uf1VarQ = uf1.q();
        vv0 vv0Var = new vv0(3, this);
        uf1VarQ.getClass();
        this.e = uf1.y(vv0Var);
        uf1 uf1VarQ2 = uf1.q();
        Objects.requireNonNull(jk2Var);
        kk4 kk4Var = new kk4(jk2Var, 2);
        uf1VarQ2.getClass();
        this.f = uf1.y(kk4Var);
        a14 a14Var = l;
        this.h = a14Var.containsKey(str) ? sg0.d(context, (String) a14Var.get(str), false) : -1;
    }

    public static long a(ArrayList arrayList, double d) {
        return ((Long) arrayList.get(Math.max(((int) Math.ceil((d / 100.0d) * ((double) arrayList.size()))) - 1, 0))).longValue();
    }

    public final void b(ms4 ms4Var, jn4 jn4Var) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (d(jn4Var, jElapsedRealtime)) {
            this.i.put(jn4Var, Long.valueOf(jElapsedRealtime));
            aa4.a.execute(new qa3(this, ms4Var.zza(), jn4Var, c(), 1));
        }
    }

    public final String c() {
        et4 et4Var = this.e;
        if (et4Var.c()) {
            return (String) et4Var.a();
        }
        return ab1.c.a(this.g);
    }

    public final boolean d(jn4 jn4Var, long j) {
        HashMap map = this.i;
        return map.get(jn4Var) == null || j - ((Long) map.get(jn4Var)).longValue() > 30000;
    }
}
