package defpackage;

import com.ibm.icu.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class np0 implements Comparable {
    public static final np0 b;
    public static final np0 c;
    public static final np0 e;
    public static final np0 f;
    public final int a;

    static {
        np0 np0Var = new np0(100);
        np0 np0Var2 = new np0(200);
        np0 np0Var3 = new np0(300);
        np0 np0Var4 = new np0(400);
        np0 np0Var5 = new np0(BreakIterator.WORD_IDEO_LIMIT);
        np0 np0Var6 = new np0(600);
        b = np0Var6;
        np0 np0Var7 = new np0(700);
        np0 np0Var8 = new np0(800);
        np0 np0Var9 = new np0(900);
        c = np0Var4;
        e = np0Var5;
        f = np0Var7;
        nz.i(np0Var, np0Var2, np0Var3, np0Var4, np0Var5, np0Var6, np0Var7, np0Var8, np0Var9);
    }

    public np0(int i) {
        this.a = i;
        boolean z = false;
        if (1 <= i && i < 1001) {
            z = true;
        }
        if (z) {
            return;
        }
        a11.a("Font weight can be in range [1, 1000]. Current value: " + i);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return g31.b(this.a, ((np0) obj).a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof np0) {
            return this.a == ((np0) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return ky0.m(new StringBuilder("FontWeight(weight="), this.a, ')');
    }
}
