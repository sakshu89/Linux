package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ef {
    public final ve a;
    public z30 b;
    public z30 c;
    public z30 d;
    public z30 e;
    public z30 f;
    public z30 g;
    public z30 h;
    public final jf i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public ef(ve veVar) {
        this.a = veVar;
        this.i = new jf(veVar);
    }

    public static z30 c(Context context, xe xeVar, int i) {
        ColorStateList colorStateListG;
        synchronized (xeVar) {
            colorStateListG = xeVar.a.g(context, i);
        }
        if (colorStateListG == null) {
            return null;
        }
        z30 z30Var = new z30();
        z30Var.b = true;
        z30Var.c = colorStateListG;
        return z30Var;
    }

    public final void a(Drawable drawable, z30 z30Var) {
        if (drawable == null || z30Var == null) {
            return;
        }
        xe.c(drawable, z30Var, this.a.getDrawableState());
    }

    public final void b() {
        z30 z30Var = this.b;
        ve veVar = this.a;
        if (z30Var != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = veVar.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] drawableArrA = af.a(veVar);
        a(drawableArrA[0], this.f);
        a(drawableArrA[2], this.g);
    }

    public final void d(Context context, b13 b13Var) {
        String string;
        int i = this.j;
        TypedArray typedArray = (TypedArray) b13Var.b;
        this.j = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.k = i3;
            if (i3 != -1) {
                this.j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.m = false;
                int i4 = typedArray.getInt(1, 1);
                if (i4 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (i4 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i5 = typedArray.hasValue(12) ? 12 : 10;
        int i6 = this.k;
        int i7 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceE = b13Var.e(i5, this.j, new ye(this, i6, i7, new WeakReference(this.a)));
                if (typefaceE != null) {
                    if (i2 < 28 || this.k == -1) {
                        this.l = typefaceE;
                    } else {
                        this.l = df.a(Typeface.create(typefaceE, 0), this.k, (this.j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (string = typedArray.getString(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            this.l = Typeface.create(string, this.j);
        } else {
            this.l = df.a(Typeface.create(string, 0), this.k, (this.j & 2) != 0);
        }
    }
}
