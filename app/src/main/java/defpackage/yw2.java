package defpackage;

import android.view.textclassifier.TextClassification;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yw2 {
    public final CharSequence a;
    public final long b;
    public final TextClassification c;

    public yw2(CharSequence charSequence, long j, TextClassification textClassification) {
        this.a = charSequence;
        this.b = j;
        this.c = textClassification;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yw2)) {
            return false;
        }
        yw2 yw2Var = (yw2) obj;
        return g31.a(this.a, yw2Var.a) && oz2.b(this.b, yw2Var.b) && g31.a(this.c, yw2Var.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        int i = oz2.c;
        return this.c.hashCode() + cq.c(iHashCode, 31, this.b);
    }

    public final String toString() {
        return "TextClassificationResult(text=" + ((Object) this.a) + ", selection=" + ((Object) oz2.h(this.b)) + ", textClassification=" + this.c + ')';
    }
}
