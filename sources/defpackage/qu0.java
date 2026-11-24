package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qu0 implements Handler.Callback {
    public static final Status o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status p = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object q = new Object();
    public static qu0 r;
    public long a;
    public boolean b;
    public ow2 c;
    public re3 d;
    public final Context e;
    public final mu0 f;
    public final cu2 g;
    public final AtomicInteger h;
    public final AtomicInteger i;
    public final ConcurrentHashMap j;
    public final pg k;
    public final pg l;
    public final we3 m;
    public volatile boolean n;

    public qu0(Context context, Looper looper) {
        mu0 mu0Var = mu0.d;
        this.a = 10000L;
        this.b = false;
        this.h = new AtomicInteger(1);
        this.i = new AtomicInteger(0);
        this.j = new ConcurrentHashMap(5, 0.75f, 1);
        this.k = new pg(0);
        this.l = new pg(0);
        this.n = true;
        this.e = context;
        we3 we3Var = new we3(looper, this);
        Looper.getMainLooper();
        this.m = we3Var;
        this.f = mu0Var;
        this.g = new cu2(12);
        PackageManager packageManager = context.getPackageManager();
        if (fm4.d == null) {
            fm4.d = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (fm4.d.booleanValue()) {
            this.n = false;
        }
        we3Var.sendMessage(we3Var.obtainMessage(6));
    }

    public static Status c(se seVar, x30 x30Var) {
        return new Status(17, cq.l("API: ", (String) seVar.b.c, " is not available on this device. Connection failed with: ", String.valueOf(x30Var)), x30Var.c, x30Var);
    }

    public static qu0 e(Context context) {
        qu0 qu0Var;
        HandlerThread handlerThread;
        synchronized (q) {
            if (r == null) {
                synchronized (sq4.g) {
                    try {
                        handlerThread = sq4.i;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            sq4.i = handlerThread2;
                            handlerThread2.start();
                            handlerThread = sq4.i;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = mu0.c;
                r = new qu0(applicationContext, looper);
            }
            qu0Var = r;
        }
        return qu0Var;
    }

    public final boolean a() {
        if (this.b) {
            return false;
        }
        r82 r82Var = (r82) q82.D().a;
        if (r82Var != null && !r82Var.b) {
            return false;
        }
        int i = ((SparseIntArray) this.g.b).get(203400000, -1);
        return i == -1 || i == 0;
    }

    public final boolean b(x30 x30Var, int i) {
        boolean zBooleanValue;
        PendingIntent activity;
        Boolean bool;
        mu0 mu0Var = this.f;
        Context context = this.e;
        mu0Var.getClass();
        synchronized (y11.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = y11.a;
            if (context2 == null || (bool = y11.b) == null || context2 != applicationContext) {
                y11.b = null;
                boolean zIsInstantApp = applicationContext.getPackageManager().isInstantApp();
                y11.b = Boolean.valueOf(zIsInstantApp);
                y11.a = applicationContext;
                zBooleanValue = zIsInstantApp;
            } else {
                zBooleanValue = bool.booleanValue();
            }
        }
        if (!zBooleanValue) {
            int i2 = x30Var.b;
            if (i2 == 0 || (activity = x30Var.c) == null) {
                Intent intentA = mu0Var.a(i2, context, null);
                activity = intentA != null ? PendingIntent.getActivity(context, 0, intentA, 201326592) : null;
            }
            if (activity != null) {
                int i3 = x30Var.b;
                int i4 = GoogleApiActivity.b;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                mu0Var.f(context, i3, PendingIntent.getActivity(context, 0, intent, se3.a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final wd3 d(re3 re3Var) {
        se seVar = re3Var.e;
        ConcurrentHashMap concurrentHashMap = this.j;
        wd3 wd3Var = (wd3) concurrentHashMap.get(seVar);
        if (wd3Var == null) {
            wd3Var = new wd3(this, re3Var);
            concurrentHashMap.put(seVar, wd3Var);
        }
        if (wd3Var.b.j()) {
            this.l.add(seVar);
        }
        wd3Var.m();
        return wd3Var;
    }

    public final void f(x30 x30Var, int i) {
        if (b(x30Var, i)) {
            return;
        }
        we3 we3Var = this.m;
        we3Var.sendMessage(we3Var.obtainMessage(5, i, 0, x30Var));
    }

    /* JADX WARN: Code duplicated, block: B:172:0x0344  */
    /* JADX WARN: Code duplicated, block: B:174:0x034a  */
    /* JADX WARN: Code duplicated, block: B:176:0x0368  */
    /* JADX WARN: Code duplicated, block: B:178:0x0372  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v5 wd3, still in use, count: 2, list:
          (r2v5 wd3) from 0x033c: IGET (r2v5 wd3) A[WRAPPED] (LINE:829) wd3.g int
          (r2v5 wd3) from 0x0342: PHI (r2 I:??) = (r2v2 wd3), (r2v5 wd3) binds: [B:170:0x0341, B:228:0x0342] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message r11) {
        /*
            Method dump skipped, instruction units count: 1102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qu0.handleMessage(android.os.Message):boolean");
    }
}
