package defpackage;

import android.util.LongSparseArray;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationResponse;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tc4 {
    public static final long a() {
        return Thread.currentThread().getId();
    }

    public static void b(q8 q8Var, LongSparseArray longSparseArray) {
        TranslationResponseValue value;
        CharSequence text;
        ig2 ig2Var;
        gg2 gg2Var;
        hq0 hq0Var;
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            long jKeyAt = longSparseArray.keyAt(i);
            ViewTranslationResponse viewTranslationResponseL = a7.l(longSparseArray.get(jKeyAt));
            if (viewTranslationResponseL != null && (value = viewTranslationResponseL.getValue("android:text")) != null && (text = value.getText()) != null && (ig2Var = (ig2) q8Var.c().b((int) jKeyAt)) != null && (gg2Var = ig2Var.a) != null) {
                Object objG = gg2Var.d.a.g(bg2.l);
                if (objG == null) {
                    objG = null;
                }
                b2 b2Var = (b2) objG;
                if (b2Var != null && (hq0Var = (hq0) b2Var.b) != null) {
                }
            }
        }
    }
}
