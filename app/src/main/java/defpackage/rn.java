package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rn extends gr0 implements wq0 {
    public static final rn k = new rn(3, un.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        un unVar = (un) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = un.b;
        unVar.getClass();
        if (obj3 == wn.l) {
            obj3 = new kx(unVar.t());
        }
        return new mx(obj3);
    }
}
