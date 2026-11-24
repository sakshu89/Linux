package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.hardware.camera2.CameraDevice;
import android.os.Trace;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.nio.MappedByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s7 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ s7(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    private final void a() {
        zo0 zo0Var = (zo0) this.b;
        synchronized (zo0Var.d) {
            try {
                if (zo0Var.h == null) {
                    return;
                }
                try {
                    pp0 pp0VarC = zo0Var.c();
                    int i = pp0VarC.f;
                    if (i == 2) {
                        synchronized (zo0Var.d) {
                        }
                    }
                    if (i != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + i + ")");
                    }
                    try {
                        int i2 = s13.a;
                        Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        qs4 qs4Var = zo0Var.c;
                        Context context = zo0Var.a;
                        qs4Var.getClass();
                        pp0[] pp0VarArr = {pp0VarC};
                        ae4 ae4Var = l33.a;
                        Trace.beginSection(hd4.e("TypefaceCompat.createFromFontInfo"));
                        try {
                            Typeface typefaceB = l33.a.b(context, pp0VarArr, 0);
                            Trace.endSection();
                            MappedByteBuffer mappedByteBufferE = ce4.e(zo0Var.a, pp0VarC.a);
                            if (mappedByteBufferE == null || typefaceB == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            try {
                                Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                p6 p6Var = new p6(typefaceB, ir4.a(mappedByteBufferE));
                                Trace.endSection();
                                Trace.endSection();
                                synchronized (zo0Var.d) {
                                    try {
                                        cn4 cn4Var = zo0Var.h;
                                        if (cn4Var != null) {
                                            cn4Var.b(p6Var);
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                zo0Var.b();
                            } catch (Throwable th2) {
                                int i3 = s13.a;
                                Trace.endSection();
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            Trace.endSection();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        int i4 = s13.a;
                        Trace.endSection();
                        throw th4;
                    }
                } catch (Throwable th5) {
                    synchronized (zo0Var.d) {
                        try {
                            cn4 cn4Var2 = zo0Var.h;
                            if (cn4Var2 != null) {
                                cn4Var2.a(th5);
                            }
                            zo0Var.b();
                        } catch (Throwable th6) {
                            throw th6;
                        }
                    }
                }
            } catch (Throwable th7) {
                throw th7;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:185:0x035b  */
    @Override // java.lang.Runnable
    public final void run() {
        int[] iArr;
        View viewFindFocus;
        char c = 7;
        Boolean bool = null;
        switch (this.a) {
            case 0:
                x7 x7Var = (x7) this.b;
                Trace.beginSection("measureAndLayout");
                try {
                    x7Var.e.q(true);
                    Trace.endSection();
                    Trace.beginSection("checkForSemanticsChanges");
                    try {
                        x7Var.f();
                        Trace.endSection();
                        x7Var.s0 = false;
                        return;
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } catch (Throwable th2) {
                    Trace.endSection();
                    throw th2;
                }
            case 1:
                q8 q8Var = (q8) this.b;
                boolean zD = q8Var.d();
                r7 r7Var = q8Var.a;
                if (zD) {
                    Trace.beginSection("ContentCapture:changeChecker");
                    try {
                        r7Var.q(true);
                        ml1 ml1Var = q8Var.u;
                        int[] iArr2 = ml1Var.b;
                        long[] jArr = ml1Var.a;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                long j = jArr[i];
                                if ((((~j) << c) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i2 = 8 - ((~(i - length)) >>> 31);
                                    int i3 = 0;
                                    while (i3 < i2) {
                                        if ((255 & j) < 128) {
                                            int i4 = iArr2[(i << 3) + i3];
                                            if (!q8Var.c().a(i4)) {
                                                q8Var.e.add(new d50(i4, q8Var.t, e50.b, null));
                                                q8Var.k.s(q43.a);
                                            }
                                        }
                                        j >>= 8;
                                        i3++;
                                        iArr2 = iArr2;
                                    }
                                    iArr = iArr2;
                                    if (i2 == 8) {
                                    }
                                } else {
                                    iArr = iArr2;
                                }
                                if (i != length) {
                                    i++;
                                    c = 7;
                                    iArr2 = iArr;
                                }
                            }
                        }
                        Trace.beginSection("ContentCapture:sendAppearEvents");
                        try {
                            q8Var.f(r7Var.getSemanticsOwner().a(), q8Var.v);
                            Trace.endSection();
                            q8Var.b(q8Var.c());
                            q8Var.k();
                            q8Var.w = false;
                            return;
                        } finally {
                            Trace.endSection();
                        }
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
                return;
            case 2:
                ActionMode actionMode = ((fc) this.b).h;
                if (actionMode != null) {
                    actionMode.finish();
                    return;
                }
                return;
            case 3:
                bq bqVar = (bq) this.b;
                tp tpVar = bqVar.g;
                if (tpVar != null) {
                    tpVar.a(null);
                    bqVar.g = null;
                    return;
                }
                return;
            case 4:
                yq yqVar = (yq) this.b;
                yqVar.d0 = false;
                yqVar.c0 = false;
                yqVar.t("OpenCameraConfigAndClose is done, state: ".concat(cq.y(yqVar.q0)));
                int iX = cq.x(yqVar.q0);
                if (iX == 1 || iX == 4) {
                    hh1.e(null, yqVar.v.isEmpty());
                    yqVar.u();
                    return;
                } else {
                    if (iX != 6) {
                        yqVar.t("OpenCameraConfigAndClose finished while in state: ".concat(cq.y(yqVar.q0)));
                        return;
                    }
                    int i5 = yqVar.t;
                    if (i5 == 0) {
                        yqVar.J(false);
                        return;
                    } else {
                        yqVar.t("OpenCameraConfigAndClose in error: ".concat(yq.v(i5)));
                        yqVar.k.b();
                        return;
                    }
                }
            case 5:
                ((CameraDevice) this.b).close();
                return;
            case 6:
                wq wqVar = (wq) this.b;
                if (wqVar.b) {
                    return;
                }
                hh1.e(null, wqVar.c.f.q0 == 7 || wqVar.c.f.q0 == 6);
                boolean zC = wqVar.c.c();
                yq yqVar2 = wqVar.c.f;
                if (zC) {
                    yqVar2.I(true);
                    return;
                } else {
                    yqVar2.J(true);
                    return;
                }
            case 7:
                ((mr) this.b).i.c();
                return;
            case 8:
                ((qy0) this.b).clear();
                return;
            case 9:
                ((yt) this.b).b.onCameraAccessPrioritiesChanged();
                return;
            case 10:
                tq tqVar = (tq) this.b;
                if (tqVar.c.q0 == 4) {
                    tqVar.c.J(false);
                    return;
                }
                return;
            case 11:
                q82 q82Var = (q82) this.b;
                if (((yq) q82Var.a).q0 == 9) {
                    ((yq) q82Var.a).B();
                    return;
                }
                return;
            case 12:
                g12 g12Var = (g12) ((cj) ((ow) this.b).b).b;
                if (g12Var != null) {
                    j62 j62Var = g12Var.g;
                    vc4.b();
                    if (j62Var.g || j62Var.h) {
                        return;
                    }
                    j62Var.h = true;
                    return;
                }
                return;
            case 13:
                tw twVar = (tw) this.b;
                synchronized (twVar.a) {
                    if (twVar.b.isEmpty()) {
                        return;
                    }
                    try {
                        twVar.h(twVar.b);
                        twVar.b.clear();
                        return;
                    } catch (Throwable th4) {
                        twVar.b.clear();
                        throw th4;
                    }
                }
            case 14:
                for (bv2 bv2Var : (LinkedHashSet) this.b) {
                    bv2Var.getClass();
                    bv2Var.c(bv2Var);
                }
                return;
            case 15:
                l10 l10Var = (l10) this.b;
                Runnable runnable = l10Var.b;
                if (runnable != null) {
                    runnable.run();
                    l10Var.b = null;
                    return;
                }
                return;
            case 16:
                ((xt2) this.b).close();
                return;
            case 17:
                fb0 fb0Var = (fb0) this.b;
                fb0Var.j = true;
                fb0Var.d();
                return;
            case 18:
                ((wp) this.b).cancel(true);
                return;
            case 19:
                cg0 cg0Var = (cg0) this.b;
                cg0Var.f = true;
                cg0Var.d();
                return;
            case 20:
                dg0 dg0Var = (dg0) ((cj) this.b).f;
                if (dg0Var != null) {
                    Iterator it = dg0Var.values().iterator();
                    while (it.hasNext()) {
                        ((st2) it.next()).b();
                    }
                    return;
                }
                return;
            case 21:
                a();
                return;
            case 22:
                ((g02) this.b).n();
                return;
            case 23:
                a12 a12Var = (a12) this.b;
                qb1 qb1Var = a12Var.i;
                if (a12Var.b == 0) {
                    a12Var.c = true;
                    qb1Var.d(db1.ON_PAUSE);
                }
                if (a12Var.a == 0 && a12Var.c) {
                    qb1Var.d(db1.ON_STOP);
                    a12Var.e = true;
                    return;
                }
                return;
            case 24:
                h82.setRippleState$lambda$1((h82) this.b);
                return;
            case 25:
                ((pr) this.b).a();
                return;
            case 26:
                View view = (View) this.b;
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                return;
            case 27:
                dg0 dg0Var2 = (dg0) ((kf) this.b).e;
                if (dg0Var2 != null) {
                    Iterator it2 = dg0Var2.values().iterator();
                    while (it2.hasNext()) {
                        ((st2) it2.next()).b();
                    }
                    return;
                }
                return;
            case 28:
                ((rw) this.b).a();
                return;
            default:
                zy2 zy2Var = (zy2) this.b;
                kf kfVar = zy2Var.b;
                zy2Var.n = null;
                pm1 pm1Var = zy2Var.m;
                View view2 = zy2Var.a;
                if (!view2.isFocused() && (viewFindFocus = view2.getRootView().findFocus()) != null && viewFindFocus.onCheckIsTextEditor()) {
                    pm1Var.h();
                    return;
                }
                Object[] objArr = pm1Var.a;
                int i6 = pm1Var.c;
                Boolean boolValueOf = null;
                for (int i7 = 0; i7 < i6; i7++) {
                    yy2 yy2Var = (yy2) objArr[i7];
                    int iOrdinal = yy2Var.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            boolValueOf = Boolean.FALSE;
                        } else if (iOrdinal != 2 && iOrdinal != 3) {
                            dk0.l();
                            return;
                        } else if (!g31.a(bool, Boolean.FALSE)) {
                            boolValueOf = Boolean.valueOf(yy2Var == yy2.c);
                        }
                    } else {
                        boolValueOf = Boolean.TRUE;
                    }
                    bool = boolValueOf;
                }
                pm1Var.h();
                if (g31.a(bool, Boolean.TRUE)) {
                    ((InputMethodManager) ((f81) kfVar.c).getValue()).restartInput((View) kfVar.b);
                }
                if (boolValueOf != null) {
                    if (boolValueOf.booleanValue()) {
                        ((py0) ((wj1) kfVar.e).b).j();
                    } else {
                        ((py0) ((wj1) kfVar.e).b).g();
                    }
                }
                if (g31.a(bool, Boolean.FALSE)) {
                    ((InputMethodManager) ((f81) kfVar.c).getValue()).restartInput((View) kfVar.b);
                    return;
                }
                return;
        }
    }
}
