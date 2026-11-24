package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zr1 {
    public final int a;
    public final int b;

    public /* synthetic */ zr1(int i, int i2, int i3) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public abstract void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var);

    public j6 b(iz izVar) {
        return null;
    }

    public final String toString() {
        String strB = u42.a(getClass()).b();
        return strB == null ? "" : strB;
    }

    public zr1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
