package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zn0 {
    public static final MeteringRectangle[] j = new MeteringRectangle[0];
    public final kq a;
    public final ch2 b;
    public volatile boolean c = false;
    public int d = 1;
    public MeteringRectangle[] e;
    public MeteringRectangle[] f;
    public MeteringRectangle[] g;
    public boolean h;
    public yn0 i;

    public zn0(kq kqVar, ch2 ch2Var) {
        MeteringRectangle[] meteringRectangleArr = j;
        this.e = meteringRectangleArr;
        this.f = meteringRectangleArr;
        this.g = meteringRectangleArr;
        this.h = false;
        this.i = null;
        this.a = kqVar;
        this.b = ch2Var;
    }

    public final void a(boolean z, boolean z2) {
        if (this.c) {
            ur urVar = new ur();
            urVar.c = true;
            urVar.a = this.d;
            zl1 zl1VarM = zl1.m();
            if (z) {
                zl1VarM.v(zr.M(CaptureRequest.CONTROL_AF_TRIGGER), 2);
            }
            if (z2) {
                zl1VarM.v(zr.M(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER), 2);
            }
            urVar.c(new zr(gs1.l(zl1VarM)));
            this.a.s(Collections.singletonList(urVar.d()));
        }
    }

    public final wc1 b(final boolean z) {
        if (Build.VERSION.SDK_INT < 28 || kq.n(this.a.e, 5) != 5) {
            return mz0.c;
        }
        final tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            this.b.execute(new Runnable() { // from class: xn0
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r3v1, types: [jq, yn0] */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public final void run() {
                    final zn0 zn0Var = this.a;
                    boolean z2 = z;
                    final tp tpVar2 = tpVar;
                    kq kqVar = zn0Var.a;
                    ((HashSet) kqVar.b.b).remove(zn0Var.i);
                    zn0Var.h = z2;
                    if (!zn0Var.c) {
                        tpVar2.b(new dt("Camera is not active."));
                        return;
                    }
                    final long jU = zn0Var.a.u();
                    var r3 = new jq() { // from class: yn0
                        @Override // defpackage.jq
                        public final boolean a(TotalCaptureResult totalCaptureResult) {
                            boolean z3 = ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE)).intValue() == 5;
                            xq4.c(3, "FocusMeteringControl");
                            if (z3 != zn0Var.h || !kq.q(totalCaptureResult, jU)) {
                                return false;
                            }
                            xq4.c(3, "FocusMeteringControl");
                            tpVar2.a(null);
                            return true;
                        }
                    };
                    zn0Var.i = r3;
                    zn0Var.a.j(r3);
                }
            });
            tpVar.a = "enableExternalFlashAeMode";
        } catch (Exception e) {
            wpVar.b(e);
        }
        return wpVar;
    }

    public final wp c() {
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            this.b.execute(new o8(17, this, tpVar));
            tpVar.a = "triggerAePrecapture";
            return wpVar;
        } catch (Exception e) {
            wpVar.b(e);
            return wpVar;
        }
    }

    public final void d(tp tpVar) {
        xq4.c(3, "FocusMeteringControl");
        if (!this.c) {
            tpVar.b(new dt("Camera is not active."));
            return;
        }
        ur urVar = new ur();
        urVar.a = this.d;
        urVar.c = true;
        zl1 zl1VarM = zl1.m();
        zl1VarM.v(zr.M(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER), 1);
        urVar.c(new zr(gs1.l(zl1VarM)));
        urVar.b(new lr(tpVar, 1));
        this.a.s(Collections.singletonList(urVar.d()));
    }
}
