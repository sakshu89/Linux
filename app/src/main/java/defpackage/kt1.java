package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kt1 extends k61 implements hq0 {
    public static final kt1 H;
    public static final kt1 X;
    public static final kt1 Y;
    public static final kt1 c;
    public static final kt1 e;
    public static final kt1 f;
    public static final kt1 i;
    public static final kt1 j;
    public static final kt1 k;
    public static final kt1 n;
    public static final kt1 s;
    public static final kt1 t;
    public static final kt1 u;
    public static final kt1 v;
    public static final kt1 w;
    public static final kt1 x;
    public final /* synthetic */ int b;

    static {
        int i2 = 1;
        c = new kt1(i2, 0);
        e = new kt1(i2, 1);
        f = new kt1(i2, 2);
        i = new kt1(i2, 3);
        j = new kt1(i2, 4);
        k = new kt1(i2, 5);
        n = new kt1(i2, 6);
        s = new kt1(i2, 7);
        t = new kt1(i2, 8);
        u = new kt1(i2, 9);
        v = new kt1(i2, 10);
        w = new kt1(i2, 11);
        x = new kt1(i2, 12);
        H = new kt1(i2, 13);
        X = new kt1(i2, 14);
        Y = new kt1(i2, 15);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kt1(int i2) {
        super(1);
        this.b = 17;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i2 = this.b;
        q43 q43Var = q43.a;
        switch (i2) {
            case 0:
                n71 n71Var = (n71) obj;
                if (n71Var.H()) {
                    n71Var.U(false);
                }
                return q43Var;
            case 1:
                n71 n71Var2 = (n71) obj;
                if (n71Var2.H()) {
                    n71Var2.S(false);
                }
                return q43Var;
            case 2:
                n71 n71Var3 = (n71) obj;
                if (n71Var3.H()) {
                    n71Var3.S(false);
                }
                return q43Var;
            case 3:
                n71 n71Var4 = (n71) obj;
                if (n71Var4.H()) {
                    n71.T(n71Var4, false, 7);
                }
                return q43Var;
            case 4:
                n71 n71Var5 = (n71) obj;
                if (n71Var5.H()) {
                    n71.V(n71Var5, false, 7);
                }
                return q43Var;
            case 5:
                n71 n71Var6 = (n71) obj;
                if (n71Var6.H()) {
                    n71Var6.F();
                }
                return q43Var;
            case 6:
                return q43Var;
            case 7:
                yy1 yy1Var = (yy1) obj;
                if (yy1Var.isAttachedToWindow()) {
                    yy1Var.l();
                }
                return q43Var;
            case 8:
                ((Context) obj).getClass();
                return ii0.a;
            case 9:
                return q43Var;
            case 10:
                return Integer.valueOf(((fd2) obj).b);
            case 11:
                i21 i21Var = ((fd2) obj).c;
                return Integer.valueOf(i21Var.d - i21Var.b);
            case 12:
                return q43Var;
            case 13:
                int i3 = ((jz0) obj).a;
                return q43Var;
            case 14:
                return q43Var;
            case 15:
                int i4 = ((jz0) obj).a;
                return q43Var;
            case 16:
                g23 g23Var = (g23) obj;
                si0 si0Var = si0.a;
                si0 si0Var2 = si0.b;
                if (g23Var.a(si0Var, si0Var2)) {
                    return yi0.b;
                }
                return g23Var.a(si0Var2, si0.c) ? yi0.b : yi0.b;
            case 17:
                return Boolean.valueOf(((ko0) obj).I0());
            case 18:
                ((ww0) obj).getClass();
                return Boolean.TRUE;
            default:
                mg2.c((og2) obj);
                return q43Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ kt1(int i2, int i3) {
        super(i2);
        this.b = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ kt1(int i2, Object obj) {
        super(1);
        this.b = i2;
    }
}
