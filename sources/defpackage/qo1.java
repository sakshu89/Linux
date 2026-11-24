package defpackage;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qo1 {
    public final NotificationManager a;

    static {
        new HashSet();
    }

    public qo1(Context context) {
        this.a = (NotificationManager) context.getSystemService("notification");
    }
}
