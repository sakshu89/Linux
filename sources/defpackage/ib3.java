package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ib3 extends hb3 {
    public static final pb3 r = pb3.b(WindowInsets.CONSUMED, null);

    public ib3(pb3 pb3Var, WindowInsets windowInsets) {
        super(pb3Var, windowInsets);
    }

    @Override // defpackage.eb3, defpackage.lb3
    public q11 f(int i) {
        return q11.c(this.c.getInsets(mb3.a(i)));
    }

    @Override // defpackage.eb3, defpackage.lb3
    public q11 g(int i) {
        return q11.c(this.c.getInsetsIgnoringVisibility(mb3.a(i)));
    }

    @Override // defpackage.eb3, defpackage.lb3
    public boolean o(int i) {
        return this.c.isVisible(mb3.a(i));
    }

    @Override // defpackage.eb3, defpackage.lb3
    public final void d(View view) {
    }
}
