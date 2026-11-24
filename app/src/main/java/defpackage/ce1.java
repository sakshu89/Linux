package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.libraries.vision.visionkit.pipeline.AndroidAssetUtil;
import com.google.android.libraries.vision.visionkit.pipeline.alt.PipelineException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ce1 {
    public boolean a;
    public boolean b;
    public final Object c;
    public final Object d;
    public Object e;

    public ce1(Context context, vm3 vm3Var) {
        this.b = true;
        this.c = context;
        this.d = vm3Var;
    }

    public void a() {
        if (!this.a || this.b) {
            return;
        }
        this.b = true;
        yq2 yq2Var = (yq2) this.e;
        if (yq2Var != null) {
            yq2Var.e(null);
        }
        this.e = null;
        ((ts0) this.d).a();
    }

    public ok3 b() {
        vm3 vm3Var = (vm3) this.d;
        boolean z = this.a;
        np3 np3Var = np3.a;
        if (z) {
            return new ok3(0, np3Var);
        }
        if (((jo3) this.e) == null) {
            AndroidAssetUtil.a((Context) this.c);
            String str = vm3Var.a;
            String str2 = vm3Var.b;
            String str3 = vm3Var.c;
            boolean z2 = vm3Var.d;
            fl3 fl3VarP = il3.p();
            int i = 4;
            char c = z2 ? (char) 4 : (char) 0;
            lm3 lm3VarO = nm3.o();
            qk3 qk3VarO = tk3.o();
            qk3VarO.d();
            tk3.p((tk3) qk3VarO.b, str2);
            qk3VarO.d();
            tk3.q((tk3) qk3VarO.b, str);
            qk3VarO.d();
            tk3.r((tk3) qk3VarO.b);
            qk3VarO.d();
            tk3.t((tk3) qk3VarO.b);
            if (!str3.isEmpty()) {
                ur3 ur3VarO = vr3.o();
                wr3 wr3VarO = yr3.o();
                wr3VarO.d();
                ((yr3) wr3VarO.b).zbe = str3;
                ur3VarO.d();
                vr3.p((vr3) ur3VarO.b, (yr3) wr3VarO.a());
                qk3VarO.d();
                tk3.s((tk3) qk3VarO.b, (vr3) ur3VarO.a());
            }
            lm3VarO.d();
            nm3.p((nm3) lm3VarO.b, (tk3) qk3VarO.a());
            if (c == 0) {
                i = 1;
            } else if (c == 1) {
                i = 2;
            } else if (c == 2) {
                i = 3;
            } else if (c != 3) {
                i = c != 4 ? 0 : 5;
            }
            vl3 vl3VarO = xl3.o();
            vl3VarO.d();
            xl3.p((xl3) vl3VarO.b, i);
            lm3VarO.d();
            nm3.r((nm3) lm3VarO.b, (xl3) vl3VarO.a());
            bp3 bp3VarO = dp3.o();
            bp3VarO.d();
            dp3.p((dp3) bp3VarO.b);
            lm3VarO.d();
            nm3.q((nm3) lm3VarO.b, (dp3) bp3VarO.a());
            fl3VarP.d();
            il3.r((il3) fl3VarP.b, (nm3) lm3VarO.a());
            pn3 pn3VarO = qn3.o();
            pn3VarO.d();
            qn3.p((qn3) pn3VarO.b);
            fl3VarP.d();
            il3.q((il3) fl3VarP.b, (qn3) pn3VarO.a());
            this.e = new jo3((il3) fl3VarP.a());
        }
        try {
            jo3 jo3Var = (jo3) this.e;
            jg1.d(jo3Var);
            ze3 ze3Var = jo3Var.b;
            long j = jo3Var.c;
            if (j == 0) {
                throw new PipelineException(9, "Pipeline has been closed or was not initialized");
            }
            try {
                ze3Var.start(j);
                ze3Var.waitUntilIdle(jo3Var.c);
                this.a = true;
                return new ok3(0, np3Var);
            } catch (PipelineException e) {
                ze3Var.stop(jo3Var.c);
                throw e;
            }
        } catch (PipelineException e2) {
            return new ok3(1, new qp3(new RemoteException("Failed to initialize detector. ".concat((String) e2.getRootCauseMessage().b()))));
        }
    }

    public ce1(s70 s70Var, ts0 ts0Var) {
        s70Var.getClass();
        this.c = s70Var;
        this.d = ts0Var;
    }
}
