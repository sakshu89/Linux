package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sz1 {
    public final List a;
    public final List[] b;
    public int c;
    public int d;
    public boolean e;
    public final /* synthetic */ tz1 f;

    public sz1(tz1 tz1Var, List list) {
        this.f = tz1Var;
        this.a = list;
        this.b = new List[list.size()];
        if (list.isEmpty()) {
            c11.a("NestedPrefetchController shouldn't be created with no states");
        }
    }
}
