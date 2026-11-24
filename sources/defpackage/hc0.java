package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hc0 implements xg2 {
    public final CharSequence a;
    public final int b;
    public final vq0 c;

    public hc0(CharSequence charSequence, int i, vq0 vq0Var) {
        charSequence.getClass();
        this.a = charSequence;
        this.b = i;
        this.c = vq0Var;
    }

    @Override // defpackage.xg2
    public final Iterator iterator() {
        return new gc0(this);
    }
}
