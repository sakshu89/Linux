package defpackage;

import com.ibm.icu.text.DateFormat;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xx2 {
    public static final String a = js2.h(DateFormat.HOUR24, 10);

    public static final long a(yz2 yz2Var, jc0 jc0Var, qo0 qo0Var, String str, int i) {
        ia iaVarA = e8.a(str, yz2Var, r40.b(0, 0, 15), jc0Var, qo0Var, i, 64);
        return (((long) mb4.a(iaVarA.a.a())) << 32) | (((long) mb4.a(iaVarA.b())) & 4294967295L);
    }
}
