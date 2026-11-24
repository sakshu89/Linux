package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gi {
    public final Object a;
    public final v02 b;

    public gi(Object obj, v02 v02Var) {
        if (obj == null) {
            dk0.n("Null payload");
            throw null;
        }
        this.a = obj;
        this.b = v02Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gi)) {
            return false;
        }
        gi giVar = (gi) obj;
        return this.a.equals(giVar.a) && this.b.equals(giVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ (((1000003 * 1000003) ^ this.a.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.a + ", priority=" + this.b + "}";
    }
}
