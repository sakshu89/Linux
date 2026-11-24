package defpackage;

import android.util.Rational;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ht2 {
    public final int a;
    public final int b;
    public final Rational c;
    public final boolean d;

    public ht2(ut utVar, Rational rational) {
        this.a = utVar.a();
        this.b = utVar.b();
        this.c = rational;
        boolean z = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z = false;
        }
        this.d = z;
    }

    public final Size a(xy0 xy0Var) {
        int i = xy0Var.i();
        Size size = (Size) xy0Var.d(xy0.D, null);
        if (size != null) {
            int iA = pg4.a(pg4.b(i), this.a, 1 == this.b);
            if (iA == 90 || iA == 270) {
                return new Size(size.getHeight(), size.getWidth());
            }
        }
        return size;
    }
}
