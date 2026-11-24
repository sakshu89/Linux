package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o32 extends k61 implements fq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o32(Object obj, Object obj2, Object obj3, int i) {
        super(0);
        this.b = i;
        this.c = obj;
        this.e = obj2;
        this.f = obj3;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.b;
        Object obj = this.f;
        Object obj2 = this.e;
        Object obj3 = this.c;
        switch (i) {
            case 0:
                jh4 jh4Var = ((ww) obj3).b;
                jh4Var.getClass();
                return jh4Var.a(((w4) obj).h.d, ((yv0) obj2).a());
            default:
                a1 a1Var = (a1) obj3;
                a1Var.removeOnAttachStateChangeListener((n9) obj2);
                g31.d(a1Var).a.remove((kf2) obj);
                return q43.a;
        }
    }
}
