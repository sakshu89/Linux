package defpackage;

import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.TestSingletonComponent;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fn4 {
    public static Object a(Object obj, Class cls) {
        if (!(obj instanceof GeneratedComponent)) {
            if (obj instanceof GeneratedComponentManager) {
                return a(((GeneratedComponentManager) obj).generatedComponent(), cls);
            }
            throw new IllegalStateException("Given component holder " + obj.getClass() + " does not implement " + GeneratedComponent.class + " or " + GeneratedComponentManager.class);
        }
        if (obj instanceof TestSingletonComponent) {
            boolean z = false;
            for (Annotation annotation : cls.getAnnotations()) {
                if (annotation.annotationType().getCanonicalName().contentEquals("dagger.hilt.android.EarlyEntryPoint")) {
                    z = true;
                    break;
                }
            }
            Preconditions.checkState(!z, "Interface, %s, annotated with @EarlyEntryPoint should be called with EarlyEntryPoints.get() rather than EntryPoints.get()", cls.getCanonicalName());
        }
        return cls.cast(obj);
    }
}
