package defpackage;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hk4 implements dk4 {
    public final ArrayList a;

    public hk4(Context context, ak4 ak4Var) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        ak4Var.getClass();
        arrayList.add(new vk4(context, ak4Var));
    }

    @Override // defpackage.dk4
    public final void a(cu2 cu2Var) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((dk4) obj).a(cu2Var);
        }
    }
}
