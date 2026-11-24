package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oh2 {
    public final nh2 a;

    public oh2(ArrayList arrayList, ch2 ch2Var, vs vsVar) {
        if (Build.VERSION.SDK_INT < 28) {
            this.a = new mh2(arrayList, ch2Var, vsVar);
        } else {
            this.a = new lh2(arrayList, ch2Var, vsVar);
        }
    }

    public static ArrayList a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((OutputConfiguration) ((ws1) it.next()).a.a());
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof oh2)) {
            return false;
        }
        return this.a.equals(((oh2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
