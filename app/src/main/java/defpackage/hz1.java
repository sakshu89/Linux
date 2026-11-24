package defpackage;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hz1 {
    public final String a;
    public final hq0 b;
    public final s70 c;
    public final Object d = new Object();
    public volatile py0 e;

    public hz1(String str, hq0 hq0Var, s70 s70Var) {
        this.a = str;
        this.b = hq0Var;
        this.c = s70Var;
    }

    public final py0 a(Context context, c51 c51Var) {
        py0 py0Var;
        context.getClass();
        c51Var.getClass();
        py0 py0Var2 = this.e;
        if (py0Var2 != null) {
            return py0Var2;
        }
        synchronized (this.d) {
            try {
                if (this.e == null) {
                    Context applicationContext = context.getApplicationContext();
                    hq0 hq0Var = this.b;
                    applicationContext.getClass();
                    List list = (List) hq0Var.j(applicationContext);
                    s70 s70Var = this.c;
                    h7 h7Var = new h7(8, applicationContext, this);
                    list.getClass();
                    this.e = new py0(8, new py0(8, new w90(new kl0(new ta(14, h7Var)), nz.h(new p0(list, null, 14)), new fl4(15), s70Var)));
                }
                py0Var = this.e;
                py0Var.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return py0Var;
    }
}
