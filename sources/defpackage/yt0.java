package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yt0 extends j1 {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, yt0> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected r43 unknownFields;

    public yt0() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r43.f;
    }

    public static yt0 d(Class cls) {
        yt0 yt0Var = defaultInstanceMap.get(cls);
        if (yt0Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                yt0Var = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (yt0Var != null) {
            return yt0Var;
        }
        yt0 yt0Var2 = (yt0) ((yt0) c53.d(cls)).c(6);
        if (yt0Var2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, yt0Var2);
        return yt0Var2;
    }

    public static Object e(Method method, yt0 yt0Var, Object... objArr) {
        try {
            return method.invoke(yt0Var, objArr);
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

    public static final boolean f(yt0 yt0Var, boolean z) {
        byte bByteValue = ((Byte) yt0Var.c(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        w12 w12Var = w12.c;
        w12Var.getClass();
        boolean zF = w12Var.a(yt0Var.getClass()).f(yt0Var);
        if (z) {
            yt0Var.c(2);
        }
        return zF;
    }

    public static void j(Class cls, yt0 yt0Var) {
        yt0Var.h();
        defaultInstanceMap.put(cls, yt0Var);
    }

    @Override // defpackage.j1
    public final int a(db2 db2Var) {
        int iD;
        int iD2;
        if (g()) {
            if (db2Var == null) {
                w12 w12Var = w12.c;
                w12Var.getClass();
                iD2 = w12Var.a(getClass()).d(this);
            } else {
                iD2 = db2Var.d(this);
            }
            if (iD2 >= 0) {
                return iD2;
            }
            og.n(ky0.h(iD2, "serialized size must be non-negative, was "));
            return 0;
        }
        int i = this.memoizedSerializedSize;
        if ((i & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i & Integer.MAX_VALUE;
        }
        if (db2Var == null) {
            w12 w12Var2 = w12.c;
            w12Var2.getClass();
            iD = w12Var2.a(getClass()).d(this);
        } else {
            iD = db2Var.d(this);
        }
        k(iD);
        return iD;
    }

    @Override // defpackage.j1
    public final void b(kz kzVar) {
        w12 w12Var = w12.c;
        w12Var.getClass();
        db2 db2VarA = w12Var.a(getClass());
        uf1 uf1Var = kzVar.a;
        if (uf1Var == null) {
            uf1Var = new uf1(kzVar);
        }
        db2VarA.e(this, uf1Var);
    }

    public abstract Object c(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        w12 w12Var = w12.c;
        w12Var.getClass();
        return w12Var.a(getClass()).g(this, (yt0) obj);
    }

    public final boolean g() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void h() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final int hashCode() {
        if (g()) {
            w12 w12Var = w12.c;
            w12Var.getClass();
            return w12Var.a(getClass()).a(this);
        }
        if (this.memoizedHashCode == 0) {
            w12 w12Var2 = w12.c;
            w12Var2.getClass();
            this.memoizedHashCode = w12Var2.a(getClass()).a(this);
        }
        return this.memoizedHashCode;
    }

    public final yt0 i() {
        return (yt0) c(4);
    }

    public final void k(int i) {
        if (i < 0) {
            og.n(ky0.h(i, "serialized size must be non-negative, was "));
        } else {
            this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        }
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = qi1.a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        qi1.c(this, sb, 0);
        return sb.toString();
    }
}
