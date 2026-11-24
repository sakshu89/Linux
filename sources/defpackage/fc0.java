package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fc0 implements fh0 {
    public final int a;
    public final int b;

    public fc0(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (i >= 0 && i2 >= 0) {
            return;
        }
        a11.a("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
    }

    @Override // defpackage.fh0
    public final void a(gh0 gh0Var) {
        int i = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = i + 1;
            int i4 = gh0Var.b;
            if (i4 <= i3) {
                i = i4;
                break;
            }
            i = (Character.isHighSurrogate(gh0Var.b((i4 - i3) + (-1))) && Character.isLowSurrogate(gh0Var.b(gh0Var.b - i3))) ? i + 2 : i3;
        }
        int iC = 0;
        for (int i5 = 0; i5 < this.b; i5++) {
            int i6 = iC + 1;
            int i7 = gh0Var.c;
            ye yeVar = gh0Var.a;
            if (i7 + i6 >= yeVar.c()) {
                iC = yeVar.c() - gh0Var.c;
                break;
            }
            iC = (Character.isHighSurrogate(gh0Var.b((gh0Var.c + i6) + (-1))) && Character.isLowSurrogate(gh0Var.b(gh0Var.c + i6))) ? iC + 2 : i6;
        }
        int i8 = gh0Var.c;
        gh0Var.a(i8, iC + i8);
        int i9 = gh0Var.b;
        gh0Var.a(i9 - i, i9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fc0)) {
            return false;
        }
        fc0 fc0Var = (fc0) obj;
        return this.a == fc0Var.a && this.b == fc0Var.b;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=");
        sb.append(this.a);
        sb.append(", lengthAfterCursor=");
        return ky0.m(sb, this.b, ')');
    }
}
