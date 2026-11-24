package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s43 {
    public static r43 a(Object obj) {
        yt0 yt0Var = (yt0) obj;
        r43 r43Var = yt0Var.unknownFields;
        if (r43Var != r43.f) {
            return r43Var;
        }
        r43 r43Var2 = new r43(0, new int[8], new Object[8], true);
        yt0Var.unknownFields = r43Var2;
        return r43Var2;
    }

    public static boolean b(int i, iz izVar, Object obj) throws o31 {
        int i2 = izVar.b;
        hz hzVar = (hz) izVar.e;
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            izVar.A(0);
            ((r43) obj).c(i3 << 3, Long.valueOf(hzVar.s()));
            return true;
        }
        if (i4 == 1) {
            izVar.A(1);
            ((r43) obj).c((i3 << 3) | 1, Long.valueOf(hzVar.p()));
            return true;
        }
        if (i4 == 2) {
            ((r43) obj).c((i3 << 3) | 2, izVar.i());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 5) {
                throw o31.b();
            }
            izVar.A(5);
            ((r43) obj).c(5 | (i3 << 3), Integer.valueOf(hzVar.o()));
            return true;
        }
        r43 r43Var = new r43(0, new int[8], new Object[8], true);
        int i5 = i3 << 3;
        int i6 = i5 | 4;
        int i7 = i + 1;
        if (i7 >= 100) {
            throw new o31("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (izVar.c() != Integer.MAX_VALUE && b(i7, izVar, r43Var)) {
        }
        if (i6 != izVar.b) {
            throw new o31("Protocol message end-group tag did not match expected tag.");
        }
        if (r43Var.e) {
            r43Var.e = false;
        }
        ((r43) obj).c(i5 | 3, r43Var);
        return true;
    }
}
