package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class je3 extends we3 {
    public final Context a;
    public final /* synthetic */ mu0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public je3(mu0 mu0Var, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.b = mu0Var;
        this.a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
            return;
        }
        int i2 = nu0.a;
        mu0 mu0Var = this.b;
        Context context = this.a;
        int iB = mu0Var.b(context, i2);
        int i3 = ru0.c;
        if (iB == 1 || iB == 2 || iB == 3 || iB == 9) {
            Intent intentA = mu0Var.a(iB, context, "n");
            mu0Var.f(context, iB, intentA == null ? null : PendingIntent.getActivity(context, 0, intentA, 201326592));
        }
    }
}
