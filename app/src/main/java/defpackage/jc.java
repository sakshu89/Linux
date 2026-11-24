package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jc implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ mm1 b;

    public /* synthetic */ jc(mm1 mm1Var, int i) {
        this.a = i;
        this.b = mm1Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        mm1 mm1Var = this.b;
        switch (i) {
            case 0:
                mm1Var.setValue((y61) obj);
                return q43Var;
            case 1:
                mm1Var.setValue((y61) obj);
                return q43Var;
            case 2:
                mm1Var.setValue((y61) obj);
                return q43Var;
            case 3:
                Float f = (Float) obj;
                f.getClass();
                return Float.valueOf(((Number) ((hq0) mm1Var.getValue()).j(f)).floatValue());
            case 4:
                String str = (String) obj;
                str.getClass();
                mm1Var.setValue(str);
                return q43Var;
            case 5:
                zt1 zt1Var = (zt1) obj;
                zt1Var.getClass();
                mm1Var.setValue(zt1Var);
                return q43Var;
            case 6:
                return new g8(9, mm1Var);
            default:
                ((hq0) mm1Var.getValue()).j((jp1) obj);
                return q43Var;
        }
    }
}
