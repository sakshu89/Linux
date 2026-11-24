package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r41 implements vo1 {
    public static final r41 b = new r41(0);
    public static final /* synthetic */ r41 c = new r41(1);
    public static final /* synthetic */ r41 d = new r41(2);
    public final /* synthetic */ int a;

    public /* synthetic */ r41(int i) {
        this.a = i;
    }

    @Override // defpackage.oi0
    public final void a(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                t41 t41Var = u41.f;
                throw new ri0("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                wo1 wo1Var = (wo1) obj2;
                wo1Var.a(tx3.g, entry.getKey());
                wo1Var.a(tx3.h, entry.getValue());
                return;
            case 2:
                throw new ri0("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
            case 3:
                Map.Entry entry2 = (Map.Entry) obj;
                wo1 wo1Var2 = (wo1) obj2;
                wo1Var2.a(x14.g, entry2.getKey());
                wo1Var2.a(x14.h, entry2.getValue());
                return;
            default:
                throw new ri0("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    }
}
