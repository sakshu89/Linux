package defpackage;

import com.ibm.icu.lang.UCharacterEnums;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class z53 {
    public static final byte[] a;
    public static final ew0 b = ko4.c(new String[0]);
    public static final a72 c;
    public static final fs1 d;
    public static final TimeZone e;
    public static final x42 f;
    public static final String g;

    static {
        int i = 0;
        byte[] bArr = new byte[0];
        a = bArr;
        ln lnVar = new ln();
        lnVar.C(bArr, 0);
        c = new a72(0L, lnVar);
        c(0L, 0L, 0L);
        oo ooVar = oo.e;
        oo[] ooVarArr = {nr4.l("efbbbf"), nr4.l("feff"), nr4.l("fffe"), nr4.l("0000ffff"), nr4.l("ffff0000")};
        ArrayList arrayList = new ArrayList(new gg(ooVarArr, false));
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(5);
        for (int i2 = 0; i2 < 5; i2++) {
            oo ooVar2 = ooVarArr[i2];
            arrayList2.add(-1);
        }
        Integer[] numArr = (Integer[]) arrayList2.toArray(new Integer[0]);
        ArrayList arrayListK = nz.k(Arrays.copyOf(numArr, numArr.length));
        int i3 = 0;
        int i4 = 0;
        while (i3 < 5) {
            arrayListK.set(nz.b(arrayList, ooVarArr[i3]), Integer.valueOf(i4));
            i3++;
            i4++;
        }
        if (((oo) arrayList.get(0)).c() <= 0) {
            og.i("the empty byte string is not a supported option");
            return;
        }
        int i5 = 0;
        while (i5 < arrayList.size()) {
            oo ooVar3 = (oo) arrayList.get(i5);
            int i6 = i5 + 1;
            int i7 = i6;
            while (i7 < arrayList.size()) {
                oo ooVar4 = (oo) arrayList.get(i7);
                ooVar4.getClass();
                ooVar3.getClass();
                if (!ooVar4.g(ooVar3.c(), ooVar3)) {
                    break;
                }
                if (ooVar4.c() == ooVar3.c()) {
                    dk0.w(ooVar4, "duplicate option: ");
                    return;
                } else if (((Number) arrayListK.get(i7)).intValue() > ((Number) arrayListK.get(i5)).intValue()) {
                    arrayList.remove(i7);
                    arrayListK.remove(i7);
                } else {
                    i7++;
                }
            }
            i5 = i6;
        }
        ln lnVar2 = new ln();
        as4.a(0L, lnVar2, 0, arrayList, 0, arrayList.size(), arrayListK);
        int[] iArr = new int[(int) (lnVar2.b / 4)];
        while (!lnVar2.e()) {
            iArr[i] = lnVar2.readInt();
            i++;
        }
        d = new fs1((oo[]) Arrays.copyOf(ooVarArr, 5), iArr);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        timeZone.getClass();
        e = timeZone;
        f = new x42("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        g = cs2.I(cs2.G(rp1.class.getName(), "okhttp3."), "Client");
    }

    public static final boolean a(ey0 ey0Var, ey0 ey0Var2) {
        ey0Var.getClass();
        ey0Var2.getClass();
        return g31.a(ey0Var.d, ey0Var2.d) && ey0Var.e == ey0Var2.e && g31.a(ey0Var.a, ey0Var2.a);
    }

    public static final int b(String str, long j, TimeUnit timeUnit) {
        if (j < 0) {
            kf2.e(str.concat(" < 0"));
            return 0;
        }
        if (timeUnit == null) {
            og.n("unit == null");
            return 0;
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            og.g(str.concat(" too large."));
            return 0;
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        og.g(str.concat(" too small."));
        return 0;
    }

    public static final void c(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void d(Closeable closeable) {
        closeable.getClass();
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void e(Socket socket) {
        socket.getClass();
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!g31.a(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final int f(String str, char c2, int i, int i2) {
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int g(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (cs2.o(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int h(String str, char c2, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return f(str, c2, i, i2);
    }

    public static final String i(String str, Object... objArr) {
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean j(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr.getClass();
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                int i = 0;
                while (true) {
                    if (i < strArr2.length) {
                        int i2 = i + 1;
                        try {
                            if (comparator.compare(str, strArr2[i]) == 0) {
                                return true;
                            }
                            i = i2;
                        } catch (ArrayIndexOutOfBoundsException e2) {
                            kf2.g(e2.getMessage());
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long k(z62 z62Var) {
        String strA = z62Var.i.a("Content-Length");
        if (strA == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List l(Object... objArr) {
        Object[] objArr2 = (Object[]) objArr.clone();
        List listUnmodifiableList = Collections.unmodifiableList(nz.i(Arrays.copyOf(objArr2, objArr2.length)));
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    public static final int m(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (g31.b(cCharAt, 31) <= 0 || g31.b(cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int n(int i, int i2, String str) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int o(int i, int i2, String str) {
        int i3 = i2 - 1;
        if (i <= i3) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 != i) {
                    i3--;
                }
            }
        }
        return i;
    }

    public static final String[] p(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr2.getClass();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean q(String str) {
        str.getClass();
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final int r(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' > c2 || c2 >= 'G') {
            return -1;
        }
        return c2 - '7';
    }

    public static final Charset s(yn ynVar, Charset charset) {
        ynVar.getClass();
        charset.getClass();
        int iB = ynVar.B(d);
        if (iB == -1) {
            return charset;
        }
        if (iB == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            charset2.getClass();
            return charset2;
        }
        if (iB == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            charset3.getClass();
            return charset3;
        }
        if (iB == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            charset4.getClass();
            return charset4;
        }
        if (iB == 3) {
            Charset charset5 = px.a;
            Charset charset6 = px.c;
            if (charset6 != null) {
                return charset6;
            }
            Charset charsetForName = Charset.forName("UTF-32BE");
            charsetForName.getClass();
            px.c = charsetForName;
            return charsetForName;
        }
        if (iB != 4) {
            throw new AssertionError();
        }
        Charset charset7 = px.a;
        Charset charset8 = px.b;
        if (charset8 != null) {
            return charset8;
        }
        Charset charsetForName2 = Charset.forName("UTF-32LE");
        charsetForName2.getClass();
        px.b = charsetForName2;
        return charsetForName2;
    }

    public static final int t(yn ynVar) {
        ynVar.getClass();
        return (ynVar.readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | ((ynVar.readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 16) | ((ynVar.readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8);
    }

    public static final boolean u(fp2 fp2Var, int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        long jNanoTime = System.nanoTime();
        long jC = fp2Var.d().e() ? fp2Var.d().c() - jNanoTime : Long.MAX_VALUE;
        fp2Var.d().d(Math.min(jC, timeUnit.toNanos(i)) + jNanoTime);
        try {
            ln lnVar = new ln();
            while (fp2Var.f(8192L, lnVar) != -1) {
                lnVar.skip(lnVar.b);
            }
            if (jC == Long.MAX_VALUE) {
                fp2Var.d().a();
                return true;
            }
            fp2Var.d().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                fp2Var.d().a();
                return false;
            }
            fp2Var.d().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                fp2Var.d().a();
            } else {
                fp2Var.d().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final ew0 v(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dw0 dw0Var = (dw0) it.next();
            oo ooVar = dw0Var.a;
            oo ooVar2 = dw0Var.b;
            String strJ = ooVar.j();
            String strJ2 = ooVar2.j();
            arrayList.add(strJ);
            arrayList.add(cs2.V(strJ2).toString());
        }
        return new ew0((String[]) arrayList.toArray(new String[0]));
    }

    public static final String w(ey0 ey0Var, boolean z) {
        int i;
        ey0Var.getClass();
        int i2 = ey0Var.e;
        String str = ey0Var.d;
        if (cs2.n(str, ":", false)) {
            str = "[" + str + ']';
        }
        if (!z) {
            String str2 = ey0Var.a;
            str2.getClass();
            if (str2.equals("http")) {
                i = 80;
            } else {
                i = str2.equals("https") ? 443 : -1;
            }
            if (i2 == i) {
                return str;
            }
        }
        return str + ':' + i2;
    }

    public static final List x(List list) {
        list.getClass();
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    public static final int y(int i, String str) {
        if (str == null) {
            return i;
        }
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
