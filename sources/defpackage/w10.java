package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w10 implements vq0, wq0, xq0, yq0, zq0, ar0, br0, cr0, gq0, iq0, kq0, lq0, mq0, nq0, oq0, pq0, qq0, sq0, tq0 {
    public final int a;
    public final boolean b;
    public rq0 c;
    public a42 e;
    public ArrayList f;

    public w10(int i, boolean z, rq0 rq0Var) {
        this.a = i;
        this.b = z;
        this.c = rq0Var;
    }

    @Override // defpackage.wq0
    public final /* bridge */ /* synthetic */ Object c(Object obj, Object obj2, Object obj3) {
        return h(obj, (x20) obj2, ((Number) obj3).intValue());
    }

    public final Object d(vk vkVar, Object obj, Object obj2, x20 x20Var, int i) {
        x20Var.X(this.a);
        m(x20Var);
        int iA = x20Var.f(this) ? yi4.a(2, 3) : yi4.a(1, 3);
        rq0 rq0Var = this.c;
        h33.c(5, rq0Var);
        Object objL = ((yq0) rq0Var).l(vkVar, obj, obj2, x20Var, Integer.valueOf(iA | i));
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new t10(this, vkVar, obj, obj2, i, 0);
        }
        return objL;
    }

    @Override // defpackage.vq0
    public final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        return f((x20) obj, ((Number) obj2).intValue());
    }

    public final Object f(x20 x20Var, int i) {
        x20Var.X(this.a);
        m(x20Var);
        int iA = i | (x20Var.f(this) ? yi4.a(2, 0) : yi4.a(1, 0));
        rq0 rq0Var = this.c;
        h33.c(2, rq0Var);
        Object objE = ((vq0) rq0Var).e(x20Var, Integer.valueOf(iA));
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new v10(2, this, w10.class, "invoke", "invoke(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", 8, 0);
        }
        return objE;
    }

    public final Object h(Object obj, x20 x20Var, int i) {
        x20Var.X(this.a);
        m(x20Var);
        int i2 = 1;
        int iA = x20Var.f(this) ? yi4.a(2, 1) : yi4.a(1, 1);
        rq0 rq0Var = this.c;
        h33.c(3, rq0Var);
        Object objC = ((wq0) rq0Var).c(obj, x20Var, Integer.valueOf(iA | i));
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gw(i, i2, this, obj);
        }
        return objC;
    }

    public final Object i(final Object obj, final Boolean bool, final Object obj2, final Object obj3, final Object obj4, x20 x20Var, final int i) {
        x20Var.X(this.a);
        m(x20Var);
        int iA = x20Var.f(this) ? yi4.a(2, 6) : yi4.a(1, 6);
        rq0 rq0Var = this.c;
        h33.c(8, rq0Var);
        Object objP = ((br0) rq0Var).p(obj, bool, obj2, obj3, obj4, x20Var, Integer.valueOf(i | iA));
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0() { // from class: u10
                @Override // defpackage.vq0
                public final Object e(Object obj5, Object obj6) {
                    ((Integer) obj6).getClass();
                    this.a.i(obj, bool, obj2, obj3, obj4, (x20) obj5, ny3.c(i) | 1);
                    return q43.a;
                }
            };
        }
        return objP;
    }

    public final Object k(Object obj, Object obj2, x20 x20Var, int i) {
        x20Var.X(this.a);
        m(x20Var);
        int iA = x20Var.f(this) ? yi4.a(2, 2) : yi4.a(1, 2);
        rq0 rq0Var = this.c;
        h33.c(4, rq0Var);
        Object objO = ((xq0) rq0Var).o(obj, obj2, x20Var, Integer.valueOf(iA | i));
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new mb(this, obj, obj2, i);
        }
        return objO;
    }

    @Override // defpackage.yq0
    public final /* bridge */ /* synthetic */ Object l(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return d((vk) obj, obj2, obj3, (x20) obj4, ((Number) obj5).intValue());
    }

    public final void m(x20 x20Var) {
        a42 a42VarX;
        if (!this.b || (a42VarX = x20Var.x()) == null) {
            return;
        }
        a42VarX.b |= 1;
        a42 a42Var = this.e;
        if (a42Var == null || !a42Var.a() || a42Var == a42VarX || g31.a(a42Var.c, a42VarX.c)) {
            this.e = a42VarX;
            return;
        }
        ArrayList arrayList = this.f;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            this.f = arrayList2;
            arrayList2.add(a42VarX);
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a42 a42Var2 = (a42) arrayList.get(i);
            if (a42Var2 == null || !a42Var2.a() || a42Var2 == a42VarX || g31.a(a42Var2.c, a42VarX.c)) {
                arrayList.set(i, a42VarX);
                return;
            }
        }
        arrayList.add(a42VarX);
    }

    @Override // defpackage.xq0
    public final /* bridge */ /* synthetic */ Object o(Object obj, Object obj2, Object obj3, Object obj4) {
        return k(obj, obj2, (x20) obj3, ((Number) obj4).intValue());
    }

    @Override // defpackage.br0
    public final /* bridge */ /* synthetic */ Object p(Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, x20 x20Var, Integer num) {
        return i(obj, bool, obj2, obj3, obj4, x20Var, num.intValue());
    }
}
