package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x52 {
    public static final nr4 b = new nr4(17);
    public final Integer a;

    public x52(Integer num) {
        this.a = num;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof x52) || obj == b;
    }

    public final int hashCode() {
        return u42.a(x52.class).hashCode();
    }

    public final String toString() {
        return "Ambiguous(outOfRangeMax=" + this.a + ")";
    }
}
