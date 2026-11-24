package defpackage;

import com.ibm.icu.text.SymbolTable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dy implements cy {
    public static final Map b;
    public final Class a;

    static {
        List listI = nz.i(fq0.class, hq0.class, vq0.class, wq0.class, xq0.class, yq0.class, zq0.class, ar0.class, br0.class, cr0.class, gq0.class, iq0.class, jq0.class, kq0.class, lq0.class, mq0.class, nq0.class, oq0.class, pq0.class, qq0.class, sq0.class, tq0.class, uq0.class);
        ArrayList arrayList = new ArrayList(nz.d(listI));
        int i = 0;
        for (Object obj : listI) {
            int i2 = i + 1;
            if (i < 0) {
                nz.n();
                throw null;
            }
            arrayList.add(new wt1((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        b = bh1.g(arrayList);
    }

    public dy(Class cls) {
        this.a = cls;
    }

    @Override // defpackage.cy
    public final Class a() {
        return this.a;
    }

    public final String b() {
        String strB;
        Class cls = this.a;
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strB2 = th4.b(cls.getName());
                return strB2 == null ? cls.getSimpleName() : strB2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strB = th4.b(componentType.getName())) != null) {
                strConcat = strB.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return cs2.R(simpleName, enclosingMethod.getName() + SymbolTable.SYMBOL_REF);
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            int iX = cs2.x(simpleName, SymbolTable.SYMBOL_REF, 0, 6);
            return iX == -1 ? simpleName : simpleName.substring(iX + 1, simpleName.length());
        }
        return cs2.R(simpleName, enclosingConstructor.getName() + SymbolTable.SYMBOL_REF);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof dy) && jp4.b(this).equals(jp4.b((dy) obj));
    }

    public final int hashCode() {
        return jp4.b(this).hashCode();
    }

    public final String toString() {
        return this.a.toString() + " (Kotlin reflection is not available)";
    }
}
