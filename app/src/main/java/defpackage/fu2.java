package defpackage;

import android.util.Range;
import android.util.Size;
import android.view.Surface;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fu2 {
    public final Object a = new Object();
    public final Size b;
    public final ig0 c;
    public final wt d;
    public final boolean e;
    public final wp f;
    public final tp g;
    public final wp h;
    public final tp i;
    public final tp j;
    public final nz0 k;
    public lj l;
    public eu2 m;
    public Executor n;

    static {
        Range range = fj.f;
    }

    public fu2(Size size, wt wtVar, boolean z, ig0 ig0Var, mt2 mt2Var) {
        this.b = size;
        this.d = wtVar;
        this.e = z;
        this.c = ig0Var;
        String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        AtomicReference atomicReference = new AtomicReference(null);
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            atomicReference.set(tpVar);
            tpVar.a = str.concat("-cancellation");
        } catch (Exception e) {
            wpVar.b(e);
        }
        tp tpVar2 = (tp) atomicReference.get();
        tpVar2.getClass();
        this.j = tpVar2;
        AtomicReference atomicReference2 = new AtomicReference(null);
        tp tpVar3 = new tp();
        tpVar3.c = new o62();
        wp wpVar2 = new wp(tpVar3);
        tpVar3.b = wpVar2;
        tpVar3.a = cq.class;
        try {
            atomicReference2.set(tpVar3);
            tpVar3.a = str.concat("-status");
        } catch (Exception e2) {
            wpVar2.b(e2);
        }
        this.h = wpVar2;
        int i = 29;
        int i2 = 0;
        wpVar2.a(new or0(i2, wpVar2, new q91(i, tpVar2, wpVar)), xg4.a());
        tp tpVar4 = (tp) atomicReference2.get();
        tpVar4.getClass();
        AtomicReference atomicReference3 = new AtomicReference(null);
        tp tpVar5 = new tp();
        tpVar5.c = new o62();
        wp wpVar3 = new wp(tpVar5);
        tpVar5.b = wpVar3;
        tpVar5.a = cq.class;
        try {
            atomicReference3.set(tpVar5);
            tpVar5.a = str.concat("-Surface");
        } catch (Exception e3) {
            wpVar3.b(e3);
        }
        this.f = wpVar3;
        tp tpVar6 = (tp) atomicReference3.get();
        tpVar6.getClass();
        this.g = tpVar6;
        nz0 nz0Var = new nz0(this, size);
        this.k = nz0Var;
        wc1 wc1VarE = oz3.e(nz0Var.e);
        wpVar3.a(new or0(i2, wpVar3, new kf(wc1VarE, tpVar4, str, i)), xg4.a());
        wc1VarE.a(new db0(this, 1), xg4.a());
        dd0 dd0VarA = xg4.a();
        AtomicReference atomicReference4 = new AtomicReference(null);
        wp wpVarA = hg4.a(new qq(8, this, atomicReference4));
        wpVarA.a(new or0(i2, wpVarA, new wj1(11, mt2Var)), dd0VarA);
        tp tpVar7 = (tp) atomicReference4.get();
        tpVar7.getClass();
        this.i = tpVar7;
    }

    public final void a(final Surface surface, Executor executor, final s40 s40Var) {
        final int i = 0;
        if (!this.g.a(surface)) {
            wp wpVar = this.f;
            if (!wpVar.isCancelled()) {
                hh1.e(null, wpVar.b.isDone());
                try {
                    wpVar.get();
                    executor.execute(new Runnable() { // from class: bu2
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i2 = i;
                            Surface surface2 = surface;
                            s40 s40Var2 = s40Var;
                            switch (i2) {
                                case 0:
                                    s40Var2.accept(new kj(3, surface2));
                                    break;
                                default:
                                    s40Var2.accept(new kj(4, surface2));
                                    break;
                            }
                        }
                    });
                    return;
                } catch (InterruptedException | ExecutionException unused) {
                    final int i2 = 1;
                    executor.execute(new Runnable() { // from class: bu2
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i3 = i2;
                            Surface surface2 = surface;
                            s40 s40Var2 = s40Var;
                            switch (i3) {
                                case 0:
                                    s40Var2.accept(new kj(3, surface2));
                                    break;
                                default:
                                    s40Var2.accept(new kj(4, surface2));
                                    break;
                            }
                        }
                    });
                    return;
                }
            }
        }
        cu2 cu2Var = new cu2(i, s40Var, surface);
        wp wpVar2 = this.h;
        wpVar2.a(new or0(i, wpVar2, cu2Var), executor);
    }

    public final void b(Executor executor, eu2 eu2Var) {
        lj ljVar;
        synchronized (this.a) {
            this.m = eu2Var;
            this.n = executor;
            ljVar = this.l;
        }
        if (ljVar != null) {
            executor.execute(new au2(eu2Var, ljVar, 1));
        }
    }

    public final void c() {
        this.g.b(new dt("Surface request will not complete."));
    }
}
