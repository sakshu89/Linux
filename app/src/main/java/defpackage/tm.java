package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tm {
    public final pm1 a;

    public tm(int i) {
        switch (i) {
            case 1:
                this.a = new pm1(new l81[16]);
                break;
            default:
                this.a = new pm1(new h50[16]);
                break;
        }
    }

    public void a(CancellationException cancellationException) {
        pm1 pm1Var = this.a;
        int i = pm1Var.c;
        wv[] wvVarArr = new wv[i];
        for (int i2 = 0; i2 < i; i2++) {
            wvVarArr[i2] = ((h50) pm1Var.a[i2]).b;
        }
        for (int i3 = 0; i3 < i; i3++) {
            wvVarArr[i3].m(cancellationException);
        }
        if (pm1Var.c == 0) {
            return;
        }
        c11.c("uncancelled requests present");
    }

    public void b() {
        pm1 pm1Var = this.a;
        h21 h21VarF = ky3.f(0, pm1Var.c);
        int i = h21VarF.a;
        int i2 = h21VarF.b;
        if (i <= i2) {
            while (true) {
                ((h50) pm1Var.a[i]).b.h(q43.a);
                if (i == i2) {
                    break;
                } else {
                    i++;
                }
            }
        }
        pm1Var.h();
    }
}
