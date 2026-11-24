package defpackage;

import android.util.Size;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nz0 extends ob0 {
    public final /* synthetic */ int o = 0;
    public final Object p;

    public nz0(Surface surface) {
        super(ob0.k, 0);
        this.p = surface;
    }

    @Override // defpackage.ob0
    public final wc1 f() {
        int i = this.o;
        Object obj = this.p;
        switch (i) {
            case 0:
                return oz3.d((Surface) obj);
            default:
                return ((fu2) obj).f;
        }
    }

    public nz0(Surface surface, Size size, int i) {
        super(size, i);
        this.p = surface;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nz0(fu2 fu2Var, Size size) {
        super(size, 34);
        this.p = fu2Var;
    }
}
