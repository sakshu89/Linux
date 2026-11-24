package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yr2 extends o53 {
    public hh2 A;
    public final zr2 o;
    public final m83 p;
    public final qs4 q;
    public final qs4 r;
    public kf s;
    public cj t;
    public st2 u;
    public st2 v;
    public st2 w;
    public st2 x;
    public gh2 y;
    public gh2 z;

    public yr2(wt wtVar, wt wtVar2, qs4 qs4Var, qs4 qs4Var2, HashSet hashSet, u53 u53Var) {
        super(F(hashSet));
        this.o = F(hashSet);
        this.q = qs4Var;
        this.r = qs4Var2;
        this.p = new m83(wtVar, wtVar2, hashSet, u53Var, new zq(9, this));
    }

    public static ArrayList E(o53 o53Var) {
        ArrayList arrayList = new ArrayList();
        if (!(o53Var instanceof yr2)) {
            arrayList.add(o53Var.f.j());
            return arrayList;
        }
        Iterator it = ((yr2) o53Var).p.a.iterator();
        while (it.hasNext()) {
            arrayList.add(((o53) it.next()).f.j());
        }
        return arrayList;
    }

    public static zr2 F(HashSet hashSet) {
        zl1 zl1VarM = zl1.m();
        new pv(zl1VarM);
        zl1VarM.v(wy0.r, 34);
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            o53 o53Var = (o53) it.next();
            if (o53Var.f.a(r53.W)) {
                arrayList.add(o53Var.f.j());
            } else {
                Log.e("StreamSharing", "A child does not have capture type.");
            }
        }
        zl1VarM.v(zr2.b, arrayList);
        zl1VarM.v(xy0.C, 2);
        return new zr2(gs1.l(zl1VarM));
    }

    public final void A() {
        hh2 hh2Var = this.A;
        if (hh2Var != null) {
            hh2Var.b();
            this.A = null;
        }
        st2 st2Var = this.u;
        if (st2Var != null) {
            st2Var.b();
            this.u = null;
        }
        st2 st2Var2 = this.v;
        if (st2Var2 != null) {
            st2Var2.b();
            this.v = null;
        }
        st2 st2Var3 = this.w;
        if (st2Var3 != null) {
            st2Var3.b();
            this.w = null;
        }
        st2 st2Var4 = this.x;
        if (st2Var4 != null) {
            st2Var4.b();
            this.x = null;
        }
        kf kfVar = this.s;
        if (kfVar != null) {
            ((fb0) kfVar.b).a();
            vc4.d(new s7(27, kfVar));
            this.s = null;
        }
        cj cjVar = this.t;
        if (cjVar != null) {
            ((yt2) cjVar.b).a();
            vc4.d(new s7(20, cjVar));
            this.t = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List B(String str, String str2, r53 r53Var, fj fjVar, fj fjVar2) {
        boolean z;
        vc4.b();
        m83 m83Var = this.p;
        if (fjVar2 == null) {
            C(str, str2, r53Var, fjVar, null);
            wt wtVarB = b();
            Objects.requireNonNull(wtVarB);
            this.s = new kf(wtVarB, new fb0(fjVar.b));
            boolean z2 = this.i != null;
            st2 st2Var = this.w;
            int i = ((xy0) this.f).i();
            m83Var.getClass();
            HashMap map = new HashMap();
            for (o53 o53Var : m83Var.a) {
                m62 m62Var = m83Var.t;
                wt wtVar = m83Var.i;
                m83 m83Var2 = m83Var;
                boolean z3 = z2;
                map.put(o53Var, m83Var2.p(o53Var, m62Var, wtVar, st2Var, i, z3));
                z2 = z3;
                m83Var = m83Var2;
            }
            m83 m83Var3 = m83Var;
            kf kfVar = this.s;
            st2 st2Var2 = this.w;
            ArrayList arrayList = new ArrayList(map.values());
            if (st2Var2 == null) {
                dk0.n("Null surfaceEdge");
                return null;
            }
            kfVar.getClass();
            vc4.b();
            kfVar.e = new dg0();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                int i3 = i2 + 1;
                ui uiVar = (ui) obj;
                dg0 dg0Var = (dg0) kfVar.e;
                Rect rect = uiVar.d;
                int i4 = uiVar.f;
                boolean z4 = uiVar.g;
                Matrix matrix = new Matrix(st2Var2.b);
                RectF rectF = new RectF(rect);
                Size size2 = uiVar.e;
                RectF rectF2 = z13.a;
                ArrayList arrayList2 = arrayList;
                int i5 = size;
                HashMap map2 = map;
                matrix.postConcat(z13.a(rectF, new RectF(0.0f, 0.0f, size2.getWidth(), size2.getHeight()), i4, z4));
                hh1.b(z13.d(z13.f(z13.e(rect), i4), false, size2));
                Rect rect2 = new Rect(0, 0, size2.getWidth(), size2.getHeight());
                cj cjVarA = st2Var2.g.a();
                cjVarA.b = size2;
                dg0Var.put(uiVar, new st2(uiVar.b, uiVar.c, cjVarA.i(), matrix, false, rect2, st2Var2.i - i4, -1, st2Var2.e != z4));
                arrayList = arrayList2;
                size = i5;
                i2 = i3;
                map = map2;
            }
            HashMap map3 = map;
            ((fb0) kfVar.b).c(st2Var2.c((wt) kfVar.c, true));
            for (Map.Entry entry : ((dg0) kfVar.e).entrySet()) {
                kfVar.g(st2Var2, entry);
                st2 st2Var3 = (st2) entry.getValue();
                dc dcVar = new dc(kfVar, st2Var2, entry, 12);
                st2Var3.getClass();
                vc4.b();
                st2Var3.a();
                st2Var3.m.add(dcVar);
            }
            st2Var2.o.add(new zt2(0, (dg0) kfVar.e));
            dg0 dg0Var2 = (dg0) kfVar.e;
            HashMap map4 = new HashMap();
            for (Map.Entry entry2 : map3.entrySet()) {
                map4.put((o53) entry2.getKey(), (st2) dg0Var2.get(entry2.getValue()));
            }
            m83Var3.u(map4);
            Object[] objArr = {this.y.c()};
            ArrayList arrayList3 = new ArrayList(1);
            Object obj2 = objArr[0];
            Objects.requireNonNull(obj2);
            arrayList3.add(obj2);
            return Collections.unmodifiableList(arrayList3);
        }
        C(str, str2, r53Var, fjVar, fjVar2);
        Matrix matrix2 = this.j;
        wt wtVarH = h();
        Objects.requireNonNull(wtVarH);
        boolean zG = wtVarH.g();
        Size size3 = fjVar2.a;
        Rect rect3 = this.i;
        if (rect3 != null) {
            z = false;
        } else {
            z = false;
            rect3 = new Rect(0, 0, size3.getWidth(), size3.getHeight());
        }
        Rect rect4 = rect3;
        wt wtVarH2 = h();
        Objects.requireNonNull(wtVarH2);
        int iG = g(wtVarH2, z);
        wt wtVarH3 = h();
        Objects.requireNonNull(wtVarH3);
        st2 st2Var4 = new st2(3, 34, fjVar2, matrix2, zG, rect4, iG, -1, k(wtVarH3));
        this.v = st2Var4;
        Objects.requireNonNull(h());
        this.x = st2Var4;
        gh2 gh2VarD = D(this.v, r53Var, fjVar2);
        this.z = gh2VarD;
        hh2 hh2Var = this.A;
        if (hh2Var != null) {
            hh2Var.b();
        }
        hh2 hh2Var2 = new hh2(new xr2(this, str, str2, r53Var, fjVar, fjVar2));
        this.A = hh2Var2;
        gh2VarD.f = hh2Var2;
        wt wtVarB2 = b();
        wt wtVarH4 = h();
        cg0 cg0Var = new cg0(fjVar.b, this.q, this.r);
        cj cjVar = new cj();
        cjVar.c = wtVarB2;
        cjVar.e = wtVarH4;
        cjVar.b = cg0Var;
        this.t = cjVar;
        boolean z5 = this.i != null;
        st2 st2Var5 = this.w;
        st2 st2Var6 = this.x;
        int i6 = ((xy0) this.f).i();
        m83Var.getClass();
        HashMap map5 = new HashMap();
        for (o53 o53Var2 : m83Var.a) {
            ui uiVarP = m83Var.p(o53Var2, m83Var.t, m83Var.i, st2Var5, i6, z5);
            m62 m62Var2 = m83Var.u;
            wt wtVar2 = m83Var.j;
            Objects.requireNonNull(wtVar2);
            map5.put(o53Var2, new ei(uiVarP, m83Var.p(o53Var2, m62Var2, wtVar2, st2Var6, i6, z5)));
            st2Var5 = st2Var5;
        }
        cj cjVar2 = this.t;
        fi fiVar = new fi(this.w, this.x, new ArrayList(map5.values()));
        cjVar2.getClass();
        yt2 yt2Var = (yt2) cjVar2.b;
        vc4.b();
        cjVar2.a = fiVar;
        cjVar2.f = new dg0();
        fi fiVar2 = (fi) cjVar2.a;
        st2 st2Var7 = fiVar2.a;
        st2 st2Var8 = fiVar2.b;
        ArrayList arrayList4 = fiVar2.c;
        int size4 = arrayList4.size();
        int i7 = 0;
        while (i7 < size4) {
            Object obj3 = arrayList4.get(i7);
            int i8 = i7 + 1;
            ei eiVar = (ei) obj3;
            dg0 dg0Var3 = (dg0) cjVar2.f;
            ui uiVar2 = eiVar.a;
            Rect rect5 = uiVar2.d;
            int i9 = uiVar2.f;
            boolean z6 = uiVar2.g;
            Matrix matrix3 = new Matrix();
            Size sizeF = z13.f(z13.e(rect5), i9);
            ArrayList arrayList5 = arrayList4;
            Size size5 = uiVar2.e;
            int i10 = size4;
            hh1.b(z13.d(sizeF, false, size5));
            HashMap map6 = map5;
            Rect rect6 = new Rect(0, 0, size5.getWidth(), size5.getHeight());
            cj cjVarA2 = st2Var7.g.a();
            cjVarA2.b = size5;
            dg0Var3.put(eiVar, new st2(uiVar2.b, uiVar2.c, cjVarA2.i(), matrix3, false, rect6, st2Var7.i - i9, -1, st2Var7.e != z6));
            size4 = i10;
            i7 = i8;
            map5 = map6;
            arrayList4 = arrayList5;
        }
        HashMap map7 = map5;
        yt2Var.c(st2Var7.c((wt) cjVar2.c, true));
        yt2Var.c(st2Var8.c((wt) cjVar2.e, false));
        wt wtVar3 = (wt) cjVar2.c;
        wt wtVar4 = (wt) cjVar2.e;
        for (Map.Entry entry3 : ((dg0) cjVar2.f).entrySet()) {
            st2 st2Var9 = st2Var7;
            st2 st2Var10 = st2Var8;
            cjVar2.l(wtVar3, wtVar4, st2Var9, st2Var10, entry3);
            st2 st2Var11 = (st2) entry3.getValue();
            wt wtVar5 = wtVar4;
            wt wtVar6 = wtVar3;
            cj cjVar3 = cjVar2;
            pq pqVar = new pq(cjVar3, wtVar6, wtVar5, st2Var9, st2Var10, entry3, 3);
            cjVar2 = cjVar3;
            wtVar3 = wtVar6;
            wtVar4 = wtVar5;
            st2Var11.getClass();
            vc4.b();
            st2Var11.a();
            st2Var11.m.add(pqVar);
            st2Var7 = st2Var9;
            st2Var8 = st2Var10;
        }
        dg0 dg0Var4 = (dg0) cjVar2.f;
        HashMap map8 = new HashMap();
        for (Map.Entry entry4 : map7.entrySet()) {
            map8.put((o53) entry4.getKey(), (st2) dg0Var4.get(entry4.getValue()));
        }
        m83Var.u(map8);
        Object[] objArr2 = {this.y.c(), this.z.c()};
        ArrayList arrayList6 = new ArrayList(2);
        for (int i11 = 0; i11 < 2; i11++) {
            Object obj4 = objArr2[i11];
            Objects.requireNonNull(obj4);
            arrayList6.add(obj4);
        }
        return Collections.unmodifiableList(arrayList6);
    }

    public final void C(String str, String str2, r53 r53Var, fj fjVar, fj fjVar2) {
        Matrix matrix = this.j;
        wt wtVarB = b();
        Objects.requireNonNull(wtVarB);
        boolean zG = wtVarB.g();
        Size size = fjVar.a;
        Rect rect = this.i;
        if (rect == null) {
            rect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        wt wtVarB2 = b();
        Objects.requireNonNull(wtVarB2);
        int iG = g(wtVarB2, false);
        wt wtVarB3 = b();
        Objects.requireNonNull(wtVarB3);
        st2 st2Var = new st2(3, 34, fjVar, matrix, zG, rect, iG, -1, k(wtVarB3));
        this.u = st2Var;
        Objects.requireNonNull(b());
        this.w = st2Var;
        gh2 gh2VarD = D(this.u, r53Var, fjVar);
        this.y = gh2VarD;
        hh2 hh2Var = this.A;
        if (hh2Var != null) {
            hh2Var.b();
        }
        hh2 hh2Var2 = new hh2(new xr2(this, str, str2, r53Var, fjVar, fjVar2));
        this.A = hh2Var2;
        gh2VarD.f = hh2Var2;
    }

    public final gh2 D(st2 st2Var, r53 r53Var, fj fjVar) {
        gh2 gh2VarD = gh2.d(r53Var, fjVar.a);
        ur urVar = gh2VarD.b;
        m83 m83Var = this.p;
        Iterator it = m83Var.a.iterator();
        int i = -1;
        while (it.hasNext()) {
            int i2 = ((kh2) ((o53) it.next()).f.f(r53.O)).g.c;
            List list = kh2.i;
            if (list.indexOf(Integer.valueOf(i)) < list.indexOf(Integer.valueOf(i2))) {
                i = i2;
            }
        }
        if (i != -1) {
            urVar.a = i;
        }
        Size size = fjVar.a;
        Iterator it2 = m83Var.a.iterator();
        while (it2.hasNext()) {
            kh2 kh2VarC = gh2.d(((o53) it2.next()).f, size).c();
            lw lwVar = kh2VarC.g;
            urVar.a(lwVar.e);
            List<es> list2 = kh2VarC.e;
            ArrayList arrayList = gh2VarD.e;
            for (es esVar : list2) {
                urVar.b(esVar);
                if (!arrayList.contains(esVar)) {
                    arrayList.add(esVar);
                }
            }
            for (CameraCaptureSession.StateCallback stateCallback : kh2VarC.d) {
                ArrayList arrayList2 = gh2VarD.d;
                if (!arrayList2.contains(stateCallback)) {
                    arrayList2.add(stateCallback);
                }
            }
            for (CameraDevice.StateCallback stateCallback2 : kh2VarC.c) {
                ArrayList arrayList3 = gh2VarD.c;
                if (!arrayList3.contains(stateCallback2)) {
                    arrayList3.add(stateCallback2);
                }
            }
            urVar.c(lwVar.b);
        }
        st2Var.getClass();
        vc4.b();
        st2Var.a();
        hh1.e("Consumer can only be linked once.", !st2Var.j);
        st2Var.j = true;
        gh2VarD.b(st2Var.l, fjVar.b, -1);
        urVar.b(m83Var.k);
        s30 s30Var = fjVar.d;
        if (s30Var != null) {
            urVar.c(s30Var);
        }
        return gh2VarD;
    }

    @Override // defpackage.o53
    public final r53 e(boolean z, u53 u53Var) {
        zr2 zr2Var = this.o;
        s30 s30VarA = u53Var.a(zr2Var.j(), 1);
        if (z) {
            s30VarA = s30.t(s30VarA, zr2Var.a);
        }
        if (s30VarA == null) {
            return null;
        }
        return ((pv) j(s30VarA)).b();
    }

    @Override // defpackage.o53
    public final HashSet i() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    @Override // defpackage.o53
    public final q53 j(s30 s30Var) {
        return new pv(zl1.o(s30Var));
    }

    @Override // defpackage.o53
    public final void p() {
        m83 m83Var = this.p;
        for (o53 o53Var : m83Var.a) {
            l83 l83Var = (l83) m83Var.c.get(o53Var);
            Objects.requireNonNull(l83Var);
            o53Var.a(l83Var, null, null, o53Var.e(true, m83Var.f));
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x019a  */
    @Override // defpackage.o53
    public final r53 r(ut utVar, q53 q53Var) {
        Object objF;
        ig0 ig0Var;
        List arrayList;
        l62 l62Var;
        zl1 zl1VarA = q53Var.a();
        m83 m83Var = this.p;
        HashSet hashSet = m83Var.n;
        m62 m62Var = m83Var.t;
        ut utVar2 = m62Var.f;
        List listJ = utVar2.j(34);
        HashSet<r53> hashSet2 = m62Var.d;
        for (r53 r53Var : hashSet2) {
            if (!((Boolean) r53Var.d(r53.V, Boolean.FALSE)).booleanValue() && (r53Var instanceof xy0) && (l62Var = (l62) ((xy0) r53Var).d(xy0.I, null)) != null && l62Var.c == 1) {
                ArrayList arrayList2 = new ArrayList(listJ);
                arrayList2.addAll(utVar2.e(34));
                listJ = arrayList2;
                break;
            }
        }
        bi biVar = xy0.G;
        zl1VarA.getClass();
        try {
            objF = zl1VarA.f(biVar);
        } catch (IllegalArgumentException unused) {
            objF = null;
        }
        List list = (List) objF;
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    arrayList = new ArrayList();
                    break;
                }
                Pair pair = (Pair) it.next();
                if (((Integer) pair.first).equals(34)) {
                    arrayList = Arrays.asList((Size[]) pair.second);
                    break;
                }
            }
            listJ = arrayList;
        }
        Rational rational = m62Var.c;
        ArrayList arrayList3 = new ArrayList();
        HashSet hashSet3 = new HashSet();
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet3.addAll(m62Var.b((r53) it2.next()));
        }
        Iterator it3 = hashSet3.iterator();
        while (it3.hasNext()) {
            if (!ug.a(rational, (Size) it3.next())) {
                arrayList3.addAll(m62Var.f(m62Var.b, listJ, false));
                break;
            }
        }
        arrayList3.addAll(m62Var.f(rational, listJ, false));
        arrayList3.addAll(m62Var.e(listJ, false));
        if (arrayList3.isEmpty()) {
            xq4.d("ResolutionsMerger", "Failed to find a parent resolution that does not result in double-cropping, this might due to camera not supporting 4:3 and 16:9resolutions or a strict ResolutionSelector settings. Starting resolution selection process with resolutions that might have a smaller FOV.");
            arrayList3.addAll(m62Var.e(listJ, true));
        }
        arrayList3.toString();
        xq4.c(3, "ResolutionsMerger");
        zl1VarA.v(xy0.J, arrayList3);
        bi biVar2 = r53.S;
        Iterator it4 = hashSet.iterator();
        int iMax = 0;
        while (it4.hasNext()) {
            iMax = Math.max(iMax, ((Integer) ((r53) it4.next()).d(r53.S, 0)).intValue());
        }
        zl1VarA.v(biVar2, Integer.valueOf(iMax));
        ArrayList arrayList4 = new ArrayList();
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            ig0 ig0Var2 = (ig0) ((r53) it5.next()).d(wy0.y, ig0.c);
            ig0Var2.getClass();
            arrayList4.add(ig0Var2);
        }
        if (arrayList4.isEmpty()) {
            ig0Var = null;
            break;
        }
        ig0 ig0Var3 = (ig0) arrayList4.get(0);
        Integer numValueOf = Integer.valueOf(ig0Var3.a);
        Integer numValueOf2 = Integer.valueOf(ig0Var3.b);
        int i = 1;
        while (true) {
            if (i >= arrayList4.size()) {
                ig0Var = new ig0(numValueOf.intValue(), numValueOf2.intValue());
                break;
            }
            ig0 ig0Var4 = (ig0) arrayList4.get(i);
            Integer numValueOf3 = Integer.valueOf(ig0Var4.a);
            if (numValueOf.equals(0)) {
                numValueOf = numValueOf3;
            } else if (!numValueOf3.equals(0)) {
                if (numValueOf.equals(2) && !numValueOf3.equals(1)) {
                    numValueOf = numValueOf3;
                } else if ((!numValueOf3.equals(2) || numValueOf.equals(1)) && !numValueOf.equals(numValueOf3)) {
                    numValueOf = null;
                }
            }
            Integer numValueOf4 = Integer.valueOf(ig0Var4.b);
            if (numValueOf2.equals(0)) {
                numValueOf2 = numValueOf4;
            } else if (!numValueOf4.equals(0) && !numValueOf2.equals(numValueOf4)) {
                numValueOf2 = null;
            }
            if (numValueOf == null || numValueOf2 == null) {
                ig0Var = null;
                break;
            }
            i++;
        }
        if (ig0Var == null) {
            og.i("Failed to merge child dynamic ranges, can not find a dynamic range that satisfies all children.");
            return null;
        }
        zl1VarA.v(wy0.y, ig0Var);
        for (o53 o53Var : m83Var.a) {
            r53 r53Var2 = o53Var.f;
            bi biVar3 = r53.b0;
            if (((Integer) r53Var2.d(biVar3, 0)).intValue() != 0) {
                Integer num = (Integer) o53Var.f.d(biVar3, 0);
                num.intValue();
                zl1VarA.v(biVar3, num);
            }
            if (o53Var.f.q() != 0) {
                zl1VarA.v(r53.a0, Integer.valueOf(o53Var.f.q()));
            }
        }
        return q53Var.b();
    }

    @Override // defpackage.o53
    public final void s() {
        for (o53 o53Var : this.p.a) {
            o53Var.s();
            o53Var.q();
        }
    }

    @Override // defpackage.o53
    public final void t() {
        Iterator it = this.p.a.iterator();
        while (it.hasNext()) {
            ((o53) it.next()).t();
        }
    }

    @Override // defpackage.o53
    public final fj u(s30 s30Var) {
        this.y.a(s30Var);
        Object[] objArr = {this.y.c()};
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
        z(B(d(), h() == null ? null : h().i().c(), this.f, fjVar, fjVar2));
        m();
        return fjVar;
    }

    @Override // defpackage.o53
    public final void w() {
        A();
        m83 m83Var = this.p;
        for (o53 o53Var : m83Var.a) {
            l83 l83Var = (l83) m83Var.c.get(o53Var);
            Objects.requireNonNull(l83Var);
            o53Var.y(l83Var);
        }
    }
}
