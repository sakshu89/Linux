package defpackage;

import android.app.Application;
import android.app.Service;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eh2 implements GeneratedComponentManager {
    public final Service a;
    public t80 b;

    public eh2(Service service) {
        this.a = service;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        if (this.b == null) {
            Application application = this.a.getApplication();
            Preconditions.checkState(application instanceof GeneratedComponentManager, "Hilt service must be attached to an @HiltAndroidApp Application. Found: %s", application.getClass());
            this.b = new t80(((v80) ((dh2) fn4.a(application, dh2.class))).b);
        }
        return this.b;
    }
}
