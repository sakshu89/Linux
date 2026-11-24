package defpackage;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.text.Normalizer;
import com.project.sonic.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x7 extends u2 implements View.OnAttachStateChangeListener, AccessibilityManager.AccessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener {
    public static final ll1 x0;
    public boolean H;
    public final ml1 X;
    public final ml1 Y;
    public final mp2 Z;
    public final mp2 c0;
    public int d0;
    public final r7 e;
    public Integer e0;
    public int f = Integer.MIN_VALUE;
    public final pg f0;
    public final un g0;
    public boolean h0;
    public final w7 i;
    public t7 i0;
    public final AccessibilityManager j;
    public ml1 j0;
    public long k;
    public final nl1 k0;
    public final kl1 l0;
    public final kl1 m0;
    public List n;
    public final String n0;
    public final String o0;
    public final b13 p0;
    public final ml1 q0;
    public hg2 r0;
    public final Handler s;
    public boolean s0;
    public final l11 t;
    public final kl1 t0;
    public int u;
    public final s7 u0;
    public int v;
    public final ArrayList v0;
    public h3 w;
    public final w7 w0;
    public h3 x;

    static {
        int[] iArr = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        ll1 ll1Var = b21.a;
        ll1 ll1Var2 = new ll1(32);
        int i = ll1Var2.b;
        if (i < 0) {
            og.o("");
            return;
        }
        int i2 = i + 32;
        ll1Var2.b(i2);
        int[] iArr2 = ll1Var2.a;
        int i3 = ll1Var2.b;
        if (i != i3) {
            qg.e(iArr2, i2, iArr2, i, i3);
        }
        qg.h(iArr, i, iArr2, 0, 12);
        ll1Var2.b += 32;
        x0 = ll1Var2;
    }

    public x7(r7 r7Var) {
        this.e = r7Var;
        int i = 0;
        this.i = new w7(this, i);
        Object systemService = r7Var.getContext().getSystemService("accessibility");
        systemService.getClass();
        this.j = (AccessibilityManager) systemService;
        this.k = 100L;
        this.s = new Handler(Looper.getMainLooper());
        this.t = new l11(this);
        this.u = Integer.MIN_VALUE;
        this.v = Integer.MIN_VALUE;
        this.X = new ml1();
        this.Y = new ml1();
        this.Z = new mp2(0);
        this.c0 = new mp2(0);
        this.d0 = -1;
        this.f0 = new pg(0);
        this.g0 = nh4.a(1, 6, null);
        this.h0 = true;
        ml1 ml1Var = d21.a;
        ml1Var.getClass();
        this.j0 = ml1Var;
        this.k0 = new nl1();
        this.l0 = new kl1();
        this.m0 = new kl1();
        this.n0 = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.o0 = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.p0 = new b13(3);
        this.q0 = new ml1();
        this.r0 = new hg2(r7Var.getSemanticsOwner().a(), ml1Var);
        int i2 = z11.a;
        this.t0 = new kl1();
        r7Var.addOnAttachStateChangeListener(this);
        this.u0 = new s7(i, this);
        this.v0 = new ArrayList();
        this.w0 = new w7(this, 1);
    }

    public static Rect D(es4 es4Var, float f, float f2) {
        if (!(es4Var instanceof us1) && !(es4Var instanceof vs1)) {
            return null;
        }
        l42 l42VarA = es4Var.a();
        return new Rect((int) (l42VarA.a + f), (int) (l42VarA.b + f2), (int) (l42VarA.c + f), (int) (l42VarA.d + f2));
    }

    public static float[] F(es4 es4Var) {
        if (!(es4Var instanceof vs1)) {
            return null;
        }
        s82 s82Var = ((vs1) es4Var).a;
        long j = s82Var.h;
        long j2 = s82Var.g;
        long j3 = s82Var.f;
        long j4 = s82Var.e;
        return new float[]{Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L))};
    }

    public static Region G(es4 es4Var, float f, float f2) {
        if (es4Var instanceof ts1) {
            ts1 ts1Var = (ts1) es4Var;
            l42 l42VarH = ts1Var.a().h(f, f2);
            Region region = new Region(new Rect((int) (l42VarH.a + 0.0f), (int) (l42VarH.b + 0.0f), (int) (l42VarH.c + 0.0f), (int) (l42VarH.d + 0.0f)));
            Region region2 = new Region();
            na naVar = ts1Var.a;
            if (naVar instanceof na) {
                Path path = naVar.a;
                path.offset(f, f2);
                region2.setPath(path, region);
                return region2;
            }
            dk0.r("Unable to obtain android.graphics.Path");
        }
        return null;
    }

    public static CharSequence H(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            int i = 100000;
            if (charSequence.length() > 100000) {
                if (Character.isHighSurrogate(charSequence.charAt(99999)) && Character.isLowSurrogate(charSequence.charAt(100000))) {
                    i = 99999;
                }
                CharSequence charSequenceSubSequence = charSequence.subSequence(0, i);
                charSequenceSubSequence.getClass();
                return charSequenceSubSequence;
            }
        }
        return charSequence;
    }

    public static String l(gg2 gg2Var) {
        be beVar;
        if (gg2Var != null) {
            cg2 cg2Var = gg2Var.d;
            gm1 gm1Var = cg2Var.a;
            ng2 ng2Var = kg2.a;
            if (gm1Var.c(ng2Var)) {
                return vc1.a((List) cg2Var.d(ng2Var), ",", null, 62);
            }
            ng2 ng2Var2 = kg2.E;
            if (gm1Var.c(ng2Var2)) {
                Object objG = gm1Var.g(ng2Var2);
                if (objG == null) {
                    objG = null;
                }
                be beVar2 = (be) objG;
                if (beVar2 != null) {
                    return beVar2.b;
                }
            } else {
                Object objG2 = gm1Var.g(kg2.A);
                if (objG2 == null) {
                    objG2 = null;
                }
                List list = (List) objG2;
                if (list != null && (beVar = (be) mz.y(list)) != null) {
                    return beVar.b;
                }
            }
        }
        return null;
    }

    public static final boolean p(ed2 ed2Var, float f) {
        fq0 fq0Var = ed2Var.a;
        if (f >= 0.0f || ((Number) fq0Var.a()).floatValue() <= 0.0f) {
            return f > 0.0f && ((Number) fq0Var.a()).floatValue() < ((Number) ed2Var.b.a()).floatValue();
        }
        return true;
    }

    public static final boolean q(ed2 ed2Var) {
        fq0 fq0Var = ed2Var.a;
        if (((Number) fq0Var.a()).floatValue() > 0.0f) {
            return true;
        }
        ((Number) fq0Var.a()).floatValue();
        ((Number) ed2Var.b.a()).floatValue();
        return false;
    }

    public static final boolean r(ed2 ed2Var) {
        fq0 fq0Var = ed2Var.a;
        if (((Number) fq0Var.a()).floatValue() < ((Number) ed2Var.b.a()).floatValue()) {
            return true;
        }
        ((Number) fq0Var.a()).floatValue();
        return false;
    }

    public static /* synthetic */ void w(x7 x7Var, int i, int i2, Integer num, int i3) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        x7Var.v(i, i2, num, null);
    }

    public final void A(n71 n71Var, nl1 nl1Var) {
        cg2 cg2VarW;
        if (n71Var.H() && !this.e.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(n71Var)) {
            n71 n71Var2 = null;
            if (!n71Var.o0.d(8)) {
                n71Var = n71Var.u();
                while (true) {
                    if (n71Var == null) {
                        n71Var = null;
                        break;
                    } else if (n71Var.o0.d(8)) {
                        break;
                    } else {
                        n71Var = n71Var.u();
                    }
                }
            }
            if (n71Var == null || (cg2VarW = n71Var.w()) == null) {
                return;
            }
            if (!cg2VarW.c) {
                for (n71 n71VarU = n71Var.u(); n71VarU != null; n71VarU = n71VarU.u()) {
                    cg2 cg2VarW2 = n71VarU.w();
                    if (cg2VarW2 != null && cg2VarW2.c) {
                        n71Var2 = n71VarU;
                        break;
                    }
                }
                if (n71Var2 != null) {
                    n71Var = n71Var2;
                }
            }
            int i = n71Var.b;
            if (nl1Var.a(i)) {
                w(this, s(i), 2048, 1, 8);
            }
        }
    }

    public final void B(n71 n71Var) {
        if (n71Var.H() && !this.e.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(n71Var)) {
            int i = n71Var.b;
            ed2 ed2Var = (ed2) this.X.b(i);
            ed2 ed2Var2 = (ed2) this.Y.b(i);
            if (ed2Var == null && ed2Var2 == null) {
                return;
            }
            AccessibilityEvent accessibilityEventG = g(i, 4096);
            if (ed2Var != null) {
                accessibilityEventG.setScrollX((int) ((Number) ed2Var.a.a()).floatValue());
                accessibilityEventG.setMaxScrollX((int) ((Number) ed2Var.b.a()).floatValue());
            }
            if (ed2Var2 != null) {
                accessibilityEventG.setScrollY((int) ((Number) ed2Var2.a.a()).floatValue());
                accessibilityEventG.setMaxScrollY((int) ((Number) ed2Var2.b.a()).floatValue());
            }
            u(accessibilityEventG);
        }
    }

    public final boolean C(gg2 gg2Var, int i, int i2, boolean z) {
        String strL;
        cg2 cg2Var = gg2Var.d;
        int i3 = gg2Var.g;
        ng2 ng2Var = bg2.j;
        if (cg2Var.a.c(ng2Var) && pc4.a(gg2Var)) {
            wq0 wq0Var = (wq0) ((b2) gg2Var.d.d(ng2Var)).b;
            if (wq0Var != null) {
                return ((Boolean) wq0Var.c(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
            }
        } else if ((i != i2 || i2 != this.d0) && (strL = l(gg2Var)) != null) {
            if (i < 0 || i != i2 || i2 > strL.length()) {
                i = -1;
            }
            this.d0 = i;
            boolean z2 = strL.length() > 0;
            u(h(s(i3), z2 ? Integer.valueOf(this.d0) : null, z2 ? Integer.valueOf(this.d0) : null, z2 ? Integer.valueOf(strL.length()) : null, strL));
            y(i3);
            return true;
        }
        return false;
    }

    public final Rect E(float f, float f2, float f3, float f4) {
        long jFloatToRawIntBits = Float.floatToRawIntBits(f);
        long jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(f2)) & 4294967295L;
        r7 r7Var = this.e;
        long jP = r7Var.p(jFloatToRawIntBits2 | (jFloatToRawIntBits << 32));
        long jP2 = r7Var.p((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
        int i = (int) (jP >> 32);
        int i2 = (int) (jP2 >> 32);
        int i3 = (int) (jP & 4294967295L);
        int i4 = (int) (jP2 & 4294967295L);
        return new Rect((int) Math.floor(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.floor(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0064  */
    /* JADX WARN: Code duplicated, block: B:20:0x006f  */
    /* JADX WARN: Code duplicated, block: B:23:0x007c  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void I() {
        long j;
        long j2;
        long j3;
        char c;
        long[] jArr;
        long[] jArr2;
        long j4;
        int i;
        int iNumberOfTrailingZeros;
        char c2;
        hg2 hg2Var;
        nl1 nl1Var = new nl1();
        nl1 nl1Var2 = this.k0;
        int[] iArr = nl1Var2.b;
        long[] jArr3 = nl1Var2.a;
        int length = jArr3.length - 2;
        ml1 ml1Var = this.q0;
        int i2 = 8;
        if (length >= 0) {
            int i3 = 0;
            j = 128;
            j2 = 255;
            while (true) {
                long j5 = jArr3[i3];
                char c3 = 7;
                j3 = -9187201950435737472L;
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j5 & 255) < 128) {
                            int i6 = iArr[(i3 << 3) + i5];
                            c2 = c3;
                            ig2 ig2Var = (ig2) k().b(i6);
                            Object obj = null;
                            gg2 gg2Var = ig2Var != null ? ig2Var.a : null;
                            if (gg2Var != null) {
                                if (!gg2Var.d.a.c(kg2.d)) {
                                    nl1Var.a(i6);
                                    hg2Var = (hg2) ml1Var.b(i6);
                                    if (hg2Var != null) {
                                        Object objG = hg2Var.a.a.g(kg2.d);
                                        obj = (String) (objG != null ? objG : null);
                                    }
                                    x(i6, 32, obj);
                                }
                            } else {
                                nl1Var.a(i6);
                                hg2Var = (hg2) ml1Var.b(i6);
                                if (hg2Var != null) {
                                    Object objG2 = hg2Var.a.a.g(kg2.d);
                                    obj = (String) (objG2 != null ? objG2 : null);
                                }
                                x(i6, 32, obj);
                            }
                        } else {
                            c2 = c3;
                        }
                        j5 >>= 8;
                        i5++;
                        c3 = c2;
                    }
                    c = c3;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    c = 7;
                }
                if (i3 == length) {
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            j = 128;
            j2 = 255;
            j3 = -9187201950435737472L;
            c = 7;
        }
        int[] iArr2 = nl1Var.b;
        long[] jArr4 = nl1Var.a;
        int length2 = jArr4.length - 2;
        if (length2 >= 0) {
            int i7 = 0;
            while (true) {
                long j6 = jArr4[i7];
                if ((((~j6) << c) & j6 & j3) != j3) {
                    int i8 = 8 - ((~(i7 - length2)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((j6 & j2) < j) {
                            int i10 = iArr2[(i7 << 3) + i9];
                            int iHashCode = Integer.hashCode(i10) * (-862048943);
                            int i11 = iHashCode ^ (iHashCode << 16);
                            int i12 = i11 & 127;
                            int i13 = nl1Var2.c;
                            int i14 = (i11 >>> 7) & i13;
                            i = i2;
                            int i15 = 0;
                            while (true) {
                                long[] jArr5 = nl1Var2.a;
                                int i16 = i14 >> 3;
                                jArr2 = jArr4;
                                int i17 = (i14 & 7) << 3;
                                j4 = j6;
                                long j7 = (jArr5[i16] >>> i17) | ((jArr5[i16 + 1] << (64 - i17)) & ((-i17) >> 63));
                                int i18 = i13;
                                long j8 = (((long) i12) * 72340172838076673L) ^ j7;
                                long j9 = (j8 - 72340172838076673L) & (~j8) & j3;
                                while (j9 != 0) {
                                    iNumberOfTrailingZeros = (i14 + (Long.numberOfTrailingZeros(j9) >> 3)) & i18;
                                    int i19 = i18;
                                    if (nl1Var2.b[iNumberOfTrailingZeros] == i10) {
                                        break;
                                    }
                                    j9 &= j9 - 1;
                                    i18 = i19;
                                }
                                int i20 = i18;
                                if ((j7 & ((~j7) << 6) & j3) != 0) {
                                    iNumberOfTrailingZeros = -1;
                                    break;
                                }
                                i15 += 8;
                                i14 = (i14 + i15) & i20;
                                jArr4 = jArr2;
                                i13 = i20;
                                j6 = j4;
                            }
                            int i21 = iNumberOfTrailingZeros;
                            if (i21 >= 0) {
                                nl1Var2.f(i21);
                            }
                        } else {
                            jArr2 = jArr4;
                            j4 = j6;
                            i = i2;
                        }
                        j6 = j4 >> i;
                        i9++;
                        i2 = i;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i8 != i2) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i7 == length2) {
                    break;
                }
                i7++;
                jArr4 = jArr;
                i2 = 8;
            }
        }
        ml1Var.c();
        c21 c21VarK = k();
        int[] iArr3 = c21VarK.b;
        Object[] objArr = c21VarK.c;
        long[] jArr6 = c21VarK.a;
        int length3 = jArr6.length - 2;
        if (length3 >= 0) {
            int i22 = 0;
            while (true) {
                long j10 = jArr6[i22];
                if ((((~j10) << c) & j10 & j3) != j3) {
                    int i23 = 8 - ((~(i22 - length3)) >>> 31);
                    for (int i24 = 0; i24 < i23; i24++) {
                        if ((j10 & j2) < j) {
                            int i25 = (i22 << 3) + i24;
                            int i26 = iArr3[i25];
                            gg2 gg2Var2 = ((ig2) objArr[i25]).a;
                            cg2 cg2Var = gg2Var2.d;
                            ng2 ng2Var = kg2.d;
                            if (cg2Var.a.c(ng2Var) && nl1Var2.a(i26)) {
                                x(i26, 16, (String) gg2Var2.d.d(ng2Var));
                            }
                            ml1Var.h(i26, new hg2(gg2Var2, k()));
                        }
                        j10 >>= 8;
                    }
                    if (i23 != 8) {
                        break;
                    }
                }
                if (i22 == length3) {
                    break;
                } else {
                    i22++;
                }
            }
        }
        this.r0 = new hg2(this.e.getSemanticsOwner().a(), k());
    }

    @Override // defpackage.u2
    public final l11 a(View view) {
        return this.t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(int i, h3 h3Var, String str, Bundle bundle) {
        gg2 gg2Var;
        r7 r7Var;
        RectF rectF;
        AccessibilityNodeInfo accessibilityNodeInfo = h3Var.a;
        ig2 ig2Var = (ig2) k().b(i);
        if (ig2Var == null || (gg2Var = ig2Var.a) == null) {
            return;
        }
        n71 n71Var = gg2Var.c;
        cg2 cg2Var = gg2Var.d;
        gm1 gm1Var = cg2Var.a;
        String strL = l(gg2Var);
        if (g31.a(str, this.n0)) {
            int iD = this.l0.d(i);
            if (iD != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, iD);
                return;
            }
            return;
        }
        if (g31.a(str, this.o0)) {
            int iD2 = this.m0.d(i);
            if (iD2 != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, iD2);
                return;
            }
            return;
        }
        boolean zC = gm1Var.c(bg2.a);
        r7 r7Var2 = this.e;
        co1 co1Var = null;
        if (zC && bundle != null && g31.a(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            int i2 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int i3 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (i3 > 0 && i2 >= 0) {
                if (i2 < (strL != null ? strL.length() : Integer.MAX_VALUE)) {
                    gz2 gz2VarA = e34.a(cg2Var);
                    if (gz2VarA == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    int i4 = 0;
                    while (i4 < i3) {
                        int i5 = i2 + i4;
                        if (i5 >= gz2VarA.a.a.b.length()) {
                            arrayList.add(co1Var);
                            i2 = i2;
                            i3 = i3;
                            r7Var = r7Var2;
                        } else {
                            l42 l42VarB = gz2VarA.b(i5);
                            co1 co1VarD = gg2Var.d();
                            long jU = 0;
                            if (co1VarD != null) {
                                if (!co1VarD.V0().w) {
                                    co1VarD = co1Var;
                                }
                                if (co1VarD != null) {
                                    jU = co1VarD.U(0L);
                                }
                            }
                            l42 l42VarI = l42VarB.i(jU);
                            l42 l42VarG = gg2Var.g();
                            l42 l42VarE = l42VarI.g(l42VarG) ? l42VarI.e(l42VarG) : co1Var;
                            if (l42VarE != 0) {
                                long jP = r7Var2.p((((long) Float.floatToRawIntBits(l42VarE.b)) & 4294967295L) | (((long) Float.floatToRawIntBits(l42VarE.a)) << 32));
                                r7Var = r7Var2;
                                long jP2 = r7Var.p((((long) Float.floatToRawIntBits(l42VarE.d)) & 4294967295L) | (((long) Float.floatToRawIntBits(l42VarE.c)) << 32));
                                int i6 = (int) (jP >> 32);
                                int i7 = (int) (jP2 >> 32);
                                int i8 = (int) (jP & 4294967295L);
                                int i9 = (int) (jP2 & 4294967295L);
                                rectF = new RectF(Math.min(Float.intBitsToFloat(i6), Float.intBitsToFloat(i7)), Math.min(Float.intBitsToFloat(i8), Float.intBitsToFloat(i9)), Math.max(Float.intBitsToFloat(i6), Float.intBitsToFloat(i7)), Math.max(Float.intBitsToFloat(i8), Float.intBitsToFloat(i9)));
                            } else {
                                r7Var = r7Var2;
                                rectF = null;
                            }
                            arrayList.add(rectF);
                        }
                        i4++;
                        i3 = i3;
                        r7Var2 = r7Var;
                        i2 = i2;
                        co1Var = null;
                    }
                    accessibilityNodeInfo.getExtras().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                    return;
                }
            }
            Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
            return;
        }
        ng2 ng2Var = kg2.y;
        if (gm1Var.c(ng2Var) && bundle != null && g31.a(str, "androidx.compose.ui.semantics.testTag")) {
            Object objG = gm1Var.g(ng2Var);
            String str2 = (String) (objG == null ? null : objG);
            if (str2 != null) {
                accessibilityNodeInfo.getExtras().putCharSequence(str, str2);
                return;
            }
            return;
        }
        if (g31.a(str, "androidx.compose.ui.semantics.id")) {
            accessibilityNodeInfo.getExtras().putInt(str, gg2Var.g);
            return;
        }
        if (g31.a(str, "androidx.compose.ui.semantics.shapeType")) {
            Object objG2 = gm1Var.g(kg2.O);
            yj2 yj2Var = (yj2) (objG2 == null ? null : objG2);
            if (yj2Var != null) {
                Rect rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);
                l42 l42VarM = m(gg2Var, rect, yj2Var);
                float f = l42VarM.b;
                float f2 = l42VarM.a;
                es4 es4VarA = yj2Var.a(l42VarM.c(), n71Var.i0, r7Var2.getDensity());
                if (es4VarA instanceof us1) {
                    accessibilityNodeInfo.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 0);
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", D(es4VarA, f2, f));
                    return;
                } else if (es4VarA instanceof vs1) {
                    accessibilityNodeInfo.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 1);
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", D(es4VarA, f2, f));
                    accessibilityNodeInfo.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", F(es4VarA));
                    return;
                } else if (!(es4VarA instanceof ts1)) {
                    dk0.l();
                    return;
                } else {
                    accessibilityNodeInfo.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 2);
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", G(es4VarA, f2, f));
                    return;
                }
            }
            return;
        }
        if (g31.a(str, "androidx.compose.ui.semantics.shapeRect")) {
            Object objG3 = gm1Var.g(kg2.O);
            yj2 yj2Var2 = (yj2) (objG3 == null ? null : objG3);
            if (yj2Var2 != null) {
                Rect rect2 = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect2);
                l42 l42VarM2 = m(gg2Var, rect2, yj2Var2);
                Rect rectD = D(yj2Var2.a(l42VarM2.c(), n71Var.i0, r7Var2.getDensity()), l42VarM2.a, l42VarM2.b);
                if (rectD != null) {
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", rectD);
                    return;
                }
                return;
            }
            return;
        }
        if (g31.a(str, "androidx.compose.ui.semantics.shapeCorners")) {
            Object objG4 = gm1Var.g(kg2.O);
            yj2 yj2Var3 = (yj2) (objG4 == null ? null : objG4);
            if (yj2Var3 != null) {
                Rect rect3 = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect3);
                float[] fArrF = F(yj2Var3.a(m(gg2Var, rect3, yj2Var3).c(), n71Var.i0, r7Var2.getDensity()));
                if (fArrF != null) {
                    accessibilityNodeInfo.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", fArrF);
                    return;
                }
                return;
            }
            return;
        }
        if (g31.a(str, "androidx.compose.ui.semantics.shapeRegion")) {
            Object objG5 = gm1Var.g(kg2.O);
            yj2 yj2Var4 = (yj2) (objG5 == null ? null : objG5);
            if (yj2Var4 != null) {
                Rect rect4 = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect4);
                l42 l42VarM3 = m(gg2Var, rect4, yj2Var4);
                Region regionG = G(yj2Var4.a(l42VarM3.c(), n71Var.i0, r7Var2.getDensity()), l42VarM3.a, l42VarM3.b);
                if (regionG != null) {
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", regionG);
                }
            }
        }
    }

    public final Rect c(ig2 ig2Var) {
        i21 i21Var = ig2Var.b;
        return E(i21Var.a, i21Var.b, i21Var.c, i21Var.d);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0068  */
    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0076 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x005c, B:28:0x006e, B:30:0x0076, B:32:0x007f, B:34:0x0085, B:35:0x0094, B:37:0x009c, B:20:0x0046, B:23:0x004d), top: B:57:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007f A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x005c, B:28:0x006e, B:30:0x0076, B:32:0x007f, B:34:0x0085, B:35:0x0094, B:37:0x009c, B:20:0x0046, B:23:0x004d), top: B:57:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0085 A[Catch: all -> 0x0037, LOOP:0: B:33:0x0083->B:34:0x0085, LOOP_END, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x005c, B:28:0x006e, B:30:0x0076, B:32:0x007f, B:34:0x0085, B:35:0x0094, B:37:0x009c, B:20:0x0046, B:23:0x004d), top: B:57:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009c A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x005c, B:28:0x006e, B:30:0x0076, B:32:0x007f, B:34:0x0085, B:35:0x0094, B:37:0x009c, B:20:0x0046, B:23:0x004d), top: B:57:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ca A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:39:0x00b7, B:41:0x00bb, B:43:0x00ca, B:47:0x00d7), top: B:55:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f1, code lost:
    
        if (defpackage.bm4.b(r4, r2) == r7) goto L49;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00f1 -> B:50:0x00f4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(defpackage.y50 r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x7.d(y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00f9  */
    public final boolean e(long j, int i, boolean z) {
        ng2 ng2Var;
        int i2;
        if (g31.a(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            c21 c21VarK = k();
            if (!jp1.b(j, 9205357640488583168L) && (((9223372034707292159L & j) + 36028792732385279L) & (-9223372034707292160L)) == 0) {
                if (z) {
                    ng2Var = kg2.v;
                } else {
                    if (z) {
                        dk0.l();
                        return false;
                    }
                    ng2Var = kg2.u;
                }
                Object[] objArr = c21VarK.c;
                long[] jArr = c21VarK.a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i3 = 0;
                    boolean z2 = false;
                    while (true) {
                        long j2 = jArr[i3];
                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i4 = 8;
                            int i5 = 8 - ((~(i3 - length)) >>> 31);
                            int i6 = 0;
                            while (i6 < i5) {
                                if ((255 & j2) < 128) {
                                    ig2 ig2Var = (ig2) objArr[(i3 << 3) + i6];
                                    i21 i21Var = ig2Var.b;
                                    float f = i21Var.a;
                                    i2 = i4;
                                    float f2 = i21Var.b;
                                    float f3 = i21Var.c;
                                    float f4 = i21Var.d;
                                    float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
                                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
                                    if ((fIntBitsToFloat2 < f4) & (fIntBitsToFloat >= f) & (fIntBitsToFloat < f3) & (fIntBitsToFloat2 >= f2)) {
                                        Object objG = ig2Var.a.d.a.g(ng2Var);
                                        if (objG == null) {
                                            objG = null;
                                        }
                                        ed2 ed2Var = (ed2) objG;
                                        if (ed2Var != null) {
                                            fq0 fq0Var = ed2Var.a;
                                            if (i < 0) {
                                                if (((Number) fq0Var.a()).floatValue() > 0.0f) {
                                                    z2 = true;
                                                }
                                            } else if (((Number) fq0Var.a()).floatValue() < ((Number) ed2Var.b.a()).floatValue()) {
                                                z2 = true;
                                            }
                                        }
                                    }
                                } else {
                                    i2 = i4;
                                }
                                j2 >>= i2;
                                i6++;
                                i4 = i2;
                            }
                            if (i5 != i4) {
                                return z2;
                            }
                        }
                        if (i3 == length) {
                            return z2;
                        }
                        i3++;
                    }
                }
            }
        }
        return false;
    }

    public final void f() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (n()) {
                t(this.e.getSemanticsOwner().a(), this.r0);
            }
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                z(k());
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    I();
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public final AccessibilityEvent g(int i, int i2) {
        ig2 ig2Var;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName("android.view.View");
        r7 r7Var = this.e;
        accessibilityEventObtain.setPackageName(r7Var.getContext().getPackageName());
        accessibilityEventObtain.setSource(r7Var, i);
        if (n() && (ig2Var = (ig2) k().b(i)) != null) {
            gg2 gg2Var = ig2Var.a;
            accessibilityEventObtain.setPassword(gg2Var.d.a.c(kg2.J));
            Object objG = gg2Var.d.a.g(kg2.n);
            if (objG == null) {
                objG = null;
            }
            boolean zA = g31.a(objG, Boolean.TRUE);
            if (Build.VERSION.SDK_INT >= 34) {
                v2.k(accessibilityEventObtain, zA);
            }
        }
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent h(int i, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent accessibilityEventG = g(i, 8192);
        if (num != null) {
            accessibilityEventG.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            accessibilityEventG.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            accessibilityEventG.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            accessibilityEventG.getText().add(charSequence);
        }
        return accessibilityEventG;
    }

    public final int i(gg2 gg2Var) {
        cg2 cg2Var = gg2Var.d;
        if (!cg2Var.a.c(kg2.a)) {
            ng2 ng2Var = kg2.F;
            if (cg2Var.a.c(ng2Var)) {
                return (int) (((oz2) cg2Var.d(ng2Var)).a & 4294967295L);
            }
        }
        return this.d0;
    }

    public final int j(gg2 gg2Var) {
        cg2 cg2Var = gg2Var.d;
        if (!cg2Var.a.c(kg2.a)) {
            ng2 ng2Var = kg2.F;
            if (cg2Var.a.c(ng2Var)) {
                return (int) (((oz2) cg2Var.d(ng2Var)).a >> 32);
            }
        }
        return this.d0;
    }

    public final c21 k() {
        if (this.h0) {
            this.h0 = false;
            r7 r7Var = this.e;
            this.j0 = o44.c(r7Var.getSemanticsOwner(), j7.e);
            if (n()) {
                ml1 ml1Var = this.j0;
                Resources resources = r7Var.getContext().getResources();
                kl1 kl1Var = this.l0;
                kl1Var.a();
                kl1 kl1Var2 = this.m0;
                kl1Var2.a();
                ig2 ig2Var = (ig2) ml1Var.b(-1);
                gg2 gg2Var = ig2Var != null ? ig2Var.a : null;
                gg2Var.getClass();
                ArrayList arrayListB = pg2.b(gg2Var, new h6(3, ml1Var), new h6(4, resources), nz.h(gg2Var));
                int i = 1;
                int size = arrayListB.size() - 1;
                if (1 <= size) {
                    while (true) {
                        int i2 = ((gg2) arrayListB.get(i - 1)).g;
                        int i3 = ((gg2) arrayListB.get(i)).g;
                        kl1Var.f(i2, i3);
                        kl1Var2.f(i3, i2);
                        if (i == size) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return this.j0;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0073 A[LOOP:0: B:4:0x0014->B:36:0x0073, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x0076 A[EDGE_INSN: B:47:0x0076->B:37:0x0076 BREAK  A[LOOP:0: B:4:0x0014->B:36:0x0073], SYNTHETIC] */
    public final l42 m(gg2 gg2Var, Rect rect, yj2 yj2Var) {
        v7 v7Var = new v7(yj2Var);
        n71 n71Var = gg2Var.c;
        dk1 dk1Var = n71Var.o0.f;
        xb0 xb0Var = null;
        if ((dk1Var.e & 8) != 0) {
            loop0: while (dk1Var != null) {
                if ((dk1Var.c & 8) == 0) {
                    if ((dk1Var.e & 8) != 0) {
                        break;
                        break;
                    }
                    dk1Var = dk1Var.i;
                } else {
                    dk1 dk1VarB = dk1Var;
                    pm1 pm1Var = null;
                    while (dk1VarB != null) {
                        if (dk1VarB instanceof eg2) {
                            ((eg2) dk1VarB).e0(v7Var);
                            if (v7Var.a) {
                                xb0Var = dk1VarB;
                                break loop0;
                            }
                        } else if ((dk1VarB.c & 8) != 0 && (dk1VarB instanceof zb0)) {
                            int i = 0;
                            for (dk1 dk1Var2 = ((zb0) dk1VarB).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                                if ((dk1Var2.c & 8) != 0) {
                                    i++;
                                    if (i == 1) {
                                        dk1VarB = dk1Var2;
                                    } else {
                                        if (pm1Var == null) {
                                            pm1Var = new pm1(new dk1[16]);
                                        }
                                        if (dk1VarB != null) {
                                            pm1Var.b(dk1VarB);
                                            dk1VarB = null;
                                        }
                                        pm1Var.b(dk1Var2);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        dk1VarB = cm4.b(pm1Var);
                    }
                    if ((dk1Var.e & 8) != 0) {
                        break;
                    }
                    dk1Var = dk1Var.i;
                }
            }
        }
        xb0 xb0Var2 = (eg2) xb0Var;
        if (xb0Var2 == null || !((dk1) xb0Var2).a.w) {
            return pp4.b(n71Var.o0.d, false);
        }
        co1 co1VarF = cm4.f(xb0Var2);
        l42 l42VarN = pp4.c(co1VarF).N(co1VarF, true);
        Rect rectE = E(l42VarN.a, l42VarN.b, l42VarN.c, l42VarN.d);
        float f = rectE.left - rect.left;
        float f2 = rectE.top - rect.top;
        return new l42(f, f2, rectE.width() + f, rectE.height() + f2);
    }

    public final boolean n() {
        AccessibilityManager accessibilityManager = this.j;
        if (!accessibilityManager.isEnabled()) {
            return false;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.n;
        if (enabledAccessibilityServiceList == null) {
            enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1);
            this.n = enabledAccessibilityServiceList;
        }
        return !enabledAccessibilityServiceList.isEmpty();
    }

    public final void o(n71 n71Var) {
        if (this.f0.add(n71Var)) {
            this.g0.s(q43.a);
        }
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        this.n = null;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        this.n = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        AccessibilityManager accessibilityManager = this.j;
        if (accessibilityManager.isEnabled()) {
            this.n = null;
        }
        accessibilityManager.addAccessibilityStateChangeListener(this);
        accessibilityManager.addTouchExplorationStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.s.removeCallbacks(this.u0);
        AccessibilityManager accessibilityManager = this.j;
        accessibilityManager.removeAccessibilityStateChangeListener(this);
        accessibilityManager.removeTouchExplorationStateChangeListener(this);
    }

    public final int s(int i) {
        if (i == this.e.getSemanticsOwner().a().g) {
            return -1;
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0088 A[LOOP:1: B:15:0x004c->B:28:0x0088, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x008b A[EDGE_INSN: B:44:0x008b->B:29:0x008b BREAK  A[LOOP:1: B:15:0x004c->B:28:0x0088], SYNTHETIC] */
    public final void t(gg2 gg2Var, hg2 hg2Var) {
        int[] iArr = k21.a;
        nl1 nl1Var = new nl1();
        List listI = gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0);
        n71 n71Var = gg2Var.c;
        int size = listI.size();
        for (int i = 0; i < size; i++) {
            gg2 gg2Var2 = (gg2) listI.get(i);
            c21 c21VarK = k();
            int i2 = gg2Var2.g;
            if (c21VarK.a(i2)) {
                if (!hg2Var.b.b(i2)) {
                    o(n71Var);
                    return;
                }
                nl1Var.a(i2);
            }
        }
        nl1 nl1Var2 = hg2Var.b;
        int[] iArr2 = nl1Var2.b;
        long[] jArr = nl1Var2.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i3 != length) {
                        break;
                        break;
                    }
                    i3++;
                } else {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128 && !nl1Var.b(iArr2[(i3 << 3) + i5])) {
                            o(n71Var);
                            return;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    } else if (i3 != length) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        List listI2 = gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0);
        int size2 = listI2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            gg2 gg2Var3 = (gg2) listI2.get(i6);
            hg2 hg2Var2 = (hg2) this.q0.b(gg2Var3.g);
            if (hg2Var2 != null && k().a(gg2Var3.g)) {
                t(gg2Var3, hg2Var2);
            }
        }
    }

    public final boolean u(AccessibilityEvent accessibilityEvent) {
        if (!n()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.H = true;
        }
        try {
            return ((Boolean) this.i.j(accessibilityEvent)).booleanValue();
        } finally {
            this.H = false;
        }
    }

    public final boolean v(int i, int i2, Integer num, List list) {
        if (i == Integer.MIN_VALUE || !n()) {
            return false;
        }
        AccessibilityEvent accessibilityEventG = g(i, i2);
        if (num != null) {
            accessibilityEventG.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            accessibilityEventG.setContentDescription(vc1.a(list, ",", null, 62));
        }
        return u(accessibilityEventG);
    }

    public final void x(int i, int i2, String str) {
        AccessibilityEvent accessibilityEventG = g(s(i), 32);
        accessibilityEventG.setContentChangeTypes(i2);
        if (str != null) {
            accessibilityEventG.getText().add(str);
        }
        u(accessibilityEventG);
    }

    public final void y(int i) {
        t7 t7Var = this.i0;
        if (t7Var != null) {
            gg2 gg2Var = t7Var.a;
            if (i != gg2Var.g) {
                return;
            }
            if (SystemClock.uptimeMillis() - t7Var.f <= 1000) {
                AccessibilityEvent accessibilityEventG = g(s(gg2Var.g), Normalizer.INPUT_IS_FCD);
                accessibilityEventG.setFromIndex(t7Var.d);
                accessibilityEventG.setToIndex(t7Var.e);
                accessibilityEventG.setAction(t7Var.b);
                accessibilityEventG.setMovementGranularity(t7Var.c);
                accessibilityEventG.getText().add(l(gg2Var));
                u(accessibilityEventG);
            }
        }
        this.i0 = null;
    }

    /* JADX WARN: Code duplicated, block: B:191:0x042a  */
    /* JADX WARN: Code duplicated, block: B:256:0x0589  */
    /* JADX WARN: Code duplicated, block: B:47:0x011c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    /* JADX WARN: Code duplicated, block: B:52:0x012a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0132  */
    /* JADX WARN: Code duplicated, block: B:55:0x013a  */
    /* JADX WARN: Code duplicated, block: B:57:0x0145  */
    /* JADX WARN: Code duplicated, block: B:60:0x0159  */
    /* JADX WARN: Code duplicated, block: B:62:0x0161  */
    /* JADX WARN: Code duplicated, block: B:64:0x0169  */
    public final void z(c21 c21Var) {
        Integer num;
        ArrayList arrayList;
        int[] iArr;
        long[] jArr;
        int i;
        ArrayList arrayList2;
        int[] iArr2;
        long[] jArr2;
        int i2;
        int i3;
        Integer num2;
        cg2 cg2Var;
        gg2 gg2Var;
        int i4;
        boolean z;
        boolean z2;
        gm1 gm1Var;
        int i5;
        int i6;
        cg2 cg2Var2;
        int i7;
        long j;
        int i8;
        int i9;
        int i10;
        gg2 gg2Var2;
        jd2 jd2Var;
        boolean z3;
        ng2 ng2Var;
        jd2 jd2Var2;
        rq0 rq0Var;
        int i11;
        String str;
        int i12;
        int i13;
        int i14;
        Integer num3;
        AccessibilityEvent accessibilityEventH;
        String str2;
        Object objG;
        c21 c21Var2 = c21Var;
        ArrayList arrayList3 = this.v0;
        ArrayList arrayList4 = new ArrayList(arrayList3);
        arrayList3.clear();
        int[] iArr3 = c21Var2.b;
        long[] jArr3 = c21Var2.a;
        int i15 = 2;
        int length = jArr3.length - 2;
        int i16 = 0;
        Integer num4 = 0;
        if (length < 0) {
            return;
        }
        int i17 = 0;
        while (true) {
            long j2 = jArr3[i17];
            int i18 = i15;
            int i19 = length;
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i20 = 8;
                int i21 = 8 - ((~(i17 - i19)) >>> 31);
                long j3 = j2;
                int i22 = i16;
                while (i22 < i21) {
                    if ((j3 & 255) < 128) {
                        int i23 = iArr3[(i17 << 3) + i22];
                        hg2 hg2Var = (hg2) this.q0.b(i23);
                        if (hg2Var == null) {
                            i = i22;
                            arrayList2 = arrayList4;
                            iArr2 = iArr3;
                            jArr2 = jArr3;
                            i2 = i20;
                            i3 = i21;
                            num2 = num4;
                        } else {
                            cg2 cg2Var3 = hg2Var.a;
                            gm1 gm1Var2 = cg2Var3.a;
                            ig2 ig2Var = (ig2) c21Var2.b(i23);
                            gg2 gg2Var3 = ig2Var != null ? ig2Var.a : null;
                            if (gg2Var3 == null) {
                                throw cq.e("no value for specified key");
                            }
                            int i24 = i20;
                            int i25 = gg2Var3.g;
                            cg2 cg2Var4 = gg2Var3.d;
                            iArr2 = iArr3;
                            gm1 gm1Var3 = cg2Var4.a;
                            jArr2 = jArr3;
                            Object[] objArr = gm1Var3.b;
                            Object[] objArr2 = gm1Var3.c;
                            long[] jArr4 = gm1Var3.a;
                            i = i22;
                            int length2 = jArr4.length - 2;
                            if (length2 >= 0) {
                                i3 = i21;
                                gg2 gg2Var4 = gg2Var3;
                                int i26 = 0;
                                z = false;
                                while (true) {
                                    long j4 = jArr4[i26];
                                    int i27 = i26;
                                    int i28 = i25;
                                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i29 = 8 - ((~(i27 - length2)) >>> 31);
                                        int i30 = 0;
                                        while (i30 < i29) {
                                            if ((j4 & 255) < 128) {
                                                int i31 = (i27 << 3) + i30;
                                                Object obj = objArr[i31];
                                                int i32 = length2;
                                                Object obj2 = objArr2[i31];
                                                cg2Var2 = cg2Var3;
                                                ng2 ng2Var2 = (ng2) obj;
                                                i7 = i30;
                                                ng2 ng2Var3 = kg2.u;
                                                if (g31.a(ng2Var2, ng2Var3)) {
                                                    j = j4;
                                                } else {
                                                    j = j4;
                                                    if (!g31.a(ng2Var2, kg2.v)) {
                                                        z3 = false;
                                                    }
                                                    if (z3) {
                                                        ng2Var = kg2.d;
                                                        if (g31.a(ng2Var2, ng2Var)) {
                                                            obj2.getClass();
                                                            str2 = (String) obj2;
                                                            if (gm1Var2.c(ng2Var)) {
                                                                x(i23, i24, str2);
                                                            }
                                                        } else if (!g31.a(ng2Var2, kg2.b) || g31.a(ng2Var2, kg2.I)) {
                                                            num4 = num4;
                                                            gm1Var2 = gm1Var2;
                                                            arrayList4 = arrayList4;
                                                            i28 = i28;
                                                            i9 = i23;
                                                            gg2Var2 = gg2Var4;
                                                            i10 = i32;
                                                            i8 = 8;
                                                            w(this, s(i9), 2048, 64, 8);
                                                            w(this, s(i9), 2048, num4, 8);
                                                        } else {
                                                            if (g31.a(ng2Var2, kg2.c)) {
                                                                i8 = 8;
                                                                w(this, s(i23), 2048, 64, 8);
                                                                w(this, s(i23), 2048, num4, 8);
                                                            } else if (g31.a(ng2Var2, kg2.H)) {
                                                                Object objG2 = gm1Var3.g(kg2.x);
                                                                if (objG2 == null) {
                                                                    objG2 = null;
                                                                }
                                                                w(this, s(i23), 2048, 64, 8);
                                                                w(this, s(i23), 2048, num4, 8);
                                                                i8 = 8;
                                                            } else if (g31.a(ng2Var2, kg2.a)) {
                                                                int iS = s(i23);
                                                                obj2.getClass();
                                                                v(iS, 2048, 4, (List) obj2);
                                                            } else {
                                                                ng2 ng2Var4 = kg2.E;
                                                                String str3 = "";
                                                                if (!g31.a(ng2Var2, ng2Var4)) {
                                                                    Integer num5 = num4;
                                                                    gm1Var2 = gm1Var2;
                                                                    arrayList4 = arrayList4;
                                                                    i9 = i23;
                                                                    ng2 ng2Var5 = kg2.F;
                                                                    if (g31.a(ng2Var2, ng2Var5)) {
                                                                        Object objG3 = gm1Var3.g(ng2Var4);
                                                                        if (objG3 == null) {
                                                                            objG3 = null;
                                                                        }
                                                                        be beVar = (be) objG3;
                                                                        if (beVar != null && (str = beVar.b) != null) {
                                                                            str3 = str;
                                                                        }
                                                                        long j5 = ((oz2) cg2Var4.d(ng2Var5)).a;
                                                                        num4 = num5;
                                                                        u(h(s(i9), Integer.valueOf((int) (j5 >> 32)), Integer.valueOf((int) (j5 & 4294967295L)), Integer.valueOf(str3.length()), H(str3)));
                                                                        i28 = i28;
                                                                        y(i28);
                                                                        gg2Var2 = gg2Var4;
                                                                        i10 = i32;
                                                                    } else {
                                                                        i28 = i28;
                                                                        i10 = i32;
                                                                        num4 = num5;
                                                                        if (g31.a(ng2Var2, ng2Var3) || g31.a(ng2Var2, kg2.v)) {
                                                                            gg2 gg2Var5 = gg2Var4;
                                                                            o(gg2Var5.c);
                                                                            int size = arrayList3.size();
                                                                            int i33 = 0;
                                                                            while (true) {
                                                                                if (i33 >= size) {
                                                                                    gg2Var2 = gg2Var5;
                                                                                    jd2Var2 = null;
                                                                                    break;
                                                                                }
                                                                                gg2Var2 = gg2Var5;
                                                                                if (((jd2) arrayList3.get(i33)).a == i9) {
                                                                                    jd2Var2 = (jd2) arrayList3.get(i33);
                                                                                    break;
                                                                                } else {
                                                                                    i33++;
                                                                                    gg2Var5 = gg2Var2;
                                                                                }
                                                                            }
                                                                            jd2Var2.getClass();
                                                                            Object objG4 = gm1Var3.g(ng2Var3);
                                                                            if (objG4 == null) {
                                                                                objG4 = null;
                                                                            }
                                                                            jd2Var2.f = (ed2) objG4;
                                                                            Object objG5 = gm1Var3.g(kg2.v);
                                                                            if (objG5 == null) {
                                                                                objG5 = null;
                                                                            }
                                                                            jd2Var2.i = (ed2) objG5;
                                                                            if (jd2Var2.b.contains(jd2Var2)) {
                                                                                this.e.getSnapshotObserver().a.c(jd2Var2, this.w0, new h7(1, jd2Var2, this));
                                                                            }
                                                                        } else if (g31.a(ng2Var2, kg2.k)) {
                                                                            obj2.getClass();
                                                                            if (((Boolean) obj2).booleanValue()) {
                                                                                i11 = 8;
                                                                                u(g(s(i28), 8));
                                                                            } else {
                                                                                i11 = 8;
                                                                            }
                                                                            w(this, s(i28), 2048, num4, i11);
                                                                            i8 = i11;
                                                                        } else {
                                                                            ng2 ng2Var6 = bg2.x;
                                                                            if (g31.a(ng2Var2, ng2Var6)) {
                                                                                List list = (List) cg2Var4.d(ng2Var6);
                                                                                Object objG6 = gm1Var2.g(ng2Var6);
                                                                                if (objG6 == null) {
                                                                                    objG6 = null;
                                                                                }
                                                                                List list2 = (List) objG6;
                                                                                if (list2 != null) {
                                                                                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                                                                                    if (list.size() > 0) {
                                                                                        list.get(0).getClass();
                                                                                        dk0.t();
                                                                                        return;
                                                                                    }
                                                                                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                                                                    if (list2.size() > 0) {
                                                                                        list2.get(0).getClass();
                                                                                        dk0.t();
                                                                                        return;
                                                                                    }
                                                                                    z = (linkedHashSet.containsAll(linkedHashSet2) && linkedHashSet2.containsAll(linkedHashSet)) ? false : true;
                                                                                } else if (!list.isEmpty()) {
                                                                                    z = true;
                                                                                }
                                                                            } else if (obj2 instanceof b2) {
                                                                                b2 b2Var = (b2) obj2;
                                                                                Object objG7 = gm1Var2.g(ng2Var2);
                                                                                if (objG7 == null) {
                                                                                    objG7 = null;
                                                                                }
                                                                                if (b2Var != objG7) {
                                                                                    if (objG7 instanceof b2) {
                                                                                        String str4 = b2Var.a;
                                                                                        b2 b2Var2 = (b2) objG7;
                                                                                        rq0 rq0Var2 = b2Var2.b;
                                                                                        if (g31.a(str4, b2Var2.a) && (((rq0Var = b2Var.b) != null || rq0Var2 == null) && (rq0Var == null || rq0Var2 != null))) {
                                                                                        }
                                                                                    }
                                                                                    z = true;
                                                                                }
                                                                                z = false;
                                                                            } else {
                                                                                z = true;
                                                                            }
                                                                            gg2Var2 = gg2Var4;
                                                                        }
                                                                    }
                                                                    i8 = 8;
                                                                } else if (gm1Var3.c(bg2.k)) {
                                                                    Object objG8 = gm1Var2.g(ng2Var4);
                                                                    if (objG8 == null) {
                                                                        objG8 = null;
                                                                    }
                                                                    be beVar2 = (be) objG8;
                                                                    if (beVar2 == null) {
                                                                        beVar2 = "";
                                                                    }
                                                                    Object objG9 = gm1Var3.g(ng2Var4);
                                                                    if (objG9 == null) {
                                                                        objG9 = null;
                                                                    }
                                                                    CharSequence charSequence = (be) objG9;
                                                                    if (charSequence == null) {
                                                                        charSequence = "";
                                                                    }
                                                                    CharSequence charSequenceH = H(charSequence);
                                                                    int length3 = beVar2.length();
                                                                    int length4 = charSequence.length();
                                                                    Integer num6 = num4;
                                                                    int i34 = length3 > length4 ? length4 : length3;
                                                                    arrayList4 = arrayList4;
                                                                    int i35 = 0;
                                                                    while (true) {
                                                                        i12 = i34;
                                                                        if (i35 >= i34) {
                                                                            i13 = length3;
                                                                            break;
                                                                        }
                                                                        i13 = length3;
                                                                        if (beVar2.charAt(i35) != charSequence.charAt(i35)) {
                                                                            break;
                                                                        }
                                                                        i35++;
                                                                        i34 = i12;
                                                                        length3 = i13;
                                                                    }
                                                                    int i36 = 0;
                                                                    while (true) {
                                                                        if (i36 >= i12 - i35) {
                                                                            i14 = i36;
                                                                            break;
                                                                        }
                                                                        i14 = i36;
                                                                        if (beVar2.charAt((i13 - 1) - i36) != charSequence.charAt((length4 - 1) - i14)) {
                                                                            break;
                                                                        } else {
                                                                            i36 = i14 + 1;
                                                                        }
                                                                    }
                                                                    int i37 = (i13 - i14) - i35;
                                                                    int i38 = (length4 - i14) - i35;
                                                                    ng2 ng2Var7 = kg2.J;
                                                                    boolean zC = gm1Var2.c(ng2Var7);
                                                                    boolean zC2 = gm1Var3.c(ng2Var7);
                                                                    boolean zC3 = gm1Var2.c(kg2.E);
                                                                    boolean z4 = zC3 && !zC && zC2;
                                                                    boolean z5 = zC3 && zC && !zC2;
                                                                    if (z4 || z5) {
                                                                        i9 = i23;
                                                                        num3 = num6;
                                                                        accessibilityEventH = h(s(i23), num3, num6, Integer.valueOf(length4), charSequenceH);
                                                                    } else {
                                                                        accessibilityEventH = g(s(i23), 16);
                                                                        accessibilityEventH.setFromIndex(i35);
                                                                        accessibilityEventH.setRemovedCount(i37);
                                                                        accessibilityEventH.setAddedCount(i38);
                                                                        accessibilityEventH.setBeforeText(beVar2);
                                                                        accessibilityEventH.getText().add(charSequenceH);
                                                                        i9 = i23;
                                                                        num3 = num6;
                                                                    }
                                                                    accessibilityEventH.setClassName("android.widget.EditText");
                                                                    u(accessibilityEventH);
                                                                    if (z4 || z5) {
                                                                        long j6 = ((oz2) cg2Var4.d(kg2.F)).a;
                                                                        accessibilityEventH.setFromIndex((int) (j6 >> 32));
                                                                        accessibilityEventH.setToIndex((int) (j6 & 4294967295L));
                                                                        u(accessibilityEventH);
                                                                    }
                                                                    i28 = i28;
                                                                    i10 = i32;
                                                                    num4 = num3;
                                                                    i8 = 8;
                                                                } else {
                                                                    Integer num7 = num4;
                                                                    gm1Var2 = gm1Var2;
                                                                    arrayList4 = arrayList4;
                                                                    i9 = i23;
                                                                    i8 = 8;
                                                                    w(this, s(i9), 2048, Integer.valueOf(i18), 8);
                                                                    i28 = i28;
                                                                    i10 = i32;
                                                                    num4 = num7;
                                                                }
                                                            }
                                                            i9 = i23;
                                                            gg2Var2 = gg2Var4;
                                                            i10 = i32;
                                                        }
                                                        num4 = num4;
                                                        gm1Var2 = gm1Var2;
                                                        arrayList4 = arrayList4;
                                                        i8 = 8;
                                                        i9 = i23;
                                                        gg2Var2 = gg2Var4;
                                                        i10 = i32;
                                                    } else {
                                                        objG = gm1Var2.g(ng2Var2);
                                                        if (objG == null) {
                                                            objG = null;
                                                        }
                                                        if (g31.a(obj2, objG)) {
                                                            num4 = num4;
                                                            i8 = i24;
                                                        } else {
                                                            ng2Var = kg2.d;
                                                            if (g31.a(ng2Var2, ng2Var)) {
                                                                obj2.getClass();
                                                                str2 = (String) obj2;
                                                                if (gm1Var2.c(ng2Var)) {
                                                                    x(i23, i24, str2);
                                                                }
                                                            } else if (g31.a(ng2Var2, kg2.b)) {
                                                                num4 = num4;
                                                                gm1Var2 = gm1Var2;
                                                                arrayList4 = arrayList4;
                                                                i28 = i28;
                                                                i9 = i23;
                                                                gg2Var2 = gg2Var4;
                                                                i10 = i32;
                                                                i8 = 8;
                                                                w(this, s(i9), 2048, 64, 8);
                                                                w(this, s(i9), 2048, num4, 8);
                                                            } else {
                                                                num4 = num4;
                                                                gm1Var2 = gm1Var2;
                                                                arrayList4 = arrayList4;
                                                                i28 = i28;
                                                                i9 = i23;
                                                                gg2Var2 = gg2Var4;
                                                                i10 = i32;
                                                                i8 = 8;
                                                                w(this, s(i9), 2048, 64, 8);
                                                                w(this, s(i9), 2048, num4, 8);
                                                            }
                                                            num4 = num4;
                                                            gm1Var2 = gm1Var2;
                                                            arrayList4 = arrayList4;
                                                            i8 = 8;
                                                            i9 = i23;
                                                            gg2Var2 = gg2Var4;
                                                            i10 = i32;
                                                        }
                                                        i9 = i23;
                                                        gg2Var2 = gg2Var4;
                                                        i10 = i32;
                                                    }
                                                    long j7 = j >> i8;
                                                    i24 = i8;
                                                    gg2Var4 = gg2Var2;
                                                    i30 = i7 + 1;
                                                    i28 = i28;
                                                    length2 = i10;
                                                    i23 = i9;
                                                    num4 = num4;
                                                    arrayList4 = arrayList4;
                                                    gm1Var2 = gm1Var2;
                                                    j4 = j7;
                                                    cg2Var3 = cg2Var2;
                                                }
                                                int size2 = arrayList4.size();
                                                int i39 = 0;
                                                while (true) {
                                                    if (i39 >= size2) {
                                                        jd2Var = null;
                                                        break;
                                                    }
                                                    int i40 = size2;
                                                    if (((jd2) arrayList4.get(i39)).a == i23) {
                                                        jd2Var = (jd2) arrayList4.get(i39);
                                                        break;
                                                    } else {
                                                        i39++;
                                                        size2 = i40;
                                                    }
                                                }
                                                if (jd2Var != null) {
                                                    z3 = false;
                                                } else {
                                                    jd2Var = new jd2(i23, arrayList3);
                                                    z3 = true;
                                                }
                                                arrayList3.add(jd2Var);
                                                if (z3) {
                                                    ng2Var = kg2.d;
                                                    if (g31.a(ng2Var2, ng2Var)) {
                                                        obj2.getClass();
                                                        str2 = (String) obj2;
                                                        if (gm1Var2.c(ng2Var)) {
                                                            x(i23, i24, str2);
                                                        }
                                                    } else if (g31.a(ng2Var2, kg2.b)) {
                                                        num4 = num4;
                                                        gm1Var2 = gm1Var2;
                                                        arrayList4 = arrayList4;
                                                        i28 = i28;
                                                        i9 = i23;
                                                        gg2Var2 = gg2Var4;
                                                        i10 = i32;
                                                        i8 = 8;
                                                        w(this, s(i9), 2048, 64, 8);
                                                        w(this, s(i9), 2048, num4, 8);
                                                    } else {
                                                        num4 = num4;
                                                        gm1Var2 = gm1Var2;
                                                        arrayList4 = arrayList4;
                                                        i28 = i28;
                                                        i9 = i23;
                                                        gg2Var2 = gg2Var4;
                                                        i10 = i32;
                                                        i8 = 8;
                                                        w(this, s(i9), 2048, 64, 8);
                                                        w(this, s(i9), 2048, num4, 8);
                                                    }
                                                    num4 = num4;
                                                    gm1Var2 = gm1Var2;
                                                    arrayList4 = arrayList4;
                                                    i8 = 8;
                                                    i9 = i23;
                                                    gg2Var2 = gg2Var4;
                                                    i10 = i32;
                                                } else {
                                                    objG = gm1Var2.g(ng2Var2);
                                                    if (objG == null) {
                                                        objG = null;
                                                    }
                                                    if (g31.a(obj2, objG)) {
                                                        num4 = num4;
                                                        i8 = i24;
                                                    } else {
                                                        ng2Var = kg2.d;
                                                        if (g31.a(ng2Var2, ng2Var)) {
                                                            obj2.getClass();
                                                            str2 = (String) obj2;
                                                            if (gm1Var2.c(ng2Var)) {
                                                                x(i23, i24, str2);
                                                            }
                                                        } else if (g31.a(ng2Var2, kg2.b)) {
                                                            num4 = num4;
                                                            gm1Var2 = gm1Var2;
                                                            arrayList4 = arrayList4;
                                                            i28 = i28;
                                                            i9 = i23;
                                                            gg2Var2 = gg2Var4;
                                                            i10 = i32;
                                                            i8 = 8;
                                                            w(this, s(i9), 2048, 64, 8);
                                                            w(this, s(i9), 2048, num4, 8);
                                                        } else {
                                                            num4 = num4;
                                                            gm1Var2 = gm1Var2;
                                                            arrayList4 = arrayList4;
                                                            i28 = i28;
                                                            i9 = i23;
                                                            gg2Var2 = gg2Var4;
                                                            i10 = i32;
                                                            i8 = 8;
                                                            w(this, s(i9), 2048, 64, 8);
                                                            w(this, s(i9), 2048, num4, 8);
                                                        }
                                                        num4 = num4;
                                                        gm1Var2 = gm1Var2;
                                                        arrayList4 = arrayList4;
                                                        i8 = 8;
                                                        i9 = i23;
                                                        gg2Var2 = gg2Var4;
                                                        i10 = i32;
                                                    }
                                                    i9 = i23;
                                                    gg2Var2 = gg2Var4;
                                                    i10 = i32;
                                                }
                                                long j8 = j >> i8;
                                                i24 = i8;
                                                gg2Var4 = gg2Var2;
                                                i30 = i7 + 1;
                                                i28 = i28;
                                                length2 = i10;
                                                i23 = i9;
                                                num4 = num4;
                                                arrayList4 = arrayList4;
                                                gm1Var2 = gm1Var2;
                                                j4 = j8;
                                                cg2Var3 = cg2Var2;
                                            } else {
                                                cg2Var2 = cg2Var3;
                                                arrayList4 = arrayList4;
                                                i7 = i30;
                                                j = j4;
                                                i8 = i24;
                                                num4 = num4;
                                                i9 = i23;
                                                gm1Var2 = gm1Var2;
                                                i28 = i28;
                                                i10 = length2;
                                            }
                                            gg2Var2 = gg2Var4;
                                            long j9 = j >> i8;
                                            i24 = i8;
                                            gg2Var4 = gg2Var2;
                                            i30 = i7 + 1;
                                            i28 = i28;
                                            length2 = i10;
                                            i23 = i9;
                                            num4 = num4;
                                            arrayList4 = arrayList4;
                                            gm1Var2 = gm1Var2;
                                            j4 = j9;
                                            cg2Var3 = cg2Var2;
                                        }
                                        num2 = num4;
                                        cg2Var = cg2Var3;
                                        gm1Var = gm1Var2;
                                        arrayList2 = arrayList4;
                                        i5 = i28;
                                        i4 = i23;
                                        gg2Var = gg2Var4;
                                        i6 = length2;
                                        if (i29 != i24) {
                                            break;
                                        }
                                    } else {
                                        num2 = num4;
                                        cg2Var = cg2Var3;
                                        gm1Var = gm1Var2;
                                        arrayList2 = arrayList4;
                                        i5 = i28;
                                        i4 = i23;
                                        gg2Var = gg2Var4;
                                        i6 = length2;
                                    }
                                    if (i27 == i6) {
                                        break;
                                    }
                                    i26 = i27 + 1;
                                    i25 = i5;
                                    length2 = i6;
                                    i23 = i4;
                                    num4 = num2;
                                    gm1Var2 = gm1Var;
                                    gg2Var4 = gg2Var;
                                    cg2Var3 = cg2Var;
                                    arrayList4 = arrayList2;
                                    i24 = 8;
                                }
                            } else {
                                cg2Var = cg2Var3;
                                arrayList2 = arrayList4;
                                i3 = i21;
                                gg2Var = gg2Var3;
                                num2 = num4;
                                i4 = i23;
                                z = false;
                            }
                            if (!z) {
                                Iterator it = cg2Var.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z2 = false;
                                        break;
                                    }
                                    if (!gg2Var.k().a.c((ng2) ((Map.Entry) it.next()).getKey())) {
                                        z2 = true;
                                        break;
                                    }
                                }
                                z = z2;
                            }
                            if (z) {
                                i2 = 8;
                                w(this, s(i4), 2048, num2, 8);
                            } else {
                                i2 = 8;
                            }
                        }
                    } else {
                        i = i22;
                        arrayList2 = arrayList4;
                        iArr2 = iArr3;
                        jArr2 = jArr3;
                        i2 = i20;
                        i3 = i21;
                        num2 = num4;
                    }
                    j3 >>= i2;
                    i22 = i + 1;
                    c21Var2 = c21Var;
                    i20 = i2;
                    num4 = num2;
                    iArr3 = iArr2;
                    jArr3 = jArr2;
                    i21 = i3;
                    arrayList4 = arrayList2;
                }
                arrayList = arrayList4;
                iArr = iArr3;
                jArr = jArr3;
                int i41 = i20;
                int i42 = i21;
                num = num4;
                if (i42 != i41) {
                    return;
                }
            } else {
                num = num4;
                arrayList = arrayList4;
                iArr = iArr3;
                jArr = jArr3;
            }
            if (i17 == i19) {
                return;
            }
            i17++;
            c21Var2 = c21Var;
            num4 = num;
            i15 = i18;
            iArr3 = iArr;
            jArr3 = jArr;
            arrayList4 = arrayList;
            i16 = 0;
            length = i19;
        }
    }
}
