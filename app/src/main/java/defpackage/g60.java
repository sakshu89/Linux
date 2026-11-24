package defpackage;

import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g60 extends nu2 implements vq0 {
    public final /* synthetic */ boolean H;
    public x00 f;
    public x00 i;
    public qb0 j;
    public qb0 k;
    public Serializable n;
    public int s;
    public /* synthetic */ Object t;
    public final /* synthetic */ String u;
    public final /* synthetic */ h60 v;
    public final /* synthetic */ Locale w;
    public final /* synthetic */ hq0 x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g60(String str, h60 h60Var, Locale locale, hq0 hq0Var, boolean z, x50 x50Var) {
        super(2, x50Var);
        this.u = str;
        this.v = h60Var;
        this.w = locale;
        this.x = hq0Var;
        this.H = z;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((g60) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        g60 g60Var = new g60(this.u, this.v, this.w, this.x, this.H, x50Var);
        g60Var.t = obj;
        return g60Var;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0102 A[Catch: all -> 0x0141, TRY_LEAVE, TryCatch #1 {all -> 0x0141, blocks: (B:34:0x00fc, B:36:0x0102), top: B:82:0x00fc }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0118  */
    /* JADX WARN: Code duplicated, block: B:43:0x0135  */
    /* JADX WARN: Code duplicated, block: B:52:0x0145  */
    /* JADX WARN: Code duplicated, block: B:56:0x015c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0174  */
    /* JADX WARN: Code duplicated, block: B:63:0x0179  */
    /* JADX WARN: Code duplicated, block: B:71:0x0198  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b5  */
    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        x00 x00Var;
        h60 h60Var;
        Throwable th;
        qb0 qb0Var;
        qb0 qb0Var2;
        x00 x00Var2;
        qb0 qb0Var3;
        String str;
        qb0 qb0Var4;
        Throwable th2;
        qb0 qb0Var5;
        String str2;
        qb0 qb0Var6;
        qb0 qb0Var7;
        qb0 qb0Var8;
        s70 s70Var = (s70) this.t;
        int i = this.s;
        int i2 = 2;
        h60 h60Var2 = this.v;
        x50 x50Var = null;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                bz3.g(obj);
                l11 l11Var = new l11(this.u, 26);
                x00 x00VarA = ui4.a();
                x00 x00VarA2 = ui4.a();
                x00Var = x00VarA;
                rb0 rb0VarA = uf4.a(s70Var, new f60(x00VarA2, h60Var2, this.w, x00VarA, this.x, l11Var, null), 3);
                h60Var = h60Var2;
                rb0 rb0VarA2 = uf4.a(s70Var, new u0(h60Var2, this.u, this.w, this.H, (x50) null), 3);
                h60Var.c = rb0VarA;
                try {
                    j70 j70Var = this.b;
                    j70Var.getClass();
                    gf2 gf2Var = new gf2(j70Var);
                    gf2Var.g(rb0VarA2.Q(), new nc(i2, x50Var, 1));
                    gf2Var.g(x00Var.Q(), new nc(i2, x50Var, i2));
                    this.t = null;
                    this.f = x00Var;
                    this.i = x00VarA2;
                    this.j = rb0VarA;
                    this.k = rb0VarA2;
                    this.n = null;
                    this.s = 1;
                    if ((gf2Var.h() ? gf2Var.d(this) : gf2Var.e(this)) != t70Var) {
                        x00Var2 = x00VarA2;
                        qb0Var = rb0VarA2;
                        qb0Var3 = rb0VarA;
                        try {
                            if (x00Var.Z()) {
                                this.t = null;
                                this.f = null;
                                this.i = x00Var2;
                                this.j = qb0Var3;
                                this.k = qb0Var;
                                this.n = null;
                                this.s = 2;
                                if (hp4.a(qb0Var, this) != t70Var) {
                                    qb0Var4 = qb0Var3;
                                    try {
                                        d60 d60Var = new d60(x00Var2, x50Var, 0);
                                        this.t = null;
                                        this.f = null;
                                        this.i = null;
                                        this.j = qb0Var4;
                                        this.k = qb0Var;
                                        this.s = 3;
                                        obj = xc4.c(5000L, d60Var, this);
                                        if (obj != t70Var) {
                                            qb0Var2 = qb0Var4;
                                            try {
                                                str = (String) obj;
                                                qb0Var3 = qb0Var2;
                                                this.t = null;
                                                this.f = null;
                                                this.i = null;
                                                this.j = qb0Var3;
                                                this.k = null;
                                                this.n = str;
                                                this.s = 4;
                                                if (hp4.a(qb0Var, this) != t70Var) {
                                                    str2 = str;
                                                    qb0Var6 = qb0Var3;
                                                    this.t = null;
                                                    this.f = null;
                                                    this.i = null;
                                                    this.j = qb0Var6;
                                                    this.k = null;
                                                    this.n = str2;
                                                    this.s = 5;
                                                    if (hp4.a(qb0Var6, this) != t70Var) {
                                                        qb0Var7 = qb0Var6;
                                                        if (h60Var.c == qb0Var7) {
                                                            h60Var.c = null;
                                                        }
                                                        return str2;
                                                    }
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                this.t = null;
                                                this.f = null;
                                                this.i = null;
                                                this.j = qb0Var2;
                                                this.k = null;
                                                this.n = th;
                                                this.s = 6;
                                                if (hp4.a(qb0Var, this) != t70Var) {
                                                    th2 = th;
                                                    qb0Var5 = qb0Var2;
                                                    this.t = null;
                                                    this.f = null;
                                                    this.i = null;
                                                    this.j = qb0Var5;
                                                    this.k = null;
                                                    this.n = th2;
                                                    this.s = 7;
                                                    if (hp4.a(qb0Var5, this) != t70Var) {
                                                        qb0Var8 = qb0Var5;
                                                        if (h60Var.c == qb0Var8) {
                                                            h60Var.c = null;
                                                        }
                                                        throw th2;
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        qb0Var2 = qb0Var4;
                                        this.t = null;
                                        this.f = null;
                                        this.i = null;
                                        this.j = qb0Var2;
                                        this.k = null;
                                        this.n = th;
                                        this.s = 6;
                                        if (hp4.a(qb0Var, this) != t70Var) {
                                            th2 = th;
                                            qb0Var5 = qb0Var2;
                                            this.t = null;
                                            this.f = null;
                                            this.i = null;
                                            this.j = qb0Var5;
                                            this.k = null;
                                            this.n = th2;
                                            this.s = 7;
                                            if (hp4.a(qb0Var5, this) != t70Var) {
                                                qb0Var8 = qb0Var5;
                                                if (h60Var.c == qb0Var8) {
                                                    h60Var.c = null;
                                                }
                                                throw th2;
                                            }
                                        }
                                        return t70Var;
                                    }
                                }
                            } else {
                                str = null;
                                this.t = null;
                                this.f = null;
                                this.i = null;
                                this.j = qb0Var3;
                                this.k = null;
                                this.n = str;
                                this.s = 4;
                                if (hp4.a(qb0Var, this) != t70Var) {
                                    str2 = str;
                                    qb0Var6 = qb0Var3;
                                    this.t = null;
                                    this.f = null;
                                    this.i = null;
                                    this.j = qb0Var6;
                                    this.k = null;
                                    this.n = str2;
                                    this.s = 5;
                                    if (hp4.a(qb0Var6, this) != t70Var) {
                                        qb0Var7 = qb0Var6;
                                        if (h60Var.c == qb0Var7) {
                                            h60Var.c = null;
                                        }
                                        return str2;
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            qb0Var2 = qb0Var3;
                            this.t = null;
                            this.f = null;
                            this.i = null;
                            this.j = qb0Var2;
                            this.k = null;
                            this.n = th;
                            this.s = 6;
                            if (hp4.a(qb0Var, this) != t70Var) {
                                th2 = th;
                                qb0Var5 = qb0Var2;
                                this.t = null;
                                this.f = null;
                                this.i = null;
                                this.j = qb0Var5;
                                this.k = null;
                                this.n = th2;
                                this.s = 7;
                                if (hp4.a(qb0Var5, this) != t70Var) {
                                    qb0Var8 = qb0Var5;
                                    if (h60Var.c == qb0Var8) {
                                        h60Var.c = null;
                                    }
                                    throw th2;
                                }
                            }
                            return t70Var;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    qb0Var = rb0VarA2;
                    qb0Var2 = rb0VarA;
                    this.t = null;
                    this.f = null;
                    this.i = null;
                    this.j = qb0Var2;
                    this.k = null;
                    this.n = th;
                    this.s = 6;
                    if (hp4.a(qb0Var, this) != t70Var) {
                        th2 = th;
                        qb0Var5 = qb0Var2;
                        this.t = null;
                        this.f = null;
                        this.i = null;
                        this.j = qb0Var5;
                        this.k = null;
                        this.n = th2;
                        this.s = 7;
                        if (hp4.a(qb0Var5, this) != t70Var) {
                            qb0Var8 = qb0Var5;
                            if (h60Var.c == qb0Var8) {
                                h60Var.c = null;
                            }
                            throw th2;
                        }
                    }
                    return t70Var;
                }
                return t70Var;
            case 1:
                qb0Var = this.k;
                qb0Var3 = this.j;
                x00Var2 = this.i;
                x00 x00Var3 = this.f;
                try {
                    bz3.g(obj);
                    x00Var = x00Var3;
                    h60Var = h60Var2;
                    if (x00Var.Z()) {
                        this.t = null;
                        this.f = null;
                        this.i = x00Var2;
                        this.j = qb0Var3;
                        this.k = qb0Var;
                        this.n = null;
                        this.s = 2;
                        if (hp4.a(qb0Var, this) != t70Var) {
                            qb0Var4 = qb0Var3;
                            d60 d60Var2 = new d60(x00Var2, x50Var, 0);
                            this.t = null;
                            this.f = null;
                            this.i = null;
                            this.j = qb0Var4;
                            this.k = qb0Var;
                            this.s = 3;
                            obj = xc4.c(5000L, d60Var2, this);
                            if (obj != t70Var) {
                                qb0Var2 = qb0Var4;
                                str = (String) obj;
                                qb0Var3 = qb0Var2;
                                this.t = null;
                                this.f = null;
                                this.i = null;
                                this.j = qb0Var3;
                                this.k = null;
                                this.n = str;
                                this.s = 4;
                                if (hp4.a(qb0Var, this) != t70Var) {
                                    str2 = str;
                                    qb0Var6 = qb0Var3;
                                    this.t = null;
                                    this.f = null;
                                    this.i = null;
                                    this.j = qb0Var6;
                                    this.k = null;
                                    this.n = str2;
                                    this.s = 5;
                                    if (hp4.a(qb0Var6, this) != t70Var) {
                                        qb0Var7 = qb0Var6;
                                        if (h60Var.c == qb0Var7) {
                                            h60Var.c = null;
                                        }
                                        return str2;
                                    }
                                }
                            }
                        }
                    } else {
                        str = null;
                        this.t = null;
                        this.f = null;
                        this.i = null;
                        this.j = qb0Var3;
                        this.k = null;
                        this.n = str;
                        this.s = 4;
                        if (hp4.a(qb0Var, this) != t70Var) {
                            str2 = str;
                            qb0Var6 = qb0Var3;
                            this.t = null;
                            this.f = null;
                            this.i = null;
                            this.j = qb0Var6;
                            this.k = null;
                            this.n = str2;
                            this.s = 5;
                            if (hp4.a(qb0Var6, this) != t70Var) {
                                qb0Var7 = qb0Var6;
                                if (h60Var.c == qb0Var7) {
                                    h60Var.c = null;
                                }
                                return str2;
                            }
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    qb0Var2 = qb0Var3;
                    h60Var = h60Var2;
                    this.t = null;
                    this.f = null;
                    this.i = null;
                    this.j = qb0Var2;
                    this.k = null;
                    this.n = th;
                    this.s = 6;
                    if (hp4.a(qb0Var, this) != t70Var) {
                        th2 = th;
                        qb0Var5 = qb0Var2;
                        this.t = null;
                        this.f = null;
                        this.i = null;
                        this.j = qb0Var5;
                        this.k = null;
                        this.n = th2;
                        this.s = 7;
                        if (hp4.a(qb0Var5, this) != t70Var) {
                            qb0Var8 = qb0Var5;
                            if (h60Var.c == qb0Var8) {
                                h60Var.c = null;
                            }
                            throw th2;
                        }
                    }
                    return t70Var;
                }
                return t70Var;
            case 2:
                qb0Var = this.k;
                qb0Var4 = this.j;
                x00Var2 = this.i;
                try {
                    bz3.g(obj);
                    h60Var = h60Var2;
                    d60 d60Var3 = new d60(x00Var2, x50Var, 0);
                    this.t = null;
                    this.f = null;
                    this.i = null;
                    this.j = qb0Var4;
                    this.k = qb0Var;
                    this.s = 3;
                    obj = xc4.c(5000L, d60Var3, this);
                    if (obj != t70Var) {
                        qb0Var2 = qb0Var4;
                        str = (String) obj;
                        qb0Var3 = qb0Var2;
                        this.t = null;
                        this.f = null;
                        this.i = null;
                        this.j = qb0Var3;
                        this.k = null;
                        this.n = str;
                        this.s = 4;
                        if (hp4.a(qb0Var, this) != t70Var) {
                            str2 = str;
                            qb0Var6 = qb0Var3;
                            this.t = null;
                            this.f = null;
                            this.i = null;
                            this.j = qb0Var6;
                            this.k = null;
                            this.n = str2;
                            this.s = 5;
                            if (hp4.a(qb0Var6, this) != t70Var) {
                                qb0Var7 = qb0Var6;
                                if (h60Var.c == qb0Var7) {
                                    h60Var.c = null;
                                }
                                return str2;
                            }
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    qb0Var2 = qb0Var4;
                    h60Var = h60Var2;
                    this.t = null;
                    this.f = null;
                    this.i = null;
                    this.j = qb0Var2;
                    this.k = null;
                    this.n = th;
                    this.s = 6;
                    if (hp4.a(qb0Var, this) != t70Var) {
                        th2 = th;
                        qb0Var5 = qb0Var2;
                        this.t = null;
                        this.f = null;
                        this.i = null;
                        this.j = qb0Var5;
                        this.k = null;
                        this.n = th2;
                        this.s = 7;
                        if (hp4.a(qb0Var5, this) != t70Var) {
                            qb0Var8 = qb0Var5;
                            if (h60Var.c == qb0Var8) {
                                h60Var.c = null;
                            }
                            throw th2;
                        }
                    }
                    return t70Var;
                }
                return t70Var;
            case 3:
                qb0Var = this.k;
                qb0Var2 = this.j;
                try {
                    bz3.g(obj);
                    h60Var = h60Var2;
                    str = (String) obj;
                    qb0Var3 = qb0Var2;
                    this.t = null;
                    this.f = null;
                    this.i = null;
                    this.j = qb0Var3;
                    this.k = null;
                    this.n = str;
                    this.s = 4;
                    if (hp4.a(qb0Var, this) != t70Var) {
                        str2 = str;
                        qb0Var6 = qb0Var3;
                        this.t = null;
                        this.f = null;
                        this.i = null;
                        this.j = qb0Var6;
                        this.k = null;
                        this.n = str2;
                        this.s = 5;
                        if (hp4.a(qb0Var6, this) != t70Var) {
                            qb0Var7 = qb0Var6;
                            if (h60Var.c == qb0Var7) {
                                h60Var.c = null;
                            }
                            return str2;
                        }
                    }
                } catch (Throwable th9) {
                    th = th9;
                    h60Var = h60Var2;
                    this.t = null;
                    this.f = null;
                    this.i = null;
                    this.j = qb0Var2;
                    this.k = null;
                    this.n = th;
                    this.s = 6;
                    if (hp4.a(qb0Var, this) != t70Var) {
                        th2 = th;
                        qb0Var5 = qb0Var2;
                        this.t = null;
                        this.f = null;
                        this.i = null;
                        this.j = qb0Var5;
                        this.k = null;
                        this.n = th2;
                        this.s = 7;
                        if (hp4.a(qb0Var5, this) != t70Var) {
                            qb0Var8 = qb0Var5;
                            if (h60Var.c == qb0Var8) {
                                h60Var.c = null;
                            }
                            throw th2;
                        }
                    }
                    return t70Var;
                }
                return t70Var;
            case 4:
                str2 = (String) this.n;
                qb0Var6 = this.j;
                bz3.g(obj);
                h60Var = h60Var2;
                this.t = null;
                this.f = null;
                this.i = null;
                this.j = qb0Var6;
                this.k = null;
                this.n = str2;
                this.s = 5;
                if (hp4.a(qb0Var6, this) != t70Var) {
                    qb0Var7 = qb0Var6;
                    if (h60Var.c == qb0Var7) {
                        h60Var.c = null;
                    }
                    return str2;
                }
                return t70Var;
            case 5:
                str2 = (String) this.n;
                qb0Var7 = this.j;
                bz3.g(obj);
                h60Var = h60Var2;
                if (h60Var.c == qb0Var7) {
                    h60Var.c = null;
                }
                return str2;
            case 6:
                th2 = (Throwable) this.n;
                qb0Var5 = this.j;
                bz3.g(obj);
                h60Var = h60Var2;
                this.t = null;
                this.f = null;
                this.i = null;
                this.j = qb0Var5;
                this.k = null;
                this.n = th2;
                this.s = 7;
                if (hp4.a(qb0Var5, this) != t70Var) {
                    qb0Var8 = qb0Var5;
                    if (h60Var.c == qb0Var8) {
                        h60Var.c = null;
                    }
                    throw th2;
                }
                return t70Var;
            case 7:
                th2 = (Throwable) this.n;
                qb0Var8 = this.j;
                bz3.g(obj);
                h60Var = h60Var2;
                if (h60Var.c == qb0Var8) {
                    h60Var.c = null;
                }
                throw th2;
            default:
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
