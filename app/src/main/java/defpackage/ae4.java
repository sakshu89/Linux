package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ae4 {
    public ae4() {
        new ConcurrentHashMap();
    }

    public static final float[] e(List list, List list2) {
        if (list == null) {
            return null;
        }
        float[] fArr = new float[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = ((Number) it.next()).floatValue();
            i++;
        }
        return fArr;
    }

    public static final void f(List list, List list2) {
        if (list2 == null) {
            if (list.size() >= 2) {
                return;
            }
            og.i("colors must have length of at least 2 if colorStops is omitted.");
        } else {
            if (list.size() == list2.size()) {
                return;
            }
            og.i("colors and colorStops arguments must have equal length.");
        }
    }

    public abstract Typeface a(Context context, fp0 fp0Var, Resources resources, int i);

    public abstract Typeface b(Context context, pp0[] pp0VarArr, int i);

    public Typeface c(Context context, List list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public abstract Typeface d(Context context, Resources resources, int i, String str);
}
