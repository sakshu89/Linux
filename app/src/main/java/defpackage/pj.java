package defpackage;

import android.util.Base64;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pj {
    public final String a;
    public final byte[] b;
    public final v02 c;

    public pj(String str, byte[] bArr, v02 v02Var) {
        this.a = str;
        this.b = bArr;
        this.c = v02Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof pj) {
            pj pjVar = (pj) obj;
            if (this.a.equals(pjVar.a) && Arrays.equals(this.b, pjVar.b) && this.c.equals(pjVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() ^ ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003);
    }

    public final String toString() {
        byte[] bArr = this.b;
        String strEncodeToString = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        return cq.n(sb, strEncodeToString, ")");
    }
}
