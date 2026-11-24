package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sh {
    public final int a;
    public final long b;

    public sh(int i, long j) {
        if (i == 0) {
            dk0.n("Null status");
            throw null;
        }
        this.a = i;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sh)) {
            return false;
        }
        sh shVar = (sh) obj;
        return cq.a(this.a, shVar.a) && this.b == shVar.b;
    }

    public final int hashCode() {
        int iX = (cq.x(this.a) ^ 1000003) * 1000003;
        long j = this.b;
        return ((int) ((j >>> 32) ^ j)) ^ iX;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.a;
        if (i == 1) {
            str = "OK";
        } else if (i != 2) {
            str = i != 3 ? "null" : "FATAL_ERROR";
        } else {
            str = "TRANSIENT_ERROR";
        }
        sb.append(str);
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
}
