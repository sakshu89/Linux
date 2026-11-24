package defpackage;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zv1 {
    public final Context a;

    public zv1(Context context) {
        this.a = context;
    }

    public static f52 d(np2 np2Var) {
        np2Var.getClass();
        int iOrdinal = np2Var.ordinal();
        if (iOrdinal == 0) {
            return new f52("android.settings.action.MANAGE_WRITE_SETTINGS", "Allow changing settings", "Android only lets an app change screen brightness after you switch this on by hand.");
        }
        if (iOrdinal == 1) {
            return new f52("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS", "Allow reading notifications", "This lets SONIC read your notifications and see what's playing. It stays off until you turn it on, and everything read stays on the phone.");
        }
        if (iOrdinal == 2) {
            return new f52("android.settings.ACCESSIBILITY_SETTINGS", "Turn on screen understanding", "SONIC needs Android's accessibility access to read what's on screen. It is only used when you explicitly ask.");
        }
        if (iOrdinal == 3) {
            return new f52("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS", "Allow changing volume in Do Not Disturb", "Do Not Disturb is on, and Android blocks volume changes from apps that don't have this access.");
        }
        if (iOrdinal == 4) {
            return new f52(Build.VERSION.SDK_INT >= 31 ? "android.settings.REQUEST_SCHEDULE_EXACT_ALARM" : "android.settings.SETTINGS", "Allow exact alarms", "Without this, Android may delay reminders by several minutes.");
        }
        if (iOrdinal == 5) {
            return new f52("android.settings.action.MANAGE_OVERLAY_PERMISSION", "Allow the edge glow", "Lets SONIC light the edge of the screen while it is listening, even when another app is in front. It draws nothing else and cannot read what is underneath it.");
        }
        dk0.l();
        return null;
    }

    public final boolean a() {
        Context context = this.a;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (string != null) {
            List listN = cs2.N(string, new char[]{':'}, 6);
            if (!listN.isEmpty()) {
                Iterator it = listN.iterator();
                while (it.hasNext()) {
                    if (js2.k((String) it.next(), context.getPackageName() + "/", false)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean b(np2 np2Var) {
        AlarmManager alarmManager;
        np2Var.getClass();
        int iOrdinal = np2Var.ordinal();
        Context context = this.a;
        if (iOrdinal == 0) {
            return Settings.System.canWrite(context);
        }
        if (iOrdinal == 1) {
            return a();
        }
        if (iOrdinal == 2) {
            return dc4.b(context);
        }
        if (iOrdinal == 3) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            return notificationManager != null && notificationManager.isNotificationPolicyAccessGranted();
        }
        if (iOrdinal == 4) {
            return Build.VERSION.SDK_INT < 31 || ((alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class)) != null && alarmManager.canScheduleExactAlarms());
        }
        if (iOrdinal == 5) {
            return Settings.canDrawOverlays(context);
        }
        dk0.l();
        return false;
    }

    public final boolean c(String str) {
        str.getClass();
        return al4.a(this.a, str) == 0;
    }
}
