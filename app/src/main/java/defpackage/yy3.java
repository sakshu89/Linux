package defpackage;

import android.os.Looper;
import android.util.Log;
import com.ibm.icu.impl.coll.CollationFastLatin;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yy3 {
    public static ClassLoader a;
    public static Thread b;
    public static final kc0 c = new kc0(1.0f, 1.0f);

    public static final String a(Object obj) {
        return obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
    }

    public static final Object b(Object[] objArr, fq0 fq0Var, x20 x20Var) {
        return c(Arrays.copyOf(objArr, objArr.length), e44.a, fq0Var, x20Var, 3456);
    }

    public static final Object c(Object[] objArr, qa2 qa2Var, fq0 fq0Var, x20 x20Var, int i) {
        Object[] objArr2;
        qa2 qa2Var2;
        Object obj;
        Object objE;
        long j = x20Var.T;
        ph4.a(36);
        String string = Long.toString(j, 36);
        string.getClass();
        qa2Var.getClass();
        ba2 ba2Var = (ba2) x20Var.j(da2.a);
        Object objL = x20Var.L();
        Object obj2 = r20.a;
        if (objL == obj2) {
            Object objK = (ba2Var == null || (objE = ba2Var.e(string)) == null) ? null : qa2Var.k(objE);
            if (objK == null) {
                objK = fq0Var.a();
            }
            objArr2 = objArr;
            qa2Var2 = qa2Var;
            Object x92Var = new x92(qa2Var2, ba2Var, string, objK, objArr2);
            x20Var.g0(x92Var);
            objL = x92Var;
        } else {
            objArr2 = objArr;
            qa2Var2 = qa2Var;
        }
        x92 x92Var2 = (x92) objL;
        Object objA = Arrays.equals(objArr2, x92Var2.f) ? x92Var2.e : null;
        if (objA == null) {
            objA = fq0Var.a();
        }
        boolean zH = x20Var.h(x92Var2) | ((((i & 112) ^ 48) > 32 && x20Var.h(qa2Var2)) || (i & 48) == 32) | x20Var.h(ba2Var) | x20Var.f(string) | x20Var.h(objA) | x20Var.h(objArr2);
        Object objL2 = x20Var.L();
        if (zH || objL2 == obj2) {
            Object[] objArr3 = objArr2;
            obj = objA;
            Object l52Var = new l52(x92Var2, qa2Var2, ba2Var, string, obj, objArr3, 0);
            x20Var.g0(l52Var);
            objL2 = l52Var;
        } else {
            obj = objA;
        }
        bz3.d((fq0) objL2, x20Var);
        return obj;
    }

    public static final Object d(Object[] objArr, qa2 qa2Var, fq0 fq0Var, x20 x20Var, int i) {
        return c(Arrays.copyOf(objArr, objArr.length), qa2Var, fq0Var, x20Var, ((i << 3) & 7168) | CollationFastLatin.LATIN_LIMIT);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00ab A[Catch: all -> 0x00a7, PHI: r1
      0x00ab: PHI (r1v4 java.lang.Thread) = (r1v3 java.lang.Thread), (r1v15 java.lang.Thread) binds: [B:7:0x000a, B:47:0x00a4] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000c, B:46:0x00a2, B:61:0x00d1, B:12:0x001f, B:52:0x00aa, B:53:0x00ab, B:64:0x00d5, B:65:0x00d6, B:54:0x00ac, B:60:0x00d0, B:59:0x00b6, B:13:0x0020, B:15:0x002d, B:25:0x0047, B:26:0x004e, B:28:0x0059, B:34:0x006e, B:35:0x0075, B:43:0x0086, B:44:0x00a0, B:18:0x003c), top: B:77:0x0003, inners: #2, #6 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static synchronized ClassLoader e() {
        SecurityException e;
        Thread thread;
        ThreadGroup threadGroup;
        if (a == null) {
            Thread thread2 = b;
            ClassLoader contextClassLoader = null;
            if (thread2 != null) {
                synchronized (thread2) {
                    try {
                        contextClassLoader = b.getContextClassLoader();
                    } catch (SecurityException e2) {
                        Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e2.getMessage());
                    }
                }
                a = contextClassLoader;
            } else {
                ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                if (threadGroup2 == null) {
                    thread2 = null;
                } else {
                    synchronized (Void.class) {
                        try {
                            try {
                                int iActiveGroupCount = threadGroup2.activeGroupCount();
                                ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                                threadGroup2.enumerate(threadGroupArr);
                                int i = 0;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= iActiveGroupCount) {
                                        threadGroup = null;
                                        break;
                                    }
                                    threadGroup = threadGroupArr[i2];
                                    if ("dynamiteLoader".equals(threadGroup.getName())) {
                                        break;
                                    }
                                    i2++;
                                }
                                if (threadGroup == null) {
                                    threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                                }
                                int iActiveCount = threadGroup.activeCount();
                                Thread[] threadArr = new Thread[iActiveCount];
                                threadGroup.enumerate(threadArr);
                                while (true) {
                                    if (i >= iActiveCount) {
                                        thread = null;
                                        break;
                                    }
                                    thread = threadArr[i];
                                    if ("GmsDynamite".equals(thread.getName())) {
                                        break;
                                    }
                                    i++;
                                }
                                if (thread == null) {
                                    try {
                                        dh dhVar = new dh(threadGroup, "GmsDynamite");
                                        try {
                                            dhVar.setContextClassLoader(null);
                                            dhVar.start();
                                            thread = dhVar;
                                        } catch (SecurityException e3) {
                                            e = e3;
                                            thread = dhVar;
                                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                                        }
                                    } catch (SecurityException e4) {
                                        e = e4;
                                    }
                                }
                            } catch (SecurityException e5) {
                                e = e5;
                                thread = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    thread2 = thread;
                }
                b = thread2;
                if (thread2 != null) {
                    synchronized (thread2) {
                        contextClassLoader = b.getContextClassLoader();
                    }
                }
                a = contextClassLoader;
            }
        }
        return a;
    }
}
