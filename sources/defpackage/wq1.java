package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wq1 extends zr1 {
    public static final wq1 c = new wq1(0, 2, 1);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        int i = ((j21) izVar.e(0)).a;
        List list = (List) izVar.e(1);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            int i3 = i + i2;
            xfVar.a(i3, obj);
            xfVar.d(i3, obj);
        }
    }
}
