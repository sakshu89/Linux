package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u51 {
    public final Boolean a;
    public final int b;
    public final int c;

    public u51(int i) {
        Boolean bool = (i & 2) != 0 ? null : Boolean.FALSE;
        int i2 = (i & 4) != 0 ? 0 : 7;
        int i3 = (i & 8) != 0 ? -1 : 7;
        this.a = bool;
        this.b = i2;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u51)) {
            return false;
        }
        u51 u51Var = (u51) obj;
        return g31.a(this.a, u51Var.a) && this.b == u51Var.b && this.c == u51Var.c;
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(-1) * 31;
        Boolean bool = this.a;
        return ky0.a(this.c, ky0.a(this.b, (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31, 31), 29791);
    }

    public final String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) "Unspecified") + ", autoCorrectEnabled=" + this.a + ", keyboardType=" + ((Object) v51.a(this.b)) + ", imeAction=" + ((Object) jz0.a(this.c)) + ", platformImeOptions=nullshowKeyboardOnFocus=null, hintLocales=null)";
    }
}
