package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.project.sonic.R;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yy1 extends a1 {
    public final WindowManager.LayoutParams H;
    public az1 c0;
    public z61 d0;
    public final ku1 e0;
    public final ku1 f0;
    public i21 g0;
    public final qc0 h0;
    public final Rect i0;
    public final wm2 j0;
    public me k0;
    public final ku1 l0;
    public boolean m0;
    public fq0 n;
    public final int[] n0;
    public bz1 s;
    public String t;
    public final View u;
    public final boolean v;
    public final fl4 w;
    public final WindowManager x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yy1(fq0 fq0Var, bz1 bz1Var, String str, View view, jc0 jc0Var, az1 az1Var, UUID uuid, boolean z) {
        super(view.getContext());
        int i = 16;
        fl4 zy1Var = Build.VERSION.SDK_INT >= 29 ? new zy1(i) : new fl4(i);
        this.n = fq0Var;
        this.s = bz1Var;
        this.t = str;
        this.u = view;
        this.v = z;
        this.w = zy1Var;
        Object systemService = view.getContext().getSystemService("window");
        systemService.getClass();
        this.x = (WindowManager) systemService;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        bz1 bz1Var2 = this.s;
        boolean zB = fb.b(view);
        boolean z2 = bz1Var2.b;
        int i2 = bz1Var2.a;
        if (z2 && zB) {
            i2 |= 8192;
        } else if (z2 && !zB) {
            i2 &= -8193;
        }
        layoutParams.flags = i2;
        layoutParams.type = 1002;
        layoutParams.token = view.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(view.getContext().getResources().getString(R.string.default_popup_window_title));
        this.H = layoutParams;
        this.c0 = az1Var;
        this.d0 = z61.a;
        this.e0 = o44.g(null);
        this.f0 = o44.g(null);
        this.h0 = o44.b(new ta(13, this));
        this.i0 = new Rect();
        this.j0 = new wm2(new za(this, 2));
        setId(android.R.id.content);
        setTag(R.id.view_tree_lifecycle_owner, af4.a(view));
        setTag(R.id.view_tree_view_model_store_owner, ef4.b(view));
        setTag(R.id.view_tree_saved_state_registry_owner, cf4.c(view));
        setTag(R.id.compose_view_saveable_id_tag, "Popup:" + uuid);
        setClipChildren(false);
        setElevation(jc0Var.x(8.0f));
        setOutlineProvider(new wy1(0));
        this.l0 = o44.g(x10.a);
        this.n0 = new int[2];
    }

    private final vq0 getContent() {
        return (vq0) this.l0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y61 getParentLayoutCoordinates() {
        return (y61) this.f0.getValue();
    }

    private final i21 getVisibleDisplayBounds() {
        this.w.getClass();
        View view = this.u;
        Rect rect = this.i0;
        view.getWindowVisibleDisplayFrame(rect);
        return new i21(rect.left, rect.top, rect.right, rect.bottom);
    }

    private final void setContent(vq0 vq0Var) {
        this.l0.setValue(vq0Var);
    }

    private final void setParentLayoutCoordinates(y61 y61Var) {
        this.f0.setValue(y61Var);
    }

    @Override // defpackage.a1
    public final void a(x20 x20Var, int i) {
        x20Var.X(-857613600);
        int i2 = 4;
        int i3 = (x20Var.h(this) ? 4 : 2) | i;
        if (x20Var.O(i3 & 1, (i3 & 3) != 2)) {
            getContent().e(x20Var, 0);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new z0(this, i, i2);
        }
    }

    @Override // defpackage.a1
    public final void d(boolean z, int i, int i2, int i3, int i4) {
        super.d(z, i, i2, i3, i4);
        this.s.getClass();
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        WindowManager.LayoutParams layoutParams = this.H;
        layoutParams.width = measuredWidth;
        layoutParams.height = childAt.getMeasuredHeight();
        this.w.getClass();
        this.x.updateViewLayout(this, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.s.c) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getKeyCode() == 4 || keyEvent.getKeyCode() == 111) {
            KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
            if (keyDispatcherState == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            }
            if (keyEvent.getAction() == 1 && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                fq0 fq0Var = this.n;
                if (fq0Var != null) {
                    fq0Var.a();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // defpackage.a1
    public final void e(int i, int i2) {
        this.s.getClass();
        i21 visibleDisplayBounds = getVisibleDisplayBounds();
        super.e(View.MeasureSpec.makeMeasureSpec(visibleDisplayBounds.c - visibleDisplayBounds.a, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(visibleDisplayBounds.d - visibleDisplayBounds.b, Integer.MIN_VALUE));
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.h0.getValue()).booleanValue();
    }

    public final WindowManager.LayoutParams getParams$ui() {
        return this.H;
    }

    public final z61 getParentLayoutDirection() {
        return this.d0;
    }

    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final l21 m38getPopupContentSizebOM6tXw() {
        return (l21) this.e0.getValue();
    }

    public final az1 getPositionProvider() {
        return this.c0;
    }

    @Override // defpackage.a1
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.m0;
    }

    public final String getTestTag() {
        return this.t;
    }

    public /* bridge */ /* synthetic */ View getViewRoot() {
        return null;
    }

    public final void h(v20 v20Var, w10 w10Var) {
        setParentCompositionContext(v20Var);
        setContent(w10Var);
        this.m0 = true;
    }

    public final void i(fq0 fq0Var, bz1 bz1Var, String str, z61 z61Var) {
        int i;
        this.n = fq0Var;
        this.t = str;
        if (!g31.a(this.s, bz1Var)) {
            bz1Var.getClass();
            this.s = bz1Var;
            boolean zB = fb.b(this.u);
            boolean z = bz1Var.b;
            int i2 = bz1Var.a;
            if (z && zB) {
                i2 |= 8192;
            } else if (z && !zB) {
                i2 &= -8193;
            }
            WindowManager.LayoutParams layoutParams = this.H;
            layoutParams.flags = i2;
            this.w.getClass();
            this.x.updateViewLayout(this, layoutParams);
        }
        int iOrdinal = z61Var.ordinal();
        if (iOrdinal != 0) {
            i = 1;
            if (iOrdinal != 1) {
                dk0.l();
                return;
            }
        } else {
            i = 0;
        }
        super.setLayoutDirection(i);
    }

    public final void j() {
        y61 parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            if (!parentLayoutCoordinates.B()) {
                parentLayoutCoordinates = null;
            }
            if (parentLayoutCoordinates == null) {
                return;
            }
            long jS = parentLayoutCoordinates.S();
            long jA = this.v ? parentLayoutCoordinates.a(0L) : parentLayoutCoordinates.i(0L);
            long jRound = (((long) Math.round(Float.intBitsToFloat((int) (jA >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (jA & 4294967295L)))) & 4294967295L);
            int i = (int) (jRound >> 32);
            int i2 = (int) (jRound & 4294967295L);
            i21 i21Var = new i21(i, i2, ((int) (jS >> 32)) + i, ((int) (jS & 4294967295L)) + i2);
            if (i21Var.equals(this.g0)) {
                return;
            }
            this.g0 = i21Var;
            l();
        }
    }

    public final void k(y61 y61Var) {
        setParentLayoutCoordinates(y61Var);
        j();
    }

    public final void l() {
        l21 l21VarM38getPopupContentSizebOM6tXw;
        i21 i21Var = this.g0;
        if (i21Var == null || (l21VarM38getPopupContentSizebOM6tXw = m38getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        long j = l21VarM38getPopupContentSizebOM6tXw.a;
        i21 visibleDisplayBounds = getVisibleDisplayBounds();
        long j2 = (((long) (visibleDisplayBounds.d - visibleDisplayBounds.b)) & 4294967295L) | (((long) (visibleDisplayBounds.c - visibleDisplayBounds.a)) << 32);
        s42 s42Var = new s42();
        s42Var.a = 0L;
        this.j0.c(this, kt1.s, new xy1(s42Var, this, i21Var, j2, j));
        long j3 = s42Var.a;
        WindowManager.LayoutParams layoutParams = this.H;
        layoutParams.x = (int) (j3 >> 32);
        layoutParams.y = (int) (j3 & 4294967295L);
        boolean z = this.s.e;
        fl4 fl4Var = this.w;
        if (z) {
            fl4Var.i(this, (int) (j2 >> 32), (int) (j2 & 4294967295L));
        }
        fl4Var.getClass();
        this.x.updateViewLayout(this, layoutParams);
    }

    @Override // defpackage.a1, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j0.d();
        if (!this.s.c || Build.VERSION.SDK_INT < 33) {
            return;
        }
        if (this.k0 == null) {
            this.k0 = new me(this.n, 0);
        }
        f3.g(this, this.k0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        wm2 wm2Var = this.j0;
        zq zqVar = wm2Var.h;
        if (zqVar != null) {
            zqVar.a();
        }
        wm2Var.a();
        if (Build.VERSION.SDK_INT >= 33) {
            f3.h(this, this.k0);
        }
        this.k0 = null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.s.d) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent != null && motionEvent.getAction() == 0 && (motionEvent.getX() < 0.0f || motionEvent.getX() >= getWidth() || motionEvent.getY() < 0.0f || motionEvent.getY() >= getHeight())) {
            fq0 fq0Var = this.n;
            if (fq0Var != null) {
                fq0Var.a();
                return true;
            }
        } else {
            if (motionEvent == null || motionEvent.getAction() != 4) {
                return super.onTouchEvent(motionEvent);
            }
            fq0 fq0Var2 = this.n;
            if (fq0Var2 != null) {
                fq0Var2.a();
            }
        }
        return true;
    }

    public final void setParentLayoutDirection(z61 z61Var) {
        this.d0 = z61Var;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m39setPopupContentSizefhxjrPA(l21 l21Var) {
        this.e0.setValue(l21Var);
    }

    public final void setPositionProvider(az1 az1Var) {
        this.c0 = az1Var;
    }

    public final void setTestTag(String str) {
        this.t = str;
    }

    public static /* synthetic */ void getParams$ui$annotations() {
    }

    public a1 getSubCompositionView() {
        return this;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
    }
}
