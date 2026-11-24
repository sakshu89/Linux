package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j63 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ k63 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j63(k63 k63Var, int i) {
        super(1);
        this.b = i;
        this.c = k63Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.b;
        q43 q43Var = q43.a;
        k63 k63Var = this.c;
        switch (i) {
            case 0:
                k63Var.d = true;
                k63Var.f.a();
                return q43Var;
            default:
                rf0 rf0Var = (rf0) obj;
                kv0 kv0Var = k63Var.b;
                float f = k63Var.k;
                float f2 = k63Var.l;
                kf kfVarC = rf0Var.C();
                long jR = kfVarC.r();
                kfVarC.m().m();
                try {
                    ((q82) kfVarC.b).H(f, f2, 0L);
                    kv0Var.a(rf0Var);
                    return q43Var;
                } finally {
                    cq.t(kfVarC, jR);
                }
        }
    }
}
