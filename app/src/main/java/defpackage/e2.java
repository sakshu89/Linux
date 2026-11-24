package defpackage;

import android.R;
import android.app.RemoteAction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.textclassifier.TextClassification;
import com.ibm.icu.text.ArabicShaping;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e2 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ e2(mm1 mm1Var, ArrayList arrayList, List list, boolean z) {
        this.a = 8;
        this.b = mm1Var;
        this.c = arrayList;
        this.e = list;
    }

    /* JADX WARN: Code duplicated, block: B:514:0x0be9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v229, types: [hq0] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, x50] */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r19v1, types: [cw] */
    /* JADX WARN: Type inference failed for: r19v2, types: [cw] */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r3v13, types: [cw] */
    /* JADX WARN: Type inference failed for: r3v14, types: [cw] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16, types: [cw] */
    /* JADX WARN: Type inference failed for: r3v17, types: [ia] */
    /* JADX WARN: Type inference failed for: r3v18, types: [cw] */
    /* JADX WARN: Type inference failed for: r3v19, types: [cw] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v54 */
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
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        boolean zPerformAction;
        AccessibilityNodeInfo accessibilityNodeInfoF;
        boolean zPerformAction2;
        AccessibilityNodeInfo accessibilityNodeInfoF2;
        fz2 fz2Var;
        Object r3;
        Object value;
        long jLongValue;
        ua1 ua1Var;
        Integer numE;
        Integer numD;
        Integer numD2;
        Integer numE2;
        gz2 gz2Var;
        gz2 gz2Var2;
        hz2 hz2Var;
        hz2 hz2Var2;
        gz2 gz2Var3;
        gz2 gz2Var4;
        hz2 hz2Var3;
        hz2 hz2Var4;
        Integer numD3;
        Integer numE3;
        Integer numE4;
        Integer numD4;
        cu2 cu2Var;
        int i = 5;
        final int i2 = 2;
        int i3 = 3;
        var r12 = 0;
        ty2 ty2Var = null;
        r12 = 0;
        final int i4 = 0;
        int i5 = 1;
        switch (this.a) {
            case 0:
                r2 r2Var = (r2) this.b;
                String str = (String) this.c;
                String str2 = (String) this.e;
                List list = (List) obj;
                list.getClass();
                r2Var.getClass();
                String strQ = r2.q(list);
                if (strQ == null || (accessibilityNodeInfoF = r2.f(list)) == null || !mf4.a(strQ, str) || cs2.A(str2) || !accessibilityNodeInfoF.isEnabled()) {
                    zPerformAction = false;
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str2);
                    zPerformAction = accessibilityNodeInfoF.performAction(ArabicShaping.SEEN_TWOCELL_NEAR, bundle);
                }
                return Boolean.valueOf(zPerformAction);
            case 1:
                r2 r2Var2 = (r2) this.b;
                y93 y93Var = (y93) this.e;
                String str3 = (String) this.c;
                List list2 = (List) obj;
                list2.getClass();
                r2Var2.getClass();
                String strQ2 = r2.q(list2);
                if (strQ2 == null || (accessibilityNodeInfoF2 = r2.f(list2)) == null || !strQ2.equals(y93Var.a)) {
                    zPerformAction2 = false;
                } else {
                    CharSequence packageName = accessibilityNodeInfoF2.getPackageName();
                    if (g31.a(packageName != null ? packageName.toString() : null, y93Var.c)) {
                        CharSequence text = accessibilityNodeInfoF2.getText();
                        String string = text != null ? text.toString() : null;
                        if (string == null) {
                            string = "";
                        }
                        if (string.equals(y93Var.b) && !cs2.A(str3) && accessibilityNodeInfoF2.isEnabled()) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str3);
                            zPerformAction2 = accessibilityNodeInfoF2.performAction(ArabicShaping.SEEN_TWOCELL_NEAR, bundle2);
                        } else {
                            zPerformAction2 = false;
                        }
                    } else {
                        zPerformAction2 = false;
                    }
                }
                return Boolean.valueOf(zPerformAction2);
            case 2:
                bq1 bq1Var = (bq1) this.b;
                ob1 ob1Var = (ob1) this.c;
                jk jkVar = (jk) this.e;
                bq1Var.getClass();
                ob1Var.getClass();
                jkVar.getClass();
                qb1 qb1VarF = ob1Var.f();
                if (qb1VarF.d != eb1.a) {
                    jkVar.b.add(new zp1(bq1Var, qb1VarF, jkVar));
                    bq1Var.d();
                    jkVar.c = new g7(0, bq1Var, bq1.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0, 15);
                }
                return new g8(3, jkVar);
            case 3:
                hq0 hq0Var = (hq0) this.b;
                mm1 mm1Var = (mm1) this.c;
                mm1 mm1Var2 = (mm1) this.e;
                ty2 ty2Var2 = (ty2) obj;
                mm1Var.setValue(ty2Var2);
                boolean zA = g31.a((String) mm1Var2.getValue(), ty2Var2.a.b);
                be beVar = ty2Var2.a;
                mm1Var2.setValue(beVar.b);
                if (!zA) {
                    hq0Var.j(beVar.b);
                }
                return q43.a;
            case 4:
                k50 k50Var = (k50) this.b;
                f41 f41Var = (f41) this.c;
                fe2 fe2Var = (fe2) this.e;
                float fFloatValue = ((Float) obj).floatValue();
                float f = k50Var.X ? 1.0f : -1.0f;
                he2 he2Var = k50Var.H;
                long jE = he2Var.e(he2Var.h(f * fFloatValue));
                he2 he2Var2 = fe2Var.a;
                float fG = he2Var.g(he2Var.e(he2Var2.c(he2Var2.k, jE, 1))) * f;
                if (Math.abs(fG) < Math.abs(fFloatValue)) {
                    CancellationException cancellationException = new CancellationException("Scroll animation cancelled because scroll was not consumed (" + fG + " < " + fFloatValue + ')');
                    cancellationException.initCause(null);
                    f41Var.e(cancellationException);
                }
                return q43.a;
            case 5:
                el1 el1Var = el1.j;
                ua1 ua1Var2 = (ua1) this.b;
                long j = ((ty2) this.c).b;
                mp1 mp1Var = (mp1) this.e;
                rf0 rf0Var = (rf0) obj;
                hz2 hz2VarD = ua1Var2.d();
                if (hz2VarD != null) {
                    var M = rf0Var.C().m();
                    long j2 = ((oz2) ua1Var2.A.getValue()).a;
                    long j3 = ((oz2) ua1Var2.B.getValue()).a;
                    gz2 gz2Var5 = hz2VarD.a;
                    fl1 fl1Var = gz2Var5.b;
                    fz2 fz2Var2 = gz2Var5.a;
                    fa faVar = ua1Var2.y;
                    long j4 = ua1Var2.z;
                    if (!oz2.c(j2)) {
                        faVar.e(j4);
                        int iL = mp1Var.l(oz2.f(j2));
                        int iL2 = mp1Var.l(oz2.e(j2));
                        if (iL != iL2) {
                            M.h(gz2Var5.h(iL, iL2), faVar);
                        }
                        fz2Var = fz2Var2;
                    } else if (oz2.c(j3)) {
                        fz2Var = fz2Var2;
                        if (!oz2.c(j)) {
                            faVar.e(j4);
                            int iL3 = mp1Var.l(oz2.f(j));
                            int iL4 = mp1Var.l(oz2.e(j));
                            if (iL3 != iL4) {
                                M.h(gz2Var5.h(iL3, iL4), faVar);
                            }
                        }
                    } else {
                        fz2Var = fz2Var2;
                        long jB = fz2Var.b.b();
                        sz szVar = jB == 16 ? null : new sz(jB);
                        long j5 = szVar != null ? szVar.a : sz.b;
                        faVar.e(sz.b(sz.d(j5) * 0.2f, j5));
                        int iL5 = mp1Var.l(oz2.f(j3));
                        int iL6 = mp1Var.l(oz2.e(j3));
                        if (iL5 != iL6) {
                            M.h(gz2Var5.h(iL5, iL6), faVar);
                        }
                    }
                    long j6 = gz2Var5.c;
                    float f2 = (int) (j6 >> 32);
                    fl1 fl1Var2 = gz2Var5.b;
                    boolean z = ((f2 > fl1Var2.d ? 1 : (f2 == fl1Var2.d ? 0 : -1)) < 0 || fl1Var2.c || (((float) ((int) (j6 & 4294967295L))) > fl1Var2.e ? 1 : (((float) ((int) (j6 & 4294967295L))) == fl1Var2.e ? 0 : -1)) < 0) && fz2Var.f != 3;
                    if (z) {
                        long j7 = gz2Var5.c;
                        l42 l42VarA = ry3.a(0L, (((long) Float.floatToRawIntBits((int) (j7 >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (j7 & 4294967295L))) & 4294967295L));
                        M.m();
                        cw.l(M, l42VarA);
                    }
                    hp2 hp2Var = fz2Var.b.a;
                    sx2 sx2Var = hp2Var.m;
                    uy2 uy2Var = hp2Var.a;
                    if (sx2Var == null) {
                        sx2Var = sx2.b;
                    }
                    sx2 sx2Var2 = sx2Var;
                    vj2 vj2Var = hp2Var.n;
                    if (vj2Var == null) {
                        vj2Var = vj2.d;
                    }
                    vj2 vj2Var2 = vj2Var;
                    wm4 wm4Var = hp2Var.o;
                    if (wm4Var == null) {
                        wm4Var = ql0.a;
                    }
                    wm4 wm4Var2 = wm4Var;
                    try {
                        hn hnVarD = uy2Var.d();
                        try {
                            if (hnVarD != null) {
                                fl1.i(fl1Var, M, hnVarD, uy2Var != el1Var ? uy2Var.a() : 1.0f, vj2Var2, sx2Var2, wm4Var2);
                                r3 = M;
                            } else {
                                var r19 = M;
                                long jC = uy2Var != el1Var ? uy2Var.c() : sz.b;
                                r19.m();
                                ArrayList arrayList = fl1Var.h;
                                int size = arrayList.size();
                                int i6 = 0;
                                var r110 = r19;
                                while (i6 < size) {
                                    au1 au1Var = (au1) arrayList.get(i6);
                                    au1Var.a.f(r110, jC, vj2Var2, sx2Var2, wm4Var2);
                                    var r4 = r110;
                                    r4.g(0.0f, au1Var.a.b());
                                    i6++;
                                    r110 = r4;
                                }
                                var r5 = r110;
                                r5.j();
                                r3 = r5;
                            }
                            if (z) {
                                r3.j();
                            }
                        } catch (Throwable th) {
                            th = th;
                            M = 4294967295;
                            if (z) {
                                M.j();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return q43.a;
            case 6:
                cx2 cx2Var = (cx2) this.b;
                Context context = (Context) this.c;
                ox2 ox2Var = (ox2) this.e;
                r50 r50Var = (r50) obj;
                List list3 = cx2Var.a;
                int size2 = list3.size();
                int i7 = 0;
                while (i7 < size2) {
                    bx2 bx2Var = (bx2) list3.get(i7);
                    int i8 = 6;
                    if (bx2Var instanceof jx2) {
                        jx2 jx2Var = (jx2) bx2Var;
                        r50.b(r50Var, new ha(i3, jx2Var), jx2Var.c == 0 ? null : new w10(-1930700965, true, new ib0(i4, jx2Var)), new zb(i8, jx2Var, ox2Var), 6);
                    } else if (bx2Var instanceof px2) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            px2 px2Var = (px2) bx2Var;
                            if (context != null) {
                                int i9 = px2Var.c;
                                TextClassification textClassification = px2Var.b;
                                if (i9 < 0) {
                                    ha haVar = new ha(17, textClassification);
                                    Drawable icon = textClassification.getIcon();
                                    r50.b(r50Var, haVar, icon != null ? new w10(-1123224187, true, new ib0(1, icon)) : null, new zb(21, context, textClassification), 6);
                                } else {
                                    RemoteAction remoteAction = (RemoteAction) textClassification.getActions().get(i9);
                                    r50.b(r50Var, new ha(18, remoteAction), ((i9 == 0) || remoteAction.shouldShowIcon()) ? new w10(-1261173016, true, new ib0(i2, remoteAction)) : null, new kb(22, remoteAction), 6);
                                }
                            }
                        }
                    } else if (bx2Var instanceof nx2) {
                        r50Var.a.add(dy3.b);
                    }
                    i7++;
                    i4 = 0;
                }
                return q43.a;
            case 7:
                mt0 mt0Var = (mt0) this.b;
                s70 s70Var = (s70) this.c;
                x00 x00Var = (x00) this.e;
                ad1 ad1Var = (ad1) obj;
                mt0Var.w = true;
                mt0.f(mt0Var, ad1Var == ad1.a ? "audioHandedToCall" : "audioYieldedToOtherApp");
                try {
                    AudioRecord audioRecord = mt0Var.t;
                    if (audioRecord != null) {
                        audioRecord.stop();
                    }
                    break;
                } catch (Throwable unused) {
                }
                mt0Var.j();
                jr2 jr2Var = mt0Var.k;
                do {
                    value = jr2Var.getValue();
                } while (!jr2Var.h(value, ee1.a((ee1) value, false, null, null, "Live audio is paused. Tap the orb to resume when phone audio is available.", 47)));
                uf4.b(s70Var, null, new aa(mt0Var, x00Var, r12, i), 3);
                return q43.a;
            case 8:
                q43 q43Var = q43.a;
                mm1 mm1Var3 = (mm1) this.b;
                ArrayList arrayList2 = (ArrayList) this.c;
                List list4 = (List) this.e;
                yw1 yw1Var = (yw1) obj;
                yw1Var.a = true;
                int size3 = arrayList2.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    ((y91) arrayList2.get(i10)).b(yw1Var);
                }
                int size4 = list4.size();
                for (int i11 = 0; i11 < size4; i11++) {
                    ((y91) list4.get(i11)).b(yw1Var);
                }
                yw1Var.a = false;
                mm1Var3.getValue();
                return q43Var;
            case 9:
                aa2 aa2Var = (aa2) this.b;
                Object obj2 = this.c;
                ea2 ea2Var = (ea2) this.e;
                gm1 gm1Var = aa2Var.b;
                if (gm1Var.b(obj2)) {
                    dk0.s("Key ", obj2, " was used multiple times ");
                    return null;
                }
                aa2Var.a.remove(obj2);
                gm1Var.m(obj2, ea2Var);
                return new z92(aa2Var, obj2, ea2Var);
            case 10:
                p42 p42Var = (p42) this.b;
                t42 t42Var = (t42) this.c;
                gu1 gu1Var = (gu1) this.e;
                Long l = (Long) obj;
                long jLongValue2 = l.longValue();
                double d = p42Var.a;
                Long l2 = (Long) t42Var.a;
                if (l2 == null || jLongValue2 <= l2.longValue()) {
                    jLongValue = 0;
                } else {
                    jLongValue = jLongValue2 - l2.longValue();
                    if (jLongValue > 50000000) {
                        jLongValue = 50000000;
                    }
                }
                double d2 = (jLongValue / 1.0E9d) + d;
                p42Var.a = d2;
                t42Var.a = l;
                gu1Var.h((float) d2);
                return q43.a;
            case 11:
                s9 s9Var = (s9) this.b;
                lf2 lf2Var = (lf2) this.c;
                o42 o42Var = (o42) this.e;
                ny1 ny1Var = (ny1) obj;
                long j8 = ny1Var.c;
                ny2 ny2Var = (ny2) s9Var.e;
                if (ny2Var.k() && ny2Var.n().a.b.length() != 0 && (ua1Var = ny2Var.d) != null && ua1Var.d() != null) {
                    s9Var.m(ny2Var.n(), j8, false, lf2Var);
                    i4 = 1;
                }
                if (i4 != 0) {
                    ny1Var.a();
                    o42Var.a = true;
                }
                return q43.a;
            case 12:
                l11 l11Var = (l11) this.b;
                hq0 hq0Var2 = (hq0) this.c;
                bz2 bz2Var = (bz2) ((t42) this.e).a;
                ty2 ty2VarL = l11Var.l((List) obj);
                if (bz2Var != null) {
                    bz2Var.a(null, ty2VarL);
                }
                hq0Var2.j(ty2VarL);
                return q43.a;
            case 13:
                f51 f51Var = (f51) this.b;
                yx2 yx2Var = (yx2) this.c;
                o42 o42Var2 = (o42) this.e;
                ay2 ay2Var = (ay2) obj;
                q43 q43Var2 = q43.a;
                switch (f51Var.ordinal()) {
                    case 0:
                        ay2Var.e.a = null;
                        if (ay2Var.g.b.length() > 0) {
                            if (oz2.c(ay2Var.f)) {
                                ay2Var.i();
                            } else {
                                boolean zF = ay2Var.f();
                                long j9 = ay2Var.f;
                                if (zF) {
                                    int iF = oz2.f(j9);
                                    ay2Var.q(iF, iF);
                                } else {
                                    int iE = oz2.e(j9);
                                    ay2Var.q(iE, iE);
                                }
                            }
                        }
                        break;
                    case 1:
                        ay2Var.e.a = null;
                        if (ay2Var.g.b.length() > 0) {
                            if (oz2.c(ay2Var.f)) {
                                ay2Var.m();
                            } else {
                                boolean zF2 = ay2Var.f();
                                long j10 = ay2Var.f;
                                if (zF2) {
                                    int iE2 = oz2.e(j10);
                                    ay2Var.q(iE2, iE2);
                                } else {
                                    int iF2 = oz2.f(j10);
                                    ay2Var.q(iF2, iF2);
                                }
                            }
                        }
                        break;
                    case 2:
                        nz2 nz2Var = ay2Var.e;
                        nz2Var.a = null;
                        be beVar2 = ay2Var.g;
                        String str4 = beVar2.b;
                        String str5 = beVar2.b;
                        if (str4.length() > 0) {
                            if (ay2Var.f()) {
                                nz2Var.a = null;
                                if (str5.length() > 0 && (numD = ay2Var.d()) != null) {
                                    int iIntValue = numD.intValue();
                                    ay2Var.q(iIntValue, iIntValue);
                                }
                            } else {
                                nz2Var.a = null;
                                if (str5.length() > 0 && (numE = ay2Var.e()) != null) {
                                    int iIntValue2 = numE.intValue();
                                    ay2Var.q(iIntValue2, iIntValue2);
                                }
                            }
                        }
                        break;
                    case 3:
                        nz2 nz2Var2 = ay2Var.e;
                        nz2Var2.a = null;
                        be beVar3 = ay2Var.g;
                        String str6 = beVar3.b;
                        String str7 = beVar3.b;
                        if (str6.length() > 0) {
                            if (ay2Var.f()) {
                                nz2Var2.a = null;
                                if (str7.length() > 0 && (numE2 = ay2Var.e()) != null) {
                                    int iIntValue3 = numE2.intValue();
                                    ay2Var.q(iIntValue3, iIntValue3);
                                }
                            } else {
                                nz2Var2.a = null;
                                if (str7.length() > 0 && (numD2 = ay2Var.d()) != null) {
                                    int iIntValue4 = numD2.intValue();
                                    ay2Var.q(iIntValue4, iIntValue4);
                                }
                            }
                        }
                        break;
                    case 4:
                        ay2Var.j();
                        break;
                    case 5:
                        ay2Var.l();
                        break;
                    case 6:
                        ay2Var.o();
                        break;
                    case 7:
                        ay2Var.n();
                        break;
                    case 8:
                        ay2Var.e.a = null;
                        if (ay2Var.g.b.length() > 0) {
                            if (ay2Var.f()) {
                                ay2Var.o();
                            } else {
                                ay2Var.n();
                            }
                        }
                        break;
                    case 9:
                        ay2Var.e.a = null;
                        if (ay2Var.g.b.length() > 0) {
                            if (ay2Var.f()) {
                                ay2Var.n();
                            } else {
                                ay2Var.o();
                            }
                        }
                        break;
                    case 10:
                        if (ay2Var.g.b.length() > 0 && (gz2Var = ay2Var.c) != null) {
                            int iG = ay2Var.g(gz2Var, -1);
                            ay2Var.q(iG, iG);
                        }
                        break;
                    case 11:
                        if (ay2Var.g.b.length() > 0 && (gz2Var2 = ay2Var.c) != null) {
                            int iG2 = ay2Var.g(gz2Var2, 1);
                            ay2Var.q(iG2, iG2);
                        }
                        break;
                    case 12:
                    case 48:
                        break;
                    case 13:
                        if (ay2Var.g.b.length() > 0 && (hz2Var = ay2Var.i) != null) {
                            int iH = ay2Var.h(hz2Var, -1);
                            ay2Var.q(iH, iH);
                        }
                        break;
                    case 14:
                        if (ay2Var.g.b.length() > 0 && (hz2Var2 = ay2Var.i) != null) {
                            int iH2 = ay2Var.h(hz2Var2, 1);
                            ay2Var.q(iH2, iH2);
                        }
                        break;
                    case 15:
                        ay2Var.e.a = null;
                        if (ay2Var.g.b.length() > 0) {
                            ay2Var.q(0, 0);
                        }
                        break;
                    case 16:
                        ay2Var.e.a = null;
                        be beVar4 = ay2Var.g;
                        if (beVar4.b.length() > 0) {
                            int length = beVar4.b.length();
                            ay2Var.q(length, length);
                        }
                        break;
                    case 17:
                        yx2Var.b.d(false);
                        break;
                    case 18:
                        yx2Var.b.p();
                        break;
                    case 19:
                        yx2Var.b.f();
                        break;
                    case 20:
                        List listA = ay2Var.a(new xn2(8));
                        if (listA != null) {
                            yx2Var.a(listA);
                        }
                        break;
                    case 21:
                        List listA2 = ay2Var.a(new xn2(9));
                        if (listA2 != null) {
                            yx2Var.a(listA2);
                        }
                        break;
                    case 22:
                        List listA3 = ay2Var.a(new xn2(10));
                        if (listA3 != null) {
                            yx2Var.a(listA3);
                        }
                        break;
                    case 23:
                        List listA4 = ay2Var.a(new xn2(11));
                        if (listA4 != null) {
                            yx2Var.a(listA4);
                        }
                        break;
                    case 24:
                        List listA5 = ay2Var.a(new xn2(12));
                        if (listA5 != null) {
                            yx2Var.a(listA5);
                        }
                        break;
                    case 25:
                        List listA6 = ay2Var.a(new xn2(13));
                        if (listA6 != null) {
                            yx2Var.a(listA6);
                        }
                        break;
                    case 26:
                        ay2Var.e.a = null;
                        be beVar5 = ay2Var.g;
                        if (beVar5.b.length() > 0) {
                            ay2Var.q(0, beVar5.b.length());
                        }
                        break;
                    case 27:
                        ay2Var.i();
                        ay2Var.p();
                        break;
                    case 28:
                        ay2Var.m();
                        ay2Var.p();
                        break;
                    case 29:
                        if (ay2Var.g.b.length() > 0 && (gz2Var3 = ay2Var.c) != null) {
                            int iG3 = ay2Var.g(gz2Var3, -1);
                            ay2Var.q(iG3, iG3);
                        }
                        ay2Var.p();
                        break;
                    case 30:
                        if (ay2Var.g.b.length() > 0 && (gz2Var4 = ay2Var.c) != null) {
                            int iG4 = ay2Var.g(gz2Var4, 1);
                            ay2Var.q(iG4, iG4);
                        }
                        ay2Var.p();
                        break;
                    case 31:
                        if (ay2Var.g.b.length() > 0 && (hz2Var3 = ay2Var.i) != null) {
                            int iH3 = ay2Var.h(hz2Var3, -1);
                            ay2Var.q(iH3, iH3);
                        }
                        ay2Var.p();
                        break;
                    case 32:
                        if (ay2Var.g.b.length() > 0 && (hz2Var4 = ay2Var.i) != null) {
                            int iH4 = ay2Var.h(hz2Var4, 1);
                            ay2Var.q(iH4, iH4);
                        }
                        ay2Var.p();
                        break;
                    case 33:
                        ay2Var.e.a = null;
                        if (ay2Var.g.b.length() > 0) {
                            ay2Var.q(0, 0);
                        }
                        ay2Var.p();
                        break;
                    case 34:
                        ay2Var.e.a = null;
                        be beVar6 = ay2Var.g;
                        if (beVar6.b.length() > 0) {
                            int length2 = beVar6.b.length();
                            ay2Var.q(length2, length2);
                        }
                        ay2Var.p();
                        break;
                    case 35:
                        nz2 nz2Var3 = ay2Var.e;
                        nz2Var3.a = null;
                        be beVar7 = ay2Var.g;
                        String str8 = beVar7.b;
                        String str9 = beVar7.b;
                        if (str8.length() > 0) {
                            if (ay2Var.f()) {
                                nz2Var3.a = null;
                                if (str9.length() > 0 && (numE3 = ay2Var.e()) != null) {
                                    int iIntValue5 = numE3.intValue();
                                    ay2Var.q(iIntValue5, iIntValue5);
                                }
                            } else {
                                nz2Var3.a = null;
                                if (str9.length() > 0 && (numD3 = ay2Var.d()) != null) {
                                    int iIntValue6 = numD3.intValue();
                                    ay2Var.q(iIntValue6, iIntValue6);
                                }
                            }
                        }
                        ay2Var.p();
                        break;
                    case 36:
                        nz2 nz2Var4 = ay2Var.e;
                        nz2Var4.a = null;
                        be beVar8 = ay2Var.g;
                        String str10 = beVar8.b;
                        String str11 = beVar8.b;
                        if (str10.length() > 0) {
                            if (ay2Var.f()) {
                                nz2Var4.a = null;
                                if (str11.length() > 0 && (numD4 = ay2Var.d()) != null) {
                                    int iIntValue7 = numD4.intValue();
                                    ay2Var.q(iIntValue7, iIntValue7);
                                }
                            } else {
                                nz2Var4.a = null;
                                if (str11.length() > 0 && (numE4 = ay2Var.e()) != null) {
                                    int iIntValue8 = numE4.intValue();
                                    ay2Var.q(iIntValue8, iIntValue8);
                                }
                            }
                        }
                        ay2Var.p();
                        break;
                    case 37:
                        ay2Var.j();
                        ay2Var.p();
                        break;
                    case 38:
                        ay2Var.l();
                        ay2Var.p();
                        break;
                    case 39:
                        ay2Var.o();
                        ay2Var.p();
                        break;
                    case 40:
                        ay2Var.n();
                        ay2Var.p();
                        break;
                    case 41:
                        ay2Var.e.a = null;
                        if (ay2Var.g.b.length() > 0) {
                            if (ay2Var.f()) {
                                ay2Var.o();
                            } else {
                                ay2Var.n();
                            }
                        }
                        ay2Var.p();
                        break;
                    case 42:
                        ay2Var.e.a = null;
                        if (ay2Var.g.b.length() > 0) {
                            if (ay2Var.f()) {
                                ay2Var.n();
                            } else {
                                ay2Var.o();
                            }
                        }
                        ay2Var.p();
                        break;
                    case 43:
                        ay2Var.e.a = null;
                        if (ay2Var.g.b.length() > 0) {
                            long j11 = ay2Var.f;
                            int i12 = oz2.c;
                            int i13 = (int) (j11 & 4294967295L);
                            ay2Var.q(i13, i13);
                        }
                        break;
                    case 44:
                        if (yx2Var.e) {
                            o42Var2.a = yx2Var.a.x.b.r.A(yx2Var.l);
                        } else {
                            yx2Var.a(nz.h(new r00("\n", 1)));
                        }
                        break;
                    case 45:
                        if (yx2Var.e) {
                            o42Var2.a = false;
                        } else {
                            yx2Var.a(nz.h(new r00("\t", 1)));
                        }
                        break;
                    case 46:
                        m43 m43Var = yx2Var.h;
                        if (m43Var != null) {
                            m43Var.a(ty2.a(ay2Var.h, ay2Var.g, ay2Var.f, 4));
                        }
                        m43 m43Var2 = yx2Var.h;
                        if (m43Var2 != null) {
                            cu2 cu2Var2 = m43Var2.a;
                            if (cu2Var2 != null && (cu2Var = (cu2) cu2Var2.b) != null) {
                                m43Var2.a = cu2Var;
                                m43Var2.c -= ((ty2) cu2Var2.c).a.b.length();
                                m43Var2.b = new cu2(i, m43Var2.b, (ty2) cu2Var2.c);
                                r12 = (ty2) cu2Var.c;
                            }
                            if (r12 != 0) {
                                yx2Var.k.j(r12);
                            }
                        }
                        break;
                    case 47:
                        m43 m43Var3 = yx2Var.h;
                        if (m43Var3 != null) {
                            cu2 cu2Var3 = m43Var3.b;
                            if (cu2Var3 != null) {
                                m43Var3.b = (cu2) cu2Var3.b;
                                ty2 ty2Var3 = (ty2) cu2Var3.c;
                                m43Var3.a = new cu2(i, m43Var3.a, ty2Var3);
                                m43Var3.c = ty2Var3.a.b.length() + m43Var3.c;
                                ty2Var = (ty2) cu2Var3.c;
                            }
                            if (ty2Var != null) {
                                yx2Var.k.j(ty2Var);
                            }
                        }
                        break;
                    default:
                        dk0.l();
                        return null;
                }
                return q43Var2;
            default:
                final ny2 ny2Var2 = (ny2) this.b;
                s70 s70Var2 = (s70) this.c;
                Context context2 = (Context) this.e;
                ax2 ax2Var = (ax2) obj;
                yl1 yl1Var = ax2Var.a;
                yl1 yl1Var2 = ax2Var.a;
                nx2 nx2Var = nx2.b;
                yl1Var.a(nx2Var);
                kx2 kx2Var = kx2.Autofill;
                boolean z2 = (oz2.c(ny2Var2.n().b) || !ny2Var2.j() || (ny2Var2.f instanceof nu1) || ny2Var2.h == null) ? false : true;
                int i14 = 23;
                zb zbVar = new zb(i14, s70Var2, new hy2(ny2Var2, r12, i5));
                Resources resources = context2.getResources();
                int i15 = 19;
                o0 o0Var = new o0(i15, zbVar, r12);
                if (z2) {
                    yl1Var2.a(new jx2(ta4.a, resources.getString(R.string.cut), R.attr.actionModeCutDrawable, o0Var));
                }
                kx2 kx2Var2 = kx2.Autofill;
                boolean z3 = (oz2.c(ny2Var2.n().b) || (ny2Var2.f instanceof nu1) || ny2Var2.h == null) ? false : true;
                zb zbVar2 = new zb(i14, s70Var2, new hy2(ny2Var2, r12, i2));
                Resources resources2 = context2.getResources();
                o0 o0Var2 = new o0(i15, zbVar2, r12);
                if (z3) {
                    yl1Var2.a(new jx2(ta4.b, resources2.getString(R.string.copy), R.attr.actionModeCopyDrawable, o0Var2));
                }
                kx2 kx2Var3 = kx2.Autofill;
                boolean z4 = ny2Var2.j() && ((Boolean) ny2Var2.x.getValue()).booleanValue() && ny2Var2.h != null;
                zb zbVar3 = new zb(i14, s70Var2, new hy2(ny2Var2, r12, i3));
                Resources resources3 = context2.getResources();
                o0 o0Var3 = new o0(i15, zbVar3, r12);
                if (z4) {
                    yl1Var2.a(new jx2(ta4.c, resources3.getString(R.string.paste), R.attr.actionModePasteDrawable, o0Var3));
                }
                kx2 kx2Var4 = kx2.Autofill;
                boolean z5 = oz2.d(ny2Var2.n().b) != ny2Var2.n().a.b.length();
                fq0 fq0Var = new fq0() { // from class: ry2
                    @Override // defpackage.fq0
                    public final Object a() {
                        int i16 = i4;
                        q43 q43Var3 = q43.a;
                        ny2 ny2Var3 = ny2Var2;
                        switch (i16) {
                            case 0:
                                return Boolean.valueOf(!ny2Var3.B);
                            case 1:
                                ty2 ty2VarE = ny2.e(ny2Var3.n().a, hc4.a(0, ny2Var3.n().a.b.length()));
                                ny2Var3.c.j(ty2VarE);
                                long j12 = ty2VarE.b;
                                ny2Var3.w = new oz2(j12);
                                ny2Var3.u = ty2.a(ny2Var3.u, null, j12, 5);
                                ny2Var3.h(true);
                                return q43Var3;
                            default:
                                fq0 fq0Var2 = ny2Var3.g;
                                if (fq0Var2 != null) {
                                    fq0Var2.a();
                                }
                                return q43Var3;
                        }
                    }
                };
                final int i16 = 1;
                fq0 fq0Var2 = new fq0() { // from class: ry2
                    @Override // defpackage.fq0
                    public final Object a() {
                        int i17 = i16;
                        q43 q43Var3 = q43.a;
                        ny2 ny2Var3 = ny2Var2;
                        switch (i17) {
                            case 0:
                                return Boolean.valueOf(!ny2Var3.B);
                            case 1:
                                ty2 ty2VarE = ny2.e(ny2Var3.n().a, hc4.a(0, ny2Var3.n().a.b.length()));
                                ny2Var3.c.j(ty2VarE);
                                long j12 = ty2VarE.b;
                                ny2Var3.w = new oz2(j12);
                                ny2Var3.u = ty2.a(ny2Var3.u, null, j12, 5);
                                ny2Var3.h(true);
                                return q43Var3;
                            default:
                                fq0 fq0Var3 = ny2Var3.g;
                                if (fq0Var3 != null) {
                                    fq0Var3.a();
                                }
                                return q43Var3;
                        }
                    }
                };
                Resources resources4 = context2.getResources();
                o0 o0Var4 = new o0(i15, fq0Var2, fq0Var);
                if (z5) {
                    yl1Var2.a(new jx2(ta4.d, resources4.getString(R.string.selectAll), R.attr.actionModeSelectAllDrawable, o0Var4));
                }
                kx2 kx2Var5 = kx2.Autofill;
                if (ny2Var2.j() && oz2.c(ny2Var2.n().b)) {
                    i4 = 1;
                }
                fq0 fq0Var3 = new fq0() { // from class: ry2
                    @Override // defpackage.fq0
                    public final Object a() {
                        int i17 = i2;
                        q43 q43Var3 = q43.a;
                        ny2 ny2Var3 = ny2Var2;
                        switch (i17) {
                            case 0:
                                return Boolean.valueOf(!ny2Var3.B);
                            case 1:
                                ty2 ty2VarE = ny2.e(ny2Var3.n().a, hc4.a(0, ny2Var3.n().a.b.length()));
                                ny2Var3.c.j(ty2VarE);
                                long j12 = ty2VarE.b;
                                ny2Var3.w = new oz2(j12);
                                ny2Var3.u = ty2.a(ny2Var3.u, null, j12, 5);
                                ny2Var3.h(true);
                                return q43Var3;
                            default:
                                fq0 fq0Var4 = ny2Var3.g;
                                if (fq0Var4 != null) {
                                    fq0Var4.a();
                                }
                                return q43Var3;
                        }
                    }
                };
                Resources resources5 = context2.getResources();
                o0 o0Var5 = new o0(i15, fq0Var3, r12);
                if (i4 != 0) {
                    yl1Var2.a(new jx2(kx2Var5.a, resources5.getString(kx2Var5.b), kx2Var5.c, o0Var5));
                }
                yl1Var2.a(nx2Var);
                return q43.a;
        }
    }

    public /* synthetic */ e2(k50 k50Var, i53 i53Var, f41 f41Var, fe2 fe2Var) {
        this.a = 4;
        this.b = k50Var;
        this.c = f41Var;
        this.e = fe2Var;
    }

    public /* synthetic */ e2(r2 r2Var, y93 y93Var, String str) {
        this.a = 1;
        this.b = r2Var;
        this.e = y93Var;
        this.c = str;
    }

    public /* synthetic */ e2(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
    }
}
