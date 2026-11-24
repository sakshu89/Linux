package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vh {
    public final int a;
    public final wh b;

    public vh(int i, wh whVar) {
        if (i == 0) {
            dk0.n("Null type");
            throw null;
        }
        this.a = i;
        this.b = whVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vh)) {
            return false;
        }
        vh vhVar = (vh) obj;
        if (!cq.a(this.a, vhVar.a)) {
            return false;
        }
        wh whVar = vhVar.b;
        wh whVar2 = this.b;
        if (whVar2 == null) {
            return whVar == null;
        }
        return whVar2.equals(whVar);
    }

    public final int hashCode() {
        int iX = (cq.x(this.a) ^ 1000003) * 1000003;
        wh whVar = this.b;
        return (whVar == null ? 0 : whVar.hashCode()) ^ iX;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("CameraState{type=");
        int i = this.a;
        if (i == 1) {
            str = "PENDING_OPEN";
        } else if (i == 2) {
            str = "OPENING";
        } else if (i == 3) {
            str = "OPEN";
        } else if (i != 4) {
            str = i != 5 ? "null" : "CLOSED";
        } else {
            str = "CLOSING";
        }
        sb.append(str);
        sb.append(", error=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
}
