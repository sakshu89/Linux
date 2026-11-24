package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface ck1 extends ek1 {
    @Override // defpackage.ek1
    default Object a(vq0 vq0Var, Object obj) {
        return vq0Var.e(obj, this);
    }

    @Override // defpackage.ek1
    default boolean b(hq0 hq0Var) {
        return ((Boolean) hq0Var.j(this)).booleanValue();
    }
}
