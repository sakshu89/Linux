package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ze2 {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public ze2 f;
    public ze2 g;

    public ze2(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        bArr.getClass();
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public final ze2 a() {
        ze2 ze2Var = this.f;
        if (ze2Var == this) {
            ze2Var = null;
        }
        ze2 ze2Var2 = this.g;
        ze2Var2.getClass();
        ze2Var2.f = this.f;
        ze2 ze2Var3 = this.f;
        ze2Var3.getClass();
        ze2Var3.g = this.g;
        this.f = null;
        this.g = null;
        return ze2Var;
    }

    public final void b(ze2 ze2Var) {
        ze2Var.getClass();
        ze2Var.g = this;
        ze2Var.f = this.f;
        ze2 ze2Var2 = this.f;
        ze2Var2.getClass();
        ze2Var2.g = ze2Var;
        this.f = ze2Var;
    }

    public final ze2 c() {
        this.d = true;
        return new ze2(this.a, this.b, this.c, true, false);
    }

    public final void d(ze2 ze2Var, int i) {
        ze2Var.getClass();
        byte[] bArr = ze2Var.a;
        if (!ze2Var.e) {
            og.n("only owner can write");
            return;
        }
        int i2 = ze2Var.c;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (ze2Var.d) {
                dk0.v();
                return;
            }
            int i4 = ze2Var.b;
            if (i3 - i4 > 8192) {
                dk0.v();
                return;
            } else {
                qg.d(bArr, 0, bArr, i4, i2);
                ze2Var.c -= ze2Var.b;
                ze2Var.b = 0;
            }
        }
        int i5 = ze2Var.c;
        int i6 = this.b;
        qg.d(this.a, i5, bArr, i6, i6 + i);
        ze2Var.c += i;
        this.b += i;
    }

    public ze2() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }
}
