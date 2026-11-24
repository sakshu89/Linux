package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wu implements cs {
    public final c72 H;
    public final c72 X;
    public final qs4 Y;
    public final qs4 Z;
    public final wt a;
    public final wt b;
    public final l11 c;
    public final u53 e;
    public final yh f;
    public final ArrayList i;
    public final ArrayList j;
    public final lq k;
    public List n;
    public final bt s;
    public final Object t;
    public boolean u;
    public s30 v;
    public o53 w;
    public yr2 x;

    public wu(wt wtVar, wt wtVar2, c72 c72Var, c72 c72Var2, lq lqVar, l11 l11Var, bs bsVar) {
        qs4 qs4Var = qs4.f;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.n = Collections.EMPTY_LIST;
        this.t = new Object();
        this.u = true;
        this.v = null;
        this.a = wtVar;
        this.b = wtVar2;
        this.Y = qs4Var;
        this.Z = qs4Var;
        this.k = lqVar;
        this.c = l11Var;
        this.e = bsVar;
        bt btVar = c72Var.c;
        this.s = btVar;
        btVar.k();
        this.H = c72Var;
        this.X = c72Var2;
        this.f = s(c72Var, c72Var2);
    }

    public static Matrix o(Rect rect, Size size) {
        hh1.a("Cannot compute viewport crop rects zero sized sensor rect.", rect.width() > 0 && rect.height() > 0);
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    public static yh s(c72 c72Var, c72 c72Var2) {
        StringBuilder sb = new StringBuilder();
        sb.append(c72Var.a.c());
        sb.append(c72Var2 == null ? "" : c72Var2.a.c());
        return new yh(sb.toString(), c72Var.c.a);
    }

    public static HashMap t(ArrayList arrayList, u53 u53Var, u53 u53Var2) {
        r53 r53VarE;
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            o53 o53Var = (o53) obj;
            if (o53Var instanceof yr2) {
                yr2 yr2Var = (yr2) o53Var;
                h02 h02Var = new h02(gs1.l(new yr(3).b));
                xy0.s(h02Var);
                g02 g02Var = new g02(h02Var);
                g02Var.p = g02.w;
                r53 r53VarE2 = g02Var.e(false, u53Var);
                if (r53VarE2 == null) {
                    r53VarE = null;
                } else {
                    zl1 zl1VarO = zl1.o(r53VarE2);
                    zl1VarO.a.remove(yv2.N);
                    r53VarE = ((pv) yr2Var.j(zl1VarO)).b();
                }
            } else {
                r53VarE = o53Var.e(false, u53Var);
            }
            r53 r53VarE3 = o53Var.e(true, u53Var2);
            vu vuVar = new vu();
            vuVar.a = r53VarE;
            vuVar.b = r53VarE3;
            map.put(o53Var, vuVar);
        }
        return map;
    }

    public static boolean x(fj fjVar, kh2 kh2Var) {
        s30 s30Var = fjVar.d;
        gs1 gs1Var = kh2Var.g.b;
        if (s30Var.e().size() != kh2Var.g.b.e().size()) {
            return true;
        }
        for (bi biVar : s30Var.e()) {
            if (!gs1Var.a.containsKey(biVar) || !Objects.equals(gs1Var.f(biVar), s30Var.f(biVar))) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList z(ArrayList arrayList, List list) {
        ArrayList arrayList2 = new ArrayList(list);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((o53) obj).getClass();
            Iterator it = list.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                dk0.t();
                return null;
            }
        }
        return arrayList2;
    }

    public final void A(LinkedHashSet linkedHashSet, boolean z) {
        int i;
        HashMap map;
        int i2;
        fj fjVar;
        s30 s30Var;
        int i3;
        boolean z2;
        synchronized (this.t) {
            try {
                w();
                synchronized (this.t) {
                    try {
                        if (!this.n.isEmpty()) {
                            Iterator it = linkedHashSet.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                o53 o53Var = (o53) it.next();
                                if (o53Var instanceof ry0) {
                                    r53 r53Var = o53Var.f;
                                    bi biVar = sy0.i;
                                    if (r53Var.a(biVar)) {
                                        Integer num = (Integer) r53Var.f(biVar);
                                        num.getClass();
                                        if (num.intValue() == 1) {
                                            z2 = true;
                                            break;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if (z2) {
                                throw new IllegalArgumentException("Ultra HDR image capture does not support for use with CameraEffect.");
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!z) {
                    w();
                }
                yr2 yr2VarQ = q(linkedHashSet, z);
                o53 o53VarM = m(linkedHashSet, yr2VarQ);
                ArrayList arrayList = new ArrayList(linkedHashSet);
                if (o53VarM != null) {
                    arrayList.add(o53VarM);
                }
                if (yr2VarQ != null) {
                    arrayList.add(yr2VarQ);
                    arrayList.removeAll(yr2VarQ.p.a);
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                arrayList2.removeAll(this.j);
                ArrayList arrayList3 = new ArrayList(arrayList);
                arrayList3.retainAll(this.j);
                ArrayList arrayList4 = new ArrayList(this.j);
                arrayList4.removeAll(arrayList);
                HashMap mapT = t(arrayList2, (u53) this.s.d(zs.d, u53.a), this.e);
                Map mapP = Collections.EMPTY_MAP;
                try {
                    synchronized (this.t) {
                        try {
                            i = this.k.c == 2 ? 1 : 0;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    HashMap mapP2 = p(i, this.a.i(), arrayList2, arrayList3, mapT);
                    if (this.b != null) {
                        synchronized (this.t) {
                            try {
                                i3 = this.k.c == 2 ? 1 : 0;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                        wt wtVar = this.b;
                        Objects.requireNonNull(wtVar);
                        map = mapP2;
                        mapP = p(i3, wtVar.i(), arrayList2, arrayList3, mapT);
                    } else {
                        map = mapP2;
                    }
                    B(map, arrayList);
                    ArrayList arrayListZ = z(arrayList, this.n);
                    ArrayList arrayList5 = new ArrayList(linkedHashSet);
                    arrayList5.removeAll(arrayList);
                    ArrayList arrayListZ2 = z(arrayList5, arrayListZ);
                    if (arrayListZ2.size() > 0) {
                        xq4.d("CameraUseCaseAdapter", "Unused effects: " + arrayListZ2);
                    }
                    int size = arrayList4.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj = arrayList4.get(i4);
                        i4++;
                        ((o53) obj).y(this.a);
                    }
                    this.a.d(arrayList4);
                    if (this.b != null) {
                        int size2 = arrayList4.size();
                        int i5 = 0;
                        while (i5 < size2) {
                            Object obj2 = arrayList4.get(i5);
                            i5++;
                            wt wtVar2 = this.b;
                            Objects.requireNonNull(wtVar2);
                            ((o53) obj2).y(wtVar2);
                        }
                        wt wtVar3 = this.b;
                        Objects.requireNonNull(wtVar3);
                        wtVar3.d(arrayList4);
                    }
                    if (arrayList4.isEmpty()) {
                        int size3 = arrayList3.size();
                        int i6 = 0;
                        while (i6 < size3) {
                            Object obj3 = arrayList3.get(i6);
                            i6++;
                            o53 o53Var2 = (o53) obj3;
                            if (!map.containsKey(o53Var2) || (s30Var = (fjVar = (fj) map.get(o53Var2)).d) == null) {
                                i2 = size3;
                            } else {
                                i2 = size3;
                                if (x(fjVar, o53Var2.m)) {
                                    o53Var2.g = o53Var2.u(s30Var);
                                    if (this.u) {
                                        this.a.o(o53Var2);
                                        wt wtVar4 = this.b;
                                        if (wtVar4 != null) {
                                            wtVar4.o(o53Var2);
                                        }
                                    }
                                }
                            }
                            size3 = i2;
                        }
                    }
                    int i7 = 0;
                    for (int size4 = arrayList2.size(); i7 < size4; size4 = size4) {
                        Object obj4 = arrayList2.get(i7);
                        i7++;
                        o53 o53Var3 = (o53) obj4;
                        vu vuVar = (vu) mapT.get(o53Var3);
                        Objects.requireNonNull(vuVar);
                        wt wtVar5 = this.b;
                        wt wtVar6 = this.a;
                        if (wtVar5 != null) {
                            o53Var3.a(wtVar6, wtVar5, vuVar.a, vuVar.b);
                            fj fjVar2 = (fj) map.get(o53Var3);
                            fjVar2.getClass();
                            o53Var3.g = o53Var3.v(fjVar2, (fj) mapP.get(o53Var3));
                        } else {
                            o53Var3.a(wtVar6, null, vuVar.a, vuVar.b);
                            fj fjVar3 = (fj) map.get(o53Var3);
                            fjVar3.getClass();
                            o53Var3.g = o53Var3.v(fjVar3, null);
                        }
                    }
                    if (this.u) {
                        this.a.f(arrayList2);
                        wt wtVar7 = this.b;
                        if (wtVar7 != null) {
                            wtVar7.f(arrayList2);
                        }
                    }
                    int size5 = arrayList2.size();
                    int i8 = 0;
                    while (i8 < size5) {
                        Object obj5 = arrayList2.get(i8);
                        i8++;
                        ((o53) obj5).o();
                    }
                    this.i.clear();
                    this.i.addAll(linkedHashSet);
                    this.j.clear();
                    this.j.addAll(arrayList);
                    this.w = o53VarM;
                    this.x = yr2VarQ;
                } catch (IllegalArgumentException e) {
                    if (!z) {
                        w();
                        if (this.k.c != 2) {
                            A(linkedHashSet, true);
                            return;
                        }
                    }
                    throw e;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public final void B(HashMap map, ArrayList arrayList) {
        synchronized (this.t) {
            try {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    o53 o53Var = (o53) obj;
                    Rect rectE = this.a.l().e();
                    fj fjVar = (fj) map.get(o53Var);
                    fjVar.getClass();
                    Matrix matrixO = o(rectE, fjVar.a);
                    o53Var.getClass();
                    o53Var.j = new Matrix(matrixO);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.cs
    public final ut a() {
        return this.H;
    }

    public final void c(List list) {
        synchronized (this.t) {
            try {
                this.a.e(this.s);
                wt wtVar = this.b;
                if (wtVar != null) {
                    wtVar.e(this.s);
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.i);
                linkedHashSet.addAll(list);
                try {
                    A(linkedHashSet, this.b != null);
                } catch (IllegalArgumentException e) {
                    throw new uu(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j() {
        synchronized (this.t) {
            try {
                if (!this.u) {
                    if (!this.j.isEmpty()) {
                        this.a.e(this.s);
                        wt wtVar = this.b;
                        if (wtVar != null) {
                            wtVar.e(this.s);
                        }
                    }
                    this.a.f(this.j);
                    wt wtVar2 = this.b;
                    if (wtVar2 != null) {
                        wtVar2.f(this.j);
                    }
                    synchronized (this.t) {
                        try {
                            if (this.v != null) {
                                this.a.l().c(this.v);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    ArrayList arrayList = this.j;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((o53) obj).o();
                    }
                    this.u = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00d6  */
    public final o53 m(LinkedHashSet linkedHashSet, yr2 yr2Var) {
        boolean z;
        boolean z2;
        o53 o53VarC;
        synchronized (this.t) {
            try {
                ArrayList arrayList = new ArrayList(linkedHashSet);
                if (yr2Var != null) {
                    arrayList.add(yr2Var);
                    arrayList.removeAll(yr2Var.p.a);
                }
                synchronized (this.t) {
                    z = false;
                    z2 = ((Integer) this.s.d(zs.g, 0)).intValue() == 1;
                }
                if (z2) {
                    int size = arrayList.size();
                    boolean z3 = false;
                    boolean z4 = false;
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        o53 o53Var = (o53) obj;
                        if ((o53Var instanceof g02) || (o53Var instanceof yr2)) {
                            z4 = true;
                        } else if (o53Var instanceof ry0) {
                            z3 = true;
                        }
                    }
                    if (!z3 || z4) {
                        int size2 = arrayList.size();
                        boolean z5 = false;
                        int i2 = 0;
                        while (i2 < size2) {
                            Object obj2 = arrayList.get(i2);
                            i2++;
                            o53 o53Var2 = (o53) obj2;
                            if ((o53Var2 instanceof g02) || (o53Var2 instanceof yr2)) {
                                z = true;
                            } else if (o53Var2 instanceof ry0) {
                                z5 = true;
                            }
                        }
                        if (!z || z5) {
                            o53VarC = null;
                        } else {
                            o53 o53Var3 = this.w;
                            if (o53Var3 instanceof ry0) {
                                o53VarC = o53Var3;
                            } else {
                                yr yrVar = new yr(2);
                                yrVar.b.v(yv2.M, "ImageCapture-Extra");
                                o53VarC = yrVar.c();
                            }
                        }
                    } else {
                        o53 o53Var4 = this.w;
                        if (o53Var4 instanceof g02) {
                            o53VarC = o53Var4;
                        } else {
                            yr yrVar2 = new yr(3);
                            yrVar2.b.v(yv2.M, "Preview-Extra");
                            h02 h02Var = new h02(gs1.l(yrVar2.b));
                            xy0.s(h02Var);
                            g02 g02Var = new g02(h02Var);
                            g02Var.p = g02.w;
                            g02Var.B(new og(16));
                            o53VarC = g02Var;
                        }
                    }
                } else {
                    o53VarC = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return o53VarC;
    }

    public final HashMap p(int i, ut utVar, ArrayList arrayList, ArrayList arrayList2, HashMap map) {
        l11 l11Var;
        HashMap map2;
        Rect rectE;
        int size;
        int i2;
        boolean z;
        ArrayList arrayList3 = new ArrayList();
        String strC = utVar.c();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        int size2 = arrayList2.size();
        int i3 = 0;
        while (true) {
            l11Var = this.c;
            map2 = null;
            if (i3 >= size2) {
                break;
            }
            Object obj = arrayList2.get(i3);
            i3++;
            o53 o53Var = (o53) obj;
            int iP = o53Var.f.p();
            fj fjVar = o53Var.g;
            Size size3 = fjVar != null ? fjVar.a : null;
            jt2 jt2Var = (jt2) ((HashMap) l11Var.b).get(strC);
            hj hjVarB = jt2Var != null ? hj.b(i, iP, size3, jt2Var.i(iP)) : null;
            int iP2 = o53Var.f.p();
            fj fjVar2 = o53Var.g;
            Size size4 = fjVar2 != null ? fjVar2.a : null;
            fjVar2.getClass();
            rh rhVar = new rh(hjVarB, iP2, size4, fjVar2.b, yr2.E(o53Var), o53Var.g.d, (Range) o53Var.f.d(r53.T, null));
            arrayList3.add(rhVar);
            map4.put(rhVar, o53Var);
            map3.put(o53Var, o53Var.g);
            size2 = size2;
        }
        if (!arrayList.isEmpty()) {
            HashMap map5 = new HashMap();
            HashMap map6 = new HashMap();
            try {
                rectE = this.a.l().e();
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    o53 o53Var2 = (o53) obj2;
                    if (o53Var2 != null) {
                        if (o53Var2.f.a(r53.W)) {
                            if (o53Var2.f.j() == t53.e) {
                                z = true;
                                break;
                            }
                        } else {
                            Log.e("CameraUseCaseAdapter", o53Var2 + " UseCase does not have capture type.");
                        }
                    }
                }
            } catch (NullPointerException unused) {
                rectE = null;
            }
            kf kfVar = new kf(utVar, rectE != null ? z13.e(rectE) : null);
            int size5 = arrayList.size();
            boolean z2 = false;
            int i4 = 0;
            while (i4 < size5) {
                Object obj3 = arrayList.get(i4);
                i4++;
                HashMap map7 = map2;
                o53 o53Var3 = (o53) obj3;
                int i5 = size5;
                vu vuVar = (vu) map.get(o53Var3);
                boolean z3 = z2;
                r53 r53VarL = o53Var3.l(utVar, vuVar.a, vuVar.b);
                map5.put(r53VarL, o53Var3);
                map6.put(r53VarL, kfVar.s(r53VarL));
                r53 r53Var = o53Var3.f;
                z2 = r53Var instanceof h02 ? ((h02) r53Var).q() == 2 : z3;
                size5 = i5;
                map2 = map7;
            }
            boolean z4 = z2;
            HashMap map8 = map2;
            size = arrayList.size();
            i2 = 0;
            l11Var.getClass();
            hh1.a("No new use cases to be bound.", !map6.isEmpty());
            jt2 jt2Var2 = (jt2) ((HashMap) l11Var.b).get(strC);
            if (jt2Var2 == null) {
                og.i(cq.j("No such camera id in supported combination list: ", strC));
                return map8;
            }
            Pair pairG = jt2Var2.g(i, arrayList3, map6, z4, z);
            for (Map.Entry entry : map5.entrySet()) {
                map3.put((o53) entry.getValue(), (fj) ((Map) pairG.first).get(entry.getKey()));
            }
            for (Map.Entry entry2 : ((Map) pairG.second).entrySet()) {
                if (map4.containsKey(entry2.getKey())) {
                    map3.put((o53) map4.get(entry2.getKey()), (fj) entry2.getValue());
                }
            }
        }
        return map3;
    }

    public final yr2 q(LinkedHashSet linkedHashSet, boolean z) {
        boolean z2;
        synchronized (this.t) {
            try {
                HashSet<o53> hashSetU = u(linkedHashSet, z);
                if (hashSetU.size() < 2) {
                    w();
                    return null;
                }
                yr2 yr2Var = this.x;
                if (yr2Var != null && yr2Var.p.a.equals(hashSetU)) {
                    yr2 yr2Var2 = this.x;
                    Objects.requireNonNull(yr2Var2);
                    return yr2Var2;
                }
                int[] iArr = {1, 2, 4};
                HashSet hashSet = new HashSet();
                for (o53 o53Var : hashSetU) {
                    for (int i = 0; i < 3; i++) {
                        int i2 = iArr[i];
                        Iterator it = o53Var.i().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            int iIntValue = ((Integer) it.next()).intValue();
                            if ((i2 & iIntValue) == iIntValue) {
                                z2 = true;
                                break;
                            }
                        }
                        if (z2) {
                            if (hashSet.contains(Integer.valueOf(i2))) {
                                return null;
                            }
                            hashSet.add(Integer.valueOf(i2));
                        }
                    }
                }
                return new yr2(this.a, this.b, this.Y, this.Z, hashSetU, this.e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        synchronized (this.t) {
            try {
                if (this.u) {
                    this.a.d(new ArrayList(this.j));
                    wt wtVar = this.b;
                    if (wtVar != null) {
                        wtVar.d(new ArrayList(this.j));
                    }
                    synchronized (this.t) {
                        gt gtVarL = this.a.l();
                        this.v = gtVarL.b();
                        gtVarL.d();
                    }
                    this.u = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final HashSet u(LinkedHashSet linkedHashSet, boolean z) {
        int i;
        HashSet hashSet = new HashSet();
        synchronized (this.t) {
            Iterator it = this.n.iterator();
            if (it.hasNext()) {
                if (it.next() == null) {
                    throw null;
                }
                throw new ClassCastException();
            }
            i = z ? 3 : 0;
        }
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            o53 o53Var = (o53) it2.next();
            hh1.a("Only support one level of sharing for now.", !(o53Var instanceof yr2));
            Iterator it3 = o53Var.i().iterator();
            while (it3.hasNext()) {
                int iIntValue = ((Integer) it3.next()).intValue();
                if ((i & iIntValue) == iIntValue) {
                    hashSet.add(o53Var);
                    break;
                }
            }
        }
        return hashSet;
    }

    public final List v() {
        ArrayList arrayList;
        synchronized (this.t) {
            arrayList = new ArrayList(this.i);
        }
        return arrayList;
    }

    public final void w() {
        synchronized (this.t) {
            this.s.k();
        }
    }

    public final void y(ArrayList arrayList) {
        synchronized (this.t) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.i);
            linkedHashSet.removeAll(arrayList);
            A(linkedHashSet, this.b != null);
        }
    }
}
