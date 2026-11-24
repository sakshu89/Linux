package com.project.sonic.voiceinteraction;

import android.service.voice.VoiceInteractionService;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import defpackage.eh2;
import defpackage.g31;
import defpackage.t80;
import defpackage.to2;
import defpackage.yg;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class SonicVoiceInteractionService extends VoiceInteractionService implements GeneratedComponentManagerHolder {
    public volatile eh2 a;
    public final Object b = new Object();
    public boolean c = false;
    public yg e;

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
            to2 to2Var = (to2) generatedComponent();
            ((SonicVoiceInteractionService) UnsafeCasts.unsafeCast(this)).e = (yg) ((t80) to2Var).a.X0.get();
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        yg ygVar = this.e;
        if (ygVar == null) {
            g31.f("sessions");
            throw null;
        }
        if (ygVar.c == this) {
            ygVar.c = null;
        }
        super.onDestroy();
    }

    @Override // android.service.voice.VoiceInteractionService
    public final void onReady() {
        super.onReady();
        yg ygVar = this.e;
        if (ygVar != null) {
            ygVar.c = this;
        } else {
            g31.f("sessions");
            throw null;
        }
    }

    @Override // android.service.voice.VoiceInteractionService
    public final void onShutdown() {
        yg ygVar = this.e;
        if (ygVar == null) {
            g31.f("sessions");
            throw null;
        }
        if (ygVar.c == this) {
            ygVar.c = null;
        }
        super.onShutdown();
    }
}
