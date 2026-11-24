package defpackage;

import com.ibm.icu.impl.locale.BaseLocale;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ub1 {
    public static final HashMap a = new HashMap();
    public static final HashMap b = new HashMap();

    public static void a(Constructor constructor, nb1 nb1Var) {
        try {
            constructor.newInstance(nb1Var).getClass();
            throw new ClassCastException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0102  */
    /* JADX WARN: Code duplicated, block: B:59:0x0104  */
    /* JADX WARN: Code duplicated, block: B:61:0x0107  */
    /* JADX WARN: Code duplicated, block: B:77:0x013d  */
    /* JADX WARN: Code duplicated, block: B:90:0x013b A[SYNTHETIC] */
    public static int b(Class cls) {
        Constructor<?> declaredConstructor;
        boolean zBooleanValue;
        Class<?>[] interfaces;
        int i;
        boolean z;
        Class<?> cls2;
        HashMap map = a;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r3 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r3 != null ? r3.getName() : "";
                name.getClass();
                if (name.length() != 0) {
                    canonicalName.getClass();
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                canonicalName.getClass();
                String strConcat = js2.i(canonicalName, ".", BaseLocale.SEP).concat("_LifecycleAdapter");
                if (name.length() != 0) {
                    strConcat = name + '.' + strConcat;
                }
                declaredConstructor = Class.forName(strConcat).getDeclaredConstructor(cls);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                declaredConstructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap map2 = b;
            if (declaredConstructor == null) {
                gy gyVar = gy.c;
                HashMap map3 = gyVar.b;
                Boolean bool = (Boolean) map3.get(cls);
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                map3.put(cls, Boolean.FALSE);
                                zBooleanValue = false;
                                break;
                            }
                            if (((hq1) declaredMethods[i3].getAnnotation(hq1.class)) != null) {
                                gyVar.a(cls, declaredMethods);
                                zBooleanValue = true;
                                break;
                            }
                            i3++;
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
                    }
                }
                if (!zBooleanValue) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && nb1.class.isAssignableFrom(superclass)) {
                        superclass.getClass();
                        if (b(superclass) != 1) {
                            Object obj = map2.get(superclass);
                            obj.getClass();
                            arrayList = new ArrayList((Collection) obj);
                            interfaces = cls.getInterfaces();
                            interfaces.getClass();
                            i = 0;
                            while (true) {
                                if (i < interfaces.length) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    if (arrayList != null) {
                                        break;
                                    }
                                    map2.put(cls, arrayList);
                                } else {
                                    int i4 = i + 1;
                                    cls2 = interfaces[i];
                                    if (cls2 == null) {
                                    }
                                    i = i4;
                                }
                            }
                        }
                    } else {
                        interfaces = cls.getInterfaces();
                        interfaces.getClass();
                        i = 0;
                        while (true) {
                            if (i < interfaces.length) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                if (arrayList != null) {
                                    break;
                                }
                                map2.put(cls, arrayList);
                            } else {
                                int i5 = i + 1;
                                try {
                                    cls2 = interfaces[i];
                                    if (cls2 == null && nb1.class.isAssignableFrom(cls2)) {
                                        cls2.getClass();
                                        if (b(cls2) == 1) {
                                            break;
                                        }
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        Object obj2 = map2.get(cls2);
                                        obj2.getClass();
                                        arrayList.addAll((Collection) obj2);
                                    }
                                    i = i5;
                                } catch (ArrayIndexOutOfBoundsException e3) {
                                    kf2.g(e3.getMessage());
                                    return 0;
                                }
                            }
                        }
                    }
                }
            } else {
                map2.put(cls, nz.h(declaredConstructor));
            }
            i2 = 2;
            break;
        }
        map.put(cls, Integer.valueOf(i2));
        return i2;
    }
}
