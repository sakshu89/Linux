package defpackage;

import android.content.Context;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r23 {
    public static volatile x80 e;
    public final wy a;
    public final wy b;
    public final ya0 c;
    public final pi d;

    public r23(wy wyVar, wy wyVar2, ya0 ya0Var, pi piVar, p6 p6Var) {
        this.a = wyVar;
        this.b = wyVar2;
        this.c = ya0Var;
        this.d = piVar;
        ((Executor) p6Var.a).execute(new o7(9, p6Var));
    }

    public static r23 a() {
        x80 x80Var = e;
        if (x80Var != null) {
            return (r23) x80Var.f.get();
        }
        og.n("Not initialized!");
        return null;
    }

    public static void b(Context context) {
        if (e == null) {
            synchronized (r23.class) {
                try {
                    if (e == null) {
                        wf wfVar = new wf();
                        context.getClass();
                        wfVar.a = context;
                        e = wfVar.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final b13 c(po poVar) {
        Set setUnmodifiableSet = poVar instanceof po ? Collections.unmodifiableSet(po.d) : Collections.singleton(new qi0("proto"));
        poVar.getClass();
        String str = poVar.a;
        String str2 = poVar.b;
        if (str2 == null) {
            str2 = "";
        }
        pj pjVar = new pj("cct", cq.l("1$", str, "\\", str2).getBytes(Charset.forName("UTF-8")), v02.a);
        b13 b13Var = new b13();
        b13Var.a = setUnmodifiableSet;
        b13Var.b = pjVar;
        b13Var.c = this;
        return b13Var;
    }
}
