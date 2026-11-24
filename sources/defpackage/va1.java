package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class va1 implements hq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ va1(int i) {
        this.a = i;
    }

    /* JADX WARN: Code duplicated, block: B:144:0x03a9  */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        String str;
        sz szVar;
        int i = this.a;
        q43 q43Var = q43.a;
        hp2 hp2Var = null;
        jz2Var = null;
        jz2 jz2Var = null;
        hp2Var = null;
        int i2 = 0;
        switch (i) {
            case 0:
                return q43Var;
            case 1:
                return q43Var;
            case 2:
                fh1 fh1Var = (fh1) obj;
                fh1Var.getClass();
                return fh1Var.c();
            case 3:
                ((Long) obj).getClass();
                return q43Var;
            case 4:
                au1 au1Var = (au1) obj;
                StringBuilder sb = new StringBuilder("[");
                sb.append(au1Var.b);
                sb.append(", ");
                return ky0.m(sb, au1Var.c, ')');
            case 5:
                ta taVar = ((vn1) obj).a;
                if (taVar != null) {
                    taVar.a();
                }
                return q43Var;
            case 6:
                gw1 gw1Var = (gw1) obj;
                int i3 = ea.a;
                sr2 sr2Var = AndroidCompositionLocals_androidKt.b;
                gw1Var.getClass();
                Context context = (Context) mj4.a(gw1Var, sr2Var);
                jc0 jc0Var = (jc0) mj4.a(gw1Var, l30.h);
                et1 et1Var = (et1) mj4.a(gw1Var, ft1.a);
                if (et1Var == null) {
                    return null;
                }
                return new g9(context, jc0Var, et1Var.a, et1Var.b);
            case 7:
                Context context2 = (Context) obj;
                List<ResolveInfo> listQueryIntentActivities = context2.getPackageManager().queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), 0);
                ArrayList arrayList = new ArrayList(listQueryIntentActivities.size());
                int size = listQueryIntentActivities.size();
                while (i2 < size) {
                    ResolveInfo resolveInfo = listQueryIntentActivities.get(i2);
                    ResolveInfo resolveInfo2 = resolveInfo;
                    if (context2.getPackageName().equals(resolveInfo2.activityInfo.packageName)) {
                        arrayList.add(resolveInfo);
                    } else {
                        ActivityInfo activityInfo = resolveInfo2.activityInfo;
                        if (activityInfo.exported && ((str = activityInfo.permission) == null || context2.checkSelfPermission(str) == 0)) {
                            arrayList.add(resolveInfo);
                        }
                    }
                    i2++;
                }
                return arrayList;
            case 8:
                x51 x51Var = (x51) obj;
                x51Var.a = 6000;
                Float fValueOf = Float.valueOf(90.0f);
                x51Var.a(fValueOf, 300).b = uk1.a;
                x51Var.a(fValueOf, 1500);
                Float fValueOf2 = Float.valueOf(180.0f);
                x51Var.a(fValueOf2, 1800);
                x51Var.a(fValueOf2, 3000);
                Float fValueOf3 = Float.valueOf(270.0f);
                x51Var.a(fValueOf3, 3300);
                x51Var.a(fValueOf3, 4500);
                Float fValueOf4 = Float.valueOf(360.0f);
                x51Var.a(fValueOf4, 4800);
                x51Var.a(fValueOf4, 6000);
                return q43Var;
            case 9:
                q12 q12Var = q12.b;
                c51[] c51VarArr = mg2.a;
                ng2 ng2Var = kg2.c;
                c51 c51Var = mg2.a[1];
                ((og2) obj).a(ng2Var, q12Var);
                return q43Var;
            case 10:
                return new aa2((Map) obj);
            case 11:
                return obj;
            case 12:
                obj.getClass();
                List list = (List) obj;
                Object obj2 = list.get(0);
                hq0 hq0Var = (hq0) wa2.h.c;
                Boolean bool = Boolean.FALSE;
                hp2 hp2Var2 = (g31.a(obj2, bool) || obj2 == null) ? null : (hp2) hq0Var.j(obj2);
                Object obj3 = list.get(1);
                hp2 hp2Var3 = (g31.a(obj3, bool) || obj3 == null) ? null : (hp2) hq0Var.j(obj3);
                Object obj4 = list.get(2);
                hp2 hp2Var4 = (g31.a(obj4, bool) || obj4 == null) ? null : (hp2) hq0Var.j(obj4);
                Object obj5 = list.get(3);
                if (!g31.a(obj5, bool) && obj5 != null) {
                    hp2Var = (hp2) hq0Var.j(obj5);
                }
                return new jz2(hp2Var2, hp2Var3, hp2Var4, hp2Var);
            case 13:
                obj.getClass();
                List list2 = (List) obj;
                Object obj6 = list2.get(1);
                List list3 = (g31.a(obj6, Boolean.FALSE) || obj6 == null) ? null : (List) ((hq0) wa2.a.c).j(obj6);
                Object obj7 = list2.get(0);
                String str2 = obj7 != null ? (String) obj7 : null;
                str2.getClass();
                return new be(list3, str2);
            case 14:
                obj.getClass();
                return new sx2(((Integer) obj).intValue());
            case 15:
                obj.getClass();
                List list4 = (List) obj;
                return new vy2(((Number) list4.get(0)).floatValue(), ((Number) list4.get(1)).floatValue());
            case 16:
                obj.getClass();
                List list5 = (List) obj;
                Object obj8 = list5.get(0);
                c03[] c03VarArr = b03.b;
                hq0 hq0Var2 = wa2.v.b;
                Boolean bool2 = Boolean.FALSE;
                g31.a(obj8, bool2);
                b03 b03Var = obj8 != null ? (b03) hq0Var2.j(obj8) : null;
                b03Var.getClass();
                long j = b03Var.a;
                Object obj9 = list5.get(1);
                g31.a(obj9, bool2);
                b03 b03Var2 = obj9 != null ? (b03) hq0Var2.j(obj9) : null;
                b03Var2.getClass();
                return new wy2(j, b03Var2.a);
            case 17:
                obj.getClass();
                return new np0(((Integer) obj).intValue());
            case 18:
                obj.getClass();
                return new rk(((Float) obj).floatValue());
            case 19:
                obj.getClass();
                List list6 = (List) obj;
                Object obj10 = list6.get(0);
                Integer num = obj10 != null ? (Integer) obj10 : null;
                num.getClass();
                int iIntValue = num.intValue();
                Object obj11 = list6.get(1);
                Integer num2 = obj11 != null ? (Integer) obj11 : null;
                num2.getClass();
                return new oz2(hc4.a(iIntValue, num2.intValue()));
            case 20:
                obj.getClass();
                List list7 = (List) obj;
                Object obj12 = list7.get(0);
                int i4 = sz.h;
                Boolean bool3 = Boolean.FALSE;
                g31.a(obj12, bool3);
                if (obj12 != null) {
                    szVar = g31.a(obj12, Boolean.FALSE) ? new sz(sz.g) : new sz(ki4.b(((Integer) obj12).intValue()));
                } else {
                    szVar = null;
                }
                szVar.getClass();
                long j2 = szVar.a;
                Object obj13 = list7.get(1);
                va2 va2Var = wa2.x;
                g31.a(obj13, bool3);
                jp1 jp1Var = obj13 != null ? (jp1) va2Var.b.j(obj13) : null;
                jp1Var.getClass();
                long j3 = jp1Var.a;
                Object obj14 = list7.get(2);
                Float f = obj14 != null ? (Float) obj14 : null;
                f.getClass();
                return new vj2(j2, j3, f.floatValue());
            case 21:
                obj.getClass();
                return new vw2(((Integer) obj).intValue());
            case 22:
                obj.getClass();
                List list8 = (List) obj;
                Object obj15 = list8.get(0);
                String str3 = obj15 != null ? (String) obj15 : null;
                str3.getClass();
                Object obj16 = list8.get(1);
                q91 q91Var = wa2.i;
                if (!g31.a(obj16, Boolean.FALSE) && obj16 != null) {
                    jz2Var = (jz2) ((hq0) q91Var.c).j(obj16);
                }
                return new jc1(str3, jz2Var);
            case 23:
                obj.getClass();
                return new vx2(((Integer) obj).intValue());
            case 24:
                obj.getClass();
                return new iy0(((Integer) obj).intValue());
            case 25:
                obj.getClass();
                List list9 = (List) obj;
                ArrayList arrayList2 = new ArrayList(list9.size());
                int size2 = list9.size();
                while (i2 < size2) {
                    Object obj17 = list9.get(i2);
                    ae aeVar = (g31.a(obj17, Boolean.FALSE) || obj17 == null) ? null : (ae) ((hq0) wa2.b.c).j(obj17);
                    aeVar.getClass();
                    arrayList2.add(aeVar);
                    i2++;
                }
                return arrayList2;
            case 26:
                obj.getClass();
                return new lp0(((Integer) obj).intValue());
            case 27:
                obj.getClass();
                return new mp0(((Integer) obj).intValue());
            case 28:
                Boolean bool4 = Boolean.FALSE;
                if (g31.a(obj, bool4)) {
                    return new b03(b03.c);
                }
                obj.getClass();
                List list10 = (List) obj;
                Object obj18 = list10.get(0);
                Float f2 = obj18 != null ? (Float) obj18 : null;
                f2.getClass();
                float fFloatValue = f2.floatValue();
                Object obj19 = list10.get(1);
                va2 va2Var2 = wa2.w;
                g31.a(obj19, bool4);
                c03 c03Var = obj19 != null ? (c03) va2Var2.b.j(obj19) : null;
                c03Var.getClass();
                return new b03(nc4.d(fFloatValue, c03Var.a));
            default:
                if (g31.a(obj, 0)) {
                    return new c03(8589934592L);
                }
                return g31.a(obj, 1) ? new c03(4294967296L) : new c03(0L);
        }
    }
}
