package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q12 {
    public static final q12 b = new q12(new bz());
    public final bz a;

    public q12(bz bzVar) {
        this.a = bzVar;
        if (Float.isNaN(0.0f)) {
            og.i("current must not be NaN");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q12) && this.a.equals(((q12) obj).a);
    }

    public final int hashCode() {
        return (this.a.hashCode() + (Float.hashCode(0.0f) * 31)) * 31;
    }

    public final String toString() {
        return "ProgressBarRangeInfo(current=0.0, range=" + this.a + ", steps=0)";
    }
}
