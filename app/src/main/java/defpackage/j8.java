package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j8 implements pd0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ j8(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // defpackage.pd0
    public final void a() {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((Context) obj2).getApplicationContext().unregisterComponentCallbacks((l8) obj);
                break;
            case 1:
                ((Context) obj2).getApplicationContext().unregisterComponentCallbacks((m8) obj);
                break;
            case 2:
                ((s01) obj2).a.k((q01) obj);
                break;
            case 3:
                ((ha1) obj2).c.k(obj);
                break;
            case 4:
                ((j23) obj2).j.remove((j23) obj);
                break;
            default:
                j23 j23Var = (j23) obj2;
                e23 e23Var = (e23) ((f23) obj).b.getValue();
                if (e23Var != null) {
                    j23Var.i.remove(e23Var.a);
                }
                break;
        }
    }
}
