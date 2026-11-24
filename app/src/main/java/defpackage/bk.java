package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bk {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(bk.class, "notCompletedCount$volatile");
    public final qb0[] a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    public bk(qb0[] qb0VarArr) {
        this.a = qb0VarArr;
        this.notCompletedCount$volatile = qb0VarArr.length;
    }
}
