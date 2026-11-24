package defpackage;

import android.graphics.Canvas;
import android.os.Build;
import com.ibm.icu.lang.UCharacterEnums;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fh4 {
    public static Method a;
    public static Method b;
    public static boolean c;

    public static void a(Canvas canvas, boolean z) {
        Method method;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            if (z) {
                canvas.enableZ();
                return;
            } else {
                canvas.disableZ();
                return;
            }
        }
        if (!c) {
            try {
                if (i == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass());
                    a = (Method) declaredMethod.invoke(Canvas.class, "insertReorderBarrier", new Class[0]);
                    b = (Method) declaredMethod.invoke(Canvas.class, "insertInorderBarrier", new Class[0]);
                } else {
                    a = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                    b = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                }
                Method method2 = a;
                if (method2 != null) {
                    method2.setAccessible(true);
                }
                Method method3 = b;
                if (method3 != null) {
                    method3.setAccessible(true);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            c = true;
        }
        if (z) {
            try {
                Method method4 = a;
                if (method4 != null) {
                    method4.invoke(canvas, null);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (z || (method = b) == null) {
            return;
        }
        method.invoke(canvas, null);
    }

    public static int b(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iB = hh4.b(obj);
        int i2 = iB & i;
        int iC = c(i2, obj3);
        if (iC != 0) {
            int i3 = ~i;
            int i4 = iB & i3;
            int i5 = -1;
            while (true) {
                int i6 = iC - 1;
                int i7 = iArr[i6];
                int i8 = i7 & i;
                if ((i7 & i3) != i4 || !di4.b(obj, objArr[i6]) || (objArr2 != null && !di4.b(obj2, objArr2[i6]))) {
                    if (i8 == 0) {
                        break;
                    }
                    i5 = i6;
                    iC = i8;
                } else {
                    if (i5 == -1) {
                        e(i2, i8, obj3);
                        return i6;
                    }
                    iArr[i5] = (iArr[i5] & i3) | (i8 & i);
                    return i6;
                }
            }
        }
        return -1;
    }

    public static int c(int i, Object obj) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        }
        return obj instanceof short[] ? (char) ((short[]) obj)[i] : ((int[]) obj)[i];
    }

    public static Object d(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            og.i(ky0.h(i, "must be power of 2 between 2^1 and 2^30: "));
            return null;
        }
        if (i <= 256) {
            return new byte[i];
        }
        return i <= 65536 ? new short[i] : new int[i];
    }

    public static void e(int i, int i2, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }
}
