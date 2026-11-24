package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import com.project.sonic.R;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ra3 implements View.OnApplyWindowInsetsListener {
    public final hz a;
    public pb3 b;

    public ra3(View view, hz hzVar) {
        pb3 pb3VarB;
        this.a = hzVar;
        int i = u73.a;
        pb3 pb3VarA = p73.a(view);
        if (pb3VarA != null) {
            int i2 = Build.VERSION.SDK_INT;
            pb3VarB = (i2 >= 34 ? new cb3(pb3VarA) : i2 >= 31 ? new bb3(pb3VarA) : i2 >= 30 ? new ab3(pb3VarA) : i2 >= 29 ? new za3(pb3VarA) : new ya3(pb3VarA)).b();
        } else {
            pb3VarB = null;
        }
        this.b = pb3VarB;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        Interpolator interpolator;
        if (!view.isLaidOut()) {
            this.b = pb3.b(windowInsets, view);
            return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }
        pb3 pb3VarB = pb3.b(windowInsets, view);
        lb3 lb3Var = pb3VarB.a;
        if (this.b == null) {
            int i = u73.a;
            this.b = p73.a(view);
        }
        if (this.b == null) {
            this.b = pb3VarB;
            if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                return view.onApplyWindowInsets(windowInsets);
            }
        } else {
            hz hzVarJ = sa3.j(view);
            if (hzVarJ == null || !Objects.equals((pb3) hzVarJ.b, pb3VarB)) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                pb3 pb3Var = this.b;
                int i2 = 1;
                while (i2 <= 512) {
                    q11 q11VarF = lb3Var.f(i2);
                    q11 q11VarF2 = pb3Var.a.f(i2);
                    int i3 = q11VarF.a;
                    int i4 = q11VarF.d;
                    int i5 = q11VarF.c;
                    int i6 = q11VarF.b;
                    int i7 = q11VarF2.a;
                    int i8 = q11VarF2.d;
                    int[] iArr3 = iArr;
                    int i9 = q11VarF2.c;
                    int i10 = q11VarF2.b;
                    boolean z = i3 > i7 || i6 > i10 || i5 > i9 || i4 > i8;
                    if (z != (i3 < i7 || i6 < i10 || i5 < i9 || i4 < i8)) {
                        if (z) {
                            iArr3[0] = iArr3[0] | i2;
                        } else {
                            iArr2[0] = iArr2[0] | i2;
                        }
                    }
                    i2 <<= 1;
                    iArr = iArr3;
                    iArr2 = iArr2;
                }
                int i11 = iArr[0];
                int i12 = iArr2[0];
                int i13 = i11 | i12;
                if (i13 == 0) {
                    this.b = pb3VarB;
                    if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                        return view.onApplyWindowInsets(windowInsets);
                    }
                } else {
                    pb3 pb3Var2 = this.b;
                    if ((i11 & 8) != 0) {
                        interpolator = sa3.e;
                    } else if ((i12 & 8) != 0) {
                        interpolator = sa3.f;
                    } else if ((i11 & 519) != 0) {
                        interpolator = sa3.g;
                    } else {
                        interpolator = (i12 & 519) != 0 ? sa3.h : null;
                    }
                    xa3 xa3Var = new xa3(i13, interpolator, (i13 & 8) != 0 ? 160L : 250L);
                    xa3Var.a.e(0.0f);
                    ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(xa3Var.a.b());
                    q11 q11VarF3 = lb3Var.f(i13);
                    q11 q11VarF4 = pb3Var2.a.f(i13);
                    int iMin = Math.min(q11VarF3.a, q11VarF4.a);
                    int i14 = q11VarF3.b;
                    int i15 = q11VarF4.b;
                    int iMin2 = Math.min(i14, i15);
                    int i16 = q11VarF3.c;
                    int i17 = q11VarF4.c;
                    int iMin3 = Math.min(i16, i17);
                    int i18 = q11VarF3.d;
                    int i19 = q11VarF4.d;
                    cu2 cu2Var = new cu2(8, q11.b(iMin, iMin2, iMin3, Math.min(i18, i19)), q11.b(Math.max(q11VarF3.a, q11VarF4.a), Math.max(i14, i15), Math.max(i16, i17), Math.max(i18, i19)));
                    sa3.g(view, xa3Var, pb3VarB, false);
                    duration.addUpdateListener(new oa3(xa3Var, pb3VarB, pb3Var2, i13, view));
                    duration.addListener(new pa3(xa3Var, view));
                    qa3 qa3Var = new qa3(view, xa3Var, cu2Var, duration, 0);
                    if (view != null) {
                        oq1 oq1Var = new oq1(view, qa3Var);
                        view.getViewTreeObserver().addOnPreDrawListener(oq1Var);
                        view.addOnAttachStateChangeListener(oq1Var);
                    } else {
                        dk0.n("view == null");
                    }
                    this.b = pb3VarB;
                    if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                        return view.onApplyWindowInsets(windowInsets);
                    }
                }
            } else if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                return view.onApplyWindowInsets(windowInsets);
            }
        }
        return windowInsets;
    }
}
