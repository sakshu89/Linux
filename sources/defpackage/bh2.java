package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bh2 implements Iterable, x41 {
    public final /* synthetic */ hc0 a;

    public bh2(hc0 hc0Var) {
        this.a = hc0Var;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new gc0(this.a);
    }
}
