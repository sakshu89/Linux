package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class th2 implements fh0 {
    public final int a;
    public final int b;

    public th2(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // defpackage.fh0
    public final void a(gh0 gh0Var) {
        boolean z = gh0Var.d != -1;
        ye yeVar = gh0Var.a;
        if (z) {
            gh0Var.d = -1;
            gh0Var.e = -1;
        }
        int iC = ky3.c(this.a, 0, yeVar.c());
        int iC2 = ky3.c(this.b, 0, yeVar.c());
        if (iC != iC2) {
            if (iC < iC2) {
                gh0Var.e(iC, iC2);
            } else {
                gh0Var.e(iC2, iC);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof th2)) {
            return false;
        }
        th2 th2Var = (th2) obj;
        return this.a == th2Var.a && this.b == th2Var.b;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SetComposingRegionCommand(start=");
        sb.append(this.a);
        sb.append(", end=");
        return ky0.m(sb, this.b, ')');
    }
}
