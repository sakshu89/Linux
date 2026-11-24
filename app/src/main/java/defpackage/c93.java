package defpackage;

import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c93 {
    public final zv1 a;
    public final AudioManager b;

    public c93(Context context, zv1 zv1Var) {
        zv1Var.getClass();
        this.a = zv1Var;
        this.b = (AudioManager) context.getSystemService(AudioManager.class);
    }

    public static h93 c(c93 c93Var, boolean z) {
        AudioManager audioManager = c93Var.b;
        if (audioManager == null) {
            return new g93("no audio service on this device");
        }
        if (audioManager.isVolumeFixed()) {
            return new g93("this device doesn't let apps change the volume");
        }
        i93 i93VarE = c93Var.e();
        int i = z ? 1 : -1;
        int iC = ky3.c(i93VarE.a + (z ? 3 : -3), 0, i93VarE.b);
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                audioManager.adjustStreamVolume(3, i, 1);
            } catch (SecurityException e) {
                return c93Var.b(e);
            }
        }
        return c93Var.a(i93VarE, iC, z);
    }

    public static h93 d(c93 c93Var, boolean z) {
        AudioManager audioManager = c93Var.b;
        if (audioManager == null) {
            return new g93("no audio service on this device");
        }
        try {
            audioManager.adjustStreamVolume(3, z ? -100 : 100, 1);
            i93 i93VarE = c93Var.e();
            return i93VarE.c == z ? new e93(i93VarE) : new f93(i93VarE.a, i93VarE);
        } catch (SecurityException e) {
            return c93Var.b(e);
        }
    }

    public final h93 a(i93 i93Var, int i, boolean z) {
        int i2 = i93Var.a;
        i93 i93VarE = e();
        int i3 = 0;
        while (true) {
            int i4 = i93VarE.a;
            if (i3 >= 6) {
                return (i4 == i || (z && i4 > i2) || (!z && i4 < i2)) ? new e93(i93VarE) : new f93(i, i93VarE);
            }
            if (i4 == i) {
                return new e93(i93VarE);
            }
            if (z && (i4 > i2 || i2 == i93Var.b)) {
                return new e93(i93VarE);
            }
            if (!z && (i4 < i2 || i2 == 0)) {
                return new e93(i93VarE);
            }
            try {
                Thread.sleep(40L);
            } catch (Exception unused) {
            }
            i93VarE = e();
            i3++;
        }
    }

    public final h93 b(SecurityException securityException) {
        NotificationManager notificationManager = (NotificationManager) this.a.a.getSystemService(NotificationManager.class);
        if (notificationManager == null || !notificationManager.isNotificationPolicyAccessGranted()) {
            return d93.a;
        }
        String message = securityException.getMessage();
        if (message == null) {
            message = "Android refused the volume change";
        }
        return new g93(message);
    }

    public final i93 e() {
        AudioManager audioManager = this.b;
        return audioManager == null ? new i93(0, 0, false) : new i93(audioManager.getStreamVolume(3), audioManager.getStreamMaxVolume(3), audioManager.isStreamMute(3));
    }
}
