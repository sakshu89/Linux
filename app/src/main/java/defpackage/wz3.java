package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wz3 {
    public static final qs4 a = new qs4(14);

    public static boolean a(String str, String str2) {
        str.getClass();
        str2.getClass();
        return g31.a(b(str), b(str2));
    }

    public static String b(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            char cCharAt = str.charAt(!z ? i : length);
            boolean z2 = cCharAt == 8203 || cCharAt == 65279 || cCharAt == 8206 || cCharAt == 8207 || (8234 <= cCharAt && cCharAt < 8239) || ((8294 <= cCharAt && cCharAt < 8298) || cCharAt == 8288);
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }
}
