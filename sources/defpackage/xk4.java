package defpackage;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xk4 extends ov3 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xk4(int i) {
        super(2);
        this.b = i;
    }

    @Override // defpackage.ov3
    public final Object c(Object obj) {
        switch (this.b) {
            case 0:
                tj1 tj1VarC = tj1.c();
                return new nk4(tj1VarC.b(), (jk2) tj1VarC.a(jk2.class), new hk4(tj1.c().b(), (ak4) obj));
            case 1:
                tj1 tj1VarC2 = tj1.c();
                Context contextB = tj1.c().b();
                ArrayList arrayList = new ArrayList();
                ((oq4) obj).getClass();
                ak1 ak1Var = new ak1(25);
                po poVar = po.e;
                r23.b(contextB);
                r23.a().c(poVar);
                po.d.contains(new qi0("json"));
                arrayList.add(ak1Var);
                return new zq4(tj1VarC2.b(), (jk2) tj1VarC2.a(jk2.class));
            default:
                gs4 gs4Var = (gs4) obj;
                tj1 tj1VarC3 = tj1.c();
                return new ns4(tj1VarC3.b(), (jk2) tj1VarC3.a(jk2.class), new is4(tj1.c().b(), gs4Var), gs4Var.a);
        }
    }
}
