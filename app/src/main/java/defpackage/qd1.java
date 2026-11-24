package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qd1 {
    public final long a;
    public final byte[] b;
    public final long c;
    public final boolean d;

    public qd1(long j, byte[] bArr, long j2, int i) {
        bArr = (i & 2) != 0 ? new byte[0] : bArr;
        boolean z = (i & 8) == 0;
        this.a = j;
        this.b = bArr;
        this.c = j2;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qd1)) {
            return false;
        }
        qd1 qd1Var = (qd1) obj;
        return this.a == qd1Var.a && this.b.equals(qd1Var.b) && this.c == qd1Var.c && this.d == qd1Var.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + cq.c((Arrays.hashCode(this.b) + (Long.hashCode(this.a) * 31)) * 31, 31, this.c);
    }

    public final String toString() {
        String string = Arrays.toString(this.b);
        StringBuilder sb = new StringBuilder("LivePcmPacket(epoch=");
        sb.append(this.a);
        sb.append(", bytes=");
        sb.append(string);
        sb.append(", replySequence=");
        sb.append(this.c);
        sb.append(", turnComplete=");
        return ky0.o(sb, this.d, ")");
    }
}
