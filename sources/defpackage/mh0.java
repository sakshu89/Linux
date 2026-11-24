package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mh0 implements Runnable {
    public final /* synthetic */ int a = 0;
    public final int b;
    public final Object c;

    public mh0(List list, int i, Throwable th) {
        hh1.d(list, "initCallbacks cannot be null");
        this.c = new ArrayList(list);
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        int i2 = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i3 = 0;
                if (i2 == 1) {
                    while (i3 < size) {
                        ((lh0) arrayList.get(i3)).b();
                        i3++;
                    }
                } else {
                    while (i3 < size) {
                        ((lh0) arrayList.get(i3)).a();
                        i3++;
                    }
                }
                break;
            default:
                ((wd3) obj).i(i2);
                break;
        }
    }

    public mh0(wd3 wd3Var, int i) {
        this.c = wd3Var;
        this.b = i;
    }
}
