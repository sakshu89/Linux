package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vg0 implements s40 {
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ vg0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.s40
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                ((s40) this.b).getClass();
                ((s40) this.b).accept(obj);
                return;
            case 1:
                cp0 cp0Var = (cp0) obj;
                if (cp0Var == null) {
                    cp0Var = new cp0(-3);
                }
                ((l11) this.b).C(cp0Var);
                return;
            default:
                cp0 cp0Var2 = (cp0) obj;
                synchronized (dp0.c) {
                    try {
                        pk2 pk2Var = dp0.d;
                        ArrayList arrayList = (ArrayList) pk2Var.get((String) this.b);
                        if (arrayList == null) {
                            return;
                        }
                        pk2Var.remove((String) this.b);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((s40) arrayList.get(i)).accept(cp0Var2);
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }
}
