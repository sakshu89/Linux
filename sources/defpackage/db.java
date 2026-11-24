package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class db extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ ArrayList c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ db(int i, ArrayList arrayList) {
        super(1);
        this.b = i;
        this.c = arrayList;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.b;
        q43 q43Var = q43.a;
        ArrayList arrayList = this.c;
        switch (i) {
            case 0:
                yw1 yw1Var = (yw1) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    int i2 = 0;
                    while (true) {
                        yw1.k(yw1Var, (zw1) arrayList.get(i2), 0, 0);
                        if (i2 != size) {
                            i2++;
                        }
                    }
                }
                break;
            case 1:
                yw1 yw1Var2 = (yw1) obj;
                int size2 = arrayList.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    yw1.h(yw1Var2, (zw1) arrayList.get(i3), 0, 0);
                }
                break;
            default:
                yw1 yw1Var3 = (yw1) obj;
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    yw1.m(yw1Var3, (zw1) arrayList.get(i4), 0, 0);
                }
                break;
        }
        return q43Var;
    }
}
