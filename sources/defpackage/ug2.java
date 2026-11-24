package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ug2 extends af2 {
    public final /* synthetic */ AtomicReferenceArray j;

    public ug2(long j, ug2 ug2Var, int i) {
        super(j, ug2Var, i);
        this.j = new AtomicReferenceArray(tg2.f);
    }

    @Override // defpackage.af2
    public final int l() {
        return tg2.f;
    }

    @Override // defpackage.af2
    public final void m(int i, j70 j70Var) {
        this.j.set(i, tg2.e);
        n();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f + ", hashCode=" + hashCode() + ']';
    }
}
