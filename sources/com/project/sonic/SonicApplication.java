package com.project.sonic;

import android.app.Application;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import defpackage.jn2;
import defpackage.q82;
import defpackage.vf;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class SonicApplication extends Application implements GeneratedComponentManagerHolder {
    public boolean a = false;
    public final vf b = new vf(new q82(this));

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final GeneratedComponentManager componentManager() {
        return this.b;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return this.b.generatedComponent();
    }

    @Override // android.app.Application
    public final void onCreate() {
        if (!this.a) {
            this.a = true;
            jn2 jn2Var = (jn2) this.b.generatedComponent();
            jn2Var.getClass();
        }
        super.onCreate();
    }
}
