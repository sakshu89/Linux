package defpackage;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ea2 implements ba2, na2 {
    public final /* synthetic */ ca2 a;
    public qb1 b;
    public q91 c;

    public ea2(ca2 ca2Var) {
        this.a = ca2Var;
        Object objE = ca2Var.e("androidx.savedstate.SavedStateRegistry");
        Bundle bundle = objE instanceof Bundle ? (Bundle) objE : null;
        if (bundle != null && this.c == null) {
            q91 q91Var = new q91(new ma2(this, new kb(17, this)));
            this.c = q91Var;
            q91Var.D(bundle);
        }
        ca2Var.a("androidx.savedstate.SavedStateRegistry", new kb(15, this));
    }

    @Override // defpackage.ba2
    public final kf a(String str, fq0 fq0Var) {
        return this.a.a(str, fq0Var);
    }

    @Override // defpackage.na2
    public final q91 b() {
        q91 q91Var = this.c;
        if (q91Var == null) {
            q91 q91Var2 = new q91(new ma2(this, new kb(17, this)));
            this.c = q91Var2;
            q91Var2.D(null);
            q91Var = q91Var2;
        }
        return (q91) q91Var.c;
    }

    @Override // defpackage.ba2
    public final boolean c(Object obj) {
        return this.a.c(obj);
    }

    @Override // defpackage.ba2
    public final Map d() {
        return this.a.d();
    }

    @Override // defpackage.ba2
    public final Object e(String str) {
        return this.a.e(str);
    }

    @Override // defpackage.ob1
    public final qb1 f() {
        qb1 qb1Var = this.b;
        if (qb1Var != null) {
            return qb1Var;
        }
        qb1 qb1Var2 = new qb1(this, false);
        this.b = qb1Var2;
        return qb1Var2;
    }
}
