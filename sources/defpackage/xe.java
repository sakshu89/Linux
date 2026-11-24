package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xe {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static xe c;
    public s62 a;

    public static synchronized void b() {
        if (c == null) {
            xe xeVar = new xe();
            c = xeVar;
            xeVar.a = s62.c();
            s62 s62Var = c.a;
            lj1 lj1Var = new lj1();
            synchronized (s62Var) {
                s62Var.e = lj1Var;
            }
        }
    }

    public static void c(Drawable drawable, z30 z30Var, int[] iArr) {
        PorterDuff.Mode mode = s62.f;
        int[] state = drawable.getState();
        int[] iArr2 = wf0.a;
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = z30Var.b;
            if (!z && !z30Var.a) {
                drawable.clearColorFilter();
                return;
            }
            PorterDuffColorFilter porterDuffColorFilterF = null;
            ColorStateList colorStateList = z ? (ColorStateList) z30Var.c : null;
            PorterDuff.Mode mode2 = z30Var.a ? (PorterDuff.Mode) z30Var.d : s62.f;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilterF = s62.f(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilterF);
        }
    }

    public final synchronized Drawable a(Context context, int i) {
        return this.a.d(context, i);
    }
}
