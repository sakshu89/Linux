package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.ibm.icu.impl.PatternTokenizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xg4 {
    public static dd0 a() {
        if (dd0.b != null) {
            return dd0.b;
        }
        synchronized (dd0.class) {
            try {
                if (dd0.b == null) {
                    dd0.b = new dd0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dd0.b;
    }

    public static w31 b() {
        if (w31.c != null) {
            return w31.c;
        }
        synchronized (w31.class) {
            try {
                if (w31.c == null) {
                    w31.c = new w31(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return w31.c;
    }

    public static xv0 c() {
        if (kg1.a != null) {
            return kg1.a;
        }
        synchronized (kg1.class) {
            try {
                if (kg1.a == null) {
                    kg1.a = new xv0(new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return kg1.a;
    }

    public static String d(rt3 rt3Var) {
        StringBuilder sb = new StringBuilder(rt3Var.d());
        for (int i = 0; i < rt3Var.d(); i++) {
            byte bA = rt3Var.a(i);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append(PatternTokenizer.BACK_SLASH);
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
