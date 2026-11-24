package defpackage;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ia2 implements la2 {
    public final q91 a;
    public boolean b;
    public Bundle c;
    public final cv2 d;

    public ia2(q91 q91Var, h83 h83Var) {
        q91Var.getClass();
        this.a = q91Var;
        this.d = new cv2(new kb(16, h83Var));
    }

    @Override // defpackage.la2
    public final Bundle a() {
        Bundle bundleA = bg4.a((wt1[]) Arrays.copyOf(new wt1[0], 0));
        Bundle bundle = this.c;
        if (bundle != null) {
            bundleA.putAll(bundle);
        }
        for (Map.Entry entry : ((ja2) this.d.getValue()).b.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA2 = ((i10) ((fa2) entry.getValue()).a.a).a();
            if (!bundleA2.isEmpty()) {
                str.getClass();
                bundleA.putBundle(str, bundleA2);
            }
        }
        this.b = false;
        return bundleA;
    }

    public final void b() {
        if (this.b) {
            return;
        }
        Bundle bundleX = this.a.x("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundleA = bg4.a((wt1[]) Arrays.copyOf(new wt1[0], 0));
        Bundle bundle = this.c;
        if (bundle != null) {
            bundleA.putAll(bundle);
        }
        if (bundleX != null) {
            bundleA.putAll(bundleX);
        }
        this.c = bundleA;
        this.b = true;
    }
}
