package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class lo4 {
    public static final void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            c11.a("both minLines " + i + " and maxLines " + i2 + " must be greater than zero");
        }
        if (i <= i2) {
            return;
        }
        c11.a("minLines " + i + " must be less than or equal to maxLines " + i2);
    }
}
