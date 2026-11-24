package defpackage;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class cq implements up {
    public static final /* synthetic */ int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    public static /* synthetic */ int[] A(int i) {
        int[] iArr = new int[i];
        System.arraycopy(a, 0, iArr, 0, i);
        return iArr;
    }

    public static /* synthetic */ boolean a(int i, int i2) {
        if (i != 0) {
            return i == i2;
        }
        throw null;
    }

    public static int b(int i, float f, int i2) {
        return (Float.hashCode(f) + i) * i2;
    }

    public static int c(int i, int i2, long j) {
        return (Long.hashCode(j) + i) * i2;
    }

    public static b10 e(String str) {
        z01.c(str);
        return new b10();
    }

    public static b22 f(v80 v80Var, int i) {
        return yd0.a(new u80(v80Var, i, 0));
    }

    public static Rect g(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        return rect;
    }

    public static String h(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String i(String str, int i, String str2, int i2, String str3) {
        return str + i + str2 + i2 + str3;
    }

    public static String j(String str, String str2) {
        return str + str2;
    }

    public static String k(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String l(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String m(StringBuilder sb, float f, char c) {
        sb.append(f);
        sb.append(c);
        return sb.toString();
    }

    public static String n(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String o(Locale locale, String str, Locale locale2) {
        locale.getClass();
        String lowerCase = str.toLowerCase(locale2);
        lowerCase.getClass();
        return lowerCase;
    }

    public static StringBuilder p(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder q(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static /* synthetic */ BigDecimal r(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }

    public static void s(int i, x20 x20Var, jd jdVar, x20 x20Var2, j7 j7Var) {
        ie4.a(x20Var, Integer.valueOf(i), jdVar);
        ie4.b(x20Var2, j7Var);
    }

    public static void t(kf kfVar, long j) {
        kfVar.m().j();
        kfVar.G(j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void u(bq2 bq2Var) throws Exception {
        boolean zIsTerminated;
        if (bq2Var instanceof AutoCloseable) {
            bq2Var.close();
            return;
        }
        if (!(bq2Var instanceof ExecutorService)) {
            dk0.v();
            return;
        }
        ExecutorService executorService = (ExecutorService) bq2Var;
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

    public static String v(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static /* synthetic */ String w(int i) {
        switch (i) {
            case 1:
                return "RELEASED";
            case 2:
                return "RELEASING";
            case 3:
                return "INITIALIZED";
            case 4:
                return "PENDING_OPEN";
            case 5:
                return "CLOSING";
            case 6:
                return "REOPENING_QUIRK";
            case 7:
                return "REOPENING";
            case 8:
                return "OPENING";
            case 9:
                return "OPENED";
            case 10:
                return "CONFIGURED";
            default:
                throw null;
        }
    }

    public static /* synthetic */ int x(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ String y(int i) {
        switch (i) {
            case 1:
                return "RELEASED";
            case 2:
                return "RELEASING";
            case 3:
                return "INITIALIZED";
            case 4:
                return "PENDING_OPEN";
            case 5:
                return "CLOSING";
            case 6:
                return "REOPENING_QUIRK";
            case 7:
                return "REOPENING";
            case 8:
                return "OPENING";
            case 9:
                return "OPENED";
            case 10:
                return "CONFIGURED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String z(int i) {
        switch (i) {
            case 1:
                return "UNINITIALIZED";
            case 2:
                return "INITIALIZED";
            case 3:
                return "GET_SURFACE";
            case 4:
                return "OPENING";
            case 5:
                return "OPENED";
            case 6:
                return "CLOSED";
            case 7:
                return "RELEASING";
            case 8:
                return "RELEASED";
            default:
                return "null";
        }
    }
}
