package defpackage;

import android.graphics.Rect;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tw2 extends sw2 {
    public final AbstractList d;

    public tw2(vs4 vs4Var) {
        super(vs4Var.a, vs4Var.b, vs4Var.c, vs4Var.e, null);
        this.d = jh4.b(vs4Var.f, new el1(23));
    }

    public tw2(String str, Rect rect, List list, String str2, AbstractList abstractList) {
        super(str, rect, list, str2, null);
        this.d = abstractList;
    }
}
