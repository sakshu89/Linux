package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ni0 {
    public final qi0 a;
    public final byte[] b;

    public ni0(qi0 qi0Var, byte[] bArr) {
        if (qi0Var == null) {
            dk0.n("encoding is null");
            throw null;
        }
        if (bArr == null) {
            dk0.n("bytes is null");
            throw null;
        }
        this.a = qi0Var;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ni0)) {
            return false;
        }
        ni0 ni0Var = (ni0) obj;
        if (this.a.equals(ni0Var.a)) {
            return Arrays.equals(this.b, ni0Var.b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b) ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.a + ", bytes=[...]}";
    }
}
