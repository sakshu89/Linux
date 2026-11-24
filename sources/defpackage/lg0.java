package defpackage;

import android.hardware.camera2.params.DynamicRangeProfiles;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lg0 implements kg0 {
    public final DynamicRangeProfiles a;

    public lg0(Object obj) {
        this.a = (DynamicRangeProfiles) obj;
    }

    public static Set c(Set set) {
        if (set.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            long jLongValue = l.longValue();
            ig0 ig0Var = (ig0) jg0.a.get(l);
            hh1.d(ig0Var, "Dynamic range profile cannot be converted to a DynamicRange object: " + jLongValue);
            hashSet.add(ig0Var);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // defpackage.kg0
    public final Set a(ig0 ig0Var) {
        Long lA = jg0.a(ig0Var, this.a);
        hh1.a("DynamicRange is not supported: " + ig0Var, lA != null);
        return c(this.a.getProfileCaptureRequestConstraints(lA.longValue()));
    }

    @Override // defpackage.kg0
    public final Set b() {
        return c(this.a.getSupportedProfiles());
    }

    @Override // defpackage.kg0
    public final DynamicRangeProfiles unwrap() {
        return this.a;
    }
}
