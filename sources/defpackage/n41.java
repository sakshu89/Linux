package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n41 extends gr0 implements wq0 {
    public static final n41 k = new n41(3, p41.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        Object objU;
        p41 p41Var = (p41) obj;
        gf2 gf2Var = (gf2) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p41.a;
        do {
            objU = p41Var.U();
            if (!(objU instanceof rz0)) {
                if (!(objU instanceof a10)) {
                    objU = tz3.e(objU);
                }
                gf2Var.f = objU;
            }
            return q43.a;
        } while (p41Var.m0(objU) < 0);
        gf2Var.c = hp4.d(p41Var, true, new m41(p41Var, gf2Var));
        return q43.a;
    }
}
