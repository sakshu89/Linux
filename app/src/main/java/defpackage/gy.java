package defpackage;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gy {
    public static final gy c = new gy();
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();

    public static void b(HashMap map, fy fyVar, db1 db1Var, Class cls) {
        db1 db1Var2 = (db1) map.get(fyVar);
        if (db1Var2 == null || db1Var == db1Var2) {
            if (db1Var2 == null) {
                map.put(fyVar, db1Var);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + fyVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + db1Var2 + ", new value " + db1Var);
    }

    public final ey a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.a;
        if (superclass != null) {
            ey eyVarA = (ey) map2.get(superclass);
            if (eyVarA == null) {
                eyVarA = a(superclass, null);
            }
            map.putAll(eyVarA.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            ey eyVarA2 = (ey) map2.get(cls2);
            if (eyVarA2 == null) {
                eyVarA2 = a(cls2, null);
            }
            for (Map.Entry entry : eyVarA2.b.entrySet()) {
                b(map, (fy) entry.getKey(), (db1) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            hq1 hq1Var = (hq1) method.getAnnotation(hq1.class);
            if (hq1Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!ob1.class.isAssignableFrom(parameterTypes[0])) {
                        og.i("invalid parameter type. Must be one and instanceof LifecycleOwner");
                        return null;
                    }
                    i = 1;
                }
                db1 db1VarValue = hq1Var.value();
                if (parameterTypes.length > 1) {
                    if (!db1.class.isAssignableFrom(parameterTypes[1])) {
                        og.i("invalid parameter type. second arg must be an event");
                        return null;
                    }
                    if (db1VarValue != db1.ON_ANY) {
                        og.i("Second arg is supported only for ON_ANY value");
                        return null;
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    og.i("cannot have more than 2 params");
                    return null;
                }
                b(map, new fy(i, method), db1VarValue, cls);
                z = true;
            }
        }
        ey eyVar = new ey(map);
        map2.put(cls, eyVar);
        this.b.put(cls, Boolean.valueOf(z));
        return eyVar;
    }
}
