package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yh {
    public final String a;
    public final ki b;

    public yh(String str, ki kiVar) {
        if (str == null) {
            dk0.n("Null cameraIdString");
            throw null;
        }
        this.a = str;
        if (kiVar != null) {
            this.b = kiVar;
        } else {
            dk0.n("Null cameraConfigId");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof yh)) {
            return false;
        }
        yh yhVar = (yh) obj;
        return this.a.equals(yhVar.a) && this.b.equals(yhVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "CameraId{cameraIdString=" + this.a + ", cameraConfigId=" + this.b + "}";
    }
}
