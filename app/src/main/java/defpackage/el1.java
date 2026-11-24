package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.ibm.icu.lang.UCharacterEnums;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class el1 implements o72, om2, uy2, p10, po0, dr0, ey1, op3, ks4 {
    public static final el1 b = new el1(1);
    public static final el1 c = new el1(2);
    public static final el1 e = new el1(3);
    public static final el1 f = new el1(4);
    public static final el1 i = new el1(5);
    public static final el1 j = new el1(6);
    public static final /* synthetic */ el1 k = new el1(7);
    public static el1 n;
    public final /* synthetic */ int a;

    public el1(Set set) {
        this.a = 0;
        new HashMap();
        new HashMap();
        Iterator it = set.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            dk0.t();
            throw null;
        }
    }

    public static final String j(byte[] bArr, int i2, byte[][] bArr2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        byte[] bArr3 = PublicSuffixDatabase.e;
        int length = bArr.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = (i6 + length) / 2;
            while (i7 > -1 && bArr[i7] != 10) {
                i7--;
            }
            int i8 = i7 + 1;
            int i9 = 1;
            while (true) {
                i3 = i8 + i9;
                if (bArr[i3] == 10) {
                    break;
                }
                i9++;
            }
            int i10 = i3 - i8;
            int i11 = i2;
            boolean z2 = false;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (z2) {
                    i4 = 46;
                    z = false;
                } else {
                    byte b2 = bArr2[i11][i12];
                    byte[] bArr4 = z53.a;
                    int i14 = b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                    z = z2;
                    i4 = i14;
                }
                byte b3 = bArr[i8 + i13];
                byte[] bArr5 = z53.a;
                i5 = i4 - (b3 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
                if (i5 != 0) {
                    break;
                }
                i13++;
                i12++;
                if (i13 == i10) {
                    break;
                }
                if (bArr2[i11].length != i12) {
                    z2 = z;
                } else {
                    if (i11 == bArr2.length - 1) {
                        break;
                    }
                    i11++;
                    i12 = -1;
                    z2 = true;
                }
            }
            if (i5 >= 0) {
                if (i5 <= 0) {
                    int i15 = i10 - i13;
                    int length2 = bArr2[i11].length - i12;
                    int length3 = bArr2.length;
                    for (int i16 = i11 + 1; i16 < length3; i16++) {
                        length2 += bArr2[i16].length;
                    }
                    if (length2 >= i15) {
                        if (length2 <= i15) {
                            Charset charset = StandardCharsets.UTF_8;
                            charset.getClass();
                            return new String(bArr, i8, i10, charset);
                        }
                    }
                }
                i6 = i3 + 1;
            }
            length = i7;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0080  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.content.ContentValues] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static Uri m(File file, kf kfVar) throws Throwable {
        Uri uriInsert;
        int i2;
        ContentValues contentValues;
        ContentResolver contentResolver = (ContentResolver) kfVar.b;
        Objects.requireNonNull(contentResolver);
        ContentValues contentValues2 = (ContentValues) kfVar.c;
        Uri contentValues3 = contentValues2 != null ? new ContentValues(contentValues2) : new ContentValues();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            contentValues3.put("is_pending", 1);
        }
        try {
            try {
                uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues3);
                try {
                    if (uriInsert == null) {
                        throw new ty0("Failed to insert a MediaStore URI.", null);
                    }
                    n(file, uriInsert, contentResolver);
                    if (i3 >= 29) {
                        ContentValues contentValues4 = new ContentValues();
                        if (i3 >= 29) {
                            contentValues4.put("is_pending", (Integer) 0);
                        }
                        contentResolver.update(uriInsert, contentValues4, null, null);
                    }
                    return uriInsert;
                } catch (IOException e2) {
                    e = e2;
                    throw new ty0("Failed to write to MediaStore URI: " + uriInsert, e);
                } catch (SecurityException e3) {
                    e = e3;
                    throw new ty0("Failed to write to MediaStore URI: " + uriInsert, e);
                }
            } catch (Throwable th) {
                th = th;
                if (contentValues3 != 0 && (i2 = Build.VERSION.SDK_INT) >= 29) {
                    contentValues = new ContentValues();
                    if (i2 >= 29) {
                        contentValues.put("is_pending", (Integer) 0);
                    }
                    contentResolver.update(contentValues3, contentValues, null, null);
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            uriInsert = null;
            throw new ty0("Failed to write to MediaStore URI: " + uriInsert, e);
        } catch (SecurityException e5) {
            e = e5;
            uriInsert = null;
            throw new ty0("Failed to write to MediaStore URI: " + uriInsert, e);
        } catch (Throwable th2) {
            th = th2;
            contentValues3 = 0;
            if (contentValues3 != 0) {
                contentValues = new ContentValues();
                if (i2 >= 29) {
                    contentValues.put("is_pending", (Integer) 0);
                }
                contentResolver.update(contentValues3, contentValues, null, null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void n(File file, Uri uri, ContentResolver contentResolver) throws IOException {
        OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri);
        try {
            if (outputStreamOpenOutputStream == null) {
                throw new FileNotFoundException(uri + " cannot be resolved.");
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 <= 0) {
                        fileInputStream.close();
                        outputStreamOpenOutputStream.close();
                        return;
                    }
                    outputStreamOpenOutputStream.write(bArr, 0, i2);
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            if (outputStreamOpenOutputStream != null) {
                outputStreamOpenOutputStream.close();
            }
            throw th4;
        }
    }

    public static Typeface o(String str, np0 np0Var, int i2) {
        if (i2 == 0 && g31.a(np0Var, np0.c) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        return Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), np0Var.a, i2 == 1);
    }

    public static rn2 p(e5 e5Var) {
        e5Var.getClass();
        if (e5Var instanceof a5) {
            return rn2.e;
        }
        if (e5Var.equals(b5.a)) {
            return rn2.f;
        }
        if (e5Var instanceof y4) {
            return rn2.i;
        }
        if (e5Var instanceof d5) {
            return rn2.j;
        }
        if (e5Var instanceof c5) {
            return rn2.b;
        }
        if (e5Var instanceof z4) {
            return q(((z4) e5Var).a.b);
        }
        dk0.l();
        return null;
    }

    public static rn2 q(e33 e33Var) {
        int iOrdinal = e33Var.ordinal();
        rn2 rn2Var = rn2.k;
        rn2 rn2Var2 = rn2.s;
        switch (iOrdinal) {
            case 0:
                return rn2Var;
            case 1:
                return rn2.n;
            case 2:
                return rn2.u;
            case 3:
                return rn2.t;
            case 4:
                return rn2.w;
            case 5:
                return rn2.v;
            case 6:
                return rn2.x;
            case 7:
                return rn2.b;
            case 8:
                return rn2Var2;
            case 9:
                return rn2Var;
            case 10:
                return rn2Var2;
            default:
                dk0.l();
                return null;
        }
    }

    @Override // defpackage.uy2
    public float a() {
        return Float.NaN;
    }

    @Override // defpackage.om2
    public boolean b(Object obj, Object obj2) {
        return false;
    }

    @Override // defpackage.uy2
    public long c() {
        int i2 = sz.h;
        return sz.g;
    }

    @Override // defpackage.uy2
    public hn d() {
        return null;
    }

    @Override // defpackage.ey1
    public Typeface e(np0 np0Var, int i2) {
        return o(null, np0Var, i2);
    }

    @Override // defpackage.ks4
    public Object f(Object obj) {
        zs4 zs4Var = (zs4) obj;
        float f2 = zs4Var.i;
        rw2 rw2Var = new rw2(zs4Var.a, zs4Var.b, zs4Var.c, zs4Var.e, null);
        jh4.b(zs4Var.f, new su0(23));
        return rw2Var;
    }

    @Override // defpackage.p10
    public Object g(e72 e72Var) {
        switch (this.a) {
            case 7:
                return new el1(e72Var.d(dl1.class));
            case 24:
                return new p52(e72Var.c(y74.class));
            default:
                return new qm4((on4) e72Var.b(on4.class), (wj0) e72Var.b(wj0.class));
        }
    }

    @Override // defpackage.op3
    public String h(Object obj) {
        return ((lr3) obj).a;
    }

    @Override // defpackage.ey1
    public Typeface i(bu0 bu0Var, np0 np0Var, int i2) {
        return o(bu0Var.d, np0Var, i2);
    }

    public ek1 k(c6 c6Var) {
        return new em((ll) c6Var);
    }

    public long l(long j2, long j3) {
        float fMin = Math.min(Float.intBitsToFloat((int) (j3 >> 32)) / Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)) / Float.intBitsToFloat((int) (j2 & 4294967295L)));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fMin)) << 32) | (((long) Float.floatToRawIntBits(fMin)) & 4294967295L);
        int i2 = xa2.a;
        return jFloatToRawIntBits;
    }

    public String toString() {
        switch (this.a) {
            case 4:
                return "NeverEqualPolicy";
            default:
                return super.toString();
        }
    }

    @Override // defpackage.dr0
    public Object apply(Object obj) {
        return obj;
    }

    public /* synthetic */ el1(int i2) {
        this.a = i2;
    }
}
