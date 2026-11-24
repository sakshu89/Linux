package defpackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class au0 implements xg2 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ au0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // defpackage.xg2
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new zt0(this);
            case 1:
                xg2 xg2Var = (xg2) this.b;
                ArrayList arrayList = new ArrayList();
                Iterator it = xg2Var.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                qz.p(arrayList, (Comparator) this.c);
                return arrayList.iterator();
            case 2:
                return new ul0(this);
            default:
                return new c23(this);
        }
    }
}
