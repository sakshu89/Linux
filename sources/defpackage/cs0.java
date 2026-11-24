package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cs0 implements qp {
    public final /* synthetic */ int a;
    public final /* synthetic */ yv b;

    public /* synthetic */ cs0(yv yvVar, int i) {
        this.a = i;
        this.b = yvVar;
    }

    @Override // defpackage.qp
    public final void d(m32 m32Var, z62 z62Var) {
        Object h72Var;
        String strO;
        int i = this.a;
        yv yvVar = this.b;
        String str = "";
        try {
            switch (i) {
                case 0:
                    try {
                        try {
                            int i2 = z62Var.e;
                            b72 b72Var = z62Var.j;
                            strO = b72Var != null ? b72Var.o() : null;
                            if (strO != null) {
                                str = strO;
                            }
                            yr0 yr0Var = new yr0(i2, str);
                            z62Var.close();
                            yvVar.h(yr0Var);
                            return;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                fi4.a(z62Var, th);
                                throw th2;
                            }
                        }
                    } catch (Exception e) {
                        yvVar.h(new h72(e));
                        return;
                    }
                default:
                    try {
                        int i3 = z62Var.e;
                        b72 b72Var2 = z62Var.j;
                        strO = b72Var2 != null ? b72Var2.o() : null;
                        if (strO != null) {
                            str = strO;
                        }
                        h72Var = new zc3(i3, str);
                        z62Var.close();
                        yvVar.h(h72Var);
                        return;
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            fi4.a(z62Var, th3);
                            throw th4;
                        }
                    }
            }
        } catch (Throwable th5) {
            h72Var = new h72(th5);
        }
    }

    @Override // defpackage.qp
    public final void m(m32 m32Var, IOException iOException) {
        int i = this.a;
        yv yvVar = this.b;
        switch (i) {
            case 0:
                yvVar.h(new h72(iOException));
                break;
            default:
                yvVar.h(new h72(iOException));
                break;
        }
    }
}
