package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hr implements ks {
    public final Executor a;
    public final mr b;
    public final int c;

    public hr(mr mrVar, ch2 ch2Var, int i) {
        this.b = mrVar;
        this.a = ch2Var;
        this.c = i;
    }

    @Override // defpackage.ks
    public final wc1 a() {
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            this.b.i.c();
            tpVar.a(null);
            tpVar.a = "invokePostCaptureFuture";
            return wpVar;
        } catch (Exception e) {
            wpVar.b(e);
            return wpVar;
        }
    }

    @Override // defpackage.ks
    public final wc1 b() {
        xq4.c(3, "Camera2CapturePipeline");
        return oz3.g(jr0.b(this.b.a(this.c)), new q82(new og(10)), this.a);
    }
}
