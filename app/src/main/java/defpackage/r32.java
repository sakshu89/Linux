package defpackage;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r32 implements ms4 {
    public final long a;
    public final Object b;
    public final Object c;
    public final Object e;

    public r32(mw2 mw2Var) {
        mw2Var.getClass();
        TimeUnit.MINUTES.getClass();
        this.a = 300000000000L;
        this.b = mw2Var.e();
        this.c = new qx0(this, cq.n(new StringBuilder(), z53.g, " ConnectionPool"));
        this.e = new ConcurrentLinkedQueue();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x002c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0031 A[SYNTHETIC] */
    public boolean a(w4 w4Var, m32 m32Var, ArrayList arrayList, boolean z) {
        Iterator it = ((ConcurrentLinkedQueue) this.e).iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            q32 q32Var = (q32) it.next();
            q32Var.getClass();
            synchronized (q32Var) {
                if (z) {
                    try {
                        if (!(q32Var.g != null)) {
                            continue;
                        } else if (q32Var.h(w4Var, arrayList)) {
                            m32Var.b(q32Var);
                            return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (q32Var.h(w4Var, arrayList)) {
                    m32Var.b(q32Var);
                    return true;
                }
            }
        }
    }

    public int b(q32 q32Var, long j) {
        byte[] bArr = z53.a;
        ArrayList arrayList = q32Var.p;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = "A connection to " + q32Var.b.a.h + " was leaked. Did you forget to close a response body?";
                ex1 ex1Var = ex1.a;
                ex1.a.j(((k32) reference).a, str);
                arrayList.remove(i);
                q32Var.j = true;
                if (arrayList.isEmpty()) {
                    q32Var.q = j - this.a;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    @Override // defpackage.ms4
    public t9 zza() {
        int allocationByteCount;
        sm4 sm4Var;
        rz2 rz2Var = (rz2) this.b;
        long j = this.a;
        in4 in4Var = (in4) this.c;
        k11 k11Var = (k11) this.e;
        b13 b13Var = new b13();
        cj cjVar = new cj();
        cjVar.b = Long.valueOf(j & Long.MAX_VALUE);
        cjVar.c = in4Var;
        cjVar.e = Boolean.valueOf(rz2.i);
        Boolean bool = Boolean.TRUE;
        cjVar.f = bool;
        cjVar.a = bool;
        b13Var.a = new xm4(cjVar);
        int i = k11Var.d;
        boolean z = false;
        if (i == -1) {
            Bitmap bitmap = k11Var.a;
            jg1.d(bitmap);
            allocationByteCount = bitmap.getAllocationByteCount();
        } else {
            if (i == 17 || i == 842094169) {
                jg1.d(null);
                throw null;
            }
            if (i == 35) {
                jg1.d(null);
                throw null;
            }
            allocationByteCount = 0;
        }
        cu2 cu2Var = new cu2(15, z);
        if (i == -1) {
            sm4Var = sm4.BITMAP;
        } else if (i == 35) {
            sm4Var = sm4.YUV_420_888;
        } else if (i == 842094169) {
            sm4Var = sm4.YV12;
        } else if (i != 16) {
            sm4Var = i != 17 ? sm4.UNKNOWN_FORMAT : sm4.NV21;
        } else {
            sm4Var = sm4.NV16;
        }
        cu2Var.b = sm4Var;
        cu2Var.c = Integer.valueOf(allocationByteCount & Integer.MAX_VALUE);
        b13Var.b = new tm4(cu2Var);
        wj1 wj1Var = new wj1(27, z);
        rz2Var.g.getClass();
        wj1Var.b = tq4.LATIN;
        b13Var.c = new uq4(wj1Var);
        qq4 qq4Var = new qq4(b13Var);
        lj1 lj1Var = new lj1(8);
        lj1Var.d = rz2Var.g.a() ? hn4.TYPE_THICK : hn4.TYPE_THIN;
        lj1Var.e = qq4Var;
        return new t9(lj1Var, 0);
    }

    public /* synthetic */ r32(rz2 rz2Var, long j, in4 in4Var, k11 k11Var) {
        this.b = rz2Var;
        this.a = j;
        this.c = in4Var;
        this.e = k11Var;
    }
}
