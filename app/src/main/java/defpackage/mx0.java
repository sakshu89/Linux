package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mx0 extends gw2 {
    public final /* synthetic */ int e;
    public final /* synthetic */ tx0 f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mx0(String str, tx0 tx0Var, int i, int i2, int i3) {
        super(str, true);
        this.e = i3;
        this.f = tx0Var;
        this.g = i;
        this.h = i2;
    }

    @Override // defpackage.gw2
    public final long a() {
        switch (this.e) {
            case 0:
                tx0 tx0Var = this.f;
                try {
                    tx0Var.g0.r(this.g, this.h, true);
                    break;
                } catch (IOException e) {
                    tx0Var.c(2, 2, e);
                }
                return -1L;
            case 1:
                su0 su0Var = this.f.t;
                int i = this.h;
                su0Var.getClass();
                if (i == 0) {
                    throw null;
                }
                synchronized (this.f) {
                    this.f.i0.remove(Integer.valueOf(this.g));
                }
                return -1L;
            default:
                tx0 tx0Var2 = this.f;
                try {
                    int i2 = this.g;
                    int i3 = this.h;
                    if (i3 == 0) {
                        throw null;
                    }
                    tx0Var2.g0.v(i2, i3);
                    return -1L;
                } catch (IOException e2) {
                    tx0Var2.c(2, 2, e2);
                }
                break;
        }
    }
}
