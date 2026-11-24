package defpackage;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gb2 {
    public static final Class a;
    public static final s43 b;
    public static final s43 c;

    static {
        Class<?> cls;
        Class<?> cls2;
        w12 w12Var = w12.c;
        s43 s43Var = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            w12 w12Var2 = w12.c;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                s43Var = (s43) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        b = s43Var;
        c = new s43();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += kz.j(((Integer) list.get(i)).intValue());
        }
        return iJ;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (kz.h(i) + 4) * size;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (kz.h(i) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += kz.j(((Integer) list.get(i)).intValue());
        }
        return iJ;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += kz.j(((Long) list.get(i)).longValue());
        }
        return iJ;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int iIntValue = ((Integer) list.get(i2)).intValue();
            i += kz.i((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return i;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iJ += kz.j((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iJ;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += kz.i(((Integer) list.get(i2)).intValue());
        }
        return i;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += kz.j(((Long) list.get(i)).longValue());
        }
        return iJ;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void k(s43 s43Var, Object obj, Object obj2) {
        s43Var.getClass();
        yt0 yt0Var = (yt0) obj;
        r43 r43Var = yt0Var.unknownFields;
        r43 r43Var2 = ((yt0) obj2).unknownFields;
        r43 r43Var3 = r43.f;
        if (!r43Var3.equals(r43Var2)) {
            if (r43Var3.equals(r43Var)) {
                int i = r43Var.a + r43Var2.a;
                int[] iArrCopyOf = Arrays.copyOf(r43Var.b, i);
                System.arraycopy(r43Var2.b, 0, iArrCopyOf, r43Var.a, r43Var2.a);
                Object[] objArrCopyOf = Arrays.copyOf(r43Var.c, i);
                System.arraycopy(r43Var2.c, 0, objArrCopyOf, r43Var.a, r43Var2.a);
                r43Var = new r43(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                r43Var.getClass();
                if (!r43Var2.equals(r43Var3)) {
                    if (!r43Var.e) {
                        dk0.p();
                        return;
                    }
                    int i2 = r43Var.a + r43Var2.a;
                    r43Var.a(i2);
                    System.arraycopy(r43Var2.b, 0, r43Var.b, r43Var.a, r43Var2.a);
                    System.arraycopy(r43Var2.c, 0, r43Var.c, r43Var.a, r43Var2.a);
                    r43Var.a = i2;
                }
            }
        }
        yt0Var.unknownFields = r43Var;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void m(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.o(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            Logger logger = kz.f;
            i3++;
        }
        kzVar.D(i3);
        while (i2 < list.size()) {
            kzVar.m(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void n(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                double dDoubleValue = ((Double) list.get(i2)).doubleValue();
                kzVar.getClass();
                kzVar.t(i, Double.doubleToRawLongBits(dDoubleValue));
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            Logger logger = kz.f;
            i3 += 8;
        }
        kzVar.D(i3);
        while (i2 < list.size()) {
            kzVar.u(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void o(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.v(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ += kz.j(((Integer) list.get(i3)).intValue());
        }
        kzVar.D(iJ);
        while (i2 < list.size()) {
            kzVar.w(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void p(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.r(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = kz.f;
            i3 += 4;
        }
        kzVar.D(i3);
        while (i2 < list.size()) {
            kzVar.s(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void q(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.t(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = kz.f;
            i3 += 8;
        }
        kzVar.D(i3);
        while (i2 < list.size()) {
            kzVar.u(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void r(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                float fFloatValue = ((Float) list.get(i2)).floatValue();
                kzVar.getClass();
                kzVar.r(i, Float.floatToRawIntBits(fFloatValue));
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            Logger logger = kz.f;
            i3 += 4;
        }
        kzVar.D(i3);
        while (i2 < list.size()) {
            kzVar.s(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void s(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.v(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ += kz.j(((Integer) list.get(i3)).intValue());
        }
        kzVar.D(iJ);
        while (i2 < list.size()) {
            kzVar.w(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void t(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.E(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ += kz.j(((Long) list.get(i3)).longValue());
        }
        kzVar.D(iJ);
        while (i2 < list.size()) {
            kzVar.F(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void u(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.r(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = kz.f;
            i3 += 4;
        }
        kzVar.D(i3);
        while (i2 < list.size()) {
            kzVar.s(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void v(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.t(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = kz.f;
            i3 += 8;
        }
        kzVar.D(i3);
        while (i2 < list.size()) {
            kzVar.u(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void w(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                kzVar.C(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int iIntValue2 = ((Integer) list.get(i4)).intValue();
            i3 += kz.i((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        kzVar.D(i3);
        while (i2 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            kzVar.D((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i2++;
        }
    }

    public static void x(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                kzVar.E(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iJ += kz.j((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        kzVar.D(iJ);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            kzVar.F((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i2++;
        }
    }

    public static void y(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.C(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += kz.i(((Integer) list.get(i4)).intValue());
        }
        kzVar.D(i3);
        while (i2 < list.size()) {
            kzVar.D(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void z(int i, List list, uf1 uf1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kz kzVar = (kz) uf1Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kzVar.E(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        kzVar.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ += kz.j(((Long) list.get(i3)).longValue());
        }
        kzVar.D(iJ);
        while (i2 < list.size()) {
            kzVar.F(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static Object j(Object obj, int i, w21 w21Var, Object obj2, s43 s43Var) {
        return obj2;
    }
}
