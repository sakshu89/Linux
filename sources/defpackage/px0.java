package defpackage;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class px0 extends gw2 {
    public final /* synthetic */ int e = 1;
    public final /* synthetic */ tx0 f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px0(String str, tx0 tx0Var, int i, List list, boolean z) {
        super(str, true);
        this.f = tx0Var;
        this.g = i;
    }

    @Override // defpackage.gw2
    public final long a() {
        switch (this.e) {
            case 0:
                this.f.t.getClass();
                try {
                    this.f.g0.v(this.g, 9);
                    synchronized (this.f) {
                        this.f.i0.remove(Integer.valueOf(this.g));
                    }
                } catch (IOException unused) {
                }
                return -1L;
            default:
                this.f.t.getClass();
                try {
                    this.f.g0.v(this.g, 9);
                    synchronized (this.f) {
                        this.f.i0.remove(Integer.valueOf(this.g));
                    }
                } catch (IOException unused2) {
                }
                return -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px0(String str, tx0 tx0Var, int i, List list) {
        super(str, true);
        this.f = tx0Var;
        this.g = i;
    }
}
