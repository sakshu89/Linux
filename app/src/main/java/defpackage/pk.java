package defpackage;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pk implements x50, u70, Serializable {
    public final x50 a;

    public pk(x50 x50Var) {
        this.a = x50Var;
    }

    public u70 d() {
        x50 x50Var = this.a;
        if (x50Var instanceof u70) {
            return (u70) x50Var;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // defpackage.x50
    public final void h(Object obj) {
        var r2 = this;
        while (true) {
            pk pkVar = (pk) r2;
            x50 x50Var = pkVar.a;
            x50Var.getClass();
            try {
                obj = pkVar.s(obj);
                if (obj == t70.a) {
                    return;
                }
            } catch (Throwable th) {
                obj = new h72(th);
            }
            pkVar.t();
            if (!(x50Var instanceof pk)) {
                x50Var.h(obj);
                return;
            }
            r2 = x50Var;
        }
    }

    public x50 q(x50 x50Var, Object obj) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public StackTraceElement r() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        aa0 aa0Var = (aa0) getClass().getAnnotation(aa0.class);
        String str = null;
        if (aa0Var == null || aa0Var.v() < 1) {
            return null;
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? aa0Var.l()[iIntValue] : -1;
        yy yyVar = o24.b;
        yy yyVar2 = o24.a;
        if (yyVar == null) {
            try {
                yy yyVar3 = new yy(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                o24.b = yyVar3;
                yyVar = yyVar3;
            } catch (Exception unused2) {
                o24.b = yyVar2;
                yyVar = yyVar2;
            }
        }
        if (yyVar != yyVar2 && (method = yyVar.a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = yyVar.b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = yyVar.c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = aa0Var.c();
        } else {
            strC = str + '/' + aa0Var.c();
        }
        return new StackTraceElement(strC, aa0Var.m(), aa0Var.f(), i);
    }

    public abstract Object s(Object obj);

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object objR = r();
        if (objR == null) {
            objR = getClass().getName();
        }
        sb.append(objR);
        return sb.toString();
    }

    public void t() {
    }
}
