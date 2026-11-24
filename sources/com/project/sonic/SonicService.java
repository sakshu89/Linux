package com.project.sonic;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import defpackage.ao2;
import defpackage.eh2;
import defpackage.g31;
import defpackage.jr2;
import defpackage.r2;
import defpackage.t80;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class SonicService extends AccessibilityService implements GeneratedComponentManagerHolder {
    public static volatile SonicService f;
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

    @Override // android.app.Service
    public final void onCreate() {
        if (!this.c) {
            this.c = true;
            ao2 ao2Var = (ao2) generatedComponent();
            ((SonicService) UnsafeCasts.unsafeCast(this)).e = (r2) ((t80) ao2Var).a.U.get();
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        if (f == this) {
            f = null;
        }
        r2 r2Var = this.e;
        if (r2Var == null) {
            g31.f("bridge");
            throw null;
        }
        r2Var.h(this);
        super.onDestroy();
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onServiceConnected() {
        super.onServiceConnected();
        f = this;
        AccessibilityServiceInfo serviceInfo = getServiceInfo();
        serviceInfo.flags |= 82;
        setServiceInfo(serviceInfo);
        r2 r2Var = this.e;
        if (r2Var == null) {
            g31.f("bridge");
            throw null;
        }
        synchronized (r2Var) {
            r2Var.b.set(this);
            jr2 jr2Var = r2Var.c;
            Boolean bool = Boolean.TRUE;
            jr2Var.getClass();
            jr2Var.j(null, bool);
        }
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        if (f == this) {
            f = null;
        }
        r2 r2Var = this.e;
        if (r2Var != null) {
            r2Var.h(this);
            return super.onUnbind(intent);
        }
        g31.f("bridge");
        throw null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onInterrupt() {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }
}
