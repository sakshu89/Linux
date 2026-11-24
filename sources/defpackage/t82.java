package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t82 implements yj2 {
    public final g70 a;
    public final g70 b;
    public final g70 c;
    public final g70 d;

    public t82(g70 g70Var, g70 g70Var2, g70 g70Var3, g70 g70Var4) {
        this.a = g70Var;
        this.b = g70Var2;
        this.c = g70Var3;
        this.d = g70Var4;
    }

    public static t82 b(t82 t82Var, g70 g70Var, g70 g70Var2, g70 g70Var3, g70 g70Var4, int i) {
        if ((i & 1) != 0) {
            g70Var = t82Var.a;
        }
        if ((i & 2) != 0) {
            g70Var2 = t82Var.b;
        }
        if ((i & 4) != 0) {
            g70Var3 = t82Var.c;
        }
        if ((i & 8) != 0) {
            g70Var4 = t82Var.d;
        }
        t82Var.getClass();
        return new t82(g70Var, g70Var2, g70Var3, g70Var4);
    }

    @Override // defpackage.yj2
    public final es4 a(long j, z61 z61Var, jc0 jc0Var) {
        float fA = this.a.a(j, jc0Var);
        float fA2 = this.b.a(j, jc0Var);
        float fA3 = this.c.a(j, jc0Var);
        float fA4 = this.d.a(j, jc0Var);
        float fB = xk2.b(j);
        float f = fA + fA4;
        if (f > fB) {
            float f2 = fB / f;
            fA *= f2;
            fA4 *= f2;
        }
        float f3 = fA2 + fA3;
        if (f3 > fB) {
            float f4 = fB / f3;
            fA2 *= f4;
            fA3 *= f4;
        }
        if (fA < 0.0f || fA2 < 0.0f || fA3 < 0.0f || fA4 < 0.0f) {
            c11.a("Corner size in Px can't be negative(topStart = " + fA + ", topEnd = " + fA2 + ", bottomEnd = " + fA3 + ", bottomStart = " + fA4 + ")!");
        }
        if (fA + fA2 + fA3 + fA4 == 0.0f) {
            return new us1(ry3.a(0L, j));
        }
        l42 l42VarA = ry3.a(0L, j);
        z61 z61Var2 = z61.a;
        float f5 = z61Var == z61Var2 ? fA : fA2;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L);
        if (z61Var == z61Var2) {
            fA = fA2;
        }
        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fA)) << 32) | (((long) Float.floatToRawIntBits(fA)) & 4294967295L);
        float f6 = z61Var == z61Var2 ? fA3 : fA4;
        long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L);
        if (z61Var != z61Var2) {
            fA4 = fA3;
        }
        return new vs1(new s82(l42VarA.a, l42VarA.b, l42VarA.c, l42VarA.d, jFloatToRawIntBits, jFloatToRawIntBits2, jFloatToRawIntBits3, (((long) Float.floatToRawIntBits(fA4)) << 32) | (((long) Float.floatToRawIntBits(fA4)) & 4294967295L)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t82)) {
            return false;
        }
        t82 t82Var = (t82) obj;
        return g31.a(this.a, t82Var.a) && g31.a(this.b, t82Var.b) && g31.a(this.c, t82Var.c) && g31.a(this.d, t82Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "RoundedCornerShape(topStart = " + this.a + ", topEnd = " + this.b + ", bottomEnd = " + this.c + ", bottomStart = " + this.d + ')';
    }
}
