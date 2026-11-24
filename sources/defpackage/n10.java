package defpackage;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.project.sonic.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class n10 extends Activity implements h83, cw0, na2, ob1 {
    public boolean H;
    public boolean X;
    public final cv2 Y;
    public final cv2 Z;
    public final qb1 a;
    public final o50 b;
    public final py0 c;
    public final q91 e;
    public g83 f;
    public final l10 i;
    public final cv2 j;
    public final AtomicInteger k;
    public final m10 n;
    public final CopyOnWriteArrayList s;
    public final CopyOnWriteArrayList t;
    public final CopyOnWriteArrayList u;
    public final CopyOnWriteArrayList v;
    public final CopyOnWriteArrayList w;
    public final CopyOnWriteArrayList x;

    public n10() {
        qb1 qb1Var = new qb1(this, true);
        this.a = qb1Var;
        this.b = new o50();
        this.c = new py0(new e10(this, 0));
        ma2 ma2Var = new ma2(this, new kb(17, this));
        q91 q91Var = new q91(ma2Var);
        this.e = q91Var;
        this.i = new l10(this);
        this.j = new cv2(new f10(this, 1));
        this.k = new AtomicInteger();
        this.n = new m10(this);
        this.s = new CopyOnWriteArrayList();
        this.t = new CopyOnWriteArrayList();
        this.u = new CopyOnWriteArrayList();
        this.v = new CopyOnWriteArrayList();
        this.w = new CopyOnWriteArrayList();
        this.x = new CopyOnWriteArrayList();
        qb1Var.a(new h10(0, this));
        int i = 1;
        qb1Var.a(new h10(i, this));
        qb1Var.a(new k42(i, this));
        ma2Var.a();
        c44.c(this);
        ((q91) q91Var.c).F("android:support:activity-result", new i10(0, this));
        e(new dq1() { // from class: j10
            @Override // defpackage.dq1
            public final void a(n10 n10Var) {
                n10Var.getClass();
                n10 n10Var2 = this.a;
                Bundle bundleX = ((q91) n10Var2.e.c).x("android:support:activity-result");
                if (bundleX != null) {
                    m10 m10Var = n10Var2.n;
                    LinkedHashMap linkedHashMap = m10Var.b;
                    LinkedHashMap linkedHashMap2 = m10Var.a;
                    Bundle bundle = m10Var.g;
                    ArrayList<Integer> integerArrayList = bundleX.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleX.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    ArrayList<String> stringArrayList2 = bundleX.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    if (stringArrayList2 != null) {
                        m10Var.d.addAll(stringArrayList2);
                    }
                    Bundle bundle2 = bundleX.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    if (bundle2 != null) {
                        bundle.putAll(bundle2);
                    }
                    int size = stringArrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = stringArrayList.get(i2);
                        if (linkedHashMap.containsKey(str)) {
                            Integer num = (Integer) linkedHashMap.remove(str);
                            if (!bundle.containsKey(str)) {
                                h33.b(linkedHashMap2).remove(num);
                            }
                        }
                        Integer num2 = integerArrayList.get(i2);
                        num2.getClass();
                        int iIntValue = num2.intValue();
                        String str2 = stringArrayList.get(i2);
                        str2.getClass();
                        String str3 = str2;
                        linkedHashMap2.put(Integer.valueOf(iIntValue), str3);
                        m10Var.b.put(str3, Integer.valueOf(iIntValue));
                    }
                }
            }
        });
        this.Y = new cv2(new f10(this, 2));
        this.Z = new cv2(new f10(this, 3));
    }

    public static void d(n10 n10Var) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            if (!g31.a(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        } catch (NullPointerException e2) {
            if (!g31.a(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e2;
            }
        }
    }

    @Override // defpackage.cw0
    public final b80 a() {
        jl1 jl1Var = new jl1(a80.b);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = jl1Var.a;
        if (application != null) {
            linkedHashMap.put(d83.d, getApplication());
        }
        linkedHashMap.put(c44.a, this);
        linkedHashMap.put(c44.b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(c44.c, extras);
        }
        return jl1Var;
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        h();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        this.i.a(decorView);
        super.addContentView(view, layoutParams);
    }

    @Override // defpackage.na2
    public final q91 b() {
        return (q91) this.e.c;
    }

    @Override // defpackage.h83
    public final g83 c() {
        if (getApplication() == null) {
            og.n("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
            return null;
        }
        if (this.f == null) {
            k10 k10Var = (k10) getLastNonConfigurationInstance();
            if (k10Var != null) {
                this.f = k10Var.a;
            }
            if (this.f == null) {
                this.f = new g83();
            }
        }
        g83 g83Var = this.f;
        g83Var.getClass();
        return g83Var;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        if (lp4.a(decorView, keyEvent)) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return super.dispatchKeyEvent(keyEvent);
        }
        onUserInteraction();
        Window window = getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                if (!lp4.a) {
                    try {
                        lp4.b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                    } catch (NoSuchMethodException unused) {
                    }
                    lp4.a = true;
                }
                Method method = lp4.b;
                boolean zBooleanValue = false;
                if (method != null) {
                    try {
                        Object objInvoke = method.invoke(actionBar, keyEvent);
                        if (objInvoke != null) {
                            zBooleanValue = ((Boolean) objInvoke).booleanValue();
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
                if (zBooleanValue) {
                    return true;
                }
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView2 = window.getDecorView();
        int i = u73.a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList = t73.d;
            t73 t73Var = (t73) decorView2.getTag(R.id.tag_unhandled_key_event_manager);
            if (t73Var == null) {
                t73Var = new t73();
                t73Var.a = null;
                t73Var.b = null;
                t73Var.c = null;
                decorView2.setTag(R.id.tag_unhandled_key_event_manager, t73Var);
            }
            if (keyEvent.getAction() == 0) {
                WeakHashMap weakHashMap = t73Var.a;
                if (weakHashMap != null) {
                    weakHashMap.clear();
                }
                ArrayList arrayList2 = t73.d;
                if (!arrayList2.isEmpty()) {
                    synchronized (arrayList2) {
                        try {
                            if (t73Var.a == null) {
                                t73Var.a = new WeakHashMap();
                            }
                            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                                ArrayList arrayList3 = t73.d;
                                View view = (View) ((WeakReference) arrayList3.get(size)).get();
                                if (view == null) {
                                    arrayList3.remove(size);
                                } else {
                                    t73Var.a.put(view, Boolean.TRUE);
                                    for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        t73Var.a.put((View) parent, Boolean.TRUE);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
            View viewA = t73Var.a(decorView2);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                    if (t73Var.b == null) {
                        t73Var.b = new SparseArray();
                    }
                    t73Var.b.put(keyCode, new WeakReference(viewA));
                }
            }
            if (viewA != null) {
                return true;
            }
        }
        return keyEvent.dispatch(this, decorView2 != null ? decorView2.getKeyDispatcherState() : null, this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        if (lp4.a(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public final void e(dq1 dq1Var) {
        o50 o50Var = this.b;
        o50Var.getClass();
        n10 n10Var = o50Var.b;
        if (n10Var != null) {
            dq1Var.a(n10Var);
        }
        o50Var.a.add(dq1Var);
    }

    @Override // defpackage.ob1
    public final qb1 f() {
        return this.a;
    }

    public final bq1 g() {
        return (bq1) this.Z.getValue();
    }

    public final void h() {
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        decorView2.getClass();
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        decorView3.getClass();
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        decorView4.getClass();
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        decorView5.getClass();
        decorView5.setTag(R.id.report_drawn, this);
    }

    public final void i(Bundle bundle) {
        super.onCreate(bundle);
        int i = g62.b;
        e62.b(this);
    }

    public final void j(Bundle bundle) {
        bundle.getClass();
        qb1 qb1Var = this.a;
        qb1Var.c("setCurrentState");
        qb1Var.e(eb1.c);
        super.onSaveInstanceState(bundle);
    }

    public final kf k(final su0 su0Var, final ag1 ag1Var) {
        Number number;
        final m10 m10Var = this.n;
        m10Var.getClass();
        final String str = "activity_rq#" + this.k.getAndIncrement();
        LinkedHashMap linkedHashMap = m10Var.c;
        qb1 qb1Var = this.a;
        if (qb1Var.d.compareTo(eb1.e) >= 0) {
            StringBuilder sb = new StringBuilder("LifecycleOwner ");
            sb.append(this);
            eb1 eb1Var = qb1Var.d;
            sb.append(" is attempting to register while current state is ");
            sb.append(eb1Var);
            sb.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb.toString().toString());
        }
        LinkedHashMap linkedHashMap2 = m10Var.a;
        LinkedHashMap linkedHashMap3 = m10Var.b;
        if (((Integer) linkedHashMap3.get(str)) == null) {
            e4 e4Var = new e4(0);
            Iterator it = new p40(new au0(0, e4Var, new x0(28, e4Var))).iterator();
            do {
                if (!it.hasNext()) {
                    kf2.g("Sequence contains no element matching the predicate.");
                    return null;
                }
                number = (Number) it.next();
            } while (linkedHashMap2.containsKey(Integer.valueOf(number.intValue())));
            int iIntValue = number.intValue();
            linkedHashMap2.put(Integer.valueOf(iIntValue), str);
            linkedHashMap3.put(str, Integer.valueOf(iIntValue));
        }
        g4 g4Var = (g4) linkedHashMap.get(str);
        if (g4Var == null) {
            g4Var = new g4(qb1Var);
        }
        lb1 lb1Var = new lb1() { // from class: d4
            @Override // defpackage.lb1
            public final void j(ob1 ob1Var, db1 db1Var) {
                Integer num;
                db1 db1Var2 = db1.ON_START;
                m10 m10Var2 = m10Var;
                String str2 = str;
                if (db1Var2 == db1Var) {
                    LinkedHashMap linkedHashMap4 = m10Var2.e;
                    Bundle bundle = m10Var2.g;
                    LinkedHashMap linkedHashMap5 = m10Var2.f;
                    su0 su0Var2 = su0Var;
                    ag1 ag1Var2 = ag1Var;
                    linkedHashMap4.put(str2, new f4(su0Var2, ag1Var2));
                    if (linkedHashMap5.containsKey(str2)) {
                        Object obj = linkedHashMap5.get(str2);
                        linkedHashMap5.remove(str2);
                        ag1Var2.a(obj);
                    }
                    b4 b4Var = (b4) wf4.a(str2, bundle);
                    if (b4Var != null) {
                        bundle.remove(str2);
                        ag1Var2.a(su0Var2.o(b4Var.b, b4Var.a));
                        return;
                    }
                    return;
                }
                if (db1.ON_STOP == db1Var) {
                    m10Var2.e.remove(str2);
                    return;
                }
                if (db1.ON_DESTROY == db1Var) {
                    LinkedHashMap linkedHashMap6 = m10Var2.c;
                    Bundle bundle2 = m10Var2.g;
                    LinkedHashMap linkedHashMap7 = m10Var2.f;
                    if (!m10Var2.d.contains(str2) && (num = (Integer) m10Var2.b.remove(str2)) != null) {
                        m10Var2.a.remove(num);
                    }
                    m10Var2.e.remove(str2);
                    if (linkedHashMap7.containsKey(str2)) {
                        Log.w("ActivityResultRegistry", "Dropping pending result for request " + str2 + ": " + linkedHashMap7.get(str2));
                        linkedHashMap7.remove(str2);
                    }
                    if (bundle2.containsKey(str2)) {
                        Log.w("ActivityResultRegistry", "Dropping pending result for request " + str2 + ": " + ((b4) wf4.a(str2, bundle2)));
                        bundle2.remove(str2);
                    }
                    g4 g4Var2 = (g4) linkedHashMap6.get(str2);
                    if (g4Var2 != null) {
                        ArrayList arrayList = g4Var2.b;
                        int size = arrayList.size();
                        int i = 0;
                        while (i < size) {
                            Object obj2 = arrayList.get(i);
                            i++;
                            g4Var2.a.f((lb1) obj2);
                        }
                        arrayList.clear();
                        linkedHashMap6.remove(str2);
                    }
                }
            }
        };
        g4Var.a.a(lb1Var);
        g4Var.b.add(lb1Var);
        linkedHashMap.put(str, g4Var);
        return new kf(m10Var, str, su0Var, 2);
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        if (this.n.a(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        g().b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        configuration.getClass();
        super.onConfigurationChanged(configuration);
        Iterator it = this.s.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((s40) it.next()).accept(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.e.D(bundle);
        o50 o50Var = this.b;
        o50Var.getClass();
        o50Var.b = this;
        Iterator it = o50Var.a.iterator();
        while (it.hasNext()) {
            ((dq1) it.next()).a(this);
        }
        i(bundle);
        int i = g62.b;
        e62.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        menu.getClass();
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.c.b).iterator();
        if (!it.hasNext()) {
            return true;
        }
        ((aq0) it.next()).getClass();
        throw null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        menuItem.getClass();
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) this.c.b).iterator();
        if (!it.hasNext()) {
            return false;
        }
        ((aq0) it.next()).getClass();
        throw null;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        configuration.getClass();
        this.H = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.H = false;
            Iterator it = this.v.iterator();
            it.getClass();
            while (it.hasNext()) {
                ((s40) it.next()).accept(new il1(z));
            }
        } catch (Throwable th) {
            this.H = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        Iterator it = this.u.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((s40) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        menu.getClass();
        Iterator it = ((CopyOnWriteArrayList) this.c.b).iterator();
        if (it.hasNext()) {
            ((aq0) it.next()).getClass();
            throw null;
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        configuration.getClass();
        this.X = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.X = false;
            Iterator it = this.w.iterator();
            it.getClass();
            while (it.hasNext()) {
                ((s40) it.next()).accept(new ww1(z));
            }
        } catch (Throwable th) {
            this.X = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        menu.getClass();
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.c.b).iterator();
        if (!it.hasNext()) {
            return true;
        }
        ((aq0) it.next()).getClass();
        throw null;
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        strArr.getClass();
        iArr.getClass();
        if (this.n.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        k10 k10Var;
        g83 g83Var = this.f;
        if (g83Var == null && (k10Var = (k10) getLastNonConfigurationInstance()) != null) {
            g83Var = k10Var.a;
        }
        if (g83Var == null) {
            return null;
        }
        k10 k10Var2 = new k10();
        k10Var2.a = g83Var;
        return k10Var2;
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        qb1 qb1Var = this.a;
        if (qb1Var != null) {
            qb1Var.c("setCurrentState");
            qb1Var.e(eb1.c);
        }
        j(bundle);
        this.e.E(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.t.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((s40) it.next()).accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.x.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (hd4.a()) {
                Trace.beginSection(hd4.e("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            eq0 eq0Var = (eq0) this.j.getValue();
            synchronized (eq0Var.a) {
                try {
                    eq0Var.b = true;
                    ArrayList arrayList = eq0Var.c;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((fq0) obj).a();
                    }
                    eq0Var.c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            Trace.endSection();
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        h();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        this.i.a(decorView);
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i) {
        intent.getClass();
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        intentSender.getClass();
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        intent.getClass();
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        intentSender.getClass();
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        h();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        this.i.a(decorView);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        h();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        this.i.a(decorView);
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        if (this.H) {
            return;
        }
        Iterator it = this.v.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((s40) it.next()).accept(new il1(z));
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        if (this.X) {
            return;
        }
        Iterator it = this.w.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((s40) it.next()).accept(new ww1(z));
        }
    }
}
