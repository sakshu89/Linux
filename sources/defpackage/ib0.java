package defpackage;

import android.app.RemoteAction;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ib0 implements wq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ib0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj4 = this.b;
        switch (i) {
            case 0:
                long j = ((sz) obj).a;
                x20 x20Var = (x20) obj2;
                int iIntValue = ((Number) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= x20Var.e(j) ? 4 : 2;
                }
                if (!x20Var.O(iIntValue & 1, (iIntValue & 19) != 18)) {
                    x20Var.R();
                } else {
                    jb0.b(((jx2) obj4).c, j, x20Var, (iIntValue << 3) & 112);
                }
                break;
            case 1:
                long j2 = ((sz) obj).a;
                x20 x20Var2 = (x20) obj2;
                int iIntValue2 = ((Number) obj3).intValue();
                if (!x20Var2.O(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    x20Var2.R();
                } else {
                    ak1.j.d((Drawable) obj4, x20Var2, 48);
                }
                break;
            default:
                long j3 = ((sz) obj).a;
                x20 x20Var3 = (x20) obj2;
                int iIntValue3 = ((Number) obj3).intValue();
                if (!x20Var3.O(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    x20Var3.R();
                } else {
                    ak1.j.i(((RemoteAction) obj4).getIcon(), x20Var3, 48);
                }
                break;
        }
        return q43Var;
    }
}
