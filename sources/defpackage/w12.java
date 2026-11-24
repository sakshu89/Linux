package defpackage;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w12 {
    public static final w12 c = new w12();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final q82 a = new q82(1);

    public final db2 a(Class cls) {
        xk0 xk0Var;
        db2 db2VarW;
        Class cls2;
        x21.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.b;
        db2 db2Var = (db2) concurrentHashMap.get(cls);
        if (db2Var != null) {
            return db2Var;
        }
        q82 q82Var = this.a;
        q82Var.getClass();
        Class cls3 = gb2.a;
        if (!yt0.class.isAssignableFrom(cls) && (cls2 = gb2.a) != null && !cls2.isAssignableFrom(cls)) {
            og.i("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            return null;
        }
        v22 v22VarA = ((ng1) q82Var.a).a(cls);
        if ((v22VarA.d & 2) == 2) {
            if (yt0.class.isAssignableFrom(cls)) {
                db2VarW = new wi1(gb2.c, yk0.a, v22VarA.a);
            } else {
                s43 s43Var = gb2.b;
                xk0 xk0Var2 = yk0.b;
                if (xk0Var2 == null) {
                    og.n("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                db2VarW = new wi1(s43Var, xk0Var2, v22VarA.a);
            }
        } else if (yt0.class.isAssignableFrom(cls)) {
            tn1 tn1Var = un1.b;
            sc1 sc1Var = tc1.b;
            s43 s43Var2 = gb2.c;
            xk0 xk0Var3 = cq.x(v22VarA.a()) != 1 ? yk0.a : null;
            yg1 yg1Var = zg1.b;
            if (!(v22VarA instanceof v22)) {
                int[] iArr = ui1.n;
                dk0.t();
                return null;
            }
            db2VarW = ui1.w(v22VarA, tn1Var, sc1Var, s43Var2, xk0Var3, yg1Var);
        } else {
            tn1 tn1Var2 = un1.a;
            sc1 sc1Var2 = tc1.a;
            s43 s43Var3 = gb2.b;
            if (cq.x(v22VarA.a()) != 1) {
                xk0 xk0Var4 = yk0.b;
                if (xk0Var4 == null) {
                    og.n("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                xk0Var = xk0Var4;
            } else {
                xk0Var = null;
            }
            yg1 yg1Var2 = zg1.a;
            if (!(v22VarA instanceof v22)) {
                int[] iArr2 = ui1.n;
                dk0.t();
                return null;
            }
            db2VarW = ui1.w(v22VarA, tn1Var2, sc1Var2, s43Var3, xk0Var, yg1Var2);
        }
        db2 db2Var2 = (db2) concurrentHashMap.putIfAbsent(cls, db2VarW);
        return db2Var2 != null ? db2Var2 : db2VarW;
    }
}
