package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kb0 implements ls {
    public long a;
    public final Object b;
    public final Object c;

    public kb0() {
        this.b = new z63();
        this.c = new z63();
    }

    @Override // defpackage.ls
    public iv2 b() {
        return (iv2) this.c;
    }

    public void c(long j, long j2) {
        ((z63) this.b).a(Float.intBitsToFloat((int) (j2 >> 32)), j);
        ((z63) this.c).a(Float.intBitsToFloat((int) (j2 & 4294967295L)), j);
    }

    @Override // defpackage.ls
    public long d() {
        ls lsVar = (ls) this.b;
        if (lsVar != null) {
            return lsVar.d();
        }
        long j = this.a;
        if (j != -1) {
            return j;
        }
        og.n("No timestamp is available.");
        return 0L;
    }

    @Override // defpackage.ls
    public hs j() {
        ls lsVar = (ls) this.b;
        return lsVar != null ? lsVar.j() : hs.a;
    }

    @Override // defpackage.ls
    public js k() {
        ls lsVar = (ls) this.b;
        return lsVar != null ? lsVar.k() : js.a;
    }

    @Override // defpackage.ls
    public int m() {
        ls lsVar = (ls) this.b;
        if (lsVar != null) {
            return lsVar.m();
        }
        return 1;
    }

    @Override // defpackage.ls
    public is o() {
        ls lsVar = (ls) this.b;
        return lsVar != null ? lsVar.o() : is.a;
    }

    public kb0(ls lsVar, iv2 iv2Var, long j) {
        this.b = lsVar;
        this.c = iv2Var;
        this.a = j;
    }
}
