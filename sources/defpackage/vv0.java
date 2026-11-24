package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vv0 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ vv0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((Runnable) obj).run();
                return null;
            case 1:
                return ab1.c.a(((nk4) obj).g);
            case 2:
                return ab1.c.a(((zq4) obj).a);
            default:
                return ab1.c.a(((ns4) obj).g);
        }
    }
}
