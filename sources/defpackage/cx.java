package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cx extends dx {
    private volatile /* synthetic */ int consumed$volatile;
    public final bx e;

    static {
        AtomicIntegerFieldUpdater.newUpdater(cx.class, "consumed$volatile");
    }

    public /* synthetic */ cx(bx bxVar) {
        this(bxVar, gi0.a, -3, nn.a);
    }

    @Override // defpackage.dx, defpackage.mm0
    public final Object a(nm0 nm0Var, x50 x50Var) throws Throwable {
        int i = this.b;
        t70 t70Var = t70.a;
        if (i == -3) {
            Object objA = sn4.a(nm0Var, this.e, false, x50Var);
            if (objA == t70Var) {
                return objA;
            }
        } else {
            Object objA2 = super.a(nm0Var, x50Var);
            if (objA2 == t70Var) {
                return objA2;
            }
        }
        return q43.a;
    }

    @Override // defpackage.dx
    public final String c() {
        return "channel=" + this.e;
    }

    @Override // defpackage.dx
    public final Object d(j12 j12Var, x50 x50Var) throws Throwable {
        Object objA = sn4.a(new wg2(j12Var), this.e, false, x50Var);
        return objA == t70.a ? objA : q43.a;
    }

    @Override // defpackage.dx
    public final dx e(j70 j70Var, int i, nn nnVar) {
        return new cx(this.e, j70Var, i, nnVar);
    }

    @Override // defpackage.dx
    public final mm0 f() {
        return new cx(this.e);
    }

    @Override // defpackage.dx
    public final bx g(s70 s70Var) {
        return this.b == -3 ? this.e : super.g(s70Var);
    }

    public cx(bx bxVar, j70 j70Var, int i, nn nnVar) {
        super(j70Var, i, nnVar);
        this.e = bxVar;
    }
}
