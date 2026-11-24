package defpackage;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xh2 extends wp0 {
    public final Object e;
    public final vy0 f;
    public final int i;
    public final int j;

    public xh2(zy0 zy0Var, Size size, vy0 vy0Var) {
        super(zy0Var);
        this.e = new Object();
        if (size == null) {
            this.i = this.b.b();
            this.j = this.b.a();
        } else {
            this.i = size.getWidth();
            this.j = size.getHeight();
        }
        this.f = vy0Var;
    }

    @Override // defpackage.wp0, defpackage.zy0
    public final int a() {
        return this.j;
    }

    @Override // defpackage.wp0, defpackage.zy0
    public final int b() {
        return this.i;
    }

    @Override // defpackage.wp0, defpackage.zy0
    public final vy0 m() {
        return this.f;
    }
}
