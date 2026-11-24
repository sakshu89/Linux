package defpackage;

import com.ibm.icu.text.DateTimePatternGenerator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tt3 {
    public final Object a;
    public final int b;

    public tt3(jt3 jt3Var, int i) {
        this.a = jt3Var;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof tt3)) {
            return false;
        }
        tt3 tt3Var = (tt3) obj;
        return this.a == tt3Var.a && this.b == tt3Var.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.a) * DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH) + this.b;
    }
}
