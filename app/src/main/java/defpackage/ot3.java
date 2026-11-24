package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ot3 extends qt3 {
    public final int e;

    public ot3(byte[] bArr, int i) {
        super(bArr);
        rt3.f(0, i, bArr.length);
        this.e = i;
    }

    @Override // defpackage.qt3, defpackage.rt3
    public final byte a(int i) {
        int i2 = this.e;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.c[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(ky0.h(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(ky0.i("Index > length: ", i, i2, ", "));
    }

    @Override // defpackage.qt3, defpackage.rt3
    public final byte b(int i) {
        return this.c[i];
    }

    @Override // defpackage.qt3, defpackage.rt3
    public final int d() {
        return this.e;
    }
}
