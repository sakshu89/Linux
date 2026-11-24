package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class po1 {
    public final Context a;
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public int h;
    public q91 j;
    public Bundle l;
    public String m;
    public final boolean n;
    public final Notification o;
    public final ArrayList p;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public final boolean i = true;
    public boolean k = false;

    public po1(Context context, String str) {
        Notification notification = new Notification();
        this.o = notification;
        this.a = context;
        this.m = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.h = 0;
        this.p = new ArrayList();
        this.n = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Bundle bundle;
        kf kfVar = new kf(this);
        Notification.Builder builder = (Notification.Builder) kfVar.b;
        po1 po1Var = (po1) kfVar.c;
        q91 q91Var = po1Var.j;
        if (q91Var != null) {
            new Notification.BigTextStyle(builder).setBigContentTitle(null).bigText((CharSequence) q91Var.c);
        }
        Notification notificationBuild = builder.build();
        if (q91Var != null) {
            po1Var.j.getClass();
        }
        if (q91Var != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        return notificationBuild;
    }

    public final void c(q91 q91Var) {
        if (this.j != q91Var) {
            this.j = q91Var;
            if (((po1) q91Var.b) != this) {
                q91Var.b = this;
                c(q91Var);
            }
        }
    }
}
