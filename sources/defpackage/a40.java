package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a40 {
    public static final a40 e;
    public static final a40 f;
    public final boolean a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    static {
        xx xxVar = xx.r;
        xx xxVar2 = xx.s;
        xx xxVar3 = xx.t;
        xx xxVar4 = xx.l;
        xx xxVar5 = xx.n;
        xx xxVar6 = xx.m;
        xx xxVar7 = xx.o;
        xx xxVar8 = xx.q;
        xx xxVar9 = xx.p;
        xx[] xxVarArr = {xxVar, xxVar2, xxVar3, xxVar4, xxVar5, xxVar6, xxVar7, xxVar8, xxVar9};
        xx[] xxVarArr2 = {xxVar, xxVar2, xxVar3, xxVar4, xxVar5, xxVar6, xxVar7, xxVar8, xxVar9, xx.j, xx.k, xx.h, xx.i, xx.f, xx.g, xx.e};
        z30 z30Var = new z30(0);
        z30Var.b((xx[]) Arrays.copyOf(xxVarArr, 9));
        c13 c13Var = c13.TLS_1_3;
        c13 c13Var2 = c13.TLS_1_2;
        z30Var.e(c13Var, c13Var2);
        z30Var.b = true;
        z30Var.a();
        z30 z30Var2 = new z30(0);
        z30Var2.b((xx[]) Arrays.copyOf(xxVarArr2, 16));
        z30Var2.e(c13Var, c13Var2);
        z30Var2.b = true;
        e = z30Var2.a();
        z30 z30Var3 = new z30(0);
        z30Var3.b((xx[]) Arrays.copyOf(xxVarArr2, 16));
        z30Var3.e(c13Var, c13Var2, c13.TLS_1_1, c13.TLS_1_0);
        z30Var3.b = true;
        z30Var3.a();
        f = new a40(false, false, null, null);
    }

    public a40(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.a = z;
        this.b = z2;
        this.c = strArr;
        this.d = strArr2;
    }

    public final List a() {
        String[] strArr = this.c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(xx.b.n(str));
        }
        return mz.O(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        if (!this.a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !z53.j(strArr, sSLSocket.getEnabledProtocols(), bn1.b)) {
            return false;
        }
        String[] strArr2 = this.c;
        return strArr2 == null || z53.j(strArr2, sSLSocket.getEnabledCipherSuites(), xx.c);
    }

    public final List c() {
        String[] strArr = this.d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(zc4.b(str));
        }
        return mz.O(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a40)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        a40 a40Var = (a40) obj;
        boolean z = a40Var.a;
        boolean z2 = this.a;
        if (z2 != z) {
            return false;
        }
        if (z2) {
            return Arrays.equals(this.c, a40Var.c) && Arrays.equals(this.d, a40Var.d) && this.b == a40Var.b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.a) {
            return 17;
        }
        String[] strArr = this.c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.b ? 1 : 0);
    }

    public final String toString() {
        if (!this.a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.b + ')';
    }
}
