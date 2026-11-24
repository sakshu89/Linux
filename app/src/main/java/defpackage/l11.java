package defpackage;

import android.R;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillId;
import android.view.inputmethod.InputMethodManager;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.DateTimePatternGenerator;
import com.ibm.icu.text.Normalizer;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class l11 implements ls, ir0, wh0, zs2 {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;

    public l11(String str, int i) {
        this.a = i;
        switch (i) {
            case 24:
                Object[] objArr = {str, 23};
                if (!(str.length() <= 23)) {
                    throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
                }
                this.b = str;
                this.c = null;
                return;
            case 25:
            default:
                this.c = null;
                this.b = str;
                return;
            case 26:
                str.getClass();
                this.b = str;
                this.c = new x42("^(?:(?:hey|ok|okay|hi|hello|yo)\\s+)?(?:sonic|sonik)\\b[\\s,.!?:;—-]+(.+)$", y42.IGNORE_CASE);
                return;
        }
    }

    public static List I(String str) {
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, str, locale);
        Pattern patternCompile = Pattern.compile("[^\\p{L}\\p{N}]+");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strO).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        String string = cs2.V(strReplaceAll).toString();
        Pattern patternCompile2 = Pattern.compile("\\s+");
        patternCompile2.getClass();
        string.getClass();
        int iEnd = 0;
        cs2.L(0);
        Matcher matcher = patternCompile2.matcher(string);
        if (!matcher.find()) {
            return nz.h(string.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        do {
            arrayList.add(string.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
        } while (matcher.find());
        arrayList.add(string.subSequence(iEnd, string.length()).toString());
        return arrayList;
    }

    public void A(mq mqVar) {
        synchronized (this.b) {
            try {
                mqVar.getClass();
                for (String str : new LinkedHashSet(mqVar.f)) {
                    xq4.c(3, "CameraRepository");
                    ((LinkedHashMap) this.c).put(str, mqVar.a(str));
                }
            } catch (su e) {
                throw new v01(e);
            }
        }
    }

    public AutofillId B(long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return f50.b(t6.d(this.c), ((View) this.b).getAutofillId(), j);
        }
        return null;
    }

    public void C(cp0 cp0Var) {
        uj0 uj0Var = (uj0) this.c;
        py0 py0Var = (py0) this.b;
        int i = cp0Var.b;
        if (i != 0) {
            uj0Var.execute(new t5(py0Var, i));
        } else {
            uj0Var.execute(new or0(1, py0Var, cp0Var.a));
        }
    }

    public void D(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws ds {
        executor.getClass();
        stateCallback.getClass();
        try {
            ((CameraManager) this.b).openCamera(str, new rq(executor, stateCallback), ((du) this.c).b);
        } catch (CameraAccessException e) {
            throw new ds(e);
        }
    }

    public void E(ch2 ch2Var, tq tqVar) {
        yt ytVar;
        du duVar = (du) this.c;
        synchronized (duVar.a) {
            try {
                ytVar = (yt) duVar.a.get(tqVar);
                if (ytVar == null) {
                    ytVar = new yt(ch2Var, tqVar);
                    duVar.a.put(tqVar, ytVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ((CameraManager) this.b).registerAvailabilityCallback(ytVar, duVar.b);
    }

    public void F() {
        if (((e01) this.c) != null) {
            this.c = null;
            ((ky) this.b).M0(true);
        }
    }

    public int G(CaptureRequest captureRequest, ch2 ch2Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.b).setRepeatingRequest(captureRequest, new iq(ch2Var, captureCallback), ((us) this.c).a);
    }

    public void H(CameraManager.AvailabilityCallback availabilityCallback) {
        yt ytVar;
        if (availabilityCallback != null) {
            du duVar = (du) this.c;
            synchronized (duVar.a) {
                ytVar = (yt) duVar.a.remove(availabilityCallback);
            }
        } else {
            ytVar = null;
        }
        if (ytVar != null) {
            synchronized (ytVar.c) {
                ytVar.d = true;
            }
        }
        ((CameraManager) this.b).unregisterAvailabilityCallback(ytVar);
    }

    @Override // defpackage.ls
    public void a(bk0 bk0Var) {
        String strValueOf;
        CaptureResult captureResult = (CaptureResult) this.c;
        super.a(bk0Var);
        ArrayList arrayList = bk0Var.a;
        try {
            Integer num = (Integer) captureResult.get(CaptureResult.JPEG_ORIENTATION);
            if (num != null) {
                bk0Var.d(num.intValue());
            }
        } catch (BufferUnderflowException unused) {
            xq4.d("C2CameraCaptureResult", "Failed to get JPEG orientation.");
        }
        Long l = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l != null) {
            bk0Var.c("ExposureTime", String.valueOf(l.longValue() / 1.0E9d), arrayList);
        }
        Float f = (Float) captureResult.get(CaptureResult.LENS_APERTURE);
        if (f != null) {
            bk0Var.c("FNumber", String.valueOf(f.floatValue()), arrayList);
        }
        Integer numValueOf = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        if (numValueOf != null) {
            Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
            if (num2 != null) {
                numValueOf = Integer.valueOf(numValueOf.intValue() * ((int) (num2.intValue() / 100.0f)));
            }
            int iIntValue = numValueOf.intValue();
            bk0Var.c("SensitivityType", String.valueOf(3), arrayList);
            bk0Var.c("PhotographicSensitivity", String.valueOf(Math.min(DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH, iIntValue)), arrayList);
        }
        Float f2 = (Float) captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f2 != null) {
            bk0Var.c("FocalLength", ((long) (f2.floatValue() * 1000.0f)) + "/1000", arrayList);
        }
        Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AWB_MODE);
        if (num3 != null) {
            int iX = cq.x(num3.intValue() == 0 ? 2 : 1);
            if (iX != 0) {
                strValueOf = iX != 1 ? null : String.valueOf(1);
            } else {
                strValueOf = String.valueOf(0);
            }
            bk0Var.c("WhiteBalance", strValueOf, arrayList);
        }
    }

    @Override // defpackage.ls
    public iv2 b() {
        return (iv2) this.b;
    }

    @Override // defpackage.ir0
    public void c(Object obj) {
        switch (this.a) {
            case 17:
                break;
            default:
                xt2 xt2Var = (xt2) obj;
                xt2Var.getClass();
                ((yt2) ((cj) this.c).b).b(xt2Var);
                break;
        }
    }

    @Override // defpackage.ls
    public long d() {
        Long l = (Long) ((CaptureResult) this.c).get(CaptureResult.SENSOR_TIMESTAMP);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    @Override // defpackage.wh0
    public Object e() {
        return (v43) this.b;
    }

    @Override // defpackage.wh0
    public boolean f(CharSequence charSequence, int i, int i2, q33 q33Var) {
        if ((q33Var.c & 4) > 0) {
            return true;
        }
        if (((v43) this.b) == null) {
            this.b = new v43(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((su0) this.c).getClass();
        ((v43) this.b).setSpan(new r33(q33Var), i, i2, 33);
        return true;
    }

    public boolean g(long j) {
        Object obj;
        List list = (List) ((q91) this.c).b;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list.get(i);
            if (f31.d(((py1) obj).a, j)) {
                break;
            }
            i++;
        }
        py1 py1Var = (py1) obj;
        if (py1Var != null) {
            return py1Var.h;
        }
        return false;
    }

    @Override // defpackage.zs2
    public void h(ys2 ys2Var) {
        ul1 ul1Var = (ul1) this.c;
        ul1Var.a();
        am1 am1Var = (am1) ys2Var.b;
        Object[] objArr = am1Var.b;
        long[] jArr = am1Var.c;
        int i = am1Var.e;
        while (i != Integer.MAX_VALUE) {
            int i2 = (int) ((jArr[i] >> 31) & 2147483647L);
            Object obj = objArr[i];
            Object objB = ((v81) this.b).b(obj);
            int iD = ul1Var.d(objB);
            int i3 = iD >= 0 ? ul1Var.c[iD] : 0;
            if (i3 == 7) {
                ys2Var.remove(obj);
            } else {
                ul1Var.g(i3 + 1, objB);
            }
            i = i2;
        }
    }

    @Override // defpackage.ir0
    public void i(Throwable th) {
        switch (this.a) {
            case 17:
                vc4.b();
                g12 g12Var = (g12) this.b;
                cj cjVar = (cj) this.c;
                if (g12Var == ((g12) cjVar.b)) {
                    xq4.d("CaptureNode", "request aborted, id=" + ((g12) cjVar.b).a);
                    q91 q91Var = (q91) cjVar.a;
                    if (q91Var != null) {
                        q91Var.c = null;
                    }
                    cjVar.b = null;
                }
                break;
            default:
                int i = ((st2) this.b).f;
                if (i == 2 && (th instanceof CancellationException)) {
                    xq4.c(3, "DualSurfaceProcessorNode");
                } else {
                    xq4.e("DualSurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + cb4.f(i), th);
                }
                break;
        }
    }

    @Override // defpackage.ls
    public hs j() {
        Integer num = (Integer) ((CaptureResult) this.c).get(CaptureResult.CONTROL_AE_STATE);
        hs hsVar = hs.a;
        if (num == null) {
            return hsVar;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return hs.b;
        }
        if (iIntValue != 1) {
            if (iIntValue == 2) {
                return hs.f;
            }
            if (iIntValue == 3) {
                return hs.i;
            }
            if (iIntValue == 4) {
                return hs.e;
            }
            if (iIntValue != 5) {
                xq4.a("C2CameraCaptureResult", "Undefined ae state: " + num);
                return hsVar;
            }
        }
        return hs.c;
    }

    @Override // defpackage.ls
    public js k() {
        Integer num = (Integer) ((CaptureResult) this.c).get(CaptureResult.CONTROL_AWB_STATE);
        js jsVar = js.a;
        if (num == null) {
            return jsVar;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return js.b;
        }
        if (iIntValue == 1) {
            return js.c;
        }
        if (iIntValue == 2) {
            return js.e;
        }
        if (iIntValue == 3) {
            return js.f;
        }
        xq4.a("C2CameraCaptureResult", "Undefined awb state: " + num);
        return jsVar;
    }

    public ty2 l(List list) {
        fh0 fh0Var;
        Exception e;
        try {
            int size = list.size();
            int i = 0;
            fh0Var = null;
            while (i < size) {
                try {
                    fh0 fh0Var2 = (fh0) list.get(i);
                    try {
                        fh0Var2.a((gh0) this.c);
                        i++;
                        fh0Var = fh0Var2;
                    } catch (Exception e2) {
                        e = e2;
                        fh0Var = fh0Var2;
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder("Error while applying EditCommand batch to buffer (length=");
                        sb2.append(((gh0) this.c).a.c());
                        sb2.append(", composition=");
                        sb2.append(((gh0) this.c).c());
                        sb2.append(", selection=");
                        gh0 gh0Var = (gh0) this.c;
                        sb2.append((Object) oz2.h(hc4.a(gh0Var.b, gh0Var.c)));
                        sb2.append("):");
                        sb.append(sb2.toString());
                        sb.append('\n');
                        mz.B(list, sb, new x0(10, fh0Var, this), 60);
                        throw new RuntimeException(sb.toString(), e);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            gh0 gh0Var2 = (gh0) this.c;
            gh0Var2.getClass();
            be beVar = new be(gh0Var2.a.toString());
            gh0 gh0Var3 = (gh0) this.c;
            long jA = hc4.a(gh0Var3.b, gh0Var3.c);
            oz2 oz2Var = oz2.g(((ty2) this.b).b) ? null : new oz2(jA);
            ty2 ty2Var = new ty2(beVar, oz2Var != null ? oz2Var.a : hc4.a(oz2.e(jA), oz2.f(jA)), ((gh0) this.c).c());
            this.b = ty2Var;
            return ty2Var;
        } catch (Exception e4) {
            fh0Var = null;
            e = e4;
        }
    }

    @Override // defpackage.ls
    public int m() {
        Integer num = (Integer) ((CaptureResult) this.c).get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return 1;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0 || iIntValue == 1) {
            return 2;
        }
        if (iIntValue == 2) {
            return 3;
        }
        if (iIntValue == 3 || iIntValue == 4) {
            return 4;
        }
        xq4.a("C2CameraCaptureResult", "Undefined flash state: " + num);
        return 1;
    }

    @Override // defpackage.ls
    public CaptureResult n() {
        return (CaptureResult) this.c;
    }

    @Override // defpackage.ls
    public is o() {
        Integer num = (Integer) ((CaptureResult) this.c).get(CaptureResult.CONTROL_AF_STATE);
        is isVar = is.a;
        if (num == null) {
            return isVar;
        }
        switch (num.intValue()) {
            case 0:
                return is.b;
            case 1:
            case 3:
                return is.c;
            case 2:
                return is.e;
            case 4:
                return is.i;
            case 5:
                return is.j;
            case 6:
                return is.f;
            default:
                xq4.a("C2CameraCaptureResult", "Undefined af state: " + num);
                return isVar;
        }
    }

    @Override // defpackage.zs2
    public boolean p(Object obj, Object obj2) {
        v81 v81Var = (v81) this.b;
        return g31.a(v81Var.b(obj), v81Var.b(obj2));
    }

    public void q() {
        kf kfVar = (kf) this.b;
        if (kfVar != null) {
            ((AtomicBoolean) kfVar.c).set(true);
            ((ScheduledFuture) kfVar.b).cancel(true);
        }
        this.b = null;
    }

    public int r(ArrayList arrayList, ch2 ch2Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.b).captureBurst(arrayList, new iq(ch2Var, captureCallback), ((us) this.c).a);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:104:0x0209  */
    /* JADX WARN: Code duplicated, block: B:106:0x0212  */
    /* JADX WARN: Code duplicated, block: B:109:0x0260  */
    /* JADX WARN: Code duplicated, block: B:111:0x0264  */
    /* JADX WARN: Code duplicated, block: B:112:0x026a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0289 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x028b  */
    /* JADX WARN: Code duplicated, block: B:120:0x028e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0292  */
    /* JADX WARN: Code duplicated, block: B:123:0x0295  */
    /* JADX WARN: Code duplicated, block: B:126:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:128:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:131:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:133:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:136:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:139:0x030a  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:142:0x0315  */
    /* JADX WARN: Code duplicated, block: B:144:0x0325  */
    /* JADX WARN: Code duplicated, block: B:150:0x0343  */
    /* JADX WARN: Code duplicated, block: B:153:0x034b  */
    /* JADX WARN: Code duplicated, block: B:155:0x035d A[LOOP:3: B:152:0x0349->B:155:0x035d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:160:0x037a  */
    /* JADX WARN: Code duplicated, block: B:162:0x038a  */
    /* JADX WARN: Code duplicated, block: B:168:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:171:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:173:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:177:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:179:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:187:0x041d  */
    /* JADX WARN: Code duplicated, block: B:189:0x042b  */
    /* JADX WARN: Code duplicated, block: B:191:0x0432  */
    /* JADX WARN: Code duplicated, block: B:193:0x0446  */
    /* JADX WARN: Code duplicated, block: B:195:0x0458  */
    /* JADX WARN: Code duplicated, block: B:197:0x0462  */
    /* JADX WARN: Code duplicated, block: B:199:0x0472  */
    /* JADX WARN: Code duplicated, block: B:203:0x0480  */
    /* JADX WARN: Code duplicated, block: B:206:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:208:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:211:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:214:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:215:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:218:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:221:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:223:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:224:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:226:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:229:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:232:0x0505  */
    /* JADX WARN: Code duplicated, block: B:237:0x051b  */
    /* JADX WARN: Code duplicated, block: B:239:0x0523  */
    /* JADX WARN: Code duplicated, block: B:242:0x0529  */
    /* JADX WARN: Code duplicated, block: B:243:0x0530  */
    /* JADX WARN: Code duplicated, block: B:247:0x053d  */
    /* JADX WARN: Code duplicated, block: B:250:0x0543  */
    /* JADX WARN: Code duplicated, block: B:252:0x0546  */
    /* JADX WARN: Code duplicated, block: B:255:0x055d A[LOOP:8: B:251:0x0544->B:255:0x055d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:258:0x0565  */
    /* JADX WARN: Code duplicated, block: B:261:0x0570  */
    /* JADX WARN: Code duplicated, block: B:264:0x0579  */
    /* JADX WARN: Code duplicated, block: B:266:0x057d  */
    /* JADX WARN: Code duplicated, block: B:267:0x0582  */
    /* JADX WARN: Code duplicated, block: B:269:0x058c  */
    /* JADX WARN: Code duplicated, block: B:271:0x0591  */
    /* JADX WARN: Code duplicated, block: B:273:0x059b  */
    /* JADX WARN: Code duplicated, block: B:274:0x059f  */
    /* JADX WARN: Code duplicated, block: B:277:0x05c0  */
    /* JADX WARN: Code duplicated, block: B:280:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:281:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:284:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:286:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:288:0x0601  */
    /* JADX WARN: Code duplicated, block: B:289:0x0608  */
    /* JADX WARN: Code duplicated, block: B:292:0x061b  */
    /* JADX WARN: Code duplicated, block: B:294:0x061f  */
    /* JADX WARN: Code duplicated, block: B:296:0x062b  */
    /* JADX WARN: Code duplicated, block: B:299:0x0633  */
    /* JADX WARN: Code duplicated, block: B:301:0x063b  */
    /* JADX WARN: Code duplicated, block: B:304:0x064c  */
    /* JADX WARN: Code duplicated, block: B:309:0x066a  */
    /* JADX WARN: Code duplicated, block: B:312:0x066f  */
    /* JADX WARN: Code duplicated, block: B:314:0x0679  */
    /* JADX WARN: Code duplicated, block: B:315:0x0689  */
    /* JADX WARN: Code duplicated, block: B:318:0x0693  */
    /* JADX WARN: Code duplicated, block: B:31:0x0083  */
    /* JADX WARN: Code duplicated, block: B:321:0x0698  */
    /* JADX WARN: Code duplicated, block: B:324:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:326:0x06b3  */
    /* JADX WARN: Code duplicated, block: B:329:0x06b8  */
    /* JADX WARN: Code duplicated, block: B:332:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:335:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:338:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:33:0x0090  */
    /* JADX WARN: Code duplicated, block: B:341:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:344:0x0704  */
    /* JADX WARN: Code duplicated, block: B:348:0x0716  */
    /* JADX WARN: Code duplicated, block: B:349:0x071d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0094  */
    /* JADX WARN: Code duplicated, block: B:351:0x0720  */
    /* JADX WARN: Code duplicated, block: B:354:0x0734  */
    /* JADX WARN: Code duplicated, block: B:359:0x0753  */
    /* JADX WARN: Code duplicated, block: B:360:0x0756  */
    /* JADX WARN: Code duplicated, block: B:363:0x0778  */
    /* JADX WARN: Code duplicated, block: B:365:0x077e  */
    /* JADX WARN: Code duplicated, block: B:374:0x07a1  */
    /* JADX WARN: Code duplicated, block: B:376:0x07a7  */
    /* JADX WARN: Code duplicated, block: B:37:0x009c  */
    /* JADX WARN: Code duplicated, block: B:384:0x07bf  */
    /* JADX WARN: Code duplicated, block: B:386:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:388:0x07cd  */
    /* JADX WARN: Code duplicated, block: B:390:0x07d5  */
    /* JADX WARN: Code duplicated, block: B:393:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:396:0x07f2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:404:0x080e  */
    /* JADX WARN: Code duplicated, block: B:407:0x081b  */
    /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:410:0x083d  */
    /* JADX WARN: Code duplicated, block: B:412:0x0845  */
    /* JADX WARN: Code duplicated, block: B:413:0x084b  */
    /* JADX WARN: Code duplicated, block: B:416:0x0854  */
    /* JADX WARN: Code duplicated, block: B:419:0x0862  */
    /* JADX WARN: Code duplicated, block: B:422:0x086b  */
    /* JADX WARN: Code duplicated, block: B:427:0x0890  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:430:0x0895  */
    /* JADX WARN: Code duplicated, block: B:431:0x08a4  */
    /* JADX WARN: Code duplicated, block: B:433:0x08b7  */
    /* JADX WARN: Code duplicated, block: B:435:0x08ba  */
    /* JADX WARN: Code duplicated, block: B:437:0x08c6  */
    /* JADX WARN: Code duplicated, block: B:439:0x08dc  */
    /* JADX WARN: Code duplicated, block: B:443:0x08ec  */
    /* JADX WARN: Code duplicated, block: B:445:0x08f2  */
    /* JADX WARN: Code duplicated, block: B:446:0x08f4  */
    /* JADX WARN: Code duplicated, block: B:448:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:450:0x0900  */
    /* JADX WARN: Code duplicated, block: B:454:0x0917  */
    /* JADX WARN: Code duplicated, block: B:456:0x091a  */
    /* JADX WARN: Code duplicated, block: B:459:0x0922  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:461:0x0930  */
    /* JADX WARN: Code duplicated, block: B:463:0x0933  */
    /* JADX WARN: Code duplicated, block: B:465:0x0941  */
    /* JADX WARN: Code duplicated, block: B:468:0x0946  */
    /* JADX WARN: Code duplicated, block: B:473:0x0950  */
    /* JADX WARN: Code duplicated, block: B:476:0x0960  */
    /* JADX WARN: Code duplicated, block: B:478:0x0972  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:480:0x0986  */
    /* JADX WARN: Code duplicated, block: B:482:0x0997  */
    /* JADX WARN: Code duplicated, block: B:486:0x09a4  */
    /* JADX WARN: Code duplicated, block: B:488:0x09aa  */
    /* JADX WARN: Code duplicated, block: B:489:0x09ad  */
    /* JADX WARN: Code duplicated, block: B:491:0x09b1  */
    /* JADX WARN: Code duplicated, block: B:492:0x09b4  */
    /* JADX WARN: Code duplicated, block: B:495:0x09c4  */
    /* JADX WARN: Code duplicated, block: B:497:0x09da  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:500:0x09ef A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:503:0x09ff  */
    /* JADX WARN: Code duplicated, block: B:505:0x0a02  */
    /* JADX WARN: Code duplicated, block: B:507:0x0a10  */
    /* JADX WARN: Code duplicated, block: B:510:0x0a14  */
    /* JADX WARN: Code duplicated, block: B:513:0x0a29  */
    /* JADX WARN: Code duplicated, block: B:516:0x0a33  */
    /* JADX WARN: Code duplicated, block: B:518:0x0a3b  */
    /* JADX WARN: Code duplicated, block: B:520:0x0a46  */
    /* JADX WARN: Code duplicated, block: B:521:0x0a49  */
    /* JADX WARN: Code duplicated, block: B:523:0x0a4f  */
    /* JADX WARN: Code duplicated, block: B:526:0x0a57  */
    /* JADX WARN: Code duplicated, block: B:528:0x0a60  */
    /* JADX WARN: Code duplicated, block: B:529:0x0a63  */
    /* JADX WARN: Code duplicated, block: B:533:0x0a72 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:536:0x0a82  */
    /* JADX WARN: Code duplicated, block: B:538:0x0a85  */
    /* JADX WARN: Code duplicated, block: B:53:0x0102  */
    /* JADX WARN: Code duplicated, block: B:540:0x0a93  */
    /* JADX WARN: Code duplicated, block: B:543:0x0a97  */
    /* JADX WARN: Code duplicated, block: B:546:0x0aac  */
    /* JADX WARN: Code duplicated, block: B:549:0x0ab6  */
    /* JADX WARN: Code duplicated, block: B:551:0x0abc  */
    /* JADX WARN: Code duplicated, block: B:554:0x0acc  */
    /* JADX WARN: Code duplicated, block: B:557:0x0adc  */
    /* JADX WARN: Code duplicated, block: B:560:0x0ae9  */
    /* JADX WARN: Code duplicated, block: B:561:0x0aed  */
    /* JADX WARN: Code duplicated, block: B:564:0x0afc  */
    /* JADX WARN: Code duplicated, block: B:566:0x0b06  */
    /* JADX WARN: Code duplicated, block: B:569:0x0b1c  */
    /* JADX WARN: Code duplicated, block: B:56:0x010f  */
    /* JADX WARN: Code duplicated, block: B:572:0x0b32  */
    /* JADX WARN: Code duplicated, block: B:575:0x0b4a  */
    /* JADX WARN: Code duplicated, block: B:577:0x0b5a  */
    /* JADX WARN: Code duplicated, block: B:579:0x0b70  */
    /* JADX WARN: Code duplicated, block: B:580:0x0b72  */
    /* JADX WARN: Code duplicated, block: B:582:0x0b75  */
    /* JADX WARN: Code duplicated, block: B:584:0x0b89  */
    /* JADX WARN: Code duplicated, block: B:586:0x0b94  */
    /* JADX WARN: Code duplicated, block: B:590:0x0bb9  */
    /* JADX WARN: Code duplicated, block: B:592:0x0bbf  */
    /* JADX WARN: Code duplicated, block: B:593:0x0bc1  */
    /* JADX WARN: Code duplicated, block: B:595:0x0bcb  */
    /* JADX WARN: Code duplicated, block: B:597:0x0bd2  */
    /* JADX WARN: Code duplicated, block: B:599:0x0bd6  */
    /* JADX WARN: Code duplicated, block: B:59:0x011c  */
    /* JADX WARN: Code duplicated, block: B:601:0x0be3  */
    /* JADX WARN: Code duplicated, block: B:604:0x0bf4  */
    /* JADX WARN: Code duplicated, block: B:606:0x0bff  */
    /* JADX WARN: Code duplicated, block: B:610:0x0c24  */
    /* JADX WARN: Code duplicated, block: B:611:0x0c28  */
    /* JADX WARN: Code duplicated, block: B:614:0x0c35  */
    /* JADX WARN: Code duplicated, block: B:615:0x0c48  */
    /* JADX WARN: Code duplicated, block: B:618:0x0c52  */
    /* JADX WARN: Code duplicated, block: B:621:0x0c63  */
    /* JADX WARN: Code duplicated, block: B:632:0x0c78  */
    /* JADX WARN: Code duplicated, block: B:634:0x0c7d  */
    /* JADX WARN: Code duplicated, block: B:637:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x02df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0370 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x03d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x0562 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x0552 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x07bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x07b7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x0999 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x0999 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:0x0ba1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:681:0x08df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x014c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0151  */
    /* JADX WARN: Code duplicated, block: B:73:0x0160  */
    /* JADX WARN: Code duplicated, block: B:75:0x017a  */
    /* JADX WARN: Code duplicated, block: B:77:0x018a  */
    /* JADX WARN: Code duplicated, block: B:80:0x018e  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:99:0x01de  */
    /* JADX WARN: Instruction removed from duplicated block: B:606:0x0bff, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:634:0x0c7d, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r14v24, types: [java.lang.Class, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.accessibility.AccessibilityNodeInfo] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v107 */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.view.accessibility.AccessibilityNodeInfo] */
    /* JADX WARN: Type inference failed for: r2v90, types: [ii0] */
    /* JADX WARN: Type inference failed for: r2v91, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v92, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v53, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v54, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v75 */
    public h3 s(int i) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain;
        h3 h3Var;
        int i2;
        h3 h3Var2;
        gg2 gg2VarL;
        Integer numValueOf;
        int iIntValue;
        kl1 kl1Var;
        mp2 mp2Var;
        Resources resources;
        gm1 gm1Var;
        Object objG;
        boolean zI;
        List listI;
        int size;
        boolean z;
        int i3;
        int i4;
        int i5;
        AccessibilityNodeInfo accessibilityNodeInfo;
        be beVarE;
        x7 x7Var;
        kl1 kl1Var2;
        gg2 gg2Var;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        cg2 cg2Var;
        AccessibilityNodeInfo accessibilityNodeInfo3;
        h3 h3Var3;
        Object r0;
        Object r1;
        ng2 ng2Var;
        Object r2;
        gg2 gg2Var2;
        String strD;
        Object objG2;
        d13 d13Var;
        Object objG3;
        Boolean bool;
        Object objG4;
        List list;
        Object r3;
        Object objG5;
        String str;
        Object objG6;
        h3 h3Var4;
        int i6;
        Object objG7;
        Integer num;
        int iIntValue2;
        ng2 ng2Var2;
        x7 x7Var2;
        boolean z2;
        Object objG8;
        Object objG9;
        b2 b2Var;
        Object objG10;
        b2 b2Var2;
        Object objG11;
        b2 b2Var3;
        String strL;
        ArrayList arrayList;
        CharSequence charSequenceE;
        q12 q12Var;
        float f;
        Object objG12;
        lz lzVar;
        ArrayList arrayList2;
        Object objG13;
        float f2;
        boolean zA;
        int size2;
        int size3;
        List listI2;
        int size4;
        int i7;
        gg2 gg2Var3;
        Object objG14;
        ed2 ed2Var;
        ed2 ed2Var2;
        int i8;
        CharSequence charSequence;
        boolean zB;
        int iD;
        r7 r7Var;
        int iD2;
        String str2;
        h3 h3Var5;
        b2 b2Var4;
        b2 b2Var5;
        b2 b2Var6;
        ng2 ng2Var3;
        List list2;
        int size5;
        ll1 ll1Var;
        boolean z3;
        ul1 ul1Var;
        int[] iArr;
        int i9;
        int[] iArrCopyOf;
        int i10;
        int i11;
        ul1 ul1Var2;
        ArrayList arrayList3;
        int i12;
        Object objG15;
        Object objG16;
        Object objG17;
        boolean zR;
        z61 z61Var;
        n71 n71Var;
        d3 d3Var;
        d3 d3Var2;
        Object objG18;
        gg2 gg2VarL2;
        Object objG19;
        Object objG20;
        lz lzVar2;
        ArrayList arrayList4;
        List listI3;
        int size6;
        int i13;
        int i14;
        boolean zA2;
        int i15;
        int i16;
        Object objG21;
        gg2 gg2Var4;
        b2 b2Var7;
        ng2 ng2Var4;
        b2 b2Var8;
        String str3;
        List list3;
        n71 n71VarU;
        cg2 cg2VarW;
        boolean zA3;
        Object objG22;
        cg2 cg2VarW2;
        Object objG23;
        b2 b2Var9;
        Object objG24;
        b2 b2Var10;
        Object objG25;
        b2 b2Var11;
        b2 b2Var12;
        ClipDescription primaryClipDescription;
        boolean zHasMimeType;
        Object objG26;
        int iD3;
        gg2 gg2VarL3;
        boolean zBooleanValue;
        cg2 cg2Var2;
        ng2 ng2Var5;
        Object objG27;
        jc0 density;
        b13 b13Var;
        SpannableString spannableString;
        List list4;
        ArrayList arrayList5;
        b13 b13Var2;
        SpannableString spannableString2;
        Object arrayList6;
        Object arrayList7;
        int size7;
        int i17;
        Object arrayList8;
        int size8;
        int i18;
        b13 b13Var3;
        int size9;
        int i19;
        ae aeVar;
        int i20;
        Object obj;
        int i21;
        kc1 kc1Var;
        WeakHashMap weakHashMap;
        Object c20Var;
        ae aeVar2;
        jc1 jc1Var;
        WeakHashMap weakHashMap2;
        Object uRLSpan;
        int size10;
        int i22;
        ae aeVar3;
        m53 m53Var;
        WeakHashMap weakHashMap3;
        Object uRLSpan2;
        int size11;
        int i23;
        ae aeVar4;
        a73 a73Var;
        int i24;
        int i25;
        int size12;
        int i26;
        ae aeVar5;
        int size13;
        int i27;
        int i28;
        int i29;
        long jC;
        np0 np0Var;
        lp0 lp0Var;
        vy2 vy2Var;
        long j;
        sx2 sx2Var;
        uy2 f00Var;
        SpannableString spannableString3;
        np0 np0Var2;
        int i30;
        int i31;
        int i32;
        gg2 gg2Var5;
        c21 c21VarK;
        int i33;
        ig2 ig2Var;
        boolean zA4;
        gg2 gg2Var6;
        Object parentForAccessibility;
        View view;
        qb1 qb1VarF;
        x7 x7Var3 = (x7) this.c;
        AccessibilityManager accessibilityManager = x7Var3.j;
        r7 r7Var2 = x7Var3.e;
        f7 viewTreeOwners = r7Var2.getViewTreeOwners();
        if (((viewTreeOwners == null || (qb1VarF = viewTreeOwners.a.f()) == null) ? null : qb1VarF.d) == eb1.a) {
            if (accessibilityManager.isEnabled()) {
                h3Var5 = null;
            } else {
                h3Var5 = new h3(AccessibilityNodeInfo.obtain());
            }
            x7Var2 = x7Var3;
            i6 = i;
        } else {
            ig2 ig2Var2 = (ig2) x7Var3.k().b(i);
            if (ig2Var2 == null) {
                if (accessibilityManager.isEnabled()) {
                    h3Var5 = null;
                } else {
                    h3Var5 = new h3(AccessibilityNodeInfo.obtain());
                }
                x7Var2 = x7Var3;
                i6 = i;
            } else {
                gg2 gg2Var7 = ig2Var2.a;
                cg2 cg2VarK = gg2Var7.k();
                n71 n71Var2 = gg2Var7.c;
                cg2 cg2Var3 = gg2Var7.d;
                Object objG28 = cg2VarK.a.g(kg2.n);
                if (objG28 == null) {
                    objG28 = null;
                }
                boolean zA5 = g31.a(objG28, Boolean.TRUE);
                if (!zA5) {
                    accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
                    h3Var = new h3(accessibilityNodeInfoObtain);
                    i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 34) {
                        v2.l(accessibilityNodeInfoObtain, zA5);
                    } else {
                        h3Var.f(64, zA5);
                    }
                    if (i == -1) {
                        parentForAccessibility = r7Var2.getParentForAccessibility();
                        h3Var2 = null;
                        if (parentForAccessibility instanceof View) {
                            view = (View) parentForAccessibility;
                        } else {
                            view = null;
                        }
                        h3Var.b = -1;
                        accessibilityNodeInfoObtain.setParent(view);
                    } else {
                        h3Var2 = null;
                        gg2VarL = gg2Var7.l();
                        if (gg2VarL != null) {
                            numValueOf = Integer.valueOf(gg2VarL.g);
                        } else {
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            z01.c("semanticsNode " + i + " has null parent");
                            og.k();
                            return null;
                        }
                        iIntValue = numValueOf.intValue();
                        if (iIntValue == r7Var2.getSemanticsOwner().a().g) {
                            iIntValue = -1;
                        }
                        h3Var.b = iIntValue;
                        accessibilityNodeInfoObtain.setParent(r7Var2, iIntValue);
                    }
                    h3Var.c = i;
                    accessibilityNodeInfoObtain.setSource(r7Var2, i);
                    accessibilityNodeInfoObtain.setBoundsInScreen(x7Var3.c(ig2Var2));
                    kl1Var = x7Var3.t0;
                    mp2Var = x7Var3.c0;
                    resources = r7Var2.getContext().getResources();
                    h3Var.g("android.view.View");
                    gm1Var = cg2Var3.a;
                    if (gm1Var.c(kg2.E)) {
                        h3Var.g("android.widget.EditText");
                    }
                    if (gm1Var.c(kg2.A)) {
                        h3Var.g("android.widget.TextView");
                    }
                    objG = gm1Var.g(kg2.x);
                    if (objG == null) {
                        objG = h3Var2;
                    }
                    if (((m82) objG) != null && (gg2Var7.e || gg2Var7.i((4 & 1) != 0 ? !gg2Var7.b : false, (4 & 2) == 0).isEmpty())) {
                        h3Var.g("android.widget.Button");
                    }
                    accessibilityNodeInfoObtain.setPackageName(r7Var2.getContext().getPackageName());
                    accessibilityNodeInfoObtain.setImportantForAccessibility(o44.f(gg2Var7));
                    if (i2 >= 34) {
                        zI = v2.i(accessibilityManager);
                    } else {
                        zI = true;
                    }
                    listI = gg2Var7.i((4 & 1) != 0 ? !gg2Var7.b : false, (4 & 2) == 0);
                    size = listI.size();
                    z = zI;
                    i3 = 0;
                    i4 = 0;
                    while (i4 < size) {
                        List list5 = listI;
                        gg2Var5 = (gg2) listI.get(i4);
                        int i34 = i4;
                        c21VarK = x7Var3.k();
                        int i35 = size;
                        i33 = gg2Var5.g;
                        if (!c21VarK.a(i33)) {
                            if (r7Var2.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(gg2Var5.c) == null) {
                                dk0.t();
                                return h3Var2;
                            }
                            if (i33 != -1) {
                                ig2Var = (ig2) x7Var3.k().b(i33);
                                if (ig2Var != null || (gg2Var6 = ig2Var.a) == null) {
                                    zA4 = false;
                                } else {
                                    Object objG29 = gg2Var6.k().a.g(kg2.n);
                                    if (objG29 == null) {
                                        objG29 = h3Var2;
                                    }
                                    zA4 = g31.a(objG29, Boolean.TRUE);
                                }
                                if (z || !zA4) {
                                    accessibilityNodeInfoObtain.addChild(r7Var2, i33);
                                }
                                kl1Var.f(i33, i3);
                                i3++;
                            }
                        }
                        i4 = i34 + 1;
                        listI = list5;
                        size = i35;
                    }
                    i5 = x7Var3.u;
                    accessibilityNodeInfo = h3Var.a;
                    if (i == i5) {
                        accessibilityNodeInfo.setAccessibilityFocused(true);
                        h3Var.a(d3.d);
                    } else {
                        accessibilityNodeInfo.setAccessibilityFocused(false);
                        h3Var.a(d3.c);
                    }
                    beVarE = pc4.e(gg2Var7);
                    if (beVarE != null) {
                        r7Var2.getFontFamilyResolver();
                        density = r7Var2.getDensity();
                        b13Var = x7Var3.p0;
                        String str4 = beVarE.b;
                        list4 = beVarE.a;
                        spannableString = new SpannableString(str4);
                        arrayList5 = beVarE.c;
                        if (arrayList5 != null) {
                            size13 = arrayList5.size();
                            i27 = 0;
                            while (i27 < size13) {
                                ArrayList arrayList9 = arrayList5;
                                ae aeVar6 = (ae) arrayList5.get(i27);
                                int i36 = size13;
                                hp2 hp2Var = (hp2) aeVar6.a;
                                int i37 = i27;
                                i28 = aeVar6.b;
                                i29 = aeVar6.c;
                                x7 x7Var4 = x7Var3;
                                jC = hp2Var.a.c();
                                AccessibilityNodeInfo accessibilityNodeInfo4 = accessibilityNodeInfoObtain;
                                h3 h3Var6 = h3Var;
                                long j2 = hp2Var.b;
                                np0Var = hp2Var.c;
                                lp0Var = hp2Var.d;
                                vy2Var = hp2Var.j;
                                kl1 kl1Var3 = kl1Var;
                                ne1 ne1Var = hp2Var.k;
                                gg2 gg2Var8 = gg2Var7;
                                AccessibilityNodeInfo accessibilityNodeInfo5 = accessibilityNodeInfo;
                                j = hp2Var.l;
                                sx2Var = hp2Var.m;
                                f00Var = hp2Var.a;
                                cg2 cg2Var4 = cg2Var3;
                                b13 b13Var4 = b13Var;
                                if (!sz.c(jC, f00Var.c())) {
                                    if (jC != 16) {
                                        f00Var = new f00(jC);
                                    } else {
                                        f00Var = el1.j;
                                    }
                                }
                                m54.b(spannableString, f00Var.c(), i28, i29);
                                spannableString3 = spannableString;
                                m54.c(spannableString3, j2, density, i28, i29);
                                if (np0Var == null || lp0Var != null) {
                                    if (np0Var == null) {
                                        np0Var2 = np0.c;
                                    } else {
                                        np0Var2 = np0Var;
                                    }
                                    if (lp0Var != null) {
                                        i30 = lp0Var.a;
                                    } else {
                                        i30 = 0;
                                    }
                                    StyleSpan styleSpan = new StyleSpan(xc4.a(np0Var2, i30));
                                    i31 = 33;
                                    spannableString3.setSpan(styleSpan, i28, i29, 33);
                                } else {
                                    i31 = 33;
                                }
                                if (sx2Var != null) {
                                    i32 = sx2Var.a;
                                    if ((i32 | 1) == i32) {
                                        spannableString3.setSpan(new UnderlineSpan(), i28, i29, i31);
                                    }
                                    if ((i32 | 2) == i32) {
                                        spannableString3.setSpan(new StrikethroughSpan(), i28, i29, i31);
                                    }
                                }
                                if (vy2Var != null) {
                                    spannableString3.setSpan(new ScaleXSpan(vy2Var.a), i28, i29, i31);
                                }
                                m54.d(spannableString3, ne1Var, i28, i29);
                                if (j != 16) {
                                    spannableString3.setSpan(new BackgroundColorSpan(ki4.g(j)), i28, i29, i31);
                                }
                                i27 = i37 + 1;
                                spannableString = spannableString3;
                                cg2Var3 = cg2Var4;
                                arrayList5 = arrayList9;
                                size13 = i36;
                                x7Var3 = x7Var4;
                                accessibilityNodeInfoObtain = accessibilityNodeInfo4;
                                h3Var = h3Var6;
                                kl1Var = kl1Var3;
                                gg2Var7 = gg2Var8;
                                accessibilityNodeInfo = accessibilityNodeInfo5;
                                b13Var = b13Var4;
                            }
                        }
                        x7Var = x7Var3;
                        kl1Var2 = kl1Var;
                        gg2Var = gg2Var7;
                        accessibilityNodeInfo2 = accessibilityNodeInfo;
                        cg2Var = cg2Var3;
                        b13Var2 = b13Var;
                        accessibilityNodeInfo3 = accessibilityNodeInfoObtain;
                        h3Var3 = h3Var;
                        spannableString2 = spannableString;
                        int length = str4.length();
                        arrayList6 = ii0.a;
                        if (list4 != null) {
                            arrayList7 = new ArrayList(list4.size());
                            size12 = list4.size();
                            while (i26 < size12) {
                                Object obj2 = list4.get(i26);
                                aeVar5 = (ae) obj2;
                                if (!(aeVar5.a instanceof a73) && ce.b(0, length, aeVar5.b, aeVar5.c)) {
                                    arrayList7.add(obj2);
                                }
                            }
                        } else {
                            arrayList7 = arrayList6;
                        }
                        size7 = arrayList7.size();
                        while (i17 < size7) {
                            ae aeVar7 = (ae) arrayList7.get(i17);
                            a73Var = (a73) aeVar7.a;
                            i24 = aeVar7.b;
                            i25 = aeVar7.c;
                            if (a73Var instanceof a73) {
                                dk0.l();
                                return h3Var2;
                            }
                            spannableString2.setSpan(new TtsSpan.VerbatimBuilder(a73Var.a).build(), i24, i25, 33);
                        }
                        int length2 = str4.length();
                        if (list4 != null) {
                            arrayList8 = new ArrayList(list4.size());
                            size11 = list4.size();
                            while (i23 < size11) {
                                Object obj3 = list4.get(i23);
                                aeVar4 = (ae) obj3;
                                if (!(aeVar4.a instanceof m53) && ce.b(0, length2, aeVar4.b, aeVar4.c)) {
                                    arrayList8.add(obj3);
                                }
                            }
                        } else {
                            arrayList8 = arrayList6;
                        }
                        size8 = arrayList8.size();
                        i18 = 0;
                        while (i18 < size8) {
                            ae aeVar8 = (ae) arrayList8.get(i18);
                            m53Var = (m53) aeVar8.a;
                            int i38 = aeVar8.b;
                            int i39 = aeVar8.c;
                            b13 b13Var5 = b13Var2;
                            weakHashMap3 = (WeakHashMap) b13Var5.a;
                            uRLSpan2 = weakHashMap3.get(m53Var);
                            if (uRLSpan2 == null) {
                                uRLSpan2 = new URLSpan(m53Var.a);
                                weakHashMap3.put(m53Var, uRLSpan2);
                            }
                            spannableString2.setSpan((URLSpan) uRLSpan2, i38, i39, 33);
                            i18++;
                            b13Var2 = b13Var5;
                        }
                        b13Var3 = b13Var2;
                        int length3 = str4.length();
                        if (list4 != null) {
                            arrayList6 = new ArrayList(list4.size());
                            size10 = list4.size();
                            while (i22 < size10) {
                                Object obj4 = list4.get(i22);
                                aeVar3 = (ae) obj4;
                                if (!(aeVar3.a instanceof kc1) && ce.b(0, length3, aeVar3.b, aeVar3.c)) {
                                    arrayList6.add(obj4);
                                }
                            }
                        }
                        size9 = arrayList6.size();
                        while (i19 < size9) {
                            aeVar = (ae) arrayList6.get(i19);
                            i20 = aeVar.b;
                            obj = aeVar.a;
                            i21 = aeVar.c;
                            if (i20 != i21) {
                                kc1Var = (kc1) obj;
                                if (kc1Var instanceof jc1) {
                                    obj.getClass();
                                    jc1Var = (jc1) obj;
                                    aeVar2 = new ae(jc1Var, i20, i21);
                                    weakHashMap2 = (WeakHashMap) b13Var3.b;
                                    uRLSpan = weakHashMap2.get(aeVar2);
                                    if (uRLSpan == null) {
                                        uRLSpan = new URLSpan(jc1Var.a);
                                        weakHashMap2.put(aeVar2, uRLSpan);
                                    }
                                    spannableString2.setSpan((URLSpan) uRLSpan, i20, i21, 33);
                                } else {
                                    weakHashMap = (WeakHashMap) b13Var3.c;
                                    c20Var = weakHashMap.get(aeVar);
                                    if (c20Var == null) {
                                        c20Var = new c20(kc1Var);
                                        weakHashMap.put(aeVar, c20Var);
                                    }
                                    spannableString2.setSpan((ClickableSpan) c20Var, i20, i21, 33);
                                }
                            }
                        }
                        r0 = (SpannableString) x7.H(spannableString2);
                    } else {
                        x7Var = x7Var3;
                        kl1Var2 = kl1Var;
                        gg2Var = gg2Var7;
                        accessibilityNodeInfo2 = accessibilityNodeInfo;
                        n71Var2 = n71Var2;
                        cg2Var = cg2Var3;
                        accessibilityNodeInfo3 = accessibilityNodeInfoObtain;
                        h3Var3 = h3Var;
                        r0 = h3Var2;
                    }
                    r1 = accessibilityNodeInfo2;
                    r1.setText(r0);
                    ng2Var = kg2.K;
                    if (gm1Var.c(ng2Var)) {
                        AccessibilityNodeInfo accessibilityNodeInfo6 = accessibilityNodeInfo3;
                        accessibilityNodeInfo6.setContentInvalid(true);
                        objG27 = gm1Var.g(ng2Var);
                        if (objG27 == null) {
                            objG27 = h3Var2;
                        }
                        accessibilityNodeInfo6.setError((CharSequence) objG27);
                        r2 = accessibilityNodeInfo6;
                    } else {
                        r2 = accessibilityNodeInfo3;
                    }
                    gg2Var2 = gg2Var;
                    strD = pc4.d(gg2Var2, resources);
                    if (Build.VERSION.SDK_INT >= 30) {
                        e3.j(r1, strD);
                    } else {
                        r1.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", strD);
                    }
                    r2.setCheckable(pc4.c(gg2Var2));
                    objG2 = gm1Var.g(kg2.I);
                    if (objG2 == null) {
                        objG2 = h3Var2;
                    }
                    d13Var = (d13) objG2;
                    if (d13Var != null) {
                        if (d13Var == d13.a) {
                            r1.setChecked(true);
                        } else if (d13Var == d13.b) {
                            r1.setChecked(false);
                        }
                    }
                    objG3 = gm1Var.g(kg2.H);
                    if (objG3 == null) {
                        objG3 = h3Var2;
                    }
                    bool = (Boolean) objG3;
                    if (bool != null) {
                        r1.setChecked(bool.booleanValue());
                    }
                    if (cg2Var.c || gg2Var2.i((4 & 1) != 0 ? !gg2Var2.b : false, (4 & 2) == 0).isEmpty()) {
                        objG4 = gm1Var.g(kg2.a);
                        if (objG4 == null) {
                            objG4 = h3Var2;
                        }
                        list = (List) objG4;
                        if (list != null) {
                            r3 = (String) mz.y(list);
                        } else {
                            r3 = h3Var2;
                        }
                        r2.setContentDescription(r3);
                    }
                    objG5 = gm1Var.g(kg2.y);
                    if (objG5 == null) {
                        objG5 = h3Var2;
                    }
                    str = (String) objG5;
                    if (str != null) {
                        gg2VarL3 = gg2Var2;
                        while (true) {
                            if (gg2VarL3 != null) {
                                zBooleanValue = false;
                                break;
                            }
                            cg2Var2 = gg2VarL3.d;
                            ng2Var5 = lg2.a;
                            if (cg2Var2.a.c(ng2Var5)) {
                                zBooleanValue = ((Boolean) cg2Var2.d(ng2Var5)).booleanValue();
                                break;
                            }
                            gg2VarL3 = gg2VarL3.l();
                        }
                        if (zBooleanValue) {
                            r2.setViewIdResourceName(str);
                        }
                    }
                    objG6 = gm1Var.g(kg2.h);
                    if (objG6 == null) {
                        objG6 = h3Var2;
                    }
                    if (((q43) objG6) == null) {
                        h3Var4 = h3Var3;
                    } else if (Build.VERSION.SDK_INT >= 28) {
                        r1.setHeading(true);
                        h3Var4 = h3Var3;
                    } else {
                        h3Var4 = h3Var3;
                        h3Var4.f(2, true);
                    }
                    i6 = i;
                    if (i6 != -1) {
                        iD3 = kl1Var2.d(gg2Var2.g);
                        if (iD3 != -1) {
                            r2.setDrawingOrder(iD3);
                        } else {
                            Log.w("AccessibilityDelegate", "Drawing order is not available, was AccessibilityNodeInfo requested for a child node before its parent?");
                        }
                    }
                    r2.setPassword(gm1Var.c(kg2.J));
                    r2.setEditable(gm1Var.c(kg2.M));
                    objG7 = gm1Var.g(kg2.N);
                    if (objG7 == null) {
                        objG7 = h3Var2;
                    }
                    num = (Integer) objG7;
                    if (num != null) {
                        iIntValue2 = num.intValue();
                    } else {
                        iIntValue2 = -1;
                    }
                    r2.setMaxTextLength(iIntValue2);
                    r2.setEnabled(pc4.a(gg2Var2));
                    ng2Var2 = kg2.k;
                    r2.setFocusable(gm1Var.c(ng2Var2));
                    if (r2.isFocusable()) {
                        r2.setFocused(((Boolean) cg2Var.d(ng2Var2)).booleanValue());
                        if (r2.isFocused()) {
                            r1.addAction(2);
                            x7Var2 = x7Var;
                            x7Var2.v = i6;
                        } else {
                            x7Var2 = x7Var;
                            z2 = true;
                            r1.addAction(1);
                        }
                        r2.setVisibleToUser(o44.e(gg2Var2) ^ z2);
                        objG8 = gm1Var.g(kg2.j);
                        if (objG8 == null) {
                            objG8 = h3Var2;
                        }
                        if (objG8 == null) {
                            dk0.t();
                            return null;
                        }
                        r1.setClickable(false);
                        objG9 = gm1Var.g(bg2.b);
                        if (objG9 == null) {
                            objG9 = h3Var2;
                        }
                        b2Var = (b2) objG9;
                        if (b2Var != null) {
                            objG26 = gm1Var.g(kg2.H);
                            if (objG26 == null) {
                                objG26 = h3Var2;
                            }
                            g31.a(objG26, Boolean.TRUE);
                            r1.setClickable(true);
                            if (pc4.a(gg2Var2) && r2.isClickable()) {
                                var r14 = h3Var2;
                                h3Var4.a(new d3(r14, 16, b2Var.a, r14));
                            }
                        }
                        r1.setLongClickable(false);
                        objG10 = gm1Var.g(bg2.c);
                        if (objG10 == null) {
                            objG10 = null;
                        }
                        b2Var2 = (b2) objG10;
                        if (b2Var2 != null) {
                            r1.setLongClickable(true);
                            if (pc4.a(gg2Var2)) {
                                h3Var4.a(new d3(null, 32, b2Var2.a, null));
                            }
                        }
                        objG11 = gm1Var.g(bg2.q);
                        if (objG11 == null) {
                            objG11 = null;
                        }
                        b2Var3 = (b2) objG11;
                        if (b2Var3 != null) {
                            h3Var4.a(new d3(null, 16384, b2Var3.a, null));
                        }
                        if (pc4.a(gg2Var2)) {
                            objG23 = gm1Var.g(bg2.k);
                            if (objG23 == null) {
                                objG23 = null;
                            }
                            b2Var9 = (b2) objG23;
                            if (b2Var9 != null) {
                                h3Var4.a(new d3(null, ArabicShaping.SEEN_TWOCELL_NEAR, b2Var9.a, null));
                            }
                            objG24 = gm1Var.g(bg2.p);
                            if (objG24 == null) {
                                objG24 = null;
                            }
                            b2Var10 = (b2) objG24;
                            if (b2Var10 != null) {
                                h3Var4.a(new d3(null, R.id.accessibilityActionImeEnter, b2Var10.a, null));
                            }
                            objG25 = gm1Var.g(bg2.r);
                            if (objG25 == null) {
                                objG25 = null;
                            }
                            b2Var11 = (b2) objG25;
                            if (b2Var11 != null) {
                                h3Var4.a(new d3(null, 65536, b2Var11.a, null));
                            }
                            b2Var12 = (b2) y24.a(cg2Var, bg2.s);
                            if (b2Var12 != null && r2.isFocused()) {
                                primaryClipDescription = r7Var2.getClipboardManager().a.getPrimaryClipDescription();
                                if (primaryClipDescription != null) {
                                    zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                                } else {
                                    zHasMimeType = false;
                                }
                                if (zHasMimeType) {
                                    h3Var4.a(new d3(null, 32768, b2Var12.a, null));
                                }
                            }
                        }
                        strL = x7.l(gg2Var2);
                        if (strL != null && strL.length() != 0) {
                            r2.setTextSelection(x7Var2.j(gg2Var2), x7Var2.i(gg2Var2));
                            b2Var8 = (b2) y24.a(cg2Var, bg2.j);
                            if (b2Var8 != null) {
                                str3 = b2Var8.a;
                            } else {
                                str3 = null;
                            }
                            h3Var4.a(new d3(Normalizer.INPUT_IS_FCD, str3));
                            r1.addAction(256);
                            r1.addAction(512);
                            r1.setMovementGranularities(11);
                            list3 = (List) y24.a(cg2Var, kg2.a);
                            if ((list3 != null || list3.isEmpty()) && gm1Var.c(bg2.a) && (!gm1Var.c(kg2.E) || g31.a(y24.a(cg2Var, ng2Var2), Boolean.TRUE))) {
                                n71VarU = n71Var2.u();
                                while (true) {
                                    if (n71VarU == null) {
                                        n71VarU = null;
                                        break;
                                    }
                                    cg2VarW2 = n71VarU.w();
                                    if (cg2VarW2 == null && cg2VarW2.c) {
                                        if (cg2VarW2.a.c(kg2.E)) {
                                            break;
                                        }
                                    }
                                    n71VarU = n71VarU.u();
                                }
                                if (n71VarU == null) {
                                    r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                } else {
                                    cg2VarW = n71VarU.w();
                                    if (cg2VarW != null) {
                                        objG22 = cg2VarW.a.g(ng2Var2);
                                        if (objG22 == null) {
                                            objG22 = null;
                                        }
                                        zA3 = g31.a(objG22, Boolean.TRUE);
                                    } else {
                                        zA3 = false;
                                    }
                                    if (zA3) {
                                        r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                    }
                                }
                            }
                        }
                        arrayList = new ArrayList();
                        arrayList.add("androidx.compose.ui.semantics.id");
                        charSequenceE = h3Var4.e();
                        if (charSequenceE != null && charSequenceE.length() != 0 && gm1Var.c(bg2.a)) {
                            arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                        }
                        if (gm1Var.c(kg2.y)) {
                            arrayList.add("androidx.compose.ui.semantics.testTag");
                        }
                        if (gm1Var.c(kg2.O)) {
                            arrayList.add("androidx.compose.ui.semantics.shapeType");
                            arrayList.add("androidx.compose.ui.semantics.shapeRect");
                            arrayList.add("androidx.compose.ui.semantics.shapeCorners");
                            arrayList.add("androidx.compose.ui.semantics.shapeRegion");
                        }
                        r2.setAvailableExtraData(arrayList);
                        q12Var = (q12) y24.a(cg2Var, kg2.c);
                        f = 0.0f;
                        if (q12Var != null) {
                            ng2Var4 = bg2.i;
                            if (gm1Var.c(ng2Var4)) {
                                h3Var4.g("android.widget.SeekBar");
                            } else {
                                h3Var4.g("android.widget.ProgressBar");
                            }
                            if (q12Var != q12.b) {
                                r2.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, 0.0f, 0.0f, 0.0f));
                            }
                            if (gm1Var.c(ng2Var4)) {
                                pc4.a(gg2Var2);
                            }
                        }
                        if (pc4.a(gg2Var2) && (b2Var7 = (b2) y24.a(cg2Var, bg2.i)) != null) {
                            h3Var4.a(new d3(R.id.accessibilityActionSetProgress, b2Var7.a));
                        }
                        objG12 = gg2Var2.k().a.g(kg2.f);
                        if (objG12 == null) {
                            objG12 = null;
                        }
                        lzVar = (lz) objG12;
                        if (lzVar != null) {
                            r1.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(lzVar.a, lzVar.b, false, 0));
                            f2 = 0.0f;
                        } else {
                            arrayList2 = new ArrayList();
                            objG13 = gg2Var2.k().a.g(kg2.e);
                            if (objG13 == null) {
                                objG13 = null;
                            }
                            if (objG13 != null) {
                                listI2 = gg2Var2.i((4 & 1) != 0 ? !gg2Var2.b : false, (4 & 2) == 0);
                                size4 = listI2.size();
                                i7 = 0;
                                while (i7 < size4) {
                                    gg2Var3 = (gg2) listI2.get(i7);
                                    float f3 = f;
                                    if (gg2Var3.k().a.c(kg2.H)) {
                                        arrayList2.add(gg2Var3);
                                    }
                                    i7++;
                                    f = f3;
                                }
                            }
                            f2 = f;
                            if (!arrayList2.isEmpty()) {
                                zA = hi4.a(arrayList2);
                                if (zA) {
                                    size2 = 1;
                                } else {
                                    size2 = arrayList2.size();
                                }
                                if (zA) {
                                    size3 = arrayList2.size();
                                } else {
                                    size3 = 1;
                                }
                                r1.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(size2, size3, false, 0));
                            }
                        }
                        objG14 = gg2Var2.k().a.g(kg2.g);
                        if (objG14 == null) {
                            objG14 = null;
                        }
                        if (objG14 == null) {
                            gg2VarL2 = gg2Var2.l();
                            if (gg2VarL2 != null) {
                                objG19 = gg2VarL2.k().a.g(kg2.e);
                                if (objG19 == null) {
                                    objG19 = null;
                                }
                                if (objG19 != null) {
                                    objG20 = gg2VarL2.k().a.g(kg2.f);
                                    if (objG20 == null) {
                                        objG20 = null;
                                    }
                                    lzVar2 = (lz) objG20;
                                    if (lzVar2 != null || (lzVar2.a >= 0 && lzVar2.b >= 0)) {
                                        if (gg2Var2.k().a.c(kg2.H)) {
                                            arrayList4 = new ArrayList();
                                            listI3 = gg2VarL2.i((4 & 1) != 0 ? !gg2VarL2.b : false, (4 & 2) == 0);
                                            size6 = listI3.size();
                                            i14 = 0;
                                            while (i13 < size6) {
                                                gg2Var4 = (gg2) listI3.get(i13);
                                                if (gg2Var4.k().a.c(kg2.H)) {
                                                    arrayList4.add(gg2Var4);
                                                    if (gg2Var4.c.v() < gg2Var2.c.v()) {
                                                        i14++;
                                                    }
                                                }
                                            }
                                            if (!arrayList4.isEmpty()) {
                                                zA2 = hi4.a(arrayList4);
                                                if (zA2) {
                                                    i15 = 0;
                                                } else {
                                                    i15 = i14;
                                                }
                                                if (zA2) {
                                                    i16 = i14;
                                                } else {
                                                    i16 = 0;
                                                }
                                                objG21 = gg2Var2.k().a.g(kg2.H);
                                                if (objG21 == null) {
                                                    objG21 = Boolean.FALSE;
                                                }
                                                r1.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i15, 1, i16, 1, false, ((Boolean) objG21).booleanValue()));
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            dk0.t();
                        }
                        ed2Var = (ed2) y24.a(cg2Var, kg2.u);
                        b2 b2Var13 = (b2) y24.a(cg2Var, bg2.d);
                        if (ed2Var != null && b2Var13 != null) {
                            objG17 = gg2Var2.k().a.g(kg2.f);
                            if (objG17 == null) {
                                objG17 = null;
                            }
                            if (objG17 == null) {
                                objG18 = gg2Var2.k().a.g(kg2.e);
                                if (objG18 == null) {
                                    objG18 = null;
                                }
                                if (objG18 == null) {
                                    h3Var4.g("android.widget.HorizontalScrollView");
                                }
                            }
                            if (((Number) ed2Var.b.a()).floatValue() > f2) {
                                r1.setScrollable(true);
                            }
                            if (pc4.a(gg2Var2)) {
                                zR = x7.r(ed2Var);
                                z61Var = z61.b;
                                if (zR) {
                                    h3Var4.a(d3.e);
                                    n71Var = n71Var2;
                                    if (n71Var.i0 == z61Var) {
                                        d3Var2 = d3.h;
                                    } else {
                                        d3Var2 = d3.j;
                                    }
                                    h3Var4.a(d3Var2);
                                } else {
                                    n71Var = n71Var2;
                                }
                                if (x7.q(ed2Var)) {
                                    h3Var4.a(d3.f);
                                    if (n71Var.i0 == z61Var) {
                                        d3Var = d3.j;
                                    } else {
                                        d3Var = d3.h;
                                    }
                                    h3Var4.a(d3Var);
                                }
                            }
                        }
                        ed2Var2 = (ed2) y24.a(cg2Var, kg2.v);
                        if (ed2Var2 != null && b2Var13 != null) {
                            objG15 = gg2Var2.k().a.g(kg2.f);
                            if (objG15 == null) {
                                objG15 = null;
                            }
                            if (objG15 == null) {
                                objG16 = gg2Var2.k().a.g(kg2.e);
                                if (objG16 == null) {
                                    objG16 = null;
                                }
                                if (objG16 == null) {
                                    h3Var4.g("android.widget.ScrollView");
                                }
                            }
                            if (((Number) ed2Var2.b.a()).floatValue() > f2) {
                                r1.setScrollable(true);
                            }
                            if (pc4.a(gg2Var2)) {
                                if (x7.r(ed2Var2)) {
                                    h3Var4.a(d3.e);
                                    h3Var4.a(d3.i);
                                }
                                if (x7.q(ed2Var2)) {
                                    h3Var4.a(d3.f);
                                    h3Var4.a(d3.g);
                                }
                            }
                        }
                        i8 = Build.VERSION.SDK_INT;
                        if (i8 >= 29) {
                            nc4.a(h3Var4, gg2Var2);
                        }
                        charSequence = (CharSequence) y24.a(cg2Var, kg2.d);
                        if (i8 >= 28) {
                            r1.setPaneTitle(charSequence);
                        } else {
                            r1.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
                        }
                        if (pc4.a(gg2Var2)) {
                            b2Var4 = (b2) y24.a(cg2Var, bg2.t);
                            if (b2Var4 != null) {
                                h3Var4.a(new d3(ArabicShaping.TASHKEEL_BEGIN, b2Var4.a));
                            }
                            b2Var5 = (b2) y24.a(cg2Var, bg2.u);
                            if (b2Var5 != null) {
                                h3Var4.a(new d3(ArabicShaping.TASHKEEL_RESIZE, b2Var5.a));
                            }
                            b2Var6 = (b2) y24.a(cg2Var, bg2.v);
                            if (b2Var6 != null) {
                                h3Var4.a(new d3(1048576, b2Var6.a));
                            }
                            ng2Var3 = bg2.x;
                            if (cg2Var.a.c(bg2.x)) {
                                list2 = (List) cg2Var.d(ng2Var3);
                                size5 = list2.size();
                                ll1Var = x7.x0;
                                if (size5 < ll1Var.b) {
                                    throw new IllegalStateException("Can't have more than " + ll1Var.b + " custom actions for one widget");
                                }
                                mp2 mp2Var2 = new mp2(0);
                                ul1 ul1VarA = xo1.a();
                                if (ny3.a(mp2Var.a, mp2Var.c, i6) >= 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    ul1Var = (ul1) mp2Var.b(i6);
                                    iArr = ll1Var.a;
                                    i9 = ll1Var.b;
                                    iArrCopyOf = new int[16];
                                    i10 = 0;
                                    i11 = 0;
                                    while (i10 < i9) {
                                        int i40 = iArr[i10];
                                        int i41 = i9;
                                        i12 = i11 + 1;
                                        ul1 ul1Var3 = ul1Var;
                                        if (iArrCopyOf.length < i12) {
                                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i12, (iArrCopyOf.length * 3) / 2));
                                        }
                                        iArrCopyOf[i11] = i40;
                                        i10++;
                                        i11 = i12;
                                        i9 = i41;
                                        ul1Var = ul1Var3;
                                    }
                                    ul1Var2 = ul1Var;
                                    arrayList3 = new ArrayList();
                                    if (list2.size() <= 0) {
                                        ky0.x(list2.get(0));
                                        ul1Var2.getClass();
                                        throw null;
                                    }
                                    if (arrayList3.size() <= 0) {
                                        ky0.x(arrayList3.get(0));
                                        if (i11 <= 0) {
                                            og.o("Index must be between 0 and size");
                                            return null;
                                        }
                                        int i42 = iArrCopyOf[0];
                                        throw null;
                                    }
                                } else if (list2.size() > 0) {
                                    ky0.x(list2.get(0));
                                    ll1Var.c(0);
                                    throw null;
                                }
                                x7Var2.Z.c(i6, mp2Var2);
                                mp2Var.c(i6, ul1VarA);
                            }
                        }
                        zB = pc4.b(gg2Var2, resources);
                        if (Build.VERSION.SDK_INT >= 28) {
                            r1.setScreenReaderFocusable(zB);
                        } else {
                            h3Var4.f(1, zB);
                        }
                        iD = x7Var2.l0.d(i6);
                        if (iD != -1) {
                            e34.b(r7Var2.getAndroidViewsHandler$ui(), iD);
                            r7Var = r7Var2;
                            r1.setTraversalBefore(r7Var, iD);
                            x7Var2.b(i6, h3Var4, x7Var2.n0, null);
                        } else {
                            r7Var = r7Var2;
                        }
                        iD2 = x7Var2.m0.d(i6);
                        if (iD2 != -1) {
                            e34.b(r7Var.getAndroidViewsHandler$ui(), iD2);
                        }
                        str2 = (String) y24.a(cg2Var, lg2.b);
                        if (str2 != null) {
                            h3Var4.g(str2);
                        }
                        h3Var5 = h3Var4;
                    } else {
                        x7Var2 = x7Var;
                    }
                    z2 = true;
                    r2.setVisibleToUser(o44.e(gg2Var2) ^ z2);
                    objG8 = gm1Var.g(kg2.j);
                    if (objG8 == null) {
                        objG8 = h3Var2;
                    }
                    if (objG8 == null) {
                        dk0.t();
                        return null;
                    }
                    r1.setClickable(false);
                    objG9 = gm1Var.g(bg2.b);
                    if (objG9 == null) {
                        objG9 = h3Var2;
                    }
                    b2Var = (b2) objG9;
                    if (b2Var != null) {
                        objG26 = gm1Var.g(kg2.H);
                        if (objG26 == null) {
                            objG26 = h3Var2;
                        }
                        g31.a(objG26, Boolean.TRUE);
                        r1.setClickable(true);
                        if (pc4.a(gg2Var2)) {
                            var r15 = h3Var2;
                            h3Var4.a(new d3(r15, 16, b2Var.a, r15));
                        }
                    }
                    r1.setLongClickable(false);
                    objG10 = gm1Var.g(bg2.c);
                    if (objG10 == null) {
                        objG10 = null;
                    }
                    b2Var2 = (b2) objG10;
                    if (b2Var2 != null) {
                        r1.setLongClickable(true);
                        if (pc4.a(gg2Var2)) {
                            h3Var4.a(new d3(null, 32, b2Var2.a, null));
                        }
                    }
                    objG11 = gm1Var.g(bg2.q);
                    if (objG11 == null) {
                        objG11 = null;
                    }
                    b2Var3 = (b2) objG11;
                    if (b2Var3 != null) {
                        h3Var4.a(new d3(null, 16384, b2Var3.a, null));
                    }
                    if (pc4.a(gg2Var2)) {
                        objG23 = gm1Var.g(bg2.k);
                        if (objG23 == null) {
                            objG23 = null;
                        }
                        b2Var9 = (b2) objG23;
                        if (b2Var9 != null) {
                            h3Var4.a(new d3(null, ArabicShaping.SEEN_TWOCELL_NEAR, b2Var9.a, null));
                        }
                        objG24 = gm1Var.g(bg2.p);
                        if (objG24 == null) {
                            objG24 = null;
                        }
                        b2Var10 = (b2) objG24;
                        if (b2Var10 != null) {
                            h3Var4.a(new d3(null, R.id.accessibilityActionImeEnter, b2Var10.a, null));
                        }
                        objG25 = gm1Var.g(bg2.r);
                        if (objG25 == null) {
                            objG25 = null;
                        }
                        b2Var11 = (b2) objG25;
                        if (b2Var11 != null) {
                            h3Var4.a(new d3(null, 65536, b2Var11.a, null));
                        }
                        b2Var12 = (b2) y24.a(cg2Var, bg2.s);
                        if (b2Var12 != null) {
                            primaryClipDescription = r7Var2.getClipboardManager().a.getPrimaryClipDescription();
                            if (primaryClipDescription != null) {
                                zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                            } else {
                                zHasMimeType = false;
                            }
                            if (zHasMimeType) {
                                h3Var4.a(new d3(null, 32768, b2Var12.a, null));
                            }
                        }
                    }
                    strL = x7.l(gg2Var2);
                    if (strL != null) {
                        r2.setTextSelection(x7Var2.j(gg2Var2), x7Var2.i(gg2Var2));
                        b2Var8 = (b2) y24.a(cg2Var, bg2.j);
                        if (b2Var8 != null) {
                            str3 = b2Var8.a;
                        } else {
                            str3 = null;
                        }
                        h3Var4.a(new d3(Normalizer.INPUT_IS_FCD, str3));
                        r1.addAction(256);
                        r1.addAction(512);
                        r1.setMovementGranularities(11);
                        list3 = (List) y24.a(cg2Var, kg2.a);
                        if (list3 != null) {
                            n71VarU = n71Var2.u();
                            while (true) {
                                if (n71VarU == null) {
                                    n71VarU = null;
                                    break;
                                }
                                cg2VarW2 = n71VarU.w();
                                if (cg2VarW2 == null) {
                                }
                                n71VarU = n71VarU.u();
                            }
                            if (n71VarU == null) {
                                r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                            } else {
                                cg2VarW = n71VarU.w();
                                if (cg2VarW != null) {
                                    objG22 = cg2VarW.a.g(ng2Var2);
                                    if (objG22 == null) {
                                        objG22 = null;
                                    }
                                    zA3 = g31.a(objG22, Boolean.TRUE);
                                } else {
                                    zA3 = false;
                                }
                                if (zA3) {
                                    r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                }
                            }
                        } else {
                            n71VarU = n71Var2.u();
                            while (true) {
                                if (n71VarU == null) {
                                    n71VarU = null;
                                    break;
                                }
                                cg2VarW2 = n71VarU.w();
                                if (cg2VarW2 == null) {
                                }
                                n71VarU = n71VarU.u();
                            }
                            if (n71VarU == null) {
                                r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                            } else {
                                cg2VarW = n71VarU.w();
                                if (cg2VarW != null) {
                                    objG22 = cg2VarW.a.g(ng2Var2);
                                    if (objG22 == null) {
                                        objG22 = null;
                                    }
                                    zA3 = g31.a(objG22, Boolean.TRUE);
                                } else {
                                    zA3 = false;
                                }
                                if (zA3) {
                                    r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                }
                            }
                        }
                    }
                    arrayList = new ArrayList();
                    arrayList.add("androidx.compose.ui.semantics.id");
                    charSequenceE = h3Var4.e();
                    if (charSequenceE != null) {
                        arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                    }
                    if (gm1Var.c(kg2.y)) {
                        arrayList.add("androidx.compose.ui.semantics.testTag");
                    }
                    if (gm1Var.c(kg2.O)) {
                        arrayList.add("androidx.compose.ui.semantics.shapeType");
                        arrayList.add("androidx.compose.ui.semantics.shapeRect");
                        arrayList.add("androidx.compose.ui.semantics.shapeCorners");
                        arrayList.add("androidx.compose.ui.semantics.shapeRegion");
                    }
                    r2.setAvailableExtraData(arrayList);
                    q12Var = (q12) y24.a(cg2Var, kg2.c);
                    f = 0.0f;
                    if (q12Var != null) {
                        ng2Var4 = bg2.i;
                        if (gm1Var.c(ng2Var4)) {
                            h3Var4.g("android.widget.SeekBar");
                        } else {
                            h3Var4.g("android.widget.ProgressBar");
                        }
                        if (q12Var != q12.b) {
                            r2.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, 0.0f, 0.0f, 0.0f));
                        }
                        if (gm1Var.c(ng2Var4)) {
                            pc4.a(gg2Var2);
                        }
                    }
                    if (pc4.a(gg2Var2)) {
                        h3Var4.a(new d3(R.id.accessibilityActionSetProgress, b2Var7.a));
                    }
                    objG12 = gg2Var2.k().a.g(kg2.f);
                    if (objG12 == null) {
                        objG12 = null;
                    }
                    lzVar = (lz) objG12;
                    if (lzVar != null) {
                        r1.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(lzVar.a, lzVar.b, false, 0));
                        f2 = 0.0f;
                    } else {
                        arrayList2 = new ArrayList();
                        objG13 = gg2Var2.k().a.g(kg2.e);
                        if (objG13 == null) {
                            objG13 = null;
                        }
                        if (objG13 != null) {
                            listI2 = gg2Var2.i((4 & 1) != 0 ? !gg2Var2.b : false, (4 & 2) == 0);
                            size4 = listI2.size();
                            i7 = 0;
                            while (i7 < size4) {
                                gg2Var3 = (gg2) listI2.get(i7);
                                float f4 = f;
                                if (gg2Var3.k().a.c(kg2.H)) {
                                    arrayList2.add(gg2Var3);
                                }
                                i7++;
                                f = f4;
                            }
                        }
                        f2 = f;
                        if (!arrayList2.isEmpty()) {
                            zA = hi4.a(arrayList2);
                            if (zA) {
                                size2 = 1;
                            } else {
                                size2 = arrayList2.size();
                            }
                            if (zA) {
                                size3 = arrayList2.size();
                            } else {
                                size3 = 1;
                            }
                            r1.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(size2, size3, false, 0));
                        }
                    }
                    objG14 = gg2Var2.k().a.g(kg2.g);
                    if (objG14 == null) {
                        objG14 = null;
                    }
                    if (objG14 == null) {
                        gg2VarL2 = gg2Var2.l();
                        if (gg2VarL2 != null) {
                            objG19 = gg2VarL2.k().a.g(kg2.e);
                            if (objG19 == null) {
                                objG19 = null;
                            }
                            if (objG19 != null) {
                                objG20 = gg2VarL2.k().a.g(kg2.f);
                                if (objG20 == null) {
                                    objG20 = null;
                                }
                                lzVar2 = (lz) objG20;
                                if (lzVar2 != null) {
                                    if (gg2Var2.k().a.c(kg2.H)) {
                                        arrayList4 = new ArrayList();
                                        listI3 = gg2VarL2.i((4 & 1) != 0 ? !gg2VarL2.b : false, (4 & 2) == 0);
                                        size6 = listI3.size();
                                        i14 = 0;
                                        while (i13 < size6) {
                                            gg2Var4 = (gg2) listI3.get(i13);
                                            if (gg2Var4.k().a.c(kg2.H)) {
                                                arrayList4.add(gg2Var4);
                                                if (gg2Var4.c.v() < gg2Var2.c.v()) {
                                                    i14++;
                                                }
                                            }
                                        }
                                        if (!arrayList4.isEmpty()) {
                                            zA2 = hi4.a(arrayList4);
                                            if (zA2) {
                                                i15 = 0;
                                            } else {
                                                i15 = i14;
                                            }
                                            if (zA2) {
                                                i16 = i14;
                                            } else {
                                                i16 = 0;
                                            }
                                            objG21 = gg2Var2.k().a.g(kg2.H);
                                            if (objG21 == null) {
                                                objG21 = Boolean.FALSE;
                                            }
                                            r1.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i15, 1, i16, 1, false, ((Boolean) objG21).booleanValue()));
                                        }
                                    }
                                } else if (gg2Var2.k().a.c(kg2.H)) {
                                    arrayList4 = new ArrayList();
                                    listI3 = gg2VarL2.i((4 & 1) != 0 ? !gg2VarL2.b : false, (4 & 2) == 0);
                                    size6 = listI3.size();
                                    i14 = 0;
                                    while (i13 < size6) {
                                        gg2Var4 = (gg2) listI3.get(i13);
                                        if (gg2Var4.k().a.c(kg2.H)) {
                                            arrayList4.add(gg2Var4);
                                            if (gg2Var4.c.v() < gg2Var2.c.v()) {
                                                i14++;
                                            }
                                        }
                                    }
                                    if (!arrayList4.isEmpty()) {
                                        zA2 = hi4.a(arrayList4);
                                        if (zA2) {
                                            i15 = 0;
                                        } else {
                                            i15 = i14;
                                        }
                                        if (zA2) {
                                            i16 = i14;
                                        } else {
                                            i16 = 0;
                                        }
                                        objG21 = gg2Var2.k().a.g(kg2.H);
                                        if (objG21 == null) {
                                            objG21 = Boolean.FALSE;
                                        }
                                        r1.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i15, 1, i16, 1, false, ((Boolean) objG21).booleanValue()));
                                    }
                                }
                            }
                        }
                    } else {
                        dk0.t();
                    }
                    ed2Var = (ed2) y24.a(cg2Var, kg2.u);
                    b2 b2Var14 = (b2) y24.a(cg2Var, bg2.d);
                    if (ed2Var != null) {
                        objG17 = gg2Var2.k().a.g(kg2.f);
                        if (objG17 == null) {
                            objG17 = null;
                        }
                        if (objG17 == null) {
                            objG18 = gg2Var2.k().a.g(kg2.e);
                            if (objG18 == null) {
                                objG18 = null;
                            }
                            if (objG18 == null) {
                                h3Var4.g("android.widget.HorizontalScrollView");
                            }
                        }
                        if (((Number) ed2Var.b.a()).floatValue() > f2) {
                            r1.setScrollable(true);
                        }
                        if (pc4.a(gg2Var2)) {
                            zR = x7.r(ed2Var);
                            z61Var = z61.b;
                            if (zR) {
                                h3Var4.a(d3.e);
                                n71Var = n71Var2;
                                if (n71Var.i0 == z61Var) {
                                    d3Var2 = d3.h;
                                } else {
                                    d3Var2 = d3.j;
                                }
                                h3Var4.a(d3Var2);
                            } else {
                                n71Var = n71Var2;
                            }
                            if (x7.q(ed2Var)) {
                                h3Var4.a(d3.f);
                                if (n71Var.i0 == z61Var) {
                                    d3Var = d3.j;
                                } else {
                                    d3Var = d3.h;
                                }
                                h3Var4.a(d3Var);
                            }
                        }
                    }
                    ed2Var2 = (ed2) y24.a(cg2Var, kg2.v);
                    if (ed2Var2 != null) {
                        objG15 = gg2Var2.k().a.g(kg2.f);
                        if (objG15 == null) {
                            objG15 = null;
                        }
                        if (objG15 == null) {
                            objG16 = gg2Var2.k().a.g(kg2.e);
                            if (objG16 == null) {
                                objG16 = null;
                            }
                            if (objG16 == null) {
                                h3Var4.g("android.widget.ScrollView");
                            }
                        }
                        if (((Number) ed2Var2.b.a()).floatValue() > f2) {
                            r1.setScrollable(true);
                        }
                        if (pc4.a(gg2Var2)) {
                            if (x7.r(ed2Var2)) {
                                h3Var4.a(d3.e);
                                h3Var4.a(d3.i);
                            }
                            if (x7.q(ed2Var2)) {
                                h3Var4.a(d3.f);
                                h3Var4.a(d3.g);
                            }
                        }
                    }
                    i8 = Build.VERSION.SDK_INT;
                    if (i8 >= 29) {
                        nc4.a(h3Var4, gg2Var2);
                    }
                    charSequence = (CharSequence) y24.a(cg2Var, kg2.d);
                    if (i8 >= 28) {
                        r1.setPaneTitle(charSequence);
                    } else {
                        r1.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
                    }
                    if (pc4.a(gg2Var2)) {
                        b2Var4 = (b2) y24.a(cg2Var, bg2.t);
                        if (b2Var4 != null) {
                            h3Var4.a(new d3(ArabicShaping.TASHKEEL_BEGIN, b2Var4.a));
                        }
                        b2Var5 = (b2) y24.a(cg2Var, bg2.u);
                        if (b2Var5 != null) {
                            h3Var4.a(new d3(ArabicShaping.TASHKEEL_RESIZE, b2Var5.a));
                        }
                        b2Var6 = (b2) y24.a(cg2Var, bg2.v);
                        if (b2Var6 != null) {
                            h3Var4.a(new d3(1048576, b2Var6.a));
                        }
                        ng2Var3 = bg2.x;
                        if (cg2Var.a.c(bg2.x)) {
                            list2 = (List) cg2Var.d(ng2Var3);
                            size5 = list2.size();
                            ll1Var = x7.x0;
                            if (size5 < ll1Var.b) {
                                throw new IllegalStateException("Can't have more than " + ll1Var.b + " custom actions for one widget");
                            }
                            mp2 mp2Var3 = new mp2(0);
                            ul1 ul1VarA2 = xo1.a();
                            if (ny3.a(mp2Var.a, mp2Var.c, i6) >= 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                ul1Var = (ul1) mp2Var.b(i6);
                                iArr = ll1Var.a;
                                i9 = ll1Var.b;
                                iArrCopyOf = new int[16];
                                i10 = 0;
                                i11 = 0;
                                while (i10 < i9) {
                                    int i43 = iArr[i10];
                                    int i44 = i9;
                                    i12 = i11 + 1;
                                    ul1 ul1Var4 = ul1Var;
                                    if (iArrCopyOf.length < i12) {
                                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i12, (iArrCopyOf.length * 3) / 2));
                                    }
                                    iArrCopyOf[i11] = i43;
                                    i10++;
                                    i11 = i12;
                                    i9 = i44;
                                    ul1Var = ul1Var4;
                                }
                                ul1Var2 = ul1Var;
                                arrayList3 = new ArrayList();
                                if (list2.size() <= 0) {
                                    ky0.x(list2.get(0));
                                    ul1Var2.getClass();
                                    throw null;
                                }
                                if (arrayList3.size() <= 0) {
                                    ky0.x(arrayList3.get(0));
                                    if (i11 <= 0) {
                                        og.o("Index must be between 0 and size");
                                        return null;
                                    }
                                    int i45 = iArrCopyOf[0];
                                    throw null;
                                }
                            } else if (list2.size() > 0) {
                                ky0.x(list2.get(0));
                                ll1Var.c(0);
                                throw null;
                            }
                            x7Var2.Z.c(i6, mp2Var3);
                            mp2Var.c(i6, ul1VarA2);
                        }
                    }
                    zB = pc4.b(gg2Var2, resources);
                    if (Build.VERSION.SDK_INT >= 28) {
                        r1.setScreenReaderFocusable(zB);
                    } else {
                        h3Var4.f(1, zB);
                    }
                    iD = x7Var2.l0.d(i6);
                    if (iD != -1) {
                        e34.b(r7Var2.getAndroidViewsHandler$ui(), iD);
                        r7Var = r7Var2;
                        r1.setTraversalBefore(r7Var, iD);
                        x7Var2.b(i6, h3Var4, x7Var2.n0, null);
                    } else {
                        r7Var = r7Var2;
                    }
                    iD2 = x7Var2.m0.d(i6);
                    if (iD2 != -1) {
                        e34.b(r7Var.getAndroidViewsHandler$ui(), iD2);
                    }
                    str2 = (String) y24.a(cg2Var, lg2.b);
                    if (str2 != null) {
                        h3Var4.g(str2);
                    }
                    h3Var5 = h3Var4;
                } else if (Build.VERSION.SDK_INT >= 34 ? v2.i(accessibilityManager) : true) {
                    accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
                    h3Var = new h3(accessibilityNodeInfoObtain);
                    i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 34) {
                        v2.l(accessibilityNodeInfoObtain, zA5);
                    } else {
                        h3Var.f(64, zA5);
                    }
                    if (i == -1) {
                        parentForAccessibility = r7Var2.getParentForAccessibility();
                        h3Var2 = null;
                        if (parentForAccessibility instanceof View) {
                            view = (View) parentForAccessibility;
                        } else {
                            view = null;
                        }
                        h3Var.b = -1;
                        accessibilityNodeInfoObtain.setParent(view);
                    } else {
                        h3Var2 = null;
                        gg2VarL = gg2Var7.l();
                        if (gg2VarL != null) {
                            numValueOf = Integer.valueOf(gg2VarL.g);
                        } else {
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            z01.c("semanticsNode " + i + " has null parent");
                            og.k();
                            return null;
                        }
                        iIntValue = numValueOf.intValue();
                        if (iIntValue == r7Var2.getSemanticsOwner().a().g) {
                            iIntValue = -1;
                        }
                        h3Var.b = iIntValue;
                        accessibilityNodeInfoObtain.setParent(r7Var2, iIntValue);
                    }
                    h3Var.c = i;
                    accessibilityNodeInfoObtain.setSource(r7Var2, i);
                    accessibilityNodeInfoObtain.setBoundsInScreen(x7Var3.c(ig2Var2));
                    kl1Var = x7Var3.t0;
                    mp2Var = x7Var3.c0;
                    resources = r7Var2.getContext().getResources();
                    h3Var.g("android.view.View");
                    gm1Var = cg2Var3.a;
                    if (gm1Var.c(kg2.E)) {
                        h3Var.g("android.widget.EditText");
                    }
                    if (gm1Var.c(kg2.A)) {
                        h3Var.g("android.widget.TextView");
                    }
                    objG = gm1Var.g(kg2.x);
                    if (objG == null) {
                        objG = h3Var2;
                    }
                    if (((m82) objG) != null) {
                        h3Var.g("android.widget.Button");
                    }
                    accessibilityNodeInfoObtain.setPackageName(r7Var2.getContext().getPackageName());
                    accessibilityNodeInfoObtain.setImportantForAccessibility(o44.f(gg2Var7));
                    if (i2 >= 34) {
                        zI = v2.i(accessibilityManager);
                    } else {
                        zI = true;
                    }
                    listI = gg2Var7.i((4 & 1) != 0 ? !gg2Var7.b : false, (4 & 2) == 0);
                    size = listI.size();
                    z = zI;
                    i3 = 0;
                    i4 = 0;
                    while (i4 < size) {
                        List list6 = listI;
                        gg2Var5 = (gg2) listI.get(i4);
                        int i310 = i4;
                        c21VarK = x7Var3.k();
                        int i311 = size;
                        i33 = gg2Var5.g;
                        if (!c21VarK.a(i33)) {
                            if (r7Var2.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(gg2Var5.c) == null) {
                                dk0.t();
                                return h3Var2;
                            }
                            if (i33 != -1) {
                                ig2Var = (ig2) x7Var3.k().b(i33);
                                if (ig2Var != null) {
                                    zA4 = false;
                                } else {
                                    zA4 = false;
                                }
                                if (z) {
                                    accessibilityNodeInfoObtain.addChild(r7Var2, i33);
                                } else {
                                    accessibilityNodeInfoObtain.addChild(r7Var2, i33);
                                }
                                kl1Var.f(i33, i3);
                                i3++;
                            }
                        }
                        i4 = i310 + 1;
                        listI = list6;
                        size = i311;
                    }
                    i5 = x7Var3.u;
                    accessibilityNodeInfo = h3Var.a;
                    if (i == i5) {
                        accessibilityNodeInfo.setAccessibilityFocused(true);
                        h3Var.a(d3.d);
                    } else {
                        accessibilityNodeInfo.setAccessibilityFocused(false);
                        h3Var.a(d3.c);
                    }
                    beVarE = pc4.e(gg2Var7);
                    if (beVarE != null) {
                        r7Var2.getFontFamilyResolver();
                        density = r7Var2.getDensity();
                        b13Var = x7Var3.p0;
                        String str5 = beVarE.b;
                        list4 = beVarE.a;
                        spannableString = new SpannableString(str5);
                        arrayList5 = beVarE.c;
                        if (arrayList5 != null) {
                            size13 = arrayList5.size();
                            i27 = 0;
                            while (i27 < size13) {
                                ArrayList arrayList10 = arrayList5;
                                ae aeVar9 = (ae) arrayList5.get(i27);
                                int i312 = size13;
                                hp2 hp2Var2 = (hp2) aeVar9.a;
                                int i313 = i27;
                                i28 = aeVar9.b;
                                i29 = aeVar9.c;
                                x7 x7Var5 = x7Var3;
                                jC = hp2Var2.a.c();
                                AccessibilityNodeInfo accessibilityNodeInfo7 = accessibilityNodeInfoObtain;
                                h3 h3Var7 = h3Var;
                                long j3 = hp2Var2.b;
                                np0Var = hp2Var2.c;
                                lp0Var = hp2Var2.d;
                                vy2Var = hp2Var2.j;
                                kl1 kl1Var4 = kl1Var;
                                ne1 ne1Var2 = hp2Var2.k;
                                gg2 gg2Var9 = gg2Var7;
                                AccessibilityNodeInfo accessibilityNodeInfo8 = accessibilityNodeInfo;
                                j = hp2Var2.l;
                                sx2Var = hp2Var2.m;
                                f00Var = hp2Var2.a;
                                cg2 cg2Var5 = cg2Var3;
                                b13 b13Var6 = b13Var;
                                if (!sz.c(jC, f00Var.c())) {
                                    if (jC != 16) {
                                        f00Var = new f00(jC);
                                    } else {
                                        f00Var = el1.j;
                                    }
                                }
                                m54.b(spannableString, f00Var.c(), i28, i29);
                                spannableString3 = spannableString;
                                m54.c(spannableString3, j3, density, i28, i29);
                                if (np0Var == null) {
                                    if (np0Var == null) {
                                        np0Var2 = np0.c;
                                    } else {
                                        np0Var2 = np0Var;
                                    }
                                    if (lp0Var != null) {
                                        i30 = lp0Var.a;
                                    } else {
                                        i30 = 0;
                                    }
                                    StyleSpan styleSpan2 = new StyleSpan(xc4.a(np0Var2, i30));
                                    i31 = 33;
                                    spannableString3.setSpan(styleSpan2, i28, i29, 33);
                                } else {
                                    if (np0Var == null) {
                                        np0Var2 = np0.c;
                                    } else {
                                        np0Var2 = np0Var;
                                    }
                                    if (lp0Var != null) {
                                        i30 = lp0Var.a;
                                    } else {
                                        i30 = 0;
                                    }
                                    StyleSpan styleSpan3 = new StyleSpan(xc4.a(np0Var2, i30));
                                    i31 = 33;
                                    spannableString3.setSpan(styleSpan3, i28, i29, 33);
                                }
                                if (sx2Var != null) {
                                    i32 = sx2Var.a;
                                    if ((i32 | 1) == i32) {
                                        spannableString3.setSpan(new UnderlineSpan(), i28, i29, i31);
                                    }
                                    if ((i32 | 2) == i32) {
                                        spannableString3.setSpan(new StrikethroughSpan(), i28, i29, i31);
                                    }
                                }
                                if (vy2Var != null) {
                                    spannableString3.setSpan(new ScaleXSpan(vy2Var.a), i28, i29, i31);
                                }
                                m54.d(spannableString3, ne1Var2, i28, i29);
                                if (j != 16) {
                                    spannableString3.setSpan(new BackgroundColorSpan(ki4.g(j)), i28, i29, i31);
                                }
                                i27 = i313 + 1;
                                spannableString = spannableString3;
                                cg2Var3 = cg2Var5;
                                arrayList5 = arrayList10;
                                size13 = i312;
                                x7Var3 = x7Var5;
                                accessibilityNodeInfoObtain = accessibilityNodeInfo7;
                                h3Var = h3Var7;
                                kl1Var = kl1Var4;
                                gg2Var7 = gg2Var9;
                                accessibilityNodeInfo = accessibilityNodeInfo8;
                                b13Var = b13Var6;
                            }
                        }
                        x7Var = x7Var3;
                        kl1Var2 = kl1Var;
                        gg2Var = gg2Var7;
                        accessibilityNodeInfo2 = accessibilityNodeInfo;
                        cg2Var = cg2Var3;
                        b13Var2 = b13Var;
                        accessibilityNodeInfo3 = accessibilityNodeInfoObtain;
                        h3Var3 = h3Var;
                        spannableString2 = spannableString;
                        int length4 = str5.length();
                        arrayList6 = ii0.a;
                        if (list4 != null) {
                            arrayList7 = new ArrayList(list4.size());
                            size12 = list4.size();
                            for (i26 = 0; i26 < size12; i26++) {
                                Object obj5 = list4.get(i26);
                                aeVar5 = (ae) obj5;
                                if (!(aeVar5.a instanceof a73)) {
                                }
                            }
                        } else {
                            arrayList7 = arrayList6;
                        }
                        size7 = arrayList7.size();
                        for (i17 = 0; i17 < size7; i17++) {
                            ae aeVar10 = (ae) arrayList7.get(i17);
                            a73Var = (a73) aeVar10.a;
                            i24 = aeVar10.b;
                            i25 = aeVar10.c;
                            if (a73Var instanceof a73) {
                                dk0.l();
                                return h3Var2;
                            }
                            spannableString2.setSpan(new TtsSpan.VerbatimBuilder(a73Var.a).build(), i24, i25, 33);
                        }
                        int length5 = str5.length();
                        if (list4 != null) {
                            arrayList8 = new ArrayList(list4.size());
                            size11 = list4.size();
                            for (i23 = 0; i23 < size11; i23++) {
                                Object obj6 = list4.get(i23);
                                aeVar4 = (ae) obj6;
                                if (!(aeVar4.a instanceof m53)) {
                                }
                            }
                        } else {
                            arrayList8 = arrayList6;
                        }
                        size8 = arrayList8.size();
                        i18 = 0;
                        while (i18 < size8) {
                            ae aeVar11 = (ae) arrayList8.get(i18);
                            m53Var = (m53) aeVar11.a;
                            int i314 = aeVar11.b;
                            int i315 = aeVar11.c;
                            b13 b13Var7 = b13Var2;
                            weakHashMap3 = (WeakHashMap) b13Var7.a;
                            uRLSpan2 = weakHashMap3.get(m53Var);
                            if (uRLSpan2 == null) {
                                uRLSpan2 = new URLSpan(m53Var.a);
                                weakHashMap3.put(m53Var, uRLSpan2);
                            }
                            spannableString2.setSpan((URLSpan) uRLSpan2, i314, i315, 33);
                            i18++;
                            b13Var2 = b13Var7;
                        }
                        b13Var3 = b13Var2;
                        int length6 = str5.length();
                        if (list4 != null) {
                            arrayList6 = new ArrayList(list4.size());
                            size10 = list4.size();
                            for (i22 = 0; i22 < size10; i22++) {
                                Object obj7 = list4.get(i22);
                                aeVar3 = (ae) obj7;
                                if (!(aeVar3.a instanceof kc1)) {
                                }
                            }
                        }
                        size9 = arrayList6.size();
                        for (i19 = 0; i19 < size9; i19++) {
                            aeVar = (ae) arrayList6.get(i19);
                            i20 = aeVar.b;
                            obj = aeVar.a;
                            i21 = aeVar.c;
                            if (i20 != i21) {
                                kc1Var = (kc1) obj;
                                if (kc1Var instanceof jc1) {
                                    obj.getClass();
                                    jc1Var = (jc1) obj;
                                    aeVar2 = new ae(jc1Var, i20, i21);
                                    weakHashMap2 = (WeakHashMap) b13Var3.b;
                                    uRLSpan = weakHashMap2.get(aeVar2);
                                    if (uRLSpan == null) {
                                        uRLSpan = new URLSpan(jc1Var.a);
                                        weakHashMap2.put(aeVar2, uRLSpan);
                                    }
                                    spannableString2.setSpan((URLSpan) uRLSpan, i20, i21, 33);
                                } else {
                                    weakHashMap = (WeakHashMap) b13Var3.c;
                                    c20Var = weakHashMap.get(aeVar);
                                    if (c20Var == null) {
                                        c20Var = new c20(kc1Var);
                                        weakHashMap.put(aeVar, c20Var);
                                    }
                                    spannableString2.setSpan((ClickableSpan) c20Var, i20, i21, 33);
                                }
                            }
                        }
                        r0 = (SpannableString) x7.H(spannableString2);
                    } else {
                        x7Var = x7Var3;
                        kl1Var2 = kl1Var;
                        gg2Var = gg2Var7;
                        accessibilityNodeInfo2 = accessibilityNodeInfo;
                        n71Var2 = n71Var2;
                        cg2Var = cg2Var3;
                        accessibilityNodeInfo3 = accessibilityNodeInfoObtain;
                        h3Var3 = h3Var;
                        r0 = h3Var2;
                    }
                    r1 = accessibilityNodeInfo2;
                    r1.setText(r0);
                    ng2Var = kg2.K;
                    if (gm1Var.c(ng2Var)) {
                        AccessibilityNodeInfo accessibilityNodeInfo9 = accessibilityNodeInfo3;
                        accessibilityNodeInfo9.setContentInvalid(true);
                        objG27 = gm1Var.g(ng2Var);
                        if (objG27 == null) {
                            objG27 = h3Var2;
                        }
                        accessibilityNodeInfo9.setError((CharSequence) objG27);
                        r2 = accessibilityNodeInfo9;
                    } else {
                        r2 = accessibilityNodeInfo3;
                    }
                    gg2Var2 = gg2Var;
                    strD = pc4.d(gg2Var2, resources);
                    if (Build.VERSION.SDK_INT >= 30) {
                        e3.j(r1, strD);
                    } else {
                        r1.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", strD);
                    }
                    r2.setCheckable(pc4.c(gg2Var2));
                    objG2 = gm1Var.g(kg2.I);
                    if (objG2 == null) {
                        objG2 = h3Var2;
                    }
                    d13Var = (d13) objG2;
                    if (d13Var != null) {
                        if (d13Var == d13.a) {
                            r1.setChecked(true);
                        } else if (d13Var == d13.b) {
                            r1.setChecked(false);
                        }
                    }
                    objG3 = gm1Var.g(kg2.H);
                    if (objG3 == null) {
                        objG3 = h3Var2;
                    }
                    bool = (Boolean) objG3;
                    if (bool != null) {
                        r1.setChecked(bool.booleanValue());
                    }
                    if (cg2Var.c) {
                        objG4 = gm1Var.g(kg2.a);
                        if (objG4 == null) {
                            objG4 = h3Var2;
                        }
                        list = (List) objG4;
                        if (list != null) {
                            r3 = (String) mz.y(list);
                        } else {
                            r3 = h3Var2;
                        }
                        r2.setContentDescription(r3);
                    } else {
                        objG4 = gm1Var.g(kg2.a);
                        if (objG4 == null) {
                            objG4 = h3Var2;
                        }
                        list = (List) objG4;
                        if (list != null) {
                            r3 = (String) mz.y(list);
                        } else {
                            r3 = h3Var2;
                        }
                        r2.setContentDescription(r3);
                    }
                    objG5 = gm1Var.g(kg2.y);
                    if (objG5 == null) {
                        objG5 = h3Var2;
                    }
                    str = (String) objG5;
                    if (str != null) {
                        gg2VarL3 = gg2Var2;
                        while (true) {
                            if (gg2VarL3 != null) {
                                zBooleanValue = false;
                                break;
                            }
                            cg2Var2 = gg2VarL3.d;
                            ng2Var5 = lg2.a;
                            if (cg2Var2.a.c(ng2Var5)) {
                                zBooleanValue = ((Boolean) cg2Var2.d(ng2Var5)).booleanValue();
                                break;
                            }
                            gg2VarL3 = gg2VarL3.l();
                        }
                        if (zBooleanValue) {
                            r2.setViewIdResourceName(str);
                        }
                    }
                    objG6 = gm1Var.g(kg2.h);
                    if (objG6 == null) {
                        objG6 = h3Var2;
                    }
                    if (((q43) objG6) == null) {
                        h3Var4 = h3Var3;
                    } else if (Build.VERSION.SDK_INT >= 28) {
                        r1.setHeading(true);
                        h3Var4 = h3Var3;
                    } else {
                        h3Var4 = h3Var3;
                        h3Var4.f(2, true);
                    }
                    i6 = i;
                    if (i6 != -1) {
                        iD3 = kl1Var2.d(gg2Var2.g);
                        if (iD3 != -1) {
                            r2.setDrawingOrder(iD3);
                        } else {
                            Log.w("AccessibilityDelegate", "Drawing order is not available, was AccessibilityNodeInfo requested for a child node before its parent?");
                        }
                    }
                    r2.setPassword(gm1Var.c(kg2.J));
                    r2.setEditable(gm1Var.c(kg2.M));
                    objG7 = gm1Var.g(kg2.N);
                    if (objG7 == null) {
                        objG7 = h3Var2;
                    }
                    num = (Integer) objG7;
                    if (num != null) {
                        iIntValue2 = num.intValue();
                    } else {
                        iIntValue2 = -1;
                    }
                    r2.setMaxTextLength(iIntValue2);
                    r2.setEnabled(pc4.a(gg2Var2));
                    ng2Var2 = kg2.k;
                    r2.setFocusable(gm1Var.c(ng2Var2));
                    if (r2.isFocusable()) {
                        r2.setFocused(((Boolean) cg2Var.d(ng2Var2)).booleanValue());
                        if (r2.isFocused()) {
                            r1.addAction(2);
                            x7Var2 = x7Var;
                            x7Var2.v = i6;
                        } else {
                            x7Var2 = x7Var;
                            z2 = true;
                            r1.addAction(1);
                        }
                        r2.setVisibleToUser(o44.e(gg2Var2) ^ z2);
                        objG8 = gm1Var.g(kg2.j);
                        if (objG8 == null) {
                            objG8 = h3Var2;
                        }
                        if (objG8 == null) {
                            dk0.t();
                            return null;
                        }
                        r1.setClickable(false);
                        objG9 = gm1Var.g(bg2.b);
                        if (objG9 == null) {
                            objG9 = h3Var2;
                        }
                        b2Var = (b2) objG9;
                        if (b2Var != null) {
                            objG26 = gm1Var.g(kg2.H);
                            if (objG26 == null) {
                                objG26 = h3Var2;
                            }
                            g31.a(objG26, Boolean.TRUE);
                            r1.setClickable(true);
                            if (pc4.a(gg2Var2)) {
                                var r16 = h3Var2;
                                h3Var4.a(new d3(r16, 16, b2Var.a, r16));
                            }
                        }
                        r1.setLongClickable(false);
                        objG10 = gm1Var.g(bg2.c);
                        if (objG10 == null) {
                            objG10 = null;
                        }
                        b2Var2 = (b2) objG10;
                        if (b2Var2 != null) {
                            r1.setLongClickable(true);
                            if (pc4.a(gg2Var2)) {
                                h3Var4.a(new d3(null, 32, b2Var2.a, null));
                            }
                        }
                        objG11 = gm1Var.g(bg2.q);
                        if (objG11 == null) {
                            objG11 = null;
                        }
                        b2Var3 = (b2) objG11;
                        if (b2Var3 != null) {
                            h3Var4.a(new d3(null, 16384, b2Var3.a, null));
                        }
                        if (pc4.a(gg2Var2)) {
                            objG23 = gm1Var.g(bg2.k);
                            if (objG23 == null) {
                                objG23 = null;
                            }
                            b2Var9 = (b2) objG23;
                            if (b2Var9 != null) {
                                h3Var4.a(new d3(null, ArabicShaping.SEEN_TWOCELL_NEAR, b2Var9.a, null));
                            }
                            objG24 = gm1Var.g(bg2.p);
                            if (objG24 == null) {
                                objG24 = null;
                            }
                            b2Var10 = (b2) objG24;
                            if (b2Var10 != null) {
                                h3Var4.a(new d3(null, R.id.accessibilityActionImeEnter, b2Var10.a, null));
                            }
                            objG25 = gm1Var.g(bg2.r);
                            if (objG25 == null) {
                                objG25 = null;
                            }
                            b2Var11 = (b2) objG25;
                            if (b2Var11 != null) {
                                h3Var4.a(new d3(null, 65536, b2Var11.a, null));
                            }
                            b2Var12 = (b2) y24.a(cg2Var, bg2.s);
                            if (b2Var12 != null) {
                                primaryClipDescription = r7Var2.getClipboardManager().a.getPrimaryClipDescription();
                                if (primaryClipDescription != null) {
                                    zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                                } else {
                                    zHasMimeType = false;
                                }
                                if (zHasMimeType) {
                                    h3Var4.a(new d3(null, 32768, b2Var12.a, null));
                                }
                            }
                        }
                        strL = x7.l(gg2Var2);
                        if (strL != null) {
                            r2.setTextSelection(x7Var2.j(gg2Var2), x7Var2.i(gg2Var2));
                            b2Var8 = (b2) y24.a(cg2Var, bg2.j);
                            if (b2Var8 != null) {
                                str3 = b2Var8.a;
                            } else {
                                str3 = null;
                            }
                            h3Var4.a(new d3(Normalizer.INPUT_IS_FCD, str3));
                            r1.addAction(256);
                            r1.addAction(512);
                            r1.setMovementGranularities(11);
                            list3 = (List) y24.a(cg2Var, kg2.a);
                            if (list3 != null) {
                                n71VarU = n71Var2.u();
                                while (true) {
                                    if (n71VarU == null) {
                                        n71VarU = null;
                                        break;
                                    }
                                    cg2VarW2 = n71VarU.w();
                                    if (cg2VarW2 == null) {
                                    }
                                    n71VarU = n71VarU.u();
                                }
                                if (n71VarU == null) {
                                    r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                } else {
                                    cg2VarW = n71VarU.w();
                                    if (cg2VarW != null) {
                                        objG22 = cg2VarW.a.g(ng2Var2);
                                        if (objG22 == null) {
                                            objG22 = null;
                                        }
                                        zA3 = g31.a(objG22, Boolean.TRUE);
                                    } else {
                                        zA3 = false;
                                    }
                                    if (zA3) {
                                        r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                    }
                                }
                            } else {
                                n71VarU = n71Var2.u();
                                while (true) {
                                    if (n71VarU == null) {
                                        n71VarU = null;
                                        break;
                                    }
                                    cg2VarW2 = n71VarU.w();
                                    if (cg2VarW2 == null) {
                                    }
                                    n71VarU = n71VarU.u();
                                }
                                if (n71VarU == null) {
                                    r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                } else {
                                    cg2VarW = n71VarU.w();
                                    if (cg2VarW != null) {
                                        objG22 = cg2VarW.a.g(ng2Var2);
                                        if (objG22 == null) {
                                            objG22 = null;
                                        }
                                        zA3 = g31.a(objG22, Boolean.TRUE);
                                    } else {
                                        zA3 = false;
                                    }
                                    if (zA3) {
                                        r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                    }
                                }
                            }
                        }
                        arrayList = new ArrayList();
                        arrayList.add("androidx.compose.ui.semantics.id");
                        charSequenceE = h3Var4.e();
                        if (charSequenceE != null) {
                            arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                        }
                        if (gm1Var.c(kg2.y)) {
                            arrayList.add("androidx.compose.ui.semantics.testTag");
                        }
                        if (gm1Var.c(kg2.O)) {
                            arrayList.add("androidx.compose.ui.semantics.shapeType");
                            arrayList.add("androidx.compose.ui.semantics.shapeRect");
                            arrayList.add("androidx.compose.ui.semantics.shapeCorners");
                            arrayList.add("androidx.compose.ui.semantics.shapeRegion");
                        }
                        r2.setAvailableExtraData(arrayList);
                        q12Var = (q12) y24.a(cg2Var, kg2.c);
                        f = 0.0f;
                        if (q12Var != null) {
                            ng2Var4 = bg2.i;
                            if (gm1Var.c(ng2Var4)) {
                                h3Var4.g("android.widget.SeekBar");
                            } else {
                                h3Var4.g("android.widget.ProgressBar");
                            }
                            if (q12Var != q12.b) {
                                r2.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, 0.0f, 0.0f, 0.0f));
                            }
                            if (gm1Var.c(ng2Var4)) {
                                pc4.a(gg2Var2);
                            }
                        }
                        if (pc4.a(gg2Var2)) {
                            h3Var4.a(new d3(R.id.accessibilityActionSetProgress, b2Var7.a));
                        }
                        objG12 = gg2Var2.k().a.g(kg2.f);
                        if (objG12 == null) {
                            objG12 = null;
                        }
                        lzVar = (lz) objG12;
                        if (lzVar != null) {
                            r1.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(lzVar.a, lzVar.b, false, 0));
                            f2 = 0.0f;
                        } else {
                            arrayList2 = new ArrayList();
                            objG13 = gg2Var2.k().a.g(kg2.e);
                            if (objG13 == null) {
                                objG13 = null;
                            }
                            if (objG13 != null) {
                                listI2 = gg2Var2.i((4 & 1) != 0 ? !gg2Var2.b : false, (4 & 2) == 0);
                                size4 = listI2.size();
                                i7 = 0;
                                while (i7 < size4) {
                                    gg2Var3 = (gg2) listI2.get(i7);
                                    float f5 = f;
                                    if (gg2Var3.k().a.c(kg2.H)) {
                                        arrayList2.add(gg2Var3);
                                    }
                                    i7++;
                                    f = f5;
                                }
                            }
                            f2 = f;
                            if (!arrayList2.isEmpty()) {
                                zA = hi4.a(arrayList2);
                                if (zA) {
                                    size2 = 1;
                                } else {
                                    size2 = arrayList2.size();
                                }
                                if (zA) {
                                    size3 = arrayList2.size();
                                } else {
                                    size3 = 1;
                                }
                                r1.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(size2, size3, false, 0));
                            }
                        }
                        objG14 = gg2Var2.k().a.g(kg2.g);
                        if (objG14 == null) {
                            objG14 = null;
                        }
                        if (objG14 == null) {
                            gg2VarL2 = gg2Var2.l();
                            if (gg2VarL2 != null) {
                                objG19 = gg2VarL2.k().a.g(kg2.e);
                                if (objG19 == null) {
                                    objG19 = null;
                                }
                                if (objG19 != null) {
                                    objG20 = gg2VarL2.k().a.g(kg2.f);
                                    if (objG20 == null) {
                                        objG20 = null;
                                    }
                                    lzVar2 = (lz) objG20;
                                    if (lzVar2 != null) {
                                        if (gg2Var2.k().a.c(kg2.H)) {
                                            arrayList4 = new ArrayList();
                                            listI3 = gg2VarL2.i((4 & 1) != 0 ? !gg2VarL2.b : false, (4 & 2) == 0);
                                            size6 = listI3.size();
                                            i14 = 0;
                                            for (i13 = 0; i13 < size6; i13++) {
                                                gg2Var4 = (gg2) listI3.get(i13);
                                                if (gg2Var4.k().a.c(kg2.H)) {
                                                    arrayList4.add(gg2Var4);
                                                    if (gg2Var4.c.v() < gg2Var2.c.v()) {
                                                        i14++;
                                                    }
                                                }
                                            }
                                            if (!arrayList4.isEmpty()) {
                                                zA2 = hi4.a(arrayList4);
                                                if (zA2) {
                                                    i15 = 0;
                                                } else {
                                                    i15 = i14;
                                                }
                                                if (zA2) {
                                                    i16 = i14;
                                                } else {
                                                    i16 = 0;
                                                }
                                                objG21 = gg2Var2.k().a.g(kg2.H);
                                                if (objG21 == null) {
                                                    objG21 = Boolean.FALSE;
                                                }
                                                r1.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i15, 1, i16, 1, false, ((Boolean) objG21).booleanValue()));
                                            }
                                        }
                                    } else if (gg2Var2.k().a.c(kg2.H)) {
                                        arrayList4 = new ArrayList();
                                        listI3 = gg2VarL2.i((4 & 1) != 0 ? !gg2VarL2.b : false, (4 & 2) == 0);
                                        size6 = listI3.size();
                                        i14 = 0;
                                        while (i13 < size6) {
                                            gg2Var4 = (gg2) listI3.get(i13);
                                            if (gg2Var4.k().a.c(kg2.H)) {
                                                arrayList4.add(gg2Var4);
                                                if (gg2Var4.c.v() < gg2Var2.c.v()) {
                                                    i14++;
                                                }
                                            }
                                        }
                                        if (!arrayList4.isEmpty()) {
                                            zA2 = hi4.a(arrayList4);
                                            if (zA2) {
                                                i15 = 0;
                                            } else {
                                                i15 = i14;
                                            }
                                            if (zA2) {
                                                i16 = i14;
                                            } else {
                                                i16 = 0;
                                            }
                                            objG21 = gg2Var2.k().a.g(kg2.H);
                                            if (objG21 == null) {
                                                objG21 = Boolean.FALSE;
                                            }
                                            r1.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i15, 1, i16, 1, false, ((Boolean) objG21).booleanValue()));
                                        }
                                    }
                                }
                            }
                        } else {
                            dk0.t();
                        }
                        ed2Var = (ed2) y24.a(cg2Var, kg2.u);
                        b2 b2Var15 = (b2) y24.a(cg2Var, bg2.d);
                        if (ed2Var != null) {
                            objG17 = gg2Var2.k().a.g(kg2.f);
                            if (objG17 == null) {
                                objG17 = null;
                            }
                            if (objG17 == null) {
                                objG18 = gg2Var2.k().a.g(kg2.e);
                                if (objG18 == null) {
                                    objG18 = null;
                                }
                                if (objG18 == null) {
                                    h3Var4.g("android.widget.HorizontalScrollView");
                                }
                            }
                            if (((Number) ed2Var.b.a()).floatValue() > f2) {
                                r1.setScrollable(true);
                            }
                            if (pc4.a(gg2Var2)) {
                                zR = x7.r(ed2Var);
                                z61Var = z61.b;
                                if (zR) {
                                    h3Var4.a(d3.e);
                                    n71Var = n71Var2;
                                    if (n71Var.i0 == z61Var) {
                                        d3Var2 = d3.h;
                                    } else {
                                        d3Var2 = d3.j;
                                    }
                                    h3Var4.a(d3Var2);
                                } else {
                                    n71Var = n71Var2;
                                }
                                if (x7.q(ed2Var)) {
                                    h3Var4.a(d3.f);
                                    if (n71Var.i0 == z61Var) {
                                        d3Var = d3.j;
                                    } else {
                                        d3Var = d3.h;
                                    }
                                    h3Var4.a(d3Var);
                                }
                            }
                        }
                        ed2Var2 = (ed2) y24.a(cg2Var, kg2.v);
                        if (ed2Var2 != null) {
                            objG15 = gg2Var2.k().a.g(kg2.f);
                            if (objG15 == null) {
                                objG15 = null;
                            }
                            if (objG15 == null) {
                                objG16 = gg2Var2.k().a.g(kg2.e);
                                if (objG16 == null) {
                                    objG16 = null;
                                }
                                if (objG16 == null) {
                                    h3Var4.g("android.widget.ScrollView");
                                }
                            }
                            if (((Number) ed2Var2.b.a()).floatValue() > f2) {
                                r1.setScrollable(true);
                            }
                            if (pc4.a(gg2Var2)) {
                                if (x7.r(ed2Var2)) {
                                    h3Var4.a(d3.e);
                                    h3Var4.a(d3.i);
                                }
                                if (x7.q(ed2Var2)) {
                                    h3Var4.a(d3.f);
                                    h3Var4.a(d3.g);
                                }
                            }
                        }
                        i8 = Build.VERSION.SDK_INT;
                        if (i8 >= 29) {
                            nc4.a(h3Var4, gg2Var2);
                        }
                        charSequence = (CharSequence) y24.a(cg2Var, kg2.d);
                        if (i8 >= 28) {
                            r1.setPaneTitle(charSequence);
                        } else {
                            r1.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
                        }
                        if (pc4.a(gg2Var2)) {
                            b2Var4 = (b2) y24.a(cg2Var, bg2.t);
                            if (b2Var4 != null) {
                                h3Var4.a(new d3(ArabicShaping.TASHKEEL_BEGIN, b2Var4.a));
                            }
                            b2Var5 = (b2) y24.a(cg2Var, bg2.u);
                            if (b2Var5 != null) {
                                h3Var4.a(new d3(ArabicShaping.TASHKEEL_RESIZE, b2Var5.a));
                            }
                            b2Var6 = (b2) y24.a(cg2Var, bg2.v);
                            if (b2Var6 != null) {
                                h3Var4.a(new d3(1048576, b2Var6.a));
                            }
                            ng2Var3 = bg2.x;
                            if (cg2Var.a.c(bg2.x)) {
                                list2 = (List) cg2Var.d(ng2Var3);
                                size5 = list2.size();
                                ll1Var = x7.x0;
                                if (size5 < ll1Var.b) {
                                    throw new IllegalStateException("Can't have more than " + ll1Var.b + " custom actions for one widget");
                                }
                                mp2 mp2Var4 = new mp2(0);
                                ul1 ul1VarA3 = xo1.a();
                                if (ny3.a(mp2Var.a, mp2Var.c, i6) >= 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    ul1Var = (ul1) mp2Var.b(i6);
                                    iArr = ll1Var.a;
                                    i9 = ll1Var.b;
                                    iArrCopyOf = new int[16];
                                    i10 = 0;
                                    i11 = 0;
                                    while (i10 < i9) {
                                        int i46 = iArr[i10];
                                        int i47 = i9;
                                        i12 = i11 + 1;
                                        ul1 ul1Var5 = ul1Var;
                                        if (iArrCopyOf.length < i12) {
                                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i12, (iArrCopyOf.length * 3) / 2));
                                        }
                                        iArrCopyOf[i11] = i46;
                                        i10++;
                                        i11 = i12;
                                        i9 = i47;
                                        ul1Var = ul1Var5;
                                    }
                                    ul1Var2 = ul1Var;
                                    arrayList3 = new ArrayList();
                                    if (list2.size() <= 0) {
                                        ky0.x(list2.get(0));
                                        ul1Var2.getClass();
                                        throw null;
                                    }
                                    if (arrayList3.size() <= 0) {
                                        ky0.x(arrayList3.get(0));
                                        if (i11 <= 0) {
                                            og.o("Index must be between 0 and size");
                                            return null;
                                        }
                                        int i48 = iArrCopyOf[0];
                                        throw null;
                                    }
                                } else if (list2.size() > 0) {
                                    ky0.x(list2.get(0));
                                    ll1Var.c(0);
                                    throw null;
                                }
                                x7Var2.Z.c(i6, mp2Var4);
                                mp2Var.c(i6, ul1VarA3);
                            }
                        }
                        zB = pc4.b(gg2Var2, resources);
                        if (Build.VERSION.SDK_INT >= 28) {
                            r1.setScreenReaderFocusable(zB);
                        } else {
                            h3Var4.f(1, zB);
                        }
                        iD = x7Var2.l0.d(i6);
                        if (iD != -1) {
                            e34.b(r7Var2.getAndroidViewsHandler$ui(), iD);
                            r7Var = r7Var2;
                            r1.setTraversalBefore(r7Var, iD);
                            x7Var2.b(i6, h3Var4, x7Var2.n0, null);
                        } else {
                            r7Var = r7Var2;
                        }
                        iD2 = x7Var2.m0.d(i6);
                        if (iD2 != -1) {
                            e34.b(r7Var.getAndroidViewsHandler$ui(), iD2);
                        }
                        str2 = (String) y24.a(cg2Var, lg2.b);
                        if (str2 != null) {
                            h3Var4.g(str2);
                        }
                        h3Var5 = h3Var4;
                    } else {
                        x7Var2 = x7Var;
                    }
                    z2 = true;
                    r2.setVisibleToUser(o44.e(gg2Var2) ^ z2);
                    objG8 = gm1Var.g(kg2.j);
                    if (objG8 == null) {
                        objG8 = h3Var2;
                    }
                    if (objG8 == null) {
                        dk0.t();
                        return null;
                    }
                    r1.setClickable(false);
                    objG9 = gm1Var.g(bg2.b);
                    if (objG9 == null) {
                        objG9 = h3Var2;
                    }
                    b2Var = (b2) objG9;
                    if (b2Var != null) {
                        objG26 = gm1Var.g(kg2.H);
                        if (objG26 == null) {
                            objG26 = h3Var2;
                        }
                        g31.a(objG26, Boolean.TRUE);
                        r1.setClickable(true);
                        if (pc4.a(gg2Var2)) {
                            var r17 = h3Var2;
                            h3Var4.a(new d3(r17, 16, b2Var.a, r17));
                        }
                    }
                    r1.setLongClickable(false);
                    objG10 = gm1Var.g(bg2.c);
                    if (objG10 == null) {
                        objG10 = null;
                    }
                    b2Var2 = (b2) objG10;
                    if (b2Var2 != null) {
                        r1.setLongClickable(true);
                        if (pc4.a(gg2Var2)) {
                            h3Var4.a(new d3(null, 32, b2Var2.a, null));
                        }
                    }
                    objG11 = gm1Var.g(bg2.q);
                    if (objG11 == null) {
                        objG11 = null;
                    }
                    b2Var3 = (b2) objG11;
                    if (b2Var3 != null) {
                        h3Var4.a(new d3(null, 16384, b2Var3.a, null));
                    }
                    if (pc4.a(gg2Var2)) {
                        objG23 = gm1Var.g(bg2.k);
                        if (objG23 == null) {
                            objG23 = null;
                        }
                        b2Var9 = (b2) objG23;
                        if (b2Var9 != null) {
                            h3Var4.a(new d3(null, ArabicShaping.SEEN_TWOCELL_NEAR, b2Var9.a, null));
                        }
                        objG24 = gm1Var.g(bg2.p);
                        if (objG24 == null) {
                            objG24 = null;
                        }
                        b2Var10 = (b2) objG24;
                        if (b2Var10 != null) {
                            h3Var4.a(new d3(null, R.id.accessibilityActionImeEnter, b2Var10.a, null));
                        }
                        objG25 = gm1Var.g(bg2.r);
                        if (objG25 == null) {
                            objG25 = null;
                        }
                        b2Var11 = (b2) objG25;
                        if (b2Var11 != null) {
                            h3Var4.a(new d3(null, 65536, b2Var11.a, null));
                        }
                        b2Var12 = (b2) y24.a(cg2Var, bg2.s);
                        if (b2Var12 != null) {
                            primaryClipDescription = r7Var2.getClipboardManager().a.getPrimaryClipDescription();
                            if (primaryClipDescription != null) {
                                zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                            } else {
                                zHasMimeType = false;
                            }
                            if (zHasMimeType) {
                                h3Var4.a(new d3(null, 32768, b2Var12.a, null));
                            }
                        }
                    }
                    strL = x7.l(gg2Var2);
                    if (strL != null) {
                        r2.setTextSelection(x7Var2.j(gg2Var2), x7Var2.i(gg2Var2));
                        b2Var8 = (b2) y24.a(cg2Var, bg2.j);
                        if (b2Var8 != null) {
                            str3 = b2Var8.a;
                        } else {
                            str3 = null;
                        }
                        h3Var4.a(new d3(Normalizer.INPUT_IS_FCD, str3));
                        r1.addAction(256);
                        r1.addAction(512);
                        r1.setMovementGranularities(11);
                        list3 = (List) y24.a(cg2Var, kg2.a);
                        if (list3 != null) {
                            n71VarU = n71Var2.u();
                            while (true) {
                                if (n71VarU == null) {
                                    n71VarU = null;
                                    break;
                                }
                                cg2VarW2 = n71VarU.w();
                                if (cg2VarW2 == null) {
                                }
                                n71VarU = n71VarU.u();
                            }
                            if (n71VarU == null) {
                                r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                            } else {
                                cg2VarW = n71VarU.w();
                                if (cg2VarW != null) {
                                    objG22 = cg2VarW.a.g(ng2Var2);
                                    if (objG22 == null) {
                                        objG22 = null;
                                    }
                                    zA3 = g31.a(objG22, Boolean.TRUE);
                                } else {
                                    zA3 = false;
                                }
                                if (zA3) {
                                    r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                }
                            }
                        } else {
                            n71VarU = n71Var2.u();
                            while (true) {
                                if (n71VarU == null) {
                                    n71VarU = null;
                                    break;
                                }
                                cg2VarW2 = n71VarU.w();
                                if (cg2VarW2 == null) {
                                }
                                n71VarU = n71VarU.u();
                            }
                            if (n71VarU == null) {
                                r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                            } else {
                                cg2VarW = n71VarU.w();
                                if (cg2VarW != null) {
                                    objG22 = cg2VarW.a.g(ng2Var2);
                                    if (objG22 == null) {
                                        objG22 = null;
                                    }
                                    zA3 = g31.a(objG22, Boolean.TRUE);
                                } else {
                                    zA3 = false;
                                }
                                if (zA3) {
                                    r1.setMovementGranularities(r2.getMovementGranularities() | 20);
                                }
                            }
                        }
                    }
                    arrayList = new ArrayList();
                    arrayList.add("androidx.compose.ui.semantics.id");
                    charSequenceE = h3Var4.e();
                    if (charSequenceE != null) {
                        arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                    }
                    if (gm1Var.c(kg2.y)) {
                        arrayList.add("androidx.compose.ui.semantics.testTag");
                    }
                    if (gm1Var.c(kg2.O)) {
                        arrayList.add("androidx.compose.ui.semantics.shapeType");
                        arrayList.add("androidx.compose.ui.semantics.shapeRect");
                        arrayList.add("androidx.compose.ui.semantics.shapeCorners");
                        arrayList.add("androidx.compose.ui.semantics.shapeRegion");
                    }
                    r2.setAvailableExtraData(arrayList);
                    q12Var = (q12) y24.a(cg2Var, kg2.c);
                    f = 0.0f;
                    if (q12Var != null) {
                        ng2Var4 = bg2.i;
                        if (gm1Var.c(ng2Var4)) {
                            h3Var4.g("android.widget.SeekBar");
                        } else {
                            h3Var4.g("android.widget.ProgressBar");
                        }
                        if (q12Var != q12.b) {
                            r2.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, 0.0f, 0.0f, 0.0f));
                        }
                        if (gm1Var.c(ng2Var4)) {
                            pc4.a(gg2Var2);
                        }
                    }
                    if (pc4.a(gg2Var2)) {
                        h3Var4.a(new d3(R.id.accessibilityActionSetProgress, b2Var7.a));
                    }
                    objG12 = gg2Var2.k().a.g(kg2.f);
                    if (objG12 == null) {
                        objG12 = null;
                    }
                    lzVar = (lz) objG12;
                    if (lzVar != null) {
                        r1.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(lzVar.a, lzVar.b, false, 0));
                        f2 = 0.0f;
                    } else {
                        arrayList2 = new ArrayList();
                        objG13 = gg2Var2.k().a.g(kg2.e);
                        if (objG13 == null) {
                            objG13 = null;
                        }
                        if (objG13 != null) {
                            listI2 = gg2Var2.i((4 & 1) != 0 ? !gg2Var2.b : false, (4 & 2) == 0);
                            size4 = listI2.size();
                            i7 = 0;
                            while (i7 < size4) {
                                gg2Var3 = (gg2) listI2.get(i7);
                                float f6 = f;
                                if (gg2Var3.k().a.c(kg2.H)) {
                                    arrayList2.add(gg2Var3);
                                }
                                i7++;
                                f = f6;
                            }
                        }
                        f2 = f;
                        if (!arrayList2.isEmpty()) {
                            zA = hi4.a(arrayList2);
                            if (zA) {
                                size2 = 1;
                            } else {
                                size2 = arrayList2.size();
                            }
                            if (zA) {
                                size3 = arrayList2.size();
                            } else {
                                size3 = 1;
                            }
                            r1.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(size2, size3, false, 0));
                        }
                    }
                    objG14 = gg2Var2.k().a.g(kg2.g);
                    if (objG14 == null) {
                        objG14 = null;
                    }
                    if (objG14 == null) {
                        gg2VarL2 = gg2Var2.l();
                        if (gg2VarL2 != null) {
                            objG19 = gg2VarL2.k().a.g(kg2.e);
                            if (objG19 == null) {
                                objG19 = null;
                            }
                            if (objG19 != null) {
                                objG20 = gg2VarL2.k().a.g(kg2.f);
                                if (objG20 == null) {
                                    objG20 = null;
                                }
                                lzVar2 = (lz) objG20;
                                if (lzVar2 != null) {
                                    if (gg2Var2.k().a.c(kg2.H)) {
                                        arrayList4 = new ArrayList();
                                        listI3 = gg2VarL2.i((4 & 1) != 0 ? !gg2VarL2.b : false, (4 & 2) == 0);
                                        size6 = listI3.size();
                                        i14 = 0;
                                        while (i13 < size6) {
                                            gg2Var4 = (gg2) listI3.get(i13);
                                            if (gg2Var4.k().a.c(kg2.H)) {
                                                arrayList4.add(gg2Var4);
                                                if (gg2Var4.c.v() < gg2Var2.c.v()) {
                                                    i14++;
                                                }
                                            }
                                        }
                                        if (!arrayList4.isEmpty()) {
                                            zA2 = hi4.a(arrayList4);
                                            if (zA2) {
                                                i15 = 0;
                                            } else {
                                                i15 = i14;
                                            }
                                            if (zA2) {
                                                i16 = i14;
                                            } else {
                                                i16 = 0;
                                            }
                                            objG21 = gg2Var2.k().a.g(kg2.H);
                                            if (objG21 == null) {
                                                objG21 = Boolean.FALSE;
                                            }
                                            r1.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i15, 1, i16, 1, false, ((Boolean) objG21).booleanValue()));
                                        }
                                    }
                                } else if (gg2Var2.k().a.c(kg2.H)) {
                                    arrayList4 = new ArrayList();
                                    listI3 = gg2VarL2.i((4 & 1) != 0 ? !gg2VarL2.b : false, (4 & 2) == 0);
                                    size6 = listI3.size();
                                    i14 = 0;
                                    while (i13 < size6) {
                                        gg2Var4 = (gg2) listI3.get(i13);
                                        if (gg2Var4.k().a.c(kg2.H)) {
                                            arrayList4.add(gg2Var4);
                                            if (gg2Var4.c.v() < gg2Var2.c.v()) {
                                                i14++;
                                            }
                                        }
                                    }
                                    if (!arrayList4.isEmpty()) {
                                        zA2 = hi4.a(arrayList4);
                                        if (zA2) {
                                            i15 = 0;
                                        } else {
                                            i15 = i14;
                                        }
                                        if (zA2) {
                                            i16 = i14;
                                        } else {
                                            i16 = 0;
                                        }
                                        objG21 = gg2Var2.k().a.g(kg2.H);
                                        if (objG21 == null) {
                                            objG21 = Boolean.FALSE;
                                        }
                                        r1.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i15, 1, i16, 1, false, ((Boolean) objG21).booleanValue()));
                                    }
                                }
                            }
                        }
                    } else {
                        dk0.t();
                    }
                    ed2Var = (ed2) y24.a(cg2Var, kg2.u);
                    b2 b2Var16 = (b2) y24.a(cg2Var, bg2.d);
                    if (ed2Var != null) {
                        objG17 = gg2Var2.k().a.g(kg2.f);
                        if (objG17 == null) {
                            objG17 = null;
                        }
                        if (objG17 == null) {
                            objG18 = gg2Var2.k().a.g(kg2.e);
                            if (objG18 == null) {
                                objG18 = null;
                            }
                            if (objG18 == null) {
                                h3Var4.g("android.widget.HorizontalScrollView");
                            }
                        }
                        if (((Number) ed2Var.b.a()).floatValue() > f2) {
                            r1.setScrollable(true);
                        }
                        if (pc4.a(gg2Var2)) {
                            zR = x7.r(ed2Var);
                            z61Var = z61.b;
                            if (zR) {
                                h3Var4.a(d3.e);
                                n71Var = n71Var2;
                                if (n71Var.i0 == z61Var) {
                                    d3Var2 = d3.h;
                                } else {
                                    d3Var2 = d3.j;
                                }
                                h3Var4.a(d3Var2);
                            } else {
                                n71Var = n71Var2;
                            }
                            if (x7.q(ed2Var)) {
                                h3Var4.a(d3.f);
                                if (n71Var.i0 == z61Var) {
                                    d3Var = d3.j;
                                } else {
                                    d3Var = d3.h;
                                }
                                h3Var4.a(d3Var);
                            }
                        }
                    }
                    ed2Var2 = (ed2) y24.a(cg2Var, kg2.v);
                    if (ed2Var2 != null) {
                        objG15 = gg2Var2.k().a.g(kg2.f);
                        if (objG15 == null) {
                            objG15 = null;
                        }
                        if (objG15 == null) {
                            objG16 = gg2Var2.k().a.g(kg2.e);
                            if (objG16 == null) {
                                objG16 = null;
                            }
                            if (objG16 == null) {
                                h3Var4.g("android.widget.ScrollView");
                            }
                        }
                        if (((Number) ed2Var2.b.a()).floatValue() > f2) {
                            r1.setScrollable(true);
                        }
                        if (pc4.a(gg2Var2)) {
                            if (x7.r(ed2Var2)) {
                                h3Var4.a(d3.e);
                                h3Var4.a(d3.i);
                            }
                            if (x7.q(ed2Var2)) {
                                h3Var4.a(d3.f);
                                h3Var4.a(d3.g);
                            }
                        }
                    }
                    i8 = Build.VERSION.SDK_INT;
                    if (i8 >= 29) {
                        nc4.a(h3Var4, gg2Var2);
                    }
                    charSequence = (CharSequence) y24.a(cg2Var, kg2.d);
                    if (i8 >= 28) {
                        r1.setPaneTitle(charSequence);
                    } else {
                        r1.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
                    }
                    if (pc4.a(gg2Var2)) {
                        b2Var4 = (b2) y24.a(cg2Var, bg2.t);
                        if (b2Var4 != null) {
                            h3Var4.a(new d3(ArabicShaping.TASHKEEL_BEGIN, b2Var4.a));
                        }
                        b2Var5 = (b2) y24.a(cg2Var, bg2.u);
                        if (b2Var5 != null) {
                            h3Var4.a(new d3(ArabicShaping.TASHKEEL_RESIZE, b2Var5.a));
                        }
                        b2Var6 = (b2) y24.a(cg2Var, bg2.v);
                        if (b2Var6 != null) {
                            h3Var4.a(new d3(1048576, b2Var6.a));
                        }
                        ng2Var3 = bg2.x;
                        if (cg2Var.a.c(bg2.x)) {
                            list2 = (List) cg2Var.d(ng2Var3);
                            size5 = list2.size();
                            ll1Var = x7.x0;
                            if (size5 < ll1Var.b) {
                                throw new IllegalStateException("Can't have more than " + ll1Var.b + " custom actions for one widget");
                            }
                            mp2 mp2Var5 = new mp2(0);
                            ul1 ul1VarA4 = xo1.a();
                            if (ny3.a(mp2Var.a, mp2Var.c, i6) >= 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                ul1Var = (ul1) mp2Var.b(i6);
                                iArr = ll1Var.a;
                                i9 = ll1Var.b;
                                iArrCopyOf = new int[16];
                                i10 = 0;
                                i11 = 0;
                                while (i10 < i9) {
                                    int i49 = iArr[i10];
                                    int i410 = i9;
                                    i12 = i11 + 1;
                                    ul1 ul1Var6 = ul1Var;
                                    if (iArrCopyOf.length < i12) {
                                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i12, (iArrCopyOf.length * 3) / 2));
                                    }
                                    iArrCopyOf[i11] = i49;
                                    i10++;
                                    i11 = i12;
                                    i9 = i410;
                                    ul1Var = ul1Var6;
                                }
                                ul1Var2 = ul1Var;
                                arrayList3 = new ArrayList();
                                if (list2.size() <= 0) {
                                    ky0.x(list2.get(0));
                                    ul1Var2.getClass();
                                    throw null;
                                }
                                if (arrayList3.size() <= 0) {
                                    ky0.x(arrayList3.get(0));
                                    if (i11 <= 0) {
                                        og.o("Index must be between 0 and size");
                                        return null;
                                    }
                                    int i411 = iArrCopyOf[0];
                                    throw null;
                                }
                            } else if (list2.size() > 0) {
                                ky0.x(list2.get(0));
                                ll1Var.c(0);
                                throw null;
                            }
                            x7Var2.Z.c(i6, mp2Var5);
                            mp2Var.c(i6, ul1VarA4);
                        }
                    }
                    zB = pc4.b(gg2Var2, resources);
                    if (Build.VERSION.SDK_INT >= 28) {
                        r1.setScreenReaderFocusable(zB);
                    } else {
                        h3Var4.f(1, zB);
                    }
                    iD = x7Var2.l0.d(i6);
                    if (iD != -1) {
                        e34.b(r7Var2.getAndroidViewsHandler$ui(), iD);
                        r7Var = r7Var2;
                        r1.setTraversalBefore(r7Var, iD);
                        x7Var2.b(i6, h3Var4, x7Var2.n0, null);
                    } else {
                        r7Var = r7Var2;
                    }
                    iD2 = x7Var2.m0.d(i6);
                    if (iD2 != -1) {
                        e34.b(r7Var.getAndroidViewsHandler$ui(), iD2);
                    }
                    str2 = (String) y24.a(cg2Var, lg2.b);
                    if (str2 != null) {
                        h3Var4.g(str2);
                    }
                    h3Var5 = h3Var4;
                } else {
                    x7Var2 = x7Var3;
                    i6 = i;
                    h3Var5 = null;
                }
            }
        }
        if (x7Var2.H) {
            if (i6 == x7Var2.u) {
                x7Var2.w = h3Var5;
            }
            if (i6 == x7Var2.v) {
                x7Var2.x = h3Var5;
            }
        }
        return h3Var5;
    }

    public void t(oh2 oh2Var) throws ds {
        CameraDevice cameraDevice = (CameraDevice) this.b;
        cameraDevice.getClass();
        nh2 nh2Var = oh2Var.a;
        nh2Var.c().getClass();
        List listD = nh2Var.d();
        if (listD == null) {
            og.i("Invalid output configurations");
            return;
        }
        if (nh2Var.f() == null) {
            og.i("Invalid executor");
            return;
        }
        String id = cameraDevice.getId();
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            String strB = ((ws1) it.next()).a.b();
            if (strB != null && !strB.isEmpty()) {
                xq4.d("CameraDeviceCompat", ky0.l("Camera ", id, ": Camera doesn't support physicalCameraId ", strB, ". Ignoring."));
            }
        }
        ss ssVar = new ss(nh2Var.f(), nh2Var.c());
        List listD2 = nh2Var.d();
        lt ltVar = (lt) this.c;
        ltVar.getClass();
        Handler handler = ltVar.a;
        j11 j11VarE = nh2Var.e();
        try {
            if (j11VarE != null) {
                InputConfiguration inputConfiguration = j11VarE.a.a;
                inputConfiguration.getClass();
                cameraDevice.createReprocessableCaptureSessionByConfigurations(inputConfiguration, oh2.a(listD2), ssVar, handler);
            } else {
                if (nh2Var.b() != 1) {
                    cameraDevice.createCaptureSessionByOutputConfigurations(oh2.a(listD2), ssVar, handler);
                    return;
                }
                ArrayList arrayList = new ArrayList(listD2.size());
                Iterator it2 = listD2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((OutputConfiguration) ((ws1) it2.next()).a.a()).getSurface());
                }
                cameraDevice.createConstrainedHighSpeedCaptureSession(arrayList, ssVar, handler);
            }
        } catch (CameraAccessException e) {
            throw new ds(e);
        }
    }

    public String toString() {
        switch (this.a) {
            case 3:
                return "AnimationResult(endReason=" + ((nd) this.c) + ", endState=" + ((qd) this.b) + ')';
            default:
                return super.toString();
        }
    }

    public int u() {
        Integer num = (Integer) ((CaptureResult) this.c).get(CaptureResult.CONTROL_AF_MODE);
        if (num == null) {
            return 1;
        }
        int iIntValue = num.intValue();
        if (iIntValue != 0) {
            if (iIntValue == 1 || iIntValue == 2) {
                return 3;
            }
            if (iIntValue == 3 || iIntValue == 4) {
                return 4;
            }
            if (iIntValue != 5) {
                xq4.a("C2CameraCaptureResult", "Undefined af mode: " + num);
                return 1;
            }
        }
        return 2;
    }

    public CameraCharacteristics v(String str) throws ds {
        try {
            return ((CameraManager) this.b).getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw new ds(e);
        }
    }

    public LinkedHashSet w() {
        LinkedHashSet linkedHashSet;
        synchronized (this.b) {
            linkedHashSet = new LinkedHashSet(((LinkedHashMap) this.c).values());
        }
        return linkedHashSet;
    }

    public Set x() {
        return Collections.EMPTY_SET;
    }

    public InputMethodManager y() {
        return (InputMethodManager) ((f81) this.c).getValue();
    }

    public oh1 z() {
        return (oh1) ((ku1) this.c).getValue();
    }

    public /* synthetic */ l11(int i, Object obj, Object obj2, boolean z) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    public /* synthetic */ l11(int i, boolean z) {
        this.a = i;
    }

    public l11(String str, rd3 rd3Var, fl4 fl4Var) {
        this.a = 4;
        this.c = str;
        this.b = rd3Var;
    }

    public l11(n71 n71Var, oh1 oh1Var) {
        this.a = 27;
        this.b = n71Var;
        this.c = o44.g(oh1Var);
    }

    public l11(CameraCaptureSession cameraCaptureSession, us usVar) {
        this.a = 11;
        cameraCaptureSession.getClass();
        this.b = cameraCaptureSession;
        this.c = usVar;
    }

    public l11(ru ruVar) {
        this.a = 16;
        this.b = ruVar;
        pl1 pl1Var = new pl1();
        this.c = pl1Var;
        pl1Var.i(new vh(5, null));
    }

    public l11(CameraDevice cameraDevice, lt ltVar) {
        this.a = 12;
        cameraDevice.getClass();
        this.b = cameraDevice;
        this.c = ltVar;
    }

    public l11(Context context, du duVar) {
        this.a = 13;
        this.b = (CameraManager) context.getSystemService("camera");
        this.c = duVar;
    }

    public l11(View view) {
        this.a = 0;
        this.b = view;
        this.c = yp4.a(new kb(8, this));
    }

    public l11(Context context, Object obj, LinkedHashSet linkedHashSet) {
        zt ztVarA;
        this.a = 10;
        ak1 ak1Var = new ak1(10);
        this.b = new HashMap();
        this.c = ak1Var;
        if (obj instanceof zt) {
            ztVarA = (zt) obj;
        } else {
            ztVarA = zt.a(context, jg1.g());
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ((HashMap) this.b).put(str, new jt2(context, str, ztVarA, (ak1) this.c));
        }
    }

    public /* synthetic */ l11(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public l11(int i) {
        this.a = i;
        switch (i) {
            case 5:
                this.b = new e4(1);
                this.c = new LinkedHashMap();
                break;
            case 14:
                this.b = new Object();
                this.c = new LinkedHashMap();
                new HashSet();
                break;
            default:
                this.b = new i3(this);
                break;
        }
    }

    public l11(v81 v81Var) {
        this.a = 28;
        this.b = v81Var;
        ul1 ul1Var = xo1.a;
        this.c = new ul1();
    }

    public l11(ve veVar) {
        this.a = 21;
        this.b = veVar;
        ci0 ci0Var = new ci0(veVar);
        this.c = ci0Var;
        veVar.addTextChangedListener(ci0Var);
        if (sh0.b == null) {
            synchronized (sh0.a) {
                try {
                    if (sh0.b == null) {
                        sh0 sh0Var = new sh0();
                        try {
                            sh0.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, sh0.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        sh0.b = sh0Var;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        veVar.setEditableFactory(sh0.b);
    }

    public l11(yq yqVar) {
        this.a = 9;
        this.c = yqVar;
        this.b = null;
    }

    public l11(ky kyVar) {
        this.a = 1;
        this.b = kyVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l11(x7 x7Var) {
        this(2);
        this.a = 2;
        this.c = x7Var;
    }
}
