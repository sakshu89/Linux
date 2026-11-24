package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zq implements dp1, ch, az0, dr0, up {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ zq(bv2 bv2Var, ArrayList arrayList) {
        this.a = 10;
        this.b = arrayList;
    }

    public void a() {
        vq0 vq0Var = (vq0) this.b;
        synchronized (im2.c) {
            List list = im2.h;
            list.getClass();
            ArrayList arrayList = new ArrayList(nz.d(list));
            boolean z = false;
            for (Object obj : list) {
                boolean z2 = true;
                if (!z && g31.a(obj, vq0Var)) {
                    z = true;
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(obj);
                }
            }
            im2.h = arrayList;
        }
    }

    @Override // defpackage.ch
    /* JADX INFO: renamed from: apply */
    public wc1 mo28apply(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 2:
                mr mrVar = (mr) obj2;
                if (!Boolean.TRUE.equals((Boolean) obj)) {
                    return mz0.c;
                }
                long j = mrVar.g;
                ScheduledExecutorService scheduledExecutorService = mrVar.c;
                kq kqVar = mrVar.d;
                long j2 = j / 1000000;
                or orVar = new or(new og(11));
                kqVar.j(orVar);
                o8 o8Var = new o8(9, kqVar, orVar);
                ch2 ch2Var = kqVar.c;
                wp wpVar = orVar.b;
                wpVar.b.a(o8Var, ch2Var);
                return hg4.a(new kr0(wpVar, scheduledExecutorService, j2, 1));
            case 5:
                return (wc1) ((h6) obj2).j(obj);
            default:
                ArrayList arrayList = (ArrayList) obj2;
                List list = (List) obj;
                Objects.toString(list);
                xq4.c(3, "SyncCaptureSessionBase");
                if (list.isEmpty()) {
                    return new mz0(1, new IllegalArgumentException("Unable to open capture session without surfaces"));
                }
                return list.contains(null) ? new mz0(1, new nb0("Surface closed", (ob0) arrayList.get(list.indexOf(null)))) : oz3.d(list);
        }
    }

    @Override // defpackage.az0
    public void c(bz0 bz0Var) throws Exception {
        boolean z;
        int i = this.a;
        boolean z2 = true;
        Object obj = this.b;
        switch (i) {
            case 3:
                cj cjVar = (cj) obj;
                int i2 = 5;
                try {
                    zy0 zy0VarE = bz0Var.e();
                    if (zy0VarE != null) {
                        cjVar.A(zy0VarE);
                        return;
                    }
                    g12 g12Var = (g12) cjVar.b;
                    if (g12Var != null) {
                        int i3 = g12Var.a;
                        ty0 ty0Var = new ty0("Failed to acquire latest image", null);
                        vc4.b();
                        g12 g12Var2 = (g12) cjVar.b;
                        if (g12Var2 == null || g12Var2.a != i3) {
                            return;
                        }
                        j62 j62Var = g12Var2.g;
                        oj ojVar = j62Var.a;
                        vc4.b();
                        if (j62Var.g) {
                            return;
                        }
                        vc4.b();
                        int i4 = ojVar.a;
                        if (i4 > 0) {
                            ojVar.a = i4 - 1;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            vc4.b();
                            ojVar.b.execute(new v62(i2, ojVar, ty0Var));
                        }
                        j62Var.a();
                        j62Var.e.b(ty0Var);
                        if (z) {
                            j62Var.b.d(ojVar);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (IllegalStateException e) {
                    g12 g12Var3 = (g12) cjVar.b;
                    if (g12Var3 != null) {
                        int i5 = g12Var3.a;
                        ty0 ty0Var2 = new ty0("Failed to acquire latest image", e);
                        vc4.b();
                        g12 g12Var4 = (g12) cjVar.b;
                        if (g12Var4 == null || g12Var4.a != i5) {
                            return;
                        }
                        j62 j62Var2 = g12Var4.g;
                        oj ojVar2 = j62Var2.a;
                        vc4.b();
                        if (j62Var2.g) {
                            return;
                        }
                        vc4.b();
                        int i6 = ojVar2.a;
                        if (i6 > 0) {
                            ojVar2.a = i6 - 1;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            vc4.b();
                            ojVar2.b.execute(new v62(i2, ojVar2, ty0Var2));
                        }
                        j62Var2.a();
                        j62Var2.e.b(ty0Var2);
                        if (z2) {
                            j62Var2.b.d(ojVar2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            case 4:
                fj1 fj1Var = (fj1) obj;
                synchronized (fj1Var.a) {
                    fj1Var.c++;
                    break;
                }
                fj1Var.g(bz0Var);
                return;
            default:
                od3 od3Var = (od3) obj;
                od3Var.getClass();
                try {
                    zy0 zy0VarE2 = bz0Var.e();
                    if (zy0VarE2 != null) {
                        od3Var.b.c(zy0VarE2);
                        return;
                    }
                    return;
                } catch (IllegalStateException e2) {
                    xq4.a("ZslControlImpl", "Failed to acquire latest image IllegalStateException = " + e2.getMessage());
                    return;
                }
        }
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        iq iqVar = (iq) this.b;
        iqVar.c = tpVar;
        return "RequestCompleteListener[" + iqVar + "]";
    }

    @Override // defpackage.dp1
    public void u(Object obj) {
        ((ar) this.b).h(obj);
    }

    public /* synthetic */ zq(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.dr0
    public Object apply(Object obj) {
        return (y02) ((h6) this.b).j(obj);
    }
}
