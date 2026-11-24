package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sx0 extends gw2 {
    public final /* synthetic */ tx0 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ long g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sx0(String str, tx0 tx0Var, int i, long j) {
        super(str, true);
        this.e = tx0Var;
        this.f = i;
        this.g = j;
    }

    @Override // defpackage.gw2
    public final long a() {
        tx0 tx0Var = this.e;
        try {
            tx0Var.g0.w(this.f, this.g);
            return -1L;
        } catch (IOException e) {
            tx0Var.c(2, 2, e);
            return -1L;
        }
    }
}
