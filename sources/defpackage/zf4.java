package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zf4 extends yd4 {
    public final byte[] c;

    public zf4(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.c = bArr;
    }

    @Override // defpackage.yd4
    public final byte[] g() {
        return this.c;
    }
}
