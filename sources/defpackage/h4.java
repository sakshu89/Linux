package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import java.io.Closeable;
import java.util.Collections;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h4 implements e83 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ h4(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.e83
    public final b83 b(Class cls, jl1 jl1Var) {
        Application application;
        b83 b83Var;
        switch (this.a) {
            case 0:
                jb jbVar = new jb();
                jbVar.a = true;
                jbVar.b = jl1Var;
                Context applicationContext = ((n10) this.b).getApplicationContext();
                if (!(applicationContext instanceof Application)) {
                    Context baseContext = applicationContext;
                    while (baseContext instanceof ContextWrapper) {
                        baseContext = ((ContextWrapper) baseContext).getBaseContext();
                        if (baseContext instanceof Application) {
                            application = (Application) baseContext;
                        }
                    }
                    dk0.q(applicationContext, "Could not find an Application in the given context: ");
                    return null;
                }
                application = (Application) applicationContext;
                return new j4(new s80(((v80) ((i4) fn4.a(application, i4.class))).b), jbVar);
            default:
                final n72 n72Var = new n72();
                q82 q82Var = (q82) this.b;
                c44.b(jl1Var);
                v80 v80Var = (v80) q82Var.a;
                w80 w80Var = new w80();
                w80Var.a = new u80(v80Var, 0, 1);
                w80Var.b = new u80(v80Var, 1, 1);
                w80Var.c = new u80(v80Var, 2, 1);
                w80 w80Var2 = (w80) ((iw0) fn4.a(w80Var, iw0.class));
                w80Var2.getClass();
                sg1 sg1Var = new sg1(3);
                sg1Var.e(w80Var2.a, "oj2");
                sg1Var.e(w80Var2.b, "sj2");
                sg1Var.e(w80Var2.c, "so2");
                LinkedHashMap linkedHashMap = sg1Var.a;
                c22 c22Var = (c22) (linkedHashMap.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(linkedHashMap)).get(cls.getName());
                hq0 hq0Var = (hq0) jl1Var.a.get(jw0.d);
                ((w80) ((iw0) fn4.a(w80Var, iw0.class))).getClass();
                Object obj = Collections.EMPTY_MAP.get(cls);
                if (obj == null) {
                    if (hq0Var != null) {
                        throw new IllegalStateException("Found creation callback but class " + cls.getName() + " does not have an assisted factory specified in @HiltViewModel.");
                    }
                    if (c22Var == null) {
                        throw new IllegalStateException("Expected the @HiltViewModel-annotated class " + cls.getName() + " to be available in the multi-binding of @HiltViewModelMap but none was found.");
                    }
                    b83Var = (b83) c22Var.get();
                } else {
                    if (c22Var != null) {
                        throw new AssertionError("Found the @HiltViewModel-annotated class " + cls.getName() + " in both the multi-bindings of @HiltViewModelMap and @HiltViewModelAssistedMap.");
                    }
                    if (hq0Var == null) {
                        throw new IllegalStateException("Found @HiltViewModel-annotated class " + cls.getName() + " using @AssistedInject but no creation callback was provided in CreationExtras.");
                    }
                    b83Var = (b83) hq0Var.j(obj);
                }
                Closeable closeable = new Closeable() { // from class: hw0
                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                        n72Var.a();
                    }
                };
                b83Var.getClass();
                c83 c83Var = b83Var.a;
                if (c83Var != null) {
                    if (c83Var.d) {
                        c83.a(closeable);
                    } else {
                        synchronized (c83Var.a) {
                            c83Var.c.add(closeable);
                        }
                    }
                }
                return b83Var;
        }
    }
}
