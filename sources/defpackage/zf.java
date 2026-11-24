package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zf extends eb4 {
    public static volatile zf k;
    public final gb0 j = new gb0();

    public static zf a() {
        if (k != null) {
            return k;
        }
        synchronized (zf.class) {
            try {
                if (k == null) {
                    k = new zf();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return k;
    }
}
