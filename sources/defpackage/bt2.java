package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bt2 extends hk2 implements hr2 {
    @Override // defpackage.hr2
    public final Object getValue() {
        Integer numValueOf;
        synchronized (this) {
            Object[] objArr = this.k;
            objArr.getClass();
            numValueOf = Integer.valueOf(((Number) objArr[((int) ((this.n + ((long) ((int) ((o() + ((long) this.t)) - this.n)))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return numValueOf;
    }

    public final void w(int i) {
        synchronized (this) {
            Object[] objArr = this.k;
            objArr.getClass();
            q(Integer.valueOf(((Number) objArr[((int) ((this.n + ((long) ((int) ((o() + ((long) this.t)) - this.n)))) - 1)) & (objArr.length - 1)]).intValue() + i));
        }
    }
}
