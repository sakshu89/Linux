package defpackage;

import android.util.Rational;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i2 implements Comparator {
    public final /* synthetic */ int a;
    public final Object b;

    public i2(Comparator comparator) {
        this.a = 19;
        this.b = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.a;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                int iCompare = ((lo0) obj3).compare(obj, obj2);
                return iCompare != 0 ? iCompare : si4.a(Boolean.valueOf(((AccessibilityWindowInfo) obj2).isActive()), Boolean.valueOf(((AccessibilityWindowInfo) obj).isActive()));
            case 1:
                int iCompare2 = ((i2) obj3).compare(obj, obj2);
                return iCompare2 != 0 ? iCompare2 : si4.a(Integer.valueOf(((AccessibilityWindowInfo) obj2).getLayer()), Integer.valueOf(((AccessibilityWindowInfo) obj).getLayer()));
            case 2:
                int iCompare3 = ((lo0) obj3).compare(obj, obj2);
                return iCompare3 != 0 ? iCompare3 : si4.a(Boolean.valueOf(((AccessibilityWindowInfo) obj2).isActive()), Boolean.valueOf(((AccessibilityWindowInfo) obj).isActive()));
            case 3:
                int iCompare4 = ((i2) obj3).compare(obj, obj2);
                return iCompare4 != 0 ? iCompare4 : si4.a(Integer.valueOf(((AccessibilityWindowInfo) obj2).getLayer()), Integer.valueOf(((AccessibilityWindowInfo) obj).getLayer()));
            case 4:
                int iCompare5 = ((lo0) obj3).compare(obj, obj2);
                return iCompare5 != 0 ? iCompare5 : si4.a(Boolean.valueOf(((uw1) ((wt1) obj2).a).e), Boolean.valueOf(((uw1) ((wt1) obj).a).e));
            case 5:
                int iCompare6 = ((i2) obj3).compare(obj, obj2);
                return iCompare6 != 0 ? iCompare6 : si4.a(Integer.valueOf(((String) obj).length()), Integer.valueOf(((String) obj2).length()));
            case 6:
                int iCompare7 = ((i2) obj3).compare(obj, obj2);
                return iCompare7 != 0 ? iCompare7 : si4.a((String) obj, (String) obj2);
            case 7:
                int iCompare8 = ((lo0) obj3).compare(obj, obj2);
                if (iCompare8 != 0) {
                    return iCompare8;
                }
                x42 x42Var = od1.a;
                return si4.a((Comparable) od1.a((String) obj2).a, (Comparable) od1.a((String) obj).a);
            case 8:
                int iCompare9 = ((i2) obj3).compare(obj, obj2);
                if (iCompare9 != 0) {
                    return iCompare9;
                }
                x42 x42Var2 = od1.a;
                return si4.a((Comparable) od1.a((String) obj2).b, (Comparable) od1.a((String) obj).b);
            case 9:
                int iCompare10 = ((lo0) obj3).compare(obj, obj2);
                return iCompare10 != 0 ? iCompare10 : si4.a(((o21) obj).b(), ((o21) obj2).b());
            case 10:
                Rational rational = (Rational) obj2;
                Rational rational2 = (Rational) obj3;
                float fFloatValue = ((Rational) obj).floatValue();
                float fFloatValue2 = rational2.floatValue();
                float f = fFloatValue > fFloatValue2 ? fFloatValue2 / fFloatValue : fFloatValue / fFloatValue2;
                float fFloatValue3 = rational.floatValue();
                float fFloatValue4 = rational2.floatValue();
                return Float.compare(fFloatValue3 > fFloatValue4 ? fFloatValue4 / fFloatValue3 : fFloatValue3 / fFloatValue4, f);
            case 11:
                int iCompare11 = ((lo0) obj3).compare(obj, obj2);
                return iCompare11 != 0 ? iCompare11 : si4.a(Integer.valueOf(((mb2) obj).c.left), Integer.valueOf(((mb2) obj2).c.left));
            case 12:
                int iCompare12 = ((i2) obj3).compare(obj, obj2);
                if (iCompare12 != 0) {
                    return iCompare12;
                }
                mb2 mb2Var = (mb2) obj;
                mb2 mb2Var2 = (mb2) obj2;
                return si4.a(Integer.valueOf(mb2Var.c.height() * mb2Var.c.width()), Integer.valueOf(mb2Var2.c.height() * mb2Var2.c.width()));
            case 13:
                int iCompare13 = ((lo0) obj3).compare(obj, obj2);
                return iCompare13 != 0 ? iCompare13 : si4.a(Integer.valueOf(((ob2) obj).d.left), Integer.valueOf(((ob2) obj2).d.left));
            case 14:
                int iCompare14 = ((lo0) obj3).compare(obj, obj2);
                return iCompare14 != 0 ? iCompare14 : si4.a(Integer.valueOf(cq.g((AccessibilityNodeInfo) obj).left), Integer.valueOf(cq.g((AccessibilityNodeInfo) obj2).left));
            case 15:
                int iCompare15 = ((lo0) obj3).compare(obj, obj2);
                return iCompare15 != 0 ? iCompare15 : si4.a(Integer.valueOf(((gp1) obj).b.left), Integer.valueOf(((gp1) obj2).b.left));
            case 16:
                int iCompare16 = ((lo0) obj3).compare(obj, obj2);
                return iCompare16 != 0 ? iCompare16 : si4.a(Integer.valueOf(((ob2) obj).d.left), Integer.valueOf(((ob2) obj2).d.left));
            case 17:
                int iCompare17 = ((lo0) obj3).compare(obj, obj2);
                return iCompare17 != 0 ? iCompare17 : si4.a(Integer.valueOf(cq.g((AccessibilityNodeInfo) obj).left), Integer.valueOf(cq.g((AccessibilityNodeInfo) obj2).left));
            case 18:
                int iCompare18 = ((lo0) obj3).compare(obj, obj2);
                return iCompare18 != 0 ? iCompare18 : si4.a(Integer.valueOf(((zb2) obj).d.left), Integer.valueOf(((zb2) obj2).d.left));
            case 19:
                int iCompare19 = ((Comparator) obj3).compare(obj, obj2);
                if (iCompare19 != 0) {
                    return iCompare19;
                }
                return n71.A0.compare(((gg2) obj).c, ((gg2) obj2).c);
            case 20:
                int iCompare20 = ((i2) obj3).compare(obj, obj2);
                return iCompare20 != 0 ? iCompare20 : si4.a(Integer.valueOf(((gg2) obj).g), Integer.valueOf(((gg2) obj2).g));
            case 21:
                int iCompare21 = ((wp2) obj3).compare(obj, obj2);
                return iCompare21 != 0 ? iCompare21 : si4.a(Integer.valueOf(((gp1) obj).b.left), Integer.valueOf(((gp1) obj2).b.left));
            case 22:
                int iCompare22 = ((wp2) obj3).compare(obj, obj2);
                return iCompare22 != 0 ? iCompare22 : si4.a(Integer.valueOf(((vp2) obj).b.left), Integer.valueOf(((vp2) obj2).b.left));
            case 23:
                int iCompare23 = ((wp2) obj3).compare(obj, obj2);
                return iCompare23 != 0 ? iCompare23 : si4.a(Integer.valueOf(((hp1) obj).d.left), Integer.valueOf(((hp1) obj2).d.left));
            case 24:
                int iCompare24 = ((wp2) obj3).compare(obj, obj2);
                return iCompare24 != 0 ? iCompare24 : si4.a(Integer.valueOf(((hp1) obj).d.left), Integer.valueOf(((hp1) obj2).d.left));
            case 25:
                int iCompare25 = ((wp2) obj3).compare(obj, obj2);
                return iCompare25 != 0 ? iCompare25 : si4.a(Integer.valueOf(((aq2) obj).a.c.left), Integer.valueOf(((aq2) obj2).a.c.left));
            case 26:
                bq2 bq2Var = (bq2) obj3;
                return si4.a(Integer.valueOf(bq2.c(bq2Var, (zp2) obj)), Integer.valueOf(bq2.c(bq2Var, (zp2) obj2)));
            case 27:
                int iCompare26 = ((i2) obj3).compare(obj, obj2);
                if (iCompare26 != 0) {
                    return iCompare26;
                }
                cd3 cd3Var = (cd3) obj;
                cd3 cd3Var2 = (cd3) obj2;
                return si4.a(Integer.valueOf(cd3Var.c.height() * cd3Var.c.width()), Integer.valueOf(cd3Var2.c.height() * cd3Var2.c.width()));
            default:
                Integer num = 0;
                int iCompare27 = ((wp2) obj3).compare(obj, obj2);
                if (iCompare27 != 0) {
                    return iCompare27;
                }
                return si4.a(((cd3) obj2).a.isClickable() ? 1 : num, ((cd3) obj).a.isClickable() ? 1 : 0);
        }
    }

    public /* synthetic */ i2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
