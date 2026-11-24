package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q33 {
    public static final ThreadLocal d = new ThreadLocal();
    public final int a;
    public final p6 b;
    public volatile int c = 0;

    public q33(p6 p6Var, int i) {
        this.b = p6Var;
        this.a = i;
    }

    public final int a(int i) {
        gj1 gj1VarB = b();
        int iA = gj1VarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) gj1VarB.e;
        int i2 = iA + gj1VarB.a;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final gj1 b() {
        ThreadLocal threadLocal = d;
        gj1 gj1Var = (gj1) threadLocal.get();
        if (gj1Var == null) {
            gj1Var = new gj1();
            threadLocal.set(gj1Var);
        }
        hj1 hj1Var = (hj1) this.b.a;
        int iA = hj1Var.a(6);
        if (iA != 0) {
            int i = iA + hj1Var.a;
            int i2 = (this.a * 4) + ((ByteBuffer) hj1Var.e).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) hj1Var.e).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) hj1Var.e;
            gj1Var.e = byteBuffer;
            if (byteBuffer != null) {
                gj1Var.a = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                gj1Var.b = i4;
                gj1Var.c = ((ByteBuffer) gj1Var.e).getShort(i4);
                return gj1Var;
            }
            gj1Var.a = 0;
            gj1Var.b = 0;
            gj1Var.c = 0;
        }
        return gj1Var;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        gj1 gj1VarB = b();
        int iA = gj1VarB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) gj1VarB.e).getInt(iA + gj1VarB.a) : 0));
        sb.append(", codepoints:");
        gj1 gj1VarB2 = b();
        int iA2 = gj1VarB2.a(16);
        if (iA2 != 0) {
            int i2 = iA2 + gj1VarB2.a;
            i = ((ByteBuffer) gj1VarB2.e).getInt(((ByteBuffer) gj1VarB2.e).getInt(i2) + i2);
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(Integer.toHexString(a(i3)));
            sb.append(Padder.FALLBACK_PADDING_STRING);
        }
        return sb.toString();
    }
}
