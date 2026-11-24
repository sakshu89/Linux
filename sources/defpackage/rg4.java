package defpackage;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class rg4 {
    public static fu a(String str) {
        str.getClass();
        int i = Build.VERSION.SDK_INT;
        String absolutePath = i < 29 ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() : null;
        if (!str.equals(new File(str).getName()) || cs2.A(str)) {
            og.i("Failed requirement.");
            return null;
        }
        if (i >= 29) {
            return new fu("relative_path", "Pictures/SONIC/");
        }
        if (absolutePath == null) {
            og.i("Required value was null.");
            return null;
        }
        String absolutePath2 = new File(new File(absolutePath, "SONIC"), str).getAbsolutePath();
        absolutePath2.getClass();
        return new fu("_data", absolutePath2);
    }

    public static String b(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String strL;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                strL = "null";
            } else {
                try {
                    strL = obj.toString();
                } catch (Exception e) {
                    String strK = cq.k(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strK), (Throwable) e);
                    strL = ky0.l("<", strK, " threw ", e.getClass().getName(), ">");
                }
            }
            objArr[i2] = strL;
            i2++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (iIndexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i3, iIndexOf);
            sb.append(objArr[i]);
            i++;
            i3 = iIndexOf + 2;
        }
        sb.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
