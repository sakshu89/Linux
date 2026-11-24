package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uh2 implements fh0 {
    public final be a;
    public final int b;

    public uh2(String str, int i) {
        this.a = new be(str);
        this.b = i;
    }

    @Override // defpackage.fh0
    public final void a(gh0 gh0Var) {
        int i = gh0Var.d;
        be beVar = this.a;
        if (i != -1) {
            int i2 = gh0Var.e;
            String str = beVar.b;
            String str2 = beVar.b;
            gh0Var.d(i, i2, str);
            if (str2.length() > 0) {
                gh0Var.e(i, str2.length() + i);
            }
        } else {
            int i3 = gh0Var.b;
            int i4 = gh0Var.c;
            String str3 = beVar.b;
            String str4 = beVar.b;
            gh0Var.d(i3, i4, str3);
            if (str4.length() > 0) {
                gh0Var.e(i3, str4.length() + i3);
            }
        }
        int i5 = gh0Var.b;
        int i6 = gh0Var.c;
        int i7 = i5 == i6 ? i6 : -1;
        int i8 = this.b;
        int iC = ky3.c(i8 > 0 ? (i7 + i8) - 1 : (i7 + i8) - beVar.b.length(), 0, gh0Var.a.c());
        gh0Var.f(iC, iC);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uh2)) {
            return false;
        }
        uh2 uh2Var = (uh2) obj;
        return g31.a(this.a.b, uh2Var.a.b) && this.b == uh2Var.b;
    }

    public final int hashCode() {
        return (this.a.b.hashCode() * 31) + this.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SetComposingTextCommand(text='");
        sb.append(this.a.b);
        sb.append("', newCursorPosition=");
        return ky0.m(sb, this.b, ')');
    }
}
