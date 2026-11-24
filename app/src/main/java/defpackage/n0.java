package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n0 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ky b;

    public /* synthetic */ n0(ky kyVar, int i) {
        this.a = i;
        this.b = kyVar;
    }

    @Override // defpackage.fq0
    public final Object a() {
        xb0 xb0Var;
        int i = this.a;
        ky kyVar = this.b;
        switch (i) {
            case 0:
                c01 c01Var = (c01) ij4.a(kyVar, zz0.a);
                if (c01Var == null) {
                    c11.a("clickable only supports IndicationNodeFactory instances provided to LocalIndication, but Indication was provided instead. Either migrate the Indication implementation to implement IndicationNodeFactory, or use the other clickable overload that takes an Indication parameter, and explicitly pass LocalIndication.current there. The Indication instance provided here was: " + c01Var);
                }
                c01 c01Var2 = kyVar.h0;
                kyVar.h0 = c01Var;
                if (c01Var2 != null && !g31.a(c01Var, c01Var2) && ((xb0Var = kyVar.i0) != null || !kyVar.p0)) {
                    if (xb0Var != null) {
                        kyVar.J0(xb0Var);
                    }
                    kyVar.i0 = null;
                    kyVar.P0();
                }
                return q43.a;
            default:
                kyVar.f0.a();
                return Boolean.TRUE;
        }
    }
}
