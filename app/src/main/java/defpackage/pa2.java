package defpackage;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pa2 {
    public static final List a = nz.i(Application.class, fa2.class);
    public static final List b = nz.h(fa2.class);

    public static final Constructor a(Class cls, List list) {
        list.getClass();
        Constructor<?>[] constructors = cls.getConstructors();
        constructors.getClass();
        int i = 0;
        while (true) {
            if (!(i < constructors.length)) {
                break;
            }
            int i2 = i + 1;
            try {
                Constructor<?> constructor = constructors[i];
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                parameterTypes.getClass();
                List listS = qg.s(parameterTypes);
                if (list.equals(listS)) {
                    return constructor;
                }
                if (list.size() == listS.size() && listS.containsAll(list)) {
                    throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
                }
                i = i2;
            } catch (ArrayIndexOutOfBoundsException e) {
                kf2.g(e.getMessage());
            }
        }
        return null;
    }

    public static final b83 b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (b83) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            dk0.k("Failed to access ", cls, e);
            return null;
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
