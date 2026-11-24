package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tj1 {
    public static final Object b = new Object();
    public static tj1 c;
    public s10 a;

    public static tj1 c() {
        tj1 tj1Var;
        synchronized (b) {
            jg1.f("MlKitContext has not been initialized", c != null);
            tj1Var = c;
            jg1.d(tj1Var);
        }
        return tj1Var;
    }

    public static tj1 d(Context context) {
        HashMap map;
        tj1 tj1Var;
        synchronized (b) {
            jg1.f("MlKitContext is already initialized", c == null);
            tj1 tj1Var2 = new tj1();
            c = tj1Var2;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            new qs4(10);
            wf wfVar = new wf();
            wfVar.a = context;
            ArrayList arrayListC = wfVar.c();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(arrayListC);
            arrayList2.add(d10.b(context, Context.class, new Class[0]));
            arrayList2.add(d10.b(tj1Var2, tj1.class, new Class[0]));
            s10 s10Var = new s10(arrayList, arrayList2);
            tj1Var2.a = s10Var;
            AtomicReference atomicReference = s10Var.e;
            Boolean bool = Boolean.TRUE;
            do {
                if (atomicReference.compareAndSet(null, bool)) {
                    synchronized (s10Var) {
                        map = new HashMap(s10Var.a);
                    }
                    s10Var.f(map, true);
                    break;
                }
            } while (atomicReference.get() == null);
            tj1Var = c;
        }
        return tj1Var;
    }

    public final Object a(Class cls) {
        jg1.f("MlKitContext has been deleted", c == this);
        jg1.d(this.a);
        return this.a.b(cls);
    }

    public final Context b() {
        return (Context) a(Context.class);
    }
}
