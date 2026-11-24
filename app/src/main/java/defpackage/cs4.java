package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cs4 {
    public static long a(long j, c81 c81Var) {
        c81 c81Var2 = c81.a;
        return r40.a(c81Var == c81Var2 ? q40.j(j) : q40.i(j), c81Var == c81Var2 ? q40.h(j) : q40.g(j), c81Var == c81Var2 ? q40.i(j) : q40.j(j), c81Var == c81Var2 ? q40.g(j) : q40.h(j));
    }

    public static long b(int i, long j) {
        return r40.a(0, q40.h(j), (i & 4) != 0 ? q40.i(j) : 0, q40.g(j));
    }

    public static final long c(long j) {
        return r40.a(q40.j(j), q40.h(j), q40.i(j), q40.g(j));
    }
}
