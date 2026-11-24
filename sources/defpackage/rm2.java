package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rm2 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ rm2(rm2 rm2Var, q0 q0Var) {
        this.a = 6;
        this.b = rm2Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        Object value;
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                hm1 hm1Var = (hm1) obj2;
                if (obj instanceof or2) {
                    ((or2) obj).f(4);
                }
                hm1Var.a(obj);
                return q43.a;
            case 1:
                wm2 wm2Var = (wm2) obj2;
                synchronized (wm2Var.g) {
                    vm2 vm2Var = wm2Var.i;
                    vm2Var.getClass();
                    Object obj3 = vm2Var.b;
                    obj3.getClass();
                    int i2 = vm2Var.d;
                    ul1 ul1Var = vm2Var.c;
                    if (ul1Var == null) {
                        ul1Var = new ul1();
                        vm2Var.c = ul1Var;
                        vm2Var.f.m(obj3, ul1Var);
                    }
                    vm2Var.b(obj, i2, obj3, ul1Var);
                }
                return q43.a;
            case 2:
                so2 so2Var = (so2) obj2;
                z83 z83Var = (z83) obj;
                z83Var.getClass();
                if (z83Var.equals(v83.a)) {
                    jr2 jr2Var = so2Var.n;
                    do {
                        value = jr2Var.getValue();
                    } while (!jr2Var.h(value, eo2.a((eo2) value, null, null, null, null, null, null, null, null, true, false, false, false, false, null, 0L, 32511)));
                } else if (z83Var instanceof u83) {
                    jr2 jr2Var2 = so2Var.o;
                    Float fValueOf = Float.valueOf(((u83) z83Var).a);
                    jr2Var2.getClass();
                    jr2Var2.j(null, fValueOf);
                }
                return q43.a;
            case 3:
                od odVar = (od) obj;
                ((ic) obj2).e(odVar.e.getValue(), eb4.a.b.j(odVar.f));
                return q43.a;
            case 4:
                Drawable drawable = (Drawable) obj2;
                rf0 rf0Var = (rf0) obj;
                cw cwVarM = rf0Var.C().m();
                drawable.setBounds(0, 0, (int) Float.intBitsToFloat((int) (rf0Var.c() >> 32)), (int) Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L)));
                drawable.draw(v6.a(cwVarM));
                return q43.a;
            case 5:
                ((hq0) obj).j((ax2) obj2);
                return q43.a;
            case 6:
                rm2 rm2Var = (rm2) obj2;
                t23 t23Var = (t23) obj;
                if (t23Var instanceof q4) {
                    rm2Var.j(((q4) t23Var).x);
                    return Boolean.TRUE;
                }
                og.n("TextContextMenuDataNode.TraverseKey key must only be attached to instances of TextContextMenuDataNode.");
                return null;
            case 7:
                fy2 fy2Var = (fy2) obj2;
                float fFloatValue = ((Float) obj).floatValue();
                gu1 gu1Var = fy2Var.a;
                float fG = gu1Var.g() + fFloatValue;
                gu1 gu1Var2 = fy2Var.b;
                if (fG > gu1Var2.g()) {
                    fFloatValue = gu1Var2.g() - gu1Var.g();
                } else if (fG < 0.0f) {
                    fFloatValue = -gu1Var.g();
                }
                gu1Var.h(gu1Var.g() + fFloatValue);
                return Float.valueOf(fFloatValue);
            case 8:
                return (jp1) ((fq0) obj2).a();
            default:
                return new g8(10, (j23) obj2);
        }
    }

    public /* synthetic */ rm2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
