package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pp3 implements Serializable {
    public static qp3 d(Object obj) {
        obj.getClass();
        return new qp3(obj);
    }

    public abstract Object a();

    public abstract Object b();

    public abstract boolean c();

    public abstract boolean equals(Object obj);

    public abstract int hashCode();
}
