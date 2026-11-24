package defpackage;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gz1 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ vq0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gz1(vq0 vq0Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.k = vq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((gz1) q((x50) obj2, (dm1) obj)).s(q43Var);
            case 1:
                return ((gz1) q((x50) obj2, (dm1) obj)).s(q43Var);
            default:
                return ((gz1) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        vq0 vq0Var = this.k;
        switch (i) {
            case 0:
                gz1 gz1Var = new gz1(vq0Var, x50Var, 0);
                gz1Var.j = obj;
                return gz1Var;
            case 1:
                gz1 gz1Var2 = new gz1(vq0Var, x50Var, 1);
                gz1Var2.j = obj;
                return gz1Var2;
            default:
                gz1 gz1Var3 = new gz1(vq0Var, x50Var, 2);
                gz1Var3.j = obj;
                return gz1Var3;
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        vq0 vq0Var = this.k;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    dm1 dm1Var = (dm1) this.j;
                    this.i = 1;
                    obj = vq0Var.e(dm1Var, this);
                    if (obj == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i2 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                dm1 dm1Var2 = (dm1) obj;
                dm1Var2.getClass();
                ((AtomicBoolean) dm1Var2.b.b).set(true);
                return dm1Var2;
            case 1:
                int i3 = this.i;
                if (i3 == 0) {
                    bz3.g(obj);
                    dm1 dm1Var3 = new dm1(new LinkedHashMap(((dm1) this.j).a()), false);
                    this.j = dm1Var3;
                    this.i = 1;
                    return vq0Var.e(dm1Var3, this) == t70Var ? t70Var : dm1Var3;
                }
                if (i3 != 1) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                dm1 dm1Var4 = (dm1) this.j;
                bz3.g(obj);
                return dm1Var4;
            default:
                int i4 = this.i;
                if (i4 == 0) {
                    bz3.g(obj);
                    s70 s70Var = (s70) this.j;
                    this.i = 1;
                    if (vq0Var.e(s70Var, this) == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i4 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43.a;
        }
    }
}
