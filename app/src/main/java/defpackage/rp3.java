package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rp3 implements Iterator {
    public String a;
    public final CharSequence c;
    public int b = 2;
    public int e = 0;
    public int f = Integer.MAX_VALUE;

    public rp3(y74 y74Var, CharSequence charSequence) {
        this.c = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2 = this.b;
        if (i2 == 4) {
            throw new IllegalStateException();
        }
        int i3 = i2 - 1;
        String string = null;
        if (i2 == 0) {
            throw null;
        }
        if (i3 == 0) {
            return true;
        }
        if (i3 != 2) {
            this.b = 4;
            int i4 = this.e;
            while (true) {
                int length = this.e;
                if (length == -1) {
                    this.b = 3;
                    break;
                }
                CharSequence charSequence = this.c;
                int length2 = charSequence.length() - 4;
                while (true) {
                    if (length > length2) {
                        length = -1;
                        break;
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= 4) {
                            break;
                        }
                        if (charSequence.charAt(i5 + length) != "#vk ".charAt(i5)) {
                            break;
                        }
                        i5++;
                    }
                    length++;
                }
                if (length == -1) {
                    length = charSequence.length();
                    this.e = -1;
                    i = -1;
                } else {
                    i = length + 4;
                    this.e = i;
                }
                if (i != i4) {
                    if (i4 < length) {
                        charSequence.charAt(i4);
                    }
                    if (i4 < length) {
                        charSequence.charAt(length - 1);
                    }
                    int i6 = this.f;
                    if (i6 == 1) {
                        length = charSequence.length();
                        this.e = -1;
                        if (length > i4) {
                            charSequence.charAt(length - 1);
                        }
                    } else {
                        this.f = i6 - 1;
                    }
                    string = charSequence.subSequence(i4, length).toString();
                    break;
                }
                int i7 = i + 1;
                this.e = i7;
                if (i7 > charSequence.length()) {
                    this.e = -1;
                }
            }
            this.a = string;
            if (this.b != 3) {
                this.b = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            dk0.d();
            return null;
        }
        this.b = 2;
        String str = this.a;
        this.a = null;
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
