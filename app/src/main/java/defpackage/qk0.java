package defpackage;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qk0 {
    public final BigDecimal a;
    public final boolean b;

    public qk0(BigDecimal bigDecimal, boolean z) {
        this.a = bigDecimal;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qk0)) {
            return false;
        }
        qk0 qk0Var = (qk0) obj;
        return this.a.equals(qk0Var.a) && this.b == qk0Var.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Operand(number=" + this.a + ", approximate=" + this.b + ")";
    }
}
