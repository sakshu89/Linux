package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {
    public static final iz1 c = new iz1("model_key_revision");
    public static final iz1 d = new iz1("cloud_enabled");
    public static final iz1 e = new iz1("provider_id");
    public static final iz1 f = new iz1("resolved_api_version");
    public static final iz1 g = new iz1("cloud_usage_day");
    public static final iz1 h = new iz1("cloud_usage_calls");
    public static final iz1 i = new iz1("cloud_daily_limit");
    public final Context a;
    public final x b;

    public f0(Context context) {
        this.a = context;
        this.b = new x(((c90) ((py0) g0.a(context)).b).d(), 1);
        ((py0) g0.a(context)).d();
    }

    public static final iz1 a(f0 f0Var, String str) {
        return new iz1("blocked_models_at/".concat(str));
    }

    public static final iz1 b(f0 f0Var, String str) {
        return new iz1("blocked_models/".concat(str));
    }

    public static final iz1 c(f0 f0Var, String str) {
        return new iz1(cq.j("resolved_at/", str));
    }

    public static final iz1 d(f0 f0Var, String str) {
        return new iz1(cq.j("resolved_model/", str));
    }

    public final Object e(String str, String str2, Long l, y50 y50Var) {
        Object objA;
        String string = cs2.V(str2).toString();
        return (string.length() != 0 && (objA = rq1.a(g0.a(this.a), new p(l, this, str, string, null, 0), y50Var)) == t70.a) ? objA : q43.a;
    }

    public final Object f(String str, y50 y50Var) {
        return rn4.c(new s(((c90) ((py0) g0.a(this.a)).b).d(), this, str, 0), y50Var);
    }

    public final Object g(String str, y50 y50Var) {
        return rn4.c(new s(((c90) ((py0) g0.a(this.a)).b).d(), this, str, 1), y50Var);
    }

    public final Object h(String str, y50 y50Var) {
        return rn4.c(new s(((c90) ((py0) g0.a(this.a)).b).d(), this, str, 2), y50Var);
    }

    public final Object i(y50 y50Var) {
        return rn4.c(new x(((c90) ((py0) g0.a(this.a)).b).d(), 0), y50Var);
    }

    public final Object j(nu2 nu2Var) {
        Object objA = rq1.a(g0.a(this.a), new y(this, null, 1), nu2Var);
        return objA == t70.a ? objA : q43.a;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public final Object k(String str, String str2, long j, long j2, y50 y50Var) {
        b0 b0Var;
        o42 o42Var;
        if (y50Var instanceof b0) {
            b0Var = (b0) y50Var;
            int i2 = b0Var.j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                b0Var.j = i2 - Integer.MIN_VALUE;
            } else {
                b0Var = new b0(this, y50Var);
            }
        } else {
            b0Var = new b0(this, y50Var);
        }
        b0 b0Var2 = b0Var;
        Object obj = b0Var2.f;
        int i3 = b0Var2.j;
        if (i3 == 0) {
            bz3.g(obj);
            o42 o42Var2 = new o42();
            c90 c90VarA = g0.a(this.a);
            c0 c0Var = new c0(j2, this, str, str2, j, o42Var2, null);
            b0Var2.e = o42Var2;
            b0Var2.j = 1;
            Object objA = rq1.a(c90VarA, c0Var, b0Var2);
            t70 t70Var = t70.a;
            if (objA == t70Var) {
                return t70Var;
            }
            o42Var = o42Var2;
        } else {
            if (i3 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            o42Var = b0Var2.e;
            bz3.g(obj);
        }
        return Boolean.valueOf(o42Var.a);
    }

    public final Object l(boolean z, nu2 nu2Var) {
        Object objA = rq1.a(g0.a(this.a), new d0(z, (x50) null, 0), nu2Var);
        return objA == t70.a ? objA : q43.a;
    }
}
