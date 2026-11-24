package defpackage;

import com.ibm.icu.impl.CalendarAstronomer;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Serializable n;
    public final /* synthetic */ Object s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Object obj, Object obj2, Serializable serializable, Object obj3, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = obj;
        this.k = obj2;
        this.n = serializable;
        this.s = obj3;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ((p) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            default:
                return ((p) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.s;
        Serializable serializable = this.n;
        Object obj3 = this.k;
        Object obj4 = this.j;
        switch (i) {
            case 0:
                p pVar = new p((Long) obj4, (f0) obj3, (String) serializable, (String) obj2, x50Var, 0);
                pVar.i = obj;
                return pVar;
            default:
                p pVar2 = new p((zm) obj4, (co1) obj3, (h7) serializable, (ek) obj2, x50Var, 1);
                pVar2.i = obj;
                return pVar2;
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        Object obj2 = this.s;
        Serializable serializable = this.n;
        Object obj3 = this.k;
        Object obj4 = this.j;
        switch (i) {
            case 0:
                String str = (String) obj2;
                String str2 = (String) serializable;
                f0 f0Var = (f0) obj3;
                dm1 dm1Var = (dm1) this.i;
                bz3.g(obj);
                Long l = (Long) obj4;
                Long l2 = (Long) dm1Var.c(f0.c);
                if ((l2 != null ? l2.longValue() : 0L) == l.longValue()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Long l3 = (Long) dm1Var.c(f0.a(f0Var, str2));
                    long jLongValue = jCurrentTimeMillis - (l3 != null ? l3.longValue() : 0L);
                    if (0 > jLongValue || jLongValue >= CalendarAstronomer.DAY_MS) {
                        dm1Var.f(f0.b(f0Var, str2), wh2.b(str));
                        dm1Var.f(f0.a(f0Var, str2), new Long(jCurrentTimeMillis));
                    } else {
                        iz1 iz1VarB = f0.b(f0Var, str2);
                        Set set = (Set) dm1Var.c(f0.b(f0Var, str2));
                        if (set == null) {
                            set = mi0.a;
                        }
                        LinkedHashSet linkedHashSet = new LinkedHashSet(bh1.b(set.size() + 1));
                        linkedHashSet.addAll(set);
                        linkedHashSet.add(str);
                        dm1Var.f(iz1VarB, linkedHashSet);
                    }
                }
                return q43.a;
            default:
                bz3.g(obj);
                s70 s70Var = (s70) this.i;
                zm zmVar = (zm) obj4;
                x50 x50Var = null;
                uf4.b(s70Var, null, new r0(zmVar, (co1) obj3, (h7) serializable, x50Var, 2), 3);
                return uf4.b(s70Var, null, new p0(zmVar, (ek) obj2, x50Var, 5), 3);
        }
    }
}
