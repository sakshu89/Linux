package defpackage;

import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uw {
    public final lw a;

    public uw() {
        HashSet hashSet = new HashSet();
        zl1 zl1VarM = zl1.m();
        ArrayList arrayList = new ArrayList();
        om1 om1VarA = om1.a();
        ArrayList arrayList2 = new ArrayList(hashSet);
        gs1 gs1VarL = gs1.l(zl1VarM);
        ArrayList arrayList3 = new ArrayList(arrayList);
        iv2 iv2Var = iv2.b;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = om1VarA.a;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        this.a = new lw(arrayList2, gs1VarL, -1, false, arrayList3, false, new iv2(arrayMap), null);
    }
}
