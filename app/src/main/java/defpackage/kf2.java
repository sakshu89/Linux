package defpackage;

import com.ibm.icu.util.ICUUncheckedIOException;
import java.io.FileNotFoundException;
import java.io.InvalidObjectException;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kf2 implements lf2, q83 {
    public final /* synthetic */ int a;

    public /* synthetic */ kf2(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(int i, Object obj) {
        throw new IllegalArgumentException("Illegal pattern character '" + ((char) i) + ((Object) "' in \"") + obj + ((Object) "\""));
    }

    public static /* synthetic */ void d(int i, String str, Object obj, Object obj2) {
        throw new IllegalArgumentException(str + i + ((Object) " (0x") + obj + obj2);
    }

    public static /* synthetic */ void e(Object obj) {
        throw new IllegalStateException(obj.toString());
    }

    public static /* synthetic */ void f(Object obj, String str) throws FileNotFoundException {
        throw new FileNotFoundException(str + obj);
    }

    public static /* synthetic */ void g(String str) {
        throw new NoSuchElementException(str);
    }

    public static /* synthetic */ void h(Throwable th) {
        throw new ICUUncheckedIOException(th);
    }

    public static /* synthetic */ void i(String str) throws InvalidObjectException {
        throw new InvalidObjectException(str);
    }

    public static /* synthetic */ void j(String str) throws pu3 {
        throw new pu3(str);
    }

    @Override // defpackage.q83
    public a23 a(be beVar) {
        return new a23(beVar, lp1.a);
    }

    @Override // defpackage.lf2
    public jf2 b(s9 s9Var) {
        if2 if2VarB;
        if2 if2Var;
        if2 if2Var2;
        jf2 jf2Var = (jf2) s9Var.c;
        iz izVar = (iz) s9Var.e;
        if (jf2Var == null) {
            return o24.a(s9Var, qs4.j);
        }
        if2 if2Var3 = jf2Var.b;
        if2 if2Var4 = jf2Var.a;
        if (s9Var.b) {
            if2VarB = o24.b(s9Var, izVar, if2Var4);
            if2Var2 = if2Var3;
            if2Var3 = if2Var4;
            if2Var = if2VarB;
        } else {
            if2VarB = o24.b(s9Var, izVar, if2Var3);
            if2Var = if2Var4;
            if2Var2 = if2VarB;
        }
        if (g31.a(if2VarB, if2Var3)) {
            return jf2Var;
        }
        jf2 jf2Var2 = new jf2(if2Var, if2Var2, s9Var.g() == e80.a || (s9Var.g() == e80.c && if2Var.b > if2Var2.b));
        iz izVar2 = (iz) s9Var.e;
        if2 if2Var5 = jf2Var2.a;
        long j = if2Var5.c;
        if2 if2Var6 = jf2Var2.b;
        if (j != if2Var6.c) {
            boolean z = jf2Var2.c;
            if ((z ? if2Var5 : if2Var6).b != 0) {
                return jf2Var2;
            }
            if (((gz2) izVar2.e).a.a.b.length() != (z ? if2Var6 : if2Var5).b) {
                return jf2Var2;
            }
        } else if (if2Var5.b != if2Var6.b) {
            return jf2Var2;
        }
        jf2 jf2Var3 = (jf2) s9Var.c;
        String str = ((gz2) izVar2.e).a.a.b;
        if (jf2Var3 == null || str.length() == 0) {
            return jf2Var2;
        }
        boolean z2 = s9Var.b;
        String str2 = ((gz2) izVar2.e).a.a.b;
        int i = izVar2.b;
        int length = str2.length();
        if (i == 0) {
            int iA = ra4.a(0, str2);
            return z2 ? jf2.a(jf2Var2, o24.d(if2Var5, izVar2, iA), null, true, 2) : jf2.a(jf2Var2, null, o24.d(if2Var6, izVar2, iA), false, 1);
        }
        if (i == length) {
            int iB = ra4.b(length, str2);
            return z2 ? jf2.a(jf2Var2, o24.d(if2Var5, izVar2, iB), null, false, 2) : jf2.a(jf2Var2, null, o24.d(if2Var6, izVar2, iB), true, 1);
        }
        boolean z3 = jf2Var3.c;
        int iB2 = z2 ^ z3 ? ra4.b(i, str2) : ra4.a(i, str2);
        return z2 ? jf2.a(jf2Var2, o24.d(if2Var5, izVar2, iB2), null, z3, 2) : jf2.a(jf2Var2, null, o24.d(if2Var6, izVar2, iB2), z3, 1);
    }
}
