package defpackage;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hv {
    public static final Set g = wh2.c("start recording", "start video recording", "start recording video", "record video", "record a video", "begin recording");
    public static final Set h = wh2.c("stop recording", "stop video recording", "stop recording video", "stop video capture", "end recording");
    public static final Set i = wh2.c("start_recording", "start_recording_button", "start_video_recording_button");
    public static final Set j = wh2.c("stop_recording", "stop_recording_button", "stop_video_recording", "stop_video_recording_button", "video_stop_button");
    public static final Set k = wh2.c("take photo", "take picture", "capture photo", "photo shutter", "take a photo");
    public static final Set l = wh2.c("recording_status", "video_recording_status", "recording_indicator");
    public static final Set m = wh2.c("recording", "recording video", "video recording");
    public static final Set n = wh2.c("review_done", "review_retake", "video_review_done", "video_review_retake");
    public static final Set o = wh2.c("save video", "retake video", "done", "retake");
    public static final Set p = wh2.c("com.oplus.camera", "com.oppo.camera", "com.coloros.camera", "com.oneplus.camera", "com.android.camera", "com.android.camera2", "com.sec.android.app.camera", "com.google.android.GoogleCamera", "com.motorola.camera3", "com.huawei.camera", "com.honor.camera", "org.codeaurora.snapcam");
    public final r2 a;
    public final nb2 b;
    public final j5 c;
    public final an1 d;
    public String e;
    public wt1 f;

    public hv(r2 r2Var, nb2 nb2Var, j5 j5Var) {
        r2Var.getClass();
        nb2Var.getClass();
        j5Var.getClass();
        this.a = r2Var;
        this.b = nb2Var;
        this.c = j5Var;
        this.d = new an1();
    }

    public static List a(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rectG = cq.g(accessibilityNodeInfo);
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        CharSequence text = accessibilityNodeInfo.getText();
        String string = text != null ? text.toString() : null;
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        return nz.i(viewIdResourceName, string, contentDescription != null ? contentDescription.toString() : null, Integer.valueOf(rectG.left), Integer.valueOf(rectG.top), Integer.valueOf(rectG.right), Integer.valueOf(rectG.bottom));
    }

    public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo, bv bvVar) {
        Rect rectG;
        int i2;
        int i3;
        int i4;
        int i5;
        if (!accessibilityNodeInfo.isVisibleToUser() || !accessibilityNodeInfo.isEnabled() || accessibilityNodeInfo.isPassword() || accessibilityNodeInfo.isEditable()) {
            return false;
        }
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        return g31.a(packageName != null ? packageName.toString() : null, bvVar.a) && accessibilityNodeInfo.getWindowId() == bvVar.b && (i2 = (rectG = cq.g(accessibilityNodeInfo)).right) > (i3 = rectG.left) && (i4 = rectG.bottom) > (i5 = rectG.top) && i3 >= bvVar.c && i5 >= bvVar.d && i2 <= bvVar.e && i4 <= bvVar.f;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:111:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:113:0x0200  */
    /* JADX WARN: Code duplicated, block: B:47:0x0131  */
    /* JADX WARN: Code duplicated, block: B:60:0x0163  */
    public static av c(cv cvVar) {
        String strO;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        AccessibilityNodeInfo accessibilityNodeInfo;
        String str;
        String string;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = cvVar.b;
        IdentityHashMap identityHashMap = cvVar.c;
        bv bvVar = cvVar.a;
        int size = arrayList3.size();
        int i3 = 0;
        boolean z4 = false;
        boolean z5 = false;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList3.get(i4);
            i4++;
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            if (b(accessibilityNodeInfo2, bvVar)) {
                String viewIdResourceName = accessibilityNodeInfo2.getViewIdResourceName();
                if (viewIdResourceName != null) {
                    String strS = cs2.S(viewIdResourceName, '/');
                    Locale locale = Locale.ROOT;
                    strO = cq.o(locale, strS, locale);
                } else {
                    strO = null;
                }
                if (strO == null) {
                    strO = "";
                }
                CharSequence text = accessibilityNodeInfo2.getText();
                CharSequence contentDescription = accessibilityNodeInfo2.getContentDescription();
                CharSequence[] charSequenceArr = new CharSequence[2];
                charSequenceArr[i3] = text;
                charSequenceArr[1] = contentDescription;
                List<String> listH = zg2.h(zg2.f(zg2.g(charSequenceArr), new j(12)));
                ArrayList arrayList4 = new ArrayList(nz.d(listH));
                for (String str2 : listH) {
                    Locale locale2 = Locale.ROOT;
                    String strO2 = cq.o(locale2, str2, locale2);
                    Pattern patternCompile = Pattern.compile("\\s+");
                    patternCompile.getClass();
                    ArrayList arrayList5 = arrayList3;
                    String strReplaceAll = patternCompile.matcher(strO2).replaceAll(Padder.FALLBACK_PADDING_STRING);
                    strReplaceAll.getClass();
                    arrayList4.add(cs2.Y(cs2.V(strReplaceAll).toString(), '.', '!'));
                    arrayList3 = arrayList5;
                }
                ArrayList arrayList6 = arrayList3;
                if (l.contains(strO) && !arrayList4.isEmpty()) {
                    int size2 = arrayList4.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        Object obj2 = arrayList4.get(i5);
                        i5++;
                        if (m.contains((String) obj2)) {
                            z4 = true;
                            break;
                        }
                    }
                }
                if (n.contains(strO) && !arrayList4.isEmpty()) {
                    int size3 = arrayList4.size();
                    int i6 = 0;
                    while (i6 < size3) {
                        Object obj3 = arrayList4.get(i6);
                        i6++;
                        if (o.contains((String) obj3)) {
                            z5 = true;
                            break;
                        }
                    }
                }
                if (!arrayList4.isEmpty()) {
                    int size4 = arrayList4.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 < size4) {
                            Object obj4 = arrayList4.get(i7);
                            i7++;
                            if (g.contains((String) obj4)) {
                            }
                        } else if (i.contains(strO)) {
                            z = false;
                        }
                        z = true;
                    }
                } else if (i.contains(strO)) {
                    z = false;
                } else {
                    z = true;
                }
                if (arrayList4.isEmpty()) {
                    z2 = z;
                    if (!j.contains(strO)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    int size5 = arrayList4.size();
                    int i8 = 0;
                    while (true) {
                        if (i8 < size5) {
                            Object obj5 = arrayList4.get(i8);
                            i8++;
                            z2 = z;
                            if (!h.contains((String) obj5)) {
                                z = z2;
                            }
                        } else {
                            z2 = z;
                            if (!j.contains(strO)) {
                                z3 = false;
                            }
                        }
                        z3 = true;
                    }
                }
                if (z2 || z3) {
                    if (!arrayList4.isEmpty()) {
                        int size6 = arrayList4.size();
                        int i9 = 0;
                        while (true) {
                            if (i9 < size6) {
                                Object obj6 = arrayList4.get(i9);
                                i9++;
                                if (k.contains((String) obj6)) {
                                    i2 = 0;
                                }
                            }
                        }
                    }
                    int i10 = 0;
                    Object obj7 = accessibilityNodeInfo2;
                    while (true) {
                        if (i10 < 4) {
                            accessibilityNodeInfo = (AccessibilityNodeInfo) obj7;
                            if (accessibilityNodeInfo == null) {
                                accessibilityNodeInfo = null;
                                i2 = 0;
                            } else if (identityHashMap.get(accessibilityNodeInfo) != null && b(accessibilityNodeInfo, bvVar) && !accessibilityNodeInfo.isScrollable()) {
                                CharSequence className = accessibilityNodeInfo.getClassName();
                                if (className == null || (string = className.toString()) == null) {
                                    i2 = 0;
                                } else {
                                    i2 = 0;
                                    if (cs2.n(string, "RecyclerView", false) || cs2.n(string, "ScrollView", false) || js2.e(string, "SeekBar", false)) {
                                        accessibilityNodeInfo = null;
                                    }
                                }
                                if (!accessibilityNodeInfo.isClickable()) {
                                    i10++;
                                    obj7 = identityHashMap.get(accessibilityNodeInfo);
                                }
                            }
                            if (accessibilityNodeInfo != null) {
                                str = (String) mz.y(listH);
                                if (str == null) {
                                    if (z2) {
                                        str = "Start recording";
                                    } else {
                                        str = "Stop recording";
                                    }
                                }
                                if (z2) {
                                    arrayList.add(new zu(accessibilityNodeInfo, str));
                                }
                                if (z3) {
                                    arrayList2.add(new zu(accessibilityNodeInfo, str));
                                }
                            }
                        }
                        i2 = 0;
                        accessibilityNodeInfo = null;
                        if (accessibilityNodeInfo != null) {
                            str = (String) mz.y(listH);
                            if (str == null) {
                                if (z2) {
                                    str = "Start recording";
                                } else {
                                    str = "Stop recording";
                                }
                            }
                            if (z2) {
                                arrayList.add(new zu(accessibilityNodeInfo, str));
                            }
                            if (z3) {
                                arrayList2.add(new zu(accessibilityNodeInfo, str));
                            }
                        }
                    }
                } else {
                    i2 = 0;
                }
                i3 = i2;
                arrayList3 = arrayList6;
            }
        }
        int i11 = i3;
        HashSet hashSet = new HashSet();
        ArrayList arrayList7 = new ArrayList();
        int size7 = arrayList.size();
        int i12 = i11;
        while (i12 < size7) {
            Object obj8 = arrayList.get(i12);
            i12++;
            if (hashSet.add(((zu) obj8).a)) {
                arrayList7.add(obj8);
            }
        }
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList8 = new ArrayList();
        int size8 = arrayList2.size();
        int i13 = i11;
        while (i13 < size8) {
            Object obj9 = arrayList2.get(i13);
            i13++;
            if (hashSet2.add(((zu) obj9).a)) {
                arrayList8.add(obj9);
            }
        }
        return new av(arrayList7, arrayList8, z4, z5);
    }

    public static boolean i(String str) {
        return (cs2.A(str) || wh2.c("unknown", "android", "android.chooser", "com.android.intentresolver", "com.android.permissioncontroller", "com.google.android.permissioncontroller", "com.project.sonic").contains(str)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:112:0x0213  */
    /* JADX WARN: Code duplicated, block: B:114:0x0219  */
    /* JADX WARN: Code duplicated, block: B:117:0x023a  */
    /* JADX WARN: Code duplicated, block: B:120:0x0243  */
    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a2 A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ae A[Catch: all -> 0x0067, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00bd A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c1 A[Catch: all -> 0x0067, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00ec A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x010a A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x010d A[Catch: all -> 0x0067, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x013d A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0145 A[Catch: all -> 0x0067, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0167  */
    /* JADX WARN: Code duplicated, block: B:76:0x0169  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:83:0x0184 A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0197 A[Catch: all -> 0x0067, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x019f  */
    /* JADX WARN: Code duplicated, block: B:93:0x01a3 A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x01ba A[Catch: all -> 0x0067, TryCatch #0 {all -> 0x0067, blocks: (B:35:0x00a2, B:38:0x00ae, B:40:0x00b2, B:43:0x00bd, B:45:0x00c1, B:47:0x00c7, B:50:0x00d2, B:52:0x00de, B:55:0x00ec, B:57:0x00fd, B:61:0x010a, B:63:0x010f, B:65:0x0116, B:67:0x0126, B:68:0x0134, B:71:0x013d, B:73:0x0145, B:77:0x0171, B:79:0x0177, B:83:0x0184, B:85:0x018a, B:89:0x0197, B:93:0x01a3, B:95:0x01ba, B:97:0x01d2, B:62:0x010d, B:101:0x01df, B:122:0x0250, B:19:0x0062), top: B:135:0x0062 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x023a -> B:118:0x023d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x0243 -> B:119:0x0240). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object d(java.lang.String r18, boolean r19, boolean r20, defpackage.y50 r21) {
        /*
            Method dump skipped, instruction units count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hv.d(java.lang.String, boolean, boolean, y50):java.lang.Object");
    }

    public final cv e() {
        AccessibilityNodeInfo accessibilityNodeInfoB = this.a.b();
        if (accessibilityNodeInfoB == null) {
            return null;
        }
        Rect rectG = cq.g(accessibilityNodeInfoB);
        CharSequence packageName = accessibilityNodeInfoB.getPackageName();
        String string = packageName != null ? packageName.toString() : null;
        if (string == null) {
            string = "";
        }
        String str = string;
        if (cs2.A(str) || rectG.right <= rectG.left || rectG.bottom <= rectG.top) {
            accessibilityNodeInfoB.recycle();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(accessibilityNodeInfoB);
        while (!arrayDeque.isEmpty() && arrayList.size() < 240) {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) arrayDeque.removeFirst();
            arrayList.add(accessibilityNodeInfo);
            if (!accessibilityNodeInfo.isPassword()) {
                int childCount = accessibilityNodeInfo.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
                    if (child != null) {
                        identityHashMap.put(child, accessibilityNodeInfo);
                        arrayDeque.add(child);
                    }
                }
            }
        }
        boolean zIsEmpty = arrayDeque.isEmpty();
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            ((AccessibilityNodeInfo) it.next()).recycle();
        }
        return new cv(new bv(accessibilityNodeInfoB.getWindowId(), rectG.left, rectG.top, str, rectG.right, rectG.bottom), arrayList, identityHashMap, zIsEmpty);
    }

    public final mv f(bv bvVar, boolean z, zu zuVar) {
        cv cvVarE = e();
        if (cvVarE == null) {
            return new jv("Camera left the foreground");
        }
        try {
            if (cvVarE.e && cvVarE.a.equals(bvVar)) {
                av avVarC = c(cvVarE);
                if (avVarC.a(z)) {
                    this.f = null;
                    return new lv(bvVar.a, z, true);
                }
                ArrayList arrayList = z ? avVarC.a : avVarC.b;
                if (arrayList.size() <= 1) {
                    zu zuVar2 = (zu) mz.I(arrayList);
                    if (zuVar2 == null) {
                        return new jv("Recording control disappeared before activation");
                    }
                    if (a(zuVar2.a).equals(a(zuVar.a))) {
                        return null;
                    }
                    return new jv("Recording control changed before activation");
                }
                ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    arrayList2.add(((zu) obj).b);
                }
                return new iv(arrayList2);
            }
            return new jv("Camera window changed before activation");
        } finally {
            cvVarE.close();
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008f A[Catch: all -> 0x0097, TryCatch #2 {all -> 0x0097, blocks: (B:35:0x0089, B:37:0x008f, B:40:0x009a, B:42:0x00a0, B:43:0x00a8, B:30:0x0071), top: B:59:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x009a A[Catch: all -> 0x0097, TryCatch #2 {all -> 0x0097, blocks: (B:35:0x0089, B:37:0x008f, B:40:0x009a, B:42:0x00a0, B:43:0x00a8, B:30:0x0071), top: B:59:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a0 A[Catch: all -> 0x0097, TryCatch #2 {all -> 0x0097, blocks: (B:35:0x0089, B:37:0x008f, B:40:0x009a, B:42:0x00a0, B:43:0x00a8, B:30:0x0071), top: B:59:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a8 A[Catch: all -> 0x0097, TRY_LEAVE, TryCatch #2 {all -> 0x0097, blocks: (B:35:0x0089, B:37:0x008f, B:40:0x009a, B:42:0x00a0, B:43:0x00a8, B:30:0x0071), top: B:59:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g(String str, y50 y50Var) {
        ev evVar;
        an1 an1Var;
        int i2;
        an1 an1Var2;
        j5 j5Var;
        Object objC;
        String str2;
        int i3;
        Object objD;
        mv jvVar;
        if (y50Var instanceof ev) {
            evVar = (ev) y50Var;
            int i4 = evVar.s;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                evVar.s = i4 - Integer.MIN_VALUE;
            } else {
                evVar = new ev(this, y50Var);
            }
        } else {
            evVar = new ev(this, y50Var);
        }
        Object obj = evVar.k;
        int i5 = evVar.s;
        int i6 = 0;
        Object obj2 = t70.a;
        try {
            try {
                if (i5 == 0) {
                    bz3.g(obj);
                    evVar.e = str;
                    an1Var = this.d;
                    evVar.f = an1Var;
                    evVar.i = 0;
                    evVar.s = 1;
                    if (an1Var.e(evVar) != obj2) {
                        i2 = 0;
                    }
                    return obj2;
                }
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        an1Var2 = evVar.f;
                        try {
                            bz3.g(obj);
                            mv mvVar = (mv) obj;
                            an1Var = an1Var2;
                            jvVar = mvVar;
                            an1Var.h(null);
                            return jvVar;
                        } catch (Throwable th) {
                            th = th;
                            an1Var2.h(null);
                            throw th;
                        }
                    }
                    i6 = evVar.j;
                    i3 = evVar.i;
                    an1 an1Var3 = evVar.f;
                    String str3 = evVar.e;
                    try {
                        bz3.g(obj);
                        objC = obj;
                        an1Var = an1Var3;
                        str2 = str3;
                        if (!((g5) objC).i) {
                            jvVar = new jv("Screen reading is disabled in SONIC settings");
                        } else {
                            if (i(str2)) {
                                evVar.e = null;
                                evVar.f = an1Var;
                                evVar.i = i3;
                                evVar.j = i6;
                                evVar.s = 3;
                                objD = d(str2, true, true, evVar);
                                if (objD != obj2) {
                                    an1 an1Var4 = an1Var;
                                    obj = objD;
                                    an1Var2 = an1Var4;
                                    mv mvVar2 = (mv) obj;
                                    an1Var = an1Var2;
                                    jvVar = mvVar2;
                                }
                                return obj2;
                            }
                            jvVar = new jv("No resolved camera application");
                        }
                        an1Var.h(null);
                        return jvVar;
                    } catch (Throwable th2) {
                        th = th2;
                        an1Var2 = an1Var3;
                        an1Var2.h(null);
                        throw th;
                    }
                }
                int i7 = evVar.i;
                an1 an1Var5 = evVar.f;
                String str4 = evVar.e;
                bz3.g(obj);
                an1Var = an1Var5;
                i2 = i7;
                str = str4;
                objC = rn4.c(j5Var.b, evVar);
                if (objC != obj2) {
                    int i8 = i2;
                    str2 = str;
                    i3 = i8;
                    if (!((g5) objC).i) {
                        jvVar = new jv("Screen reading is disabled in SONIC settings");
                    } else if (i(str2)) {
                        jvVar = new jv("No resolved camera application");
                    } else {
                        evVar.e = null;
                        evVar.f = an1Var;
                        evVar.i = i3;
                        evVar.j = i6;
                        evVar.s = 3;
                        objD = d(str2, true, true, evVar);
                        if (objD != obj2) {
                            an1 an1Var6 = an1Var;
                            obj = objD;
                            an1Var2 = an1Var6;
                            mv mvVar3 = (mv) obj;
                            an1Var = an1Var2;
                            jvVar = mvVar3;
                        }
                    }
                    an1Var.h(null);
                    return jvVar;
                }
                return obj2;
            } catch (Throwable th3) {
                th = th3;
                an1Var2 = an1Var;
                an1Var2.h(null);
                throw th;
            }
            j5Var = this.c;
            evVar.e = str;
            evVar.f = an1Var;
            evVar.i = i2;
            evVar.j = 0;
            evVar.s = 2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008f A[Catch: all -> 0x0098, TryCatch #3 {all -> 0x0098, blocks: (B:35:0x0089, B:37:0x008f, B:40:0x009c, B:49:0x00b2, B:54:0x00bd, B:58:0x00c5, B:65:0x00dd, B:67:0x00e7, B:70:0x00ee, B:76:0x0108, B:50:0x00b6, B:51:0x00b9, B:30:0x0071, B:42:0x00a4, B:44:0x00aa), top: B:92:0x0071, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x009c A[Catch: all -> 0x0098, TRY_LEAVE, TryCatch #3 {all -> 0x0098, blocks: (B:35:0x0089, B:37:0x008f, B:40:0x009c, B:49:0x00b2, B:54:0x00bd, B:58:0x00c5, B:65:0x00dd, B:67:0x00e7, B:70:0x00ee, B:76:0x0108, B:50:0x00b6, B:51:0x00b9, B:30:0x0071, B:42:0x00a4, B:44:0x00aa), top: B:92:0x0071, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #5 {all -> 0x00af, blocks: (B:42:0x00a4, B:44:0x00aa), top: B:95:0x00a4, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d3 A[Catch: all -> 0x0115, TryCatch #1 {all -> 0x0115, blocks: (B:59:0x00cb, B:61:0x00d3, B:63:0x00d7), top: B:88:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00d7 A[Catch: all -> 0x0115, TRY_LEAVE, TryCatch #1 {all -> 0x0115, blocks: (B:59:0x00cb, B:61:0x00d3, B:63:0x00d7), top: B:88:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:95:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00da A[SYNTHETIC] */
    public final Object h(String str, y50 y50Var) {
        fv fvVar;
        an1 an1Var;
        int i2;
        j5 j5Var;
        Object objC;
        String str2;
        int i3;
        an1 an1Var2;
        AccessibilityNodeInfo accessibilityNodeInfoB;
        CharSequence packageName;
        String string;
        String[] strArr;
        LinkedHashSet linkedHashSet;
        int i4;
        mv jvVar;
        String str3;
        if (y50Var instanceof fv) {
            fvVar = (fv) y50Var;
            int i5 = fvVar.s;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                fvVar.s = i5 - Integer.MIN_VALUE;
            } else {
                fvVar = new fv(this, y50Var);
            }
        } else {
            fvVar = new fv(this, y50Var);
        }
        Object obj = fvVar.k;
        int i6 = fvVar.s;
        Object obj2 = t70.a;
        try {
            try {
                if (i6 == 0) {
                    bz3.g(obj);
                    fvVar.e = str;
                    an1Var = this.d;
                    fvVar.f = an1Var;
                    fvVar.i = 0;
                    fvVar.s = 1;
                    if (an1Var.e(fvVar) != obj2) {
                        i2 = 0;
                    }
                    return obj2;
                }
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        an1Var2 = fvVar.f;
                        try {
                            bz3.g(obj);
                            mv mvVar = (mv) obj;
                            an1Var = an1Var2;
                            jvVar = mvVar;
                            an1Var.h(null);
                            return jvVar;
                        } catch (Throwable th) {
                            th = th;
                            an1Var2.h(null);
                            throw th;
                        }
                    }
                    i3 = fvVar.j;
                    i2 = fvVar.i;
                    an1 an1Var3 = fvVar.f;
                    str2 = fvVar.e;
                    try {
                        bz3.g(obj);
                        objC = obj;
                        an1Var = an1Var3;
                        if (((g5) objC).i) {
                            accessibilityNodeInfoB = this.a.b();
                            if (accessibilityNodeInfoB != null) {
                                try {
                                    packageName = accessibilityNodeInfoB.getPackageName();
                                    if (packageName != null) {
                                        string = packageName.toString();
                                    } else {
                                        string = null;
                                    }
                                    accessibilityNodeInfoB.recycle();
                                } catch (Throwable th2) {
                                    accessibilityNodeInfoB.recycle();
                                    throw th2;
                                }
                            } else {
                                string = null;
                            }
                            if (str2 != null || !i(str2)) {
                                str2 = null;
                            }
                            strArr = new String[]{str2, this.e};
                            try {
                                linkedHashSet = new LinkedHashSet();
                                for (i4 = 0; i4 < 2; i4++) {
                                    str3 = strArr[i4];
                                    if (str3 != null) {
                                        linkedHashSet.add(str3);
                                    }
                                }
                                LinkedHashSet linkedHashSetA = wh2.a(linkedHashSet, p);
                                if (string == null && linkedHashSetA.contains(string)) {
                                    fvVar.e = null;
                                    fvVar.f = an1Var;
                                    fvVar.i = i2;
                                    fvVar.j = i3;
                                    fvVar.s = 3;
                                    Object objD = d(string, false, false, fvVar);
                                    if (objD != obj2) {
                                        an1 an1Var4 = an1Var;
                                        obj = objD;
                                        an1Var2 = an1Var4;
                                        mv mvVar2 = (mv) obj;
                                        an1Var = an1Var2;
                                        jvVar = mvVar2;
                                    }
                                    return obj2;
                                }
                                jvVar = new jv("A supported camera application is not in the foreground");
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                an1Var2 = an1Var;
                                an1Var2.h(null);
                                throw th;
                            }
                        } else {
                            jvVar = new jv("Screen reading is disabled in SONIC settings");
                        }
                        an1Var.h(null);
                        return jvVar;
                    } catch (Throwable th4) {
                        th = th4;
                        an1Var2 = an1Var3;
                        an1Var2.h(null);
                        throw th;
                    }
                }
                int i7 = fvVar.i;
                an1 an1Var5 = fvVar.f;
                String str4 = fvVar.e;
                bz3.g(obj);
                an1Var = an1Var5;
                i2 = i7;
                str = str4;
                objC = rn4.c(j5Var.b, fvVar);
                if (objC != obj2) {
                    str2 = str;
                    i3 = 0;
                    if (((g5) objC).i) {
                        jvVar = new jv("Screen reading is disabled in SONIC settings");
                    } else {
                        accessibilityNodeInfoB = this.a.b();
                        if (accessibilityNodeInfoB != null) {
                            packageName = accessibilityNodeInfoB.getPackageName();
                            if (packageName != null) {
                                string = packageName.toString();
                            } else {
                                string = null;
                            }
                            accessibilityNodeInfoB.recycle();
                        } else {
                            string = null;
                        }
                        if (str2 != null) {
                            str2 = null;
                        } else {
                            str2 = null;
                        }
                        strArr = new String[]{str2, this.e};
                        linkedHashSet = new LinkedHashSet();
                        while (i4 < 2) {
                            str3 = strArr[i4];
                            if (str3 != null) {
                                linkedHashSet.add(str3);
                            }
                        }
                        LinkedHashSet linkedHashSetA2 = wh2.a(linkedHashSet, p);
                        if (string == null) {
                        }
                        jvVar = new jv("A supported camera application is not in the foreground");
                    }
                    an1Var.h(null);
                    return jvVar;
                }
                return obj2;
            } catch (Throwable th5) {
                th = th5;
                th = th;
                an1Var2 = an1Var;
                an1Var2.h(null);
                throw th;
            }
            j5Var = this.c;
            fvVar.e = str;
            fvVar.f = an1Var;
            fvVar.i = i2;
            fvVar.j = 0;
            fvVar.s = 2;
        } catch (Throwable th6) {
            th = th6;
            an1Var2 = an1Var;
            an1Var2.h(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0059 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0074 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:25:0x0070, B:27:0x0074, B:30:0x007d, B:32:0x0087, B:38:0x009b), top: B:47:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0087 A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #0 {all -> 0x0094, blocks: (B:25:0x0070, B:27:0x0074, B:30:0x007d, B:32:0x0087, B:38:0x009b), top: B:47:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0096  */
    /* JADX WARN: Code duplicated, block: B:47:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0057 -> B:19:0x005a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object j(defpackage.bv r8, boolean r9, defpackage.y50 r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof defpackage.gv
            if (r0 == 0) goto L13
            r0 = r10
            gv r0 = (defpackage.gv) r0
            int r1 = r0.s
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.s = r1
            goto L18
        L13:
            gv r0 = new gv
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.k
            int r1 = r0.s
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L3a
            if (r1 != r4) goto L34
            int r8 = r0.j
            int r9 = r0.i
            boolean r1 = r0.f
            bv r5 = r0.e
            defpackage.bz3.g(r10)
            r10 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r5
            goto L5a
        L34:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r7)
            return r2
        L3a:
            defpackage.bz3.g(r10)
            r10 = 16
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r3
        L43:
            if (r8 >= r10) goto Lae
            r1.e = r9
            r1.f = r0
            r1.i = r10
            r1.j = r8
            r1.s = r4
            r5 = 125(0x7d, double:6.2E-322)
            java.lang.Object r5 = defpackage.bm4.b(r5, r1)
            t70 r6 = defpackage.t70.a
            if (r5 != r6) goto L5a
            return r6
        L5a:
            r2 r5 = r7.a
            boolean r5 = r5.l()
            if (r5 == 0) goto L6a
            kv r7 = new kv
            java.lang.String r8 = "Phone locked before recording state was visible"
            r7.<init>(r0, r8)
            return r7
        L6a:
            cv r5 = r7.e()
            if (r5 == 0) goto L9b
            boolean r6 = r5.e     // Catch: java.lang.Throwable -> L94
            if (r6 == 0) goto L9b
            bv r6 = r5.a     // Catch: java.lang.Throwable -> L94
            boolean r6 = r6.equals(r9)     // Catch: java.lang.Throwable -> L94
            if (r6 != 0) goto L7d
            goto L9b
        L7d:
            av r6 = c(r5)     // Catch: java.lang.Throwable -> L94
            boolean r6 = r6.a(r0)     // Catch: java.lang.Throwable -> L94
            if (r6 == 0) goto L96
            r7.f = r2     // Catch: java.lang.Throwable -> L94
            lv r7 = new lv     // Catch: java.lang.Throwable -> L94
            java.lang.String r8 = r9.a     // Catch: java.lang.Throwable -> L94
            r7.<init>(r8, r0, r3)     // Catch: java.lang.Throwable -> L94
            r5.close()
            return r7
        L94:
            r7 = move-exception
            goto La8
        L96:
            r5.close()
            int r8 = r8 + r4
            goto L43
        L9b:
            kv r7 = new kv     // Catch: java.lang.Throwable -> L94
            java.lang.String r8 = "Camera window changed or became unreadable before recording state was confirmed"
            r7.<init>(r0, r8)     // Catch: java.lang.Throwable -> L94
            if (r5 == 0) goto La7
            r5.close()
        La7:
            return r7
        La8:
            if (r5 == 0) goto Lad
            r5.close()
        Lad:
            throw r7
        Lae:
            kv r7 = new kv
            java.lang.String r8 = "Camera accepted one activation but did not expose the requested recording state"
            r7.<init>(r0, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hv.j(bv, boolean, y50):java.lang.Object");
    }
}
