package defpackage;

import android.view.Surface;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m92 implements bz0 {
    public final bz0 e;
    public final Surface f;
    public vp0 i;
    public final Object a = new Object();
    public int b = 0;
    public boolean c = false;
    public final yy0 j = new yy0(this);

    public m92(bz0 bz0Var) {
        this.e = bz0Var;
        this.f = bz0Var.getSurface();
    }

    @Override // defpackage.bz0
    public final int a() {
        int iA;
        synchronized (this.a) {
            iA = this.e.a();
        }
        return iA;
    }

    @Override // defpackage.bz0
    public final int b() {
        int iB;
        synchronized (this.a) {
            iB = this.e.b();
        }
        return iB;
    }

    public final void c() {
        synchronized (this.a) {
            try {
                this.c = true;
                this.e.j();
                if (this.b == 0) {
                    close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bz0
    public final void close() {
        synchronized (this.a) {
            try {
                Surface surface = this.f;
                if (surface != null) {
                    surface.release();
                }
                this.e.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bz0
    public final zy0 e() {
        rk2 rk2Var;
        synchronized (this.a) {
            zy0 zy0VarE = this.e.e();
            if (zy0VarE != null) {
                this.b++;
                rk2Var = new rk2(zy0VarE);
                rk2Var.c(this.j);
            } else {
                rk2Var = null;
            }
        }
        return rk2Var;
    }

    @Override // defpackage.bz0
    public final Surface getSurface() {
        Surface surface;
        synchronized (this.a) {
            surface = this.e.getSurface();
        }
        return surface;
    }

    @Override // defpackage.bz0
    public final int h() {
        int iH;
        synchronized (this.a) {
            iH = this.e.h();
        }
        return iH;
    }

    @Override // defpackage.bz0
    public final void j() {
        synchronized (this.a) {
            this.e.j();
        }
    }

    @Override // defpackage.bz0
    public final void l(az0 az0Var, Executor executor) {
        synchronized (this.a) {
            this.e.l(new qq(7, this, az0Var), executor);
        }
    }

    @Override // defpackage.bz0
    public final int n() {
        int iN;
        synchronized (this.a) {
            iN = this.e.n();
        }
        return iN;
    }

    @Override // defpackage.bz0
    public final zy0 p() {
        rk2 rk2Var;
        synchronized (this.a) {
            zy0 zy0VarP = this.e.p();
            if (zy0VarP != null) {
                this.b++;
                rk2Var = new rk2(zy0VarP);
                rk2Var.c(this.j);
            } else {
                rk2Var = null;
            }
        }
        return rk2Var;
    }
}
