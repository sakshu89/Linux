package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class rh4 {
    public static final void a(long j, js1 js1Var) {
        if (js1Var == js1.a) {
            if (q40.g(j) != Integer.MAX_VALUE) {
                return;
            }
            c11.c("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        } else {
            if (q40.h(j) != Integer.MAX_VALUE) {
                return;
            }
            c11.c("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        }
    }

    public static void b(int i, int i2) {
        String strC;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strC = th4.c("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    og.i(ky0.h(i2, "negative size: "));
                    return;
                }
                strC = th4.c("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strC);
        }
    }

    public static void c(int i, int i2) {
        if (i < 0 || i > i2) {
            og.o(e(i, i2, "index"));
        }
    }

    public static void d(int i, int i2, int i3) {
        String strE;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strE = e(i, i3, "start index");
            } else {
                strE = (i2 < 0 || i2 > i3) ? e(i2, i3, "end index") : th4.c("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strE);
        }
    }

    public static String e(int i, int i2, String str) {
        if (i < 0) {
            return th4.c("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return th4.c("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        og.i(ky0.h(i2, "negative size: "));
        return null;
    }
}
