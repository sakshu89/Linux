package defpackage;

import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ee4 {
    public static final void a(TextPaint textPaint, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        textPaint.setAlpha(Math.round(f * 255.0f));
    }

    public static final Object b(hb2 hb2Var, boolean z, hb2 hb2Var2, vq0 vq0Var) throws Throwable {
        Object a10Var;
        Object objC0;
        try {
            if (vq0Var instanceof pk) {
                h33.c(2, vq0Var);
                a10Var = vq0Var.e(hb2Var2, hb2Var);
            } else {
                a10Var = fp4.c(vq0Var, hb2Var2, hb2Var);
            }
        } catch (gd0 e) {
            Throwable th = e.a;
            hb2Var.b0(new a10(th, false));
            throw th;
        } catch (Throwable th2) {
            a10Var = new a10(th2, false);
        }
        t70 t70Var = t70.a;
        if (a10Var == t70Var || (objC0 = hb2Var.c0(a10Var)) == tz3.b) {
            return t70Var;
        }
        hb2Var.v0();
        if (!(objC0 instanceof a10)) {
            return tz3.e(objC0);
        }
        if (!z) {
            Throwable th3 = ((a10) objC0).a;
            if ((th3 instanceof v03) && ((v03) th3).a == hb2Var) {
                if (a10Var instanceof a10) {
                    throw ((a10) a10Var).a;
                }
                return a10Var;
            }
        }
        throw ((a10) objC0).a;
    }
}
