package defpackage;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g90 extends nu2 implements hq0 {
    public Object f;
    public Serializable i;
    public Object j;
    public Object k;
    public Iterator n;
    public int s;
    public int t;
    public final /* synthetic */ w90 u;
    public final /* synthetic */ p6 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g90(w90 w90Var, p6 p6Var, x50 x50Var) {
        super(1, x50Var);
        this.u = w90Var;
        this.v = p6Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        return new g90(this.u, this.v, (x50) obj).s(q43.a);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:? A[LOOP:0: B:21:0x009f->B:51:?, LOOP_END, SYNTHETIC] */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        an1 an1Var;
        o42 o42Var;
        t42 t42Var;
        t42 t42Var2;
        an1 an1Var2;
        Iterator it;
        an1 an1Var3;
        o42 o42Var2;
        t42 t42Var3;
        f90 f90Var;
        t42 t42Var4;
        o42 o42Var3;
        vq0 vq0Var;
        Object obj2;
        int iHashCode;
        Integer numA;
        Object obj3;
        int i = this.t;
        p6 p6Var = this.v;
        w90 w90Var = this.u;
        t70 t70Var = t70.a;
        if (i == 0) {
            bz3.g(obj);
            an1Var = new an1();
            o42Var = new o42();
            t42Var = new t42();
            this.f = an1Var;
            this.i = o42Var;
            this.j = t42Var;
            this.k = t42Var;
            this.t = 1;
            obj = w90.g(w90Var, true, this);
            if (obj != t70Var) {
                t42Var2 = t42Var;
            }
            return t70Var;
        }
        if (i == 1) {
            t42Var = (t42) this.k;
            t42Var2 = (t42) this.j;
            o42Var = (o42) this.i;
            an1Var = (an1) this.f;
            bz3.g(obj);
        } else {
            if (i == 2) {
                it = this.n;
                f90Var = (f90) this.k;
                t42Var3 = (t42) this.j;
                o42Var2 = (o42) this.i;
                an1Var3 = (an1) this.f;
                bz3.g(obj);
                while (it.hasNext()) {
                    vq0Var = (vq0) it.next();
                    this.f = an1Var3;
                    this.i = o42Var2;
                    this.j = t42Var3;
                    this.k = f90Var;
                    this.n = it;
                    this.t = 2;
                    if (vq0Var.e(f90Var, this) == t70Var) {
                        return t70Var;
                    }
                }
                t42Var2 = t42Var3;
                o42Var = o42Var2;
                an1Var2 = an1Var3;
                p6Var.c = null;
                this.f = o42Var;
                this.i = t42Var2;
                this.j = an1Var2;
                this.k = null;
                this.n = null;
                this.t = 3;
                if (an1Var2.e(this) != t70Var) {
                    t42Var4 = t42Var2;
                    o42Var3 = o42Var;
                    o42Var3.a = true;
                    an1Var2.h(null);
                    obj2 = t42Var4.a;
                    if (obj2 != null) {
                        iHashCode = obj2.hashCode();
                    } else {
                        iHashCode = 0;
                    }
                    uk2 uk2VarH = w90Var.h();
                    this.f = obj2;
                    this.i = null;
                    this.j = null;
                    this.s = iHashCode;
                    this.t = 4;
                    numA = uk2VarH.a();
                    if (numA != t70Var) {
                        obj = numA;
                        obj3 = obj2;
                    }
                }
                return t70Var;
            }
            if (i == 3) {
                an1Var2 = (an1) this.j;
                t42Var4 = (t42) this.i;
                o42Var3 = (o42) this.f;
                bz3.g(obj);
                try {
                    o42Var3.a = true;
                    an1Var2.h(null);
                    obj2 = t42Var4.a;
                    if (obj2 != null) {
                        iHashCode = obj2.hashCode();
                    } else {
                        iHashCode = 0;
                    }
                    uk2 uk2VarH2 = w90Var.h();
                    this.f = obj2;
                    this.i = null;
                    this.j = null;
                    this.s = iHashCode;
                    this.t = 4;
                    numA = uk2VarH2.a();
                    if (numA != t70Var) {
                        obj = numA;
                        obj3 = obj2;
                    }
                    return t70Var;
                } catch (Throwable th) {
                    an1Var2.h(null);
                    throw th;
                }
            }
            if (i != 4) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            iHashCode = this.s;
            obj3 = this.f;
            bz3.g(obj);
        }
        return new y80(obj3, iHashCode, ((Number) obj).intValue());
        t42Var.a = ((y80) obj).b;
        f90 f90Var2 = new f90(an1Var, o42Var, t42Var2, w90Var);
        List list = (List) p6Var.c;
        if (list != null) {
            it = list.iterator();
            an1Var3 = an1Var;
            o42Var2 = o42Var;
            t42Var3 = t42Var2;
            f90Var = f90Var2;
            while (it.hasNext()) {
                vq0Var = (vq0) it.next();
                this.f = an1Var3;
                this.i = o42Var2;
                this.j = t42Var3;
                this.k = f90Var;
                this.n = it;
                this.t = 2;
                if (vq0Var.e(f90Var, this) == t70Var) {
                    return t70Var;
                }
            }
            t42Var2 = t42Var3;
            o42Var = o42Var2;
            an1Var2 = an1Var3;
        } else {
            an1Var2 = an1Var;
        }
        p6Var.c = null;
        this.f = o42Var;
        this.i = t42Var2;
        this.j = an1Var2;
        this.k = null;
        this.n = null;
        this.t = 3;
        if (an1Var2.e(this) != t70Var) {
            t42Var4 = t42Var2;
            o42Var3 = o42Var;
            o42Var3.a = true;
            an1Var2.h(null);
            obj2 = t42Var4.a;
            if (obj2 != null) {
                iHashCode = obj2.hashCode();
            } else {
                iHashCode = 0;
            }
            uk2 uk2VarH3 = w90Var.h();
            this.f = obj2;
            this.i = null;
            this.j = null;
            this.s = iHashCode;
            this.t = 4;
            numA = uk2VarH3.a();
            if (numA != t70Var) {
                obj = numA;
                obj3 = obj2;
                return new y80(obj3, iHashCode, ((Number) obj).intValue());
            }
        }
        return t70Var;
    }
}
