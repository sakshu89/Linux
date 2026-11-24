package defpackage;

import com.ibm.icu.impl.number.Padder;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xt1 {
    public final Object a;
    public final Object b;

    public xt1(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof xt1)) {
            return false;
        }
        xt1 xt1Var = (xt1) obj;
        return xt1Var.a.equals(this.a) && xt1Var.b.equals(this.b);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    public final String toString() {
        return "Pair{" + this.a + Padder.FALLBACK_PADDING_STRING + this.b + "}";
    }
}
