package defpackage;

import com.ibm.icu.impl.locale.LanguageTag;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ul3 {
    public final int a;
    public final int b;

    public ul3(int i, int i2) {
        if (i >= 32767 || i < 0) {
            dk0.v();
            throw null;
        }
        if (i2 >= 32767 || i2 < 0) {
            dk0.v();
            throw null;
        }
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ul3) {
            ul3 ul3Var = (ul3) obj;
            if (this.a == ul3Var.a && this.b == ul3Var.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b | (this.a << 16);
    }

    public final String toString() {
        return this.a + LanguageTag.PRIVATEUSE + this.b;
    }
}
