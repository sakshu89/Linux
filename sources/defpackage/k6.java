package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k6 extends a54 {
    public final int b;

    public k6(int i) {
        this.b = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof k6) && ((k6) obj).b == this.b;
    }

    public final int hashCode() {
        return this.b * 31;
    }
}
