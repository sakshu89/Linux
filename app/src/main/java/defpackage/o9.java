package defpackage;

import android.content.Context;
import android.os.Build;
import com.project.sonic.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o9 implements uu0 {
    public static boolean f = true;
    public final r7 a;
    public final Object b = new Object();
    public a83 c;
    public boolean d;
    public final m9 e;

    public o9(r7 r7Var) {
        this.a = r7Var;
        m9 m9Var = new m9();
        this.e = m9Var;
        if (r7Var.isAttachedToWindow()) {
            Context context = r7Var.getContext();
            if (!this.d) {
                context.getApplicationContext().registerComponentCallbacks(m9Var);
                this.d = true;
            }
        }
        r7Var.addOnAttachStateChangeListener(new n9(0, this));
    }

    @Override // defpackage.uu0
    public final void a(vu0 vu0Var) {
        synchronized (this.b) {
            if (!vu0Var.s) {
                vu0Var.s = true;
                vu0Var.b();
            }
        }
    }

    @Override // defpackage.uu0
    public final vu0 b() {
        xu0 ev0Var;
        xu0 cv0Var;
        vu0 vu0Var;
        synchronized (this.b) {
            try {
                r7 r7Var = this.a;
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    r7Var.getUniqueDrawingId();
                }
                if (i >= 29) {
                    cv0Var = new cv0();
                } else {
                    if (f) {
                        try {
                            ev0Var = new av0(this.a, new fw(), new ew());
                        } catch (Throwable unused) {
                            f = false;
                            ev0Var = new ev0(c(this.a));
                        }
                    } else {
                        ev0Var = new ev0(c(this.a));
                    }
                    cv0Var = ev0Var;
                }
                vu0Var = new vu0(cv0Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        return vu0Var;
    }

    public final of0 c(r7 r7Var) {
        a83 a83Var = this.c;
        if (a83Var != null) {
            return a83Var;
        }
        a83 a83Var2 = new a83(r7Var.getContext());
        a83Var2.setClipChildren(false);
        a83Var2.setClipToPadding(false);
        a83Var2.setTag(R.id.hide_graphics_layer_in_inspector_tag, Boolean.TRUE);
        r7Var.addView(a83Var2, -1);
        this.c = a83Var2;
        return a83Var2;
    }
}
