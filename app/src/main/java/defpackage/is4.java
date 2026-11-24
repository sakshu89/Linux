package defpackage;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class is4 implements hs4 {
    public final ArrayList a;

    public is4(Context context, gs4 gs4Var) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        gs4Var.getClass();
        arrayList.add(new os4(context, gs4Var));
    }

    @Override // defpackage.hs4
    public final void a(t9 t9Var) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((hs4) obj).a(t9Var);
        }
    }
}
