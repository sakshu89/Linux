package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f20 extends RuntimeException {
    public final yl1 a;
    public final yl1 b;
    public final ll1 c;
    public final int e;

    public f20(yl1 yl1Var, yl1 yl1Var2, ll1 ll1Var, int i, Exception exc) {
        super(exc);
        this.a = yl1Var;
        this.b = yl1Var2;
        this.c = ll1Var;
        this.e = i;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        List listH;
        StringBuilder sb = new StringBuilder("\n            |Failed to execute op number ");
        sb.append(this.e);
        sb.append(":\n            |");
        yg2 yg2VarA = ah2.a(new e20(this, null));
        if (yg2VarA.hasNext()) {
            Object next = yg2VarA.next();
            if (yg2VarA.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (yg2VarA.hasNext()) {
                    arrayList.add(yg2VarA.next());
                }
                listH = arrayList;
            } else {
                listH = nz.h(next);
            }
        } else {
            listH = ii0.a;
        }
        sb.append(mz.C(mz.M(50, listH), "\n", null, null, null, 62));
        sb.append("\n            ");
        return ds2.c(sb.toString());
    }
}
