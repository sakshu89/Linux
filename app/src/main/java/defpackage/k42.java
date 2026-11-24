package defpackage;

import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k42 implements lb1 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ k42(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                na2 na2Var = (na2) obj;
                if (db1Var != db1.ON_CREATE) {
                    og.m("Next event must be ON_CREATE");
                    return;
                }
                ob1Var.f().f(this);
                Bundle bundleX = na2Var.b().x("androidx.savedstate.Restarter");
                if (bundleX == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundleX.getStringArrayList("classes_to_restore");
                if (stringArrayList == null) {
                    og.n("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                    return;
                }
                int size = stringArrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    String str = stringArrayList.get(i2);
                    i2++;
                    String str2 = str;
                    try {
                        Class<? extends U> clsAsSubclass = Class.forName(str2, false, k42.class.getClassLoader()).asSubclass(ka2.class);
                        clsAsSubclass.getClass();
                        try {
                            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                Object objNewInstance = declaredConstructor.newInstance(null);
                                objNewInstance.getClass();
                                if (!(na2Var instanceof h83)) {
                                    dk0.u(na2Var, "Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: ");
                                    return;
                                }
                                g83 g83VarC = ((h83) na2Var).c();
                                q91 q91VarB = na2Var.b();
                                g83VarC.getClass();
                                LinkedHashMap linkedHashMap = g83VarC.a;
                                for (String str3 : new HashSet(linkedHashMap.keySet())) {
                                    str3.getClass();
                                    b83 b83Var = (b83) linkedHashMap.get(str3);
                                    if (b83Var != null) {
                                        iq4.a(b83Var, q91VarB, na2Var.f());
                                    }
                                }
                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                    q91VarB.G();
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(cq.j("Failed to instantiate ", str2), e);
                            }
                        } catch (NoSuchMethodException e2) {
                            throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                        }
                    } catch (ClassNotFoundException e3) {
                        throw new RuntimeException(cq.v("Class ", str2, " wasn't found"), e3);
                    }
                }
                return;
            case 1:
                n10 n10Var = (n10) obj;
                if (n10Var.f == null) {
                    k10 k10Var = (k10) n10Var.getLastNonConfigurationInstance();
                    if (k10Var != null) {
                        n10Var.f = k10Var.a;
                    }
                    if (n10Var.f == null) {
                        n10Var.f = new g83();
                    }
                }
                n10Var.a.f(this);
                return;
            case 2:
                new HashMap();
                ut0[] ut0VarArr = (ut0[]) obj;
                if (ut0VarArr.length > 0) {
                    ut0 ut0Var = ut0VarArr[0];
                    throw null;
                }
                if (ut0VarArr.length <= 0) {
                    return;
                }
                ut0 ut0Var2 = ut0VarArr[0];
                throw null;
            default:
                if (db1Var != db1.ON_CREATE) {
                    dk0.u(db1Var, "Next event must be ON_CREATE, it was ");
                    return;
                } else {
                    ob1Var.f().f(this);
                    ((ia2) obj).b();
                    return;
                }
        }
    }
}
