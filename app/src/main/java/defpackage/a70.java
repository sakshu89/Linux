package defpackage;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a70 implements PointerInputEventHandler {
    public final /* synthetic */ wx2 a;
    public final /* synthetic */ ny2 b;

    public a70(wx2 wx2Var, ny2 ny2Var) {
        this.a = wx2Var;
        this.b = ny2Var;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(ry1 ry1Var, x50 x50Var) {
        Object objC = tl4.c(new z60(ry1Var, this.a, this.b, null, 0), x50Var);
        return objC == t70.a ? objC : q43.a;
    }
}
