package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class g73 {
    public final ng a;
    public final ng b;
    public final ng c;

    public g73(ng ngVar, ng ngVar2, ng ngVar3) {
        this.a = ngVar;
        this.b = ngVar2;
        this.c = ngVar3;
    }

    public abstract h73 a();

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        ng ngVar = this.c;
        Class cls2 = (Class) ngVar.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(ky0.k(cls.getPackage().getName(), ".", cls.getSimpleName(), "Parcelizer"), false, cls.getClassLoader());
        ngVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException {
        ng ngVar = this.a;
        Method method = (Method) ngVar.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, g73.class.getClassLoader()).getDeclaredMethod("read", g73.class);
        ngVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        ng ngVar = this.b;
        Method method = (Method) ngVar.get(name);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, g73.class);
        ngVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i);

    public final Parcelable f(Parcelable parcelable, int i) {
        if (!e(i)) {
            return parcelable;
        }
        return ((h73) this).e.readParcelable(h73.class.getClassLoader());
    }

    public final i73 g() {
        String string = ((h73) this).e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (i73) c(string).invoke(null, a());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public abstract void h(int i);

    public final void i(i73 i73Var) {
        if (i73Var == null) {
            ((h73) this).e.writeString(null);
            return;
        }
        try {
            ((h73) this).e.writeString(b(i73Var.getClass()).getName());
            h73 h73VarA = a();
            try {
                d(i73Var.getClass()).invoke(null, i73Var, h73VarA);
                Parcel parcel = h73VarA.e;
                int i = h73VarA.i;
                if (i >= 0) {
                    int i2 = h73VarA.d.get(i);
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(iDataPosition - i2);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
                }
                throw ((RuntimeException) e4.getCause());
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(i73Var.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
