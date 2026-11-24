package defpackage;

import android.graphics.Rect;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sa2 implements hq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ sa2(int i) {
        this.a = i;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        ae aeVar;
        String string;
        String string2;
        AccessibilityNodeInfo accessibilityNodeInfo;
        i = 0;
        int i = 0;
        ai0Var = null;
        ai0 ai0Var = null;
        vj2Var = null;
        vj2 vj2Var = null;
        lz2Var = null;
        lz2 lz2Var = null;
        ic1Var = null;
        ic1 ic1Var = null;
        jc1Var = null;
        jc1 jc1Var = null;
        m53Var = null;
        m53 m53Var = null;
        a73Var = null;
        a73 a73Var = null;
        hp2Var = null;
        hp2 hp2Var = null;
        eu1Var = null;
        eu1 eu1Var = null;
        jz2Var = null;
        jz2 jz2Var = null;
        switch (this.a) {
            case 0:
                if (g31.a(obj, Boolean.FALSE)) {
                    return new jp1(9205357640488583168L);
                }
                obj.getClass();
                List list = (List) obj;
                Object obj2 = list.get(0);
                Float f = obj2 != null ? (Float) obj2 : null;
                f.getClass();
                float fFloatValue = f.floatValue();
                Object obj3 = list.get(1);
                Float f2 = obj3 != null ? (Float) obj3 : null;
                f2.getClass();
                return new jp1((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(f2.floatValue())) & 4294967295L));
            case 1:
                obj.getClass();
                List list2 = (List) obj;
                ArrayList arrayList = new ArrayList(list2.size());
                int size = list2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj4 = list2.get(i2);
                    me1 me1Var = (g31.a(obj4, Boolean.FALSE) || obj4 == null) ? null : (me1) ((hq0) wa2.z.c).j(obj4);
                    me1Var.getClass();
                    arrayList.add(me1Var);
                }
                return new ne1(arrayList);
            case 2:
                obj.getClass();
                String str = (String) obj;
                gx1.a.getClass();
                Locale localeForLanguageTag = Locale.forLanguageTag(str);
                if (g31.a(localeForLanguageTag.toLanguageTag(), "und")) {
                    Log.e("Locale", "The language tag " + str + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
                }
                return new me1(localeForLanguageTag);
            case 3:
                obj.getClass();
                List list3 = (List) obj;
                Object obj5 = list3.get(0);
                String str2 = obj5 != null ? (String) obj5 : null;
                str2.getClass();
                Object obj6 = list3.get(1);
                q91 q91Var = wa2.i;
                if (!g31.a(obj6, Boolean.FALSE) && obj6 != null) {
                    jz2Var = (jz2) ((hq0) q91Var.c).j(obj6);
                }
                return new ic1(str2, jz2Var);
            case 4:
                obj.getClass();
                List list4 = (List) obj;
                Object obj7 = list4.get(0);
                float f3 = yb1.b;
                va2 va2Var = wa2.B;
                Boolean bool = Boolean.FALSE;
                g31.a(obj7, bool);
                yb1 yb1Var = obj7 != null ? (yb1) va2Var.b.j(obj7) : null;
                yb1Var.getClass();
                float f4 = yb1Var.a;
                Object obj8 = list4.get(1);
                va2 va2Var2 = wa2.C;
                g31.a(obj8, bool);
                ac1 ac1Var = obj8 != null ? (ac1) va2Var2.b.j(obj8) : null;
                ac1Var.getClass();
                int i3 = ac1Var.a;
                Object obj9 = list4.get(2);
                va2 va2Var3 = wa2.D;
                g31.a(obj9, bool);
                zb1 zb1Var = obj9 != null ? (zb1) va2Var3.b.j(obj9) : null;
                zb1Var.getClass();
                return new bc1(i3, f4, zb1Var.a);
            case 5:
                obj.getClass();
                float fFloatValue2 = ((Float) obj).floatValue();
                yb1.a(fFloatValue2);
                return new yb1(fFloatValue2);
            case 6:
                obj.getClass();
                return new ac1(((Integer) obj).intValue());
            case 7:
                obj.getClass();
                List list5 = (List) obj;
                Object obj10 = list5.get(0);
                de deVar = obj10 != null ? (de) obj10 : null;
                deVar.getClass();
                Object obj11 = list5.get(2);
                Integer num = obj11 != null ? (Integer) obj11 : null;
                num.getClass();
                int iIntValue = num.intValue();
                Object obj12 = list5.get(3);
                Integer num2 = obj12 != null ? (Integer) obj12 : null;
                num2.getClass();
                int iIntValue2 = num2.intValue();
                Object obj13 = list5.get(4);
                String str3 = obj13 != null ? (String) obj13 : null;
                str3.getClass();
                switch (deVar.ordinal()) {
                    case 0:
                        Object obj14 = list5.get(1);
                        q91 q91Var2 = wa2.g;
                        if (!g31.a(obj14, Boolean.FALSE) && obj14 != null) {
                            eu1Var = (eu1) ((hq0) q91Var2.c).j(obj14);
                        }
                        eu1Var.getClass();
                        aeVar = new ae(eu1Var, iIntValue, iIntValue2, str3);
                        break;
                    case 1:
                        Object obj15 = list5.get(1);
                        q91 q91Var3 = wa2.h;
                        if (!g31.a(obj15, Boolean.FALSE) && obj15 != null) {
                            hp2Var = (hp2) ((hq0) q91Var3.c).j(obj15);
                        }
                        hp2Var.getClass();
                        aeVar = new ae(hp2Var, iIntValue, iIntValue2, str3);
                        break;
                    case 2:
                        Object obj16 = list5.get(1);
                        q91 q91Var4 = wa2.c;
                        if (!g31.a(obj16, Boolean.FALSE) && obj16 != null) {
                            a73Var = (a73) ((hq0) q91Var4.c).j(obj16);
                        }
                        a73Var.getClass();
                        aeVar = new ae(a73Var, iIntValue, iIntValue2, str3);
                        break;
                    case 3:
                        Object obj17 = list5.get(1);
                        q91 q91Var5 = wa2.d;
                        if (!g31.a(obj17, Boolean.FALSE) && obj17 != null) {
                            m53Var = (m53) ((hq0) q91Var5.c).j(obj17);
                        }
                        m53Var.getClass();
                        aeVar = new ae(m53Var, iIntValue, iIntValue2, str3);
                        break;
                    case 4:
                        Object obj18 = list5.get(1);
                        q91 q91Var6 = wa2.e;
                        if (!g31.a(obj18, Boolean.FALSE) && obj18 != null) {
                            jc1Var = (jc1) ((hq0) q91Var6.c).j(obj18);
                        }
                        jc1Var.getClass();
                        aeVar = new ae(jc1Var, iIntValue, iIntValue2, str3);
                        break;
                    case 5:
                        Object obj19 = list5.get(1);
                        q91 q91Var7 = wa2.f;
                        if (!g31.a(obj19, Boolean.FALSE) && obj19 != null) {
                            ic1Var = (ic1) ((hq0) q91Var7.c).j(obj19);
                        }
                        ic1Var.getClass();
                        aeVar = new ae(ic1Var, iIntValue, iIntValue2, str3);
                        break;
                    case 6:
                        Object obj20 = list5.get(1);
                        String str4 = obj20 != null ? (String) obj20 : null;
                        str4.getClass();
                        aeVar = new ae(new bs2(str4), iIntValue, iIntValue2, str3);
                        break;
                    default:
                        dk0.l();
                        return null;
                }
                return aeVar;
            case 8:
                obj.getClass();
                return new zb1(((Integer) obj).intValue());
            case 9:
                String str5 = obj != null ? (String) obj : null;
                str5.getClass();
                return new a73(str5);
            case 10:
                String str6 = obj != null ? (String) obj : null;
                str6.getClass();
                return new m53(str6);
            case 11:
                obj.getClass();
                List list6 = (List) obj;
                Object obj21 = list6.get(0);
                va2 va2Var4 = wa2.q;
                Boolean bool2 = Boolean.FALSE;
                g31.a(obj21, bool2);
                vw2 vw2Var = obj21 != null ? (vw2) va2Var4.b.j(obj21) : null;
                vw2Var.getClass();
                int i4 = vw2Var.a;
                Object obj22 = list6.get(1);
                va2 va2Var5 = wa2.r;
                g31.a(obj22, bool2);
                vx2 vx2Var = obj22 != null ? (vx2) va2Var5.b.j(obj22) : null;
                vx2Var.getClass();
                int i5 = vx2Var.a;
                Object obj23 = list6.get(2);
                c03[] c03VarArr = b03.b;
                va2 va2Var6 = wa2.v;
                g31.a(obj23, bool2);
                b03 b03Var = obj23 != null ? (b03) va2Var6.b.j(obj23) : null;
                b03Var.getClass();
                long j = b03Var.a;
                Object obj24 = list6.get(3);
                wy2 wy2Var = wy2.c;
                wy2 wy2Var2 = (g31.a(obj24, bool2) || obj24 == null) ? null : (wy2) ((hq0) wa2.l.c).j(obj24);
                Object obj25 = list6.get(4);
                nx1 nx1Var = (g31.a(obj25, bool2) || obj25 == null) ? null : (nx1) ((hq0) g44.a.c).j(obj25);
                Object obj26 = list6.get(5);
                bc1 bc1Var = bc1.d;
                bc1 bc1Var2 = (g31.a(obj26, bool2) || obj26 == null) ? null : (bc1) ((hq0) wa2.A.c).j(obj26);
                Object obj27 = list6.get(6);
                wb1 wb1Var = (g31.a(obj27, bool2) || obj27 == null) ? null : (wb1) ((hq0) g44.c.c).j(obj27);
                wb1Var.getClass();
                int i6 = wb1Var.a;
                Object obj28 = list6.get(7);
                va2 va2Var7 = wa2.s;
                g31.a(obj28, bool2);
                iy0 iy0Var = obj28 != null ? (iy0) va2Var7.b.j(obj28) : null;
                iy0Var.getClass();
                int i7 = iy0Var.a;
                Object obj29 = list6.get(8);
                boolean zA = g31.a(obj29, bool2);
                q91 q91Var8 = g44.d;
                if (!zA && obj29 != null) {
                    lz2Var = (lz2) ((hq0) q91Var8.c).j(obj29);
                }
                return new eu1(i4, i5, j, wy2Var2, nx1Var, bc1Var2, i6, i7, lz2Var);
            case 12:
                obj.getClass();
                List list7 = (List) obj;
                Object obj30 = list7.get(0);
                int i8 = sz.h;
                Boolean bool3 = Boolean.FALSE;
                g31.a(obj30, bool3);
                sz szVar = obj30 != null ? obj30.equals(bool3) ? new sz(sz.g) : new sz(ki4.b(((Integer) obj30).intValue())) : null;
                szVar.getClass();
                long j2 = szVar.a;
                Object obj31 = list7.get(1);
                c03[] c03VarArr2 = b03.b;
                hq0 hq0Var = wa2.v.b;
                g31.a(obj31, bool3);
                b03 b03Var2 = obj31 != null ? (b03) hq0Var.j(obj31) : null;
                b03Var2.getClass();
                long j3 = b03Var2.a;
                Object obj32 = list7.get(2);
                np0 np0Var = np0.b;
                np0 np0Var2 = (g31.a(obj32, bool3) || obj32 == null) ? null : (np0) ((hq0) wa2.m.c).j(obj32);
                Object obj33 = list7.get(3);
                lp0 lp0Var = (g31.a(obj33, bool3) || obj33 == null) ? null : (lp0) ((hq0) wa2.t.c).j(obj33);
                Object obj34 = list7.get(4);
                mp0 mp0Var = (g31.a(obj34, bool3) || obj34 == null) ? null : (mp0) ((hq0) wa2.u.c).j(obj34);
                Object obj35 = list7.get(6);
                String str7 = obj35 != null ? (String) obj35 : null;
                Object obj36 = list7.get(7);
                g31.a(obj36, bool3);
                b03 b03Var3 = obj36 != null ? (b03) hq0Var.j(obj36) : null;
                b03Var3.getClass();
                long j4 = b03Var3.a;
                Object obj37 = list7.get(8);
                rk rkVar = (g31.a(obj37, bool3) || obj37 == null) ? null : (rk) ((hq0) wa2.n.c).j(obj37);
                Object obj38 = list7.get(9);
                vy2 vy2Var = (g31.a(obj38, bool3) || obj38 == null) ? null : (vy2) ((hq0) wa2.k.c).j(obj38);
                Object obj39 = list7.get(10);
                ne1 ne1Var = ne1.c;
                ne1 ne1Var2 = (g31.a(obj39, bool3) || obj39 == null) ? null : (ne1) ((hq0) wa2.y.c).j(obj39);
                Object obj40 = list7.get(11);
                g31.a(obj40, bool3);
                sz szVar2 = obj40 != null ? obj40.equals(bool3) ? new sz(sz.g) : new sz(ki4.b(((Integer) obj40).intValue())) : null;
                szVar2.getClass();
                long j5 = szVar2.a;
                Object obj41 = list7.get(12);
                sx2 sx2Var = (g31.a(obj41, bool3) || obj41 == null) ? null : (sx2) ((hq0) wa2.j.c).j(obj41);
                Object obj42 = list7.get(13);
                vj2 vj2Var2 = vj2.d;
                q91 q91Var9 = wa2.o;
                if (!g31.a(obj42, bool3) && obj42 != null) {
                    vj2Var = (vj2) ((hq0) q91Var9.c).j(obj42);
                }
                return new hp2(j2, j3, np0Var2, lp0Var, mp0Var, (ev2) null, str7, j4, rkVar, vy2Var, ne1Var2, j5, sx2Var, vj2Var, 49184);
            case 13:
                obj.getClass();
                List list8 = (List) obj;
                Object obj43 = list8.get(0);
                Boolean bool4 = obj43 != null ? (Boolean) obj43 : null;
                bool4.getClass();
                boolean zBooleanValue = bool4.booleanValue();
                Object obj44 = list8.get(1);
                boolean zA2 = g31.a(obj44, Boolean.FALSE);
                q91 q91Var10 = g44.b;
                if (!zA2 && obj44 != null) {
                    ai0Var = (ai0) ((hq0) q91Var10.c).j(obj44);
                }
                ai0Var.getClass();
                return new nx1(ai0Var.a, zBooleanValue);
            case 14:
                obj.getClass();
                return new ai0(((Integer) obj).intValue());
            case 15:
                obj.getClass();
                return new wb1(((Integer) obj).intValue());
            case 16:
                obj.getClass();
                List list9 = (List) obj;
                Object obj45 = list9.get(0);
                kz2 kz2Var = (g31.a(obj45, Boolean.FALSE) || obj45 == null) ? null : (kz2) ((hq0) g44.e.c).j(obj45);
                kz2Var.getClass();
                int i9 = kz2Var.a;
                Object obj46 = list9.get(1);
                Boolean bool5 = obj46 != null ? (Boolean) obj46 : null;
                bool5.getClass();
                return new lz2(i9, bool5.booleanValue());
            case 17:
                obj.getClass();
                return new kz2(((Integer) obj).intValue());
            case 18:
                ob2 ob2Var = (ob2) obj;
                ob2Var.getClass();
                String str8 = ob2Var.b;
                String str9 = ob2Var.a;
                Rect rect = ob2Var.d;
                return str8 + ":" + str9 + ":" + rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom + ":" + ob2Var.f;
            case 19:
                Byte b = (Byte) obj;
                b.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b}, 1));
            case 20:
                gp1 gp1Var = (gp1) obj;
                gp1Var.getClass();
                return cs2.V(gp1Var.a).toString();
            case 21:
                return new md2(((Integer) obj).intValue());
            case 22:
                return Boolean.valueOf(!false);
            case 23:
                CharSequence charSequence = (CharSequence) obj;
                if (charSequence == null || (string = charSequence.toString()) == null || (string2 = cs2.V(string).toString()) == null || cs2.A(string2)) {
                    return null;
                }
                return string2;
            case 24:
                jp1 jp1Var = (jp1) obj;
                long j6 = jp1Var.a;
                return (9223372034707292159L & j6) != 9205357640488583168L ? new sd(Float.intBitsToFloat((int) (j6 >> 32)), Float.intBitsToFloat((int) (jp1Var.a & 4294967295L))) : zf2.a;
            case 25:
                sd sdVar = (sd) obj;
                return new jp1((((long) Float.floatToRawIntBits(sdVar.a)) << 32) | (((long) Float.floatToRawIntBits(sdVar.b)) & 4294967295L));
            case 26:
                return Boolean.valueOf(obj == null);
            case 27:
                oi2 oi2Var = (oi2) obj;
                oi2Var.getClass();
                return oi2Var.b;
            case 28:
                yl2 yl2Var = (yl2) obj;
                yl2Var.getClass();
                String str10 = yl2Var.d;
                if (cs2.A(str10) || (accessibilityNodeInfo = yl2Var.f) == null) {
                    return null;
                }
                String str11 = yl2Var.a;
                int i10 = yl2Var.b;
                String str12 = yl2Var.c;
                String str13 = yl2Var.e;
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (viewIdResourceName == null) {
                    viewIdResourceName = "";
                }
                ArrayList arrayList2 = yl2Var.g;
                if (!arrayList2.isEmpty()) {
                    int size2 = arrayList2.size();
                    int i11 = 0;
                    while (i11 < size2) {
                        Object obj47 = arrayList2.get(i11);
                        i11++;
                        if (g31.a((String) obj47, str10) && (i = i + 1) < 0) {
                            nz.m();
                            throw null;
                        }
                    }
                }
                return new am2(str11, i10, str12, str10, str13, viewIdResourceName, i);
            default:
                sa2 sa2Var = im2.a;
                return q43.a;
        }
    }
}
