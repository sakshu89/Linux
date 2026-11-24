package com.project.sonic.background;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.project.sonic.SonicService;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import defpackage.do2;
import defpackage.eh2;
import defpackage.g31;
import defpackage.r2;
import defpackage.t80;
import defpackage.v62;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class SonicTileService extends TileService implements GeneratedComponentManagerHolder {
    public static final /* synthetic */ int f = 0;
    public volatile eh2 a;
    public final Object b = new Object();
    public boolean c = false;
    public r2 e;

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
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

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        super.onClick();
        r2 r2Var = this.e;
        if (r2Var == null) {
            g31.f("bridge");
            throw null;
        }
        if (!r2Var.j()) {
            Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent.setFlags(268435456);
            if (Build.VERSION.SDK_INT < 34) {
                if (isLocked()) {
                    unlockAndRun(new v62(2, this, intent));
                    return;
                } else {
                    startActivityAndCollapse(intent);
                    return;
                }
            }
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 67108864);
            if (isLocked()) {
                unlockAndRun(new v62(1, this, activity));
                return;
            } else {
                startActivityAndCollapse(activity);
                return;
            }
        }
        SonicService sonicService = SonicService.f;
        SonicService sonicService2 = SonicService.f;
        if (sonicService2 != null) {
            r2 r2Var2 = sonicService2.e;
            if (r2Var2 == null) {
                g31.f("bridge");
                throw null;
            }
            r2Var2.h(sonicService2);
            sonicService2.disableSelf();
        }
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setState(1);
        }
        Tile qsTile2 = getQsTile();
        if (qsTile2 != null) {
            qsTile2.updateTile();
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        if (!this.c) {
            this.c = true;
            do2 do2Var = (do2) generatedComponent();
            ((SonicTileService) UnsafeCasts.unsafeCast(this)).e = (r2) ((t80) do2Var).a.U.get();
        }
        super.onCreate();
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        Tile qsTile = getQsTile();
        if (qsTile == null) {
            return;
        }
        r2 r2Var = this.e;
        if (r2Var == null) {
            g31.f("bridge");
            throw null;
        }
        boolean zJ = r2Var.j();
        qsTile.setState(zJ ? 2 : 1);
        qsTile.setLabel(zJ ? "SONIC Controls On" : "SONIC Controls Off");
        if (Build.VERSION.SDK_INT >= 29) {
            qsTile.setSubtitle(zJ ? "Tap to pause for payments" : "Tap to enable");
        }
        qsTile.updateTile();
    }
}
