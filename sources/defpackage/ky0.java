package defpackage;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ky0 {
    public static int A(int i, int i2, int i3) {
        return st3.b(i) + i2 + i3;
    }

    public static int a(int i, int i2, int i3) {
        return (Integer.hashCode(i) + i2) * i3;
    }

    public static int b(int i, int i2, int i3, int i4) {
        return st3.b(i) + i2 + i3 + i4;
    }

    public static int c(int i, int i2, yz2 yz2Var) {
        return (yz2Var.hashCode() + i) * i2;
    }

    public static int d(int i, int i2, String str) {
        return (str.hashCode() + i) * i2;
    }

    public static int e(int i, int i2, boolean z) {
        return (Boolean.hashCode(z) + i) * i2;
    }

    public static kt2 f(ArrayList arrayList, kt2 kt2Var) {
        arrayList.add(kt2Var);
        return new kt2();
    }

    public static ClassCastException g(Object obj) {
        obj.getClass();
        return new ClassCastException();
    }

    public static String h(int i, String str) {
        return str + i;
    }

    public static String i(String str, int i, int i2, String str2) {
        return str + i + str2 + i2;
    }

    public static String j(String str, String str2) {
        return str + str2;
    }

    public static String k(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String l(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String m(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static String n(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static String o(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder p(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static HashMap q(Class cls, fx3 fx3Var) {
        HashMap map = new HashMap();
        map.put(cls, fx3Var);
        return map;
    }

    public static Map r(HashMap map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static fx3 s(HashMap map, int i) {
        Collections.unmodifiableMap(new HashMap(map));
        return new fx3(i);
    }

    public static void t(int i, int i2, int i3, int i4, int i5) {
        mp4.a(i);
        mp4.a(i2);
        mp4.a(i3);
        mp4.a(i4);
        mp4.a(i5);
    }

    public static void u(int i, lt2 lt2Var, long j, kt2 kt2Var) {
        kt2Var.a(new hj(i, lt2Var, j));
    }

    public static void v(long j, StringBuilder sb, String str) {
        sb.append((Object) sz.i(j));
        sb.append(str);
    }

    public static /* synthetic */ void w(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            }
            if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            } else if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
                return;
            } else {
                dk0.v();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static /* synthetic */ void x(Object obj) {
        if (obj == null) {
            return;
        }
        dk0.t();
    }

    public static void y(String str, String str2, PrintStream printStream) {
        printStream.println(str + str2);
    }

    public static void z(HashMap map) {
        Collections.unmodifiableMap(new HashMap(map));
    }
}
