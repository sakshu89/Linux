package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ei {
    public final ui a;
    public final ui b;

    public ei(ui uiVar, ui uiVar2) {
        this.a = uiVar;
        this.b = uiVar2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ei)) {
            return false;
        }
        ei eiVar = (ei) obj;
        return this.a.equals(eiVar.a) && this.b.equals(eiVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "DualOutConfig{primaryOutConfig=" + this.a + ", secondaryOutConfig=" + this.b + "}";
    }
}
