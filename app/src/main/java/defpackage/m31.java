package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m31 implements qh1, z21 {
    public final /* synthetic */ z21 a;
    public final z61 b;

    public m31(z21 z21Var, z61 z61Var) {
        this.a = z21Var;
        this.b = z61Var;
    }

    @Override // defpackage.jc0
    public final float I(long j) {
        return this.a.I(j);
    }

    @Override // defpackage.qh1
    public final ph1 O(int i, int i2, Map map, hq0 hq0Var, hq0 hq0Var2) {
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if ((i & (-16777216)) != 0 || ((-16777216) & i2) != 0) {
            z01.b("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new l31(i, i2, map, hq0Var);
    }

    @Override // defpackage.jc0
    public final int R(float f) {
        return this.a.R(f);
    }

    @Override // defpackage.jc0
    public final long a0(long j) {
        return this.a.a0(j);
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.a.b();
    }

    @Override // defpackage.jc0
    public final float d0(long j) {
        return this.a.d0(j);
    }

    @Override // defpackage.z21
    public final z61 getLayoutDirection() {
        return this.b;
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.a.l();
    }

    @Override // defpackage.jc0
    public final long l0(float f) {
        return this.a.l0(f);
    }

    @Override // defpackage.jc0
    public final float r0(int i) {
        return this.a.r0(i);
    }

    @Override // defpackage.z21
    public final boolean s() {
        return this.a.s();
    }

    @Override // defpackage.jc0
    public final float u0(float f) {
        return this.a.u0(f);
    }

    @Override // defpackage.jc0
    public final long v(float f) {
        return this.a.v(f);
    }

    @Override // defpackage.jc0
    public final long w(long j) {
        return this.a.w(j);
    }

    @Override // defpackage.jc0
    public final float x(float f) {
        return this.a.x(f);
    }
}
