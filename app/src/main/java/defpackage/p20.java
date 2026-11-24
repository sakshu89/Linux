package defpackage;

import com.project.sonic.MainActivity;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p20 extends a1 {
    public final ku1 n;
    public boolean s;

    public p20(MainActivity mainActivity) {
        super(mainActivity);
        this.n = o44.g(null);
    }

    @Override // defpackage.a1
    public final void a(x20 x20Var, int i) {
        x20Var.X(420213850);
        int i2 = (x20Var.h(this) ? 4 : 2) | i;
        if (x20Var.O(i2 & 1, (i2 & 3) != 2)) {
            vq0 vq0Var = (vq0) this.n.getValue();
            if (vq0Var == null) {
                x20Var.W(-1238823553);
            } else {
                x20Var.W(98585282);
                vq0Var.e(x20Var, 0);
            }
            x20Var.p(false);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new z0(this, i, 1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return p20.class.getName();
    }

    @Override // defpackage.a1
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.s;
    }

    public final void setContent(vq0 vq0Var) {
        this.s = true;
        this.n.setValue(vq0Var);
        if (isAttachedToWindow()) {
            if (this.e != null || isAttachedToWindow()) {
                c();
            } else {
                og.n("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.");
            }
        }
    }

    public static /* synthetic */ void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }
}
