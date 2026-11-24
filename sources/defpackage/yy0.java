package defpackage;

import androidx.camera.core.ImageProcessingUtil;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yy0 implements vp0 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;

    @Override // defpackage.vp0
    public final void c(wp0 wp0Var) throws Exception {
        vp0 vp0Var;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                zy0 zy0Var = (zy0) obj;
                int i2 = ImageProcessingUtil.a;
                if (zy0Var != null) {
                    zy0Var.close();
                    return;
                }
                return;
            default:
                m92 m92Var = (m92) obj;
                synchronized (m92Var.a) {
                    try {
                        int i3 = m92Var.b - 1;
                        m92Var.b = i3;
                        if (m92Var.c && i3 == 0) {
                            m92Var.close();
                        }
                        vp0Var = m92Var.i;
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (vp0Var != null) {
                    vp0Var.c(wp0Var);
                    return;
                }
                return;
        }
    }
}
