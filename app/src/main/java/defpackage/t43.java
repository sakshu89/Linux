package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t43 extends l70 {
    public static final t43 c = new t43();

    @Override // defpackage.l70
    public final void L(j70 j70Var, Runnable runnable) {
        xa0.e.c.e(runnable, true, false);
    }

    @Override // defpackage.l70
    public final void M(j70 j70Var, Runnable runnable) {
        xa0.e.c.e(runnable, true, true);
    }

    @Override // defpackage.l70
    public final l70 O(int i) {
        lq4.a(i);
        return i >= nw2.d ? this : super.O(i);
    }

    @Override // defpackage.l70
    public final String toString() {
        return "Dispatchers.IO";
    }
}
