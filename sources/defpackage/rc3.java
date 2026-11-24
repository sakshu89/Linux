package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.project.sonic.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class rc3 {
    public static final ViewGroup.LayoutParams a = new ViewGroup.LayoutParams(-2, -2);

    /* JADX WARN: Code duplicated, block: B:20:0x005a  */
    /* JADX WARN: Code duplicated, block: B:23:0x007f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x00af  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final pc3 a(a1 a1Var, a30 a30Var, w10 w10Var) {
        r7 r7Var;
        pc3 pc3Var;
        Object[] objArr = 0;
        if (iu0.a.compareAndSet(false, true)) {
            un unVarA = nh4.a(1, 6, null);
            uf4.b(tl4.a((j70) qc.v.getValue()), null, new r0(unVarA, objArr == true ? 1 : 0, 11), 3);
            h6 h6Var = new h6(12, unVarA);
            synchronized (im2.c) {
                im2.i = mz.F(im2.i, h6Var);
            }
            im2.a();
        }
        if (a1Var.getChildCount() > 0) {
            View childAt = a1Var.getChildAt(0);
            if (childAt instanceof r7) {
                r7Var = (r7) childAt;
            }
            if (r7Var == null) {
                r7Var = new r7(a1Var.getContext(), a30Var.j());
                a1Var.addView(r7Var.getView(), a);
            }
            Object tag = r7Var.getView().getTag(R.id.wrapped_composition_tag);
            pc3Var = tag instanceof pc3 ? (pc3) tag : null;
            if (pc3Var == null) {
                pc3Var = new pc3(r7Var, new g30(a30Var, new b43(r7Var.getRoot())));
                r7Var.getView().setTag(R.id.wrapped_composition_tag, pc3Var);
            }
            pc3Var.b(w10Var);
            if (!g31.a(r7Var.getCoroutineContext(), a30Var.j())) {
                r7Var.setCoroutineContext(a30Var.j());
            }
            r7Var.setFrameEndScheduler$ui(new qc3(a30Var));
            return pc3Var;
        }
        a1Var.removeAllViews();
        r7Var = null;
        if (r7Var == null) {
            r7Var = new r7(a1Var.getContext(), a30Var.j());
            a1Var.addView(r7Var.getView(), a);
        }
        Object tag2 = r7Var.getView().getTag(R.id.wrapped_composition_tag);
        if (tag2 instanceof pc3) {
        }
        if (pc3Var == null) {
            pc3Var = new pc3(r7Var, new g30(a30Var, new b43(r7Var.getRoot())));
            r7Var.getView().setTag(R.id.wrapped_composition_tag, pc3Var);
        }
        pc3Var.b(w10Var);
        if (!g31.a(r7Var.getCoroutineContext(), a30Var.j())) {
            r7Var.setCoroutineContext(a30Var.j());
        }
        r7Var.setFrameEndScheduler$ui(new qc3(a30Var));
        return pc3Var;
    }
}
