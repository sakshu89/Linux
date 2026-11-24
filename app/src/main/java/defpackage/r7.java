package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.os.StrictMode;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.TranslationRequestValue;
import android.view.translation.ViewTranslationRequest;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;
import com.project.sonic.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r7 extends ViewGroup implements it1, o82, ta0, ks1, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnTouchModeChangeListener, wn0 {
    public static Class s1;
    public static Method t1;
    public static Method u1;
    public static final yl1 v1 = new yl1();
    public static c7 w1;
    public static Method x1;
    public final lt1 A0;
    public boolean B0;
    public xc C0;
    public q40 D0;
    public boolean E0;
    public final lh1 F0;
    public long G0;
    public final na1 H;
    public final int[] H0;
    public final float[] I0;
    public final float[] J0;
    public final float[] K0;
    public long L0;
    public boolean M0;
    public long N0;
    public final ku1 O0;
    public final qc0 P0;
    public hq0 Q0;
    public final zy2 R0;
    public final xy2 S0;
    public final AtomicReference T0;
    public final ac0 U0;
    public final el1 V0;
    public final ku1 W0;
    public final ku1 X0;
    public final na0 Y0;
    public final p11 Z0;
    public long a;
    public final fk1 a1;
    public final boolean b;
    public final mc b1;
    public d01 c;
    public final fw c0;
    public MotionEvent c1;
    public final vc d0;
    public long d1;
    public final p71 e;
    public final s11 e0;
    public final cu2 e1;
    public rb1 f;
    public final n71 f0;
    public final yl1 f1;
    public final ml1 g0;
    public float g1;
    public final n42 h0;
    public float h1;
    public sb1 i;
    public final r7 i0;
    public final o7 i1;
    public o72 j;
    public final jg2 j0;
    public final b7 j1;
    public final hg k;
    public final x7 k0;
    public boolean k1;
    public q8 l0;
    public final kk l1;
    public final o6 m0;
    public final n7 m1;
    public final b7 n;
    public final o9 n0;
    public final yo n1;
    public final wj o0;
    public boolean o1;
    public final yl1 p0;
    public final py0 p1;
    public yl1 q0;
    public View q1;
    public boolean r0;
    public final l7 r1;
    public final ku1 s;
    public final qk1 s0;
    public final View t;
    public final ux t0;
    public final boolean u;
    public final ku1 u0;
    public final do0 v;
    public final p6 v0;
    public j70 w;
    public final s6 w0;
    public final c9 x;
    public boolean x0;
    public final z6 y0;
    public final y6 z0;

    public r7(Context context, j70 j70Var) {
        z61 z61Var;
        super(context);
        this.a = 9205357640488583168L;
        int i = 1;
        this.b = true;
        this.e = new p71();
        this.j = el1.e;
        this.k = new hg();
        this.n = new b7(this, 0);
        lc0 lc0VarA = vc4.a(context);
        ak1 ak1Var = ak1.i;
        this.s = new ku1(lc0VarA, ak1Var);
        int i2 = Build.VERSION.SDK_INT;
        boolean z = i2 >= 35;
        this.u = z;
        ki0 ki0Var = new ki0();
        this.v = new do0(this, this);
        this.w = j70Var;
        this.x = new c9();
        this.H = new na1();
        this.c0 = new fw();
        this.d0 = new vc(ViewConfiguration.get(context));
        this.e0 = new s11();
        n71 n71Var = new n71(3);
        n71Var.c0(p82.c);
        n71Var.Z(getDensity());
        n71Var.e0(getViewConfiguration());
        n71Var.d0(new p7(this).c(((do0) getFocusOwner()).e).c(m35getDragAndDropManager().c));
        this.f0 = n71Var;
        ml1 ml1Var = d21.a;
        this.g0 = new ml1();
        getLayoutNodes();
        this.h0 = new n42();
        this.i0 = this;
        this.j0 = new jg2(getRoot(), ki0Var, getLayoutNodes());
        x7 x7Var = new x7(this);
        this.k0 = x7Var;
        this.l0 = new q8(this, new g7(0, this, e8.class, "getContentCaptureSessionCompat", "getContentCaptureSessionCompat(Landroid/view/View;)Landroidx/compose/ui/contentcapture/ContentCaptureSessionWrapper;", 1, 0, 0));
        o6 o6Var = new o6();
        Object systemService = context.getSystemService("accessibility");
        systemService.getClass();
        this.m0 = o6Var;
        this.n0 = new o9(this);
        this.o0 = new wj();
        this.p0 = new yl1();
        this.s0 = new qk1();
        n71 root = getRoot();
        ux uxVar = new ux();
        uxVar.b = root;
        uxVar.c = new mw0(root.o0.c);
        uxVar.d = new wj1(2);
        uxVar.e = new pw0();
        this.t0 = uxVar;
        this.u0 = o44.g(new Configuration(context.getResources().getConfiguration()));
        wj autofillTree = getAutofillTree();
        p6 p6Var = new p6();
        p6Var.a = this;
        p6Var.b = autofillTree;
        AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
        if (autofillManager == null) {
            og.n("Autofill service could not be located.");
            throw null;
        }
        p6Var.c = autofillManager;
        setImportantForAutofill(1);
        AutofillId autofillId = getAutofillId();
        if (autofillId == null) {
            throw cq.e("Required value was null.");
        }
        p6Var.e = autofillId;
        this.v0 = p6Var;
        AutofillManager autofillManager2 = (AutofillManager) context.getSystemService(AutofillManager.class);
        if (autofillManager2 == null) {
            throw cq.e("Autofill service could not be located.");
        }
        this.w0 = new s6(new wj1(i, autofillManager2), getSemanticsOwner(), this, getRectManager(), context.getPackageName());
        this.y0 = new z6(context);
        this.z0 = new y6(getClipboardManager());
        this.A0 = new lt1(new k7(this, i));
        this.F0 = new lh1(getRoot());
        this.G0 = 9223372034707292159L;
        this.H0 = new int[]{0, 0};
        float[] fArrA = ih1.a();
        this.I0 = fArrA;
        this.J0 = ih1.a();
        this.K0 = ih1.a();
        this.L0 = -1L;
        this.N0 = 9187343241974906880L;
        this.O0 = o44.g(null);
        this.P0 = o44.b(new n7(this, i));
        zy2 zy2Var = new zy2(getView(), this);
        this.R0 = zy2Var;
        this.S0 = new xy2(zy2Var);
        this.T0 = new AtomicReference(null);
        this.U0 = new ac0(getTextInputService());
        this.V0 = new el1(8);
        this.W0 = new ku1(yn4.a(context), ak1Var);
        int layoutDirection = context.getResources().getConfiguration().getLayoutDirection();
        int[] iArr = un0.a;
        z61 z61Var2 = z61.a;
        if (layoutDirection != 0) {
            z61Var = layoutDirection != 1 ? null : z61.b;
        } else {
            z61Var = z61Var2;
        }
        this.X0 = o44.g(z61Var != null ? z61Var : z61Var2);
        this.Y0 = new na0(this, i);
        this.Z0 = new p11(isInTouchMode() ? 1 : 2);
        fk1 fk1Var = new fk1();
        new pm1(new ok[16]);
        new pm1(new mr4[16]);
        new pm1(new n71[16]);
        new pm1(new mr4[16]);
        this.a1 = fk1Var;
        mc mcVar = new mc();
        new nr4(new ta(i, mcVar));
        this.b1 = mcVar;
        this.e1 = new cu2(7);
        this.f1 = new yl1();
        int i3 = 0;
        this.i1 = new o7(i3, this);
        this.j1 = new b7(this, i);
        this.l1 = new kk(context, new k7(this, i3));
        this.m1 = new n7(this, i3);
        this.n1 = i2 < 29 ? new zo(fArrA) : new ap();
        addOnAttachStateChangeListener(this.l0);
        setWillNotDraw(false);
        setFocusable(true);
        d8.a.a(this, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        int i4 = u73.a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        setAccessibilityDelegate(x7Var.b);
        setOnDragListener(m35getDragAndDropManager());
        getRoot().d(this);
        if (i2 >= 29) {
            z7.a.a(this);
        }
        if (z) {
            View view = new View(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
            view.setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
            this.t = view;
            addView(view, -1);
        }
        this.p1 = i2 >= 31 ? new py0(13) : null;
        this.r1 = new l7(this);
    }

    public static void d(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof r7) {
                ((r7) childAt).s();
            } else if (childAt instanceof ViewGroup) {
                d((ViewGroup) childAt);
            }
        }
    }

    public static long e(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return size;
        }
        if (mode == 0) {
            return 2147483647L;
        }
        if (mode != 1073741824) {
            throw new IllegalStateException();
        }
        long j = size;
        return j | (j << 32);
    }

    public static View f(View view, int i) throws NoSuchMethodException {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", null);
            declaredMethod.setAccessible(true);
            if (g31.a(declaredMethod.invoke(view, null), Integer.valueOf(i))) {
                return view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View viewF = f(viewGroup.getChildAt(i2), i);
                    if (viewF != null) {
                        return viewF;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f7 get_viewTreeOwners() {
        return (f7) this.O0.getValue();
    }

    public static void i(n71 n71Var) {
        n71Var.D();
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            i((n71) objArr[i2]);
        }
    }

    public static boolean l(MotionEvent motionEvent) {
        boolean z = (Float.floatToRawIntBits(motionEvent.getX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawY()) & Integer.MAX_VALUE) >= 2139095040;
        if (!z) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 1; i < pointerCount; i++) {
                z = (Float.floatToRawIntBits(motionEvent.getX(i)) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY(i)) & Integer.MAX_VALUE) >= 2139095040 || (Build.VERSION.SDK_INT >= 29 && !rk1.a.a(motionEvent, i));
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    private void setDensity(jc0 jc0Var) {
        this.s.setValue(jc0Var);
    }

    private void setFontFamilyResolver(qo0 qo0Var) {
        this.W0.setValue(qo0Var);
    }

    private void setLayoutDirection(z61 z61Var) {
        this.X0.setValue(z61Var);
    }

    private final void set_viewTreeOwners(f7 f7Var) {
        this.O0.setValue(f7Var);
    }

    public final void A(n71 n71Var) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (n71Var != null) {
            while (n71Var != null && n71Var.r() == l71.a) {
                if (!this.E0) {
                    n71 n71VarU = n71Var.u();
                    if (n71VarU == null) {
                        break;
                    }
                    long j = n71VarU.o0.c.e;
                    if (q40.f(j) && q40.e(j)) {
                        break;
                    }
                }
                n71Var = n71Var.u();
            }
            if (n71Var == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    public final long B(long j) {
        x();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (this.N0 >> 32));
        return ih1.b((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (this.N0 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32), this.K0);
    }

    public final int C(MotionEvent motionEvent) {
        Object obj;
        if (this.o1) {
            this.o1 = false;
            int metaState = motionEvent.getMetaState();
            this.H.getClass();
            ma3.a.setValue(new sy1(metaState));
        }
        qk1 qk1Var = this.s0;
        q91 q91VarC = qk1Var.c(motionEvent, this);
        int actionMasked = motionEvent.getActionMasked();
        ux uxVar = this.t0;
        if (q91VarC == null) {
            if (!uxVar.a) {
                ((if1) ((wj1) uxVar.d).b).a();
                ((mw0) uxVar.c).c();
            }
            return 0;
        }
        List list = (List) q91VarC.b;
        int size = list.size() - 1;
        if (size < 0) {
            obj = null;
            break;
        }
        while (true) {
            int i = size - 1;
            obj = list.get(size);
            if (((py1) obj).e && (actionMasked == 0 || actionMasked == 5)) {
                break;
            }
            if (i < 0) {
                obj = null;
                break;
            }
            size = i;
        }
        py1 py1Var = (py1) obj;
        if (py1Var != null) {
            this.a = py1Var.d;
        }
        int iC = uxVar.c(q91VarC, this, m(motionEvent));
        q91VarC.c = null;
        if ((actionMasked != 0 && actionMasked != 5) || (iC & 1) != 0) {
            return iC;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        qk1Var.c.delete(pointerId);
        qk1Var.b.delete(pointerId);
        return iC;
    }

    public final void D(MotionEvent motionEvent, int i, long j, boolean z) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (i != 9 && i != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerPropertiesArr[i2] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            pointerCoordsArr[i3] = new MotionEvent.PointerCoords();
        }
        int i4 = 0;
        while (i4 < pointerCount) {
            int i5 = ((actionIndex < 0 || i4 < actionIndex) ? 0 : 1) + i4;
            motionEvent.getPointerProperties(i5, pointerPropertiesArr[i4]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i4];
            motionEvent.getPointerCoords(i5, pointerCoords);
            float f = pointerCoords.x;
            long jP = p((((long) Float.floatToRawIntBits(pointerCoords.y)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32));
            pointerCoords.x = Float.intBitsToFloat((int) (jP >> 32));
            pointerCoords.y = Float.intBitsToFloat((int) (jP & 4294967295L));
            i4++;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j : motionEvent.getDownTime(), j, i, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        q91 q91VarC = this.s0.c(motionEventObtain, this);
        q91VarC.getClass();
        this.t0.c(q91VarC, this, true);
        motionEventObtain.recycle();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final void E(vq0 vq0Var, y50 y50Var) {
        q7 q7Var;
        if (y50Var instanceof q7) {
            q7Var = (q7) y50Var;
            int i = q7Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                q7Var.i = i - Integer.MIN_VALUE;
            } else {
                q7Var = new q7(this, y50Var);
            }
        } else {
            q7Var = new q7(this, y50Var);
        }
        Object obj = q7Var.e;
        int i2 = q7Var.i;
        if (i2 == 0) {
            bz3.g(obj);
            k7 k7Var = new k7(this, 2);
            q7Var.i = 1;
            if (tl4.c(new aa(k7Var, this.T0, vq0Var, null, 13), q7Var) == t70.a) {
                return;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return;
            }
            bz3.g(obj);
        }
        og.k();
    }

    public final void F(Configuration configuration) {
        Configuration configuration2 = getConfiguration();
        if (g31.a(configuration2, configuration)) {
            return;
        }
        setConfiguration(new Configuration(configuration));
        if (configuration2.fontScale != configuration.fontScale || configuration2.densityDpi != configuration.densityDpi) {
            setDensity(vc4.a(getContext()));
        }
        if ((configuration2.diff(configuration) & (-1342235264)) != 0) {
            this.H.getClass();
        }
        int i = Build.VERSION.SDK_INT;
        if ((i >= 31 ? configuration2.fontWeightAdjustment : 0) != (i >= 31 ? configuration.fontWeightAdjustment : 0)) {
            setFontFamilyResolver(yn4.a(getContext()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0044  */
    public final void G() {
        boolean z;
        int i;
        boolean z2;
        int[] iArr = this.H0;
        getLocationOnScreen(iArr);
        long j = this.G0;
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        int i4 = iArr[0];
        if (i2 == i4 && i3 == iArr[1] && this.L0 >= 0) {
            z = false;
        } else {
            this.G0 = (((long) i4) << 32) | (((long) iArr[1]) & 4294967295L);
            if (i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE) {
                z = false;
            } else {
                getRoot().p0.p.x0();
                z = true;
            }
        }
        x();
        View rootView = this.q1;
        if (rootView == null) {
            rootView = getRootView();
            this.q1 = rootView;
        }
        n42 rectManager = getRectManager();
        long j2 = this.G0;
        long jB = ap4.b(this.N0);
        int width = rootView.getWidth();
        int height = rootView.getHeight();
        rectManager.getClass();
        float[] fArr = this.J0;
        if (fArr.length < 16) {
            i = 0;
        } else {
            i = (((fArr[0] == 1.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[4] == 0.0f && fArr[5] == 1.0f && fArr[6] == 0.0f && fArr[8] == 0.0f && fArr[9] == 0.0f && fArr[10] == 1.0f) ? 1 : 0) << 1) | ((fArr[12] == 0.0f && fArr[13] == 0.0f && fArr[14] == 0.0f && fArr[15] == 1.0f) ? 1 : 0);
        }
        o03 o03Var = rectManager.b;
        if ((i & 2) != 0) {
            fArr = null;
        }
        if (e21.a(jB, o03Var.d)) {
            z2 = false;
        } else {
            o03Var.d = jB;
            z2 = true;
        }
        if (!e21.a(j2, o03Var.e)) {
            o03Var.e = j2;
            z2 = true;
        }
        if (fArr != null) {
            o03Var.g = fArr;
            z2 = true;
        }
        long j3 = (((long) width) << 32) | (((long) height) & 4294967295L);
        if (j3 != o03Var.f) {
            o03Var.f = j3;
            z2 = true;
        }
        rectManager.e = z2 || rectManager.e;
        this.F0.a(z);
        getRectManager().a();
    }

    public final void H(float f) {
        if (this.u) {
            if (f > 0.0f) {
                if (Float.isNaN(this.g1) || f > this.g1) {
                    this.g1 = f;
                    return;
                }
                return;
            }
            if (f < 0.0f) {
                if (Float.isNaN(this.h1) || f < this.h1) {
                    this.h1 = f;
                }
            }
        }
    }

    @Override // defpackage.wn0
    public final void a(ko0 ko0Var, ko0 ko0Var2) {
        zn1 zn1Var;
        zn1 zn1Var2;
        if (ko0Var != null) {
            ko0 ko0Var3 = ko0Var;
            if (!ko0Var3.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var = ko0Var3.a;
            n71 n71VarG = cm4.g(ko0Var);
            LinkedHashSet linkedHashSet = null;
            ArrayList arrayList = null;
            while (n71VarG != null) {
                if ((n71VarG.o0.f.e & ArabicShaping.SEEN_TWOCELL_NEAR) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & ArabicShaping.SEEN_TWOCELL_NEAR) != 0) {
                            dk1 dk1VarB = dk1Var;
                            pm1 pm1Var = null;
                            while (dk1VarB != null) {
                                if (dk1VarB instanceof n01) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(dk1VarB);
                                } else if ((dk1VarB.c & ArabicShaping.SEEN_TWOCELL_NEAR) != 0 && (dk1VarB instanceof zb0)) {
                                    int i = 0;
                                    for (dk1 dk1Var2 = ((zb0) dk1VarB).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                                        if ((dk1Var2.c & ArabicShaping.SEEN_TWOCELL_NEAR) != 0) {
                                            i++;
                                            if (i == 1) {
                                                dk1VarB = dk1Var2;
                                            } else {
                                                if (pm1Var == null) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (dk1VarB != null) {
                                                    pm1Var.b(dk1VarB);
                                                    dk1VarB = null;
                                                }
                                                pm1Var.b(dk1Var2);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                dk1VarB = cm4.b(pm1Var);
                            }
                        }
                        dk1Var = dk1Var.f;
                    }
                }
                n71VarG = n71VarG.u();
                dk1Var = (n71VarG == null || (zn1Var2 = n71VarG.o0) == null) ? null : zn1Var2.e;
            }
            if (arrayList == null) {
                return;
            }
            if (ko0Var2 != null) {
                if (!ko0Var2.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1 dk1Var3 = ko0Var2.a;
                n71 n71VarG2 = cm4.g(ko0Var2);
                LinkedHashSet linkedHashSet2 = null;
                while (n71VarG2 != null) {
                    if ((n71VarG2.o0.f.e & ArabicShaping.SEEN_TWOCELL_NEAR) != 0) {
                        while (dk1Var3 != null) {
                            if ((dk1Var3.c & ArabicShaping.SEEN_TWOCELL_NEAR) != 0) {
                                dk1 dk1VarB2 = dk1Var3;
                                pm1 pm1Var2 = null;
                                while (dk1VarB2 != null) {
                                    if (dk1VarB2 instanceof n01) {
                                        if (linkedHashSet2 == null) {
                                            linkedHashSet2 = new LinkedHashSet();
                                        }
                                        linkedHashSet2.add(dk1VarB2);
                                    } else if ((dk1VarB2.c & ArabicShaping.SEEN_TWOCELL_NEAR) != 0 && (dk1VarB2 instanceof zb0)) {
                                        int i2 = 0;
                                        for (dk1 dk1Var4 = ((zb0) dk1VarB2).H; dk1Var4 != null; dk1Var4 = dk1Var4.i) {
                                            if ((dk1Var4.c & ArabicShaping.SEEN_TWOCELL_NEAR) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    dk1VarB2 = dk1Var4;
                                                } else {
                                                    if (pm1Var2 == null) {
                                                        pm1Var2 = new pm1(new dk1[16]);
                                                    }
                                                    if (dk1VarB2 != null) {
                                                        pm1Var2.b(dk1VarB2);
                                                        dk1VarB2 = null;
                                                    }
                                                    pm1Var2.b(dk1Var4);
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    dk1VarB2 = cm4.b(pm1Var2);
                                }
                            }
                            dk1Var3 = dk1Var3.f;
                        }
                    }
                    n71VarG2 = n71VarG2.u();
                    dk1Var3 = (n71VarG2 == null || (zn1Var = n71VarG2.o0) == null) ? null : zn1Var.e;
                }
                linkedHashSet = linkedHashSet2;
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                n01 n01Var = (n01) arrayList.get(i3);
                if (!(linkedHashSet != null ? linkedHashSet.contains(n01Var) : false)) {
                    n01Var.A();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        ko0 ko0Var = ((do0) getFocusOwner()).c;
        if (!ko0Var.w) {
            return;
        }
        if (!ko0Var.a.w) {
            z01.b("visitSubtreeIf called on an unattached node");
        }
        pm1 pm1Var = new pm1(new dk1[16]);
        dk1 dk1Var = ko0Var.a;
        dk1 dk1Var2 = dk1Var.i;
        if (dk1Var2 == null) {
            cm4.a(pm1Var, dk1Var);
        } else {
            pm1Var.b(dk1Var2);
        }
        while (true) {
            int i3 = pm1Var.c;
            if (i3 == 0) {
                return;
            }
            dk1 dk1Var3 = (dk1) pm1Var.l(i3 - 1);
            if ((dk1Var3.e & 1024) != 0) {
                for (dk1 dk1Var4 = dk1Var3; dk1Var4 != null && dk1Var4.w; dk1Var4 = dk1Var4.i) {
                    if ((dk1Var4.c & 1024) != 0) {
                        dk1 dk1VarB = dk1Var4;
                        pm1 pm1Var2 = null;
                        while (dk1VarB != null) {
                            int i4 = 0;
                            if (dk1VarB instanceof ko0) {
                                ko0 ko0Var2 = (ko0) dk1VarB;
                                if (ko0Var2.w && ko0Var2.K0().a) {
                                    super.addFocusables(arrayList, i, i2);
                                    ko0 ko0Var3 = ((do0) getFocusOwner()).c;
                                    if (ko0Var3.w) {
                                        if (!ko0Var3.a.w) {
                                            z01.b("visitSubtreeIf called on an unattached node");
                                        }
                                        pm1 pm1Var3 = new pm1(new dk1[16]);
                                        dk1 dk1Var5 = ko0Var3.a;
                                        dk1 dk1Var6 = dk1Var5.i;
                                        if (dk1Var6 == null) {
                                            cm4.a(pm1Var3, dk1Var5);
                                        } else {
                                            pm1Var3.b(dk1Var6);
                                        }
                                        while (true) {
                                            int i5 = pm1Var3.c;
                                            if (i5 == 0) {
                                                break;
                                            }
                                            dk1 dk1Var7 = (dk1) pm1Var3.l(i5 - 1);
                                            if ((dk1Var7.e & 1024) != 0) {
                                                for (dk1 dk1Var8 = dk1Var7; dk1Var8 != null && dk1Var8.w; dk1Var8 = dk1Var8.i) {
                                                    if ((dk1Var8.c & 1024) != 0) {
                                                        dk1 dk1VarB2 = dk1Var8;
                                                        pm1 pm1Var4 = null;
                                                        while (dk1VarB2 != null) {
                                                            if (dk1VarB2 instanceof ko0) {
                                                                ko0 ko0Var4 = (ko0) dk1VarB2;
                                                                if (ko0Var4.w) {
                                                                    eo0 eo0VarK0 = ko0Var4.K0();
                                                                    if (ko0Var4.w && eo0VarK0.a) {
                                                                        return;
                                                                    }
                                                                }
                                                            } else if ((dk1VarB2.c & 1024) != 0 && (dk1VarB2 instanceof zb0)) {
                                                                int i6 = 0;
                                                                for (dk1 dk1Var9 = ((zb0) dk1VarB2).H; dk1Var9 != null; dk1Var9 = dk1Var9.i) {
                                                                    if ((dk1Var9.c & 1024) != 0) {
                                                                        i6++;
                                                                        if (i6 == 1) {
                                                                            dk1VarB2 = dk1Var9;
                                                                        } else {
                                                                            if (pm1Var4 == null) {
                                                                                pm1Var4 = new pm1(new dk1[16]);
                                                                            }
                                                                            if (dk1VarB2 != null) {
                                                                                pm1Var4.b(dk1VarB2);
                                                                                dk1VarB2 = null;
                                                                            }
                                                                            pm1Var4.b(dk1Var9);
                                                                        }
                                                                    }
                                                                }
                                                                if (i6 == 1) {
                                                                }
                                                            }
                                                            dk1VarB2 = cm4.b(pm1Var4);
                                                        }
                                                    }
                                                }
                                            }
                                            cm4.a(pm1Var3, dk1Var7);
                                        }
                                    }
                                    if (arrayList != null) {
                                        arrayList.remove(this);
                                        return;
                                    }
                                    return;
                                }
                            } else if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                for (dk1 dk1Var10 = ((zb0) dk1VarB).H; dk1Var10 != null; dk1Var10 = dk1Var10.i) {
                                    if ((dk1Var10.c & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            dk1VarB = dk1Var10;
                                        } else {
                                            if (pm1Var2 == null) {
                                                pm1Var2 = new pm1(new dk1[16]);
                                            }
                                            if (dk1VarB != null) {
                                                pm1Var2.b(dk1VarB);
                                                dk1VarB = null;
                                            }
                                            pm1Var2.b(dk1Var10);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            dk1VarB = cm4.b(pm1Var2);
                        }
                    }
                }
            }
            cm4.a(pm1Var, dk1Var3);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        view.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addViewInLayout(view, i, layoutParams, true);
    }

    @Override // android.view.View
    public final void autofill(SparseArray sparseArray) {
        cg2 cg2VarW;
        hq0 hq0Var;
        hq0 hq0Var2;
        s6 s6Var = this.w0;
        if (s6Var != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int iKeyAt = sparseArray.keyAt(i);
                AutofillValue autofillValue = (AutofillValue) sparseArray.get(iKeyAt);
                n71 n71Var = (n71) s6Var.b.c.b(iKeyAt);
                if (n71Var != null && (cg2VarW = n71Var.w()) != null) {
                    gm1 gm1Var = cg2VarW.a;
                    Object objG = gm1Var.g(bg2.g);
                    if (objG == null) {
                        objG = null;
                    }
                    b2 b2Var = (b2) objG;
                    if (b2Var != null && (hq0Var2 = (hq0) b2Var.b) != null) {
                    }
                    Object objG2 = gm1Var.g(bg2.h);
                    b2 b2Var2 = (b2) (objG2 != null ? objG2 : null);
                    if (b2Var2 != null && (hq0Var = (hq0) b2Var2.b) != null) {
                    }
                }
            }
        }
        p6 p6Var = this.v0;
        if (p6Var != null) {
            wj wjVar = (wj) p6Var.b;
            if (wjVar.a.isEmpty()) {
                return;
            }
            int size2 = sparseArray.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int iKeyAt2 = sparseArray.keyAt(i2);
                AutofillValue autofillValue2 = (AutofillValue) sparseArray.get(iKeyAt2);
                if (autofillValue2.isText()) {
                    autofillValue2.getTextValue().toString();
                    if (wjVar.a.get(Integer.valueOf(iKeyAt2)) != null) {
                        dk0.t();
                        return;
                    }
                } else {
                    if (autofillValue2.isDate()) {
                        throw new no1("An operation is not implemented: b/138604541: Add onFill() callback for date");
                    }
                    if (autofillValue2.isList()) {
                        throw new no1("An operation is not implemented: b/138604541: Add onFill() callback for list");
                    }
                    if (autofillValue2.isToggle()) {
                        throw new no1("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.k0.e(this.a, i, false);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.k0.e(this.a, i, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            i(getRoot());
        }
        q(true);
        im2.j().m();
        this.r0 = true;
        fw fwVar = this.c0;
        u6 u6Var = fwVar.a;
        Canvas canvas2 = u6Var.a;
        u6Var.a = canvas;
        getRoot().i(u6Var, null);
        fwVar.a.a = canvas2;
        yl1 yl1Var = this.p0;
        if (yl1Var.i()) {
            int i = yl1Var.b;
            for (int i2 = 0; i2 < i; i2++) {
                ((yu0) ((ht1) yl1Var.f(i2))).g();
            }
        }
        int i3 = y73.a;
        yl1Var.d();
        this.r0 = false;
        yl1 yl1Var2 = this.q0;
        if (yl1Var2 != null) {
            yl1Var.b(yl1Var2);
            yl1Var2.d();
        }
        if (this.u) {
            pe.a(this, this.g1);
            View view = this.t;
            if (view == null) {
                g31.f("frameRateCategoryView");
                throw null;
            }
            pe.a(view, this.h1);
            if (!Float.isNaN(this.h1)) {
                view.invalidate();
                drawChild(canvas, view, getDrawingTime());
            }
            this.g1 = Float.NaN;
            this.h1 = Float.NaN;
        }
        getRectManager().a();
    }

    /* JADX WARN: Failed to calculate best type for var: r5v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v12 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v12 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v13 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v12 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(android.view.MotionEvent r43) {
        /*
            Method dump skipped, instruction units count: 1939
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r7.dispatchGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0157  */
    /* JADX WARN: Code duplicated, block: B:70:0x015e A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i;
        boolean z = this.k1;
        b7 b7Var = this.j1;
        if (z) {
            removeCallbacks(b7Var);
            b7Var.run();
        }
        if (!l(motionEvent) && isAttachedToWindow()) {
            x7 x7Var = this.k0;
            r7 r7Var = x7Var.e;
            AccessibilityManager accessibilityManager = x7Var.j;
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                if (action == 7 || action == 9) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    r7Var.q(true);
                    pw0 pw0Var = new pw0();
                    n71 root = r7Var.getRoot();
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(x)) << 32) | (((long) Float.floatToRawIntBits(y)) & 4294967295L);
                    zn1 zn1Var = root.o0;
                    co1 co1Var = zn1Var.d;
                    r72 r72Var = co1.v0;
                    zn1Var.d.a1(co1.z0, co1Var.S0(jFloatToRawIntBits), pw0Var, 1, true);
                    yl1 yl1Var = pw0Var.a;
                    int i2 = yl1Var.b - 1;
                    while (true) {
                        if (-1 >= i2) {
                            i = Integer.MIN_VALUE;
                            break;
                        }
                        Object objF = yl1Var.f(i2);
                        objF.getClass();
                        n71 n71VarG = cm4.g((dk1) objF);
                        if (r7Var.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(n71VarG) != null) {
                            dk0.t();
                            return false;
                        }
                        if (n71VarG.o0.d(8)) {
                            int iS = x7Var.s(n71VarG.b);
                            gg2 gg2VarB = c34.b(n71VarG, false);
                            if (o44.f(gg2VarB)) {
                                if (!gg2VarB.k().a.c(kg2.z)) {
                                    i = iS;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                        i2--;
                    }
                    r7Var.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(motionEvent);
                    int i3 = x7Var.f;
                    if (i3 != i) {
                        x7Var.f = i;
                        x7.w(x7Var, i, 128, null, 12);
                        x7.w(x7Var, i3, 256, null, 12);
                    }
                } else if (action == 10) {
                    int i4 = x7Var.f;
                    if (i4 == Integer.MIN_VALUE) {
                        r7Var.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(motionEvent);
                    } else if (i4 != Integer.MIN_VALUE) {
                        x7Var.f = Integer.MIN_VALUE;
                        x7.w(x7Var, Integer.MIN_VALUE, 128, null, 12);
                        x7.w(x7Var, i4, 256, null, 12);
                    }
                }
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 7) {
                if (actionMasked == 10 && m(motionEvent)) {
                    if (motionEvent.getToolType(0) != 3 || motionEvent.getButtonState() == 0) {
                        MotionEvent motionEvent2 = this.c1;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.c1 = MotionEvent.obtainNoHistory(motionEvent);
                        this.k1 = true;
                        postDelayed(b7Var, 8L);
                        return false;
                    }
                } else if ((h(motionEvent) & 1) != 0) {
                    return true;
                }
            } else if (n(motionEvent)) {
                if ((h(motionEvent) & 1) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        if (!isFocused()) {
            return ((do0) getFocusOwner()).d(keyEvent, new h7(i, this, keyEvent));
        }
        int metaState = keyEvent.getMetaState();
        this.H.getClass();
        ma3.a.setValue(new sy1(metaState));
        return ((do0) getFocusOwner()).d(keyEvent, k30.j) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        zn1 zn1Var;
        if (isFocused()) {
            do0 do0Var = (do0) getFocusOwner();
            if (do0Var.d.e) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            } else {
                ko0 ko0VarA = xn4.a(do0Var.c);
                if (ko0VarA != null) {
                    if (!ko0VarA.a.w) {
                        z01.b("visitAncestors called on an unattached node");
                    }
                    dk1 dk1Var = ko0VarA.a;
                    n71 n71VarG = cm4.g(ko0VarA);
                    while (n71VarG != null) {
                        if ((n71VarG.o0.f.e & Normalizer.INPUT_IS_FCD) != 0) {
                            while (dk1Var != null) {
                                if ((dk1Var.c & Normalizer.INPUT_IS_FCD) != 0) {
                                    dk1 dk1VarB = dk1Var;
                                    pm1 pm1Var = null;
                                    while (dk1VarB != null) {
                                        if ((dk1VarB.c & Normalizer.INPUT_IS_FCD) != 0 && (dk1VarB instanceof zb0)) {
                                            int i = 0;
                                            for (dk1 dk1Var2 = ((zb0) dk1VarB).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                                                if ((dk1Var2.c & Normalizer.INPUT_IS_FCD) != 0) {
                                                    i++;
                                                    if (i == 1) {
                                                        dk1VarB = dk1Var2;
                                                    } else {
                                                        if (pm1Var == null) {
                                                            pm1Var = new pm1(new dk1[16]);
                                                        }
                                                        if (dk1VarB != null) {
                                                            pm1Var.b(dk1VarB);
                                                            dk1VarB = null;
                                                        }
                                                        pm1Var.b(dk1Var2);
                                                    }
                                                }
                                            }
                                            if (i == 1) {
                                            }
                                        }
                                        dk1VarB = cm4.b(pm1Var);
                                    }
                                }
                                dk1Var = dk1Var.f;
                            }
                        }
                        n71VarG = n71VarG.u();
                        dk1Var = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
                    }
                }
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideStructure(ViewStructure viewStructure) {
        if (Build.VERSION.SDK_INT < 28) {
            y7.a.a(viewStructure, getView());
        } else {
            super.dispatchProvideStructure(viewStructure);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Object ohVar;
        ko0 ko0VarF;
        if (this.k1) {
            b7 b7Var = this.j1;
            removeCallbacks(b7Var);
            MotionEvent motionEvent2 = this.c1;
            motionEvent2.getClass();
            if (motionEvent.getActionMasked() == 0 && motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
                this.k1 = false;
            } else {
                b7Var.run();
            }
        }
        if (!l(motionEvent) && isAttachedToWindow() && (motionEvent.getActionMasked() != 2 || n(motionEvent))) {
            int iH = h(motionEvent);
            if ((iH & 2) != 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            boolean z = motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5;
            boolean z2 = motionEvent.isFromSource(8194) || motionEvent.isFromSource(1048584);
            if (z && z2) {
                Object parent = getParent();
                View view = parent instanceof View ? (View) parent : null;
                if (view == null || (ohVar = view.getTag(R.id.auto_clear_focus_behavior_tag)) == null) {
                    ohVar = new oh(1);
                }
                if (ohVar.equals(new oh(1)) && (ko0VarF = ((do0) getFocusOwner()).f()) != null) {
                    co1 co1VarF = cm4.f(ko0VarF);
                    if (!pp4.c(co1VarF).N(co1VarF, true).a((((long) Float.floatToRawIntBits(motionEvent.getX())) << 32) | (((long) Float.floatToRawIntBits(motionEvent.getY())) & 4294967295L))) {
                        ((do0) getFocusOwner()).b(false, true, 8);
                    }
                }
            }
            if ((iH & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    public final View findViewByAccessibilityIdTraversal(int i) throws IllegalAccessException, InvocationTargetException {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return f(this, i);
            }
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(i));
            if (objInvoke instanceof View) {
                return (View) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i) {
        l42 l42VarA;
        if (view == null || this.F0.c) {
            return super.focusSearch(view, i);
        }
        View rootView = getRootView();
        rootView.getClass();
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) rootView, view, i);
        if (viewFindNextFocus != null && !viewFindNextFocus.equals(this)) {
            ViewParent parent = viewFindNextFocus.getParent();
            while (true) {
                if (parent == null) {
                    viewFindNextFocus = null;
                    break;
                }
                if (parent == this) {
                    break;
                }
                parent = parent.getParent();
            }
        } else {
            viewFindNextFocus = null;
            break;
        }
        if (view == this) {
            ko0 ko0VarA = xn4.a(((do0) getFocusOwner()).c);
            l42VarA = ko0VarA != null ? xn4.b(ko0VarA) : null;
            if (l42VarA == null) {
                l42VarA = un0.a(view, this);
            }
        } else {
            l42VarA = un0.a(view, this);
        }
        qn0 qn0VarB = un0.b(i);
        int i2 = qn0VarB != null ? qn0VarB.a : 6;
        t42 t42Var = new t42();
        if (((do0) getFocusOwner()).e(i2, l42VarA, new i7(0, t42Var)) == null) {
            return view;
        }
        Object obj = t42Var.a;
        if (obj == null) {
            if (viewFindNextFocus == null) {
                return super.focusSearch(view, i);
            }
        } else if (viewFindNextFocus == null || i2 == 1 || i2 == 2 || nd4.h(xn4.b((ko0) obj), un0.a(viewFindNextFocus, this), l42VarA, i2)) {
            return this;
        }
        return viewFindNextFocus;
    }

    public final void g(n71 n71Var, boolean z) {
        this.F0.f(n71Var, z);
    }

    public final xc getAndroidViewsHandler$ui() {
        if (this.C0 == null) {
            xc xcVar = new xc(getContext());
            this.C0 = xcVar;
            addView(xcVar, -1);
            requestLayout();
        }
        xc xcVar2 = this.C0;
        xcVar2.getClass();
        return xcVar2;
    }

    public qj getAutofill() {
        return this.v0;
    }

    public vj getAutofillManager() {
        return this.w0;
    }

    public wj getAutofillTree() {
        return this.o0;
    }

    public final Configuration getConfiguration() {
        return (Configuration) this.u0.getValue();
    }

    public final q8 getContentCaptureManager$ui() {
        return this.l0;
    }

    public j70 getCoroutineContext() {
        return this.w;
    }

    public jc0 getDensity() {
        return (jc0) this.s.getValue();
    }

    public l42 getEmbeddedViewFocusRect() {
        if (isFocused()) {
            ko0 ko0VarA = xn4.a(((do0) getFocusOwner()).c);
            if (ko0VarA != null) {
                return xn4.b(ko0VarA);
            }
            return null;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return un0.a(viewFindFocus, this);
        }
        return null;
    }

    public ao0 getFocusOwner() {
        return this.v;
    }

    @Override // android.view.View
    public final void getFocusedRect(Rect rect) {
        l42 embeddedViewFocusRect = getEmbeddedViewFocusRect();
        if (embeddedViewFocusRect != null) {
            rect.left = Math.round(embeddedViewFocusRect.a);
            rect.top = Math.round(embeddedViewFocusRect.b);
            rect.right = Math.round(embeddedViewFocusRect.c);
            rect.bottom = Math.round(embeddedViewFocusRect.d);
            return;
        }
        if (g31.a(((do0) getFocusOwner()).e(6, null, j7.c), Boolean.TRUE)) {
            super.getFocusedRect(rect);
        } else {
            rect.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
    }

    public qo0 getFontFamilyResolver() {
        return (qo0) this.W0.getValue();
    }

    public po0 getFontLoader() {
        return this.V0;
    }

    public final rb1 getFrameEndScheduler$ui() {
        return this.f;
    }

    public uu0 getGraphicsContext() {
        return this.n0;
    }

    public bw0 getHapticFeedBack() {
        return this.Y0;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.F0.b.w() || !this.k.isEmpty();
    }

    @Override // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    public o11 getInputModeManager() {
        return this.Z0;
    }

    public final s11 getInsetsListener() {
        return this.e0;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui() {
        return this.L0;
    }

    @Override // android.view.View, android.view.ViewParent
    public z61 getLayoutDirection() {
        return (z61) this.X0.getValue();
    }

    public long getMeasureIteration() {
        lh1 lh1Var = this.F0;
        if (!lh1Var.c) {
            z01.a("measureIteration should be only used during the measure/layout pass");
        }
        return lh1Var.g;
    }

    public fk1 getModifierLocalManager() {
        return this.a1;
    }

    public r7 getOutOfFrameExecutor() {
        if (isAttachedToWindow()) {
            return this;
        }
        return null;
    }

    public yw1 getPlacementScope() {
        int i = ax1.b;
        return new nf1(1, this);
    }

    public my1 getPointerIconService() {
        return this.r1;
    }

    /* JADX INFO: renamed from: getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui, reason: not valid java name */
    public final d01 m30getPrimaryDirectionalMotionAxisOverridedqNNBbU$ui() {
        return this.c;
    }

    public n42 getRectManager() {
        return this.h0;
    }

    public o72 getRetainedValuesStore() {
        return this.j;
    }

    public n71 getRoot() {
        return this.f0;
    }

    public o82 getRootForTest() {
        return this.i0;
    }

    public final boolean getScrollCaptureInProgress$ui() {
        py0 py0Var;
        if (Build.VERSION.SDK_INT < 31 || (py0Var = this.p1) == null) {
            return false;
        }
        return ((Boolean) ((ku1) py0Var.b).getValue()).booleanValue();
    }

    public jg2 getSemanticsOwner() {
        return this.j0;
    }

    public p71 getSharedDrawScope() {
        return this.e;
    }

    public boolean getShowLayoutBounds() {
        return Build.VERSION.SDK_INT >= 30 ? ke.a.a(this) : this.B0;
    }

    public lt1 getSnapshotObserver() {
        return this.A0;
    }

    public zm2 getSoftwareKeyboardController() {
        return this.U0;
    }

    public xy2 getTextInputService() {
        return this.S0;
    }

    public zz2 getTextToolbar() {
        return this.b1;
    }

    public final n82 getUncaughtExceptionHandler$ui() {
        return null;
    }

    public w73 getViewConfiguration() {
        return this.d0;
    }

    public final f7 getViewTreeOwners() {
        return (f7) this.P0.getValue();
    }

    public la3 getWindowInfo() {
        return this.H;
    }

    public final s6 get_autofillManager$ui() {
        return this.w0;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    public final int h(MotionEvent motionEvent) {
        int actionMasked;
        MotionEvent motionEvent2;
        r7 r7Var;
        removeCallbacks(this.i1);
        try {
            y(motionEvent);
            this.M0 = true;
            q(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked2 = motionEvent.getActionMasked();
                MotionEvent motionEvent3 = this.c1;
                boolean z = motionEvent3 != null && motionEvent3.getToolType(0) == 3;
                ux uxVar = this.t0;
                if (motionEvent3 != null) {
                    try {
                        if (!((motionEvent3.getSource() == motionEvent.getSource() && motionEvent3.getToolType(0) == motionEvent.getToolType(0)) ? false : true)) {
                            motionEvent2 = motionEvent3;
                        } else if (motionEvent3.getButtonState() != 0 || (actionMasked = motionEvent3.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6) {
                            motionEvent2 = motionEvent3;
                            if (!uxVar.a) {
                                ((if1) ((wj1) uxVar.d).b).a();
                                ((mw0) uxVar.c).c();
                            }
                        } else if (motionEvent3.getActionMasked() == 10 || !z) {
                            motionEvent2 = motionEvent3;
                        } else {
                            D(motionEvent3, 10, motionEvent3.getEventTime(), true);
                            motionEvent2 = motionEvent3;
                        }
                    } catch (Throwable th) {
                        th = th;
                        Trace.endSection();
                        throw th;
                    }
                } else {
                    motionEvent2 = motionEvent3;
                }
                boolean z2 = motionEvent.getToolType(0) == 3;
                if (z || !z2 || actionMasked2 == 3 || actionMasked2 == 9 || !m(motionEvent)) {
                    r7Var = this;
                } else {
                    r7Var = this;
                    r7Var.D(motionEvent, 9, motionEvent.getEventTime(), true);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                MotionEvent motionEvent4 = r7Var.c1;
                if (motionEvent4 != null && motionEvent4.getAction() == 10) {
                    MotionEvent motionEvent5 = r7Var.c1;
                    int pointerId = motionEvent5 != null ? motionEvent5.getPointerId(0) : -1;
                    int action = motionEvent.getAction();
                    qk1 qk1Var = r7Var.s0;
                    if (action == 9 && motionEvent.getHistorySize() == 0) {
                        if (pointerId >= 0) {
                            qk1Var.c.delete(pointerId);
                            qk1Var.b.delete(pointerId);
                        }
                    } else if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                        MotionEvent motionEvent6 = r7Var.c1;
                        float x = motionEvent6 != null ? motionEvent6.getX() : Float.NaN;
                        MotionEvent motionEvent7 = r7Var.c1;
                        boolean z3 = (x == motionEvent.getX() && (motionEvent7 != null ? motionEvent7.getY() : Float.NaN) == motionEvent.getY()) ? false : true;
                        MotionEvent motionEvent8 = r7Var.c1;
                        boolean z4 = (motionEvent8 != null ? motionEvent8.getEventTime() : -1L) != motionEvent.getEventTime();
                        if (z3 || z4) {
                            if (pointerId >= 0) {
                                qk1Var.c.delete(pointerId);
                                qk1Var.b.delete(pointerId);
                            }
                            mw0 mw0Var = (mw0) uxVar.c;
                            if (mw0Var.d) {
                                mw0Var.d = true;
                            } else {
                                mw0Var.g.a.h();
                            }
                        }
                    }
                }
                r7Var.c1 = MotionEvent.obtainNoHistory(motionEvent);
                int iC = C(motionEvent);
                Trace.endSection();
                r7Var.M0 = false;
                return iC;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            this.M0 = false;
            throw th3;
        }
    }

    public final void k(n71 n71Var) {
        this.F0.p(n71Var, false);
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            k((n71) objArr[i2]);
        }
    }

    public final boolean m(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y && y <= ((float) getHeight());
    }

    public final boolean n(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        return (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.c1) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) ? false : true;
    }

    public final void o(float[] fArr) {
        x();
        ih1.e(fArr, this.J0);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.N0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.N0 & 4294967295L));
        float[] fArr2 = this.I0;
        ih1.d(fArr2);
        ih1.f(fArr2, fIntBitsToFloat, fIntBitsToFloat2);
        e8.d(fArr, fArr2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        o72 o72Var;
        qb1 qb1VarF;
        Object obj;
        super.onAttachedToWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            setShowLayoutBounds(lc4.a());
        }
        this.e0.onViewAttachedToWindow(this);
        int i2 = 0;
        if (i > 28) {
            if (w1 == null) {
                c7 c7Var = new c7(i2);
                w1 = c7Var;
                StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
                try {
                    if (s1 == null) {
                        s1 = Class.forName("android.os.SystemProperties");
                    }
                    if (u1 == null) {
                        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
                        Class cls = s1;
                        u1 = cls != null ? cls.getDeclaredMethod("addChangeCallback", Runnable.class) : null;
                    }
                    Method method = u1;
                    if (method != null) {
                        method.invoke(null, c7Var);
                    }
                } catch (Throwable unused) {
                }
                StrictMode.setVmPolicy(vmPolicy);
            }
            yl1 yl1Var = v1;
            synchronized (yl1Var) {
                yl1Var.a(this);
            }
        }
        this.H.a.setValue(Boolean.valueOf(hasWindowFocus()));
        this.H.getClass();
        this.H.getClass();
        k(getRoot());
        i(getRoot());
        getSnapshotObserver().a.d();
        p6 p6Var = this.v0;
        if (p6Var != null) {
            sj sjVar = sj.a;
            sjVar.getClass();
            ((AutofillManager) p6Var.c).registerCallback(sjVar);
        }
        ob1 ob1VarA = af4.a(this);
        na2 na2VarC = cf4.c(this);
        h83 h83VarB = ef4.b(this);
        rb1 rb1Var = this.f;
        if (ob1VarA == null || h83VarB == null || rb1Var == null) {
            o72Var = null;
        } else {
            g83 g83VarC = h83VarB.c();
            f83 f83Var = new f83();
            a80 a80Var = a80.b;
            g83VarC.getClass();
            a80Var.getClass();
            tb1 tb1Var = (tb1) new uf1(g83VarC, f83Var, a80Var).o(u42.a(tb1.class));
            Object parent = getParent();
            parent.getClass();
            int id = ((View) parent).getId();
            ml1 ml1Var = tb1Var.b;
            Object objB = ml1Var.b(id);
            if (objB == null) {
                objB = new yl1(1);
                ml1Var.h(id, objB);
            }
            yl1 yl1Var2 = (yl1) objB;
            Object[] objArr = yl1Var2.a;
            int i3 = yl1Var2.b;
            while (true) {
                if (i2 >= i3) {
                    obj = null;
                    break;
                }
                obj = objArr[i2];
                if (!((sb1) obj).c) {
                    break;
                } else {
                    i2++;
                }
            }
            sb1 sb1Var = (sb1) obj;
            if (sb1Var == null) {
                sb1Var = new sb1();
                yl1Var2.a(sb1Var);
            }
            sb1Var.c = true;
            this.i = sb1Var;
            o72Var = sb1Var.b;
        }
        if (o72Var == null) {
            o72Var = el1.e;
        }
        this.j = o72Var;
        f7 viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || (ob1VarA != null && na2VarC != null && (ob1VarA != viewTreeOwners.a || na2VarC != viewTreeOwners.b || h83VarB != viewTreeOwners.c))) {
            if (ob1VarA == null) {
                og.n("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
                return;
            }
            if (na2VarC == null) {
                og.n("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
                return;
            }
            if (viewTreeOwners != null && (qb1VarF = viewTreeOwners.a.f()) != null) {
                qb1VarF.f(this);
            }
            ob1VarA.f().a(this);
            f7 f7Var = new f7(ob1VarA, na2VarC, h83VarB);
            set_viewTreeOwners(f7Var);
            hq0 hq0Var = this.Q0;
            if (hq0Var != null) {
                hq0Var.j(f7Var);
            }
            this.Q0 = null;
        }
        this.Z0.a.setValue(new n11(isInTouchMode() ? 1 : 2));
        f7 viewTreeOwners2 = getViewTreeOwners();
        qb1 qb1VarF2 = viewTreeOwners2 != null ? viewTreeOwners2.a.f() : null;
        if (qb1VarF2 == null) {
            throw cq.e("No lifecycle owner exists");
        }
        qb1VarF2.a(this);
        qb1VarF2.a(this.l0);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        getViewTreeObserver().addOnScrollChangedListener(this);
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (Build.VERSION.SDK_INT >= 31) {
            b8.a.b(this);
        }
        s6 s6Var = this.w0;
        if (s6Var != null) {
            ((do0) getFocusOwner()).g.a(s6Var);
            getSemanticsOwner().d.a(s6Var);
        }
        ((do0) getFocusOwner()).g.a(this);
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        ph2 ph2Var = (ph2) this.T0.get();
        ua uaVar = (ua) (ph2Var != null ? ph2Var.b : null);
        if (uaVar == null) {
            return this.R0.d;
        }
        ph2 ph2Var2 = (ph2) uaVar.e.get();
        m11 m11Var = (m11) (ph2Var2 != null ? ph2Var2.b : null);
        return m11Var != null && (m11Var.e ^ true);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        F(configuration);
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i;
        ph2 ph2Var = (ph2) this.T0.get();
        ua uaVar = (ua) (ph2Var != null ? ph2Var.b : null);
        if (uaVar != null) {
            ph2 ph2Var2 = (ph2) uaVar.e.get();
            m11 m11Var = (m11) (ph2Var2 != null ? ph2Var2.b : null);
            if (m11Var == null) {
                return null;
            }
            synchronized (m11Var.c) {
                if (m11Var.e) {
                    return null;
                }
                i42 i42VarA = m11Var.a.a(editorInfo);
                h6 h6Var = new h6(16, m11Var);
                InputConnection uo1Var = Build.VERSION.SDK_INT >= 34 ? new uo1(i42VarA, h6Var) : new to1(i42VarA, h6Var);
                m11Var.d.b(new m93(uo1Var));
                return uo1Var;
            }
        }
        zy2 zy2Var = this.R0;
        if (!zy2Var.d) {
            return null;
        }
        kz0 kz0Var = zy2Var.h;
        ty2 ty2Var = zy2Var.g;
        int i2 = kz0Var.e;
        boolean z = kz0Var.a;
        if (i2 == 1) {
            i = z ? 6 : 0;
        } else if (i2 == 0) {
            i = 1;
        } else if (i2 == 2) {
            i = 2;
        } else if (i2 == 6) {
            i = 5;
        } else if (i2 == 5) {
            i = 7;
        } else if (i2 == 3) {
            i = 3;
        } else if (i2 == 4) {
            i = 4;
        } else {
            if (i2 != 7) {
                og.n("invalid ImeAction");
                return null;
            }
        }
        editorInfo.imeOptions = i;
        int i3 = kz0Var.d;
        int i4 = 18;
        if (i3 == 1) {
            editorInfo.inputType = 1;
        } else if (i3 == 2) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions = Integer.MIN_VALUE | i;
        } else if (i3 == 3) {
            editorInfo.inputType = 2;
        } else if (i3 == 4) {
            editorInfo.inputType = 3;
        } else if (i3 == 5) {
            editorInfo.inputType = 17;
        } else if (i3 == 6) {
            editorInfo.inputType = 33;
        } else if (i3 == 7) {
            editorInfo.inputType = 129;
        } else if (i3 == 8) {
            editorInfo.inputType = 18;
        } else {
            if (i3 != 9) {
                og.n("Invalid Keyboard Type");
                return null;
            }
            editorInfo.inputType = 8194;
        }
        if (!z) {
            int i5 = editorInfo.inputType;
            if ((i5 & 1) == 1) {
                editorInfo.inputType = i5 | Normalizer.INPUT_IS_FCD;
                if (i2 == 1) {
                    editorInfo.imeOptions |= 1073741824;
                }
            }
        }
        int i6 = editorInfo.inputType;
        if ((i6 & 1) == 1) {
            int i7 = kz0Var.b;
            if (i7 == 1) {
                editorInfo.inputType = i6 | 4096;
            } else if (i7 == 2) {
                editorInfo.inputType = i6 | 8192;
            } else if (i7 == 3) {
                editorInfo.inputType = i6 | 16384;
            }
            if (kz0Var.c) {
                editorInfo.inputType |= 32768;
            }
        }
        long j = ty2Var.b;
        int i8 = oz2.c;
        editorInfo.initialSelStart = (int) (j >> 32);
        editorInfo.initialSelEnd = (int) (j & 4294967295L);
        bn4.a(editorInfo, ty2Var.a.b);
        editorInfo.imeOptions |= 33554432;
        if (oh0.d()) {
            oh0.a().i(editorInfo);
        }
        h42 h42Var = new h42(zy2Var.g, new py0(i4, zy2Var), zy2Var.h.c);
        zy2Var.i.add(new WeakReference(h42Var));
        return h42Var;
    }

    @Override // android.view.View
    public final void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer consumer) {
        gg2 gg2Var;
        q8 q8Var = this.l0;
        q8Var.getClass();
        for (long j : jArr) {
            ig2 ig2Var = (ig2) q8Var.c().b((int) j);
            if (ig2Var != null && (gg2Var = ig2Var.a) != null) {
                a7.o();
                ViewTranslationRequest.Builder builderJ = a7.j(q8Var.a.getAutofillId(), gg2Var.g);
                Object objG = gg2Var.d.a.g(kg2.A);
                if (objG == null) {
                    objG = null;
                }
                List list = (List) objG;
                if (list != null) {
                    builderJ.setValue("android:text", TranslationRequestValue.forText(new be(vc1.a(list, "\n", null, 62))));
                    consumer.accept(builderJ.build());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e0.onViewDetachedFromWindow(this);
        if (this.u) {
            View view = this.t;
            if (view == null) {
                g31.f("frameRateCategoryView");
                throw null;
            }
            removeView(view);
        }
        int i = Build.VERSION.SDK_INT;
        if (i > 28) {
            yl1 yl1Var = v1;
            synchronized (yl1Var) {
                yl1Var.j(this);
            }
        }
        wm2 wm2Var = getSnapshotObserver().a;
        zq zqVar = wm2Var.h;
        if (zqVar != null) {
            zqVar.a();
        }
        wm2Var.a();
        this.H.getClass();
        f7 viewTreeOwners = getViewTreeOwners();
        qb1 qb1VarF = viewTreeOwners != null ? viewTreeOwners.a.f() : null;
        if (qb1VarF == null) {
            throw cq.e("No lifecycle owner exists");
        }
        qb1VarF.f(this.l0);
        qb1VarF.f(this);
        p6 p6Var = this.v0;
        if (p6Var != null) {
            sj sjVar = sj.a;
            sjVar.getClass();
            ((AutofillManager) p6Var.c).unregisterCallback(sjVar);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        getViewTreeObserver().removeOnScrollChangedListener(this);
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        sb1 sb1Var = this.i;
        if (sb1Var != null) {
            sb1Var.c = false;
        }
        this.i = null;
        if (i >= 31) {
            b8.a.a(this);
        }
        s6 s6Var = this.w0;
        if (s6Var != null) {
            getSemanticsOwner().d.j(s6Var);
            ((do0) getFocusOwner()).g.j(s6Var);
        }
        n42 rectManager = getRectManager();
        m4 m4Var = rectManager.g;
        if (m4Var != null) {
            n4.a.removeCallbacks(m4Var);
            rectManager.g = null;
        }
        ((do0) getFocusOwner()).g.j(this);
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z || hasFocus()) {
            return;
        }
        do0 do0Var = (do0) getFocusOwner();
        wn4.a(do0Var.c, true);
        if (do0Var.f() != null) {
            ko0 ko0VarF = do0Var.f();
            do0Var.i(null);
            if (ko0VarF != null) {
                ko0VarF.J0(jo0.a, jo0.c);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.L0 = 0L;
        G();
        int i = Build.VERSION.SDK_INT;
        if (32 > i || i >= 34) {
            return;
        }
        F(getResources().getConfiguration());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.L0 = 0L;
        this.F0.j(this.m1);
        this.D0 = null;
        G();
        if (this.C0 != null) {
            getAndroidViewsHandler$ui().layout(0, 0, i3 - i, i4 - i2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        lh1 lh1Var = this.F0;
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                k(getRoot());
            }
            long jE = e(i);
            long jE2 = e(i2);
            long jA = wk4.a((int) (jE >>> 32), (int) (jE & 4294967295L), (int) (jE2 >>> 32), (int) (4294967295L & jE2));
            q40 q40Var = this.D0;
            if (q40Var == null) {
                this.D0 = new q40(jA);
                this.E0 = false;
            } else if (!q40.b(q40Var.a, jA)) {
                this.E0 = true;
            }
            lh1Var.q(jA);
            lh1Var.l();
            setMeasuredDimension(getRoot().p0.p.a, getRoot().p0.p.b);
            if (this.C0 != null) {
                getAndroidViewsHandler$ui().measure(View.MeasureSpec.makeMeasureSpec(getRoot().p0.p.a, 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().p0.p.b, 1073741824));
            }
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a0  */
    @Override // android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        if (viewStructure != null) {
            s6 s6Var = this.w0;
            if (s6Var != null) {
                n71 n71Var = s6Var.b.a;
                AutofillId autofillId = s6Var.j;
                String str = s6Var.f;
                n42 n42Var = s6Var.e;
                h51.c(viewStructure, n71Var, autofillId, str, n42Var);
                Object[] objArr = yo1.a;
                yl1 yl1Var = new yl1(2);
                yl1Var.a(n71Var);
                yl1Var.a(viewStructure);
                while (yl1Var.i()) {
                    Object objK = yl1Var.k(yl1Var.b - 1);
                    objK.getClass();
                    ViewStructure viewStructure2 = (ViewStructure) objK;
                    Object objK2 = yl1Var.k(yl1Var.b - 1);
                    objK2.getClass();
                    wl1 wl1Var = (wl1) ((n71) objK2).n();
                    int i2 = ((pm1) wl1Var.b).c;
                    for (int i3 = 0; i3 < i2; i3++) {
                        n71 n71Var2 = (n71) wl1Var.get(i3);
                        if (!n71Var2.x0 && n71Var2.H() && n71Var2.I()) {
                            cg2 cg2VarW = n71Var2.w();
                            if (cg2VarW != null) {
                                gm1 gm1Var = cg2VarW.a;
                                if (gm1Var.b(bg2.g) || gm1Var.b(bg2.h) || gm1Var.b(kg2.q) || gm1Var.b(kg2.r)) {
                                    ViewStructure viewStructureNewChild = viewStructure2.newChild(viewStructure2.addChildCount(1));
                                    h51.c(viewStructureNewChild, n71Var2, autofillId, str, n42Var);
                                    yl1Var.a(n71Var2);
                                    yl1Var.a(viewStructureNewChild);
                                } else {
                                    yl1Var.a(n71Var2);
                                    yl1Var.a(viewStructure2);
                                }
                            } else {
                                yl1Var.a(n71Var2);
                                yl1Var.a(viewStructure2);
                            }
                        }
                    }
                }
            }
            p6 p6Var = this.v0;
            if (p6Var != null) {
                wj wjVar = (wj) p6Var.b;
                LinkedHashMap linkedHashMap = wjVar.a;
                LinkedHashMap linkedHashMap2 = wjVar.a;
                if (linkedHashMap.isEmpty()) {
                    return;
                }
                int iAddChildCount = viewStructure.addChildCount(linkedHashMap2.size());
                Iterator it = linkedHashMap2.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    int iIntValue = ((Number) entry.getKey()).intValue();
                    if (entry.getValue() != null) {
                        dk0.t();
                        return;
                    }
                    ViewStructure viewStructureNewChild2 = viewStructure.newChild(iAddChildCount);
                    viewStructureNewChild2.setAutofillId((AutofillId) p6Var.e, iIntValue);
                    viewStructureNewChild2.setId(iIntValue, ((r7) p6Var.a).getContext().getPackageName(), null, null);
                    viewStructureNewChild2.setAutofillType(1);
                    throw null;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        ly1 ly1Var;
        int toolType = motionEvent.getToolType(i);
        if (motionEvent.isFromSource(8194) || !motionEvent.isFromSource(UProperty.CASE_FOLDING) || (!(toolType == 2 || toolType == 4) || (ly1Var = ((l7) getPointerIconService()).a) == null)) {
            return super.onResolvePointerIcon(motionEvent, i);
        }
        Context context = getContext();
        return ly1Var instanceof va ? PointerIcon.getSystemIcon(context, ((va) ly1Var).b) : PointerIcon.getSystemIcon(context, 1000);
    }

    @Override // defpackage.ta0
    public final void onResume(ob1 ob1Var) {
        zv zvVarS;
        if (Build.VERSION.SDK_INT < 30) {
            setShowLayoutBounds(lc4.a());
        }
        sb1 sb1Var = this.i;
        if (sb1Var != null) {
            rb1 rb1Var = this.f;
            rb1Var.getClass();
            py0 py0Var = sb1Var.a;
            mg1 mg1Var = (mg1) py0Var.b;
            if (!mg1Var.a || mg1Var.c) {
                return;
            }
            try {
                zvVarS = ((qc3) rb1Var).a.s(new ta(10, sb1Var));
            } catch (CancellationException unused) {
                mg1 mg1Var2 = (mg1) py0Var.b;
                if (!mg1Var2.b) {
                    if (mg1Var2.c) {
                        ez1.a("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                    }
                    mg1Var2.a();
                    mg1Var2.c = true;
                }
                zvVarS = null;
            }
            zv zvVar = sb1Var.d;
            if (zvVar != null) {
                zvVar.cancel();
            }
            sb1Var.d = zvVarS;
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        z61 z61Var;
        if (this.b) {
            int[] iArr = un0.a;
            z61 z61Var2 = z61.a;
            if (i != 0) {
                z61Var = i != 1 ? null : z61.b;
            } else {
                z61Var = z61Var2;
            }
            if (z61Var != null) {
                z61Var2 = z61Var;
            }
            setLayoutDirection(z61Var2);
        }
    }

    @Override // android.view.View
    public final void onScrollCaptureSearch(Rect rect, Point point, Consumer consumer) {
        py0 py0Var;
        if (Build.VERSION.SDK_INT < 31 || (py0Var = this.p1) == null) {
            return;
        }
        jg2 semanticsOwner = getSemanticsOwner();
        j70 coroutineContext = getCoroutineContext();
        pm1 pm1Var = new pm1(new fd2[16]);
        i24.a(semanticsOwner.a(), 0, new fg1(1, pm1Var, pm1.class, "add", "add(Ljava/lang/Object;)Z", 8, 1));
        Arrays.sort(pm1Var.a, 0, pm1Var.c, new w00(0, new hq0[]{kt1.v, kt1.w}));
        int i = pm1Var.c;
        fd2 fd2Var = (fd2) (i == 0 ? null : pm1Var.a[i - 1]);
        if (fd2Var == null) {
            return;
        }
        i21 i21Var = fd2Var.c;
        j20 j20Var = new j20(fd2Var.a, i21Var, tl4.a(coroutineContext), py0Var, this);
        co1 co1Var = fd2Var.d;
        l42 l42VarN = pp4.c(co1Var).N(co1Var, true);
        long j = (((long) i21Var.a) << 32) | (((long) i21Var.b) & 4294967295L);
        ScrollCaptureTarget scrollCaptureTargetE = a7.e(this, py3.a(bp4.a(l42VarN)), new Point((int) (j >> 32), (int) (j & 4294967295L)), j20Var);
        scrollCaptureTargetE.setScrollBounds(py3.a(i21Var));
        consumer.accept(scrollCaptureTargetE);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        G();
    }

    @Override // defpackage.ta0
    public final void onStop(ob1 ob1Var) {
        sb1 sb1Var = this.i;
        if (sb1Var != null) {
            mg1 mg1Var = (mg1) sb1Var.a.b;
            if (mg1Var.a && !mg1Var.c) {
                zv zvVar = sb1Var.d;
                if (zvVar != null) {
                    zvVar.cancel();
                }
                sb1Var.d = null;
                return;
            }
            if (mg1Var.b) {
                return;
            }
            if (!mg1Var.c) {
                ez1.a("ManagedValuesStore tried to leave composition twice. Is the store installed in multiple places?");
            }
            if (!mg1Var.e.i()) {
                ez1.a("Attempted to start retaining exited values with pending exited values");
            }
            mg1Var.c = false;
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public final void onTouchModeChanged(boolean z) {
        this.Z0.a.setValue(new n11(z ? 1 : 2));
    }

    @Override // android.view.View
    public final void onVirtualViewTranslationResponses(LongSparseArray longSparseArray) {
        q8 q8Var = this.l0;
        q8Var.getClass();
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        if (g31.a(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            tc4.b(q8Var, longSparseArray);
        } else {
            q8Var.a.post(new o8(0, q8Var, longSparseArray));
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        boolean zA;
        this.H.a.setValue(Boolean.valueOf(z));
        this.o1 = true;
        super.onWindowFocusChanged(z);
        if (!z || Build.VERSION.SDK_INT >= 30 || getShowLayoutBounds() == (zA = lc4.a())) {
            return;
        }
        setShowLayoutBounds(zA);
        i(getRoot());
    }

    public final long p(long j) {
        x();
        long jB = ih1.b(j, this.J0);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.N0 >> 32)) + Float.intBitsToFloat((int) (jB >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.N0 & 4294967295L)) + Float.intBitsToFloat((int) (jB & 4294967295L));
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
    }

    public final void q(boolean z) {
        n7 n7Var;
        lh1 lh1Var = this.F0;
        if (lh1Var.b.w() || ((pm1) lh1Var.e.b).c != 0) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z) {
                try {
                    n7Var = this.m1;
                } finally {
                    Trace.endSection();
                }
            } else {
                n7Var = null;
            }
            if (lh1Var.j(n7Var)) {
                requestLayout();
            }
            lh1Var.a(false);
        }
    }

    public final void r(n71 n71Var, long j) {
        lh1 lh1Var = this.F0;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            lh1Var.k(n71Var, j);
            if (!lh1Var.b.w()) {
                lh1Var.a(false);
            }
            getRectManager().a();
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        int i2 = 1;
        if (!isFocused()) {
            qn0 qn0VarB = un0.b(i);
            int i3 = qn0VarB != null ? qn0VarB.a : 7;
            Boolean boolE = ((do0) getFocusOwner()).e(i3, rect != null ? new l42(rect.left, rect.top, rect.right, rect.bottom) : null, new m7(i3, 0));
            Boolean bool = Boolean.TRUE;
            if (!g31.a(boolE, bool)) {
                if (!g31.a(((do0) getFocusOwner()).e(i3, null, new m7(i3, i2)), bool)) {
                    if (hasFocus() && (i3 == 1 || i3 == 2)) {
                        return ((do0) getFocusOwner()).h(i3);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public final void s() {
        yl1 yl1Var;
        Object[] objArr;
        if (this.x0) {
            wm2 wm2Var = getSnapshotObserver().a;
            synchronized (wm2Var.g) {
                try {
                    pm1 pm1Var = wm2Var.f;
                    int i = pm1Var.c;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        objArr = pm1Var.a;
                        if (i2 >= i) {
                            break;
                        }
                        vm2 vm2Var = (vm2) objArr[i2];
                        vm2Var.c();
                        if (!vm2Var.f.j()) {
                            i3++;
                        } else if (i3 > 0) {
                            Object[] objArr2 = pm1Var.a;
                            objArr2[i2 - i3] = objArr2[i2];
                        }
                        i2++;
                    }
                    int i4 = i - i3;
                    Arrays.fill(objArr, i4, i, (Object) null);
                    pm1Var.c = i4;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.x0 = false;
        }
        xc xcVar = this.C0;
        if (xcVar != null) {
            d(xcVar);
        }
        s6 s6Var = this.w0;
        if (s6Var != null) {
            nl1 nl1Var = s6Var.k;
            if (nl1Var.d == 0 && s6Var.n) {
                ((AutofillManager) s6Var.a.b).commit();
                s6Var.n = false;
            }
            if (nl1Var.d != 0) {
                s6Var.n = true;
            }
        }
        while (this.f1.i() && this.f1.f(0) != null) {
            int i5 = this.f1.b;
            int i6 = 0;
            while (true) {
                yl1Var = this.f1;
                if (i6 < i5) {
                    fq0 fq0Var = (fq0) yl1Var.f(i6);
                    yl1 yl1Var2 = this.f1;
                    if (i6 < 0 || i6 >= yl1Var2.b) {
                        yl1Var2.n(i6);
                        throw null;
                    }
                    Object[] objArr3 = yl1Var2.a;
                    Object obj = objArr3[i6];
                    objArr3[i6] = null;
                    if (fq0Var != null) {
                        fq0Var.a();
                    }
                    i6++;
                }
            }
            yl1Var.l(0, i5);
        }
    }

    public void setAccessibilityEventBatchIntervalMillis(long j) {
        this.k0.k = j;
    }

    public final void setConfiguration(Configuration configuration) {
        this.u0.setValue(configuration);
    }

    public final void setContentCaptureManager$ui(q8 q8Var) {
        this.l0 = q8Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [dk1] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v5 */
    public void setCoroutineContext(j70 j70Var) {
        this.w = j70Var;
        dk1 dk1Var = getRoot().o0.f;
        if (dk1Var instanceof tu2) {
            ((tu2) dk1Var).K0();
        }
        if (!dk1Var.a.w) {
            z01.b("visitSubtreeIf called on an unattached node");
        }
        pm1 pm1Var = new pm1(new dk1[16]);
        dk1 dk1Var2 = dk1Var.a;
        dk1 dk1Var3 = dk1Var2.i;
        if (dk1Var3 == null) {
            cm4.a(pm1Var, dk1Var2);
        } else {
            pm1Var.b(dk1Var3);
        }
        while (true) {
            int i = pm1Var.c;
            if (i == 0) {
                return;
            }
            dk1 dk1Var4 = (dk1) pm1Var.l(i - 1);
            if ((dk1Var4.e & 16) != 0) {
                for (dk1 dk1Var5 = dk1Var4; dk1Var5 != null && dk1Var5.w; dk1Var5 = dk1Var5.i) {
                    if ((dk1Var5.c & 16) != 0) {
                        ?? B = dk1Var5;
                        ?? pm1Var2 = 0;
                        while (B != 0) {
                            if (B instanceof qy1) {
                                qy1 qy1Var = (qy1) B;
                                if (qy1Var instanceof tu2) {
                                    ((tu2) qy1Var).K0();
                                }
                            } else if ((B.c & 16) != 0 && (B instanceof zb0)) {
                                dk1 dk1Var6 = ((zb0) B).H;
                                int i2 = 0;
                                B = B;
                                pm1Var2 = pm1Var2;
                                while (dk1Var6 != null) {
                                    if ((dk1Var6.c & 16) != 0) {
                                        i2++;
                                        pm1Var2 = pm1Var2;
                                        if (i2 == 1) {
                                            B = dk1Var6;
                                        } else {
                                            if (pm1Var2 == 0) {
                                                pm1Var2 = new pm1(new dk1[16]);
                                            }
                                            if (B != 0) {
                                                pm1Var2.b(B);
                                                B = 0;
                                            }
                                            pm1Var2.b(dk1Var6);
                                        }
                                    }
                                    dk1Var6 = dk1Var6.i;
                                    B = B;
                                    pm1Var2 = pm1Var2;
                                }
                                if (i2 == 1) {
                                }
                            }
                            B = cm4.b(pm1Var2);
                        }
                    }
                }
            }
            cm4.a(pm1Var, dk1Var4);
        }
    }

    public final void setFrameEndScheduler$ui(rb1 rb1Var) {
        this.f = rb1Var;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui(long j) {
        this.L0 = j;
    }

    public final void setOnViewTreeOwnersAvailable(hq0 hq0Var) {
        f7 viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            hq0Var.j(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.Q0 = hq0Var;
    }

    /* JADX INFO: renamed from: setPrimaryDirectionalMotionAxisOverride-r2epLt8$ui, reason: not valid java name */
    public final void m31setPrimaryDirectionalMotionAxisOverrider2epLt8$ui(d01 d01Var) {
        this.c = d01Var;
    }

    public void setShowLayoutBounds(boolean z) {
        this.B0 = z;
    }

    public void setUncaughtExceptionHandler(n82 n82Var) {
        this.F0.getClass();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t(n71 n71Var) {
        x7 x7Var = this.k0;
        x7Var.h0 = true;
        if (x7Var.n()) {
            x7Var.o(n71Var);
        }
        q8 q8Var = this.l0;
        q8Var.j = true;
        if (q8Var.d()) {
            q8Var.k.s(q43.a);
        }
    }

    public final void u(n71 n71Var, boolean z, boolean z2, boolean z3) {
        n71 n71VarU;
        n71 n71VarU2;
        lh1 lh1Var = this.F0;
        if (!z) {
            if (lh1Var.p(n71Var, z2) && z3) {
                A(n71Var);
                return;
            }
            return;
        }
        kf kfVar = lh1Var.b;
        n71 n71Var2 = n71Var.n;
        r71 r71Var = n71Var.p0;
        if (n71Var2 == null) {
            z01.b("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int iOrdinal = r71Var.d.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2 && iOrdinal != 3) {
                if (iOrdinal != 4) {
                    dk0.l();
                    return;
                }
                if (!r71Var.e || z2) {
                    r71Var.e = true;
                    r71Var.p.c0 = true;
                    if (n71Var.x0) {
                        return;
                    }
                    if ((g31.a(n71Var.J(), Boolean.TRUE) || lh1.h(n71Var)) && ((n71VarU = n71Var.u()) == null || !n71VarU.p0.e)) {
                        kfVar.e(n71Var, q31.a);
                    } else if ((n71Var.I() || lh1.i(n71Var)) && ((n71VarU2 = n71Var.u()) == null || !n71VarU2.q())) {
                        kfVar.e(n71Var, q31.c);
                    }
                    if (lh1Var.d || !z3) {
                        return;
                    }
                    A(n71Var);
                    return;
                }
                return;
            }
        }
        lh1Var.h.b(new kh1(n71Var, true, z2));
    }

    public final void v(n71 n71Var, boolean z, boolean z2) {
        r71 r71Var = n71Var.p0;
        q31 q31Var = q31.e;
        lh1 lh1Var = this.F0;
        if (!z) {
            lh1Var.getClass();
            int iOrdinal = r71Var.d.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                return;
            }
            if (iOrdinal != 4) {
                dk0.l();
                return;
            }
            n71 n71VarU = n71Var.u();
            boolean z3 = n71VarU == null || n71VarU.I();
            if (!z2) {
                if (n71Var.q()) {
                    return;
                }
                if (n71Var.p() && n71Var.I() == z3 && n71Var.I() == r71Var.p.Z) {
                    return;
                }
            }
            nh1 nh1Var = r71Var.p;
            nh1Var.d0 = true;
            nh1Var.e0 = true;
            if (!n71Var.x0 && nh1Var.Z && z3) {
                if ((n71VarU == null || !n71VarU.p()) && (n71VarU == null || !n71VarU.q())) {
                    lh1Var.b.e(n71Var, q31Var);
                }
                if (lh1Var.d) {
                    return;
                }
                A(null);
                return;
            }
            return;
        }
        kf kfVar = lh1Var.b;
        int iOrdinal2 = r71Var.d.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                return;
            }
            if (iOrdinal2 != 2) {
                if (iOrdinal2 == 3) {
                    return;
                }
                if (iOrdinal2 != 4) {
                    dk0.l();
                    return;
                }
            }
        }
        if ((r71Var.e || r71Var.f) && !z2) {
            return;
        }
        r71Var.f = true;
        r71Var.g = true;
        nh1 nh1Var2 = r71Var.p;
        nh1Var2.d0 = true;
        nh1Var2.e0 = true;
        if (n71Var.x0) {
            return;
        }
        n71 n71VarU2 = n71Var.u();
        if (g31.a(n71Var.J(), Boolean.TRUE) && ((n71VarU2 == null || !n71VarU2.p0.e) && (n71VarU2 == null || !n71VarU2.p0.f))) {
            kfVar.e(n71Var, q31.b);
        } else if (n71Var.I() && ((n71VarU2 == null || !n71VarU2.p()) && (n71VarU2 == null || !n71VarU2.q()))) {
            kfVar.e(n71Var, q31Var);
        }
        if (lh1Var.d) {
            return;
        }
        A(null);
    }

    public final void w() {
        x7 x7Var = this.k0;
        x7Var.h0 = true;
        if (x7Var.n() && !x7Var.s0) {
            x7Var.s0 = true;
            x7Var.s.post(x7Var.u0);
        }
        q8 q8Var = this.l0;
        q8Var.j = true;
        if (!q8Var.d() || q8Var.w) {
            return;
        }
        q8Var.w = true;
        q8Var.n.post(q8Var.x);
    }

    public final void x() {
        if (this.M0) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.L0) {
            this.L0 = jCurrentAnimationTimeMillis;
            yo yoVar = this.n1;
            float[] fArr = this.J0;
            yoVar.a(this, fArr);
            gp4.a(fArr, this.K0);
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            int[] iArr = this.H0;
            view.getLocationOnScreen(iArr);
            float f = iArr[0];
            float f2 = iArr[1];
            view.getLocationInWindow(iArr);
            this.N0 = (((long) Float.floatToRawIntBits(f - iArr[0])) << 32) | (((long) Float.floatToRawIntBits(f2 - iArr[1])) & 4294967295L);
        }
    }

    public final void y(MotionEvent motionEvent) {
        this.L0 = AnimationUtils.currentAnimationTimeMillis();
        yo yoVar = this.n1;
        float[] fArr = this.J0;
        yoVar.a(this, fArr);
        gp4.a(fArr, this.K0);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        long jB = ih1.b((((long) Float.floatToRawIntBits(x)) << 32) | (((long) Float.floatToRawIntBits(y)) & 4294967295L), fArr);
        float rawX = motionEvent.getRawX() - Float.intBitsToFloat((int) (jB >> 32));
        float rawY = motionEvent.getRawY() - Float.intBitsToFloat((int) (jB & 4294967295L));
        this.N0 = (((long) Float.floatToRawIntBits(rawX)) << 32) | (((long) Float.floatToRawIntBits(rawY)) & 4294967295L);
    }

    public final boolean z() {
        if (isFocused()) {
            return true;
        }
        return super.requestFocus(130, null);
    }

    public o6 getAccessibilityManager() {
        return this.m0;
    }

    public y6 getClipboard() {
        return this.z0;
    }

    public z6 getClipboardManager() {
        return this.y0;
    }

    /* JADX INFO: renamed from: getDragAndDropManager, reason: merged with bridge method [inline-methods] */
    public c9 m35getDragAndDropManager() {
        return this.x;
    }

    public ml1 getLayoutNodes() {
        return this.g0;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        addView(view, -1);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = i;
        layoutParamsGenerateDefaultLayoutParams.height = i2;
        addViewInLayout(view, -1, layoutParamsGenerateDefaultLayoutParams, true);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, i, layoutParams, true);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, -1, layoutParams, true);
    }

    @oc0
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui$annotations() {
    }

    /* JADX INFO: renamed from: getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui$annotations, reason: not valid java name */
    public static /* synthetic */ void m29getPrimaryDirectionalMotionAxisOverridedqNNBbU$ui$annotations() {
    }

    public static /* synthetic */ void getRoot$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @oc0
    public static /* synthetic */ void getTextInputService$annotations() {
    }

    public View getView() {
        return this;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    public final void setUncaughtExceptionHandler$ui(n82 n82Var) {
    }
}
