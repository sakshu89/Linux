package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vw2 {
    public final int a;

    public static String a(int i) {
        if (i == 1) {
            return "Left";
        }
        if (i == 2) {
            return "Right";
        }
        if (i == 3) {
            return "Center";
        }
        if (i == 4) {
            return "Justify";
        }
        if (i == 5) {
            return "Start";
        }
        if (i == 6) {
            return "End";
        }
        return i == 0 ? "Unspecified" : "Invalid";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof vw2) {
            return this.a == ((vw2) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.a);
    }

    public final String toString() {
        return a(this.a);
    }
}
