package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f10 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ n10 b;

    public /* synthetic */ f10(n10 n10Var, int i) {
        this.a = i;
        this.b = n10Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        n10 n10Var = this.b;
        switch (i) {
            case 0:
                n10Var.reportFullyDrawn();
                return q43.a;
            case 1:
                return new eq0(n10Var.i, new f10(n10Var, 0));
            case 2:
                return new oa2(n10Var.getApplication(), n10Var, n10Var.getIntent() != null ? n10Var.getIntent().getExtras() : null);
            default:
                bq1 bq1Var = new bq1(new e10(n10Var, 1));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (g31.a(Looper.myLooper(), Looper.getMainLooper())) {
                        n10Var.a.a(new g10(bq1Var, n10Var));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new o8(10, n10Var, bq1Var));
                    }
                }
                return bq1Var;
        }
    }
}
