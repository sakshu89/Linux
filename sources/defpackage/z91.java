package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z91 implements kd2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ z91(int i, Object obj, Object obj2) {
        this.a = i;
        this.c = obj2;
        this.b = obj;
    }

    public static int b(z91 z91Var, int i) {
        Object obj;
        ea1 ea1Var = (ea1) z91Var.c;
        x91 x91VarI = ea1Var.i();
        if (!x91VarI.k.isEmpty()) {
            int iG = ea1Var.g();
            if (i > z91Var.c() || iG > i) {
                return ((i - ea1Var.g()) * fq4.a(x91VarI)) - ea1Var.h();
            }
            List list = x91VarI.k;
            int size = list.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    obj = null;
                    break;
                }
                obj = list.get(i2);
                if (((y91) obj).a == i) {
                    break;
                }
                i2++;
            }
            y91 y91Var = (y91) obj;
            if (y91Var != null) {
                return y91Var.j;
            }
        }
        return 0;
    }

    @Override // defpackage.kd2
    public final float a(float f) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((kd2) obj).a(f);
            default:
                he2 he2Var = (he2) obj;
                if (Math.abs(f) == 0.0f || ((Boolean) he2Var.h.a()).booleanValue()) {
                    return he2Var.d(he2Var.g(((fe2) this.c).a(2, he2Var.e(he2Var.h(f)))));
                }
                throw new gm0("The fling animation was cancelled", 0);
        }
    }

    public int c() {
        y91 y91Var = (y91) mz.E(((ea1) this.c).i().k);
        if (y91Var != null) {
            return y91Var.a;
        }
        return 0;
    }
}
