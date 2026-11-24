package defpackage;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cy2 implements PointerInputEventHandler {
    public final /* synthetic */ s70 a;
    public final /* synthetic */ mm1 b;
    public final /* synthetic */ mm1 c;

    public cy2(s70 s70Var, mm1 mm1Var, mm1 mm1Var2) {
        this.a = s70Var;
        this.b = mm1Var;
        this.c = mm1Var2;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(ry1 ry1Var, x50 x50Var) {
        by2 by2Var = new by2(this.a, this.b, null);
        jc jcVar = new jc(this.c, 7);
        nv2 nv2Var = vv2.a;
        Object objC = tl4.c(new z9(ry1Var, by2Var, jcVar, new zz1(ry1Var), null), x50Var);
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        if (objC != t70Var) {
            objC = q43Var;
        }
        return objC == t70Var ? objC : q43Var;
    }
}
