package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pp implements w41, Serializable {
    public transient w41 a;
    public final Object b;
    public final Class c;
    public final String e;
    public final String f;
    public final boolean i;

    public pp(Object obj, Class cls, String str, String str2, boolean z) {
        this.b = obj;
        this.c = cls;
        this.e = str;
        this.f = str2;
        this.i = z;
    }

    public abstract w41 d();

    public final cy f() {
        boolean z = this.i;
        Class cls = this.c;
        if (!z) {
            return u42.a(cls);
        }
        u42.a.getClass();
        return new mt1(cls);
    }
}
