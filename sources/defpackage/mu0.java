package defpackage;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.ibm.icu.text.DateFormat;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mu0 extends nu0 {
    public static final Object c = new Object();
    public static final mu0 d = new mu0();

    public static AlertDialog d(Activity activity, int i, he3 he3Var, DialogInterface.OnCancelListener onCancelListener) {
        String string;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(ae3.b(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i == 1) {
            string = resources.getString(com.project.sonic.R.string.common_google_play_services_install_button);
        } else if (i != 2) {
            string = i != 3 ? resources.getString(R.string.ok) : resources.getString(com.project.sonic.R.string.common_google_play_services_enable_button);
        } else {
            string = resources.getString(com.project.sonic.R.string.common_google_play_services_update_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, he3Var);
        }
        String strC = ae3.c(activity, i);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", ky0.h(i, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        hj0 hj0Var = new hj0();
        jg1.e(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        hj0Var.a = alertDialog;
        if (onCancelListener != null) {
            hj0Var.b = onCancelListener;
        }
        hj0Var.show(fragmentManager, str);
    }

    public final void c(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogD = d(googleApiActivity, i, new he3(super.a(i, googleApiActivity, DateFormat.DAY), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogD == null) {
            return;
        }
        e(googleApiActivity, alertDialogD, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void f(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        Log.w("GoogleApiAvailability", cq.h("GMS core API Availability. ConnectionResult=", i, ", tag=null"), new IllegalArgumentException());
        if (i == 18) {
            new je3(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i == 6 ? ae3.e(context, "common_google_play_services_resolution_required_title") : ae3.c(context, i);
        if (strE == null) {
            strE = context.getResources().getString(com.project.sonic.R.string.common_google_play_services_notification_ticker);
        }
        String strD = (i == 6 || i == 19) ? ae3.d(context, "common_google_play_services_resolution_required_text", ae3.a(context)) : ae3.b(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        jg1.d(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        po1 po1Var = new po1(context, null);
        po1Var.k = true;
        po1Var.o.flags |= 16;
        po1Var.e = po1.b(strE);
        q91 q91Var = new q91(13);
        q91Var.c = po1.b(strD);
        po1Var.c(q91Var);
        PackageManager packageManager = context.getPackageManager();
        if (fm4.a == null) {
            fm4.a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (fm4.a.booleanValue()) {
            po1Var.o.icon = context.getApplicationInfo().icon;
            po1Var.h = 2;
            if (fm4.a(context)) {
                po1Var.b.add(new oo1(com.project.sonic.R.drawable.common_full_open_on_phone, resources.getString(com.project.sonic.R.string.common_open_on_phone), pendingIntent));
            } else {
                po1Var.g = pendingIntent;
            }
        } else {
            po1Var.o.icon = R.drawable.stat_sys_warning;
            po1Var.o.tickerText = po1.b(resources.getString(com.project.sonic.R.string.common_google_play_services_notification_ticker));
            po1Var.o.when = System.currentTimeMillis();
            po1Var.g = pendingIntent;
            po1Var.f = po1.b(strD);
        }
        synchronized (c) {
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String string = context.getResources().getString(com.project.sonic.R.string.common_google_play_services_notification_channel_name);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
        } else if (!string.contentEquals(notificationChannel.getName())) {
            notificationChannel.setName(string);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        po1Var.m = "com.google.android.gms.availability";
        Notification notificationA = po1Var.a();
        if (i == 1 || i == 2 || i == 3) {
            ru0.a.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationA);
    }

    public final void g(Activity activity, vy3 vy3Var, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogD = d(activity, i, new he3(super.a(i, activity, DateFormat.DAY), vy3Var, 1), onCancelListener);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
