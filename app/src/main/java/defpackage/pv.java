package defpackage;

import com.ibm.icu.impl.locale.LanguageTag;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pv implements q53 {
    public final zl1 a;

    public pv(zl1 zl1Var) {
        Object objF;
        this.a = zl1Var;
        Object objF2 = null;
        try {
            objF = zl1Var.f(yv2.N);
        } catch (IllegalArgumentException unused) {
            objF = null;
        }
        Class cls = (Class) objF;
        if (cls != null && !cls.equals(yr2.class)) {
            dk0.j("Invalid target class configuration for ", this, ": ", cls);
            throw null;
        }
        this.a.v(r53.W, t53.f);
        zl1 zl1Var2 = this.a;
        zl1Var2.v(yv2.N, yr2.class);
        try {
            objF2 = zl1Var2.f(yv2.M);
        } catch (IllegalArgumentException unused2) {
        }
        if (objF2 == null) {
            zl1Var2.v(yv2.M, yr2.class.getCanonicalName() + LanguageTag.SEP + UUID.randomUUID());
        }
    }

    @Override // defpackage.tk0
    public zl1 a() {
        return this.a;
    }

    @Override // defpackage.q53
    public r53 b() {
        return new zr2(gs1.l(this.a));
    }

    public pv() {
        Object objF;
        zl1 zl1VarM = zl1.m();
        this.a = zl1VarM;
        Object objF2 = null;
        try {
            objF = zl1VarM.f(yv2.N);
        } catch (IllegalArgumentException unused) {
            objF = null;
        }
        Class cls = (Class) objF;
        if (cls != null && !cls.equals(ov.class)) {
            dk0.j("Invalid target class configuration for ", this, ": ", cls);
            throw null;
        }
        zl1 zl1Var = this.a;
        zl1Var.v(yv2.N, ov.class);
        try {
            objF2 = zl1Var.f(yv2.M);
        } catch (IllegalArgumentException unused2) {
        }
        if (objF2 == null) {
            zl1Var.v(yv2.M, ov.class.getCanonicalName() + LanguageTag.SEP + UUID.randomUUID());
        }
    }
}
