package defpackage;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xo {
    public final BigDecimal a;
    public final boolean b;

    public xo(BigDecimal bigDecimal, boolean z) {
        this.a = bigDecimal;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xo)) {
            return false;
        }
        xo xoVar = (xo) obj;
        return this.a.equals(xoVar.a) && this.b == xoVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Value(value=" + this.a + ", approximate=" + this.b + ")";
    }
}
