package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qy3 extends wx3 {
    public final Object a;
    public int b;
    public final /* synthetic */ zy3 c;

    public qy3(zy3 zy3Var, int i) {
        this.c = zy3Var;
        Object obj = zy3.s;
        this.a = zy3Var.b()[i];
        this.b = i;
    }

    public final void a() {
        int i = this.b;
        Object obj = this.a;
        zy3 zy3Var = this.c;
        if (i != -1 && i < zy3Var.size()) {
            if (di4.b(obj, zy3Var.b()[this.b])) {
                return;
            }
        }
        Object obj2 = zy3.s;
        this.b = zy3Var.h(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        zy3 zy3Var = this.c;
        Map mapD = zy3Var.d();
        if (mapD != null) {
            return mapD.get(this.a);
        }
        a();
        int i = this.b;
        if (i == -1) {
            return null;
        }
        return zy3Var.c()[i];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        zy3 zy3Var = this.c;
        Map mapD = zy3Var.d();
        Object obj2 = this.a;
        if (mapD != null) {
            return mapD.put(obj2, obj);
        }
        a();
        int i = this.b;
        if (i == -1) {
            zy3Var.put(obj2, obj);
            return null;
        }
        Object obj3 = zy3Var.c()[i];
        zy3Var.c()[this.b] = obj;
        return obj3;
    }
}
