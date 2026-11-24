package defpackage;

import android.hardware.camera2.params.InputConfiguration;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kh2 {
    public static final List i = Arrays.asList(1, 5, 3);
    public final ArrayList a;
    public final dj b;
    public final List c;
    public final List d;
    public final List e;
    public final ih2 f;
    public final lw g;
    public final InputConfiguration h;

    public kh2(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, lw lwVar, ih2 ih2Var, InputConfiguration inputConfiguration, dj djVar) {
        this.a = arrayList;
        this.c = Collections.unmodifiableList(arrayList2);
        this.d = Collections.unmodifiableList(arrayList3);
        this.e = Collections.unmodifiableList(arrayList4);
        this.f = ih2Var;
        this.g = lwVar;
        this.h = inputConfiguration;
        this.b = djVar;
    }

    public static kh2 a() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(0);
        ArrayList arrayList3 = new ArrayList(0);
        ArrayList arrayList4 = new ArrayList(0);
        HashSet hashSet = new HashSet();
        zl1 zl1VarM = zl1.m();
        ArrayList arrayList5 = new ArrayList();
        om1 om1VarA = om1.a();
        ArrayList arrayList6 = new ArrayList(hashSet);
        gs1 gs1VarL = gs1.l(zl1VarM);
        ArrayList arrayList7 = new ArrayList(arrayList5);
        iv2 iv2Var = iv2.b;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = om1VarA.a;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        return new kh2(arrayList, arrayList2, arrayList3, arrayList4, new lw(arrayList6, gs1VarL, -1, false, arrayList7, false, new iv2(arrayMap), null), null, null, null);
    }

    public final List b() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.a;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            dj djVar = (dj) obj;
            arrayList.add(djVar.a);
            Iterator it = djVar.b.iterator();
            while (it.hasNext()) {
                arrayList.add((ob0) it.next());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
