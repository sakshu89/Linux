package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kk4 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ jk2 b;

    public /* synthetic */ kk4(jk2 jk2Var, int i) {
        this.a = i;
        this.b = jk2Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.b.a();
    }
}
