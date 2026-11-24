package defpackage;

import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ji1 {
    public static final Pattern c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public final String a;
    public final String[] b;

    public ji1(String str, String[] strArr) {
        this.a = str;
        this.b = strArr;
    }

    public final Charset a(Charset charset) {
        String str;
        String[] strArr = this.b;
        int i = 0;
        int iA = dy3.a(0, strArr.length - 1, 2);
        if (iA < 0) {
            str = null;
            break;
        }
        while (true) {
            if (!js2.f(strArr[i], "charset")) {
                if (i == iA) {
                    str = null;
                    break;
                }
                i += 2;
            } else {
                str = strArr[i + 1];
                break;
            }
        }
        if (str == null) {
            return charset;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ji1) && g31.a(((ji1) obj).a, this.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
