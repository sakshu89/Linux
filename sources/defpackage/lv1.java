package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lv1 implements j52 {
    public final Set a;
    public final pm1 b = new pm1(new k52[16]);

    public lv1(Set set) {
        this.a = set;
    }

    @Override // defpackage.j52
    public final void a() {
        pm1 pm1Var = this.b;
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        for (int i2 = 0; i2 < i; i2++) {
            j52 j52Var = ((k52) objArr[i2]).a;
            this.a.remove(j52Var);
            j52Var.a();
        }
    }

    @Override // defpackage.j52
    public final void b() {
    }

    @Override // defpackage.j52
    public final void d() {
    }
}
