package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y21 {
    public final int a;
    public final int b;
    public final q91 c;

    public y21(int i, int i2, q91 q91Var) {
        this.a = i;
        this.b = i2;
        this.c = q91Var;
        if (i < 0) {
            c11.a("startIndex should be >= 0");
        }
        if (i2 > 0) {
            return;
        }
        c11.a("size should be > 0");
    }
}
