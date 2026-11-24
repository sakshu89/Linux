package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ju {
    public static final ju b;
    public static final ju c;
    public final LinkedHashSet a;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new xa1(0));
        b = new ju(linkedHashSet);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(new xa1(1));
        c = new ju(linkedHashSet2);
    }

    public ju(LinkedHashSet linkedHashSet) {
        this.a = linkedHashSet;
    }

    public final ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        for (xa1 xa1Var : this.a) {
            List<ut> listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            xa1Var.getClass();
            ArrayList arrayList3 = new ArrayList();
            for (ut utVar : listUnmodifiableList) {
                hh1.a("The camera info doesn't contain internal implementation.", utVar instanceof ut);
                if (utVar.b() == xa1Var.a) {
                    arrayList3.add(utVar);
                }
            }
            arrayList2 = arrayList3;
        }
        arrayList2.retainAll(arrayList);
        return arrayList2;
    }

    public final Integer b() {
        Integer num = null;
        for (xa1 xa1Var : this.a) {
            if (xa1Var instanceof xa1) {
                Integer numValueOf = Integer.valueOf(xa1Var.a);
                if (num == null) {
                    num = numValueOf;
                } else if (!num.equals(numValueOf)) {
                    og.n("Multiple conflicting lens facing requirements exist.");
                    return null;
                }
            }
        }
        return num;
    }

    public final wt c(LinkedHashSet linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((wt) it.next()).i());
        }
        ArrayList arrayListA = a(arrayList);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            wt wtVar = (wt) it2.next();
            if (arrayListA.contains(wtVar.i())) {
                linkedHashSet2.add(wtVar);
            }
        }
        Iterator it3 = linkedHashSet2.iterator();
        if (it3.hasNext()) {
            return (wt) it3.next();
        }
        og.i("No available camera can be found");
        return null;
    }
}
