package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ll2 {
    public final ArrayList a;
    public final List b;
    public final rg1 c;

    public ll2(Set set) {
        set.getClass();
        this.a = new ArrayList();
        List<bl2> listK = mz.K(set, new lo0(29));
        this.b = listK;
        rg1 rg1Var = new rg1();
        for (bl2 bl2Var : listK) {
            Iterator it = bl2Var.b().iterator();
            while (it.hasNext()) {
                String str = ((w3) it.next()).a;
                bl2 bl2Var2 = (bl2) rg1Var.get(new w3(str));
                if (bl2Var2 != null) {
                    this.a.add(new kl2(str, bl2Var2.d(), bl2Var.d()));
                } else {
                    rg1Var.put(new w3(str), bl2Var);
                }
            }
        }
        this.c = rg1Var.b();
        List list = this.b;
        int iB = bh1.b(nz.d(list));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iB < 16 ? 16 : iB);
        for (Object obj : list) {
            linkedHashMap.put(new dl2(((bl2) obj).d()), obj);
        }
    }

    public final bl2 a(String str) {
        str.getClass();
        return (bl2) this.c.get(new w3(str));
    }
}
