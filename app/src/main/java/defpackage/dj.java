package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dj {
    public final ob0 a;
    public final List b;
    public final int c;
    public final int d;
    public final ig0 e;

    public dj(ob0 ob0Var, List list, int i, int i2, ig0 ig0Var) {
        this.a = ob0Var;
        this.b = list;
        this.c = i;
        this.d = i2;
        this.e = ig0Var;
    }

    public static cj a(ob0 ob0Var) {
        cj cjVar = new cj();
        if (ob0Var == null) {
            dk0.n("Null surface");
            return null;
        }
        cjVar.b = ob0Var;
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            dk0.n("Null sharedSurfaces");
            return null;
        }
        cjVar.c = list;
        cjVar.e = -1;
        cjVar.f = -1;
        cjVar.a = ig0.d;
        return cjVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dj)) {
            return false;
        }
        dj djVar = (dj) obj;
        return this.a.equals(djVar.a) && this.b.equals(djVar.b) && this.c == djVar.c && this.d == djVar.d && this.e.equals(djVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() ^ ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * (-721379959)) ^ this.c) * 1000003) ^ this.d) * 1000003);
    }

    public final String toString() {
        return "OutputConfig{surface=" + this.a + ", sharedSurfaces=" + this.b + ", physicalCameraId=null, mirrorMode=" + this.c + ", surfaceGroupId=" + this.d + ", dynamicRange=" + this.e + "}";
    }
}
