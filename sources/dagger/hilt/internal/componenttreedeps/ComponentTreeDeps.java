package dagger.hilt.internal.componenttreedeps;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface ComponentTreeDeps {
    Class<?>[] aggregatedDeps() default {};

    Class<?>[] aliasOfDeps() default {};

    Class<?>[] defineComponentDeps() default {};

    Class<?>[] earlyEntryPointDeps() default {};

    Class<?>[] rootDeps() default {};

    Class<?>[] uninstallModulesDeps() default {};
}
