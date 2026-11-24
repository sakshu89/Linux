package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nx0 implements fq0 {
    public final wx0 a;
    public final /* synthetic */ tx0 b;

    public nx0(tx0 tx0Var, wx0 wx0Var) {
        this.b = tx0Var;
        this.a = wx0Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        tx0 tx0Var = this.b;
        wx0 wx0Var = this.a;
        try {
            if (!wx0Var.c(true, this)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            while (wx0Var.c(false, this)) {
            }
            tx0Var.c(1, 9, null);
            z53.d(wx0Var);
            return q43.a;
        } catch (IOException e) {
            tx0Var.c(2, 2, e);
        } catch (Throwable th) {
            tx0Var.c(3, 3, null);
            z53.d(wx0Var);
            throw th;
        }
    }
}
