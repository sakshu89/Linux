package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ie1 {
    public static final z12 a;

    static {
        Object h72Var;
        try {
            ClassLoader classLoader = ob1.class.getClassLoader();
            classLoader.getClass();
            Method method = classLoader.loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalLifecycleOwner", null);
            Annotation[] annotations = method.getAnnotations();
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    Object objInvoke = method.invoke(null, null);
                    if (objInvoke instanceof z12) {
                        h72Var = (z12) objInvoke;
                        break;
                    }
                } else if (!(annotations[i] instanceof oc0)) {
                    i++;
                }
                h72Var = null;
                break;
            }
        } catch (Throwable th) {
            h72Var = new h72(th);
        }
        z12 sr2Var = (z12) (h72Var instanceof h72 ? null : h72Var);
        if (sr2Var == null) {
            sr2Var = new sr2(new e4(23));
        }
        a = sr2Var;
    }
}
