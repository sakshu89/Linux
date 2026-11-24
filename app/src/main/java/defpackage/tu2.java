package defpackage;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tu2 extends dk1 implements ry1, jc0, qy1 {
    public Object H;
    public PointerInputEventHandler X;
    public yq2 Y;
    public gy1 Z = pu2.a;
    public final pm1 c0;
    public final pm1 d0;
    public final pm1 e0;
    public gy1 f0;
    public long g0;
    public Object x;

    public tu2(Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler) {
        this.x = obj;
        this.H = obj2;
        this.X = pointerInputEventHandler;
        pm1 pm1Var = new pm1(new su2[16]);
        this.c0 = pm1Var;
        this.d0 = pm1Var;
        this.e0 = new pm1(new su2[16]);
        this.g0 = 0L;
    }

    @Override // defpackage.dk1
    public final void B0() {
        K0();
    }

    @Override // defpackage.qy1
    public final void H(gy1 gy1Var, hy1 hy1Var, long j) {
        this.g0 = j;
        if (hy1Var == hy1.a) {
            this.Z = gy1Var;
        }
        x50 x50Var = null;
        if (this.Y == null) {
            this.Y = uf4.b(w0(), null, new l2(this, x50Var, 16), 1);
        }
        J0(gy1Var, hy1Var);
        List list = gy1Var.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!y11.d((ny1) list.get(i))) {
                this.f0 = gy1Var;
            }
        }
        gy1Var = null;
        this.f0 = gy1Var;
    }

    public final Object I0(vq0 vq0Var, x50 x50Var) {
        yv yvVar = new yv(1, fp4.b(x50Var));
        yvVar.x();
        su2 su2Var = new su2(this, yvVar);
        synchronized (this.d0) {
            this.c0.b(su2Var);
            new q92(fp4.b(fp4.a(su2Var, su2Var, vq0Var)), t70.a).h(q43.a);
        }
        yvVar.z(new h6(24, su2Var));
        return yvVar.v();
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004c A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x000d, B:13:0x001b, B:14:0x0020, B:17:0x0023, B:20:0x002f, B:22:0x0037, B:24:0x003b, B:25:0x0040, B:26:0x0043, B:28:0x004c, B:30:0x0054, B:32:0x0058), top: B:41:0x000d }] */
    public final void J0(gy1 gy1Var, hy1 hy1Var) {
        Object[] objArr;
        int i;
        int i2;
        su2 su2Var;
        yv yvVar;
        yv yvVar2;
        synchronized (this.d0) {
            pm1 pm1Var = this.e0;
            pm1Var.d(pm1Var.c, this.c0);
        }
        try {
            int iOrdinal = hy1Var.ordinal();
            if (iOrdinal == 0) {
                pm1 pm1Var2 = this.e0;
                objArr = pm1Var2.a;
                i = pm1Var2.c;
                for (i2 = 0; i2 < i; i2++) {
                    su2Var = (su2) objArr[i2];
                    if (hy1Var != su2Var.e && (yvVar = su2Var.c) != null) {
                        su2Var.c = null;
                        yvVar.h(gy1Var);
                    }
                }
            } else if (iOrdinal == 1) {
                pm1 pm1Var3 = this.e0;
                int i3 = pm1Var3.c - 1;
                Object[] objArr2 = pm1Var3.a;
                if (i3 < objArr2.length) {
                    while (i3 >= 0) {
                        su2 su2Var2 = (su2) objArr2[i3];
                        if (hy1Var == su2Var2.e && (yvVar2 = su2Var2.c) != null) {
                            su2Var2.c = null;
                            yvVar2.h(gy1Var);
                        }
                        i3--;
                    }
                }
            } else {
                if (iOrdinal != 2) {
                    throw new b10();
                }
                pm1 pm1Var4 = this.e0;
                objArr = pm1Var4.a;
                i = pm1Var4.c;
                while (i2 < i) {
                    su2Var = (su2) objArr[i2];
                    if (hy1Var != su2Var.e) {
                    }
                }
            }
            this.e0.h();
        } catch (Throwable th) {
            this.e0.h();
            throw th;
        }
    }

    public final void K0() {
        yq2 yq2Var = this.Y;
        if (yq2Var != null) {
            yq2Var.B(new hk1("Pointer input was reset", 2));
            this.Y = null;
        }
    }

    @Override // defpackage.xb0, defpackage.qy1
    public final void a() {
        K0();
    }

    @Override // defpackage.jc0
    public final float b() {
        return cm4.g(this).h0.b();
    }

    @Override // defpackage.qy1
    public final void b0() {
        K0();
    }

    @Override // defpackage.qy1
    public final void h0() {
        gy1 gy1Var = this.f0;
        if (gy1Var == null) {
            return;
        }
        List list = gy1Var.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((ny1) list.get(i)).d) {
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ny1 ny1Var = (ny1) list.get(i2);
                    long j = ny1Var.a;
                    long j2 = ny1Var.c;
                    long j3 = ny1Var.b;
                    float f = ny1Var.e;
                    boolean z = ny1Var.d;
                    arrayList.add(new ny1(j, j3, j2, false, f, j3, j2, z, z, ny1Var.i, 0L));
                }
                gy1 gy1Var2 = new gy1(arrayList, null);
                this.Z = gy1Var2;
                J0(gy1Var2, hy1.a);
                J0(gy1Var2, hy1.b);
                J0(gy1Var2, hy1.c);
                this.f0 = null;
                return;
            }
        }
    }

    @Override // defpackage.jc0
    public final float l() {
        return cm4.g(this).h0.l();
    }
}
