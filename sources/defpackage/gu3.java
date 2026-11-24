package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gu3 extends jt3 {
    private static final Map zbb = new ConcurrentHashMap();
    protected kv3 zbc;
    private int zbd;

    public gu3() {
        this.zba = 0;
        this.zbd = -1;
        this.zbc = kv3.f;
    }

    public static void d(Class cls, gu3 gu3Var) {
        gu3Var.c();
        zbb.put(cls, gu3Var);
    }

    public static final boolean f(gu3 gu3Var, boolean z) {
        byte bByteValue = ((Byte) gu3Var.i(1, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zD = bv3.c.a(gu3Var.getClass()).d(gu3Var);
        if (z) {
            gu3Var.i(2, true == zD ? gu3Var : null);
        }
        return zD;
    }

    public static gu3 l(Class cls) {
        Map map = zbb;
        gu3 gu3Var = (gu3) map.get(cls);
        if (gu3Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                gu3Var = (gu3) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (gu3Var != null) {
            return gu3Var;
        }
        gu3 gu3Var2 = (gu3) ((gu3) pv3.g(cls)).i(6, null);
        if (gu3Var2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, gu3Var2);
        return gu3Var2;
    }

    public static gu3 m(gu3 gu3Var, byte[] bArr, ut3 ut3Var) throws pu3 {
        int length = bArr.length;
        if (length != 0) {
            gu3 gu3Var2 = (gu3) gu3Var.i(4, null);
            try {
                ev3 ev3VarA = bv3.c.a(gu3Var2.getClass());
                ev3VarA.b(gu3Var2, bArr, 0, length, new nt3(ut3Var));
                ev3VarA.g(gu3Var2);
                gu3Var = gu3Var2;
            } catch (IOException e) {
                if (e.getCause() instanceof pu3) {
                    throw ((pu3) e.getCause());
                }
                throw new pu3(e.getMessage(), e);
            } catch (IndexOutOfBoundsException unused) {
                kf2.j("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return null;
            } catch (jv3 e2) {
                kf2.j(e2.getMessage());
                return null;
            } catch (pu3 e3) {
                throw e3;
            }
        }
        if (gu3Var == null || f(gu3Var, true)) {
            return gu3Var;
        }
        kf2.j(new jv3().getMessage());
        return null;
    }

    public static Object n(Method method, gu3 gu3Var, Object... objArr) {
        try {
            return method.invoke(gu3Var, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    @Override // defpackage.jt3
    public final int a(ev3 ev3Var) {
        if (g()) {
            int iF = ev3Var.f(this);
            if (iF >= 0) {
                return iF;
            }
            og.n(ky0.h(iF, "serialized size must be non-negative, was "));
            return 0;
        }
        int i = this.zbd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iF2 = ev3Var.f(this);
        if (iF2 >= 0) {
            this.zbd = (this.zbd & Integer.MIN_VALUE) | iF2;
            return iF2;
        }
        og.n(ky0.h(iF2, "serialized size must be non-negative, was "));
        return 0;
    }

    public final void c() {
        this.zbd &= Integer.MAX_VALUE;
    }

    public final void e() {
        this.zbd = (this.zbd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return bv3.c.a(getClass()).a(this, (gu3) obj);
    }

    public final boolean g() {
        return (this.zbd & Integer.MIN_VALUE) != 0;
    }

    public final void h(st3 st3Var) {
        ev3 ev3VarA = bv3.c.a(getClass());
        py0 py0Var = st3Var.a;
        if (py0Var == null) {
            py0Var = new py0(st3Var);
        }
        ev3VarA.h(this, py0Var);
    }

    public final int hashCode() {
        if (g()) {
            return bv3.c.a(getClass()).c(this);
        }
        int i = this.zba;
        if (i != 0) {
            return i;
        }
        int iC = bv3.c.a(getClass()).c(this);
        this.zba = iC;
        return iC;
    }

    public abstract Object i(int i, gu3 gu3Var);

    public final int j() {
        if (g()) {
            int iF = bv3.c.a(getClass()).f(this);
            if (iF >= 0) {
                return iF;
            }
            og.n(ky0.h(iF, "serialized size must be non-negative, was "));
            return 0;
        }
        int i = this.zbd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iF2 = bv3.c.a(getClass()).f(this);
        if (iF2 >= 0) {
            this.zbd = (this.zbd & Integer.MIN_VALUE) | iF2;
            return iF2;
        }
        og.n(ky0.h(iF2, "serialized size must be non-negative, was "));
        return 0;
    }

    public final au3 k() {
        return (au3) i(5, null);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = xu3.a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        xu3.c(this, sb, 0);
        return sb.toString();
    }
}
