package defpackage;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bv3 {
    public static final bv3 c = new bv3();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final q82 a = new q82(2);

    public final ev3 a(Class cls) {
        ev3 zu3Var;
        Charset charset = nu3.a;
        if (cls == null) {
            dk0.n("messageType");
            return null;
        }
        ConcurrentHashMap concurrentHashMap = this.b;
        ev3 ev3Var = (ev3) concurrentHashMap.get(cls);
        if (ev3Var != null) {
            return ev3Var;
        }
        q82 q82Var = this.a;
        q82Var.getClass();
        el1 el1Var = fv3.a;
        gu3.class.isAssignableFrom(cls);
        dv3 dv3VarD = ((wj1) q82Var.a).d(cls);
        if ((dv3VarD.d & 2) == 2) {
            el1 el1Var2 = fv3.a;
            nr4 nr4Var = vt3.a;
            zu3Var = new zu3(el1Var2, dv3VarD.a);
        } else {
            int i = av3.a;
            int i2 = ru3.a;
            el1 el1Var3 = fv3.a;
            nr4 nr4Var2 = dv3VarD.a() + (-1) != 1 ? vt3.a : null;
            int i3 = vu3.a;
            zu3Var = yu3.w(dv3VarD, el1Var3, nr4Var2);
        }
        ev3 ev3Var2 = (ev3) concurrentHashMap.putIfAbsent(cls, zu3Var);
        return ev3Var2 == null ? zu3Var : ev3Var2;
    }
}
