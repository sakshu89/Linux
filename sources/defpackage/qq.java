package defpackage;

import android.view.Surface;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qq implements ch, eu2, az0, mk2, up {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ qq(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // defpackage.mk2
    public boolean a() {
        tz1 tz1Var = (tz1) this.b;
        xj xjVar = (xj) this.c;
        if (!tz1Var.X) {
            tz1Var.h();
            long jA = xj.a(tz1Var.x, xjVar.a);
            xjVar.a = jA;
            tz1Var.X = !tz1Var.g(tz1Var.w, jA + xjVar.b);
        }
        return tz1Var.X;
    }

    @Override // defpackage.ch
    /* JADX INFO: renamed from: apply */
    public wc1 mo28apply(Object obj) {
        int i = this.a;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                tw twVar = (tw) obj3;
                twVar.a();
                ((nz0) obj2).a();
                return twVar.l();
            case 1:
                return hg4.a(new kr0((wp) obj2, ((rr) obj3).c, 3000L, 1));
            default:
                ArrayList arrayList = (ArrayList) obj2;
                zq zqVar = ((n83) obj3).c;
                Object objF = 100;
                try {
                    objF = ((lw) arrayList.get(0)).b.f(lw.j);
                    break;
                } catch (IllegalArgumentException unused) {
                }
                Integer num = (Integer) objF;
                Objects.requireNonNull(num);
                int iIntValue = num.intValue();
                Object objF2 = 0;
                try {
                    objF2 = ((lw) arrayList.get(0)).b.f(lw.i);
                    break;
                } catch (IllegalArgumentException unused2) {
                }
                Integer num2 = (Integer) objF2;
                Objects.requireNonNull(num2);
                int iIntValue2 = num2.intValue();
                kf kfVar = ((yr2) zqVar.b).s;
                if (kfVar == null) {
                    return new mz0(1, new Exception("Failed to take picture: pipeline is not ready."));
                }
                fb0 fb0Var = (fb0) kfVar.b;
                tp tpVar = new tp();
                tpVar.c = new o62();
                wp wpVar = new wp(tpVar);
                tpVar.b = wpVar;
                tpVar.a = cq.class;
                try {
                    fb0Var.e(new o8(12, fb0Var, new di(iIntValue, iIntValue2, tpVar)), new cb0(tpVar, 0));
                    tpVar.a = "DefaultSurfaceProcessor#snapshot";
                    break;
                } catch (Exception e) {
                    wpVar.b(e);
                }
                return oz3.e(wpVar);
        }
    }

    @Override // defpackage.eu2
    public void b(lj ljVar) {
        fb0 fb0Var = (fb0) this.b;
        rr0 rr0Var = (((fu2) this.c).c.a() && ljVar.d) ? rr0.c : rr0.b;
        qq1 qq1Var = fb0Var.a;
        ur0.d((AtomicBoolean) qq1Var.c, true);
        ur0.c((Thread) qq1Var.f);
        if (((rr0) qq1Var.v) != rr0Var) {
            qq1Var.v = rr0Var;
            qq1Var.t(qq1Var.a);
        }
    }

    @Override // defpackage.az0
    public void c(bz0 bz0Var) {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 4:
                ((az0) obj).c((q91) obj2);
                break;
            default:
                ((az0) obj).c((m92) obj2);
                break;
        }
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        switch (this.a) {
            case 6:
                y02 y02Var = (y02) this.b;
                ov ovVar = (ov) this.c;
                y02Var.getClass();
                synchronized (y02Var.a) {
                    xw xwVarG = oz3.g(jr0.b(mz0.c), new zq(5, new h6(19, ovVar)), xg4.a());
                    xwVarG.a(new or0(0, xwVarG, new q91(20, tpVar, ovVar)), xg4.a());
                }
                return "ProcessCameraProvider-initializeCameraX";
            case 7:
            default:
                f03 f03Var = (f03) this.b;
                Surface surface = (Surface) this.c;
                xq4.c(3, "TextureViewImpl");
                f03Var.h.a(surface, xg4.a(), new zt2(2, tpVar));
                return "provideSurface[request=" + f03Var.h + " surface=" + surface + "]";
            case 8:
                fu2 fu2Var = (fu2) this.b;
                ((AtomicReference) this.c).set(tpVar);
                return "SurfaceRequest-surface-recreation(" + fu2Var.hashCode() + ")";
        }
    }
}
