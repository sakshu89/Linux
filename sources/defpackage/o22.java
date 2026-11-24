package defpackage;

import android.graphics.RadialGradient;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o22 extends tj2 {
    public final List c;
    public final List d;
    public final long e;
    public final float f;

    public o22(List list, ArrayList arrayList, long j, float f) {
        this.c = list;
        this.d = arrayList;
        this.e = j;
        this.f = f;
    }

    @Override // defpackage.tj2
    public final Shader b(long j) {
        float fIntBitsToFloat;
        float fIntBitsToFloat2;
        long j2 = this.e;
        if ((9223372034707292159L & j2) == 9205357640488583168L) {
            long jA = a44.a(j);
            fIntBitsToFloat = Float.intBitsToFloat((int) (jA >> 32));
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (jA & 4294967295L));
        } else {
            int i = (int) (j2 >> 32);
            if (Float.intBitsToFloat(i) == Float.POSITIVE_INFINITY) {
                i = (int) (j >> 32);
            }
            fIntBitsToFloat = Float.intBitsToFloat(i);
            int i2 = (int) (j2 & 4294967295L);
            if (Float.intBitsToFloat(i2) == Float.POSITIVE_INFINITY) {
                i2 = (int) (j & 4294967295L);
            }
            fIntBitsToFloat2 = Float.intBitsToFloat(i2);
        }
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        float fB = this.f;
        if (fB == Float.POSITIVE_INFINITY) {
            fB = xk2.b(j) / 2.0f;
        }
        float f = fB;
        List list = this.c;
        List list2 = this.d;
        ae4.f(list, list2);
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
        int size = list.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ki4.g(((sz) list.get(i3)).a);
        }
        return new RadialGradient(fIntBitsToFloat3, fIntBitsToFloat4, f, iArr, ae4.e(list2, list), Shader.TileMode.CLAMP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o22)) {
            return false;
        }
        o22 o22Var = (o22) obj;
        return this.c.equals(o22Var.c) && g31.a(this.d, o22Var.d) && jp1.b(this.e, o22Var.e) && this.f == o22Var.f;
    }

    public final int hashCode() {
        int iHashCode = this.c.hashCode() * 31;
        List list = this.d;
        return Integer.hashCode(0) + cq.b(cq.c((iHashCode + (list != null ? list.hashCode() : 0)) * 31, 31, this.e), this.f, 31);
    }

    public final String toString() {
        String str;
        long j = this.e;
        String str2 = "";
        if ((9223372034707292159L & j) != 9205357640488583168L) {
            str = "center=" + ((Object) jp1.g(j)) + ", ";
        } else {
            str = "";
        }
        float f = this.f;
        if ((Float.floatToRawIntBits(f) & Integer.MAX_VALUE) < 2139095040) {
            str2 = "radius=" + f + ", ";
        }
        return "RadialGradient(colors=" + this.c + ", stops=" + this.d + ", " + str + str2 + "tileMode=Clamp)";
    }
}
