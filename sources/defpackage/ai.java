package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ai extends ny {
    public final qh a;

    public ai(qh qhVar) {
        this.a = qhVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ny)) {
            return false;
        }
        ny nyVar = (ny) obj;
        Object obj2 = my.a;
        if (obj2.equals(obj2)) {
            return this.a.equals(((ai) nyVar).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ ((my.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "ClientInfo{clientType=" + my.a + ", androidClientInfo=" + this.a + "}";
    }
}
