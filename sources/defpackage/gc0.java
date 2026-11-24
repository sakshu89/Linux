package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gc0 implements Iterator, x41 {
    public int a = -1;
    public int b;
    public int c;
    public h21 e;
    public int f;
    public final /* synthetic */ hc0 i;

    public gc0(hc0 hc0Var) {
        this.i = hc0Var;
        int iC = ky3.c(0, 0, hc0Var.a.length());
        this.b = iC;
        this.c = iC;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001c  */
    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    /* JADX WARN: Code duplicated, block: B:13:0x0036  */
    /* JADX WARN: Code duplicated, block: B:15:0x0046  */
    /* JADX WARN: Code duplicated, block: B:16:0x005a  */
    /* JADX WARN: Code duplicated, block: B:18:0x0077  */
    public final void a() {
        wt1 wt1Var;
        hc0 hc0Var = this.i;
        CharSequence charSequence = hc0Var.a;
        int i = this.c;
        if (i < 0) {
            this.a = 0;
            this.e = null;
            return;
        }
        int i2 = hc0Var.b;
        if (i2 > 0) {
            int i3 = this.f + 1;
            this.f = i3;
            if (i3 >= i2) {
                int i4 = this.b;
                charSequence.getClass();
                this.e = new h21(i4, charSequence.length() - 1, 1);
                this.c = -1;
            } else if (i > charSequence.length()) {
                int i5 = this.b;
                charSequence.getClass();
                this.e = new h21(i5, charSequence.length() - 1, 1);
                this.c = -1;
            } else {
                wt1Var = (wt1) hc0Var.c.e(charSequence, Integer.valueOf(this.c));
                if (wt1Var == null) {
                    int i6 = this.b;
                    charSequence.getClass();
                    this.e = new h21(i6, charSequence.length() - 1, 1);
                    this.c = -1;
                } else {
                    int iIntValue = ((Number) wt1Var.a).intValue();
                    int iIntValue2 = ((Number) wt1Var.b).intValue();
                    this.e = ky3.f(this.b, iIntValue);
                    int i7 = iIntValue + iIntValue2;
                    this.b = i7;
                    this.c = i7 + (iIntValue2 == 0 ? 1 : 0);
                }
            }
        } else if (i > charSequence.length()) {
            int i8 = this.b;
            charSequence.getClass();
            this.e = new h21(i8, charSequence.length() - 1, 1);
            this.c = -1;
        } else {
            wt1Var = (wt1) hc0Var.c.e(charSequence, Integer.valueOf(this.c));
            if (wt1Var == null) {
                int i9 = this.b;
                charSequence.getClass();
                this.e = new h21(i9, charSequence.length() - 1, 1);
                this.c = -1;
            } else {
                int iIntValue3 = ((Number) wt1Var.a).intValue();
                int iIntValue4 = ((Number) wt1Var.b).intValue();
                this.e = ky3.f(this.b, iIntValue3);
                int i10 = iIntValue3 + iIntValue4;
                this.b = i10;
                this.c = i10 + (iIntValue4 == 0 ? 1 : 0);
            }
        }
        this.a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a == -1) {
            a();
        }
        return this.a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.a == -1) {
            a();
        }
        if (this.a == 0) {
            dk0.d();
            return null;
        }
        h21 h21Var = this.e;
        h21Var.getClass();
        this.e = null;
        this.a = -1;
        return h21Var;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
