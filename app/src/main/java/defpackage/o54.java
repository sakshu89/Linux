package defpackage;

import android.text.Spanned;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class o54 {
    public static final py0 a;
    public static final py0 b;

    static {
        int i = 16;
        a = new py0(i, "NONE");
        b = new py0(i, "PENDING");
    }

    public static final jr2 a(Object obj) {
        if (obj == null) {
            obj = s24.a;
        }
        return new jr2(obj);
    }

    public static final boolean b(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }
}
