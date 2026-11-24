package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tn4 {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(p03 p03Var, j90 j90Var, Throwable th, y50 y50Var) throws IllegalAccessException, InvocationTargetException {
        rm0 rm0Var;
        if (y50Var instanceof rm0) {
            rm0Var = (rm0) y50Var;
            int i = rm0Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                rm0Var.i = i - Integer.MIN_VALUE;
            } else {
                rm0Var = new rm0(y50Var);
            }
        } else {
            rm0Var = new rm0(y50Var);
        }
        Object obj = rm0Var.f;
        int i2 = rm0Var.i;
        try {
            if (i2 == 0) {
                bz3.g(obj);
                rm0Var.e = th;
                rm0Var.i = 1;
                Object objC = j90Var.c(p03Var, th, rm0Var);
                Object obj2 = t70.a;
                if (objC == obj2) {
                    return obj2;
                }
            } else {
                if (i2 != 1) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                th = rm0Var.e;
                bz3.g(obj);
            }
            return q43.a;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                gn4.a(th2, th);
            }
            throw th2;
        }
    }
}
