package defpackage;

import com.ibm.icu.impl.CalendarAstronomer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r implements nm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ nm0 b;
    public final /* synthetic */ f0 c;
    public final /* synthetic */ String e;

    public /* synthetic */ r(nm0 nm0Var, f0 f0Var, String str, int i) {
        this.a = i;
        this.b = nm0Var;
        this.c = f0Var;
        this.e = str;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:9:0x002c  */
    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) {
        q qVar;
        Set set;
        t tVar;
        u uVar;
        int i = this.a;
        q43 q43Var = q43.a;
        String str = this.e;
        f0 f0Var = this.c;
        nm0 nm0Var = this.b;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                if (x50Var instanceof q) {
                    qVar = (q) x50Var;
                    int i2 = qVar.f;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        qVar.f = i2 - Integer.MIN_VALUE;
                    } else {
                        qVar = new q(this, x50Var);
                    }
                } else {
                    qVar = new q(this, x50Var);
                }
                Object obj2 = qVar.e;
                int i3 = qVar.f;
                if (i3 != 0) {
                    if (i3 == 1) {
                        bz3.g(obj2);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj2);
                dm1 dm1Var = (dm1) obj;
                long jCurrentTimeMillis = System.currentTimeMillis();
                Long l = (Long) dm1Var.c(f0.a(f0Var, str));
                long jLongValue = jCurrentTimeMillis - (l != null ? l.longValue() : 0L);
                Set set2 = mi0.a;
                if (0 <= jLongValue && jLongValue < CalendarAstronomer.DAY_MS && (set = (Set) dm1Var.c(f0.b(f0Var, str))) != null) {
                    set2 = set;
                }
                qVar.f = 1;
                return nm0Var.n(set2, qVar) == t70Var ? t70Var : q43Var;
            case 1:
                if (x50Var instanceof t) {
                    tVar = (t) x50Var;
                    int i4 = tVar.f;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        tVar.f = i4 - Integer.MIN_VALUE;
                    } else {
                        tVar = new t(this, x50Var);
                    }
                } else {
                    tVar = new t(this, x50Var);
                }
                Object obj3 = tVar.e;
                int i5 = tVar.f;
                if (i5 != 0) {
                    if (i5 == 1) {
                        bz3.g(obj3);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj3);
                Long l2 = (Long) ((dm1) obj).c(f0.c(f0Var, str));
                Long l3 = new Long(l2 != null ? l2.longValue() : 0L);
                tVar.f = 1;
                return nm0Var.n(l3, tVar) == t70Var ? t70Var : q43Var;
            default:
                if (x50Var instanceof u) {
                    uVar = (u) x50Var;
                    int i6 = uVar.f;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        uVar.f = i6 - Integer.MIN_VALUE;
                    } else {
                        uVar = new u(this, x50Var);
                    }
                } else {
                    uVar = new u(this, x50Var);
                }
                Object obj4 = uVar.e;
                int i7 = uVar.f;
                if (i7 == 0) {
                    bz3.g(obj4);
                    Object objC = ((dm1) obj).c(f0.d(f0Var, str));
                    uVar.f = 1;
                    return nm0Var.n(objC, uVar) == t70Var ? t70Var : q43Var;
                }
                if (i7 == 1) {
                    bz3.g(obj4);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
