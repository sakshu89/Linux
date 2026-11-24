package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface ek1 {
    Object a(vq0 vq0Var, Object obj);

    boolean b(hq0 hq0Var);

    default ek1 c(ek1 ek1Var) {
        return ek1Var == bk1.a ? this : new q00(this, ek1Var);
    }
}
