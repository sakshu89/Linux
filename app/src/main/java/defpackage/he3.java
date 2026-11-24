package defpackage;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class he3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ Object c;

    public /* synthetic */ he3(Intent intent, Object obj, int i) {
        this.a = i;
        this.b = intent;
        this.c = obj;
    }

    public final void a() {
        int i = this.a;
        Object obj = this.c;
        Intent intent = this.b;
        switch (i) {
            case 0:
                if (intent != null) {
                    ((GoogleApiActivity) obj).startActivityForResult(intent, 2);
                }
                break;
            default:
                if (intent != null) {
                    ((vy3) obj).startActivityForResult(intent, 2);
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
