package defpackage;

import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hy {
    public final ReferenceQueue a = new ReferenceQueue();
    public final Set b = Collections.synchronizedSet(new HashSet());
}
