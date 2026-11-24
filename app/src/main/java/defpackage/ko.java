package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ko implements Iterator {
    public final /* synthetic */ int a = 0;
    public int b = 0;
    public final int c;
    public final /* synthetic */ Object e;

    public ko(rt3 rt3Var) {
        this.e = rt3Var;
        this.c = rt3Var.d();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                return this.b < this.c;
            default:
                return this.b < this.c;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.a;
        Object obj = this.e;
        int i2 = this.c;
        switch (i) {
            case 0:
                int i3 = this.b;
                if (i3 < i2) {
                    this.b = i3 + 1;
                    return Byte.valueOf(((no) obj).h(i3));
                }
                dk0.d();
                return null;
            default:
                int i4 = this.b;
                if (i4 < i2) {
                    this.b = i4 + 1;
                    return Byte.valueOf(((rt3) obj).b(i4));
                }
                dk0.d();
                return null;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public ko(no noVar) {
        this.e = noVar;
        this.c = noVar.size();
    }
}
