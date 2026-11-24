package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ha1 implements ba2, y92 {
    public final ca2 a;
    public final aa2 b;
    public final hm1 c;

    public ha1(ba2 ba2Var, Map map, aa2 aa2Var) {
        x0 x0Var = new x0(17, ba2Var);
        sr2 sr2Var = da2.a;
        this.a = new ca2(map, x0Var);
        this.b = aa2Var;
        hm1 hm1Var = za2.a;
        this.c = new hm1();
    }

    @Override // defpackage.ba2
    public final kf a(String str, fq0 fq0Var) {
        return this.a.a(str, fq0Var);
    }

    @Override // defpackage.y92
    public final void b(Object obj, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-858296452);
        if ((i & 6) == 0) {
            i2 = (x20Var.h(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(w10Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.h(this) ? 256 : 128;
        }
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            this.b.b(obj, w10Var, x20Var, i2 & 126);
            boolean zH = x20Var.h(this) | x20Var.h(obj);
            Object objL = x20Var.L();
            if (zH || objL == r20.a) {
                objL = new o0(11, this, obj);
                x20Var.g0(objL);
            }
            bz3.a(obj, (hq0) objL, x20Var);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new mb(this, obj, w10Var, i, 7);
        }
    }

    @Override // defpackage.ba2
    public final boolean c(Object obj) {
        return this.a.c(obj);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x004e A[LOOP:0: B:5:0x000d->B:17:0x004e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0051 A[EDGE_INSN: B:21:0x0051->B:18:0x0051 BREAK  A[LOOP:0: B:5:0x000d->B:17:0x004e], SYNTHETIC] */
    @Override // defpackage.ba2
    public final Map d() {
        hm1 hm1Var = this.c;
        Object[] objArr = hm1Var.b;
        long[] jArr = hm1Var.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            Object obj = objArr[(i << 3) + i3];
                            aa2 aa2Var = this.b;
                            if (aa2Var.b.k(obj) == null) {
                                aa2Var.a.remove(obj);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i != length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return this.a.d();
    }

    @Override // defpackage.ba2
    public final Object e(String str) {
        return this.a.e(str);
    }
}
