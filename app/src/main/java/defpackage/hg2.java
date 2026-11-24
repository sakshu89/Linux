package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hg2 {
    public final cg2 a;
    public final nl1 b;

    public hg2(gg2 gg2Var, c21 c21Var) {
        this.a = gg2Var.d;
        this.b = new nl1(gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0).size());
        List listI = gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0);
        int size = listI.size();
        for (int i = 0; i < size; i++) {
            gg2 gg2Var2 = (gg2) listI.get(i);
            if (c21Var.a(gg2Var2.g)) {
                this.b.a(gg2Var2.g);
            }
        }
    }
}
