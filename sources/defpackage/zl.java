package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;
import com.project.sonic.MainActivity;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zl {
    public static final il a = new il(-1.0f);
    public static final il b = new il(1.0f);

    public static void a(MainActivity mainActivity, Intent intent, String str) {
        if (intent.resolveActivity(mainActivity.getPackageManager()) != null) {
            try {
                mainActivity.startActivity(intent);
                return;
            } catch (ActivityNotFoundException unused) {
            }
        }
        Toast.makeText(mainActivity, "Look for '" + str + "' in Settings.", 1).show();
        Intent intent2 = new Intent("android.settings.SETTINGS");
        intent2.setFlags(268435456);
        try {
            mainActivity.startActivity(intent2);
        } catch (Exception unused2) {
            Toast.makeText(mainActivity, "Could not open Settings page for '" + str + "'.", 1).show();
        }
    }
}
