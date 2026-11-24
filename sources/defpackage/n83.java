package defpackage;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n83 implements gt {
    public final gt b;
    public final zq c;

    public n83(gt gtVar, zq zqVar) {
        this.b = gtVar;
        this.c = zqVar;
    }

    @Override // defpackage.gt
    public final wc1 a(int i, int i2) {
        return this.b.a(i, i2);
    }

    @Override // defpackage.gt
    public final s30 b() {
        return this.b.b();
    }

    @Override // defpackage.gt
    public final void c(s30 s30Var) {
        this.b.c(s30Var);
    }

    @Override // defpackage.gt
    public final void d() {
        this.b.d();
    }

    @Override // defpackage.gt
    public final Rect e() {
        return this.b.e();
    }

    @Override // defpackage.gt
    public final void f(int i) {
        this.b.f(i);
    }

    @Override // defpackage.gt
    public final void g(qy0 qy0Var) {
        this.b.g(qy0Var);
    }

    @Override // defpackage.gt
    public final wc1 h(ArrayList arrayList, int i, int i2) {
        hh1.a("Only support one capture config.", arrayList.size() == 1);
        wc1 wc1VarA = this.b.a(i, i2);
        return new uc1(new ArrayList(Collections.singletonList(oz3.g(oz3.g(oz3.g(jr0.b(wc1VarA), new nr0(wc1VarA, 1), xg4.a()), new qq(10, this, arrayList), xg4.a()), new nr0(wc1VarA, 2), xg4.a()))), true, xg4.a());
    }

    @Override // defpackage.gt
    public final void i(gh2 gh2Var) {
        this.b.i(gh2Var);
    }
}
