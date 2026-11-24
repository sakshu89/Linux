package defpackage;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sp4 implements Handler.Callback {
    public final /* synthetic */ sq4 a;

    public /* synthetic */ sp4(sq4 sq4Var) {
        this.a = sq4Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.a.a) {
                try {
                    rm4 rm4Var = (rm4) message.obj;
                    pn4 pn4Var = (pn4) this.a.a.get(rm4Var);
                    if (pn4Var != null && pn4Var.a.isEmpty()) {
                        if (pn4Var.c) {
                            pn4Var.g.c.removeMessages(1, pn4Var.e);
                            sq4 sq4Var = pn4Var.g;
                            sq4Var.d.k(sq4Var.b, pn4Var);
                            pn4Var.c = false;
                            pn4Var.b = 2;
                        }
                        this.a.a.remove(rm4Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.a.a) {
            try {
                rm4 rm4Var2 = (rm4) message.obj;
                pn4 pn4Var2 = (pn4) this.a.a.get(rm4Var2);
                if (pn4Var2 != null && pn4Var2.b == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(rm4Var2)), new Exception());
                    ComponentName componentName = pn4Var2.f;
                    if (componentName == null) {
                        rm4Var2.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = rm4Var2.b;
                        jg1.d(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    pn4Var2.onServiceDisconnected(componentName);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }
}
