package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jd2 implements jt1 {
    public final int a;
    public final List b;
    public Float c = null;
    public Float e = null;
    public ed2 f = null;
    public ed2 i = null;

    public jd2(int i, ArrayList arrayList) {
        this.a = i;
        this.b = arrayList;
    }

    @Override // defpackage.jt1
    public final boolean y() {
        return this.b.contains(this);
    }
}
