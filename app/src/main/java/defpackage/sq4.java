package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sq4 {
    public static final Object g = new Object();
    public static sq4 h;
    public static HandlerThread i;
    public final HashMap a = new HashMap();
    public final Context b;
    public volatile we3 c;
    public final fl4 d;
    public final long e;
    public final long f;

    public sq4(Context context, Looper looper) {
        sp4 sp4Var = new sp4(this);
        this.b = context.getApplicationContext();
        we3 we3Var = new we3(looper, sp4Var);
        Looper.getMainLooper();
        this.c = we3Var;
        if (fl4.e == null) {
            synchronized (fl4.c) {
                try {
                    if (fl4.e == null) {
                        fl4.e = new fl4();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        fl4 fl4Var = fl4.e;
        jg1.d(fl4Var);
        this.d = fl4Var;
        this.e = 5000L;
        this.f = 300000L;
    }

    public final void a(String str, ServiceConnection serviceConnection, boolean z) {
        rm4 rm4Var = new rm4(str, z);
        jg1.e(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.a) {
            try {
                pn4 pn4Var = (pn4) this.a.get(rm4Var);
                if (pn4Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(rm4Var.toString()));
                }
                if (!pn4Var.a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(rm4Var.toString()));
                }
                pn4Var.a.remove(serviceConnection);
                if (pn4Var.a.isEmpty()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, rm4Var), this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b(rm4 rm4Var, x34 x34Var, String str) {
        boolean z;
        synchronized (this.a) {
            try {
                pn4 pn4Var = (pn4) this.a.get(rm4Var);
                if (pn4Var == null) {
                    pn4Var = new pn4(this, rm4Var);
                    pn4Var.a.put(x34Var, x34Var);
                    pn4Var.a(str, null);
                    this.a.put(rm4Var, pn4Var);
                } else {
                    this.c.removeMessages(0, rm4Var);
                    if (pn4Var.a.containsKey(x34Var)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(rm4Var.toString()));
                    }
                    pn4Var.a.put(x34Var, x34Var);
                    int i2 = pn4Var.b;
                    if (i2 == 1) {
                        x34Var.onServiceConnected(pn4Var.f, pn4Var.d);
                    } else if (i2 == 2) {
                        pn4Var.a(str, null);
                    }
                }
                z = pn4Var.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
