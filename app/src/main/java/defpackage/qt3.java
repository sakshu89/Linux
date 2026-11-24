package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class qt3 extends rt3 {
    public final byte[] c;

    public qt3(byte[] bArr) {
        this.a = 0;
        bArr.getClass();
        this.c = bArr;
    }

    @Override // defpackage.rt3
    public byte a(int i) {
        return this.c[i];
    }

    @Override // defpackage.rt3
    public byte b(int i) {
        return this.c[i];
    }

    @Override // defpackage.rt3
    public int d() {
        return this.c.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof rt3) && d() == ((rt3) obj).d()) {
            if (d() == 0) {
                return true;
            }
            if (!(obj instanceof qt3)) {
                return obj.equals(this);
            }
            qt3 qt3Var = (qt3) obj;
            int i = this.a;
            int i2 = qt3Var.a;
            if (i == 0 || i2 == 0 || i == i2) {
                int iD = d();
                if (iD > qt3Var.d()) {
                    throw new IllegalArgumentException("Length too large: " + iD + d());
                }
                if (iD > qt3Var.d()) {
                    og.i(ky0.i("Ran off end of other: 0, ", iD, qt3Var.d(), ", "));
                    return false;
                }
                byte[] bArr = qt3Var.c;
                int i3 = 0;
                int i4 = 0;
                while (i3 < iD) {
                    if (this.c[i3] == bArr[i4]) {
                        i3++;
                        i4++;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
