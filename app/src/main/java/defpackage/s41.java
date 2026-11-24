package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s41 implements f63 {
    public static final s41 b = new s41(0);
    public static final s41 c = new s41(1);
    public final /* synthetic */ int a;

    public /* synthetic */ s41(int i) {
        this.a = i;
    }

    @Override // defpackage.oi0
    public final void a(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                t41 t41Var = u41.f;
                ((g63) obj2).b((String) obj);
                break;
            default:
                t41 t41Var2 = u41.f;
                ((g63) obj2).c(((Boolean) obj).booleanValue());
                break;
        }
    }
}
