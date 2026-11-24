package defpackage;

import android.graphics.Typeface;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ro0 implements qo0 {
    public final ak1 a;
    public final l9 b;
    public final cu2 c;
    public final vo0 d;
    public final py0 e;

    public ro0(ak1 ak1Var, l9 l9Var) {
        cu2 cu2Var = so0.a;
        vo0 vo0Var = new vo0();
        uo0 uo0Var = vo0.a;
        tv0 tv0Var = kd0.a;
        uo0Var.getClass();
        tl4.a(pl4.c(uo0Var, tv0Var).r(gi0.a).r(new ft2(null)));
        py0 py0Var = new py0(7);
        this.a = ak1Var;
        this.b = l9Var;
        this.c = cu2Var;
        this.d = vo0Var;
        this.e = py0Var;
        new x0(12, this);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093 A[Catch: Exception -> 0x009b, TRY_ENTER, TryCatch #0 {Exception -> 0x009b, blocks: (B:25:0x0041, B:27:0x0054, B:30:0x0059, B:32:0x005d, B:35:0x006a, B:52:0x0093, B:53:0x009a, B:34:0x0066), top: B:59:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final t33 a(s33 s33Var) {
        Typeface typefaceE;
        t33 t33Var;
        Object objRemove;
        cu2 cu2Var = this.c;
        synchronized (((el1) cu2Var.b)) {
            try {
                t33 t33Var2 = (t33) ((tf1) cu2Var.c).a(s33Var);
                if (t33Var2 != null) {
                    if (t33Var2.b) {
                        return t33Var2;
                    }
                    tf1 tf1Var = (tf1) cu2Var.c;
                    synchronized (tf1Var.c) {
                        uf1 uf1Var = tf1Var.b;
                        uf1Var.getClass();
                        objRemove = ((LinkedHashMap) uf1Var.b).remove(s33Var);
                        if (objRemove != null) {
                            tf1Var.d--;
                        }
                    }
                }
                try {
                    this.d.getClass();
                    ev2 ev2Var = s33Var.a;
                    ey1 ey1Var = (ey1) this.e.b;
                    int i = s33Var.c;
                    np0 np0Var = s33Var.b;
                    if (ev2Var != null && !(ev2Var instanceof la0)) {
                        if (ev2Var instanceof bu0) {
                            typefaceE = ey1Var.i((bu0) ev2Var, np0Var, i);
                        } else {
                            t33Var = null;
                        }
                        if (t33Var != null) {
                            throw new IllegalStateException("Could not load font");
                        }
                        synchronized (((el1) cu2Var.b)) {
                            if (((tf1) cu2Var.c).a(s33Var) == null && t33Var.b) {
                                ((tf1) cu2Var.c).b(s33Var, t33Var);
                            }
                        }
                        return t33Var;
                    }
                    typefaceE = ey1Var.e(np0Var, i);
                    t33Var = new t33(typefaceE);
                    if (t33Var != null) {
                        throw new IllegalStateException("Could not load font");
                    }
                    synchronized (((el1) cu2Var.b)) {
                        if (((tf1) cu2Var.c).a(s33Var) == null) {
                            ((tf1) cu2Var.c).b(s33Var, t33Var);
                        }
                        return t33Var;
                    }
                } catch (Exception e) {
                    throw new IllegalStateException("Could not load font", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final t33 b(ev2 ev2Var, np0 np0Var, int i, int i2) {
        l9 l9Var = this.b;
        l9Var.getClass();
        int i3 = l9Var.a;
        np0 np0Var2 = (i3 == 0 || i3 == Integer.MAX_VALUE) ? np0Var : new np0(ky3.c(np0Var.a + i3, 1, 1000));
        this.a.getClass();
        return a(new s33(ev2Var, np0Var2, i, i2, null));
    }
}
