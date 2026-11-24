package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface x22 extends s30 {
    @Override // defpackage.s30
    default boolean a(bi biVar) {
        return n().a(biVar);
    }

    @Override // defpackage.s30
    default r30 b(bi biVar) {
        return n().b(biVar);
    }

    @Override // defpackage.s30
    default void c(qq qqVar) {
        n().c(qqVar);
    }

    @Override // defpackage.s30
    default Object d(bi biVar, Object obj) {
        return n().d(biVar, obj);
    }

    @Override // defpackage.s30
    default Set e() {
        return n().e();
    }

    @Override // defpackage.s30
    default Object f(bi biVar) {
        return n().f(biVar);
    }

    @Override // defpackage.s30
    default Set g(bi biVar) {
        return n().g(biVar);
    }

    @Override // defpackage.s30
    default Object h(bi biVar, r30 r30Var) {
        return n().h(biVar, r30Var);
    }

    s30 n();
}
