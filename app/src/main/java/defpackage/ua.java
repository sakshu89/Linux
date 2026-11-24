package defpackage;

import android.view.View;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ua implements s70 {
    public final View a;
    public final xy2 b;
    public final s70 c;
    public final AtomicReference e = new AtomicReference(null);

    public ua(View view, xy2 xy2Var, s70 s70Var) {
        this.a = view;
        this.b = xy2Var;
        this.c = s70Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final void a(wa1 wa1Var, y50 y50Var) {
        sa saVar;
        if (y50Var instanceof sa) {
            saVar = (sa) y50Var;
            int i = saVar.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                saVar.i = i - Integer.MIN_VALUE;
            } else {
                saVar = new sa(this, y50Var);
            }
        } else {
            saVar = new sa(this, y50Var);
        }
        Object obj = saVar.e;
        int i2 = saVar.i;
        if (i2 == 0) {
            bz3.g(obj);
            k8 k8Var = new k8(2, wa1Var, this);
            x50 x50Var = null;
            p0 p0Var = new p0(this, x50Var, 3);
            saVar.i = 1;
            if (tl4.c(new aa(k8Var, this.e, p0Var, x50Var, 13), saVar) == t70.a) {
                return;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return;
            }
            bz3.g(obj);
        }
        og.k();
    }

    @Override // defpackage.s70
    public final j70 o() {
        return this.c.o();
    }
}
