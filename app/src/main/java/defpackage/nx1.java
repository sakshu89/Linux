package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nx1 {
    public final boolean a;
    public final int b;

    public nx1() {
        this.a = false;
        this.b = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nx1)) {
            return false;
        }
        nx1 nx1Var = (nx1) obj;
        return this.a == nx1Var.a && this.b == nx1Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Boolean.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.a + ", emojiSupportMatch=" + ((Object) ai0.a(this.b)) + ')';
    }

    public nx1(int i, boolean z) {
        this.a = z;
        this.b = i;
    }
}
