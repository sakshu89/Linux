package defpackage;

import android.view.InputDevice;
import android.view.KeyEvent;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b70 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public b70(ao0 ao0Var, ua1 ua1Var) {
        this.a = 3;
        this.c = ao0Var;
        this.b = ua1Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        long j;
        boolean zG = false;
        switch (this.a) {
            case 0:
                KeyEvent keyEvent = ((g51) obj).a;
                if (((ua1) this.b).a() == rv0.b && keyEvent.getKeyCode() == 4 && h51.b(keyEvent) == 1) {
                    ((ny2) this.c).g(null);
                    zG = true;
                }
                return Boolean.valueOf(zG);
            case 1:
                gm2 gm2Var = (gm2) obj;
                synchronized (im2.c) {
                    j = im2.e;
                    im2.e = 1 + j;
                }
                return new lm1(j, gm2Var, (hq0) this.b, (hq0) this.c);
            case 2:
                a50 a50Var = (a50) this.b;
                Object obj2 = a50Var.c;
                yv yvVar = (yv) this.c;
                synchronized (obj2) {
                    ((ArrayList) a50Var.d).remove(yvVar);
                }
                return q43.a;
            default:
                KeyEvent keyEvent2 = ((g51) obj).a;
                ao0 ao0Var = (ao0) this.c;
                InputDevice device = keyEvent2.getDevice();
                if (device != null && device.supportsSource(513) && ((!device.isVirtual() || keyEvent2.getSource() == 33554433) && h51.b(keyEvent2) == 2 && keyEvent2.getSource() != 257)) {
                    if (sb4.a(19, keyEvent2)) {
                        zG = ((do0) ao0Var).g(5, true);
                    } else if (sb4.a(20, keyEvent2)) {
                        zG = ((do0) ao0Var).g(6, true);
                    } else if (sb4.a(21, keyEvent2)) {
                        zG = ((do0) ao0Var).g(3, true);
                    } else if (sb4.a(22, keyEvent2)) {
                        zG = ((do0) ao0Var).g(4, true);
                    } else if (sb4.a(23, keyEvent2)) {
                        zm2 zm2Var = ((ua1) this.b).c;
                        if (zm2Var != null) {
                            ((ac0) zm2Var).b();
                        }
                        zG = true;
                    }
                }
                return Boolean.valueOf(zG);
        }
    }

    public /* synthetic */ b70(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }
}
