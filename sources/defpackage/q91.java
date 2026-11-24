package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q91 implements cp1, ir0, eq1, cq1, bz0, zv, as1, qp, j92, qa2 {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;

    public q91(int i) {
        this.a = i;
        switch (i) {
            case 2:
                this.b = new LinkedHashMap();
                this.c = new LinkedHashSet();
                break;
            case 8:
                this.b = new z63(0);
                this.c = new z63(0);
                break;
            case 9:
                this.b = o44.g(Boolean.FALSE);
                break;
            case 11:
                this.b = new gm1();
                this.c = new gm1();
                break;
            case 13:
                break;
            case 15:
                this.b = new pm1(new n71[16]);
                break;
            case 22:
                this.b = new LinkedHashMap();
                this.c = new LinkedHashMap();
                break;
            default:
                this.b = new pl1();
                this.c = new HashMap();
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v5 */
    public static void z(n71 n71Var) {
        if (n71Var.w0 > 0) {
            if (n71Var.p0.d == j71.f && !n71Var.p() && !n71Var.q() && !n71Var.x0 && n71Var.I()) {
                dk1 dk1Var = n71Var.o0.f;
                if ((dk1Var.e & 256) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & 256) != 0) {
                            ?? B = dk1Var;
                            ?? pm1Var = 0;
                            while (B != 0) {
                                if (B instanceof du0) {
                                    du0 du0Var = (du0) B;
                                    du0Var.u(cm4.e(du0Var, 256));
                                } else if ((B.c & 256) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var2 = ((zb0) B).H;
                                    int i = 0;
                                    B = B;
                                    pm1Var = pm1Var;
                                    while (dk1Var2 != null) {
                                        if ((dk1Var2.c & 256) != 0) {
                                            i++;
                                            pm1Var = pm1Var;
                                            if (i == 1) {
                                                B = dk1Var2;
                                            } else {
                                                if (pm1Var == 0) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (B != 0) {
                                                    pm1Var.b(B);
                                                    B = 0;
                                                }
                                                pm1Var.b(dk1Var2);
                                            }
                                        }
                                        dk1Var2 = dk1Var2.i;
                                        B = B;
                                        pm1Var = pm1Var;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                B = cm4.b(pm1Var);
                            }
                        }
                        if ((dk1Var.e & 256) == 0) {
                            break;
                        } else {
                            dk1Var = dk1Var.i;
                        }
                    }
                }
            }
            n71Var.v0 = false;
            pm1 pm1VarZ = n71Var.z();
            Object[] objArr = pm1VarZ.a;
            int i2 = pm1VarZ.c;
            for (int i3 = 0; i3 < i2; i3++) {
                z((n71) objArr[i3]);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    /* JADX WARN: Code duplicated, block: B:20:0x0059  */
    public CctBackendFactory A(String str) {
        Bundle bundle;
        Map map;
        Object obj;
        if (((Map) this.c) == null) {
            Context context = (Context) this.b;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                    if (serviceInfo == null) {
                        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                    }
                    if (bundle == null) {
                        Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                        map = Collections.EMPTY_MAP;
                    } else {
                        HashMap map2 = new HashMap();
                        for (String str2 : bundle.keySet()) {
                            obj = bundle.get(str2);
                            if (!(obj instanceof String) && str2.startsWith("backend:")) {
                                for (String str3 : ((String) obj).split(",", -1)) {
                                    String strTrim = str3.trim();
                                    if (!strTrim.isEmpty()) {
                                        map2.put(strTrim, str2.substring(8));
                                    }
                                }
                            }
                        }
                        map = map2;
                    }
                    this.c = map;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
            }
            bundle = null;
            if (bundle == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                map = Collections.EMPTY_MAP;
            } else {
                HashMap map3 = new HashMap();
                while (r6.hasNext()) {
                    obj = bundle.get(str2);
                    if (!(obj instanceof String)) {
                    }
                }
                map = map3;
            }
            this.c = map;
        }
        String str4 = (String) ((Map) this.c).get(str);
        if (str4 == null) {
            return null;
        }
        try {
            return (CctBackendFactory) Class.forName(str4).asSubclass(CctBackendFactory.class).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            Log.w("BackendRegistry", "Class " + str4 + " is not found.", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e2);
            return null;
        } catch (InstantiationException e3) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e4);
            return null;
        } catch (InvocationTargetException e5) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e5);
            return null;
        }
    }

    public la2 B() {
        la2 la2Var;
        ma2 ma2Var = (ma2) this.b;
        synchronized (ma2Var.c) {
            Iterator it = ma2Var.d.entrySet().iterator();
            do {
                la2Var = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                la2 la2Var2 = (la2) entry.getValue();
                if (g31.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                    la2Var = la2Var2;
                }
            } while (la2Var == null);
        }
        return la2Var;
    }

    public synchronized void C() {
        kf kfVar = (kf) this.c;
        if (kfVar == null) {
            return;
        }
        this.c = null;
        try {
            AudioTrack audioTrack = (AudioTrack) kfVar.b;
            audioTrack.pause();
            audioTrack.flush();
            kfVar.z();
        } catch (Throwable th) {
            kfVar.z();
            throw th;
        }
    }

    public void D(Bundle bundle) {
        ma2 ma2Var = (ma2) this.b;
        na2 na2Var = ma2Var.a;
        if (!ma2Var.e) {
            ma2Var.a();
        }
        if (na2Var.f().d.compareTo(eb1.e) >= 0) {
            dk0.u(na2Var.f().d, "performRestore cannot be called when owner is ");
            return;
        }
        if (ma2Var.g) {
            og.n("SavedStateRegistry was already restored.");
            return;
        }
        Bundle bundleA = null;
        if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
            bundleA = pz3.a("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
        }
        ma2Var.f = bundleA;
        ma2Var.g = true;
    }

    public void E(Bundle bundle) {
        ma2 ma2Var = (ma2) this.b;
        Bundle bundleA = bg4.a((wt1[]) Arrays.copyOf(new wt1[0], 0));
        Bundle bundle2 = ma2Var.f;
        if (bundle2 != null) {
            bundleA.putAll(bundle2);
        }
        synchronized (ma2Var.c) {
            for (Map.Entry entry : ma2Var.d.entrySet()) {
                String str = (String) entry.getKey();
                Bundle bundleA2 = ((la2) entry.getValue()).a();
                str.getClass();
                bundleA2.getClass();
                bundleA.putBundle(str, bundleA2);
            }
        }
        if (bundleA.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundleA);
    }

    public void F(String str, la2 la2Var) {
        la2Var.getClass();
        ma2 ma2Var = (ma2) this.b;
        synchronized (ma2Var.c) {
            if (ma2Var.d.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            ma2Var.d.put(str, la2Var);
        }
    }

    public void G() {
        if (!((ma2) this.b).h) {
            og.n("Can not perform this action after onSaveInstanceState");
            return;
        }
        j42 j42Var = (j42) this.c;
        if (j42Var == null) {
            j42Var = new j42(this);
        }
        this.c = j42Var;
        try {
            ta1.class.getDeclaredConstructor(null);
            j42 j42Var2 = (j42) this.c;
            if (j42Var2 != null) {
                j42Var2.a.add(ta1.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + ta1.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    @Override // defpackage.bz0
    public int a() {
        return ((s9) this.b).a();
    }

    @Override // defpackage.j92
    public Object apply(Object obj) {
        l92 l92Var = (l92) this.b;
        pj pjVar = (pj) this.c;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        qi0 qi0Var = l92.f;
        l92Var.getClass();
        ArrayList arrayList = new ArrayList();
        Long lE = l92.e(sQLiteDatabase, pjVar);
        if (lE != null) {
            l92.r(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lE.toString()}, null, null, null, String.valueOf(l92Var.e.b)), new kf(l92Var, arrayList, pjVar, 23));
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(((xi) arrayList.get(i)).a);
            if (i < arrayList.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        l92.r(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new q52(map));
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            xi xiVar = (xi) listIterator.next();
            long j = xiVar.a;
            if (map.containsKey(Long.valueOf(j))) {
                lj1 lj1VarC = xiVar.c.c();
                for (k92 k92Var : (Set) map.get(Long.valueOf(j))) {
                    lj1VarC.a(k92Var.a, k92Var.b);
                }
                listIterator.set(new xi(j, xiVar.b, lj1VarC.c()));
            }
        }
        return arrayList;
    }

    @Override // defpackage.bz0
    public int b() {
        return ((s9) this.b).b();
    }

    @Override // defpackage.ir0
    public void c(Object obj) {
        switch (this.a) {
            case 5:
                ((Surface) this.b).release();
                ((SurfaceTexture) this.c).release();
                break;
            case 20:
                ((tp) this.b).a((ov) this.c);
                break;
            case 28:
                xt2 xt2Var = (xt2) obj;
                xt2Var.getClass();
                ((fb0) ((kf) this.c).b).b(xt2Var);
                break;
            default:
                hh1.e(null, ((tp) this.b).a(null));
                break;
        }
    }

    @Override // defpackage.zv
    public void cancel() {
        if (((hh) this.c).compareAndSet(1, 1)) {
            return;
        }
        ((ek) this.b).a();
    }

    @Override // defpackage.bz0
    public void close() {
        ((s9) this.b).close();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00be A[PHI: r11 r13 r15
      0x00be: PHI (r11v5 java.lang.Integer) = (r11v4 java.lang.Integer), (r11v9 java.lang.Integer) binds: [B:47:0x00e9, B:29:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x00be: PHI (r13v8 java.lang.Integer) = (r13v6 java.lang.Integer), (r13v4 java.lang.Integer) binds: [B:47:0x00e9, B:29:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x00be: PHI (r15v17 boolean) = (r15v11 boolean), (r15v20 boolean) binds: [B:47:0x00e9, B:29:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:71:0x013c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // defpackage.qp
    public void d(m32 m32Var, z62 z62Var) {
        x32 x32Var;
        String strJ;
        ux uxVar = z62Var.v;
        try {
            ((x32) this.b).a(z62Var, uxVar);
            p32 p32VarB = uxVar.b();
            ew0 ew0Var = z62Var.i;
            int size = ew0Var.size();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            Integer numL = null;
            Integer numL2 = null;
            while (i2 < size) {
                if (js2.f(ew0Var.b(i2), "Sec-WebSocket-Extensions")) {
                    String strF = ew0Var.f(i2);
                    int i3 = i;
                    while (i3 < strF.length()) {
                        ew0 ew0Var2 = ew0Var;
                        int iH = z53.h(strF, ',', i3, i, 4);
                        int iF = z53.f(strF, ';', i3, iH);
                        int iN = z53.n(i3, iF, strF);
                        String strSubstring = strF.substring(iN, z53.o(iN, iF, strF));
                        i3 = iF + 1;
                        if (strSubstring.equalsIgnoreCase("permessage-deflate")) {
                            if (z) {
                                z4 = true;
                            }
                            while (i3 < iH) {
                                int iF2 = z53.f(strF, ';', i3, iH);
                                int iF3 = z53.f(strF, '=', i3, iF2);
                                int iN2 = z53.n(i3, iF3, strF);
                                String strSubstring2 = strF.substring(iN2, z53.o(iN2, iF3, strF));
                                if (iF3 < iF2) {
                                    int iN3 = z53.n(iF3 + 1, iF2, strF);
                                    strJ = cs2.J(strF.substring(iN3, z53.o(iN3, iF2, strF)), "\"", "\"");
                                } else {
                                    strJ = null;
                                }
                                i3 = iF2 + 1;
                                int i4 = iH;
                                if (strSubstring2.equalsIgnoreCase("client_max_window_bits")) {
                                    if (numL != null) {
                                        z4 = true;
                                    }
                                    numL = strJ != null ? js2.l(10, strJ) : null;
                                    if (numL == null) {
                                        z4 = true;
                                    }
                                } else if (strSubstring2.equalsIgnoreCase("client_no_context_takeover")) {
                                    if (z2) {
                                        z4 = true;
                                    }
                                    if (strJ != null) {
                                        z4 = true;
                                    }
                                    z2 = true;
                                } else {
                                    if (strSubstring2.equalsIgnoreCase("server_max_window_bits")) {
                                        if (numL2 != null) {
                                            z4 = true;
                                        }
                                        numL2 = strJ != null ? js2.l(10, strJ) : null;
                                        if (numL2 == null) {
                                        }
                                    } else if (strSubstring2.equalsIgnoreCase("server_no_context_takeover")) {
                                        if (z3) {
                                            z4 = true;
                                        }
                                        if (strJ != null) {
                                            z4 = true;
                                        }
                                        z3 = true;
                                    }
                                    z4 = true;
                                }
                                iH = i4;
                            }
                            z = true;
                        } else {
                            z4 = true;
                        }
                        ew0Var = ew0Var2;
                        i = 0;
                    }
                }
                i2++;
                ew0Var = ew0Var;
                i = 0;
            }
            ((x32) this.b).d = new v93(z, numL, z2, numL2, z3, z4);
            if (z4 || numL != null) {
                x32Var = (x32) this.b;
                synchronized (x32Var) {
                    x32Var.o.clear();
                    x32Var.b(1010, "unexpected Sec-WebSocket-Extensions in response header");
                }
            } else if (numL2 != null) {
                h21 h21Var = new h21(8, 15, 1);
                int iIntValue = numL2.intValue();
                if (8 > iIntValue || iIntValue > h21Var.b) {
                    x32Var = (x32) this.b;
                    synchronized (x32Var) {
                        x32Var.o.clear();
                        x32Var.b(1010, "unexpected Sec-WebSocket-Extensions in response header");
                    }
                }
            }
            try {
                ((x32) this.b).d(z53.g + " WebSocket " + ((ey0) ((lj1) this.c).b).g(), p32VarB);
                x32 x32Var2 = (x32) this.b;
                x32Var2.a.B(x32Var2, z62Var);
                ((x32) this.b).e();
            } catch (Exception e) {
                ((x32) this.b).c(e, null);
            }
        } catch (IOException e2) {
            ((x32) this.b).c(e2, z62Var);
            z53.d(z62Var);
            if (uxVar != null) {
                uxVar.a(true, true, null);
            }
        }
    }

    @Override // defpackage.bz0
    public zy0 e() {
        return y(((s9) this.b).e());
    }

    @Override // defpackage.cp1
    public void f(Executor executor, bp1 bp1Var) {
        synchronized (((HashMap) this.c)) {
            kd1 kd1Var = (kd1) ((HashMap) this.c).get(bp1Var);
            if (kd1Var != null) {
                kd1Var.a.set(false);
            }
            kd1 kd1Var2 = new kd1(executor, (k02) bp1Var);
            ((HashMap) this.c).put(bp1Var, kd1Var2);
            xg4.c().execute(new dc(this, kd1Var, kd1Var2, 9));
        }
    }

    @Override // defpackage.as1
    public List g(Integer num) {
        List listG = ((as1) this.b).g(null);
        rl2 rl2Var = (rl2) this.c;
        int i = rl2Var.v;
        return i < 0 ? listG : mz.G(cj4.a(rl2Var, num, i, Integer.valueOf(rl2Var.E(i, rl2Var.b))), listG);
    }

    @Override // defpackage.bz0
    public Surface getSurface() {
        return ((s9) this.b).getSurface();
    }

    @Override // defpackage.bz0
    public int h() {
        return ((s9) this.b).h();
    }

    @Override // defpackage.ir0
    public void i(Throwable th) {
        switch (this.a) {
            case 5:
                throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
            case 20:
                ((tp) this.b).b(th);
                return;
            case 28:
                int i = ((st2) this.b).f;
                if (i == 2 && (th instanceof CancellationException)) {
                    xq4.c(3, "SurfaceProcessorNode");
                    return;
                }
                xq4.e("SurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + cb4.f(i), th);
                return;
            default:
                if (th instanceof du2) {
                    hh1.e(null, ((wp) this.c).cancel(false));
                    return;
                } else {
                    hh1.e(null, ((tp) this.b).a(null));
                    return;
                }
        }
    }

    @Override // defpackage.bz0
    public void j() {
        ((s9) this.b).j();
    }

    @Override // defpackage.qa2
    public Object k(Object obj) {
        return ((hq0) this.c).j(obj);
    }

    @Override // defpackage.bz0
    public void l(az0 az0Var, Executor executor) {
        ((s9) this.b).l(new qq(4, this, az0Var), executor);
    }

    @Override // defpackage.qp
    public void m(m32 m32Var, IOException iOException) {
        ((x32) this.b).c(iOException, null);
    }

    @Override // defpackage.bz0
    public int n() {
        return ((s9) this.b).n();
    }

    @Override // defpackage.cp1
    public void o(bp1 bp1Var) {
        synchronized (((HashMap) this.c)) {
            try {
                kd1 kd1Var = (kd1) ((HashMap) this.c).remove(bp1Var);
                if (kd1Var != null) {
                    kd1Var.a.set(false);
                    xg4.c().execute(new o8(20, this, kd1Var));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bz0
    public zy0 p() {
        return y(((s9) this.b).p());
    }

    @Override // defpackage.eq1
    public void q(Exception exc) {
        if (((AtomicBoolean) this.b).compareAndSet(false, true)) {
            ((yv) this.c).h(null);
        }
    }

    @Override // defpackage.cq1
    public void r(et4 et4Var) {
        et4Var.getClass();
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.b;
        nl4 nl4Var = (nl4) this.c;
        if (atomicBoolean.compareAndSet(false, true)) {
            nl4Var.close();
        }
    }

    @Override // defpackage.qa2
    public Object s(x92 x92Var, Object obj) {
        return ((vq0) this.b).e(x92Var, obj);
    }

    public kf t() {
        kf kfVar = (kf) this.c;
        if (kfVar != null) {
            return kfVar;
        }
        kf kfVar2 = (kf) ((zb) this.b).a();
        this.c = kfVar2;
        return kfVar2;
    }

    public String toString() {
        switch (this.a) {
            case 14:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.c.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void u(Object obj, String str) {
        ((ArrayList) this.b).add(cq.k(str, "=", String.valueOf(obj)));
    }

    public Size[] v(Size[] sizeArr, int i) {
        List arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList(Arrays.asList(sizeArr));
        if (((ExtraSupportedOutputSizeQuirk) this.b) != null) {
            Size[] sizeArr2 = (i == 34 && "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL)) ? new Size[]{new Size(1440, 1080), new Size(960, 720)} : new Size[0];
            if (sizeArr2.length > 0) {
                arrayList3.addAll(Arrays.asList(sizeArr2));
            }
        }
        yh0 yh0Var = (yh0) this.c;
        yh0Var.getClass();
        if (((ExcludedSupportedSizesQuirk) wc0.a.d(ExcludedSupportedSizesQuirk.class)) == null) {
            arrayList = new ArrayList();
        } else {
            String str = yh0Var.a;
            String str2 = Build.BRAND;
            if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList2.add(new Size(4160, 3120));
                    arrayList2.add(new Size(4000, 3000));
                }
            } else if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList2.add(new Size(4160, 3120));
                    arrayList2.add(new Size(4000, 3000));
                }
            } else if ("HUAWEI".equalsIgnoreCase(str2) && "HWANE".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && (i == 34 || i == 35)) {
                    arrayList2.add(new Size(720, 720));
                    arrayList2.add(new Size(400, 400));
                }
            } else if (ExcludedSupportedSizesQuirk.c()) {
                arrayList2 = new ArrayList();
                if (str.equals("0")) {
                    if (i == 34) {
                        arrayList2.add(new Size(4128, 3096));
                        arrayList2.add(new Size(4128, 2322));
                        arrayList2.add(new Size(3088, 3088));
                        arrayList2.add(new Size(3264, 2448));
                        arrayList2.add(new Size(3264, 1836));
                        arrayList2.add(new Size(2048, 1536));
                        arrayList2.add(new Size(2048, 1152));
                        arrayList2.add(new Size(1920, 1080));
                    } else if (i == 35) {
                        arrayList2.add(new Size(4128, 2322));
                        arrayList2.add(new Size(3088, 3088));
                        arrayList2.add(new Size(3264, 2448));
                        arrayList2.add(new Size(3264, 1836));
                        arrayList2.add(new Size(2048, 1536));
                        arrayList2.add(new Size(2048, 1152));
                        arrayList2.add(new Size(1920, 1080));
                    }
                } else if (str.equals("1") && (i == 34 || i == 35)) {
                    arrayList2.add(new Size(3264, 2448));
                    arrayList2.add(new Size(3264, 1836));
                    arrayList2.add(new Size(2448, 2448));
                    arrayList2.add(new Size(1920, 1920));
                    arrayList2.add(new Size(2048, 1536));
                    arrayList2.add(new Size(2048, 1152));
                    arrayList2.add(new Size(1920, 1080));
                }
            } else if (ExcludedSupportedSizesQuirk.b()) {
                arrayList2 = new ArrayList();
                if (str.equals("0")) {
                    if (i == 34) {
                        arrayList2.add(new Size(4128, 3096));
                        arrayList2.add(new Size(4128, 2322));
                        arrayList2.add(new Size(3088, 3088));
                        arrayList2.add(new Size(3264, 2448));
                        arrayList2.add(new Size(3264, 1836));
                        arrayList2.add(new Size(2048, 1536));
                        arrayList2.add(new Size(2048, 1152));
                        arrayList2.add(new Size(1920, 1080));
                    } else if (i == 35) {
                        arrayList2.add(new Size(2048, 1536));
                        arrayList2.add(new Size(2048, 1152));
                        arrayList2.add(new Size(1920, 1080));
                    }
                } else if (str.equals("1") && (i == 34 || i == 35)) {
                    arrayList2.add(new Size(2576, 1932));
                    arrayList2.add(new Size(2560, 1440));
                    arrayList2.add(new Size(1920, 1920));
                    arrayList2.add(new Size(2048, 1536));
                    arrayList2.add(new Size(2048, 1152));
                    arrayList2.add(new Size(1920, 1080));
                }
            } else if ("REDMI".equalsIgnoreCase(str2) && "joyeuse".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList2.add(new Size(9280, 6944));
                }
            } else {
                xq4.d("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
                arrayList = Collections.EMPTY_LIST;
            }
            arrayList = arrayList2;
        }
        if (!arrayList.isEmpty()) {
            arrayList3.removeAll(arrayList);
        }
        if (arrayList3.isEmpty()) {
            xq4.d("OutputSizesCorrector", "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) arrayList3.toArray(new Size[0]);
    }

    public synchronized boolean w(long j) {
        return ((LinkedHashMap) this.b).containsKey(Long.valueOf(j)) && !((LinkedHashSet) this.c).contains(Long.valueOf(j));
    }

    public Bundle x(String str) {
        ma2 ma2Var = (ma2) this.b;
        if (!ma2Var.g) {
            og.n("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
            return null;
        }
        Bundle bundle = ma2Var.f;
        if (bundle == null) {
            return null;
        }
        Bundle bundleA = bundle.containsKey(str) ? pz3.a(str, bundle) : null;
        bundle.remove(str);
        if (bundle.isEmpty()) {
            ma2Var.f = null;
        }
        return bundleA;
    }

    public xh2 y(zy0 zy0Var) {
        iv2 iv2Var;
        if (zy0Var == null) {
            return null;
        }
        if (((g12) this.c) == null) {
            iv2Var = iv2.b;
        } else {
            g12 g12Var = (g12) this.c;
            Pair pair = new Pair(g12Var.h, g12Var.i.get(0));
            iv2 iv2Var2 = iv2.b;
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put((String) pair.first, pair.second);
            iv2Var = new iv2(arrayMap);
        }
        this.c = null;
        return new xh2(zy0Var, new Size(zy0Var.b(), zy0Var.a()), new ms(new kb0(null, iv2Var, zy0Var.m().d())));
    }

    public /* synthetic */ q91(Object obj, boolean z, int i) {
        this.a = i;
        this.b = obj;
    }

    public q91(ma2 ma2Var) {
        this.a = 25;
        this.b = ma2Var;
        this.c = new q91((Object) ma2Var, false, 24);
    }

    public q91(ek ekVar) {
        this.a = 16;
        this.b = ekVar;
        this.c = new hh(0);
    }

    public q91(String str) {
        this.a = 18;
        this.b = (ExtraSupportedOutputSizeQuirk) wc0.a.d(ExtraSupportedOutputSizeQuirk.class);
        this.c = new yh0(str);
    }

    public /* synthetic */ q91(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public q91(Context context) {
        this.a = 4;
        this.c = null;
        this.b = context;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q91(int i, Object obj) {
        this(9);
        this.a = i;
        switch (i) {
            case 14:
                this.c = obj;
                this.b = new ArrayList();
                break;
            default:
                this.c = o44.g(obj);
                o44.g(obj);
                break;
        }
    }

    public q91(kf kfVar, st2 st2Var) {
        this.a = 28;
        this.c = kfVar;
        this.b = st2Var;
    }
}
