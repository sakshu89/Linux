package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nq2 implements AutoCloseable {
    public final jq2 a;
    public final ArrayList b;
    public final IdentityHashMap c;
    public final ro1 e;

    public nq2(jq2 jq2Var, ArrayList arrayList, IdentityHashMap identityHashMap, ro1 ro1Var) {
        this.a = jq2Var;
        this.b = arrayList;
        this.c = identityHashMap;
        this.e = ro1Var;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((AccessibilityNodeInfo) obj).recycle();
        }
    }
}
