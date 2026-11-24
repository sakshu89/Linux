package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fu {
    public final String a;
    public final String b;

    public fu(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fu)) {
            return false;
        }
        fu fuVar = (fu) obj;
        return this.a.equals(fuVar.a) && this.b.equals(fuVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return ky0.l("Location(column=", this.a, ", value=", this.b, ")");
    }
}
