package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ej1 implements zk0 {
    public final z70 a;
    public final z70 b;

    public ej1(z70 z70Var, z70 z70Var2) {
        this.a = z70Var;
        this.b = z70Var2;
    }

    @Override // defpackage.c22
    public final Object get() {
        return new dj1((Context) this.a.b, (kf) this.b.get());
    }
}
