package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gh0 {
    public final ye a;
    public int b;
    public int c;
    public int d;
    public int e;

    public gh0(be beVar, long j) {
        String str = beVar.b;
        ye yeVar = new ye();
        yeVar.d = str;
        yeVar.b = -1;
        yeVar.c = -1;
        this.a = yeVar;
        this.b = oz2.f(j);
        this.c = oz2.e(j);
        this.d = -1;
        this.e = -1;
        int iF = oz2.f(j);
        int iE = oz2.e(j);
        if (iF < 0 || iF > str.length()) {
            dk0.f(str.length(), ky0.p("start (", iF, ") offset is outside of text region "));
            throw null;
        }
        if (iE < 0 || iE > str.length()) {
            dk0.f(str.length(), ky0.p("end (", iE, ") offset is outside of text region "));
            throw null;
        }
        if (iF <= iE) {
            return;
        }
        og.i(ky0.i("Do not set reversed range: ", iF, iE, " > "));
        throw null;
    }

    public final void a(int i, int i2) {
        long jA = hc4.a(i, i2);
        this.a.m(i, i2, "");
        long jA2 = an4.a(hc4.a(this.b, this.c), jA);
        h(oz2.f(jA2));
        g(oz2.e(jA2));
        int i3 = this.d;
        if (i3 != -1) {
            long jA3 = an4.a(hc4.a(i3, this.e), jA);
            if (oz2.c(jA3)) {
                this.d = -1;
                this.e = -1;
            } else {
                this.d = oz2.f(jA3);
                this.e = oz2.e(jA3);
            }
        }
    }

    public final char b(int i) {
        ye yeVar = this.a;
        iz izVar = (iz) yeVar.e;
        if (izVar == null) {
            return ((String) yeVar.d).charAt(i);
        }
        if (i < yeVar.b) {
            return ((String) yeVar.d).charAt(i);
        }
        int iB = izVar.b - izVar.b();
        int i2 = yeVar.b;
        if (i >= iB + i2) {
            return ((String) yeVar.d).charAt(i - ((iB - yeVar.c) + i2));
        }
        int i3 = i - i2;
        int i4 = izVar.c;
        char[] cArr = (char[]) izVar.e;
        return i3 < i4 ? cArr[i3] : cArr[(i3 - i4) + izVar.d];
    }

    public final oz2 c() {
        int i = this.d;
        if (i != -1) {
            return new oz2(hc4.a(i, this.e));
        }
        return null;
    }

    public final void d(int i, int i2, String str) {
        ye yeVar = this.a;
        if (i < 0 || i > yeVar.c()) {
            dk0.f(yeVar.c(), ky0.p("start (", i, ") offset is outside of text region "));
            return;
        }
        if (i2 < 0 || i2 > yeVar.c()) {
            dk0.f(yeVar.c(), ky0.p("end (", i2, ") offset is outside of text region "));
        } else {
            if (i > i2) {
                og.i(ky0.i("Do not set reversed range: ", i, i2, " > "));
                return;
            }
            yeVar.m(i, i2, str);
            h(str.length() + i);
            g(str.length() + i);
            this.d = -1;
            this.e = -1;
        }
    }

    public final void e(int i, int i2) {
        ye yeVar = this.a;
        if (i < 0 || i > yeVar.c()) {
            dk0.f(yeVar.c(), ky0.p("start (", i, ") offset is outside of text region "));
        } else if (i2 < 0 || i2 > yeVar.c()) {
            dk0.f(yeVar.c(), ky0.p("end (", i2, ") offset is outside of text region "));
        } else if (i >= i2) {
            og.i(ky0.i("Do not set reversed or empty range: ", i, i2, " > "));
        } else {
            this.d = i;
            this.e = i2;
        }
    }

    public final void f(int i, int i2) {
        ye yeVar = this.a;
        if (i < 0 || i > yeVar.c()) {
            dk0.f(yeVar.c(), ky0.p("start (", i, ") offset is outside of text region "));
        } else if (i2 < 0 || i2 > yeVar.c()) {
            dk0.f(yeVar.c(), ky0.p("end (", i2, ") offset is outside of text region "));
        } else if (i > i2) {
            og.i(ky0.i("Do not set reversed range: ", i, i2, " > "));
        } else {
            h(i);
            g(i2);
        }
    }

    public final void g(int i) {
        if (!(i >= 0)) {
            a11.a("Cannot set selectionEnd to a negative value: " + i);
        }
        this.c = i;
    }

    public final void h(int i) {
        if (!(i >= 0)) {
            a11.a("Cannot set selectionStart to a negative value: " + i);
        }
        this.b = i;
    }

    public final String toString() {
        return this.a.toString();
    }
}
