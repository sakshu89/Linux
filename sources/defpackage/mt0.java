package defpackage;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mt0 {
    public static final Set b0 = wh2.c(new w3("device.wifi.enable"), new w3("device.wifi.disable"), new w3("device.wifi.toggle"), new w3("device.bluetooth.enable"), new w3("device.bluetooth.disable"), new w3("device.bluetooth.toggle"));
    public static final Set c0 = wh2.c(2381, 2509, 2637, 2765, 2893, 3021, 3149, 3277, 3405, 3530);
    public static final Set d0 = wh2.c("sonic", "offline", "shutdown", "shut", "stop", "pause", "listening", "speaking", "talking", "assistant", "quiet", "conversation");
    public final q91 A;
    public final zd1 B;
    public final LinkedHashMap C;
    public final LinkedHashMap D;
    public volatile ae1 E;
    public volatile boolean F;
    public volatile long G;
    public volatile boolean H;
    public volatile ym I;
    public volatile boolean J;
    public long K;
    public long L;
    public final AtomicLong M;
    public volatile Long N;
    public volatile boolean O;
    public final AtomicLong P;
    public final ArrayList Q;
    public final ConcurrentHashMap R;
    public volatile Long S;
    public volatile long T;
    public final Object U;
    public volatile wd1 V;
    public un W;
    public final py0 X;
    public wt1 Y;
    public final LinkedHashMap Z;
    public final Context a;
    public final LinkedHashSet a0;
    public final h61 b;
    public final f0 c;
    public final j5 d;
    public final in2 e;
    public final co2 f;
    public final xv1 g;
    public final ps0 h;
    public final he1 i;
    public final bd1 j;
    public final jr2 k;
    public final g32 l;
    public final hk2 m;
    public final e32 n;
    public final an1 o;
    public final an1 p;
    public final rp1 q;
    public volatile x32 r;
    public volatile AudioTrack s;
    public volatile AudioRecord t;
    public volatile x00 u;
    public volatile boolean v;
    public volatile boolean w;
    public volatile boolean x;
    public volatile hd1 y;
    public volatile vs0 z;

    public mt0(Context context, h61 h61Var, f0 f0Var, j5 j5Var, in2 in2Var, co2 co2Var, xv1 xv1Var, ps0 ps0Var, he1 he1Var, bd1 bd1Var, bh bhVar) {
        h61Var.getClass();
        f0Var.getClass();
        j5Var.getClass();
        in2Var.getClass();
        co2Var.getClass();
        xv1Var.getClass();
        ps0Var.getClass();
        he1Var.getClass();
        bd1Var.getClass();
        bhVar.getClass();
        this.a = context;
        this.b = h61Var;
        this.c = f0Var;
        this.d = j5Var;
        this.e = in2Var;
        this.f = co2Var;
        this.g = xv1Var;
        this.h = ps0Var;
        this.i = he1Var;
        this.j = bd1Var;
        jr2 jr2VarA = o54.a(new ee1(null, 63));
        this.k = jr2VarA;
        this.l = new g32(jr2VarA);
        hk2 hk2VarA = s44.a(64, 5, null);
        this.m = hk2VarA;
        this.n = new e32(hk2VarA);
        this.o = new an1();
        this.p = new an1();
        qp1 qp1Var = new qp1();
        qp1Var.h = false;
        qp1Var.i = false;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        timeUnit.getClass();
        qp1Var.w = z53.b("timeout", 10L, timeUnit);
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        timeUnit2.getClass();
        qp1Var.x = z53.b("timeout", 0L, timeUnit2);
        qp1Var.z = z53.b("interval", 20L, timeUnit);
        this.q = new rp1(qp1Var);
        this.A = new q91(2);
        this.B = new zd1();
        this.C = new LinkedHashMap();
        this.D = new LinkedHashMap();
        this.M = new AtomicLong();
        this.P = new AtomicLong();
        this.Q = new ArrayList();
        this.R = new ConcurrentHashMap();
        this.U = new Object();
        this.X = new py0(5);
        this.Z = new LinkedHashMap();
        this.a0 = new LinkedHashSet();
    }

    public static final /* synthetic */ ps0 a(mt0 mt0Var) {
        return mt0Var.h;
    }

    public static final boolean b(mt0 mt0Var) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) mt0Var.a.getSystemService(ConnectivityManager.class);
        return (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12) || !networkCapabilities.hasCapability(16)) ? false : true;
    }

    public static final boolean c(mt0 mt0Var, String str) {
        mt0Var.getClass();
        f5 f5VarC = new rc0().c(new mz2().a(str), i60.i);
        Set set = b0;
        String str2 = f5VarC != null ? f5VarC.a : null;
        return mz.s(str2 != null ? new w3(str2) : null, set);
    }

    public static final /* synthetic */ void d(mt0 mt0Var, x00 x00Var) {
        mt0Var.u = x00Var;
    }

    public static void f(mt0 mt0Var, String str) {
        Object objPutIfAbsent;
        ConcurrentHashMap concurrentHashMap = mt0Var.R;
        Object atomicLong = concurrentHashMap.get(str);
        if (atomicLong == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str, (atomicLong = new AtomicLong()))) != null) {
            atomicLong = objPutIfAbsent;
        }
        ((AtomicLong) atomicLong).addAndGet(1L);
    }

    public static JSONObject k(z4 z4Var) throws JSONException {
        String str;
        l5 l5Var = z4Var.a;
        rv1 rv1Var = z4Var.b;
        boolean z = l5Var.h instanceof d73;
        JSONObject jSONObject = new JSONObject();
        l5 l5Var2 = z4Var.a;
        String str2 = l5Var2.c;
        e33 e33Var = l5Var2.b;
        JSONObject jSONObjectPut = jSONObject.put("status", e33Var == e33.a ? "SUCCESS" : e33Var.name());
        if (z) {
            str = "VERIFIED_STATE_CHANGE";
        } else if (rv1Var != null) {
            str = "WAITING_FOR_USER";
        } else {
            str = e33Var == e33.b ? "UNVERIFIED_RESULT" : "NO_VERIFIED_ACTION";
        }
        JSONObject jSONObjectPut2 = jSONObjectPut.put("reason_code", str).put("verified", z);
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str2.toLowerCase(locale);
        lowerCase.getClass();
        JSONObject jSONObjectPut3 = jSONObjectPut2.put("already_satisfied", cs2.n(lowerCase, "already", false)).put("retryable", false).put("requires_user_response", rv1Var != null).put("spoken", str2);
        jSONObjectPut3.getClass();
        return jSONObjectPut3;
    }

    public final Object e(g5 g5Var, String str, long j, hq0 hq0Var, hq0 hq0Var2, lt0 lt0Var) {
        ((ConcurrentHashMap) this.X.b).clear();
        this.Y = null;
        this.Z.clear();
        this.a0.clear();
        q91 q91Var = this.A;
        synchronized (q91Var) {
            ((LinkedHashMap) q91Var.b).clear();
            ((LinkedHashSet) q91Var.c).clear();
        }
        this.C.clear();
        this.D.clear();
        this.N = null;
        this.O = false;
        this.E = null;
        this.F = false;
        this.G = 0L;
        this.H = false;
        this.K++;
        zd1 zd1Var = this.B;
        synchronized (zd1Var) {
            zd1Var.b.clear();
            zd1Var.c.clear();
        }
        this.S = null;
        jr2 jr2Var = this.k;
        ee1 ee1Var = new ee1("Connecting", 47);
        jr2Var.getClass();
        jr2Var.j(null, ee1Var);
        et0 et0Var = new et0(this, str, g5Var, j, hq0Var2, hq0Var, null);
        et2 et2Var = new et2(lt0Var, lt0Var.f());
        return ee4.b(et2Var, true, et2Var, et0Var);
    }

    public final void g(boolean z) {
        Long lValueOf = Long.valueOf(this.G);
        ae1 ae1Var = this.E;
        Set setC = wh2.c(lValueOf, Long.valueOf(ae1Var != null ? ae1Var.a : 0L));
        this.E = null;
        int i = 0;
        this.F = false;
        this.G = 0L;
        ArrayList arrayList = new ArrayList();
        for (Object obj : setC) {
            if (((Number) obj).longValue() != 0) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            long jLongValue = ((Number) obj2).longValue();
            zd1 zd1Var = this.B;
            if (!z) {
                synchronized (zd1Var) {
                    if (zd1Var.a.containsKey(Long.valueOf(jLongValue))) {
                        zd1Var.b.remove(Long.valueOf(jLongValue));
                        zd1Var.c.remove(Long.valueOf(jLongValue));
                        f(this, "interruptedRepliesRetained");
                    }
                }
            } else if (zd1Var.g(jLongValue)) {
                f(this, "repliesDismissed");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02af  */
    /* JADX WARN: Code duplicated, block: B:103:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:105:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:107:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:114:0x0330  */
    /* JADX WARN: Code duplicated, block: B:116:0x0335  */
    /* JADX WARN: Code duplicated, block: B:118:0x033d  */
    /* JADX WARN: Code duplicated, block: B:119:0x0344  */
    /* JADX WARN: Code duplicated, block: B:11:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x034a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0351  */
    /* JADX WARN: Code duplicated, block: B:125:0x0374  */
    /* JADX WARN: Code duplicated, block: B:129:0x0385  */
    /* JADX WARN: Code duplicated, block: B:12:0x004f  */
    /* JADX WARN: Code duplicated, block: B:13:0x0068  */
    /* JADX WARN: Code duplicated, block: B:141:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:143:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:144:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:146:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:147:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:149:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:156:0x044a  */
    /* JADX WARN: Code duplicated, block: B:157:0x0453  */
    /* JADX WARN: Code duplicated, block: B:159:0x045d  */
    /* JADX WARN: Code duplicated, block: B:15:0x006e  */
    /* JADX WARN: Code duplicated, block: B:161:0x0478  */
    /* JADX WARN: Code duplicated, block: B:163:0x0485  */
    /* JADX WARN: Code duplicated, block: B:166:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:168:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:170:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:172:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:174:0x04db  */
    /* JADX WARN: Code duplicated, block: B:176:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:178:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:179:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:17:0x0080  */
    /* JADX WARN: Code duplicated, block: B:181:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:183:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:185:0x0502  */
    /* JADX WARN: Code duplicated, block: B:186:0x0507  */
    /* JADX WARN: Code duplicated, block: B:187:0x0509 A[PHI: r2
      0x0509: PHI (r2v54 java.lang.Integer) = (r2v53 java.lang.Integer), (r2v76 java.lang.Integer) binds: [B:173:0x04d9, B:185:0x0502] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:190:0x0512  */
    /* JADX WARN: Code duplicated, block: B:192:0x051a  */
    /* JADX WARN: Code duplicated, block: B:193:0x051f  */
    /* JADX WARN: Code duplicated, block: B:195:0x0522  */
    /* JADX WARN: Code duplicated, block: B:197:0x052c  */
    /* JADX WARN: Code duplicated, block: B:198:0x0531  */
    /* JADX WARN: Code duplicated, block: B:19:0x008f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:201:0x0538  */
    /* JADX WARN: Code duplicated, block: B:203:0x053f  */
    /* JADX WARN: Code duplicated, block: B:206:0x0554  */
    /* JADX WARN: Code duplicated, block: B:208:0x0567  */
    /* JADX WARN: Code duplicated, block: B:210:0x056f  */
    /* JADX WARN: Code duplicated, block: B:212:0x0576  */
    /* JADX WARN: Code duplicated, block: B:215:0x0581  */
    /* JADX WARN: Code duplicated, block: B:218:0x0598  */
    /* JADX WARN: Code duplicated, block: B:221:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:224:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:226:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:227:0x05d6  */
    /* JADX WARN: Code duplicated, block: B:229:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:231:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:234:0x05f4  */
    /* JADX WARN: Code duplicated, block: B:236:0x05f7  */
    /* JADX WARN: Code duplicated, block: B:237:0x0600  */
    /* JADX WARN: Code duplicated, block: B:239:0x060b  */
    /* JADX WARN: Code duplicated, block: B:243:0x066d  */
    /* JADX WARN: Code duplicated, block: B:245:0x0672  */
    /* JADX WARN: Code duplicated, block: B:246:0x067b  */
    /* JADX WARN: Code duplicated, block: B:249:0x068e  */
    /* JADX WARN: Code duplicated, block: B:254:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:262:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:264:0x06f2  */
    /* JADX WARN: Code duplicated, block: B:265:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:267:0x06fd  */
    /* JADX WARN: Code duplicated, block: B:268:0x0700  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:270:0x0708  */
    /* JADX WARN: Code duplicated, block: B:271:0x070b  */
    /* JADX WARN: Code duplicated, block: B:273:0x0713  */
    /* JADX WARN: Code duplicated, block: B:274:0x0716  */
    /* JADX WARN: Code duplicated, block: B:276:0x071e  */
    /* JADX WARN: Code duplicated, block: B:277:0x0721  */
    /* JADX WARN: Code duplicated, block: B:279:0x0729  */
    /* JADX WARN: Code duplicated, block: B:281:0x072f  */
    /* JADX WARN: Code duplicated, block: B:284:0x0742  */
    /* JADX WARN: Code duplicated, block: B:286:0x0747  */
    /* JADX WARN: Code duplicated, block: B:289:0x0785 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:290:0x0787  */
    /* JADX WARN: Code duplicated, block: B:291:0x078c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:292:0x078e  */
    /* JADX WARN: Code duplicated, block: B:293:0x0791  */
    /* JADX WARN: Code duplicated, block: B:297:0x07a1  */
    /* JADX WARN: Code duplicated, block: B:299:0x07a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:300:0x07a9  */
    /* JADX WARN: Code duplicated, block: B:301:0x07ac  */
    /* JADX WARN: Code duplicated, block: B:305:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:307:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:309:0x07d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:310:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:313:0x07e4  */
    /* JADX WARN: Code duplicated, block: B:317:0x07f4  */
    /* JADX WARN: Code duplicated, block: B:319:0x07fc  */
    /* JADX WARN: Code duplicated, block: B:323:0x0809  */
    /* JADX WARN: Code duplicated, block: B:325:0x0820  */
    /* JADX WARN: Code duplicated, block: B:326:0x082c  */
    /* JADX WARN: Code duplicated, block: B:328:0x082f  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:331:0x0842  */
    /* JADX WARN: Code duplicated, block: B:333:0x0862  */
    /* JADX WARN: Code duplicated, block: B:336:0x087c  */
    /* JADX WARN: Code duplicated, block: B:338:0x0882  */
    /* JADX WARN: Code duplicated, block: B:340:0x0888  */
    /* JADX WARN: Code duplicated, block: B:341:0x089d  */
    /* JADX WARN: Code duplicated, block: B:345:0x08ce A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:346:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:349:0x08d7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:351:0x08e8  */
    /* JADX WARN: Code duplicated, block: B:353:0x08f5  */
    /* JADX WARN: Code duplicated, block: B:357:0x08fe  */
    /* JADX WARN: Code duplicated, block: B:359:0x090c  */
    /* JADX WARN: Code duplicated, block: B:362:0x0917 A[LOOP:0: B:360:0x090f->B:362:0x0917, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:367:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:373:0x039d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:379:0x037f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:384:0x06a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:386:0x0688 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:388:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:389:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:43:0x0109  */
    /* JADX WARN: Code duplicated, block: B:44:0x010d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0114  */
    /* JADX WARN: Code duplicated, block: B:50:0x0125 A[LOOP:4: B:45:0x010e->B:50:0x0125, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x0179  */
    /* JADX WARN: Code duplicated, block: B:63:0x018f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0197  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:72:0x01be  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:76:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:81:0x01fe A[LOOP:1: B:79:0x01f8->B:81:0x01fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:84:0x0218  */
    /* JADX WARN: Code duplicated, block: B:90:0x0233  */
    /* JADX WARN: Code duplicated, block: B:91:0x0248  */
    /* JADX WARN: Code duplicated, block: B:93:0x0292  */
    /* JADX WARN: Code duplicated, block: B:94:0x0294 A[PHI: r7
      0x0294: PHI (r7v41 py0) = (r7v32 py0), (r7v42 py0) binds: [B:295:0x079d, B:93:0x0292] A[DONT_GENERATE, DONT_INLINE]] */
    public final Object h(JSONObject jSONObject, String str, long j, hq0 hq0Var, f5 f5Var, boolean z, y50 y50Var) throws JSONException {
        LinkedHashMap linkedHashMap;
        ft0 ft0Var;
        Object obj;
        t70 t70Var;
        int i;
        String strOptString;
        q91 q91Var;
        JSONObject jSONObject2;
        JSONObject jSONObjectOptJSONObject;
        String strOptString2;
        int i2;
        boolean z2;
        String string;
        boolean zA;
        wt1 wt1Var;
        LinkedHashMap linkedHashMap2;
        ul0 ul0Var;
        boolean zM;
        mt0 mt0Var;
        rs0 rs0Var;
        py0 py0Var;
        long j2;
        LinkedHashMap linkedHashMap3;
        l90 l90VarL;
        ht0 ht0Var;
        t42 t42Var;
        ft0 ft0Var2;
        boolean z3;
        String str2;
        t42 t42Var2;
        String strOptString3;
        xv1 xv1Var;
        b63 b63VarA;
        f5 f5VarA;
        f5 f5VarB;
        boolean zB;
        i60 i60Var;
        f5 f5VarC;
        String str3;
        f5 f5Var2;
        f5 f5VarC2;
        f5 f5VarW;
        f5 f5VarA2;
        f5 f5VarC3;
        LinkedHashMap linkedHashMap4;
        f5 f5VarC4;
        f5 f5VarC5;
        f5 f5VarC6;
        String str4;
        LinkedHashMap linkedHashMap5;
        LinkedHashMap linkedHashMap6;
        x42 x42Var;
        Object obj2;
        String str5;
        fh1 fh1VarB;
        String str6;
        boolean zA2;
        boolean zFind;
        f5 f5Var3;
        String str7;
        fh1 fh1VarA;
        String str8;
        String str9;
        f5 f5VarA3;
        f5 f5VarA4;
        String str10;
        Integer numC;
        Integer numC2;
        String strB;
        LinkedHashMap linkedHashMap7;
        String str11;
        LinkedHashMap linkedHashMap8;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        f5 f5VarA5;
        f5 f5VarA6;
        String str17;
        Set setC;
        LinkedHashMap linkedHashMap9;
        String str18;
        CharSequence charSequence;
        f5 f5VarA7;
        rs0 rs0Var2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        z4 z4Var;
        JSONObject jSONObjectK;
        in2 in2Var = this.e;
        String str19 = "error";
        LinkedHashMap linkedHashMap10 = this.Z;
        py0 py0Var2 = this.X;
        if (y50Var instanceof ft0) {
            ft0Var = (ft0) y50Var;
            linkedHashMap = linkedHashMap10;
            int i3 = ft0Var.t;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                ft0Var.t = i3 - Integer.MIN_VALUE;
            }
            obj = ft0Var.n;
            t70Var = t70.a;
            i = ft0Var.t;
            if (i != 0) {
                bz3.g(obj);
                strOptString = jSONObject.optString("id");
                strOptString.getClass();
                if (!cs2.A(strOptString)) {
                    py0Var2.getClass();
                    jSONObject5 = (JSONObject) ((ConcurrentHashMap) py0Var2.b).get(strOptString);
                    if (jSONObject5 != null) {
                        return jSONObject5;
                    }
                }
                q91Var = this.A;
                synchronized (q91Var) {
                    Object obj3 = ((LinkedHashMap) q91Var.b).get(Long.valueOf(j));
                }
                jSONObject2 = (JSONObject) obj3;
                if (jSONObject2 != null) {
                    if (!cs2.A(strOptString)) {
                        py0Var2.i(jSONObject2, strOptString);
                    }
                    return jSONObject2;
                }
                if (!g31.a(jSONObject.optString("name"), "sonic_action")) {
                    JSONObject jSONObjectPut = new JSONObject().put("error", "Unknown tool");
                    jSONObjectPut.getClass();
                    return jSONObjectPut;
                }
                jSONObjectOptJSONObject = jSONObject.optJSONObject("args");
                if (jSONObjectOptJSONObject == null) {
                    JSONObject jSONObjectPut2 = new JSONObject().put("error", "Missing arguments");
                    jSONObjectPut2.getClass();
                    return jSONObjectPut2;
                }
                x42 x42Var2 = de1.a;
                strOptString2 = jSONObjectOptJSONObject.optString("action");
                strOptString2.getClass();
                str.getClass();
                if (xy.o(str)) {
                    if (!wh2.c("meta.shutdown", "meta.cancel").contains(strOptString2)) {
                        i2 = 0;
                        while (true) {
                            if (i2 < str.length()) {
                                z2 = false;
                                Locale locale = Locale.ROOT;
                                String strO = cq.o(locale, str, locale);
                                Pattern patternCompile = Pattern.compile("[^\\p{L}\\p{N}']+");
                                patternCompile.getClass();
                                String strReplaceAll = patternCompile.matcher(strO).replaceAll(Padder.FALLBACK_PADDING_STRING);
                                strReplaceAll.getClass();
                                string = cs2.V(strReplaceAll).toString();
                                if (string.length() != 0 && cs2.N(string, new char[]{' '}, 6).size() <= 6 && !de1.b.a(string)) {
                                    zA = de1.a.a(string);
                                    break;
                                }
                            } else {
                                z2 = false;
                                if (cs2.o("\"“”‘’", str.charAt(i2))) {
                                    i2++;
                                }
                            }
                            zA = z2;
                            break;
                        }
                    }
                    z2 = false;
                    zA = false;
                } else {
                    z2 = false;
                    zA = true;
                }
                if (zA) {
                    o();
                    JSONObject jSONObjectPut3 = new JSONObject().put("status", "SUCCESS").put("spoken", "SONIC is off.");
                    jSONObjectPut3.getClass();
                    return jSONObjectPut3;
                }
                if (xy.q(str, z2)) {
                    p();
                    JSONObject jSONObjectPut4 = new JSONObject().put("status", "SUCCESS").put("spoken", "");
                    jSONObjectPut4.getClass();
                    return jSONObjectPut4;
                }
                wt1Var = this.Y;
                if (wt1Var != null) {
                    if (((Number) wt1Var.a).longValue() != j) {
                        wt1Var = null;
                    }
                    if (wt1Var != null) {
                        jSONObject4 = (JSONObject) wt1Var.b;
                        if (!cs2.A(strOptString)) {
                            py0Var2.i(jSONObject4, strOptString);
                        }
                        return jSONObject4;
                    }
                }
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                itKeys.getClass();
                vl0 vl0Var = new vl0(new p40(new rg(2, itKeys)), true, new j(24));
                linkedHashMap2 = new LinkedHashMap();
                ul0Var = new ul0(vl0Var);
                while (ul0Var.hasNext()) {
                    Object next = ul0Var.next();
                    linkedHashMap2.put(next, jSONObjectOptJSONObject.optString((String) next));
                }
                t42 t42Var3 = new t42();
                zM = in2Var.m();
                if (zM) {
                    mt0Var = this;
                } else {
                    if (z || f5Var != null) {
                        if (f5Var != null) {
                            f5VarA7 = f5.a(f5Var, null, null, 23);
                            py0Var = py0Var2;
                        } else {
                            x42 x42Var3 = ge1.a;
                            strOptString3 = jSONObjectOptJSONObject.optString("action");
                            strOptString3.getClass();
                            xv1Var = this.g;
                            xv1Var.getClass();
                            if (cs2.A(str) && !strOptString3.equals("meta.shutdown")) {
                                b63VarA = new mz2().a(str);
                                x42 x42Var4 = je2.a;
                                f5VarA = k24.a(b63VarA);
                                if (f5VarA != null) {
                                    f5VarA6 = f5.a(f5VarA, null, null, 23);
                                } else {
                                    x42 x42Var5 = yb2.a;
                                    f5VarB = xz3.b(b63VarA);
                                    if (f5VarB != null) {
                                        f5VarA5 = f5.a(f5VarB, null, null, 23);
                                    } else {
                                        zB = vi1.b(str);
                                        u00 u00Var = new u00();
                                        i60Var = i60.i;
                                        f5VarC = u00Var.c(b63VarA, i60Var);
                                        if (f5VarC != null || zB) {
                                            str3 = "message.sms.send";
                                        } else {
                                            str3 = "message.sms.send";
                                            f5Var2 = wh2.c(new w3("message.sms.send"), new w3("message.draft"), new w3("message.compose.choose_channel"), new w3("message.whatsapp.draft"), new w3("call.contact"), new w3("call.number")).contains(new w3(f5VarC.a)) ? f5VarC : null;
                                            if (f5Var2 != null) {
                                                str17 = f5Var2.a;
                                                if (g31.a(str17, "call.contact")) {
                                                    setC = wh2.b("contact_name");
                                                } else if (g31.a(str17, "call.number")) {
                                                    setC = wh2.b("phone_number");
                                                } else {
                                                    setC = wh2.c("contact_name", "recipients", "phone_number", "message_body", "text", "message_channel", "recipient_count");
                                                }
                                                linkedHashMap9 = new LinkedHashMap(f5Var2.b);
                                                if (g31.a(str17, "message.whatsapp.draft")) {
                                                    linkedHashMap9.put("message_channel", "whatsapp");
                                                }
                                                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                                                    str18 = (String) entry.getKey();
                                                    String str20 = (String) entry.getValue();
                                                    if (!setC.contains(str18) && !cs2.A(str20) && (!linkedHashMap9.containsKey(str18) || (charSequence = (CharSequence) linkedHashMap9.get(str18)) == null || cs2.A(charSequence))) {
                                                        linkedHashMap9.put(str18, str20);
                                                    }
                                                }
                                                f5VarA6 = f5.a(f5Var2, null, linkedHashMap9, 21);
                                            } else {
                                                f5VarC2 = new rp2(xv1Var).c(b63VarA, i60Var);
                                                if (f5VarC2 != null) {
                                                    f5VarA6 = f5.a(f5VarC2, null, null, 23);
                                                } else {
                                                    x42 x42Var6 = nk0.a;
                                                    f5VarW = y74.w(b63VarA);
                                                    if (f5VarW != null) {
                                                        f5VarA5 = f5.a(f5VarW, null, null, 23);
                                                    } else {
                                                        x42 x42Var7 = bi1.a;
                                                        f5VarA2 = fr4.a(b63VarA);
                                                        if (f5VarA2 == null && ((f5VarA2 = new bi1().c(b63VarA, i60Var)) == null || !wh2.c(new w3("media.pause"), new w3("media.resume"), new w3("media.stop"), new w3("media.next"), new w3("media.previous"), new w3("media.identify")).contains(new w3(f5VarA2.a)))) {
                                                            f5VarA2 = null;
                                                        }
                                                        if (f5VarA2 != null) {
                                                            f5VarA5 = f5.a(f5VarA2, null, null, 23);
                                                        } else {
                                                            x42 x42Var8 = yc3.a;
                                                            if (yc3.m(b63VarA.c)) {
                                                                Map mapSingletonMap = Collections.singletonMap("target", "close ad");
                                                                mapSingletonMap.getClass();
                                                                py0Var = py0Var2;
                                                                f5Var3 = new f5("screen.click", mapSingletonMap, 1.0f, q21.c, str);
                                                            } else {
                                                                py0Var = py0Var2;
                                                                f5VarC3 = new r03().c(b63VarA, i60Var);
                                                                if (f5VarC3 != null || !wh2.c(new w3("time.alarm.set"), new w3("time.timer.set")).contains(new w3(f5VarC3.a))) {
                                                                    f5VarC3 = null;
                                                                }
                                                                if (f5VarC3 != null) {
                                                                    f5VarA4 = f5.a(f5VarC3, null, null, 23);
                                                                } else {
                                                                    if (wh2.c(new w3("time.alarm.set"), new w3("time.timer.set")).contains(new w3(strOptString3))) {
                                                                        numC = s03.c(str);
                                                                        linkedHashMap4 = linkedHashMap2;
                                                                        if (numC != null) {
                                                                            numC2 = numC;
                                                                        } else {
                                                                            str15 = (String) linkedHashMap4.get("duration_seconds");
                                                                            if (str15 != null) {
                                                                                numC2 = s03.c(str15);
                                                                                if (numC2 == null) {
                                                                                    numC2 = js2.l(10, str15);
                                                                                }
                                                                            } else {
                                                                                numC2 = null;
                                                                            }
                                                                            if (numC2 == null) {
                                                                                str16 = (String) linkedHashMap4.get("duration");
                                                                                if (str16 != null) {
                                                                                    numC2 = s03.c(str16);
                                                                                    if (numC2 == null) {
                                                                                        numC = js2.l(10, str16);
                                                                                        numC2 = numC;
                                                                                    }
                                                                                } else {
                                                                                    numC2 = null;
                                                                                }
                                                                            }
                                                                        }
                                                                        strB = s03.b(str);
                                                                        if (strB == null) {
                                                                            str13 = (String) linkedHashMap4.get("date_time");
                                                                            if (str13 != null) {
                                                                                strB = s03.b(str13);
                                                                            } else {
                                                                                strB = null;
                                                                            }
                                                                            if (strB == null) {
                                                                                str14 = (String) linkedHashMap4.get("time");
                                                                                if (str14 != null) {
                                                                                    strB = s03.b(str14);
                                                                                } else {
                                                                                    strB = null;
                                                                                }
                                                                            }
                                                                        }
                                                                        if (strOptString3.equals("time.timer.set")) {
                                                                            linkedHashMap8 = new LinkedHashMap();
                                                                            if (numC2 != null) {
                                                                                linkedHashMap8.put("duration_seconds", String.valueOf(numC2.intValue()));
                                                                            }
                                                                            str12 = (String) linkedHashMap4.get("label");
                                                                            if (str12 != null) {
                                                                                linkedHashMap8.put("label", str12);
                                                                            }
                                                                            f5Var3 = new f5("time.timer.set", linkedHashMap8, 0.95f, q21.c, str);
                                                                        } else if (strOptString3.equals("time.alarm.set")) {
                                                                            linkedHashMap7 = new LinkedHashMap();
                                                                            if (strB != null) {
                                                                                linkedHashMap7.put("date_time", strB);
                                                                            }
                                                                            str11 = (String) linkedHashMap4.get("label");
                                                                            if (str11 != null) {
                                                                                linkedHashMap7.put("label", str11);
                                                                            }
                                                                            f5Var3 = new f5("time.alarm.set", linkedHashMap7, 0.95f, q21.c, str);
                                                                        }
                                                                    } else {
                                                                        linkedHashMap4 = linkedHashMap2;
                                                                    }
                                                                    f5VarC4 = new eu().c(b63VarA, i60Var);
                                                                    if (f5VarC4 != null || !wh2.c(new w3("camera.video"), new w3("camera.video.stop")).contains(new w3(f5VarC4.a))) {
                                                                        f5VarC4 = null;
                                                                    }
                                                                    if (f5VarC4 != null) {
                                                                        f5VarA4 = f5.a(f5VarC4, null, null, 23);
                                                                    } else {
                                                                        f5VarC5 = new tb2().c(b63VarA, i60Var);
                                                                        if (f5VarC5 != null) {
                                                                            str10 = f5VarC5.a;
                                                                            if (!g31.a(str10, "screen.read") && !g31.a(str10, "screen.deep_analyze")) {
                                                                                f5VarC5 = null;
                                                                            }
                                                                        } else {
                                                                            f5VarC5 = null;
                                                                        }
                                                                        if (f5VarC5 != null) {
                                                                            f5VarA4 = f5.a(f5VarC5, null, null, 23);
                                                                        } else {
                                                                            f5VarC6 = new rc0().c(b63VarA, i60Var);
                                                                            if (f5VarC6 != null) {
                                                                                str4 = strOptString3;
                                                                                if (!wh2.c(new w3("device.wifi.enable"), new w3("device.wifi.disable"), new w3("device.wifi.toggle"), new w3("device.wifi.settings"), new w3("device.bluetooth.enable"), new w3("device.bluetooth.disable"), new w3("device.bluetooth.toggle"), new w3("device.bluetooth.settings")).contains(new w3(f5VarC6.a))) {
                                                                                }
                                                                                if (f5VarC6 != null) {
                                                                                    f5VarA3 = f5.a(f5VarC6, null, null, 23);
                                                                                } else {
                                                                                    linkedHashMap5 = new LinkedHashMap();
                                                                                    for (Map.Entry entry2 : linkedHashMap4.entrySet()) {
                                                                                        if (!cs2.A((String) entry2.getValue())) {
                                                                                            linkedHashMap5.put(entry2.getKey(), entry2.getValue());
                                                                                        }
                                                                                    }
                                                                                    linkedHashMap6 = new LinkedHashMap(linkedHashMap5);
                                                                                    String string2 = cs2.V(str).toString();
                                                                                    Locale locale2 = Locale.ROOT;
                                                                                    String strO2 = cq.o(locale2, string2, locale2);
                                                                                    if (!ge1.c.a(str) && !cs2.n(strO2, "unsubscribe", false) && !cs2.n(strO2, "don't", false) && !cs2.n(strO2, "dont", false)) {
                                                                                        linkedHashMap6.put("target", "Subscribe");
                                                                                        str5 = "youtube.subscribe";
                                                                                    } else if (ge1.d.a(str)) {
                                                                                        str5 = "device.screenshot";
                                                                                    } else if (ge1.e.a(str)) {
                                                                                        str5 = "device.lock";
                                                                                    } else if (ge1.f.a(str)) {
                                                                                        str5 = "device.volume.up";
                                                                                    } else if (ge1.g.a(str)) {
                                                                                        str5 = "device.volume.down";
                                                                                    } else {
                                                                                        if (ge1.h.a(str)) {
                                                                                            str5 = "device.volume.mute";
                                                                                        } else {
                                                                                            x42Var = ge1.i;
                                                                                            if (x42Var.a(str)) {
                                                                                                fh1VarB = x42.b(x42Var, str);
                                                                                                if (fh1VarB != null || (str6 = (String) mz.z(1, fh1VarB.a())) == null) {
                                                                                                    obj2 = "level_percent";
                                                                                                } else {
                                                                                                    obj2 = "level_percent";
                                                                                                    linkedHashMap6.put(obj2, str6);
                                                                                                }
                                                                                                str5 = "device.volume.set";
                                                                                            } else {
                                                                                                obj2 = "level_percent";
                                                                                                str5 = str4;
                                                                                            }
                                                                                        }
                                                                                        zA2 = ge1.a.a(str);
                                                                                        Pattern patternCompile2 = Pattern.compile("\\b(?:sms|text message)\\b", 66);
                                                                                        patternCompile2.getClass();
                                                                                        zFind = patternCompile2.matcher(str).find();
                                                                                        if (wh2.c(new w3("message.whatsapp.send"), new w3("message.sms.confirm_send")).contains(new w3(str5))) {
                                                                                            if (zB) {
                                                                                                linkedHashMap6.clear();
                                                                                                str5 = "message.whatsapp.send";
                                                                                            } else if (zFind) {
                                                                                                str5 = str3;
                                                                                            } else {
                                                                                                str5 = "message.whatsapp.draft";
                                                                                            }
                                                                                        }
                                                                                        if (ge1.b.contains(new w3(str5))) {
                                                                                            if (str5.equals("message.compose.choose_channel")) {
                                                                                                if (zFind) {
                                                                                                    str9 = str3;
                                                                                                } else {
                                                                                                    str9 = "message.whatsapp.draft";
                                                                                                }
                                                                                                str5 = str9;
                                                                                            }
                                                                                            if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.compose.choose_channel")).contains(new w3(str5))) {
                                                                                                linkedHashMap6.remove("message_channel");
                                                                                                if (zA2) {
                                                                                                    linkedHashMap6.put("message_channel", "whatsapp");
                                                                                                } else if (zFind) {
                                                                                                    linkedHashMap6.put("message_channel", "sms");
                                                                                                }
                                                                                            }
                                                                                            if (str5.equals("device.volume.set") && !linkedHashMap6.containsKey(obj2)) {
                                                                                                str7 = (String) linkedHashMap6.get("level");
                                                                                                if (str7 == null) {
                                                                                                    str7 = (String) linkedHashMap6.get(obj2);
                                                                                                }
                                                                                                if (str7 != null || js2.l(10, str7) == null) {
                                                                                                    Pattern patternCompile3 = Pattern.compile("(\\d{1,3})%?");
                                                                                                    patternCompile3.getClass();
                                                                                                    Matcher matcher = patternCompile3.matcher(str);
                                                                                                    matcher.getClass();
                                                                                                    fh1VarA = ty3.a(matcher, 0, str);
                                                                                                    if (fh1VarA != null) {
                                                                                                        str8 = (String) mz.z(1, fh1VarA.a());
                                                                                                    } else {
                                                                                                        str8 = null;
                                                                                                    }
                                                                                                    if (str8 != null) {
                                                                                                        linkedHashMap6.put(obj2, str8);
                                                                                                    }
                                                                                                } else {
                                                                                                    linkedHashMap6.put(obj2, str7);
                                                                                                }
                                                                                            }
                                                                                            f5Var3 = new f5(str5, linkedHashMap6, 0.95f, q21.c, str);
                                                                                        }
                                                                                    }
                                                                                    obj2 = "level_percent";
                                                                                    zA2 = ge1.a.a(str);
                                                                                    Pattern patternCompile4 = Pattern.compile("\\b(?:sms|text message)\\b", 66);
                                                                                    patternCompile4.getClass();
                                                                                    zFind = patternCompile4.matcher(str).find();
                                                                                    if (wh2.c(new w3("message.whatsapp.send"), new w3("message.sms.confirm_send")).contains(new w3(str5))) {
                                                                                        if (zB) {
                                                                                            linkedHashMap6.clear();
                                                                                            str5 = "message.whatsapp.send";
                                                                                        } else if (zFind) {
                                                                                            str5 = str3;
                                                                                        } else {
                                                                                            str5 = "message.whatsapp.draft";
                                                                                        }
                                                                                    }
                                                                                    if (ge1.b.contains(new w3(str5))) {
                                                                                        if (str5.equals("message.compose.choose_channel")) {
                                                                                            if (zFind) {
                                                                                                str9 = str3;
                                                                                            } else {
                                                                                                str9 = "message.whatsapp.draft";
                                                                                            }
                                                                                            str5 = str9;
                                                                                        }
                                                                                        if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.compose.choose_channel")).contains(new w3(str5))) {
                                                                                            linkedHashMap6.remove("message_channel");
                                                                                            if (zA2) {
                                                                                                linkedHashMap6.put("message_channel", "whatsapp");
                                                                                            } else if (zFind) {
                                                                                                linkedHashMap6.put("message_channel", "sms");
                                                                                            }
                                                                                        }
                                                                                        if (str5.equals("device.volume.set")) {
                                                                                            str7 = (String) linkedHashMap6.get("level");
                                                                                            if (str7 == null) {
                                                                                                str7 = (String) linkedHashMap6.get(obj2);
                                                                                            }
                                                                                            if (str7 != null) {
                                                                                                Pattern patternCompile5 = Pattern.compile("(\\d{1,3})%?");
                                                                                                patternCompile5.getClass();
                                                                                                Matcher matcher2 = patternCompile5.matcher(str);
                                                                                                matcher2.getClass();
                                                                                                fh1VarA = ty3.a(matcher2, 0, str);
                                                                                                if (fh1VarA != null) {
                                                                                                    str8 = (String) mz.z(1, fh1VarA.a());
                                                                                                } else {
                                                                                                    str8 = null;
                                                                                                }
                                                                                                if (str8 != null) {
                                                                                                    linkedHashMap6.put(obj2, str8);
                                                                                                }
                                                                                            } else {
                                                                                                Pattern patternCompile6 = Pattern.compile("(\\d{1,3})%?");
                                                                                                patternCompile6.getClass();
                                                                                                Matcher matcher3 = patternCompile6.matcher(str);
                                                                                                matcher3.getClass();
                                                                                                fh1VarA = ty3.a(matcher3, 0, str);
                                                                                                if (fh1VarA != null) {
                                                                                                    str8 = (String) mz.z(1, fh1VarA.a());
                                                                                                } else {
                                                                                                    str8 = null;
                                                                                                }
                                                                                                if (str8 != null) {
                                                                                                    linkedHashMap6.put(obj2, str8);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        f5Var3 = new f5(str5, linkedHashMap6, 0.95f, q21.c, str);
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                str4 = strOptString3;
                                                                            }
                                                                            f5VarC6 = null;
                                                                            if (f5VarC6 != null) {
                                                                                f5VarA3 = f5.a(f5VarC6, null, null, 23);
                                                                            } else {
                                                                                linkedHashMap5 = new LinkedHashMap();
                                                                                while (r2.hasNext()) {
                                                                                    if (!cs2.A((String) entry2.getValue())) {
                                                                                        linkedHashMap5.put(entry2.getKey(), entry2.getValue());
                                                                                    }
                                                                                }
                                                                                linkedHashMap6 = new LinkedHashMap(linkedHashMap5);
                                                                                String string3 = cs2.V(str).toString();
                                                                                Locale locale3 = Locale.ROOT;
                                                                                String strO3 = cq.o(locale3, string3, locale3);
                                                                                if (!ge1.c.a(str)) {
                                                                                    if (ge1.d.a(str)) {
                                                                                        str5 = "device.screenshot";
                                                                                    } else if (ge1.e.a(str)) {
                                                                                        str5 = "device.lock";
                                                                                    } else if (ge1.f.a(str)) {
                                                                                        str5 = "device.volume.up";
                                                                                    } else if (ge1.g.a(str)) {
                                                                                        str5 = "device.volume.down";
                                                                                    } else if (ge1.h.a(str)) {
                                                                                        str5 = "device.volume.mute";
                                                                                    } else {
                                                                                        x42Var = ge1.i;
                                                                                        if (x42Var.a(str)) {
                                                                                            fh1VarB = x42.b(x42Var, str);
                                                                                            if (fh1VarB != null) {
                                                                                                obj2 = "level_percent";
                                                                                            } else {
                                                                                                obj2 = "level_percent";
                                                                                            }
                                                                                            str5 = "device.volume.set";
                                                                                        } else {
                                                                                            obj2 = "level_percent";
                                                                                            str5 = str4;
                                                                                        }
                                                                                    }
                                                                                    obj2 = "level_percent";
                                                                                } else {
                                                                                    if (ge1.d.a(str)) {
                                                                                        str5 = "device.screenshot";
                                                                                    } else if (ge1.e.a(str)) {
                                                                                        str5 = "device.lock";
                                                                                    } else if (ge1.f.a(str)) {
                                                                                        str5 = "device.volume.up";
                                                                                    } else if (ge1.g.a(str)) {
                                                                                        str5 = "device.volume.down";
                                                                                    } else if (ge1.h.a(str)) {
                                                                                        str5 = "device.volume.mute";
                                                                                    } else {
                                                                                        x42Var = ge1.i;
                                                                                        if (x42Var.a(str)) {
                                                                                            fh1VarB = x42.b(x42Var, str);
                                                                                            if (fh1VarB != null) {
                                                                                                obj2 = "level_percent";
                                                                                            } else {
                                                                                                obj2 = "level_percent";
                                                                                            }
                                                                                            str5 = "device.volume.set";
                                                                                        } else {
                                                                                            obj2 = "level_percent";
                                                                                            str5 = str4;
                                                                                        }
                                                                                    }
                                                                                    obj2 = "level_percent";
                                                                                }
                                                                                zA2 = ge1.a.a(str);
                                                                                Pattern patternCompile7 = Pattern.compile("\\b(?:sms|text message)\\b", 66);
                                                                                patternCompile7.getClass();
                                                                                zFind = patternCompile7.matcher(str).find();
                                                                                if (wh2.c(new w3("message.whatsapp.send"), new w3("message.sms.confirm_send")).contains(new w3(str5))) {
                                                                                    if (zB) {
                                                                                        linkedHashMap6.clear();
                                                                                        str5 = "message.whatsapp.send";
                                                                                    } else if (zFind) {
                                                                                        str5 = str3;
                                                                                    } else {
                                                                                        str5 = "message.whatsapp.draft";
                                                                                    }
                                                                                }
                                                                                if (ge1.b.contains(new w3(str5))) {
                                                                                    if (str5.equals("message.compose.choose_channel")) {
                                                                                        if (zFind) {
                                                                                            str9 = str3;
                                                                                        } else {
                                                                                            str9 = "message.whatsapp.draft";
                                                                                        }
                                                                                        str5 = str9;
                                                                                    }
                                                                                    if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.compose.choose_channel")).contains(new w3(str5))) {
                                                                                        linkedHashMap6.remove("message_channel");
                                                                                        if (zA2) {
                                                                                            linkedHashMap6.put("message_channel", "whatsapp");
                                                                                        } else if (zFind) {
                                                                                            linkedHashMap6.put("message_channel", "sms");
                                                                                        }
                                                                                    }
                                                                                    if (str5.equals("device.volume.set")) {
                                                                                        str7 = (String) linkedHashMap6.get("level");
                                                                                        if (str7 == null) {
                                                                                            str7 = (String) linkedHashMap6.get(obj2);
                                                                                        }
                                                                                        if (str7 != null) {
                                                                                            Pattern patternCompile8 = Pattern.compile("(\\d{1,3})%?");
                                                                                            patternCompile8.getClass();
                                                                                            Matcher matcher4 = patternCompile8.matcher(str);
                                                                                            matcher4.getClass();
                                                                                            fh1VarA = ty3.a(matcher4, 0, str);
                                                                                            if (fh1VarA != null) {
                                                                                                str8 = (String) mz.z(1, fh1VarA.a());
                                                                                            } else {
                                                                                                str8 = null;
                                                                                            }
                                                                                            if (str8 != null) {
                                                                                                linkedHashMap6.put(obj2, str8);
                                                                                            }
                                                                                        } else {
                                                                                            Pattern patternCompile9 = Pattern.compile("(\\d{1,3})%?");
                                                                                            patternCompile9.getClass();
                                                                                            Matcher matcher5 = patternCompile9.matcher(str);
                                                                                            matcher5.getClass();
                                                                                            fh1VarA = ty3.a(matcher5, 0, str);
                                                                                            if (fh1VarA != null) {
                                                                                                str8 = (String) mz.z(1, fh1VarA.a());
                                                                                            } else {
                                                                                                str8 = null;
                                                                                            }
                                                                                            if (str8 != null) {
                                                                                                linkedHashMap6.put(obj2, str8);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    f5Var3 = new f5(str5, linkedHashMap6, 0.95f, q21.c, str);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                f5VarA3 = f5VarA4;
                                                            }
                                                            f5VarA3 = f5Var3;
                                                        }
                                                    }
                                                }
                                                if (f5VarA3 == null) {
                                                    JSONObject jSONObjectPut5 = new JSONObject().put("status", "FAILED").put("retryable", false).put("spoken", "I couldn't match that request to a supported action.");
                                                    jSONObjectPut5.getClass();
                                                    return jSONObjectPut5;
                                                }
                                                f5VarA7 = f5VarA3;
                                            }
                                        }
                                        if (f5Var2 != null) {
                                            str17 = f5Var2.a;
                                            if (g31.a(str17, "call.contact")) {
                                                setC = wh2.b("contact_name");
                                            } else if (g31.a(str17, "call.number")) {
                                                setC = wh2.b("phone_number");
                                            } else {
                                                setC = wh2.c("contact_name", "recipients", "phone_number", "message_body", "text", "message_channel", "recipient_count");
                                            }
                                            linkedHashMap9 = new LinkedHashMap(f5Var2.b);
                                            if (g31.a(str17, "message.whatsapp.draft")) {
                                                linkedHashMap9.put("message_channel", "whatsapp");
                                            }
                                            while (r0.hasNext()) {
                                                str18 = (String) entry.getKey();
                                                String str21 = (String) entry.getValue();
                                                if (!setC.contains(str18)) {
                                                }
                                            }
                                            f5VarA6 = f5.a(f5Var2, null, linkedHashMap9, 21);
                                        } else {
                                            f5VarC2 = new rp2(xv1Var).c(b63VarA, i60Var);
                                            if (f5VarC2 != null) {
                                                f5VarA6 = f5.a(f5VarC2, null, null, 23);
                                            } else {
                                                x42 x42Var9 = nk0.a;
                                                f5VarW = y74.w(b63VarA);
                                                if (f5VarW != null) {
                                                    f5VarA5 = f5.a(f5VarW, null, null, 23);
                                                } else {
                                                    x42 x42Var10 = bi1.a;
                                                    f5VarA2 = fr4.a(b63VarA);
                                                    if (f5VarA2 == null) {
                                                        f5VarA2 = null;
                                                    }
                                                    if (f5VarA2 != null) {
                                                        f5VarA5 = f5.a(f5VarA2, null, null, 23);
                                                    } else {
                                                        x42 x42Var11 = yc3.a;
                                                        if (yc3.m(b63VarA.c)) {
                                                            Map mapSingletonMap2 = Collections.singletonMap("target", "close ad");
                                                            mapSingletonMap2.getClass();
                                                            py0Var = py0Var2;
                                                            f5Var3 = new f5("screen.click", mapSingletonMap2, 1.0f, q21.c, str);
                                                        } else {
                                                            py0Var = py0Var2;
                                                            f5VarC3 = new r03().c(b63VarA, i60Var);
                                                            if (f5VarC3 != null) {
                                                                f5VarC3 = null;
                                                            } else {
                                                                f5VarC3 = null;
                                                            }
                                                            if (f5VarC3 != null) {
                                                                f5VarA4 = f5.a(f5VarC3, null, null, 23);
                                                            } else {
                                                                if (wh2.c(new w3("time.alarm.set"), new w3("time.timer.set")).contains(new w3(strOptString3))) {
                                                                    numC = s03.c(str);
                                                                    linkedHashMap4 = linkedHashMap2;
                                                                    if (numC != null) {
                                                                        numC2 = numC;
                                                                    } else {
                                                                        str15 = (String) linkedHashMap4.get("duration_seconds");
                                                                        if (str15 != null) {
                                                                            numC2 = s03.c(str15);
                                                                            if (numC2 == null) {
                                                                                numC2 = js2.l(10, str15);
                                                                            }
                                                                        } else {
                                                                            numC2 = null;
                                                                        }
                                                                        if (numC2 == null) {
                                                                            str16 = (String) linkedHashMap4.get("duration");
                                                                            if (str16 != null) {
                                                                                numC2 = s03.c(str16);
                                                                                if (numC2 == null) {
                                                                                    numC = js2.l(10, str16);
                                                                                    numC2 = numC;
                                                                                }
                                                                            } else {
                                                                                numC2 = null;
                                                                            }
                                                                        }
                                                                    }
                                                                    strB = s03.b(str);
                                                                    if (strB == null) {
                                                                        str13 = (String) linkedHashMap4.get("date_time");
                                                                        if (str13 != null) {
                                                                            strB = s03.b(str13);
                                                                        } else {
                                                                            strB = null;
                                                                        }
                                                                        if (strB == null) {
                                                                            str14 = (String) linkedHashMap4.get("time");
                                                                            if (str14 != null) {
                                                                                strB = s03.b(str14);
                                                                            } else {
                                                                                strB = null;
                                                                            }
                                                                        }
                                                                    }
                                                                    if (strOptString3.equals("time.timer.set")) {
                                                                        linkedHashMap8 = new LinkedHashMap();
                                                                        if (numC2 != null) {
                                                                            linkedHashMap8.put("duration_seconds", String.valueOf(numC2.intValue()));
                                                                        }
                                                                        str12 = (String) linkedHashMap4.get("label");
                                                                        if (str12 != null) {
                                                                            linkedHashMap8.put("label", str12);
                                                                        }
                                                                        f5Var3 = new f5("time.timer.set", linkedHashMap8, 0.95f, q21.c, str);
                                                                    } else if (strOptString3.equals("time.alarm.set")) {
                                                                        linkedHashMap7 = new LinkedHashMap();
                                                                        if (strB != null) {
                                                                            linkedHashMap7.put("date_time", strB);
                                                                        }
                                                                        str11 = (String) linkedHashMap4.get("label");
                                                                        if (str11 != null) {
                                                                            linkedHashMap7.put("label", str11);
                                                                        }
                                                                        f5Var3 = new f5("time.alarm.set", linkedHashMap7, 0.95f, q21.c, str);
                                                                    }
                                                                } else {
                                                                    linkedHashMap4 = linkedHashMap2;
                                                                }
                                                                f5VarC4 = new eu().c(b63VarA, i60Var);
                                                                if (f5VarC4 != null) {
                                                                    f5VarC4 = null;
                                                                } else {
                                                                    f5VarC4 = null;
                                                                }
                                                                if (f5VarC4 != null) {
                                                                    f5VarA4 = f5.a(f5VarC4, null, null, 23);
                                                                } else {
                                                                    f5VarC5 = new tb2().c(b63VarA, i60Var);
                                                                    if (f5VarC5 != null) {
                                                                        str10 = f5VarC5.a;
                                                                        if (!g31.a(str10, "screen.read")) {
                                                                            f5VarC5 = null;
                                                                        }
                                                                    } else {
                                                                        f5VarC5 = null;
                                                                    }
                                                                    if (f5VarC5 != null) {
                                                                        f5VarA4 = f5.a(f5VarC5, null, null, 23);
                                                                    } else {
                                                                        f5VarC6 = new rc0().c(b63VarA, i60Var);
                                                                        if (f5VarC6 != null) {
                                                                            str4 = strOptString3;
                                                                            if (!wh2.c(new w3("device.wifi.enable"), new w3("device.wifi.disable"), new w3("device.wifi.toggle"), new w3("device.wifi.settings"), new w3("device.bluetooth.enable"), new w3("device.bluetooth.disable"), new w3("device.bluetooth.toggle"), new w3("device.bluetooth.settings")).contains(new w3(f5VarC6.a))) {
                                                                            }
                                                                            if (f5VarC6 != null) {
                                                                                f5VarA3 = f5.a(f5VarC6, null, null, 23);
                                                                            } else {
                                                                                linkedHashMap5 = new LinkedHashMap();
                                                                                while (r2.hasNext()) {
                                                                                    if (!cs2.A((String) entry2.getValue())) {
                                                                                        linkedHashMap5.put(entry2.getKey(), entry2.getValue());
                                                                                    }
                                                                                }
                                                                                linkedHashMap6 = new LinkedHashMap(linkedHashMap5);
                                                                                String string4 = cs2.V(str).toString();
                                                                                Locale locale4 = Locale.ROOT;
                                                                                String strO4 = cq.o(locale4, string4, locale4);
                                                                                if (!ge1.c.a(str)) {
                                                                                    if (ge1.d.a(str)) {
                                                                                        str5 = "device.screenshot";
                                                                                    } else if (ge1.e.a(str)) {
                                                                                        str5 = "device.lock";
                                                                                    } else if (ge1.f.a(str)) {
                                                                                        str5 = "device.volume.up";
                                                                                    } else if (ge1.g.a(str)) {
                                                                                        str5 = "device.volume.down";
                                                                                    } else if (ge1.h.a(str)) {
                                                                                        str5 = "device.volume.mute";
                                                                                    } else {
                                                                                        x42Var = ge1.i;
                                                                                        if (x42Var.a(str)) {
                                                                                            fh1VarB = x42.b(x42Var, str);
                                                                                            if (fh1VarB != null) {
                                                                                                obj2 = "level_percent";
                                                                                            } else {
                                                                                                obj2 = "level_percent";
                                                                                            }
                                                                                            str5 = "device.volume.set";
                                                                                        } else {
                                                                                            obj2 = "level_percent";
                                                                                            str5 = str4;
                                                                                        }
                                                                                    }
                                                                                    obj2 = "level_percent";
                                                                                } else {
                                                                                    if (ge1.d.a(str)) {
                                                                                        str5 = "device.screenshot";
                                                                                    } else if (ge1.e.a(str)) {
                                                                                        str5 = "device.lock";
                                                                                    } else if (ge1.f.a(str)) {
                                                                                        str5 = "device.volume.up";
                                                                                    } else if (ge1.g.a(str)) {
                                                                                        str5 = "device.volume.down";
                                                                                    } else if (ge1.h.a(str)) {
                                                                                        str5 = "device.volume.mute";
                                                                                    } else {
                                                                                        x42Var = ge1.i;
                                                                                        if (x42Var.a(str)) {
                                                                                            fh1VarB = x42.b(x42Var, str);
                                                                                            if (fh1VarB != null) {
                                                                                                obj2 = "level_percent";
                                                                                            } else {
                                                                                                obj2 = "level_percent";
                                                                                            }
                                                                                            str5 = "device.volume.set";
                                                                                        } else {
                                                                                            obj2 = "level_percent";
                                                                                            str5 = str4;
                                                                                        }
                                                                                    }
                                                                                    obj2 = "level_percent";
                                                                                }
                                                                                zA2 = ge1.a.a(str);
                                                                                Pattern patternCompile10 = Pattern.compile("\\b(?:sms|text message)\\b", 66);
                                                                                patternCompile10.getClass();
                                                                                zFind = patternCompile10.matcher(str).find();
                                                                                if (wh2.c(new w3("message.whatsapp.send"), new w3("message.sms.confirm_send")).contains(new w3(str5))) {
                                                                                    if (zB) {
                                                                                        linkedHashMap6.clear();
                                                                                        str5 = "message.whatsapp.send";
                                                                                    } else if (zFind) {
                                                                                        str5 = str3;
                                                                                    } else {
                                                                                        str5 = "message.whatsapp.draft";
                                                                                    }
                                                                                }
                                                                                if (ge1.b.contains(new w3(str5))) {
                                                                                    if (str5.equals("message.compose.choose_channel")) {
                                                                                        if (zFind) {
                                                                                            str9 = str3;
                                                                                        } else {
                                                                                            str9 = "message.whatsapp.draft";
                                                                                        }
                                                                                        str5 = str9;
                                                                                    }
                                                                                    if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.compose.choose_channel")).contains(new w3(str5))) {
                                                                                        linkedHashMap6.remove("message_channel");
                                                                                        if (zA2) {
                                                                                            linkedHashMap6.put("message_channel", "whatsapp");
                                                                                        } else if (zFind) {
                                                                                            linkedHashMap6.put("message_channel", "sms");
                                                                                        }
                                                                                    }
                                                                                    if (str5.equals("device.volume.set")) {
                                                                                        str7 = (String) linkedHashMap6.get("level");
                                                                                        if (str7 == null) {
                                                                                            str7 = (String) linkedHashMap6.get(obj2);
                                                                                        }
                                                                                        if (str7 != null) {
                                                                                            Pattern patternCompile11 = Pattern.compile("(\\d{1,3})%?");
                                                                                            patternCompile11.getClass();
                                                                                            Matcher matcher6 = patternCompile11.matcher(str);
                                                                                            matcher6.getClass();
                                                                                            fh1VarA = ty3.a(matcher6, 0, str);
                                                                                            if (fh1VarA != null) {
                                                                                                str8 = (String) mz.z(1, fh1VarA.a());
                                                                                            } else {
                                                                                                str8 = null;
                                                                                            }
                                                                                            if (str8 != null) {
                                                                                                linkedHashMap6.put(obj2, str8);
                                                                                            }
                                                                                        } else {
                                                                                            Pattern patternCompile12 = Pattern.compile("(\\d{1,3})%?");
                                                                                            patternCompile12.getClass();
                                                                                            Matcher matcher7 = patternCompile12.matcher(str);
                                                                                            matcher7.getClass();
                                                                                            fh1VarA = ty3.a(matcher7, 0, str);
                                                                                            if (fh1VarA != null) {
                                                                                                str8 = (String) mz.z(1, fh1VarA.a());
                                                                                            } else {
                                                                                                str8 = null;
                                                                                            }
                                                                                            if (str8 != null) {
                                                                                                linkedHashMap6.put(obj2, str8);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    f5Var3 = new f5(str5, linkedHashMap6, 0.95f, q21.c, str);
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str4 = strOptString3;
                                                                        }
                                                                        f5VarC6 = null;
                                                                        if (f5VarC6 != null) {
                                                                            f5VarA3 = f5.a(f5VarC6, null, null, 23);
                                                                        } else {
                                                                            linkedHashMap5 = new LinkedHashMap();
                                                                            while (r2.hasNext()) {
                                                                                if (!cs2.A((String) entry2.getValue())) {
                                                                                    linkedHashMap5.put(entry2.getKey(), entry2.getValue());
                                                                                }
                                                                            }
                                                                            linkedHashMap6 = new LinkedHashMap(linkedHashMap5);
                                                                            String string5 = cs2.V(str).toString();
                                                                            Locale locale5 = Locale.ROOT;
                                                                            String strO5 = cq.o(locale5, string5, locale5);
                                                                            if (!ge1.c.a(str)) {
                                                                                if (ge1.d.a(str)) {
                                                                                    str5 = "device.screenshot";
                                                                                } else if (ge1.e.a(str)) {
                                                                                    str5 = "device.lock";
                                                                                } else if (ge1.f.a(str)) {
                                                                                    str5 = "device.volume.up";
                                                                                } else if (ge1.g.a(str)) {
                                                                                    str5 = "device.volume.down";
                                                                                } else if (ge1.h.a(str)) {
                                                                                    str5 = "device.volume.mute";
                                                                                } else {
                                                                                    x42Var = ge1.i;
                                                                                    if (x42Var.a(str)) {
                                                                                        fh1VarB = x42.b(x42Var, str);
                                                                                        if (fh1VarB != null) {
                                                                                            obj2 = "level_percent";
                                                                                        } else {
                                                                                            obj2 = "level_percent";
                                                                                        }
                                                                                        str5 = "device.volume.set";
                                                                                    } else {
                                                                                        obj2 = "level_percent";
                                                                                        str5 = str4;
                                                                                    }
                                                                                }
                                                                                obj2 = "level_percent";
                                                                            } else {
                                                                                if (ge1.d.a(str)) {
                                                                                    str5 = "device.screenshot";
                                                                                } else if (ge1.e.a(str)) {
                                                                                    str5 = "device.lock";
                                                                                } else if (ge1.f.a(str)) {
                                                                                    str5 = "device.volume.up";
                                                                                } else if (ge1.g.a(str)) {
                                                                                    str5 = "device.volume.down";
                                                                                } else if (ge1.h.a(str)) {
                                                                                    str5 = "device.volume.mute";
                                                                                } else {
                                                                                    x42Var = ge1.i;
                                                                                    if (x42Var.a(str)) {
                                                                                        fh1VarB = x42.b(x42Var, str);
                                                                                        if (fh1VarB != null) {
                                                                                            obj2 = "level_percent";
                                                                                        } else {
                                                                                            obj2 = "level_percent";
                                                                                        }
                                                                                        str5 = "device.volume.set";
                                                                                    } else {
                                                                                        obj2 = "level_percent";
                                                                                        str5 = str4;
                                                                                    }
                                                                                }
                                                                                obj2 = "level_percent";
                                                                            }
                                                                            zA2 = ge1.a.a(str);
                                                                            Pattern patternCompile13 = Pattern.compile("\\b(?:sms|text message)\\b", 66);
                                                                            patternCompile13.getClass();
                                                                            zFind = patternCompile13.matcher(str).find();
                                                                            if (wh2.c(new w3("message.whatsapp.send"), new w3("message.sms.confirm_send")).contains(new w3(str5))) {
                                                                                if (zB) {
                                                                                    linkedHashMap6.clear();
                                                                                    str5 = "message.whatsapp.send";
                                                                                } else if (zFind) {
                                                                                    str5 = str3;
                                                                                } else {
                                                                                    str5 = "message.whatsapp.draft";
                                                                                }
                                                                            }
                                                                            if (ge1.b.contains(new w3(str5))) {
                                                                                if (str5.equals("message.compose.choose_channel")) {
                                                                                    if (zFind) {
                                                                                        str9 = str3;
                                                                                    } else {
                                                                                        str9 = "message.whatsapp.draft";
                                                                                    }
                                                                                    str5 = str9;
                                                                                }
                                                                                if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.compose.choose_channel")).contains(new w3(str5))) {
                                                                                    linkedHashMap6.remove("message_channel");
                                                                                    if (zA2) {
                                                                                        linkedHashMap6.put("message_channel", "whatsapp");
                                                                                    } else if (zFind) {
                                                                                        linkedHashMap6.put("message_channel", "sms");
                                                                                    }
                                                                                }
                                                                                if (str5.equals("device.volume.set")) {
                                                                                    str7 = (String) linkedHashMap6.get("level");
                                                                                    if (str7 == null) {
                                                                                        str7 = (String) linkedHashMap6.get(obj2);
                                                                                    }
                                                                                    if (str7 != null) {
                                                                                        Pattern patternCompile14 = Pattern.compile("(\\d{1,3})%?");
                                                                                        patternCompile14.getClass();
                                                                                        Matcher matcher8 = patternCompile14.matcher(str);
                                                                                        matcher8.getClass();
                                                                                        fh1VarA = ty3.a(matcher8, 0, str);
                                                                                        if (fh1VarA != null) {
                                                                                            str8 = (String) mz.z(1, fh1VarA.a());
                                                                                        } else {
                                                                                            str8 = null;
                                                                                        }
                                                                                        if (str8 != null) {
                                                                                            linkedHashMap6.put(obj2, str8);
                                                                                        }
                                                                                    } else {
                                                                                        Pattern patternCompile15 = Pattern.compile("(\\d{1,3})%?");
                                                                                        patternCompile15.getClass();
                                                                                        Matcher matcher9 = patternCompile15.matcher(str);
                                                                                        matcher9.getClass();
                                                                                        fh1VarA = ty3.a(matcher9, 0, str);
                                                                                        if (fh1VarA != null) {
                                                                                            str8 = (String) mz.z(1, fh1VarA.a());
                                                                                        } else {
                                                                                            str8 = null;
                                                                                        }
                                                                                        if (str8 != null) {
                                                                                            linkedHashMap6.put(obj2, str8);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                f5Var3 = new f5(str5, linkedHashMap6, 0.95f, q21.c, str);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            f5VarA3 = f5VarA4;
                                                        }
                                                        f5VarA3 = f5Var3;
                                                    }
                                                }
                                            }
                                            if (f5VarA3 == null) {
                                                JSONObject jSONObjectPut6 = new JSONObject().put("status", "FAILED").put("retryable", false).put("spoken", "I couldn't match that request to a supported action.");
                                                jSONObjectPut6.getClass();
                                                return jSONObjectPut6;
                                            }
                                            f5VarA7 = f5VarA3;
                                        }
                                    }
                                    f5VarA3 = f5VarA5;
                                    py0Var = py0Var2;
                                    if (f5VarA3 == null) {
                                        JSONObject jSONObjectPut7 = new JSONObject().put("status", "FAILED").put("retryable", false).put("spoken", "I couldn't match that request to a supported action.");
                                        jSONObjectPut7.getClass();
                                        return jSONObjectPut7;
                                    }
                                    f5VarA7 = f5VarA3;
                                }
                                f5VarA3 = f5VarA6;
                                py0Var = py0Var2;
                                if (f5VarA3 == null) {
                                    JSONObject jSONObjectPut8 = new JSONObject().put("status", "FAILED").put("retryable", false).put("spoken", "I couldn't match that request to a supported action.");
                                    jSONObjectPut8.getClass();
                                    return jSONObjectPut8;
                                }
                                f5VarA7 = f5VarA3;
                            } else {
                                py0Var = py0Var2;
                            }
                            f5VarA3 = null;
                            if (f5VarA3 == null) {
                                JSONObject jSONObjectPut9 = new JSONObject().put("status", "FAILED").put("retryable", false).put("spoken", "I couldn't match that request to a supported action.");
                                jSONObjectPut9.getClass();
                                return jSONObjectPut9;
                            }
                            f5VarA7 = f5VarA3;
                        }
                        j2 = j;
                        rs0Var2 = new rs0(j2, f5VarA7.a, bh1.h(f5VarA7.b));
                        linkedHashMap3 = linkedHashMap;
                        jSONObject3 = (JSONObject) linkedHashMap3.get(rs0Var2);
                        if (jSONObject3 != null) {
                            if (!cs2.A(strOptString)) {
                                py0Var.i(jSONObject3, strOptString);
                            }
                            return jSONObject3;
                        }
                        l90 l90Var = new l90(1, new gn2(f5VarA7, in2Var, (x50) null));
                        rs0Var = rs0Var2;
                        l90VarL = l90Var;
                        mt0Var = this;
                    } else {
                        mt0Var = this;
                    }
                    t42Var = t42Var3;
                    ht0Var = new ht0(mt0Var, hq0Var, t42Var, 0);
                    ft0Var2 = ft0Var;
                    ft0Var2.e = strOptString;
                    ft0Var2.f = t42Var;
                    ft0Var2.i = rs0Var;
                    ft0Var2.j = j2;
                    z3 = zM;
                    ft0Var2.k = z3;
                    ft0Var2.t = 1;
                    if (l90VarL.a(ht0Var, ft0Var2) == t70Var) {
                        return t70Var;
                    }
                    str2 = strOptString;
                    t42Var2 = t42Var;
                }
                t42Var3 = t42Var3;
                ft0Var = ft0Var;
                str19 = "error";
                zM = zM;
                linkedHashMap3 = linkedHashMap;
                rs0Var = null;
                py0Var = py0Var2;
                j2 = j;
                l90VarL = mt0Var.e.l(str, c63.b, ii0.a);
                t42Var = t42Var3;
                ht0Var = new ht0(mt0Var, hq0Var, t42Var, 0);
                ft0Var2 = ft0Var;
                ft0Var2.e = strOptString;
                ft0Var2.f = t42Var;
                ft0Var2.i = rs0Var;
                ft0Var2.j = j2;
                z3 = zM;
                ft0Var2.k = z3;
                ft0Var2.t = 1;
                if (l90VarL.a(ht0Var, ft0Var2) == t70Var) {
                    return t70Var;
                }
                str2 = strOptString;
                t42Var2 = t42Var;
            } else {
                if (i == 1) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                boolean z4 = ft0Var.k;
                long j3 = ft0Var.j;
                rs0 rs0Var3 = ft0Var.i;
                t42Var2 = ft0Var.f;
                String str22 = ft0Var.e;
                bz3.g(obj);
                z3 = z4;
                rs0Var = rs0Var3;
                str19 = "error";
                mt0Var = this;
                str2 = str22;
                py0Var = py0Var2;
                j2 = j3;
                linkedHashMap3 = linkedHashMap;
            }
            z4Var = (z4) t42Var2.a;
            if (z4Var == null) {
                JSONObject jSONObjectPut10 = new JSONObject().put(str19, "No action outcome");
                jSONObjectPut10.getClass();
                return jSONObjectPut10;
            }
            jSONObjectK = k(z4Var);
            str2.getClass();
            if (!cs2.A(str2)) {
                py0Var.i(jSONObjectK, str2);
            }
            if (z4Var.b == null || z3) {
                mt0Var.Y = new wt1(new Long(j2), jSONObjectK);
            }
            if (rs0Var != null) {
                linkedHashMap3.put(rs0Var, jSONObjectK);
            }
            while (linkedHashMap3.size() > 64) {
                Set setKeySet = linkedHashMap3.keySet();
                setKeySet.getClass();
                linkedHashMap3.remove(mz.w(setKeySet));
            }
            return jSONObjectK;
        }
        linkedHashMap = linkedHashMap10;
        ft0Var = new ft0(this, y50Var);
        obj = ft0Var.n;
        t70Var = t70.a;
        i = ft0Var.t;
        if (i != 0) {
            bz3.g(obj);
            strOptString = jSONObject.optString("id");
            strOptString.getClass();
            if (!cs2.A(strOptString)) {
                py0Var2.getClass();
                jSONObject5 = (JSONObject) ((ConcurrentHashMap) py0Var2.b).get(strOptString);
                if (jSONObject5 != null) {
                    return jSONObject5;
                }
            }
            q91Var = this.A;
            synchronized (q91Var) {
                Object obj4 = ((LinkedHashMap) q91Var.b).get(Long.valueOf(j));
                jSONObject2 = (JSONObject) obj4;
                if (jSONObject2 != null) {
                    if (!cs2.A(strOptString)) {
                        py0Var2.i(jSONObject2, strOptString);
                    }
                    return jSONObject2;
                }
                if (!g31.a(jSONObject.optString("name"), "sonic_action")) {
                    JSONObject jSONObjectPut11 = new JSONObject().put("error", "Unknown tool");
                    jSONObjectPut11.getClass();
                    return jSONObjectPut11;
                }
                jSONObjectOptJSONObject = jSONObject.optJSONObject("args");
                if (jSONObjectOptJSONObject == null) {
                    JSONObject jSONObjectPut12 = new JSONObject().put("error", "Missing arguments");
                    jSONObjectPut12.getClass();
                    return jSONObjectPut12;
                }
                x42 x42Var12 = de1.a;
                strOptString2 = jSONObjectOptJSONObject.optString("action");
                strOptString2.getClass();
                str.getClass();
                if (xy.o(str)) {
                    if (!wh2.c("meta.shutdown", "meta.cancel").contains(strOptString2)) {
                        i2 = 0;
                        while (true) {
                            if (i2 < str.length()) {
                                z2 = false;
                                Locale locale6 = Locale.ROOT;
                                String strO6 = cq.o(locale6, str, locale6);
                                Pattern patternCompile16 = Pattern.compile("[^\\p{L}\\p{N}']+");
                                patternCompile16.getClass();
                                String strReplaceAll2 = patternCompile16.matcher(strO6).replaceAll(Padder.FALLBACK_PADDING_STRING);
                                strReplaceAll2.getClass();
                                string = cs2.V(strReplaceAll2).toString();
                                if (string.length() != 0) {
                                    zA = de1.a.a(string);
                                    break;
                                }
                                break;
                            }
                            z2 = false;
                            if (cs2.o("\"“”‘’", str.charAt(i2))) {
                                i2++;
                            }
                            zA = z2;
                            break;
                        }
                    }
                    z2 = false;
                    zA = false;
                } else {
                    z2 = false;
                    zA = true;
                }
                if (zA) {
                    o();
                    JSONObject jSONObjectPut13 = new JSONObject().put("status", "SUCCESS").put("spoken", "SONIC is off.");
                    jSONObjectPut13.getClass();
                    return jSONObjectPut13;
                }
                if (xy.q(str, z2)) {
                    p();
                    JSONObject jSONObjectPut14 = new JSONObject().put("status", "SUCCESS").put("spoken", "");
                    jSONObjectPut14.getClass();
                    return jSONObjectPut14;
                }
                wt1Var = this.Y;
                if (wt1Var != null) {
                    if (((Number) wt1Var.a).longValue() != j) {
                        wt1Var = null;
                    }
                    if (wt1Var != null) {
                        jSONObject4 = (JSONObject) wt1Var.b;
                        if (!cs2.A(strOptString)) {
                            py0Var2.i(jSONObject4, strOptString);
                        }
                        return jSONObject4;
                    }
                }
                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                itKeys2.getClass();
                vl0 vl0Var2 = new vl0(new p40(new rg(2, itKeys2)), true, new j(24));
                linkedHashMap2 = new LinkedHashMap();
                ul0Var = new ul0(vl0Var2);
                while (ul0Var.hasNext()) {
                    Object next2 = ul0Var.next();
                    linkedHashMap2.put(next2, jSONObjectOptJSONObject.optString((String) next2));
                }
                t42 t42Var4 = new t42();
                zM = in2Var.m();
                if (zM) {
                    if (z) {
                    }
                    if (f5Var != null) {
                        f5VarA7 = f5.a(f5Var, null, null, 23);
                        py0Var = py0Var2;
                    } else {
                        x42 x42Var13 = ge1.a;
                        strOptString3 = jSONObjectOptJSONObject.optString("action");
                        strOptString3.getClass();
                        xv1Var = this.g;
                        xv1Var.getClass();
                        if (cs2.A(str)) {
                            py0Var = py0Var2;
                            f5VarA3 = null;
                        } else {
                            b63VarA = new mz2().a(str);
                            x42 x42Var14 = je2.a;
                            f5VarA = k24.a(b63VarA);
                            if (f5VarA != null) {
                                f5VarA6 = f5.a(f5VarA, null, null, 23);
                            } else {
                                x42 x42Var15 = yb2.a;
                                f5VarB = xz3.b(b63VarA);
                                if (f5VarB != null) {
                                    f5VarA5 = f5.a(f5VarB, null, null, 23);
                                } else {
                                    zB = vi1.b(str);
                                    u00 u00Var2 = new u00();
                                    i60Var = i60.i;
                                    f5VarC = u00Var2.c(b63VarA, i60Var);
                                    if (f5VarC != null) {
                                        str3 = "message.sms.send";
                                    } else {
                                        str3 = "message.sms.send";
                                    }
                                    if (f5Var2 != null) {
                                        str17 = f5Var2.a;
                                        if (g31.a(str17, "call.contact")) {
                                            setC = wh2.b("contact_name");
                                        } else if (g31.a(str17, "call.number")) {
                                            setC = wh2.b("phone_number");
                                        } else {
                                            setC = wh2.c("contact_name", "recipients", "phone_number", "message_body", "text", "message_channel", "recipient_count");
                                        }
                                        linkedHashMap9 = new LinkedHashMap(f5Var2.b);
                                        if (g31.a(str17, "message.whatsapp.draft")) {
                                            linkedHashMap9.put("message_channel", "whatsapp");
                                        }
                                        while (r0.hasNext()) {
                                            str18 = (String) entry.getKey();
                                            String str23 = (String) entry.getValue();
                                            if (!setC.contains(str18)) {
                                            }
                                        }
                                        f5VarA6 = f5.a(f5Var2, null, linkedHashMap9, 21);
                                    } else {
                                        f5VarC2 = new rp2(xv1Var).c(b63VarA, i60Var);
                                        if (f5VarC2 != null) {
                                            f5VarA6 = f5.a(f5VarC2, null, null, 23);
                                        } else {
                                            x42 x42Var16 = nk0.a;
                                            f5VarW = y74.w(b63VarA);
                                            if (f5VarW != null) {
                                                f5VarA5 = f5.a(f5VarW, null, null, 23);
                                            } else {
                                                x42 x42Var17 = bi1.a;
                                                f5VarA2 = fr4.a(b63VarA);
                                                if (f5VarA2 == null) {
                                                    f5VarA2 = null;
                                                }
                                                if (f5VarA2 != null) {
                                                    f5VarA5 = f5.a(f5VarA2, null, null, 23);
                                                } else {
                                                    x42 x42Var18 = yc3.a;
                                                    if (yc3.m(b63VarA.c)) {
                                                        Map mapSingletonMap3 = Collections.singletonMap("target", "close ad");
                                                        mapSingletonMap3.getClass();
                                                        py0Var = py0Var2;
                                                        f5Var3 = new f5("screen.click", mapSingletonMap3, 1.0f, q21.c, str);
                                                    } else {
                                                        py0Var = py0Var2;
                                                        f5VarC3 = new r03().c(b63VarA, i60Var);
                                                        if (f5VarC3 != null) {
                                                            f5VarC3 = null;
                                                        } else {
                                                            f5VarC3 = null;
                                                        }
                                                        if (f5VarC3 != null) {
                                                            f5VarA4 = f5.a(f5VarC3, null, null, 23);
                                                        } else {
                                                            if (wh2.c(new w3("time.alarm.set"), new w3("time.timer.set")).contains(new w3(strOptString3))) {
                                                                numC = s03.c(str);
                                                                linkedHashMap4 = linkedHashMap2;
                                                                if (numC != null) {
                                                                    numC2 = numC;
                                                                } else {
                                                                    str15 = (String) linkedHashMap4.get("duration_seconds");
                                                                    if (str15 != null) {
                                                                        numC2 = s03.c(str15);
                                                                        if (numC2 == null) {
                                                                            numC2 = js2.l(10, str15);
                                                                        }
                                                                    } else {
                                                                        numC2 = null;
                                                                    }
                                                                    if (numC2 == null) {
                                                                        str16 = (String) linkedHashMap4.get("duration");
                                                                        if (str16 != null) {
                                                                            numC2 = s03.c(str16);
                                                                            if (numC2 == null) {
                                                                                numC = js2.l(10, str16);
                                                                                numC2 = numC;
                                                                            }
                                                                        } else {
                                                                            numC2 = null;
                                                                        }
                                                                    }
                                                                }
                                                                strB = s03.b(str);
                                                                if (strB == null) {
                                                                    str13 = (String) linkedHashMap4.get("date_time");
                                                                    if (str13 != null) {
                                                                        strB = s03.b(str13);
                                                                    } else {
                                                                        strB = null;
                                                                    }
                                                                    if (strB == null) {
                                                                        str14 = (String) linkedHashMap4.get("time");
                                                                        if (str14 != null) {
                                                                            strB = s03.b(str14);
                                                                        } else {
                                                                            strB = null;
                                                                        }
                                                                    }
                                                                }
                                                                if (strOptString3.equals("time.timer.set")) {
                                                                    linkedHashMap8 = new LinkedHashMap();
                                                                    if (numC2 != null) {
                                                                        linkedHashMap8.put("duration_seconds", String.valueOf(numC2.intValue()));
                                                                    }
                                                                    str12 = (String) linkedHashMap4.get("label");
                                                                    if (str12 != null) {
                                                                        linkedHashMap8.put("label", str12);
                                                                    }
                                                                    f5Var3 = new f5("time.timer.set", linkedHashMap8, 0.95f, q21.c, str);
                                                                } else if (strOptString3.equals("time.alarm.set")) {
                                                                    linkedHashMap7 = new LinkedHashMap();
                                                                    if (strB != null) {
                                                                        linkedHashMap7.put("date_time", strB);
                                                                    }
                                                                    str11 = (String) linkedHashMap4.get("label");
                                                                    if (str11 != null) {
                                                                        linkedHashMap7.put("label", str11);
                                                                    }
                                                                    f5Var3 = new f5("time.alarm.set", linkedHashMap7, 0.95f, q21.c, str);
                                                                }
                                                            } else {
                                                                linkedHashMap4 = linkedHashMap2;
                                                            }
                                                            f5VarC4 = new eu().c(b63VarA, i60Var);
                                                            if (f5VarC4 != null) {
                                                                f5VarC4 = null;
                                                            } else {
                                                                f5VarC4 = null;
                                                            }
                                                            if (f5VarC4 != null) {
                                                                f5VarA4 = f5.a(f5VarC4, null, null, 23);
                                                            } else {
                                                                f5VarC5 = new tb2().c(b63VarA, i60Var);
                                                                if (f5VarC5 != null) {
                                                                    str10 = f5VarC5.a;
                                                                    if (!g31.a(str10, "screen.read")) {
                                                                        f5VarC5 = null;
                                                                    }
                                                                } else {
                                                                    f5VarC5 = null;
                                                                }
                                                                if (f5VarC5 != null) {
                                                                    f5VarA4 = f5.a(f5VarC5, null, null, 23);
                                                                } else {
                                                                    f5VarC6 = new rc0().c(b63VarA, i60Var);
                                                                    if (f5VarC6 != null) {
                                                                        str4 = strOptString3;
                                                                        if (!wh2.c(new w3("device.wifi.enable"), new w3("device.wifi.disable"), new w3("device.wifi.toggle"), new w3("device.wifi.settings"), new w3("device.bluetooth.enable"), new w3("device.bluetooth.disable"), new w3("device.bluetooth.toggle"), new w3("device.bluetooth.settings")).contains(new w3(f5VarC6.a))) {
                                                                        }
                                                                        if (f5VarC6 != null) {
                                                                            f5VarA3 = f5.a(f5VarC6, null, null, 23);
                                                                        } else {
                                                                            linkedHashMap5 = new LinkedHashMap();
                                                                            while (r2.hasNext()) {
                                                                                if (!cs2.A((String) entry2.getValue())) {
                                                                                    linkedHashMap5.put(entry2.getKey(), entry2.getValue());
                                                                                }
                                                                            }
                                                                            linkedHashMap6 = new LinkedHashMap(linkedHashMap5);
                                                                            String string6 = cs2.V(str).toString();
                                                                            Locale locale7 = Locale.ROOT;
                                                                            String strO7 = cq.o(locale7, string6, locale7);
                                                                            if (!ge1.c.a(str)) {
                                                                                if (ge1.d.a(str)) {
                                                                                    str5 = "device.screenshot";
                                                                                } else if (ge1.e.a(str)) {
                                                                                    str5 = "device.lock";
                                                                                } else if (ge1.f.a(str)) {
                                                                                    str5 = "device.volume.up";
                                                                                } else if (ge1.g.a(str)) {
                                                                                    str5 = "device.volume.down";
                                                                                } else if (ge1.h.a(str)) {
                                                                                    str5 = "device.volume.mute";
                                                                                } else {
                                                                                    x42Var = ge1.i;
                                                                                    if (x42Var.a(str)) {
                                                                                        fh1VarB = x42.b(x42Var, str);
                                                                                        if (fh1VarB != null) {
                                                                                            obj2 = "level_percent";
                                                                                        } else {
                                                                                            obj2 = "level_percent";
                                                                                        }
                                                                                        str5 = "device.volume.set";
                                                                                    } else {
                                                                                        obj2 = "level_percent";
                                                                                        str5 = str4;
                                                                                    }
                                                                                }
                                                                                obj2 = "level_percent";
                                                                            } else {
                                                                                if (ge1.d.a(str)) {
                                                                                    str5 = "device.screenshot";
                                                                                } else if (ge1.e.a(str)) {
                                                                                    str5 = "device.lock";
                                                                                } else if (ge1.f.a(str)) {
                                                                                    str5 = "device.volume.up";
                                                                                } else if (ge1.g.a(str)) {
                                                                                    str5 = "device.volume.down";
                                                                                } else if (ge1.h.a(str)) {
                                                                                    str5 = "device.volume.mute";
                                                                                } else {
                                                                                    x42Var = ge1.i;
                                                                                    if (x42Var.a(str)) {
                                                                                        fh1VarB = x42.b(x42Var, str);
                                                                                        if (fh1VarB != null) {
                                                                                            obj2 = "level_percent";
                                                                                        } else {
                                                                                            obj2 = "level_percent";
                                                                                        }
                                                                                        str5 = "device.volume.set";
                                                                                    } else {
                                                                                        obj2 = "level_percent";
                                                                                        str5 = str4;
                                                                                    }
                                                                                }
                                                                                obj2 = "level_percent";
                                                                            }
                                                                            zA2 = ge1.a.a(str);
                                                                            Pattern patternCompile17 = Pattern.compile("\\b(?:sms|text message)\\b", 66);
                                                                            patternCompile17.getClass();
                                                                            zFind = patternCompile17.matcher(str).find();
                                                                            if (wh2.c(new w3("message.whatsapp.send"), new w3("message.sms.confirm_send")).contains(new w3(str5))) {
                                                                                if (zB) {
                                                                                    linkedHashMap6.clear();
                                                                                    str5 = "message.whatsapp.send";
                                                                                } else if (zFind) {
                                                                                    str5 = str3;
                                                                                } else {
                                                                                    str5 = "message.whatsapp.draft";
                                                                                }
                                                                            }
                                                                            if (ge1.b.contains(new w3(str5))) {
                                                                                f5VarA3 = null;
                                                                            } else {
                                                                                if (str5.equals("message.compose.choose_channel")) {
                                                                                    if (zFind) {
                                                                                        str9 = str3;
                                                                                    } else {
                                                                                        str9 = "message.whatsapp.draft";
                                                                                    }
                                                                                    str5 = str9;
                                                                                }
                                                                                if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.compose.choose_channel")).contains(new w3(str5))) {
                                                                                    linkedHashMap6.remove("message_channel");
                                                                                    if (zA2) {
                                                                                        linkedHashMap6.put("message_channel", "whatsapp");
                                                                                    } else if (zFind) {
                                                                                        linkedHashMap6.put("message_channel", "sms");
                                                                                    }
                                                                                }
                                                                                if (str5.equals("device.volume.set")) {
                                                                                    str7 = (String) linkedHashMap6.get("level");
                                                                                    if (str7 == null) {
                                                                                        str7 = (String) linkedHashMap6.get(obj2);
                                                                                    }
                                                                                    if (str7 != null) {
                                                                                        Pattern patternCompile18 = Pattern.compile("(\\d{1,3})%?");
                                                                                        patternCompile18.getClass();
                                                                                        Matcher matcher10 = patternCompile18.matcher(str);
                                                                                        matcher10.getClass();
                                                                                        fh1VarA = ty3.a(matcher10, 0, str);
                                                                                        if (fh1VarA != null) {
                                                                                            str8 = (String) mz.z(1, fh1VarA.a());
                                                                                        } else {
                                                                                            str8 = null;
                                                                                        }
                                                                                        if (str8 != null) {
                                                                                            linkedHashMap6.put(obj2, str8);
                                                                                        }
                                                                                    } else {
                                                                                        Pattern patternCompile19 = Pattern.compile("(\\d{1,3})%?");
                                                                                        patternCompile19.getClass();
                                                                                        Matcher matcher11 = patternCompile19.matcher(str);
                                                                                        matcher11.getClass();
                                                                                        fh1VarA = ty3.a(matcher11, 0, str);
                                                                                        if (fh1VarA != null) {
                                                                                            str8 = (String) mz.z(1, fh1VarA.a());
                                                                                        } else {
                                                                                            str8 = null;
                                                                                        }
                                                                                        if (str8 != null) {
                                                                                            linkedHashMap6.put(obj2, str8);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                f5Var3 = new f5(str5, linkedHashMap6, 0.95f, q21.c, str);
                                                                            }
                                                                        }
                                                                    } else {
                                                                        str4 = strOptString3;
                                                                    }
                                                                    f5VarC6 = null;
                                                                    if (f5VarC6 != null) {
                                                                        f5VarA3 = f5.a(f5VarC6, null, null, 23);
                                                                    } else {
                                                                        linkedHashMap5 = new LinkedHashMap();
                                                                        while (r2.hasNext()) {
                                                                            if (!cs2.A((String) entry2.getValue())) {
                                                                                linkedHashMap5.put(entry2.getKey(), entry2.getValue());
                                                                            }
                                                                        }
                                                                        linkedHashMap6 = new LinkedHashMap(linkedHashMap5);
                                                                        String string7 = cs2.V(str).toString();
                                                                        Locale locale8 = Locale.ROOT;
                                                                        String strO8 = cq.o(locale8, string7, locale8);
                                                                        if (!ge1.c.a(str)) {
                                                                            if (ge1.d.a(str)) {
                                                                                str5 = "device.screenshot";
                                                                            } else if (ge1.e.a(str)) {
                                                                                str5 = "device.lock";
                                                                            } else if (ge1.f.a(str)) {
                                                                                str5 = "device.volume.up";
                                                                            } else if (ge1.g.a(str)) {
                                                                                str5 = "device.volume.down";
                                                                            } else if (ge1.h.a(str)) {
                                                                                str5 = "device.volume.mute";
                                                                            } else {
                                                                                x42Var = ge1.i;
                                                                                if (x42Var.a(str)) {
                                                                                    fh1VarB = x42.b(x42Var, str);
                                                                                    if (fh1VarB != null) {
                                                                                        obj2 = "level_percent";
                                                                                    } else {
                                                                                        obj2 = "level_percent";
                                                                                    }
                                                                                    str5 = "device.volume.set";
                                                                                } else {
                                                                                    obj2 = "level_percent";
                                                                                    str5 = str4;
                                                                                }
                                                                            }
                                                                            obj2 = "level_percent";
                                                                        } else {
                                                                            if (ge1.d.a(str)) {
                                                                                str5 = "device.screenshot";
                                                                            } else if (ge1.e.a(str)) {
                                                                                str5 = "device.lock";
                                                                            } else if (ge1.f.a(str)) {
                                                                                str5 = "device.volume.up";
                                                                            } else if (ge1.g.a(str)) {
                                                                                str5 = "device.volume.down";
                                                                            } else if (ge1.h.a(str)) {
                                                                                str5 = "device.volume.mute";
                                                                            } else {
                                                                                x42Var = ge1.i;
                                                                                if (x42Var.a(str)) {
                                                                                    fh1VarB = x42.b(x42Var, str);
                                                                                    if (fh1VarB != null) {
                                                                                        obj2 = "level_percent";
                                                                                    } else {
                                                                                        obj2 = "level_percent";
                                                                                    }
                                                                                    str5 = "device.volume.set";
                                                                                } else {
                                                                                    obj2 = "level_percent";
                                                                                    str5 = str4;
                                                                                }
                                                                            }
                                                                            obj2 = "level_percent";
                                                                        }
                                                                        zA2 = ge1.a.a(str);
                                                                        Pattern patternCompile110 = Pattern.compile("\\b(?:sms|text message)\\b", 66);
                                                                        patternCompile110.getClass();
                                                                        zFind = patternCompile110.matcher(str).find();
                                                                        if (wh2.c(new w3("message.whatsapp.send"), new w3("message.sms.confirm_send")).contains(new w3(str5))) {
                                                                            if (zB) {
                                                                                linkedHashMap6.clear();
                                                                                str5 = "message.whatsapp.send";
                                                                            } else if (zFind) {
                                                                                str5 = str3;
                                                                            } else {
                                                                                str5 = "message.whatsapp.draft";
                                                                            }
                                                                        }
                                                                        if (ge1.b.contains(new w3(str5))) {
                                                                            f5VarA3 = null;
                                                                        } else {
                                                                            if (str5.equals("message.compose.choose_channel")) {
                                                                                if (zFind) {
                                                                                    str9 = str3;
                                                                                } else {
                                                                                    str9 = "message.whatsapp.draft";
                                                                                }
                                                                                str5 = str9;
                                                                            }
                                                                            if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.compose.choose_channel")).contains(new w3(str5))) {
                                                                                linkedHashMap6.remove("message_channel");
                                                                                if (zA2) {
                                                                                    linkedHashMap6.put("message_channel", "whatsapp");
                                                                                } else if (zFind) {
                                                                                    linkedHashMap6.put("message_channel", "sms");
                                                                                }
                                                                            }
                                                                            if (str5.equals("device.volume.set")) {
                                                                                str7 = (String) linkedHashMap6.get("level");
                                                                                if (str7 == null) {
                                                                                    str7 = (String) linkedHashMap6.get(obj2);
                                                                                }
                                                                                if (str7 != null) {
                                                                                    Pattern patternCompile111 = Pattern.compile("(\\d{1,3})%?");
                                                                                    patternCompile111.getClass();
                                                                                    Matcher matcher12 = patternCompile111.matcher(str);
                                                                                    matcher12.getClass();
                                                                                    fh1VarA = ty3.a(matcher12, 0, str);
                                                                                    if (fh1VarA != null) {
                                                                                        str8 = (String) mz.z(1, fh1VarA.a());
                                                                                    } else {
                                                                                        str8 = null;
                                                                                    }
                                                                                    if (str8 != null) {
                                                                                        linkedHashMap6.put(obj2, str8);
                                                                                    }
                                                                                } else {
                                                                                    Pattern patternCompile112 = Pattern.compile("(\\d{1,3})%?");
                                                                                    patternCompile112.getClass();
                                                                                    Matcher matcher13 = patternCompile112.matcher(str);
                                                                                    matcher13.getClass();
                                                                                    fh1VarA = ty3.a(matcher13, 0, str);
                                                                                    if (fh1VarA != null) {
                                                                                        str8 = (String) mz.z(1, fh1VarA.a());
                                                                                    } else {
                                                                                        str8 = null;
                                                                                    }
                                                                                    if (str8 != null) {
                                                                                        linkedHashMap6.put(obj2, str8);
                                                                                    }
                                                                                }
                                                                            }
                                                                            f5Var3 = new f5(str5, linkedHashMap6, 0.95f, q21.c, str);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        f5VarA3 = f5VarA4;
                                                    }
                                                    f5VarA3 = f5Var3;
                                                }
                                            }
                                        }
                                    }
                                }
                                f5VarA3 = f5VarA5;
                                py0Var = py0Var2;
                            }
                            f5VarA3 = f5VarA6;
                            py0Var = py0Var2;
                        }
                        if (f5VarA3 == null) {
                            JSONObject jSONObjectPut15 = new JSONObject().put("status", "FAILED").put("retryable", false).put("spoken", "I couldn't match that request to a supported action.");
                            jSONObjectPut15.getClass();
                            return jSONObjectPut15;
                        }
                        f5VarA7 = f5VarA3;
                    }
                    j2 = j;
                    rs0Var2 = new rs0(j2, f5VarA7.a, bh1.h(f5VarA7.b));
                    linkedHashMap3 = linkedHashMap;
                    jSONObject3 = (JSONObject) linkedHashMap3.get(rs0Var2);
                    if (jSONObject3 != null) {
                        if (!cs2.A(strOptString)) {
                            py0Var.i(jSONObject3, strOptString);
                        }
                        return jSONObject3;
                    }
                    l90 l90Var2 = new l90(1, new gn2(f5VarA7, in2Var, (x50) null));
                    rs0Var = rs0Var2;
                    l90VarL = l90Var2;
                    mt0Var = this;
                    t42Var = t42Var4;
                    ht0Var = new ht0(mt0Var, hq0Var, t42Var, 0);
                    ft0Var2 = ft0Var;
                    ft0Var2.e = strOptString;
                    ft0Var2.f = t42Var;
                    ft0Var2.i = rs0Var;
                    ft0Var2.j = j2;
                    z3 = zM;
                    ft0Var2.k = z3;
                    ft0Var2.t = 1;
                    if (l90VarL.a(ht0Var, ft0Var2) == t70Var) {
                        return t70Var;
                    }
                    str2 = strOptString;
                    t42Var2 = t42Var;
                } else {
                    mt0Var = this;
                }
                t42Var4 = t42Var4;
                ft0Var = ft0Var;
                str19 = "error";
                zM = zM;
                linkedHashMap3 = linkedHashMap;
                rs0Var = null;
                py0Var = py0Var2;
                j2 = j;
                l90VarL = mt0Var.e.l(str, c63.b, ii0.a);
                t42Var = t42Var4;
                ht0Var = new ht0(mt0Var, hq0Var, t42Var, 0);
                ft0Var2 = ft0Var;
                ft0Var2.e = strOptString;
                ft0Var2.f = t42Var;
                ft0Var2.i = rs0Var;
                ft0Var2.j = j2;
                z3 = zM;
                ft0Var2.k = z3;
                ft0Var2.t = 1;
                if (l90VarL.a(ht0Var, ft0Var2) == t70Var) {
                    return t70Var;
                }
                str2 = strOptString;
                t42Var2 = t42Var;
            }
        } else {
            if (i == 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            boolean z5 = ft0Var.k;
            long j4 = ft0Var.j;
            rs0 rs0Var4 = ft0Var.i;
            t42Var2 = ft0Var.f;
            String str24 = ft0Var.e;
            bz3.g(obj);
            z3 = z5;
            rs0Var = rs0Var4;
            str19 = "error";
            mt0Var = this;
            str2 = str24;
            py0Var = py0Var2;
            j2 = j4;
            linkedHashMap3 = linkedHashMap;
        }
        z4Var = (z4) t42Var2.a;
        if (z4Var == null) {
            JSONObject jSONObjectPut16 = new JSONObject().put(str19, "No action outcome");
            jSONObjectPut16.getClass();
            return jSONObjectPut16;
        }
        jSONObjectK = k(z4Var);
        str2.getClass();
        if (!cs2.A(str2)) {
            py0Var.i(jSONObjectK, str2);
        }
        if (z4Var.b == null) {
            mt0Var.Y = new wt1(new Long(j2), jSONObjectK);
        } else {
            mt0Var.Y = new wt1(new Long(j2), jSONObjectK);
        }
        if (rs0Var != null) {
            linkedHashMap3.put(rs0Var, jSONObjectK);
        }
        while (linkedHashMap3.size() > 64) {
            Set setKeySet2 = linkedHashMap3.keySet();
            setKeySet2.getClass();
            linkedHashMap3.remove(mz.w(setKeySet2));
        }
        return jSONObjectK;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0138  */
    /* JADX WARN: Code duplicated, block: B:37:0x017e  */
    /* JADX WARN: Code duplicated, block: B:39:0x018b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0190 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object i(JSONObject jSONObject, String str, long j, hq0 hq0Var, f5 f5Var, boolean z, y50 y50Var) throws JSONException {
        it0 it0Var;
        String str2;
        long j2;
        hq0 hq0Var2;
        boolean z2;
        boolean z3;
        boolean z4;
        JSONObject jSONObject2;
        String str3;
        z4 z4Var;
        String str4;
        hk2 hk2Var;
        long j3;
        z4 z4Var2;
        String str5;
        JSONObject jSONObject3;
        hq0 hq0Var3;
        String str6;
        JSONObject jSONObjectPut;
        String strOptString;
        if (y50Var instanceof it0) {
            it0Var = (it0) y50Var;
            int i = it0Var.x;
            if ((i & Integer.MIN_VALUE) != 0) {
                it0Var.x = i - Integer.MIN_VALUE;
            } else {
                it0Var = new it0(this, y50Var);
            }
        } else {
            it0Var = new it0(this, y50Var);
        }
        it0 it0Var2 = it0Var;
        Object objH = it0Var2.v;
        Object obj = t70.a;
        int i2 = it0Var2.x;
        try {
            if (i2 == 0) {
                bz3.g(objH);
                boolean zM = this.e.m();
                boolean zContains = this.a0.contains(new Long(j));
                try {
                    it0Var2.e = jSONObject;
                    it0Var2.f = str;
                    it0Var2.i = hq0Var;
                    it0Var2.n = j;
                    it0Var2.s = z;
                    it0Var2.t = zM;
                    it0Var2.u = zContains;
                    it0Var2.x = 1;
                    objH = h(jSONObject, str, j, hq0Var, f5Var, z, it0Var2);
                    if (objH != obj) {
                        str3 = str;
                        j2 = j;
                        hq0Var2 = hq0Var;
                        z2 = z;
                        z3 = zM;
                        z4 = zContains;
                        jSONObject2 = jSONObject;
                    }
                } catch (Exception e) {
                    e = e;
                    str2 = str;
                    j2 = j;
                    hq0Var2 = hq0Var;
                    z2 = z;
                    z3 = zM;
                    z4 = zContains;
                    jSONObject2 = jSONObject;
                    Log.w("SonicLive", "Phone action failed: ".concat(e.getClass().getSimpleName()));
                    this.a0.add(new Long(j2));
                    str4 = str2;
                    z4Var = new z4(new l5(str2, e33.b, "I couldn't verify that action completed. Please check its result before trying again.", null, null, null, null, null, null, null, e.getClass().getSimpleName(), 2040), (rv1) this.e.g.e.a.getValue());
                    hk2Var = this.m;
                    it0Var2.e = jSONObject2;
                    it0Var2.f = str4;
                    it0Var2.i = hq0Var2;
                    it0Var2.j = "I couldn't verify that action completed. Please check its result before trying again.";
                    it0Var2.k = z4Var;
                    it0Var2.n = j2;
                    it0Var2.s = z2;
                    it0Var2.t = z3;
                    it0Var2.u = z4;
                    it0Var2.x = 2;
                    if (hk2Var.n(z4Var, it0Var2) != obj) {
                        j3 = j2;
                        z4Var2 = z4Var;
                        str5 = str4;
                        jSONObject3 = jSONObject2;
                        hq0Var3 = hq0Var2;
                        str6 = "I couldn't verify that action completed. Please check its result before trying again.";
                        hq0Var3.j(z4Var2);
                        jSONObjectPut = new JSONObject().put("status", "PARTIAL").put("verified", false).put("retryable", false).put("reason_code", "ACTION_EXCEPTION").put("spoken", str6);
                        py0 py0Var = this.X;
                        String strOptString2 = jSONObject3.optString("id");
                        strOptString2.getClass();
                        jSONObjectPut.getClass();
                        py0Var.i(jSONObjectPut, strOptString2);
                        j2 = j3;
                        str3 = str5;
                        if (!this.v) {
                            strOptString = jSONObjectPut.optString("spoken");
                            strOptString.getClass();
                            if (!cs2.A(strOptString)) {
                                this.x = false;
                                if (z3) {
                                    this.B.c(new j(23));
                                }
                                this.C.put(new Long(j2), new Long(this.B.d("connection-" + this.K + "-input-" + j2, str3, jSONObjectPut).a));
                            }
                        }
                        jSONObjectPut.getClass();
                        return jSONObjectPut;
                    }
                }
                return obj;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                z4 = it0Var2.u;
                z3 = it0Var2.t;
                j3 = it0Var2.n;
                z4Var2 = it0Var2.k;
                str6 = it0Var2.j;
                hq0Var3 = it0Var2.i;
                str5 = it0Var2.f;
                jSONObject3 = it0Var2.e;
                bz3.g(objH);
                hq0Var3.j(z4Var2);
                jSONObjectPut = new JSONObject().put("status", "PARTIAL").put("verified", false).put("retryable", false).put("reason_code", "ACTION_EXCEPTION").put("spoken", str6);
                py0 py0Var2 = this.X;
                String strOptString3 = jSONObject3.optString("id");
                strOptString3.getClass();
                jSONObjectPut.getClass();
                py0Var2.i(jSONObjectPut, strOptString3);
                j2 = j3;
                str3 = str5;
                if (!this.v) {
                    strOptString = jSONObjectPut.optString("spoken");
                    strOptString.getClass();
                    if (!cs2.A(strOptString)) {
                        this.x = false;
                        if (z3 && !z4) {
                            this.B.c(new j(23));
                        }
                        this.C.put(new Long(j2), new Long(this.B.d("connection-" + this.K + "-input-" + j2, str3, jSONObjectPut).a));
                    }
                }
                jSONObjectPut.getClass();
                return jSONObjectPut;
            }
            z4 = it0Var2.u;
            z3 = it0Var2.t;
            z2 = it0Var2.s;
            j2 = it0Var2.n;
            hq0Var2 = it0Var2.i;
            str3 = it0Var2.f;
            jSONObject2 = it0Var2.e;
            try {
                bz3.g(objH);
            } catch (Exception e2) {
                e = e2;
                str2 = str3;
                Log.w("SonicLive", "Phone action failed: ".concat(e.getClass().getSimpleName()));
                this.a0.add(new Long(j2));
                str4 = str2;
                z4Var = new z4(new l5(str2, e33.b, "I couldn't verify that action completed. Please check its result before trying again.", null, null, null, null, null, null, null, e.getClass().getSimpleName(), 2040), (rv1) this.e.g.e.a.getValue());
                hk2Var = this.m;
                it0Var2.e = jSONObject2;
                it0Var2.f = str4;
                it0Var2.i = hq0Var2;
                it0Var2.j = "I couldn't verify that action completed. Please check its result before trying again.";
                it0Var2.k = z4Var;
                it0Var2.n = j2;
                it0Var2.s = z2;
                it0Var2.t = z3;
                it0Var2.u = z4;
                it0Var2.x = 2;
                if (hk2Var.n(z4Var, it0Var2) != obj) {
                    j3 = j2;
                    z4Var2 = z4Var;
                    str5 = str4;
                    jSONObject3 = jSONObject2;
                    hq0Var3 = hq0Var2;
                    str6 = "I couldn't verify that action completed. Please check its result before trying again.";
                    hq0Var3.j(z4Var2);
                    jSONObjectPut = new JSONObject().put("status", "PARTIAL").put("verified", false).put("retryable", false).put("reason_code", "ACTION_EXCEPTION").put("spoken", str6);
                    py0 py0Var3 = this.X;
                    String strOptString4 = jSONObject3.optString("id");
                    strOptString4.getClass();
                    jSONObjectPut.getClass();
                    py0Var3.i(jSONObjectPut, strOptString4);
                    j2 = j3;
                    str3 = str5;
                }
                return obj;
            }
            this.a0.add(new Long(j2));
            jSONObjectPut = (JSONObject) objH;
            if (!this.v) {
                strOptString = jSONObjectPut.optString("spoken");
                strOptString.getClass();
                if (!cs2.A(strOptString)) {
                    this.x = false;
                    if (z3) {
                        this.B.c(new j(23));
                    }
                    this.C.put(new Long(j2), new Long(this.B.d("connection-" + this.K + "-input-" + j2, str3, jSONObjectPut).a));
                }
            }
            jSONObjectPut.getClass();
            return jSONObjectPut;
        } catch (CancellationException e3) {
            throw e3;
        }
    }

    public final void j() {
        Object value;
        synchronized (this.U) {
            this.T++;
            un unVar = this.W;
            if (unVar != null) {
                do {
                } while (!(unVar.p() instanceof lx));
            }
            try {
                wd1 wd1Var = this.V;
                if (wd1Var != null) {
                    synchronized (wd1Var.b) {
                        try {
                            wd1Var.a.C();
                            wd1Var.f();
                        } catch (Throwable th) {
                            wd1Var.f();
                            throw th;
                        }
                    }
                } else {
                    AudioTrack audioTrack = this.s;
                    if (audioTrack != null) {
                        audioTrack.pause();
                    }
                    AudioTrack audioTrack2 = this.s;
                    if (audioTrack2 != null) {
                        audioTrack2.flush();
                    }
                }
            } catch (Throwable unused) {
            }
        }
        jr2 jr2Var = this.k;
        do {
            value = jr2Var.getValue();
        } while (!jr2Var.h(value, ee1.a((ee1) value, false, null, "", null, 53)));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ef A[Catch: all -> 0x003a, TryCatch #1 {all -> 0x003a, blocks: (B:13:0x0035, B:33:0x00dd, B:35:0x00e3, B:38:0x00ef, B:39:0x00fb, B:40:0x011d, B:42:0x0137, B:44:0x013b), top: B:54:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x013b A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #1 {all -> 0x003a, blocks: (B:13:0x0035, B:33:0x00dd, B:35:0x00e3, B:38:0x00ef, B:39:0x00fb, B:40:0x011d, B:42:0x0137, B:44:0x013b), top: B:54:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object l(fq0 fq0Var, hq0 hq0Var, y50 y50Var) throws Throwable {
        jt0 jt0Var;
        int i;
        long j;
        rv1 rv1Var;
        an1 an1Var;
        fq0 fq0Var2;
        hq0 hq0Var2;
        an1 an1Var2;
        rv1 rv1Var2;
        long j2;
        t42 t42Var;
        z4 z4Var;
        jr2 jr2Var;
        Object value;
        ym ymVar;
        if (y50Var instanceof jt0) {
            jt0Var = (jt0) y50Var;
            int i2 = jt0Var.v;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                jt0Var.v = i2 - Integer.MIN_VALUE;
            } else {
                jt0Var = new jt0(this, y50Var);
            }
        } else {
            jt0Var = new jt0(this, y50Var);
        }
        Object obj = jt0Var.t;
        t70 t70Var = t70.a;
        int i3 = jt0Var.v;
        try {
            if (i3 == 0) {
                bz3.g(obj);
                i = 0;
                this.x = false;
                j();
                this.f.c();
                j = this.M.get();
                rv1Var = (rv1) this.e.g.e.a.getValue();
                an1Var = this.p;
                fq0Var2 = fq0Var;
                jt0Var.e = fq0Var2;
                jt0Var.f = (gr0) hq0Var;
                jt0Var.i = rv1Var;
                jt0Var.j = an1Var;
                jt0Var.n = j;
                jt0Var.s = 0;
                jt0Var.v = 1;
                if (an1Var.e(jt0Var) != t70Var) {
                    hq0Var2 = hq0Var;
                }
                return t70Var;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                j2 = jt0Var.n;
                t42Var = jt0Var.k;
                an1Var2 = jt0Var.j;
                rv1Var2 = jt0Var.i;
                try {
                    bz3.g(obj);
                    z4Var = (z4) t42Var.a;
                    if (z4Var != null && j2 == this.M.get()) {
                        if (rv1Var2 != null) {
                            this.B.c(new j(25));
                        }
                        zd1 zd1Var = this.B;
                        long j3 = this.L + 1;
                        this.L = j3;
                        zd1Var.d("ui-" + j3, z4Var.a.a, k(z4Var));
                        jr2Var = this.k;
                        do {
                            value = jr2Var.getValue();
                        } while (!jr2Var.h(value, ee1.a((ee1) value, false, null, z4Var.a.c, null, 55)));
                        ymVar = this.I;
                        if (ymVar != null) {
                            ymVar.a();
                        }
                    }
                    an1Var = an1Var2;
                    an1Var.h(null);
                    return q43.a;
                } catch (Throwable th) {
                    th = th;
                    an1Var2.h(null);
                    throw th;
                }
            }
            i = jt0Var.s;
            j = jt0Var.n;
            an1Var = jt0Var.j;
            rv1 rv1Var3 = jt0Var.i;
            hq0 hq0Var3 = (hq0) jt0Var.f;
            fq0 fq0Var3 = jt0Var.e;
            bz3.g(obj);
            rv1Var = rv1Var3;
            fq0Var2 = fq0Var3;
            hq0Var2 = hq0Var3;
            if (j == this.M.get() && rv1Var == this.e.g.e.a.getValue()) {
                t42 t42Var2 = new t42();
                mm0 mm0Var = (mm0) fq0Var2.a();
                ht0 ht0Var = new ht0(this, hq0Var2, t42Var2, 1);
                jt0Var.e = null;
                jt0Var.f = null;
                jt0Var.i = rv1Var;
                jt0Var.j = an1Var;
                jt0Var.k = t42Var2;
                jt0Var.n = j;
                jt0Var.s = i;
                jt0Var.v = 2;
                if (mm0Var.a(ht0Var, jt0Var) != t70Var) {
                    rv1Var2 = rv1Var;
                    j2 = j;
                    an1Var2 = an1Var;
                    t42Var = t42Var2;
                    z4Var = (z4) t42Var.a;
                    if (z4Var != null) {
                        if (rv1Var2 != null) {
                            this.B.c(new j(25));
                        }
                        zd1 zd1Var2 = this.B;
                        long j4 = this.L + 1;
                        this.L = j4;
                        zd1Var2.d("ui-" + j4, z4Var.a.a, k(z4Var));
                        jr2Var = this.k;
                        do {
                            value = jr2Var.getValue();
                        } while (!jr2Var.h(value, ee1.a((ee1) value, false, null, z4Var.a.c, null, 55)));
                        ymVar = this.I;
                        if (ymVar != null) {
                            ymVar.a();
                        }
                    }
                    an1Var = an1Var2;
                }
                return t70Var;
            }
            an1Var.h(null);
            return q43.a;
        } catch (Throwable th2) {
            th = th2;
            an1Var2 = an1Var;
            an1Var2.h(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x039e A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:99:0x0392, B:101:0x039e, B:105:0x03e1, B:108:0x03ec, B:112:0x03f3, B:114:0x03f7, B:119:0x0402, B:131:0x0424, B:129:0x041f, B:130:0x0422, B:133:0x0442, B:134:0x044e, B:136:0x0454, B:141:0x0468, B:144:0x0471, B:148:0x04f2, B:150:0x04ff, B:152:0x0503, B:154:0x0507, B:157:0x0541, B:18:0x0081, B:24:0x00be, B:27:0x00fb, B:31:0x0139), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:104:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:107:0x03e9 A[PHI: r0 r14
      0x03e9: PHI (r0v14 mt0) = (r0v19 mt0), (r0v35 mt0) binds: [B:106:0x03e7, B:100:0x039c] A[DONT_GENERATE, DONT_INLINE]
      0x03e9: PHI (r14v9 an1) = (r14v13 an1), (r14v14 an1) binds: [B:106:0x03e7, B:100:0x039c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:108:0x03ec A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:99:0x0392, B:101:0x039e, B:105:0x03e1, B:108:0x03ec, B:112:0x03f3, B:114:0x03f7, B:119:0x0402, B:131:0x0424, B:129:0x041f, B:130:0x0422, B:133:0x0442, B:134:0x044e, B:136:0x0454, B:141:0x0468, B:144:0x0471, B:148:0x04f2, B:150:0x04ff, B:152:0x0503, B:154:0x0507, B:157:0x0541, B:18:0x0081, B:24:0x00be, B:27:0x00fb, B:31:0x0139), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:111:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:114:0x03f7 A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:99:0x0392, B:101:0x039e, B:105:0x03e1, B:108:0x03ec, B:112:0x03f3, B:114:0x03f7, B:119:0x0402, B:131:0x0424, B:129:0x041f, B:130:0x0422, B:133:0x0442, B:134:0x044e, B:136:0x0454, B:141:0x0468, B:144:0x0471, B:148:0x04f2, B:150:0x04ff, B:152:0x0503, B:154:0x0507, B:157:0x0541, B:18:0x0081, B:24:0x00be, B:27:0x00fb, B:31:0x0139), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:119:0x0402 A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:99:0x0392, B:101:0x039e, B:105:0x03e1, B:108:0x03ec, B:112:0x03f3, B:114:0x03f7, B:119:0x0402, B:131:0x0424, B:129:0x041f, B:130:0x0422, B:133:0x0442, B:134:0x044e, B:136:0x0454, B:141:0x0468, B:144:0x0471, B:148:0x04f2, B:150:0x04ff, B:152:0x0503, B:154:0x0507, B:157:0x0541, B:18:0x0081, B:24:0x00be, B:27:0x00fb, B:31:0x0139), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0411  */
    /* JADX WARN: Code duplicated, block: B:130:0x0422 A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:99:0x0392, B:101:0x039e, B:105:0x03e1, B:108:0x03ec, B:112:0x03f3, B:114:0x03f7, B:119:0x0402, B:131:0x0424, B:129:0x041f, B:130:0x0422, B:133:0x0442, B:134:0x044e, B:136:0x0454, B:141:0x0468, B:144:0x0471, B:148:0x04f2, B:150:0x04ff, B:152:0x0503, B:154:0x0507, B:157:0x0541, B:18:0x0081, B:24:0x00be, B:27:0x00fb, B:31:0x0139), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0442 A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:99:0x0392, B:101:0x039e, B:105:0x03e1, B:108:0x03ec, B:112:0x03f3, B:114:0x03f7, B:119:0x0402, B:131:0x0424, B:129:0x041f, B:130:0x0422, B:133:0x0442, B:134:0x044e, B:136:0x0454, B:141:0x0468, B:144:0x0471, B:148:0x04f2, B:150:0x04ff, B:152:0x0503, B:154:0x0507, B:157:0x0541, B:18:0x0081, B:24:0x00be, B:27:0x00fb, B:31:0x0139), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0454 A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:99:0x0392, B:101:0x039e, B:105:0x03e1, B:108:0x03ec, B:112:0x03f3, B:114:0x03f7, B:119:0x0402, B:131:0x0424, B:129:0x041f, B:130:0x0422, B:133:0x0442, B:134:0x044e, B:136:0x0454, B:141:0x0468, B:144:0x0471, B:148:0x04f2, B:150:0x04ff, B:152:0x0503, B:154:0x0507, B:157:0x0541, B:18:0x0081, B:24:0x00be, B:27:0x00fb, B:31:0x0139), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x046e  */
    /* JADX WARN: Code duplicated, block: B:144:0x0471 A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:99:0x0392, B:101:0x039e, B:105:0x03e1, B:108:0x03ec, B:112:0x03f3, B:114:0x03f7, B:119:0x0402, B:131:0x0424, B:129:0x041f, B:130:0x0422, B:133:0x0442, B:134:0x044e, B:136:0x0454, B:141:0x0468, B:144:0x0471, B:148:0x04f2, B:150:0x04ff, B:152:0x0503, B:154:0x0507, B:157:0x0541, B:18:0x0081, B:24:0x00be, B:27:0x00fb, B:31:0x0139), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:147:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:150:0x04ff A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:99:0x0392, B:101:0x039e, B:105:0x03e1, B:108:0x03ec, B:112:0x03f3, B:114:0x03f7, B:119:0x0402, B:131:0x0424, B:129:0x041f, B:130:0x0422, B:133:0x0442, B:134:0x044e, B:136:0x0454, B:141:0x0468, B:144:0x0471, B:148:0x04f2, B:150:0x04ff, B:152:0x0503, B:154:0x0507, B:157:0x0541, B:18:0x0081, B:24:0x00be, B:27:0x00fb, B:31:0x0139), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x055a  */
    /* JADX WARN: Code duplicated, block: B:164:0x055d  */
    /* JADX WARN: Code duplicated, block: B:168:0x058c  */
    /* JADX WARN: Code duplicated, block: B:173:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:175:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:183:0x0349 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x0466 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x018f A[PHI: r1 r3 r5 r6 r7 r10 r11 r12
      0x018f: PHI (r1v29 java.lang.Object) = (r1v24 java.lang.Object), (r1v41 java.lang.Object) binds: [B:74:0x02c7, B:39:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r3v16 int) = (r3v12 int), (r3v21 int) binds: [B:74:0x02c7, B:39:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r5v21 int) = (r5v19 int), (r5v22 int) binds: [B:74:0x02c7, B:39:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r6v12 g5) = (r6v10 g5), (r6v15 g5) binds: [B:74:0x02c7, B:39:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r7v8 hq0) = (r7v6 hq0), (r7v10 hq0) binds: [B:74:0x02c7, B:39:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r10v11 an1) = (r10v9 an1), (r10v12 an1) binds: [B:74:0x02c7, B:39:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r11v6 hq0) = (r11v4 hq0), (r11v8 hq0) binds: [B:74:0x02c7, B:39:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r12v3 long) = (r12v1 long), (r12v5 long) binds: [B:74:0x02c7, B:39:0x018b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x0215 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:13:0x0044, B:169:0x0597, B:176:0x05cb, B:161:0x0554, B:165:0x055f, B:174:0x05ae, B:35:0x016a, B:89:0x0337, B:38:0x0188, B:76:0x02cb, B:78:0x02d0, B:81:0x02d9, B:84:0x02e5, B:85:0x0300, B:177:0x05e8, B:42:0x01a4, B:70:0x028d, B:72:0x0293, B:73:0x02ae, B:45:0x01bb, B:67:0x026a, B:48:0x01d3, B:63:0x024a, B:55:0x020f, B:57:0x0215, B:59:0x0220), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0220 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:13:0x0044, B:169:0x0597, B:176:0x05cb, B:161:0x0554, B:165:0x055f, B:174:0x05ae, B:35:0x016a, B:89:0x0337, B:38:0x0188, B:76:0x02cb, B:78:0x02d0, B:81:0x02d9, B:84:0x02e5, B:85:0x0300, B:177:0x05e8, B:42:0x01a4, B:70:0x028d, B:72:0x0293, B:73:0x02ae, B:45:0x01bb, B:67:0x026a, B:48:0x01d3, B:63:0x024a, B:55:0x020f, B:57:0x0215, B:59:0x0220), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0242  */
    /* JADX WARN: Code duplicated, block: B:62:0x0244  */
    /* JADX WARN: Code duplicated, block: B:65:0x0263  */
    /* JADX WARN: Code duplicated, block: B:66:0x0265  */
    /* JADX WARN: Code duplicated, block: B:69:0x028b  */
    /* JADX WARN: Code duplicated, block: B:70:0x028d A[Catch: all -> 0x0063, PHI: r1 r3 r5 r6 r7 r10 r11 r12
      0x028d: PHI (r1v20 java.lang.Object) = (r1v17 java.lang.Object), (r1v28 java.lang.Object) binds: [B:68:0x0289, B:43:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x028d: PHI (r3v12 int) = (r3v9 int), (r3v15 int) binds: [B:68:0x0289, B:43:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x028d: PHI (r5v19 int) = (r5v16 int), (r5v20 int) binds: [B:68:0x0289, B:43:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x028d: PHI (r6v10 g5) = (r6v7 g5), (r6v11 g5) binds: [B:68:0x0289, B:43:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x028d: PHI (r7v6 hq0) = (r7v4 hq0), (r7v7 hq0) binds: [B:68:0x0289, B:43:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x028d: PHI (r10v9 an1) = (r10v7 an1), (r10v10 an1) binds: [B:68:0x0289, B:43:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x028d: PHI (r11v4 hq0) = (r11v2 hq0), (r11v5 hq0) binds: [B:68:0x0289, B:43:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x028d: PHI (r12v1 long) = (r12v0 long), (r12v2 long) binds: [B:68:0x0289, B:43:0x01a7] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0063, blocks: (B:13:0x0044, B:169:0x0597, B:176:0x05cb, B:161:0x0554, B:165:0x055f, B:174:0x05ae, B:35:0x016a, B:89:0x0337, B:38:0x0188, B:76:0x02cb, B:78:0x02d0, B:81:0x02d9, B:84:0x02e5, B:85:0x0300, B:177:0x05e8, B:42:0x01a4, B:70:0x028d, B:72:0x0293, B:73:0x02ae, B:45:0x01bb, B:67:0x026a, B:48:0x01d3, B:63:0x024a, B:55:0x020f, B:57:0x0215, B:59:0x0220), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0293 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:13:0x0044, B:169:0x0597, B:176:0x05cb, B:161:0x0554, B:165:0x055f, B:174:0x05ae, B:35:0x016a, B:89:0x0337, B:38:0x0188, B:76:0x02cb, B:78:0x02d0, B:81:0x02d9, B:84:0x02e5, B:85:0x0300, B:177:0x05e8, B:42:0x01a4, B:70:0x028d, B:72:0x0293, B:73:0x02ae, B:45:0x01bb, B:67:0x026a, B:48:0x01d3, B:63:0x024a, B:55:0x020f, B:57:0x0215, B:59:0x0220), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x02ae A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:13:0x0044, B:169:0x0597, B:176:0x05cb, B:161:0x0554, B:165:0x055f, B:174:0x05ae, B:35:0x016a, B:89:0x0337, B:38:0x0188, B:76:0x02cb, B:78:0x02d0, B:81:0x02d9, B:84:0x02e5, B:85:0x0300, B:177:0x05e8, B:42:0x01a4, B:70:0x028d, B:72:0x0293, B:73:0x02ae, B:45:0x01bb, B:67:0x026a, B:48:0x01d3, B:63:0x024a, B:55:0x020f, B:57:0x0215, B:59:0x0220), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:78:0x02d0 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:13:0x0044, B:169:0x0597, B:176:0x05cb, B:161:0x0554, B:165:0x055f, B:174:0x05ae, B:35:0x016a, B:89:0x0337, B:38:0x0188, B:76:0x02cb, B:78:0x02d0, B:81:0x02d9, B:84:0x02e5, B:85:0x0300, B:177:0x05e8, B:42:0x01a4, B:70:0x028d, B:72:0x0293, B:73:0x02ae, B:45:0x01bb, B:67:0x026a, B:48:0x01d3, B:63:0x024a, B:55:0x020f, B:57:0x0215, B:59:0x0220), top: B:182:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:95:0x034d A[Catch: all -> 0x05a9, TRY_LEAVE, TryCatch #1 {all -> 0x05a9, blocks: (B:93:0x0349, B:95:0x034d), top: B:183:0x0349 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x037b  */
    /* JADX WARN: Multi-variable type inference failed */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:168:0x058c -> B:169:0x0597). Please report as a decompilation issue!!! */
    public final Object m(n90 n90Var, o0 o0Var, y50 y50Var) throws Throwable {
        lt0 lt0Var;
        an1 an1Var;
        hq0 hq0Var;
        hq0 hq0Var2;
        an1 an1Var2;
        int i;
        Object objC;
        int i2;
        Object obj;
        hq0 hq0Var3;
        hq0 hq0Var4;
        int i3;
        be1 be1Var;
        g5 g5Var;
        Object objI;
        hq0 hq0Var5;
        g5 g5Var2;
        Object obj2;
        hq0 hq0Var6;
        int i4;
        long jLongValue;
        Object objC2;
        Object objE;
        hq0 hq0Var7;
        g5 g5Var3;
        String str;
        Object obj3;
        int i5;
        Object obj4;
        int i6;
        hq0 hq0Var8;
        long j;
        hq0 hq0Var9;
        Set linkedHashSet;
        hq0 hq0Var10;
        an1 an1Var3;
        int i7;
        int i8;
        g5 g5Var4;
        int i9;
        int i10;
        Object obj5;
        String str2;
        g5 g5Var5;
        an1 an1Var4;
        hq0 hq0Var11;
        int i11;
        Object obj6;
        Set set;
        lt0 lt0Var2;
        long j2;
        int i12;
        int i13;
        Object obj7;
        long j3;
        hq0 hq0Var12;
        Object obj8;
        int i14;
        hq0 hq0Var13;
        g5 g5Var6;
        Set set2;
        int i15;
        lt0 lt0Var3;
        String str3;
        int i16;
        int i17;
        int i18;
        String str4;
        Object obj9;
        Set set3;
        int i19;
        boolean z;
        String str5;
        long j4;
        hq0 hq0Var14;
        int i20;
        int i21;
        long j5;
        hq0 hq0Var15;
        int i22;
        hq0 hq0Var16;
        Set set4;
        int i23;
        g5 g5Var7;
        an1 an1Var5;
        long j6;
        Set set5;
        boolean z2;
        hq0 hq0Var17;
        Object objA;
        Set set6;
        Object obj10;
        hq0 hq0Var18;
        be1 be1Var2;
        Object obj11;
        Object obj12;
        pd1 pd1Var;
        List list;
        Object obj13;
        Iterator it;
        Object next;
        String str6;
        Object objE2;
        int iOrdinal;
        dd1 dd1Var;
        long j7;
        Set set7;
        hq0 hq0Var19;
        Object objC3;
        String str7;
        Object objI2;
        mt0 mt0Var = this;
        Object obj14 = t70.a;
        dd1 dd1Var2 = dd1.b;
        if (y50Var instanceof lt0) {
            lt0Var = (lt0) y50Var;
            int i24 = lt0Var.Z;
            if ((i24 & Integer.MIN_VALUE) != 0) {
                lt0Var.Z = i24 - Integer.MIN_VALUE;
            } else {
                lt0Var = new lt0(mt0Var, y50Var);
            }
        } else {
            lt0Var = new lt0(mt0Var, y50Var);
        }
        Object obj15 = lt0Var.X;
        try {
            try {
                switch (lt0Var.Z) {
                    case 0:
                        bz3.g(obj15);
                        an1 an1Var6 = mt0Var.o;
                        hq0Var = n90Var;
                        lt0Var.e = hq0Var;
                        hq0Var2 = o0Var;
                        lt0Var.f = hq0Var2;
                        lt0Var.i = an1Var6;
                        lt0Var.u = 0;
                        lt0Var.Z = 1;
                        if (an1Var6.e(lt0Var) != obj14) {
                            an1Var2 = an1Var6;
                            i = 0;
                            if (!mt0Var.j.d) {
                                be1Var = new be1(null, 27);
                            } else {
                                mt0Var.v = false;
                                mt0Var.w = false;
                                mt0Var.x = false;
                                mt0Var.J = true;
                                j5 j5Var = mt0Var.d;
                                lt0Var.e = hq0Var;
                                lt0Var.f = hq0Var2;
                                lt0Var.i = an1Var2;
                                lt0Var.u = i;
                                lt0Var.v = 0;
                                lt0Var.Z = 2;
                                objC = rn4.c(j5Var.b, lt0Var);
                                if (objC == obj14) {
                                    hq0 hq0Var20 = hq0Var2;
                                    i2 = i;
                                    obj = objC;
                                    hq0Var3 = hq0Var20;
                                    hq0Var4 = hq0Var;
                                    i3 = 0;
                                    g5Var = (g5) obj;
                                    f0 f0Var = mt0Var.c;
                                    lt0Var.e = hq0Var4;
                                    lt0Var.f = hq0Var3;
                                    lt0Var.i = an1Var2;
                                    lt0Var.j = g5Var;
                                    lt0Var.u = i2;
                                    lt0Var.v = i3;
                                    lt0Var.Z = 3;
                                    objI = f0Var.i(lt0Var);
                                    if (objI != obj14) {
                                        hq0Var5 = hq0Var4;
                                        g5Var2 = g5Var;
                                        obj2 = objI;
                                        hq0Var6 = hq0Var3;
                                        i4 = i2;
                                        jLongValue = ((Number) obj2).longValue();
                                        f0 f0Var2 = mt0Var.c;
                                        lt0Var.e = hq0Var5;
                                        lt0Var.f = hq0Var6;
                                        lt0Var.i = an1Var2;
                                        lt0Var.j = g5Var2;
                                        lt0Var.u = i4;
                                        lt0Var.v = i3;
                                        lt0Var.H = jLongValue;
                                        lt0Var.Z = 4;
                                        objC2 = rn4.c(f0Var2.b, lt0Var);
                                        if (objC2 == obj14) {
                                            if (!((o) objC2).a) {
                                                h61 h61Var = mt0Var.b;
                                                lt0Var.e = hq0Var5;
                                                lt0Var.f = hq0Var6;
                                                lt0Var.i = an1Var2;
                                                lt0Var.j = g5Var2;
                                                lt0Var.u = i4;
                                                lt0Var.v = i3;
                                                lt0Var.H = jLongValue;
                                                lt0Var.Z = 5;
                                                objE = h61Var.e("gemini_api_key", lt0Var);
                                                if (objE != obj14) {
                                                    hq0 hq0Var21 = hq0Var5;
                                                    hq0Var7 = hq0Var6;
                                                    g5Var3 = g5Var2;
                                                    str = (String) objE;
                                                    if (str != null || cs2.A(str)) {
                                                        jr2 jr2Var = mt0Var.k;
                                                        ee1 ee1Var = new ee1("Save your Gemini API key in Setup to use Live audio.", 47);
                                                        jr2Var.getClass();
                                                        obj3 = null;
                                                        jr2Var.j(null, ee1Var);
                                                        be1Var = new be1(dd1Var2, 30);
                                                    } else {
                                                        int iA = al4.a(mt0Var.a, "android.permission.RECORD_AUDIO");
                                                        jr2 jr2Var2 = mt0Var.k;
                                                        if (iA != 0) {
                                                            ee1 ee1Var2 = new ee1("Microphone permission is required for Live audio.", 47);
                                                            jr2Var2.getClass();
                                                            jr2Var2.j(null, ee1Var2);
                                                            be1Var = new be1(dd1.e, 30);
                                                        } else {
                                                            ee1 ee1Var3 = new ee1("Connecting", 47);
                                                            jr2Var2.getClass();
                                                            jr2Var2.j(null, ee1Var3);
                                                            ps0 ps0Var = mt0Var.h;
                                                            lt0Var.e = hq0Var21;
                                                            lt0Var.f = hq0Var7;
                                                            lt0Var.i = an1Var2;
                                                            lt0Var.j = g5Var3;
                                                            lt0Var.k = str;
                                                            lt0Var.u = i4;
                                                            lt0Var.v = i3;
                                                            lt0Var.H = jLongValue;
                                                            lt0Var.Z = 6;
                                                            i5 = 0;
                                                            Object objA2 = ps0Var.a(false, lt0Var);
                                                            if (objA2 != obj14) {
                                                                long j8 = jLongValue;
                                                                obj4 = objA2;
                                                                i6 = i3;
                                                                hq0Var8 = hq0Var21;
                                                                j = j8;
                                                                hq0Var9 = hq0Var8;
                                                                linkedHashSet = new LinkedHashSet();
                                                                hq0Var10 = hq0Var7;
                                                                an1Var3 = an1Var2;
                                                                i7 = i4;
                                                                i8 = i5;
                                                                g5Var4 = g5Var3;
                                                                i9 = i6;
                                                                i10 = i8;
                                                                if (i10 >= 4) {
                                                                    try {
                                                                        if (mt0Var.v) {
                                                                            an1Var2 = an1Var3;
                                                                        } else {
                                                                            f0 f0Var3 = mt0Var.c;
                                                                            lt0Var.e = hq0Var9;
                                                                            lt0Var.f = hq0Var10;
                                                                            lt0Var.i = an1Var3;
                                                                            lt0Var.j = g5Var4;
                                                                            lt0Var.k = str;
                                                                            lt0Var.n = obj4;
                                                                            str7 = str;
                                                                            lt0Var.s = linkedHashSet;
                                                                            lt0Var.t = null;
                                                                            lt0Var.u = i7;
                                                                            lt0Var.v = i9;
                                                                            lt0Var.H = j;
                                                                            lt0Var.w = i8;
                                                                            lt0Var.x = i10;
                                                                            lt0Var.Z = 7;
                                                                            objI2 = f0Var3.i(lt0Var);
                                                                            if (objI2 != obj14) {
                                                                                an1Var4 = an1Var3;
                                                                                obj5 = obj4;
                                                                                g5Var5 = g5Var4;
                                                                                set = linkedHashSet;
                                                                                obj6 = objI2;
                                                                                hq0 hq0Var22 = hq0Var10;
                                                                                str2 = str7;
                                                                                lt0 lt0Var4 = lt0Var;
                                                                                i11 = i10;
                                                                                hq0Var11 = hq0Var22;
                                                                                j2 = j;
                                                                                lt0Var2 = lt0Var4;
                                                                                i12 = i9;
                                                                                j7 = j2;
                                                                                if (((Number) obj6).longValue() == j7) {
                                                                                    set7 = set;
                                                                                    f0 f0Var4 = mt0Var.c;
                                                                                    lt0Var2.e = hq0Var9;
                                                                                    lt0Var2.f = hq0Var11;
                                                                                    lt0Var2.i = an1Var4;
                                                                                    lt0Var2.j = g5Var5;
                                                                                    lt0Var2.k = str2;
                                                                                    lt0Var2.n = obj5;
                                                                                    hq0Var19 = hq0Var11;
                                                                                    lt0Var2.s = set7;
                                                                                    lt0Var2.u = i7;
                                                                                    lt0Var2.v = i12;
                                                                                    lt0Var2.H = j7;
                                                                                    lt0Var2.w = i8;
                                                                                    lt0Var2.x = i11;
                                                                                    lt0Var2.Z = 8;
                                                                                    objC3 = rn4.c(f0Var4.b, lt0Var2);
                                                                                    if (objC3 == obj14) {
                                                                                        i13 = i11;
                                                                                        str3 = str2;
                                                                                        i16 = i7;
                                                                                        i15 = i8;
                                                                                        hq0Var12 = hq0Var9;
                                                                                        g5Var6 = g5Var5;
                                                                                        set2 = set7;
                                                                                        obj7 = objC3;
                                                                                        obj8 = obj5;
                                                                                        i14 = i12;
                                                                                        j3 = j7;
                                                                                        lt0Var3 = lt0Var2;
                                                                                        hq0Var13 = hq0Var19;
                                                                                        j4 = j3;
                                                                                        obj11 = obj14;
                                                                                        if (((o) obj7).a) {
                                                                                            if (obj8 instanceof h72) {
                                                                                                obj12 = null;
                                                                                            } else {
                                                                                                obj12 = obj8;
                                                                                            }
                                                                                            pd1Var = (pd1) obj12;
                                                                                            if (pd1Var != null) {
                                                                                                list = pd1Var.b;
                                                                                            } else {
                                                                                                list = null;
                                                                                            }
                                                                                            obj13 = obj8;
                                                                                            if (list == null) {
                                                                                                w30 w30VarB = oj4.b(i72.a(obj13));
                                                                                                iOrdinal = w30VarB.ordinal();
                                                                                                if (iOrdinal != 1 || iOrdinal == 2) {
                                                                                                    dd1Var = dd1.a;
                                                                                                } else if (iOrdinal == 6 || iOrdinal == 7) {
                                                                                                    dd1Var = dd1.c;
                                                                                                } else if (iOrdinal != 9) {
                                                                                                    dd1Var = dd1Var2;
                                                                                                } else {
                                                                                                    dd1Var = dd1.a;
                                                                                                }
                                                                                                jr2 jr2Var3 = mt0Var.k;
                                                                                                ee1 ee1Var4 = new ee1(oj4.d(w30VarB), 47);
                                                                                                jr2Var3.getClass();
                                                                                                jr2Var3.j(null, ee1Var4);
                                                                                                be1Var = new be1(dd1Var, 30);
                                                                                                break;
                                                                                            } else {
                                                                                                it = list.iterator();
                                                                                                do {
                                                                                                    if (it.hasNext()) {
                                                                                                        next = it.next();
                                                                                                    } else {
                                                                                                        next = null;
                                                                                                    }
                                                                                                    str6 = (String) next;
                                                                                                    if (str6 == null) {
                                                                                                        an1Var2 = an1Var4;
                                                                                                    } else {
                                                                                                        set2.add(str6);
                                                                                                        l82 l82Var = g5Var6.a;
                                                                                                        q03 q03Var = g5Var6.b;
                                                                                                        boolean z3 = g5Var6.c;
                                                                                                        b60 b60Var = g5Var6.d;
                                                                                                        String str8 = g5Var6.e;
                                                                                                        boolean z4 = g5Var6.g;
                                                                                                        l61 l61Var = g5Var6.h;
                                                                                                        boolean z5 = g5Var6.i;
                                                                                                        boolean z6 = g5Var6.j;
                                                                                                        boolean z7 = g5Var6.k;
                                                                                                        l61Var.getClass();
                                                                                                        g5 g5Var8 = new g5(l82Var, q03Var, z3, b60Var, str8, str6, z4, l61Var, z5, z6, z7);
                                                                                                        lt0Var3.e = hq0Var12;
                                                                                                        lt0Var3.f = hq0Var13;
                                                                                                        lt0Var3.i = an1Var4;
                                                                                                        lt0Var3.j = g5Var6;
                                                                                                        lt0Var3.k = str3;
                                                                                                        lt0Var3.n = null;
                                                                                                        lt0Var3.s = set2;
                                                                                                        lt0Var3.t = str6;
                                                                                                        lt0Var3.u = i16;
                                                                                                        lt0Var3.v = i14;
                                                                                                        lt0Var3.H = j4;
                                                                                                        lt0Var3.w = i15;
                                                                                                        lt0Var3.x = i13;
                                                                                                        lt0Var3.Z = 9;
                                                                                                        mt0Var = this;
                                                                                                        i19 = 1;
                                                                                                        z = false;
                                                                                                        objE2 = mt0Var.e(g5Var8, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                                                                        obj14 = obj11;
                                                                                                        if (objE2 != obj14) {
                                                                                                            int i25 = i16;
                                                                                                            str4 = str3;
                                                                                                            lt0Var = lt0Var3;
                                                                                                            i18 = i25;
                                                                                                            obj9 = objE2;
                                                                                                            hq0Var14 = hq0Var13;
                                                                                                            i17 = i14;
                                                                                                            set3 = set2;
                                                                                                            str5 = str6;
                                                                                                            be1Var2 = (be1) obj9;
                                                                                                            be1Var2.getClass();
                                                                                                            Object obj16 = obj14;
                                                                                                            if (be1Var2.e || be1Var2.d || be1Var2.c) {
                                                                                                                be1Var = be1Var2;
                                                                                                            } else {
                                                                                                                ps0 ps0Var2 = mt0Var.h;
                                                                                                                lt0Var.e = hq0Var12;
                                                                                                                lt0Var.f = hq0Var14;
                                                                                                                lt0Var.i = an1Var4;
                                                                                                                lt0Var.j = g5Var6;
                                                                                                                lt0Var.k = str4;
                                                                                                                lt0Var.n = null;
                                                                                                                lt0Var.s = set3;
                                                                                                                lt0Var.t = null;
                                                                                                                lt0Var.u = i18;
                                                                                                                lt0Var.v = i17;
                                                                                                                lt0Var.H = j4;
                                                                                                                lt0Var.w = i15;
                                                                                                                lt0Var.x = i13;
                                                                                                                lt0Var.Z = 10;
                                                                                                                hq0 hq0Var23 = hq0Var14;
                                                                                                                Object objE3 = ps0Var2.b.e("gemini_live", str5, new Long(j4), lt0Var);
                                                                                                                obj14 = obj16;
                                                                                                                if (objE3 != obj14) {
                                                                                                                    objE3 = q43.a;
                                                                                                                }
                                                                                                                if (objE3 != obj14) {
                                                                                                                    j5 = j4;
                                                                                                                    i21 = i15;
                                                                                                                    i23 = i17;
                                                                                                                    i22 = i18;
                                                                                                                    i20 = i13;
                                                                                                                    g5Var7 = g5Var6;
                                                                                                                    set4 = set3;
                                                                                                                    hq0Var15 = hq0Var12;
                                                                                                                    hq0Var16 = hq0Var23;
                                                                                                                    an1Var5 = an1Var4;
                                                                                                                    j6 = j5;
                                                                                                                    ps0 ps0Var3 = mt0Var.h;
                                                                                                                    set5 = set4;
                                                                                                                    if (i21 == 0) {
                                                                                                                        z2 = i19;
                                                                                                                    } else {
                                                                                                                        z2 = z;
                                                                                                                    }
                                                                                                                    lt0Var.e = hq0Var15;
                                                                                                                    lt0Var.f = hq0Var16;
                                                                                                                    lt0Var.i = an1Var5;
                                                                                                                    lt0Var.j = g5Var7;
                                                                                                                    lt0Var.k = str4;
                                                                                                                    hq0Var17 = hq0Var16;
                                                                                                                    lt0Var.n = null;
                                                                                                                    lt0Var.s = set5;
                                                                                                                    lt0Var.t = null;
                                                                                                                    lt0Var.u = i22;
                                                                                                                    lt0Var.v = i23;
                                                                                                                    lt0Var.H = j6;
                                                                                                                    lt0Var.w = i21;
                                                                                                                    lt0Var.x = i20;
                                                                                                                    lt0Var.Z = 11;
                                                                                                                    objA = ps0Var3.a(z2, lt0Var);
                                                                                                                    if (objA != obj14) {
                                                                                                                        set6 = set5;
                                                                                                                        g5Var4 = g5Var7;
                                                                                                                        i9 = i23;
                                                                                                                        an1Var3 = an1Var5;
                                                                                                                        i7 = i22;
                                                                                                                        obj10 = objA;
                                                                                                                        hq0Var18 = hq0Var15;
                                                                                                                        str = str4;
                                                                                                                        hq0Var10 = hq0Var17;
                                                                                                                        linkedHashSet = set6;
                                                                                                                        i8 = i19;
                                                                                                                        hq0Var9 = hq0Var18;
                                                                                                                        long j9 = j6;
                                                                                                                        obj4 = obj10;
                                                                                                                        i10 = i20 + 1;
                                                                                                                        j = j9;
                                                                                                                        if (i10 >= 4) {
                                                                                                                            an1Var2 = an1Var3;
                                                                                                                        } else if (mt0Var.v) {
                                                                                                                            f0 f0Var5 = mt0Var.c;
                                                                                                                            lt0Var.e = hq0Var9;
                                                                                                                            lt0Var.f = hq0Var10;
                                                                                                                            lt0Var.i = an1Var3;
                                                                                                                            lt0Var.j = g5Var4;
                                                                                                                            lt0Var.k = str;
                                                                                                                            lt0Var.n = obj4;
                                                                                                                            str7 = str;
                                                                                                                            lt0Var.s = linkedHashSet;
                                                                                                                            lt0Var.t = null;
                                                                                                                            lt0Var.u = i7;
                                                                                                                            lt0Var.v = i9;
                                                                                                                            lt0Var.H = j;
                                                                                                                            lt0Var.w = i8;
                                                                                                                            lt0Var.x = i10;
                                                                                                                            lt0Var.Z = 7;
                                                                                                                            objI2 = f0Var5.i(lt0Var);
                                                                                                                            if (objI2 != obj14) {
                                                                                                                                an1Var4 = an1Var3;
                                                                                                                                obj5 = obj4;
                                                                                                                                g5Var5 = g5Var4;
                                                                                                                                set = linkedHashSet;
                                                                                                                                obj6 = objI2;
                                                                                                                                hq0 hq0Var24 = hq0Var10;
                                                                                                                                str2 = str7;
                                                                                                                                lt0 lt0Var5 = lt0Var;
                                                                                                                                i11 = i10;
                                                                                                                                hq0Var11 = hq0Var24;
                                                                                                                                j2 = j;
                                                                                                                                lt0Var2 = lt0Var5;
                                                                                                                                i12 = i9;
                                                                                                                                j7 = j2;
                                                                                                                                if (((Number) obj6).longValue() == j7) {
                                                                                                                                    set7 = set;
                                                                                                                                    f0 f0Var6 = mt0Var.c;
                                                                                                                                    lt0Var2.e = hq0Var9;
                                                                                                                                    lt0Var2.f = hq0Var11;
                                                                                                                                    lt0Var2.i = an1Var4;
                                                                                                                                    lt0Var2.j = g5Var5;
                                                                                                                                    lt0Var2.k = str2;
                                                                                                                                    lt0Var2.n = obj5;
                                                                                                                                    hq0Var19 = hq0Var11;
                                                                                                                                    lt0Var2.s = set7;
                                                                                                                                    lt0Var2.u = i7;
                                                                                                                                    lt0Var2.v = i12;
                                                                                                                                    lt0Var2.H = j7;
                                                                                                                                    lt0Var2.w = i8;
                                                                                                                                    lt0Var2.x = i11;
                                                                                                                                    lt0Var2.Z = 8;
                                                                                                                                    objC3 = rn4.c(f0Var6.b, lt0Var2);
                                                                                                                                    if (objC3 == obj14) {
                                                                                                                                        i13 = i11;
                                                                                                                                        str3 = str2;
                                                                                                                                        i16 = i7;
                                                                                                                                        i15 = i8;
                                                                                                                                        hq0Var12 = hq0Var9;
                                                                                                                                        g5Var6 = g5Var5;
                                                                                                                                        set2 = set7;
                                                                                                                                        obj7 = objC3;
                                                                                                                                        obj8 = obj5;
                                                                                                                                        i14 = i12;
                                                                                                                                        j3 = j7;
                                                                                                                                        lt0Var3 = lt0Var2;
                                                                                                                                        hq0Var13 = hq0Var19;
                                                                                                                                        j4 = j3;
                                                                                                                                        obj11 = obj14;
                                                                                                                                        if (((o) obj7).a) {
                                                                                                                                            if (obj8 instanceof h72) {
                                                                                                                                                obj12 = null;
                                                                                                                                            } else {
                                                                                                                                                obj12 = obj8;
                                                                                                                                            }
                                                                                                                                            pd1Var = (pd1) obj12;
                                                                                                                                            if (pd1Var != null) {
                                                                                                                                                list = pd1Var.b;
                                                                                                                                            } else {
                                                                                                                                                list = null;
                                                                                                                                            }
                                                                                                                                            obj13 = obj8;
                                                                                                                                            if (list == null) {
                                                                                                                                                w30 w30VarB2 = oj4.b(i72.a(obj13));
                                                                                                                                                iOrdinal = w30VarB2.ordinal();
                                                                                                                                                if (iOrdinal != 1) {
                                                                                                                                                    dd1Var = dd1.a;
                                                                                                                                                } else {
                                                                                                                                                    dd1Var = dd1.a;
                                                                                                                                                }
                                                                                                                                                jr2 jr2Var4 = mt0Var.k;
                                                                                                                                                ee1 ee1Var5 = new ee1(oj4.d(w30VarB2), 47);
                                                                                                                                                jr2Var4.getClass();
                                                                                                                                                jr2Var4.j(null, ee1Var5);
                                                                                                                                                be1Var = new be1(dd1Var, 30);
                                                                                                                                                break;
                                                                                                                                            } else {
                                                                                                                                                it = list.iterator();
                                                                                                                                                if (it.hasNext()) {
                                                                                                                                                    next = it.next();
                                                                                                                                                } else {
                                                                                                                                                    next = null;
                                                                                                                                                }
                                                                                                                                                str6 = (String) next;
                                                                                                                                                if (str6 == null) {
                                                                                                                                                    an1Var2 = an1Var4;
                                                                                                                                                } else {
                                                                                                                                                    set2.add(str6);
                                                                                                                                                    l82 l82Var2 = g5Var6.a;
                                                                                                                                                    q03 q03Var2 = g5Var6.b;
                                                                                                                                                    boolean z8 = g5Var6.c;
                                                                                                                                                    b60 b60Var2 = g5Var6.d;
                                                                                                                                                    String str9 = g5Var6.e;
                                                                                                                                                    boolean z9 = g5Var6.g;
                                                                                                                                                    l61 l61Var2 = g5Var6.h;
                                                                                                                                                    boolean z10 = g5Var6.i;
                                                                                                                                                    boolean z11 = g5Var6.j;
                                                                                                                                                    boolean z12 = g5Var6.k;
                                                                                                                                                    l61Var2.getClass();
                                                                                                                                                    g5 g5Var9 = new g5(l82Var2, q03Var2, z8, b60Var2, str9, str6, z9, l61Var2, z10, z11, z12);
                                                                                                                                                    lt0Var3.e = hq0Var12;
                                                                                                                                                    lt0Var3.f = hq0Var13;
                                                                                                                                                    lt0Var3.i = an1Var4;
                                                                                                                                                    lt0Var3.j = g5Var6;
                                                                                                                                                    lt0Var3.k = str3;
                                                                                                                                                    lt0Var3.n = null;
                                                                                                                                                    lt0Var3.s = set2;
                                                                                                                                                    lt0Var3.t = str6;
                                                                                                                                                    lt0Var3.u = i16;
                                                                                                                                                    lt0Var3.v = i14;
                                                                                                                                                    lt0Var3.H = j4;
                                                                                                                                                    lt0Var3.w = i15;
                                                                                                                                                    lt0Var3.x = i13;
                                                                                                                                                    lt0Var3.Z = 9;
                                                                                                                                                    mt0Var = this;
                                                                                                                                                    i19 = 1;
                                                                                                                                                    z = false;
                                                                                                                                                    objE2 = mt0Var.e(g5Var9, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                                                                                                                    obj14 = obj11;
                                                                                                                                                    if (objE2 != obj14) {
                                                                                                                                                        int i26 = i16;
                                                                                                                                                        str4 = str3;
                                                                                                                                                        lt0Var = lt0Var3;
                                                                                                                                                        i18 = i26;
                                                                                                                                                        obj9 = objE2;
                                                                                                                                                        hq0Var14 = hq0Var13;
                                                                                                                                                        i17 = i14;
                                                                                                                                                        set3 = set2;
                                                                                                                                                        str5 = str6;
                                                                                                                                                        be1Var2 = (be1) obj9;
                                                                                                                                                        be1Var2.getClass();
                                                                                                                                                        Object obj17 = obj14;
                                                                                                                                                        if (be1Var2.e) {
                                                                                                                                                        }
                                                                                                                                                        be1Var = be1Var2;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            an1Var2 = an1Var4;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    an1Var2 = an1Var4;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            an1Var2 = an1Var3;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                } while (set2.contains((String) next));
                                                                                                str6 = (String) next;
                                                                                                if (str6 == null) {
                                                                                                    an1Var2 = an1Var4;
                                                                                                } else {
                                                                                                    set2.add(str6);
                                                                                                    l82 l82Var3 = g5Var6.a;
                                                                                                    q03 q03Var3 = g5Var6.b;
                                                                                                    boolean z13 = g5Var6.c;
                                                                                                    b60 b60Var3 = g5Var6.d;
                                                                                                    String str10 = g5Var6.e;
                                                                                                    boolean z14 = g5Var6.g;
                                                                                                    l61 l61Var3 = g5Var6.h;
                                                                                                    boolean z15 = g5Var6.i;
                                                                                                    boolean z16 = g5Var6.j;
                                                                                                    boolean z17 = g5Var6.k;
                                                                                                    l61Var3.getClass();
                                                                                                    g5 g5Var10 = new g5(l82Var3, q03Var3, z13, b60Var3, str10, str6, z14, l61Var3, z15, z16, z17);
                                                                                                    lt0Var3.e = hq0Var12;
                                                                                                    lt0Var3.f = hq0Var13;
                                                                                                    lt0Var3.i = an1Var4;
                                                                                                    lt0Var3.j = g5Var6;
                                                                                                    lt0Var3.k = str3;
                                                                                                    lt0Var3.n = null;
                                                                                                    lt0Var3.s = set2;
                                                                                                    lt0Var3.t = str6;
                                                                                                    lt0Var3.u = i16;
                                                                                                    lt0Var3.v = i14;
                                                                                                    lt0Var3.H = j4;
                                                                                                    lt0Var3.w = i15;
                                                                                                    lt0Var3.x = i13;
                                                                                                    lt0Var3.Z = 9;
                                                                                                    mt0Var = this;
                                                                                                    i19 = 1;
                                                                                                    z = false;
                                                                                                    objE2 = mt0Var.e(g5Var10, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                                                                    obj14 = obj11;
                                                                                                    if (objE2 != obj14) {
                                                                                                        int i27 = i16;
                                                                                                        str4 = str3;
                                                                                                        lt0Var = lt0Var3;
                                                                                                        i18 = i27;
                                                                                                        obj9 = objE2;
                                                                                                        hq0Var14 = hq0Var13;
                                                                                                        i17 = i14;
                                                                                                        set3 = set2;
                                                                                                        str5 = str6;
                                                                                                        be1Var2 = (be1) obj9;
                                                                                                        be1Var2.getClass();
                                                                                                        Object obj18 = obj14;
                                                                                                        if (be1Var2.e) {
                                                                                                        }
                                                                                                        be1Var = be1Var2;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            an1Var2 = an1Var4;
                                                                                        } else {
                                                                                            an1Var2 = an1Var4;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    an1Var2 = an1Var4;
                                                                                }
                                                                            }
                                                                        }
                                                                        mt0Var.o();
                                                                        jr2 jr2Var5 = mt0Var.k;
                                                                        ee1 ee1Var6 = new ee1(null, 63);
                                                                        jr2Var5.getClass();
                                                                        jr2Var5.j(null, ee1Var6);
                                                                        be1Var = new be1(null, 27);
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        an1Var = an1Var3;
                                                                        an1Var.h(null);
                                                                        throw th;
                                                                    }
                                                                } else {
                                                                    an1Var2 = an1Var3;
                                                                }
                                                                jr2 jr2Var6 = mt0Var.k;
                                                                ee1 ee1Var7 = new ee1("No compatible Gemini Live model answered for this key. SONIC will recheck automatically.", 47);
                                                                jr2Var6.getClass();
                                                                jr2Var6.j(null, ee1Var7);
                                                                be1Var = new be1(dd1Var2, 30);
                                                            }
                                                        }
                                                    }
                                                    an1Var2.h(obj3);
                                                    return be1Var;
                                                }
                                            } else {
                                                jr2 jr2Var7 = mt0Var.k;
                                                ee1 ee1Var8 = new ee1("Enable cloud AI and save a Gemini key before starting Live audio.", 47);
                                                jr2Var7.getClass();
                                                jr2Var7.j(null, ee1Var8);
                                                be1Var = new be1(dd1Var2, 30);
                                            }
                                        }
                                    }
                                }
                            }
                            obj3 = null;
                            an1Var2.h(obj3);
                            return be1Var;
                        }
                        return obj14;
                    case 1:
                        i = lt0Var.u;
                        an1 an1Var7 = lt0Var.i;
                        hq0Var2 = lt0Var.f;
                        hq0 hq0Var25 = lt0Var.e;
                        bz3.g(obj15);
                        an1Var2 = an1Var7;
                        hq0Var = hq0Var25;
                        if (!mt0Var.j.d) {
                            mt0Var.v = false;
                            mt0Var.w = false;
                            mt0Var.x = false;
                            mt0Var.J = true;
                            j5 j5Var2 = mt0Var.d;
                            lt0Var.e = hq0Var;
                            lt0Var.f = hq0Var2;
                            lt0Var.i = an1Var2;
                            lt0Var.u = i;
                            lt0Var.v = 0;
                            lt0Var.Z = 2;
                            objC = rn4.c(j5Var2.b, lt0Var);
                            if (objC == obj14) {
                                hq0 hq0Var26 = hq0Var2;
                                i2 = i;
                                obj = objC;
                                hq0Var3 = hq0Var26;
                                hq0Var4 = hq0Var;
                                i3 = 0;
                                g5Var = (g5) obj;
                                f0 f0Var7 = mt0Var.c;
                                lt0Var.e = hq0Var4;
                                lt0Var.f = hq0Var3;
                                lt0Var.i = an1Var2;
                                lt0Var.j = g5Var;
                                lt0Var.u = i2;
                                lt0Var.v = i3;
                                lt0Var.Z = 3;
                                objI = f0Var7.i(lt0Var);
                                if (objI != obj14) {
                                    hq0Var5 = hq0Var4;
                                    g5Var2 = g5Var;
                                    obj2 = objI;
                                    hq0Var6 = hq0Var3;
                                    i4 = i2;
                                    jLongValue = ((Number) obj2).longValue();
                                    f0 f0Var8 = mt0Var.c;
                                    lt0Var.e = hq0Var5;
                                    lt0Var.f = hq0Var6;
                                    lt0Var.i = an1Var2;
                                    lt0Var.j = g5Var2;
                                    lt0Var.u = i4;
                                    lt0Var.v = i3;
                                    lt0Var.H = jLongValue;
                                    lt0Var.Z = 4;
                                    objC2 = rn4.c(f0Var8.b, lt0Var);
                                    if (objC2 == obj14) {
                                        if (!((o) objC2).a) {
                                            jr2 jr2Var8 = mt0Var.k;
                                            ee1 ee1Var9 = new ee1("Enable cloud AI and save a Gemini key before starting Live audio.", 47);
                                            jr2Var8.getClass();
                                            jr2Var8.j(null, ee1Var9);
                                            be1Var = new be1(dd1Var2, 30);
                                        } else {
                                            h61 h61Var2 = mt0Var.b;
                                            lt0Var.e = hq0Var5;
                                            lt0Var.f = hq0Var6;
                                            lt0Var.i = an1Var2;
                                            lt0Var.j = g5Var2;
                                            lt0Var.u = i4;
                                            lt0Var.v = i3;
                                            lt0Var.H = jLongValue;
                                            lt0Var.Z = 5;
                                            objE = h61Var2.e("gemini_api_key", lt0Var);
                                            if (objE != obj14) {
                                                hq0 hq0Var27 = hq0Var5;
                                                hq0Var7 = hq0Var6;
                                                g5Var3 = g5Var2;
                                                str = (String) objE;
                                                if (str != null) {
                                                    break;
                                                }
                                                jr2 jr2Var9 = mt0Var.k;
                                                ee1 ee1Var10 = new ee1("Save your Gemini API key in Setup to use Live audio.", 47);
                                                jr2Var9.getClass();
                                                obj3 = null;
                                                jr2Var9.j(null, ee1Var10);
                                                be1Var = new be1(dd1Var2, 30);
                                                an1Var2.h(obj3);
                                                return be1Var;
                                            }
                                        }
                                    }
                                }
                            }
                            return obj14;
                        }
                        be1Var = new be1(null, 27);
                        obj3 = null;
                        an1Var2.h(obj3);
                        return be1Var;
                    case 2:
                        int i28 = lt0Var.v;
                        int i29 = lt0Var.u;
                        an1Var2 = lt0Var.i;
                        hq0 hq0Var28 = lt0Var.f;
                        hq0 hq0Var29 = lt0Var.e;
                        bz3.g(obj15);
                        hq0Var4 = hq0Var29;
                        hq0Var3 = hq0Var28;
                        i2 = i29;
                        i3 = i28;
                        obj = obj15;
                        g5Var = (g5) obj;
                        f0 f0Var9 = mt0Var.c;
                        lt0Var.e = hq0Var4;
                        lt0Var.f = hq0Var3;
                        lt0Var.i = an1Var2;
                        lt0Var.j = g5Var;
                        lt0Var.u = i2;
                        lt0Var.v = i3;
                        lt0Var.Z = 3;
                        objI = f0Var9.i(lt0Var);
                        if (objI != obj14) {
                            hq0Var5 = hq0Var4;
                            g5Var2 = g5Var;
                            obj2 = objI;
                            hq0Var6 = hq0Var3;
                            i4 = i2;
                            jLongValue = ((Number) obj2).longValue();
                            f0 f0Var10 = mt0Var.c;
                            lt0Var.e = hq0Var5;
                            lt0Var.f = hq0Var6;
                            lt0Var.i = an1Var2;
                            lt0Var.j = g5Var2;
                            lt0Var.u = i4;
                            lt0Var.v = i3;
                            lt0Var.H = jLongValue;
                            lt0Var.Z = 4;
                            objC2 = rn4.c(f0Var10.b, lt0Var);
                            if (objC2 == obj14) {
                                if (!((o) objC2).a) {
                                    jr2 jr2Var10 = mt0Var.k;
                                    ee1 ee1Var11 = new ee1("Enable cloud AI and save a Gemini key before starting Live audio.", 47);
                                    jr2Var10.getClass();
                                    jr2Var10.j(null, ee1Var11);
                                    be1Var = new be1(dd1Var2, 30);
                                } else {
                                    h61 h61Var3 = mt0Var.b;
                                    lt0Var.e = hq0Var5;
                                    lt0Var.f = hq0Var6;
                                    lt0Var.i = an1Var2;
                                    lt0Var.j = g5Var2;
                                    lt0Var.u = i4;
                                    lt0Var.v = i3;
                                    lt0Var.H = jLongValue;
                                    lt0Var.Z = 5;
                                    objE = h61Var3.e("gemini_api_key", lt0Var);
                                    if (objE != obj14) {
                                        hq0 hq0Var210 = hq0Var5;
                                        hq0Var7 = hq0Var6;
                                        g5Var3 = g5Var2;
                                        str = (String) objE;
                                        if (str != null) {
                                            break;
                                        }
                                        jr2 jr2Var11 = mt0Var.k;
                                        ee1 ee1Var12 = new ee1("Save your Gemini API key in Setup to use Live audio.", 47);
                                        jr2Var11.getClass();
                                        obj3 = null;
                                        jr2Var11.j(null, ee1Var12);
                                        be1Var = new be1(dd1Var2, 30);
                                        an1Var2.h(obj3);
                                        return be1Var;
                                    }
                                }
                                obj3 = null;
                                an1Var2.h(obj3);
                                return be1Var;
                            }
                        }
                        return obj14;
                    case 3:
                        int i30 = lt0Var.v;
                        int i31 = lt0Var.u;
                        g5 g5Var11 = lt0Var.j;
                        an1Var2 = lt0Var.i;
                        hq0 hq0Var30 = lt0Var.f;
                        hq0 hq0Var31 = lt0Var.e;
                        bz3.g(obj15);
                        hq0Var6 = hq0Var30;
                        hq0Var5 = hq0Var31;
                        i4 = i31;
                        g5Var2 = g5Var11;
                        i3 = i30;
                        obj2 = obj15;
                        jLongValue = ((Number) obj2).longValue();
                        f0 f0Var11 = mt0Var.c;
                        lt0Var.e = hq0Var5;
                        lt0Var.f = hq0Var6;
                        lt0Var.i = an1Var2;
                        lt0Var.j = g5Var2;
                        lt0Var.u = i4;
                        lt0Var.v = i3;
                        lt0Var.H = jLongValue;
                        lt0Var.Z = 4;
                        objC2 = rn4.c(f0Var11.b, lt0Var);
                        if (objC2 == obj14) {
                            if (!((o) objC2).a) {
                                jr2 jr2Var12 = mt0Var.k;
                                ee1 ee1Var13 = new ee1("Enable cloud AI and save a Gemini key before starting Live audio.", 47);
                                jr2Var12.getClass();
                                jr2Var12.j(null, ee1Var13);
                                be1Var = new be1(dd1Var2, 30);
                            } else {
                                h61 h61Var4 = mt0Var.b;
                                lt0Var.e = hq0Var5;
                                lt0Var.f = hq0Var6;
                                lt0Var.i = an1Var2;
                                lt0Var.j = g5Var2;
                                lt0Var.u = i4;
                                lt0Var.v = i3;
                                lt0Var.H = jLongValue;
                                lt0Var.Z = 5;
                                objE = h61Var4.e("gemini_api_key", lt0Var);
                                if (objE != obj14) {
                                    hq0 hq0Var211 = hq0Var5;
                                    hq0Var7 = hq0Var6;
                                    g5Var3 = g5Var2;
                                    str = (String) objE;
                                    if (str != null) {
                                        break;
                                    }
                                    jr2 jr2Var13 = mt0Var.k;
                                    ee1 ee1Var14 = new ee1("Save your Gemini API key in Setup to use Live audio.", 47);
                                    jr2Var13.getClass();
                                    obj3 = null;
                                    jr2Var13.j(null, ee1Var14);
                                    be1Var = new be1(dd1Var2, 30);
                                    an1Var2.h(obj3);
                                    return be1Var;
                                }
                            }
                            obj3 = null;
                            an1Var2.h(obj3);
                            return be1Var;
                        }
                        return obj14;
                    case 4:
                        long j10 = lt0Var.H;
                        int i32 = lt0Var.v;
                        i4 = lt0Var.u;
                        g5Var2 = lt0Var.j;
                        an1Var2 = lt0Var.i;
                        hq0Var6 = lt0Var.f;
                        hq0Var5 = lt0Var.e;
                        bz3.g(obj15);
                        jLongValue = j10;
                        i3 = i32;
                        objC2 = obj15;
                        if (!((o) objC2).a) {
                            h61 h61Var5 = mt0Var.b;
                            lt0Var.e = hq0Var5;
                            lt0Var.f = hq0Var6;
                            lt0Var.i = an1Var2;
                            lt0Var.j = g5Var2;
                            lt0Var.u = i4;
                            lt0Var.v = i3;
                            lt0Var.H = jLongValue;
                            lt0Var.Z = 5;
                            objE = h61Var5.e("gemini_api_key", lt0Var);
                            if (objE != obj14) {
                                hq0 hq0Var212 = hq0Var5;
                                hq0Var7 = hq0Var6;
                                g5Var3 = g5Var2;
                                str = (String) objE;
                                if (str != null) {
                                    break;
                                }
                                jr2 jr2Var14 = mt0Var.k;
                                ee1 ee1Var15 = new ee1("Save your Gemini API key in Setup to use Live audio.", 47);
                                jr2Var14.getClass();
                                obj3 = null;
                                jr2Var14.j(null, ee1Var15);
                                be1Var = new be1(dd1Var2, 30);
                                an1Var2.h(obj3);
                                return be1Var;
                            }
                            return obj14;
                        }
                        jr2 jr2Var15 = mt0Var.k;
                        ee1 ee1Var16 = new ee1("Enable cloud AI and save a Gemini key before starting Live audio.", 47);
                        jr2Var15.getClass();
                        jr2Var15.j(null, ee1Var16);
                        be1Var = new be1(dd1Var2, 30);
                        obj3 = null;
                        an1Var2.h(obj3);
                        return be1Var;
                    case 5:
                        long j11 = lt0Var.H;
                        int i33 = lt0Var.v;
                        i4 = lt0Var.u;
                        g5Var2 = lt0Var.j;
                        an1Var2 = lt0Var.i;
                        hq0Var6 = lt0Var.f;
                        hq0Var5 = lt0Var.e;
                        bz3.g(obj15);
                        jLongValue = j11;
                        i3 = i33;
                        objE = obj15;
                        hq0 hq0Var213 = hq0Var5;
                        hq0Var7 = hq0Var6;
                        g5Var3 = g5Var2;
                        str = (String) objE;
                        if (str != null) {
                            break;
                        }
                        jr2 jr2Var16 = mt0Var.k;
                        ee1 ee1Var17 = new ee1("Save your Gemini API key in Setup to use Live audio.", 47);
                        jr2Var16.getClass();
                        obj3 = null;
                        jr2Var16.j(null, ee1Var17);
                        be1Var = new be1(dd1Var2, 30);
                        an1Var2.h(obj3);
                        return be1Var;
                    case 6:
                        j = lt0Var.H;
                        i6 = lt0Var.v;
                        i4 = lt0Var.u;
                        str = lt0Var.k;
                        g5Var3 = lt0Var.j;
                        an1Var2 = lt0Var.i;
                        hq0Var7 = lt0Var.f;
                        hq0Var8 = lt0Var.e;
                        bz3.g(obj15);
                        obj4 = ((i72) obj15).a;
                        i5 = 0;
                        hq0Var9 = hq0Var8;
                        linkedHashSet = new LinkedHashSet();
                        hq0Var10 = hq0Var7;
                        an1Var3 = an1Var2;
                        i7 = i4;
                        i8 = i5;
                        g5Var4 = g5Var3;
                        i9 = i6;
                        i10 = i8;
                        if (i10 >= 4) {
                            if (mt0Var.v) {
                                f0 f0Var12 = mt0Var.c;
                                lt0Var.e = hq0Var9;
                                lt0Var.f = hq0Var10;
                                lt0Var.i = an1Var3;
                                lt0Var.j = g5Var4;
                                lt0Var.k = str;
                                lt0Var.n = obj4;
                                str7 = str;
                                lt0Var.s = linkedHashSet;
                                lt0Var.t = null;
                                lt0Var.u = i7;
                                lt0Var.v = i9;
                                lt0Var.H = j;
                                lt0Var.w = i8;
                                lt0Var.x = i10;
                                lt0Var.Z = 7;
                                objI2 = f0Var12.i(lt0Var);
                                if (objI2 != obj14) {
                                    an1Var4 = an1Var3;
                                    obj5 = obj4;
                                    g5Var5 = g5Var4;
                                    set = linkedHashSet;
                                    obj6 = objI2;
                                    hq0 hq0Var214 = hq0Var10;
                                    str2 = str7;
                                    lt0 lt0Var6 = lt0Var;
                                    i11 = i10;
                                    hq0Var11 = hq0Var214;
                                    j2 = j;
                                    lt0Var2 = lt0Var6;
                                    i12 = i9;
                                    j7 = j2;
                                    if (((Number) obj6).longValue() == j7) {
                                        set7 = set;
                                        f0 f0Var13 = mt0Var.c;
                                        lt0Var2.e = hq0Var9;
                                        lt0Var2.f = hq0Var11;
                                        lt0Var2.i = an1Var4;
                                        lt0Var2.j = g5Var5;
                                        lt0Var2.k = str2;
                                        lt0Var2.n = obj5;
                                        hq0Var19 = hq0Var11;
                                        lt0Var2.s = set7;
                                        lt0Var2.u = i7;
                                        lt0Var2.v = i12;
                                        lt0Var2.H = j7;
                                        lt0Var2.w = i8;
                                        lt0Var2.x = i11;
                                        lt0Var2.Z = 8;
                                        objC3 = rn4.c(f0Var13.b, lt0Var2);
                                        if (objC3 == obj14) {
                                            i13 = i11;
                                            str3 = str2;
                                            i16 = i7;
                                            i15 = i8;
                                            hq0Var12 = hq0Var9;
                                            g5Var6 = g5Var5;
                                            set2 = set7;
                                            obj7 = objC3;
                                            obj8 = obj5;
                                            i14 = i12;
                                            j3 = j7;
                                            lt0Var3 = lt0Var2;
                                            hq0Var13 = hq0Var19;
                                            j4 = j3;
                                            obj11 = obj14;
                                            if (((o) obj7).a) {
                                                if (obj8 instanceof h72) {
                                                    obj12 = null;
                                                } else {
                                                    obj12 = obj8;
                                                }
                                                pd1Var = (pd1) obj12;
                                                if (pd1Var != null) {
                                                    list = pd1Var.b;
                                                } else {
                                                    list = null;
                                                }
                                                obj13 = obj8;
                                                if (list == null) {
                                                    w30 w30VarB3 = oj4.b(i72.a(obj13));
                                                    iOrdinal = w30VarB3.ordinal();
                                                    if (iOrdinal != 1) {
                                                        dd1Var = dd1.a;
                                                    } else {
                                                        dd1Var = dd1.a;
                                                    }
                                                    jr2 jr2Var17 = mt0Var.k;
                                                    ee1 ee1Var18 = new ee1(oj4.d(w30VarB3), 47);
                                                    jr2Var17.getClass();
                                                    jr2Var17.j(null, ee1Var18);
                                                    be1Var = new be1(dd1Var, 30);
                                                    break;
                                                } else {
                                                    it = list.iterator();
                                                    do {
                                                        if (it.hasNext()) {
                                                            next = it.next();
                                                        } else {
                                                            next = null;
                                                        }
                                                        str6 = (String) next;
                                                        if (str6 == null) {
                                                            an1Var2 = an1Var4;
                                                        } else {
                                                            set2.add(str6);
                                                            l82 l82Var4 = g5Var6.a;
                                                            q03 q03Var4 = g5Var6.b;
                                                            boolean z18 = g5Var6.c;
                                                            b60 b60Var4 = g5Var6.d;
                                                            String str11 = g5Var6.e;
                                                            boolean z19 = g5Var6.g;
                                                            l61 l61Var4 = g5Var6.h;
                                                            boolean z110 = g5Var6.i;
                                                            boolean z111 = g5Var6.j;
                                                            boolean z112 = g5Var6.k;
                                                            l61Var4.getClass();
                                                            g5 g5Var12 = new g5(l82Var4, q03Var4, z18, b60Var4, str11, str6, z19, l61Var4, z110, z111, z112);
                                                            lt0Var3.e = hq0Var12;
                                                            lt0Var3.f = hq0Var13;
                                                            lt0Var3.i = an1Var4;
                                                            lt0Var3.j = g5Var6;
                                                            lt0Var3.k = str3;
                                                            lt0Var3.n = null;
                                                            lt0Var3.s = set2;
                                                            lt0Var3.t = str6;
                                                            lt0Var3.u = i16;
                                                            lt0Var3.v = i14;
                                                            lt0Var3.H = j4;
                                                            lt0Var3.w = i15;
                                                            lt0Var3.x = i13;
                                                            lt0Var3.Z = 9;
                                                            mt0Var = this;
                                                            i19 = 1;
                                                            z = false;
                                                            objE2 = mt0Var.e(g5Var12, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                            obj14 = obj11;
                                                            if (objE2 != obj14) {
                                                                int i210 = i16;
                                                                str4 = str3;
                                                                lt0Var = lt0Var3;
                                                                i18 = i210;
                                                                obj9 = objE2;
                                                                hq0Var14 = hq0Var13;
                                                                i17 = i14;
                                                                set3 = set2;
                                                                str5 = str6;
                                                                be1Var2 = (be1) obj9;
                                                                be1Var2.getClass();
                                                                Object obj19 = obj14;
                                                                if (be1Var2.e) {
                                                                }
                                                                be1Var = be1Var2;
                                                                break;
                                                            }
                                                        }
                                                    } while (set2.contains((String) next));
                                                    str6 = (String) next;
                                                    if (str6 == null) {
                                                        an1Var2 = an1Var4;
                                                    } else {
                                                        set2.add(str6);
                                                        l82 l82Var5 = g5Var6.a;
                                                        q03 q03Var5 = g5Var6.b;
                                                        boolean z113 = g5Var6.c;
                                                        b60 b60Var5 = g5Var6.d;
                                                        String str12 = g5Var6.e;
                                                        boolean z114 = g5Var6.g;
                                                        l61 l61Var5 = g5Var6.h;
                                                        boolean z115 = g5Var6.i;
                                                        boolean z116 = g5Var6.j;
                                                        boolean z117 = g5Var6.k;
                                                        l61Var5.getClass();
                                                        g5 g5Var13 = new g5(l82Var5, q03Var5, z113, b60Var5, str12, str6, z114, l61Var5, z115, z116, z117);
                                                        lt0Var3.e = hq0Var12;
                                                        lt0Var3.f = hq0Var13;
                                                        lt0Var3.i = an1Var4;
                                                        lt0Var3.j = g5Var6;
                                                        lt0Var3.k = str3;
                                                        lt0Var3.n = null;
                                                        lt0Var3.s = set2;
                                                        lt0Var3.t = str6;
                                                        lt0Var3.u = i16;
                                                        lt0Var3.v = i14;
                                                        lt0Var3.H = j4;
                                                        lt0Var3.w = i15;
                                                        lt0Var3.x = i13;
                                                        lt0Var3.Z = 9;
                                                        mt0Var = this;
                                                        i19 = 1;
                                                        z = false;
                                                        objE2 = mt0Var.e(g5Var13, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                        obj14 = obj11;
                                                        if (objE2 != obj14) {
                                                            int i211 = i16;
                                                            str4 = str3;
                                                            lt0Var = lt0Var3;
                                                            i18 = i211;
                                                            obj9 = objE2;
                                                            hq0Var14 = hq0Var13;
                                                            i17 = i14;
                                                            set3 = set2;
                                                            str5 = str6;
                                                            be1Var2 = (be1) obj9;
                                                            be1Var2.getClass();
                                                            Object obj110 = obj14;
                                                            if (be1Var2.e) {
                                                            }
                                                            be1Var = be1Var2;
                                                            break;
                                                        }
                                                    }
                                                }
                                                an1Var2 = an1Var4;
                                                obj3 = null;
                                                an1Var2.h(obj3);
                                                return be1Var;
                                            }
                                            an1Var2 = an1Var4;
                                        }
                                    } else {
                                        an1Var2 = an1Var4;
                                    }
                                }
                                return obj14;
                            }
                            an1Var2 = an1Var3;
                            mt0Var.o();
                            jr2 jr2Var18 = mt0Var.k;
                            ee1 ee1Var19 = new ee1(null, 63);
                            jr2Var18.getClass();
                            jr2Var18.j(null, ee1Var19);
                            be1Var = new be1(null, 27);
                            obj3 = null;
                            an1Var2.h(obj3);
                            return be1Var;
                        }
                        an1Var2 = an1Var3;
                        jr2 jr2Var19 = mt0Var.k;
                        ee1 ee1Var20 = new ee1("No compatible Gemini Live model answered for this key. SONIC will recheck automatically.", 47);
                        jr2Var19.getClass();
                        jr2Var19.j(null, ee1Var20);
                        be1Var = new be1(dd1Var2, 30);
                        obj3 = null;
                        an1Var2.h(obj3);
                        return be1Var;
                    case 7:
                        int i34 = lt0Var.x;
                        int i35 = lt0Var.w;
                        long j12 = lt0Var.H;
                        int i36 = lt0Var.v;
                        int i37 = lt0Var.u;
                        Set set8 = lt0Var.s;
                        obj5 = lt0Var.n;
                        str2 = lt0Var.k;
                        g5Var5 = lt0Var.j;
                        an1Var4 = lt0Var.i;
                        hq0 hq0Var32 = lt0Var.f;
                        hq0 hq0Var33 = lt0Var.e;
                        bz3.g(obj15);
                        hq0Var9 = hq0Var33;
                        hq0Var11 = hq0Var32;
                        lt0 lt0Var7 = lt0Var;
                        i11 = i34;
                        obj6 = obj15;
                        dd1Var2 = dd1Var2;
                        set = set8;
                        i7 = i37;
                        lt0Var2 = lt0Var7;
                        j2 = j12;
                        i8 = i35;
                        i12 = i36;
                        j7 = j2;
                        if (((Number) obj6).longValue() == j7) {
                            set7 = set;
                            f0 f0Var14 = mt0Var.c;
                            lt0Var2.e = hq0Var9;
                            lt0Var2.f = hq0Var11;
                            lt0Var2.i = an1Var4;
                            lt0Var2.j = g5Var5;
                            lt0Var2.k = str2;
                            lt0Var2.n = obj5;
                            hq0Var19 = hq0Var11;
                            lt0Var2.s = set7;
                            lt0Var2.u = i7;
                            lt0Var2.v = i12;
                            lt0Var2.H = j7;
                            lt0Var2.w = i8;
                            lt0Var2.x = i11;
                            lt0Var2.Z = 8;
                            objC3 = rn4.c(f0Var14.b, lt0Var2);
                            if (objC3 == obj14) {
                                i13 = i11;
                                str3 = str2;
                                i16 = i7;
                                i15 = i8;
                                hq0Var12 = hq0Var9;
                                g5Var6 = g5Var5;
                                set2 = set7;
                                obj7 = objC3;
                                obj8 = obj5;
                                i14 = i12;
                                j3 = j7;
                                lt0Var3 = lt0Var2;
                                hq0Var13 = hq0Var19;
                                j4 = j3;
                                obj11 = obj14;
                                if (((o) obj7).a) {
                                    if (obj8 instanceof h72) {
                                        obj12 = null;
                                    } else {
                                        obj12 = obj8;
                                    }
                                    pd1Var = (pd1) obj12;
                                    if (pd1Var != null) {
                                        list = pd1Var.b;
                                    } else {
                                        list = null;
                                    }
                                    obj13 = obj8;
                                    if (list == null) {
                                        it = list.iterator();
                                        do {
                                            if (it.hasNext()) {
                                                next = it.next();
                                            } else {
                                                next = null;
                                            }
                                            str6 = (String) next;
                                            if (str6 == null) {
                                                an1Var2 = an1Var4;
                                            } else {
                                                set2.add(str6);
                                                l82 l82Var6 = g5Var6.a;
                                                q03 q03Var6 = g5Var6.b;
                                                boolean z118 = g5Var6.c;
                                                b60 b60Var6 = g5Var6.d;
                                                String str13 = g5Var6.e;
                                                boolean z119 = g5Var6.g;
                                                l61 l61Var6 = g5Var6.h;
                                                boolean z1110 = g5Var6.i;
                                                boolean z1111 = g5Var6.j;
                                                boolean z1112 = g5Var6.k;
                                                l61Var6.getClass();
                                                g5 g5Var14 = new g5(l82Var6, q03Var6, z118, b60Var6, str13, str6, z119, l61Var6, z1110, z1111, z1112);
                                                lt0Var3.e = hq0Var12;
                                                lt0Var3.f = hq0Var13;
                                                lt0Var3.i = an1Var4;
                                                lt0Var3.j = g5Var6;
                                                lt0Var3.k = str3;
                                                lt0Var3.n = null;
                                                lt0Var3.s = set2;
                                                lt0Var3.t = str6;
                                                lt0Var3.u = i16;
                                                lt0Var3.v = i14;
                                                lt0Var3.H = j4;
                                                lt0Var3.w = i15;
                                                lt0Var3.x = i13;
                                                lt0Var3.Z = 9;
                                                mt0Var = this;
                                                i19 = 1;
                                                z = false;
                                                objE2 = mt0Var.e(g5Var14, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                obj14 = obj11;
                                                if (objE2 != obj14) {
                                                    int i212 = i16;
                                                    str4 = str3;
                                                    lt0Var = lt0Var3;
                                                    i18 = i212;
                                                    obj9 = objE2;
                                                    hq0Var14 = hq0Var13;
                                                    i17 = i14;
                                                    set3 = set2;
                                                    str5 = str6;
                                                    be1Var2 = (be1) obj9;
                                                    be1Var2.getClass();
                                                    Object obj111 = obj14;
                                                    if (be1Var2.e) {
                                                    }
                                                    be1Var = be1Var2;
                                                    break;
                                                }
                                            }
                                            jr2 jr2Var110 = mt0Var.k;
                                            ee1 ee1Var21 = new ee1("No compatible Gemini Live model answered for this key. SONIC will recheck automatically.", 47);
                                            jr2Var110.getClass();
                                            jr2Var110.j(null, ee1Var21);
                                            be1Var = new be1(dd1Var2, 30);
                                            obj3 = null;
                                            an1Var2.h(obj3);
                                            return be1Var;
                                        } while (set2.contains((String) next));
                                        str6 = (String) next;
                                        if (str6 == null) {
                                            an1Var2 = an1Var4;
                                        } else {
                                            set2.add(str6);
                                            l82 l82Var7 = g5Var6.a;
                                            q03 q03Var7 = g5Var6.b;
                                            boolean z1113 = g5Var6.c;
                                            b60 b60Var7 = g5Var6.d;
                                            String str14 = g5Var6.e;
                                            boolean z1114 = g5Var6.g;
                                            l61 l61Var7 = g5Var6.h;
                                            boolean z1115 = g5Var6.i;
                                            boolean z1116 = g5Var6.j;
                                            boolean z1117 = g5Var6.k;
                                            l61Var7.getClass();
                                            g5 g5Var15 = new g5(l82Var7, q03Var7, z1113, b60Var7, str14, str6, z1114, l61Var7, z1115, z1116, z1117);
                                            lt0Var3.e = hq0Var12;
                                            lt0Var3.f = hq0Var13;
                                            lt0Var3.i = an1Var4;
                                            lt0Var3.j = g5Var6;
                                            lt0Var3.k = str3;
                                            lt0Var3.n = null;
                                            lt0Var3.s = set2;
                                            lt0Var3.t = str6;
                                            lt0Var3.u = i16;
                                            lt0Var3.v = i14;
                                            lt0Var3.H = j4;
                                            lt0Var3.w = i15;
                                            lt0Var3.x = i13;
                                            lt0Var3.Z = 9;
                                            mt0Var = this;
                                            i19 = 1;
                                            z = false;
                                            objE2 = mt0Var.e(g5Var15, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                            obj14 = obj11;
                                            if (objE2 != obj14) {
                                                int i213 = i16;
                                                str4 = str3;
                                                lt0Var = lt0Var3;
                                                i18 = i213;
                                                obj9 = objE2;
                                                hq0Var14 = hq0Var13;
                                                i17 = i14;
                                                set3 = set2;
                                                str5 = str6;
                                                be1Var2 = (be1) obj9;
                                                be1Var2.getClass();
                                                Object obj112 = obj14;
                                                if (be1Var2.e) {
                                                }
                                                be1Var = be1Var2;
                                                break;
                                            }
                                        }
                                        jr2 jr2Var111 = mt0Var.k;
                                        ee1 ee1Var22 = new ee1("No compatible Gemini Live model answered for this key. SONIC will recheck automatically.", 47);
                                        jr2Var111.getClass();
                                        jr2Var111.j(null, ee1Var22);
                                        be1Var = new be1(dd1Var2, 30);
                                        obj3 = null;
                                        an1Var2.h(obj3);
                                        return be1Var;
                                    }
                                    w30 w30VarB4 = oj4.b(i72.a(obj13));
                                    iOrdinal = w30VarB4.ordinal();
                                    if (iOrdinal != 1) {
                                        dd1Var = dd1.a;
                                    } else {
                                        dd1Var = dd1.a;
                                    }
                                    jr2 jr2Var112 = mt0Var.k;
                                    ee1 ee1Var110 = new ee1(oj4.d(w30VarB4), 47);
                                    jr2Var112.getClass();
                                    jr2Var112.j(null, ee1Var110);
                                    be1Var = new be1(dd1Var, 30);
                                    break;
                                    an1Var2 = an1Var4;
                                    obj3 = null;
                                    an1Var2.h(obj3);
                                    return be1Var;
                                }
                                an1Var2 = an1Var4;
                            }
                            return obj14;
                        }
                        an1Var2 = an1Var4;
                        mt0Var.o();
                        jr2 jr2Var113 = mt0Var.k;
                        ee1 ee1Var111 = new ee1(null, 63);
                        jr2Var113.getClass();
                        jr2Var113.j(null, ee1Var111);
                        be1Var = new be1(null, 27);
                        obj3 = null;
                        an1Var2.h(obj3);
                        return be1Var;
                    case 8:
                        int i38 = lt0Var.x;
                        int i39 = lt0Var.w;
                        long j13 = lt0Var.H;
                        int i40 = lt0Var.v;
                        int i41 = lt0Var.u;
                        Set set9 = lt0Var.s;
                        Object obj20 = lt0Var.n;
                        String str15 = lt0Var.k;
                        g5 g5Var16 = lt0Var.j;
                        an1Var4 = lt0Var.i;
                        hq0 hq0Var34 = lt0Var.f;
                        hq0 hq0Var35 = lt0Var.e;
                        bz3.g(obj15);
                        i13 = i38;
                        obj7 = obj15;
                        dd1Var2 = dd1Var2;
                        j3 = j13;
                        hq0Var12 = hq0Var35;
                        obj8 = obj20;
                        i14 = i40;
                        hq0Var13 = hq0Var34;
                        g5Var6 = g5Var16;
                        set2 = set9;
                        i15 = i39;
                        lt0Var3 = lt0Var;
                        str3 = str15;
                        i16 = i41;
                        j4 = j3;
                        obj11 = obj14;
                        if (((o) obj7).a) {
                            if (obj8 instanceof h72) {
                                obj12 = null;
                            } else {
                                obj12 = obj8;
                            }
                            pd1Var = (pd1) obj12;
                            if (pd1Var != null) {
                                list = pd1Var.b;
                            } else {
                                list = null;
                            }
                            obj13 = obj8;
                            if (list == null) {
                                it = list.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next = it.next();
                                    } else {
                                        next = null;
                                    }
                                    str6 = (String) next;
                                    if (str6 == null) {
                                        set2.add(str6);
                                        l82 l82Var8 = g5Var6.a;
                                        q03 q03Var8 = g5Var6.b;
                                        boolean z1118 = g5Var6.c;
                                        b60 b60Var8 = g5Var6.d;
                                        String str16 = g5Var6.e;
                                        boolean z1119 = g5Var6.g;
                                        l61 l61Var8 = g5Var6.h;
                                        boolean z11110 = g5Var6.i;
                                        boolean z11111 = g5Var6.j;
                                        boolean z11112 = g5Var6.k;
                                        l61Var8.getClass();
                                        g5 g5Var17 = new g5(l82Var8, q03Var8, z1118, b60Var8, str16, str6, z1119, l61Var8, z11110, z11111, z11112);
                                        lt0Var3.e = hq0Var12;
                                        lt0Var3.f = hq0Var13;
                                        lt0Var3.i = an1Var4;
                                        lt0Var3.j = g5Var6;
                                        lt0Var3.k = str3;
                                        lt0Var3.n = null;
                                        lt0Var3.s = set2;
                                        lt0Var3.t = str6;
                                        lt0Var3.u = i16;
                                        lt0Var3.v = i14;
                                        lt0Var3.H = j4;
                                        lt0Var3.w = i15;
                                        lt0Var3.x = i13;
                                        lt0Var3.Z = 9;
                                        mt0Var = this;
                                        i19 = 1;
                                        z = false;
                                        objE2 = mt0Var.e(g5Var17, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                        obj14 = obj11;
                                        if (objE2 != obj14) {
                                            int i214 = i16;
                                            str4 = str3;
                                            lt0Var = lt0Var3;
                                            i18 = i214;
                                            obj9 = objE2;
                                            hq0Var14 = hq0Var13;
                                            i17 = i14;
                                            set3 = set2;
                                            str5 = str6;
                                            be1Var2 = (be1) obj9;
                                            be1Var2.getClass();
                                            Object obj113 = obj14;
                                            if (be1Var2.e) {
                                            }
                                            be1Var = be1Var2;
                                            break;
                                        }
                                        return obj14;
                                    }
                                    an1Var2 = an1Var4;
                                    jr2 jr2Var114 = mt0Var.k;
                                    ee1 ee1Var23 = new ee1("No compatible Gemini Live model answered for this key. SONIC will recheck automatically.", 47);
                                    jr2Var114.getClass();
                                    jr2Var114.j(null, ee1Var23);
                                    be1Var = new be1(dd1Var2, 30);
                                    obj3 = null;
                                    an1Var2.h(obj3);
                                    return be1Var;
                                } while (set2.contains((String) next));
                                str6 = (String) next;
                                if (str6 == null) {
                                    set2.add(str6);
                                    l82 l82Var9 = g5Var6.a;
                                    q03 q03Var9 = g5Var6.b;
                                    boolean z11113 = g5Var6.c;
                                    b60 b60Var9 = g5Var6.d;
                                    String str17 = g5Var6.e;
                                    boolean z11114 = g5Var6.g;
                                    l61 l61Var9 = g5Var6.h;
                                    boolean z11115 = g5Var6.i;
                                    boolean z11116 = g5Var6.j;
                                    boolean z11117 = g5Var6.k;
                                    l61Var9.getClass();
                                    g5 g5Var18 = new g5(l82Var9, q03Var9, z11113, b60Var9, str17, str6, z11114, l61Var9, z11115, z11116, z11117);
                                    lt0Var3.e = hq0Var12;
                                    lt0Var3.f = hq0Var13;
                                    lt0Var3.i = an1Var4;
                                    lt0Var3.j = g5Var6;
                                    lt0Var3.k = str3;
                                    lt0Var3.n = null;
                                    lt0Var3.s = set2;
                                    lt0Var3.t = str6;
                                    lt0Var3.u = i16;
                                    lt0Var3.v = i14;
                                    lt0Var3.H = j4;
                                    lt0Var3.w = i15;
                                    lt0Var3.x = i13;
                                    lt0Var3.Z = 9;
                                    mt0Var = this;
                                    i19 = 1;
                                    z = false;
                                    objE2 = mt0Var.e(g5Var18, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                    obj14 = obj11;
                                    if (objE2 != obj14) {
                                        int i215 = i16;
                                        str4 = str3;
                                        lt0Var = lt0Var3;
                                        i18 = i215;
                                        obj9 = objE2;
                                        hq0Var14 = hq0Var13;
                                        i17 = i14;
                                        set3 = set2;
                                        str5 = str6;
                                        be1Var2 = (be1) obj9;
                                        be1Var2.getClass();
                                        Object obj114 = obj14;
                                        if (be1Var2.e) {
                                        }
                                        be1Var = be1Var2;
                                        break;
                                    }
                                    return obj14;
                                }
                                an1Var2 = an1Var4;
                                jr2 jr2Var115 = mt0Var.k;
                                ee1 ee1Var24 = new ee1("No compatible Gemini Live model answered for this key. SONIC will recheck automatically.", 47);
                                jr2Var115.getClass();
                                jr2Var115.j(null, ee1Var24);
                                be1Var = new be1(dd1Var2, 30);
                                obj3 = null;
                                an1Var2.h(obj3);
                                return be1Var;
                            }
                            w30 w30VarB5 = oj4.b(i72.a(obj13));
                            iOrdinal = w30VarB5.ordinal();
                            if (iOrdinal != 1) {
                                dd1Var = dd1.a;
                            } else {
                                dd1Var = dd1.a;
                            }
                            jr2 jr2Var116 = mt0Var.k;
                            ee1 ee1Var112 = new ee1(oj4.d(w30VarB5), 47);
                            jr2Var116.getClass();
                            jr2Var116.j(null, ee1Var112);
                            be1Var = new be1(dd1Var, 30);
                            break;
                            an1Var2 = an1Var4;
                            obj3 = null;
                            an1Var2.h(obj3);
                            return be1Var;
                        }
                        an1Var2 = an1Var4;
                        mt0Var.o();
                        jr2 jr2Var117 = mt0Var.k;
                        ee1 ee1Var113 = new ee1(null, 63);
                        jr2Var117.getClass();
                        jr2Var117.j(null, ee1Var113);
                        be1Var = new be1(null, 27);
                        obj3 = null;
                        an1Var2.h(obj3);
                        return be1Var;
                    case 9:
                        int i42 = lt0Var.x;
                        int i43 = lt0Var.w;
                        long j14 = lt0Var.H;
                        i17 = lt0Var.v;
                        i18 = lt0Var.u;
                        String str18 = lt0Var.t;
                        Set set10 = lt0Var.s;
                        str4 = lt0Var.k;
                        g5 g5Var19 = lt0Var.j;
                        an1Var4 = lt0Var.i;
                        hq0 hq0Var36 = lt0Var.f;
                        hq0 hq0Var37 = lt0Var.e;
                        bz3.g(obj15);
                        i13 = i42;
                        obj9 = obj15;
                        dd1Var2 = dd1Var2;
                        set3 = set10;
                        i19 = 1;
                        z = false;
                        str5 = str18;
                        i15 = i43;
                        j4 = j14;
                        hq0Var12 = hq0Var37;
                        hq0Var14 = hq0Var36;
                        g5Var6 = g5Var19;
                        be1Var2 = (be1) obj9;
                        be1Var2.getClass();
                        Object obj115 = obj14;
                        if (be1Var2.e) {
                            break;
                        }
                        be1Var = be1Var2;
                        an1Var2 = an1Var4;
                        obj3 = null;
                        an1Var2.h(obj3);
                        return be1Var;
                    case 10:
                        i20 = lt0Var.x;
                        i21 = lt0Var.w;
                        long j15 = lt0Var.H;
                        int i44 = lt0Var.v;
                        int i45 = lt0Var.u;
                        Set set11 = lt0Var.s;
                        str4 = lt0Var.k;
                        g5 g5Var20 = lt0Var.j;
                        an1Var4 = lt0Var.i;
                        hq0 hq0Var38 = lt0Var.f;
                        hq0 hq0Var39 = lt0Var.e;
                        bz3.g(obj15);
                        dd1Var2 = dd1Var2;
                        i19 = 1;
                        z = false;
                        j5 = j15;
                        hq0Var15 = hq0Var39;
                        i22 = i45;
                        hq0Var16 = hq0Var38;
                        set4 = set11;
                        i23 = i44;
                        g5Var7 = g5Var20;
                        an1Var5 = an1Var4;
                        j6 = j5;
                        ps0 ps0Var4 = mt0Var.h;
                        set5 = set4;
                        if (i21 == 0) {
                            z2 = i19;
                        } else {
                            z2 = z;
                        }
                        lt0Var.e = hq0Var15;
                        lt0Var.f = hq0Var16;
                        lt0Var.i = an1Var5;
                        lt0Var.j = g5Var7;
                        lt0Var.k = str4;
                        hq0Var17 = hq0Var16;
                        lt0Var.n = null;
                        lt0Var.s = set5;
                        lt0Var.t = null;
                        lt0Var.u = i22;
                        lt0Var.v = i23;
                        lt0Var.H = j6;
                        lt0Var.w = i21;
                        lt0Var.x = i20;
                        lt0Var.Z = 11;
                        objA = ps0Var4.a(z2, lt0Var);
                        if (objA != obj14) {
                            set6 = set5;
                            g5Var4 = g5Var7;
                            i9 = i23;
                            an1Var3 = an1Var5;
                            i7 = i22;
                            obj10 = objA;
                            hq0Var18 = hq0Var15;
                            str = str4;
                            hq0Var10 = hq0Var17;
                            linkedHashSet = set6;
                            i8 = i19;
                            hq0Var9 = hq0Var18;
                            long j16 = j6;
                            obj4 = obj10;
                            i10 = i20 + 1;
                            j = j16;
                            if (i10 >= 4) {
                                if (mt0Var.v) {
                                    f0 f0Var15 = mt0Var.c;
                                    lt0Var.e = hq0Var9;
                                    lt0Var.f = hq0Var10;
                                    lt0Var.i = an1Var3;
                                    lt0Var.j = g5Var4;
                                    lt0Var.k = str;
                                    lt0Var.n = obj4;
                                    str7 = str;
                                    lt0Var.s = linkedHashSet;
                                    lt0Var.t = null;
                                    lt0Var.u = i7;
                                    lt0Var.v = i9;
                                    lt0Var.H = j;
                                    lt0Var.w = i8;
                                    lt0Var.x = i10;
                                    lt0Var.Z = 7;
                                    objI2 = f0Var15.i(lt0Var);
                                    if (objI2 != obj14) {
                                        an1Var4 = an1Var3;
                                        obj5 = obj4;
                                        g5Var5 = g5Var4;
                                        set = linkedHashSet;
                                        obj6 = objI2;
                                        hq0 hq0Var215 = hq0Var10;
                                        str2 = str7;
                                        lt0 lt0Var8 = lt0Var;
                                        i11 = i10;
                                        hq0Var11 = hq0Var215;
                                        j2 = j;
                                        lt0Var2 = lt0Var8;
                                        i12 = i9;
                                        j7 = j2;
                                        if (((Number) obj6).longValue() == j7) {
                                            set7 = set;
                                            f0 f0Var16 = mt0Var.c;
                                            lt0Var2.e = hq0Var9;
                                            lt0Var2.f = hq0Var11;
                                            lt0Var2.i = an1Var4;
                                            lt0Var2.j = g5Var5;
                                            lt0Var2.k = str2;
                                            lt0Var2.n = obj5;
                                            hq0Var19 = hq0Var11;
                                            lt0Var2.s = set7;
                                            lt0Var2.u = i7;
                                            lt0Var2.v = i12;
                                            lt0Var2.H = j7;
                                            lt0Var2.w = i8;
                                            lt0Var2.x = i11;
                                            lt0Var2.Z = 8;
                                            objC3 = rn4.c(f0Var16.b, lt0Var2);
                                            if (objC3 == obj14) {
                                                i13 = i11;
                                                str3 = str2;
                                                i16 = i7;
                                                i15 = i8;
                                                hq0Var12 = hq0Var9;
                                                g5Var6 = g5Var5;
                                                set2 = set7;
                                                obj7 = objC3;
                                                obj8 = obj5;
                                                i14 = i12;
                                                j3 = j7;
                                                lt0Var3 = lt0Var2;
                                                hq0Var13 = hq0Var19;
                                                j4 = j3;
                                                obj11 = obj14;
                                                if (((o) obj7).a) {
                                                    if (obj8 instanceof h72) {
                                                        obj12 = null;
                                                    } else {
                                                        obj12 = obj8;
                                                    }
                                                    pd1Var = (pd1) obj12;
                                                    if (pd1Var != null) {
                                                        list = pd1Var.b;
                                                    } else {
                                                        list = null;
                                                    }
                                                    obj13 = obj8;
                                                    if (list == null) {
                                                        w30 w30VarB6 = oj4.b(i72.a(obj13));
                                                        iOrdinal = w30VarB6.ordinal();
                                                        if (iOrdinal != 1) {
                                                            dd1Var = dd1.a;
                                                        } else {
                                                            dd1Var = dd1.a;
                                                        }
                                                        jr2 jr2Var118 = mt0Var.k;
                                                        ee1 ee1Var114 = new ee1(oj4.d(w30VarB6), 47);
                                                        jr2Var118.getClass();
                                                        jr2Var118.j(null, ee1Var114);
                                                        be1Var = new be1(dd1Var, 30);
                                                        break;
                                                    } else {
                                                        it = list.iterator();
                                                        do {
                                                            if (it.hasNext()) {
                                                                next = it.next();
                                                            } else {
                                                                next = null;
                                                            }
                                                            str6 = (String) next;
                                                            if (str6 == null) {
                                                                an1Var2 = an1Var4;
                                                            } else {
                                                                set2.add(str6);
                                                                l82 l82Var10 = g5Var6.a;
                                                                q03 q03Var10 = g5Var6.b;
                                                                boolean z11118 = g5Var6.c;
                                                                b60 b60Var10 = g5Var6.d;
                                                                String str19 = g5Var6.e;
                                                                boolean z11119 = g5Var6.g;
                                                                l61 l61Var10 = g5Var6.h;
                                                                boolean z111110 = g5Var6.i;
                                                                boolean z111111 = g5Var6.j;
                                                                boolean z111112 = g5Var6.k;
                                                                l61Var10.getClass();
                                                                g5 g5Var110 = new g5(l82Var10, q03Var10, z11118, b60Var10, str19, str6, z11119, l61Var10, z111110, z111111, z111112);
                                                                lt0Var3.e = hq0Var12;
                                                                lt0Var3.f = hq0Var13;
                                                                lt0Var3.i = an1Var4;
                                                                lt0Var3.j = g5Var6;
                                                                lt0Var3.k = str3;
                                                                lt0Var3.n = null;
                                                                lt0Var3.s = set2;
                                                                lt0Var3.t = str6;
                                                                lt0Var3.u = i16;
                                                                lt0Var3.v = i14;
                                                                lt0Var3.H = j4;
                                                                lt0Var3.w = i15;
                                                                lt0Var3.x = i13;
                                                                lt0Var3.Z = 9;
                                                                mt0Var = this;
                                                                i19 = 1;
                                                                z = false;
                                                                objE2 = mt0Var.e(g5Var110, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                                obj14 = obj11;
                                                                if (objE2 != obj14) {
                                                                    int i216 = i16;
                                                                    str4 = str3;
                                                                    lt0Var = lt0Var3;
                                                                    i18 = i216;
                                                                    obj9 = objE2;
                                                                    hq0Var14 = hq0Var13;
                                                                    i17 = i14;
                                                                    set3 = set2;
                                                                    str5 = str6;
                                                                    be1Var2 = (be1) obj9;
                                                                    be1Var2.getClass();
                                                                    Object obj116 = obj14;
                                                                    if (be1Var2.e) {
                                                                    }
                                                                    be1Var = be1Var2;
                                                                    break;
                                                                }
                                                            }
                                                        } while (set2.contains((String) next));
                                                        str6 = (String) next;
                                                        if (str6 == null) {
                                                            an1Var2 = an1Var4;
                                                        } else {
                                                            set2.add(str6);
                                                            l82 l82Var11 = g5Var6.a;
                                                            q03 q03Var11 = g5Var6.b;
                                                            boolean z111113 = g5Var6.c;
                                                            b60 b60Var11 = g5Var6.d;
                                                            String str110 = g5Var6.e;
                                                            boolean z111114 = g5Var6.g;
                                                            l61 l61Var11 = g5Var6.h;
                                                            boolean z111115 = g5Var6.i;
                                                            boolean z111116 = g5Var6.j;
                                                            boolean z111117 = g5Var6.k;
                                                            l61Var11.getClass();
                                                            g5 g5Var111 = new g5(l82Var11, q03Var11, z111113, b60Var11, str110, str6, z111114, l61Var11, z111115, z111116, z111117);
                                                            lt0Var3.e = hq0Var12;
                                                            lt0Var3.f = hq0Var13;
                                                            lt0Var3.i = an1Var4;
                                                            lt0Var3.j = g5Var6;
                                                            lt0Var3.k = str3;
                                                            lt0Var3.n = null;
                                                            lt0Var3.s = set2;
                                                            lt0Var3.t = str6;
                                                            lt0Var3.u = i16;
                                                            lt0Var3.v = i14;
                                                            lt0Var3.H = j4;
                                                            lt0Var3.w = i15;
                                                            lt0Var3.x = i13;
                                                            lt0Var3.Z = 9;
                                                            mt0Var = this;
                                                            i19 = 1;
                                                            z = false;
                                                            objE2 = mt0Var.e(g5Var111, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                            obj14 = obj11;
                                                            if (objE2 != obj14) {
                                                                int i217 = i16;
                                                                str4 = str3;
                                                                lt0Var = lt0Var3;
                                                                i18 = i217;
                                                                obj9 = objE2;
                                                                hq0Var14 = hq0Var13;
                                                                i17 = i14;
                                                                set3 = set2;
                                                                str5 = str6;
                                                                be1Var2 = (be1) obj9;
                                                                be1Var2.getClass();
                                                                Object obj117 = obj14;
                                                                if (be1Var2.e) {
                                                                }
                                                                be1Var = be1Var2;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    an1Var2 = an1Var4;
                                                    obj3 = null;
                                                    an1Var2.h(obj3);
                                                    return be1Var;
                                                }
                                                an1Var2 = an1Var4;
                                            }
                                        } else {
                                            an1Var2 = an1Var4;
                                        }
                                    }
                                } else {
                                    an1Var2 = an1Var3;
                                }
                                mt0Var.o();
                                jr2 jr2Var119 = mt0Var.k;
                                ee1 ee1Var115 = new ee1(null, 63);
                                jr2Var119.getClass();
                                jr2Var119.j(null, ee1Var115);
                                be1Var = new be1(null, 27);
                                obj3 = null;
                                an1Var2.h(obj3);
                                return be1Var;
                            }
                            an1Var2 = an1Var3;
                            jr2 jr2Var1110 = mt0Var.k;
                            ee1 ee1Var25 = new ee1("No compatible Gemini Live model answered for this key. SONIC will recheck automatically.", 47);
                            jr2Var1110.getClass();
                            jr2Var1110.j(null, ee1Var25);
                            be1Var = new be1(dd1Var2, 30);
                            obj3 = null;
                            an1Var2.h(obj3);
                            return be1Var;
                        }
                        return obj14;
                    case 11:
                        i20 = lt0Var.x;
                        j6 = lt0Var.H;
                        int i46 = lt0Var.v;
                        int i47 = lt0Var.u;
                        set6 = lt0Var.s;
                        String str20 = lt0Var.k;
                        g5 g5Var21 = lt0Var.j;
                        an1 an1Var8 = lt0Var.i;
                        hq0 hq0Var40 = lt0Var.f;
                        hq0 hq0Var41 = lt0Var.e;
                        bz3.g(obj15);
                        obj10 = ((i72) obj15).a;
                        str = str20;
                        hq0Var18 = hq0Var41;
                        dd1Var2 = dd1Var2;
                        i19 = 1;
                        g5Var4 = g5Var21;
                        i9 = i46;
                        an1Var3 = an1Var8;
                        i7 = i47;
                        hq0Var10 = hq0Var40;
                        linkedHashSet = set6;
                        i8 = i19;
                        hq0Var9 = hq0Var18;
                        long j17 = j6;
                        obj4 = obj10;
                        i10 = i20 + 1;
                        j = j17;
                        if (i10 >= 4) {
                            if (mt0Var.v) {
                                f0 f0Var17 = mt0Var.c;
                                lt0Var.e = hq0Var9;
                                lt0Var.f = hq0Var10;
                                lt0Var.i = an1Var3;
                                lt0Var.j = g5Var4;
                                lt0Var.k = str;
                                lt0Var.n = obj4;
                                str7 = str;
                                lt0Var.s = linkedHashSet;
                                lt0Var.t = null;
                                lt0Var.u = i7;
                                lt0Var.v = i9;
                                lt0Var.H = j;
                                lt0Var.w = i8;
                                lt0Var.x = i10;
                                lt0Var.Z = 7;
                                objI2 = f0Var17.i(lt0Var);
                                if (objI2 != obj14) {
                                    an1Var4 = an1Var3;
                                    obj5 = obj4;
                                    g5Var5 = g5Var4;
                                    set = linkedHashSet;
                                    obj6 = objI2;
                                    hq0 hq0Var216 = hq0Var10;
                                    str2 = str7;
                                    lt0 lt0Var9 = lt0Var;
                                    i11 = i10;
                                    hq0Var11 = hq0Var216;
                                    j2 = j;
                                    lt0Var2 = lt0Var9;
                                    i12 = i9;
                                    j7 = j2;
                                    if (((Number) obj6).longValue() == j7) {
                                        set7 = set;
                                        f0 f0Var18 = mt0Var.c;
                                        lt0Var2.e = hq0Var9;
                                        lt0Var2.f = hq0Var11;
                                        lt0Var2.i = an1Var4;
                                        lt0Var2.j = g5Var5;
                                        lt0Var2.k = str2;
                                        lt0Var2.n = obj5;
                                        hq0Var19 = hq0Var11;
                                        lt0Var2.s = set7;
                                        lt0Var2.u = i7;
                                        lt0Var2.v = i12;
                                        lt0Var2.H = j7;
                                        lt0Var2.w = i8;
                                        lt0Var2.x = i11;
                                        lt0Var2.Z = 8;
                                        objC3 = rn4.c(f0Var18.b, lt0Var2);
                                        if (objC3 == obj14) {
                                            i13 = i11;
                                            str3 = str2;
                                            i16 = i7;
                                            i15 = i8;
                                            hq0Var12 = hq0Var9;
                                            g5Var6 = g5Var5;
                                            set2 = set7;
                                            obj7 = objC3;
                                            obj8 = obj5;
                                            i14 = i12;
                                            j3 = j7;
                                            lt0Var3 = lt0Var2;
                                            hq0Var13 = hq0Var19;
                                            j4 = j3;
                                            obj11 = obj14;
                                            if (((o) obj7).a) {
                                                if (obj8 instanceof h72) {
                                                    obj12 = null;
                                                } else {
                                                    obj12 = obj8;
                                                }
                                                pd1Var = (pd1) obj12;
                                                if (pd1Var != null) {
                                                    list = pd1Var.b;
                                                } else {
                                                    list = null;
                                                }
                                                obj13 = obj8;
                                                if (list == null) {
                                                    w30 w30VarB7 = oj4.b(i72.a(obj13));
                                                    iOrdinal = w30VarB7.ordinal();
                                                    if (iOrdinal != 1) {
                                                        dd1Var = dd1.a;
                                                    } else {
                                                        dd1Var = dd1.a;
                                                    }
                                                    jr2 jr2Var1111 = mt0Var.k;
                                                    ee1 ee1Var116 = new ee1(oj4.d(w30VarB7), 47);
                                                    jr2Var1111.getClass();
                                                    jr2Var1111.j(null, ee1Var116);
                                                    be1Var = new be1(dd1Var, 30);
                                                    break;
                                                } else {
                                                    it = list.iterator();
                                                    do {
                                                        if (it.hasNext()) {
                                                            next = it.next();
                                                        } else {
                                                            next = null;
                                                        }
                                                        str6 = (String) next;
                                                        if (str6 == null) {
                                                            an1Var2 = an1Var4;
                                                        } else {
                                                            set2.add(str6);
                                                            l82 l82Var12 = g5Var6.a;
                                                            q03 q03Var12 = g5Var6.b;
                                                            boolean z111118 = g5Var6.c;
                                                            b60 b60Var12 = g5Var6.d;
                                                            String str111 = g5Var6.e;
                                                            boolean z111119 = g5Var6.g;
                                                            l61 l61Var12 = g5Var6.h;
                                                            boolean z1111110 = g5Var6.i;
                                                            boolean z1111111 = g5Var6.j;
                                                            boolean z1111112 = g5Var6.k;
                                                            l61Var12.getClass();
                                                            g5 g5Var112 = new g5(l82Var12, q03Var12, z111118, b60Var12, str111, str6, z111119, l61Var12, z1111110, z1111111, z1111112);
                                                            lt0Var3.e = hq0Var12;
                                                            lt0Var3.f = hq0Var13;
                                                            lt0Var3.i = an1Var4;
                                                            lt0Var3.j = g5Var6;
                                                            lt0Var3.k = str3;
                                                            lt0Var3.n = null;
                                                            lt0Var3.s = set2;
                                                            lt0Var3.t = str6;
                                                            lt0Var3.u = i16;
                                                            lt0Var3.v = i14;
                                                            lt0Var3.H = j4;
                                                            lt0Var3.w = i15;
                                                            lt0Var3.x = i13;
                                                            lt0Var3.Z = 9;
                                                            mt0Var = this;
                                                            i19 = 1;
                                                            z = false;
                                                            objE2 = mt0Var.e(g5Var112, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                            obj14 = obj11;
                                                            if (objE2 != obj14) {
                                                                int i218 = i16;
                                                                str4 = str3;
                                                                lt0Var = lt0Var3;
                                                                i18 = i218;
                                                                obj9 = objE2;
                                                                hq0Var14 = hq0Var13;
                                                                i17 = i14;
                                                                set3 = set2;
                                                                str5 = str6;
                                                                be1Var2 = (be1) obj9;
                                                                be1Var2.getClass();
                                                                Object obj118 = obj14;
                                                                if (be1Var2.e) {
                                                                }
                                                                be1Var = be1Var2;
                                                                break;
                                                            }
                                                        }
                                                    } while (set2.contains((String) next));
                                                    str6 = (String) next;
                                                    if (str6 == null) {
                                                        an1Var2 = an1Var4;
                                                    } else {
                                                        set2.add(str6);
                                                        l82 l82Var13 = g5Var6.a;
                                                        q03 q03Var13 = g5Var6.b;
                                                        boolean z1111113 = g5Var6.c;
                                                        b60 b60Var13 = g5Var6.d;
                                                        String str112 = g5Var6.e;
                                                        boolean z1111114 = g5Var6.g;
                                                        l61 l61Var13 = g5Var6.h;
                                                        boolean z1111115 = g5Var6.i;
                                                        boolean z1111116 = g5Var6.j;
                                                        boolean z1111117 = g5Var6.k;
                                                        l61Var13.getClass();
                                                        g5 g5Var113 = new g5(l82Var13, q03Var13, z1111113, b60Var13, str112, str6, z1111114, l61Var13, z1111115, z1111116, z1111117);
                                                        lt0Var3.e = hq0Var12;
                                                        lt0Var3.f = hq0Var13;
                                                        lt0Var3.i = an1Var4;
                                                        lt0Var3.j = g5Var6;
                                                        lt0Var3.k = str3;
                                                        lt0Var3.n = null;
                                                        lt0Var3.s = set2;
                                                        lt0Var3.t = str6;
                                                        lt0Var3.u = i16;
                                                        lt0Var3.v = i14;
                                                        lt0Var3.H = j4;
                                                        lt0Var3.w = i15;
                                                        lt0Var3.x = i13;
                                                        lt0Var3.Z = 9;
                                                        mt0Var = this;
                                                        i19 = 1;
                                                        z = false;
                                                        objE2 = mt0Var.e(g5Var113, str3, j4, hq0Var12, hq0Var13, lt0Var3);
                                                        obj14 = obj11;
                                                        if (objE2 != obj14) {
                                                            int i219 = i16;
                                                            str4 = str3;
                                                            lt0Var = lt0Var3;
                                                            i18 = i219;
                                                            obj9 = objE2;
                                                            hq0Var14 = hq0Var13;
                                                            i17 = i14;
                                                            set3 = set2;
                                                            str5 = str6;
                                                            be1Var2 = (be1) obj9;
                                                            be1Var2.getClass();
                                                            Object obj119 = obj14;
                                                            if (be1Var2.e) {
                                                            }
                                                            be1Var = be1Var2;
                                                            break;
                                                        }
                                                    }
                                                }
                                                an1Var2 = an1Var4;
                                                obj3 = null;
                                                an1Var2.h(obj3);
                                                return be1Var;
                                            }
                                            an1Var2 = an1Var4;
                                        }
                                    } else {
                                        an1Var2 = an1Var4;
                                    }
                                }
                                return obj14;
                            }
                            an1Var2 = an1Var3;
                            mt0Var.o();
                            jr2 jr2Var1112 = mt0Var.k;
                            ee1 ee1Var117 = new ee1(null, 63);
                            jr2Var1112.getClass();
                            jr2Var1112.j(null, ee1Var117);
                            be1Var = new be1(null, 27);
                            obj3 = null;
                            an1Var2.h(obj3);
                            return be1Var;
                        }
                        an1Var2 = an1Var3;
                        jr2 jr2Var1113 = mt0Var.k;
                        ee1 ee1Var26 = new ee1("No compatible Gemini Live model answered for this key. SONIC will recheck automatically.", 47);
                        jr2Var1113.getClass();
                        jr2Var1113.j(null, ee1Var26);
                        be1Var = new be1(dd1Var2, 30);
                        obj3 = null;
                        an1Var2.h(obj3);
                        return be1Var;
                    default:
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            an1Var = an1Var4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x009d  */
    public final boolean n(String str) {
        boolean z;
        str.getClass();
        if (((ee1) this.l.a.getValue()).a && !this.w) {
            this.x = false;
            if (xy.o(str)) {
                o();
                return true;
            }
            if (xy.q(str, false)) {
                p();
                return true;
            }
            x32 x32Var = this.r;
            if (x32Var != null) {
                String string = new JSONObject().put("clientContent", new JSONObject().put("turns", new JSONArray().put(new JSONObject().put("role", "user").put("parts", new JSONArray().put(new JSONObject().put("text", str))))).put("turnComplete", true)).toString();
                string.getClass();
                if (x32Var.g(string)) {
                    if (this.E == null) {
                        hd1 hd1Var = this.y;
                        z = (hd1Var != null ? hd1Var.i() : null) != null;
                    }
                    this.O = z;
                    g(true);
                    hd1 hd1Var2 = this.y;
                    if (hd1Var2 != null) {
                        hd1Var2.g();
                    }
                    hd1 hd1Var3 = this.y;
                    if (hd1Var3 != null) {
                        hd1Var3.a(str);
                    }
                    hd1 hd1Var4 = this.y;
                    if (hd1Var4 != null) {
                        hd1Var4.d();
                    }
                    hd1 hd1Var5 = this.y;
                    this.N = hd1Var5 != null ? Long.valueOf(hd1Var5.j()) : null;
                    j();
                    this.f.c();
                    jr2 jr2Var = this.k;
                    while (true) {
                        Object value = jr2Var.getValue();
                        String str2 = str;
                        if (jr2Var.h(value, ee1.a((ee1) value, false, str2, "", null, 51))) {
                            break;
                        }
                        str = str2;
                    }
                    vs0 vs0Var = this.z;
                    if (vs0Var != null) {
                        vs0Var.a();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final void o() {
        this.v = true;
        this.M.incrementAndGet();
        this.N = null;
        this.O = false;
        this.J = false;
        zd1 zd1Var = this.B;
        synchronized (zd1Var) {
            zd1Var.a.clear();
            ((LinkedHashMap) zd1Var.e).clear();
            zd1Var.b.clear();
            zd1Var.c.clear();
            ((LinkedHashMap) zd1Var.f).clear();
        }
        this.E = null;
        this.F = false;
        this.G = 0L;
        this.H = false;
        hd1 hd1Var = this.y;
        if (hd1Var != null) {
            hd1Var.g();
        }
        x00 x00Var = this.u;
        if (x00Var != null) {
            x00Var.b0(q43.a);
        }
        try {
            AudioRecord audioRecord = this.t;
            if (audioRecord != null) {
                audioRecord.stop();
            }
        } catch (Throwable unused) {
        }
        x32 x32Var = this.r;
        if (x32Var != null) {
            m32 m32Var = x32Var.g;
            m32Var.getClass();
            m32Var.d();
        }
        j();
        this.f.c();
    }

    public final void p() {
        hd1 hd1Var = this.y;
        if (hd1Var != null) {
            synchronized (hd1Var) {
                hd1Var.b = true;
            }
        }
        g(true);
        this.B.c(new j(22));
        this.H = false;
        j();
        this.f.c();
    }
}
