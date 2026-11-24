package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j90 extends nu2 implements wq0 {
    public final /* synthetic */ int f = 1;
    public int i;
    public /* synthetic */ Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j90(w90 w90Var, x50 x50Var) {
        super(3, x50Var);
        this.j = w90Var;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return new j90((w90) this.j, (x50) obj3).s(q43Var);
            default:
                ((Boolean) obj2).getClass();
                j90 j90Var = new j90(3, (x50) obj3);
                j90Var.j = (jl0) obj;
                return j90Var.s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        int i = this.f;
        t70 t70Var = t70.a;
        switch (i) {
            case 0:
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    w90 w90Var = (w90) this.j;
                    this.i = 1;
                    if (w90.a(w90Var, this) == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i2 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43.a;
            default:
                int i3 = this.i;
                if (i3 != 0) {
                    if (i3 == 1) {
                        bz3.g(obj);
                        return obj;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                jl0 jl0Var = (jl0) this.j;
                this.i = 1;
                jl0Var.getClass();
                Object objA = jl0.a(jl0Var, this);
                return objA == t70Var ? t70Var : objA;
        }
    }

    public /* synthetic */ j90(int i, x50 x50Var) {
        super(i, x50Var);
    }
}
