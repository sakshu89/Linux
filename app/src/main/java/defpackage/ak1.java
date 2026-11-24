package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.CamcorderProfile;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.ibm.icu.impl.number.Padder;
import java.nio.ByteBuffer;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ak1 implements i70, om2, eq1, yp, px1, wy, ze3, p10, ks4 {
    public static final ak1 b = new ak1(1);
    public static final /* synthetic */ ak1 c = new ak1(2);
    public static final l42 e = new l42(Float.NaN, Float.NaN, Float.NaN, Float.NaN);
    public static final ak1 f = new ak1(4);
    public static final ak1 i = new ak1(5);
    public static final ak1 j = new ak1(6);
    public static final /* synthetic */ ak1 k = new ak1(7);
    public final /* synthetic */ int a;

    public ak1() {
        this.a = 9;
        new tf1(16);
        long[] jArr = ya2.a;
        new gm1();
    }

    public static final String j(String str) {
        x42 x42Var = b50.c;
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFC);
        strNormalize.getClass();
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = strNormalize.toLowerCase(locale);
        lowerCase.getClass();
        return b50.d.f(cs2.V(lowerCase).toString(), Padder.FALLBACK_PADDING_STRING);
    }

    public static final float k(String str, String str2) {
        Float fValueOf;
        x42 x42Var = b50.c;
        if (cs2.A(str) || cs2.A(str2)) {
            return 0.0f;
        }
        if (!str.equals(str2)) {
            int i2 = 0;
            List listN = cs2.N(str, new char[]{' '}, 6);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listN) {
                if (!cs2.A((String) obj)) {
                    arrayList.add(obj);
                }
            }
            List listN2 = cs2.N(str2, new char[]{' '}, 6);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listN2) {
                if (!cs2.A((String) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            if (cs2.o(str, ' ') || !arrayList2.contains(str)) {
                float fP = p(str, str2);
                Float fValueOf2 = null;
                if (arrayList.size() <= 1) {
                    ArrayList arrayList3 = new ArrayList();
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj3 = arrayList.get(i3);
                        i3++;
                        String str3 = (String) obj3;
                        ArrayList arrayList4 = new ArrayList(nz.d(arrayList2));
                        int size2 = arrayList2.size();
                        int i4 = 0;
                        while (i4 < size2) {
                            Object obj4 = arrayList2.get(i4);
                            i4++;
                            arrayList4.add(Float.valueOf(p(str3, (String) obj4)));
                        }
                        rz.q(arrayList4, arrayList3);
                    }
                    Iterator it = arrayList3.iterator();
                    if (it.hasNext()) {
                        float fFloatValue = ((Number) it.next()).floatValue();
                        while (it.hasNext()) {
                            fFloatValue = Math.max(fFloatValue, ((Number) it.next()).floatValue());
                        }
                        fValueOf2 = Float.valueOf(fFloatValue);
                    }
                    float fFloatValue2 = fValueOf2 != null ? fValueOf2.floatValue() : 0.0f;
                    return (arrayList.size() != 1 || arrayList2.size() <= 1) ? Math.max(fP, fFloatValue2) : Math.max(fP, (((1.0f / arrayList2.size()) * 0.15f) + 0.8f) * fFloatValue2);
                }
                ArrayList arrayList5 = new ArrayList(nz.d(arrayList));
                int size3 = arrayList.size();
                int i5 = 0;
                while (i5 < size3) {
                    Object obj5 = arrayList.get(i5);
                    i5++;
                    String str4 = (String) obj5;
                    Iterator it2 = arrayList2.iterator();
                    if (it2.hasNext()) {
                        float fP2 = p(str4, (String) it2.next());
                        while (it2.hasNext()) {
                            fP2 = Math.max(fP2, p(str4, (String) it2.next()));
                        }
                        fValueOf = Float.valueOf(fP2);
                    } else {
                        fValueOf = null;
                    }
                    arrayList5.add(Float.valueOf(fValueOf != null ? fValueOf.floatValue() : 0.0f));
                }
                if (!arrayList5.isEmpty()) {
                    int size4 = arrayList5.size();
                    int i6 = 0;
                    while (i6 < size4) {
                        Object obj6 = arrayList5.get(i6);
                        i6++;
                        if (((Number) obj6).floatValue() != 1.0f) {
                            if (!arrayList.isEmpty()) {
                                int size5 = arrayList.size();
                                int i7 = 0;
                                int i8 = 0;
                                while (i8 < size5) {
                                    Object obj7 = arrayList.get(i8);
                                    i8++;
                                    String str5 = (String) obj7;
                                    if (!arrayList2.isEmpty()) {
                                        int size6 = arrayList2.size();
                                        int i9 = 0;
                                        while (true) {
                                            if (i9 < size6) {
                                                Object obj8 = arrayList2.get(i9);
                                                i9++;
                                                String str6 = (String) obj8;
                                                if (p(str5, str6) < 0.7f) {
                                                    x42 x42Var2 = b50.c;
                                                    if (n(str5).equals(n(str6))) {
                                                    }
                                                }
                                                i7++;
                                                if (i7 < 0) {
                                                    nz.m();
                                                    throw null;
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                }
                                i2 = i7;
                            }
                            float fR = ((float) mz.r(arrayList5)) * (i2 / arrayList.size());
                            if (fR > 0.84f) {
                                return 0.84f;
                            }
                            return fR;
                        }
                    }
                }
            }
        }
        return 1.0f;
    }

    public static boolean l(uh0 uh0Var, Editable editable, int i2, int i3, boolean z) {
        int iMin;
        if (editable != null && i2 >= 0 && i3 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd) {
                if (z) {
                    int iMax = Math.max(i2, 0);
                    int length = editable.length();
                    if (selectionStart >= 0 && length >= selectionStart && iMax >= 0) {
                        loop0: while (true) {
                            boolean z2 = false;
                            while (true) {
                                if (iMax == 0) {
                                    break loop0;
                                }
                                selectionStart--;
                                if (selectionStart < 0) {
                                    if (!z2) {
                                        selectionStart = 0;
                                        break loop0;
                                    }
                                    break loop0;
                                }
                                char cCharAt = editable.charAt(selectionStart);
                                if (z2) {
                                    if (Character.isHighSurrogate(cCharAt)) {
                                        iMax--;
                                    }
                                } else if (!Character.isSurrogate(cCharAt)) {
                                    iMax--;
                                } else if (!Character.isHighSurrogate(cCharAt)) {
                                    z2 = true;
                                }
                                selectionStart = -1;
                                break loop0;
                            }
                        }
                    }
                    selectionStart = -1;
                    break loop0;
                    int iMax2 = Math.max(i3, 0);
                    iMin = editable.length();
                    if (selectionEnd >= 0 && iMin >= selectionEnd && iMax2 >= 0) {
                        loop2: while (true) {
                            boolean z3 = false;
                            while (true) {
                                if (iMax2 != 0) {
                                    if (selectionEnd >= iMin) {
                                        if (!z3) {
                                            break loop2;
                                        }
                                        break loop2;
                                    }
                                    char cCharAt2 = editable.charAt(selectionEnd);
                                    if (z3) {
                                        if (Character.isLowSurrogate(cCharAt2)) {
                                            iMax2--;
                                            selectionEnd++;
                                        }
                                    } else if (!Character.isSurrogate(cCharAt2)) {
                                        iMax2--;
                                        selectionEnd++;
                                    } else if (!Character.isLowSurrogate(cCharAt2)) {
                                        selectionEnd++;
                                        z3 = true;
                                    }
                                    iMin = -1;
                                    break loop2;
                                }
                                iMin = selectionEnd;
                                break loop2;
                            }
                        }
                    }
                    iMin = -1;
                    break loop2;
                    if (selectionStart != -1 && iMin != -1) {
                    }
                } else {
                    selectionStart = Math.max(selectionStart - i2, 0);
                    iMin = Math.min(selectionEnd + i3, editable.length());
                }
                r33[] r33VarArr = (r33[]) editable.getSpans(selectionStart, iMin, r33.class);
                if (r33VarArr != null && r33VarArr.length > 0) {
                    for (r33 r33Var : r33VarArr) {
                        int spanStart = editable.getSpanStart(r33Var);
                        int spanEnd = editable.getSpanEnd(r33Var);
                        selectionStart = Math.min(spanStart, selectionStart);
                        iMin = Math.max(spanEnd, iMin);
                    }
                    int iMax3 = Math.max(selectionStart, 0);
                    int iMin2 = Math.min(iMin, editable.length());
                    uh0Var.beginBatchEdit();
                    editable.delete(iMax3, iMin2);
                    uh0Var.endBatchEdit();
                    return true;
                }
            }
        }
        return false;
    }

    public static String m(String str) {
        str.getClass();
        qs4 qs4Var = mz2.b;
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        return cs2.V(b50.d.f(b50.c.f(js2.i(qs4.o(lowerCase), "️", ""), Padder.FALLBACK_PADDING_STRING), Padder.FALLBACK_PADDING_STRING)).toString();
    }

    public static String n(String str) {
        char cCharAt;
        char c2;
        str.getClass();
        if (str.length() == 0) {
            return "";
        }
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        String strReplace = lowerCase.replace('v', 'w');
        strReplace.getClass();
        String strReplace2 = strReplace.replace('z', 's');
        strReplace2.getClass();
        StringBuilder sb = new StringBuilder();
        int length = strReplace2.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt2 = strReplace2.charAt(i2);
            if (Character.isLetter(cCharAt2)) {
                sb.append(cCharAt2);
            }
        }
        String string = sb.toString();
        if (string.length() == 0) {
            return "";
        }
        switch (string.charAt(0)) {
            case 'b':
            case 'f':
            case 'p':
            case 'v':
            case 'w':
                cCharAt = '1';
                break;
            case 'c':
            case 'g':
            case 'j':
            case 'k':
            case 'q':
            case 's':
            case 'x':
            case 'y':
            case 'z':
                cCharAt = '2';
                break;
            case 'd':
            case 't':
                cCharAt = '3';
                break;
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            default:
                cCharAt = string.charAt(0);
                break;
            case 'h':
                cCharAt = '7';
                break;
            case 'l':
                cCharAt = '4';
                break;
            case 'm':
            case 'n':
                cCharAt = '5';
                break;
            case 'r':
                cCharAt = '6';
                break;
        }
        ArrayList arrayList = new ArrayList();
        int length2 = string.length();
        char c3 = cCharAt;
        for (int i3 = 1; i3 < length2; i3++) {
            switch (string.charAt(i3)) {
                case 'b':
                case 'f':
                case 'p':
                case 'v':
                case 'w':
                    c2 = '1';
                    break;
                case 'c':
                case 'g':
                case 'j':
                case 'k':
                case 'q':
                case 's':
                case 'x':
                case 'y':
                case 'z':
                    c2 = '2';
                    break;
                case 'd':
                case 't':
                    c2 = '3';
                    break;
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                default:
                    c2 = '0';
                    break;
                case 'h':
                    c2 = '7';
                    break;
                case 'l':
                    c2 = '4';
                    break;
                case 'm':
                case 'n':
                    c2 = '5';
                    break;
                case 'r':
                    c2 = '6';
                    break;
            }
            if (c2 != '0' && c2 != c3) {
                arrayList.add(Character.valueOf(c2));
                c3 = c2;
            }
        }
        return cs2.T(4, cCharAt + mz.C(arrayList, "", null, null, null, 62));
    }

    public static final String o(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (!ph4.c(cCharAt) && !cs2.o("-().", cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        return js2.k(string, "00", false) ? "+".concat(cs2.p(2, string)) : string;
    }

    public static final float p(String str, String str2) {
        float f2 = 1.0f;
        if (g31.a(str, str2)) {
            return 1.0f;
        }
        int length = str2.length();
        int i2 = length + 1;
        int[] iArr = new int[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iArr[i4] = i4;
        }
        int length2 = str.length();
        int i5 = 0;
        while (i5 < length2) {
            int i6 = iArr[i3];
            int i7 = i5 + 1;
            iArr[i3] = i7;
            int length3 = str2.length();
            int i8 = i3;
            while (i8 < length3) {
                int i9 = i8 + 1;
                int i10 = iArr[i9];
                float f3 = f2;
                iArr[i9] = Math.min(iArr[i8] + 1, Math.min(i10 + 1, i6 + (str.charAt(i5) == str2.charAt(i8) ? 0 : 1)));
                i8 = i9;
                i6 = i10;
                f2 = f3;
                i3 = 0;
            }
            i5 = i7;
            f2 = f2;
        }
        float f4 = f2;
        if (i2 != 0) {
            return f4 - (iArr[length] / Math.max(str.length(), str2.length()));
        }
        kf2.g("Array is empty.");
        return 0.0f;
    }

    @Override // defpackage.om2
    public boolean b(Object obj, Object obj2) {
        return obj == obj2;
    }

    @Override // defpackage.yp
    public CamcorderProfile c(int i2, int i3) {
        return CamcorderProfile.get(i2, i3);
    }

    public void d(Drawable drawable, x20 x20Var, int i2) {
        x20Var.X(257732500);
        int i3 = 4;
        int i4 = (x20Var.h(drawable) ? 4 : 2) | i2;
        if (x20Var.O(i4 & 1, (i4 & 3) != 2)) {
            ek1 ek1VarG = w44.g(bk1.a, s50.e);
            boolean zH = x20Var.h(drawable);
            Object objL = x20Var.L();
            if (zH || objL == r20.a) {
                objL = new rm2(i3, drawable);
                x20Var.g0(objL);
            }
            gm.a(az3.a(ek1VarG, (hq0) objL), x20Var, 0);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new km(i2, 14, this, drawable);
        }
    }

    @Override // defpackage.yp
    public boolean e(int i2, int i3) {
        return CamcorderProfile.hasProfile(i2, i3);
    }

    @Override // defpackage.ks4
    public Object f(Object obj) {
        String str = ((tw2) obj).a;
        return str == null ? "" : str;
    }

    @Override // defpackage.p10
    public Object g(e72 e72Var) {
        return new wj0(e72Var.c(yj1.class));
    }

    @Override // defpackage.wy
    public long h() {
        return SystemClock.elapsedRealtime();
    }

    public void i(final Icon icon, x20 x20Var, final int i2) {
        a42 a42VarR;
        vq0 vq0Var;
        x20Var.X(2116504409);
        int i3 = (x20Var.h(icon) ? 4 : 2) | i2;
        final int i4 = 0;
        final int i5 = 1;
        if (x20Var.O(i3 & 1, (i3 & 19) != 18)) {
            Context context = (Context) x20Var.j(AndroidCompositionLocals_androidKt.b);
            boolean zF = x20Var.f(icon) | x20Var.f(context);
            Object objL = x20Var.L();
            if (zF || objL == r20.a) {
                objL = icon.loadDrawable(context);
                x20Var.g0(objL);
            }
            Drawable drawable = (Drawable) objL;
            if (drawable == null) {
                a42VarR = x20Var.r();
                if (a42VarR == null) {
                    return;
                } else {
                    vq0Var = new vq0(this, icon, i2, i4) { // from class: ix2
                        public final /* synthetic */ int a;
                        public final /* synthetic */ ak1 b;
                        public final /* synthetic */ Icon c;

                        {
                            this.a = i4;
                            this.b = this;
                        }

                        @Override // defpackage.vq0
                        public final Object e(Object obj, Object obj2) {
                            int i6 = this.a;
                            q43 q43Var = q43.a;
                            Icon icon2 = this.c;
                            ak1 ak1Var = this.b;
                            x20 x20Var2 = (x20) obj;
                            ((Integer) obj2).getClass();
                            switch (i6) {
                                case 0:
                                    ak1Var.i(icon2, x20Var2, ny3.c(49));
                                    break;
                                default:
                                    ak1Var.i(icon2, x20Var2, ny3.c(49));
                                    break;
                            }
                            return q43Var;
                        }
                    };
                }
            } else {
                d(drawable, x20Var, 48);
            }
            a42VarR.d = vq0Var;
        }
        x20Var.R();
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            vq0Var = new vq0(this, icon, i2, i5) { // from class: ix2
                public final /* synthetic */ int a;
                public final /* synthetic */ ak1 b;
                public final /* synthetic */ Icon c;

                {
                    this.a = i5;
                    this.b = this;
                }

                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    int i6 = this.a;
                    q43 q43Var = q43.a;
                    Icon icon2 = this.c;
                    ak1 ak1Var = this.b;
                    x20 x20Var2 = (x20) obj;
                    ((Integer) obj2).getClass();
                    switch (i6) {
                        case 0:
                            ak1Var.i(icon2, x20Var2, ny3.c(49));
                            break;
                        default:
                            ak1Var.i(icon2, x20Var2, ny3.c(49));
                            break;
                    }
                    return q43Var;
                }
            };
            a42VarR.d = vq0Var;
        }
    }

    @Override // defpackage.ze3
    public long initialize(byte[] bArr, long j2, long j3, long j4, long j5, long j6) {
        return 1L;
    }

    @Override // defpackage.ze3
    public long initializeFrameBufferReleaseCallback(long j2) {
        return 1L;
    }

    @Override // defpackage.ze3
    public long initializeFrameManager() {
        return 1L;
    }

    @Override // defpackage.ze3
    public long initializeIsolationCallback() {
        return 1L;
    }

    @Override // defpackage.ze3
    public long initializeResultsCallback() {
        return 1L;
    }

    @Override // defpackage.ze3
    public byte[] process(long j2, long j3, long j4, byte[] bArr, int i2, int i3, int i4, int i5) {
        return am3.o().b();
    }

    @Override // defpackage.ze3
    public byte[] processBitmap(long j2, long j3, Bitmap bitmap, int i2, int i3, int i4, int i5) {
        return am3.o().b();
    }

    @Override // defpackage.ze3
    public byte[] processYuvFrame(long j2, long j3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3, int i4, int i5, int i6, int i7) {
        return am3.o().b();
    }

    @Override // defpackage.eq1
    public void q(Exception exc) {
        l11 l11Var = zj1.f;
        if (Log.isLoggable((String) l11Var.b, 6)) {
            String str = (String) l11Var.c;
            Log.e("MobileVisionBase", str != null ? str.concat("Error preloading model resource") : "Error preloading model resource", exc);
        }
    }

    @Override // defpackage.ze3
    public boolean stop(long j2) {
        return true;
    }

    public String toString() {
        switch (this.a) {
            case 5:
                return "ReferentialEqualityPolicy";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ ak1(int i2) {
        this.a = i2;
    }

    @Override // defpackage.ze3
    public void a() {
    }

    @Override // defpackage.ze3
    public void start(long j2) {
    }

    @Override // defpackage.ze3
    public void waitUntilIdle(long j2) {
    }

    @Override // defpackage.ze3
    public void close(long j2, long j3, long j4, long j5, long j6) {
    }
}
