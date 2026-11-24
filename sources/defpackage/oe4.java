package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class oe4 {
    public static final boolean a(long j, long j2) {
        return j == j2;
    }

    public static ColorStateList b(Context context, int i) {
        ColorStateList colorStateListA;
        ColorStateList colorStateList;
        t62 t62Var;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        u62 u62Var = new u62(resources, theme);
        synchronized (w62.c) {
            try {
                SparseArray sparseArray = (SparseArray) w62.b.get(u62Var);
                colorStateListA = null;
                if (sparseArray == null || sparseArray.size() <= 0 || (t62Var = (t62) sparseArray.get(i)) == null) {
                    colorStateList = null;
                } else {
                    if (t62Var.b.equals(resources.getConfiguration())) {
                        if (theme != null || t62Var.c != 0) {
                            if (theme == null || t62Var.c != theme.hashCode()) {
                            }
                        }
                        colorStateList = t62Var.a;
                    }
                    sparseArray.remove(i);
                    colorStateList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ThreadLocal threadLocal = w62.a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            try {
                colorStateListA = e00.a(resources, resources.getXml(i), theme);
            } catch (Exception e) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        if (colorStateListA == null) {
            return resources.getColorStateList(i, theme);
        }
        synchronized (w62.c) {
            try {
                WeakHashMap weakHashMap = w62.b;
                SparseArray sparseArray2 = (SparseArray) weakHashMap.get(u62Var);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    weakHashMap.put(u62Var, sparseArray2);
                }
                sparseArray2.append(i, new t62(colorStateListA, u62Var.a.getConfiguration(), theme));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return colorStateListA;
    }
}
