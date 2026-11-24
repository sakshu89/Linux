package defpackage;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oa2 implements e83 {
    public final Application a;
    public final d83 b;
    public final Bundle c;
    public final qb1 d;
    public final q91 e;

    public oa2(Application application, n10 n10Var, Bundle bundle) {
        d83 d83Var;
        this.e = (q91) n10Var.e.c;
        this.d = n10Var.a;
        this.c = bundle;
        this.a = application;
        if (application != null) {
            if (d83.c == null) {
                d83.c = new d83(application);
            }
            d83Var = d83.c;
            d83Var.getClass();
        } else {
            d83Var = new d83(null);
        }
        this.b = d83Var;
    }

    @Override // defpackage.e83
    public final b83 a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(cls, canonicalName);
        }
        og.i("Local and anonymous classes can not be ViewModels");
        return null;
    }

    @Override // defpackage.e83
    public final b83 b(Class cls, jl1 jl1Var) {
        fl4 fl4Var = uf1.f;
        LinkedHashMap linkedHashMap = jl1Var.a;
        String str = (String) linkedHashMap.get(fl4Var);
        if (str == null) {
            og.n("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
            return null;
        }
        if (linkedHashMap.get(c44.a) == null || linkedHashMap.get(c44.b) == null) {
            if (this.d != null) {
                return d(cls, str);
            }
            og.n("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            return null;
        }
        Application application = (Application) linkedHashMap.get(d83.d);
        boolean zIsAssignableFrom = wc.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? pa2.a(cls, pa2.b) : pa2.a(cls, pa2.a);
        if (constructorA == null) {
            return this.b.b(cls, jl1Var);
        }
        return (!zIsAssignableFrom || application == null) ? pa2.b(cls, constructorA, c44.b(jl1Var)) : pa2.b(cls, constructorA, application, c44.b(jl1Var));
    }

    @Override // defpackage.e83
    public final b83 c(dy dyVar, jl1 jl1Var) {
        return b(jp4.a(dyVar), jl1Var);
    }

    public final b83 d(Class cls, String str) {
        qb1 qb1Var = this.d;
        if (qb1Var == null) {
            dk0.r("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
            return null;
        }
        boolean zIsAssignableFrom = wc.class.isAssignableFrom(cls);
        Application application = this.a;
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? pa2.a(cls, pa2.b) : pa2.a(cls, pa2.a);
        if (constructorA == null) {
            if (application != null) {
                return this.b.a(cls);
            }
            if (f83.a == null) {
                f83.a = new f83();
            }
            f83.a.getClass();
            return kp4.a(cls);
        }
        q91 q91Var = this.e;
        q91Var.getClass();
        fa2 fa2VarA = oz3.a(q91Var.x(str), this.c);
        ga2 ga2Var = new ga2(str, fa2VarA);
        ga2Var.c(q91Var, qb1Var);
        eb1 eb1Var = qb1Var.d;
        if (eb1Var == eb1.b || eb1Var.compareTo(eb1.e) >= 0) {
            q91Var.G();
        } else {
            qb1Var.a(new va0(q91Var, qb1Var));
        }
        b83 b83VarB = (!zIsAssignableFrom || application == null) ? pa2.b(cls, constructorA, fa2VarA) : pa2.b(cls, constructorA, application, fa2VarA);
        b83VarB.a("androidx.lifecycle.savedstate.vm.tag", ga2Var);
        return b83VarB;
    }
}
