package defpackage;

import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g10 implements lb1 {
    public final /* synthetic */ bq1 a;
    public final /* synthetic */ n10 b;

    public /* synthetic */ g10(bq1 bq1Var, n10 n10Var) {
        this.a = bq1Var;
        this.b = n10Var;
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) {
        if (db1Var == db1.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = f3.a(this.b);
            bq1 bq1Var = this.a;
            bq1Var.e = onBackInvokedDispatcherA;
            bq1Var.c(bq1Var.g);
        }
    }
}
