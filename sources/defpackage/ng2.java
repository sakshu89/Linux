package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ng2 {
    public final String a;
    public final vq0 b;
    public final boolean c;

    public ng2(String str, vq0 vq0Var) {
        this.a = str;
        this.b = vq0Var;
    }

    public final String toString() {
        return "AccessibilityKey: " + this.a;
    }

    public /* synthetic */ ng2(String str) {
        this(str, jd.m0);
    }

    public ng2(String str, int i) {
        this(str);
        this.c = true;
    }

    public ng2(String str, boolean z, vq0 vq0Var) {
        this(str, vq0Var);
        this.c = z;
    }
}
