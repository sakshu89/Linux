package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j42 implements la2 {
    public final LinkedHashSet a = new LinkedHashSet();

    public j42(q91 q91Var) {
        q91Var.F("androidx.savedstate.Restarter", this);
    }

    @Override // defpackage.la2
    public final Bundle a() {
        Bundle bundleA = bg4.a((wt1[]) Arrays.copyOf(new wt1[0], 0));
        List listO = mz.O(this.a);
        bundleA.putStringArrayList("classes_to_restore", listO instanceof ArrayList ? (ArrayList) listO : new ArrayList<>(listO));
        return bundleA;
    }
}
