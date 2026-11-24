package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ap1 extends ud3 implements ly0 {
    public final Object b;

    public ap1(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper", 1);
        this.b = obj;
    }

    public static ly0 f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return iInterfaceQueryLocalInterface instanceof ly0 ? (ly0) iInterfaceQueryLocalInterface : new xy3(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 1);
    }

    public static Object g(ly0 ly0Var) {
        if (ly0Var instanceof ap1) {
            return ((ap1) ly0Var).b;
        }
        IBinder iBinderAsBinder = ly0Var.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            og.i(ky0.h(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
            return null;
        }
        jg1.d(field);
        if (field.isAccessible()) {
            og.i("IObjectWrapper declared field not private!");
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
