package defpackage;

import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.text.DateTimePatternGenerator;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x32 {
    public static final List w = nz.h(y12.HTTP_1_1);
    public final cj a;
    public final Random b;
    public final long c;
    public v93 d;
    public final long e;
    public final String f;
    public m32 g;
    public w32 h;
    public w93 i;
    public x93 j;
    public final lw2 k;
    public String l;
    public p32 m;
    public final ArrayDeque n;
    public final ArrayDeque o;
    public long p;
    public boolean q;
    public int r;
    public String s;
    public boolean t;
    public int u;
    public boolean v;

    public x32(mw2 mw2Var, lj1 lj1Var, cj cjVar, Random random, long j, long j2) {
        mw2Var.getClass();
        this.a = cjVar;
        this.b = random;
        this.c = j;
        this.d = null;
        this.e = j2;
        this.k = mw2Var.e();
        this.n = new ArrayDeque();
        this.o = new ArrayDeque();
        this.r = -1;
        String str = (String) lj1Var.c;
        if (!"GET".equals(str)) {
            og.g(cq.j("Request must be GET: ", str));
            throw null;
        }
        oo ooVar = oo.e;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f = nr4.o(bArr).a();
    }

    public final void a(z62 z62Var, ux uxVar) {
        int i = z62Var.e;
        if (i != 101) {
            StringBuilder sb = new StringBuilder("Expected HTTP 101 response but was '");
            sb.append(i);
            sb.append(' ');
            throw new ProtocolException(ky0.n(sb, z62Var.c, PatternTokenizer.SINGLE_QUOTE));
        }
        String strC = z62.c(z62Var, "Connection");
        if (!"Upgrade".equalsIgnoreCase(strC)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strC + PatternTokenizer.SINGLE_QUOTE);
        }
        String strC2 = z62.c(z62Var, "Upgrade");
        if (!"websocket".equalsIgnoreCase(strC2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strC2 + PatternTokenizer.SINGLE_QUOTE);
        }
        String strC3 = z62.c(z62Var, "Sec-WebSocket-Accept");
        oo ooVar = oo.e;
        String strA = nr4.m(this.f + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").b("SHA-1").a();
        if (g31.a(strA, strC3)) {
            if (uxVar == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA + "' but was '" + strC3 + PatternTokenizer.SINGLE_QUOTE);
    }

    public final void b(int i, String str) {
        String str2;
        synchronized (this) {
            oo ooVarM = null;
            try {
                if (i < 1000 || i >= 5000) {
                    str2 = "Code must be in range [1000,5000): " + i;
                } else if ((1004 > i || i >= 1007) && (1015 > i || i >= 3000)) {
                    str2 = null;
                } else {
                    str2 = "Code " + i + " is reserved and may not be used.";
                }
                if (str2 != null) {
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    oo ooVar = oo.e;
                    ooVarM = nr4.m(str);
                    if (ooVarM.a.length > 123) {
                        throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                    }
                }
                if (!this.t && !this.q) {
                    this.q = true;
                    this.o.add(new u32(i, ooVarM));
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Exception exc, z62 z62Var) {
        synchronized (this) {
            if (this.t) {
                return;
            }
            this.t = true;
            p32 p32Var = this.m;
            this.m = null;
            w93 w93Var = this.i;
            this.i = null;
            x93 x93Var = this.j;
            this.j = null;
            this.k.e();
            try {
                this.a.z(this, exc, z62Var);
            } finally {
                if (p32Var != null) {
                    z53.d(p32Var);
                }
                if (w93Var != null) {
                    z53.d(w93Var);
                }
                if (x93Var != null) {
                    z53.d(x93Var);
                }
            }
        }
    }

    public final void d(String str, p32 p32Var) {
        x32 x32Var;
        v93 v93Var = this.d;
        v93Var.getClass();
        synchronized (this) {
            try {
                this.l = str;
                this.m = p32Var;
                this.j = new x93(p32Var.b, this.b, v93Var.a, v93Var.c, this.e);
                this.h = new w32(this);
                long j = this.c;
                if (j != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                    x32Var = this;
                    try {
                        this.k.c(new rx0(str.concat(" ping"), x32Var, nanos, 1), nanos);
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        throw th2;
                    }
                } else {
                    x32Var = this;
                }
                if (!x32Var.o.isEmpty()) {
                    x32Var.f();
                }
                x32Var.i = new w93(p32Var.a, x32Var, v93Var.a, v93Var.e);
            } catch (Throwable th3) {
                th = th3;
                x32Var = this;
            }
        }
    }

    public final void e() {
        while (this.r == -1) {
            w93 w93Var = this.i;
            w93Var.getClass();
            w93Var.e();
            if (w93Var.n) {
                w93Var.c();
            } else {
                ln lnVar = w93Var.u;
                int i = w93Var.i;
                if (i != 1 && i != 2) {
                    byte[] bArr = z53.a;
                    String hexString = Integer.toHexString(i);
                    hexString.getClass();
                    throw new ProtocolException("Unknown opcode: ".concat(hexString));
                }
                while (true) {
                    if (!w93Var.f) {
                        long j = w93Var.j;
                        if (j > 0) {
                            w93Var.a.i(j, lnVar);
                        }
                        if (w93Var.k) {
                            if (w93Var.s) {
                                mi1 mi1Var = w93Var.v;
                                if (mi1Var == null) {
                                    mi1Var = new mi1(w93Var.e, 1);
                                    w93Var.v = mi1Var;
                                }
                                Inflater inflater = (Inflater) mi1Var.e;
                                ln lnVar2 = mi1Var.c;
                                if (lnVar2.b != 0) {
                                    og.i("Failed requirement.");
                                    return;
                                }
                                if (mi1Var.b) {
                                    inflater.reset();
                                }
                                lnVar2.D(lnVar);
                                lnVar2.K(DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH);
                                long bytesRead = inflater.getBytesRead() + lnVar2.b;
                                do {
                                    ((u01) mi1Var.f).c(Long.MAX_VALUE, lnVar);
                                } while (inflater.getBytesRead() < bytesRead);
                            }
                            x32 x32Var = w93Var.b;
                            if (i != 1) {
                                oo ooVarL = lnVar.l(lnVar.b);
                                x32Var.getClass();
                                ooVarL.getClass();
                                x32Var.a.d(ooVarL.j());
                                break;
                            }
                            String strW = lnVar.w();
                            x32Var.getClass();
                            x32Var.a.d(strW);
                            break;
                        }
                        while (!w93Var.f) {
                            w93Var.e();
                            if (!w93Var.n) {
                                break;
                            } else {
                                w93Var.c();
                            }
                        }
                        if (w93Var.i != 0) {
                            int i2 = w93Var.i;
                            byte[] bArr2 = z53.a;
                            String hexString2 = Integer.toHexString(i2);
                            hexString2.getClass();
                            throw new ProtocolException("Expected continuation opcode. Got: ".concat(hexString2));
                        }
                    } else {
                        dk0.h("closed");
                        return;
                    }
                }
            }
        }
    }

    public final void f() {
        byte[] bArr = z53.a;
        w32 w32Var = this.h;
        if (w32Var != null) {
            this.k.c(w32Var, 0L);
        }
    }

    public final boolean g(String str) {
        oo ooVar = oo.e;
        oo ooVarM = nr4.m(str);
        synchronized (this) {
            if (!this.t && !this.q) {
                long j = this.p;
                byte[] bArr = ooVarM.a;
                if (((long) bArr.length) + j > 16777216) {
                    b(1001, null);
                    return false;
                }
                this.p = j + ((long) bArr.length);
                this.o.add(new v32(ooVarM));
                f();
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x006f A[Catch: all -> 0x007b, TRY_ENTER, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007e A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0082 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x009e A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e1 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f2 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0106 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0118 A[Catch: all -> 0x007b, TRY_LEAVE, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0128  */
    /* JADX WARN: Code duplicated, block: B:80:0x012d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0132  */
    /* JADX WARN: Code duplicated, block: B:87:0x013a A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:29:0x006f, B:32:0x007e, B:34:0x0082, B:35:0x008c, B:37:0x0098, B:40:0x009c, B:41:0x009d, B:42:0x009e, B:44:0x00a2, B:74:0x0114, B:76:0x0118, B:85:0x0137, B:86:0x0139, B:62:0x00cd, B:66:0x00f2, B:67:0x00fb, B:63:0x00e1, B:68:0x00fc, B:70:0x0106, B:71:0x0109, B:87:0x013a, B:88:0x013f, B:73:0x0111, B:36:0x008d), top: B:103:0x006d, inners: #0, #2 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:63:0x00e1, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v6 */
    public final boolean h() {
        p32 p32Var;
        Object objPoll;
        String str;
        String str2;
        ?? r7;
        ?? r6;
        int i;
        oo ooVar;
        oo ooVarL;
        ln lnVar;
        v32 v32Var;
        synchronized (this) {
            try {
                if (this.t) {
                    return false;
                }
                x93 x93Var = this.j;
                Object objPoll2 = this.n.poll();
                String str3 = null;
                try {
                    if (objPoll2 == null) {
                        objPoll = this.o.poll();
                        if (objPoll instanceof u32) {
                            int i2 = this.r;
                            str = this.s;
                            if (i2 != -1) {
                                p32Var = this.m;
                                this.m = null;
                                w93 w93Var = this.i;
                                this.i = null;
                                x93 x93Var2 = this.j;
                                this.j = null;
                                this.k.e();
                                r6 = w93Var;
                                r7 = x93Var2;
                            } else {
                                this.k.c(new w32(this.l + " cancel", this), 60000000000L);
                                p32Var = null;
                                str2 = null;
                                r7 = str2;
                                r6 = str2;
                            }
                        } else {
                            if (objPoll == null) {
                                return false;
                            }
                            p32Var = null;
                            str = null;
                        }
                        if (objPoll2 != null) {
                            x93Var.getClass();
                            x93Var.c(10, (oo) objPoll2);
                        } else if (objPoll instanceof v32) {
                            v32Var = (v32) objPoll;
                            x93Var.getClass();
                            x93Var.e(v32Var.a);
                            synchronized (this) {
                                this.p -= (long) v32Var.a.a.length;
                            }
                        } else {
                            if (objPoll instanceof u32) {
                                throw new AssertionError();
                            }
                            u32 u32Var = (u32) objPoll;
                            x93Var.getClass();
                            i = u32Var.a;
                            ooVar = u32Var.b;
                            ooVarL = oo.e;
                            if (i == 0 || ooVar != null) {
                                if (i != 0) {
                                    if (i >= 1000 || i >= 5000) {
                                        str3 = "Code must be in range [1000,5000): " + i;
                                    } else if ((1004 <= i && i < 1007) || (1015 <= i && i < 3000)) {
                                        str3 = "Code " + i + " is reserved and may not be used.";
                                    }
                                    if (str3 != null) {
                                        throw new IllegalArgumentException(str3.toString());
                                    }
                                }
                                lnVar = new ln();
                                lnVar.L(i);
                                if (ooVar != null) {
                                    lnVar.A(ooVar);
                                }
                                ooVarL = lnVar.l(lnVar.b);
                            }
                            try {
                                x93Var.c(8, ooVarL);
                                x93Var.k = true;
                                if (p32Var != null) {
                                    cj cjVar = this.a;
                                    str.getClass();
                                    ((x00) cjVar.f).b0(q43.a);
                                }
                            } catch (Throwable th) {
                                x93Var.k = true;
                                throw th;
                            }
                        }
                        if (p32Var != null) {
                            z53.d(p32Var);
                        }
                        if (r6 != 0) {
                            z53.d(r6);
                        }
                        if (r7 != 0) {
                            z53.d(r7);
                        }
                        return true;
                    }
                    p32Var = null;
                    objPoll = null;
                    str = null;
                    if (objPoll2 != null) {
                        x93Var.getClass();
                        x93Var.c(10, (oo) objPoll2);
                    } else if (objPoll instanceof v32) {
                        v32Var = (v32) objPoll;
                        x93Var.getClass();
                        x93Var.e(v32Var.a);
                        synchronized (this) {
                            this.p -= (long) v32Var.a.a.length;
                        }
                    } else {
                        if (objPoll instanceof u32) {
                            throw new AssertionError();
                        }
                        u32 u32Var2 = (u32) objPoll;
                        x93Var.getClass();
                        i = u32Var2.a;
                        ooVar = u32Var2.b;
                        ooVarL = oo.e;
                        if (i == 0) {
                            if (i != 0) {
                                if (i >= 1000) {
                                    str3 = "Code must be in range [1000,5000): " + i;
                                } else {
                                    str3 = "Code must be in range [1000,5000): " + i;
                                }
                                if (str3 != null) {
                                    throw new IllegalArgumentException(str3.toString());
                                }
                            }
                            lnVar = new ln();
                            lnVar.L(i);
                            if (ooVar != null) {
                                lnVar.A(ooVar);
                            }
                            ooVarL = lnVar.l(lnVar.b);
                        } else {
                            if (i != 0) {
                                if (i >= 1000) {
                                    str3 = "Code must be in range [1000,5000): " + i;
                                } else {
                                    str3 = "Code must be in range [1000,5000): " + i;
                                }
                                if (str3 != null) {
                                    throw new IllegalArgumentException(str3.toString());
                                }
                            }
                            lnVar = new ln();
                            lnVar.L(i);
                            if (ooVar != null) {
                                lnVar.A(ooVar);
                            }
                            ooVarL = lnVar.l(lnVar.b);
                        }
                        x93Var.c(8, ooVarL);
                        x93Var.k = true;
                        if (p32Var != null) {
                            cj cjVar2 = this.a;
                            str.getClass();
                            ((x00) cjVar2.f).b0(q43.a);
                        }
                    }
                    if (p32Var != null) {
                        z53.d(p32Var);
                    }
                    if (r6 != 0) {
                        z53.d(r6);
                    }
                    if (r7 != 0) {
                        z53.d(r7);
                    }
                    return true;
                } catch (Throwable th2) {
                    if (p32Var != null) {
                        z53.d(p32Var);
                    }
                    if (r6 != 0) {
                        z53.d(r6);
                    }
                    if (r7 != 0) {
                        z53.d(r7);
                    }
                    throw th2;
                }
                str2 = str;
                r7 = str2;
                r6 = str2;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
