package defpackage;

import android.app.Application;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z3 implements GeneratedComponentManager {
    public volatile q80 a;
    public final Object b = new Object();
    public final n10 c;
    public final l4 e;
    public jb f;

    public z3(n10 n10Var) {
        this.c = n10Var;
        this.e = new l4(n10Var);
    }

    public final q80 a() {
        String str;
        n10 n10Var = this.c;
        if (n10Var.getApplication() instanceof GeneratedComponentManager) {
            s80 s80Var = (s80) ((y3) fn4.a(this.e, y3.class));
            return new q80(s80Var.a, s80Var.b);
        }
        if (Application.class.equals(n10Var.getApplication().getClass())) {
            str = "Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?";
        } else {
            str = "Found: " + n10Var.getApplication().getClass();
        }
        throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. ".concat(str));
    }

    public final void b() {
        l4 l4Var = this.e;
        jb jbVar = ((j4) l4.a(l4Var.a, l4Var.b).o(u42.a(j4.class))).c;
        this.f = jbVar;
        if (((jl1) jbVar.b) == null) {
            b80 b80VarA = this.c.a();
            Preconditions.checkState(jbVar.a, "setExtras should only be called for an Activity that extends ComponentActivity", new Object[0]);
            jbVar.b = (jl1) b80VarA;
        }
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        if (this.a == null) {
            synchronized (this.b) {
                try {
                    if (this.a == null) {
                        this.a = a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.a;
    }
}
