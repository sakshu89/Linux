package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nw1 extends y1 {
    public final /* synthetic */ int a;
    public final hw1 b;

    public /* synthetic */ nw1(hw1 hw1Var, int i) {
        this.a = i;
        this.b = hw1Var;
    }

    @Override // defpackage.y0
    public final int a() {
        int i = this.a;
        hw1 hw1Var = this.b;
        switch (i) {
            case 0:
                hw1Var.getClass();
                break;
            default:
                hw1Var.getClass();
                break;
        }
        return hw1Var.b;
    }

    @Override // defpackage.y0, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        int i = this.a;
        hw1 hw1Var = this.b;
        switch (i) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = hw1Var.get(entry.getKey());
                if (obj2 != null) {
                    return obj2.equals(entry.getValue());
                }
                return entry.getValue() == null && hw1Var.containsKey(entry.getKey());
            default:
                return hw1Var.containsKey(obj);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                x23 x23Var = this.b.a;
                y23[] y23VarArr = new y23[8];
                for (int i = 0; i < 8; i++) {
                    y23VarArr[i] = new z23(0);
                }
                return new ow1(x23Var, y23VarArr);
            default:
                x23 x23Var2 = this.b.a;
                y23[] y23VarArr2 = new y23[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    y23VarArr2[i2] = new z23(1);
                }
                return new ow1(x23Var2, y23VarArr2);
        }
    }
}
