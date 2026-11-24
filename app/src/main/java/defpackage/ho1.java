package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ho1 {
    public final pm1 a = new pm1(new xn1[16]);
    public final yl1 b = new yl1(10);

    public boolean a(if1 if1Var, y61 y61Var, l11 l11Var, boolean z) {
        pm1 pm1Var = this.a;
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            z2 = ((xn1) objArr[i2]).a(if1Var, y61Var, l11Var, z) || z2;
        }
        return z2;
    }

    public void b(l11 l11Var) {
        pm1 pm1Var = this.a;
        int i = pm1Var.c;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            }
            if (((xn1) pm1Var.a[i]).d.a == 0) {
                pm1Var.l(i);
            }
        }
    }
}
