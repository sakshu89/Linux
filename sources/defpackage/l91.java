package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l91 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ o91 b;

    public /* synthetic */ l91(o91 o91Var, int i) {
        this.a = i;
        this.b = o91Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        o91 o91Var = this.b;
        switch (i) {
            case 0:
                t91 t91Var = (t91) o91Var.x.a();
                int iC = t91Var.c();
                int i2 = 0;
                while (i2 < iC) {
                    if (t91Var.d(i2).equals(obj)) {
                        return Integer.valueOf(i2);
                    }
                    i2++;
                }
                i2 = -1;
                return Integer.valueOf(i2);
            default:
                int iIntValue = ((Integer) obj).intValue();
                t91 t91Var2 = (t91) o91Var.x.a();
                if (iIntValue < 0 || iIntValue >= t91Var2.c()) {
                    StringBuilder sbP = ky0.p("Can't scroll to index ", iIntValue, ", it is out of bounds [0, ");
                    sbP.append(t91Var2.c());
                    sbP.append(')');
                    c11.a(sbP.toString());
                }
                uf4.b(o91Var.w0(), null, new n91(o91Var, iIntValue, null), 3);
                return Boolean.TRUE;
        }
    }
}
