package defpackage;

import android.R;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public enum kx2 {
    /* JADX INFO: Fake field, exist only in values array */
    Cut(ta4.a, R.string.cut, R.attr.actionModeCutDrawable),
    /* JADX INFO: Fake field, exist only in values array */
    Copy(ta4.b, R.string.copy, R.attr.actionModeCopyDrawable),
    /* JADX INFO: Fake field, exist only in values array */
    Paste(ta4.c, R.string.paste, R.attr.actionModePasteDrawable),
    /* JADX INFO: Fake field, exist only in values array */
    SelectAll(ta4.d, R.string.selectAll, R.attr.actionModeSelectAllDrawable),
    Autofill(ta4.e, Build.VERSION.SDK_INT <= 26 ? com.project.sonic.R.string.androidx_compose_foundation_autofill : R.string.autofill, 0);

    public final Object a;
    public final int b;
    public final int c;

    kx2(Object obj, int i, int i2) {
        this.a = obj;
        this.b = i;
        this.c = i2;
    }
}
