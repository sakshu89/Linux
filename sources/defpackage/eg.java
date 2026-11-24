package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eg implements dg, fg {
    public final float a;
    public final ag b;
    public final float c;

    public eg(float f, ag agVar) {
        this.a = f;
        this.b = agVar;
        this.c = f;
    }

    @Override // defpackage.dg, defpackage.fg
    public final float a() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof eg) {
            eg egVar = (eg) obj;
            return de0.b(this.a, egVar.a) && this.b == egVar.b;
        }
        return false;
    }

    @Override // defpackage.dg
    public final void h(jc0 jc0Var, int i, int[] iArr, z61 z61Var, int[] iArr2) {
        int i2;
        int i3;
        if (iArr.length == 0) {
            return;
        }
        int iR = jc0Var.R(this.a);
        if (z61Var == z61.b) {
            int length = iArr.length - 1;
            i2 = 0;
            i3 = 0;
            while (-1 < length) {
                int i4 = iArr[length];
                int iMin = Math.min(i2, i - i4);
                iArr2[length] = iMin;
                int iMin2 = Math.min(iR, (i - iMin) - i4);
                int i5 = iArr2[length] + i4 + iMin2;
                length--;
                i3 = iMin2;
                i2 = i5;
            }
        } else {
            int length2 = iArr.length;
            i2 = 0;
            i3 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length2) {
                int i8 = iArr[i6];
                int iMin3 = Math.min(i2, i - i8);
                iArr2[i7] = iMin3;
                int iMin4 = Math.min(iR, (i - iMin3) - i8);
                int i9 = iArr2[i7] + i8 + iMin4;
                i6++;
                i3 = iMin4;
                i2 = i9;
                i7++;
            }
        }
        int i10 = i2 - i3;
        if (i10 < i) {
            int iIntValue = ((Number) this.b.e(Integer.valueOf(i - i10), z61Var)).intValue();
            int length3 = iArr2.length;
            for (int i11 = 0; i11 < length3; i11++) {
                iArr2[i11] = iArr2[i11] + iIntValue;
            }
        }
    }

    public final int hashCode() {
        return this.b.hashCode() + ky0.e(Float.hashCode(this.a) * 31, 31, true);
    }

    @Override // defpackage.fg
    public final void i(int i, qh1 qh1Var, int[] iArr, int[] iArr2) {
        h(qh1Var, i, iArr, z61.a, iArr2);
    }

    public final String toString() {
        return "Arrangement#spacedAligned(" + ((Object) de0.c(this.a)) + ", " + this.b + ')';
    }
}
