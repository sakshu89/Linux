package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class z50 {
    public static final Set a = Collections.unmodifiableSet(EnumSet.of(is.e, is.f, is.i, is.j));
    public static final Set b = Collections.unmodifiableSet(EnumSet.of(js.e, js.a));
    public static final Set c;
    public static final Set d;

    static {
        hs hsVar = hs.f;
        hs hsVar2 = hs.e;
        hs hsVar3 = hs.a;
        Set setUnmodifiableSet = Collections.unmodifiableSet(EnumSet.of(hsVar, hsVar2, hsVar3));
        c = setUnmodifiableSet;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) setUnmodifiableSet);
        enumSetCopyOf.remove(hsVar2);
        enumSetCopyOf.remove(hsVar3);
        d = Collections.unmodifiableSet(enumSetCopyOf);
    }
}
