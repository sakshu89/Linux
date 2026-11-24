package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fv3 {
    public static final el1 a;

    static {
        bv3 bv3Var = bv3.c;
        a = new el1(22);
    }

    public static void a(int i, List list, py0 py0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof hu3)) {
            if (!z) {
                while (i2 < list.size()) {
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    st3Var.o(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int iB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iB += st3.b((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            st3Var.p(iB);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                st3Var.p((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        hu3 hu3Var = (hu3) list;
        if (!z) {
            while (i2 < hu3Var.c) {
                int iB2 = hu3Var.b(i2);
                st3Var.o(i, (iB2 >> 31) ^ (iB2 + iB2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int iB3 = 0;
        for (int i4 = 0; i4 < hu3Var.c; i4++) {
            int iB4 = hu3Var.b(i4);
            iB3 += st3.b((iB4 >> 31) ^ (iB4 + iB4));
        }
        st3Var.p(iB3);
        while (i2 < hu3Var.c) {
            int iB5 = hu3Var.b(i2);
            st3Var.p((iB5 >> 31) ^ (iB5 + iB5));
            i2++;
        }
    }

    public static void b(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof su3)) {
            if (!z) {
                while (i2 < list.size()) {
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    st3Var.q(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int iC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iC += st3.c((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            st3Var.p(iC);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                st3Var.r((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        su3 su3Var = (su3) list;
        if (!z) {
            while (i2 < su3Var.c) {
                long jB = su3Var.b(i2);
                st3Var.q(i, (jB >> 63) ^ (jB + jB));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int iC2 = 0;
        for (int i4 = 0; i4 < su3Var.c; i4++) {
            long jB2 = su3Var.b(i4);
            iC2 += st3.c((jB2 >> 63) ^ (jB2 + jB2));
        }
        st3Var.p(iC2);
        while (i2 < su3Var.c) {
            long jB3 = su3Var.b(i2);
            st3Var.r((jB3 >> 63) ^ (jB3 + jB3));
            i2++;
        }
    }

    public static void c(int i, List list, py0 py0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof hu3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.o(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int iB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iB += st3.b(((Integer) list.get(i3)).intValue());
            }
            st3Var.p(iB);
            while (i2 < list.size()) {
                st3Var.p(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        hu3 hu3Var = (hu3) list;
        if (!z) {
            while (i2 < hu3Var.c) {
                st3Var.o(i, hu3Var.b(i2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int iB2 = 0;
        for (int i4 = 0; i4 < hu3Var.c; i4++) {
            iB2 += st3.b(hu3Var.b(i4));
        }
        st3Var.p(iB2);
        while (i2 < hu3Var.c) {
            st3Var.p(hu3Var.b(i2));
            i2++;
        }
    }

    public static void d(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof su3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.q(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int iC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iC += st3.c(((Long) list.get(i3)).longValue());
            }
            st3Var.p(iC);
            while (i2 < list.size()) {
                st3Var.r(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        su3 su3Var = (su3) list;
        if (!z) {
            while (i2 < su3Var.c) {
                st3Var.q(i, su3Var.b(i2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int iC2 = 0;
        for (int i4 = 0; i4 < su3Var.c; i4++) {
            iC2 += st3.c(su3Var.b(i4));
        }
        st3Var.p(iC2);
        while (i2 < su3Var.c) {
            st3Var.r(su3Var.b(i2));
            i2++;
        }
    }

    public static boolean e(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int f(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof hu3)) {
            int iC = 0;
            while (i < size) {
                iC += st3.c(((Integer) list.get(i)).intValue());
                i++;
            }
            return iC;
        }
        hu3 hu3Var = (hu3) list;
        int iC2 = 0;
        while (i < size) {
            iC2 += st3.c(hu3Var.b(i));
            i++;
        }
        return iC2;
    }

    public static int g(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (st3.b(i << 3) + 4) * size;
    }

    public static int h(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (st3.b(i << 3) + 8) * size;
    }

    public static int i(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof hu3)) {
            int iC = 0;
            while (i < size) {
                iC += st3.c(((Integer) list.get(i)).intValue());
                i++;
            }
            return iC;
        }
        hu3 hu3Var = (hu3) list;
        int iC2 = 0;
        while (i < size) {
            iC2 += st3.c(hu3Var.b(i));
            i++;
        }
        return iC2;
    }

    public static int j(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof su3)) {
            int iC = 0;
            while (i < size) {
                iC += st3.c(((Long) list.get(i)).longValue());
                i++;
            }
            return iC;
        }
        su3 su3Var = (su3) list;
        int iC2 = 0;
        while (i < size) {
            iC2 += st3.c(su3Var.b(i));
            i++;
        }
        return iC2;
    }

    public static int k(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof hu3)) {
            int iB = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iB += st3.b((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iB;
        }
        hu3 hu3Var = (hu3) list;
        int iB2 = 0;
        while (i < size) {
            int iB3 = hu3Var.b(i);
            iB2 += st3.b((iB3 >> 31) ^ (iB3 + iB3));
            i++;
        }
        return iB2;
    }

    public static int l(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof su3)) {
            int iC = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iC += st3.c((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iC;
        }
        su3 su3Var = (su3) list;
        int iC2 = 0;
        while (i < size) {
            long jB = su3Var.b(i);
            iC2 += st3.c((jB >> 63) ^ (jB + jB));
            i++;
        }
        return iC2;
    }

    public static int m(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof hu3)) {
            int iB = 0;
            while (i < size) {
                iB += st3.b(((Integer) list.get(i)).intValue());
                i++;
            }
            return iB;
        }
        hu3 hu3Var = (hu3) list;
        int iB2 = 0;
        while (i < size) {
            iB2 += st3.b(hu3Var.b(i));
            i++;
        }
        return iB2;
    }

    public static int n(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof su3)) {
            int iC = 0;
            while (i < size) {
                iC += st3.c(((Long) list.get(i)).longValue());
                i++;
            }
            return iC;
        }
        su3 su3Var = (su3) list;
        int iC2 = 0;
        while (i < size) {
            iC2 += st3.c(su3Var.b(i));
            i++;
        }
        return iC2;
    }

    public static void o(Object obj, Object obj2) {
        hv3 hv3Var = ((du3) obj2).zbb.a;
        if (hv3Var.isEmpty()) {
            return;
        }
        du3 du3Var = (du3) obj;
        wt3 wt3Var = du3Var.zbb;
        if (wt3Var.b) {
            du3Var.zbb = wt3Var.clone();
        }
        wt3 wt3Var2 = du3Var.zbb;
        wt3Var2.getClass();
        if (hv3Var.b > 0) {
            wt3Var2.g(hv3Var.c(0));
            throw null;
        }
        Iterator it = hv3Var.a().iterator();
        if (it.hasNext()) {
            wt3Var2.g((Map.Entry) it.next());
            throw null;
        }
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
    public static void p(Object obj, Object obj2) {
        gu3 gu3Var = (gu3) obj;
        kv3 kv3Var = gu3Var.zbc;
        kv3 kv3Var2 = ((gu3) obj2).zbc;
        kv3 kv3Var3 = kv3.f;
        if (!kv3Var3.equals(kv3Var2)) {
            if (kv3Var3.equals(kv3Var)) {
                int i = kv3Var.a + kv3Var2.a;
                int[] iArrCopyOf = Arrays.copyOf(kv3Var.b, i);
                System.arraycopy(kv3Var2.b, 0, iArrCopyOf, kv3Var.a, kv3Var2.a);
                Object[] objArrCopyOf = Arrays.copyOf(kv3Var.c, i);
                System.arraycopy(kv3Var2.c, 0, objArrCopyOf, kv3Var.a, kv3Var2.a);
                kv3Var = new kv3(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                kv3Var.getClass();
                if (!kv3Var2.equals(kv3Var3)) {
                    if (!kv3Var.e) {
                        dk0.p();
                        return;
                    }
                    int i2 = kv3Var.a + kv3Var2.a;
                    kv3Var.e(i2);
                    System.arraycopy(kv3Var2.b, 0, kv3Var.b, kv3Var.a, kv3Var2.a);
                    System.arraycopy(kv3Var2.c, 0, kv3Var.c, kv3Var.a, kv3Var2.a);
                    kv3Var.a = i2;
                }
            }
        }
        gu3Var.zbc = kv3Var;
    }

    public static void q(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                boolean zBooleanValue = ((Boolean) list.get(i2)).booleanValue();
                st3Var.p(i << 3);
                st3Var.d(zBooleanValue ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        st3Var.p(i3);
        while (i2 < list.size()) {
            st3Var.d(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void r(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                st3Var.i(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        st3Var.p(i3);
        while (i2 < list.size()) {
            st3Var.j(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void s(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof hu3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.k(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int iC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iC += st3.c(((Integer) list.get(i3)).intValue());
            }
            st3Var.p(iC);
            while (i2 < list.size()) {
                st3Var.l(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        hu3 hu3Var = (hu3) list;
        if (!z) {
            while (i2 < hu3Var.c) {
                st3Var.k(i, hu3Var.b(i2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int iC2 = 0;
        for (int i4 = 0; i4 < hu3Var.c; i4++) {
            iC2 += st3.c(hu3Var.b(i4));
        }
        st3Var.p(iC2);
        while (i2 < hu3Var.c) {
            st3Var.l(hu3Var.b(i2));
            i2++;
        }
    }

    public static void t(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof hu3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.g(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            st3Var.p(i3);
            while (i2 < list.size()) {
                st3Var.h(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        hu3 hu3Var = (hu3) list;
        if (!z) {
            while (i2 < hu3Var.c) {
                st3Var.g(i, hu3Var.b(i2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < hu3Var.c; i6++) {
            hu3Var.b(i6);
            i5 += 4;
        }
        st3Var.p(i5);
        while (i2 < hu3Var.c) {
            st3Var.h(hu3Var.b(i2));
            i2++;
        }
    }

    public static void u(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof su3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.i(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            st3Var.p(i3);
            while (i2 < list.size()) {
                st3Var.j(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        su3 su3Var = (su3) list;
        if (!z) {
            while (i2 < su3Var.c) {
                st3Var.i(i, su3Var.b(i2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < su3Var.c; i6++) {
            su3Var.b(i6);
            i5 += 8;
        }
        st3Var.p(i5);
        while (i2 < su3Var.c) {
            st3Var.j(su3Var.b(i2));
            i2++;
        }
    }

    public static void v(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof yt3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.g(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).getClass();
                i3 += 4;
            }
            st3Var.p(i3);
            while (i2 < list.size()) {
                st3Var.h(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        yt3 yt3Var = (yt3) list;
        if (!z) {
            while (i2 < yt3Var.c) {
                yt3Var.d(i2);
                st3Var.g(i, Float.floatToRawIntBits(yt3Var.b[i2]));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < yt3Var.c; i6++) {
            yt3Var.d(i6);
            float f = yt3Var.b[i6];
            i5 += 4;
        }
        st3Var.p(i5);
        while (i2 < yt3Var.c) {
            yt3Var.d(i2);
            st3Var.h(Float.floatToRawIntBits(yt3Var.b[i2]));
            i2++;
        }
    }

    public static void w(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof hu3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.k(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int iC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iC += st3.c(((Integer) list.get(i3)).intValue());
            }
            st3Var.p(iC);
            while (i2 < list.size()) {
                st3Var.l(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        hu3 hu3Var = (hu3) list;
        if (!z) {
            while (i2 < hu3Var.c) {
                st3Var.k(i, hu3Var.b(i2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int iC2 = 0;
        for (int i4 = 0; i4 < hu3Var.c; i4++) {
            iC2 += st3.c(hu3Var.b(i4));
        }
        st3Var.p(iC2);
        while (i2 < hu3Var.c) {
            st3Var.l(hu3Var.b(i2));
            i2++;
        }
    }

    public static void x(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof su3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.q(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int iC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iC += st3.c(((Long) list.get(i3)).longValue());
            }
            st3Var.p(iC);
            while (i2 < list.size()) {
                st3Var.r(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        su3 su3Var = (su3) list;
        if (!z) {
            while (i2 < su3Var.c) {
                st3Var.q(i, su3Var.b(i2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int iC2 = 0;
        for (int i4 = 0; i4 < su3Var.c; i4++) {
            iC2 += st3.c(su3Var.b(i4));
        }
        st3Var.p(iC2);
        while (i2 < su3Var.c) {
            st3Var.r(su3Var.b(i2));
            i2++;
        }
    }

    public static void y(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof hu3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.g(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            st3Var.p(i3);
            while (i2 < list.size()) {
                st3Var.h(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        hu3 hu3Var = (hu3) list;
        if (!z) {
            while (i2 < hu3Var.c) {
                st3Var.g(i, hu3Var.b(i2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < hu3Var.c; i6++) {
            hu3Var.b(i6);
            i5 += 4;
        }
        st3Var.p(i5);
        while (i2 < hu3Var.c) {
            st3Var.h(hu3Var.b(i2));
            i2++;
        }
    }

    public static void z(int i, List list, py0 py0Var, boolean z) throws jz {
        if (list == null || list.isEmpty()) {
            return;
        }
        st3 st3Var = (st3) py0Var.b;
        int i2 = 0;
        if (!(list instanceof su3)) {
            if (!z) {
                while (i2 < list.size()) {
                    st3Var.i(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            st3Var.n(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            st3Var.p(i3);
            while (i2 < list.size()) {
                st3Var.j(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        su3 su3Var = (su3) list;
        if (!z) {
            while (i2 < su3Var.c) {
                st3Var.i(i, su3Var.b(i2));
                i2++;
            }
            return;
        }
        st3Var.n(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < su3Var.c; i6++) {
            su3Var.b(i6);
            i5 += 8;
        }
        st3Var.p(i5);
        while (i2 < su3Var.c) {
            st3Var.j(su3Var.b(i2));
            i2++;
        }
    }
}
