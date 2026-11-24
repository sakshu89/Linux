package defpackage;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rk4 implements d22 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ rk4(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.d22
    public final Object get() {
        int i = this.a;
        int i2 = 25;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((b13) obj).f(new qi0("json"), nr4.u);
            case 1:
                return ((b13) obj).f(new qi0("proto"), fl4.s);
            case 2:
                return ((b13) obj).f(new qi0("json"), new fl4(i2));
            case 3:
                return ((b13) obj).f(new qi0("proto"), new y74(i2));
            default:
                String str = (String) obj;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new p31("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e) {
                    throw new p31(cq.v("Could not instantiate ", str, "."), e);
                } catch (InstantiationException e2) {
                    throw new p31(cq.v("Could not instantiate ", str, "."), e2);
                } catch (NoSuchMethodException e3) {
                    throw new p31(cq.j("Could not instantiate ", str), e3);
                } catch (InvocationTargetException e4) {
                    throw new p31(cq.j("Could not instantiate ", str), e4);
                }
        }
    }
}
