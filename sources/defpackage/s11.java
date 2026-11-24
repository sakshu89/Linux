package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s11 extends hz implements Runnable, up1, View.OnAttachStateChangeListener {
    public boolean c;
    public int e;
    public pb3 f;
    public final gm1 i;
    public final hu1 j;
    public final yl1 k;
    public final um2 n;

    public s11() {
        super(1);
        gm1 gm1Var = new gm1(9);
        vb3.a.getClass();
        gm1Var.m(ub3.b, new ec3("caption bar"));
        gm1Var.m(ub3.c, new ec3("display cutout"));
        gm1Var.m(ub3.d, new ec3("ime"));
        gm1Var.m(ub3.e, new ec3("mandatory system gestures"));
        gm1Var.m(ub3.f, new ec3("navigation bars"));
        gm1Var.m(ub3.g, new ec3("status bars"));
        gm1Var.m(ub3.h, new ec3("system gestures"));
        gm1Var.m(ub3.i, new ec3("tappable element"));
        gm1Var.m(ub3.j, new ec3("waterfall"));
        this.i = gm1Var;
        this.j = new hu1(0);
        this.k = new yl1(4);
        this.n = new um2();
    }

    public final void E(pb3 pb3Var) {
        char c;
        char c2;
        boolean z;
        char c3;
        boolean z2;
        boolean z3;
        long j;
        boolean z4;
        boolean z5;
        long[] jArr;
        int[] iArr;
        Object[] objArr;
        Object[] objArr2;
        int i;
        ml1 ml1Var = xb3.a;
        int[] iArr2 = ml1Var.b;
        Object[] objArr3 = ml1Var.c;
        long[] jArr2 = ml1Var.a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i2 = 0;
            z2 = false;
            z3 = false;
            c = 16;
            c2 = ' ';
            while (true) {
                long j2 = jArr2[i2];
                z = true;
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    c3 = '0';
                    while (i5 < i4) {
                        if ((j2 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            int i7 = iArr2[i6];
                            vb3 vb3Var = (vb3) objArr3[i6];
                            q11 q11VarF = pb3Var.a.f(i7);
                            long j3 = (((long) q11VarF.a) << 48) | (((long) q11VarF.b) << 32) | (((long) q11VarF.c) << 16) | ((long) q11VarF.d);
                            Object objG = this.i.g(vb3Var);
                            objG.getClass();
                            ec3 ec3Var = (ec3) objG;
                            if (!oe4.a(j3, ec3Var.h)) {
                                ec3Var.h = j3;
                                z2 = true;
                                if (!oe4.a(j3, 0L)) {
                                    z3 = true;
                                }
                            }
                            if (i7 != 8) {
                                q11 q11VarG = pb3Var.a.g(i7);
                                objArr2 = objArr3;
                                long j4 = (((long) q11VarG.b) << 32) | (((long) q11VarG.a) << 48) | (((long) q11VarG.c) << 16) | ((long) q11VarG.d);
                                if (!oe4.a(ec3Var.i, j4)) {
                                    ec3Var.i = j4;
                                    z2 = true;
                                    if (!oe4.a(j4, 0L)) {
                                        z3 = true;
                                    }
                                }
                            } else {
                                objArr2 = objArr3;
                            }
                            ec3Var.a.setValue(Boolean.valueOf(pb3Var.a.o(i7)));
                            i = 8;
                        } else {
                            objArr2 = objArr3;
                            i = i3;
                        }
                        j2 >>= i;
                        i5++;
                        i3 = i;
                        objArr3 = objArr2;
                        jArr2 = jArr2;
                        iArr2 = iArr2;
                    }
                    jArr = jArr2;
                    iArr = iArr2;
                    objArr = objArr3;
                    if (i4 != i3) {
                        break;
                    }
                } else {
                    jArr = jArr2;
                    iArr = iArr2;
                    objArr = objArr3;
                    c3 = '0';
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                objArr3 = objArr;
                jArr2 = jArr;
                iArr2 = iArr;
            }
        } else {
            c = 16;
            c2 = ' ';
            z = true;
            c3 = '0';
            z2 = false;
            z3 = false;
        }
        md0 md0VarE = pb3Var.a.e();
        if (md0VarE == null) {
            j = 0;
        } else {
            q11 q11VarA = md0VarE.a();
            j = (((long) q11VarA.a) << c3) | (((long) q11VarA.b) << c2) | (((long) q11VarA.c) << c) | ((long) q11VarA.d);
        }
        gm1 gm1Var = this.i;
        vb3.a.getClass();
        Object objG2 = gm1Var.g(ub3.j);
        objG2.getClass();
        ec3 ec3Var2 = (ec3) objG2;
        ec3Var2.a.setValue(Boolean.valueOf(!oe4.a(j, 0L)));
        if (!oe4.a(ec3Var2.h, j)) {
            ec3Var2.h = j;
            ec3Var2.i = j;
            z2 = z;
            if (!oe4.a(j, 0L)) {
                z3 = z2;
            }
        }
        if (md0VarE == null) {
            yl1 yl1Var = this.k;
            if (yl1Var.b > 0) {
                yl1Var.d();
                this.n.clear();
                z2 = z;
            }
        } else {
            List listC = Build.VERSION.SDK_INT >= 28 ? p50.c(md0VarE.a) : Collections.EMPTY_LIST;
            int size = listC.size();
            yl1 yl1Var2 = this.k;
            if (size < yl1Var2.b) {
                yl1Var2.l(listC.size(), this.k.b);
                this.n.f(listC.size(), this.n.size());
                z2 = z;
            } else {
                int size2 = listC.size() - this.k.b;
                int i8 = 0;
                while (i8 < size2) {
                    yl1 yl1Var3 = this.k;
                    yl1Var3.a(o44.g(listC.get(yl1Var3.b)));
                    this.n.add(new g11("display cutout rect " + this.k.b));
                    i8++;
                    z2 = z;
                }
            }
            int size3 = listC.size();
            for (int i9 = 0; i9 < size3; i9++) {
                Rect rect = (Rect) listC.get(i9);
                mm1 mm1Var = (mm1) this.k.f(i9);
                if (!g31.a(mm1Var.getValue(), rect)) {
                    mm1Var.setValue(rect);
                    z2 = z;
                }
            }
            if (!listC.isEmpty()) {
                z3 = z;
            }
        }
        if ((z3 || this.j.g() != 0) && z2) {
            hu1 hu1Var = this.j;
            hu1Var.h(hu1Var.g() + 1);
            synchronized (im2.c) {
                hm1 hm1Var = im2.j.h;
                z4 = (hm1Var == null || hm1Var.h() != (z5 = z)) ? false : z5;
            }
            if (z4) {
                im2.a();
            }
        }
    }

    @Override // defpackage.up1
    public final pb3 a(View view, pb3 pb3Var) {
        if (this.c) {
            this.f = pb3Var;
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
                return pb3Var;
            }
        } else if (this.e == 0) {
            E(pb3Var);
        }
        return pb3Var;
    }

    @Override // defpackage.hz
    public final void e(xa3 xa3Var) {
        boolean z = false;
        this.c = false;
        int iD = xa3Var.a.d();
        this.e &= ~iD;
        this.f = null;
        vb3 vb3Var = (vb3) xb3.a.b(iD);
        if (vb3Var != null) {
            Object objG = this.i.g(vb3Var);
            objG.getClass();
            ec3 ec3Var = (ec3) objG;
            ec3Var.c.h(0.0f);
            ec3Var.e.h(1.0f);
            ec3Var.d.h(0L);
            ec3Var.c.h(0.0f);
            ec3Var.b.setValue(Boolean.FALSE);
            ec3Var.j = -1L;
            ec3Var.k = -1L;
            hu1 hu1Var = this.j;
            hu1Var.h(hu1Var.g() + 1);
            synchronized (im2.c) {
                hm1 hm1Var = im2.j.h;
                if (hm1Var != null && hm1Var.h()) {
                    z = true;
                }
            }
            if (z) {
                im2.a();
            }
        }
    }

    @Override // defpackage.hz
    public final void f() {
        this.c = true;
    }

    @Override // defpackage.hz
    public final pb3 g(pb3 pb3Var, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            xa3 xa3Var = (xa3) list.get(i);
            vb3 vb3Var = (vb3) xb3.a.b(xa3Var.a.d());
            if (vb3Var != null) {
                Object objG = this.i.g(vb3Var);
                objG.getClass();
                ec3 ec3Var = (ec3) objG;
                if (((Boolean) ec3Var.b.getValue()).booleanValue()) {
                    wa3 wa3Var = xa3Var.a;
                    ec3Var.c.h(wa3Var.c());
                    ec3Var.e.h(wa3Var.a());
                    ec3Var.d.h(wa3Var.b());
                }
            }
        }
        E(pb3Var);
        return pb3Var;
    }

    @Override // defpackage.hz
    public final cu2 h(xa3 xa3Var, cu2 cu2Var) {
        pb3 pb3Var = this.f;
        boolean z = false;
        this.c = false;
        this.f = null;
        if (xa3Var.a.b() > 0 && pb3Var != null) {
            int iD = xa3Var.a.d();
            this.e |= iD;
            vb3 vb3Var = (vb3) xb3.a.b(iD);
            if (vb3Var != null) {
                Object objG = this.i.g(vb3Var);
                objG.getClass();
                ec3 ec3Var = (ec3) objG;
                q11 q11VarF = pb3Var.a.f(iD);
                long j = (((long) q11VarF.a) << 48) | (((long) q11VarF.b) << 32) | (((long) q11VarF.c) << 16) | ((long) q11VarF.d);
                long j2 = ec3Var.h;
                if (!oe4.a(j, j2)) {
                    ec3Var.j = j2;
                    ec3Var.k = j;
                    ec3Var.b.setValue(Boolean.TRUE);
                    wa3 wa3Var = xa3Var.a;
                    ec3Var.c.h(wa3Var.c());
                    ec3Var.e.h(wa3Var.a());
                    ec3Var.d.h(wa3Var.b());
                    hu1 hu1Var = this.j;
                    hu1Var.h(hu1Var.g() + 1);
                    synchronized (im2.c) {
                        hm1 hm1Var = im2.j.h;
                        if (hm1Var != null && hm1Var.h()) {
                            z = true;
                        }
                    }
                    if (z) {
                        im2.a();
                        return cu2Var;
                    }
                }
            }
        }
        return cu2Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        int i = u73.a;
        o73.f(view, this);
        u73.c(view, this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        int i = u73.a;
        o73.f(view, null);
        u73.c(view, null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c) {
            this.e = 0;
            this.c = false;
            pb3 pb3Var = this.f;
            if (pb3Var != null) {
                E(pb3Var);
                this.f = null;
            }
        }
    }
}
