package com.project.sonic.background;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import com.project.sonic.MainActivity;
import com.project.sonic.R;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import defpackage.ah;
import defpackage.ap2;
import defpackage.bd1;
import defpackage.bh;
import defpackage.bz3;
import defpackage.co2;
import defpackage.dt1;
import defpackage.ee1;
import defpackage.eh2;
import defpackage.ft2;
import defpackage.fw0;
import defpackage.g31;
import defpackage.gu;
import defpackage.h60;
import defpackage.ig1;
import defpackage.in2;
import defpackage.j5;
import defpackage.jr2;
import defpackage.l90;
import defpackage.l93;
import defpackage.ld0;
import defpackage.mo2;
import defpackage.mt0;
import defpackage.og;
import defpackage.oj1;
import defpackage.oo1;
import defpackage.pl4;
import defpackage.pn2;
import defpackage.po1;
import defpackage.q43;
import defpackage.rn2;
import defpackage.sc2;
import defpackage.t70;
import defpackage.t80;
import defpackage.tl4;
import defpackage.tv1;
import defpackage.uf4;
import defpackage.v80;
import defpackage.w50;
import defpackage.wa4;
import defpackage.x50;
import defpackage.xa0;
import defpackage.y50;
import defpackage.yg;
import defpackage.yo2;
import defpackage.yq2;
import defpackage.zo2;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class SonicVoiceService extends Service implements GeneratedComponentManagerHolder {
    public static final /* synthetic */ int d0 = 0;
    public yq2 H;
    public final fw0 X;
    public boolean Y;
    public boolean Z;
    public volatile eh2 a;
    public final Object b = new Object();
    public boolean c = false;
    public final gu c0;
    public pn2 e;
    public l93 f;
    public in2 i;
    public co2 j;
    public dt1 k;
    public oj1 n;
    public j5 s;
    public mt0 t;
    public h60 u;
    public yg v;
    public bh w;
    public final w50 x;

    public SonicVoiceService() {
        ft2 ft2VarA = wa4.a();
        xa0 xa0Var = ld0.a;
        this.x = tl4.a(pl4.c(ft2VarA, ig1.a.i));
        tv1 tv1Var = new tv1(19);
        fw0 fw0Var = new fw0();
        fw0Var.b = tv1Var;
        this.X = fw0Var;
        this.c0 = new gu();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:29:0x007d A[PHI: r12
      0x007d: PHI (r12v5 java.lang.Object) = (r12v1 java.lang.Object), (r12v14 java.lang.Object) binds: [B:20:0x0053, B:27:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x0085  */
    /* JADX WARN: Code duplicated, block: B:34:0x0093  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a7 A[PHI: r1 r12
      0x00a7: PHI (r1v2 o42) = (r1v1 o42), (r1v8 o42) binds: [B:19:0x004a, B:35:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x00a7: PHI (r12v3 t42) = (r12v2 t42), (r12v8 t42) binds: [B:19:0x004a, B:35:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x014d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0166  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:80:0x016a  */
    /* JADX WARN: Path cross not found for [B:73:0x014d, B:48:0x00d3], limit reached: 78 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00c0 -> B:43:0x00c3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(com.project.sonic.background.SonicVoiceService r11, defpackage.y50 r12) {
        /*
            Method dump skipped, instruction units count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.project.sonic.background.SonicVoiceService.a(com.project.sonic.background.SonicVoiceService, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0130  */
    /* JADX WARN: Code duplicated, block: B:66:0x013e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0166  */
    /* JADX WARN: Code duplicated, block: B:73:0x0170  */
    /* JADX WARN: Code duplicated, block: B:79:0x018b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:81:0x0191  */
    /* JADX WARN: Code duplicated, block: B:83:0x0195  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0166 -> B:15:0x0041). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object b(com.project.sonic.background.SonicVoiceService r17, java.lang.String r18, java.util.ArrayList r19, defpackage.y50 r20) {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.project.sonic.background.SonicVoiceService.b(com.project.sonic.background.SonicVoiceService, java.lang.String, java.util.ArrayList, y50):java.lang.Object");
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final eh2 componentManager() {
        if (this.a == null) {
            synchronized (this.b) {
                try {
                    if (this.a == null) {
                        this.a = new eh2(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.a;
    }

    public final in2 d() {
        in2 in2Var = this.i;
        if (in2Var != null) {
            return in2Var;
        }
        g31.f("agent");
        throw null;
    }

    public final mt0 e() {
        mt0 mt0Var = this.t;
        if (mt0Var != null) {
            return mt0Var;
        }
        g31.f("live");
        throw null;
    }

    public final dt1 f() {
        dt1 dt1Var = this.k;
        if (dt1Var != null) {
            return dt1Var;
        }
        g31.f("overlay");
        throw null;
    }

    public final j5 g() {
        j5 j5Var = this.s;
        if (j5Var != null) {
            return j5Var;
        }
        g31.f("settings");
        throw null;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object h(y50 y50Var) throws IllegalAccessException, InvocationTargetException {
        zo2 zo2Var;
        if (y50Var instanceof zo2) {
            zo2Var = (zo2) y50Var;
            int i = zo2Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                zo2Var.i = i - Integer.MIN_VALUE;
            } else {
                zo2Var = new zo2(this, y50Var);
            }
        } else {
            zo2Var = new zo2(this, y50Var);
        }
        Object obj = zo2Var.e;
        int i2 = zo2Var.i;
        x50 x50Var = null;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(obj);
            this.Z = true;
            h60 h60Var = this.u;
            if (h60Var == null) {
                g31.f("playback");
                throw null;
            }
            h60Var.b();
            co2 co2Var = this.j;
            if (co2Var == null) {
                g31.f("speaker");
                throw null;
            }
            co2Var.c();
            pn2 pn2Var = this.e;
            if (pn2Var == null) {
                g31.f("listener");
                throw null;
            }
            pn2Var.d();
            j5 j5VarG = g();
            zo2Var.i = 1;
            if (j5VarG.b(false, zo2Var) != t70Var) {
            }
            return t70Var;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                bz3.g(obj);
                return q43Var;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        if (d().g.e.a.getValue() != null) {
            l90 l90Var = new l90(1, new sc2(d(), x50Var, 7));
            mo2 mo2Var = mo2.c;
            zo2Var.i = 2;
            if (l90Var.a(mo2Var, zo2Var) == t70Var) {
                return t70Var;
            }
        }
        return q43Var;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        if (!this.c) {
            this.c = true;
            ap2 ap2Var = (ap2) generatedComponent();
            SonicVoiceService sonicVoiceService = (SonicVoiceService) UnsafeCasts.unsafeCast(this);
            v80 v80Var = ((t80) ap2Var).a;
            sonicVoiceService.e = (pn2) v80Var.T0.get();
            sonicVoiceService.f = (l93) v80Var.U0.get();
            sonicVoiceService.i = (in2) v80Var.Q0.get();
            sonicVoiceService.j = (co2) v80Var.g.get();
            sonicVoiceService.k = (dt1) v80Var.d0.get();
            sonicVoiceService.n = (oj1) v80Var.V0.get();
            sonicVoiceService.s = (j5) v80Var.i.get();
            sonicVoiceService.t = (mt0) v80Var.S0.get();
            sonicVoiceService.u = (h60) v80Var.W0.get();
            sonicVoiceService.v = (yg) v80Var.X0.get();
            sonicVoiceService.w = (bh) v80Var.c0.get();
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() throws IllegalAccessException, InvocationTargetException {
        f().b(true);
        yq2 yq2Var = this.H;
        if (yq2Var != null) {
            yq2Var.e(null);
        }
        tl4.b(this.x, null);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        AudioManager audioManager;
        Object value;
        x50 x50Var = null;
        if (!g31.a(intent != null ? intent.getAction() : null, "com.project.sonic.STOP_AMBIENT")) {
            if (!g31.a(intent != null ? intent.getAction() : null, "com.project.sonic.PAUSE_AMBIENT")) {
                this.Z = false;
                if (g31.a(intent != null ? intent.getAction() : null, "com.project.sonic.ACTIVATE_LIVE")) {
                    mt0 mt0VarE = e();
                    synchronized (mt0VarE) {
                        mt0VarE.x = false;
                        bd1 bd1Var = mt0VarE.j;
                        synchronized (bd1Var) {
                            try {
                                if (bd1Var.b == null && (audioManager = bd1Var.a) != null && audioManager.getMode() == 0) {
                                    bd1Var.d = false;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        jr2 jr2Var = mt0VarE.k;
                        do {
                            value = jr2Var.getValue();
                        } while (!jr2Var.h(value, ee1.a((ee1) value, false, null, null, null, 47)));
                    }
                }
                ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("sonic_ambient", "SONIC continuous conversation", 2));
                PendingIntent service = PendingIntent.getService(this, 1, new Intent(this, (Class<?>) SonicVoiceService.class).setAction("com.project.sonic.STOP_AMBIENT"), 67108864);
                PendingIntent activity = PendingIntent.getActivity(this, 2, new Intent(this, (Class<?>) MainActivity.class), 67108864);
                po1 po1Var = new po1(this, "sonic_ambient");
                po1Var.o.icon = R.mipmap.ic_launcher;
                po1Var.e = po1.b("SONIC continuous conversation is active");
                po1Var.f = po1.b("Microphone on · tap Stop to end");
                po1Var.g = activity;
                po1Var.o.flags |= 2;
                po1Var.b.add(new oo1(0, "Stop", service));
                Notification notificationA = po1Var.a();
                notificationA.getClass();
                startForeground(73, notificationA);
                bh bhVar = this.w;
                if (bhVar == null) {
                    g31.f("assistantState");
                    throw null;
                }
                if (((ah) bhVar.a.getValue()) == ah.a) {
                    f().d(rn2.b);
                } else {
                    f().b(true);
                }
                yq2 yq2Var = this.H;
                if (yq2Var != null && yq2Var.c()) {
                    return 2;
                }
                this.H = uf4.b(this.x, null, new yo2(this, null), 3);
                return 2;
            }
        }
        this.Z = true;
        if (g31.a(intent.getAction(), "com.project.sonic.STOP_AMBIENT")) {
            e().o();
            co2 co2Var = this.j;
            if (co2Var == null) {
                g31.f("speaker");
                throw null;
            }
            co2Var.c();
            oj1 oj1Var = this.n;
            if (oj1Var == null) {
                g31.f("arbiter");
                throw null;
            }
            if (oj1Var.b == this) {
                pn2 pn2Var = this.e;
                if (pn2Var == null) {
                    g31.f("listener");
                    throw null;
                }
                pn2Var.d();
            }
        }
        uf4.b(this.x, null, new sc2(intent, this, x50Var, 10), 3);
        return 2;
    }
}
