package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aj0 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ bj0 c;
    public final /* synthetic */ long e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ aj0(bj0 bj0Var, long j, int i) {
        super(1);
        this.b = i;
        this.c = bj0Var;
        this.e = j;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0067  */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        hq0 hq0Var;
        hq0 hq0Var2;
        long jB;
        int iOrdinal;
        int i = this.b;
        bj0 bj0Var = this.c;
        switch (i) {
            case 0:
                int iOrdinal2 = ((si0) obj).ordinal();
                long j = this.e;
                if (iOrdinal2 == 0) {
                    zw zwVar = bj0Var.Y.a.b;
                    if (zwVar != null && (hq0Var = zwVar.b) != null) {
                        j = ((l21) hq0Var.j(new l21(j))).a;
                    }
                } else if (iOrdinal2 != 1) {
                    if (iOrdinal2 != 2) {
                        dk0.l();
                        return null;
                    }
                    zw zwVar2 = bj0Var.Z.a.b;
                    if (zwVar2 != null && (hq0Var2 = zwVar2.b) != null) {
                        j = ((l21) hq0Var2.j(new l21(j))).a;
                    }
                }
                return new l21(j);
            default:
                si0 si0Var = (si0) obj;
                if (bj0Var.f0 == null || bj0Var.I0() == null || g31.a(bj0Var.f0, bj0Var.I0()) || (iOrdinal = si0Var.ordinal()) == 0 || iOrdinal == 1) {
                    jB = 0;
                } else {
                    if (iOrdinal != 2) {
                        dk0.l();
                        return null;
                    }
                    zw zwVar3 = bj0Var.Z.a.b;
                    if (zwVar3 != null) {
                        hq0 hq0Var3 = zwVar3.b;
                        long j2 = this.e;
                        long j3 = ((l21) hq0Var3.j(new l21(j2))).a;
                        c6 c6VarI0 = bj0Var.I0();
                        c6VarI0.getClass();
                        z61 z61Var = z61.a;
                        long jA = c6VarI0.a(j2, j3, z61Var);
                        c6 c6Var = bj0Var.f0;
                        c6Var.getClass();
                        jB = e21.b(jA, c6Var.a(j2, j3, z61Var));
                    } else {
                        jB = 0;
                    }
                }
                return new e21(jB);
        }
    }
}
