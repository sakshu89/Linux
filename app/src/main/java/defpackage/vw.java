package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.SparseArray;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vw implements p23 {
    public final uf1 a;
    public final ConnectivityManager b;
    public final Context c;
    public final URL d;
    public final wy e;
    public final wy f;
    public final int g;

    public vw(Context context, wy wyVar, wy wyVar2) {
        u41 u41Var = new u41();
        jh jhVar = jh.a;
        u41Var.a(el.class, jhVar);
        u41Var.a(th.class, jhVar);
        mh mhVar = mh.a;
        u41Var.a(xe1.class, mhVar);
        u41Var.a(ri.class, mhVar);
        kh khVar = kh.a;
        u41Var.a(ny.class, khVar);
        u41Var.a(ai.class, khVar);
        ih ihVar = ih.a;
        u41Var.a(x6.class, ihVar);
        u41Var.a(qh.class, ihVar);
        lh lhVar = lh.a;
        u41Var.a(we1.class, lhVar);
        u41Var.a(qi.class, lhVar);
        nh nhVar = nh.a;
        u41Var.a(mn1.class, nhVar);
        u41Var.a(ti.class, nhVar);
        u41Var.e = true;
        this.a = new uf1(25, u41Var);
        this.c = context;
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.d = b(po.c);
        this.e = wyVar2;
        this.f = wyVar;
        this.g = 40000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(cq.j("Invalid url: ", str), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:30:0x0111  */
    public final hi a(hi hiVar) {
        int type;
        int subtype;
        HashMap map;
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        lj1 lj1VarC = hiVar.c();
        int i = Build.VERSION.SDK_INT;
        HashMap map2 = (HashMap) lj1VarC.g;
        if (map2 == null) {
            og.n("Property \"autoMetadata\" has not been set");
            return null;
        }
        map2.put("sdk-version", String.valueOf(i));
        lj1VarC.a("model", Build.MODEL);
        lj1VarC.a("hardware", Build.HARDWARE);
        lj1VarC.a("device", Build.DEVICE);
        lj1VarC.a("product", Build.PRODUCT);
        lj1VarC.a("os-uild", Build.ID);
        lj1VarC.a("manufacturer", Build.MANUFACTURER);
        lj1VarC.a("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        long offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
        HashMap map3 = (HashMap) lj1VarC.g;
        if (map3 == null) {
            og.n("Property \"autoMetadata\" has not been set");
            return null;
        }
        map3.put("tz-offset", String.valueOf(offset));
        int i2 = -1;
        if (activeNetworkInfo == null) {
            SparseArray sparseArray = ln1.a;
            type = -1;
        } else {
            type = activeNetworkInfo.getType();
        }
        HashMap map4 = (HashMap) lj1VarC.g;
        if (map4 == null) {
            og.n("Property \"autoMetadata\" has not been set");
            return null;
        }
        map4.put("net-type", String.valueOf(type));
        if (activeNetworkInfo != null) {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                SparseArray sparseArray2 = kn1.a;
                subtype = 100;
            } else if (((kn1) kn1.a.get(subtype)) == null) {
            }
            map = (HashMap) lj1VarC.g;
            if (map != null) {
                og.n("Property \"autoMetadata\" has not been set");
                return null;
            }
            map.put("mobile-subtype", String.valueOf(subtype));
            lj1VarC.a("country", Locale.getDefault().getCountry());
            lj1VarC.a("locale", Locale.getDefault().getLanguage());
            Context context = this.c;
            lj1VarC.a("mcc_mnc", ((TelephonyManager) context.getSystemService("phone")).getSimOperator());
            try {
                i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("TransportRuntime.".concat("CctTransportBackend"), "Unable to find version code for package", e);
            }
            lj1VarC.a("application_build", Integer.toString(i2));
            return lj1VarC.c();
        }
        SparseArray sparseArray3 = kn1.a;
        subtype = 0;
        map = (HashMap) lj1VarC.g;
        if (map != null) {
            og.n("Property \"autoMetadata\" has not been set");
            return null;
        }
        map.put("mobile-subtype", String.valueOf(subtype));
        lj1VarC.a("country", Locale.getDefault().getCountry());
        lj1VarC.a("locale", Locale.getDefault().getLanguage());
        Context context2 = this.c;
        lj1VarC.a("mcc_mnc", ((TelephonyManager) context2.getSystemService("phone")).getSimOperator());
        i2 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
        lj1VarC.a("application_build", Integer.toString(i2));
        return lj1VarC.c();
    }
}
