package defpackage;

import java.util.Iterator;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eh1 extends y0 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ eh1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.y0
    public final int a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((fh1) obj).a.groupCount() + 1;
            default:
                hw1 hw1Var = (hw1) obj;
                hw1Var.getClass();
                return hw1Var.b;
        }
    }

    public ch1 b(int i) {
        Matcher matcher = ((fh1) this.b).a;
        h21 h21VarF = ky3.f(matcher.start(i), matcher.end(i));
        if (h21VarF.a < 0) {
            return null;
        }
        String strGroup = matcher.group(i);
        strGroup.getClass();
        return new ch1(strGroup, h21VarF);
    }

    @Override // defpackage.y0, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        switch (this.a) {
            case 0:
                if (obj == null ? true : obj instanceof ch1) {
                    return super.contains((ch1) obj);
                }
                return false;
            default:
                return ((hw1) this.b).containsValue(obj);
        }
    }

    @Override // defpackage.y0, java.util.Collection
    public boolean isEmpty() {
        switch (this.a) {
            case 0:
                return false;
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new c23(new au0(3, new rg(1, nz.f(this)), new x0(18, this)));
            default:
                x23 x23Var = ((hw1) this.b).a;
                y23[] y23VarArr = new y23[8];
                for (int i = 0; i < 8; i++) {
                    y23VarArr[i] = new z23(2);
                }
                return new ow1(x23Var, y23VarArr);
        }
    }
}
