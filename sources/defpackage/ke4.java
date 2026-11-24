package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ke4 {
    public static qd a(float f, int i) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return new qd(eb4.a, Float.valueOf(0.0f), new rd(f), Long.MIN_VALUE, Long.MIN_VALUE, false);
    }

    public static qd b(qd qdVar, float f) {
        float f2 = ((rd) qdVar.c).a;
        return new qd(qdVar.a, Float.valueOf(f), new rd(f2), qdVar.e, qdVar.f, qdVar.i);
    }

    public static boolean c(byte b) {
        return b > -65;
    }
}
