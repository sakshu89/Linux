package defpackage;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ru {
    public final StringBuilder a = new StringBuilder();
    public final Object b;
    public int c;
    public final lq d;
    public final HashMap e;
    public int f;

    public ru(lq lqVar) {
        Object obj = new Object();
        this.b = obj;
        this.e = new HashMap();
        this.c = 1;
        synchronized (obj) {
            this.d = lqVar;
            this.f = this.c;
        }
    }

    public static void c(yq yqVar, vt vtVar) {
        if (hd4.a()) {
            hd4.b(vtVar.ordinal(), "CX:State[" + yqVar + "]");
        }
    }

    public final qu a(String str) {
        HashMap map = this.e;
        for (cs csVar : map.keySet()) {
            if (str.equals(csVar.a().c())) {
                return (qu) map.get(csVar);
            }
        }
        return null;
    }

    public final void b() {
        boolean zC = xq4.c(3, "CameraStateRegistry");
        StringBuilder sb = this.a;
        if (zC) {
            sb.setLength(0);
            sb.append("Recalculating open cameras:\n");
            sb.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            sb.append("-------------------------------------------------------------------\n");
        }
        int i = 0;
        for (Map.Entry entry : this.e.entrySet()) {
            if (xq4.c(3, "CameraStateRegistry")) {
                sb.append(String.format(Locale.US, "%-45s%-22s\n", ((cs) entry.getKey()).toString(), ((qu) entry.getValue()).a != null ? ((qu) entry.getValue()).a.toString() : "UNKNOWN"));
            }
            vt vtVar = ((qu) entry.getValue()).a;
            if (vtVar != null && vtVar.a) {
                i++;
            }
        }
        if (xq4.c(3, "CameraStateRegistry")) {
            sb.append("-------------------------------------------------------------------\n");
            Locale locale = Locale.US;
            sb.append(cq.i("Open count: ", i, " (Max allowed: ", this.c, ")"));
            xq4.c(3, "CameraStateRegistry");
        }
        this.f = Math.max(this.c - i, 0);
    }

    public final boolean d(yq yqVar) {
        boolean z;
        synchronized (this.b) {
            try {
                qu quVar = (qu) this.e.get(yqVar);
                hh1.d(quVar, "Camera must first be registered with registerCamera()");
                z = true;
                if (xq4.c(3, "CameraStateRegistry")) {
                    this.a.setLength(0);
                    StringBuilder sb = this.a;
                    Locale locale = Locale.US;
                    int i = this.f;
                    vt vtVar = quVar.a;
                    boolean z2 = vtVar != null && vtVar.a;
                    sb.append("tryOpenCamera(" + yqVar + ") [Available Cameras: " + i + ", Already Open: " + z2 + " (Previous state: " + quVar.a + ")]");
                }
                if (this.f > 0) {
                    vt vtVar2 = vt.OPENING;
                    quVar.a = vtVar2;
                    c(yqVar, vtVar2);
                } else {
                    vt vtVar3 = quVar.a;
                    if (vtVar3 != null && vtVar3.a) {
                        vt vtVar4 = vt.OPENING;
                        quVar.a = vtVar4;
                        c(yqVar, vtVar4);
                    } else {
                        z = false;
                    }
                }
                if (xq4.c(3, "CameraStateRegistry")) {
                    StringBuilder sb2 = this.a;
                    Locale locale2 = Locale.US;
                    sb2.append(" --> ".concat(z ? "SUCCESS" : "FAIL"));
                    xq4.c(3, "CameraStateRegistry");
                }
                if (z) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final boolean e(String str, String str2) {
        synchronized (this.b) {
            try {
                boolean z = true;
                if (this.d.c != 2) {
                    return true;
                }
                qu quVarA = a(str);
                vt vtVar = quVarA != null ? quVarA.a : null;
                qu quVarA2 = str2 != null ? a(str2) : null;
                vt vtVar2 = quVarA2 != null ? quVarA2.a : null;
                vt vtVar3 = vt.OPEN;
                boolean z2 = vtVar3.equals(vtVar) || vt.CONFIGURED.equals(vtVar);
                boolean z3 = vtVar3.equals(vtVar2) || vt.CONFIGURED.equals(vtVar2);
                if (!z2 || !z3) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
