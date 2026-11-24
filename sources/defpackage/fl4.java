package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.ArabicShaping;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class fl4 implements e91, i70, b23, mo, op3, p10, ks4 {
    public static fl4 b;
    public static volatile fl4 e;
    public final /* synthetic */ int a;
    public static final Object c = new Object();
    public static final fl4 f = new fl4(2);
    public static final /* synthetic */ fl4 i = new fl4(3);
    public static final fl4 j = new fl4(4);
    public static final fl4 k = new fl4(5);
    public static final fl4 n = new fl4(6);
    public static final /* synthetic */ fl4 s = new fl4(7);

    public fl4() {
        this.a = 1;
        new ConcurrentHashMap();
    }

    public static String c(int i2, int i3, int i4, String str, String str2, boolean z) {
        int i5 = (i4 & 1) != 0 ? 0 : i2;
        int length = (i4 & 2) != 0 ? str.length() : i3;
        boolean z2 = (i4 & 8) != 0 ? false : z;
        boolean z3 = (i4 & 16) == 0;
        boolean z4 = (i4 & 32) == 0;
        boolean z5 = (i4 & 64) == 0;
        str.getClass();
        int iCharCount = i5;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i6 = 128;
            int i7 = 32;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z5) || cs2.o(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z2 || (z3 && !d(iCharCount, length, str)))) || (iCodePointAt == 43 && z4)))) {
                ln lnVar = new ln();
                lnVar.M(i5, iCharCount, str);
                ln lnVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z4) {
                            lnVar.N(z2 ? "+" : "%2B");
                        } else if (iCodePointAt2 < i7 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i6 && !z5) || cs2.o(str2, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z2 || (z3 && !d(iCharCount, length, str)))))) {
                            if (lnVar2 == null) {
                                lnVar2 = new ln();
                            }
                            lnVar2.O(iCodePointAt2);
                            while (!lnVar2.e()) {
                                byte b2 = lnVar2.readByte();
                                int i8 = b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                                lnVar.E(37);
                                char[] cArr = ey0.j;
                                lnVar.E(cArr[(i8 >> 4) & 15]);
                                lnVar.E(cArr[b2 & 15]);
                            }
                        } else {
                            lnVar.O(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i6 = 128;
                    i7 = 32;
                }
                return lnVar.w();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i5, length);
    }

    public static boolean d(int i2, int i3, String str) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && z53.r(str.charAt(i2 + 1)) != -1 && z53.r(str.charAt(i4)) != -1;
    }

    public static String e(int i2, int i3, int i4, String str) {
        int i5;
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        boolean z = (i4 & 4) == 0;
        str.getClass();
        int iCharCount = i2;
        while (iCharCount < i3) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                ln lnVar = new ln();
                lnVar.M(i2, iCharCount, str);
                while (iCharCount < i3) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i5 = iCharCount + 2) < i3) {
                        int iR = z53.r(str.charAt(iCharCount + 1));
                        int iR2 = z53.r(str.charAt(i5));
                        if (iR == -1 || iR2 == -1) {
                            lnVar.O(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            lnVar.E((iR << 4) + iR2);
                            iCharCount = Character.charCount(iCodePointAt) + i5;
                        }
                    } else if (iCodePointAt == 43 && z) {
                        lnVar.E(32);
                        iCharCount++;
                    } else {
                        lnVar.O(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return lnVar.w();
            }
            iCharCount++;
        }
        return str.substring(i2, i3);
    }

    public static ArrayList j(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int iX = cs2.x(str, '&', i2, 4);
            if (iX == -1) {
                iX = str.length();
            }
            int iX2 = cs2.x(str, '=', i2, 4);
            if (iX2 == -1 || iX2 > iX) {
                arrayList.add(str.substring(i2, iX));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i2, iX2));
                arrayList.add(str.substring(iX2 + 1, iX));
            }
            i2 = iX + 1;
        }
        return arrayList;
    }

    public static synchronized void l() {
        if (b == null) {
            b = new fl4(0);
        }
    }

    @Override // defpackage.b23
    public Object apply(Object obj) {
        switch (this.a) {
            case 7:
                break;
        }
        return (byte[]) obj;
    }

    @Override // defpackage.mo
    public byte[] b(int i2, byte[] bArr, int i3) {
        return Arrays.copyOfRange(bArr, i2, i3 + i2);
    }

    @Override // defpackage.ks4
    public Object f(Object obj) {
        String str = ((rw2) obj).a;
        return str == null ? "" : str;
    }

    @Override // defpackage.p10
    public Object g(e72 e72Var) {
        switch (this.a) {
            case 22:
                return new ak1(0);
            default:
                hy hyVar = new hy();
                t5 t5Var = new t5(3);
                ReferenceQueue referenceQueue = hyVar.a;
                Set set = hyVar.b;
                set.add(new z14(hyVar, referenceQueue, set, t5Var));
                Thread thread = new Thread(new or0(11, referenceQueue, set), "MlKitCleaner");
                thread.setDaemon(true);
                thread.start();
                return hyVar;
        }
    }

    @Override // defpackage.op3
    public String h(Object obj) {
        return ((jr3) obj).a;
    }

    public void k(Context context, pn4 pn4Var) {
        try {
            context.unbindService(pn4Var);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    public boolean m(Context context, String str, Intent intent, pn4 pn4Var, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((sc3.a(context).a.getPackageManager().getApplicationInfo(packageName, 0).flags & ArabicShaping.SEEN_TWOCELL_NEAR) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (executor == null) {
            executor = null;
        }
        return (Build.VERSION.SDK_INT < 29 || executor == null) ? context.bindService(intent, pn4Var, 4225) : context.bindService(intent, 4225, executor, pn4Var);
    }

    public String toString() {
        switch (this.a) {
            case 18:
                return "SharingStarted.Lazily";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ fl4(int i2) {
        this.a = i2;
    }

    @Override // defpackage.e91
    public void a() {
    }

    @Override // defpackage.e91
    public void cancel() {
    }

    public void i(yy1 yy1Var, int i2, int i3) {
    }
}
