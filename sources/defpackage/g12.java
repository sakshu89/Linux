package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g12 {
    public final int a;
    public final kf b;
    public final Rect c;
    public final int d;
    public final int e;
    public final Matrix f;
    public final j62 g;
    public final String h;
    public final wc1 j;
    public int k = -1;
    public final ArrayList i = new ArrayList();

    public g12(jw jwVar, kf kfVar, Rect rect, int i, int i2, Matrix matrix, j62 j62Var, wc1 wc1Var, int i3) {
        this.a = i3;
        this.b = kfVar;
        this.e = i2;
        this.d = i;
        this.c = rect;
        this.f = matrix;
        this.g = j62Var;
        this.h = String.valueOf(jwVar.hashCode());
        List<uw> list = jwVar.a;
        Objects.requireNonNull(list);
        for (uw uwVar : list) {
            ArrayList arrayList = this.i;
            uwVar.getClass();
            arrayList.add(0);
        }
        this.j = wc1Var;
    }
}
