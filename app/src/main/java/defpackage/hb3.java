package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class hb3 extends gb3 {
    public q11 o;
    public q11 p;
    public q11 q;

    public hb3(pb3 pb3Var, WindowInsets windowInsets) {
        super(pb3Var, windowInsets);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    @Override // defpackage.lb3
    public q11 h() {
        if (this.p == null) {
            this.p = q11.c(this.c.getMandatorySystemGestureInsets());
        }
        return this.p;
    }

    @Override // defpackage.lb3
    public q11 j() {
        if (this.o == null) {
            this.o = q11.c(this.c.getSystemGestureInsets());
        }
        return this.o;
    }

    @Override // defpackage.lb3
    public q11 l() {
        if (this.q == null) {
            this.q = q11.c(this.c.getTappableElementInsets());
        }
        return this.q;
    }

    @Override // defpackage.fb3, defpackage.lb3
    public void r(q11 q11Var) {
    }
}
