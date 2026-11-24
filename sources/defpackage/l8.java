package defpackage;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l8 implements ComponentCallbacks2 {
    public final /* synthetic */ Configuration a;
    public final /* synthetic */ iz0 b;

    public l8(Configuration configuration, iz0 iz0Var) {
        this.a = configuration;
        this.b = iz0Var;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = this.a;
        int iUpdateFrom = configuration2.updateFrom(configuration);
        Iterator it = this.b.a.entrySet().iterator();
        while (it.hasNext()) {
            gz0 gz0Var = (gz0) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
            if (gz0Var == null || Configuration.needNewResources(iUpdateFrom, gz0Var.b)) {
                it.remove();
            }
        }
        configuration2.setTo(configuration);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.b.a.clear();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        this.b.a.clear();
    }
}
