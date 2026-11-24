package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z92 implements pd0 {
    public final /* synthetic */ aa2 a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ ea2 c;

    public z92(aa2 aa2Var, Object obj, ea2 ea2Var) {
        this.a = aa2Var;
        this.b = obj;
        this.c = ea2Var;
    }

    @Override // defpackage.pd0
    public final void a() {
        aa2 aa2Var = this.a;
        gm1 gm1Var = aa2Var.b;
        Object obj = this.b;
        Object objK = gm1Var.k(obj);
        ea2 ea2Var = this.c;
        if (objK == ea2Var) {
            Map map = aa2Var.a;
            Map mapD = ea2Var.d();
            if (mapD.isEmpty()) {
                map.remove(obj);
            } else {
                map.put(obj, mapD);
            }
        }
    }
}
