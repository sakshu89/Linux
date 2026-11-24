package defpackage;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d83 extends f83 {
    public static d83 c;
    public static final y74 d = new y74(20);
    public final Application b;

    public d83(Application application) {
        this.b = application;
    }

    @Override // defpackage.f83, defpackage.e83
    public final b83 a(Class cls) {
        Application application = this.b;
        if (application != null) {
            return d(cls, application);
        }
        dk0.r("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        return null;
    }

    @Override // defpackage.f83, defpackage.e83
    public final b83 b(Class cls, jl1 jl1Var) {
        if (this.b != null) {
            return a(cls);
        }
        Application application = (Application) jl1Var.a.get(d);
        if (application != null) {
            return d(cls, application);
        }
        if (!wc.class.isAssignableFrom(cls)) {
            return kp4.a(cls);
        }
        og.i("CreationExtras must have an application by `APPLICATION_KEY`");
        return null;
    }

    public final b83 d(Class cls, Application application) {
        if (!wc.class.isAssignableFrom(cls)) {
            return kp4.a(cls);
        }
        try {
            b83 b83Var = (b83) cls.getConstructor(Application.class).newInstance(application);
            b83Var.getClass();
            return b83Var;
        } catch (IllegalAccessException e) {
            dk0.k("Cannot create an instance of ", cls, e);
            return null;
        } catch (InstantiationException e2) {
            dk0.k("Cannot create an instance of ", cls, e2);
            return null;
        } catch (NoSuchMethodException e3) {
            dk0.k("Cannot create an instance of ", cls, e3);
            return null;
        } catch (InvocationTargetException e4) {
            dk0.k("Cannot create an instance of ", cls, e4);
            return null;
        }
    }
}
