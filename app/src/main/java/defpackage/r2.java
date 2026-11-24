package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.project.sonic.SonicService;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r2 {
    public final Context a;
    public final AtomicReference b = new AtomicReference(null);
    public final jr2 c;
    public final g32 d;

    public r2(Context context) {
        this.a = context;
        jr2 jr2VarA = o54.a(Boolean.FALSE);
        this.c = jr2VarA;
        this.d = new g32(jr2VarA);
    }

    public static final void a(AtomicBoolean atomicBoolean, hq0 hq0Var, ad2 ad2Var) {
        if (atomicBoolean.compareAndSet(false, true)) {
            hq0Var.j(ad2Var);
            return;
        }
        zc2 zc2Var = ad2Var instanceof zc2 ? (zc2) ad2Var : null;
        if (zc2Var != null) {
            zc2Var.a.recycle();
        }
    }

    public static AccessibilityNodeInfo f(List list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) next;
            if (accessibilityNodeInfo.isEditable() && !accessibilityNodeInfo.isPassword()) {
                Set setC = wh2.c("entry", "message_entry", "compose_text");
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (mz.s(viewIdResourceName != null ? cs2.S(viewIdResourceName, '/') : null, setC)) {
                    obj = next;
                    break;
                }
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
        if (accessibilityNodeInfo2 != null) {
            return accessibilityNodeInfo2;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj2;
            if (accessibilityNodeInfo3.isEditable() && !accessibilityNodeInfo3.isPassword()) {
                arrayList.add(obj2);
            }
        }
        return (AccessibilityNodeInfo) mz.I(arrayList);
    }

    public static int m(String str, List list) {
        int i = 0;
        if (list != null && list.isEmpty()) {
            return 0;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) it.next();
            if (!accessibilityNodeInfo.isEditable()) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (g31.a(text != null ? text.toString() : null, str)) {
                    Set setC = wh2.c("message_text", "message_body");
                    String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                    if (mz.s(viewIdResourceName != null ? cs2.S(viewIdResourceName, '/') : null, setC) && (i = i + 1) < 0) {
                        nz.m();
                        throw null;
                    }
                } else {
                    continue;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:89:0x012f  */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0130, code lost:
    
        if (r2 == null) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String q(java.util.List r12) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r2.q(java.util.List):java.lang.String");
    }

    public final AccessibilityNodeInfo b() {
        Object h72Var;
        String string;
        AccessibilityService accessibilityServiceI = i();
        if (accessibilityServiceI != null) {
            try {
                List<AccessibilityWindowInfo> windows = accessibilityServiceI.getWindows();
                try {
                    windows.getClass();
                    vl0 vl0Var = new vl0(new rg(1, windows), true, new j(1));
                    i2 i2Var = new i2(1, new i2(0, new lo0(6)));
                    ArrayList arrayList = new ArrayList();
                    Iterator it = vl0Var.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                    qz.p(arrayList, i2Var);
                    Iterator it2 = arrayList.iterator();
                    AccessibilityWindowInfo accessibilityWindowInfo = (AccessibilityWindowInfo) (!it2.hasNext() ? null : it2.next());
                    if (accessibilityWindowInfo != null) {
                        AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
                        if (root != null) {
                            CharSequence packageName = root.getPackageName();
                            if (packageName != null && (string = packageName.toString()) != null && (!cs2.A(string))) {
                                return root;
                            }
                            root.recycle();
                        }
                    } else if (windows.isEmpty()) {
                        try {
                            h72Var = accessibilityServiceI.getRootInActiveWindow();
                        } catch (Throwable th) {
                            h72Var = new h72(th);
                        }
                        if (h72Var instanceof h72) {
                            h72Var = null;
                        }
                        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) h72Var;
                        if (accessibilityNodeInfo != null) {
                            CharSequence packageName2 = accessibilityNodeInfo.getPackageName();
                            String string2 = packageName2 != null ? packageName2.toString() : null;
                            if (string2 == null) {
                                string2 = "";
                            }
                            if (windows.isEmpty() && !cs2.A(string2) && !wh2.c("android", "com.android.systemui").contains(string2) && !cs2.n(string2, "inputmethod", false) && !cs2.n(string2, "keyboard", false)) {
                                return accessibilityNodeInfo;
                            }
                            accessibilityNodeInfo.recycle();
                        }
                    }
                } finally {
                    windows.getClass();
                    Iterator<T> it3 = windows.iterator();
                    while (it3.hasNext()) {
                        ((AccessibilityWindowInfo) it3.next()).recycle();
                    }
                }
            } catch (IllegalStateException | SecurityException unused) {
                return null;
            }
        }
        return null;
    }

    public final AccessibilityNodeInfo c() {
        List listD = d();
        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) mz.y(listD);
        Iterator it = mz.u(1, listD).iterator();
        while (it.hasNext()) {
            ((AccessibilityNodeInfo) it.next()).recycle();
        }
        return accessibilityNodeInfo;
    }

    public final List d() {
        AccessibilityNodeInfo rootInActiveWindow;
        int i;
        AccessibilityService accessibilityServiceI = i();
        if (accessibilityServiceI == null) {
            return ii0.a;
        }
        List<AccessibilityWindowInfo> windows = accessibilityServiceI.getWindows();
        ArrayList arrayList = new ArrayList();
        try {
            windows.getClass();
            if (!windows.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = windows.iterator();
                while (true) {
                    i = 3;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    AccessibilityWindowInfo accessibilityWindowInfo = (AccessibilityWindowInfo) next;
                    if (accessibilityWindowInfo.getType() == 1 || accessibilityWindowInfo.getType() == 3 || accessibilityWindowInfo.getType() == 4) {
                        arrayList2.add(next);
                    }
                }
                Iterator it2 = mz.K(arrayList2, new i2(i, new i2(2, new lo0(7)))).iterator();
                while (it2.hasNext()) {
                    AccessibilityNodeInfo root = ((AccessibilityWindowInfo) it2.next()).getRoot();
                    if (root != null) {
                        arrayList.add(root);
                    }
                }
            }
            if (arrayList.isEmpty() && (rootInActiveWindow = accessibilityServiceI.getRootInActiveWindow()) != null) {
                arrayList.add(rootInActiveWindow);
            }
            return arrayList;
        } finally {
            windows.getClass();
            Iterator<T> it3 = windows.iterator();
            while (it3.hasNext()) {
                ((AccessibilityWindowInfo) it3.next()).recycle();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(long j, y50 y50Var) {
        j2 j2Var;
        if (y50Var instanceof j2) {
            j2Var = (j2) y50Var;
            int i = j2Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                j2Var.i = i - Integer.MIN_VALUE;
            } else {
                j2Var = new j2(this, y50Var);
            }
        } else {
            j2Var = new j2(this, y50Var);
        }
        Object obj = j2Var.e;
        int i2 = j2Var.i;
        x50 x50Var = null;
        if (i2 == 0) {
            bz3.g(obj);
            if (j()) {
                return Boolean.TRUE;
            }
            l2 l2Var = new l2(this, x50Var, 0);
            j2Var.i = 1;
            Object objC = xc4.c(j, l2Var, j2Var);
            t70 t70Var = t70.a;
            if (objC == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(obj);
        }
        return Boolean.valueOf(j());
    }

    public final y93 g() {
        return (y93) s(new x0(2, this));
    }

    public final synchronized void h(SonicService sonicService) {
        try {
            sonicService.getClass();
            AtomicReference atomicReference = this.b;
            while (!atomicReference.compareAndSet(sonicService, null)) {
                if (atomicReference.get() != sonicService) {
                }
            }
            jr2 jr2Var = this.c;
            Boolean bool = Boolean.FALSE;
            jr2Var.getClass();
            jr2Var.j(null, bool);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final AccessibilityService i() {
        return (AccessibilityService) this.b.get();
    }

    public final boolean j() {
        return this.b.get() != null;
    }

    public final boolean k(String str) {
        str.getClass();
        AccessibilityNodeInfo accessibilityNodeInfoB = b();
        if (accessibilityNodeInfoB == null) {
            return false;
        }
        try {
            CharSequence packageName = accessibilityNodeInfoB.getPackageName();
            return g31.a(packageName != null ? packageName.toString() : null, str);
        } finally {
            accessibilityNodeInfoB.recycle();
        }
    }

    public final boolean l() {
        KeyguardManager keyguardManager = (KeyguardManager) this.a.getSystemService(KeyguardManager.class);
        return keyguardManager != null && keyguardManager.isKeyguardLocked();
    }

    public final Object n(y50 y50Var) {
        yv yvVar = new yv(1, fp4.b(y50Var));
        yvVar.x();
        int i = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        yvVar.z(new m2(atomicBoolean, 0));
        try {
            o(new f2(new o2(atomicBoolean, yvVar, i), 0));
        } catch (Throwable th) {
            if (atomicBoolean.compareAndSet(false, true)) {
                yvVar.h(new h72(th));
            }
        }
        return yvVar.v();
    }

    public final void o(hq0 hq0Var) {
        AccessibilityService accessibilityServiceI = i();
        if (Build.VERSION.SDK_INT < 30 || accessibilityServiceI == null) {
            hq0Var.j(new yc2(null));
        } else {
            accessibilityServiceI.takeScreenshot(0, this.a.getMainExecutor(), new q2(new AtomicBoolean(false), hq0Var));
        }
    }

    public final Object p(y50 y50Var) {
        int i = 1;
        yv yvVar = new yv(1, fp4.b(y50Var));
        yvVar.x();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        yvVar.z(new m2(atomicBoolean, 1));
        try {
            o(new o2(atomicBoolean, yvVar, i));
        } catch (Throwable th) {
            if (atomicBoolean.compareAndSet(false, true)) {
                yvVar.h(new h72(th));
            }
        }
        return yvVar.v();
    }

    public final boolean r(String str, int i, String str2) {
        str.getClass();
        str2.getClass();
        return g31.a(s(new h2(this, str, i, str2, 0)), Boolean.TRUE);
    }

    public final Object s(hq0 hq0Var) {
        AccessibilityNodeInfo accessibilityNodeInfoB = b();
        if (accessibilityNodeInfoB != null) {
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(accessibilityNodeInfoB);
            int i = 0;
            try {
                Set setC = wh2.c("com.whatsapp", "com.whatsapp.w4b");
                CharSequence packageName = accessibilityNodeInfoB.getPackageName();
                if (mz.s(packageName != null ? packageName.toString() : null, setC)) {
                    while (!arrayDeque.isEmpty() && arrayList.size() < 1000) {
                        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) arrayDeque.removeFirst();
                        accessibilityNodeInfo.getClass();
                        arrayList.add(accessibilityNodeInfo);
                        if (!accessibilityNodeInfo.isPassword()) {
                            int childCount = accessibilityNodeInfo.getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
                                if (child != null) {
                                    arrayDeque.add(child);
                                }
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        if (((AccessibilityNodeInfo) obj).isVisibleToUser()) {
                            arrayList2.add(obj);
                        }
                    }
                    return hq0Var.j(arrayList2);
                }
            } finally {
                int size2 = arrayList.size();
                while (i < size2) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    ((AccessibilityNodeInfo) obj2).recycle();
                }
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((AccessibilityNodeInfo) it.next()).recycle();
                }
            }
        }
        return null;
    }
}
