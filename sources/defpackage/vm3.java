package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vm3 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;

    public vm3(String str, String str2, String str3, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vm3)) {
            return false;
        }
        vm3 vm3Var = (vm3) obj;
        return this.a.equals(vm3Var.a) && this.b.equals(vm3Var.b) && this.c.equals(vm3Var.c) && this.d == vm3Var.d;
    }

    public final int hashCode() {
        return (true != this.d ? 1237 : 1231) ^ ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("VkpTextRecognizerOptions{configLabel=");
        sb.append(this.a);
        sb.append(", modelDir=");
        sb.append(this.b);
        sb.append(", languageHint=");
        sb.append(this.c);
        sb.append(", enableLowLatencyInBackground=");
        return ky0.o(sb, this.d, "}");
    }
}
