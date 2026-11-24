package defpackage;

import com.ibm.icu.text.Bidi;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w93 implements Closeable {
    public final yn a;
    public final x32 b;
    public final boolean c;
    public final boolean e;
    public boolean f;
    public int i;
    public long j;
    public boolean k;
    public boolean n;
    public boolean s;
    public final ln t;
    public final ln u;
    public mi1 v;
    public final byte[] w;

    public w93(yn ynVar, x32 x32Var, boolean z, boolean z2) {
        ynVar.getClass();
        x32Var.getClass();
        this.a = ynVar;
        this.b = x32Var;
        this.c = z;
        this.e = z2;
        this.t = new ln();
        this.u = new ln();
        this.w = null;
    }

    public final void c() throws ProtocolException, EOFException {
        String strW;
        short s;
        w93 w93Var;
        x93 x93Var;
        String strH;
        long j = this.j;
        if (j > 0) {
            this.a.i(j, this.t);
        }
        switch (this.i) {
            case 8:
                ln lnVar = this.t;
                long j2 = lnVar.b;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                p32 p32Var = null;
                if (j2 != 0) {
                    s = lnVar.readShort();
                    strW = this.t.w();
                    if (s < 1000 || s >= 5000) {
                        strH = ky0.h(s, "Code must be in range [1000,5000): ");
                    } else {
                        strH = ((1004 > s || s >= 1007) && (1015 > s || s >= 3000)) ? null : cq.h("Code ", s, " is reserved and may not be used.");
                    }
                    if (strH != null) {
                        throw new ProtocolException(strH);
                    }
                } else {
                    strW = "";
                    s = 1005;
                }
                x32 x32Var = this.b;
                x32Var.getClass();
                if (s == -1) {
                    og.i("Failed requirement.");
                    return;
                }
                synchronized (x32Var) {
                    if (x32Var.r != -1) {
                        throw new IllegalStateException("already closed");
                    }
                    x32Var.r = s;
                    x32Var.s = strW;
                    if (x32Var.q && x32Var.o.isEmpty()) {
                        p32 p32Var2 = x32Var.m;
                        x32Var.m = null;
                        w93Var = x32Var.i;
                        x32Var.i = null;
                        x93Var = x32Var.j;
                        x32Var.j = null;
                        x32Var.k.e();
                        p32Var = p32Var2;
                    } else {
                        w93Var = null;
                        x93Var = null;
                    }
                }
                try {
                    x32Var.a.y(x32Var, s, strW);
                    if (p32Var != null) {
                        ((x00) x32Var.a.f).b0(q43.a);
                        break;
                    }
                    if (p32Var != null) {
                        z53.d(p32Var);
                    }
                    if (w93Var != null) {
                        z53.d(w93Var);
                    }
                    if (x93Var != null) {
                        z53.d(x93Var);
                    }
                    this.f = true;
                    return;
                } catch (Throwable th) {
                    if (p32Var != null) {
                        z53.d(p32Var);
                    }
                    if (w93Var != null) {
                        z53.d(w93Var);
                    }
                    if (x93Var != null) {
                        z53.d(x93Var);
                    }
                    throw th;
                }
            case 9:
                x32 x32Var2 = this.b;
                ln lnVar2 = this.t;
                oo ooVarL = lnVar2.l(lnVar2.b);
                synchronized (x32Var2) {
                    try {
                        ooVarL.getClass();
                        if (!x32Var2.t && (!x32Var2.q || !x32Var2.o.isEmpty())) {
                            x32Var2.n.add(ooVarL);
                            x32Var2.f();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            case 10:
                x32 x32Var3 = this.b;
                ln lnVar3 = this.t;
                oo ooVarL2 = lnVar3.l(lnVar3.b);
                synchronized (x32Var3) {
                    ooVarL2.getClass();
                    x32Var3.v = false;
                }
                return;
            default:
                int i = this.i;
                byte[] bArr = z53.a;
                String hexString = Integer.toHexString(i);
                hexString.getClass();
                throw new ProtocolException("Unknown control opcode: ".concat(hexString));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        mi1 mi1Var = this.v;
        if (mi1Var != null) {
            mi1Var.close();
        }
    }

    public final void e() throws IOException {
        boolean z;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (this.f) {
            dk0.h("closed");
            return;
        }
        yn ynVar = this.a;
        long jH = ynVar.d().h();
        ynVar.d().b();
        try {
            byte b = ynVar.readByte();
            byte[] bArr = z53.a;
            ynVar.d().g(jH, timeUnit);
            int i = b & 15;
            this.i = i;
            boolean z2 = (b & Bidi.LEVEL_OVERRIDE) != 0;
            this.k = z2;
            boolean z3 = (b & 8) != 0;
            this.n = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (b & 64) != 0;
            if (i == 1 || i == 2) {
                if (!z4) {
                    z = false;
                } else {
                    if (!this.c) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.s = z;
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((b & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((b & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            byte b2 = ynVar.readByte();
            boolean z5 = (b2 & Bidi.LEVEL_OVERRIDE) != 0;
            if (z5) {
                throw new ProtocolException("Server-sent frames must not be masked.");
            }
            long j = b2 & Bidi.LEVEL_DEFAULT_RTL;
            this.j = j;
            if (j == 126) {
                this.j = ynVar.readShort() & 65535;
            } else if (j == 127) {
                long j2 = ynVar.readLong();
                this.j = j2;
                if (j2 < 0) {
                    String hexString = Long.toHexString(this.j);
                    hexString.getClass();
                    throw new ProtocolException("Frame length 0x" + hexString + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.n && this.j > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                byte[] bArr2 = this.w;
                bArr2.getClass();
                ynVar.readFully(bArr2);
            }
        } catch (Throwable th) {
            ynVar.d().g(jH, timeUnit);
            throw th;
        }
    }
}
