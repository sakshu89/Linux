package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e82 {
    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof e82);
    }

    public final int hashCode() {
        return Float.hashCode(0.1f) + cq.b(cq.b(Float.hashCode(0.16f) * 31, 0.1f, 31), 0.08f, 31);
    }

    public final String toString() {
        return "RippleAlpha(draggedAlpha=0.16, focusedAlpha=0.1, hoveredAlpha=0.08, pressedAlpha=0.1)";
    }
}
