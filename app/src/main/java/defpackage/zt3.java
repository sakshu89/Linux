package defpackage;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zt3 {
    public static final Object[] a = new Object[0];

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(j12 j12Var, l52 l52Var, y50 y50Var) {
        h12 h12Var;
        if (y50Var instanceof h12) {
            h12Var = (h12) y50Var;
            int i = h12Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                h12Var.i = i - Integer.MIN_VALUE;
            } else {
                h12Var = new h12(y50Var);
            }
        } else {
            h12Var = new h12(y50Var);
        }
        Object obj = h12Var.f;
        int i2 = h12Var.i;
        int i3 = 1;
        try {
            if (i2 == 0) {
                bz3.g(obj);
                j70 j70Var = h12Var.b;
                j70Var.getClass();
                if (j70Var.v(nr4.k) != j12Var) {
                    og.n("awaitClose() can only be invoked from the producer context");
                    return null;
                }
                h12Var.e = l52Var;
                h12Var.i = 1;
                yv yvVar = new yv(1, fp4.b(h12Var));
                yvVar.x();
                j12Var.i.A(new gn(i3, yvVar));
                Object objV = yvVar.v();
                t70 t70Var = t70.a;
                if (objV == t70Var) {
                    return t70Var;
                }
            } else {
                if (i2 != 1) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                l52Var = h12Var.e;
                bz3.g(obj);
            }
            l52Var.a();
            return q43.a;
        } catch (Throwable th) {
            l52Var.a();
            throw th;
        }
    }

    public static final Object[] b(Collection collection) {
        collection.getClass();
        int size = collection.size();
        Object[] objArr = a;
        if (size == 0) {
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return objArr;
        }
        Object[] objArrCopyOf = new Object[size];
        int i = 0;
        while (true) {
            int i2 = i + 1;
            objArrCopyOf[i] = it.next();
            if (i2 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    i3 = 2147483645;
                    if (i2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
            } else if (!it.hasNext()) {
                return Arrays.copyOf(objArrCopyOf, i2);
            }
            i = i2;
        }
    }

    public static final Object[] c(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        collection.getClass();
        objArr.getClass();
        int size = collection.size();
        int i = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    objNewInstance.getClass();
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i2 = i + 1;
                    objArrCopyOf[i] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf != objArr) {
                            return Arrays.copyOf(objArrCopyOf, i2);
                        }
                        objArr[i2] = null;
                        return objArr;
                    }
                    i = i2;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }

    public static ut3 d() {
        String strK;
        ClassLoader classLoader = zt3.class.getClassLoader();
        if (ut3.class.equals(ut3.class)) {
            strK = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!ut3.class.getPackage().equals(zt3.class.getPackage())) {
                og.i(ut3.class.getName());
                return null;
            }
            strK = ky0.k(ut3.class.getPackage().getName(), ".BlazeGenerated", ut3.class.getSimpleName(), "Loader");
        }
        try {
            try {
                try {
                    ky0.x(Class.forName(strK, true, classLoader).getConstructor(null).newInstance(null));
                    throw null;
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException(e);
                } catch (InstantiationException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException(e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            try {
                Iterator it = Arrays.asList(new zt3[0]).iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    try {
                        if (it.next() == null) {
                            throw null;
                        }
                        throw new ClassCastException();
                    } catch (ServiceConfigurationError e5) {
                        Logger.getLogger(st3.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(ut3.class.getSimpleName()), (Throwable) e5);
                    }
                }
                if (arrayList.size() == 1) {
                    return (ut3) arrayList.get(0);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                try {
                    return (ut3) ut3.class.getMethod("combine", Collection.class).invoke(null, arrayList);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(e6);
                } catch (NoSuchMethodException e7) {
                    throw new IllegalStateException(e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(e8);
                }
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }
}
