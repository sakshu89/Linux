package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i7 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ t42 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i7(int i, t42 t42Var) {
        super(1);
        this.b = i;
        this.c = t42Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        boolean z;
        int i = this.b;
        t42 t42Var = this.c;
        switch (i) {
            case 0:
                t42Var.a = (ko0) obj;
                return Boolean.TRUE;
            case 1:
                ww0 ww0Var = (ww0) obj;
                Object obj2 = t42Var.a;
                if (obj2 == null && ww0Var.X) {
                    t42Var.a = ww0Var;
                } else if (obj2 != null) {
                    ww0Var.getClass();
                }
                return Boolean.TRUE;
            default:
                xb0 xb0Var = (t23) obj;
                if (((dk1) xb0Var).a.w) {
                    t42Var.a = xb0Var;
                    z = false;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
        }
    }
}
