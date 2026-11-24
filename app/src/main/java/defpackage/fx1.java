package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fx1 {
    public static final Method a;
    public static final Method b;

    static {
        Method method;
        Method method2;
        Method[] methods = Throwable.class.getMethods();
        methods.getClass();
        int length = methods.length;
        int i = 0;
        while (true) {
            method = null;
            if (i >= length) {
                method2 = null;
                break;
            }
            method2 = methods[i];
            if (g31.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                parameterTypes.getClass();
                if (g31.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    break;
                }
            }
            i++;
        }
        a = method2;
        for (Method method3 : methods) {
            if (g31.a(method3.getName(), "getSuppressed")) {
                method = method3;
                break;
            }
        }
        b = method;
    }
}
