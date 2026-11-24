package defpackage;

import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class py3 {
    public static final lo0 a = new lo0(15);

    public static final Rect a(i21 i21Var) {
        return new Rect(i21Var.a, i21Var.b, i21Var.c, i21Var.d);
    }

    public static final RectF b(l42 l42Var) {
        return new RectF(l42Var.a, l42Var.b, l42Var.c, l42Var.d);
    }

    public static final l42 c(RectF rectF) {
        return new l42(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
