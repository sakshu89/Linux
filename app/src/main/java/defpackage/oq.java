package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oq implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ yq b;
    public final /* synthetic */ ArrayList c;

    public /* synthetic */ oq(yq yqVar, ArrayList arrayList, int i) {
        this.a = i;
        this.b = yqVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        kf kfVar;
        switch (this.a) {
            case 0:
                yq yqVar = this.b;
                ArrayList arrayList = this.c;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                boolean z = false;
                boolean z2 = false;
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    uh uhVar = (uh) obj;
                    if (yqVar.a.d(uhVar.a)) {
                        yqVar.a.a.remove(uhVar.a);
                        arrayList2.add(uhVar.a);
                        if (uhVar.b == g02.class) {
                            z2 = true;
                        }
                    }
                }
                if (arrayList2.isEmpty()) {
                    return;
                }
                yqVar.t("Use cases [" + TextUtils.join(", ", arrayList2) + "] now DETACHED for camera");
                if (z2) {
                    yqVar.j.h.getClass();
                }
                yqVar.p();
                if (yqVar.a.c().isEmpty()) {
                    yqVar.j.l.c = false;
                } else {
                    yqVar.L();
                }
                if (!yqVar.a.b().isEmpty()) {
                    yqVar.K();
                    yqVar.D();
                    if (yqVar.q0 == 9) {
                        yqVar.B();
                        return;
                    }
                    return;
                }
                yqVar.j.k();
                yqVar.D();
                yqVar.j.r(false);
                yqVar.u = yqVar.z();
                yqVar.t("Closing camera.");
                switch (cq.x(yqVar.q0)) {
                    case 3:
                        hh1.e(null, yqVar.s == null);
                        yqVar.E(3);
                        return;
                    case 4:
                    default:
                        yqVar.t("close() ignored due to being in state: ".concat(cq.y(yqVar.q0)));
                        return;
                    case 5:
                    case 6:
                    case 7:
                        if (yqVar.k.a() || ((kfVar = (kf) yqVar.p0.b) != null && !((AtomicBoolean) kfVar.c).get())) {
                            z = true;
                        }
                        yqVar.p0.q();
                        yqVar.E(5);
                        if (z) {
                            hh1.e(null, yqVar.v.isEmpty());
                            yqVar.r();
                            return;
                        }
                        return;
                    case 8:
                    case 9:
                        yqVar.E(5);
                        yqVar.q();
                        return;
                }
            default:
                yq yqVar2 = this.b;
                ArrayList arrayList3 = this.c;
                kq kqVar = yqVar2.j;
                try {
                    yqVar2.H(arrayList3);
                    return;
                } finally {
                    kqVar.k();
                }
        }
    }
}
