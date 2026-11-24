package defpackage;

import android.util.Size;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uh {
    public final String a;
    public final Class b;
    public final kh2 c;
    public final r53 d;
    public final Size e;
    public final fj f;
    public final List g;

    public uh(String str, Class cls, kh2 kh2Var, r53 r53Var, Size size, fj fjVar, ArrayList arrayList) {
        this.a = str;
        this.b = cls;
        if (kh2Var == null) {
            dk0.n("Null sessionConfig");
            throw null;
        }
        this.c = kh2Var;
        if (r53Var == null) {
            dk0.n("Null useCaseConfig");
            throw null;
        }
        this.d = r53Var;
        this.e = size;
        this.f = fjVar;
        this.g = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof uh)) {
            return false;
        }
        uh uhVar = (uh) obj;
        if (!this.a.equals(uhVar.a) || !this.b.equals(uhVar.b) || !this.c.equals(uhVar.c) || !this.d.equals(uhVar.d)) {
            return false;
        }
        Size size = uhVar.e;
        Size size2 = this.e;
        if (size2 == null) {
            if (size != null) {
                return false;
            }
        } else if (!size2.equals(size)) {
            return false;
        }
        fj fjVar = uhVar.f;
        fj fjVar2 = this.f;
        if (fjVar2 == null) {
            if (fjVar != null) {
                return false;
            }
        } else if (!fjVar2.equals(fjVar)) {
            return false;
        }
        List list = uhVar.g;
        List list2 = this.g;
        if (list2 == null) {
            return list == null;
        }
        return list2.equals(list);
    }

    public final int hashCode() {
        int iHashCode = (((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        Size size = this.e;
        int iHashCode2 = (iHashCode ^ (size == null ? 0 : size.hashCode())) * 1000003;
        fj fjVar = this.f;
        int iHashCode3 = (iHashCode2 ^ (fjVar == null ? 0 : fjVar.hashCode())) * 1000003;
        List list = this.g;
        return iHashCode3 ^ (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "UseCaseInfo{useCaseId=" + this.a + ", useCaseType=" + this.b + ", sessionConfig=" + this.c + ", useCaseConfig=" + this.d + ", surfaceResolution=" + this.e + ", streamSpec=" + this.f + ", captureTypes=" + this.g + "}";
    }
}
