package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k73 extends k61 implements vq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ tw0[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k73(tw0[] tw0VarArr, int i) {
        super(2);
        this.b = i;
        this.c = tw0VarArr;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.b;
        tw0[] tw0VarArr = this.c;
        switch (i) {
            case 0:
                return Float.valueOf(iz3.a((yw1) obj, true, tw0VarArr, ((Number) obj2).floatValue()));
            default:
                return Float.valueOf(iz3.a((yw1) obj, false, tw0VarArr, ((Number) obj2).floatValue()));
        }
    }
}
