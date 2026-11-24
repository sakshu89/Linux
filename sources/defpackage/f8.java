package defpackage;

import android.os.Looper;
import android.view.Choreographer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.UUID;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f8 extends k61 implements fq0 {
    public static final f8 H;
    public static final f8 X;
    public static final f8 Y;
    public static final f8 Z;
    public static final f8 c;
    public static final f8 c0;
    public static final f8 d0;
    public static final f8 e;
    public static final f8 e0;
    public static final f8 f;
    public static final f8 f0;
    public static final f8 g0;
    public static final f8 h0;
    public static final f8 i;
    public static final f8 i0;
    public static final f8 j;
    public static final f8 j0;
    public static final f8 k;
    public static final f8 k0;
    public static final f8 l0;
    public static final f8 m0;
    public static final f8 n;
    public static final f8 n0;
    public static final f8 o0;
    public static final f8 s;
    public static final f8 t;
    public static final f8 u;
    public static final f8 v;
    public static final f8 w;
    public static final f8 x;
    public final /* synthetic */ int b;

    static {
        int i2 = 0;
        c = new f8(i2, 0);
        e = new f8(i2, 1);
        f = new f8(i2, 2);
        i = new f8(i2, 3);
        j = new f8(i2, 4);
        k = new f8(i2, 5);
        n = new f8(i2, 6);
        s = new f8(i2, 7);
        t = new f8(i2, 8);
        u = new f8(i2, 9);
        v = new f8(i2, 10);
        w = new f8(i2, 11);
        x = new f8(i2, 12);
        H = new f8(i2, 13);
        X = new f8(i2, 14);
        Y = new f8(i2, 15);
        Z = new f8(i2, 16);
        c0 = new f8(i2, 17);
        d0 = new f8(i2, 18);
        e0 = new f8(i2, 19);
        f0 = new f8(i2, 20);
        g0 = new f8(i2, 21);
        h0 = new f8(i2, 22);
        i0 = new f8(i2, 23);
        j0 = new f8(i2, 24);
        k0 = new f8(i2, 25);
        l0 = new f8(i2, 26);
        m0 = new f8(i2, 27);
        n0 = new f8(i2, 28);
        o0 = new f8(i2, 29);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f8(int i2, int i3) {
        super(i2);
        this.b = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.fq0
    public final Object a() throws Throwable {
        jj0 jj0VarA;
        j70 j70VarA;
        long jS;
        Choreographer choreographer;
        int i2 = 2;
        Object[] objArr = 0;
        switch (this.b) {
            case 0:
                AndroidCompositionLocals_androidKt.b("LocalConfiguration");
                throw null;
            case 1:
                AndroidCompositionLocals_androidKt.b("LocalContext");
                throw null;
            case 2:
                AndroidCompositionLocals_androidKt.b("LocalImageVectorCache");
                throw null;
            case 3:
                AndroidCompositionLocals_androidKt.b("LocalResourceIdCache");
                throw null;
            case 4:
                AndroidCompositionLocals_androidKt.b("LocalView");
                throw null;
            case 5:
                return Boolean.FALSE;
            case 6:
                return "DEFAULT_TEST_TAG";
            case 7:
                return UUID.randomUUID();
            case 8:
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    xa0 xa0Var = ld0.a;
                    tv0 tv0Var = ig1.a;
                    vq0 ncVar = new nc(i2, objArr == true ? 1 : 0, 0);
                    Thread threadCurrentThread = Thread.currentThread();
                    qs4 qs4Var = qs4.c;
                    l70 l70Var = (l70) tv0Var.v(qs4Var);
                    gi0 gi0Var = gi0.a;
                    if (l70Var == null) {
                        jj0VarA = i03.a();
                        j70VarA = ql4.a(gi0Var, pl4.c(tv0Var, jj0VarA), true);
                        xa0 xa0Var2 = ld0.a;
                        if (j70VarA != xa0Var2 && j70VarA.v(qs4Var) == null) {
                            j70VarA = j70VarA.r(xa0Var2);
                        }
                    } else {
                        jj0VarA = (jj0) i03.a.get();
                        j70VarA = ql4.a(gi0Var, tv0Var, true);
                        xa0 xa0Var3 = ld0.a;
                        if (j70VarA != xa0Var3 && j70VarA.v(qs4Var) == null) {
                            j70VarA = j70VarA.r(xa0Var3);
                        }
                    }
                    ql qlVar = new ql(j70VarA, threadCurrentThread, jj0VarA);
                    qlVar.u0(v70.a, qlVar, ncVar);
                    jj0 jj0Var = qlVar.j;
                    if (jj0Var != null) {
                        int i3 = jj0.i;
                        jj0Var.R(false);
                    }
                    while (true) {
                        if (jj0Var != null) {
                            try {
                                jS = jj0Var.S();
                            } catch (Throwable th) {
                                if (jj0Var != null) {
                                    int i4 = jj0.i;
                                    jj0Var.P(false);
                                }
                                throw th;
                            }
                        } else {
                            jS = Long.MAX_VALUE;
                        }
                        if (qlVar.Z()) {
                            if (jj0Var != null) {
                                int i5 = jj0.i;
                                jj0Var.P(false);
                            }
                            Object objE = tz3.e(qlVar.U());
                            a10 a10Var = objE instanceof a10 ? (a10) objE : null;
                            if (a10Var != null) {
                                throw a10Var.a;
                            }
                            choreographer = (Choreographer) objE;
                        } else {
                            LockSupport.parkNanos(qlVar, jS);
                            if (Thread.interrupted()) {
                                qlVar.A(new InterruptedException());
                            }
                        }
                        break;
                    }
                } else {
                    choreographer = Choreographer.getInstance();
                }
                qc qcVar = new qc(choreographer, go4.a(Looper.getMainLooper()));
                return pl4.c(qcVar, qcVar.u);
            case 9:
                return new n71(2);
            case 10:
            case 11:
                return null;
            case 12:
                l30.b("LocalAutofillManager");
                throw null;
            case 13:
                l30.b("LocalAutofillTree");
                throw null;
            case 14:
                l30.b("LocalClipboard");
                throw null;
            case 15:
                l30.b("LocalClipboardManager");
                throw null;
            case 16:
                return Boolean.TRUE;
            case 17:
                l30.b("LocalDensity");
                throw null;
            case 18:
                l30.b("LocalFocusManager");
                throw null;
            case 19:
                l30.b("LocalFontFamilyResolver");
                throw null;
            case 20:
                l30.b("LocalFontLoader");
                throw null;
            case 21:
                l30.b("LocalGraphicsContext");
                throw null;
            case 22:
                l30.b("LocalHapticFeedback");
                throw null;
            case 23:
                l30.b("LocalInputManager");
                throw null;
            case 24:
                l30.b("LocalLayoutDirection");
                throw null;
            case 25:
                return null;
            case 26:
                return Boolean.FALSE;
            case 27:
            case 28:
                return null;
            default:
                l30.b("LocalTextToolbar");
                throw null;
        }
    }
}
