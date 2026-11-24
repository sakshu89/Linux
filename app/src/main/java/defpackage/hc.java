package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hc implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ mm1 b;

    public /* synthetic */ hc(mm1 mm1Var, int i) {
        this.a = i;
        this.b = mm1Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        q43 q43Var = q43.a;
        mm1 mm1Var = this.b;
        switch (i) {
            case 0:
                y61 y61Var = (y61) mm1Var.getValue();
                if (y61Var != null) {
                    return y61Var;
                }
                c11.d("Required value was null.");
                og.k();
                return null;
            case 1:
                y61 y61Var2 = (y61) mm1Var.getValue();
                if (y61Var2 != null) {
                    return y61Var2;
                }
                c11.d("Required value was null.");
                og.k();
                return null;
            case 2:
                Boolean bool = (Boolean) mm1Var.getValue();
                bool.booleanValue();
                return bool;
            case 3:
                return (t91) ((fq0) mm1Var.getValue()).a();
            case 4:
                return new r91((hq0) mm1Var.getValue());
            case 5:
                y61 y61Var3 = (y61) mm1Var.getValue();
                if (y61Var3 != null) {
                    return y61Var3;
                }
                c11.d("Required value was null.");
                og.k();
                return null;
            case 6:
                mm1Var.setValue(Boolean.FALSE);
                return q43Var;
            case 7:
                mm1Var.setValue(Boolean.TRUE);
                return q43Var;
            case 8:
                mm1Var.setValue(zt1.a);
                return q43Var;
            default:
                mm1Var.setValue(zt1.b);
                return q43Var;
        }
    }
}
