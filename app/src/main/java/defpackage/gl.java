package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gl {
    public final int a;
    public final boolean b;
    public final cz1 c;
    public final Float d;
    public final boolean e;
    public final String f;

    public gl(int i, boolean z, cz1 cz1Var, Float f, boolean z2, String str) {
        this.a = i;
        this.b = z;
        this.c = cz1Var;
        this.d = f;
        this.e = z2;
        this.f = str;
    }

    public final String a() {
        return "percent=" + this.a + " charging=" + this.b + " source=" + this.c + " saver=" + this.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gl)) {
            return false;
        }
        gl glVar = (gl) obj;
        return this.a == glVar.a && this.b == glVar.b && this.c == glVar.c && g31.a(this.d, glVar.d) && this.e == glVar.e && g31.a(this.f, glVar.f);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ky0.e(Integer.hashCode(this.a) * 31, 31, this.b)) * 31;
        Float f = this.d;
        int iE = ky0.e((iHashCode + (f == null ? 0 : f.hashCode())) * 31, 31, this.e);
        String str = this.f;
        return iE + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "BatteryStatus(percent=" + this.a + ", isCharging=" + this.b + ", source=" + this.c + ", temperatureCelsius=" + this.d + ", isPowerSaveMode=" + this.e + ", health=" + this.f + ")";
    }
}
