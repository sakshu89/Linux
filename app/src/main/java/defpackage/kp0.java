package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kp0 implements ip0 {
    public final float[] a;
    public final float[] b;

    public kp0(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            og.i("Array lengths must match and be nonzero");
            throw null;
        }
        this.a = fArr;
        this.b = fArr2;
    }

    @Override // defpackage.ip0
    public final float a(float f) {
        return xy.b(f, this.b, this.a);
    }

    @Override // defpackage.ip0
    public final float b(float f) {
        return xy.b(f, this.a, this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof kp0)) {
            return false;
        }
        kp0 kp0Var = (kp0) obj;
        return Arrays.equals(this.a, kp0Var.a) && Arrays.equals(this.b, kp0Var.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b) + (Arrays.hashCode(this.a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FontScaleConverter{fromSpValues=");
        String string = Arrays.toString(this.a);
        string.getClass();
        sb.append(string);
        sb.append(", toDpValues=");
        String string2 = Arrays.toString(this.b);
        string2.getClass();
        sb.append(string2);
        sb.append('}');
        return sb.toString();
    }
}
