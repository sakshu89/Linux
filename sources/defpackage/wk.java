package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wk implements lx2 {
    public final w10 a;
    public final xm1 b = new xm1();
    public final ku1 c = o44.g(null);

    public wk(w10 w10Var) {
        this.a = w10Var;
    }

    @Override // defpackage.lx2
    public final Object a(dx2 dx2Var, nu2 nu2Var) {
        x50 x50Var = null;
        ec ecVar = new ec(this, new vk(dx2Var), x50Var, 1);
        xm1 xm1Var = this.b;
        xm1Var.getClass();
        Object objC = tl4.c(new cd(xm1Var, ecVar, x50Var, 3), nu2Var);
        return objC == t70.a ? objC : q43.a;
    }

    public final void b(final fq0 fq0Var, x20 x20Var, final int i) {
        final fq0 fq0Var2;
        x20 x20Var2;
        x20Var.X(723898654);
        int i2 = (x20Var.f(this) ? 32 : 16) | i;
        final int i3 = 0;
        final int i4 = 1;
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            vk vkVar = (vk) this.c.getValue();
            if (vkVar == null) {
                a42 a42VarR = x20Var.r();
                if (a42VarR != null) {
                    a42VarR.d = new vq0(this, fq0Var, i, i3) { // from class: uk
                        public final /* synthetic */ int a;
                        public final /* synthetic */ wk b;
                        public final /* synthetic */ fq0 c;

                        {
                            this.a = i3;
                            this.b = this;
                        }

                        @Override // defpackage.vq0
                        public final Object e(Object obj, Object obj2) {
                            int i5 = this.a;
                            q43 q43Var = q43.a;
                            fq0 fq0Var3 = this.c;
                            wk wkVar = this.b;
                            x20 x20Var3 = (x20) obj;
                            ((Integer) obj2).getClass();
                            switch (i5) {
                                case 0:
                                    wkVar.b(fq0Var3, x20Var3, ny3.c(7));
                                    break;
                                default:
                                    wkVar.b(fq0Var3, x20Var3, ny3.c(7));
                                    break;
                            }
                            return q43Var;
                        }
                    };
                    return;
                }
                return;
            }
            fq0Var2 = fq0Var;
            x20Var2 = x20Var;
            this.a.l(vkVar, vkVar.a, fq0Var2, x20Var2, Integer.valueOf(CollationFastLatin.LATIN_LIMIT));
        } else {
            fq0Var2 = fq0Var;
            x20Var2 = x20Var;
            x20Var2.R();
        }
        a42 a42VarR2 = x20Var2.r();
        if (a42VarR2 != null) {
            a42VarR2.d = new vq0(this, fq0Var2, i, i4) { // from class: uk
                public final /* synthetic */ int a;
                public final /* synthetic */ wk b;
                public final /* synthetic */ fq0 c;

                {
                    this.a = i4;
                    this.b = this;
                }

                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    int i5 = this.a;
                    q43 q43Var = q43.a;
                    fq0 fq0Var3 = this.c;
                    wk wkVar = this.b;
                    x20 x20Var3 = (x20) obj;
                    ((Integer) obj2).getClass();
                    switch (i5) {
                        case 0:
                            wkVar.b(fq0Var3, x20Var3, ny3.c(7));
                            break;
                        default:
                            wkVar.b(fq0Var3, x20Var3, ny3.c(7));
                            break;
                    }
                    return q43Var;
                }
            };
        }
    }
}
