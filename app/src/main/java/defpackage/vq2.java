package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vq2 implements yl0 {
    public final float a;
    public final float b;
    public final Object c;

    public vq2(float f, float f2, Object obj) {
        this.a = f;
        this.b = f2;
        this.c = obj;
    }

    @Override // defpackage.pd
    public final s63 a(g33 g33Var) {
        Object obj = this.c;
        return new wj1(this.a, this.b, obj == null ? null : (vd) g33Var.a.j(obj));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof vq2) {
            vq2 vq2Var = (vq2) obj;
            if (vq2Var.a == this.a && vq2Var.b == this.b && g31.a(vq2Var.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.c;
        return Float.hashCode(this.b) + cq.b((obj != null ? obj.hashCode() : 0) * 31, this.a, 31);
    }

    public /* synthetic */ vq2(Object obj) {
        this(1.0f, 1500.0f, obj);
    }
}
