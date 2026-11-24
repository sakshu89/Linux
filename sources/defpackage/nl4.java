package defpackage;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nl4 extends zj1 implements pz2 {
    public final qz2 i;

    public nl4(rz2 rz2Var, Executor executor, ns4 ns4Var, qz2 qz2Var) {
        super(rz2Var, executor);
        this.i = qz2Var;
        lj1 lj1Var = new lj1(8);
        lj1Var.d = qz2Var.a() ? hn4.TYPE_THICK : hn4.TYPE_THIN;
        b13 b13Var = new b13();
        wj1 wj1Var = new wj1(27, false);
        wj1Var.b = tq4.LATIN;
        b13Var.c = new uq4(wj1Var);
        lj1Var.e = new qq4(b13Var);
        aa4.a.execute(new qa3(ns4Var, new t9(lj1Var, 1), jn4.ON_DEVICE_TEXT_CREATE, ns4Var.c(), 1));
    }

    @Override // defpackage.cs1
    public final el0[] c() {
        return this.i.a() ? ds1.a : new el0[]{ds1.b};
    }

    public final et4 e(final k11 k11Var) {
        synchronized (this) {
            if (this.a.get()) {
                uj1 uj1Var = new uj1("This detector is already closed!", 14);
                et4 et4Var = new et4();
                et4Var.d(uj1Var);
                return et4Var;
            }
            if (k11Var.b >= 32 && k11Var.c >= 32) {
                return this.b.a(this.e, new Callable() { // from class: ax3
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        tj4 tj4Var;
                        nl4 nl4Var = this.a;
                        k11 k11Var2 = k11Var;
                        HashMap map = tj4.i;
                        fl4.l();
                        int i = dl4.a;
                        fl4.l();
                        if (Boolean.parseBoolean("")) {
                            HashMap map2 = tj4.i;
                            if (map2.get("detectorTaskWithResource#run") == null) {
                                map2.put("detectorTaskWithResource#run", new tj4("detectorTaskWithResource#run"));
                            }
                            tj4Var = (tj4) map2.get("detectorTaskWithResource#run");
                        } else {
                            tj4Var = qj4.j;
                        }
                        tj4Var.c();
                        try {
                            uw2 uw2VarB = nl4Var.b.b(k11Var2);
                            tj4Var.close();
                            return uw2VarB;
                        } catch (Throwable th) {
                            try {
                                tj4Var.close();
                            } catch (Throwable th2) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    }
                }, (wj1) this.c.b);
            }
            uj1 uj1Var2 = new uj1("InputImage width and height should be at least 32!", 3);
            et4 et4Var2 = new et4();
            et4Var2.d(uj1Var2);
            return et4Var2;
        }
    }
}
