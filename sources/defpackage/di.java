package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class di {
    public final int a;
    public final int b;
    public final tp c;

    public di(int i, int i2, tp tpVar) {
        this.a = i;
        this.b = i2;
        this.c = tpVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof di) {
            di diVar = (di) obj;
            return this.a == diVar.a && this.b == diVar.b && this.c == diVar.c;
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() ^ ((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003);
    }

    public final String toString() {
        return "PendingSnapshot{jpegQuality=" + this.a + ", rotationDegrees=" + this.b + ", completer=" + this.c + "}";
    }
}
