package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.TypedValue;
import com.project.sonic.R;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s62 {
    public static s62 g;
    public WeakHashMap a;
    public final WeakHashMap b = new WeakHashMap(0);
    public TypedValue c;
    public boolean d;
    public lj1 e;
    public static final PorterDuff.Mode f = PorterDuff.Mode.SRC_IN;
    public static final r62 h = new r62(6);

    public static synchronized s62 c() {
        try {
            if (g == null) {
                g = new s62();
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public static synchronized PorterDuffColorFilter f(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        r62 r62Var = h;
        r62Var.getClass();
        int i2 = (31 + i) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) r62Var.a(Integer.valueOf(mode.hashCode() + i2));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public final void a(Context context, int i, ColorStateList colorStateList) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        mp2 mp2Var = (mp2) this.a.get(context);
        if (mp2Var == null) {
            mp2Var = new mp2(0);
            this.a.put(context, mp2Var);
        }
        int i2 = mp2Var.c;
        if (i2 != 0 && i <= mp2Var.a[i2 - 1]) {
            mp2Var.c(i, colorStateList);
            return;
        }
        if (i2 >= mp2Var.a.length) {
            int i3 = (i2 + 1) * 4;
            for (int i4 = 4; i4 < 32; i4++) {
                int i5 = (1 << i4) - 12;
                if (i3 <= i5) {
                    i3 = i5;
                    break;
                }
            }
            int i6 = i3 / 4;
            mp2Var.a = Arrays.copyOf(mp2Var.a, i6);
            mp2Var.b = Arrays.copyOf(mp2Var.b, i6);
        }
        mp2Var.a[i2] = i;
        mp2Var.b[i2] = colorStateList;
        mp2Var.c = i2 + 1;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    public final Drawable b(Context context, int i) {
        Object obj;
        WeakReference weakReference;
        Drawable drawableNewDrawable;
        LayerDrawable layerDrawableH;
        if (this.c == null) {
            this.c = new TypedValue();
        }
        TypedValue typedValue = this.c;
        context.getResources().getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        synchronized (this) {
            if1 if1Var = (if1) this.b.get(context);
            obj = null;
            if (if1Var != null && (weakReference = (WeakReference) if1Var.b(j)) != null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                if (constantState != null) {
                    drawableNewDrawable = constantState.newDrawable(context.getResources());
                } else {
                    if1Var.e(j);
                }
            }
            drawableNewDrawable = null;
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        if (this.e == null) {
            layerDrawableH = null;
        } else if (i == R.drawable.abc_cab_background_top_material) {
            layerDrawableH = new LayerDrawable(new Drawable[]{d(context, R.drawable.abc_cab_background_internal_bg), d(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        } else if (i == R.drawable.abc_ratingbar_material) {
            layerDrawableH = lj1.h(this, context, R.dimen.abc_star_big);
        } else if (i == R.drawable.abc_ratingbar_indicator_material) {
            layerDrawableH = lj1.h(this, context, R.dimen.abc_star_medium);
        } else if (i == R.drawable.abc_ratingbar_small_material) {
            layerDrawableH = lj1.h(this, context, R.dimen.abc_star_small);
        } else {
            layerDrawableH = null;
        }
        if (layerDrawableH == null) {
            return layerDrawableH;
        }
        layerDrawableH.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = layerDrawableH.getConstantState();
                if (constantState2 == null) {
                    return layerDrawableH;
                }
                if1 if1Var2 = (if1) this.b.get(context);
                if (if1Var2 == null) {
                    if1Var2 = new if1(obj);
                    this.b.put(context, if1Var2);
                }
                if1Var2.d(j, new WeakReference(constantState2));
                return layerDrawableH;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized Drawable d(Context context, int i) {
        return e(context, i);
    }

    public final synchronized Drawable e(Context context, int i) {
        Drawable drawableB;
        try {
            if (!this.d) {
                this.d = true;
                Drawable drawableD = d(context, R.drawable.abc_vector_test);
                if (drawableD == null || !"android.graphics.drawable.VectorDrawable".equals(drawableD.getClass().getName())) {
                    this.d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableB = b(context, i);
            if (drawableB == null) {
                drawableB = context.getDrawable(i);
            }
            if (drawableB != null) {
                drawableB = h(context, i, drawableB);
            }
            if (drawableB != null) {
                int[] iArr = wf0.a;
                String name = drawableB.getClass().getName();
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 29 && i2 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
                    int[] state = drawableB.getState();
                    if (state == null || state.length == 0) {
                        drawableB.setState(wf0.a);
                    } else {
                        drawableB.setState(wf0.b);
                    }
                    drawableB.setState(state);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableB;
    }

    public final synchronized ColorStateList g(Context context, int i) {
        ColorStateList colorStateList;
        mp2 mp2Var;
        WeakHashMap weakHashMap = this.a;
        ColorStateList colorStateListJ = null;
        colorStateList = (weakHashMap == null || (mp2Var = (mp2) weakHashMap.get(context)) == null) ? null : (ColorStateList) mp2Var.b(i);
        if (colorStateList == null) {
            lj1 lj1Var = this.e;
            if (lj1Var != null) {
                colorStateListJ = lj1Var.j(context, i);
            }
            if (colorStateListJ != null) {
                a(context, i, colorStateListJ);
            }
            colorStateList = colorStateListJ;
        }
        return colorStateList;
    }

    public final Drawable h(Context context, int i, Drawable drawable) {
        int iRound;
        PorterDuffColorFilter porterDuffColorFilterF;
        ColorStateList colorStateListG = g(context, i);
        if (colorStateListG != null) {
            int[] iArr = wf0.a;
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setTintList(colorStateListG);
            PorterDuff.Mode mode = null;
            if (this.e != null && i == R.drawable.abc_switch_thumb_material) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (mode != null) {
                drawableMutate.setTintMode(mode);
            }
            return drawableMutate;
        }
        lj1 lj1Var = this.e;
        int i2 = R.attr.colorControlNormal;
        if (lj1Var != null) {
            if (i == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int iB = h03.b(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = xe.b;
                lj1.l(drawableFindDrawableByLayerId, iB, mode2);
                lj1.l(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), h03.b(context, R.attr.colorControlNormal), mode2);
                lj1.l(layerDrawable.findDrawableByLayerId(android.R.id.progress), h03.b(context, R.attr.colorControlActivated), mode2);
                return drawable;
            }
            if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
                int iA = h03.a(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = xe.b;
                lj1.l(drawableFindDrawableByLayerId2, iA, mode3);
                lj1.l(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), h03.b(context, R.attr.colorControlActivated), mode3);
                lj1.l(layerDrawable2.findDrawableByLayerId(android.R.id.progress), h03.b(context, R.attr.colorControlActivated), mode3);
                return drawable;
            }
        }
        lj1 lj1Var2 = this.e;
        if (lj1Var2 != null) {
            PorterDuff.Mode mode4 = xe.b;
            boolean z = true;
            if (lj1.b(i, (int[]) lj1Var2.b)) {
                iRound = -1;
            } else {
                if (lj1.b(i, (int[]) lj1Var2.d)) {
                    i2 = R.attr.colorControlActivated;
                } else {
                    boolean zB = lj1.b(i, (int[]) lj1Var2.e);
                    i2 = android.R.attr.colorBackground;
                    if (zB) {
                        mode4 = PorterDuff.Mode.MULTIPLY;
                    } else if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                        iRound = Math.round(40.8f);
                        i2 = android.R.attr.colorForeground;
                    } else if (i != R.drawable.abc_dialog_material_background) {
                        i2 = 0;
                        z = false;
                    }
                }
                iRound = -1;
            }
            if (z) {
                int[] iArr2 = wf0.a;
                Drawable drawableMutate2 = drawable.mutate();
                int iB2 = h03.b(context, i2);
                synchronized (xe.class) {
                    porterDuffColorFilterF = f(iB2, mode4);
                }
                drawableMutate2.setColorFilter(porterDuffColorFilterF);
                if (iRound != -1) {
                    drawableMutate2.setAlpha(iRound);
                }
            }
        }
        return drawable;
    }
}
