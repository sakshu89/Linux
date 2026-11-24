package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.project.sonic.R;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class a1 extends ViewGroup {
    public WeakReference a;
    public IBinder b;
    public pc3 c;
    public a30 e;
    public o32 f;
    public boolean i;
    public boolean j;
    public boolean k;

    public a1(Context context) {
        super(context, null, 0);
        setClipChildren(false);
        setClipToPadding(false);
        int i = 1;
        setImportantForAccessibility(1);
        n9 n9Var = new n9(i, this);
        addOnAttachStateChangeListener(n9Var);
        kf2 kf2Var = new kf2(11);
        g31.d(this).a.add(kf2Var);
        this.f = new o32(this, n9Var, kf2Var, i);
    }

    private final void setParentContext(a30 a30Var) {
        if (this.e != a30Var) {
            this.e = a30Var;
            if (a30Var != null) {
                this.a = null;
            }
            pc3 pc3Var = this.c;
            if (pc3Var != null) {
                pc3Var.a();
                this.c = null;
                if (isAttachedToWindow()) {
                    c();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.b != iBinder) {
            this.b = iBinder;
            this.a = null;
        }
    }

    public abstract void a(x20 x20Var, int i);

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        b();
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams) {
        b();
        return super.addViewInLayout(view, i, layoutParams);
    }

    public final void b() {
        if (this.j) {
            return;
        }
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        if (this.c == null) {
            boolean z = false;
            Object[] objArr = 0;
            try {
                this.j = true;
                this.c = rc3.a(this, f(), new w10(-656146368, true, new z0(objArr == true ? 1 : 0, this)));
            } finally {
                this.j = false;
            }
        }
    }

    public void d(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    public void e(int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i, i2);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(i2)));
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingBottom() + getPaddingTop() + childAt.getMeasuredHeight());
    }

    public final a30 f() {
        f42 f42Var;
        j70 j70Var;
        sc scVar;
        a30 a30VarB = this.e;
        if (a30VarB == null) {
            a30VarB = dc3.b(this);
            if (a30VarB == null) {
                Object parent = getParent();
                while (a30VarB == null && (parent instanceof View)) {
                    View view = (View) parent;
                    a30VarB = dc3.b(view);
                    parent = ye4.b(view);
                }
            }
            boolean z = false;
            if (a30VarB != null) {
                a30 a30Var = (!(a30VarB instanceof f42) || ((c42) ((f42) a30VarB).u.getValue()).compareTo(c42.b) > 0) ? a30VarB : null;
                if (a30Var != null) {
                    this.a = new WeakReference(a30Var);
                }
            } else {
                a30VarB = null;
            }
            if (a30VarB == null) {
                WeakReference weakReference = this.a;
                if (weakReference == null || (a30VarB = (a30) weakReference.get()) == null || ((a30VarB instanceof f42) && ((c42) ((f42) a30VarB).u.getValue()).compareTo(c42.b) <= 0)) {
                    a30VarB = null;
                }
                if (a30VarB == null) {
                    if (!isAttachedToWindow()) {
                        z01.b("Cannot locate windowRecomposer; View " + this + " is not attached to a window");
                    }
                    View view2 = this;
                    Object parent2 = getParent();
                    while (parent2 instanceof View) {
                        View view3 = (View) parent2;
                        if (view3.getId() == 16908290) {
                            break;
                        }
                        view2 = view3;
                        parent2 = view3.getParent();
                    }
                    a30 a30VarB2 = dc3.b(view2);
                    if (a30VarB2 == null) {
                        ((yb3) zb3.a.get()).getClass();
                        j70 j70Var2 = gi0.a;
                        cv2 cv2Var = qc.v;
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            j70Var = (j70) qc.v.getValue();
                        } else {
                            j70Var = (j70) qc.w.get();
                            if (j70Var == null) {
                                og.n("no AndroidUiDispatcher for this thread");
                                return null;
                            }
                        }
                        j70 j70VarR = j70Var.r(j70Var2);
                        sc scVar2 = (sc) j70VarR.v(xy.X);
                        if (scVar2 != null) {
                            scVar = new sc(scVar2);
                            a50 a50Var = (a50) scVar.c;
                            synchronized (a50Var.c) {
                                a50Var.b = false;
                            }
                        } else {
                            scVar = null;
                        }
                        t42 t42Var = new t42();
                        j70 ok1Var = (nk1) j70VarR.v(su0.i);
                        if (ok1Var == null) {
                            ok1Var = new ok1();
                            t42Var.a = ok1Var;
                        }
                        if (scVar != null) {
                            j70Var2 = scVar;
                        }
                        j70 j70VarR2 = j70VarR.r(j70Var2).r(ok1Var);
                        f42Var = new f42(j70VarR2);
                        synchronized (f42Var.c) {
                            f42Var.t = true;
                        }
                        w50 w50VarA = tl4.a(j70VarR2);
                        ob1 ob1VarA = af4.a(view2);
                        qb1 qb1VarF = ob1VarA != null ? ob1VarA.f() : null;
                        if (qb1VarF == null) {
                            z01.c("ViewTreeLifecycleOwner not found from " + view2);
                            og.k();
                            return null;
                        }
                        view2.addOnAttachStateChangeListener(new ac3(view2, f42Var));
                        qb1VarF.a(new cc3(w50VarA, scVar, f42Var, t42Var, view2));
                        view2.setTag(R.id.androidx_compose_ui_view_composition_context, f42Var);
                        fu0 fu0Var = fu0.a;
                        Handler handler = view2.getHandler();
                        int i = uv0.a;
                        view2.addOnAttachStateChangeListener(new n9(2, uf4.b(fu0Var, new tv0(handler, "windowRecomposer cleanup", false).i, new sc2((Object) f42Var, (Object) view2, (x50) (z ? 1 : 0), 16), 2)));
                    } else {
                        if (!(a30VarB2 instanceof f42)) {
                            og.n("root viewTreeParentCompositionContext is not a Recomposer");
                            return null;
                        }
                        f42Var = (f42) a30VarB2;
                    }
                    f42 f42Var2 = ((c42) f42Var.u.getValue()).compareTo(c42.b) > 0 ? f42Var : null;
                    if (f42Var2 != null) {
                        this.a = new WeakReference(f42Var2);
                    }
                    return f42Var;
                }
            }
        }
        return a30VarB;
    }

    /* JADX INFO: renamed from: getAutoClearFocusBehavior-4UtRPd4, reason: not valid java name */
    public final int m0getAutoClearFocusBehavior4UtRPd4() {
        Object tag = getTag(R.id.auto_clear_focus_behavior_tag);
        oh ohVar = tag instanceof oh ? (oh) tag : null;
        if (ohVar != null) {
            return ohVar.a;
        }
        return 1;
    }

    public final boolean getHasComposition() {
        return this.c != null;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    public final boolean isTransitionGroup() {
        return !this.k || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        d(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        c();
        e(i, i2);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(i);
        }
    }

    /* JADX INFO: renamed from: setAutoClearFocusBehavior-17tfJxM, reason: not valid java name */
    public final void m1setAutoClearFocusBehavior17tfJxM(int i) {
        setTag(R.id.auto_clear_focus_behavior_tag, new oh(i));
    }

    public final void setParentCompositionContext(a30 a30Var) {
        setParentContext(a30Var);
    }

    public final void setShowLayoutBounds(boolean z) {
        this.i = z;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((r7) ((it1) childAt)).setShowLayoutBounds(z);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean z) {
        super.setTransitionGroup(z);
        this.k = true;
    }

    public final void setViewCompositionStrategy(v73 v73Var) {
        o32 o32Var = this.f;
        if (o32Var != null) {
            o32Var.a();
        }
        ((we4) v73Var).getClass();
        int i = 1;
        n9 n9Var = new n9(i, this);
        addOnAttachStateChangeListener(n9Var);
        kf2 kf2Var = new kf2(11);
        g31.d(this).a.add(kf2Var);
        this.f = new o32(this, n9Var, kf2Var, i);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        b();
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        b();
        return super.addViewInLayout(view, i, layoutParams, z);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i2) {
        b();
        super.addView(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        b();
        super.addView(view, i, layoutParams);
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }
}
