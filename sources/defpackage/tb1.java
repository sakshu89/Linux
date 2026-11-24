package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tb1 extends b83 {
    public final ml1 b;

    public tb1() {
        ml1 ml1Var = d21.a;
        this.b = new ml1();
    }

    @Override // defpackage.b83
    public final void d() {
        ml1 ml1Var = this.b;
        int[] iArr = ml1Var.b;
        Object[] objArr = ml1Var.c;
        long[] jArr = ml1Var.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        int i5 = iArr[i4];
                        yl1 yl1Var = (yl1) objArr[i4];
                        Object[] objArr2 = yl1Var.a;
                        int i6 = yl1Var.b;
                        for (int i7 = 0; i7 < i6; i7++) {
                            sb1 sb1Var = (sb1) objArr2[i7];
                            zv zvVar = sb1Var.d;
                            if (zvVar != null) {
                                zvVar.cancel();
                            }
                            sb1Var.d = null;
                            mg1 mg1Var = (mg1) sb1Var.a.b;
                            mg1Var.b = true;
                            mg1Var.a = false;
                            mg1Var.a();
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }
}
