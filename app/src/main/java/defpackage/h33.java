package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class h33 {
    public static final py0 a = new py0(16, "RESUME_TOKEN");

    public static final void a(ll1 ll1Var, int i) {
        if (ll1Var.b == 0 || !(ll1Var.c(0) == i || ll1Var.c(ll1Var.b - 1) == i)) {
            int i2 = ll1Var.b;
            ll1Var.a(i);
            while (i2 > 0) {
                int i3 = ((i2 + 1) >>> 1) - 1;
                int iC = ll1Var.c(i3);
                if (i <= iC) {
                    break;
                }
                ll1Var.f(i2, iC);
                i2 = i3;
            }
            ll1Var.f(i2, i);
        }
    }

    public static Map b(Object obj) {
        if ((obj instanceof x41) && !(obj instanceof z41)) {
            f(obj, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            g31.e(e, h33.class.getName());
            throw e;
        }
    }

    public static void c(int i, Object obj) {
        if (obj == null || d(i, obj)) {
            return;
        }
        f(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static boolean d(int i, Object obj) {
        int iB;
        if (obj instanceof rq0) {
            if (obj instanceof fr0) {
                iB = ((fr0) obj).b();
            } else if (obj instanceof fq0) {
                iB = 0;
            } else if (obj instanceof hq0) {
                iB = 1;
            } else if (obj instanceof vq0) {
                iB = 2;
            } else if (obj instanceof wq0) {
                iB = 3;
            } else if (obj instanceof xq0) {
                iB = 4;
            } else if (obj instanceof yq0) {
                iB = 5;
            } else if (obj instanceof zq0) {
                iB = 6;
            } else if (obj instanceof ar0) {
                iB = 7;
            } else if (obj instanceof br0) {
                iB = 8;
            } else if (obj instanceof cr0) {
                iB = 9;
            } else if (obj instanceof gq0) {
                iB = 10;
            } else if (obj instanceof iq0) {
                iB = 11;
            } else if (obj instanceof kq0) {
                iB = 13;
            } else if (obj instanceof lq0) {
                iB = 14;
            } else if (obj instanceof mq0) {
                iB = 15;
            } else if (obj instanceof nq0) {
                iB = 16;
            } else if (obj instanceof oq0) {
                iB = 17;
            } else if (obj instanceof pq0) {
                iB = 18;
            } else if (obj instanceof qq0) {
                iB = 19;
            } else if (obj instanceof sq0) {
                iB = 20;
            } else {
                iB = obj instanceof tq0 ? 21 : -1;
            }
            if (iB == i) {
                return true;
            }
        }
        return false;
    }

    public static final int e(ll1 ll1Var) {
        int iC;
        int i = ll1Var.b;
        int iC2 = ll1Var.c(0);
        while (ll1Var.b != 0 && ll1Var.c(0) == iC2) {
            ll1Var.f(0, ll1Var.d());
            ll1Var.e(ll1Var.b - 1);
            int i2 = ll1Var.b;
            int i3 = i2 >>> 1;
            int i4 = 0;
            while (i4 < i3) {
                int iC3 = ll1Var.c(i4);
                int i5 = (i4 + 1) * 2;
                int i6 = i5 - 1;
                int iC4 = ll1Var.c(i6);
                if (i5 < i2 && (iC = ll1Var.c(i5)) > iC4) {
                    if (iC <= iC3) {
                        break;
                    }
                    ll1Var.f(i4, iC);
                    ll1Var.f(i5, iC3);
                    i4 = i5;
                } else {
                    if (iC4 <= iC3) {
                        break;
                    }
                    ll1Var.f(i4, iC4);
                    ll1Var.f(i6, iC3);
                    i4 = i6;
                }
            }
        }
        return iC2;
    }

    public static void f(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(cq.k(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        g31.e(classCastException, h33.class.getName());
        throw classCastException;
    }
}
