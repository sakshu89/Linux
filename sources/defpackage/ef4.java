package defpackage;

import android.os.Build;
import android.view.View;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;
import com.project.sonic.R;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ef4 {
    /* JADX WARN: Code duplicated, block: B:101:0x0115  */
    /* JADX WARN: Code duplicated, block: B:103:0x0139  */
    /* JADX WARN: Code duplicated, block: B:105:0x0143  */
    /* JADX WARN: Code duplicated, block: B:111:0x014f  */
    /* JADX WARN: Code duplicated, block: B:113:0x015a  */
    /* JADX WARN: Code duplicated, block: B:114:0x015c  */
    /* JADX WARN: Code duplicated, block: B:118:0x016e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0194  */
    /* JADX WARN: Code duplicated, block: B:124:0x0197 A[Catch: RejectedExecutionException -> 0x0195, TryCatch #2 {RejectedExecutionException -> 0x0195, blocks: (B:120:0x018e, B:128:0x019e, B:130:0x01b0, B:136:0x01bd, B:138:0x01cf, B:142:0x01d6, B:132:0x01b6, B:124:0x0197), top: B:171:0x018e }] */
    /* JADX WARN: Code duplicated, block: B:126:0x019b  */
    /* JADX WARN: Code duplicated, block: B:127:0x019d  */
    /* JADX WARN: Code duplicated, block: B:130:0x01b0 A[Catch: RejectedExecutionException -> 0x0195, TryCatch #2 {RejectedExecutionException -> 0x0195, blocks: (B:120:0x018e, B:128:0x019e, B:130:0x01b0, B:136:0x01bd, B:138:0x01cf, B:142:0x01d6, B:132:0x01b6, B:124:0x0197), top: B:171:0x018e }] */
    /* JADX WARN: Code duplicated, block: B:132:0x01b6 A[Catch: RejectedExecutionException -> 0x0195, TryCatch #2 {RejectedExecutionException -> 0x0195, blocks: (B:120:0x018e, B:128:0x019e, B:130:0x01b0, B:136:0x01bd, B:138:0x01cf, B:142:0x01d6, B:132:0x01b6, B:124:0x0197), top: B:171:0x018e }] */
    /* JADX WARN: Code duplicated, block: B:138:0x01cf A[Catch: RejectedExecutionException -> 0x0195, TryCatch #2 {RejectedExecutionException -> 0x0195, blocks: (B:120:0x018e, B:128:0x019e, B:130:0x01b0, B:136:0x01bd, B:138:0x01cf, B:142:0x01d6, B:132:0x01b6, B:124:0x0197), top: B:171:0x018e }] */
    /* JADX WARN: Code duplicated, block: B:142:0x01d6 A[Catch: RejectedExecutionException -> 0x0195, TRY_LEAVE, TryCatch #2 {RejectedExecutionException -> 0x0195, blocks: (B:120:0x018e, B:128:0x019e, B:130:0x01b0, B:136:0x01bd, B:138:0x01cf, B:142:0x01d6, B:132:0x01b6, B:124:0x0197), top: B:171:0x018e }] */
    /* JADX WARN: Code duplicated, block: B:152:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:156:0x0236  */
    /* JADX WARN: Code duplicated, block: B:157:0x023a  */
    /* JADX WARN: Code duplicated, block: B:159:0x025f  */
    /* JADX WARN: Code duplicated, block: B:161:0x0263  */
    /* JADX WARN: Code duplicated, block: B:164:0x026f  */
    /* JADX WARN: Code duplicated, block: B:171:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x007d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0081  */
    /* JADX WARN: Code duplicated, block: B:51:0x0084  */
    /* JADX WARN: Code duplicated, block: B:53:0x008c  */
    /* JADX WARN: Code duplicated, block: B:54:0x008f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0097  */
    /* JADX WARN: Code duplicated, block: B:60:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:81:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:92:0x00ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0101  */
    /* JADX WARN: Code duplicated, block: B:95:0x0104  */
    /* JADX WARN: Code duplicated, block: B:97:0x0107  */
    /* JADX WARN: Code duplicated, block: B:98:0x0109  */
    public static final void a(final String str, final ek1 ek1Var, final yz2 yz2Var, int i, boolean z, final int i2, int i3, x20 x20Var, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean zH;
        int i14;
        boolean z3;
        final int i15;
        final int i16;
        final boolean z4;
        a42 a42VarR;
        int i17;
        qo0 qo0Var;
        int i18;
        Executor executor;
        boolean z5;
        fq0 fq0Var;
        Boolean bool;
        z61 z61Var;
        Object obj;
        boolean z6;
        boolean zD;
        Object objL;
        boolean z7;
        int i19;
        x20Var.X(-1040751001);
        if ((i4 & 6) == 0) {
            i6 = (x20Var.f(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= x20Var.f(ek1Var) ? 32 : 16;
        }
        if ((i4 & CollationFastLatin.LATIN_LIMIT) == 0) {
            i6 |= x20Var.f(yz2Var) ? 256 : 128;
        }
        if ((i5 & 8) != 0) {
            i6 |= UCharacterProperty.SCRIPT_X_WITH_OTHER;
        } else if ((i4 & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i6 |= x20Var.h(null) ? 2048 : 1024;
        }
        int i20 = i5 & 16;
        if (i20 == 0) {
            if ((i4 & 24576) == 0) {
                i7 = i;
                i6 |= x20Var.d(i7) ? 16384 : 8192;
            }
            i8 = i5 & 32;
            if (i8 != 0) {
                if ((196608 & i4) == 0) {
                    z2 = z;
                    if (x20Var.g(z2)) {
                        i9 = Normalizer.INPUT_IS_FCD;
                    } else {
                        i9 = 65536;
                    }
                    i6 |= i9;
                }
                if ((1572864 & i4) == 0) {
                    if (x20Var.d(i2)) {
                        i19 = 1048576;
                    } else {
                        i19 = ArabicShaping.TASHKEEL_RESIZE;
                    }
                    i6 |= i19;
                }
                i10 = i5 & 128;
                if (i10 != 0) {
                    i6 |= 12582912;
                    i11 = i3;
                } else {
                    i11 = i3;
                    if ((i4 & 12582912) == 0) {
                        if (x20Var.d(i11)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i6 |= i12;
                    }
                }
                i13 = i6 | 100663296;
                if ((i5 & 512) != 0) {
                    i13 = i6 | 905969664;
                } else if ((805306368 & i4) == 0) {
                    if ((1073741824 & i4) == 0) {
                        zH = x20Var.f(null);
                    } else {
                        zH = x20Var.h(null);
                    }
                    if (zH) {
                        i14 = 536870912;
                    } else {
                        i14 = 268435456;
                    }
                    i13 |= i14;
                }
                if ((i13 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (x20Var.O(i13 & 1, z3)) {
                    if (i20 != 0) {
                        i7 = 1;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        i17 = 1;
                    } else {
                        i17 = i11;
                    }
                    lo4.a(i17, i2);
                    if (x20Var.j(ag2.a) == null) {
                        dk0.t();
                        return;
                    }
                    x20Var.W(356914239);
                    x20Var.p(false);
                    qo0Var = (qo0) x20Var.j(l30.k);
                    i18 = (i13 & 14) | ((i13 >> 3) & 112);
                    executor = (Executor) x20Var.j(cl.a);
                    if (executor != null) {
                        int length = str.length();
                        if (Build.VERSION.SDK_INT >= 28 && length >= 8 && length < 1000) {
                            if (cl.b == null) {
                                if (Runtime.getRuntime().availableProcessors() >= 4) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                cl.b = Boolean.valueOf(z7);
                            }
                            bool = cl.b;
                            bool.getClass();
                            if (bool.booleanValue()) {
                                x20Var.W(1254274527);
                                z61Var = (z61) x20Var.j(l30.n);
                                obj = (jc0) x20Var.j(l30.h);
                                if (((i18 & 112) ^ 48) > 32) {
                                    try {
                                        if (!x20Var.f(yz2Var)) {
                                            z6 = true;
                                        } else if ((i18 & 48) == 32) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        zD = z6 | x20Var.d(z61Var.ordinal()) | ((((i18 & 14) ^ 6) <= 4 && x20Var.f(str)) || (i18 & 6) == 4) | x20Var.f(obj) | x20Var.h(qo0Var);
                                        objL = x20Var.L();
                                        if (!zD || objL == r20.a) {
                                            z5 = false;
                                            try {
                                                Object blVar = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                                qo0Var = qo0Var;
                                                try {
                                                    x20Var.g0(blVar);
                                                    objL = blVar;
                                                } catch (RejectedExecutionException unused) {
                                                }
                                            } catch (RejectedExecutionException unused2) {
                                                qo0Var = qo0Var;
                                            }
                                        } else {
                                            z5 = false;
                                        }
                                        executor.execute((Runnable) objL);
                                    } catch (RejectedExecutionException unused3) {
                                        z5 = false;
                                    }
                                } else {
                                    if ((i18 & 48) == 32) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    zD = z6 | x20Var.d(z61Var.ordinal()) | ((((i18 & 14) ^ 6) <= 4 && x20Var.f(str)) || (i18 & 6) == 4) | x20Var.f(obj) | x20Var.h(qo0Var);
                                    objL = x20Var.L();
                                    if (zD) {
                                        z5 = false;
                                        Object blVar2 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                        qo0Var = qo0Var;
                                        x20Var.g0(blVar2);
                                        objL = blVar2;
                                        executor.execute((Runnable) objL);
                                    } else {
                                        z5 = false;
                                        Object blVar3 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                        qo0Var = qo0Var;
                                        x20Var.g0(blVar3);
                                        objL = blVar3;
                                        executor.execute((Runnable) objL);
                                    }
                                }
                            }
                            x20Var.p(z5);
                            x20Var.W(357875859);
                            x20Var.p(z5);
                            i16 = i7;
                            i15 = i17;
                            z4 = z2;
                            ek1 ek1VarC = ek1Var.c(new uz2(str, yz2Var, qo0Var, i16, z4, i2, i15));
                            eb ebVar = eb.d;
                            int iHashCode = Long.hashCode(x20Var.T);
                            ek1 ek1VarC2 = gj4.c(x20Var, ek1VarC);
                            gw1 gw1VarL = x20Var.l();
                            o20.p.getClass();
                            fq0Var = n20.b;
                            x20Var.Z();
                            if (x20Var.S) {
                                x20Var.k(fq0Var);
                            } else {
                                x20Var.j0();
                            }
                            ie4.c(x20Var, n20.f, ebVar);
                            ie4.c(x20Var, n20.e, gw1VarL);
                            ie4.b(x20Var, n20.h);
                            ie4.c(x20Var, n20.d, ek1VarC2);
                            ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
                            x20Var.p(true);
                        }
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                    x20Var.W(1250991751);
                    x20Var.p(z5);
                    x20Var.W(357875859);
                    x20Var.p(z5);
                    i16 = i7;
                    i15 = i17;
                    z4 = z2;
                    ek1 ek1VarC3 = ek1Var.c(new uz2(str, yz2Var, qo0Var, i16, z4, i2, i15));
                    eb ebVar2 = eb.d;
                    int iHashCode2 = Long.hashCode(x20Var.T);
                    ek1 ek1VarC4 = gj4.c(x20Var, ek1VarC3);
                    gw1 gw1VarL2 = x20Var.l();
                    o20.p.getClass();
                    fq0Var = n20.b;
                    x20Var.Z();
                    if (x20Var.S) {
                        x20Var.k(fq0Var);
                    } else {
                        x20Var.j0();
                    }
                    ie4.c(x20Var, n20.f, ebVar2);
                    ie4.c(x20Var, n20.e, gw1VarL2);
                    ie4.b(x20Var, n20.h);
                    ie4.c(x20Var, n20.d, ek1VarC4);
                    ie4.a(x20Var, Integer.valueOf(iHashCode2), n20.g);
                    x20Var.p(true);
                } else {
                    x20Var.R();
                    i15 = i11;
                    i16 = i7;
                    z4 = z2;
                }
                a42VarR = x20Var.r();
                if (a42VarR != null) {
                    a42VarR.d = new vq0() { // from class: al
                        @Override // defpackage.vq0
                        public final Object e(Object obj2, Object obj3) {
                            ((Integer) obj3).getClass();
                            ef4.a(str, ek1Var, yz2Var, i16, z4, i2, i15, (x20) obj2, ny3.c(i4 | 1), i5);
                            return q43.a;
                        }
                    };
                }
            }
            i6 |= 196608;
            z2 = z;
            if ((1572864 & i4) == 0) {
                if (x20Var.d(i2)) {
                    i19 = 1048576;
                } else {
                    i19 = ArabicShaping.TASHKEEL_RESIZE;
                }
                i6 |= i19;
            }
            i10 = i5 & 128;
            if (i10 != 0) {
                i6 |= 12582912;
                i11 = i3;
            } else {
                i11 = i3;
                if ((i4 & 12582912) == 0) {
                    if (x20Var.d(i11)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i6 |= i12;
                }
            }
            i13 = i6 | 100663296;
            if ((i5 & 512) != 0) {
                i13 = i6 | 905969664;
            } else if ((805306368 & i4) == 0) {
                if ((1073741824 & i4) == 0) {
                    zH = x20Var.f(null);
                } else {
                    zH = x20Var.h(null);
                }
                if (zH) {
                    i14 = 536870912;
                } else {
                    i14 = 268435456;
                }
                i13 |= i14;
            }
            if ((i13 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (x20Var.O(i13 & 1, z3)) {
                if (i20 != 0) {
                    i7 = 1;
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if (i10 != 0) {
                    i17 = 1;
                } else {
                    i17 = i11;
                }
                lo4.a(i17, i2);
                if (x20Var.j(ag2.a) == null) {
                    dk0.t();
                    return;
                }
                x20Var.W(356914239);
                x20Var.p(false);
                qo0Var = (qo0) x20Var.j(l30.k);
                i18 = (i13 & 14) | ((i13 >> 3) & 112);
                executor = (Executor) x20Var.j(cl.a);
                if (executor != null) {
                    int length2 = str.length();
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (cl.b == null) {
                            if (Runtime.getRuntime().availableProcessors() >= 4) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            cl.b = Boolean.valueOf(z7);
                        }
                        bool = cl.b;
                        bool.getClass();
                        if (bool.booleanValue()) {
                            x20Var.W(1254274527);
                            z61Var = (z61) x20Var.j(l30.n);
                            obj = (jc0) x20Var.j(l30.h);
                            if (((i18 & 112) ^ 48) > 32) {
                                if (!x20Var.f(yz2Var)) {
                                    z6 = true;
                                } else if ((i18 & 48) == 32) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                zD = z6 | x20Var.d(z61Var.ordinal()) | ((((i18 & 14) ^ 6) <= 4 && x20Var.f(str)) || (i18 & 6) == 4) | x20Var.f(obj) | x20Var.h(qo0Var);
                                objL = x20Var.L();
                                if (zD) {
                                    z5 = false;
                                    Object blVar4 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                    qo0Var = qo0Var;
                                    x20Var.g0(blVar4);
                                    objL = blVar4;
                                    executor.execute((Runnable) objL);
                                } else {
                                    z5 = false;
                                    Object blVar5 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                    qo0Var = qo0Var;
                                    x20Var.g0(blVar5);
                                    objL = blVar5;
                                    executor.execute((Runnable) objL);
                                }
                            } else {
                                if ((i18 & 48) == 32) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                zD = z6 | x20Var.d(z61Var.ordinal()) | ((((i18 & 14) ^ 6) <= 4 && x20Var.f(str)) || (i18 & 6) == 4) | x20Var.f(obj) | x20Var.h(qo0Var);
                                objL = x20Var.L();
                                if (zD) {
                                    z5 = false;
                                    Object blVar6 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                    qo0Var = qo0Var;
                                    x20Var.g0(blVar6);
                                    objL = blVar6;
                                    executor.execute((Runnable) objL);
                                } else {
                                    z5 = false;
                                    Object blVar7 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                    qo0Var = qo0Var;
                                    x20Var.g0(blVar7);
                                    objL = blVar7;
                                    executor.execute((Runnable) objL);
                                }
                            }
                        }
                        x20Var.p(z5);
                        x20Var.W(357875859);
                        x20Var.p(z5);
                        i16 = i7;
                        i15 = i17;
                        z4 = z2;
                        ek1 ek1VarC5 = ek1Var.c(new uz2(str, yz2Var, qo0Var, i16, z4, i2, i15));
                        eb ebVar3 = eb.d;
                        int iHashCode3 = Long.hashCode(x20Var.T);
                        ek1 ek1VarC6 = gj4.c(x20Var, ek1VarC5);
                        gw1 gw1VarL3 = x20Var.l();
                        o20.p.getClass();
                        fq0Var = n20.b;
                        x20Var.Z();
                        if (x20Var.S) {
                            x20Var.k(fq0Var);
                        } else {
                            x20Var.j0();
                        }
                        ie4.c(x20Var, n20.f, ebVar3);
                        ie4.c(x20Var, n20.e, gw1VarL3);
                        ie4.b(x20Var, n20.h);
                        ie4.c(x20Var, n20.d, ek1VarC6);
                        ie4.a(x20Var, Integer.valueOf(iHashCode3), n20.g);
                        x20Var.p(true);
                    }
                    z5 = false;
                } else {
                    z5 = false;
                }
                x20Var.W(1250991751);
                x20Var.p(z5);
                x20Var.W(357875859);
                x20Var.p(z5);
                i16 = i7;
                i15 = i17;
                z4 = z2;
                ek1 ek1VarC7 = ek1Var.c(new uz2(str, yz2Var, qo0Var, i16, z4, i2, i15));
                eb ebVar4 = eb.d;
                int iHashCode4 = Long.hashCode(x20Var.T);
                ek1 ek1VarC8 = gj4.c(x20Var, ek1VarC7);
                gw1 gw1VarL4 = x20Var.l();
                o20.p.getClass();
                fq0Var = n20.b;
                x20Var.Z();
                if (x20Var.S) {
                    x20Var.k(fq0Var);
                } else {
                    x20Var.j0();
                }
                ie4.c(x20Var, n20.f, ebVar4);
                ie4.c(x20Var, n20.e, gw1VarL4);
                ie4.b(x20Var, n20.h);
                ie4.c(x20Var, n20.d, ek1VarC8);
                ie4.a(x20Var, Integer.valueOf(iHashCode4), n20.g);
                x20Var.p(true);
            } else {
                x20Var.R();
                i15 = i11;
                i16 = i7;
                z4 = z2;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new vq0() { // from class: al
                    @Override // defpackage.vq0
                    public final Object e(Object obj2, Object obj3) {
                        ((Integer) obj3).getClass();
                        ef4.a(str, ek1Var, yz2Var, i16, z4, i2, i15, (x20) obj2, ny3.c(i4 | 1), i5);
                        return q43.a;
                    }
                };
            }
        }
        i6 |= 24576;
        i7 = i;
        i8 = i5 & 32;
        if (i8 != 0) {
            if ((196608 & i4) == 0) {
                z2 = z;
                if (x20Var.g(z2)) {
                    i9 = Normalizer.INPUT_IS_FCD;
                } else {
                    i9 = 65536;
                }
                i6 |= i9;
            }
            if ((1572864 & i4) == 0) {
                if (x20Var.d(i2)) {
                    i19 = 1048576;
                } else {
                    i19 = ArabicShaping.TASHKEEL_RESIZE;
                }
                i6 |= i19;
            }
            i10 = i5 & 128;
            if (i10 != 0) {
                i6 |= 12582912;
                i11 = i3;
            } else {
                i11 = i3;
                if ((i4 & 12582912) == 0) {
                    if (x20Var.d(i11)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i6 |= i12;
                }
            }
            i13 = i6 | 100663296;
            if ((i5 & 512) != 0) {
                i13 = i6 | 905969664;
            } else if ((805306368 & i4) == 0) {
                if ((1073741824 & i4) == 0) {
                    zH = x20Var.f(null);
                } else {
                    zH = x20Var.h(null);
                }
                if (zH) {
                    i14 = 536870912;
                } else {
                    i14 = 268435456;
                }
                i13 |= i14;
            }
            if ((i13 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (x20Var.O(i13 & 1, z3)) {
                if (i20 != 0) {
                    i7 = 1;
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if (i10 != 0) {
                    i17 = 1;
                } else {
                    i17 = i11;
                }
                lo4.a(i17, i2);
                if (x20Var.j(ag2.a) == null) {
                    dk0.t();
                    return;
                }
                x20Var.W(356914239);
                x20Var.p(false);
                qo0Var = (qo0) x20Var.j(l30.k);
                i18 = (i13 & 14) | ((i13 >> 3) & 112);
                executor = (Executor) x20Var.j(cl.a);
                if (executor != null) {
                    int length3 = str.length();
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (cl.b == null) {
                            if (Runtime.getRuntime().availableProcessors() >= 4) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            cl.b = Boolean.valueOf(z7);
                        }
                        bool = cl.b;
                        bool.getClass();
                        if (bool.booleanValue()) {
                            x20Var.W(1254274527);
                            z61Var = (z61) x20Var.j(l30.n);
                            obj = (jc0) x20Var.j(l30.h);
                            if (((i18 & 112) ^ 48) > 32) {
                                if (!x20Var.f(yz2Var)) {
                                    z6 = true;
                                } else if ((i18 & 48) == 32) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                zD = z6 | x20Var.d(z61Var.ordinal()) | ((((i18 & 14) ^ 6) <= 4 && x20Var.f(str)) || (i18 & 6) == 4) | x20Var.f(obj) | x20Var.h(qo0Var);
                                objL = x20Var.L();
                                if (zD) {
                                    z5 = false;
                                    Object blVar8 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                    qo0Var = qo0Var;
                                    x20Var.g0(blVar8);
                                    objL = blVar8;
                                    executor.execute((Runnable) objL);
                                } else {
                                    z5 = false;
                                    Object blVar9 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                    qo0Var = qo0Var;
                                    x20Var.g0(blVar9);
                                    objL = blVar9;
                                    executor.execute((Runnable) objL);
                                }
                            } else {
                                if ((i18 & 48) == 32) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                zD = z6 | x20Var.d(z61Var.ordinal()) | ((((i18 & 14) ^ 6) <= 4 && x20Var.f(str)) || (i18 & 6) == 4) | x20Var.f(obj) | x20Var.h(qo0Var);
                                objL = x20Var.L();
                                if (zD) {
                                    z5 = false;
                                    Object blVar10 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                    qo0Var = qo0Var;
                                    x20Var.g0(blVar10);
                                    objL = blVar10;
                                    executor.execute((Runnable) objL);
                                } else {
                                    z5 = false;
                                    Object blVar11 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                    qo0Var = qo0Var;
                                    x20Var.g0(blVar11);
                                    objL = blVar11;
                                    executor.execute((Runnable) objL);
                                }
                            }
                        }
                        x20Var.p(z5);
                        x20Var.W(357875859);
                        x20Var.p(z5);
                        i16 = i7;
                        i15 = i17;
                        z4 = z2;
                        ek1 ek1VarC9 = ek1Var.c(new uz2(str, yz2Var, qo0Var, i16, z4, i2, i15));
                        eb ebVar5 = eb.d;
                        int iHashCode5 = Long.hashCode(x20Var.T);
                        ek1 ek1VarC10 = gj4.c(x20Var, ek1VarC9);
                        gw1 gw1VarL5 = x20Var.l();
                        o20.p.getClass();
                        fq0Var = n20.b;
                        x20Var.Z();
                        if (x20Var.S) {
                            x20Var.k(fq0Var);
                        } else {
                            x20Var.j0();
                        }
                        ie4.c(x20Var, n20.f, ebVar5);
                        ie4.c(x20Var, n20.e, gw1VarL5);
                        ie4.b(x20Var, n20.h);
                        ie4.c(x20Var, n20.d, ek1VarC10);
                        ie4.a(x20Var, Integer.valueOf(iHashCode5), n20.g);
                        x20Var.p(true);
                    }
                    z5 = false;
                } else {
                    z5 = false;
                }
                x20Var.W(1250991751);
                x20Var.p(z5);
                x20Var.W(357875859);
                x20Var.p(z5);
                i16 = i7;
                i15 = i17;
                z4 = z2;
                ek1 ek1VarC11 = ek1Var.c(new uz2(str, yz2Var, qo0Var, i16, z4, i2, i15));
                eb ebVar6 = eb.d;
                int iHashCode6 = Long.hashCode(x20Var.T);
                ek1 ek1VarC12 = gj4.c(x20Var, ek1VarC11);
                gw1 gw1VarL6 = x20Var.l();
                o20.p.getClass();
                fq0Var = n20.b;
                x20Var.Z();
                if (x20Var.S) {
                    x20Var.k(fq0Var);
                } else {
                    x20Var.j0();
                }
                ie4.c(x20Var, n20.f, ebVar6);
                ie4.c(x20Var, n20.e, gw1VarL6);
                ie4.b(x20Var, n20.h);
                ie4.c(x20Var, n20.d, ek1VarC12);
                ie4.a(x20Var, Integer.valueOf(iHashCode6), n20.g);
                x20Var.p(true);
            } else {
                x20Var.R();
                i15 = i11;
                i16 = i7;
                z4 = z2;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new vq0() { // from class: al
                    @Override // defpackage.vq0
                    public final Object e(Object obj2, Object obj3) {
                        ((Integer) obj3).getClass();
                        ef4.a(str, ek1Var, yz2Var, i16, z4, i2, i15, (x20) obj2, ny3.c(i4 | 1), i5);
                        return q43.a;
                    }
                };
            }
        }
        i6 |= 196608;
        z2 = z;
        if ((1572864 & i4) == 0) {
            if (x20Var.d(i2)) {
                i19 = 1048576;
            } else {
                i19 = ArabicShaping.TASHKEEL_RESIZE;
            }
            i6 |= i19;
        }
        i10 = i5 & 128;
        if (i10 != 0) {
            i6 |= 12582912;
            i11 = i3;
        } else {
            i11 = i3;
            if ((i4 & 12582912) == 0) {
                if (x20Var.d(i11)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i6 |= i12;
            }
        }
        i13 = i6 | 100663296;
        if ((i5 & 512) != 0) {
            i13 = i6 | 905969664;
        } else if ((805306368 & i4) == 0) {
            if ((1073741824 & i4) == 0) {
                zH = x20Var.f(null);
            } else {
                zH = x20Var.h(null);
            }
            if (zH) {
                i14 = 536870912;
            } else {
                i14 = 268435456;
            }
            i13 |= i14;
        }
        if ((i13 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (x20Var.O(i13 & 1, z3)) {
            if (i20 != 0) {
                i7 = 1;
            }
            if (i8 != 0) {
                z2 = true;
            }
            if (i10 != 0) {
                i17 = 1;
            } else {
                i17 = i11;
            }
            lo4.a(i17, i2);
            if (x20Var.j(ag2.a) == null) {
                dk0.t();
                return;
            }
            x20Var.W(356914239);
            x20Var.p(false);
            qo0Var = (qo0) x20Var.j(l30.k);
            i18 = (i13 & 14) | ((i13 >> 3) & 112);
            executor = (Executor) x20Var.j(cl.a);
            if (executor != null) {
                int length4 = str.length();
                if (Build.VERSION.SDK_INT >= 28) {
                    if (cl.b == null) {
                        if (Runtime.getRuntime().availableProcessors() >= 4) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        cl.b = Boolean.valueOf(z7);
                    }
                    bool = cl.b;
                    bool.getClass();
                    if (bool.booleanValue()) {
                        x20Var.W(1254274527);
                        z61Var = (z61) x20Var.j(l30.n);
                        obj = (jc0) x20Var.j(l30.h);
                        if (((i18 & 112) ^ 48) > 32) {
                            if (!x20Var.f(yz2Var)) {
                                z6 = true;
                            } else if ((i18 & 48) == 32) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            zD = z6 | x20Var.d(z61Var.ordinal()) | ((((i18 & 14) ^ 6) <= 4 && x20Var.f(str)) || (i18 & 6) == 4) | x20Var.f(obj) | x20Var.h(qo0Var);
                            objL = x20Var.L();
                            if (zD) {
                                z5 = false;
                                Object blVar12 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                qo0Var = qo0Var;
                                x20Var.g0(blVar12);
                                objL = blVar12;
                                executor.execute((Runnable) objL);
                            } else {
                                z5 = false;
                                Object blVar13 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                qo0Var = qo0Var;
                                x20Var.g0(blVar13);
                                objL = blVar13;
                                executor.execute((Runnable) objL);
                            }
                        } else {
                            if ((i18 & 48) == 32) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            zD = z6 | x20Var.d(z61Var.ordinal()) | ((((i18 & 14) ^ 6) <= 4 && x20Var.f(str)) || (i18 & 6) == 4) | x20Var.f(obj) | x20Var.h(qo0Var);
                            objL = x20Var.L();
                            if (zD) {
                                z5 = false;
                                Object blVar14 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                qo0Var = qo0Var;
                                x20Var.g0(blVar14);
                                objL = blVar14;
                                executor.execute((Runnable) objL);
                            } else {
                                z5 = false;
                                Object blVar15 = new bl(yz2Var, z61Var, str, obj, qo0Var, 0);
                                qo0Var = qo0Var;
                                x20Var.g0(blVar15);
                                objL = blVar15;
                                executor.execute((Runnable) objL);
                            }
                        }
                    }
                    x20Var.p(z5);
                    x20Var.W(357875859);
                    x20Var.p(z5);
                    i16 = i7;
                    i15 = i17;
                    z4 = z2;
                    ek1 ek1VarC13 = ek1Var.c(new uz2(str, yz2Var, qo0Var, i16, z4, i2, i15));
                    eb ebVar7 = eb.d;
                    int iHashCode7 = Long.hashCode(x20Var.T);
                    ek1 ek1VarC14 = gj4.c(x20Var, ek1VarC13);
                    gw1 gw1VarL7 = x20Var.l();
                    o20.p.getClass();
                    fq0Var = n20.b;
                    x20Var.Z();
                    if (x20Var.S) {
                        x20Var.k(fq0Var);
                    } else {
                        x20Var.j0();
                    }
                    ie4.c(x20Var, n20.f, ebVar7);
                    ie4.c(x20Var, n20.e, gw1VarL7);
                    ie4.b(x20Var, n20.h);
                    ie4.c(x20Var, n20.d, ek1VarC14);
                    ie4.a(x20Var, Integer.valueOf(iHashCode7), n20.g);
                    x20Var.p(true);
                }
                z5 = false;
            } else {
                z5 = false;
            }
            x20Var.W(1250991751);
            x20Var.p(z5);
            x20Var.W(357875859);
            x20Var.p(z5);
            i16 = i7;
            i15 = i17;
            z4 = z2;
            ek1 ek1VarC15 = ek1Var.c(new uz2(str, yz2Var, qo0Var, i16, z4, i2, i15));
            eb ebVar8 = eb.d;
            int iHashCode8 = Long.hashCode(x20Var.T);
            ek1 ek1VarC16 = gj4.c(x20Var, ek1VarC15);
            gw1 gw1VarL8 = x20Var.l();
            o20.p.getClass();
            fq0Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(fq0Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, n20.f, ebVar8);
            ie4.c(x20Var, n20.e, gw1VarL8);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC16);
            ie4.a(x20Var, Integer.valueOf(iHashCode8), n20.g);
            x20Var.p(true);
        } else {
            x20Var.R();
            i15 = i11;
            i16 = i7;
            z4 = z2;
        }
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0() { // from class: al
                @Override // defpackage.vq0
                public final Object e(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    ef4.a(str, ek1Var, yz2Var, i16, z4, i2, i15, (x20) obj2, ny3.c(i4 | 1), i5);
                    return q43.a;
                }
            };
        }
    }

    public static final h83 b(View view) {
        view.getClass();
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
            h83 h83Var = tag instanceof h83 ? (h83) tag : null;
            if (h83Var != null) {
                return h83Var;
            }
            Object objB = ye4.b(view);
            view = objB instanceof View ? (View) objB : null;
        }
        return null;
    }
}
