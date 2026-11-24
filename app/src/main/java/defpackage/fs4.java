package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fs4 {
    public static final long a(l42 l42Var) {
        float f = l42Var.c - l42Var.a;
        return (((long) Float.floatToRawIntBits(l42Var.d - l42Var.b)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }
}
