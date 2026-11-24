package defpackage;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.ibm.icu.lang.UCharacter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x0 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ x0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x036e  */
    /* JADX WARN: Code duplicated, block: B:225:0x0525  */
    /* JADX WARN: Code duplicated, block: B:233:0x055c  */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        AccessibilityNodeInfo accessibilityNodeInfoF;
        int i;
        nl nlVar;
        boolean z;
        boolean z2;
        String strConcat;
        StringBuilder sb;
        int i2;
        x91 x91Var;
        List listK;
        ua1 ua1Var;
        int i3 = 4;
        int i4 = 6;
        float f = 0.0f;
        x91 x91Var2 = null;
        z = false;
        z = false;
        z = false;
        boolean z3 = false;
        switch (this.a) {
            case 0:
                return obj == ((y0) this.b) ? "(this Collection)" : String.valueOf(obj);
            case 1:
                hw1 hw1Var = (hw1) this.b;
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                StringBuilder sb2 = new StringBuilder();
                Object key = entry.getKey();
                sb2.append(key == hw1Var ? "(this Map)" : String.valueOf(key));
                sb2.append('=');
                Object value = entry.getValue();
                sb2.append(value != hw1Var ? String.valueOf(value) : "(this Map)");
                return sb2.toString();
            case 2:
                r2 r2Var = (r2) this.b;
                List list = (List) obj;
                list.getClass();
                r2Var.getClass();
                String strQ = r2.q(list);
                if (strQ == null || (accessibilityNodeInfoF = r2.f(list)) == null) {
                    return null;
                }
                CharSequence text = accessibilityNodeInfoF.getText();
                String string = text != null ? text.toString() : null;
                if (string == null) {
                    string = "";
                }
                CharSequence packageName = accessibilityNodeInfoF.getPackageName();
                String string2 = packageName != null ? packageName.toString() : null;
                return new y93(strQ, string, string2 != null ? string2 : "");
            case 3:
                s4 s4Var = (s4) this.b;
                s4Var.X.e((ax2) obj, ij4.a(s4Var, AndroidCompositionLocals_androidKt.b));
                return q43.a;
            case 4:
                ((og2) obj).a(wf2.a, new vf2(pv0.a, ((op1) this.b).a(), uf2.b, true));
                return q43.a;
            case 5:
                return new g8(i3, (wk) this.b);
            case 6:
                wl wlVar = (wl) this.b;
                so soVar = (so) obj;
                if (soVar.b() * wlVar.Y < 0.0f || xk2.b(soVar.a.c()) <= 0.0f) {
                    return soVar.a(new j(i4));
                }
                final float fMin = Math.min(de0.b(wlVar.Y, 0.0f) ? 1.0f : (float) Math.ceil(soVar.b() * wlVar.Y), (float) Math.ceil(xk2.b(soVar.a.c()) / 2.0f));
                final float f2 = fMin / 2.0f;
                final long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (((long) Float.floatToRawIntBits(f2)) << 32);
                final long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (soVar.a.c() >> 32)) - fMin)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (soVar.a.c() & 4294967295L)) - fMin)) & 4294967295L);
                float f3 = fMin * 2.0f;
                boolean z4 = f3 > xk2.b(soVar.a.c());
                es4 es4VarA = wlVar.c0.a(soVar.a.c(), soVar.a.getLayoutDirection(), soVar);
                if (!(es4VarA instanceof ts1)) {
                    if (!(es4VarA instanceof vs1)) {
                        boolean z5 = z4;
                        if (!(es4VarA instanceof us1)) {
                            dk0.l();
                            return null;
                        }
                        final cn2 cn2Var = wlVar.Z;
                        final long j = z5 ? 0L : jFloatToRawIntBits;
                        if (z5) {
                            jFloatToRawIntBits2 = soVar.a.c();
                        }
                        final long j2 = jFloatToRawIntBits2;
                        final wm4 ks2Var = z5 ? ql0.a : new ks2(fMin, 0.0f, 0, 0, 30);
                        return soVar.a(new hq0() { // from class: tl
                            @Override // defpackage.hq0
                            public final Object j(Object obj2) {
                                p71 p71Var = (p71) obj2;
                                p71Var.a();
                                rf0.W(p71Var, cn2Var, j, j2, 0.0f, ks2Var, 104);
                                return q43.a;
                            }
                        });
                    }
                    final cn2 cn2Var2 = wlVar.Z;
                    s82 s82Var = ((vs1) es4VarA).a;
                    if (ez3.b(s82Var)) {
                        final long j3 = s82Var.e;
                        final ks2 ks2Var2 = new ks2(fMin, 0.0f, 0, 0, 30);
                        final boolean z6 = z4;
                        return soVar.a(new hq0() { // from class: ul
                            @Override // defpackage.hq0
                            public final Object j(Object obj2) throws Throwable {
                                long j4;
                                p71 p71Var = (p71) obj2;
                                p71Var.a();
                                ew ewVar = p71Var.a;
                                boolean z7 = z6;
                                hn hnVar = cn2Var2;
                                long j5 = j3;
                                if (z7) {
                                    rf0.K(p71Var, hnVar, 0L, 0L, j5, null, UCharacter.UnicodeBlock.PSALTER_PAHLAVI_ID);
                                } else {
                                    float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
                                    float f4 = f2;
                                    if (fIntBitsToFloat < f4) {
                                        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (ewVar.c() >> 32));
                                        float f5 = fMin;
                                        float f6 = fIntBitsToFloat2 - f5;
                                        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (ewVar.c() & 4294967295L)) - f5;
                                        kf kfVar = ewVar.b;
                                        long jR = kfVar.r();
                                        kfVar.m().m();
                                        try {
                                            ((kf) ((q82) kfVar.b).a).m().f(f5, f5, f6, fIntBitsToFloat3, 0);
                                            j4 = jR;
                                            try {
                                                rf0.K(p71Var, hnVar, 0L, 0L, j5, null, UCharacter.UnicodeBlock.PSALTER_PAHLAVI_ID);
                                                cq.t(kfVar, j4);
                                            } catch (Throwable th) {
                                                th = th;
                                                cq.t(kfVar, j4);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            j4 = jR;
                                        }
                                    } else {
                                        rf0.K(p71Var, hnVar, jFloatToRawIntBits, jFloatToRawIntBits2, of4.c(f4, j5), ks2Var2, 208);
                                    }
                                }
                                return q43.a;
                            }
                        });
                    }
                    boolean z7 = z4;
                    if (wlVar.X == null) {
                        wlVar.X = new sl();
                    }
                    sl slVar = wlVar.X;
                    slVar.getClass();
                    na naVarA = slVar.d;
                    if (naVarA == null) {
                        naVarA = pa.a();
                        slVar.d = naVarA;
                    }
                    naVarA.f();
                    na.b(naVarA, s82Var);
                    if (!z7) {
                        na naVarA2 = pa.a();
                        na.b(naVarA2, new s82(fMin, fMin, (s82Var.c - s82Var.a) - fMin, (s82Var.d - s82Var.b) - fMin, of4.c(fMin, s82Var.e), of4.c(fMin, s82Var.f), of4.c(fMin, s82Var.g), of4.c(fMin, s82Var.h)));
                        naVarA.e(naVarA, naVarA2, 0);
                    }
                    return soVar.a(new o0(3, naVarA, cn2Var2));
                }
                cn2 cn2Var3 = wlVar.Z;
                ts1 ts1Var = (ts1) es4VarA;
                na naVar = ts1Var.a;
                if (z4) {
                    return soVar.a(new o0(i3, ts1Var, cn2Var3));
                }
                if (cn2Var3 != null) {
                    nlVar = new nl(5, sz.b(1.0f, cn2Var3.a));
                    i = 1;
                } else {
                    i = 0;
                    nlVar = null;
                }
                l42 l42VarC = naVar.c();
                float f4 = l42VarC.b;
                float f5 = l42VarC.a;
                if (wlVar.X == null) {
                    wlVar.X = new sl();
                }
                sl slVar2 = wlVar.X;
                slVar2.getClass();
                na naVarA3 = slVar2.d;
                if (naVarA3 == null) {
                    naVarA3 = pa.a();
                    slVar2.d = naVarA3;
                }
                naVarA3.f();
                float f6 = l42VarC.a;
                float f7 = l42VarC.d;
                float f8 = l42VarC.c;
                float f9 = l42VarC.b;
                if (Float.isNaN(f6) || Float.isNaN(f9) || Float.isNaN(f8) || Float.isNaN(f7)) {
                    pa.b("Invalid rectangle, make sure no value is NaN");
                }
                if (naVarA3.b == null) {
                    naVarA3.b = new RectF();
                }
                RectF rectF = naVarA3.b;
                rectF.getClass();
                rectF.set(f6, f9, f8, f7);
                Path path = naVarA3.a;
                RectF rectF2 = naVarA3.b;
                rectF2.getClass();
                path.addRect(rectF2, Path.Direction.CCW);
                naVarA3.e(naVarA3, naVar, 0);
                t42 t42Var = new t42();
                nl nlVar2 = nlVar;
                long jCeil = (((long) ((int) Math.ceil(l42VarC.d - f4))) & 4294967295L) | (((long) ((int) Math.ceil(l42VarC.c - f5))) << 32);
                sl slVar3 = wlVar.X;
                slVar3.getClass();
                p9 p9VarA = slVar3.a;
                u6 u6VarA = slVar3.b;
                my0 my0Var = p9VarA != null ? new my0(p9VarA.a()) : null;
                if (my0Var != null && my0Var.a == 0) {
                    z = true;
                } else {
                    my0 my0Var2 = p9VarA != null ? new my0(p9VarA.a()) : null;
                    if (my0Var2 != null && i == my0Var2.a) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (p9VarA == null || u6VarA == null) {
                    p9VarA = ro4.a((int) (jCeil >> 32), (int) (jCeil & 4294967295L), i);
                    slVar3.a = p9VarA;
                    u6VarA = bh4.a(p9VarA);
                    slVar3.b = u6VarA;
                } else {
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (soVar.a.c() >> 32));
                    Bitmap bitmap = p9VarA.a;
                    if (fIntBitsToFloat > bitmap.getWidth() || Float.intBitsToFloat((int) (soVar.a.c() & 4294967295L)) > bitmap.getHeight() || !z) {
                        p9VarA = ro4.a((int) (jCeil >> 32), (int) (jCeil & 4294967295L), i);
                        slVar3.a = p9VarA;
                        u6VarA = bh4.a(p9VarA);
                        slVar3.b = u6VarA;
                    }
                }
                ew ewVar = slVar3.c;
                if (ewVar == null) {
                    ewVar = new ew();
                    slVar3.c = ewVar;
                }
                kf kfVar = ewVar.b;
                dw dwVar = ewVar.a;
                long jA = cp4.a(jCeil);
                ew ewVar2 = ewVar;
                z61 layoutDirection = soVar.a.getLayoutDirection();
                jc0 jc0Var = dwVar.a;
                z61 z61Var = dwVar.b;
                na naVar2 = naVarA3;
                cw cwVar = dwVar.c;
                long j4 = dwVar.d;
                dwVar.a = soVar;
                dwVar.b = layoutDirection;
                dwVar.c = u6VarA;
                dwVar.d = jA;
                u6VarA.m();
                rf0.E(ewVar2, sz.b, jA, 58);
                float f10 = -f5;
                float f11 = -f4;
                ((q82) kfVar.b).J(f10, f11);
                try {
                    rf0.t(ewVar2, ts1Var.a, cn2Var3, 0.0f, new ks2(f3, 0.0f, 0, 0, 30), 52);
                    float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (ewVar2.c() >> 32)) + 1.0f) / Float.intBitsToFloat((int) (ewVar2.c() >> 32));
                    float fIntBitsToFloat3 = (Float.intBitsToFloat((int) (ewVar2.c() & 4294967295L)) + 1.0f) / Float.intBitsToFloat((int) (ewVar2.c() & 4294967295L));
                    long jX = ewVar2.X();
                    u6 u6Var = u6VarA;
                    long jR = kfVar.r();
                    kfVar.m().m();
                    try {
                        ((q82) kfVar.b).H(fIntBitsToFloat2, fIntBitsToFloat3, jX);
                        rf0.t(ewVar2, naVar2, cn2Var3, 0.0f, null, 28);
                        kfVar.m().j();
                        kfVar.G(jR);
                        ((q82) kfVar.b).J(-f10, -f11);
                        u6Var.j();
                        dwVar.a = jc0Var;
                        dwVar.b = z61Var;
                        dwVar.c = cwVar;
                        dwVar.d = j4;
                        p9VarA.a.prepareToDraw();
                        t42Var.a = p9VarA;
                        return soVar.a(new vl(l42VarC, t42Var, jCeil, nlVar2));
                    } catch (Throwable th) {
                        kfVar.m().j();
                        kfVar.G(jR);
                        throw th;
                    }
                } catch (Throwable th2) {
                    ((q82) kfVar.b).J(-f10, -f11);
                    throw th2;
                }
            case 7:
                o42 o42Var = (o42) this.b;
                t23 t23Var = (t23) obj;
                if (!o42Var.a) {
                    t23Var.getClass();
                    z2 = ((pd2) t23Var).x;
                }
                o42Var.a = z2;
                return Boolean.valueOf(!z2);
            case 8:
                LinkedHashSet linkedHashSet = (LinkedHashSet) this.b;
                Throwable th3 = (Throwable) obj;
                th3.getClass();
                return Boolean.valueOf(linkedHashSet.add(th3));
            case 9:
                ((ff1) this.b).a();
                return q43.a;
            case 10:
                fh0 fh0Var = (fh0) obj;
                String str = ((fh0) this.b) == fh0Var ? " > " : "   ";
                if (!(fh0Var instanceof r00)) {
                    if (fh0Var instanceof uh2) {
                        sb = new StringBuilder("SetComposingTextCommand(text.length=");
                        uh2 uh2Var = (uh2) fh0Var;
                        sb.append(uh2Var.a.b.length());
                        sb.append(", newCursorPosition=");
                        i2 = uh2Var.b;
                    } else if (fh0Var instanceof th2) {
                        strConcat = ((th2) fh0Var).toString();
                    } else if (fh0Var instanceof ec0) {
                        strConcat = ((ec0) fh0Var).toString();
                    } else if (fh0Var instanceof fc0) {
                        strConcat = ((fc0) fh0Var).toString();
                    } else if (fh0Var instanceof vh2) {
                        strConcat = ((vh2) fh0Var).toString();
                    } else if (fh0Var instanceof xl0) {
                        strConcat = "FinishComposingTextCommand()";
                    } else if (fh0Var instanceof dc0) {
                        strConcat = "DeleteAllCommand()";
                    } else {
                        String strB = u42.a(fh0Var.getClass()).b();
                        if (strB == null) {
                            strB = "{anonymous EditCommand}";
                        }
                        strConcat = "Unknown EditCommand: ".concat(strB);
                    }
                    return str.concat(strConcat);
                }
                sb = new StringBuilder("CommitTextCommand(text.length=");
                r00 r00Var = (r00) fh0Var;
                sb.append(r00Var.a.b.length());
                sb.append(", newCursorPosition=");
                i2 = r00Var.b;
                strConcat = ky0.m(sb, i2, ')');
                return str.concat(strConcat);
            case 11:
                pm1 pm1Var = (pm1) this.b;
                Object[] objArr = pm1Var.a;
                int i5 = pm1Var.c;
                for (int i6 = 0; i6 < i5; i6++) {
                    ((ph1) objArr[i6]).c();
                }
                return q43.a;
            case 12:
                s33 s33Var = (s33) obj;
                return ((ro0) this.b).a(new s33(null, s33Var.b, s33Var.c, s33Var.d, s33Var.e)).a;
            case 13:
                mt0 mt0Var = (mt0) this.b;
                if (((Long) obj).longValue() != 0) {
                    mt0.f(mt0Var, "pcmRepliesStarted");
                }
                return q43.a;
            case 14:
                return new g8(i4, (u81) this.b);
            case 15:
                return new g8(8, (a91) this.b);
            case 16:
                ea1 ea1Var = (ea1) this.b;
                float f12 = -((Float) obj).floatValue();
                if ((f12 >= 0.0f || ea1Var.c()) && (f12 <= 0.0f || ea1Var.a())) {
                    if (Math.abs(ea1Var.h) > 0.5f) {
                        c11.c("entered drag with non-zero pending scroll");
                    }
                    ea1Var.d = true;
                    float f13 = ea1Var.h + f12;
                    ea1Var.h = f13;
                    if (Math.abs(f13) > 0.5f) {
                        float f14 = ea1Var.h;
                        int iRound = Math.round(f14);
                        x91 x91VarF = ((x91) ea1Var.f.getValue()).f(iRound, !ea1Var.b);
                        if (x91VarF == null || (x91Var = ea1Var.c) == null) {
                            x91Var2 = x91VarF;
                        } else {
                            x91 x91VarF2 = x91Var.f(iRound, true);
                            if (x91VarF2 != null) {
                                ea1Var.c = x91VarF2;
                                x91Var2 = x91VarF;
                            }
                        }
                        if (x91Var2 != null) {
                            ea1Var.f(x91Var2, ea1Var.b, true);
                            ea1Var.v.setValue(q43.a);
                            ea1Var.j(f14 - ea1Var.h, x91Var2);
                        } else {
                            n71 n71Var = ea1Var.k;
                            if (n71Var != null) {
                                n71Var.k();
                            }
                            ea1Var.j(f14 - ea1Var.h, ea1Var.i());
                        }
                    }
                    if (Math.abs(ea1Var.h) > 0.5f) {
                        f12 -= ea1Var.h;
                        ea1Var.h = 0.0f;
                    }
                    f = f12;
                }
                return Float.valueOf(-f);
            case 17:
                ba2 ba2Var = (ba2) this.b;
                return Boolean.valueOf(ba2Var != null ? ba2Var.c(obj) : true);
            case 18:
                return ((eh1) this.b).b(((Integer) obj).intValue());
            case 19:
                ((an1) this.b).h(null);
                return q43.a;
            case 20:
                t42 t42Var2 = (t42) this.b;
                t23 t23Var2 = (t23) obj;
                t23Var2.getClass();
                f91 f91Var = ((v23) t23Var2).x;
                List list2 = (List) t42Var2.a;
                if (list2 != null) {
                    list2.add(f91Var);
                    listK = list2;
                } else {
                    listK = nz.k(f91Var);
                }
                t42Var2.a = listK;
                return s23.b;
            case 21:
                ((g30) this.b).z(obj);
                return q43.a;
            case 22:
                f42 f42Var = (f42) this.b;
                Throwable th4 = (Throwable) obj;
                CancellationException cancellationException = new CancellationException("Recomposer effect job completed");
                cancellationException.initCause(th4);
                synchronized (f42Var.c) {
                    try {
                        f41 f41Var = f42Var.d;
                        if (f41Var != null) {
                            jr2 jr2Var = f42Var.u;
                            c42 c42Var = c42.b;
                            jr2Var.getClass();
                            jr2Var.j(null, c42Var);
                            f41Var.e(cancellationException);
                            f42Var.r = null;
                            f41Var.C(new o0(16, f42Var, th4));
                        } else {
                            f42Var.e = cancellationException;
                            jr2 jr2Var2 = f42Var.u;
                            c42 c42Var2 = c42.a;
                            jr2Var2.getClass();
                            jr2Var2.j(null, c42Var2);
                        }
                    } catch (Throwable th5) {
                        throw th5;
                    }
                }
                return q43.a;
            case 23:
                ((i42) this.b).a((fh0) obj);
                return q43.a;
            case 24:
                ba2 ba2Var2 = ((aa2) this.b).c;
                return Boolean.valueOf(ba2Var2 != null ? ba2Var2.c(obj) : true);
            case 25:
                md2 md2Var = (md2) this.b;
                float fFloatValue = ((Float) obj).floatValue();
                hu1 hu1Var = md2Var.a;
                float fG = hu1Var.g() + fFloatValue + md2Var.f;
                float fB = ky3.b(fG, 0.0f, md2Var.e.g());
                boolean z8 = fG == fB;
                float fG2 = fB - hu1Var.g();
                int iRound2 = Math.round(fG2);
                hu1Var.h(hu1Var.g() + iRound2);
                md2Var.f = fG2 - iRound2;
                if (!z8) {
                    fFloatValue = fG2;
                }
                return Float.valueOf(fFloatValue);
            case 26:
                he2 he2Var = (he2) this.b;
                return new jp1(he2Var.c(he2Var.k, ((jp1) obj).a, he2Var.j));
            case 27:
                s9 s9Var = (s9) this.b;
                ny1 ny1Var = (ny1) obj;
                long j5 = ny1Var.c;
                ny2 ny2Var = (ny2) s9Var.e;
                if (ny2Var.k() && ny2Var.n().a.b.length() != 0 && (ua1Var = ny2Var.d) != null && ua1Var.d() != null) {
                    s9Var.m(ny2Var.n(), j5, false, xy.Y);
                    z3 = true;
                }
                if (z3) {
                    ny1Var.a();
                }
                return q43.a;
            case 28:
                e4 e4Var = (e4) this.b;
                obj.getClass();
                return e4Var.a();
            default:
                ArrayList arrayList = (ArrayList) this.b;
                yw1 yw1Var = (yw1) obj;
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    yw1.h(yw1Var, (zw1) arrayList.get(i7), 0, 0);
                }
                return q43.a;
        }
    }

    public /* synthetic */ x0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
    }
}
