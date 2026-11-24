package defpackage;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ec1 extends tj2 {
    public final List c;
    public final List d;
    public final long e;
    public final long f;

    public ec1(List list, ArrayList arrayList, long j, long j2) {
        this.c = list;
        this.d = arrayList;
        this.e = j;
        this.f = j2;
    }

    @Override // defpackage.tj2
    public final Shader b(long j) {
        long j2 = this.e;
        int i = (int) (j2 >> 32);
        if (Float.intBitsToFloat(i) == Float.POSITIVE_INFINITY) {
            i = (int) (j >> 32);
        }
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        int i2 = (int) (j2 & 4294967295L);
        if (Float.intBitsToFloat(i2) == Float.POSITIVE_INFINITY) {
            i2 = (int) (j & 4294967295L);
        }
        float fIntBitsToFloat2 = Float.intBitsToFloat(i2);
        long j3 = this.f;
        int i3 = (int) (j3 >> 32);
        if (Float.intBitsToFloat(i3) == Float.POSITIVE_INFINITY) {
            i3 = (int) (j >> 32);
        }
        float fIntBitsToFloat3 = Float.intBitsToFloat(i3);
        int i4 = (int) (j3 & 4294967295L);
        if (Float.intBitsToFloat(i4) == Float.POSITIVE_INFINITY) {
            i4 = (int) (j & 4294967295L);
        }
        float fIntBitsToFloat4 = Float.intBitsToFloat(i4);
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat4)) & 4294967295L);
        List list = this.c;
        List list2 = this.d;
        ae4.f(list, list2);
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jFloatToRawIntBits2 >> 32));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jFloatToRawIntBits2 & 4294967295L));
        int size = list.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr[i5] = ki4.g(((sz) list.get(i5)).a);
        }
        return new LinearGradient(fIntBitsToFloat5, fIntBitsToFloat6, fIntBitsToFloat7, fIntBitsToFloat8, iArr, ae4.e(list2, list), Shader.TileMode.CLAMP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ec1)) {
            return false;
        }
        ec1 ec1Var = (ec1) obj;
        return this.c.equals(ec1Var.c) && g31.a(this.d, ec1Var.d) && jp1.b(this.e, ec1Var.e) && jp1.b(this.f, ec1Var.f);
    }

    public final int hashCode() {
        int iHashCode = this.c.hashCode() * 31;
        List list = this.d;
        return Integer.hashCode(0) + cq.c(cq.c((iHashCode + (list != null ? list.hashCode() : 0)) * 31, 31, this.e), 31, this.f);
    }

    public final String toString() {
        String str;
        long j = this.e;
        String str2 = "";
        if (((((j & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0) {
            str = "start=" + ((Object) jp1.g(j)) + ", ";
        } else {
            str = "";
        }
        long j2 = this.f;
        if (((((j2 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0) {
            str2 = "end=" + ((Object) jp1.g(j2)) + ", ";
        }
        return "LinearGradient(colors=" + this.c + ", stops=" + this.d + ", " + str + str2 + "tileMode=Clamp)";
    }
}
