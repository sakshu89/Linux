package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ht0 implements nm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ mt0 b;
    public final /* synthetic */ hq0 c;
    public final /* synthetic */ t42 e;

    public /* synthetic */ ht0(mt0 mt0Var, hq0 hq0Var, t42 t42Var, int i) {
        this.a = i;
        this.b = mt0Var;
        this.c = hq0Var;
        this.e = t42Var;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0026  */
    public final Object a(e5 e5Var, x50 x50Var) {
        gt0 gt0Var;
        kt0 kt0Var;
        int i = this.a;
        q43 q43Var = q43.a;
        t42 t42Var = this.e;
        hq0 hq0Var = this.c;
        mt0 mt0Var = this.b;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                if (x50Var instanceof gt0) {
                    gt0Var = (gt0) x50Var;
                    int i2 = gt0Var.j;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        gt0Var.j = i2 - Integer.MIN_VALUE;
                    } else {
                        gt0Var = new gt0(this, x50Var);
                    }
                } else {
                    gt0Var = new gt0(this, x50Var);
                }
                Object obj = gt0Var.f;
                int i3 = gt0Var.j;
                if (i3 == 0) {
                    bz3.g(obj);
                    hk2 hk2Var = mt0Var.m;
                    gt0Var.e = e5Var;
                    gt0Var.j = 1;
                    if (hk2Var.n(e5Var, gt0Var) == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i3 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    e5Var = gt0Var.e;
                    bz3.g(obj);
                }
                hq0Var.j(e5Var);
                if (!(e5Var instanceof z4)) {
                    return q43Var;
                }
                t42Var.a = e5Var;
                return q43Var;
            default:
                if (x50Var instanceof kt0) {
                    kt0Var = (kt0) x50Var;
                    int i4 = kt0Var.j;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        kt0Var.j = i4 - Integer.MIN_VALUE;
                    } else {
                        kt0Var = new kt0(this, x50Var);
                    }
                } else {
                    kt0Var = new kt0(this, x50Var);
                }
                Object obj2 = kt0Var.f;
                int i5 = kt0Var.j;
                if (i5 == 0) {
                    bz3.g(obj2);
                    hk2 hk2Var2 = mt0Var.m;
                    kt0Var.e = e5Var;
                    kt0Var.j = 1;
                    if (hk2Var2.n(e5Var, kt0Var) == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i5 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    e5Var = kt0Var.e;
                    bz3.g(obj2);
                }
                hq0Var.j(e5Var);
                if (!(e5Var instanceof z4)) {
                    return q43Var;
                }
                t42Var.a = e5Var;
                return q43Var;
        }
    }

    @Override // defpackage.nm0
    public final /* bridge */ /* synthetic */ Object n(Object obj, x50 x50Var) {
        switch (this.a) {
            case 0:
                break;
        }
        return a((e5) obj, x50Var);
    }
}
