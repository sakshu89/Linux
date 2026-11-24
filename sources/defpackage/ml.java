package defpackage;

import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ml extends tt1 {
    public final p9 e;
    public final long f;
    public final int g;
    public final long h;
    public float i;
    public nl j;

    public ml(p9 p9Var) {
        int i;
        long width = (((long) p9Var.a.getWidth()) << 32) | (((long) p9Var.a.getHeight()) & 4294967295L);
        this.e = p9Var;
        this.f = width;
        this.g = 1;
        int i2 = (int) (width >> 32);
        if (i2 < 0 || (i = (int) (width & 4294967295L)) < 0 || i2 > p9Var.a.getWidth() || i > p9Var.a.getHeight()) {
            og.i("Failed requirement.");
            throw null;
        }
        this.h = width;
        this.i = 1.0f;
    }

    @Override // defpackage.tt1
    public final void a(float f) {
        this.i = f;
    }

    @Override // defpackage.tt1
    public final void b(nl nlVar) {
        this.j = nlVar;
    }

    @Override // defpackage.tt1
    public final long d() {
        return cp4.a(this.h);
    }

    @Override // defpackage.tt1
    public final void e(p71 p71Var) {
        ew ewVar = p71Var.a;
        rf0.T(p71Var, this.e, this.f, (((long) Math.round(Float.intBitsToFloat((int) (ewVar.c() >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (ewVar.c() & 4294967295L)))) & 4294967295L), this.i, this.j, this.g, UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_I_ID);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ml)) {
            return false;
        }
        ml mlVar = (ml) obj;
        return g31.a(this.e, mlVar.e) && e21.a(0L, 0L) && l21.a(this.f, mlVar.f) && this.g == mlVar.g;
    }

    public final int hashCode() {
        return Integer.hashCode(this.g) + cq.c(cq.c(this.e.hashCode() * 31, 31, 0L), 31, this.f);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BitmapPainter(image=");
        sb.append(this.e);
        sb.append(", srcOffset=");
        sb.append((Object) e21.d(0L));
        sb.append(", srcSize=");
        sb.append((Object) l21.b(this.f));
        sb.append(", filterQuality=");
        int i = this.g;
        if (i == 0) {
            str = "None";
        } else if (i == 1) {
            str = "Low";
        } else if (i == 2) {
            str = "Medium";
        } else {
            str = i == 3 ? "High" : "Unknown";
        }
        sb.append((Object) str);
        sb.append(')');
        return sb.toString();
    }
}
