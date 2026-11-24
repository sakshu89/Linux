package defpackage;

import android.view.ViewStructure;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vy1 extends k61 implements xq0 {
    public final /* synthetic */ ViewStructure b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vy1(ViewStructure viewStructure) {
        super(4);
        this.b = viewStructure;
    }

    @Override // defpackage.xq0
    public final Object o(Object obj, Object obj2, Object obj3, Object obj4) {
        int iIntValue = ((Number) obj).intValue();
        int iIntValue2 = ((Number) obj2).intValue();
        int iIntValue3 = ((Number) obj3).intValue();
        int iIntValue4 = ((Number) obj4).intValue() - iIntValue2;
        this.b.setDimens(iIntValue, iIntValue2, 0, 0, iIntValue3 - iIntValue, iIntValue4);
        return q43.a;
    }
}
