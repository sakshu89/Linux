package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gn implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ gn(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((zv) obj2).cancel();
                return q43Var;
            case 1:
                ((yv) obj2).h(q43Var);
                return q43Var;
            case 2:
                float[] fArr = ((ih1) obj).a;
                y61 y61Var = (y61) obj2;
                if (y61Var.B()) {
                    pp4.c(y61Var).J(y61Var, fArr);
                }
                return q43Var;
            default:
                ((List) obj2).get(((Number) obj).intValue());
                return null;
        }
    }
}
