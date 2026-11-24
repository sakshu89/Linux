package defpackage;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hj {
    public final int a;
    public final lt2 b;
    public final long c;

    public hj(int i, lt2 lt2Var, long j) {
        if (i == 0) {
            dk0.n("Null configType");
            throw null;
        }
        this.a = i;
        this.b = lt2Var;
        this.c = j;
    }

    public static int a(int i) {
        if (i == 35) {
            return 2;
        }
        if (i == 256) {
            return 3;
        }
        if (i == 4101) {
            return 4;
        }
        return i == 32 ? 5 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0087  */
    public static hj b(int i, int i2, Size size, mj mjVar) {
        lt2 lt2Var;
        int iA = a(i2);
        int iA2 = al2.a(size);
        if (i == 1) {
            if (iA2 <= al2.a((Size) mjVar.b.get(Integer.valueOf(i2)))) {
                lt2Var = lt2.s720p;
            } else if (iA2 <= al2.a((Size) mjVar.d.get(Integer.valueOf(i2)))) {
                lt2Var = lt2.s1440p;
            } else {
                lt2Var = lt2.NOT_SUPPORT;
            }
        } else if (iA2 <= al2.a(mjVar.a)) {
            lt2Var = lt2.VGA;
        } else if (iA2 <= al2.a(mjVar.c)) {
            lt2Var = lt2.PREVIEW;
        } else if (iA2 <= al2.a(mjVar.e)) {
            lt2Var = lt2.RECORD;
        } else if (iA2 <= al2.a((Size) mjVar.f.get(Integer.valueOf(i2)))) {
            lt2Var = lt2.MAXIMUM;
        } else {
            Size size2 = (Size) mjVar.g.get(Integer.valueOf(i2));
            if (size2 != null) {
                if (iA2 <= size2.getHeight() * size2.getWidth()) {
                    lt2Var = lt2.ULTRA_MAXIMUM;
                } else {
                    lt2Var = lt2.NOT_SUPPORT;
                }
            } else {
                lt2Var = lt2.NOT_SUPPORT;
            }
        }
        return new hj(iA, lt2Var, 0L);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof hj)) {
            return false;
        }
        hj hjVar = (hj) obj;
        return cq.a(this.a, hjVar.a) && this.b.equals(hjVar.b) && this.c == hjVar.c;
    }

    public final int hashCode() {
        int iX = (((cq.x(this.a) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        long j = this.c;
        return ((int) ((j >>> 32) ^ j)) ^ iX;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("SurfaceConfig{configType=");
        int i = this.a;
        if (i == 1) {
            str = "PRIV";
        } else if (i == 2) {
            str = "YUV";
        } else if (i == 3) {
            str = "JPEG";
        } else if (i != 4) {
            str = i != 5 ? "null" : "RAW";
        } else {
            str = "JPEG_R";
        }
        sb.append(str);
        sb.append(", configSize=");
        sb.append(this.b);
        sb.append(", streamUseCase=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
}
