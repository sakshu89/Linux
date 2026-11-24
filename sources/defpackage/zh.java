package defpackage;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zh {
    public nz0 b;
    public final Size d;
    public final int e;
    public final int f;
    public final boolean g;
    public final vg0 h;
    public final vg0 i;
    public es a = new pw(0);
    public final nz0 c = null;

    public zh(Size size, int i, int i2, boolean z, vg0 vg0Var, vg0 vg0Var2) {
        if (size == null) {
            dk0.n("Null size");
            throw null;
        }
        this.d = size;
        this.e = i;
        this.f = i2;
        this.g = z;
        this.h = vg0Var;
        this.i = vg0Var2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zh) {
            zh zhVar = (zh) obj;
            return this.d.equals(zhVar.d) && this.e == zhVar.e && this.f == zhVar.f && this.g == zhVar.g && this.h == zhVar.h && this.i == zhVar.i;
        }
        return false;
    }

    public final int hashCode() {
        return this.i.hashCode() ^ ((((((((((((this.d.hashCode() ^ 1000003) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ (this.g ? 1231 : 1237)) * 583896283) ^ 35) * 1000003) ^ this.h.hashCode()) * 1000003);
    }

    public final String toString() {
        return "In{size=" + this.d + ", inputFormat=" + this.e + ", outputFormat=" + this.f + ", virtualCamera=" + this.g + ", imageReaderProxyProvider=null, postviewSize=null, postviewImageFormat=35, requestEdge=" + this.h + ", errorEdge=" + this.i + "}";
    }
}
