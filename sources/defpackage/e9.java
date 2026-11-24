package defpackage;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e9 implements PointerInputEventHandler {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e9(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(ry1 ry1Var, x50 x50Var) {
        int i = this.a;
        int i2 = 1;
        x50 x50Var2 = null;
        Object obj = this.b;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                Object objB = ao4.b(ry1Var, new b82((f9) obj, x50Var2, 2), x50Var);
                return objB == t70Var ? objB : q43Var;
            case 1:
                ny2 ny2Var = (ny2) obj;
                s9 s9Var = ny2Var.A;
                ly2 ly2Var = ny2Var.z;
                tu2 tu2Var = (tu2) ry1Var;
                tu2Var.getClass();
                Object objB2 = ao4.b(ry1Var, new pf2(new t9(cm4.g(tu2Var).j0), s9Var, ly2Var, null), x50Var);
                if (objB2 != t70Var) {
                    objB2 = q43Var;
                }
                return objB2 == t70Var ? objB2 : q43Var;
            case 2:
                Object objI0 = ((tu2) ry1Var).I0(new b82((hq0) obj, x50Var2, i2), x50Var);
                return objI0 == t70Var ? objI0 : q43Var;
            case 3:
                Object objB3 = ao4.b(ry1Var, new pf2((ms2) obj, null), x50Var);
                return objB3 == t70Var ? objB3 : q43Var;
            case 4:
                Object objB4 = ao4.b(ry1Var, new b82(new q0(1, (hx2) obj, hx2.class, "tryShowContextMenu", "tryShowContextMenu-k-4lQ0M(J)V", 0, 0, 19), x50Var2, 0), x50Var);
                if (objB4 != t70Var) {
                    objB4 = q43Var;
                }
                return objB4 == t70Var ? objB4 : q43Var;
            default:
                Object objC = tl4.c(new f61(ry1Var, (wx2) obj, x50Var2, i2), x50Var);
                if (objC != t70Var) {
                    objC = q43Var;
                }
                return objC == t70Var ? objC : q43Var;
        }
    }
}
