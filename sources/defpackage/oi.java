package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oi {
    public final ob1 a;
    public final yh b;

    public oi(ob1 ob1Var, yh yhVar) {
        if (ob1Var == null) {
            dk0.n("Null lifecycleOwner");
            throw null;
        }
        this.a = ob1Var;
        if (yhVar != null) {
            this.b = yhVar;
        } else {
            dk0.n("Null cameraId");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof oi) {
            oi oiVar = (oi) obj;
            if (this.a.equals(oiVar.a) && this.b.equals(oiVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "Key{lifecycleOwner=" + this.a + ", cameraId=" + this.b + "}";
    }
}
