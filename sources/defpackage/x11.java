package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x11 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final cv2 e;

    public x11(String str, String str2) {
        this.a = str;
        this.b = str2;
        Set set = ue.f;
        this.c = qs4.s(str2);
        this.d = str2.codePoints().anyMatch(new te(0));
        this.e = new cv2(new kb(9, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x11)) {
            return false;
        }
        x11 x11Var = (x11) obj;
        return this.a.equals(x11Var.a) && this.b.equals(x11Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return ky0.l("InstalledApp(packageName=", this.a, ", label=", this.b, ")");
    }
}
