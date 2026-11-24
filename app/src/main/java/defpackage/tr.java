package defpackage;

import android.hardware.camera2.TotalCaptureResult;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tr implements nr {
    public final kq a;
    public final int b;
    public boolean c = false;
    public final Executor d;
    public final ScheduledExecutorService e;
    public final boolean f;

    public tr(kq kqVar, int i, ch2 ch2Var, xv0 xv0Var, boolean z) {
        this.a = kqVar;
        this.b = i;
        this.d = ch2Var;
        this.e = xv0Var;
        this.f = z;
    }

    @Override // defpackage.nr
    public final boolean a() {
        return this.b == 0;
    }

    @Override // defpackage.nr
    public final wc1 b(TotalCaptureResult totalCaptureResult) {
        ur.g(this.b, totalCaptureResult);
        xq4.c(3, "Camera2CapturePipeline");
        if (ur.g(this.b, totalCaptureResult)) {
            if (!this.a.r) {
                xq4.c(3, "Camera2CapturePipeline");
                final int i = 1;
                this.c = true;
                tp tpVar = new tp();
                tpVar.c = new o62();
                wp wpVar = new wp(tpVar);
                tpVar.b = wpVar;
                tpVar.a = cq.class;
                try {
                    this.a.j.a(tpVar, true);
                    tpVar.a = "TorchOn";
                } catch (Exception e) {
                    wpVar.b(e);
                }
                jr0 jr0VarB = jr0.b(wpVar);
                final int i2 = 0;
                xw xwVarG = oz3.g(oz3.g(jr0VarB, new ch(this) { // from class: sr
                    public final /* synthetic */ tr b;

                    {
                        this.b = this;
                    }

                    @Override // defpackage.ch
                    /* JADX INFO: renamed from: apply */
                    public final wc1 mo28apply(Object obj) {
                        int i3 = i2;
                        tr trVar = this.b;
                        switch (i3) {
                            case 0:
                                return trVar.f ? trVar.a.h.c() : mz0.c;
                            default:
                                ScheduledExecutorService scheduledExecutorService = trVar.e;
                                kq kqVar = trVar.a;
                                or orVar = new or(new og(15));
                                kqVar.j(orVar);
                                o8 o8Var = new o8(9, kqVar, orVar);
                                ch2 ch2Var = kqVar.c;
                                wp wpVar2 = orVar.b;
                                wpVar2.b.a(o8Var, ch2Var);
                                return hg4.a(new kr0(wpVar2, scheduledExecutorService, 2000L, 1));
                        }
                    }
                }, this.d), new ch(this) { // from class: sr
                    public final /* synthetic */ tr b;

                    {
                        this.b = this;
                    }

                    @Override // defpackage.ch
                    /* JADX INFO: renamed from: apply */
                    public final wc1 mo28apply(Object obj) {
                        int i3 = i;
                        tr trVar = this.b;
                        switch (i3) {
                            case 0:
                                return trVar.f ? trVar.a.h.c() : mz0.c;
                            default:
                                ScheduledExecutorService scheduledExecutorService = trVar.e;
                                kq kqVar = trVar.a;
                                or orVar = new or(new og(15));
                                kqVar.j(orVar);
                                o8 o8Var = new o8(9, kqVar, orVar);
                                ch2 ch2Var = kqVar.c;
                                wp wpVar2 = orVar.b;
                                wpVar2.b.a(o8Var, ch2Var);
                                return hg4.a(new kr0(wpVar2, scheduledExecutorService, 2000L, 1));
                        }
                    }
                }, this.d);
                og ogVar = new og(13);
                return oz3.g(xwVarG, new q82(ogVar), xg4.a());
            }
            xq4.c(3, "Camera2CapturePipeline");
        }
        return oz3.d(Boolean.FALSE);
    }

    @Override // defpackage.nr
    public final void c() {
        if (this.c) {
            kq kqVar = this.a;
            kqVar.j.a(null, false);
            xq4.c(3, "Camera2CapturePipeline");
            if (this.f) {
                kqVar.h.a(false, true);
            }
        }
    }
}
