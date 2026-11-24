package defpackage;

import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.Bidi;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wx0 implements Closeable {
    public static final Logger e;
    public final yn a;
    public final vx0 b;
    public final zw0 c;

    static {
        Logger logger = Logger.getLogger(ix0.class.getName());
        logger.getClass();
        e = logger;
    }

    public wx0(i32 i32Var) {
        i32Var.getClass();
        this.a = i32Var;
        vx0 vx0Var = new vx0(i32Var);
        this.b = vx0Var;
        this.c = new zw0(vx0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c(boolean z, nx0 nx0Var) throws IOException {
        int i;
        boolean z2;
        int i2;
        Object[] array;
        boolean z3 = false;
        try {
            this.a.F(9L);
            int iT = z53.t(this.a);
            if (iT > 16384) {
                dk0.h(ky0.h(iT, "FRAME_SIZE_ERROR: "));
                return false;
            }
            int i3 = this.a.readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            byte b = this.a.readByte();
            int i4 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            int i5 = this.a.readInt();
            int i6 = i5 & Integer.MAX_VALUE;
            Logger logger = e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(ix0.a(true, i6, iT, i3, i4));
            }
            if (z && i3 != 4) {
                StringBuilder sb = new StringBuilder("Expected a SETTINGS frame but was ");
                String[] strArr = ix0.b;
                sb.append(i3 < strArr.length ? strArr[i3] : z53.i("0x%02x", Integer.valueOf(i3)));
                throw new IOException(sb.toString());
            }
            int i7 = 2;
            switch (i3) {
                case 0:
                    e(nx0Var, iT, i4, i6);
                    return true;
                case 1:
                    o(nx0Var, iT, i4, i6);
                    return true;
                case 2:
                    if (iT != 5) {
                        dk0.h(cq.h("TYPE_PRIORITY length: ", iT, " != 5"));
                        return false;
                    }
                    if (i6 == 0) {
                        dk0.h("TYPE_PRIORITY streamId == 0");
                        return false;
                    }
                    yn ynVar = this.a;
                    ynVar.readInt();
                    ynVar.readByte();
                    return true;
                case 3:
                    if (iT != 4) {
                        dk0.h(cq.h("TYPE_RST_STREAM length: ", iT, " != 4"));
                        return false;
                    }
                    if (i6 == 0) {
                        dk0.h("TYPE_RST_STREAM streamId == 0");
                        return false;
                    }
                    int i8 = this.a.readInt();
                    int[] iArrA = cq.A(14);
                    int length = iArrA.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 < length) {
                            int i10 = iArrA[i9];
                            if (cq.x(i10) == i8) {
                                i = i10;
                            } else {
                                i9++;
                            }
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        dk0.h(ky0.h(i8, "TYPE_RST_STREAM unexpected error code: "));
                        return false;
                    }
                    tx0 tx0Var = nx0Var.b;
                    if (i6 != 0 && (i5 & 1) == 0) {
                        tx0Var.n.c(new mx0(tx0Var.c + '[' + i6 + "] onReset", tx0Var, i6, i, 1), 0L);
                        return true;
                    }
                    ay0 ay0VarJ = tx0Var.j(i6);
                    if (ay0VarJ == null) {
                        return true;
                    }
                    synchronized (ay0VarJ) {
                        try {
                            if (i == 0) {
                                throw null;
                            }
                            if (ay0VarJ.m == 0) {
                                ay0VarJ.m = i;
                                ay0VarJ.notifyAll();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return true;
                case 4:
                    yn ynVar2 = this.a;
                    if (i6 != 0) {
                        dk0.h("TYPE_SETTINGS streamId != 0");
                        return false;
                    }
                    if ((b & 1) == 0) {
                        if (iT % 6 != 0) {
                            dk0.h(ky0.h(iT, "TYPE_SETTINGS length % 6 != 0: "));
                            return false;
                        }
                        yh2 yh2Var = new yh2();
                        f21 f21VarE = ky3.e(ky3.f(0, iT), 6);
                        int i11 = f21VarE.a;
                        int i12 = f21VarE.b;
                        int i13 = f21VarE.c;
                        if ((i13 > 0 && i11 <= i12) || (i13 < 0 && i12 <= i11)) {
                            while (true) {
                                short s = ynVar2.readShort();
                                byte[] bArr = z53.a;
                                int i14 = s & 65535;
                                int i15 = ynVar2.readInt();
                                if (i14 == 2) {
                                    z2 = z3;
                                    if (i15 != 0 && i15 != 1) {
                                        dk0.h("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                        return z2;
                                    }
                                } else if (i14 == 3) {
                                    z2 = z3;
                                    i14 = 4;
                                } else if (i14 == 4) {
                                    z2 = z3;
                                    if (i15 < 0) {
                                        dk0.h("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        return z2;
                                    }
                                    i14 = 7;
                                } else if (i14 != 5) {
                                    z2 = z3;
                                } else {
                                    z2 = z3;
                                    if (i15 < 16384 || i15 > 16777215) {
                                        dk0.h(ky0.h(i15, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
                                        return z2;
                                    }
                                }
                                yh2Var.b(i14, i15);
                                if (i11 != i12) {
                                    i11 += i13;
                                    z3 = z2;
                                }
                            }
                        }
                        tx0 tx0Var2 = nx0Var.b;
                        tx0Var2.k.c(new lx0(i7, cq.n(new StringBuilder(), tx0Var2.c, " applyAndAckSettings"), nx0Var, yh2Var), 0L);
                        return true;
                    }
                    if (iT != 0) {
                        dk0.h("FRAME_SIZE_ERROR ack frame should be empty!");
                        return false;
                    }
                    break;
                case 5:
                    q(nx0Var, iT, i4, i6);
                    return true;
                case 6:
                    if (iT != 8) {
                        dk0.h(ky0.h(iT, "TYPE_PING length != 8: "));
                        return false;
                    }
                    if (i6 != 0) {
                        dk0.h("TYPE_PING streamId != 0");
                        return false;
                    }
                    int i16 = this.a.readInt();
                    int i17 = this.a.readInt();
                    Object[] objArr = (b & 1) != 0 ? 1 : 0;
                    tx0 tx0Var3 = nx0Var.b;
                    if (objArr == 0) {
                        tx0Var3.k.c(new mx0(cq.n(new StringBuilder(), nx0Var.b.c, " ping"), nx0Var.b, i16, i17, 0), 0L);
                        return true;
                    }
                    synchronized (tx0Var3) {
                        try {
                            if (i16 == 1) {
                                tx0Var3.v++;
                            } else if (i16 == 2) {
                                tx0Var3.x++;
                            } else if (i16 == 3) {
                                tx0Var3.notifyAll();
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return true;
                case 7:
                    if (iT < 8) {
                        dk0.h(ky0.h(iT, "TYPE_GOAWAY length < 8: "));
                        return false;
                    }
                    if (i6 != 0) {
                        dk0.h("TYPE_GOAWAY streamId != 0");
                        return false;
                    }
                    int i18 = this.a.readInt();
                    int i19 = this.a.readInt();
                    int i20 = iT - 8;
                    int[] iArrA2 = cq.A(14);
                    int length2 = iArrA2.length;
                    int i21 = 0;
                    while (true) {
                        if (i21 < length2) {
                            i2 = iArrA2[i21];
                            if (cq.x(i2) != i19) {
                                i21++;
                            }
                        } else {
                            i2 = 0;
                        }
                    }
                    if (i2 == 0) {
                        dk0.h(ky0.h(i19, "TYPE_GOAWAY unexpected error code: "));
                        return false;
                    }
                    oo ooVarL = oo.e;
                    if (i20 > 0) {
                        ooVarL = this.a.l(i20);
                    }
                    ooVarL.getClass();
                    ooVarL.c();
                    tx0 tx0Var4 = nx0Var.b;
                    synchronized (tx0Var4) {
                        array = tx0Var4.b.values().toArray(new ay0[0]);
                        tx0Var4.i = true;
                    }
                    for (ay0 ay0Var : (ay0[]) array) {
                        if (ay0Var.a > i18 && ay0Var.g()) {
                            synchronized (ay0Var) {
                                if (ay0Var.m == 0) {
                                    ay0Var.m = 8;
                                    ay0Var.notifyAll();
                                }
                                break;
                            }
                            nx0Var.b.j(ay0Var.a);
                        }
                    }
                    break;
                    break;
                case 8:
                    if (iT != 4) {
                        dk0.h(ky0.h(iT, "TYPE_WINDOW_UPDATE length !=4: "));
                        return false;
                    }
                    long j = 2147483647L & ((long) this.a.readInt());
                    if (j == 0) {
                        dk0.h("windowSizeIncrement was 0");
                        return false;
                    }
                    tx0 tx0Var5 = nx0Var.b;
                    if (i6 == 0) {
                        synchronized (tx0Var5) {
                            tx0Var5.e0 += j;
                            tx0Var5.notifyAll();
                        }
                        return true;
                    }
                    ay0 ay0VarE = tx0Var5.e(i6);
                    if (ay0VarE != null) {
                        synchronized (ay0VarE) {
                            ay0VarE.f += j;
                            if (j > 0) {
                                ay0VarE.notifyAll();
                            }
                            break;
                        }
                        return true;
                    }
                    break;
                default:
                    this.a.skip(iT);
                    return true;
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.close();
    }

    public final void e(nx0 nx0Var, int i, int i2, int i3) throws IOException {
        int i4;
        boolean z;
        boolean z2;
        if (i3 == 0) {
            dk0.h("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
            return;
        }
        boolean z3 = (i2 & 1) != 0;
        if ((i2 & 32) != 0) {
            dk0.h("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
            return;
        }
        if ((i2 & 8) != 0) {
            byte b = this.a.readByte();
            byte[] bArr = z53.a;
            i4 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        } else {
            i4 = 0;
        }
        int iA = oo4.a(i, i2, i4);
        yn ynVar = this.a;
        ynVar.getClass();
        tx0 tx0Var = nx0Var.b;
        if (i3 != 0 && (i3 & 1) == 0) {
            ln lnVar = new ln();
            long j = iA;
            ynVar.F(j);
            ynVar.f(j, lnVar);
            tx0Var.n.c(new ox0(tx0Var.c + '[' + i3 + "] onData", tx0Var, i3, lnVar, iA, z3), 0L);
        } else {
            ay0 ay0VarE = tx0Var.e(i3);
            if (ay0VarE == null) {
                nx0Var.b.v(i3, 2);
                long j2 = iA;
                nx0Var.b.q(j2);
                ynVar.skip(j2);
            } else {
                byte[] bArr2 = z53.a;
                yx0 yx0Var = ay0VarE.i;
                long j3 = iA;
                yx0Var.getClass();
                long j4 = j3;
                while (true) {
                    ay0 ay0Var = yx0Var.i;
                    if (j4 <= 0) {
                        byte[] bArr3 = z53.a;
                        ay0Var.b.q(j3);
                        break;
                    }
                    synchronized (ay0Var) {
                        z = yx0Var.b;
                        z2 = yx0Var.e.b + j4 > yx0Var.a;
                    }
                    if (z2) {
                        ynVar.skip(j4);
                        yx0Var.i.e(4);
                        break;
                    }
                    if (z) {
                        ynVar.skip(j4);
                        break;
                    }
                    long jF = ynVar.f(j4, yx0Var.c);
                    if (jF == -1) {
                        throw new EOFException();
                    }
                    j4 -= jF;
                    ay0 ay0Var2 = yx0Var.i;
                    synchronized (ay0Var2) {
                        try {
                            if (yx0Var.f) {
                                ln lnVar2 = yx0Var.c;
                                lnVar2.skip(lnVar2.b);
                            } else {
                                ln lnVar3 = yx0Var.e;
                                boolean z4 = lnVar3.b == 0;
                                lnVar3.D(yx0Var.c);
                                if (z4) {
                                    ay0Var2.notifyAll();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                if (z3) {
                    ay0VarE.i(z53.b, true);
                }
            }
        }
        this.a.skip(i4);
    }

    public final List j(int i, int i2, int i3, int i4) throws IOException {
        vx0 vx0Var = this.b;
        vx0Var.f = i;
        vx0Var.b = i;
        vx0Var.i = i2;
        vx0Var.c = i3;
        vx0Var.e = i4;
        zw0 zw0Var = this.c;
        i32 i32Var = zw0Var.c;
        ArrayList arrayList = zw0Var.b;
        while (!i32Var.c()) {
            byte b = i32Var.readByte();
            byte[] bArr = z53.a;
            int i5 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            if (i5 == 128) {
                dk0.h("index == 0");
                return null;
            }
            if ((b & Bidi.LEVEL_OVERRIDE) == 128) {
                int iE = zw0Var.e(i5, 127);
                int i6 = iE - 1;
                if (i6 >= 0) {
                    dw0[] dw0VarArr = bx0.a;
                    if (i6 <= dw0VarArr.length - 1) {
                        arrayList.add(dw0VarArr[i6]);
                    }
                }
                int length = zw0Var.e + 1 + (i6 - bx0.a.length);
                if (length >= 0) {
                    dw0[] dw0VarArr2 = zw0Var.d;
                    if (length < dw0VarArr2.length) {
                        dw0 dw0Var = dw0VarArr2[length];
                        dw0Var.getClass();
                        arrayList.add(dw0Var);
                    }
                }
                dk0.h(ky0.h(iE, "Header index too large "));
                return null;
            }
            if (i5 == 64) {
                dw0[] dw0VarArr3 = bx0.a;
                oo ooVarD = zw0Var.d();
                bx0.a(ooVarD);
                zw0Var.c(new dw0(ooVarD, zw0Var.d()));
            } else if ((b & 64) == 64) {
                zw0Var.c(new dw0(zw0Var.b(zw0Var.e(i5, 63) - 1), zw0Var.d()));
            } else if ((b & 32) == 32) {
                int iE2 = zw0Var.e(i5, 31);
                zw0Var.a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + zw0Var.a);
                }
                int i7 = zw0Var.g;
                if (iE2 < i7) {
                    if (iE2 == 0) {
                        dw0[] dw0VarArr4 = zw0Var.d;
                        qg.l(0, dw0VarArr4.length, null, dw0VarArr4);
                        zw0Var.e = zw0Var.d.length - 1;
                        zw0Var.f = 0;
                        zw0Var.g = 0;
                    } else {
                        zw0Var.a(i7 - iE2);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                dw0[] dw0VarArr5 = bx0.a;
                oo ooVarD2 = zw0Var.d();
                bx0.a(ooVarD2);
                arrayList.add(new dw0(ooVarD2, zw0Var.d()));
            } else {
                arrayList.add(new dw0(zw0Var.b(zw0Var.e(i5, 15) - 1), zw0Var.d()));
            }
        }
        List listO = mz.O(arrayList);
        arrayList.clear();
        return listO;
    }

    public final void o(nx0 nx0Var, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 == 0) {
            dk0.h("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
            return;
        }
        boolean z = false;
        int i5 = 1;
        boolean z2 = (i2 & 1) != 0;
        if ((i2 & 8) != 0) {
            byte b = this.a.readByte();
            byte[] bArr = z53.a;
            i4 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        } else {
            i4 = 0;
        }
        if ((i2 & 32) != 0) {
            yn ynVar = this.a;
            ynVar.readInt();
            ynVar.readByte();
            byte[] bArr2 = z53.a;
            i -= 5;
        }
        List listJ = j(oo4.a(i, i2, i4), i4, i2, i3);
        tx0 tx0Var = nx0Var.b;
        if (i3 != 0 && (i3 & 1) == 0) {
            z = true;
        }
        if (z) {
            tx0Var.n.c(new px0(tx0Var.c + '[' + i3 + "] onHeaders", tx0Var, i3, listJ, z2), 0L);
            return;
        }
        synchronized (tx0Var) {
            ay0 ay0VarE = tx0Var.e(i3);
            if (ay0VarE != null) {
                ay0VarE.i(z53.v(listJ), z2);
                return;
            }
            if (tx0Var.i) {
                return;
            }
            if (i3 <= tx0Var.e) {
                return;
            }
            if (i3 % 2 == tx0Var.f % 2) {
                return;
            }
            ay0 ay0Var = new ay0(i3, tx0Var, false, z2, z53.v(listJ));
            tx0Var.e = i3;
            tx0Var.b.put(Integer.valueOf(i3), ay0Var);
            tx0Var.j.e().c(new lx0(i5, tx0Var.c + '[' + i3 + "] onStream", tx0Var, ay0Var), 0L);
        }
    }

    public final void q(nx0 nx0Var, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 == 0) {
            dk0.h("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
            return;
        }
        if ((i2 & 8) != 0) {
            byte b = this.a.readByte();
            byte[] bArr = z53.a;
            i4 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        } else {
            i4 = 0;
        }
        int i5 = this.a.readInt() & Integer.MAX_VALUE;
        List listJ = j(oo4.a(i - 4, i2, i4), i4, i2, i3);
        tx0 tx0Var = nx0Var.b;
        synchronized (tx0Var) {
            if (tx0Var.i0.contains(Integer.valueOf(i5))) {
                tx0Var.v(i5, 2);
                return;
            }
            tx0Var.i0.add(Integer.valueOf(i5));
            tx0Var.n.c(new px0(tx0Var.c + '[' + i5 + "] onRequest", tx0Var, i5, listJ), 0L);
        }
    }
}
