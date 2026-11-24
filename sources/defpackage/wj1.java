package defpackage;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Region;
import android.os.Build;
import android.os.Parcel;
import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.camera.camera2.internal.compat.quirk.TorchFlashRequiredFor3aUpdateQuirk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wj1 implements kq1, bp1, wz, ir0, wu2, wd, v63, o52, wu3 {
    public final /* synthetic */ int a;
    public Object b;

    public wj1(long[] jArr) {
        ql1 ql1Var;
        this.a = 8;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            ql1Var = new ql1(jArrCopyOf.length);
            int i = ql1Var.b;
            if (i < 0) {
                og.o("");
                throw null;
            }
            if (jArrCopyOf.length != 0) {
                int length = jArrCopyOf.length + i;
                long[] jArr2 = ql1Var.a;
                if (jArr2.length < length) {
                    ql1Var.a = Arrays.copyOf(jArr2, Math.max(length, (jArr2.length * 3) / 2));
                }
                long[] jArr3 = ql1Var.a;
                int i2 = ql1Var.b;
                if (i != i2) {
                    qg.f(jArr3, jArr3, jArrCopyOf.length + i, i, i2);
                }
                qg.f(jArrCopyOf, jArr3, i, 0, jArrCopyOf.length);
                ql1Var.b += jArrCopyOf.length;
            }
        } else {
            ql1Var = new ql1(16);
        }
        this.b = ql1Var;
    }

    @Override // defpackage.s63
    public long a(vd vdVar, vd vdVar2, vd vdVar3) {
        return ((p6) this.b).a(vdVar, vdVar2, vdVar3);
    }

    @Override // defpackage.o52
    public void accept(Object obj, Object obj2) {
        ue3 ue3Var = new ue3((iw2) obj2);
        ke3 ke3Var = (ke3) ((ye3) obj).p();
        re reVar = (re) this.b;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(ke3Var.c);
        int i = be3.a;
        parcelObtain.writeStrongBinder(ue3Var);
        parcelObtain.writeInt(1);
        reVar.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(null);
        ke3Var.a(parcelObtain, 2);
    }

    @Override // defpackage.wu2
    public Object b() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 15:
                l92 l92Var = (l92) obj;
                long jH = l92Var.b.h() - l92Var.e.d;
                SQLiteDatabase sQLiteDatabaseC = l92Var.c();
                sQLiteDatabaseC.beginTransaction();
                try {
                    int iDelete = sQLiteDatabaseC.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(jH)});
                    sQLiteDatabaseC.setTransactionSuccessful();
                    return Integer.valueOf(iDelete);
                } finally {
                    sQLiteDatabaseC.endTransaction();
                }
            default:
                p6 p6Var = (p6) obj;
                SQLiteDatabase sQLiteDatabaseC2 = ((l92) p6Var.b).c();
                sQLiteDatabaseC2.beginTransaction();
                try {
                    List list = (List) l92.r(sQLiteDatabaseC2.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), y74.i);
                    sQLiteDatabaseC2.setTransactionSuccessful();
                    sQLiteDatabaseC2.endTransaction();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((kf) p6Var.c).B((pj) it.next(), 1, false);
                    }
                    return null;
                } catch (Throwable th) {
                    sQLiteDatabaseC2.endTransaction();
                    throw th;
                }
        }
    }

    @Override // defpackage.kq1
    public void c(Object obj) {
        switch (this.a) {
            case 0:
                ((o2) this.b).j(obj);
                break;
            case 11:
                ((mt2) this.b).run();
                break;
            default:
                break;
        }
    }

    @Override // defpackage.wu3
    public dv3 d(Class cls) {
        for (int i = 0; i < 2; i++) {
            wu3 wu3Var = ((wu3[]) this.b)[i];
            if (wu3Var.j(cls)) {
                return wu3Var.d(cls);
            }
        }
        dk0.r("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }

    @Override // defpackage.s63
    public vd f(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        return ((p6) this.b).f(j, vdVar, vdVar2, vdVar3);
    }

    @Override // defpackage.wd
    public im0 get(int i) {
        return (jm0) this.b;
    }

    @Override // defpackage.s63
    public vd h(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        return ((p6) this.b).h(j, vdVar, vdVar2, vdVar3);
    }

    @Override // defpackage.ir0
    public void i(Throwable th) {
        switch (this.a) {
            case 11:
                return;
            default:
                bv2 bv2Var = (bv2) this.b;
                synchronized (bv2Var.a) {
                    try {
                        List list = bv2Var.k;
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((ob0) it.next()).b();
                            }
                            bv2Var.k = null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                bv2Var.u.i();
                lj1 lj1Var = bv2Var.b;
                lj1Var.f(bv2Var);
                synchronized (lj1Var.c) {
                    ((LinkedHashSet) lj1Var.f).remove(bv2Var);
                    break;
                }
                return;
        }
    }

    @Override // defpackage.v63, defpackage.s63
    public boolean isInfinite() {
        ((p6) this.b).getClass();
        return false;
    }

    @Override // defpackage.wu3
    public boolean j(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (((wu3[]) this.b)[i].j(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.s63
    public vd k(vd vdVar, vd vdVar2, vd vdVar3) {
        return ((p6) this.b).k(vdVar, vdVar2, vdVar3);
    }

    @Override // defpackage.wz
    public long l() {
        return ((k82) this.b).b;
    }

    @Override // defpackage.bp1
    public void m(Object obj) {
        ((s40) this.b).accept(obj);
    }

    public void n(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 27) {
            ((AutofillManager) this.b).notifyViewVisibilityChanged(view, i, z);
        }
    }

    @Override // defpackage.bp1
    public void onError(Throwable th) {
        xq4.b("ObserverToConsumerAdapter", "Unexpected error in Observable", th);
    }

    public l11 p(q91 q91Var, r7 r7Var) {
        long j;
        boolean z;
        long jB;
        if1 if1Var = (if1) this.b;
        List list = (List) q91Var.b;
        if1 if1Var2 = new if1(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            py1 py1Var = (py1) list.get(i);
            long j2 = py1Var.a;
            oy1 oy1Var = (oy1) if1Var.b(j2);
            if (oy1Var == null) {
                j = py1Var.b;
                jB = py1Var.d;
                z = false;
            } else {
                long j3 = oy1Var.a;
                j = j3;
                z = oy1Var.c;
                jB = r7Var.B(oy1Var.b);
            }
            long j4 = py1Var.a;
            int i2 = i;
            List list2 = list;
            int i3 = size;
            if1Var2.d(j4, new ny1(j4, py1Var.b, py1Var.d, py1Var.e, py1Var.f, j, jB, z, py1Var.g, py1Var.i, py1Var.j, py1Var.k));
            boolean z2 = py1Var.e;
            if (z2) {
                if1Var.d(j2, new oy1(py1Var.b, py1Var.c, z2));
            } else {
                if1Var.e(j2);
            }
            i = i2 + 1;
            list = list2;
            size = i3;
        }
        return new l11(25, if1Var2, q91Var);
    }

    public boolean q() {
        TorchFlashRequiredFor3aUpdateQuirk torchFlashRequiredFor3aUpdateQuirk = (TorchFlashRequiredFor3aUpdateQuirk) this.b;
        boolean z = false;
        if (torchFlashRequiredFor3aUpdateQuirk != null) {
            if (!(Build.VERSION.SDK_INT >= 28 && kq.n(torchFlashRequiredFor3aUpdateQuirk.a, 5) == 5)) {
                z = true;
            }
        }
        xq4.c(3, "UseFlashModeTorchFor3aUpdate");
        return z;
    }

    private final void o(Throwable th) {
    }

    public /* synthetic */ wj1(int i, boolean z) {
        this.a = i;
    }

    public /* synthetic */ wj1(re3 re3Var, re reVar) {
        this.a = 23;
        this.b = reVar;
    }

    public wj1(ch2 ch2Var) {
        this.a = 19;
        this.b = new AtomicInteger(0);
    }

    public wj1(cq0 cq0Var) {
        this.a = 16;
        this.b = (TorchFlashRequiredFor3aUpdateQuirk) cq0Var.d(TorchFlashRequiredFor3aUpdateQuirk.class);
    }

    public wj1(View view) {
        this.a = 9;
        if (Build.VERSION.SDK_INT >= 30) {
            bn2 bn2Var = new bn2(14, view);
            bn2Var.c = view;
            this.b = bn2Var;
            return;
        }
        this.b = new py0(14, view);
    }

    public /* synthetic */ wj1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public wj1(int i) {
        this.a = i;
        switch (i) {
            case 7:
                this.b = new Region();
                break;
            case 25:
                this.b = new et4();
                break;
            default:
                this.b = new if1((Object) null);
                break;
        }
    }

    public wj1(y53 y53Var) {
        this.a = 13;
        this.b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), y53Var);
    }

    public wj1(float f, float f2, vd vdVar) {
        Object wj1Var;
        this.a = 18;
        int[] iArr = t63.a;
        if (vdVar != null) {
            wj1Var = new py0(f, f2, vdVar);
        } else {
            wj1Var = new wj1(f, f2);
        }
        this.b = new p6(wj1Var);
    }

    public wj1(float f, float f2) {
        this.a = 17;
        this.b = new jm0(f, f2, 0.01f);
    }
}
