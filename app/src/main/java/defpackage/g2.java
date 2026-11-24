package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g2 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ g2(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0303  */
    /* JADX WARN: Code duplicated, block: B:12:0x0059  */
    /* JADX WARN: Code duplicated, block: B:155:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:157:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:158:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:160:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:177:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:182:0x03c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x03ec A[SYNTHETIC] */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        String strQ;
        boolean z;
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo parent;
        int i;
        int i2;
        String lowerCase;
        String string;
        String string2;
        String string3;
        ae1 ae1Var;
        Object obj2 = null;
        boolean zPerformAction = false;
        zPerformAction = false;
        zPerformAction = false;
        zPerformAction = false;
        zPerformAction = false;
        zPerformAction = false;
        zPerformAction = false;
        zPerformAction = false;
        switch (this.a) {
            case 0:
                r2 r2Var = (r2) this.b;
                String str = (String) this.c;
                String str2 = (String) this.e;
                String str3 = (String) this.f;
                List list = (List) obj;
                list.getClass();
                r2Var.getClass();
                AccessibilityNodeInfo accessibilityNodeInfoF = r2.f(list);
                if (accessibilityNodeInfoF != null && (strQ = r2.q(list)) != null) {
                    boolean zA = mf4.a(strQ, str);
                    if (!cs2.A(str2)) {
                        CharSequence text = accessibilityNodeInfoF.getText();
                        z = g31.a((text == null || (string3 = text.toString()) == null) ? null : cs2.V(string3).toString(), cs2.V(str2).toString());
                    }
                    if (zA && z) {
                        CharSequence packageName = accessibilityNodeInfoF.getPackageName();
                        if (g31.a(packageName != null ? packageName.toString() : null, str3)) {
                            for (Object obj3 : list) {
                                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj3;
                                String viewIdResourceName = accessibilityNodeInfo2.getViewIdResourceName();
                                String strS = viewIdResourceName != null ? cs2.S(viewIdResourceName, '/') : null;
                                if (strS == null) {
                                    strS = "";
                                }
                                Locale locale = Locale.ROOT;
                                String lowerCase2 = strS.toLowerCase(locale);
                                lowerCase2.getClass();
                                CharSequence contentDescription = accessibilityNodeInfo2.getContentDescription();
                                if (contentDescription == null || (string = contentDescription.toString()) == null || (string2 = cs2.V(string).toString()) == null) {
                                    lowerCase = null;
                                } else {
                                    lowerCase = string2.toLowerCase(locale);
                                    lowerCase.getClass();
                                }
                                if (lowerCase == null) {
                                    lowerCase = "";
                                }
                                if (wh2.c("send", "button_send", "entry_send").contains(lowerCase2) || (wh2.c("send", "send message", "भेजें").contains(lowerCase) && !cs2.n(lowerCase2, "voice", false) && !cs2.n(lowerCase2, "mic", false))) {
                                    if (accessibilityNodeInfo2.isEnabled()) {
                                        obj2 = obj3;
                                        accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
                                        if (accessibilityNodeInfo != null) {
                                            if (accessibilityNodeInfo.isClickable()) {
                                                zPerformAction = accessibilityNodeInfo.performAction(16);
                                            } else {
                                                parent = accessibilityNodeInfo.getParent();
                                                i = 0;
                                                while (parent != null) {
                                                    i2 = i + 1;
                                                    if (i < 3) {
                                                        try {
                                                            if (!parent.isClickable() && parent.isEnabled() && parent.isVisibleToUser()) {
                                                                zPerformAction = parent.performAction(16);
                                                                parent.recycle();
                                                            } else {
                                                                AccessibilityNodeInfo parent2 = parent.getParent();
                                                                parent.recycle();
                                                                parent = parent2;
                                                                i = i2;
                                                            }
                                                        } catch (Throwable th) {
                                                            parent.recycle();
                                                            throw th;
                                                        }
                                                    } else if (parent != null) {
                                                        parent.recycle();
                                                    }
                                                }
                                                if (parent != null) {
                                                    parent.recycle();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
                            if (accessibilityNodeInfo != null) {
                                if (accessibilityNodeInfo.isClickable()) {
                                    zPerformAction = accessibilityNodeInfo.performAction(16);
                                } else {
                                    parent = accessibilityNodeInfo.getParent();
                                    i = 0;
                                    while (parent != null) {
                                        i2 = i + 1;
                                        if (i < 3) {
                                            if (!parent.isClickable()) {
                                            }
                                            AccessibilityNodeInfo parent3 = parent.getParent();
                                            parent.recycle();
                                            parent = parent3;
                                            i = i2;
                                        } else if (parent != null) {
                                            parent.recycle();
                                        }
                                    }
                                    if (parent != null) {
                                        parent.recycle();
                                    }
                                }
                            }
                        }
                    }
                }
                return Boolean.valueOf(zPerformAction);
            case 1:
                bd bdVar = (bd) this.b;
                qd qdVar = (qd) this.c;
                hq0 hq0Var = (hq0) this.e;
                o42 o42Var = (o42) this.f;
                od odVar = (od) obj;
                ya4.f(odVar, bdVar.c);
                ku1 ku1Var = odVar.e;
                Object objA = bd.a(bdVar, ku1Var.getValue());
                if (!g31.a(objA, ku1Var.getValue())) {
                    bdVar.c.b.setValue(objA);
                    qdVar.b.setValue(objA);
                    if (hq0Var != null) {
                        hq0Var.j(bdVar);
                    }
                    odVar.a();
                    o42Var.a = true;
                } else if (hq0Var != null) {
                    hq0Var.j(bdVar);
                }
                return q43.a;
            case 2:
                ua1 ua1Var = (ua1) this.b;
                xy2 xy2Var = (xy2) this.c;
                ty2 ty2Var = (ty2) this.e;
                kz0 kz0Var = (kz0) this.f;
                if (ua1Var.b()) {
                    l11 l11Var = ua1Var.d;
                    q60 q60Var = ua1Var.v;
                    q60 q60Var2 = ua1Var.w;
                    t42 t42Var = new t42();
                    e2 e2Var = new e2(l11Var, q60Var, t42Var, 12);
                    by1 by1Var = xy2Var.a;
                    by1Var.h(ty2Var, kz0Var, e2Var, q60Var2);
                    bz2 bz2Var = new bz2(xy2Var, by1Var);
                    xy2Var.b.set(bz2Var);
                    t42Var.a = bz2Var;
                    ua1Var.e = bz2Var;
                }
                return new ya(1);
            case 3:
                q42 q42Var = (q42) this.b;
                z91 z91Var = (z91) this.c;
                q42 q42Var2 = (q42) this.e;
                ka0 ka0Var = (ka0) this.f;
                od odVar2 = (od) obj;
                float fFloatValue = ((Number) odVar2.e.getValue()).floatValue() - q42Var.a;
                float fA = z91Var.a(fFloatValue);
                q42Var.a = ((Number) odVar2.e.getValue()).floatValue();
                q42Var2.a = ((Number) odVar2.a.b.j(odVar2.f)).floatValue();
                if (Math.abs(fFloatValue - fA) > 0.5f) {
                    odVar2.a();
                }
                ka0Var.getClass();
                return q43.a;
            case 4:
                mt0 mt0Var = (mt0) this.b;
                s70 s70Var = (s70) this.c;
                x00 x00Var = (x00) this.e;
                hd1 hd1Var = (hd1) this.f;
                Long l = (Long) obj;
                long jLongValue = l.longValue();
                zd1 zd1Var = mt0Var.B;
                synchronized (zd1Var) {
                    ae1Var = (ae1) zd1Var.a.get(l);
                }
                if (ae1Var != null && mt0Var.B.g(jLongValue)) {
                    mt0Var.P.incrementAndGet();
                    mt0.f(mt0Var, "pcmRepliesCompleted");
                    synchronized (mt0Var.Q) {
                        mt0Var.Q.add(new xd1(ae1Var.a, ae1Var.c));
                        while (mt0Var.Q.size() > 128) {
                            mt0Var.Q.remove(0);
                        }
                    }
                    uf4.b(s70Var, null, new ws0(mt0Var, x00Var, hd1Var, s70Var, null, 1), 3);
                }
                return q43.a;
            case 5:
                mm1 mm1Var = (mm1) this.b;
                s01 s01Var = (s01) this.c;
                q42 q42Var3 = (q42) this.e;
                s70 s70Var2 = (s70) this.f;
                long jLongValue2 = ((Long) obj).longValue();
                gr2 gr2Var = (gr2) mm1Var.getValue();
                long jLongValue3 = gr2Var != null ? ((Number) gr2Var.getValue()).longValue() : jLongValue2;
                long j = s01Var.c;
                pm1 pm1Var = s01Var.a;
                if (j == Long.MIN_VALUE || q42Var3.a != ya4.e(s70Var2.o())) {
                    s01Var.c = jLongValue2;
                    Object[] objArr = pm1Var.a;
                    int i3 = pm1Var.c;
                    for (int i4 = 0; i4 < i3; i4++) {
                        ((q01) objArr[i4]).i = true;
                    }
                    q42Var3.a = ya4.e(s70Var2.o());
                }
                float f = q42Var3.a;
                if (f == 0.0f) {
                    Object[] objArr2 = pm1Var.a;
                    int i5 = pm1Var.c;
                    for (int i6 = 0; i6 < i5; i6++) {
                        q01 q01Var = (q01) objArr2[i6];
                        q01Var.c.setValue(q01Var.e.c);
                        q01Var.i = true;
                    }
                } else {
                    long j2 = (long) ((jLongValue3 - s01Var.c) / f);
                    Object[] objArr3 = pm1Var.a;
                    int i7 = pm1Var.c;
                    boolean z2 = true;
                    for (int i8 = 0; i8 < i7; i8++) {
                        q01 q01Var2 = (q01) objArr3[i8];
                        if (!q01Var2.f) {
                            q01Var2.k.b.setValue(Boolean.FALSE);
                            if (q01Var2.i) {
                                q01Var2.i = false;
                                q01Var2.j = j2;
                            }
                            long j3 = j2 - q01Var2.j;
                            q01Var2.c.setValue(q01Var2.e.a(j3));
                            q01Var2.f = q01Var2.e.f(j3);
                        }
                        if (!q01Var2.f) {
                            z2 = false;
                        }
                    }
                    s01Var.d.setValue(Boolean.valueOf(!z2));
                }
                return q43.a;
            case 6:
                f91 f91Var = (f91) this.b;
                f91Var.c = new a50((v81) this.c, (ws2) this.e, (uz1) this.f);
                return new g8(7, f91Var);
            default:
                q42 q42Var4 = (q42) this.b;
                sc0 sc0Var = (sc0) this.c;
                fe2 fe2Var = (fe2) this.e;
                w9 w9Var = (w9) this.f;
                od odVar3 = (od) obj;
                q43 q43Var = q43.a;
                float fFloatValue2 = ((Number) odVar3.e.getValue()).floatValue() - q42Var4.a;
                if (pr4.a(fFloatValue2)) {
                    if (((Boolean) w9Var.j(Float.valueOf(q42Var4.a))).booleanValue()) {
                        odVar3.a();
                    }
                } else if (pr4.a(fFloatValue2 - sc0Var.c(fe2Var, fFloatValue2))) {
                    q42Var4.a += fFloatValue2;
                    if (((Boolean) w9Var.j(Float.valueOf(q42Var4.a))).booleanValue()) {
                        odVar3.a();
                    }
                } else {
                    odVar3.a();
                }
                return q43Var;
        }
    }
}
