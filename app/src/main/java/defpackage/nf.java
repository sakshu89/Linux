package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nf implements bl2 {
    public final ue a;
    public final r2 b;
    public final j5 c;
    public String d;
    public final Set e;
    public final l82 f;

    public nf(ue ueVar, r2 r2Var, j5 j5Var) {
        ueVar.getClass();
        r2Var.getClass();
        j5Var.getClass();
        this.a = ueVar;
        this.b = r2Var;
        this.c = j5Var;
        this.e = wh2.c(new w3("app.open"), new w3("app.list"));
        this.f = l82.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [ii0] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.util.ArrayList] */
    public static final rf n(nf nfVar, String str) {
        Object next;
        int i;
        Object arrayList;
        ue ueVar = nfVar.a;
        Iterator it = ueVar.b().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((x11) next).a.equals(str));
        x11 x11Var = (x11) next;
        if (x11Var != null) {
            return new qf(x11Var, "you picked it");
        }
        ueVar.getClass();
        Set set = ue.f;
        String strS = qs4.s(str);
        if (strS.length() == 0) {
            return new pf(str);
        }
        List<x11> listB = ueVar.b();
        if (listB.isEmpty()) {
            return new pf(str);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listB) {
            if (g31.a(((x11) obj).c, strS)) {
                arrayList2.add(obj);
            }
        }
        x11 x11Var2 = (x11) mz.I(arrayList2);
        if (x11Var2 != null) {
            return new qf(x11Var2, "exact name");
        }
        if (arrayList2.size() > 1) {
            return new of(str, arrayList2);
        }
        List list = (List) ue.g.get(strS);
        if (list != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listB) {
                if (list.contains(((x11) obj2).a)) {
                    arrayList3.add(obj2);
                }
            }
            rf rfVarC = ue.c(str, "known nickname", arrayList3);
            if (rfVarC != null) {
                return rfVarC;
            }
        }
        rf rfVarA = ue.a(str, listB, true);
        if (rfVarA != null) {
            return rfVarA;
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = listB.iterator();
        while (true) {
            i = 0;
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            List listN = cs2.N(((x11) next2).c, new char[]{' '}, 6);
            ArrayList arrayList5 = new ArrayList();
            for (Object obj3 : listN) {
                if (((String) obj3).length() > 0) {
                    arrayList5.add(obj3);
                }
            }
            if (arrayList5.contains(strS)) {
                arrayList4.add(next2);
            }
        }
        x11 x11Var3 = (x11) mz.I(arrayList4);
        if (x11Var3 != null) {
            return new qf(x11Var3, "name contains word");
        }
        if (arrayList4.size() > 1) {
            return new of(str, mz.L(arrayList4, 5));
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj4 : listB) {
            if (js2.k(((x11) obj4).c, strS, false)) {
                arrayList6.add(obj4);
            }
        }
        if (arrayList6.size() == 1) {
            return new qf((x11) mz.x(arrayList6), "name prefix");
        }
        if (strS.length() >= 4) {
            arrayList = new ArrayList();
            for (Object obj5 : listB) {
                if (cs2.n(((x11) obj5).c, strS, false)) {
                    arrayList.add(obj5);
                }
            }
        } else {
            arrayList = ii0.a;
        }
        if (arrayList.size() == 1) {
            return new qf((x11) mz.x(arrayList), "name contains");
        }
        int i2 = strS.length() <= 4 ? 0 : strS.length() <= 7 ? 1 : 2;
        if (i2 > 0) {
            ArrayList arrayList7 = new ArrayList(nz.d(listB));
            for (x11 x11Var4 : listB) {
                arrayList7.add(new wt1(x11Var4, Integer.valueOf(qs4.n(strS, i2, x11Var4.c))));
            }
            ArrayList arrayList8 = new ArrayList();
            int size = arrayList7.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj6 = arrayList7.get(i3);
                i3++;
                if (((Number) ((wt1) obj6).b).intValue() <= i2) {
                    arrayList8.add(obj6);
                }
            }
            List listK = mz.K(arrayList8, new lo0(11));
            wt1 wt1Var = (wt1) mz.y(listK);
            if (wt1Var != null) {
                ArrayList arrayList9 = new ArrayList();
                for (Object obj7 : listK) {
                    if (((Number) ((wt1) obj7).b).intValue() == ((Number) wt1Var.b).intValue()) {
                        arrayList9.add(obj7);
                    }
                }
                ArrayList arrayList10 = new ArrayList(nz.d(arrayList9));
                int size2 = arrayList9.size();
                while (i < size2) {
                    Object obj8 = arrayList9.get(i);
                    i++;
                    arrayList10.add((x11) ((wt1) obj8).a);
                }
                return arrayList10.size() == 1 ? new qf((x11) mz.x(arrayList10), "close spelling") : new of(str, mz.L(arrayList10, 5));
            }
        }
        rf rfVarA2 = ue.a(str, listB, false);
        if (rfVarA2 != null) {
            return rfVarA2;
        }
        List listT = mz.t(mz.G(arrayList6, arrayList));
        return !listT.isEmpty() ? new of(str, mz.L(listT, 5)) : new pf(str);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0081  */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    /* JADX WARN: Code duplicated, block: B:39:0x008f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0097  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) throws Throwable {
        lf lfVar;
        String str;
        String str2;
        String str3;
        if (x50Var instanceof lf) {
            lfVar = (lf) x50Var;
            int i = lfVar.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                lfVar.j = i - Integer.MIN_VALUE;
            } else {
                lfVar = new lf(this, (y50) x50Var);
            }
        } else {
            lfVar = new lf(this, (y50) x50Var);
        }
        Object objC = lfVar.f;
        int i2 = lfVar.j;
        x50 x50Var2 = null;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objC);
            if (g31.a(f5Var.a, "app.open") && this.b.j()) {
                lfVar.j = 1;
                objC = rn4.c(this.c.b, lfVar);
                if (objC != t70Var) {
                }
                return t70Var;
            }
            return null;
        }
        if (i2 == 1) {
            bz3.g(objC);
        } else {
            if (i2 != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str2 = lfVar.e;
            bz3.g(objC);
        }
        str3 = (String) objC;
        if (str3 == null) {
            return new c73("No app window is available");
        }
        return str3.equals(str2) ? new d73("foreground app package", str2) : new c73("Requested app is not visible yet");
        if (((g5) objC).i && (str = this.d) != null) {
            xa0 xa0Var = ld0.a;
            qa0 qa0Var = qa0.c;
            mf mfVar = new mf(this, x50Var2, 0);
            lfVar.e = str;
            lfVar.j = 2;
            objC = uf4.d(qa0Var, mfVar, lfVar);
            if (objC != t70Var) {
                str2 = str;
                str3 = (String) objC;
                if (str3 == null) {
                    return new c73("No app window is available");
                }
                if (str3.equals(str2)) {
                }
            }
            return t70Var;
        }
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.e;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "app.launch";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Opens an app by name, and tells you what's installed.";
    }

    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) {
        xa0 xa0Var = ld0.a;
        return uf4.d(qa0.c, new y(this, f5Var, null, 5), x50Var);
    }

    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        return a32.a;
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final List k() {
        return ii0.a;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.f;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "App launcher";
    }

    @Override // defpackage.bl2
    public final void f() {
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
