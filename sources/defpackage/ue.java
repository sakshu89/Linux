package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.SystemClock;
import com.ibm.icu.impl.locale.LanguageTag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ue {
    public static final Set f = wh2.c(6, 8, 7);
    public static final Map g;
    public static final LinkedHashMap h;
    public final Context a;
    public final n21 b;
    public List c;
    public long d;
    public final Object e;

    static {
        Map mapC = bh1.c(new wt1("whatsapp", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("whats app", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("wa", nz.h("com.whatsapp")), new wt1("व्हाट्सऐप", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("व्हाट्सएप", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("व्हाट्सआप", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("व्हॉट्सॲप", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("ਵਾਟਸਐਪ", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("ਵਟਸਐਪ", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("વોટ્સએપ", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("વ્હોટ્સએપ", nz.i("com.whatsapp", "com.whatsapp.w4b")), new wt1("insta", nz.h("com.instagram.android")), new wt1("instagram", nz.h("com.instagram.android")), new wt1("इंस्टाग्राम", nz.h("com.instagram.android")), new wt1("ਇੰਸਟਾਗ੍ਰਾਮ", nz.h("com.instagram.android")), new wt1("ઇન્સ્ટાગ્રામ", nz.h("com.instagram.android")), new wt1("fb", nz.h("com.facebook.katana")), new wt1("facebook", nz.h("com.facebook.katana")), new wt1("फेसबुक", nz.h("com.facebook.katana")), new wt1("ਫੇਸਬੁੱਕ", nz.h("com.facebook.katana")), new wt1("ફેસબુક", nz.h("com.facebook.katana")), new wt1("messenger", nz.h("com.facebook.orca")), new wt1("yt", nz.h("com.google.android.youtube")), new wt1("youtube", nz.h("com.google.android.youtube")), new wt1("यूट्यूब", nz.h("com.google.android.youtube")), new wt1("ਯੂਟਿਊਬ", nz.h("com.google.android.youtube")), new wt1("યુટ્યુબ", nz.h("com.google.android.youtube")), new wt1("youtube music", nz.h("com.google.android.apps.youtube.music")), new wt1("yt music", nz.h("com.google.android.apps.youtube.music")), new wt1("gmail", nz.h("com.google.android.gm")), new wt1("mail", nz.h("com.google.android.gm")), new wt1("जीमेल", nz.h("com.google.android.gm")), new wt1("ਜੀਮੇਲ", nz.h("com.google.android.gm")), new wt1("જીમેલ", nz.h("com.google.android.gm")), new wt1("maps", nz.h("com.google.android.apps.maps")), new wt1("google maps", nz.h("com.google.android.apps.maps")), new wt1("मैप्स", nz.h("com.google.android.apps.maps")), new wt1("ਮੈਪਸ", nz.h("com.google.android.apps.maps")), new wt1("મેપ્સ", nz.h("com.google.android.apps.maps")), new wt1("play store", nz.h("com.android.vending")), new wt1("playstore", nz.h("com.android.vending")), new wt1("प्ले स्टोर", nz.h("com.android.vending")), new wt1("ਪਲੇ ਸਟੋਰ", nz.h("com.android.vending")), new wt1("પ્લે સ્ટોਰ", nz.h("com.android.vending")), new wt1("chrome", nz.h("com.android.chrome")), new wt1("browser", nz.h("com.android.chrome")), new wt1("क्रोम", nz.h("com.android.chrome")), new wt1("ਕ੍ਰੋਮ", nz.h("com.android.chrome")), new wt1("ક્રોમ", nz.h("com.android.chrome")), new wt1("spotify", nz.h("com.spotify.music")), new wt1("netflix", nz.h("com.netflix.mediaclient")), new wt1("prime video", nz.h("com.amazon.avod.thirdpartyclient")), new wt1("hotstar", nz.i("in.startv.hotstar", "in.startv.hotstar.dplus")), new wt1("photos", nz.h("com.google.android.apps.photos")), new wt1("drive", nz.h("com.google.android.apps.docs")), new wt1("telegram", nz.h("org.telegram.messenger")), new wt1("gpay", nz.h("com.google.android.apps.nbu.paisa.user")), new wt1("google pay", nz.h("com.google.android.apps.nbu.paisa.user")), new wt1("phonepe", nz.h("com.phonepe.app")), new wt1("paytm", nz.h("net.one97.paytm")), new wt1("amazon", nz.i("in.amazon.mShop.android.shopping", "com.amazon.mShop.android.shopping")), new wt1("flipkart", nz.h("com.flipkart.android")), new wt1("swiggy", nz.h("in.swiggy.android")), new wt1("zomato", nz.h("com.application.zomato")), new wt1("uber", nz.h("com.ubercab")), new wt1("ola", nz.h("com.olacabs.customer")), new wt1(LanguageTag.PRIVATEUSE, nz.h("com.twitter.android")), new wt1("twitter", nz.h("com.twitter.android")), new wt1("linkedin", nz.h("com.linkedin.android")), new wt1("snapchat", nz.h("com.snapchat.android")), new wt1("snap", nz.h("com.snapchat.android")), new wt1("discord", nz.h("com.discord")), new wt1("reddit", nz.h("com.reddit.frontpage")), new wt1("zoom", nz.h("us.zoom.videomeetings")), new wt1("teams", nz.h("com.microsoft.teams")), new wt1("meet", nz.h("com.google.android.apps.tachyon")));
        g = mapC;
        Set<Map.Entry> setEntrySet = mapC.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setEntrySet) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            ArrayList arrayList2 = new ArrayList(nz.d(list));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new wt1((String) it.next(), str));
            }
            rz.q(arrayList2, arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            wt1 wt1Var = (wt1) obj;
            String str2 = (String) wt1Var.a;
            Object arrayList3 = linkedHashMap.get(str2);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap.put(str2, arrayList3);
            }
            ((List) arrayList3).add((String) wt1Var.b);
        }
        h = linkedHashMap;
    }

    public ue(Context context, n21 n21Var) {
        n21Var.getClass();
        this.a = context;
        this.b = n21Var;
        this.c = ii0.a;
        this.e = new Object();
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0124  */
    public static rf a(String str, List list, boolean z) {
        String str2;
        boolean z2;
        boolean zEquals;
        String strR = qs4.r(str);
        if (strR != null) {
            if (cs2.A(strR)) {
                strR = null;
            }
            if (strR != null) {
                int i = 0;
                boolean zAnyMatch = str.codePoints().anyMatch(new te(i));
                String strE = qs4.e(strR);
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    x11 x11Var = (x11) obj;
                    qc1 qc1VarE = nz.e();
                    if ((zAnyMatch || x11Var.d) && (str2 = (String) x11Var.e.getValue()) != null) {
                        qc1VarE.add(str2);
                    }
                    if (zAnyMatch) {
                        Collection collection = (List) h.get(x11Var.a);
                        if (collection == null) {
                            collection = ii0.a;
                        }
                        qc1VarE.addAll(collection);
                    }
                    qc1 qc1VarC = nz.c(qc1VarE);
                    if (qc1VarC == null || !qc1VarC.isEmpty()) {
                        ListIterator listIterator = qc1VarC.listIterator(i);
                        while (true) {
                            nw0 nw0Var = (nw0) listIterator;
                            if (!nw0Var.hasNext()) {
                                break;
                            }
                            String str3 = (String) nw0Var.next();
                            if (z) {
                                zEquals = strR.equals(str3);
                            } else {
                                int i2 = Math.min(strR.length(), str3.length()) >= 8 ? 2 : 1;
                                int i3 = (Math.min(strR.length(), str3.length()) < 5 || qs4.n(strR, i2, str3) > i2) ? i : 1;
                                String strE2 = qs4.e(str3);
                                StringBuilder sb = new StringBuilder();
                                for (int i4 = i; i4 < strE.length(); i4++) {
                                    char cCharAt = strE.charAt(i4);
                                    if (!cs2.o("aeiouy ", cCharAt)) {
                                        sb.append(cCharAt);
                                    }
                                }
                                String string = sb.toString();
                                if (Math.min(strE.length(), strE2.length()) < 4 || string.length() < 3) {
                                    z2 = false;
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    for (int i5 = i; i5 < strE2.length(); i5++) {
                                        char cCharAt2 = strE2.charAt(i5);
                                        if (!cs2.o("aeiouy ", cCharAt2)) {
                                            sb2.append(cCharAt2);
                                        }
                                    }
                                    if (!string.equals(sb2.toString()) || qs4.n(strE, i2, strE2) > i2) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                }
                                zEquals = i3 != 0 || z2;
                            }
                            if (zEquals) {
                                arrayList.add(obj);
                                break;
                            }
                            i = 0;
                        }
                    }
                    i = 0;
                }
                return c(str, z ? "same name across scripts" : "close name across scripts", arrayList);
            }
        }
        return null;
    }

    public static rf c(String str, String str2, ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (hashSet.add(((x11) obj).a)) {
                arrayList2.add(obj);
            }
        }
        int size2 = arrayList2.size();
        if (size2 != 0) {
            return size2 != 1 ? new of(str, mz.L(arrayList2, 5)) : new qf((x11) mz.H(arrayList2), str2);
        }
        return null;
    }

    public final List b() {
        synchronized (this.e) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (!this.c.isEmpty() && jElapsedRealtime - this.d < 30000) {
                return this.c;
            }
            List listD = d();
            this.c = listD;
            this.d = jElapsedRealtime;
            return listD;
        }
    }

    public final List d() {
        x11 x11Var;
        String str;
        Intent intentAddCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
        intentAddCategory.getClass();
        PackageManager packageManager = this.a.getPackageManager();
        try {
            int i = 0;
            List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intentAddCategory, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.queryIntentActivities(intentAddCategory, 0);
            listQueryIntentActivities.getClass();
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo == null || (str = activityInfo.packageName) == null) {
                    x11Var = null;
                } else {
                    String string = cs2.V(resolveInfo.loadLabel(packageManager).toString()).toString();
                    if (string.length() == 0) {
                        string = str;
                    }
                    x11Var = new x11(str, string);
                }
                if (x11Var != null) {
                    arrayList.add(x11Var);
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (hashSet.add(((x11) obj).a)) {
                    arrayList2.add(obj);
                }
            }
            return mz.K(arrayList2, new lo0(10));
        } catch (RuntimeException unused) {
            return ii0.a;
        }
    }
}
