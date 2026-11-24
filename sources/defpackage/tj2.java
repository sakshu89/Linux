package defpackage;

import android.graphics.Paint;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tj2 extends hn {
    public wj1 a;
    public long b = 9205357640488583168L;

    @Override // defpackage.hn
    public final void a(float f, long j, fa faVar) {
        Paint paint = faVar.a;
        wj1 wj1Var = this.a;
        if (wj1Var == null || !xk2.a(this.b, j)) {
            if (xk2.c(j)) {
                this.a = null;
                this.b = 9205357640488583168L;
                wj1Var = null;
            } else {
                wj1Var = this.a;
                if (wj1Var == null) {
                    wj1Var = new wj1(14, false);
                    this.a = wj1Var;
                }
                wj1Var.b = b(j);
                this.a = wj1Var;
                this.b = j;
            }
        }
        long jB = ki4.b(paint.getColor());
        long j2 = sz.b;
        if (!sz.c(jB, j2)) {
            faVar.e(j2);
        }
        if (!g31.a(faVar.c, wj1Var != null ? (Shader) wj1Var.b : null)) {
            faVar.h(wj1Var != null ? (Shader) wj1Var.b : null);
        }
        if (paint.getAlpha() / 255.0f == f) {
            return;
        }
        faVar.c(f);
    }

    public abstract Shader b(long j);
}
