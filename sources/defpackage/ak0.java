package defpackage;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ak0 implements Enumeration {
    public final Enumeration a;

    public ak0(bk0 bk0Var) {
        this.a = Collections.enumeration(bk0Var.a);
    }

    @Override // java.util.Enumeration
    public final boolean hasMoreElements() {
        return this.a.hasMoreElements();
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        return new HashMap((Map) this.a.nextElement());
    }
}
