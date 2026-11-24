package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w50 implements s70 {
    public final j70 a;

    public w50(j70 j70Var) {
        this.a = j70Var;
    }

    @Override // defpackage.s70
    public final j70 o() {
        return this.a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.a + ')';
    }
}
