package defpackage;

import android.os.Bundle;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class c44 {
    public static final qs4 a = new qs4(17);
    public static final xy b;
    public static final su0 c;

    static {
        int i = 18;
        b = new xy(i);
        c = new su0(i);
    }

    public static final void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            og.g(i != i2 ? cq.i("Both size ", i, " and step ", i2, " must be greater than zero.") : cq.h("size ", i, " must be greater than zero."));
        }
    }

    public static final fa2 b(jl1 jl1Var) {
        LinkedHashMap linkedHashMap = jl1Var.a;
        na2 na2Var = (na2) linkedHashMap.get(a);
        Bundle bundle = null;
        if (na2Var == null) {
            og.i("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
            return null;
        }
        h83 h83Var = (h83) linkedHashMap.get(b);
        if (h83Var == null) {
            og.i("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
            return null;
        }
        Bundle bundle2 = (Bundle) linkedHashMap.get(c);
        String str = (String) linkedHashMap.get(uf1.f);
        if (str == null) {
            og.i("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            return null;
        }
        la2 la2VarB = na2Var.b().B();
        ia2 ia2Var = la2VarB instanceof ia2 ? (ia2) la2VarB : null;
        if (ia2Var == null) {
            og.n("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
            return null;
        }
        LinkedHashMap linkedHashMap2 = d(h83Var).b;
        fa2 fa2Var = (fa2) linkedHashMap2.get(str);
        if (fa2Var != null) {
            return fa2Var;
        }
        ia2Var.b();
        Bundle bundle3 = ia2Var.c;
        if (bundle3 != null && bundle3.containsKey(str)) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                bundle4 = bg4.a((wt1[]) Arrays.copyOf(new wt1[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                ia2Var.c = null;
            }
            bundle = bundle4;
        }
        fa2 fa2VarA = oz3.a(bundle, bundle2);
        linkedHashMap2.put(str, fa2VarA);
        return fa2VarA;
    }

    public static final void c(na2 na2Var) {
        eb1 eb1Var = na2Var.f().d;
        if (eb1Var != eb1.b && eb1Var != eb1.c) {
            og.i("Failed requirement.");
        } else if (na2Var.b().B() == null) {
            ia2 ia2Var = new ia2(na2Var.b(), (h83) na2Var);
            na2Var.b().F("androidx.lifecycle.internal.SavedStateHandlesProvider", ia2Var);
            na2Var.f().a(new k42(3, ia2Var));
        }
    }

    public static final ja2 d(h83 h83Var) {
        ha2 ha2Var = new ha2();
        b80 b80VarA = h83Var instanceof cw0 ? ((cw0) h83Var).a() : a80.b;
        b80VarA.getClass();
        g83 g83VarC = h83Var.c();
        g83VarC.getClass();
        return (ja2) new p6(g83VarC, ha2Var, b80VarA).n(u42.a(ja2.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
