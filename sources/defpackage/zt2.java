package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zt2 implements s40 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ zt2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.s40
    public final void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                lj ljVar = (lj) obj;
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    int i2 = ljVar.b - ((ui) entry.getKey()).f;
                    if (((ui) entry.getKey()).g) {
                        i2 = -i2;
                    }
                    int iG = z13.g(i2);
                    st2 st2Var = (st2) entry.getValue();
                    st2Var.getClass();
                    vc4.d(new pt2(st2Var, iG, -1));
                }
                break;
            case 1:
                rw rwVar = (rw) obj2;
                xq4.c(3, "SurfaceViewImpl");
                if (rwVar != null) {
                    rwVar.a();
                }
                break;
            default:
                ((tp) obj2).a((kj) obj);
                break;
        }
    }
}
