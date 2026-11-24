package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class se {
    public final int a;
    public final l11 b;
    public final ie c;
    public final String d;

    public se(l11 l11Var, ie ieVar, String str) {
        this.b = l11Var;
        this.c = ieVar;
        this.d = str;
        this.a = Arrays.hashCode(new Object[]{l11Var, ieVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof se)) {
            return false;
        }
        se seVar = (se) obj;
        return sr4.a(this.b, seVar.b) && sr4.a(this.c, seVar.c) && sr4.a(this.d, seVar.d);
    }

    public final int hashCode() {
        return this.a;
    }
}
