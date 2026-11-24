package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iy2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ iy2(Object obj, boolean z, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.k = obj;
        this.j = z;
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
        return ((iy2) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        boolean z = this.j;
        Object obj2 = this.k;
        switch (i) {
            case 0:
                return new iy2((ny2) obj2, z, x50Var, 0);
            default:
                return new iy2((j13) obj2, z, x50Var, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [x50] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        sy syVar;
        int i = this.f;
        boolean z = this.j;
        Object obj2 = this.k;
        t70 t70Var = t70.a;
        be beVar = 0;
        beVar = 0;
        switch (i) {
            case 0:
                ny2 ny2Var = (ny2) obj2;
                int i2 = this.i;
                q43 q43Var = q43.a;
                if (i2 == 0) {
                    bz3.g(obj);
                    if (!oz2.c(ny2Var.n().b) && !(ny2Var.f instanceof nu1)) {
                        be beVarD = bc4.d(ny2Var.n());
                        beVar = beVarD;
                        if (z) {
                            int iE = oz2.e(ny2Var.n().b);
                            ny2Var.c.j(ny2.e(ny2Var.n().a, hc4.a(iE, iE)));
                            ny2Var.q(rv0.a);
                            beVar = beVarD;
                        }
                    }
                    if (beVar != 0 && (syVar = ny2Var.h) != null) {
                        oy oyVarA = di4.a(beVar);
                        this.i = 1;
                        ((y6) syVar).a(oyVarA);
                        if (q43Var == t70Var) {
                            return t70Var;
                        }
                    }
                } else {
                    if (i2 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43Var;
            default:
                int i3 = this.i;
                if (i3 != 0) {
                    if (i3 == 1) {
                        bz3.g(obj);
                        return obj;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                jr2 jr2Var = ((j13) obj2).d;
                d0 d0Var = new d0(z, (x50) beVar, 6);
                this.i = 1;
                Object objD = rn4.d(jr2Var, d0Var, this);
                return objD == t70Var ? t70Var : objD;
        }
    }
}
