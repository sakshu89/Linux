package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Trace;
import com.ibm.icu.impl.locale.LanguageTag;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dp0 {
    public static final tf1 a = new tf1(16);
    public static final ThreadPoolExecutor b;
    public static final Object c;
    public static final pk2 d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new i62());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
        c = new Object();
        d = new pk2(0);
    }

    public static String a(int i, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(((yo0) list.get(i2)).g);
            sb.append(LanguageTag.SEP);
            sb.append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static cp0 b(String str, Context context, List list, int i) {
        int i2;
        Typeface typefaceB;
        tf1 tf1Var = a;
        Trace.beginSection(hd4.e("getFontSync"));
        try {
            Typeface typeface = (Typeface) tf1Var.a(str);
            if (typeface != null) {
                cp0 cp0Var = new cp0(typeface);
                Trace.endSection();
                return cp0Var;
            }
            try {
                c10 c10VarA = xo0.a(context, list);
                List list2 = (List) c10VarA.b;
                int i3 = c10VarA.a;
                if (i3 == 0) {
                    pp0[] pp0VarArr = (pp0[]) list2.get(0);
                    if (pp0VarArr == null || pp0VarArr.length == 0) {
                        i2 = 1;
                    } else {
                        int length = pp0VarArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                i2 = 0;
                                break;
                            }
                            int i5 = pp0VarArr[i4].f;
                            if (i5 != 0) {
                                if (i5 >= 0) {
                                    i2 = i5;
                                    break;
                                }
                                i2 = -3;
                                break;
                            }
                            i4++;
                        }
                    }
                } else {
                    if (i3 != 1) {
                        i2 = -3;
                        break;
                    }
                    i2 = -2;
                }
                if (i2 != 0) {
                    cp0 cp0Var2 = new cp0(i2);
                    Trace.endSection();
                    return cp0Var2;
                }
                if (list2.size() <= 1 || Build.VERSION.SDK_INT < 29) {
                    pp0[] pp0VarArr2 = (pp0[]) list2.get(0);
                    ae4 ae4Var = l33.a;
                    Trace.beginSection(hd4.e("TypefaceCompat.createFromFontInfo"));
                    try {
                        typefaceB = l33.a.b(context, pp0VarArr2, i);
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } else {
                    ae4 ae4Var2 = l33.a;
                    Trace.beginSection(hd4.e("TypefaceCompat.createFromFontInfoWithFallback"));
                    try {
                        typefaceB = l33.a.c(context, list2, i);
                        Trace.endSection();
                    } catch (Throwable th2) {
                        Trace.endSection();
                        throw th2;
                    }
                }
                if (typefaceB == null) {
                    cp0 cp0Var3 = new cp0(-3);
                    Trace.endSection();
                    return cp0Var3;
                }
                tf1Var.b(str, typefaceB);
                cp0 cp0Var4 = new cp0(typefaceB);
                Trace.endSection();
                return cp0Var4;
            } catch (PackageManager.NameNotFoundException unused) {
                cp0 cp0Var5 = new cp0(-1);
                Trace.endSection();
                return cp0Var5;
            }
        } catch (Throwable th3) {
            Trace.endSection();
            throw th3;
        }
    }
}
