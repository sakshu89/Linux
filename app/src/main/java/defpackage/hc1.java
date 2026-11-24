package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hc1 implements Iterator, x41 {
    public final String a;
    public int b;
    public int c;
    public int e;
    public int f;

    public hc1(String str) {
        this.a = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2;
        int i3 = this.b;
        if (i3 != 0) {
            return i3 == 1;
        }
        if (this.f < 0) {
            this.b = 2;
            return false;
        }
        String str = this.a;
        int length = str.length();
        int length2 = str.length();
        for (int i4 = this.c; i4 < length2; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i2 = i4 + 1) < str.length() && str.charAt(i2) == '\n') ? 2 : 1;
                length = i4;
                this.b = 1;
                this.f = i;
                this.e = length;
                return true;
            }
        }
        i = -1;
        this.b = 1;
        this.f = i;
        this.e = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            dk0.d();
            return null;
        }
        this.b = 0;
        int i = this.e;
        int i2 = this.c;
        this.c = this.f + i;
        return this.a.subSequence(i2, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
