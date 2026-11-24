package com.project.sonic;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.project.sonic.background.SonicVoiceService;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.Preconditions;
import defpackage.ag1;
import defpackage.ah0;
import defpackage.bh0;
import defpackage.ch0;
import defpackage.cj;
import defpackage.cq;
import defpackage.cs2;
import defpackage.dg1;
import defpackage.dh0;
import defpackage.dk0;
import defpackage.dv2;
import defpackage.e83;
import defpackage.eb1;
import defpackage.eh0;
import defpackage.eo2;
import defpackage.fn4;
import defpackage.fo2;
import defpackage.fq0;
import defpackage.g31;
import defpackage.gb4;
import defpackage.gg1;
import defpackage.h33;
import defpackage.h81;
import defpackage.ha;
import defpackage.ho2;
import defpackage.jb;
import defpackage.jo2;
import defpackage.jq4;
import defpackage.jr2;
import defpackage.jw0;
import defpackage.kf;
import defpackage.kw0;
import defpackage.l11;
import defpackage.lb0;
import defpackage.lx;
import defpackage.n10;
import defpackage.nz;
import defpackage.o10;
import defpackage.oj2;
import defpackage.q80;
import defpackage.q82;
import defpackage.rn2;
import defpackage.s80;
import defpackage.sg1;
import defpackage.sj2;
import defpackage.so2;
import defpackage.su0;
import defpackage.u42;
import defpackage.uf4;
import defpackage.v80;
import defpackage.vg;
import defpackage.w10;
import defpackage.wg;
import defpackage.wh2;
import defpackage.xn2;
import defpackage.yq2;
import defpackage.z3;
import defpackage.zf1;
import defpackage.zg;
import defpackage.zl;
import defpackage.zv1;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity extends n10 implements GeneratedComponentManagerHolder {
    public static final Set m0 = wh2.c("android.settings.action.MANAGE_WRITE_SETTINGS", "android.settings.APPLICATION_DETAILS_SETTINGS", "android.settings.action.MANAGE_OVERLAY_PERMISSION");
    public volatile z3 c0;
    public final Object d0 = new Object();
    public boolean e0 = false;
    public zv1 f0;
    public final cj g0;
    public final cj h0;
    public final cj i0;
    public Boolean j0;
    public final kf k0;
    public final kf l0;

    public MainActivity() {
        e(new kw0(this, 1));
        this.g0 = new cj(u42.a(so2.class), new gg1(1, this), new gg1(0, this), new gg1(2, this));
        this.h0 = new cj(u42.a(oj2.class), new gg1(4, this), new gg1(3, this), new gg1(5, this));
        this.i0 = new cj(u42.a(sj2.class), new gg1(7, this), new gg1(6, this), new gg1(8, this));
        this.k0 = k(new su0(8), new ag1(this, 0));
        this.l0 = k(new su0(8), new ag1(this, 1));
    }

    public static final void l(MainActivity mainActivity) {
        boolean z;
        mainActivity.w("Choose SONIC under 'Digital assistant app'.");
        List<String> listI = nz.i("android.settings.VOICE_INPUT_SETTINGS", "android.settings.MANAGE_DEFAULT_APPS_SETTINGS", "android.settings.SETTINGS");
        if (!listI.isEmpty()) {
            for (String str : listI) {
                str.getClass();
                try {
                    mainActivity.startActivity(new Intent(str));
                    z = true;
                } catch (ActivityNotFoundException | SecurityException unused) {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
        }
        mainActivity.w("Couldn't open Settings on this device.");
    }

    public static final void m(MainActivity mainActivity) {
        zg zgVar;
        mainActivity.getClass();
        zf1 zf1Var = new zf1(mainActivity, 2);
        if (((Boolean) zf1Var.j("android.settings.ACTION_POWER_MENU_SETTINGS")).booleanValue()) {
            zgVar = zg.a;
        } else {
            zgVar = ((Boolean) zf1Var.j("android.settings.SETTINGS")).booleanValue() ? zg.b : zg.c;
        }
        int iOrdinal = zgVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    mainActivity.w("Couldn't open Settings on this device.");
                    return;
                } else {
                    dk0.l();
                    return;
                }
            }
            String str = Build.MANUFACTURER;
            str.getClass();
            String string = cs2.V(str).toString();
            if (cs2.A(string)) {
                string = null;
            }
            mainActivity.w("The direct power-button page isn't available on " + (string != null ? cq.v("your ", string, " phone") : "this phone") + ". Search Settings for ‘Press and hold power button’, ‘Power button’ or ‘Side button’, then choose Digital assistant. Choose SONIC as the default assistant first.");
        }
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final z3 componentManager() {
        if (this.c0 == null) {
            synchronized (this.d0) {
                try {
                    if (this.c0 == null) {
                        this.c0 = new z3(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c0;
    }

    public final void o() {
        Boolean bool = this.j0;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            this.j0 = null;
            so2 so2VarQ = q();
            uf4.b(gb4.c(so2VarQ), null, new jo2(so2VarQ, so2VarQ.u, zBooleanValue, null), 3);
        }
    }

    @Override // defpackage.n10, android.app.Activity
    public final void onCreate(Bundle bundle) {
        bh0 ch0Var;
        t(bundle);
        int i = 7;
        xn2 xn2Var = new xn2(i);
        dv2 dv2Var = new dv2(0, 0, xn2Var);
        int i2 = ah0.a;
        int i3 = ah0.b;
        xn2 xn2Var2 = new xn2(i);
        dv2 dv2Var2 = new dv2(i2, i3, xn2Var2);
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        Resources resources = decorView.getResources();
        resources.getClass();
        boolean zBooleanValue = ((Boolean) xn2Var.j(resources)).booleanValue();
        Resources resources2 = decorView.getResources();
        resources2.getClass();
        boolean zBooleanValue2 = ((Boolean) xn2Var2.j(resources2)).booleanValue();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            ch0Var = new eh0();
        } else if (i4 >= 29) {
            ch0Var = new dh0();
        } else {
            ch0Var = i4 >= 28 ? new ch0() : new bh0();
        }
        bh0 bh0Var = ch0Var;
        Window window = getWindow();
        window.getClass();
        bh0Var.b(dv2Var, dv2Var2, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = getWindow();
        window2.getClass();
        bh0Var.a(window2);
        uf4.b(jq4.a(this), null, new dg1(this, null, 1), 3);
        try {
            o10.a(this, new w10(2062329026, true, new ha(i, this)));
        } catch (Exception e) {
            Log.e("SONIC_CRASH", "Fatal error building UI", e);
        }
        if (bundle == null) {
            v(getIntent());
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        jb jbVar = componentManager().f;
        if (jbVar != null) {
            jbVar.b = null;
        }
    }

    @Override // defpackage.n10, android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        setIntent(intent);
        v(intent);
        if (this.a.d.compareTo(eb1.f) >= 0) {
            o();
        }
    }

    @Override // android.app.Activity
    public final void onPause() throws IllegalAccessException, InvocationTargetException {
        Object value;
        yq2 yq2Var;
        so2 so2VarQ = q();
        jr2 jr2Var = so2VarQ.n;
        so2VarQ.w = false;
        if (!so2VarQ.o()) {
            while (!(so2VarQ.q.p() instanceof lx)) {
            }
            so2VarQ.l.b();
            if (so2VarQ.x && (yq2Var = so2VarQ.z) != null) {
                yq2Var.e(null);
            }
        }
        jr2 jr2Var2 = so2VarQ.o;
        Float fValueOf = Float.valueOf(0.0f);
        jr2Var2.getClass();
        jr2Var2.j(null, fValueOf);
        if (((eo2) jr2Var.getValue()).a == rn2.c) {
            do {
                value = jr2Var.getValue();
            } while (!jr2Var.h(value, eo2.a((eo2) value, null, "RUNNING IN BACKGROUND", null, null, null, null, null, null, false, false, false, false, false, null, 0L, 32765)));
        }
        eo2 eo2Var = (eo2) q().n.getValue();
        if (!q().o()) {
            boolean z = eo2Var.j;
            rn2 rn2Var = eo2Var.a;
            if (z || rn2Var.a() || rn2Var.b()) {
                try {
                    startForegroundService(new Intent(this, (Class<?>) SonicVoiceService.class));
                } catch (IllegalStateException unused) {
                    w("Android paused background listening. Return to SONIC to continue.");
                } catch (SecurityException unused2) {
                    w("Microphone access is needed to continue listening in the background.");
                }
            }
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onResume() {
        Object value;
        yq2 yq2Var;
        super.onResume();
        if (!q().o()) {
            startService(new Intent(this, (Class<?>) SonicVoiceService.class).setAction("com.project.sonic.PAUSE_AMBIENT"));
        }
        so2 so2VarQ = q();
        jr2 jr2Var = so2VarQ.n;
        so2VarQ.w = true;
        so2VarQ.q();
        so2VarQ.i();
        if (so2VarQ.C) {
            so2VarQ.C = false;
            uf4.b(gb4.c(so2VarQ), null, new fo2(so2VarQ, null, 11), 3);
        }
        if (!so2VarQ.o() && so2VarQ.r && ((yq2Var = so2VarQ.z) == null || !yq2Var.c())) {
            so2VarQ.q.s(new ho2(true));
        }
        if (((eo2) jr2Var.getValue()).a == rn2.c) {
            do {
                value = jr2Var.getValue();
            } while (!jr2Var.h(value, eo2.a((eo2) value, null, "LISTENING", null, null, null, null, null, null, false, false, false, false, false, null, 0L, 32765)));
        }
        s().e();
        r().j();
        o();
    }

    public final e83 p() {
        e83 e83Var = (e83) this.Y.getValue();
        q80 q80Var = (q80) ((lb0) fn4.a(this, lb0.class));
        q80Var.getClass();
        sg1 sg1Var = new sg1(3);
        Boolean bool = Boolean.TRUE;
        sg1Var.e(bool, "oj2");
        sg1Var.e(bool, "sj2");
        sg1Var.e(bool, "so2");
        LinkedHashMap linkedHashMap = sg1Var.a;
        h81 h81Var = new h81(linkedHashMap.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(linkedHashMap));
        v80 v80Var = q80Var.a;
        s80 s80Var = q80Var.b;
        q82 q82Var = new q82();
        q82Var.a = v80Var;
        return new jw0(h81Var, (e83) Preconditions.checkNotNull(e83Var), q82Var);
    }

    public final so2 q() {
        return (so2) this.g0.getValue();
    }

    public final oj2 r() {
        return (oj2) this.h0.getValue();
    }

    public final sj2 s() {
        return (sj2) this.i0.getValue();
    }

    public final void t(Bundle bundle) {
        super.onCreate(bundle);
        componentManager().b();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void u(String str, String str2) {
        switch (str.hashCode()) {
            case -628456768:
                if (str.equals("android.settings.ACCESSIBILITY_SETTINGS")) {
                    Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                    intent.setFlags(268435456);
                    zl.a(this, intent, "Accessibility");
                    return;
                }
                break;
            case -417739141:
                if (str.equals("android.settings.APPLICATION_DETAILS_SETTINGS")) {
                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.parse("package:" + getPackageName()));
                    intent2.setFlags(268435456);
                    zl.a(this, intent2, "App info");
                    return;
                }
                break;
            case 604372044:
                if (str.equals("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
                    Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName()));
                    intent3.setFlags(268435456);
                    zl.a(this, intent3, "Display over other apps");
                    return;
                }
                break;
            case 1408560259:
                if (str.equals("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) {
                    Intent intent4 = new Intent();
                    intent4.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent4.setData(Uri.parse("package:" + getPackageName()));
                    intent4.setFlags(268435456);
                    Intent intent5 = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
                    intent5.setFlags(268435456);
                    if (intent4.resolveActivity(getPackageManager()) != null) {
                        try {
                            startActivity(intent4);
                            return;
                        } catch (ActivityNotFoundException unused) {
                        }
                    }
                    zl.a(this, intent5, "Battery optimization");
                    return;
                }
                break;
        }
        Intent intent6 = new Intent(str);
        if (m0.contains(str)) {
            intent6.setData(Uri.parse("package:" + getPackageName()));
        }
        if (str.equals("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS") && Build.VERSION.SDK_INT >= 30) {
            intent6.putExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME", getPackageName() + "/" + SonicNotificationService.class.getName());
        }
        try {
            startActivity(intent6);
        } catch (ActivityNotFoundException unused2) {
            try {
                startActivity(new Intent("android.settings.SETTINGS"));
                w("This phone doesn't have that page. Look for \"" + str2 + "\" in Settings.");
            } catch (ActivityNotFoundException unused3) {
                w("Couldn't open Settings on this device.");
            }
        }
    }

    public final void v(Intent intent) {
        if (intent == null) {
            return;
        }
        l11 l11Var = vg.a;
        Boolean bool = null;
        if (g31.a(intent.getAction(), "android.intent.action.ASSIST")) {
            l11 l11Var2 = vg.a;
            String stringExtra = intent.getStringExtra("com.project.sonic.extra.ASSISTANT_INVOCATION");
            synchronized (l11Var2) {
                wg wgVar = (wg) h33.b((LinkedHashMap) l11Var2.c).remove(stringExtra);
                if (wgVar != null) {
                    long jLongValue = ((Number) ((fq0) l11Var2.b).a()).longValue() - wgVar.b;
                    Boolean boolValueOf = Boolean.valueOf(wgVar.a);
                    if (0 <= jLongValue && jLongValue < 15000) {
                        bool = boolValueOf;
                    }
                }
            }
        }
        if (bool != null) {
            this.j0 = bool;
        }
    }

    public final void w(String str) {
        Toast.makeText(this, str, 1).show();
    }
}
