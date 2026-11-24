package defpackage;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z14 extends PhantomReference {
    public final Set a;
    public final t5 b;

    public /* synthetic */ z14(hy hyVar, ReferenceQueue referenceQueue, Set set, t5 t5Var) {
        super(hyVar, referenceQueue);
        this.a = set;
        this.b = t5Var;
    }
}
