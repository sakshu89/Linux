package defpackage;

import android.view.textclassifier.TextClassifier;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ long j;
    public Object k;
    public final /* synthetic */ Object n;
    public final /* synthetic */ Object s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(hx2 hx2Var, long j, lx2 lx2Var, gx2 gx2Var, x50 x50Var) {
        super(2, x50Var);
        this.f = 3;
        this.k = hx2Var;
        this.j = j;
        this.n = lx2Var;
        this.s = gx2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((s0) q((x50) obj2, (s70) obj)).s(q43Var);
            case 1:
                return ((s0) q((x50) obj2, (TextClassifier) obj)).s(q43Var);
            case 2:
                return ((s0) q((x50) obj2, (fe2) obj)).s(q43Var);
            default:
                return ((s0) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.s;
        Object obj3 = this.n;
        switch (i) {
            case 0:
                return new s0((f41) obj3, this.j, (ol1) obj2, x50Var, 0);
            case 1:
                s0 s0Var = new s0(this.j, x50Var, (sx1) obj3, (CharSequence) obj2);
                s0Var.k = obj;
                return s0Var;
            case 2:
                s0 s0Var2 = new s0((he2) obj3, this.j, (q42) obj2, x50Var, 2);
                s0Var2.k = obj;
                return s0Var2;
            default:
                return new s0((hx2) this.k, this.j, (lx2) obj3, (gx2) obj2, x50Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        c02 c02Var;
        int i = this.f;
        long j = this.j;
        int i2 = 3;
        Object obj2 = this.s;
        Object obj3 = this.n;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ol1 ol1Var = (ol1) obj2;
                int i3 = this.i;
                if (i3 != 0) {
                    if (i3 == 1) {
                        bz3.g(obj);
                    } else if (i3 == 2) {
                        c02Var = (c02) this.k;
                        bz3.g(obj);
                        this.k = null;
                        this.i = 3;
                        if (ol1Var.a(c02Var, this) == t70Var) {
                            return t70Var;
                        }
                    } else {
                        if (i3 != 3) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        bz3.g(obj);
                    }
                    return q43Var;
                }
                bz3.g(obj);
                this.i = 1;
                if (((f41) obj3).H(this) == t70Var) {
                    return t70Var;
                }
                b02 b02Var = new b02(j);
                c02 c02Var2 = new c02(b02Var);
                this.k = c02Var2;
                this.i = 2;
                if (ol1Var.a(b02Var, this) == t70Var) {
                    return t70Var;
                }
                c02Var = c02Var2;
                this.k = null;
                this.i = 3;
                if (ol1Var.a(c02Var, this) == t70Var) {
                    return t70Var;
                }
                return q43Var;
            case 1:
                int i4 = this.i;
                if (i4 == 0) {
                    bz3.g(obj);
                    TextClassifier textClassifier = (TextClassifier) this.k;
                    this.i = 1;
                    if (sx1.a((sx1) obj3, (CharSequence) obj2, this.j, textClassifier, this) == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i4 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43Var;
            case 2:
                he2 he2Var = (he2) obj3;
                int i5 = this.i;
                if (i5 == 0) {
                    bz3.g(obj);
                    fe2 fe2Var = (fe2) this.k;
                    float fG = he2Var.g(j);
                    ic icVar = new ic((q42) obj2, he2Var, fe2Var, i2);
                    this.i = 1;
                    vq2 vq2VarD = ie4.d(7, null);
                    Float f = new Float(0.0f);
                    Float f2 = new Float(fG);
                    Float f3 = new Float(0.0f);
                    g33 g33Var = eb4.a;
                    hq0 hq0Var = g33Var.a;
                    vd vdVarC = (vd) hq0Var.j(f3);
                    if (vdVarC == null) {
                        vdVarC = ((vd) hq0Var.j(f)).c();
                    }
                    vd vdVar = vdVarC;
                    Object objA = ya4.a(new qd(g33Var, f, vdVar, 56), new wv2(vq2VarD, g33Var, f, f2, vdVar), Long.MIN_VALUE, new rm2(i2, icVar), this);
                    if (objA != t70Var) {
                        objA = q43Var;
                    }
                    if (objA != t70Var) {
                        objA = q43Var;
                    }
                    if (objA == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i5 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43Var;
            default:
                int i6 = this.i;
                if (i6 != 0) {
                    if (i6 == 1) {
                        bz3.g(obj);
                    } else {
                        if (i6 != 2) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        bz3.g(obj);
                    }
                    return q43Var;
                }
                bz3.g(obj);
                gy2 gy2Var = ((hx2) this.k).X;
                if (gy2Var != null) {
                    this.i = 1;
                    if (new gy2(gy2Var.j, this, 0).s(q43Var) == t70Var) {
                        return t70Var;
                    }
                }
                this.i = 2;
                if (((lx2) obj3).a((gx2) obj2, this) == t70Var) {
                    return t70Var;
                }
                return q43Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(long j, x50 x50Var, sx1 sx1Var, CharSequence charSequence) {
        super(2, x50Var);
        this.f = 1;
        this.n = sx1Var;
        this.s = charSequence;
        this.j = j;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s0(Object obj, long j, Object obj2, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.n = obj;
        this.j = j;
        this.s = obj2;
    }
}
