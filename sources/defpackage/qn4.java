package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qn4 {
    public static final mm1 a(g32 g32Var, x20 x20Var, int i) {
        ob1 ob1Var = (ob1) x20Var.j(ie1.a);
        Object value = g32Var.a.getValue();
        Object objF = ob1Var.f();
        int i2 = i & 14;
        int i3 = i << 3;
        int i4 = (i3 & 57344) | i2 | (i3 & 7168);
        eb1 eb1Var = eb1.e;
        Object obj = gi0.a;
        Object[] objArr = {g32Var, objF, eb1Var, obj};
        boolean zH = ((((i4 & 7168) ^ UCharacterProperty.SCRIPT_X_WITH_OTHER) > 2048 && x20Var.d(eb1Var.ordinal())) || (i4 & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 2048) | x20Var.h(objF) | x20Var.h(obj) | x20Var.h(g32Var);
        Object objL = x20Var.L();
        Object obj2 = r20.a;
        if (zH || objL == obj2) {
            objL = new z9(objF, eb1Var, obj, g32Var, null, 4);
            x20Var.g0(objL);
        }
        vq0 vq0Var = (vq0) objL;
        Object objL2 = x20Var.L();
        if (objL2 == obj2) {
            objL2 = o44.g(value);
            x20Var.g0(objL2);
        }
        mm1 mm1Var = (mm1) objL2;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 4);
        boolean zH2 = x20Var.h(vq0Var);
        Object objL3 = x20Var.L();
        if (zH2 || objL3 == obj2) {
            objL3 = new qm2(vq0Var, mm1Var, null, 1);
            x20Var.g0(objL3);
        }
        vq0 vq0Var2 = (vq0) objL3;
        j70 j70Var = x20Var.R;
        boolean zF = false;
        for (Object obj3 : Arrays.copyOf(objArrCopyOf, objArrCopyOf.length)) {
            zF |= x20Var.f(obj3);
        }
        Object objL4 = x20Var.L();
        if (!zF && objL4 != obj2) {
            return mm1Var;
        }
        x20Var.g0(new u61(j70Var, vq0Var2));
        return mm1Var;
    }
}
