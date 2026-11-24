package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y8 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ float b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ y8(i53 i53Var, float f, hq0 hq0Var) {
        this.a = 2;
        this.c = i53Var;
        this.b = f;
        this.e = hq0Var;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0098  */
    /* JADX WARN: Code duplicated, block: B:22:0x009a A[PHI: r0
      0x009a: PHI (r0v11 float) = (r0v10 float), (r0v17 float) binds: [B:26:0x00ae, B:20:0x0096] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        float fFloatValue;
        long jRound;
        int i = this.a;
        q43 q43Var = q43.a;
        float f = 0.0f;
        Object obj2 = this.e;
        float f2 = this.b;
        Object obj3 = this.c;
        switch (i) {
            case 0:
                p9 p9Var = (p9) obj3;
                nl nlVar = (nl) obj2;
                p71 p71Var = (p71) obj;
                p71Var.a();
                ew ewVar = p71Var.a;
                kf kfVar = ewVar.b;
                long jR = kfVar.r();
                kfVar.m().m();
                try {
                    q82 q82Var = (q82) kfVar.b;
                    q82Var.J(f2, 0.0f);
                    q82Var.G(45.0f, 0L);
                    ewVar.e(p9Var, nlVar);
                    return q43Var;
                } finally {
                    cq.t(kfVar, jR);
                }
            case 1:
                q42 q42Var = (q42) obj3;
                z91 z91Var = (z91) obj2;
                od odVar = (od) obj;
                if (f2 > 0.0f) {
                    fFloatValue = ((Number) odVar.e.getValue()).floatValue();
                    if (fFloatValue > f2) {
                        f = f2;
                    } else {
                        f = fFloatValue;
                    }
                } else if (f2 < 0.0f) {
                    fFloatValue = ((Number) odVar.e.getValue()).floatValue();
                    if (fFloatValue < f2) {
                        f = f2;
                    } else {
                        f = fFloatValue;
                    }
                }
                float f3 = f - q42Var.a;
                if (f3 != ((kd2) z91Var.b).a(f3) || f != ((Number) odVar.e.getValue()).floatValue()) {
                    odVar.a();
                }
                q42Var.a += f3;
                return q43Var;
            default:
                i53 i53Var = (i53) obj3;
                hq0 hq0Var = (hq0) obj2;
                long jLongValue = ((Long) obj).longValue();
                if (i53Var.b == Long.MIN_VALUE) {
                    i53Var.b = jLongValue;
                }
                float f4 = i53Var.e;
                rd rdVar = new rd(f4);
                rd rdVar2 = i53.f;
                if (f2 == 0.0f) {
                    jRound = i53Var.a.a(new rd(f4), rdVar2, i53Var.c);
                } else {
                    double d = (jLongValue - i53Var.b) / f2;
                    if (Double.isNaN(d)) {
                        og.i("Cannot round NaN value.");
                        return null;
                    }
                    jRound = Math.round(d);
                }
                long j = jRound;
                float f5 = ((rd) i53Var.a.h(j, rdVar, rdVar2, i53Var.c)).a;
                i53Var.c = (rd) i53Var.a.f(j, rdVar, rdVar2, i53Var.c);
                i53Var.b = jLongValue;
                float f6 = i53Var.e - f5;
                i53Var.e = f5;
                hq0Var.j(Float.valueOf(f6));
                return q43Var;
        }
    }

    public /* synthetic */ y8(float f, Object obj, Object obj2, int i) {
        this.a = i;
        this.b = f;
        this.c = obj;
        this.e = obj2;
    }
}
