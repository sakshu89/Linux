package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xp0 extends u03 {
    public u03 e;

    public xp0(u03 u03Var) {
        u03Var.getClass();
        this.e = u03Var;
    }

    @Override // defpackage.u03
    public final u03 a() {
        return this.e.a();
    }

    @Override // defpackage.u03
    public final u03 b() {
        return this.e.b();
    }

    @Override // defpackage.u03
    public final long c() {
        return this.e.c();
    }

    @Override // defpackage.u03
    public final u03 d(long j) {
        return this.e.d(j);
    }

    @Override // defpackage.u03
    public final boolean e() {
        return this.e.e();
    }

    @Override // defpackage.u03
    public final void f() throws InterruptedIOException {
        this.e.f();
    }

    @Override // defpackage.u03
    public final u03 g(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.e.g(j, timeUnit);
    }

    @Override // defpackage.u03
    public final long h() {
        return this.e.h();
    }
}
