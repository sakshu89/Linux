package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ve extends AutoCompleteTextView {
    public static final int[] e = {R.attr.popupBackground};
    public final we a;
    public final ef b;
    public final q82 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ve(Context context, AttributeSet attributeSet, int i) {
        xe xeVar;
        xe xeVar2;
        boolean z;
        boolean z2;
        String string;
        String string2;
        boolean z3;
        int resourceId;
        ColorStateList colorStateListB;
        int i2;
        int resourceId2;
        ColorStateList colorStateList;
        int resourceId3;
        ColorStateList colorStateListG;
        int resourceId4;
        super(context, attributeSet, i);
        int[] iArr = n22.b;
        Object obj = z03.a;
        if (!(context.getResources() instanceof a13)) {
            context.getResources();
            int i3 = m63.a;
        }
        Context context2 = getContext();
        ThreadLocal threadLocal = h03.a;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(n22.c);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
            typedArrayObtainStyledAttributes.recycle();
            Context context3 = getContext();
            boolean z4 = false;
            TypedArray typedArrayObtainStyledAttributes2 = context3.obtainStyledAttributes(attributeSet, e, i, 0);
            if (typedArrayObtainStyledAttributes2.hasValue(0)) {
                setDropDownBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId4 = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : s62.c().d(context3, resourceId4));
            }
            typedArrayObtainStyledAttributes2.recycle();
            we weVar = new we();
            weVar.a = -1;
            weVar.b = this;
            PorterDuff.Mode mode = xe.b;
            synchronized (xe.class) {
                try {
                    if (xe.c == null) {
                        xe.b();
                    }
                    xeVar = xe.c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            weVar.c = xeVar;
            this.a = weVar;
            Context context4 = getContext();
            int[] iArr2 = n22.g;
            TypedArray typedArrayObtainStyledAttributes3 = context4.obtainStyledAttributes(attributeSet, iArr2, i, 0);
            u73.b(this, getContext(), iArr2, attributeSet, typedArrayObtainStyledAttributes3, i);
            try {
                if (typedArrayObtainStyledAttributes3.hasValue(0)) {
                    weVar.a = typedArrayObtainStyledAttributes3.getResourceId(0, -1);
                    xe xeVar3 = (xe) weVar.c;
                    Context context5 = getContext();
                    int i4 = weVar.a;
                    synchronized (xeVar3) {
                        colorStateListG = xeVar3.a.g(context5, i4);
                    }
                    if (colorStateListG != null) {
                        weVar.c(colorStateListG);
                    }
                }
                if (typedArrayObtainStyledAttributes3.hasValue(1)) {
                    if (!typedArrayObtainStyledAttributes3.hasValue(1) || (resourceId3 = typedArrayObtainStyledAttributes3.getResourceId(1, 0)) == 0 || (colorStateList = oe4.b(context4, resourceId3)) == null) {
                        colorStateList = typedArrayObtainStyledAttributes3.getColorStateList(1);
                    }
                    o73.d(this, colorStateList);
                }
                if (typedArrayObtainStyledAttributes3.hasValue(2)) {
                    o73.e(this, wf0.a(typedArrayObtainStyledAttributes3.getInt(2, -1)));
                }
                typedArrayObtainStyledAttributes3.recycle();
                ef efVar = new ef(this);
                this.b = efVar;
                int[] iArr3 = n22.f;
                jf jfVar = efVar.i;
                Context context6 = getContext();
                synchronized (xe.class) {
                    try {
                        if (xe.c == null) {
                            xe.b();
                        }
                        xeVar2 = xe.c;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                int[] iArr4 = n22.a;
                TypedArray typedArrayObtainStyledAttributes4 = context6.obtainStyledAttributes(attributeSet, iArr4, i, 0);
                u73.b(this, getContext(), iArr4, attributeSet, typedArrayObtainStyledAttributes4, i);
                int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(0, -1);
                if (typedArrayObtainStyledAttributes4.hasValue(3)) {
                    efVar.b = ef.c(context6, xeVar2, typedArrayObtainStyledAttributes4.getResourceId(3, 0));
                }
                if (typedArrayObtainStyledAttributes4.hasValue(1)) {
                    efVar.c = ef.c(context6, xeVar2, typedArrayObtainStyledAttributes4.getResourceId(1, 0));
                }
                if (typedArrayObtainStyledAttributes4.hasValue(4)) {
                    efVar.d = ef.c(context6, xeVar2, typedArrayObtainStyledAttributes4.getResourceId(4, 0));
                }
                if (typedArrayObtainStyledAttributes4.hasValue(2)) {
                    efVar.e = ef.c(context6, xeVar2, typedArrayObtainStyledAttributes4.getResourceId(2, 0));
                }
                if (typedArrayObtainStyledAttributes4.hasValue(5)) {
                    efVar.f = ef.c(context6, xeVar2, typedArrayObtainStyledAttributes4.getResourceId(5, 0));
                }
                if (typedArrayObtainStyledAttributes4.hasValue(6)) {
                    efVar.g = ef.c(context6, xeVar2, typedArrayObtainStyledAttributes4.getResourceId(6, 0));
                }
                typedArrayObtainStyledAttributes4.recycle();
                boolean z5 = getTransformationMethod() instanceof PasswordTransformationMethod;
                if (resourceId5 != -1) {
                    TypedArray typedArrayObtainStyledAttributes5 = context6.obtainStyledAttributes(resourceId5, iArr3);
                    b13 b13Var = new b13(context6, typedArrayObtainStyledAttributes5);
                    if (z5 || !typedArrayObtainStyledAttributes5.hasValue(14)) {
                        z = false;
                        z2 = false;
                    } else {
                        z2 = typedArrayObtainStyledAttributes5.getBoolean(14, false);
                        z = true;
                    }
                    efVar.d(context6, b13Var);
                    string2 = typedArrayObtainStyledAttributes5.hasValue(15) ? typedArrayObtainStyledAttributes5.getString(15) : null;
                    string = typedArrayObtainStyledAttributes5.hasValue(13) ? typedArrayObtainStyledAttributes5.getString(13) : null;
                    b13Var.h();
                } else {
                    z = false;
                    z2 = false;
                    string = null;
                    string2 = null;
                }
                TypedArray typedArrayObtainStyledAttributes6 = context6.obtainStyledAttributes(attributeSet, iArr3, i, 0);
                b13 b13Var2 = new b13(context6, typedArrayObtainStyledAttributes6);
                if (!z5 && typedArrayObtainStyledAttributes6.hasValue(14)) {
                    z2 = typedArrayObtainStyledAttributes6.getBoolean(14, false);
                    z = true;
                }
                boolean z6 = z2;
                string2 = typedArrayObtainStyledAttributes6.hasValue(15) ? typedArrayObtainStyledAttributes6.getString(15) : string2;
                string = typedArrayObtainStyledAttributes6.hasValue(13) ? typedArrayObtainStyledAttributes6.getString(13) : string;
                if (Build.VERSION.SDK_INT >= 28 && typedArrayObtainStyledAttributes6.hasValue(0) && typedArrayObtainStyledAttributes6.getDimensionPixelSize(0, -1) == 0) {
                    setTextSize(0, 0.0f);
                }
                efVar.d(context6, b13Var2);
                b13Var2.h();
                if (!z5 && z) {
                    setAllCaps(z6);
                }
                Typeface typeface = efVar.l;
                if (typeface != null) {
                    if (efVar.k == -1) {
                        setTypeface(typeface, efVar.j);
                    } else {
                        setTypeface(typeface);
                    }
                }
                if (string != null) {
                    cf.d(this, string);
                }
                if (string2 != null) {
                    bf.b(this, bf.a(string2));
                }
                Context context7 = jfVar.h;
                TypedArray typedArrayObtainStyledAttributes7 = context7.obtainStyledAttributes(attributeSet, iArr, i, 0);
                ve veVar = jfVar.g;
                u73.b(veVar, veVar.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes7, i);
                if (typedArrayObtainStyledAttributes7.hasValue(5)) {
                    jfVar.a = typedArrayObtainStyledAttributes7.getInt(5, 0);
                }
                float dimension = typedArrayObtainStyledAttributes7.hasValue(4) ? typedArrayObtainStyledAttributes7.getDimension(4, -1.0f) : -1.0f;
                float dimension2 = typedArrayObtainStyledAttributes7.hasValue(2) ? typedArrayObtainStyledAttributes7.getDimension(2, -1.0f) : -1.0f;
                float dimension3 = typedArrayObtainStyledAttributes7.hasValue(1) ? typedArrayObtainStyledAttributes7.getDimension(1, -1.0f) : -1.0f;
                if (!typedArrayObtainStyledAttributes7.hasValue(3) || (resourceId2 = typedArrayObtainStyledAttributes7.getResourceId(3, 0)) <= 0) {
                    z3 = false;
                } else {
                    TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes7.getResources().obtainTypedArray(resourceId2);
                    int length = typedArrayObtainTypedArray.length();
                    int[] iArr5 = new int[length];
                    if (length > 0) {
                        int i5 = 0;
                        while (i5 < length) {
                            iArr5[i5] = typedArrayObtainTypedArray.getDimensionPixelSize(i5, -1);
                            i5++;
                            z4 = z4;
                        }
                        z3 = z4;
                        int[] iArrA = jf.a(iArr5);
                        jfVar.e = iArrA;
                        int length2 = iArrA.length;
                        boolean z7 = length2 > 0 ? true : z3 ? 1 : 0;
                        jfVar.f = z7;
                        if (z7) {
                            jfVar.a = 1;
                            jfVar.c = iArrA[z3 ? 1 : 0];
                            jfVar.d = iArrA[length2 - 1];
                            jfVar.b = -1.0f;
                        }
                    } else {
                        z3 = false;
                    }
                    typedArrayObtainTypedArray.recycle();
                }
                typedArrayObtainStyledAttributes7.recycle();
                if (jfVar.a == 1) {
                    if (!jfVar.f) {
                        DisplayMetrics displayMetrics = context7.getResources().getDisplayMetrics();
                        if (dimension2 == -1.0f) {
                            i2 = 2;
                            dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                        } else {
                            i2 = 2;
                        }
                        float f = dimension2;
                        float fApplyDimension = dimension3 == -1.0f ? TypedValue.applyDimension(i2, 112.0f, displayMetrics) : dimension3;
                        dimension = dimension == -1.0f ? 1.0f : dimension;
                        if (f <= 0.0f) {
                            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
                        }
                        if (fApplyDimension <= f) {
                            throw new IllegalArgumentException("Maximum auto-size text size (" + fApplyDimension + "px) is less or equal to minimum auto-size text size (" + f + "px)");
                        }
                        if (dimension <= 0.0f) {
                            throw new IllegalArgumentException("The auto-size step granularity (" + dimension + "px) is less or equal to (0px)");
                        }
                        jfVar.a = 1;
                        jfVar.c = f;
                        jfVar.d = fApplyDimension;
                        jfVar.b = dimension;
                        jfVar.f = z3;
                    }
                    if (jfVar.a == 1 && (!jfVar.f || jfVar.e.length == 0)) {
                        int iFloor = ((int) Math.floor((jfVar.d - jfVar.c) / jfVar.b)) + 1;
                        int[] iArr6 = new int[iFloor];
                        for (int i6 = 0; i6 < iFloor; i6++) {
                            iArr6[i6] = Math.round((i6 * jfVar.b) + jfVar.c);
                        }
                        jfVar.e = jf.a(iArr6);
                    }
                }
                if (j83.a && jfVar.a != 0) {
                    int[] iArr7 = jfVar.e;
                    if (iArr7.length > 0) {
                        if (cf.a(this) != -1.0f) {
                            cf.b(this, Math.round(jfVar.c), Math.round(jfVar.d), Math.round(jfVar.b), 0);
                        } else {
                            cf.c(this, iArr7, 0);
                        }
                    }
                }
                TypedArray typedArrayObtainStyledAttributes8 = context6.obtainStyledAttributes(attributeSet, iArr);
                int resourceId6 = typedArrayObtainStyledAttributes8.getResourceId(8, -1);
                Drawable drawableA = resourceId6 != -1 ? xeVar2.a(context6, resourceId6) : null;
                int resourceId7 = typedArrayObtainStyledAttributes8.getResourceId(13, -1);
                Drawable drawableA2 = resourceId7 != -1 ? xeVar2.a(context6, resourceId7) : null;
                int resourceId8 = typedArrayObtainStyledAttributes8.getResourceId(9, -1);
                Drawable drawableA3 = resourceId8 != -1 ? xeVar2.a(context6, resourceId8) : null;
                int resourceId9 = typedArrayObtainStyledAttributes8.getResourceId(6, -1);
                Drawable drawableA4 = resourceId9 != -1 ? xeVar2.a(context6, resourceId9) : null;
                int resourceId10 = typedArrayObtainStyledAttributes8.getResourceId(10, -1);
                Drawable drawableA5 = resourceId10 != -1 ? xeVar2.a(context6, resourceId10) : null;
                int resourceId11 = typedArrayObtainStyledAttributes8.getResourceId(7, -1);
                Drawable drawableA6 = resourceId11 != -1 ? xeVar2.a(context6, resourceId11) : null;
                if (drawableA5 != null || drawableA6 != null) {
                    Drawable[] drawableArrA = af.a(this);
                    af.b(this, drawableA5 == null ? drawableArrA[0] : drawableA5, drawableA2 == null ? drawableArrA[1] : drawableA2, drawableA6 == null ? drawableArrA[2] : drawableA6, drawableA4 == null ? drawableArrA[r10] : drawableA4);
                } else if (drawableA != null || drawableA2 != null || drawableA3 != null || drawableA4 != null) {
                    Drawable[] drawableArrA2 = af.a(this);
                    Drawable drawable = drawableArrA2[0];
                    if (drawable == null && drawableArrA2[2] == null) {
                        Drawable[] compoundDrawables = getCompoundDrawables();
                        setCompoundDrawablesWithIntrinsicBounds(drawableA == null ? compoundDrawables[0] : drawableA, drawableA2 == null ? compoundDrawables[1] : drawableA2, drawableA3 == null ? compoundDrawables[2] : drawableA3, drawableA4 == null ? compoundDrawables[3] : drawableA4);
                    } else {
                        af.b(this, drawable, drawableA2 == null ? drawableArrA2[1] : drawableA2, drawableArrA2[2], drawableA4 == null ? drawableArrA2[r10] : drawableA4);
                    }
                }
                if (typedArrayObtainStyledAttributes8.hasValue(11)) {
                    setCompoundDrawableTintList((!typedArrayObtainStyledAttributes8.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes8.getResourceId(11, 0)) == 0 || (colorStateListB = oe4.b(context6, resourceId)) == null) ? typedArrayObtainStyledAttributes8.getColorStateList(11) : colorStateListB);
                }
                int i7 = -1;
                if (typedArrayObtainStyledAttributes8.hasValue(12)) {
                    setCompoundDrawableTintMode(wf0.a(typedArrayObtainStyledAttributes8.getInt(12, -1)));
                }
                int dimensionPixelSize = typedArrayObtainStyledAttributes8.getDimensionPixelSize(15, -1);
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes8.getDimensionPixelSize(18, -1);
                int dimensionPixelSize3 = typedArrayObtainStyledAttributes8.getDimensionPixelSize(19, -1);
                typedArrayObtainStyledAttributes8.recycle();
                if (dimensionPixelSize != -1) {
                    if (dimensionPixelSize < 0) {
                        dk0.v();
                        throw null;
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        p50.n(this, dimensionPixelSize);
                    } else {
                        Paint.FontMetricsInt fontMetricsInt = getPaint().getFontMetricsInt();
                        int i8 = getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
                        if (dimensionPixelSize > Math.abs(i8)) {
                            setPadding(getPaddingLeft(), dimensionPixelSize + i8, getPaddingRight(), getPaddingBottom());
                        }
                    }
                    i7 = -1;
                }
                if (dimensionPixelSize2 != i7) {
                    if (dimensionPixelSize2 < 0) {
                        dk0.v();
                        throw null;
                    }
                    Paint.FontMetricsInt fontMetricsInt2 = getPaint().getFontMetricsInt();
                    int i9 = getIncludeFontPadding() ? fontMetricsInt2.bottom : fontMetricsInt2.descent;
                    if (dimensionPixelSize2 > Math.abs(i9)) {
                        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), dimensionPixelSize2 - i9);
                    }
                    i7 = -1;
                }
                if (dimensionPixelSize3 != i7) {
                    if (dimensionPixelSize3 < 0) {
                        dk0.v();
                        throw null;
                    }
                    int fontMetricsInt3 = getPaint().getFontMetricsInt(null);
                    if (dimensionPixelSize3 != fontMetricsInt3) {
                        setLineSpacing(dimensionPixelSize3 - fontMetricsInt3, 1.0f);
                    }
                }
                this.b.b();
                q82 q82Var = new q82(this, 4);
                this.c = q82Var;
                TypedArray typedArrayObtainStyledAttributes9 = getContext().obtainStyledAttributes(attributeSet, iArr, i, 0);
                try {
                    boolean z8 = typedArrayObtainStyledAttributes9.hasValue(14) ? typedArrayObtainStyledAttributes9.getBoolean(14, true) : true;
                    typedArrayObtainStyledAttributes9.recycle();
                    q82Var.I(z8);
                    KeyListener keyListener = getKeyListener();
                    if (keyListener instanceof NumberKeyListener) {
                        return;
                    }
                    boolean zIsFocusable = super.isFocusable();
                    boolean zIsClickable = super.isClickable();
                    boolean zIsLongClickable = super.isLongClickable();
                    int inputType = super.getInputType();
                    KeyListener keyListenerE = q82Var.E(keyListener);
                    if (keyListenerE == keyListener) {
                        return;
                    }
                    super.setKeyListener(keyListenerE);
                    super.setRawInputType(inputType);
                    super.setFocusable(zIsFocusable);
                    super.setClickable(zIsClickable);
                    super.setLongClickable(zIsLongClickable);
                } catch (Throwable th3) {
                    typedArrayObtainStyledAttributes9.recycle();
                    throw th3;
                }
            } catch (Throwable th4) {
                typedArrayObtainStyledAttributes3.recycle();
                throw th4;
            }
        } catch (Throwable th5) {
            typedArrayObtainStyledAttributes.recycle();
            throw th5;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        we weVar = this.a;
        if (weVar != null) {
            weVar.a();
        }
        ef efVar = this.b;
        if (efVar != null) {
            efVar.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        ActionMode.Callback customSelectionActionModeCallback = super.getCustomSelectionActionModeCallback();
        return customSelectionActionModeCallback instanceof d03 ? ((d03) customSelectionActionModeCallback).a : customSelectionActionModeCallback;
    }

    public ColorStateList getSupportBackgroundTintList() {
        z30 z30Var;
        we weVar = this.a;
        if (weVar == null || (z30Var = (z30) weVar.e) == null) {
            return null;
        }
        return (ColorStateList) z30Var.c;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        z30 z30Var;
        we weVar = this.a;
        if (weVar == null || (z30Var = (z30) weVar.e) == null) {
            return null;
        }
        return (PorterDuff.Mode) z30Var.d;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        z30 z30Var = this.b.h;
        if (z30Var != null) {
            return (ColorStateList) z30Var.c;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        z30 z30Var = this.b.h;
        if (z30Var != null) {
            return (PorterDuff.Mode) z30Var.d;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }
        q82 q82Var = (q82) this.c.a;
        if (inputConnectionOnCreateInputConnection == null) {
            q82Var.getClass();
            return null;
        }
        l11 l11Var = (l11) q82Var.a;
        l11Var.getClass();
        return inputConnectionOnCreateInputConnection instanceof uh0 ? inputConnectionOnCreateInputConnection : new uh0((ve) l11Var.b, inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        we weVar = this.a;
        if (weVar != null) {
            weVar.a = -1;
            weVar.c(null);
            weVar.a();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        ColorStateList colorStateListG;
        super.setBackgroundResource(i);
        we weVar = this.a;
        if (weVar != null) {
            weVar.a = i;
            xe xeVar = (xe) weVar.c;
            if (xeVar != null) {
                Context context = ((ve) weVar.b).getContext();
                synchronized (xeVar) {
                    colorStateListG = xeVar.a.g(context, i);
                }
            } else {
                colorStateListG = null;
            }
            weVar.c(colorStateListG);
            weVar.a();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        ef efVar = this.b;
        if (efVar != null) {
            efVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        ef efVar = this.b;
        if (efVar != null) {
            efVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT <= 27 && !(callback instanceof d03) && callback != null) {
            callback = new d03(callback, this);
        }
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(s62.c().d(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.c.I(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.c.E(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        we weVar = this.a;
        if (weVar != null) {
            if (((z30) weVar.e) == null) {
                weVar.e = new z30();
            }
            z30 z30Var = (z30) weVar.e;
            z30Var.c = colorStateList;
            z30Var.b = true;
            weVar.a();
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        we weVar = this.a;
        if (weVar != null) {
            if (((z30) weVar.e) == null) {
                weVar.e = new z30();
            }
            z30 z30Var = (z30) weVar.e;
            z30Var.d = mode;
            z30Var.a = true;
            weVar.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        ef efVar = this.b;
        if (efVar.h == null) {
            efVar.h = new z30();
        }
        z30 z30Var = efVar.h;
        z30Var.c = colorStateList;
        z30Var.b = colorStateList != null;
        efVar.b = z30Var;
        efVar.c = z30Var;
        efVar.d = z30Var;
        efVar.e = z30Var;
        efVar.f = z30Var;
        efVar.g = z30Var;
        efVar.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        ef efVar = this.b;
        if (efVar.h == null) {
            efVar.h = new z30();
        }
        z30 z30Var = efVar.h;
        z30Var.d = mode;
        z30Var.a = mode != null;
        efVar.b = z30Var;
        efVar.c = z30Var;
        efVar.d = z30Var;
        efVar.e = z30Var;
        efVar.f = z30Var;
        efVar.g = z30Var;
        efVar.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        String string;
        super.setTextAppearance(context, i);
        ef efVar = this.b;
        if (efVar != null) {
            ve veVar = efVar.a;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, n22.f);
            b13 b13Var = new b13(context, typedArrayObtainStyledAttributes);
            if (typedArrayObtainStyledAttributes.hasValue(14)) {
                veVar.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
            }
            if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
                veVar.setTextSize(0, 0.0f);
            }
            efVar.d(context, b13Var);
            if (typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
                cf.d(veVar, string);
            }
            b13Var.h();
            Typeface typeface = efVar.l;
            if (typeface != null) {
                veVar.setTypeface(typeface, efVar.j);
            }
        }
    }
}
