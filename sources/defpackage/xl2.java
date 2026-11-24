package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xl2 {
    public final Set a;
    public final Set b;
    public final Set c;
    public final Set d;

    public xl2(Set set, Set set2, Set set3, Set set4) {
        this.a = set;
        this.b = set2;
        this.c = set3;
        this.d = set4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xl2)) {
            return false;
        }
        xl2 xl2Var = (xl2) obj;
        return this.a.equals(xl2Var.a) && this.b.equals(xl2Var.b) && this.c.equals(xl2Var.c) && this.d.equals(xl2Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Profile(composerIds=" + this.a + ", recipientIds=" + this.b + ", sendIds=" + this.c + ", messageIds=" + this.d + ")";
    }
}
