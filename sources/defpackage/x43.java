package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x43 implements f81, Serializable {
    public fq0 a;
    public Object b;

    @Override // defpackage.f81
    public final Object getValue() {
        if (this.b == fl4.n) {
            fq0 fq0Var = this.a;
            fq0Var.getClass();
            this.b = fq0Var.a();
            this.a = null;
        }
        return this.b;
    }

    public final String toString() {
        return this.b != fl4.n ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
