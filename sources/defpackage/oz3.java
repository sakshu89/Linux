package defpackage;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class oz3 {
    public static fa2 a(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = bundle2;
        }
        if (bundle == null) {
            fa2 fa2Var = new fa2();
            new LinkedHashMap();
            fa2Var.a = new cj(ji0.a);
            return fa2Var;
        }
        ClassLoader classLoader = fa2.class.getClassLoader();
        classLoader.getClass();
        bundle.setClassLoader(classLoader);
        rg1 rg1Var = new rg1(bundle.size());
        for (String str : bundle.keySet()) {
            str.getClass();
            rg1Var.put(str, bundle.get(str));
        }
        rg1 rg1VarB = rg1Var.b();
        fa2 fa2Var2 = new fa2();
        new LinkedHashMap();
        fa2Var2.a = new cj(rg1VarB);
        return fa2Var2;
    }

    public static Object b(Future future) {
        hh1.e("Future was expected to be done, " + future, future.isDone());
        return c(future);
    }

    public static Object c(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static mz0 d(Object obj) {
        return obj == null ? mz0.c : new mz0(0, obj);
    }

    public static wc1 e(wc1 wc1Var) {
        wc1Var.getClass();
        if (wc1Var.isDone()) {
            return wc1Var;
        }
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            f(false, wc1Var, tpVar, xg4.a());
            tpVar.a = "nonCancellationPropagating[" + wc1Var + "]";
        } catch (Exception e) {
            wpVar.b(e);
        }
        return wpVar;
    }

    public static void f(boolean z, wc1 wc1Var, tp tpVar, dd0 dd0Var) {
        wc1Var.getClass();
        tpVar.getClass();
        dd0Var.getClass();
        wc1Var.a(new or0(0, wc1Var, new pb0(tpVar, 1)), dd0Var);
        if (z) {
            o7 o7Var = new o7(3, wc1Var);
            dd0 dd0VarA = xg4.a();
            o62 o62Var = tpVar.c;
            if (o62Var != null) {
                o62Var.a(o7Var, dd0VarA);
            }
        }
    }

    public static xw g(wc1 wc1Var, ch chVar, Executor executor) {
        xw xwVar = new xw(chVar, wc1Var);
        wc1Var.a(xwVar, executor);
        return xwVar;
    }
}
