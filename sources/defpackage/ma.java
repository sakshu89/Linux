package defpackage;

import android.graphics.Typeface;
import android.os.LocaleList;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.ScaleXSpan;
import com.ibm.icu.text.DateTimePatternGenerator;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ma implements cu1 {
    public final String a;
    public final yz2 b;
    public final List c;
    public final List e;
    public final qo0 f;
    public final jc0 i;
    public final lc j;
    public final CharSequence k;
    public final c71 n;
    public b13 s;
    public final boolean t;
    public final int u;

    /* JADX WARN: Code duplicated, block: B:15:0x0071  */
    /* JADX WARN: Code duplicated, block: B:184:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:186:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:187:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:18:0x0076  */
    /* JADX WARN: Code duplicated, block: B:190:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:191:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:197:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:204:0x0402  */
    /* JADX WARN: Code duplicated, block: B:205:0x0404  */
    /* JADX WARN: Code duplicated, block: B:207:0x0408  */
    /* JADX WARN: Code duplicated, block: B:210:0x0416  */
    /* JADX WARN: Code duplicated, block: B:213:0x041d  */
    /* JADX WARN: Code duplicated, block: B:215:0x0425  */
    /* JADX WARN: Code duplicated, block: B:220:0x043b  */
    /* JADX WARN: Code duplicated, block: B:221:0x043e  */
    /* JADX WARN: Code duplicated, block: B:224:0x0444  */
    /* JADX WARN: Code duplicated, block: B:225:0x0447  */
    /* JADX WARN: Code duplicated, block: B:229:0x0462  */
    /* JADX WARN: Code duplicated, block: B:231:0x0474  */
    /* JADX WARN: Code duplicated, block: B:233:0x047e  */
    /* JADX WARN: Code duplicated, block: B:235:0x0484  */
    /* JADX WARN: Code duplicated, block: B:241:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:242:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:244:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:245:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:248:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:249:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:251:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:252:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:256:0x0511  */
    /* JADX WARN: Code duplicated, block: B:258:0x051d  */
    /* JADX WARN: Code duplicated, block: B:260:0x0524  */
    /* JADX WARN: Code duplicated, block: B:267:0x0533  */
    /* JADX WARN: Code duplicated, block: B:271:0x053f  */
    /* JADX WARN: Code duplicated, block: B:280:0x0550  */
    /* JADX WARN: Code duplicated, block: B:283:0x058a  */
    /* JADX WARN: Code duplicated, block: B:285:0x0590  */
    /* JADX WARN: Code duplicated, block: B:288:0x059e  */
    /* JADX WARN: Code duplicated, block: B:290:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:292:0x05ce A[LOOP:8: B:291:0x05cc->B:292:0x05ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:295:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:297:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:299:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:301:0x05f4  */
    /* JADX WARN: Code duplicated, block: B:302:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:304:0x0603  */
    /* JADX WARN: Code duplicated, block: B:306:0x0617  */
    /* JADX WARN: Code duplicated, block: B:315:0x063b  */
    /* JADX WARN: Code duplicated, block: B:320:0x0656  */
    /* JADX WARN: Code duplicated, block: B:322:0x0662  */
    /* JADX WARN: Code duplicated, block: B:324:0x0668  */
    /* JADX WARN: Code duplicated, block: B:329:0x0676  */
    /* JADX WARN: Code duplicated, block: B:383:0x07b7  */
    /* JADX WARN: Code duplicated, block: B:385:0x07be  */
    /* JADX WARN: Code duplicated, block: B:387:0x07cc  */
    /* JADX WARN: Code duplicated, block: B:389:0x07d2  */
    /* JADX WARN: Code duplicated, block: B:394:0x07e0  */
    /* JADX WARN: Code duplicated, block: B:408:0x0831  */
    /* JADX WARN: Code duplicated, block: B:410:0x0842  */
    /* JADX WARN: Code duplicated, block: B:411:0x0846  */
    /* JADX WARN: Code duplicated, block: B:413:0x0851  */
    /* JADX WARN: Code duplicated, block: B:416:0x085b A[LOOP:6: B:415:0x0859->B:416:0x085b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:419:0x086c  */
    /* JADX WARN: Code duplicated, block: B:421:0x0877  */
    /* JADX WARN: Code duplicated, block: B:423:0x0885 A[LOOP:7: B:422:0x0883->B:423:0x0885, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:426:0x0892  */
    /* JADX WARN: Code duplicated, block: B:430:0x08a4  */
    /* JADX WARN: Code duplicated, block: B:442:0x0536 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:458:0x062a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:421:0x0877, please report this as an issue */
    public ma(String str, yz2 yz2Var, List list, List list2, qo0 qo0Var, jc0 jc0Var) {
        boolean zBooleanValue;
        Locale locale;
        int i;
        Object obj;
        Typeface typeface;
        CharSequence charSequence;
        Spannable spannableString;
        hp2 hp2Var;
        eu1 eu1Var;
        cy1 cy1Var;
        boolean z;
        bc1 bc1Var;
        float fA;
        int length;
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        wy2 wy2Var;
        ArrayList arrayList;
        int size;
        int i4;
        hp2 hp2Var2;
        ev2 ev2Var;
        hp2 hp2Var3;
        t50 t50Var;
        int size2;
        int i5;
        int[] iArr;
        int size3;
        int i6;
        int i7;
        int i8;
        int i9;
        int size4;
        hp2 hp2VarC;
        int i10;
        ArrayList arrayList2;
        hp2 hp2Var4;
        int i11;
        int i12;
        int i13;
        int size5;
        boolean z4;
        int i14;
        jc0 jc0Var2;
        jc0 jc0Var3;
        wy2 wy2Var2;
        int size6;
        int i15;
        ae aeVar;
        int i16;
        long j;
        long jB;
        int size7;
        int i17;
        ae aeVar2;
        xd xdVar;
        jc0 jc0Var4;
        int i18;
        Object ya1Var;
        ae aeVar3;
        Object obj2;
        eu1 eu1Var2;
        int i19;
        int i20;
        int i21;
        ae aeVar4;
        Object obj3;
        hp2 hp2Var5;
        int i22;
        long j2;
        long j3;
        long jB2;
        float fC;
        long jB3;
        float fC2;
        nx1 nx1Var;
        CharSequence charSequence2;
        nx1 nx1Var2;
        this.a = str;
        this.b = yz2Var;
        this.c = list;
        this.e = list2;
        this.f = qo0Var;
        this.i = jc0Var;
        float fB = jc0Var.b();
        lc lcVar = new lc(1);
        ((TextPaint) lcVar).density = fB;
        lcVar.b = sx2.b;
        lcVar.c = 3;
        lcVar.d = vj2.d;
        this.j = lcVar;
        boolean zA = nd4.a(yz2Var);
        hp2 hp2Var6 = yz2Var.a;
        eu1 eu1Var3 = yz2Var.b;
        if (zA) {
            q82 q82Var = rh0.a;
            q82 q82Var2 = rh0.a;
            gr2 gr2VarC = (gr2) q82Var2.a;
            if (gr2VarC == null) {
                if (oh0.d()) {
                    gr2VarC = q82Var2.C();
                    q82Var2.a = gr2VarC;
                } else {
                    gr2VarC = cz3.a;
                }
            }
            zBooleanValue = ((Boolean) gr2VarC.getValue()).booleanValue();
        } else {
            zBooleanValue = false;
        }
        this.t = zBooleanValue;
        int i23 = eu1Var3.b;
        ne1 ne1Var = hp2Var6.k;
        if (i23 == 4) {
            i = 2;
        } else if (i23 == 5) {
            i = 3;
        } else if (i23 == 1) {
            i = 0;
        } else if (i23 == 2) {
            i = 1;
        } else {
            if (i23 != 3 && i23 != 0) {
                og.n("Invalid TextDirection.");
                throw null;
            }
            int layoutDirectionFromLocale = TextUtils.getLayoutDirectionFromLocale((ne1Var == null || (locale = ((me1) ne1Var.a.get(0)).a) == null) ? Locale.getDefault() : locale);
            if (layoutDirectionFromLocale == 0 || layoutDirectionFromLocale != 1) {
                i = 2;
            } else {
                i = 3;
            }
        }
        this.u = i;
        la laVar = new la(this);
        lz2 lz2Var = eu1Var3.i;
        lz2Var = lz2Var == null ? lz2.c : lz2Var;
        lcVar.setFlags(lz2Var.b ? lcVar.getFlags() | 128 : lcVar.getFlags() & (-129));
        int i24 = lz2Var.a;
        if (i24 == 1) {
            lcVar.setFlags(lcVar.getFlags() | 64);
            lcVar.setHinting(0);
        } else if (i24 == 2) {
            lcVar.getFlags();
            lcVar.setHinting(1);
        } else if (i24 == 3) {
            lcVar.getFlags();
            lcVar.setHinting(0);
        } else {
            lcVar.getFlags();
        }
        int size8 = list.size();
        int i25 = 0;
        while (true) {
            if (i25 >= size8) {
                obj = null;
                break;
            }
            obj = list.get(i25);
            if (((ae) obj).a instanceof hp2) {
                break;
            } else {
                i25++;
            }
        }
        boolean z5 = obj != null;
        long j4 = hp2Var6.b;
        np0 np0Var = hp2Var6.c;
        lp0 lp0Var = hp2Var6.d;
        String str2 = hp2Var6.g;
        ne1 ne1Var2 = hp2Var6.k;
        uy2 uy2Var = hp2Var6.a;
        vy2 vy2Var = hp2Var6.j;
        long j5 = hp2Var6.h;
        long jB4 = b03.b(j4);
        boolean z6 = z5;
        if (c03.a(jB4, 4294967296L)) {
            lcVar.setTextSize(jc0Var.d0(j4));
        } else if (c03.a(jB4, 8589934592L)) {
            lcVar.setTextSize(b03.c(j4) * lcVar.getTextSize());
        }
        ev2 ev2Var2 = hp2Var6.f;
        if (ev2Var2 != null || lp0Var != null || np0Var != null) {
            np0 np0Var2 = np0Var == null ? np0.c : np0Var;
            int i26 = lp0Var != null ? lp0Var.a : 0;
            mp0 mp0Var = hp2Var6.e;
            int i27 = mp0Var != null ? mp0Var.a : DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
            ma maVar = laVar.a;
            t33 t33VarB = ((ro0) maVar.f).b(ev2Var2, np0Var2, i26, i27);
            if (t33VarB instanceof t33) {
                Object obj4 = t33VarB.a;
                obj4.getClass();
                typeface = (Typeface) obj4;
            } else {
                b13 b13Var = new b13(t33VarB, maVar.s);
                maVar.s = b13Var;
                Object obj5 = b13Var.c;
                obj5.getClass();
                typeface = (Typeface) obj5;
            }
            lcVar.setTypeface(typeface);
        }
        if (ne1Var2 != null) {
            ne1 ne1Var3 = ne1.c;
            if (!ne1Var2.equals(gx1.a.n())) {
                ArrayList arrayList3 = new ArrayList(nz.d(ne1Var2));
                Iterator it = ne1Var2.a.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((me1) it.next()).a);
                }
                Locale[] localeArr = (Locale[]) arrayList3.toArray(new Locale[0]);
                lcVar.setTextLocales(new LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
            }
        }
        if (str2 != null && !str2.equals("")) {
            lcVar.setFontFeatureSettings(str2);
        }
        if (vy2Var != null && !vy2Var.equals(vy2.c)) {
            lcVar.setTextScaleX(lcVar.getTextScaleX() * vy2Var.a);
            lcVar.setTextSkewX(lcVar.getTextSkewX() + vy2Var.b);
        }
        lcVar.d(uy2Var.c());
        lcVar.c(uy2Var.d(), 9205357640488583168L, uy2Var.a());
        lcVar.f(hp2Var6.n);
        lcVar.g(hp2Var6.m);
        lcVar.e(hp2Var6.o);
        if (c03.a(b03.b(j5), 4294967296L) && b03.c(j5) != 0.0f) {
            float textScaleX = lcVar.getTextScaleX() * lcVar.getTextSize();
            float fD0 = jc0Var.d0(j5);
            if (textScaleX != 0.0f) {
                lcVar.setLetterSpacing(fD0 / textScaleX);
            }
        } else if (c03.a(b03.b(j5), 8589934592L)) {
            lcVar.setLetterSpacing(b03.c(j5));
        }
        long j6 = hp2Var6.l;
        rk rkVar = hp2Var6.i;
        boolean z7 = z6 && c03.a(b03.b(j5), 4294967296L) && b03.c(j5) != 0.0f;
        long j7 = sz.g;
        boolean z8 = (sz.c(j6, j7) || sz.c(j6, sz.f)) ? false : true;
        boolean z9 = (rkVar == null || Float.compare(rkVar.a, 0.0f) == 0) ? false : true;
        hp2 hp2Var7 = (z7 || z8 || z9) ? new hp2(0L, 0L, (np0) null, (lp0) null, (mp0) null, (ev2) null, (String) null, z7 ? j5 : b03.c, z9 ? rkVar : null, (vy2) null, (ne1) null, z8 ? j6 : j7, (sx2) null, (vj2) null, 63103) : null;
        List list3 = this.c;
        if (hp2Var7 != null) {
            int size9 = list3.size() + 1;
            ArrayList arrayList4 = new ArrayList(size9);
            int i28 = 0;
            while (i28 < size9) {
                arrayList4.add(i28 == 0 ? new ae(hp2Var7, 0, this.a.length()) : (ae) this.c.get(i28 - 1));
                i28++;
            }
            list3 = arrayList4;
        }
        String str3 = this.a;
        float textSize = this.j.getTextSize();
        yz2 yz2Var2 = this.b;
        List list4 = this.e;
        jc0 jc0Var5 = this.i;
        boolean z10 = this.t;
        ja jaVar = ka.a;
        if (z10 && oh0.d()) {
            cy1 cy1Var2 = yz2Var2.c;
            ai0 ai0Var = (cy1Var2 == null || (nx1Var2 = cy1Var2.a) == null) ? null : new ai0(nx1Var2.b);
            CharSequence charSequenceG = oh0.a().g(str3, 0, str3.length(), (ai0Var != null && ai0Var.a == 2) ? 1 : 0);
            charSequenceG.getClass();
            charSequence = charSequenceG;
        } else {
            charSequence = str3;
        }
        if (list3.isEmpty() && list4.isEmpty() && g31.a(yz2Var2.b.d, wy2.c)) {
            charSequence2 = charSequence;
            if ((yz2Var2.b.c & 1095216660480L) != 0) {
                if (charSequence instanceof Spannable) {
                    spannableString = (Spannable) charSequence;
                } else {
                    spannableString = new SpannableString(charSequence);
                }
                hp2Var = yz2Var2.a;
                eu1Var = yz2Var2.b;
                if (g31.a(hp2Var.m, sx2.c)) {
                    spannableString.setSpan(ka.a, 0, str3.length(), 33);
                }
                cy1Var = yz2Var2.c;
                if (cy1Var != null) {
                    z = false;
                } else {
                    z = false;
                }
                if (z) {
                    bc1Var = eu1Var.f;
                    if (bc1Var == null) {
                    }
                    fA = m54.a(eu1Var.c, textSize, jc0Var5);
                    if (Float.isNaN(fA)) {
                        i3 = 0;
                    } else {
                        if (spannableString.length() == 0) {
                            length = spannableString.length() + 1;
                        } else {
                            length = spannableString.length();
                        }
                        int i29 = length;
                        i2 = bc1Var.b;
                        if ((i2 & 1) > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if ((i2 & 16) > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        i3 = 0;
                        spannableString.setSpan(new cc1(fA, i29, z2, z3, bc1Var.a, bc1Var.c), 0, spannableString.length(), 33);
                    }
                } else {
                    bc1Var = eu1Var.f;
                    if (bc1Var == null) {
                    }
                    fA = m54.a(eu1Var.c, textSize, jc0Var5);
                    if (Float.isNaN(fA)) {
                        if (spannableString.length() == 0) {
                            length = spannableString.length() + 1;
                        } else {
                            length = spannableString.length();
                        }
                        int i210 = length;
                        i2 = bc1Var.b;
                        if ((i2 & 1) > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if ((i2 & 16) > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        i3 = 0;
                        spannableString.setSpan(new cc1(fA, i210, z2, z3, bc1Var.a, bc1Var.c), 0, spannableString.length(), 33);
                    } else {
                        i3 = 0;
                    }
                }
                wy2Var = eu1Var.d;
                if (wy2Var != null) {
                    i22 = i3;
                    j2 = wy2Var.a;
                    j3 = wy2Var.b;
                    if (b03.a(j2, nc4.c(i22))) {
                        jB2 = b03.b(j2);
                        if (c03.a(jB2, 4294967296L)) {
                            fC = jc0Var5.d0(j2);
                        } else if (c03.a(jB2, 8589934592L)) {
                            fC = b03.c(j2) * textSize;
                        } else {
                            fC = 0.0f;
                        }
                        jB3 = b03.b(j3);
                        if (c03.a(jB3, 4294967296L)) {
                            fC2 = jc0Var5.d0(j3);
                        } else if (c03.a(jB3, 8589934592L)) {
                            fC2 = b03.c(j3) * textSize;
                        } else {
                            fC2 = 0.0f;
                        }
                        spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fC), (int) Math.ceil(fC2)), 0, spannableString.length(), 33);
                    } else {
                        jB2 = b03.b(j2);
                        if (c03.a(jB2, 4294967296L)) {
                            fC = jc0Var5.d0(j2);
                        } else if (c03.a(jB2, 8589934592L)) {
                            fC = b03.c(j2) * textSize;
                        } else {
                            fC = 0.0f;
                        }
                        jB3 = b03.b(j3);
                        if (c03.a(jB3, 4294967296L)) {
                            fC2 = jc0Var5.d0(j3);
                        } else if (c03.a(jB3, 8589934592L)) {
                            fC2 = b03.c(j3) * textSize;
                        } else {
                            fC2 = 0.0f;
                        }
                        spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fC), (int) Math.ceil(fC2)), 0, spannableString.length(), 33);
                    }
                }
                arrayList = new ArrayList(list3.size());
                size = list3.size();
                for (i4 = 0; i4 < size; i4++) {
                    aeVar4 = (ae) list3.get(i4);
                    obj3 = aeVar4.a;
                    if (obj3 instanceof hp2) {
                        hp2Var5 = (hp2) obj3;
                        if (hp2Var5.f == null) {
                            arrayList.add(aeVar4);
                        } else {
                            arrayList.add(aeVar4);
                        }
                    }
                }
                hp2Var2 = yz2Var2.a;
                ev2Var = hp2Var2.f;
                if (ev2Var != null) {
                    hp2Var3 = new hp2(0L, 0L, hp2Var2.c, hp2Var2.d, hp2Var2.e, ev2Var, (String) null, 0L, (rk) null, (vy2) null, (ne1) null, 0L, (sx2) null, (vj2) null, 65475);
                } else {
                    hp2Var3 = new hp2(0L, 0L, hp2Var2.c, hp2Var2.d, hp2Var2.e, ev2Var, (String) null, 0L, (rk) null, (vy2) null, (ne1) null, 0L, (sx2) null, (vj2) null, 65475);
                }
                t50Var = new t50(4, spannableString, laVar);
                if (arrayList.size() > 1) {
                    size2 = arrayList.size();
                    i5 = size2 * 2;
                    iArr = new int[i5];
                    size3 = arrayList.size();
                    for (i6 = 0; i6 < size3; i6++) {
                        ae aeVar5 = (ae) arrayList.get(i6);
                        iArr[i6] = aeVar5.b;
                        iArr[i6 + size2] = aeVar5.c;
                    }
                    if (i5 > 1) {
                        Arrays.sort(iArr);
                    }
                    if (i5 == 0) {
                        kf2.g("Array is empty.");
                        throw null;
                    }
                    i7 = iArr[0];
                    i8 = 0;
                    while (i8 < i5) {
                        i9 = iArr[i8];
                        if (i9 == i7) {
                            arrayList2 = arrayList;
                            hp2Var4 = hp2Var3;
                            i11 = i8;
                        } else {
                            size4 = arrayList.size();
                            hp2VarC = hp2Var3;
                            i10 = 0;
                            while (i10 < size4) {
                                ArrayList arrayList5 = arrayList;
                                ae aeVar6 = (ae) arrayList.get(i10);
                                hp2 hp2Var8 = hp2Var3;
                                i12 = aeVar6.b;
                                int i30 = i8;
                                i13 = aeVar6.c;
                                if (i12 == i13) {
                                }
                                i10++;
                                arrayList = arrayList5;
                                hp2Var3 = hp2Var8;
                                i8 = i30;
                            }
                            arrayList2 = arrayList;
                            hp2Var4 = hp2Var3;
                            i11 = i8;
                            if (hp2VarC != null) {
                                t50Var.c(hp2VarC, Integer.valueOf(i7), Integer.valueOf(i9));
                            }
                            i7 = i9;
                        }
                        i8 = i11 + 1;
                        arrayList = arrayList2;
                        hp2Var3 = hp2Var4;
                    }
                } else if (!arrayList.isEmpty()) {
                    hp2 hp2Var9 = (hp2) ((ae) arrayList.get(0)).a;
                    t50Var.c(hp2Var3 != null ? hp2Var3.c(hp2Var9) : hp2Var9, Integer.valueOf(((ae) arrayList.get(0)).b), Integer.valueOf(((ae) arrayList.get(0)).c));
                }
                size5 = list3.size();
                z4 = false;
                i14 = 0;
                while (i14 < size5) {
                    aeVar3 = (ae) list3.get(i14);
                    obj2 = aeVar3.a;
                    if (obj2 instanceof hp2) {
                        i19 = aeVar3.b;
                        int i31 = aeVar3.c;
                        if (i19 >= 0) {
                            size5 = size5;
                            i14 = i14;
                            eu1Var2 = eu1Var;
                            z4 = z4;
                        } else {
                            size5 = size5;
                            i14 = i14;
                            eu1Var2 = eu1Var;
                            z4 = z4;
                        }
                    } else {
                        size5 = size5;
                        i14 = i14;
                        eu1Var2 = eu1Var;
                        z4 = z4;
                    }
                    i14++;
                    eu1Var = eu1Var2;
                    jc0Var5 = jc0Var5;
                    size5 = size5;
                }
                jc0Var2 = jc0Var5;
                eu1 eu1Var4 = eu1Var;
                if (z4) {
                    size7 = list3.size();
                    i17 = 0;
                    while (i17 < size7) {
                        aeVar2 = (ae) list3.get(i17);
                        xdVar = (xd) aeVar2.a;
                        if (xdVar instanceof hp2) {
                            i18 = aeVar2.b;
                            int i32 = aeVar2.c;
                            if (i18 >= 0) {
                                jc0Var4 = jc0Var2;
                            } else {
                                jc0Var4 = jc0Var2;
                            }
                        } else {
                            jc0Var4 = jc0Var2;
                        }
                        i17++;
                        jc0Var2 = jc0Var4;
                    }
                }
                jc0Var3 = jc0Var2;
                wy2Var2 = eu1Var4.d;
                if (wy2Var2 != null) {
                    j = wy2Var2.a;
                    jB = b03.b(j);
                    if (c03.a(jB, 4294967296L)) {
                        jc0Var3.d0(j);
                    } else if (c03.a(jB, 8589934592L)) {
                        b03.c(j);
                    }
                }
                size6 = list3.size();
                for (i15 = 0; i15 < size6; i15++) {
                    Object obj6 = ((ae) list3.get(i15)).a;
                }
                charSequence2 = spannableString;
                if (list4.size() > 0) {
                    aeVar = (ae) list4.get(0);
                    if (aeVar.a != null) {
                        dk0.t();
                        throw null;
                    }
                    for (Object obj7 : spannableString.getSpans(aeVar.b, aeVar.c, r33.class)) {
                        spannableString.removeSpan((r33) obj7);
                    }
                    throw null;
                }
            }
        } else {
            if (charSequence instanceof Spannable) {
                spannableString = (Spannable) charSequence;
            } else {
                spannableString = new SpannableString(charSequence);
            }
            hp2Var = yz2Var2.a;
            eu1Var = yz2Var2.b;
            if (g31.a(hp2Var.m, sx2.c)) {
                spannableString.setSpan(ka.a, 0, str3.length(), 33);
            }
            cy1Var = yz2Var2.c;
            if (cy1Var != null || (nx1Var = cy1Var.a) == null) {
                z = false;
            } else {
                z = nx1Var.a;
            }
            if (z || eu1Var.f != null) {
                bc1Var = eu1Var.f;
                bc1Var = bc1Var == null ? bc1.d : bc1Var;
                fA = m54.a(eu1Var.c, textSize, jc0Var5);
                if (Float.isNaN(fA)) {
                    if (spannableString.length() == 0 && cs2.B(spannableString) != '\n') {
                        length = spannableString.length();
                    } else {
                        length = spannableString.length() + 1;
                    }
                    int i211 = length;
                    i2 = bc1Var.b;
                    if ((i2 & 1) > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if ((i2 & 16) > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    i3 = 0;
                    spannableString.setSpan(new cc1(fA, i211, z2, z3, bc1Var.a, bc1Var.c), 0, spannableString.length(), 33);
                }
                wy2Var = eu1Var.d;
                if (wy2Var != null) {
                    i22 = i3;
                    j2 = wy2Var.a;
                    j3 = wy2Var.b;
                    if ((b03.a(j2, nc4.c(i22)) || !b03.a(j3, nc4.c(i22))) && (j2 & 1095216660480L) != r12 && (j3 & 1095216660480L) != 0) {
                        jB2 = b03.b(j2);
                        if (c03.a(jB2, 4294967296L)) {
                            fC = jc0Var5.d0(j2);
                        } else if (c03.a(jB2, 8589934592L)) {
                            fC = b03.c(j2) * textSize;
                        } else {
                            fC = 0.0f;
                        }
                        jB3 = b03.b(j3);
                        if (c03.a(jB3, 4294967296L)) {
                            fC2 = jc0Var5.d0(j3);
                        } else if (c03.a(jB3, 8589934592L)) {
                            fC2 = b03.c(j3) * textSize;
                        } else {
                            fC2 = 0.0f;
                        }
                        spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fC), (int) Math.ceil(fC2)), 0, spannableString.length(), 33);
                    }
                }
                arrayList = new ArrayList(list3.size());
                size = list3.size();
                while (i4 < size) {
                    aeVar4 = (ae) list3.get(i4);
                    obj3 = aeVar4.a;
                    if (obj3 instanceof hp2) {
                        hp2Var5 = (hp2) obj3;
                        if (hp2Var5.f == null || hp2Var5.d != null || hp2Var5.c != null || ((hp2) obj3).e != null) {
                            arrayList.add(aeVar4);
                        }
                    }
                }
                hp2Var2 = yz2Var2.a;
                ev2Var = hp2Var2.f;
                if (ev2Var != null && hp2Var2.d == null && hp2Var2.c == null && hp2Var2.e == null) {
                    hp2Var3 = null;
                } else {
                    hp2Var3 = new hp2(0L, 0L, hp2Var2.c, hp2Var2.d, hp2Var2.e, ev2Var, (String) null, 0L, (rk) null, (vy2) null, (ne1) null, 0L, (sx2) null, (vj2) null, 65475);
                }
                t50Var = new t50(4, spannableString, laVar);
                if (arrayList.size() > 1) {
                    size2 = arrayList.size();
                    i5 = size2 * 2;
                    iArr = new int[i5];
                    size3 = arrayList.size();
                    while (i6 < size3) {
                        ae aeVar7 = (ae) arrayList.get(i6);
                        iArr[i6] = aeVar7.b;
                        iArr[i6 + size2] = aeVar7.c;
                    }
                    if (i5 > 1) {
                        Arrays.sort(iArr);
                    }
                    if (i5 == 0) {
                        kf2.g("Array is empty.");
                        throw null;
                    }
                    i7 = iArr[0];
                    i8 = 0;
                    while (i8 < i5) {
                        i9 = iArr[i8];
                        if (i9 == i7) {
                            arrayList2 = arrayList;
                            hp2Var4 = hp2Var3;
                            i11 = i8;
                        } else {
                            size4 = arrayList.size();
                            hp2VarC = hp2Var3;
                            i10 = 0;
                            while (i10 < size4) {
                                ArrayList arrayList6 = arrayList;
                                ae aeVar8 = (ae) arrayList.get(i10);
                                hp2 hp2Var10 = hp2Var3;
                                i12 = aeVar8.b;
                                int i33 = i8;
                                i13 = aeVar8.c;
                                if (i12 == i13 && ce.b(i7, i9, i12, i13)) {
                                    hp2 hp2Var11 = (hp2) aeVar8.a;
                                    hp2VarC = hp2VarC != null ? hp2VarC.c(hp2Var11) : hp2Var11;
                                }
                                i10++;
                                arrayList = arrayList6;
                                hp2Var3 = hp2Var10;
                                i8 = i33;
                            }
                            arrayList2 = arrayList;
                            hp2Var4 = hp2Var3;
                            i11 = i8;
                            if (hp2VarC != null) {
                                t50Var.c(hp2VarC, Integer.valueOf(i7), Integer.valueOf(i9));
                            }
                            i7 = i9;
                        }
                        i8 = i11 + 1;
                        arrayList = arrayList2;
                        hp2Var3 = hp2Var4;
                    }
                } else if (!arrayList.isEmpty()) {
                    hp2 hp2Var12 = (hp2) ((ae) arrayList.get(0)).a;
                    t50Var.c(hp2Var3 != null ? hp2Var3.c(hp2Var12) : hp2Var12, Integer.valueOf(((ae) arrayList.get(0)).b), Integer.valueOf(((ae) arrayList.get(0)).c));
                }
                size5 = list3.size();
                z4 = false;
                i14 = 0;
                while (i14 < size5) {
                    aeVar3 = (ae) list3.get(i14);
                    obj2 = aeVar3.a;
                    if (obj2 instanceof hp2) {
                        i19 = aeVar3.b;
                        int i34 = aeVar3.c;
                        if (i19 >= 0 || i19 >= spannableString.length() || i34 <= i19 || i34 > spannableString.length()) {
                            size5 = size5;
                            i14 = i14;
                            eu1Var2 = eu1Var;
                        } else {
                            hp2 hp2Var13 = (hp2) obj2;
                            long j8 = hp2Var13.h;
                            rk rkVar2 = hp2Var13.i;
                            uy2 uy2Var2 = hp2Var13.a;
                            if (rkVar2 != null) {
                                spannableString.setSpan(new sk(rkVar2.a, 0), i19, i34, 33);
                            }
                            m54.b(spannableString, uy2Var2.c(), i19, i34);
                            hn hnVarD = uy2Var2.d();
                            float fA2 = uy2Var2.a();
                            if (hnVarD != null) {
                                if (hnVarD instanceof cn2) {
                                    m54.b(spannableString, ((cn2) hnVarD).a, i19, i34);
                                } else {
                                    spannableString.setSpan(new uj2((tj2) hnVarD, fA2), i19, i34, 33);
                                }
                            }
                            sx2 sx2Var = hp2Var13.m;
                            if (sx2Var != null) {
                                int i35 = sx2Var.a;
                                tx2 tx2Var = new tx2((i35 | 1) == i35, (i35 | 2) == i35);
                                i20 = 33;
                                spannableString.setSpan(tx2Var, i19, i34, 33);
                            } else {
                                i20 = 33;
                            }
                            int i36 = i20;
                            eu1Var2 = eu1Var;
                            m54.c(spannableString, hp2Var13.b, jc0Var5, i19, i34);
                            String str4 = hp2Var13.g;
                            if (str4 != null) {
                                spannableString.setSpan(new to0(0, str4), i19, i34, i36);
                            }
                            vy2 vy2Var2 = hp2Var13.j;
                            if (vy2Var2 != null) {
                                spannableString.setSpan(new ScaleXSpan(vy2Var2.a), i19, i34, i36);
                                spannableString.setSpan(new sk(vy2Var2.b, 1), i19, i34, i36);
                            }
                            m54.d(spannableString, hp2Var13.k, i19, i34);
                            long j9 = hp2Var13.l;
                            if (j9 != 16) {
                                spannableString.setSpan(new BackgroundColorSpan(ki4.g(j9)), i19, i34, i36);
                            }
                            vj2 vj2Var = hp2Var13.n;
                            if (vj2Var != null) {
                                long j10 = vj2Var.b;
                                int iG = ki4.g(vj2Var.a);
                                float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
                                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L));
                                float f = vj2Var.c;
                                xj2 xj2Var = new xj2(iG, fIntBitsToFloat, fIntBitsToFloat2, f == 0.0f ? Float.MIN_VALUE : f);
                                i21 = 33;
                                spannableString.setSpan(xj2Var, i19, i34, 33);
                            } else {
                                i21 = i36;
                            }
                            wm4 wm4Var = hp2Var13.o;
                            if (wm4Var != null) {
                                spannableString.setSpan(new sf0(wm4Var), i19, i34, i21);
                            }
                            z4 = (c03.a(b03.b(j8), 4294967296L) || c03.a(b03.b(j8), 8589934592L)) ? true : z4;
                        }
                        z4 = z4;
                    } else {
                        size5 = size5;
                        i14 = i14;
                        eu1Var2 = eu1Var;
                        z4 = z4;
                    }
                    i14++;
                    eu1Var = eu1Var2;
                    jc0Var5 = jc0Var5;
                    size5 = size5;
                }
                jc0Var2 = jc0Var5;
                eu1 eu1Var5 = eu1Var;
                if (z4) {
                    size7 = list3.size();
                    i17 = 0;
                    while (i17 < size7) {
                        aeVar2 = (ae) list3.get(i17);
                        xdVar = (xd) aeVar2.a;
                        if (xdVar instanceof hp2) {
                            i18 = aeVar2.b;
                            int i37 = aeVar2.c;
                            if (i18 >= 0 || i18 >= spannableString.length() || i37 <= i18 || i37 > spannableString.length()) {
                                jc0Var4 = jc0Var2;
                            } else {
                                long j11 = ((hp2) xdVar).h;
                                long jB5 = b03.b(j11);
                                if (c03.a(jB5, 4294967296L)) {
                                    jc0Var4 = jc0Var2;
                                    ya1Var = new za1(jc0Var4.d0(j11));
                                } else {
                                    jc0Var4 = jc0Var2;
                                    ya1Var = c03.a(jB5, 8589934592L) ? new ya1(b03.c(j11)) : null;
                                }
                                if (ya1Var != null) {
                                    spannableString.setSpan(ya1Var, i18, i37, 33);
                                }
                            }
                        } else {
                            jc0Var4 = jc0Var2;
                        }
                        i17++;
                        jc0Var2 = jc0Var4;
                    }
                }
                jc0Var3 = jc0Var2;
                wy2Var2 = eu1Var5.d;
                if (wy2Var2 != null) {
                    j = wy2Var2.a;
                    jB = b03.b(j);
                    if (c03.a(jB, 4294967296L)) {
                        jc0Var3.d0(j);
                    } else if (c03.a(jB, 8589934592L)) {
                        b03.c(j);
                    }
                }
                size6 = list3.size();
                while (i15 < size6) {
                    Object obj8 = ((ae) list3.get(i15)).a;
                }
                charSequence2 = spannableString;
                if (list4.size() > 0) {
                    aeVar = (ae) list4.get(0);
                    if (aeVar.a != null) {
                        dk0.t();
                        throw null;
                    }
                    while (i16 < r1) {
                        spannableString.removeSpan((r33) obj7);
                    }
                    throw null;
                }
            } else {
                float fA3 = m54.a(eu1Var.c, textSize, jc0Var5);
                if (!Float.isNaN(fA3)) {
                    spannableString.setSpan(new xb1(fA3), 0, spannableString.length(), 33);
                }
            }
            i3 = 0;
            wy2Var = eu1Var.d;
            if (wy2Var != null) {
                i22 = i3;
                j2 = wy2Var.a;
                j3 = wy2Var.b;
                if (b03.a(j2, nc4.c(i22))) {
                    jB2 = b03.b(j2);
                    if (c03.a(jB2, 4294967296L)) {
                        fC = jc0Var5.d0(j2);
                    } else if (c03.a(jB2, 8589934592L)) {
                        fC = b03.c(j2) * textSize;
                    } else {
                        fC = 0.0f;
                    }
                    jB3 = b03.b(j3);
                    if (c03.a(jB3, 4294967296L)) {
                        fC2 = jc0Var5.d0(j3);
                    } else if (c03.a(jB3, 8589934592L)) {
                        fC2 = b03.c(j3) * textSize;
                    } else {
                        fC2 = 0.0f;
                    }
                    spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fC), (int) Math.ceil(fC2)), 0, spannableString.length(), 33);
                } else {
                    jB2 = b03.b(j2);
                    if (c03.a(jB2, 4294967296L)) {
                        fC = jc0Var5.d0(j2);
                    } else if (c03.a(jB2, 8589934592L)) {
                        fC = b03.c(j2) * textSize;
                    } else {
                        fC = 0.0f;
                    }
                    jB3 = b03.b(j3);
                    if (c03.a(jB3, 4294967296L)) {
                        fC2 = jc0Var5.d0(j3);
                    } else if (c03.a(jB3, 8589934592L)) {
                        fC2 = b03.c(j3) * textSize;
                    } else {
                        fC2 = 0.0f;
                    }
                    spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fC), (int) Math.ceil(fC2)), 0, spannableString.length(), 33);
                }
            }
            arrayList = new ArrayList(list3.size());
            size = list3.size();
            while (i4 < size) {
                aeVar4 = (ae) list3.get(i4);
                obj3 = aeVar4.a;
                if (obj3 instanceof hp2) {
                    hp2Var5 = (hp2) obj3;
                    if (hp2Var5.f == null) {
                        arrayList.add(aeVar4);
                    } else {
                        arrayList.add(aeVar4);
                    }
                }
            }
            hp2Var2 = yz2Var2.a;
            ev2Var = hp2Var2.f;
            if (ev2Var != null) {
                hp2Var3 = new hp2(0L, 0L, hp2Var2.c, hp2Var2.d, hp2Var2.e, ev2Var, (String) null, 0L, (rk) null, (vy2) null, (ne1) null, 0L, (sx2) null, (vj2) null, 65475);
            } else {
                hp2Var3 = new hp2(0L, 0L, hp2Var2.c, hp2Var2.d, hp2Var2.e, ev2Var, (String) null, 0L, (rk) null, (vy2) null, (ne1) null, 0L, (sx2) null, (vj2) null, 65475);
            }
            t50Var = new t50(4, spannableString, laVar);
            if (arrayList.size() > 1) {
                size2 = arrayList.size();
                i5 = size2 * 2;
                iArr = new int[i5];
                size3 = arrayList.size();
                while (i6 < size3) {
                    ae aeVar9 = (ae) arrayList.get(i6);
                    iArr[i6] = aeVar9.b;
                    iArr[i6 + size2] = aeVar9.c;
                }
                if (i5 > 1) {
                    Arrays.sort(iArr);
                }
                if (i5 == 0) {
                    kf2.g("Array is empty.");
                    throw null;
                }
                i7 = iArr[0];
                i8 = 0;
                while (i8 < i5) {
                    i9 = iArr[i8];
                    if (i9 == i7) {
                        arrayList2 = arrayList;
                        hp2Var4 = hp2Var3;
                        i11 = i8;
                    } else {
                        size4 = arrayList.size();
                        hp2VarC = hp2Var3;
                        i10 = 0;
                        while (i10 < size4) {
                            ArrayList arrayList7 = arrayList;
                            ae aeVar10 = (ae) arrayList.get(i10);
                            hp2 hp2Var14 = hp2Var3;
                            i12 = aeVar10.b;
                            int i38 = i8;
                            i13 = aeVar10.c;
                            if (i12 == i13) {
                            }
                            i10++;
                            arrayList = arrayList7;
                            hp2Var3 = hp2Var14;
                            i8 = i38;
                        }
                        arrayList2 = arrayList;
                        hp2Var4 = hp2Var3;
                        i11 = i8;
                        if (hp2VarC != null) {
                            t50Var.c(hp2VarC, Integer.valueOf(i7), Integer.valueOf(i9));
                        }
                        i7 = i9;
                    }
                    i8 = i11 + 1;
                    arrayList = arrayList2;
                    hp2Var3 = hp2Var4;
                }
            } else if (!arrayList.isEmpty()) {
                hp2 hp2Var15 = (hp2) ((ae) arrayList.get(0)).a;
                t50Var.c(hp2Var3 != null ? hp2Var3.c(hp2Var15) : hp2Var15, Integer.valueOf(((ae) arrayList.get(0)).b), Integer.valueOf(((ae) arrayList.get(0)).c));
            }
            size5 = list3.size();
            z4 = false;
            i14 = 0;
            while (i14 < size5) {
                aeVar3 = (ae) list3.get(i14);
                obj2 = aeVar3.a;
                if (obj2 instanceof hp2) {
                    i19 = aeVar3.b;
                    int i39 = aeVar3.c;
                    if (i19 >= 0) {
                        size5 = size5;
                        i14 = i14;
                        eu1Var2 = eu1Var;
                        z4 = z4;
                    } else {
                        size5 = size5;
                        i14 = i14;
                        eu1Var2 = eu1Var;
                        z4 = z4;
                    }
                } else {
                    size5 = size5;
                    i14 = i14;
                    eu1Var2 = eu1Var;
                    z4 = z4;
                }
                i14++;
                eu1Var = eu1Var2;
                jc0Var5 = jc0Var5;
                size5 = size5;
            }
            jc0Var2 = jc0Var5;
            eu1 eu1Var6 = eu1Var;
            if (z4) {
                size7 = list3.size();
                i17 = 0;
                while (i17 < size7) {
                    aeVar2 = (ae) list3.get(i17);
                    xdVar = (xd) aeVar2.a;
                    if (xdVar instanceof hp2) {
                        i18 = aeVar2.b;
                        int i310 = aeVar2.c;
                        if (i18 >= 0) {
                            jc0Var4 = jc0Var2;
                        } else {
                            jc0Var4 = jc0Var2;
                        }
                    } else {
                        jc0Var4 = jc0Var2;
                    }
                    i17++;
                    jc0Var2 = jc0Var4;
                }
            }
            jc0Var3 = jc0Var2;
            wy2Var2 = eu1Var6.d;
            if (wy2Var2 != null) {
                j = wy2Var2.a;
                jB = b03.b(j);
                if (c03.a(jB, 4294967296L)) {
                    jc0Var3.d0(j);
                } else if (c03.a(jB, 8589934592L)) {
                    b03.c(j);
                }
            }
            size6 = list3.size();
            while (i15 < size6) {
                Object obj9 = ((ae) list3.get(i15)).a;
            }
            charSequence2 = spannableString;
            if (list4.size() > 0) {
                aeVar = (ae) list4.get(0);
                if (aeVar.a != null) {
                    dk0.t();
                    throw null;
                }
                while (i16 < r1) {
                    spannableString.removeSpan((r33) obj7);
                }
                throw null;
            }
        }
        this.k = charSequence2;
        this.n = new c71(charSequence2, this.j, this.u);
    }

    @Override // defpackage.cu1
    public final float a() {
        c71 c71Var = this.n;
        float f = c71Var.e;
        TextPaint textPaint = c71Var.b;
        if (!Float.isNaN(f)) {
            return c71Var.e;
        }
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        CharSequence charSequence = c71Var.a;
        lineInstance.setText(new ox(charSequence, charSequence.length()));
        PriorityQueue priorityQueue = new PriorityQueue(10, new gb(3));
        int i = 0;
        for (int next = lineInstance.next(); next != -1; next = lineInstance.next()) {
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new wt1(Integer.valueOf(i), Integer.valueOf(next)));
            } else {
                wt1 wt1Var = (wt1) priorityQueue.peek();
                if (wt1Var != null && ((Number) wt1Var.b).intValue() - ((Number) wt1Var.a).intValue() < next - i) {
                    priorityQueue.poll();
                    priorityQueue.add(new wt1(Integer.valueOf(i), Integer.valueOf(next)));
                }
            }
            i = next;
        }
        float desiredWidth = 0.0f;
        if (!priorityQueue.isEmpty()) {
            Iterator it = priorityQueue.iterator();
            if (!it.hasNext()) {
                dk0.d();
                return 0.0f;
            }
            wt1 wt1Var2 = (wt1) it.next();
            desiredWidth = Layout.getDesiredWidth(c71Var.b(), ((Number) wt1Var2.a).intValue(), ((Number) wt1Var2.b).intValue(), textPaint);
            while (it.hasNext()) {
                wt1 wt1Var3 = (wt1) it.next();
                desiredWidth = Math.max(desiredWidth, Layout.getDesiredWidth(c71Var.b(), ((Number) wt1Var3.a).intValue(), ((Number) wt1Var3.b).intValue(), textPaint));
            }
        }
        c71Var.e = desiredWidth;
        return desiredWidth;
    }

    @Override // defpackage.cu1
    public final boolean b() {
        b13 b13Var = this.s;
        if (b13Var != null ? b13Var.g() : false) {
            return true;
        }
        if (!this.t && nd4.a(this.b)) {
            q82 q82Var = rh0.a;
            q82 q82Var2 = rh0.a;
            gr2 gr2VarC = (gr2) q82Var2.a;
            if (gr2VarC == null) {
                if (oh0.d()) {
                    gr2VarC = q82Var2.C();
                    q82Var2.a = gr2VarC;
                } else {
                    gr2VarC = cz3.a;
                }
            }
            if (((Boolean) gr2VarC.getValue()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.cu1
    public final float c() {
        return this.n.c();
    }
}
