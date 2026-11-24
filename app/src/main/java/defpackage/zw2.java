package defpackage;

import android.text.PrecomputedText;
import android.view.textclassifier.TextClassificationContext;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class zw2 {
    public static /* synthetic */ TextClassificationContext.Builder c(String str, String str2) {
        return new TextClassificationContext.Builder(str, str2);
    }

    public static /* synthetic */ void f() {
    }

    public static /* bridge */ /* synthetic */ boolean j(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }
}
