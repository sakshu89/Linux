package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ko4 {
    public static void a(String str) {
        if (str.length() <= 0) {
            og.i("name is empty");
            return;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                og.g(z53.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                return;
            }
        }
    }

    public static void b(String str, String str2) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                og.g(z53.i("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), str2).concat(z53.q(str2) ? "" : ": ".concat(str)));
                return;
            }
        }
    }

    public static ew0 c(String... strArr) {
        if (strArr.length % 2 != 0) {
            og.i("Expected alternating header names and values");
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        int length = strArr2.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr2[i2];
            if (str == null) {
                og.i("Headers cannot be null");
                return null;
            }
            strArr2[i2] = cs2.V(str).toString();
        }
        int iA = dy3.a(0, strArr2.length - 1, 2);
        if (iA >= 0) {
            while (true) {
                String str2 = strArr2[i];
                String str3 = strArr2[i + 1];
                a(str2);
                b(str3, str2);
                if (i == iA) {
                    break;
                }
                i += 2;
            }
        }
        return new ew0(strArr2);
    }
}
