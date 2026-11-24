package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class i82 {
    public static final m30 a = new m30(new tv1(4));
    public static final k82 b;

    static {
        long j = sz.g;
        b = new k82(j, true);
        new k82(j, false);
    }

    public static k82 a() {
        long j = sz.g;
        return (de0.b(Float.NaN, Float.NaN) && sz.c(j, j)) ? b : new k82(j, true);
    }
}
