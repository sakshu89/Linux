package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lo extends no {
    public final int f;
    public final int i;

    public lo(byte[] bArr, int i, int i2) {
        super(bArr);
        no.b(i, i + i2, bArr.length);
        this.f = i;
        this.i = i2;
    }

    @Override // defpackage.no
    public final byte a(int i) {
        int i2 = this.i;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.b[this.f + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(ky0.h(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(ky0.i("Index > length: ", i, i2, ", "));
    }

    @Override // defpackage.no
    public final void f(byte[] bArr, int i) {
        System.arraycopy(this.b, this.f, bArr, 0, i);
    }

    @Override // defpackage.no
    public final int g() {
        return this.f;
    }

    @Override // defpackage.no
    public final byte h(int i) {
        return this.b[this.f + i];
    }

    @Override // defpackage.no
    public final int size() {
        return this.i;
    }
}
