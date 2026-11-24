package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gl0 {
    public static final /* synthetic */ int c = 0;
    public final tl2 a = tl2.f();
    public boolean b;

    static {
        new gl0(0);
    }

    public gl0(int i) {
        a();
        a();
    }

    public static void b(kz kzVar, jc3 jc3Var, int i, Object obj) {
        if (jc3Var == jc3.e) {
            kzVar.B(i, 3);
            ((j1) obj).b(kzVar);
            kzVar.B(i, 4);
        }
        kzVar.B(i, jc3Var.b);
        switch (jc3Var.ordinal()) {
            case 0:
                kzVar.u(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                kzVar.s(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                kzVar.F(((Long) obj).longValue());
                break;
            case 3:
                kzVar.F(((Long) obj).longValue());
                break;
            case 4:
                kzVar.w(((Integer) obj).intValue());
                break;
            case 5:
                kzVar.u(((Long) obj).longValue());
                break;
            case 6:
                kzVar.s(((Integer) obj).intValue());
                break;
            case 7:
                kzVar.m(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof no)) {
                    kzVar.A((String) obj);
                } else {
                    kzVar.q((no) obj);
                }
                break;
            case 9:
                ((j1) obj).b(kzVar);
                break;
            case 10:
                j1 j1Var = (j1) obj;
                kzVar.D(((yt0) j1Var).a(null));
                j1Var.b(kzVar);
                break;
            case 11:
                if (!(obj instanceof no)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    kzVar.D(length);
                    kzVar.n(bArr, 0, length);
                } else {
                    kzVar.q((no) obj);
                }
                break;
            case 12:
                kzVar.D(((Integer) obj).intValue());
                break;
            case 13:
                kzVar.w(((Integer) obj).intValue());
                break;
            case 14:
                kzVar.s(((Integer) obj).intValue());
                break;
            case 15:
                kzVar.u(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                kzVar.D((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                kzVar.F((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        if (this.b) {
            return;
        }
        tl2 tl2Var = this.a;
        int size = tl2Var.a.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entryC = tl2Var.c(i);
            if (entryC.getValue() instanceof yt0) {
                yt0 yt0Var = (yt0) entryC.getValue();
                yt0Var.getClass();
                w12 w12Var = w12.c;
                w12Var.getClass();
                w12Var.a(yt0Var.getClass()).c(yt0Var);
                yt0Var.h();
            }
        }
        if (!tl2Var.c) {
            if (tl2Var.a.size() > 0) {
                tl2Var.c(0).getKey().getClass();
                dk0.t();
                return;
            } else {
                Iterator it = tl2Var.d().iterator();
                if (it.hasNext()) {
                    ((Map.Entry) it.next()).getKey().getClass();
                    dk0.t();
                    return;
                }
            }
        }
        if (!tl2Var.c) {
            tl2Var.b = tl2Var.b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(tl2Var.b);
            tl2Var.f = tl2Var.f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(tl2Var.f);
            tl2Var.c = true;
        }
        this.b = true;
    }

    public final Object clone() {
        gl0 gl0Var = new gl0();
        tl2 tl2Var = this.a;
        if (tl2Var.a.size() > 0) {
            Map.Entry entryC = tl2Var.c(0);
            if (entryC.getKey() != null) {
                dk0.t();
                return null;
            }
            entryC.getValue();
            throw null;
        }
        Iterator it = tl2Var.d().iterator();
        if (!it.hasNext()) {
            return gl0Var;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            dk0.t();
            return null;
        }
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof gl0) {
            return this.a.equals(((gl0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public gl0() {
    }
}
