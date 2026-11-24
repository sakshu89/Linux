package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vk1 {
    public final long a;
    public final long b;
    public final boolean c;

    public vk1(long j, long j2, boolean z) {
        this.a = j;
        this.b = j2;
        this.c = z;
    }

    public final vk1 a(vk1 vk1Var) {
        return new vk1(jp1.e(this.a, vk1Var.a), Math.max(this.b, vk1Var.b), this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vk1)) {
            return false;
        }
        vk1 vk1Var = (vk1) obj;
        return jp1.b(this.a, vk1Var.a) && this.b == vk1Var.b && this.c == vk1Var.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + cq.c(Long.hashCode(this.a) * 31, 31, this.b);
    }

    public final String toString() {
        return "MouseWheelScrollDelta(value=" + ((Object) jp1.g(this.a)) + ", timeMillis=" + this.b + ", shouldApplyImmediately=" + this.c + ')';
    }
}
