package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r00 implements fh0 {
    public final be a;
    public final int b;

    public r00(String str, int i) {
        this(new be(str), i);
    }

    @Override // defpackage.fh0
    public final void a(gh0 gh0Var) {
        int i = gh0Var.d;
        be beVar = this.a;
        if (i != -1) {
            gh0Var.d(i, gh0Var.e, beVar.b);
        } else {
            gh0Var.d(gh0Var.b, gh0Var.c, beVar.b);
        }
        int i2 = gh0Var.b;
        int i3 = gh0Var.c;
        int i4 = i2 == i3 ? i3 : -1;
        int i5 = this.b;
        int iC = ky3.c(i5 > 0 ? (i4 + i5) - 1 : (i4 + i5) - beVar.b.length(), 0, gh0Var.a.c());
        gh0Var.f(iC, iC);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r00)) {
            return false;
        }
        r00 r00Var = (r00) obj;
        return g31.a(this.a.b, r00Var.a.b) && this.b == r00Var.b;
    }

    public final int hashCode() {
        return (this.a.b.hashCode() * 31) + this.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CommitTextCommand(text='");
        sb.append(this.a.b);
        sb.append("', newCursorPosition=");
        return ky0.m(sb, this.b, ')');
    }

    public r00(be beVar, int i) {
        this.a = beVar;
        this.b = i;
    }
}
