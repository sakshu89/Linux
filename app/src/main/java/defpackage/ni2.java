package defpackage;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ni2 {
    public final Intent a;
    public final String b;
    public final boolean c;

    public ni2(Intent intent, String str, boolean z) {
        this.a = intent;
        this.b = str;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ni2)) {
            return false;
        }
        ni2 ni2Var = (ni2) obj;
        return this.a.equals(ni2Var.a) && this.b.equals(ni2Var.b) && this.c == ni2Var.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ky0.d(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SettingsTarget(intent=");
        sb.append(this.a);
        sb.append(", label=");
        sb.append(this.b);
        sb.append(", isPanel=");
        return ky0.o(sb, this.c, ")");
    }
}
