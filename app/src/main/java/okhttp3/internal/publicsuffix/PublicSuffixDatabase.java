package okhttp3.internal.publicsuffix;

import defpackage.cq;
import defpackage.cs2;
import defpackage.el1;
import defpackage.ex1;
import defpackage.fh;
import defpackage.fi4;
import defpackage.g31;
import defpackage.i32;
import defpackage.ii0;
import defpackage.mz;
import defpackage.nz;
import defpackage.og;
import defpackage.ov0;
import defpackage.rg;
import defpackage.sp1;
import defpackage.u03;
import defpackage.xg2;
import defpackage.yf0;
import defpackage.zf0;
import defpackage.zg2;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class PublicSuffixDatabase {
    public static final byte[] e = {42};
    public static final List f = nz.h("*");
    public static final PublicSuffixDatabase g = new PublicSuffixDatabase();
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final CountDownLatch b = new CountDownLatch(1);
    public byte[] c;
    public byte[] d;

    public static List c(String str) {
        List listN = cs2.N(str, new char[]{'.'}, 6);
        return g31.a(mz.D(listN), "") ? mz.v(listN) : listN;
    }

    public final String a(String str) {
        String strJ;
        String strJ2;
        String strJ3;
        List listN;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        unicode.getClass();
        List listC = c(unicode);
        List listN2 = ii0.a;
        if (this.a.get() || !this.a.compareAndSet(false, true)) {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z = true;
                    } catch (IOException e2) {
                        ex1 ex1Var = ex1.a;
                        ex1.a.getClass();
                        ex1.i("Failed to read public suffix list", 5, e2);
                        if (z) {
                        }
                    }
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.c == null) {
            og.n("Unable to load publicsuffixes.gz resource from the classpath.");
            return null;
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i = 0; i < size3; i++) {
            String str2 = (String) listC.get(i);
            Charset charset = StandardCharsets.UTF_8;
            charset.getClass();
            byte[] bytes = str2.getBytes(charset);
            bytes.getClass();
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= size3) {
                strJ = null;
                break;
            }
            byte[] bArr2 = this.c;
            if (bArr2 == null) {
                g31.f("publicSuffixListBytes");
                throw null;
            }
            strJ = el1.j(bArr2, i2, bArr);
            if (strJ != null) {
                break;
            }
            i2++;
        }
        if (size3 <= 1) {
            strJ2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                strJ2 = null;
                break;
            }
            bArr3[i3] = e;
            byte[] bArr4 = this.c;
            if (bArr4 == null) {
                g31.f("publicSuffixListBytes");
                throw null;
            }
            strJ2 = el1.j(bArr4, i3, bArr3);
            if (strJ2 != null) {
                break;
            }
            i3++;
        }
        if (strJ2 == null) {
            strJ3 = null;
            break;
        }
        int i4 = size3 - 1;
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                strJ3 = null;
                break;
            }
            byte[] bArr5 = this.d;
            if (bArr5 == null) {
                g31.f("publicSuffixExceptionListBytes");
                throw null;
            }
            strJ3 = el1.j(bArr5, i5, bArr);
            if (strJ3 != null) {
                break;
            }
            i5++;
        }
        if (strJ3 != null) {
            listN = cs2.N("!".concat(strJ3), new char[]{'.'}, 6);
        } else if (strJ == null && strJ2 == null) {
            listN = f;
        } else {
            List listN3 = strJ != null ? cs2.N(strJ, new char[]{'.'}, 6) : listN2;
            if (strJ2 != null) {
                listN2 = cs2.N(strJ2, new char[]{'.'}, 6);
            }
            listN = listN3.size() > listN2.size() ? listN3 : listN2;
        }
        if (listC.size() == listN.size() && ((String) listN.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listN.get(0)).charAt(0) == '!') {
            size = listC.size();
            size2 = listN.size();
        } else {
            size = listC.size();
            size2 = listN.size() + 1;
        }
        int i6 = size - size2;
        xg2 rgVar = new rg(1, c(str));
        if (i6 < 0) {
            og.g(cq.h("Requested element count ", i6, " is less than zero."));
            return null;
        }
        if (i6 != 0) {
            rgVar = rgVar instanceof zf0 ? ((zf0) rgVar).a(i6) : new yf0(rgVar, i6);
        }
        return zg2.d(rgVar, ".", null, 62);
    }

    public final void b() {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream != null) {
                Logger logger = sp1.a;
                i32 i32Var = new i32(new ov0(new fh(1, resourceAsStream, new u03())));
                try {
                    long j = i32Var.readInt();
                    i32Var.F(j);
                    byte[] bArrR = i32Var.b.r(j);
                    long j2 = i32Var.readInt();
                    i32Var.F(j2);
                    byte[] bArrR2 = i32Var.b.r(j2);
                    i32Var.close();
                    synchronized (this) {
                        this.c = bArrR;
                        this.d = bArrR2;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        fi4.a(i32Var, th);
                        throw th2;
                    }
                }
            }
            this.b.countDown();
        } catch (Throwable th3) {
            this.b.countDown();
            throw th3;
        }
    }
}
