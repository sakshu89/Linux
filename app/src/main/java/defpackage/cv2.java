package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cv2 implements f81, Serializable {
    public fq0 a;
    public volatile Object b;
    public final Object c;

    public cv2(fq0 fq0Var) {
        fq0Var.getClass();
        this.a = fq0Var;
        this.b = fl4.n;
        this.c = this;
    }

    @Override // defpackage.f81
    public final Object getValue() {
        Object objA;
        Object obj = this.b;
        fl4 fl4Var = fl4.n;
        if (obj != fl4Var) {
            return obj;
        }
        synchronized (this.c) {
            objA = this.b;
            if (objA == fl4Var) {
                fq0 fq0Var = this.a;
                fq0Var.getClass();
                objA = fq0Var.a();
                this.b = objA;
                this.a = null;
            }
        }
        return objA;
    }

    public final String toString() {
        return this.b != fl4.n ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
