package defpackage;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pv3 {
    public static final Unsafe a;
    public static final Class b;
    public static final ov3 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    /* JADX WARN: Code duplicated, block: B:11:0x0043  */
    static {
        boolean z;
        boolean z2;
        ov3 ov3Var;
        Unsafe unsafeI = i();
        a = unsafeI;
        int i = lt3.a;
        b = Memory.class;
        Class cls = Long.TYPE;
        boolean zO = o(cls);
        Class cls2 = Integer.TYPE;
        boolean zO2 = o(cls2);
        ov3 mv3Var = null;
        if (unsafeI != null) {
            if (zO) {
                mv3Var = new nv3(unsafeI);
            } else if (zO2) {
                mv3Var = new mv3(unsafeI);
            }
        }
        c = mv3Var;
        if (mv3Var == null) {
            z = false;
        } else {
            try {
                Class<?> cls3 = ((Unsafe) mv3Var.a).getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (b() == null) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                Logger.getLogger(pv3.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
            }
        }
        d = z;
        ov3 ov3Var2 = c;
        if (ov3Var2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls4 = ((Unsafe) ov3Var2.a).getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                cls4.getMethod("getInt", Object.class, cls);
                cls4.getMethod("putInt", Object.class, cls, cls2);
                cls4.getMethod("getLong", Object.class, cls);
                cls4.getMethod("putLong", Object.class, cls, cls);
                cls4.getMethod("getObject", Object.class, cls);
                cls4.getMethod("putObject", Object.class, cls, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                Logger.getLogger(pv3.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th2.toString()));
                z2 = false;
            }
        }
        e = z2;
        f = p(byte[].class);
        p(boolean[].class);
        a(boolean[].class);
        p(int[].class);
        a(int[].class);
        p(long[].class);
        a(long[].class);
        p(float[].class);
        a(float[].class);
        p(double[].class);
        a(double[].class);
        p(Object[].class);
        a(Object[].class);
        Field fieldB = b();
        if (fieldB != null && (ov3Var = c) != null) {
            ((Unsafe) ov3Var.a).objectFieldOffset(fieldB);
        }
        g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Class cls) {
        if (e) {
            ((Unsafe) c.a).arrayIndexScale(cls);
        }
    }

    public static Field b() {
        Field declaredField;
        Field declaredField2;
        int i = lt3.a;
        try {
            declaredField = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused) {
            declaredField = null;
        }
        if (declaredField != null) {
            return declaredField;
        }
        try {
            declaredField2 = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField2 = null;
        }
        if (declaredField2 == null || declaredField2.getType() != Long.TYPE) {
            return null;
        }
        return declaredField2;
    }

    public static void c(Object obj, long j, byte b2) {
        ov3 ov3Var = c;
        long j2 = (-4) & j;
        int i = ((Unsafe) ov3Var.a).getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        ((Unsafe) ov3Var.a).putInt(obj, j2, ((255 & b2) << i2) | (i & (~(255 << i2))));
    }

    public static void d(Object obj, long j, byte b2) {
        ov3 ov3Var = c;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        ((Unsafe) ov3Var.a).putInt(obj, j2, ((255 & b2) << i) | (((Unsafe) ov3Var.a).getInt(obj, j2) & (~(255 << i))));
    }

    public static int e(long j, Object obj) {
        return ((Unsafe) c.a).getInt(obj, j);
    }

    public static long f(long j, Object obj) {
        return ((Unsafe) c.a).getLong(obj, j);
    }

    public static Object g(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object h(long j, Object obj) {
        return ((Unsafe) c.a).getObject(obj, j);
    }

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new lv3());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(int i, long j, Object obj) {
        ((Unsafe) c.a).putInt(obj, j, i);
    }

    public static void k(Object obj, long j, long j2) {
        ((Unsafe) c.a).putLong(obj, j, j2);
    }

    public static void l(Object obj, long j, Object obj2) {
        ((Unsafe) c.a).putObject(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean m(long j, Object obj) {
        return ((byte) ((((Unsafe) c.a).getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean n(long j, Object obj) {
        return ((byte) ((((Unsafe) c.a).getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    public static boolean o(Class cls) {
        int i = lt3.a;
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int p(Class cls) {
        if (e) {
            return ((Unsafe) c.a).arrayBaseOffset(cls);
        }
        return -1;
    }
}
