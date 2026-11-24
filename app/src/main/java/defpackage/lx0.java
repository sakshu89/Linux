package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lx0 extends gw2 {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lx0(int i, String str, Object obj, Object obj2) {
        super(str, true);
        this.e = i;
        this.f = obj;
        this.g = obj2;
    }

    @Override // defpackage.gw2
    public final long a() {
        int i;
        long jA;
        ay0[] ay0VarArr;
        switch (this.e) {
            case 0:
                tx0 tx0Var = (tx0) this.f;
                tx0Var.a.a(tx0Var, (yh2) ((t42) this.g).a);
                return -1L;
            case 1:
                try {
                    ((tx0) this.f).a.b((ay0) this.g);
                    break;
                } catch (IOException e) {
                    ex1 ex1Var = ex1.a;
                    ex1 ex1Var2 = ex1.a;
                    String str = "Http2Connection.Listener failure for " + ((tx0) this.f).c;
                    ex1Var2.getClass();
                    ex1.i(str, 4, e);
                    try {
                        ((ay0) this.g).c(2, e);
                        break;
                    } catch (IOException unused) {
                    }
                }
                return -1L;
            default:
                nx0 nx0Var = (nx0) this.f;
                yh2 yh2Var = (yh2) this.g;
                t42 t42Var = new t42();
                tx0 tx0Var2 = nx0Var.b;
                synchronized (tx0Var2.g0) {
                    synchronized (tx0Var2) {
                        try {
                            yh2 yh2Var2 = tx0Var2.Y;
                            yh2 yh2Var3 = new yh2();
                            yh2Var2.getClass();
                            i = 0;
                            for (int i2 = 0; i2 < 10; i2++) {
                                if (((1 << i2) & yh2Var2.a) != 0) {
                                    yh2Var3.b(i2, yh2Var2.b[i2]);
                                }
                            }
                            for (int i3 = 0; i3 < 10; i3++) {
                                if (((1 << i3) & yh2Var.a) != 0) {
                                    yh2Var3.b(i3, yh2Var.b[i3]);
                                }
                            }
                            t42Var.a = yh2Var3;
                            jA = ((long) yh2Var3.a()) - ((long) yh2Var2.a());
                            ay0VarArr = (jA == 0 || tx0Var2.b.isEmpty()) ? null : (ay0[]) tx0Var2.b.values().toArray(new ay0[0]);
                            yh2 yh2Var4 = (yh2) t42Var.a;
                            yh2Var4.getClass();
                            tx0Var2.Y = yh2Var4;
                            tx0Var2.s.c(new lx0(i, tx0Var2.c + " onSettings", tx0Var2, t42Var), 0L);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    try {
                        tx0Var2.g0.c((yh2) t42Var.a);
                    } catch (IOException e2) {
                        tx0Var2.c(2, 2, e2);
                    }
                    break;
                }
                if (ay0VarArr != null) {
                    int length = ay0VarArr.length;
                    while (i < length) {
                        ay0 ay0Var = ay0VarArr[i];
                        synchronized (ay0Var) {
                            ay0Var.f += jA;
                            if (jA > 0) {
                                ay0Var.notifyAll();
                            }
                            break;
                        }
                        i++;
                    }
                }
                return -1L;
        }
    }
}
