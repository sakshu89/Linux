package defpackage;

import android.view.View;
import android.widget.Magnifier;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kx1 implements ix1 {
    public static final kx1 b = new kx1(0);
    public static final kx1 c = new kx1(1);
    public final /* synthetic */ int a;

    public /* synthetic */ kx1(int i) {
        this.a = i;
    }

    @Override // defpackage.ix1
    public final boolean a() {
        switch (this.a) {
            case 0:
                return false;
            default:
                return true;
        }
    }

    @Override // defpackage.ix1
    public final hx1 b(View view, jc0 jc0Var) {
        switch (this.a) {
            case 0:
                return new jx1(new Magnifier(view));
            default:
                return new lx1(new Magnifier(view));
        }
    }
}
