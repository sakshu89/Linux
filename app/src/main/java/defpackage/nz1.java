package defpackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nz1 extends yt0 {
    private static final nz1 DEFAULT_INSTANCE;
    private static volatile mu1 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private xg1 preferences_ = xg1.b;

    static {
        nz1 nz1Var = new nz1();
        DEFAULT_INSTANCE = nz1Var;
        yt0.j(nz1.class, nz1Var);
    }

    public static xg1 l(nz1 nz1Var) {
        xg1 xg1Var = nz1Var.preferences_;
        if (!xg1Var.a) {
            nz1Var.preferences_ = xg1Var.b();
        }
        return nz1Var.preferences_;
    }

    public static lz1 n() {
        return (lz1) ((wt0) DEFAULT_INSTANCE.c(5));
    }

    public static nz1 o(FileInputStream fileInputStream) {
        nz1 nz1Var = DEFAULT_INSTANCE;
        gz gzVar = new gz(fileInputStream);
        wk0 wk0VarA = wk0.a();
        yt0 yt0VarI = nz1Var.i();
        try {
            w12 w12Var = w12.c;
            w12Var.getClass();
            db2 db2VarA = w12Var.a(yt0VarI.getClass());
            iz izVar = (iz) gzVar.b;
            if (izVar == null) {
                izVar = new iz(gzVar);
            }
            db2VarA.h(yt0VarI, izVar, wk0VarA);
            db2VarA.c(yt0VarI);
            if (yt0.f(yt0VarI, true)) {
                return (nz1) yt0VarI;
            }
            throw new o31(new o43().getMessage());
        } catch (o31 e) {
            if (e.a) {
                throw new o31(e.getMessage(), e);
            }
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof o31) {
                throw ((o31) e2.getCause());
            }
            throw new o31(e2.getMessage(), e2);
        } catch (o43 e3) {
            throw new o31(e3.getMessage());
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof o31) {
                throw ((o31) e4.getCause());
            }
            throw e4;
        }
    }

    @Override // defpackage.yt0
    public final Object c(int i) {
        mu1 xt0Var;
        switch (cq.x(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new v22(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", mz1.a});
            case 3:
                return new nz1();
            case 4:
                return new lz1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                mu1 mu1Var = PARSER;
                if (mu1Var != null) {
                    return mu1Var;
                }
                synchronized (nz1.class) {
                    try {
                        xt0Var = PARSER;
                        if (xt0Var == null) {
                            xt0Var = new xt0();
                            PARSER = xt0Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return xt0Var;
            default:
                dk0.p();
                return null;
        }
    }

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
