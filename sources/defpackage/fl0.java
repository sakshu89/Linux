package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fl0 {
    public final String a;
    public final Map b;

    public fl0(String str, Map map) {
        this.a = str;
        this.b = map;
    }

    public static l11 a(String str) {
        return new l11(str, 23);
    }

    public static fl0 b(String str) {
        return new fl0(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fl0)) {
            return false;
        }
        fl0 fl0Var = (fl0) obj;
        return this.a.equals(fl0Var.a) && this.b.equals(fl0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.a + ", properties=" + this.b.values() + "}";
    }
}
