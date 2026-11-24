package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ox0 extends gw2 {
    public final /* synthetic */ tx0 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ ln g;
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ox0(String str, tx0 tx0Var, int i, ln lnVar, int i2, boolean z) {
        super(str, true);
        this.e = tx0Var;
        this.f = i;
        this.g = lnVar;
        this.h = i2;
    }

    @Override // defpackage.gw2
    public final long a() {
        try {
            su0 su0Var = this.e.t;
            ln lnVar = this.g;
            int i = this.h;
            su0Var.getClass();
            lnVar.skip(i);
            this.e.g0.v(this.f, 9);
            synchronized (this.e) {
                this.e.i0.remove(Integer.valueOf(this.f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
