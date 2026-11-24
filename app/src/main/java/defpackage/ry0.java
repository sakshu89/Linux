package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ImageReader;
import android.os.Looper;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ry0 extends o53 {
    public static final oy0 z = new oy0();
    public final int o;
    public final AtomicReference p;
    public final int q;
    public final int r;
    public Rational s;
    public final sb2 t;
    public gh2 u;
    public cj v;
    public lv2 w;
    public hh2 x;
    public final q82 y;

    public ry0(sy0 sy0Var) {
        super(sy0Var);
        this.p = new AtomicReference(null);
        this.r = -1;
        this.s = null;
        this.y = new q82(this);
        sy0 sy0Var2 = (sy0) this.f;
        bi biVar = sy0.b;
        if (sy0Var2.a(biVar)) {
            this.o = ((Integer) sy0Var2.f(biVar)).intValue();
        } else {
            this.o = 1;
        }
        this.q = ((Integer) sy0Var2.d(sy0.n, 0)).intValue();
        this.t = new sb2((qy0) sy0Var2.d(sy0.t, null));
    }

    public static boolean D(int i, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) ((Pair) it.next()).first).equals(Integer.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    public final void A(boolean z2) {
        lv2 lv2Var;
        vc4.b();
        hh2 hh2Var = this.x;
        if (hh2Var != null) {
            hh2Var.b();
            this.x = null;
        }
        cj cjVar = this.v;
        if (cjVar != null) {
            cjVar.k();
            this.v = null;
        }
        if (z2 || (lv2Var = this.w) == null) {
            return;
        }
        lv2Var.a();
        this.w = null;
    }

    public final gh2 B(String str, sy0 sy0Var, fj fjVar) {
        int iIntValue;
        s40 s40Var;
        bz0 bz0Var;
        final int i;
        vc4.b();
        Objects.toString(fjVar);
        Size size = fjVar.a;
        wt wtVarB = b();
        Objects.requireNonNull(wtVarB);
        boolean zG = wtVarB.g();
        boolean z2 = !zG;
        if (this.v != null) {
            hh1.e(null, z2);
            this.v.k();
        }
        if (((Boolean) this.f.d(sy0.u, Boolean.FALSE)).booleanValue()) {
            b().n().k();
        }
        cj cjVar = new cj();
        vc4.b();
        cjVar.b = sy0Var;
        er erVar = (er) sy0Var.d(r53.R, null);
        if (erVar == null) {
            dk0.x((String) sy0Var.d(yv2.M, sy0Var.toString()), "Implementation is missing option unpacker for ");
            throw null;
        }
        ur urVar = new ur();
        erVar.a(sy0Var, urVar);
        cjVar.c = urVar.d();
        final cj cjVar2 = new cj();
        cjVar2.b = null;
        cjVar2.a = null;
        cjVar.e = cjVar2;
        Executor executor = (Executor) sy0Var.d(v31.K, xg4.b());
        Objects.requireNonNull(executor);
        final f12 f12Var = new f12(executor);
        cjVar.f = f12Var;
        int iP = sy0Var.p();
        Integer num = (Integer) sy0Var.d(sy0.f, null);
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Integer num2 = (Integer) sy0Var.d(wy0.r, null);
            iIntValue = (num2 == null || num2.intValue() != 4101) ? 256 : 4101;
        }
        if (sy0Var.d(sy0.j, null) != null) {
            dk0.t();
            throw null;
        }
        vg0 vg0Var = new vg0();
        vg0 vg0Var2 = new vg0();
        zh zhVar = new zh(size, iP, iIntValue, z2, vg0Var, vg0Var2);
        cjVar.a = zhVar;
        int i2 = 0;
        hh1.e("CaptureNode does not support recreation yet.", ((zh) cjVar2.f) == null && ((m92) cjVar2.c) == null);
        cjVar2.f = zhVar;
        es owVar = new ow(i2, cjVar2);
        if (zG) {
            fj1 fj1Var = new fj1(size.getWidth(), size.getHeight(), iP, 4);
            List listAsList = Arrays.asList(owVar, fj1Var.b);
            if (listAsList.isEmpty()) {
                owVar = new gs();
                i = 0;
            } else if (listAsList.size() == 1) {
                i = 0;
                owVar = (es) listAsList.get(0);
            } else {
                i = 0;
                owVar = new fs(listAsList);
            }
            s40Var = new s40() { // from class: mw
                @Override // defpackage.s40
                public final void accept(Object obj) {
                    int i3 = i;
                    boolean z3 = false;
                    cj cjVar3 = cjVar2;
                    switch (i3) {
                        case 0:
                            cjVar3.C((g12) obj);
                            break;
                        case 1:
                            g12 g12Var = (g12) obj;
                            cjVar3.C(g12Var);
                            q91 q91Var = (q91) cjVar3.a;
                            hh1.e("Pending request should be null", ((g12) q91Var.c) == null);
                            q91Var.c = g12Var;
                            break;
                        default:
                            nj njVar = (nj) obj;
                            vc4.b();
                            g12 g12Var2 = (g12) cjVar3.b;
                            if (g12Var2 != null && g12Var2.a == njVar.a) {
                                ty0 ty0Var = njVar.b;
                                j62 j62Var = g12Var2.g;
                                oj ojVar = j62Var.a;
                                vc4.b();
                                if (!j62Var.g) {
                                    vc4.b();
                                    int i4 = ojVar.a;
                                    if (i4 > 0) {
                                        ojVar.a = i4 - 1;
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        vc4.b();
                                        ojVar.b.execute(new v62(5, ojVar, ty0Var));
                                    }
                                    j62Var.a();
                                    j62Var.e.b(ty0Var);
                                    if (z3) {
                                        j62Var.b.d(ojVar);
                                    }
                                    break;
                                }
                            }
                            break;
                    }
                }
            };
            bz0Var = fj1Var;
        } else {
            q91 q91Var = new q91((Object) new s9(ImageReader.newInstance(size.getWidth(), size.getHeight(), iP, 4)), false, 12);
            cjVar2.a = q91Var;
            final int i3 = 1;
            s40Var = new s40() { // from class: mw
                @Override // defpackage.s40
                public final void accept(Object obj) {
                    int i4 = i3;
                    boolean z3 = false;
                    cj cjVar3 = cjVar2;
                    switch (i4) {
                        case 0:
                            cjVar3.C((g12) obj);
                            break;
                        case 1:
                            g12 g12Var = (g12) obj;
                            cjVar3.C(g12Var);
                            q91 q91Var2 = (q91) cjVar3.a;
                            hh1.e("Pending request should be null", ((g12) q91Var2.c) == null);
                            q91Var2.c = g12Var;
                            break;
                        default:
                            nj njVar = (nj) obj;
                            vc4.b();
                            g12 g12Var2 = (g12) cjVar3.b;
                            if (g12Var2 != null && g12Var2.a == njVar.a) {
                                ty0 ty0Var = njVar.b;
                                j62 j62Var = g12Var2.g;
                                oj ojVar = j62Var.a;
                                vc4.b();
                                if (!j62Var.g) {
                                    vc4.b();
                                    int i5 = ojVar.a;
                                    if (i5 > 0) {
                                        ojVar.a = i5 - 1;
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        vc4.b();
                                        ojVar.b.execute(new v62(5, ojVar, ty0Var));
                                    }
                                    j62Var.a();
                                    j62Var.e.b(ty0Var);
                                    if (z3) {
                                        j62Var.b.d(ojVar);
                                    }
                                    break;
                                }
                            }
                            break;
                    }
                }
            };
            bz0Var = q91Var;
        }
        zhVar.a = owVar;
        Surface surface = bz0Var.getSurface();
        Objects.requireNonNull(surface);
        hh1.e("The surface is already set.", zhVar.b == null);
        zhVar.b = new nz0(surface, size, iP);
        cjVar2.c = new m92(bz0Var);
        bz0Var.l(new zq(3, cjVar2), xg4.c());
        vg0Var.b = s40Var;
        final int i4 = 2;
        vg0Var2.b = new s40() { // from class: mw
            @Override // defpackage.s40
            public final void accept(Object obj) {
                int i5 = i4;
                boolean z3 = false;
                cj cjVar3 = cjVar2;
                switch (i5) {
                    case 0:
                        cjVar3.C((g12) obj);
                        break;
                    case 1:
                        g12 g12Var = (g12) obj;
                        cjVar3.C(g12Var);
                        q91 q91Var2 = (q91) cjVar3.a;
                        hh1.e("Pending request should be null", ((g12) q91Var2.c) == null);
                        q91Var2.c = g12Var;
                        break;
                    default:
                        nj njVar = (nj) obj;
                        vc4.b();
                        g12 g12Var2 = (g12) cjVar3.b;
                        if (g12Var2 != null && g12Var2.a == njVar.a) {
                            ty0 ty0Var = njVar.b;
                            j62 j62Var = g12Var2.g;
                            oj ojVar = j62Var.a;
                            vc4.b();
                            if (!j62Var.g) {
                                vc4.b();
                                int i6 = ojVar.a;
                                if (i6 > 0) {
                                    ojVar.a = i6 - 1;
                                    z3 = true;
                                }
                                if (!z3) {
                                    vc4.b();
                                    ojVar.b.execute(new v62(5, ojVar, ty0Var));
                                }
                                j62Var.a();
                                j62Var.e.b(ty0Var);
                                if (z3) {
                                    j62Var.b.d(ojVar);
                                }
                                break;
                            }
                        }
                        break;
                }
            }
        };
        vg0 vg0Var3 = new vg0();
        vg0 vg0Var4 = new vg0();
        yi yiVar = new yi(vg0Var3, vg0Var4, iP, iIntValue);
        cjVar2.e = yiVar;
        f12Var.b = yiVar;
        final int i5 = 0;
        vg0Var3.b = new s40() { // from class: d12
            @Override // defpackage.s40
            public final void accept(Object obj) throws Exception {
                int i6 = i5;
                final f12 f12Var2 = f12Var;
                final zi ziVar = (zi) obj;
                switch (i6) {
                    case 0:
                        if (!ziVar.a.g.g) {
                            final int i7 = 1;
                            f12Var2.a.execute(new Runnable() { // from class: e12
                                @Override // java.lang.Runnable
                                public final void run() throws Exception {
                                    int i8 = i7;
                                    zi ziVar2 = ziVar;
                                    f12 f12Var3 = f12Var2;
                                    switch (i8) {
                                        case 0:
                                            int i9 = f12Var3.b.d;
                                            hh1.a("Postview only support YUV and JPEG output formats. Output format: " + i9, i9 == 35 || i9 == 256);
                                            try {
                                                xg4.c().execute(new o8(28, ziVar2.a, (Bitmap) f12Var3.j.apply((wi) f12Var3.c.apply(ziVar2))));
                                            } catch (Exception e) {
                                                ziVar2.b.close();
                                                xq4.b("ProcessingNode", "process postview input packet failed.", e);
                                                return;
                                            }
                                            break;
                                        default:
                                            g12 g12Var = ziVar2.a;
                                            try {
                                                if (g12Var.b == null) {
                                                    xg4.c().execute(new o8(26, g12Var, f12Var3.a(ziVar2)));
                                                } else {
                                                    xg4.c().execute(new o8(27, g12Var, f12Var3.b(ziVar2)));
                                                }
                                            } catch (OutOfMemoryError e2) {
                                                xg4.c().execute(new o8(29, g12Var, new ty0("Processing failed due to low memory.", e2)));
                                                return;
                                            } catch (RuntimeException e3) {
                                                xg4.c().execute(new o8(29, g12Var, new ty0("Processing failed.", e3)));
                                                return;
                                            } catch (ty0 e4) {
                                                xg4.c().execute(new o8(29, g12Var, e4));
                                                return;
                                            }
                                            break;
                                    }
                                }
                            });
                        } else {
                            ziVar.b.close();
                        }
                        break;
                    default:
                        if (!ziVar.a.g.g) {
                            final int i8 = 0;
                            f12Var2.a.execute(new Runnable() { // from class: e12
                                @Override // java.lang.Runnable
                                public final void run() throws Exception {
                                    int i9 = i8;
                                    zi ziVar2 = ziVar;
                                    f12 f12Var3 = f12Var2;
                                    switch (i9) {
                                        case 0:
                                            int i10 = f12Var3.b.d;
                                            hh1.a("Postview only support YUV and JPEG output formats. Output format: " + i10, i10 == 35 || i10 == 256);
                                            try {
                                                xg4.c().execute(new o8(28, ziVar2.a, (Bitmap) f12Var3.j.apply((wi) f12Var3.c.apply(ziVar2))));
                                            } catch (Exception e) {
                                                ziVar2.b.close();
                                                xq4.b("ProcessingNode", "process postview input packet failed.", e);
                                                return;
                                            }
                                            break;
                                        default:
                                            g12 g12Var = ziVar2.a;
                                            try {
                                                if (g12Var.b == null) {
                                                    xg4.c().execute(new o8(26, g12Var, f12Var3.a(ziVar2)));
                                                } else {
                                                    xg4.c().execute(new o8(27, g12Var, f12Var3.b(ziVar2)));
                                                }
                                            } catch (OutOfMemoryError e2) {
                                                xg4.c().execute(new o8(29, g12Var, new ty0("Processing failed due to low memory.", e2)));
                                                return;
                                            } catch (RuntimeException e3) {
                                                xg4.c().execute(new o8(29, g12Var, new ty0("Processing failed.", e3)));
                                                return;
                                            } catch (ty0 e4) {
                                                xg4.c().execute(new o8(29, g12Var, e4));
                                                return;
                                            }
                                            break;
                                    }
                                }
                            });
                        } else {
                            xq4.d("ProcessingNode", "The postview image is closed due to request aborted");
                            ziVar.b.close();
                        }
                        break;
                }
            }
        };
        final boolean z3 = true ? 1 : 0;
        vg0Var4.b = new s40() { // from class: d12
            @Override // defpackage.s40
            public final void accept(Object obj) throws Exception {
                int i6 = z3;
                final f12 f12Var2 = f12Var;
                final zi ziVar = (zi) obj;
                switch (i6) {
                    case 0:
                        if (!ziVar.a.g.g) {
                            final int i7 = 1;
                            f12Var2.a.execute(new Runnable() { // from class: e12
                                @Override // java.lang.Runnable
                                public final void run() throws Exception {
                                    int i9 = i7;
                                    zi ziVar2 = ziVar;
                                    f12 f12Var3 = f12Var2;
                                    switch (i9) {
                                        case 0:
                                            int i10 = f12Var3.b.d;
                                            hh1.a("Postview only support YUV and JPEG output formats. Output format: " + i10, i10 == 35 || i10 == 256);
                                            try {
                                                xg4.c().execute(new o8(28, ziVar2.a, (Bitmap) f12Var3.j.apply((wi) f12Var3.c.apply(ziVar2))));
                                            } catch (Exception e) {
                                                ziVar2.b.close();
                                                xq4.b("ProcessingNode", "process postview input packet failed.", e);
                                                return;
                                            }
                                            break;
                                        default:
                                            g12 g12Var = ziVar2.a;
                                            try {
                                                if (g12Var.b == null) {
                                                    xg4.c().execute(new o8(26, g12Var, f12Var3.a(ziVar2)));
                                                } else {
                                                    xg4.c().execute(new o8(27, g12Var, f12Var3.b(ziVar2)));
                                                }
                                            } catch (OutOfMemoryError e2) {
                                                xg4.c().execute(new o8(29, g12Var, new ty0("Processing failed due to low memory.", e2)));
                                                return;
                                            } catch (RuntimeException e3) {
                                                xg4.c().execute(new o8(29, g12Var, new ty0("Processing failed.", e3)));
                                                return;
                                            } catch (ty0 e4) {
                                                xg4.c().execute(new o8(29, g12Var, e4));
                                                return;
                                            }
                                            break;
                                    }
                                }
                            });
                        } else {
                            ziVar.b.close();
                        }
                        break;
                    default:
                        if (!ziVar.a.g.g) {
                            final int i8 = 0;
                            f12Var2.a.execute(new Runnable() { // from class: e12
                                @Override // java.lang.Runnable
                                public final void run() throws Exception {
                                    int i9 = i8;
                                    zi ziVar2 = ziVar;
                                    f12 f12Var3 = f12Var2;
                                    switch (i9) {
                                        case 0:
                                            int i10 = f12Var3.b.d;
                                            hh1.a("Postview only support YUV and JPEG output formats. Output format: " + i10, i10 == 35 || i10 == 256);
                                            try {
                                                xg4.c().execute(new o8(28, ziVar2.a, (Bitmap) f12Var3.j.apply((wi) f12Var3.c.apply(ziVar2))));
                                            } catch (Exception e) {
                                                ziVar2.b.close();
                                                xq4.b("ProcessingNode", "process postview input packet failed.", e);
                                                return;
                                            }
                                            break;
                                        default:
                                            g12 g12Var = ziVar2.a;
                                            try {
                                                if (g12Var.b == null) {
                                                    xg4.c().execute(new o8(26, g12Var, f12Var3.a(ziVar2)));
                                                } else {
                                                    xg4.c().execute(new o8(27, g12Var, f12Var3.b(ziVar2)));
                                                }
                                            } catch (OutOfMemoryError e2) {
                                                xg4.c().execute(new o8(29, g12Var, new ty0("Processing failed due to low memory.", e2)));
                                                return;
                                            } catch (RuntimeException e3) {
                                                xg4.c().execute(new o8(29, g12Var, new ty0("Processing failed.", e3)));
                                                return;
                                            } catch (ty0 e4) {
                                                xg4.c().execute(new o8(29, g12Var, e4));
                                                return;
                                            }
                                            break;
                                    }
                                }
                            });
                        } else {
                            xq4.d("ProcessingNode", "The postview image is closed due to request aborted");
                            ziVar.b.close();
                        }
                        break;
                }
            }
        };
        f12Var.c = new nr4(16);
        f12Var.d = new uf1(f12Var.k, 23);
        int i6 = 14;
        f12Var.g = new ak1(i6);
        f12Var.e = new el1(9);
        f12Var.f = new el1(i6);
        f12Var.h = new fl4(14);
        f12Var.j = new nr4(13);
        if (iP == 35 || f12Var.l) {
            f12Var.i = new y74(i6);
        }
        this.v = cjVar;
        if (this.w == null) {
            this.w = new lv2(this.y);
        }
        lv2 lv2Var = this.w;
        cj cjVar3 = this.v;
        lv2Var.getClass();
        vc4.b();
        lv2Var.c = cjVar3;
        cjVar3.getClass();
        vc4.b();
        cj cjVar4 = (cj) cjVar3.e;
        cjVar4.getClass();
        vc4.b();
        hh1.e("The ImageReader is not initialized.", ((m92) cjVar4.c) != null);
        m92 m92Var = (m92) cjVar4.c;
        synchronized (m92Var.a) {
            m92Var.i = lv2Var;
        }
        cj cjVar5 = this.v;
        gh2 gh2VarD = gh2.d((sy0) cjVar5.b, fjVar.a);
        zh zhVar2 = (zh) cjVar5.a;
        nz0 nz0Var = zhVar2.b;
        Objects.requireNonNull(nz0Var);
        ig0 ig0Var = ig0.d;
        cj cjVarA = dj.a(nz0Var);
        cjVarA.a = ig0Var;
        gh2VarD.a.add(cjVarA.h());
        nz0 nz0Var2 = zhVar2.c;
        if (nz0Var2 != null) {
            gh2VarD.h = dj.a(nz0Var2).h();
        }
        if (this.o == 2 && !fjVar.e) {
            c().i(gh2VarD);
        }
        s30 s30Var = fjVar.d;
        if (s30Var != null) {
            gh2VarD.b.c(s30Var);
        }
        hh2 hh2Var = this.x;
        if (hh2Var != null) {
            hh2Var.b();
        }
        hh2 hh2Var2 = new hh2(new ny0(0, this));
        this.x = hh2Var2;
        gh2VarD.f = hh2Var2;
        return gh2VarD;
    }

    public final int C() {
        int iIntValue;
        synchronized (this.p) {
            iIntValue = this.r;
            if (iIntValue == -1) {
                iIntValue = ((Integer) ((sy0) this.f).d(sy0.c, 2)).intValue();
            }
        }
        return iIntValue;
    }

    public final void E(kf kfVar, Executor executor, uf1 uf1Var) {
        int iRound;
        int i;
        int i2;
        int i3;
        int iIntValue;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            xg4.c().execute(new os(this, kfVar, executor, uf1Var, 3));
            return;
        }
        vc4.b();
        if (C() == 3 && this.t.a == null) {
            og.i("ScreenFlash not set for FLASH_MODE_SCREEN");
            return;
        }
        wt wtVarB = b();
        Rect rect = null;
        if (wtVarB == null) {
            ((q92) uf1Var.b).h(new h72(new ty0("Not bound to a valid Camera [" + this + "]", null)));
            return;
        }
        lv2 lv2Var = this.w;
        Objects.requireNonNull(lv2Var);
        Rect rect2 = this.i;
        fj fjVar = this.g;
        Size size = fjVar != null ? fjVar.a : null;
        Objects.requireNonNull(size);
        if (rect2 == null) {
            Rational rational = this.s;
            if (rational == null || rational.floatValue() <= 0.0f || rational.isNaN()) {
                rect2 = new Rect(0, 0, size.getWidth(), size.getHeight());
            } else {
                wt wtVarB2 = b();
                Objects.requireNonNull(wtVarB2);
                int iG = g(wtVarB2, false);
                Rational rational2 = new Rational(this.s.getDenominator(), this.s.getNumerator());
                if (!z13.c(iG)) {
                    rational2 = this.s;
                }
                if (rational2 == null || rational2.floatValue() <= 0.0f || rational2.isNaN()) {
                    xq4.d("ImageUtil", "Invalid view ratio.");
                } else {
                    int width = size.getWidth();
                    int height = size.getHeight();
                    float f = width;
                    float f2 = height;
                    float f3 = f / f2;
                    int numerator = rational2.getNumerator();
                    int denominator = rational2.getDenominator();
                    if (rational2.floatValue() > f3) {
                        int iRound2 = Math.round((f / numerator) * denominator);
                        i3 = (height - iRound2) / 2;
                        i2 = iRound2;
                        iRound = width;
                        i = 0;
                    } else {
                        iRound = Math.round((f2 / denominator) * numerator);
                        i = (width - iRound) / 2;
                        i2 = height;
                        i3 = 0;
                    }
                    rect = new Rect(i, i3, iRound + i, i2 + i3);
                }
                Objects.requireNonNull(rect);
                rect2 = rect;
            }
        }
        Matrix matrix = this.j;
        int iG2 = g(wtVarB, false);
        sy0 sy0Var = (sy0) this.f;
        bi biVar = sy0.s;
        if (sy0Var.a(biVar)) {
            iIntValue = ((Integer) sy0Var.f(biVar)).intValue();
        } else {
            int i4 = this.o;
            if (i4 == 0) {
                iIntValue = 100;
            } else {
                if (i4 != 1 && i4 != 2) {
                    og.n(cq.h("CaptureMode ", i4, " is invalid"));
                    return;
                }
                iIntValue = 95;
            }
        }
        int i5 = iIntValue;
        List listUnmodifiableList = Collections.unmodifiableList(this.u.e);
        hh1.a("onDiskCallback and outputFileOptions should be both null or both non-null.", !false);
        oj ojVar = new oj(executor, uf1Var, kfVar, rect2, matrix, iG2, i5, this.o, listUnmodifiableList);
        vc4.b();
        lv2Var.a.offer(ojVar);
        lv2Var.b();
    }

    public final void F() {
        synchronized (this.p) {
            try {
                if (this.p.get() != null) {
                    return;
                }
                c().f(C());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.o53
    public final r53 e(boolean z2, u53 u53Var) {
        z.getClass();
        sy0 sy0Var = oy0.a;
        s30 s30VarA = u53Var.a(sy0Var.j(), this.o);
        if (z2) {
            s30VarA = s30.t(s30VarA, sy0Var);
        }
        if (s30VarA == null) {
            return null;
        }
        return new sy0(gs1.l(((yr) j(s30VarA)).b));
    }

    @Override // defpackage.o53
    public final HashSet i() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    @Override // defpackage.o53
    public final q53 j(s30 s30Var) {
        return new yr(zl1.o(s30Var), 2);
    }

    @Override // defpackage.o53
    public final void p() {
        hh1.d(b(), "Attached camera cannot be null");
        if (C() == 3) {
            wt wtVarB = b();
            if ((wtVarB != null ? wtVarB.i().b() : -1) == 0) {
                return;
            }
            og.i("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
        }
    }

    @Override // defpackage.o53
    public final void q() {
        xq4.c(3, "ImageCapture");
        F();
        c().g(this.t);
    }

    @Override // defpackage.o53
    public final r53 r(ut utVar, q53 q53Var) {
        Object objF;
        Object objF2;
        Object objF3;
        if (utVar.i().c(SoftwareJpegEncodingPreferredQuirk.class)) {
            Boolean bool = Boolean.FALSE;
            zl1 zl1VarA = q53Var.a();
            bi biVar = sy0.k;
            Object objF4 = Boolean.TRUE;
            zl1VarA.getClass();
            try {
                objF4 = zl1VarA.f(biVar);
            } catch (IllegalArgumentException unused) {
            }
            if (bool.equals(objF4)) {
                xq4.d("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                xq4.c(4, "ImageCapture");
                q53Var.a().v(sy0.k, Boolean.TRUE);
            }
        }
        zl1 zl1VarA2 = q53Var.a();
        Boolean bool2 = Boolean.TRUE;
        bi biVar2 = sy0.k;
        Object objF5 = Boolean.FALSE;
        zl1VarA2.getClass();
        try {
            objF5 = zl1VarA2.f(biVar2);
        } catch (IllegalArgumentException unused2) {
        }
        boolean zEquals = bool2.equals(objF5);
        Object objF6 = null;
        boolean z2 = false;
        if (zEquals) {
            if (b() != null) {
                b().n().k();
            }
            try {
                objF3 = zl1VarA2.f(sy0.f);
            } catch (IllegalArgumentException unused3) {
                objF3 = null;
            }
            Integer num = (Integer) objF3;
            if (num == null || num.intValue() == 256) {
                z2 = true;
            } else {
                xq4.d("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z2) {
                xq4.d("ImageCapture", "Unable to support software JPEG. Disabling.");
                zl1VarA2.v(sy0.k, Boolean.FALSE);
            }
        }
        zl1 zl1VarA3 = q53Var.a();
        bi biVar3 = sy0.f;
        zl1VarA3.getClass();
        try {
            objF = zl1VarA3.f(biVar3);
        } catch (IllegalArgumentException unused4) {
            objF = null;
        }
        Integer num2 = (Integer) objF;
        if (num2 != null) {
            if (b() != null) {
                b().n().k();
            }
            q53Var.a().v(wy0.r, Integer.valueOf(z2 ? 35 : num2.intValue()));
        } else {
            zl1 zl1VarA4 = q53Var.a();
            bi biVar4 = sy0.i;
            zl1VarA4.getClass();
            try {
                objF2 = zl1VarA4.f(biVar4);
            } catch (IllegalArgumentException unused5) {
                objF2 = null;
            }
            if (Objects.equals(objF2, 1)) {
                q53Var.a().v(wy0.r, 4101);
                q53Var.a().v(wy0.y, ig0.c);
            } else if (z2) {
                q53Var.a().v(wy0.r, 35);
            } else {
                zl1 zl1VarA5 = q53Var.a();
                bi biVar5 = xy0.G;
                zl1VarA5.getClass();
                try {
                    objF6 = zl1VarA5.f(biVar5);
                } catch (IllegalArgumentException unused6) {
                }
                List list = (List) objF6;
                if (list == null || D(256, list)) {
                    q53Var.a().v(wy0.r, 256);
                } else if (D(35, list)) {
                    q53Var.a().v(wy0.r, 35);
                }
            }
        }
        return q53Var.b();
    }

    @Override // defpackage.o53
    public final void t() {
        sb2 sb2Var = this.t;
        sb2Var.c();
        sb2Var.b();
        lv2 lv2Var = this.w;
        if (lv2Var != null) {
            lv2Var.a();
        }
    }

    public final String toString() {
        return "ImageCapture:".concat(f());
    }

    @Override // defpackage.o53
    public final fj u(s30 s30Var) {
        this.u.a(s30Var);
        Object[] objArr = {this.u.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        z(Collections.unmodifiableList(arrayList));
        cj cjVarA = this.g.a();
        cjVarA.e = s30Var;
        return cjVarA.i();
    }

    @Override // defpackage.o53
    public final fj v(fj fjVar, fj fjVar2) {
        gh2 gh2VarB = B(d(), (sy0) this.f, fjVar);
        this.u = gh2VarB;
        Object[] objArr = {gh2VarB.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        z(Collections.unmodifiableList(arrayList));
        m();
        return fjVar;
    }

    @Override // defpackage.o53
    public final void w() {
        sb2 sb2Var = this.t;
        sb2Var.c();
        sb2Var.b();
        lv2 lv2Var = this.w;
        if (lv2Var != null) {
            lv2Var.a();
        }
        A(false);
        c().g(null);
    }
}
