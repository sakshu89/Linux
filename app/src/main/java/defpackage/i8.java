package defpackage;

import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i8 extends k61 implements vq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i8(r7 r7Var, vq0 vq0Var, int i) {
        super(2);
        this.b = 0;
        this.c = r7Var;
        this.e = vq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.b;
        q43 q43Var = q43.a;
        Object obj3 = this.e;
        Object obj4 = this.c;
        switch (i) {
            case 0:
                ((Number) obj2).intValue();
                AndroidCompositionLocals_androidKt.a((r7) obj4, (vq0) obj3, (x20) obj, ny3.c(1));
                break;
            case 1:
                int iIntValue = ((Number) obj).intValue();
                gg2 gg2Var = (gg2) obj2;
                q8 q8Var = (q8) obj3;
                if (!((hg2) obj4).b.b(gg2Var.g)) {
                    q8Var.h(iIntValue, gg2Var);
                    q8Var.k.s(q43Var);
                }
                break;
            case 2:
                x20 x20Var = (x20) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (!x20Var.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    x20Var.R();
                } else {
                    Boolean bool = (Boolean) ((t71) obj4).g.getValue();
                    boolean zBooleanValue = bool.booleanValue();
                    vq0 vq0Var = (vq0) obj3;
                    x20Var.Y(bool);
                    boolean zG = x20Var.g(zBooleanValue);
                    if (zBooleanValue) {
                        vq0Var.e(x20Var, 0);
                    } else {
                        if (x20Var.l != 0) {
                            y20.a("No nodes can be emitted before calling deactivateToEndGroup");
                        }
                        if (!x20Var.S) {
                            if (zG) {
                                nl2 nl2Var = x20Var.G;
                                int i2 = nl2Var.g;
                                int i3 = nl2Var.h;
                                s20 s20Var = x20Var.M;
                                s20Var.getClass();
                                s20Var.d(false);
                                s20Var.b.a.e(yq1.c);
                                jy3.a(x20Var.s, i2, i3);
                                x20Var.G.t();
                            } else {
                                x20Var.Q();
                            }
                        }
                    }
                    if (x20Var.y && x20Var.G.i == x20Var.z) {
                        x20Var.z = -1;
                        x20Var.y = false;
                    }
                    x20Var.p(false);
                }
                break;
            default:
                cw cwVar = (cw) obj;
                vu0 vu0Var = (vu0) obj2;
                co1 co1Var = (co1) obj4;
                n71 n71Var = co1Var.x;
                if (!n71Var.I()) {
                    co1Var.t0 = true;
                } else {
                    co1Var.q0 = cwVar;
                    co1Var.p0 = vu0Var;
                    lt1 snapshotObserver = ((r7) q71.a(n71Var)).getSnapshotObserver();
                    r72 r72Var = co1.v0;
                    snapshotObserver.a.c(co1Var, j7.l0, (bo1) obj3);
                    co1Var.t0 = false;
                }
                break;
        }
        return q43Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i8(int i, Object obj, Object obj2) {
        super(2);
        this.b = i;
        this.c = obj;
        this.e = obj2;
    }
}
