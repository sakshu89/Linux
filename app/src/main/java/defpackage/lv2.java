package defpackage;

import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lv2 implements vp0 {
    public final q82 b;
    public cj c;
    public j62 e;
    public final ArrayList f;
    public final ArrayDeque a = new ArrayDeque();
    public boolean i = false;

    public lv2(q82 q82Var) {
        vc4.b();
        this.b = q82Var;
        this.f = new ArrayList();
    }

    public final void a() {
        int i;
        vc4.b();
        ty0 ty0Var = new ty0("Camera is closed.", null);
        ArrayDeque arrayDeque = this.a;
        Iterator it = arrayDeque.iterator();
        while (true) {
            i = 5;
            if (!it.hasNext()) {
                break;
            }
            oj ojVar = (oj) it.next();
            ojVar.b.execute(new v62(i, ojVar, ty0Var));
        }
        arrayDeque.clear();
        ArrayList arrayList = new ArrayList(this.f);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            j62 j62Var = (j62) obj;
            j62Var.getClass();
            vc4.b();
            if (!j62Var.d.b.isDone()) {
                vc4.b();
                j62Var.g = true;
                xw xwVar = j62Var.i;
                Objects.requireNonNull(xwVar);
                xwVar.cancel(true);
                j62Var.e.b(ty0Var);
                j62Var.f.a(null);
                vc4.b();
                oj ojVar2 = j62Var.a;
                ojVar2.b.execute(new v62(i, ojVar2, ty0Var));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        oj ojVar;
        vc4.b();
        if (this.e == null && !this.i) {
            cj cjVar = this.c;
            cjVar.getClass();
            vc4.b();
            if (((cj) cjVar.e).o() == 0 || (ojVar = (oj) this.a.poll()) == null) {
                return;
            }
            j62 j62Var = new j62(ojVar, this);
            int i = 0;
            hh1.e(null, !(this.e != null));
            this.e = j62Var;
            vc4.b();
            j62Var.c.b.a(new kv2(this, i), xg4.a());
            this.f.add(j62Var);
            vc4.b();
            j62Var.d.b.a(new v62(4, this, j62Var), xg4.a());
            cj cjVar2 = this.c;
            vc4.b();
            wp wpVar = j62Var.c;
            cjVar2.getClass();
            vc4.b();
            jw jwVar = (jw) ((sy0) cjVar2.b).d(sy0.e, new jw(Arrays.asList(new uw())));
            Objects.requireNonNull(jwVar);
            int i2 = cj.i;
            cj.i = i2 + 1;
            zh zhVar = (zh) cjVar2.a;
            ArrayList arrayList = new ArrayList();
            String strValueOf = String.valueOf(jwVar.hashCode());
            List<uw> list = jwVar.a;
            Objects.requireNonNull(list);
            for (uw uwVar : list) {
                ur urVar = new ur();
                int i3 = i;
                lw lwVar = (lw) cjVar2.c;
                urVar.a = lwVar.c;
                urVar.c(lwVar.b);
                urVar.a(ojVar.j);
                nz0 nz0Var = zhVar.b;
                Objects.requireNonNull(nz0Var);
                ((HashSet) urVar.d).add(nz0Var);
                urVar.b = zhVar.c != null ? 1 : i3;
                if (so4.b(zhVar.e)) {
                    if (((ImageCaptureRotationOptionQuirk) uc0.a.d(ImageCaptureRotationOptionQuirk.class)) != null) {
                        bi biVar = lw.i;
                    } else {
                        ((zl1) urVar.e).v(lw.i, Integer.valueOf(ojVar.g));
                    }
                    ((zl1) urVar.e).v(lw.j, Integer.valueOf(((ojVar.c != null ? 1 : i3) == 0 || !z13.b(ojVar.e, zhVar.d)) ? ojVar.h : ojVar.i == 0 ? 100 : 95));
                }
                urVar.c(uwVar.a.b);
                ((om1) urVar.g).a.put(strValueOf, Integer.valueOf(i3));
                ((om1) urVar.g).a.put("CAPTURE_CONFIG_ID_KEY", Integer.valueOf(i2));
                urVar.b(zhVar.a);
                arrayList.add(urVar.d());
                i = i3;
                cjVar2 = cjVar2;
            }
            boolean z = i;
            l11 l11Var = new l11(15, arrayList, j62Var);
            g12 g12Var = new g12(jwVar, ojVar.d, ojVar.e, ojVar.g, ojVar.h, ojVar.f, j62Var, wpVar, i2);
            cj cjVar3 = this.c;
            cjVar3.getClass();
            vc4.b();
            ((zh) cjVar3.a).h.accept(g12Var);
            vc4.b();
            ry0 ry0Var = (ry0) this.b.a;
            synchronized (ry0Var.p) {
                try {
                    if (ry0Var.p.get() == null) {
                        ry0Var.p.set(Integer.valueOf(ry0Var.C()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ry0 ry0Var2 = (ry0) this.b.a;
            vc4.b();
            xw xwVarG = oz3.g(ry0Var2.c().h(arrayList, ry0Var2.o, ry0Var2.q), new q82(new dk0(4)), xg4.a());
            xwVarG.a(new or0(z ? 1 : 0, xwVarG, new cu2(1, this, l11Var, z)), xg4.c());
            vc4.b();
            hh1.e("CaptureRequestFuture can only be set once.", j62Var.i == null ? true : z ? 1 : 0);
            j62Var.i = xwVarG;
        }
    }

    @Override // defpackage.vp0
    public final void c(wp0 wp0Var) {
        xg4.c().execute(new kv2(this, 1));
    }

    public final void d(oj ojVar) {
        vc4.b();
        xq4.c(3, "TakePictureManager");
        this.a.addFirst(ojVar);
        b();
    }
}
