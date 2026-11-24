package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class he0 {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof he0) && de0.b(10.0f, 10.0f) && de0.b(40.0f, 40.0f) && de0.b(10.0f, 10.0f) && de0.b(40.0f, 40.0f);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + cq.b(cq.b(cq.b(Float.hashCode(10.0f) * 31, 40.0f, 31), 10.0f, 31), 40.0f, 31);
    }

    public final String toString() {
        return "DpTouchBoundsExpansion(start=" + ((Object) de0.c(10.0f)) + ", top=" + ((Object) de0.c(40.0f)) + ", end=" + ((Object) de0.c(10.0f)) + ", bottom=" + ((Object) de0.c(40.0f)) + ", isLayoutDirectionAware=true)";
    }
}
