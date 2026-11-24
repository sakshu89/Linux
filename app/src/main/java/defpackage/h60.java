package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h60 {
    public final pn2 a;
    public final co2 b;
    public rb0 c;

    public h60(pn2 pn2Var, co2 co2Var) {
        pn2Var.getClass();
        co2Var.getClass();
        this.a = pn2Var;
        this.b = co2Var;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public final Object a(String str, Locale locale, boolean z, boolean z2, hq0 hq0Var, y50 y50Var) {
        c60 c60Var;
        if (y50Var instanceof c60) {
            c60Var = (c60) y50Var;
            int i = c60Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                c60Var.i = i - Integer.MIN_VALUE;
            } else {
                c60Var = new c60(this, y50Var);
            }
        } else {
            c60Var = new c60(this, y50Var);
        }
        c60 c60Var2 = c60Var;
        Object obj = c60Var2.e;
        int i2 = c60Var2.i;
        if (i2 != 0) {
            if (i2 == 1) {
                bz3.g(obj);
                return null;
            }
            if (i2 == 2) {
                bz3.g(obj);
                return obj;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        co2 co2Var = this.b;
        t70 t70Var = t70.a;
        if (z2 && !((Boolean) co2Var.f.getValue()).booleanValue() && this.a.b()) {
            g60 g60Var = new g60(str, this, locale, hq0Var, z, null);
            c60Var2.i = 2;
            Object objC = tl4.c(g60Var, c60Var2);
            if (objC != t70Var) {
                return objC;
            }
        } else {
            c60Var2.i = 1;
            if (co2Var.b(str, locale, z, c60Var2) != t70Var) {
                return null;
            }
        }
        return t70Var;
    }

    public final void b() throws IllegalAccessException, InvocationTargetException {
        rb0 rb0Var = this.c;
        if (rb0Var != null) {
            rb0Var.e(null);
        }
    }
}
