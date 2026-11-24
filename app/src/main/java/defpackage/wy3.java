package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wy3 extends we3 {
    public final /* synthetic */ a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wy3(a aVar, Looper looper) {
        super(looper, 3);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        int i = this.a.v.get();
        int i2 = message.arg1;
        int i3 = message.what;
        if (i != i2) {
            if (i3 == 2 || i3 == 1 || i3 == 7) {
                bx3 bx3Var = (bx3) message.obj;
                bx3Var.getClass();
                bx3Var.c();
                return;
            }
            return;
        }
        if ((i3 == 1 || i3 == 7 || i3 == 4 || i3 == 5) && !this.a.d()) {
            bx3 bx3Var2 = (bx3) message.obj;
            bx3Var2.getClass();
            bx3Var2.c();
            return;
        }
        int i4 = message.what;
        if (i4 == 4) {
            a aVar = this.a;
            aVar.s = new x30(message.arg2);
            if (!aVar.t && !TextUtils.isEmpty(aVar.q()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(aVar.q());
                    a aVar2 = this.a;
                    if (!aVar2.t) {
                        aVar2.u(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            a aVar3 = this.a;
            x30 x30Var = aVar3.s;
            if (x30Var == null) {
                x30Var = new x30(8);
            }
            aVar3.i.o(x30Var);
            System.currentTimeMillis();
            return;
        }
        if (i4 == 5) {
            a aVar4 = this.a;
            x30 x30Var2 = aVar4.s;
            if (x30Var2 == null) {
                x30Var2 = new x30(8);
            }
            aVar4.i.o(x30Var2);
            System.currentTimeMillis();
            return;
        }
        if (i4 == 3) {
            Object obj = message.obj;
            this.a.i.o(new x30(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            System.currentTimeMillis();
            return;
        }
        if (i4 == 6) {
            this.a.u(5, null);
            py0 py0Var = this.a.n;
            if (py0Var != null) {
                ((ou0) py0Var.b).a(message.arg2);
            }
            System.currentTimeMillis();
            a.t(this.a, 5, 1, null);
            return;
        }
        if (i4 == 2 && !this.a.isConnected()) {
            bx3 bx3Var3 = (bx3) message.obj;
            bx3Var3.getClass();
            bx3Var3.c();
            return;
        }
        int i5 = message.what;
        if (i5 != 2 && i5 != 1 && i5 != 7) {
            Log.wtf("GmsClient", ky0.h(i5, "Don't know how to handle message: "), new Exception());
            return;
        }
        bx3 bx3Var4 = (bx3) message.obj;
        synchronized (bx3Var4) {
            try {
                bool = bx3Var4.a;
                if (bx3Var4.b) {
                    Log.w("GmsClient", "Callback proxy " + bx3Var4.toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            a aVar5 = bx3Var4.f;
            int i6 = bx3Var4.d;
            if (i6 != 0) {
                aVar5.u(1, null);
                Bundle bundle = bx3Var4.e;
                bx3Var4.a(new x30(i6, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else if (!bx3Var4.b()) {
                aVar5.u(1, null);
                bx3Var4.a(new x30(8, null));
            }
        }
        synchronized (bx3Var4) {
            bx3Var4.b = true;
        }
        bx3Var4.c();
    }
}
