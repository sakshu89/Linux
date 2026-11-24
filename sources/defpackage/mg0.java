package defpackage;

import android.hardware.camera2.params.DynamicRangeProfiles;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mg0 implements kg0 {
    public static final q82 a = new q82(new mg0());
    public static final Set b = Collections.singleton(ig0.d);

    @Override // defpackage.kg0
    public final Set a(ig0 ig0Var) {
        hh1.a("DynamicRange is not supported: " + ig0Var, ig0.d.equals(ig0Var));
        return b;
    }

    @Override // defpackage.kg0
    public final Set b() {
        return b;
    }

    @Override // defpackage.kg0
    public final DynamicRangeProfiles unwrap() {
        return null;
    }
}
