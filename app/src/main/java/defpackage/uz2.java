package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uz2 extends ik1 {
    public final String a;
    public final yz2 b;
    public final qo0 c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;

    public uz2(String str, yz2 yz2Var, qo0 qo0Var, int i, boolean z, int i2, int i3) {
        this.a = str;
        this.b = yz2Var;
        this.c = qo0Var;
        this.d = i;
        this.e = z;
        this.f = i2;
        this.g = i3;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        xz2 xz2Var = new xz2();
        xz2Var.x = this.a;
        xz2Var.H = this.b;
        xz2Var.X = this.c;
        xz2Var.Y = this.d;
        xz2Var.Z = this.e;
        xz2Var.c0 = this.f;
        xz2Var.d0 = this.g;
        return xz2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uz2)) {
            return false;
        }
        uz2 uz2Var = (uz2) obj;
        return g31.a(this.a, uz2Var.a) && g31.a(this.b, uz2Var.b) && g31.a(this.c, uz2Var.c) && this.d == uz2Var.d && this.e == uz2Var.e && this.f == uz2Var.f && this.g == uz2Var.g;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0047  */
    /* JADX WARN: Code duplicated, block: B:22:0x0050  */
    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    /* JADX WARN: Code duplicated, block: B:32:0x006e  */
    /* JADX WARN: Code duplicated, block: B:36:0x009f  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        boolean z;
        String str;
        String str2;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        qo0 qo0Var;
        qo0 qo0Var2;
        int i5;
        int i6;
        xz2 xz2Var = (xz2) dk1Var;
        xz2Var.getClass();
        yz2 yz2Var = xz2Var.H;
        boolean z5 = false;
        boolean z6 = true;
        yz2 yz2Var2 = this.b;
        if (yz2Var2 != yz2Var) {
            if (!yz2Var2.a.b(yz2Var.a)) {
                z = true;
            }
            str = xz2Var.x;
            str2 = this.a;
            if (!g31.a(str, str2)) {
                xz2Var.x = str2;
                xz2Var.h0 = null;
                z5 = true;
            }
            z2 = !xz2Var.H.c(yz2Var2);
            xz2Var.H = yz2Var2;
            i = xz2Var.d0;
            i2 = this.g;
            if (i != i2) {
                xz2Var.d0 = i2;
                z2 = true;
            }
            i3 = xz2Var.c0;
            i4 = this.f;
            if (i3 != i4) {
                xz2Var.c0 = i4;
                z2 = true;
            }
            z3 = xz2Var.Z;
            z4 = this.e;
            if (z3 != z4) {
                xz2Var.Z = z4;
                z2 = true;
            }
            qo0Var = xz2Var.X;
            qo0Var2 = this.c;
            if (!g31.a(qo0Var, qo0Var2)) {
                xz2Var.X = qo0Var2;
                z2 = true;
            }
            i5 = xz2Var.Y;
            i6 = this.d;
            if (i5 == i6) {
                z6 = z2;
            } else {
                xz2Var.Y = i6;
            }
            if (z5 || z6) {
                du1 du1VarI0 = xz2Var.I0();
                String str3 = xz2Var.x;
                yz2 yz2Var3 = xz2Var.H;
                qo0 qo0Var3 = xz2Var.X;
                int i7 = xz2Var.Y;
                boolean z7 = xz2Var.Z;
                int i8 = xz2Var.c0;
                int i9 = xz2Var.d0;
                du1VarI0.a = str3;
                du1VarI0.b = yz2Var3;
                du1VarI0.c = qo0Var3;
                du1VarI0.d = i7;
                du1VarI0.e = z7;
                du1VarI0.f = i8;
                du1VarI0.g = i9;
                du1VarI0.s = (du1VarI0.s << 2) | 2;
                du1VarI0.c();
            }
            if (xz2Var.w) {
                if (z5 || (z && xz2Var.g0 != null)) {
                    a34.a(xz2Var);
                }
                if (z5 || z6) {
                    up4.a(xz2Var);
                    vm4.a(xz2Var);
                }
                if (z) {
                    vm4.a(xz2Var);
                }
            }
            return;
        }
        yz2Var2.getClass();
        z = false;
        str = xz2Var.x;
        str2 = this.a;
        if (!g31.a(str, str2)) {
            xz2Var.x = str2;
            xz2Var.h0 = null;
            z5 = true;
        }
        z2 = !xz2Var.H.c(yz2Var2);
        xz2Var.H = yz2Var2;
        i = xz2Var.d0;
        i2 = this.g;
        if (i != i2) {
            xz2Var.d0 = i2;
            z2 = true;
        }
        i3 = xz2Var.c0;
        i4 = this.f;
        if (i3 != i4) {
            xz2Var.c0 = i4;
            z2 = true;
        }
        z3 = xz2Var.Z;
        z4 = this.e;
        if (z3 != z4) {
            xz2Var.Z = z4;
            z2 = true;
        }
        qo0Var = xz2Var.X;
        qo0Var2 = this.c;
        if (!g31.a(qo0Var, qo0Var2)) {
            xz2Var.X = qo0Var2;
            z2 = true;
        }
        i5 = xz2Var.Y;
        i6 = this.d;
        if (i5 == i6) {
            z6 = z2;
        } else {
            xz2Var.Y = i6;
        }
        if (z5) {
            du1 du1VarI1 = xz2Var.I0();
            String str4 = xz2Var.x;
            yz2 yz2Var4 = xz2Var.H;
            qo0 qo0Var4 = xz2Var.X;
            int i10 = xz2Var.Y;
            boolean z8 = xz2Var.Z;
            int i11 = xz2Var.c0;
            int i12 = xz2Var.d0;
            du1VarI1.a = str4;
            du1VarI1.b = yz2Var4;
            du1VarI1.c = qo0Var4;
            du1VarI1.d = i10;
            du1VarI1.e = z8;
            du1VarI1.f = i11;
            du1VarI1.g = i12;
            du1VarI1.s = (du1VarI1.s << 2) | 2;
            du1VarI1.c();
        } else {
            du1 du1VarI2 = xz2Var.I0();
            String str5 = xz2Var.x;
            yz2 yz2Var5 = xz2Var.H;
            qo0 qo0Var5 = xz2Var.X;
            int i13 = xz2Var.Y;
            boolean z9 = xz2Var.Z;
            int i14 = xz2Var.c0;
            int i15 = xz2Var.d0;
            du1VarI2.a = str5;
            du1VarI2.b = yz2Var5;
            du1VarI2.c = qo0Var5;
            du1VarI2.d = i13;
            du1VarI2.e = z9;
            du1VarI2.f = i14;
            du1VarI2.g = i15;
            du1VarI2.s = (du1VarI2.s << 2) | 2;
            du1VarI2.c();
        }
        if (xz2Var.w) {
            return;
        }
        if (z5) {
            a34.a(xz2Var);
        } else {
            a34.a(xz2Var);
        }
        if (z5) {
            up4.a(xz2Var);
            vm4.a(xz2Var);
        } else {
            up4.a(xz2Var);
            vm4.a(xz2Var);
        }
        if (z) {
            vm4.a(xz2Var);
        }
    }

    public final int hashCode() {
        return (((ky0.e(ky0.a(this.d, (this.c.hashCode() + ky0.c(this.a.hashCode() * 31, 31, this.b)) * 31, 31), 31, this.e) + this.f) * 31) + this.g) * 31;
    }
}
