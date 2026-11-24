package defpackage;

import android.content.Context;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bs implements u53 {
    public final nd0 b;

    public bs(Context context) {
        this.b = nd0.b(context);
    }

    /* JADX WARN: Code duplicated, block: B:5:0x003a  */
    @Override // defpackage.u53
    public final s30 a(t53 t53Var, int i) {
        int i2;
        zl1 zl1VarM = zl1.m();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashSet hashSet = new HashSet();
        zl1 zl1VarM2 = zl1.m();
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = om1.a().a;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int iOrdinal = t53Var.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 3) {
                i2 = 1;
            } else {
                i2 = 3;
            }
        } else if (i == 2) {
            i2 = 5;
        } else {
            i2 = 1;
        }
        bi biVar = r53.O;
        ArrayList arrayList5 = new ArrayList(linkedHashSet);
        ArrayList arrayList6 = new ArrayList(arrayList2);
        ArrayList arrayList7 = new ArrayList(arrayList3);
        ArrayList arrayList8 = new ArrayList(arrayList4);
        ArrayList arrayList9 = new ArrayList(hashSet);
        gs1 gs1VarL = gs1.l(zl1VarM2);
        ArrayList arrayList10 = new ArrayList(arrayList);
        iv2 iv2Var = iv2.b;
        ArrayMap arrayMap2 = new ArrayMap();
        for (String str : arrayMap.keySet()) {
            arrayMap2.put(str, arrayMap.get(str));
        }
        zl1VarM.v(biVar, new kh2(arrayList5, arrayList6, arrayList7, arrayList8, new lw(arrayList9, gs1VarL, i2, false, arrayList10, false, new iv2(arrayMap2), null), null, null, null));
        zl1VarM.v(r53.Q, as.a);
        HashSet hashSet2 = new HashSet();
        zl1 zl1VarM3 = zl1.m();
        ArrayList arrayList11 = new ArrayList();
        ArrayMap arrayMap3 = om1.a().a;
        int iOrdinal2 = t53Var.ordinal();
        int i3 = iOrdinal2 != 0 ? iOrdinal2 != 3 ? 1 : 3 : i == 2 ? 5 : 2;
        bi biVar2 = r53.P;
        ArrayList arrayList12 = new ArrayList(hashSet2);
        gs1 gs1VarL2 = gs1.l(zl1VarM3);
        ArrayList arrayList13 = new ArrayList(arrayList11);
        iv2 iv2Var2 = iv2.b;
        ArrayMap arrayMap4 = new ArrayMap();
        for (String str2 : arrayMap3.keySet()) {
            arrayMap4.put(str2, arrayMap3.get(str2));
        }
        zl1VarM.v(biVar2, new lw(arrayList12, gs1VarL2, i3, false, arrayList13, false, new iv2(arrayMap4), null));
        zl1VarM.v(r53.R, t53Var == t53.a ? uy0.b : er.a);
        t53 t53Var2 = t53.b;
        nd0 nd0Var = this.b;
        if (t53Var == t53Var2) {
            zl1VarM.v(xy0.F, nd0Var.e());
        }
        zl1VarM.v(xy0.A, Integer.valueOf(nd0Var.c(true).getRotation()));
        if (t53Var == t53.e || t53Var == t53.f) {
            zl1VarM.v(r53.U, Boolean.TRUE);
        }
        return gs1.l(zl1VarM);
    }
}
