package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c5 implements e5 {
    public final f5 a;
    public final String b;

    public c5(f5 f5Var, String str) {
        this.a = f5Var;
        this.b = str;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0021  */
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this != obj) {
            if (obj instanceof c5) {
                c5 c5Var = (c5) obj;
                if (this.a.equals(c5Var.a)) {
                    String str = c5Var.b;
                    String str2 = this.b;
                    if (str2 == null) {
                        if (str == null) {
                            zEquals = true;
                        } else {
                            zEquals = false;
                        }
                    } else if (str == null) {
                        zEquals = false;
                    } else {
                        zEquals = str2.equals(str);
                    }
                    if (!zEquals) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        String str = this.b;
        if (str == null) {
            str = "null";
        }
        return "Understood(intent=" + this.a + ", skillId=" + str + ")";
    }
}
