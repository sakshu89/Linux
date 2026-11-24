package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class or4 {
    public static final sc a(j70 j70Var) {
        sc scVar = (sc) j70Var.v(xy.X);
        if (scVar != null) {
            return scVar;
        }
        og.n("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.");
        return null;
    }
}
