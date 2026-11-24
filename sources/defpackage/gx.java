package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gx extends nu2 implements vq0 {
    public final /* synthetic */ int f = 0;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ jx k;
    public final /* synthetic */ nm0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gx(jx jxVar, nm0 nm0Var, Object obj, x50 x50Var) {
        super(2, x50Var);
        this.k = jxVar;
        this.n = nm0Var;
        this.j = obj;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
        }
        return ((gx) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        nm0 nm0Var = this.n;
        jx jxVar = this.k;
        switch (i) {
            case 0:
                return new gx(jxVar, nm0Var, this.j, x50Var);
            default:
                gx gxVar = new gx(jxVar, nm0Var, x50Var);
                gxVar.j = obj;
                return gxVar;
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 != 0) {
                    if (i2 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                wq0 wq0Var = this.k.f;
                Object obj2 = this.j;
                this.i = 1;
                return wq0Var.c(this.n, obj2, this) == t70Var ? t70Var : q43Var;
            default:
                int i3 = this.i;
                if (i3 != 0) {
                    if (i3 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                s70 s70Var = (s70) this.j;
                t42 t42Var = new t42();
                jx jxVar = this.k;
                mm0 mm0Var = jxVar.e;
                ix ixVar = new ix(t42Var, s70Var, jxVar, this.n, 0);
                this.i = 1;
                return mm0Var.a(ixVar, this) == t70Var ? t70Var : q43Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gx(jx jxVar, nm0 nm0Var, x50 x50Var) {
        super(2, x50Var);
        this.k = jxVar;
        this.n = nm0Var;
    }
}
