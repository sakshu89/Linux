package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.common.internal.a;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class re3 {
    public static final l11 i = new l11("ClientTelemetry.API", new rd3(2), new fl4(8));
    public static final l11 j = new l11("ModuleInstall.API", new rd3(3), new fl4(8));
    public final Context a;
    public final String b;
    public final l11 c;
    public final ie d;
    public final se e;
    public final int f;
    public final nr4 g;
    public final qu0 h;

    public re3(Context context, l11 l11Var, ie ieVar, lu0 lu0Var) {
        jg1.e(context, "Null context is not permitted.");
        jg1.e(l11Var, "Api must not be null.");
        jg1.e(lu0Var, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        jg1.e(applicationContext, "The provided context did not have an application context.");
        this.a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.b = attributionTag;
        this.c = l11Var;
        this.d = ieVar;
        this.e = new se(l11Var, ieVar, attributionTag);
        qu0 qu0VarE = qu0.e(applicationContext);
        this.h = qu0VarE;
        this.f = qu0VarE.h.getAndIncrement();
        this.g = lu0Var.a;
        we3 we3Var = qu0VarE.m;
        we3Var.sendMessage(we3Var.obtainMessage(7, this));
    }

    public final kf a() {
        kf kfVar = new kf(7);
        Set set = Collections.EMPTY_SET;
        if (((pg) kfVar.b) == null) {
            kfVar.b = new pg(0);
        }
        ((pg) kfVar.b).addAll(set);
        Context context = this.a;
        kfVar.e = context.getClass().getName();
        kfVar.c = context.getPackageName();
        return kfVar;
    }

    public et4 b(ow2 ow2Var) {
        py0 py0Var = new py0(17, false);
        el0[] el0VarArr = {mb4.a};
        py0Var.b = new py0(25, ow2Var);
        return c(2, new kk(py0Var, el0VarArr, false, 0));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    public final et4 c(int i2, kk kkVar) {
        u22 u22Var;
        iw2 iw2Var = new iw2();
        nr4 nr4Var = this.g;
        qu0 qu0Var = this.h;
        qu0Var.getClass();
        int i3 = kkVar.b;
        if (i3 != 0) {
            se seVar = this.e;
            if (qu0Var.a()) {
                r82 r82Var = (r82) q82.D().a;
                boolean z = true;
                if (r82Var != null) {
                    if (r82Var.b) {
                        boolean z2 = r82Var.c;
                        wd3 wd3Var = (wd3) qu0Var.j.get(seVar);
                        if (wd3Var != null) {
                            je jeVar = wd3Var.b;
                            if (jeVar instanceof a) {
                                a aVar = (a) jeVar;
                                if (aVar.u == null || aVar.d()) {
                                    z = z2;
                                } else {
                                    c40 c40VarC = u22.c(wd3Var, aVar, i3);
                                    if (c40VarC != null) {
                                        wd3Var.l++;
                                        z = c40VarC.c;
                                    }
                                }
                            }
                        } else {
                            z = z2;
                        }
                    }
                    u22Var = null;
                }
                u22Var = new u22(qu0Var, i3, seVar, z ? System.currentTimeMillis() : 0L, z ? SystemClock.elapsedRealtime() : 0L);
            } else {
                u22Var = null;
            }
            if (u22Var != null) {
                et4 et4Var = iw2Var.a;
                we3 we3Var = qu0Var.m;
                we3Var.getClass();
                uj0 uj0Var = new uj0(we3Var, 2);
                et4Var.getClass();
                et4Var.b.o(new xd4(uj0Var, u22Var));
                et4Var.i();
            }
        }
        ee3 ee3Var = new ee3(new ne3(i2, kkVar, iw2Var, nr4Var), qu0Var.i.get(), this);
        we3 we3Var2 = qu0Var.m;
        we3Var2.sendMessage(we3Var2.obtainMessage(4, ee3Var));
        return iw2Var.a;
    }
}
