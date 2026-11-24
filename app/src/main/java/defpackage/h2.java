package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h2 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ h2(Object obj, Object obj2, int i, Serializable serializable, int i2) {
        this.a = i2;
        this.c = obj;
        this.e = obj2;
        this.b = i;
        this.f = serializable;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        AccessibilityNodeInfo accessibilityNodeInfoF;
        boolean zContains;
        String string;
        int i = this.a;
        String string2 = null;
        string2 = null;
        q43 q43Var = q43.a;
        boolean z = false;
        int i2 = 0;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        Object obj2 = this.f;
        int i3 = this.b;
        Object obj3 = this.e;
        Object obj4 = this.c;
        switch (i) {
            case 0:
                String str = (String) obj3;
                String str2 = (String) obj2;
                List list = (List) obj;
                list.getClass();
                ((r2) obj4).getClass();
                String strQ = r2.q(list);
                if (strQ != null && (accessibilityNodeInfoF = r2.f(list)) != null && mf4.a(strQ, str)) {
                    CharSequence text = accessibilityNodeInfoF.getText();
                    if (text != null && (string = text.toString()) != null) {
                        string2 = cs2.V(string).toString();
                    }
                    if (string2 == null) {
                        string2 = "";
                    }
                    if (string2.length() == 0) {
                        zContains = true;
                    } else {
                        Set setC = wh2.c("message", "message...", "type a message", "type a message...", "संदेश लिखे", "संदेश लिखें", "संदेश", "মেসেজ লিখুন", "મેસેજ લખો");
                        Locale locale = Locale.ROOT;
                        locale.getClass();
                        String lowerCase = string2.toLowerCase(locale);
                        lowerCase.getClass();
                        zContains = setC.contains(lowerCase);
                    }
                    if (zContains) {
                        int iM = r2.m(str2, list);
                        if (i3 != 0 ? iM > i3 : iM > 0) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            case 1:
                j21 j21Var = (j21) obj3;
                ul1 ul1Var = (ul1) obj2;
                if (obj == ((qc0) obj4)) {
                    og.n("A derived state calculation cannot read itself");
                    return null;
                }
                if (obj instanceof nr2) {
                    int i4 = j21Var.a - i3;
                    int iD = ul1Var.d(obj);
                    ul1Var.g(Math.min(i4, iD >= 0 ? ul1Var.c[iD] : Integer.MAX_VALUE), obj);
                }
                return q43Var;
            case 2:
                uw0 uw0Var = (uw0) obj4;
                qh1 qh1Var = (qh1) obj3;
                zw1 zw1Var = (zw1) obj2;
                yw1 yw1Var = (yw1) obj;
                int i5 = uw0Var.b;
                fy2 fy2Var = uw0Var.a;
                a23 a23Var = uw0Var.c;
                hz2 hz2Var = (hz2) uw0Var.d.a();
                fy2Var.a(js1.b, ub4.a(yw1Var, i5, a23Var, hz2Var != null ? hz2Var.a : null, qh1Var.getLayoutDirection() == z61.b, zw1Var.a), i3, zw1Var.a);
                yw1.k(yw1Var, zw1Var, Math.round(-fy2Var.a.g()), 0);
                return q43Var;
            default:
                zw1[] zw1VarArr = (zw1[]) obj4;
                e92 e92Var = (e92) obj3;
                int[] iArr = (int[]) obj2;
                yw1 yw1Var2 = (yw1) obj;
                int length = zw1VarArr.length;
                int i6 = 0;
                while (i2 < length) {
                    zw1 zw1Var2 = zw1VarArr[i2];
                    zw1Var2.getClass();
                    zw1Var2.k();
                    yw1.h(yw1Var2, zw1Var2, iArr[i6], Math.round((1.0f + e92Var.b.a) * ((i3 - zw1Var2.b) / 2.0f)));
                    i2++;
                    i6++;
                }
                return q43Var;
        }
    }

    public /* synthetic */ h2(Object obj, Object obj2, Object obj3, int i, int i2) {
        this.a = i2;
        this.c = obj;
        this.e = obj2;
        this.f = obj3;
        this.b = i;
    }
}
