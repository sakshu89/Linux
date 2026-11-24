package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b63 {
    public final String a;
    public final String b;
    public final String c;
    public final List d;

    public b63(String str, String str2, String str3, List list) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
    }

    public final fh1 a(x42 x42Var) {
        x42Var.getClass();
        fh1 fh1VarB = x42.b(x42Var, this.b);
        return fh1VarB == null ? x42.b(x42Var, this.c) : fh1VarB;
    }

    public final boolean b(Collection collection) {
        collection.getClass();
        Collection collection2 = collection;
        if (!collection2.isEmpty()) {
            Iterator it = collection2.iterator();
            while (it.hasNext()) {
                if (js2.k(this.c, (String) it.next(), false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b63)) {
            return false;
        }
        b63 b63Var = (b63) obj;
        return g31.a(this.a, b63Var.a) && g31.a(this.b, b63Var.b) && g31.a(this.c, b63Var.c) && this.d.equals(b63Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ky0.d(ky0.d(this.a.hashCode() * 31, 31, this.b), 31, this.c);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("Utterance(raw=", this.a, ", cleaned=", this.b, ", canonical=");
        sbQ.append(this.c);
        sbQ.append(", tokens=");
        sbQ.append(this.d);
        sbQ.append(")");
        return sbQ.toString();
    }
}
