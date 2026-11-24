package defpackage;

import android.hardware.camera2.CaptureRequest;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bi {
    public final String a;
    public final Class b;
    public final Object c;

    public bi(String str, Class cls, CaptureRequest.Key key) {
        this.a = str;
        if (cls == null) {
            dk0.n("Null valueClass");
            throw null;
        }
        this.b = cls;
        this.c = key;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bi)) {
            return false;
        }
        bi biVar = (bi) obj;
        if (!this.a.equals(biVar.a) || !this.b.equals(biVar.b)) {
            return false;
        }
        Object obj2 = biVar.c;
        Object obj3 = this.c;
        if (obj3 == null) {
            return obj2 == null;
        }
        return obj3.equals(obj2);
    }

    public final int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        Object obj = this.c;
        return (obj == null ? 0 : obj.hashCode()) ^ iHashCode;
    }

    public final String toString() {
        return "Option{id=" + this.a + ", valueClass=" + this.b + ", token=" + this.c + "}";
    }
}
