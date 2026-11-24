package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.number.Padder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vc2 implements bl2 {
    public final r2 a;
    public final xb2 b;
    public final nb2 c;
    public final dt1 d;
    public final j5 e;
    public final zv1 f;
    public final xj1 g;
    public final uv1 h;
    public final xc2 i;
    public final Set j;
    public final ii0 k;
    public final l82 l;

    public vc2(r2 r2Var, xb2 xb2Var, nb2 nb2Var, dt1 dt1Var, j5 j5Var, zv1 zv1Var, xj1 xj1Var, uv1 uv1Var, xc2 xc2Var) {
        r2Var.getClass();
        xb2Var.getClass();
        nb2Var.getClass();
        dt1Var.getClass();
        j5Var.getClass();
        zv1Var.getClass();
        xj1Var.getClass();
        uv1Var.getClass();
        xc2Var.getClass();
        this.a = r2Var;
        this.b = xb2Var;
        this.c = nb2Var;
        this.d = dt1Var;
        this.e = j5Var;
        this.f = zv1Var;
        this.g = xj1Var;
        this.h = uv1Var;
        this.i = xc2Var;
        this.j = wh2.c(new w3("screen.read"), new w3("screen.deep_analyze"), new w3("screen.click"), new w3("screen.type"), new w3("screen.scroll"), new w3("screen.swipe"), new w3("screen.back"), new w3("screen.home"), new w3("youtube.like"), new w3("youtube.dislike"), new w3("youtube.subscribe"), new w3("youtube.skip_ad"));
        this.k = ii0.a;
        this.l = l82.c;
    }

    public static boolean A(Bitmap bitmap, Bitmap bitmap2, Rect rect) {
        int i;
        int i2;
        if (bitmap.isRecycled() || bitmap2.isRecycled() || bitmap.getWidth() != bitmap2.getWidth() || bitmap.getHeight() != bitmap2.getHeight() || rect.left < 0 || rect.top < 0 || rect.right > bitmap.getWidth() || rect.bottom > bitmap.getHeight() || rect.right <= rect.left || (i = rect.bottom) <= (i2 = rect.top)) {
            return false;
        }
        for (i2 = rect.top; i2 < i; i2++) {
            try {
                int i3 = rect.right;
                for (int i4 = rect.left; i4 < i3; i4++) {
                    if (bitmap.getPixel(i4, i2) != bitmap2.getPixel(i4, i2)) {
                        return false;
                    }
                }
            } catch (IllegalArgumentException | IllegalStateException unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean D(fc2 fc2Var, fc2 fc2Var2) {
        if (!fc2Var2.a.equals(fc2Var.a) || fc2Var2.b != fc2Var.b) {
            return false;
        }
        Rect rect = fc2Var2.c;
        int i = rect.left;
        Rect rect2 = fc2Var.c;
        return i == rect2.left && rect.top == rect2.top && rect.right == rect2.right && rect.bottom == rect2.bottom;
    }

    public static boolean E(ec2 ec2Var, fc2 fc2Var, wc2 wc2Var) {
        String str;
        fc2 fc2Var2 = ec2Var.b;
        sv1 sv1Var = ec2Var.a;
        String str2 = sv1Var.a;
        boolean zD = D(fc2Var2, fc2Var);
        String str3 = fc2Var.a;
        if (!zD) {
            return false;
        }
        if (wc2Var != null && !g31.a(wc2Var.a, str3)) {
            return false;
        }
        if (str3.equals("com.google.android.youtube")) {
            x42 x42Var = yc3.a;
            if (yc3.m(str2)) {
                return true;
            }
        }
        String str4 = sv1Var.g;
        String strG = uz3.g(wc2Var);
        if (str4 != null) {
            return strG != null && wz3.a(str4, strG);
        }
        if (sv1Var.c.equals(uz3.a(wc2Var))) {
            return true;
        }
        x42 x42Var2 = yc3.a;
        if (!yc3.m(str2) || (str = sv1Var.i) == null) {
            return false;
        }
        return str.equals(wc2Var != null ? yc3.t(wc2Var) : null);
    }

    public static fl2 n(String str) {
        return new fl2("The app or screen changed while I was analyzing it. Ask again on the screen you want.", cq.v("Screen changed during OCR; stale coordinates discarded (", str, ")"), null, false, 12);
    }

    public static /* synthetic */ fl2 o(vc2 vc2Var) {
        vc2Var.getClass();
        return n("active app changed");
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v6 */
    public static final Object s(vc2 vc2Var, wc2 wc2Var, fc2 fc2Var, String str, int i, t42 t42Var, f5 f5Var, ec2 ec2Var, String str2, wc2 wc2Var2, y50 y50Var) {
        jc2 jc2Var;
        int i2;
        ec2 ec2Var2;
        f5 f5Var2;
        ?? r1;
        vc2 vc2Var2;
        int i3;
        ?? r2;
        int i4 = i;
        if (y50Var instanceof jc2) {
            jc2Var = (jc2) y50Var;
            int i5 = jc2Var.u;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                jc2Var.u = i5 - Integer.MIN_VALUE;
            } else {
                jc2Var = new jc2(y50Var);
            }
        } else {
            jc2Var = new jc2(y50Var);
        }
        Object obj = jc2Var.t;
        int i6 = jc2Var.u;
        t70 t70Var = t70.a;
        if (i6 == 0) {
            bz3.g(obj);
            fc2 fc2VarP = vc2Var.p();
            String strG = uz3.g(wc2Var);
            String strG2 = uz3.g(wc2Var2);
            ?? r6 = (g31.a(fc2VarP != null ? fc2VarP.a : null, fc2Var.a) && fc2VarP.b == fc2Var.b) ? 1 : 0;
            ?? r8 = (strG == null || strG2 == null || !wz3.a(strG, strG2)) ? 0 : 1;
            if (str == null || !yc3.m(str)) {
                i2 = 0;
            } else {
                if ((wc2Var != null ? yc3.t(wc2Var) : null) == null || !t(str, wc2Var, wc2Var2)) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
            }
            if (i4 == 0 && r6 != 0 && (r8 != 0 || i2 != 0)) {
                if (g31.a(wc2Var2 != null ? wc2Var2.a : null, fc2Var.a)) {
                    Bitmap bitmap = (Bitmap) t42Var.a;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    t42Var.a = null;
                    jc2Var.e = vc2Var;
                    jc2Var.f = f5Var;
                    ec2Var2 = ec2Var;
                    jc2Var.i = ec2Var2;
                    jc2Var.j = i4;
                    jc2Var.k = r6;
                    jc2Var.n = r8;
                    jc2Var.s = i2;
                    jc2Var.u = 1;
                    if (bm4.b(200L, jc2Var) != t70Var) {
                        f5Var2 = f5Var;
                        r1 = r8;
                        vc2Var2 = vc2Var;
                        i3 = i2;
                        r2 = r6;
                    }
                }
            }
            return n("stage=" + str2 + " same_window=" + r6 + " same_query=" + r8 + " elements_before=" + (wc2Var != null ? wc2Var.c.size() : 0) + " elements_after=" + (wc2Var2 != null ? wc2Var2.c.size() : 0) + " attempt=" + i4);
        }
        if (i6 != 1) {
            if (i6 == 2) {
                bz3.g(obj);
                return obj;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i3 = jc2Var.s;
        int i7 = jc2Var.n;
        int i8 = jc2Var.k;
        i4 = jc2Var.j;
        ec2Var2 = jc2Var.i;
        f5Var2 = jc2Var.f;
        vc2Var2 = jc2Var.e;
        bz3.g(obj);
        r1 = i7;
        r2 = i8;
        jc2Var.e = null;
        jc2Var.f = null;
        jc2Var.i = null;
        jc2Var.j = i4;
        jc2Var.k = r2;
        jc2Var.n = r1;
        jc2Var.s = i3;
        jc2Var.u = 2;
        Object objR = vc2Var2.r(f5Var2, i4 + 1, ec2Var2, jc2Var);
        return objR == t70Var ? t70Var : objR;
    }

    public static final boolean t(String str, wc2 wc2Var, wc2 wc2Var2) {
        if (uz3.a(wc2Var).equals(uz3.a(wc2Var2))) {
            return true;
        }
        if (str == null || !yc3.m(str) || wc2Var == null) {
            return false;
        }
        String str2 = wc2Var.a;
        return wc2Var2 != null && g31.a(str2, "com.google.android.youtube") && g31.a(wc2Var2.a, str2);
    }

    public static final boolean z(ob2 ob2Var) {
        String str = ob2Var.b;
        String str2 = ob2Var.a;
        if (str == null) {
            str = "";
        }
        String strS = cs2.S(str, '/');
        Locale locale = Locale.ROOT;
        if (wh2.c("skip_ad_button", "skip_ad_button_text", "ad_skip_button", "skip_button").contains(cq.o(locale, strS, locale))) {
            return true;
        }
        Set setC = wh2.c("skip ad", "skip ads", "skip advertisement", "विज्ञापन छोड़ें");
        String lowerCase = cs2.V(str2).toString().toLowerCase(locale);
        lowerCase.getClass();
        if (setC.contains(lowerCase)) {
            return true;
        }
        return js2.f(cs2.V(str2).toString(), "skip") && js2.e(ob2Var.c, "Button", false);
    }

    public final Object B(f5 f5Var, String str, wc2 wc2Var, fc2 fc2Var, y50 y50Var) throws NoSuchAlgorithmException {
        if (fc2Var == null) {
            return new fl2(cq.v("I couldn't identify the active app for ", str, "."), "No active application window for automatic recovery", null, false, 12);
        }
        String str2 = fc2Var.a;
        if ((wc2Var != null && !g31.a(wc2Var.a, str2)) || !C(fc2Var)) {
            return n("active app changed");
        }
        String strA = uz3.a(wc2Var);
        String str3 = f5Var.a;
        Integer num = new Integer(fc2Var.b);
        String strG = uz3.g(wc2Var);
        Map map = f5Var.b;
        String strT = wc2Var != null ? yc3.t(wc2Var) : null;
        sv1 sv1Var = new sv1(str, str2, strA, str3, System.currentTimeMillis(), num, strG, map, strT);
        this.h.d(str, str2, strA, str3, num, strG, map, strT);
        xa0 xa0Var = ld0.a;
        return uf4.d(ig1.a.i, new aa(this, f5Var, sv1Var, fc2Var, null, 12), y50Var);
    }

    public final boolean C(fc2 fc2Var) {
        fc2 fc2VarP = p();
        if (fc2VarP == null) {
            return false;
        }
        return D(fc2Var, fc2VarP);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object F(AccessibilityService accessibilityService, Rect rect, AccessibilityNodeInfo accessibilityNodeInfo, y50 y50Var) {
        qc2 qc2Var;
        AccessibilityNodeInfo accessibilityNodeInfoB;
        if (y50Var instanceof qc2) {
            qc2Var = (qc2) y50Var;
            int i = qc2Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                qc2Var.j = i - Integer.MIN_VALUE;
            } else {
                qc2Var = new qc2(this, y50Var);
            }
        } else {
            qc2Var = new qc2(this, y50Var);
        }
        Object objC = qc2Var.f;
        int i2 = qc2Var.j;
        x50 x50Var = null;
        try {
            if (i2 == 0) {
                bz3.g(objC);
                if (rect.right <= rect.left || rect.bottom <= rect.top) {
                    return Boolean.FALSE;
                }
                accessibilityNodeInfoB = this.a.b();
                if (accessibilityNodeInfoB == null) {
                    return Boolean.FALSE;
                }
                CharSequence packageName = accessibilityNodeInfoB.getPackageName();
                String string = packageName != null ? packageName.toString() : null;
                CharSequence packageName2 = accessibilityNodeInfo.getPackageName();
                if (g31.a(string, packageName2 != null ? packageName2.toString() : null) && accessibilityNodeInfoB.getWindowId() == accessibilityNodeInfo.getWindowId()) {
                    Rect rect2 = new Rect();
                    accessibilityNodeInfoB.getBoundsInScreen(rect2);
                    if (rect.left >= rect2.left && rect.top >= rect2.top && rect.right <= rect2.right && rect.bottom <= rect2.bottom) {
                        Path path = new Path();
                        path.moveTo((rect.left + rect.right) / 2.0f, (rect.top + rect.bottom) / 2.0f);
                        sc2 sc2Var = new sc2(accessibilityService, new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 50L)).build(), x50Var, 0);
                        qc2Var.e = accessibilityNodeInfoB;
                        qc2Var.j = 1;
                        objC = xc4.c(1500L, sc2Var, qc2Var);
                        t70 t70Var = t70.a;
                        if (objC == t70Var) {
                            return t70Var;
                        }
                    }
                    Boolean bool = Boolean.FALSE;
                    accessibilityNodeInfoB.recycle();
                    return bool;
                }
                Boolean bool2 = Boolean.FALSE;
                accessibilityNodeInfoB.recycle();
                return bool2;
            }
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            accessibilityNodeInfoB = qc2Var.e;
            bz3.g(objC);
            Boolean boolValueOf = Boolean.valueOf(g31.a(objC, Boolean.TRUE));
            accessibilityNodeInfoB.recycle();
            return boolValueOf;
        } catch (Throwable th) {
            recycle();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0225  */
    /* JADX WARN: Code duplicated, block: B:112:0x0254  */
    /* JADX WARN: Code duplicated, block: B:352:0x0225 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:353:0x0261 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:354:? A[LOOP:1: B:110:0x024e->B:354:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0138 A[EDGE_INSN: B:53:0x0138->B:55:0x013f BREAK  A[LOOP:17: B:42:0x00ef->B:52:0x0130], PHI: r4 r9
      0x0138: PHI (r4v3 cc2) = (r4v0 cc2), (r4v0 cc2), (r4v4 cc2) binds: [B:37:0x00e2, B:39:0x00e8, B:420:0x0138] A[DONT_GENERATE, DONT_INLINE]
      0x0138: PHI (r9v3 cc2) = (r9v0 cc2), (r9v0 cc2), (r9v5 cc2) binds: [B:37:0x00e2, B:39:0x00e8, B:420:0x0138] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x01a3 -> B:67:0x01a6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:110:0x024e
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object G(java.lang.String r29, defpackage.wc2 r30, java.lang.String r31, defpackage.y50 r32) {
        /*
            Method dump skipped, instruction units count: 1826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vc2.G(java.lang.String, wc2, java.lang.String, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:62:0x014c A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:14:0x003d, B:46:0x0115, B:49:0x011f, B:51:0x0125, B:53:0x012f, B:56:0x013b, B:65:0x0159, B:59:0x0142, B:60:0x0146, B:62:0x014c), top: B:87:0x003d }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:91:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:? A[LOOP:0: B:60:0x0146->B:93:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0113 -> B:46:0x0115). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0193 -> B:78:0x0186). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object H(defpackage.fc2 r18, android.graphics.Bitmap r19, java.util.List r20, defpackage.y50 r21) {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vc2.H(fc2, android.graphics.Bitmap, java.util.List, y50):java.lang.Object");
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.j;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "screen";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Reads screen contents, taps elements, types text, scrolls and performs deep screen analysis";
    }

    @Override // defpackage.bl2
    public final void f() {
        this.h.a();
    }

    /* JADX WARN: Code duplicated, block: B:136:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:138:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:141:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:144:0x02ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x02f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:146:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:148:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:149:0x0302  */
    /* JADX WARN: Code duplicated, block: B:151:0x0307  */
    /* JADX WARN: Code duplicated, block: B:152:0x0311  */
    /* JADX WARN: Code duplicated, block: B:154:0x031e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0345 A[Catch: all -> 0x034a, TRY_LEAVE, TryCatch #0 {all -> 0x034a, blocks: (B:156:0x033a, B:158:0x0345), top: B:209:0x033a }] */
    /* JADX WARN: Code duplicated, block: B:162:0x034c  */
    /* JADX WARN: Code duplicated, block: B:166:0x0359  */
    /* JADX WARN: Code duplicated, block: B:169:0x035e  */
    /* JADX WARN: Code duplicated, block: B:171:0x0364  */
    /* JADX WARN: Code duplicated, block: B:174:0x037e  */
    /* JADX WARN: Code duplicated, block: B:175:0x03ad  */
    /* JADX WARN: Instruction removed from duplicated block: B:174:0x037e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:175:0x03ad, please report this as an issue */
    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) {
        String upperCase;
        uu2 uu2Var;
        uu2 uu2Var2;
        r2 r2Var;
        AccessibilityService accessibilityServiceI;
        AccessibilityNodeInfo accessibilityNodeInfoC;
        Rect rect;
        float f;
        float f2;
        float fWidth;
        float fHeight;
        int iOrdinal;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        Object h72Var;
        boolean z;
        Object obj;
        GestureDescription gestureDescription;
        GestureDescription.Builder builderAddStroke;
        Object obj2;
        Object t3Var;
        String str = f5Var.a;
        if (g31.a(str, "screen.read")) {
            return u((y50) x50Var);
        }
        x50 x50Var2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        if (g31.a(str, "screen.deep_analyze")) {
            return r(f5Var, 0, null, (y50) x50Var);
        }
        if (g31.a(str, "screen.click")) {
            return uf4.d(ld0.a, new gc2(this, f5Var, null, 0), x50Var);
        }
        if (g31.a(str, "youtube.like")) {
            return uf4.d(ld0.a, new r0(this, f5Var, "Like", x50Var2, 14), (fn2) x50Var);
        }
        if (g31.a(str, "youtube.dislike")) {
            return uf4.d(ld0.a, new r0(this, f5Var, "Dislike", x50Var2, 14), (fn2) x50Var);
        }
        if (g31.a(str, "youtube.subscribe")) {
            return x((y50) x50Var);
        }
        if (g31.a(str, "youtube.skip_ad")) {
            return w((y50) x50Var);
        }
        if (g31.a(str, "screen.type")) {
            return uf4.d(ld0.a, new gc2(this, f5Var, null, 1), x50Var);
        }
        boolean zA = g31.a(str, "screen.scroll");
        Object s3Var = u3.a;
        nb2 nb2Var = this.c;
        if (zA) {
            String strC = f5Var.c("direction");
            gd2 gd2Var = gd2.a;
            gd2 gd2Var2 = (strC == null || !strC.equalsIgnoreCase("UP")) ? gd2.b : gd2Var;
            nb2Var.getClass();
            r2 r2Var2 = nb2Var.a;
            AccessibilityService accessibilityServiceI2 = r2Var2.i();
            Object obj3 = s3Var;
            if (accessibilityServiceI2 != null) {
                AccessibilityNodeInfo accessibilityNodeInfoB = r2Var2.b();
                obj3 = s3Var;
                if (accessibilityNodeInfoB != null) {
                    int i4 = gd2Var2 == gd2Var ? 8192 : 4096;
                    ArrayList arrayListL = nb2.l(accessibilityNodeInfoB);
                    try {
                        int size = arrayListL.size();
                        int i5 = 0;
                        do {
                            if (i5 >= size) {
                                obj2 = null;
                                break;
                            }
                            obj2 = arrayListL.get(i5);
                            i5++;
                        } while (!((AccessibilityNodeInfo) obj2).isScrollable());
                        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
                        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.performAction(i4)) {
                            Path path = new Path();
                            DisplayMetrics displayMetrics = nb2Var.b.getResources().getDisplayMetrics();
                            float f10 = displayMetrics.widthPixels;
                            float f11 = displayMetrics.heightPixels;
                            if (gd2Var2 == gd2Var) {
                                float f12 = f10 / 2.0f;
                                path.moveTo(f12, 0.3f * f11);
                                path.lineTo(f12, f11 * 0.7f);
                            } else {
                                float f13 = f10 / 2.0f;
                                path.moveTo(f13, 0.7f * f11);
                                path.lineTo(f13, f11 * 0.3f);
                            }
                            if (accessibilityServiceI2.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 300L)).build(), null, null)) {
                                t3Var = new s3("scroll " + gd2Var2, null, null);
                            } else {
                                t3Var = new t3("scrollable container", ii0.a);
                            }
                            obj3 = t3Var;
                            int size2 = arrayListL.size();
                            while (i2 < size2) {
                                Object obj4 = arrayListL.get(i2);
                                i2++;
                                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj4;
                                if (!g31.a(accessibilityNodeInfo2, accessibilityNodeInfoB)) {
                                    accessibilityNodeInfo2.recycle();
                                }
                            }
                            accessibilityNodeInfoB.recycle();
                        } else {
                            Object s3Var2 = new s3("scroll " + gd2Var2, null, null);
                            int size3 = arrayListL.size();
                            while (i < size3) {
                                Object obj5 = arrayListL.get(i);
                                i++;
                                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj5;
                                if (!g31.a(accessibilityNodeInfo3, accessibilityNodeInfoB)) {
                                    accessibilityNodeInfo3.recycle();
                                }
                            }
                            accessibilityNodeInfoB.recycle();
                            obj3 = s3Var2;
                        }
                    } catch (Throwable th) {
                        int size4 = arrayListL.size();
                        while (i3 < size4) {
                            Object obj6 = arrayListL.get(i3);
                            i3++;
                            AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj6;
                            if (!g31.a(accessibilityNodeInfo4, accessibilityNodeInfoB)) {
                                accessibilityNodeInfo4.recycle();
                            }
                        }
                        accessibilityNodeInfoB.recycle();
                        throw th;
                    }
                }
            }
            if (!(obj3 instanceof s3)) {
                return new fl2("Unable to scroll screen, Boss.", "Scroll failed", null, false, 12);
            }
            String lowerCase = gd2Var2.name().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            return new hl2("Scrolled " + lowerCase + ", Boss.", "Android accepted the scroll; the final position isn't observable", new c73("Scroll request accepted"), null, false, 24);
        }
        if (!g31.a(str, "screen.swipe")) {
            if (g31.a(str, "screen.back")) {
                AccessibilityService accessibilityServiceI3 = nb2Var.a.i();
                Object s3Var3 = s3Var;
                if (accessibilityServiceI3 != null) {
                    s3Var3 = s3Var;
                    if (accessibilityServiceI3.performGlobalAction(1)) {
                        s3Var3 = new s3("back", null, null);
                    }
                }
                return s3Var3 instanceof s3 ? new hl2("Going back, Boss.", "Android accepted the back action", new c73("Global BACK accepted"), null, false, 24) : new fl2("Unable to perform back gesture, Boss.", "Back failed", null, false, 12);
            }
            if (!g31.a(str, "screen.home")) {
                return new fl2(cq.j("Unsupported action ", f5Var.a), "Unknown action", null, false, 12);
            }
            AccessibilityService accessibilityServiceI4 = nb2Var.a.i();
            Object s3Var4 = s3Var;
            if (accessibilityServiceI4 != null) {
                s3Var4 = s3Var;
                if (accessibilityServiceI4.performGlobalAction(2)) {
                    s3Var4 = new s3("home", null, null);
                }
            }
            return s3Var4 instanceof s3 ? new hl2("Going to the home screen, Boss.", "Android accepted the home action", new c73("Global HOME accepted"), null, false, 24) : new fl2("Unable to go to the home screen, Boss.", "Home failed", null, false, 12);
        }
        String strC2 = f5Var.c("direction");
        if (strC2 != null) {
            Locale locale = Locale.ROOT;
            locale.getClass();
            upperCase = strC2.toUpperCase(locale);
            upperCase.getClass();
        } else {
            upperCase = null;
        }
        if (upperCase != null) {
            int iHashCode = upperCase.hashCode();
            if (iHashCode != 2715) {
                if (iHashCode != 2104482) {
                    if (iHashCode != 2332679) {
                        if (iHashCode == 77974012 && upperCase.equals("RIGHT")) {
                            uu2Var = uu2.e;
                            uu2Var2 = uu2Var;
                            nb2Var.getClass();
                            r2Var = nb2Var.a;
                            accessibilityServiceI = r2Var.i();
                            if (accessibilityServiceI != null) {
                                accessibilityNodeInfoC = r2Var.c();
                                rect = new Rect();
                                if (accessibilityNodeInfoC != null) {
                                    accessibilityNodeInfoC.getBoundsInScreen(rect);
                                    accessibilityNodeInfoC.recycle();
                                }
                                if (rect.isEmpty()) {
                                    DisplayMetrics displayMetrics2 = nb2Var.b.getResources().getDisplayMetrics();
                                    rect.set(0, 0, displayMetrics2.widthPixels, displayMetrics2.heightPixels);
                                }
                                f = rect.left;
                                f2 = rect.top;
                                fWidth = rect.width();
                                fHeight = rect.height();
                                iOrdinal = uu2Var2.ordinal();
                                try {
                                    if (iOrdinal != 0) {
                                        if (iOrdinal != 1) {
                                            f3 = f + (fWidth / 2.0f);
                                            f4 = (0.8f * fHeight) + f2;
                                            f5 = fHeight * 0.2f;
                                        } else if (iOrdinal != 2) {
                                            f9 = (0.2f * fWidth) + f;
                                            f8 = (fHeight / 2.0f) + f2;
                                            f6 = (fWidth * 0.8f) + f;
                                            f7 = f8;
                                        } else {
                                            if (iOrdinal == 3) {
                                                dk0.l();
                                                return null;
                                            }
                                            float f14 = (0.8f * fWidth) + f;
                                            f8 = (fHeight / 2.0f) + f2;
                                            f6 = (fWidth * 0.2f) + f;
                                            f7 = f8;
                                            f9 = f14;
                                        }
                                        Path path2 = new Path();
                                        path2.moveTo(f9, f8);
                                        path2.lineTo(f6, f7);
                                        builderAddStroke = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path2, 0L, 250L));
                                        if (builderAddStroke != null) {
                                            h72Var = builderAddStroke.build();
                                        } else {
                                            h72Var = null;
                                        }
                                        z = h72Var instanceof h72;
                                        obj = h72Var;
                                        if (z) {
                                            obj = null;
                                        }
                                        gestureDescription = (GestureDescription) obj;
                                        if (gestureDescription != null ? accessibilityServiceI.dispatchGesture(gestureDescription, null, null) : false) {
                                            String lowerCase2 = uu2Var2.name().toLowerCase(Locale.ROOT);
                                            lowerCase2.getClass();
                                            s3Var = new s3("Moving ".concat(lowerCase2), null, null);
                                        }
                                    } else {
                                        f3 = f + (fWidth / 2.0f);
                                        f4 = (0.2f * fHeight) + f2;
                                        f5 = fHeight * 0.8f;
                                    }
                                    builderAddStroke = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path2, 0L, 250L));
                                    if (builderAddStroke != null) {
                                        h72Var = builderAddStroke.build();
                                    } else {
                                        h72Var = null;
                                    }
                                } catch (Throwable th2) {
                                    h72Var = new h72(th2);
                                }
                                f6 = f3;
                                f7 = f5 + f2;
                                f8 = f4;
                                f9 = f6;
                                Path path3 = new Path();
                                path3.moveTo(f9, f8);
                                path3.lineTo(f6, f7);
                                z = h72Var instanceof h72;
                                obj = h72Var;
                                if (z) {
                                    obj = null;
                                }
                                gestureDescription = (GestureDescription) obj;
                                if (gestureDescription != null ? accessibilityServiceI.dispatchGesture(gestureDescription, null, null) : false) {
                                    String lowerCase3 = uu2Var2.name().toLowerCase(Locale.ROOT);
                                    lowerCase3.getClass();
                                    s3Var = new s3("Moving ".concat(lowerCase3), null, null);
                                }
                            }
                            if (s3Var instanceof s3) {
                                String lowerCase4 = uu2Var2.name().toLowerCase(Locale.ROOT);
                                lowerCase4.getClass();
                                return new hl2("Moving " + lowerCase4 + ", Boss.", "Gesture dispatched; final screen content state is unobservable", new c73("Swipe gesture dispatched"), null, false, 24);
                            }
                            String lowerCase5 = uu2Var2.name().toLowerCase(Locale.ROOT);
                            lowerCase5.getClass();
                            return new fl2("Unable to swipe " + lowerCase5 + ", Boss.", "Gesture dispatch failed", null, false, 12);
                        }
                    } else if (upperCase.equals("LEFT")) {
                        uu2Var = uu2.c;
                        uu2Var2 = uu2Var;
                        nb2Var.getClass();
                        r2Var = nb2Var.a;
                        accessibilityServiceI = r2Var.i();
                        if (accessibilityServiceI != null) {
                            accessibilityNodeInfoC = r2Var.c();
                            rect = new Rect();
                            if (accessibilityNodeInfoC != null) {
                                accessibilityNodeInfoC.getBoundsInScreen(rect);
                                accessibilityNodeInfoC.recycle();
                            }
                            if (rect.isEmpty()) {
                                DisplayMetrics displayMetrics3 = nb2Var.b.getResources().getDisplayMetrics();
                                rect.set(0, 0, displayMetrics3.widthPixels, displayMetrics3.heightPixels);
                            }
                            f = rect.left;
                            f2 = rect.top;
                            fWidth = rect.width();
                            fHeight = rect.height();
                            iOrdinal = uu2Var2.ordinal();
                            if (iOrdinal != 0) {
                                if (iOrdinal != 1) {
                                    f3 = f + (fWidth / 2.0f);
                                    f4 = (0.8f * fHeight) + f2;
                                    f5 = fHeight * 0.2f;
                                } else if (iOrdinal != 2) {
                                    f9 = (0.2f * fWidth) + f;
                                    f8 = (fHeight / 2.0f) + f2;
                                    f6 = (fWidth * 0.8f) + f;
                                    f7 = f8;
                                } else {
                                    if (iOrdinal == 3) {
                                        dk0.l();
                                        return null;
                                    }
                                    float f15 = (0.8f * fWidth) + f;
                                    f8 = (fHeight / 2.0f) + f2;
                                    f6 = (fWidth * 0.2f) + f;
                                    f7 = f8;
                                    f9 = f15;
                                }
                                Path path4 = new Path();
                                path4.moveTo(f9, f8);
                                path4.lineTo(f6, f7);
                                builderAddStroke = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path4, 0L, 250L));
                                if (builderAddStroke != null) {
                                    h72Var = builderAddStroke.build();
                                } else {
                                    h72Var = null;
                                }
                                z = h72Var instanceof h72;
                                obj = h72Var;
                                if (z) {
                                    obj = null;
                                }
                                gestureDescription = (GestureDescription) obj;
                                if (gestureDescription != null ? accessibilityServiceI.dispatchGesture(gestureDescription, null, null) : false) {
                                    String lowerCase6 = uu2Var2.name().toLowerCase(Locale.ROOT);
                                    lowerCase6.getClass();
                                    s3Var = new s3("Moving ".concat(lowerCase6), null, null);
                                }
                            } else {
                                f3 = f + (fWidth / 2.0f);
                                f4 = (0.2f * fHeight) + f2;
                                f5 = fHeight * 0.8f;
                            }
                            f6 = f3;
                            f7 = f5 + f2;
                            f8 = f4;
                            f9 = f6;
                            Path path5 = new Path();
                            path5.moveTo(f9, f8);
                            path5.lineTo(f6, f7);
                            builderAddStroke = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path5, 0L, 250L));
                            if (builderAddStroke != null) {
                                h72Var = builderAddStroke.build();
                            } else {
                                h72Var = null;
                            }
                            z = h72Var instanceof h72;
                            obj = h72Var;
                            if (z) {
                                obj = null;
                            }
                            gestureDescription = (GestureDescription) obj;
                            if (gestureDescription != null ? accessibilityServiceI.dispatchGesture(gestureDescription, null, null) : false) {
                                String lowerCase7 = uu2Var2.name().toLowerCase(Locale.ROOT);
                                lowerCase7.getClass();
                                s3Var = new s3("Moving ".concat(lowerCase7), null, null);
                            }
                        }
                        if (s3Var instanceof s3) {
                            String lowerCase8 = uu2Var2.name().toLowerCase(Locale.ROOT);
                            lowerCase8.getClass();
                            return new hl2("Moving " + lowerCase8 + ", Boss.", "Gesture dispatched; final screen content state is unobservable", new c73("Swipe gesture dispatched"), null, false, 24);
                        }
                        String lowerCase9 = uu2Var2.name().toLowerCase(Locale.ROOT);
                        lowerCase9.getClass();
                        return new fl2("Unable to swipe " + lowerCase9 + ", Boss.", "Gesture dispatch failed", null, false, 12);
                    }
                } else if (upperCase.equals("DOWN")) {
                    uu2Var = uu2.b;
                    uu2Var2 = uu2Var;
                    nb2Var.getClass();
                    r2Var = nb2Var.a;
                    accessibilityServiceI = r2Var.i();
                    if (accessibilityServiceI != null) {
                        accessibilityNodeInfoC = r2Var.c();
                        rect = new Rect();
                        if (accessibilityNodeInfoC != null) {
                            accessibilityNodeInfoC.getBoundsInScreen(rect);
                            accessibilityNodeInfoC.recycle();
                        }
                        if (rect.isEmpty()) {
                            DisplayMetrics displayMetrics4 = nb2Var.b.getResources().getDisplayMetrics();
                            rect.set(0, 0, displayMetrics4.widthPixels, displayMetrics4.heightPixels);
                        }
                        f = rect.left;
                        f2 = rect.top;
                        fWidth = rect.width();
                        fHeight = rect.height();
                        iOrdinal = uu2Var2.ordinal();
                        if (iOrdinal != 0) {
                            if (iOrdinal != 1) {
                                f3 = f + (fWidth / 2.0f);
                                f4 = (0.8f * fHeight) + f2;
                                f5 = fHeight * 0.2f;
                            } else if (iOrdinal != 2) {
                                f9 = (0.2f * fWidth) + f;
                                f8 = (fHeight / 2.0f) + f2;
                                f6 = (fWidth * 0.8f) + f;
                                f7 = f8;
                            } else {
                                if (iOrdinal == 3) {
                                    dk0.l();
                                    return null;
                                }
                                float f16 = (0.8f * fWidth) + f;
                                f8 = (fHeight / 2.0f) + f2;
                                f6 = (fWidth * 0.2f) + f;
                                f7 = f8;
                                f9 = f16;
                            }
                            Path path6 = new Path();
                            path6.moveTo(f9, f8);
                            path6.lineTo(f6, f7);
                            builderAddStroke = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path6, 0L, 250L));
                            if (builderAddStroke != null) {
                                h72Var = builderAddStroke.build();
                            } else {
                                h72Var = null;
                            }
                            z = h72Var instanceof h72;
                            obj = h72Var;
                            if (z) {
                                obj = null;
                            }
                            gestureDescription = (GestureDescription) obj;
                            if (gestureDescription != null ? accessibilityServiceI.dispatchGesture(gestureDescription, null, null) : false) {
                                String lowerCase10 = uu2Var2.name().toLowerCase(Locale.ROOT);
                                lowerCase10.getClass();
                                s3Var = new s3("Moving ".concat(lowerCase10), null, null);
                            }
                        } else {
                            f3 = f + (fWidth / 2.0f);
                            f4 = (0.2f * fHeight) + f2;
                            f5 = fHeight * 0.8f;
                        }
                        f6 = f3;
                        f7 = f5 + f2;
                        f8 = f4;
                        f9 = f6;
                        Path path7 = new Path();
                        path7.moveTo(f9, f8);
                        path7.lineTo(f6, f7);
                        builderAddStroke = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path7, 0L, 250L));
                        if (builderAddStroke != null) {
                            h72Var = builderAddStroke.build();
                        } else {
                            h72Var = null;
                        }
                        z = h72Var instanceof h72;
                        obj = h72Var;
                        if (z) {
                            obj = null;
                        }
                        gestureDescription = (GestureDescription) obj;
                        if (gestureDescription != null ? accessibilityServiceI.dispatchGesture(gestureDescription, null, null) : false) {
                            String lowerCase11 = uu2Var2.name().toLowerCase(Locale.ROOT);
                            lowerCase11.getClass();
                            s3Var = new s3("Moving ".concat(lowerCase11), null, null);
                        }
                    }
                    if (s3Var instanceof s3) {
                        String lowerCase12 = uu2Var2.name().toLowerCase(Locale.ROOT);
                        lowerCase12.getClass();
                        return new hl2("Moving " + lowerCase12 + ", Boss.", "Gesture dispatched; final screen content state is unobservable", new c73("Swipe gesture dispatched"), null, false, 24);
                    }
                    String lowerCase13 = uu2Var2.name().toLowerCase(Locale.ROOT);
                    lowerCase13.getClass();
                    return new fl2("Unable to swipe " + lowerCase13 + ", Boss.", "Gesture dispatch failed", null, false, 12);
                }
            } else if (upperCase.equals("UP")) {
                uu2Var = uu2.a;
                uu2Var2 = uu2Var;
                nb2Var.getClass();
                r2Var = nb2Var.a;
                accessibilityServiceI = r2Var.i();
                if (accessibilityServiceI != null) {
                    accessibilityNodeInfoC = r2Var.c();
                    rect = new Rect();
                    if (accessibilityNodeInfoC != null) {
                        accessibilityNodeInfoC.getBoundsInScreen(rect);
                        accessibilityNodeInfoC.recycle();
                    }
                    if (rect.isEmpty()) {
                        DisplayMetrics displayMetrics5 = nb2Var.b.getResources().getDisplayMetrics();
                        rect.set(0, 0, displayMetrics5.widthPixels, displayMetrics5.heightPixels);
                    }
                    f = rect.left;
                    f2 = rect.top;
                    fWidth = rect.width();
                    fHeight = rect.height();
                    iOrdinal = uu2Var2.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal != 1) {
                            f3 = f + (fWidth / 2.0f);
                            f4 = (0.8f * fHeight) + f2;
                            f5 = fHeight * 0.2f;
                        } else if (iOrdinal != 2) {
                            f9 = (0.2f * fWidth) + f;
                            f8 = (fHeight / 2.0f) + f2;
                            f6 = (fWidth * 0.8f) + f;
                            f7 = f8;
                        } else {
                            if (iOrdinal == 3) {
                                dk0.l();
                                return null;
                            }
                            float f17 = (0.8f * fWidth) + f;
                            f8 = (fHeight / 2.0f) + f2;
                            f6 = (fWidth * 0.2f) + f;
                            f7 = f8;
                            f9 = f17;
                        }
                        Path path8 = new Path();
                        path8.moveTo(f9, f8);
                        path8.lineTo(f6, f7);
                        builderAddStroke = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path8, 0L, 250L));
                        if (builderAddStroke != null) {
                            h72Var = builderAddStroke.build();
                        } else {
                            h72Var = null;
                        }
                        z = h72Var instanceof h72;
                        obj = h72Var;
                        if (z) {
                            obj = null;
                        }
                        gestureDescription = (GestureDescription) obj;
                        if (gestureDescription != null ? accessibilityServiceI.dispatchGesture(gestureDescription, null, null) : false) {
                            String lowerCase14 = uu2Var2.name().toLowerCase(Locale.ROOT);
                            lowerCase14.getClass();
                            s3Var = new s3("Moving ".concat(lowerCase14), null, null);
                        }
                    } else {
                        f3 = f + (fWidth / 2.0f);
                        f4 = (0.2f * fHeight) + f2;
                        f5 = fHeight * 0.8f;
                    }
                    f6 = f3;
                    f7 = f5 + f2;
                    f8 = f4;
                    f9 = f6;
                    Path path9 = new Path();
                    path9.moveTo(f9, f8);
                    path9.lineTo(f6, f7);
                    builderAddStroke = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path9, 0L, 250L));
                    if (builderAddStroke != null) {
                        h72Var = builderAddStroke.build();
                    } else {
                        h72Var = null;
                    }
                    z = h72Var instanceof h72;
                    obj = h72Var;
                    if (z) {
                        obj = null;
                    }
                    gestureDescription = (GestureDescription) obj;
                    if (gestureDescription != null ? accessibilityServiceI.dispatchGesture(gestureDescription, null, null) : false) {
                        String lowerCase15 = uu2Var2.name().toLowerCase(Locale.ROOT);
                        lowerCase15.getClass();
                        s3Var = new s3("Moving ".concat(lowerCase15), null, null);
                    }
                }
                if (s3Var instanceof s3) {
                    String lowerCase16 = uu2Var2.name().toLowerCase(Locale.ROOT);
                    lowerCase16.getClass();
                    return new hl2("Moving " + lowerCase16 + ", Boss.", "Gesture dispatched; final screen content state is unobservable", new c73("Swipe gesture dispatched"), null, false, 24);
                }
                String lowerCase17 = uu2Var2.name().toLowerCase(Locale.ROOT);
                lowerCase17.getClass();
                return new fl2("Unable to swipe " + lowerCase17 + ", Boss.", "Gesture dispatch failed", null, false, 12);
            }
        }
        return new fl2(cq.v("Invalid swipe direction '", upperCase, "', Boss."), "Missing or invalid direction", null, false, 12);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        if (r9 == r5) goto L32;
     */
    @Override // defpackage.bl2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(defpackage.y50 r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof defpackage.pc2
            if (r0 == 0) goto L13
            r0 = r9
            pc2 r0 = (defpackage.pc2) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            pc2 r0 = new pc2
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.e
            int r1 = r0.i
            r2 = 2
            r3 = 1
            r4 = 0
            t70 r5 = defpackage.t70.a
            if (r1 == 0) goto L35
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            defpackage.bz3.g(r9)
            goto L78
        L2b:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r8)
            return r4
        L31:
            defpackage.bz3.g(r9)
            goto L45
        L35:
            defpackage.bz3.g(r9)
            r0.i = r3
            r6 = 2000(0x7d0, double:9.88E-321)
            r2 r9 = r8.a
            java.lang.Object r9 = r9.e(r6, r0)
            if (r9 != r5) goto L45
            goto L77
        L45:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L6b
            zv1 r8 = r8.f
            android.content.Context r8 = r8.a
            boolean r8 = defpackage.dc4.b(r8)
            c32 r9 = new c32
            if (r8 == 0) goto L5c
            java.lang.String r0 = "Screen control is enabled but hasn't connected yet"
            goto L5e
        L5c:
            java.lang.String r0 = "Accessibility service is not enabled"
        L5e:
            if (r8 == 0) goto L61
            goto L67
        L61:
            np2 r8 = defpackage.np2.c
            f52 r4 = defpackage.zv1.d(r8)
        L67:
            r9.<init>(r0, r4)
            return r9
        L6b:
            r0.i = r2
            j5 r8 = r8.e
            i5 r8 = r8.b
            java.lang.Object r9 = defpackage.rn4.c(r8, r0)
            if (r9 != r5) goto L78
        L77:
            return r5
        L78:
            g5 r9 = (defpackage.g5) r9
            boolean r8 = r9.i
            if (r8 != 0) goto L91
            c32 r8 = new c32
            d52 r9 = new d52
            java.lang.String r0 = "Enable screen reading"
            java.lang.String r1 = "Allow SONIC to inspect and interact with on-screen elements."
            java.lang.String r2 = "screen_reading"
            r9.<init>(r2, r0, r1)
            java.lang.String r0 = "Screen reading is turned off in settings"
            r8.<init>(r0, r9)
            return r8
        L91:
            a32 r8 = defpackage.a32.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vc2.i(y50):java.lang.Object");
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        String str = f5Var.a;
        if (g31.a(str, "screen.read")) {
            return "Read the screen?";
        }
        if (g31.a(str, "screen.deep_analyze")) {
            String strC = f5Var.c("target");
            return strC != null ? cq.v("Deep analyze and click ", strC, "?") : "Deep analyze screen?";
        }
        if (g31.a(str, "screen.click")) {
            String strC2 = f5Var.c("target");
            return strC2 != null ? cq.v("Click ", strC2, "?") : "Click on-screen element?";
        }
        if (g31.a(str, "screen.type")) {
            String strC3 = f5Var.c("text");
            return strC3 != null ? cq.v("Type '", strC3, "'?") : "Type text?";
        }
        if (g31.a(str, "screen.scroll")) {
            return "Scroll the screen?";
        }
        if (g31.a(str, "screen.swipe")) {
            String strC4 = f5Var.c("direction");
            return strC4 != null ? cq.v("Swipe ", strC4, "?") : "Swipe screen?";
        }
        if (g31.a(str, "screen.back")) {
            return "Go back?";
        }
        if (g31.a(str, "screen.home")) {
            return "Go to home screen?";
        }
        if (g31.a(str, "youtube.like")) {
            return "Like this video?";
        }
        if (g31.a(str, "youtube.dislike")) {
            return "Dislike this video?";
        }
        if (g31.a(str, "youtube.subscribe")) {
            return "Subscribe to this channel?";
        }
        if (g31.a(str, "youtube.skip_ad")) {
            return "Skip the ad?";
        }
        return null;
    }

    @Override // defpackage.bl2
    public final List k() {
        return this.k;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.l;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "Screen Control";
    }

    public final fc2 p() {
        AccessibilityNodeInfo accessibilityNodeInfoB = this.a.b();
        fc2 fc2Var = null;
        if (accessibilityNodeInfoB == null) {
            return null;
        }
        try {
            CharSequence packageName = accessibilityNodeInfoB.getPackageName();
            String string = packageName != null ? packageName.toString() : null;
            if (string == null) {
                string = "";
            }
            Rect rect = new Rect();
            accessibilityNodeInfoB.getBoundsInScreen(rect);
            if (!cs2.A(string) && rect.right > rect.left && rect.bottom > rect.top) {
                fc2Var = new fc2(string, accessibilityNodeInfoB.getWindowId(), rect);
            }
            return fc2Var;
        } finally {
            accessibilityNodeInfoB.recycle();
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02c2 A[LOOP:7: B:101:0x02bc->B:103:0x02c2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x02d4 A[Catch: all -> 0x0873, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0873, blocks: (B:97:0x02a2, B:108:0x02d4, B:113:0x02e2, B:115:0x02ec, B:117:0x02f2, B:120:0x02fd, B:125:0x030a, B:124:0x0306), top: B:339:0x02a2 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x02da A[Catch: all -> 0x02cd, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x02cd, blocks: (B:99:0x02aa, B:110:0x02da, B:122:0x0303), top: B:349:0x02a8 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:175:0x0471  */
    /* JADX WARN: Code duplicated, block: B:178:0x0496  */
    /* JADX WARN: Code duplicated, block: B:181:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:183:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:184:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:216:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:217:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:224:0x060c  */
    /* JADX WARN: Code duplicated, block: B:227:0x061b  */
    /* JADX WARN: Code duplicated, block: B:229:0x061e  */
    /* JADX WARN: Code duplicated, block: B:230:0x0626  */
    /* JADX WARN: Code duplicated, block: B:233:0x062a  */
    /* JADX WARN: Code duplicated, block: B:235:0x0630  */
    /* JADX WARN: Code duplicated, block: B:237:0x0655  */
    /* JADX WARN: Code duplicated, block: B:239:0x0659  */
    /* JADX WARN: Code duplicated, block: B:280:0x0759  */
    /* JADX WARN: Code duplicated, block: B:286:0x0769  */
    /* JADX WARN: Code duplicated, block: B:288:0x076e A[Catch: all -> 0x0762, TRY_LEAVE, TryCatch #1 {all -> 0x0762, blocks: (B:309:0x0828, B:281:0x075c, B:288:0x076e, B:294:0x07ae), top: B:338:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:292:0x07a3 A[LOOP:1: B:290:0x079d->B:292:0x07a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:294:0x07ae A[Catch: all -> 0x0762, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0762, blocks: (B:309:0x0828, B:281:0x075c, B:288:0x076e, B:294:0x07ae), top: B:338:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:298:0x07ee A[LOOP:2: B:296:0x07e8->B:298:0x07ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:321:0x0868 A[LOOP:0: B:319:0x0862->B:321:0x0868, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:329:0x0890 A[LOOP:13: B:327:0x088a->B:329:0x0890, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:334:0x08af A[LOOP:3: B:332:0x08a9->B:334:0x08af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:343:0x0732 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:362:0x024b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:364:0x0238 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:378:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:381:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x017d  */
    /* JADX WARN: Code duplicated, block: B:50:0x018d  */
    /* JADX WARN: Code duplicated, block: B:71:0x01f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:73:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:76:0x0202  */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0212  */
    /* JADX WARN: Code duplicated, block: B:87:0x023a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0266 A[LOOP:6: B:91:0x0260->B:93:0x0266, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x0293  */
    /* JADX WARN: Code duplicated, block: B:99:0x02aa A[Catch: all -> 0x02cd, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x02cd, blocks: (B:99:0x02aa, B:110:0x02da, B:122:0x0303), top: B:349:0x02a8 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:235:0x0630, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:239:0x0659, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:288:0x076e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:294:0x07ae, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [f5] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [t42] */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r1v81 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r31v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r33v0, types: [vc2] */
    /* JADX WARN: Type inference failed for: r8v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v29 */
    public final Object q(f5 f5Var, boolean z, fc2 fc2Var, y50 y50Var) {
        hc2 hc2Var;
        xc2 xc2Var;
        ?? r2;
        ?? r1;
        Iterator it;
        String strC;
        String str;
        fc2 fc2Var2;
        f5 f5Var2;
        Object obj;
        ?? r3;
        xb2 xb2Var;
        wc2 wc2Var;
        fc2 fc2VarP;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean zContains;
        List list;
        List listJ;
        t42 t42Var;
        Object string;
        Object obj2;
        AccessibilityNodeInfo accessibilityNodeInfo;
        CharSequence packageName;
        Iterator it2;
        int i;
        v3 t3Var;
        wc2 wc2Var2;
        fl2 fl2Var;
        wc2 wc2Var3;
        Object gl2Var;
        String str8;
        String strT;
        Object obj3;
        boolean z2;
        t70 t70Var;
        f5 f5Var3;
        String str9;
        wc2 wc2Var4;
        String str10;
        String str11;
        t70 t70Var2;
        hc2 hc2Var2;
        String str12;
        String str13;
        v3 v3VarC;
        List list2;
        jl2 fl2Var2;
        Object objB;
        t42 t42Var2;
        wc2 wc2Var5;
        String str14;
        int i2;
        List list3;
        Iterator it3;
        List list4;
        ArrayList arrayList;
        HashSet hashSet;
        ArrayList arrayList2;
        int size;
        int i3;
        ArrayList arrayList3;
        Object obj4;
        ob2 ob2Var;
        String str15;
        ?? r8;
        Object objG;
        v3 v3Var;
        List list5;
        t42 t42Var3;
        d73 d73Var;
        Iterator it4;
        Iterator it5;
        Iterator it6;
        d73 d73Var2;
        Object objG2;
        Object obj5;
        v3 v3Var2;
        String strD;
        ?? r4 = f5Var;
        ?? r5 = z;
        if (y50Var instanceof hc2) {
            hc2Var = (hc2) y50Var;
            int i4 = hc2Var.H;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                hc2Var.H = i4 - Integer.MIN_VALUE;
            } else {
                hc2Var = new hc2(this, y50Var);
            }
        } else {
            hc2Var = new hc2(this, y50Var);
        }
        Object obj6 = hc2Var.w;
        int i5 = hc2Var.H;
        uv1 uv1Var = this.h;
        xb2 xb2Var2 = this.b;
        nb2 nb2Var = this.c;
        xc2 xc2Var2 = this.i;
        t70 t70Var3 = t70.a;
        try {
            try {
                switch (i5) {
                    case 0:
                        bz3.g(obj6);
                        strC = r4.c("target");
                        if (strC == null) {
                            return new fl2("Which button or text should I click, Boss?", "Missing target slot", null, false, 12);
                        }
                        if (nb2Var.s(strC)) {
                            hc2Var.e = null;
                            hc2Var.f = null;
                            hc2Var.i = null;
                            hc2Var.u = r5;
                            hc2Var.H = 1;
                            Object objW = w(hc2Var);
                            if (objW != t70Var3) {
                                return objW;
                            }
                        } else {
                            str = "I found ";
                            hc2Var.e = r4;
                            fc2Var2 = fc2Var;
                            hc2Var.f = fc2Var2;
                            hc2Var.i = strC;
                            hc2Var.u = r5;
                            hc2Var.H = 2;
                            Object objB2 = xb2Var2.b(hc2Var);
                            if (objB2 != t70Var3) {
                                f5Var2 = f5Var;
                                obj = objB2;
                                r3 = r5;
                                xb2Var = xb2Var2;
                                wc2Var = (wc2) obj;
                                fc2VarP = p();
                                if (fc2VarP == null) {
                                    return new fl2("The active app isn't exposing its controls yet.", "No active window after bounded read", null, false, 12);
                                }
                                str2 = "Activation accepted without matching destination evidence";
                                int i6 = fc2VarP.b;
                                str3 = ", but couldn't confirm the requested view opened.";
                                str4 = fc2VarP.a;
                                str5 = "I tapped ";
                                if (wc2Var == null && !g31.a(wc2Var.a, str4)) {
                                    return n("active app changed");
                                }
                                if (fc2Var2 == null && (!D(fc2Var2, fc2VarP) || (wc2Var != null && !g31.a(wc2Var.a, fc2Var2.a)))) {
                                    return n("active app changed");
                                }
                                if (wc2Var != null && (str15 = wc2Var.a) != null) {
                                    str4 = str15;
                                }
                                String strA = uz3.a(wc2Var);
                                str6 = "Clicked ";
                                str7 = ", Boss.";
                                Set setC = wh2.c("button", "this button", "that button", "this", "that");
                                String lowerCase = strC.toLowerCase(Locale.ROOT);
                                lowerCase.getClass();
                                zContains = setC.contains(lowerCase);
                                list = ii0.a;
                                if (zContains) {
                                    if (wc2Var != null) {
                                        list4 = wc2Var.c;
                                    } else {
                                        list4 = null;
                                    }
                                    if (list4 != null) {
                                        list = list4;
                                    }
                                    arrayList = new ArrayList();
                                    for (Object obj7 : list) {
                                        ob2Var = (ob2) obj7;
                                        if (!ob2Var.e && !cs2.A(ob2Var.a)) {
                                            arrayList.add(obj7);
                                        }
                                    }
                                    hashSet = new HashSet();
                                    arrayList2 = new ArrayList();
                                    size = arrayList.size();
                                    i3 = 0;
                                    while (i3 < size) {
                                        obj4 = arrayList.get(i3);
                                        i3++;
                                        if (hashSet.add(((ob2) obj4).a)) {
                                            arrayList2.add(obj4);
                                        }
                                    }
                                    List<ob2> listL = mz.L(arrayList2, 6);
                                    arrayList3 = new ArrayList(nz.d(listL));
                                    for (ob2 ob2Var2 : listL) {
                                        arrayList3.add(new zx(cs2.T(80, ob2Var2.a), ob2Var2.a, (String) null, 12));
                                    }
                                    return new gl2("Which button should I click?", new yx("Which button should I click?", "target", arrayList3, "screen.click", f5Var2.b));
                                }
                                listJ = nz.j(this.a.b());
                                t42Var = new t42();
                                try {
                                    accessibilityNodeInfo = (AccessibilityNodeInfo) mz.I(listJ);
                                    try {
                                        if (accessibilityNodeInfo == null) {
                                            fl2 fl2VarO = o(this);
                                            ew2 ew2Var = (ew2) t42Var.a;
                                            xc2Var2.getClass();
                                            xc2.b(ew2Var, listJ);
                                            it3 = listJ.iterator();
                                            while (it3.hasNext()) {
                                                ((AccessibilityNodeInfo) it3.next()).recycle();
                                            }
                                            return fl2VarO;
                                        }
                                        packageName = accessibilityNodeInfo.getPackageName();
                                        if (packageName != null) {
                                            string = packageName.toString();
                                        } else {
                                            string = null;
                                        }
                                        try {
                                            if (g31.a(string, fc2VarP.a()) || accessibilityNodeInfo.getWindowId() != i6 || !C(fc2VarP)) {
                                                fl2 fl2VarO2 = o(this);
                                                ew2 ew2Var2 = (ew2) t42Var.a;
                                                xc2Var2.getClass();
                                                xc2.b(ew2Var2, listJ);
                                                it2 = listJ.iterator();
                                                while (it2.hasNext()) {
                                                    ((AccessibilityNodeInfo) it2.next()).recycle();
                                                }
                                                return fl2VarO2;
                                            }
                                            Object objK = nb2Var.E(strC, str4) ? dw2.a : xc2.k(xc2Var2, strC, listJ);
                                            t42Var.a = objK;
                                            String str16 = str4;
                                            try {
                                                if (!(objK instanceof bw2)) {
                                                    try {
                                                        if (!(objK instanceof aw2)) {
                                                            ?? r31 = r3;
                                                            if (objK instanceof zv2) {
                                                                r3 r3VarQ = nb2Var.q(strC, ((zv2) objK).b, ((zv2) objK).a);
                                                                List list6 = r3VarQ.b;
                                                                ArrayList arrayList4 = new ArrayList(nz.d(list6));
                                                                Iterator it7 = list6.iterator();
                                                                int i7 = 0;
                                                                while (it7.hasNext()) {
                                                                    Object next = it7.next();
                                                                    int i8 = i7 + 1;
                                                                    if (i7 < 0) {
                                                                        nz.n();
                                                                        throw null;
                                                                    }
                                                                    arrayList4.add(new zx(((String) next) + ", match " + i8, (String) r3VarQ.c.get(i7), (String) null, 12));
                                                                    it7 = it7;
                                                                    r3VarQ = r3VarQ;
                                                                    i7 = i8;
                                                                }
                                                                gl2 gl2Var2 = new gl2("I found multiple matches for " + strC + ", Boss. Which one?", new yx("Which " + strC + "?", "target", arrayList4, "screen.click", f5Var2.b));
                                                                ew2 ew2Var3 = (ew2) t42Var.a;
                                                                xc2Var2.getClass();
                                                                xc2.b(ew2Var3, listJ);
                                                                Iterator it8 = listJ.iterator();
                                                                while (it8.hasNext()) {
                                                                    ((AccessibilityNodeInfo) it8.next()).recycle();
                                                                }
                                                                return gl2Var2;
                                                            }
                                                            i = (!(objK instanceof cw2) || ((cw2) objK).b == null) ? 0 : 1;
                                                            ew2 ew2Var4 = (ew2) t42Var.a;
                                                            xc2Var2.getClass();
                                                            xc2.b(ew2Var4, listJ);
                                                            Iterator it9 = listJ.iterator();
                                                            while (it9.hasNext()) {
                                                                ((AccessibilityNodeInfo) it9.next()).recycle();
                                                            }
                                                            if (!C(fc2VarP)) {
                                                                return o(this);
                                                            }
                                                            t3Var = i != 0 ? new t3(strC, list) : nb2Var.b(strC);
                                                            if (t3Var instanceof s3) {
                                                                hc2Var.e = f5Var2;
                                                                hc2Var.f = null;
                                                                hc2Var.i = strC;
                                                                hc2Var.j = wc2Var;
                                                                hc2Var.k = null;
                                                                hc2Var.n = null;
                                                                hc2Var.s = t3Var;
                                                                z2 = r31 == true ? 1 : 0;
                                                                hc2Var.u = z2;
                                                                hc2Var.v = i;
                                                                hc2Var.H = 6;
                                                                t70Var = t70Var3;
                                                                if (bm4.b(250L, hc2Var) == t70Var) {
                                                                    return t70Var;
                                                                }
                                                                f5Var3 = f5Var2;
                                                                str9 = strC;
                                                                wc2Var4 = wc2Var;
                                                                if (wc2Var4 != null) {
                                                                    String strA2 = ((s3) t3Var).a();
                                                                    hc2Var.e = f5Var3;
                                                                    hc2Var.f = null;
                                                                    hc2Var.i = null;
                                                                    hc2Var.j = wc2Var4;
                                                                    hc2Var.k = null;
                                                                    hc2Var.n = null;
                                                                    hc2Var.s = t3Var;
                                                                    hc2Var.u = z2;
                                                                    hc2Var.v = i;
                                                                    hc2Var.H = 7;
                                                                    objG2 = G(str9, wc2Var4, strA2, hc2Var);
                                                                    if (objG2 == t70Var) {
                                                                        return t70Var;
                                                                    }
                                                                    v3 v3Var3 = t3Var;
                                                                    obj5 = objG2;
                                                                    v3Var2 = v3Var3;
                                                                    d73Var2 = (d73) obj5;
                                                                    t3Var = v3Var2;
                                                                } else {
                                                                    d73Var2 = null;
                                                                }
                                                                wc2Var3 = wc2Var4;
                                                                f5Var2 = f5Var3;
                                                                if (d73Var2 != null) {
                                                                    uv1Var.a();
                                                                    gl2Var = new il2(cq.v(str6, ((s3) t3Var).a(), str7), d73Var2, null, null, 12);
                                                                } else {
                                                                    uv1Var.a();
                                                                    gl2Var = new hl2(cq.v(str5, ((s3) t3Var).a(), str3), "Requested destination is not yet visible", new c73(str2), null, false, 24);
                                                                }
                                                            } else if (t3Var instanceof r3) {
                                                                r3 r3Var = (r3) t3Var;
                                                                List list7 = r3Var.b;
                                                                ArrayList arrayList5 = new ArrayList(nz.d(list7));
                                                                int i9 = 0;
                                                                for (Object obj8 : list7) {
                                                                    int i10 = i9 + 1;
                                                                    if (i9 < 0) {
                                                                        nz.n();
                                                                        throw null;
                                                                    }
                                                                    arrayList5.add(new zx(((String) obj8) + ", match " + i10, (String) r3Var.c.get(i9), (String) null, 12));
                                                                    i9 = i10;
                                                                }
                                                                gl2Var = new gl2(cq.v("I found multiple matches for ", strC, ", Boss. Which one?"), new yx(cq.v("Which ", strC, "?"), "target", arrayList5, "screen.click", f5Var2.b));
                                                                wc2Var3 = wc2Var;
                                                            } else {
                                                                if (!(t3Var instanceof t3)) {
                                                                    wc2Var2 = wc2Var;
                                                                    if (!(t3Var instanceof u3)) {
                                                                        throw new b10();
                                                                    }
                                                                    fl2Var = new fl2("Screen control was interrupted.", "Accessibility service disconnected during activation", null, false, 12);
                                                                } else if (r31 != 0) {
                                                                    hc2Var.e = f5Var2;
                                                                    hc2Var.f = null;
                                                                    hc2Var.i = null;
                                                                    hc2Var.j = wc2Var;
                                                                    hc2Var.k = null;
                                                                    hc2Var.n = null;
                                                                    hc2Var.s = null;
                                                                    hc2Var.u = r31;
                                                                    hc2Var.v = i;
                                                                    hc2Var.H = 8;
                                                                    Object objB3 = B(f5Var2, strC, wc2Var, fc2VarP, hc2Var);
                                                                    f5 f5Var4 = f5Var2;
                                                                    if (objB3 == t70Var3) {
                                                                        return t70Var3;
                                                                    }
                                                                    obj3 = objB3;
                                                                    wc2Var3 = wc2Var;
                                                                    f5Var2 = f5Var4;
                                                                    gl2Var = (jl2) obj3;
                                                                } else {
                                                                    String str17 = strC;
                                                                    wc2Var2 = wc2Var;
                                                                    fc2 fc2VarP2 = p();
                                                                    if (fc2VarP2 != null) {
                                                                        str8 = str16;
                                                                        if (!fc2VarP2.a.equals(str8)) {
                                                                            fc2VarP2 = null;
                                                                        }
                                                                        Integer numValueOf = fc2VarP2 != null ? Integer.valueOf(fc2VarP2.b) : null;
                                                                        String strG = uz3.g(wc2Var2);
                                                                        Map mapSingletonMap = Collections.singletonMap("target", str17);
                                                                        mapSingletonMap.getClass();
                                                                        if (wc2Var2 != null) {
                                                                            strT = yc3.t(wc2Var2);
                                                                        } else {
                                                                            strT = null;
                                                                        }
                                                                        this.h.d(str17, str8, strA, "screen.click", numValueOf, strG, mapSingletonMap, strT);
                                                                        fl2Var = new fl2(cq.v("I couldn't locate an actionable ", str17, " on this screen."), "Target unavailable after bounded screen analysis", null, false, 12);
                                                                    } else {
                                                                        str8 = str16;
                                                                    }
                                                                    String strG2 = uz3.g(wc2Var2);
                                                                    Map mapSingletonMap2 = Collections.singletonMap("target", str17);
                                                                    mapSingletonMap2.getClass();
                                                                    if (wc2Var2 != null) {
                                                                        strT = yc3.t(wc2Var2);
                                                                    } else {
                                                                        strT = null;
                                                                    }
                                                                    this.h.d(str17, str8, strA, "screen.click", numValueOf, strG2, mapSingletonMap2, strT);
                                                                    fl2Var = new fl2(cq.v("I couldn't locate an actionable ", str17, " on this screen."), "Target unavailable after bounded screen analysis", null, false, 12);
                                                                }
                                                                wc2Var3 = wc2Var2;
                                                                gl2Var = fl2Var;
                                                                f5Var2 = f5Var2;
                                                            }
                                                            if (wc2Var3 == null) {
                                                                strD = null;
                                                            } else {
                                                                if (!g31.a(f5Var2.c("summarise_first"), "true")) {
                                                                    wc2Var3 = null;
                                                                }
                                                                if (wc2Var3 != null) {
                                                                    xb2Var.getClass();
                                                                    strD = xb2.d(wc2Var3);
                                                                } else {
                                                                    strD = null;
                                                                }
                                                            }
                                                            if (strD != null) {
                                                                if (gl2Var instanceof il2) {
                                                                    il2 il2Var = (il2) gl2Var;
                                                                    String str18 = strD + Padder.FALLBACK_PADDING_STRING + il2Var.a;
                                                                    d73 d73Var3 = il2Var.b;
                                                                    n43 n43Var = il2Var.c;
                                                                    String str19 = il2Var.d;
                                                                    d73Var3.getClass();
                                                                    return new il2(str18, d73Var3, n43Var, str19);
                                                                }
                                                                if (gl2Var instanceof hl2) {
                                                                    hl2 hl2Var = (hl2) gl2Var;
                                                                    String str20 = strD + Padder.FALLBACK_PADDING_STRING + hl2Var.a;
                                                                    String str21 = hl2Var.b;
                                                                    e73 e73Var = hl2Var.c;
                                                                    h52 h52Var = hl2Var.d;
                                                                    boolean z3 = hl2Var.e;
                                                                    str21.getClass();
                                                                    e73Var.getClass();
                                                                    return new hl2(str20, str21, e73Var, h52Var, z3);
                                                                }
                                                            }
                                                            return gl2Var;
                                                        }
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        xc2Var = xc2Var2;
                                                        obj2 = listJ;
                                                    }
                                                }
                                                f5 f5Var5 = f5Var2;
                                                ?? r9 = r3;
                                                xc2Var = xc2Var2;
                                                str10 = str3;
                                                str11 = str5;
                                                t70Var2 = t70Var3;
                                                hc2Var2 = hc2Var;
                                                String str22 = strC;
                                                str12 = str7;
                                                str13 = str6;
                                                try {
                                                    String str23 = objK instanceof bw2 ? ((bw2) objK).b : ((aw2) objK).b;
                                                    if (!C(fc2VarP)) {
                                                        fl2 fl2VarO3 = o(this);
                                                        ew2 ew2Var5 = (ew2) t42Var.a;
                                                        xc2Var.getClass();
                                                        xc2.b(ew2Var5, listJ);
                                                        Iterator it10 = listJ.iterator();
                                                        while (it10.hasNext()) {
                                                            ((AccessibilityNodeInfo) it10.next()).recycle();
                                                        }
                                                        return fl2VarO3;
                                                    }
                                                    if (!(objK instanceof bw2)) {
                                                        v3VarC = nb2Var.c(((aw2) objK).a, str23, fc2VarP.a(), i6);
                                                    } else if (((bw2) objK).d) {
                                                        v3VarC = nb2Var.d(((bw2) objK).a, str23);
                                                    } else {
                                                        AccessibilityNodeInfo accessibilityNodeInfo2 = ((bw2) objK).a;
                                                        accessibilityNodeInfo2.getClass();
                                                        str23.getClass();
                                                        v3VarC = nb2Var.e(accessibilityNodeInfo2, str23, false, null);
                                                    }
                                                    if (!(v3VarC instanceof s3)) {
                                                        if (r9 != 0) {
                                                            hc2Var2.e = null;
                                                            hc2Var2.f = null;
                                                            hc2Var2.i = null;
                                                            hc2Var2.j = null;
                                                            hc2Var2.k = listJ;
                                                            hc2Var2.n = t42Var;
                                                            hc2Var2.s = null;
                                                            hc2Var2.t = null;
                                                            hc2Var2.u = r9;
                                                            hc2Var2.v = 0;
                                                            hc2Var2.H = 5;
                                                            objB = B(f5Var5, str22, wc2Var, fc2VarP, hc2Var2);
                                                            if (objB == t70Var2) {
                                                                return t70Var2;
                                                            }
                                                            list2 = listJ;
                                                            t42Var2 = t42Var;
                                                            fl2Var2 = (jl2) objB;
                                                            t42Var = t42Var2;
                                                        } else {
                                                            list2 = listJ;
                                                            fl2Var2 = new fl2(str + str23 + ", but it changed or couldn't be activated.", "Grounded control activation failed", null, false, 12);
                                                        }
                                                        ew2 ew2Var6 = (ew2) t42Var.a;
                                                        xc2Var.getClass();
                                                        xc2.b(ew2Var6, list2);
                                                        it6 = list2.iterator();
                                                        while (it6.hasNext()) {
                                                            ((AccessibilityNodeInfo) it6.next()).recycle();
                                                        }
                                                        return fl2Var2;
                                                    }
                                                    hc2Var2.e = null;
                                                    hc2Var2.f = null;
                                                    hc2Var2.i = str22;
                                                    hc2Var2.j = wc2Var;
                                                    hc2Var2.k = listJ;
                                                    hc2Var2.n = t42Var;
                                                    hc2Var2.s = null;
                                                    hc2Var2.t = v3VarC;
                                                    hc2Var2.u = r9;
                                                    hc2Var2.v = 0;
                                                    hc2Var2.H = 3;
                                                    if (bm4.b(250L, hc2Var2) == t70Var2) {
                                                        return t70Var2;
                                                    }
                                                    wc2Var5 = wc2Var;
                                                    str14 = str22;
                                                    i2 = 0;
                                                    list3 = listJ;
                                                    r8 = r9;
                                                    if (wc2Var5 != null) {
                                                        try {
                                                            String strA3 = ((s3) v3VarC).a();
                                                            hc2Var2.e = null;
                                                            hc2Var2.f = null;
                                                            hc2Var2.i = null;
                                                            hc2Var2.j = null;
                                                            hc2Var2.k = list3;
                                                            hc2Var2.n = t42Var;
                                                            hc2Var2.s = null;
                                                            hc2Var2.t = v3VarC;
                                                            hc2Var2.u = r8;
                                                            hc2Var2.v = i2;
                                                            hc2Var2.H = 4;
                                                            objG = G(str14, wc2Var5, strA3, hc2Var2);
                                                            if (objG == t70Var2) {
                                                                return t70Var2;
                                                            }
                                                            v3Var = v3VarC;
                                                            list5 = list3;
                                                            t42Var3 = t42Var;
                                                            v3VarC = v3Var;
                                                            d73Var = (d73) objG;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            obj2 = list3;
                                                        }
                                                    } else {
                                                        list5 = list3;
                                                        t42Var3 = t42Var;
                                                        d73Var = null;
                                                    }
                                                    if (d73Var != null) {
                                                        uv1Var.a();
                                                        il2 il2Var2 = new il2(str13 + ((s3) v3VarC).a() + str12, d73Var, null, null, 12);
                                                        ew2 ew2Var7 = (ew2) t42Var3.a;
                                                        xc2Var.getClass();
                                                        xc2.b(ew2Var7, list5);
                                                        it5 = list5.iterator();
                                                        while (it5.hasNext()) {
                                                            ((AccessibilityNodeInfo) it5.next()).recycle();
                                                        }
                                                        return il2Var2;
                                                    }
                                                    uv1Var.a();
                                                    hl2 hl2Var2 = new hl2(str11 + ((s3) v3VarC).a() + str10, "Requested destination is not yet visible", new c73(str2), null, false, 24);
                                                    ew2 ew2Var8 = (ew2) t42Var3.a;
                                                    xc2Var.getClass();
                                                    xc2.b(ew2Var8, list5);
                                                    it4 = list5.iterator();
                                                    while (it4.hasNext()) {
                                                        ((AccessibilityNodeInfo) it4.next()).recycle();
                                                    }
                                                    return hl2Var2;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    string = listJ;
                                                    obj2 = string;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        obj2 = listJ;
                                        xc2Var = xc2Var2;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    string = listJ;
                                    xc2Var = xc2Var2;
                                }
                                obj2 = string;
                                r1 = t42Var;
                                r2 = obj2;
                                ew2 ew2Var9 = (ew2) r1.a;
                                xc2Var.getClass();
                                xc2.b(ew2Var9, r2);
                                it = r2.iterator();
                                while (it.hasNext()) {
                                    ((AccessibilityNodeInfo) it.next()).recycle();
                                }
                                throw th;
                            }
                        }
                        return t70Var3;
                    case 1:
                        bz3.g(obj6);
                        return obj6;
                    case 2:
                        boolean z4 = hc2Var.u;
                        String str24 = hc2Var.i;
                        fc2 fc2Var3 = hc2Var.f;
                        f5Var2 = hc2Var.e;
                        bz3.g(obj6);
                        fc2Var2 = fc2Var3;
                        obj = obj6;
                        strC = str24;
                        r3 = z4;
                        str = "I found ";
                        xb2Var = xb2Var2;
                        wc2Var = (wc2) obj;
                        fc2VarP = p();
                        if (fc2VarP == null) {
                            return new fl2("The active app isn't exposing its controls yet.", "No active window after bounded read", null, false, 12);
                        }
                        str2 = "Activation accepted without matching destination evidence";
                        int i11 = fc2VarP.b;
                        str3 = ", but couldn't confirm the requested view opened.";
                        str4 = fc2VarP.a;
                        str5 = "I tapped ";
                        if (wc2Var == null) {
                            break;
                        }
                        if (fc2Var2 == null) {
                            break;
                        }
                        if (wc2Var != null) {
                            str4 = str15;
                        }
                        String strA4 = uz3.a(wc2Var);
                        str6 = "Clicked ";
                        str7 = ", Boss.";
                        Set setC2 = wh2.c("button", "this button", "that button", "this", "that");
                        String lowerCase2 = strC.toLowerCase(Locale.ROOT);
                        lowerCase2.getClass();
                        zContains = setC2.contains(lowerCase2);
                        list = ii0.a;
                        if (zContains) {
                            if (wc2Var != null) {
                                list4 = wc2Var.c;
                            } else {
                                list4 = null;
                            }
                            if (list4 != null) {
                                list = list4;
                            }
                            arrayList = new ArrayList();
                            while (r2.hasNext()) {
                                ob2Var = (ob2) obj7;
                                if (!ob2Var.e) {
                                }
                            }
                            hashSet = new HashSet();
                            arrayList2 = new ArrayList();
                            size = arrayList.size();
                            i3 = 0;
                            while (i3 < size) {
                                obj4 = arrayList.get(i3);
                                i3++;
                                if (hashSet.add(((ob2) obj4).a)) {
                                    arrayList2.add(obj4);
                                }
                            }
                            List<ob2> listL2 = mz.L(arrayList2, 6);
                            arrayList3 = new ArrayList(nz.d(listL2));
                            while (r0.hasNext()) {
                                arrayList3.add(new zx(cs2.T(80, ob2Var2.a), ob2Var2.a, (String) null, 12));
                            }
                            return new gl2("Which button should I click?", new yx("Which button should I click?", "target", arrayList3, "screen.click", f5Var2.b));
                        }
                        listJ = nz.j(this.a.b());
                        t42Var = new t42();
                        accessibilityNodeInfo = (AccessibilityNodeInfo) mz.I(listJ);
                        if (accessibilityNodeInfo == null) {
                            fl2 fl2VarO4 = o(this);
                            ew2 ew2Var10 = (ew2) t42Var.a;
                            xc2Var2.getClass();
                            xc2.b(ew2Var10, listJ);
                            it3 = listJ.iterator();
                            while (it3.hasNext()) {
                                ((AccessibilityNodeInfo) it3.next()).recycle();
                            }
                            return fl2VarO4;
                        }
                        packageName = accessibilityNodeInfo.getPackageName();
                        if (packageName != null) {
                            string = packageName.toString();
                        } else {
                            string = null;
                        }
                        if (g31.a(string, fc2VarP.a())) {
                            break;
                        }
                        fl2 fl2VarO5 = o(this);
                        ew2 ew2Var11 = (ew2) t42Var.a;
                        xc2Var2.getClass();
                        xc2.b(ew2Var11, listJ);
                        it2 = listJ.iterator();
                        while (it2.hasNext()) {
                            ((AccessibilityNodeInfo) it2.next()).recycle();
                        }
                        return fl2VarO5;
                        obj2 = string;
                        r1 = t42Var;
                        r2 = obj2;
                        ew2 ew2Var12 = (ew2) r1.a;
                        xc2Var.getClass();
                        xc2.b(ew2Var12, r2);
                        it = r2.iterator();
                        while (it.hasNext()) {
                            ((AccessibilityNodeInfo) it.next()).recycle();
                        }
                        throw th;
                    case 3:
                        int i12 = hc2Var.v;
                        boolean z5 = hc2Var.u;
                        v3VarC = hc2Var.t;
                        t42 t42Var4 = hc2Var.n;
                        list3 = hc2Var.k;
                        wc2Var5 = hc2Var.j;
                        str14 = hc2Var.i;
                        try {
                            bz3.g(obj6);
                            str2 = "Activation accepted without matching destination evidence";
                            str10 = ", but couldn't confirm the requested view opened.";
                            uv1Var = uv1Var;
                            xc2Var = xc2Var2;
                            str11 = "I tapped ";
                            r8 = z5;
                            hc2Var2 = hc2Var;
                            t42Var = t42Var4;
                            str12 = ", Boss.";
                            i2 = i12;
                            str13 = "Clicked ";
                            t70Var2 = t70Var3;
                            if (wc2Var5 != null) {
                                String strA5 = ((s3) v3VarC).a();
                                hc2Var2.e = null;
                                hc2Var2.f = null;
                                hc2Var2.i = null;
                                hc2Var2.j = null;
                                hc2Var2.k = list3;
                                hc2Var2.n = t42Var;
                                hc2Var2.s = null;
                                hc2Var2.t = v3VarC;
                                hc2Var2.u = r8;
                                hc2Var2.v = i2;
                                hc2Var2.H = 4;
                                objG = G(str14, wc2Var5, strA5, hc2Var2);
                                if (objG == t70Var2) {
                                    return t70Var2;
                                }
                                v3Var = v3VarC;
                                list5 = list3;
                                t42Var3 = t42Var;
                                v3VarC = v3Var;
                                d73Var = (d73) objG;
                            } else {
                                list5 = list3;
                                t42Var3 = t42Var;
                                d73Var = null;
                            }
                            if (d73Var != null) {
                                uv1Var.a();
                                il2 il2Var3 = new il2(str13 + ((s3) v3VarC).a() + str12, d73Var, null, null, 12);
                                ew2 ew2Var13 = (ew2) t42Var3.a;
                                xc2Var.getClass();
                                xc2.b(ew2Var13, list5);
                                it5 = list5.iterator();
                                while (it5.hasNext()) {
                                    ((AccessibilityNodeInfo) it5.next()).recycle();
                                }
                                return il2Var3;
                            }
                            uv1Var.a();
                            hl2 hl2Var3 = new hl2(str11 + ((s3) v3VarC).a() + str10, "Requested destination is not yet visible", new c73(str2), null, false, 24);
                            ew2 ew2Var14 = (ew2) t42Var3.a;
                            xc2Var.getClass();
                            xc2.b(ew2Var14, list5);
                            it4 = list5.iterator();
                            while (it4.hasNext()) {
                                ((AccessibilityNodeInfo) it4.next()).recycle();
                            }
                            return hl2Var3;
                        } catch (Throwable th8) {
                            th = th8;
                            r4 = t42Var4;
                            r5 = list3;
                            xc2Var = xc2Var2;
                            r1 = r4;
                            r2 = r5;
                            ew2 ew2Var15 = (ew2) r1.a;
                            xc2Var.getClass();
                            xc2.b(ew2Var15, r2);
                            it = r2.iterator();
                            while (it.hasNext()) {
                                ((AccessibilityNodeInfo) it.next()).recycle();
                            }
                            throw th;
                        }
                    case 4:
                        v3Var = hc2Var.t;
                        t42Var3 = hc2Var.n;
                        list5 = hc2Var.k;
                        bz3.g(obj6);
                        str13 = "Clicked ";
                        str2 = "Activation accepted without matching destination evidence";
                        str10 = ", but couldn't confirm the requested view opened.";
                        str12 = ", Boss.";
                        xc2Var = xc2Var2;
                        str11 = "I tapped ";
                        objG = obj6;
                        uv1Var = uv1Var;
                        v3VarC = v3Var;
                        d73Var = (d73) objG;
                        if (d73Var != null) {
                            uv1Var.a();
                            il2 il2Var4 = new il2(str13 + ((s3) v3VarC).a() + str12, d73Var, null, null, 12);
                            ew2 ew2Var16 = (ew2) t42Var3.a;
                            xc2Var.getClass();
                            xc2.b(ew2Var16, list5);
                            it5 = list5.iterator();
                            while (it5.hasNext()) {
                                ((AccessibilityNodeInfo) it5.next()).recycle();
                            }
                            return il2Var4;
                        }
                        uv1Var.a();
                        hl2 hl2Var4 = new hl2(str11 + ((s3) v3VarC).a() + str10, "Requested destination is not yet visible", new c73(str2), null, false, 24);
                        ew2 ew2Var17 = (ew2) t42Var3.a;
                        xc2Var.getClass();
                        xc2.b(ew2Var17, list5);
                        it4 = list5.iterator();
                        while (it4.hasNext()) {
                            ((AccessibilityNodeInfo) it4.next()).recycle();
                        }
                        return hl2Var4;
                    case 5:
                        t42Var2 = hc2Var.n;
                        list2 = hc2Var.k;
                        bz3.g(obj6);
                        xc2Var = xc2Var2;
                        objB = obj6;
                        fl2Var2 = (jl2) objB;
                        t42Var = t42Var2;
                        ew2 ew2Var18 = (ew2) t42Var.a;
                        xc2Var.getClass();
                        xc2.b(ew2Var18, list2);
                        it6 = list2.iterator();
                        while (it6.hasNext()) {
                            ((AccessibilityNodeInfo) it6.next()).recycle();
                        }
                        return fl2Var2;
                    case 6:
                        int i13 = hc2Var.v;
                        boolean z6 = hc2Var.u;
                        v3 v3Var4 = hc2Var.s;
                        wc2 wc2Var6 = hc2Var.j;
                        str9 = hc2Var.i;
                        f5 f5Var6 = hc2Var.e;
                        bz3.g(obj6);
                        str6 = "Clicked ";
                        t3Var = v3Var4;
                        str2 = "Activation accepted without matching destination evidence";
                        str3 = ", but couldn't confirm the requested view opened.";
                        str7 = ", Boss.";
                        uv1Var = uv1Var;
                        xb2Var = xb2Var2;
                        str5 = "I tapped ";
                        i = i13;
                        z2 = z6;
                        t70Var = t70Var3;
                        wc2Var4 = wc2Var6;
                        f5Var3 = f5Var6;
                        if (wc2Var4 != null) {
                            String strA6 = ((s3) t3Var).a();
                            hc2Var.e = f5Var3;
                            hc2Var.f = null;
                            hc2Var.i = null;
                            hc2Var.j = wc2Var4;
                            hc2Var.k = null;
                            hc2Var.n = null;
                            hc2Var.s = t3Var;
                            hc2Var.u = z2;
                            hc2Var.v = i;
                            hc2Var.H = 7;
                            objG2 = G(str9, wc2Var4, strA6, hc2Var);
                            if (objG2 == t70Var) {
                                return t70Var;
                            }
                            v3 v3Var5 = t3Var;
                            obj5 = objG2;
                            v3Var2 = v3Var5;
                            d73Var2 = (d73) obj5;
                            t3Var = v3Var2;
                        } else {
                            d73Var2 = null;
                        }
                        wc2Var3 = wc2Var4;
                        f5Var2 = f5Var3;
                        if (d73Var2 != null) {
                            uv1Var.a();
                            gl2Var = new il2(cq.v(str6, ((s3) t3Var).a(), str7), d73Var2, null, null, 12);
                        } else {
                            uv1Var.a();
                            gl2Var = new hl2(cq.v(str5, ((s3) t3Var).a(), str3), "Requested destination is not yet visible", new c73(str2), null, false, 24);
                        }
                        if (wc2Var3 == null) {
                            strD = null;
                        } else {
                            if (!g31.a(f5Var2.c("summarise_first"), "true")) {
                                wc2Var3 = null;
                            }
                            if (wc2Var3 != null) {
                                xb2Var.getClass();
                                strD = xb2.d(wc2Var3);
                            } else {
                                strD = null;
                            }
                        }
                        if (strD != null) {
                            if (gl2Var instanceof il2) {
                                il2 il2Var5 = (il2) gl2Var;
                                String str110 = strD + Padder.FALLBACK_PADDING_STRING + il2Var5.a;
                                d73 d73Var4 = il2Var5.b;
                                n43 n43Var2 = il2Var5.c;
                                String str111 = il2Var5.d;
                                d73Var4.getClass();
                                return new il2(str110, d73Var4, n43Var2, str111);
                            }
                            if (gl2Var instanceof hl2) {
                                hl2 hl2Var5 = (hl2) gl2Var;
                                String str25 = strD + Padder.FALLBACK_PADDING_STRING + hl2Var5.a;
                                String str26 = hl2Var5.b;
                                e73 e73Var2 = hl2Var5.c;
                                h52 h52Var2 = hl2Var5.d;
                                boolean z7 = hl2Var5.e;
                                str26.getClass();
                                e73Var2.getClass();
                                return new hl2(str25, str26, e73Var2, h52Var2, z7);
                            }
                        }
                        return gl2Var;
                    case 7:
                        v3Var2 = hc2Var.s;
                        wc2Var4 = hc2Var.j;
                        f5Var3 = hc2Var.e;
                        bz3.g(obj6);
                        str6 = "Clicked ";
                        str2 = "Activation accepted without matching destination evidence";
                        str3 = ", but couldn't confirm the requested view opened.";
                        str7 = ", Boss.";
                        xb2Var = xb2Var2;
                        str5 = "I tapped ";
                        obj5 = obj6;
                        uv1Var = uv1Var;
                        d73Var2 = (d73) obj5;
                        t3Var = v3Var2;
                        wc2Var3 = wc2Var4;
                        f5Var2 = f5Var3;
                        if (d73Var2 != null) {
                            uv1Var.a();
                            gl2Var = new il2(cq.v(str6, ((s3) t3Var).a(), str7), d73Var2, null, null, 12);
                        } else {
                            uv1Var.a();
                            gl2Var = new hl2(cq.v(str5, ((s3) t3Var).a(), str3), "Requested destination is not yet visible", new c73(str2), null, false, 24);
                        }
                        if (wc2Var3 == null) {
                            strD = null;
                        } else {
                            if (!g31.a(f5Var2.c("summarise_first"), "true")) {
                                wc2Var3 = null;
                            }
                            if (wc2Var3 != null) {
                                xb2Var.getClass();
                                strD = xb2.d(wc2Var3);
                            } else {
                                strD = null;
                            }
                        }
                        if (strD != null) {
                            if (gl2Var instanceof il2) {
                                il2 il2Var6 = (il2) gl2Var;
                                String str112 = strD + Padder.FALLBACK_PADDING_STRING + il2Var6.a;
                                d73 d73Var5 = il2Var6.b;
                                n43 n43Var3 = il2Var6.c;
                                String str113 = il2Var6.d;
                                d73Var5.getClass();
                                return new il2(str112, d73Var5, n43Var3, str113);
                            }
                            if (gl2Var instanceof hl2) {
                                hl2 hl2Var6 = (hl2) gl2Var;
                                String str27 = strD + Padder.FALLBACK_PADDING_STRING + hl2Var6.a;
                                String str28 = hl2Var6.b;
                                e73 e73Var3 = hl2Var6.c;
                                h52 h52Var3 = hl2Var6.d;
                                boolean z8 = hl2Var6.e;
                                str28.getClass();
                                e73Var3.getClass();
                                return new hl2(str27, str28, e73Var3, h52Var3, z8);
                            }
                        }
                        return gl2Var;
                    case 8:
                        wc2Var3 = hc2Var.j;
                        f5Var2 = hc2Var.e;
                        bz3.g(obj6);
                        xb2Var = xb2Var2;
                        obj3 = obj6;
                        gl2Var = (jl2) obj3;
                        if (wc2Var3 == null) {
                            strD = null;
                        } else {
                            if (!g31.a(f5Var2.c("summarise_first"), "true")) {
                                wc2Var3 = null;
                            }
                            if (wc2Var3 != null) {
                                xb2Var.getClass();
                                strD = xb2.d(wc2Var3);
                            } else {
                                strD = null;
                            }
                        }
                        if (strD != null) {
                            if (gl2Var instanceof il2) {
                                il2 il2Var7 = (il2) gl2Var;
                                String str114 = strD + Padder.FALLBACK_PADDING_STRING + il2Var7.a;
                                d73 d73Var6 = il2Var7.b;
                                n43 n43Var4 = il2Var7.c;
                                String str115 = il2Var7.d;
                                d73Var6.getClass();
                                return new il2(str114, d73Var6, n43Var4, str115);
                            }
                            if (gl2Var instanceof hl2) {
                                hl2 hl2Var7 = (hl2) gl2Var;
                                String str29 = strD + Padder.FALLBACK_PADDING_STRING + hl2Var7.a;
                                String str210 = hl2Var7.b;
                                e73 e73Var4 = hl2Var7.c;
                                h52 h52Var4 = hl2Var7.d;
                                boolean z9 = hl2Var7.e;
                                str210.getClass();
                                e73Var4.getClass();
                                return new hl2(str29, str210, e73Var4, h52Var4, z9);
                            }
                        }
                        return gl2Var;
                    default:
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } catch (Throwable th9) {
                th = th9;
                r1 = r4;
                r2 = r5;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    /* JADX WARN: Not initialized variable reg: 27, insn: 0x02ab: MOVE (r1 I:??[OBJECT, ARRAY]) = (r27 I:??[OBJECT, ARRAY]), block:B:61:0x02aa */
    /* JADX WARN: Not initialized variable reg: 28, insn: 0x02ad: MOVE (r2 I:??[OBJECT, ARRAY]) = (r28 I:??[OBJECT, ARRAY]), block:B:61:0x02aa */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 45901. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object r(defpackage.f5 r46, int r47, defpackage.ec2 r48, defpackage.y50 r49) {
        /*
            Method dump skipped, instruction units count: 4590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vc2.r(f5, int, ec2, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e9 A[Catch: all -> 0x003d, ye2 -> 0x013e, TryCatch #0 {ye2 -> 0x013e, blocks: (B:14:0x0038, B:55:0x00e5, B:57:0x00e9, B:60:0x00f2, B:63:0x0127), top: B:76:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f2 A[Catch: all -> 0x003d, ye2 -> 0x013e, TRY_LEAVE, TryCatch #0 {ye2 -> 0x013e, blocks: (B:14:0x0038, B:55:0x00e5, B:57:0x00e9, B:60:0x00f2, B:63:0x0127), top: B:76:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (r1 == r12) goto L53;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x00f2, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2, types: [kc2, x50, y50] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(defpackage.y50 r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vc2.u(y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0117  */
    /* JADX WARN: Code duplicated, block: B:50:0x0139  */
    /* JADX WARN: Code duplicated, block: B:53:0x0144  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r29v0, types: [vc2] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28, types: [f5, fc2, wc2] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [int] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v20, types: [int] */
    /* JADX WARN: Type inference failed for: r4v21, types: [int] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0139 -> B:51:0x013c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x01ab -> B:16:0x005a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object v(defpackage.f5 r30, boolean r31, boolean r32, defpackage.y50 r33) {
        /*
            Method dump skipped, instruction units count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vc2.v(f5, boolean, boolean, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:63:0x014b  */
    /* JADX WARN: Code duplicated, block: B:73:0x0182  */
    /* JADX WARN: Code duplicated, block: B:77:0x0197  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0164 -> B:68:0x0167). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0199 -> B:72:0x017f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object w(defpackage.y50 r27) {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vc2.w(y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
    
        if (r15 == r6) goto L31;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0084 -> B:32:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(defpackage.y50 r15) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vc2.x(y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    /* JADX WARN: Code duplicated, block: B:31:0x007b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:40:0x008e A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:32:0x007d, B:35:0x0085, B:40:0x008e, B:41:0x0092, B:43:0x0098), top: B:55:0x007d }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0098 A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #0 {all -> 0x008c, blocks: (B:32:0x007d, B:35:0x0085, B:40:0x008e, B:41:0x0092, B:43:0x0098), top: B:55:0x007d }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00a4 A[EDGE_INSN: B:45:0x00a4->B:46:0x00a5 BREAK  A[LOOP:0: B:41:0x0092->B:59:?]] */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:? A[LOOP:0: B:41:0x0092->B:59:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object y(fc2 fc2Var, Bitmap bitmap, List list, y50 y50Var) {
        oc2 oc2Var;
        fc2 fc2Var2;
        List list2;
        zc2 zc2Var;
        Bitmap bitmap2;
        Iterator it;
        if (y50Var instanceof oc2) {
            oc2Var = (oc2) y50Var;
            int i = oc2Var.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                oc2Var.n = i - Integer.MIN_VALUE;
            } else {
                oc2Var = new oc2(this, y50Var);
            }
        } else {
            oc2Var = new oc2(this, y50Var);
        }
        Object objP = oc2Var.j;
        int i2 = oc2Var.n;
        boolean z = true;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objP);
            oc2Var.e = fc2Var;
            oc2Var.f = bitmap;
            oc2Var.i = list;
            oc2Var.n = 1;
            if (bm4.b(350L, oc2Var) != t70Var) {
            }
            return t70Var;
        }
        if (i2 == 1) {
            list = oc2Var.i;
            bitmap = oc2Var.f;
            fc2Var = oc2Var.e;
            bz3.g(objP);
        } else {
            if (i2 != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            list2 = oc2Var.i;
            bitmap = oc2Var.f;
            fc2Var2 = oc2Var.e;
            bz3.g(objP);
        }
        zc2Var = objP instanceof zc2 ? (zc2) objP : null;
        if (zc2Var != null) {
            return Boolean.FALSE;
        }
        bitmap2 = zc2Var.a;
        try {
            if (!C(fc2Var2)) {
                z = false;
                break;
            }
            if (list2 != null || !list2.isEmpty()) {
                it = list2.iterator();
                while (it.hasNext()) {
                    if (!A(bitmap, bitmap2, (Rect) it.next())) {
                        z = false;
                        break;
                    }
                }
            }
            if (bitmap2 != bitmap) {
                bitmap2.recycle();
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            if (bitmap2 != bitmap) {
                bitmap2.recycle();
            }
            throw th;
        }
        if (!C(fc2Var)) {
            return Boolean.FALSE;
        }
        oc2Var.e = fc2Var;
        oc2Var.f = bitmap;
        oc2Var.i = list;
        oc2Var.n = 2;
        objP = this.a.p(oc2Var);
        if (objP != t70Var) {
            List list3 = list;
            fc2Var2 = fc2Var;
            list2 = list3;
            if (objP instanceof zc2) {
            }
            if (zc2Var != null) {
                return Boolean.FALSE;
            }
            bitmap2 = zc2Var.a;
            if (!C(fc2Var2)) {
                z = false;
                break;
            }
            if (list2 != null) {
                it = list2.iterator();
                while (it.hasNext()) {
                    if (!A(bitmap, bitmap2, (Rect) it.next())) {
                        z = false;
                        break;
                    }
                }
            } else {
                it = list2.iterator();
                while (it.hasNext()) {
                    if (!A(bitmap, bitmap2, (Rect) it.next())) {
                        z = false;
                        break;
                    }
                }
            }
            if (bitmap2 != bitmap) {
                bitmap2.recycle();
            }
            return Boolean.valueOf(z);
        }
        return t70Var;
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
