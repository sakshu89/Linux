package defpackage;

import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x9 implements nm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ x9(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00fc A[LOOP:0: B:25:0x009b->B:36:0x00fc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x00e8 A[EDGE_INSN: B:37:0x00e8->B:27:0x00e8 BREAK  A[LOOP:0: B:25:0x009b->B:36:0x00fc], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    public Object a(wt1 wt1Var, x50 x50Var) {
        ij2 ij2Var;
        o oVar;
        g5 g5Var;
        String str;
        o oVar2;
        String str2;
        boolean zEquals;
        Object value;
        boolean z;
        yq2 yq2Var;
        oj2 oj2Var = (oj2) this.b;
        jr2 jr2Var = oj2Var.j;
        f0 f0Var = oj2Var.b;
        if (x50Var instanceof ij2) {
            ij2Var = (ij2) x50Var;
            int i = ij2Var.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                ij2Var.n = i - Integer.MIN_VALUE;
            } else {
                ij2Var = new ij2(this, x50Var);
            }
        } else {
            ij2Var = new ij2(this, x50Var);
        }
        Object obj = ij2Var.j;
        int i2 = ij2Var.n;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(obj);
            o oVar3 = (o) wt1Var.a;
            g5 g5Var2 = (g5) wt1Var.b;
            ij2Var.e = oVar3;
            ij2Var.f = g5Var2;
            ij2Var.n = 1;
            Object objH = f0Var.h("gemini", ij2Var);
            if (objH != t70Var) {
                oVar = oVar3;
                obj = objH;
                g5Var = g5Var2;
            }
            return t70Var;
        }
        if (i2 == 1) {
            g5 g5Var3 = ij2Var.f;
            o oVar4 = ij2Var.e;
            bz3.g(obj);
            g5Var = g5Var3;
            oVar = oVar4;
        } else {
            if (i2 != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            String str3 = ij2Var.i;
            g5Var = ij2Var.f;
            oVar2 = ij2Var.e;
            bz3.g(obj);
            str = str3;
        }
        str2 = (String) obj;
        zEquals = ((gj2) jr2Var.getValue()).b.equals(oVar2.b);
        while (true) {
            value = jr2Var.getValue();
            z = zEquals;
            if (jr2Var.h(value, gj2.a((gj2) value, oVar2.a, oVar2.b, str, false, null, null, false, g5Var.a, g5Var.c, g5Var.d, g5Var.e, g5Var.f, str2, g5Var.i, g5Var.j, g5Var.h, g5Var.k, null, null, false, null, null, 4063352))) {
                break;
            }
            zEquals = z;
        }
        if (!z && ((yq2Var = oj2Var.k) == null || !yq2Var.c())) {
            oj2.g(oj2Var);
        }
        return q43.a;
        String str4 = (String) obj;
        ij2Var.e = oVar;
        ij2Var.f = g5Var;
        ij2Var.i = str4;
        ij2Var.n = 2;
        Object objH2 = f0Var.h("gemini_live", ij2Var);
        if (objH2 != t70Var) {
            str = str4;
            obj = objH2;
            oVar2 = oVar;
            str2 = (String) obj;
            zEquals = ((gj2) jr2Var.getValue()).b.equals(oVar2.b);
            while (true) {
                value = jr2Var.getValue();
                z = zEquals;
                if (jr2Var.h(value, gj2.a((gj2) value, oVar2.a, oVar2.b, str, false, null, null, false, g5Var.a, g5Var.c, g5Var.d, g5Var.e, g5Var.f, str2, g5Var.i, g5Var.j, g5Var.h, g5Var.k, null, null, false, null, null, 4063352))) {
                    break;
                    break;
                }
                zEquals = z;
            }
            if (!z) {
                oj2.g(oj2Var);
            }
            return q43.a;
        }
        return t70Var;
    }

    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) {
        Object objF;
        Object value;
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                l11 l11Var = (l11) obj2;
                if (Build.VERSION.SDK_INT >= 34) {
                    l11Var.y().startStylusHandwriting((View) l11Var.b);
                }
                return q43Var;
            case 1:
                r21 r21Var = (r21) obj;
                um2 um2Var = (um2) obj2;
                if (r21Var instanceof xw0) {
                    um2Var.add(r21Var);
                } else if (r21Var instanceof yw0) {
                    um2Var.remove(((yw0) r21Var).a);
                } else if (r21Var instanceof sn0) {
                    um2Var.add(r21Var);
                } else if (r21Var instanceof tn0) {
                    um2Var.remove(((tn0) r21Var).a);
                } else if (r21Var instanceof b02) {
                    um2Var.add(r21Var);
                } else if (r21Var instanceof c02) {
                    um2Var.remove(((c02) r21Var).a);
                } else if (r21Var instanceof a02) {
                    um2Var.remove(((a02) r21Var).a);
                }
                return q43Var;
            case 2:
                w90 w90Var = (w90) obj2;
                return ((w90Var.k.B() instanceof wl0) || (objF = w90.f(w90Var, true, x50Var)) != t70.a) ? q43Var : objF;
            case 3:
                ((t42) obj2).a = obj;
                throw new i0(this);
            case 4:
                return a((wt1) obj, x50Var);
            case 5:
                g5 g5Var = (g5) obj;
                sj2 sj2Var = (sj2) obj2;
                jr2 jr2Var = sj2Var.g;
                Boolean boolValueOf = Boolean.valueOf(!g5Var.g);
                jr2Var.getClass();
                jr2Var.j(null, boolValueOf);
                jr2 jr2Var2 = sj2Var.f;
                do {
                    value = jr2Var2.getValue();
                } while (!jr2Var2.h(value, qj2.a((qj2) value, null, null, false, false, false, g5Var.h, 31)));
                return q43Var;
            default:
                ((ok1) obj2).a.h(((Number) obj).floatValue());
                return q43Var;
        }
    }
}
