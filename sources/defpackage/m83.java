package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m83 implements n53 {
    public final HashSet a;
    public final u53 f;
    public final wt i;
    public final wt j;
    public final HashSet n;
    public final HashMap s;
    public final m62 t;
    public final m62 u;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final HashMap e = new HashMap();
    public final ow k = new ow(2, this);

    public m83(wt wtVar, wt wtVar2, HashSet hashSet, u53 u53Var, zq zqVar) {
        this.i = wtVar;
        this.j = wtVar2;
        this.f = u53Var;
        this.a = hashSet;
        HashMap map = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            o53 o53Var = (o53) it.next();
            map.put(o53Var, o53Var.l(wtVar.i(), null, o53Var.e(true, u53Var)));
        }
        this.s = map;
        HashSet hashSet2 = new HashSet(map.values());
        this.n = hashSet2;
        this.t = new m62(wtVar, hashSet2);
        if (this.j != null) {
            this.u = new m62(this.j, hashSet2);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            o53 o53Var2 = (o53) it2.next();
            this.e.put(o53Var2, Boolean.FALSE);
            this.c.put(o53Var2, new l83(wtVar, this, zqVar));
        }
    }

    public static void q(st2 st2Var, ob0 ob0Var, kh2 kh2Var) {
        st2Var.d();
        try {
            vc4.b();
            st2Var.a();
            rt2 rt2Var = st2Var.l;
            Objects.requireNonNull(rt2Var);
            rt2Var.g(ob0Var, new nt2(rt2Var, 0));
        } catch (nb0 unused) {
            ih2 ih2Var = kh2Var.f;
            if (ih2Var != null) {
                ih2Var.a(kh2Var);
            }
        }
    }

    public static ob0 r(o53 o53Var) {
        List listB = o53Var instanceof ry0 ? o53Var.m.b() : Collections.unmodifiableList(o53Var.m.g.a);
        hh1.e(null, listB.size() <= 1);
        if (listB.size() == 1) {
            return (ob0) listB.get(0);
        }
        return null;
    }

    @Override // defpackage.n53
    public final void c(o53 o53Var) {
        ob0 ob0VarR;
        vc4.b();
        st2 st2VarS = s(o53Var);
        if (t(o53Var) && (ob0VarR = r(o53Var)) != null) {
            q(st2VarS, ob0VarR, o53Var.m);
        }
    }

    @Override // defpackage.n53
    public final void j(o53 o53Var) {
        vc4.b();
        if (t(o53Var)) {
            return;
        }
        this.e.put(o53Var, Boolean.TRUE);
        ob0 ob0VarR = r(o53Var);
        if (ob0VarR != null) {
            q(s(o53Var), ob0VarR, o53Var.m);
        }
    }

    @Override // defpackage.n53
    public final void m(o53 o53Var) {
        vc4.b();
        if (t(o53Var)) {
            this.e.put(o53Var, Boolean.FALSE);
            st2 st2VarS = s(o53Var);
            vc4.b();
            st2VarS.a();
            st2VarS.l.a();
        }
    }

    @Override // defpackage.n53
    public final void o(o53 o53Var) {
        vc4.b();
        if (t(o53Var)) {
            st2 st2VarS = s(o53Var);
            ob0 ob0VarR = r(o53Var);
            if (ob0VarR != null) {
                q(st2VarS, ob0VarR, o53Var.m);
                return;
            }
            vc4.b();
            st2VarS.a();
            st2VarS.l.a();
        }
    }

    public final ui p(o53 o53Var, m62 m62Var, wt wtVar, st2 st2Var, int i, boolean z) {
        Size sizeE;
        int i2;
        int iF = wtVar.i().f(i);
        Matrix matrix = st2Var.b;
        RectF rectF = z13.a;
        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = (f2 * f4) + (f * f3);
        float f6 = (f * f4) - (f2 * f3);
        float f7 = (f4 * f4) + (f3 * f3);
        boolean z2 = false;
        double dSqrt = Math.sqrt((f2 * f2) + (f * f)) * Math.sqrt(f7);
        boolean z3 = ((float) Math.toDegrees(Math.atan2(((double) f6) / dSqrt, ((double) f5) / dSqrt))) > 0.0f;
        r53 r53Var = (r53) this.s.get(o53Var);
        Objects.requireNonNull(r53Var);
        Rect rectA = st2Var.d;
        float[] fArr2 = new float[9];
        st2Var.b.getValues(fArr2);
        int iG = z13.g((int) Math.round(Math.atan2(fArr2[3], fArr2[0]) * 57.29577951308232d));
        m62Var.getClass();
        if (z13.c(iG)) {
            rectA = new Rect(rectA.top, rectA.left, rectA.bottom, rectA.right);
            z2 = true;
        }
        if (z) {
            sizeE = z13.e(rectA);
            Iterator it = m62Var.b(r53Var).iterator();
            while (it.hasNext()) {
                Size sizeE2 = z13.e(m62.a((Size) it.next(), sizeE));
                if (!m62.c(sizeE2, sizeE)) {
                    sizeE = sizeE2;
                    break;
                }
            }
        } else {
            Size sizeE3 = z13.e(rectA);
            List listB = m62Var.b(r53Var);
            Iterator it2 = listB.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    Iterator it3 = listB.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            sizeE = sizeE3;
                            break;
                        }
                        Size size = (Size) it3.next();
                        if (!m62.c(size, sizeE3)) {
                            sizeE = size;
                            break;
                        }
                    }
                } else {
                    Size size2 = (Size) it2.next();
                    Rational rationalG = ug.a;
                    if (!ug.a(rationalG, sizeE3)) {
                        rationalG = ug.c;
                        if (!ug.a(rationalG, sizeE3)) {
                            rationalG = m62.g(sizeE3);
                        }
                    }
                    if (!m62Var.d(rationalG, size2) && !m62.c(size2, sizeE3)) {
                        sizeE = size2;
                        break;
                    }
                }
            }
            rectA = m62.a(sizeE3, sizeE);
        }
        Pair pair = new Pair(rectA, sizeE);
        Rect rect = (Rect) pair.first;
        Size size3 = (Size) pair.second;
        if (z2) {
            Size size4 = new Size(size3.getHeight(), size3.getWidth());
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
            size3 = size4;
        }
        Pair pair2 = new Pair(rect, size3);
        Rect rect2 = (Rect) pair2.first;
        Size size5 = (Size) pair2.second;
        int iF2 = this.i.i().f(((xy0) o53Var.f).i());
        l83 l83Var = (l83) this.c.get(o53Var);
        Objects.requireNonNull(l83Var);
        l83Var.c.c = iF2;
        int iG2 = z13.g((st2Var.i + iF2) - iF);
        if (o53Var instanceof g02) {
            i2 = 1;
        } else {
            i2 = o53Var instanceof ry0 ? 4 : 2;
        }
        return new ui(UUID.randomUUID(), i2, o53Var instanceof ry0 ? 256 : 34, rect2, z13.f(size5, iG2), iG2, o53Var.k(wtVar) ^ z3);
    }

    public final st2 s(o53 o53Var) {
        st2 st2Var = (st2) this.b.get(o53Var);
        Objects.requireNonNull(st2Var);
        return st2Var;
    }

    public final boolean t(o53 o53Var) {
        Boolean bool = (Boolean) this.e.get(o53Var);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public final void u(HashMap map) {
        HashMap map2 = this.b;
        map2.clear();
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            o53 o53Var = (o53) entry.getKey();
            st2 st2Var = (st2) entry.getValue();
            o53Var.x(st2Var.d);
            o53Var.j = new Matrix(st2Var.b);
            o53Var.g = o53Var.v(st2Var.g, null);
            o53Var.o();
        }
    }
}
