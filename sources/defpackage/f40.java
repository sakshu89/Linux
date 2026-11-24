package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f40 {
    public final Context a;

    public f40(Context context) {
        this.a = context;
    }

    public final boolean a() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService(ConnectivityManager.class);
        return connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
    }
}
