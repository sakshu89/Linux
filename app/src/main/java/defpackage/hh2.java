package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hh2 implements ih2 {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final ih2 b;

    public hh2(ih2 ih2Var) {
        this.b = ih2Var;
    }

    @Override // defpackage.ih2
    public final void a(kh2 kh2Var) {
        if (this.a.get()) {
            return;
        }
        this.b.a(kh2Var);
    }

    public final void b() {
        this.a.set(true);
    }
}
