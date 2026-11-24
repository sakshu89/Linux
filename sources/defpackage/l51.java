package defpackage;

import android.view.KeyEvent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l51 extends dk1 implements k51 {
    public hq0 H;
    public hq0 x;

    @Override // defpackage.k51
    public final boolean U(KeyEvent keyEvent) {
        hq0 hq0Var = this.x;
        if (hq0Var != null) {
            return ((Boolean) hq0Var.j(new g51(keyEvent))).booleanValue();
        }
        return false;
    }

    @Override // defpackage.k51
    public final boolean k(KeyEvent keyEvent) {
        hq0 hq0Var = this.H;
        if (hq0Var != null) {
            return ((Boolean) hq0Var.j(new g51(keyEvent))).booleanValue();
        }
        return false;
    }
}
