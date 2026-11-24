package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oe1 {
    public final pe1 a;

    static {
        new LocaleList(new Locale[0]);
    }

    public oe1(pe1 pe1Var) {
        this.a = pe1Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof oe1) {
            return this.a.equals(((oe1) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.a.hashCode();
    }

    public final String toString() {
        return this.a.a.toString();
    }
}
