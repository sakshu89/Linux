package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w32 extends gw2 {
    public final /* synthetic */ int e = 1;
    public final /* synthetic */ x32 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w32(x32 x32Var) {
        super(cq.n(new StringBuilder(), x32Var.l, " writer"), true);
        this.f = x32Var;
    }

    @Override // defpackage.gw2
    public final long a() {
        int i = this.e;
        x32 x32Var = this.f;
        switch (i) {
            case 0:
                try {
                    return x32Var.h() ? 0L : -1L;
                } catch (IOException e) {
                    x32Var.c(e, null);
                    return -1L;
                }
            default:
                m32 m32Var = x32Var.g;
                m32Var.getClass();
                m32Var.d();
                return -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w32(String str, x32 x32Var) {
        super(str, true);
        this.f = x32Var;
    }
}
