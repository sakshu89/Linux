package defpackage;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i22 {
    public final boolean a;
    public final Set b;
    public final Set c;

    public i22(boolean z, HashSet hashSet, HashSet hashSet2) {
        this.a = z;
        this.b = hashSet == null ? Collections.EMPTY_SET : new HashSet(hashSet);
        this.c = hashSet2 == null ? Collections.EMPTY_SET : new HashSet(hashSet2);
    }

    public final boolean a(Class cls, boolean z) {
        if (this.b.contains(cls)) {
            return true;
        }
        return !this.c.contains(cls) && this.a && z;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i22)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        i22 i22Var = (i22) obj;
        return this.a == i22Var.a && Objects.equals(this.b, i22Var.b) && Objects.equals(this.c, i22Var.c);
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.a), this.b, this.c);
    }

    public final String toString() {
        return "QuirkSettings{enabledWhenDeviceHasQuirk=" + this.a + ", forceEnabledQuirks=" + this.b + ", forceDisabledQuirks=" + this.c + '}';
    }
}
