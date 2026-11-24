package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i72 implements Serializable {
    public final Object a;

    public static final Throwable a(Object obj) {
        if (obj instanceof h72) {
            return ((h72) obj).a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i72) {
            return g31.a(this.a, ((i72) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.a;
        if (obj instanceof h72) {
            return ((h72) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
