package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gk0 {
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;

    public gk0(long j, byte[] bArr, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = bArr;
    }

    public static gk0 a(String str) {
        byte[] bytes = str.concat("\u0000").getBytes(jk0.Z);
        return new gk0(2, bytes, bytes.length);
    }

    public static gk0 b(long j, ByteOrder byteOrder) {
        return c(new long[]{j}, byteOrder);
    }

    public static gk0 c(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[jk0.O[4] * jArr.length]);
        byteBufferWrap.order(byteOrder);
        for (long j : jArr) {
            byteBufferWrap.putInt((int) j);
        }
        return new gk0(4, byteBufferWrap.array(), jArr.length);
    }

    public static gk0 d(ik0[] ik0VarArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[jk0.O[5] * ik0VarArr.length]);
        byteBufferWrap.order(byteOrder);
        for (ik0 ik0Var : ik0VarArr) {
            byteBufferWrap.putInt((int) ik0Var.a);
            byteBufferWrap.putInt((int) ik0Var.b);
        }
        return new gk0(5, byteBufferWrap.array(), ik0VarArr.length);
    }

    public static gk0 e(int i, ByteOrder byteOrder) {
        return f(new int[]{i}, byteOrder);
    }

    public static gk0 f(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[jk0.O[3] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i : iArr) {
            byteBufferWrap.putShort((short) i);
        }
        return new gk0(3, byteBufferWrap.array(), iArr.length);
    }

    public final double g(ByteOrder byteOrder) throws Throwable {
        Object objJ = j(byteOrder);
        if (objJ == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (objJ instanceof String) {
            return Double.parseDouble((String) objJ);
        }
        if (objJ instanceof long[]) {
            long[] jArr = (long[]) objJ;
            if (jArr.length == 1) {
                return jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objJ instanceof int[]) {
            int[] iArr = (int[]) objJ;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objJ instanceof double[]) {
            double[] dArr = (double[]) objJ;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objJ instanceof ik0[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        ik0[] ik0VarArr = (ik0[]) objJ;
        if (ik0VarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        ik0 ik0Var = ik0VarArr[0];
        return ik0Var.a / ik0Var.b;
    }

    public final int h(ByteOrder byteOrder) throws Throwable {
        Object objJ = j(byteOrder);
        if (objJ == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (objJ instanceof String) {
            return Integer.parseInt((String) objJ);
        }
        if (objJ instanceof long[]) {
            long[] jArr = (long[]) objJ;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objJ instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) objJ;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String i(ByteOrder byteOrder) throws Throwable {
        Object objJ = j(byteOrder);
        if (objJ == null) {
            return null;
        }
        if (objJ instanceof String) {
            return (String) objJ;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (objJ instanceof long[]) {
            long[] jArr = (long[]) objJ;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objJ instanceof int[]) {
            int[] iArr = (int[]) objJ;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objJ instanceof double[]) {
            double[] dArr = (double[]) objJ;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(objJ instanceof ik0[])) {
            return null;
        }
        ik0[] ik0VarArr = (ik0[]) objJ;
        while (i < ik0VarArr.length) {
            sb.append(ik0VarArr[i].a);
            sb.append('/');
            sb.append(ik0VarArr[i].b);
            i++;
            if (i != ik0VarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:17:0x0032 */
    /* JADX WARN: Type inference failed for: r13v14, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v15, types: [long[]] */
    /* JADX WARN: Type inference failed for: r13v16, types: [ik0[]] */
    /* JADX WARN: Type inference failed for: r13v17, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v18, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v19, types: [ik0[]] */
    /* JADX WARN: Type inference failed for: r13v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r13v21, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v22, types: [double[]] */
    public final Serializable j(ByteOrder byteOrder) throws Throwable {
        fk0 fk0Var;
        InputStream inputStream;
        String str;
        byte b;
        Object r13;
        byte[] bArr = this.d;
        InputStream inputStream2 = null;
        try {
            try {
                fk0Var = new fk0(bArr);
                try {
                    fk0Var.b = byteOrder;
                    int i = this.a;
                    int length = 0;
                    int i2 = this.b;
                    switch (i) {
                        case 1:
                        case 6:
                            if (bArr.length != 1 || (b = bArr[0]) < 0 || b > 1) {
                                str = new String(bArr, jk0.Z);
                                try {
                                    fk0Var.close();
                                    return str;
                                } catch (IOException e) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                    return str;
                                }
                            }
                            String str2 = new String(new char[]{(char) (b + 48)});
                            try {
                                fk0Var.close();
                                return str2;
                            } catch (IOException e2) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                return str2;
                            }
                        case 2:
                        case 7:
                            if (i2 >= jk0.P.length) {
                                int i3 = 0;
                                while (true) {
                                    byte[] bArr2 = jk0.P;
                                    if (i3 >= bArr2.length) {
                                        length = bArr2.length;
                                    } else if (bArr[i3] == bArr2[i3]) {
                                        i3++;
                                    }
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (length < i2) {
                                byte b2 = bArr[length];
                                if (b2 == 0) {
                                    str = sb.toString();
                                    fk0Var.close();
                                    return str;
                                }
                                if (b2 >= 32) {
                                    sb.append((char) b2);
                                } else {
                                    sb.append('?');
                                }
                                length++;
                            }
                            str = sb.toString();
                            fk0Var.close();
                            return str;
                        case 3:
                            r13 = new int[i2];
                            while (length < i2) {
                                r13[length] = fk0Var.readUnsignedShort();
                                length++;
                            }
                            try {
                                fk0Var.close();
                                return r13;
                            } catch (IOException e3) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                                return r13;
                            }
                        case 4:
                            r13 = new long[i2];
                            while (length < i2) {
                                r13[length] = ((long) fk0Var.readInt()) & 4294967295L;
                                length++;
                            }
                            fk0Var.close();
                            return r13;
                        case 5:
                            r13 = new ik0[i2];
                            while (length < i2) {
                                r13[length] = new ik0(((long) fk0Var.readInt()) & 4294967295L, ((long) fk0Var.readInt()) & 4294967295L);
                                length++;
                            }
                            fk0Var.close();
                            return r13;
                        case 8:
                            r13 = new int[i2];
                            while (length < i2) {
                                r13[length] = fk0Var.readShort();
                                length++;
                            }
                            fk0Var.close();
                            return r13;
                        case 9:
                            r13 = new int[i2];
                            while (length < i2) {
                                r13[length] = fk0Var.readInt();
                                length++;
                            }
                            fk0Var.close();
                            return r13;
                        case 10:
                            r13 = new ik0[i2];
                            while (length < i2) {
                                r13[length] = new ik0(fk0Var.readInt(), fk0Var.readInt());
                                length++;
                            }
                            fk0Var.close();
                            return r13;
                        case 11:
                            r13 = new double[i2];
                            while (length < i2) {
                                r13[length] = fk0Var.readFloat();
                                length++;
                            }
                            fk0Var.close();
                            return r13;
                        case 12:
                            r13 = new double[i2];
                            while (length < i2) {
                                r13[length] = fk0Var.readDouble();
                                length++;
                            }
                            fk0Var.close();
                            return r13;
                        default:
                            try {
                                fk0Var.close();
                                return null;
                            } catch (IOException e4) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                                return null;
                            }
                    }
                } catch (IOException e5) {
                    e = e5;
                    Log.w("ExifInterface", "IOException occurred during reading a value", e);
                    if (fk0Var != null) {
                        try {
                            fk0Var.close();
                        } catch (IOException e6) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e7) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            fk0Var = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    public final String toString() {
        return "(" + jk0.N[this.a] + ", data length:" + this.d.length + ")";
    }

    public gk0(int i, byte[] bArr, int i2) {
        this(-1L, bArr, i, i2);
    }
}
