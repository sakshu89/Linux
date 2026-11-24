package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fs extends es {
    public final ArrayList a = new ArrayList();

    public fs(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            es esVar = (es) it.next();
            if (!(esVar instanceof gs)) {
                this.a.add(esVar);
            }
        }
    }

    @Override // defpackage.es
    public final void a(int i) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((es) obj).a(i);
        }
    }

    @Override // defpackage.es
    public final void b(int i, ls lsVar) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((es) obj).b(i, lsVar);
        }
    }

    @Override // defpackage.es
    public final void c(int i, el1 el1Var) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((es) obj).c(i, el1Var);
        }
    }

    @Override // defpackage.es
    public final void d(int i) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((es) obj).d(i);
        }
    }
}
