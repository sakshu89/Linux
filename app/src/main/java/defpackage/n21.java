package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n21 {
    public static final Set b = wh2.c("file", "content", "javascript", "data", "intent", "android-app");
    public final Context a;

    public n21(Context context) {
        this.a = context;
    }

    public static String c(Intent intent) {
        String lowerCase;
        Uri data = intent.getData();
        if (data != null) {
            String scheme = data.getScheme();
            if (scheme != null) {
                lowerCase = scheme.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null && b.contains(lowerCase)) {
                return cq.v("the \"", lowerCase, "\" scheme isn't something I'll open");
            }
            if (g31.a(intent.getAction(), "android.intent.action.VIEW") && (lowerCase == null || cs2.A(lowerCase))) {
                return "that address is missing a scheme like https";
            }
        }
        return null;
    }

    public final t61 a(Intent intent, String str) {
        String str2;
        Context context = this.a;
        String strC = c(intent);
        if (strC != null) {
            return new s61(strC);
        }
        ResolveInfo resolveInfoB = b(intent);
        if (resolveInfoB == null) {
            return new q61(str);
        }
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            ActivityInfo activityInfo = resolveInfoB.activityInfo;
            if (activityInfo == null || (str2 = activityInfo.packageName) == null) {
                str2 = "unknown";
            }
            CharSequence charSequenceLoadLabel = resolveInfoB.loadLabel(context.getPackageManager());
            return new p61(str2, charSequenceLoadLabel != null ? charSequenceLoadLabel.toString() : null);
        } catch (ActivityNotFoundException unused) {
            return new q61(str);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Malformed request";
            }
            return new o61(message);
        } catch (SecurityException e2) {
            String message2 = e2.getMessage();
            if (message2 == null) {
                message2 = "Android blocked the request";
            }
            return new r61(message2);
        }
    }

    public final ResolveInfo b(Intent intent) {
        int i = Build.VERSION.SDK_INT;
        Context context = this.a;
        return i >= 33 ? context.getPackageManager().resolveActivity(intent, PackageManager.ResolveInfoFlags.of(0L)) : context.getPackageManager().resolveActivity(intent, 0);
    }
}
