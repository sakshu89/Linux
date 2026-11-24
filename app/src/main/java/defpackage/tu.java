package defpackage;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tu implements s40 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ tu(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // defpackage.s40
    public final void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                ((Surface) obj3).release();
                ((SurfaceTexture) obj2).release();
                break;
            case 1:
                fb0 fb0Var = (fb0) obj3;
                xt2 xt2Var = (xt2) obj2;
                xt2Var.close();
                Surface surface = (Surface) fb0Var.h.remove(xt2Var);
                if (surface != null) {
                    qq1 qq1Var = fb0Var.a;
                    ur0.d((AtomicBoolean) qq1Var.c, true);
                    ur0.c((Thread) qq1Var.f);
                    qq1Var.r(surface, true);
                }
                break;
            default:
                cg0 cg0Var = (cg0) obj3;
                xt2 xt2Var2 = (xt2) obj2;
                xt2Var2.close();
                Surface surface2 = (Surface) cg0Var.h.remove(xt2Var2);
                if (surface2 != null) {
                    ag0 ag0Var = cg0Var.a;
                    ur0.d((AtomicBoolean) ag0Var.c, true);
                    ur0.c((Thread) ag0Var.f);
                    ag0Var.r(surface2, true);
                }
                break;
        }
    }
}
