package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.project.sonic.R;
import defpackage.b13;
import defpackage.dt2;
import defpackage.f13;
import defpackage.gc1;
import defpackage.i80;
import defpackage.ke2;
import defpackage.le2;
import defpackage.me2;
import defpackage.n22;
import defpackage.ne2;
import defpackage.oe2;
import defpackage.pe2;
import defpackage.qe2;
import defpackage.re2;
import defpackage.s62;
import defpackage.se2;
import defpackage.te2;
import defpackage.u73;
import defpackage.ue2;
import defpackage.ve;
import defpackage.ve2;
import defpackage.yy;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SearchView extends gc1 {
    public static final yy N0;
    public i80 A0;
    public boolean B0;
    public CharSequence C0;
    public boolean D0;
    public boolean E0;
    public int F0;
    public boolean G0;
    public final SearchAutoComplete H;
    public Editable H0;
    public SearchableInfo I0;
    public Bundle J0;
    public final le2 K0;
    public final le2 L0;
    public final WeakHashMap M0;
    public final View c0;
    public final View d0;
    public final View e0;
    public final ImageView f0;
    public final ImageView g0;
    public final ImageView h0;
    public final ImageView i0;
    public final View j0;
    public ve2 k0;
    public final Rect l0;
    public final Rect m0;
    public final int[] n0;
    public final int[] o0;
    public final ImageView p0;
    public final Drawable q0;
    public final int r0;
    public final int s0;
    public final Intent t0;
    public final Intent u0;
    public final CharSequence v0;
    public View.OnFocusChangeListener w0;
    public View.OnClickListener x0;
    public boolean y0;
    public boolean z0;

    static {
        yy yyVar = null;
        if (Build.VERSION.SDK_INT < 29) {
            yy yyVar2 = new yy();
            yyVar2.a = null;
            yyVar2.b = null;
            yyVar2.c = null;
            yy.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                yyVar2.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                yyVar2.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                yyVar2.c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            yyVar = yyVar2;
        }
        N0 = yyVar;
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        super(context, attributeSet, i);
        int i2 = 1;
        this.a = true;
        this.b = -1;
        int i3 = 0;
        this.c = 0;
        this.f = 8388659;
        int[] iArr = n22.d;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        u73.b(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i);
        int i4 = typedArrayObtainStyledAttributes.getInt(1, -1);
        if (i4 >= 0) {
            setOrientation(i4);
        }
        int i5 = typedArrayObtainStyledAttributes.getInt(0, -1);
        if (i5 >= 0) {
            setGravity(i5);
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.j = typedArrayObtainStyledAttributes.getFloat(4, -1.0f);
        this.b = typedArrayObtainStyledAttributes.getInt(3, -1);
        this.k = typedArrayObtainStyledAttributes.getBoolean(7, false);
        setDividerDrawable((!typedArrayObtainStyledAttributes.hasValue(5) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(5, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(5) : s62.c().d(context, resourceId));
        this.w = typedArrayObtainStyledAttributes.getInt(8, 0);
        this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.l0 = new Rect();
        this.m0 = new Rect();
        this.n0 = new int[2];
        this.o0 = new int[2];
        this.K0 = new le2(this, i3);
        this.L0 = new le2(this, i2);
        this.M0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        oe2 oe2Var = new oe2(this);
        pe2 pe2Var = new pe2(this);
        qe2 qe2Var = new qe2(this);
        ke2 ke2Var = new ke2(this);
        int[] iArr2 = n22.e;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        b13 b13Var = new b13(context, typedArrayObtainStyledAttributes2);
        u73.b(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes2.getResourceId(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.H = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.c0 = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.d0 = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.e0 = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f0 = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.g0 = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.h0 = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.i0 = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.p0 = imageView5;
        viewFindViewById.setBackground(b13Var.d(10));
        viewFindViewById2.setBackground(b13Var.d(14));
        imageView.setImageDrawable(b13Var.d(13));
        imageView2.setImageDrawable(b13Var.d(7));
        imageView3.setImageDrawable(b13Var.d(4));
        imageView4.setImageDrawable(b13Var.d(16));
        imageView5.setImageDrawable(b13Var.d(13));
        this.q0 = b13Var.d(12);
        f13.a(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.r0 = typedArrayObtainStyledAttributes2.getResourceId(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.s0 = typedArrayObtainStyledAttributes2.getResourceId(5, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(ke2Var);
        searchAutoComplete.setOnEditorActionListener(oe2Var);
        searchAutoComplete.setOnItemClickListener(pe2Var);
        searchAutoComplete.setOnItemSelectedListener(qe2Var);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new me2(this));
        setIconifiedByDefault(typedArrayObtainStyledAttributes2.getBoolean(8, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.v0 = typedArrayObtainStyledAttributes2.getText(6);
        this.C0 = typedArrayObtainStyledAttributes2.getText(11);
        int i6 = typedArrayObtainStyledAttributes2.getInt(3, -1);
        if (i6 != -1) {
            setImeOptions(i6);
        }
        int i7 = typedArrayObtainStyledAttributes2.getInt(2, -1);
        if (i7 != -1) {
            setInputType(i7);
        }
        setFocusable(typedArrayObtainStyledAttributes2.getBoolean(0, true));
        b13Var.h();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.t0 = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.u0 = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.j0 = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new ne2(this));
        }
        q(this.y0);
        n();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.H;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.E0 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.H;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.E0 = false;
    }

    public final Intent d(Uri uri, String str, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.H0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.J0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.I0.getSearchActivity());
        return intent;
    }

    public final Intent e(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.J0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void f() {
        int i = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.H;
        if (i >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        yy yyVar = N0;
        yyVar.getClass();
        yy.a();
        Method method = yyVar.a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        yyVar.getClass();
        yy.a();
        Method method2 = yyVar.b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void g() {
        SearchAutoComplete searchAutoComplete = this.H;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.y0) {
            clearFocus();
            q(true);
        }
    }

    public int getImeOptions() {
        return this.H.getImeOptions();
    }

    public int getInputType() {
        return this.H.getInputType();
    }

    public int getMaxWidth() {
        return this.F0;
    }

    public CharSequence getQuery() {
        return this.H.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.C0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.I0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.v0 : getContext().getText(this.I0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.s0;
    }

    public int getSuggestionRowLayout() {
        return this.r0;
    }

    public i80 getSuggestionsAdapter() {
        return this.A0;
    }

    public final void h(int i) {
        int position;
        String strG;
        Cursor cursor = this.A0.c;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent intentD = null;
            try {
                int i2 = dt2.x;
                String strG2 = dt2.g(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strG2 == null) {
                    strG2 = this.I0.getSuggestIntentAction();
                }
                if (strG2 == null) {
                    strG2 = "android.intent.action.SEARCH";
                }
                String strG3 = dt2.g(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strG3 == null) {
                    strG3 = this.I0.getSuggestIntentData();
                }
                if (strG3 != null && (strG = dt2.g(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strG3 = strG3 + "/" + Uri.encode(strG);
                }
                intentD = d(strG3 == null ? null : Uri.parse(strG3), strG2, dt2.g(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), dt2.g(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e);
            }
            if (intentD != null) {
                try {
                    getContext().startActivity(intentD);
                } catch (RuntimeException e2) {
                    Log.e("SearchView", "Failed launch activity: " + intentD, e2);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.H;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void i(int i) {
        Editable text = this.H.getText();
        Cursor cursor = this.A0.c;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i)) {
            setQuery(text);
            return;
        }
        String strC = this.A0.c(cursor);
        if (strC != null) {
            setQuery(strC);
        } else {
            setQuery(text);
        }
    }

    public final void j(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void k() {
        SearchAutoComplete searchAutoComplete = this.H;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.I0 != null) {
            getContext().startActivity(d(null, "android.intent.action.SEARCH", null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void l() {
        boolean zIsEmpty = TextUtils.isEmpty(this.H.getText());
        int i = !zIsEmpty || this.y0 ? 0 : 8;
        ImageView imageView = this.h0;
        imageView.setVisibility(i);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void m() {
        int[] iArr = this.H.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.d0.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.e0.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void n() {
        CharSequence queryHint = getQueryHint();
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        boolean z = this.y0;
        SearchAutoComplete searchAutoComplete = this.H;
        CharSequence charSequence2 = charSequence;
        if (z) {
            Drawable drawable = this.q0;
            charSequence2 = charSequence;
            if (drawable != null) {
                int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
                drawable.setBounds(0, 0, textSize, textSize);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
                spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
                spannableStringBuilder.append(charSequence);
                charSequence2 = spannableStringBuilder;
            }
        }
        searchAutoComplete.setHint(charSequence2);
    }

    public final void o() {
        this.e0.setVisibility(((this.B0 || this.G0) && !this.z0 && (this.g0.getVisibility() == 0 || this.i0.getVisibility() == 0)) ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.K0);
        post(this.L0);
        super.onDetachedFromWindow();
    }

    @Override // defpackage.gc1, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.H;
            int[] iArr = this.n0;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.o0;
            getLocationInWindow(iArr2);
            int i5 = iArr[1] - iArr2[1];
            int i6 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i6;
            int height = searchAutoComplete.getHeight() + i5;
            Rect rect = this.l0;
            rect.set(i6, i5, width, height);
            int i7 = rect.left;
            int i8 = rect.right;
            int i9 = i4 - i2;
            Rect rect2 = this.m0;
            rect2.set(i7, 0, i8, i9);
            ve2 ve2Var = this.k0;
            if (ve2Var == null) {
                ve2 ve2Var2 = new ve2(rect2, rect, searchAutoComplete);
                this.k0 = ve2Var2;
                setTouchDelegate(ve2Var2);
            } else {
                ve2Var.b.set(rect2);
                Rect rect3 = ve2Var.d;
                rect3.set(rect2);
                int i10 = -ve2Var.e;
                rect3.inset(i10, i10);
                ve2Var.c.set(rect);
            }
        }
    }

    @Override // defpackage.gc1, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        if (this.z0) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.F0;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.F0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.F0) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ue2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ue2 ue2Var = (ue2) parcelable;
        super.onRestoreInstanceState(ue2Var.a);
        q(ue2Var.c);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ue2 ue2Var = new ue2(super.onSaveInstanceState());
        ue2Var.c = this.z0;
        return ue2Var;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.K0);
    }

    public final void p(boolean z) {
        boolean z2 = this.B0;
        this.g0.setVisibility((!z2 || !(z2 || this.G0) || this.z0 || !hasFocus() || (!z && this.G0)) ? 8 : 0);
    }

    public final void q(boolean z) {
        this.z0 = z;
        int i = 8;
        int i2 = z ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.H.getText());
        this.f0.setVisibility(i2);
        p(!zIsEmpty);
        this.c0.setVisibility(z ? 8 : 0);
        ImageView imageView = this.p0;
        imageView.setVisibility((imageView.getDrawable() == null || this.y0) ? 8 : 0);
        l();
        if (this.G0 && !this.z0 && zIsEmpty) {
            this.g0.setVisibility(8);
            i = 0;
        }
        this.i0.setVisibility(i);
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        if (this.E0 || !isFocusable()) {
            return false;
        }
        if (this.z0) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.H.requestFocus(i, rect);
        if (zRequestFocus) {
            q(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.J0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            g();
            return;
        }
        q(false);
        SearchAutoComplete searchAutoComplete = this.H;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.x0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.y0 == z) {
            return;
        }
        this.y0 = z;
        q(z);
        n();
    }

    public void setImeOptions(int i) {
        this.H.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.H.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.F0 = i;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.w0 = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.x0 = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.C0 = charSequence;
        n();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.D0 = z;
        i80 i80Var = this.A0;
        if (i80Var instanceof dt2) {
            ((dt2) i80Var).p = z ? 2 : 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0098  */
    public void setSearchableInfo(SearchableInfo searchableInfo) {
        boolean z;
        this.I0 = searchableInfo;
        Intent intent = null;
        SearchAutoComplete searchAutoComplete = this.H;
        if (searchableInfo != null) {
            searchAutoComplete.setThreshold(searchableInfo.getSuggestThreshold());
            searchAutoComplete.setImeOptions(this.I0.getImeOptions());
            int inputType = this.I0.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.I0.getSuggestAuthority() != null) {
                    inputType |= 589824;
                }
            }
            searchAutoComplete.setInputType(inputType);
            i80 i80Var = this.A0;
            if (i80Var != null) {
                i80Var.b(null);
            }
            if (this.I0.getSuggestAuthority() != null) {
                dt2 dt2Var = new dt2(getContext(), this, this.I0, this.M0);
                this.A0 = dt2Var;
                searchAutoComplete.setAdapter(dt2Var);
                ((dt2) this.A0).p = this.D0 ? 2 : 1;
            }
            n();
        }
        SearchableInfo searchableInfo2 = this.I0;
        if (searchableInfo2 != null && searchableInfo2.getVoiceSearchEnabled()) {
            if (this.I0.getVoiceSearchLaunchWebSearch()) {
                intent = this.t0;
            } else if (this.I0.getVoiceSearchLaunchRecognizer()) {
                intent = this.u0;
            }
            z = (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
        }
        this.G0 = z;
        if (z) {
            searchAutoComplete.setPrivateImeOptions("nm");
        }
        q(this.z0);
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.B0 = z;
        q(this.z0);
    }

    public void setSuggestionsAdapter(i80 i80Var) {
        this.A0 = i80Var;
        this.H.setAdapter(i80Var);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SearchAutoComplete extends ve {
        public int f;
        public SearchView i;
        public boolean j;
        public final d k;

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.k = new d(this);
            this.f = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            yy yyVar = SearchView.N0;
            yyVar.getClass();
            yy.a();
            Method method = yyVar.c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f <= 0 || super.enoughToFilter();
        }

        @Override // defpackage.ve, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.j) {
                d dVar = this.k;
                removeCallbacks(dVar);
                post(dVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            SearchView searchView = this.i;
            searchView.q(searchView.z0);
            searchView.post(searchView.K0);
            if (searchView.H.hasFocus()) {
                searchView.f();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.i.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.i.hasFocus() && getVisibility() == 0) {
                this.j = true;
                Context context = getContext();
                yy yyVar = SearchView.N0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.k;
            if (!z) {
                this.j = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.j = true;
                    return;
                }
                this.j = false;
                removeCallbacks(dVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.i = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }
    }

    public void setOnCloseListener(re2 re2Var) {
    }

    public void setOnQueryTextListener(se2 se2Var) {
    }

    public void setOnSuggestionListener(te2 te2Var) {
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }
}
