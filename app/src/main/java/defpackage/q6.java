package defpackage;

import android.graphics.Rect;
import android.view.autofill.AutofillManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q6 extends k61 implements xq0 {
    public final /* synthetic */ s6 b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q6(s6 s6Var, int i) {
        super(4);
        this.b = s6Var;
        this.c = i;
    }

    @Override // defpackage.xq0
    public final Object o(Object obj, Object obj2, Object obj3, Object obj4) {
        int iIntValue = ((Number) obj).intValue();
        int iIntValue2 = ((Number) obj2).intValue();
        int iIntValue3 = ((Number) obj3).intValue();
        int iIntValue4 = ((Number) obj4).intValue();
        s6 s6Var = this.b;
        wj1 wj1Var = s6Var.a;
        ((AutofillManager) wj1Var.b).notifyViewEntered(s6Var.c, this.c, new Rect(iIntValue, iIntValue2, iIntValue3, iIntValue4));
        return q43.a;
    }
}
