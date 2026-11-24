package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class nq4 {
    public static final void a(int i, int i2) {
        if (i < 0 || i >= i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
        }
    }

    public static final void b(int i, int i2) {
        if (i < 0 || i > i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
        }
    }

    public static final void c(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            dk0.f(i3, cq.p("fromIndex: ", i, ", toIndex: ", i2, ", size: "));
        } else {
            if (i <= i2) {
                return;
            }
            og.i(ky0.i("fromIndex: ", i, i2, " > toIndex: "));
        }
    }
}
