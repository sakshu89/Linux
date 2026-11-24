package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class en0 {
    public final kn0 a;
    public final long b;
    public final int c;
    public final int d;

    public en0(kn0 kn0Var, long j, int i, int i2) {
        this.a = kn0Var;
        this.b = j;
        this.c = i;
        this.d = i2;
    }

    public final un4 a(ph phVar, boolean z, int i, int i2, int i3, int i4) {
        if (!phVar.b) {
            return null;
        }
        this.a.getClass();
        return null;
    }

    public final ph b(boolean z, int i, long j, a21 a21Var, int i2, int i3, int i4, boolean z2, boolean z3) {
        int i5 = i3 + i4;
        if (a21Var == null) {
            return new ph(true, true);
        }
        long j2 = a21Var.a;
        this.a.getClass();
        if (i2 >= Integer.MAX_VALUE || ((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L)) < 0) {
            return new ph(true, true);
        }
        if (i != 0 && (i >= Integer.MAX_VALUE || ((int) (j >> 32)) - ((int) (j2 >> 32)) < 0)) {
            return z2 ? new ph(true, true) : new ph(true, b(z, 0, a21.a(q40.h(this.b), (((int) (j & 4294967295L)) - this.d) - i4), new a21(a21.a(((int) (j2 >> 32)) - this.c, (int) (j2 & 4294967295L))), i2 + 1, i5, 0, true, false).b);
        }
        Math.max(i4, (int) (j2 & 4294967295L));
        return new ph(false, false);
    }
}
