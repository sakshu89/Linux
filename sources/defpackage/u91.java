package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u91 extends v12 implements c51, fq0 {
    public final /* synthetic */ int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u91(int i, int i2, Class cls, Object obj, String str, String str2) {
        super(obj, cls, str, str2, i);
        this.k = i2;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.k;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((gr2) obj).getValue();
            default:
                return obj.getClass().getSimpleName();
        }
    }

    @Override // defpackage.pp
    public final w41 d() {
        u42.a.getClass();
        return this;
    }
}
