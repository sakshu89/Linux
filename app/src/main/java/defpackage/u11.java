package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u11 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ int e;

    public /* synthetic */ u11(int i, zw1 zw1Var, int i2) {
        this.a = 1;
        this.b = i;
        this.c = zw1Var;
        this.e = i2;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = this.e;
        int i3 = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                yw1.h((yw1) obj, (zw1) obj2, i3, i2);
                break;
            case 1:
                zw1 zw1Var = (zw1) obj2;
                yw1.h((yw1) obj, zw1Var, hh1.f((i3 - zw1Var.a) / 2.0f), hh1.f((i2 - zw1Var.b) / 2.0f));
                break;
            case 2:
                yw1.h((yw1) obj, (zw1) obj2, i3, i2);
                break;
            default:
                na naVar = (na) obj2;
                au1 au1Var = (au1) obj;
                ia iaVar = au1Var.a;
                int iD = au1Var.d(i3);
                int iD2 = au1Var.d(i2);
                CharSequence charSequence = iaVar.e;
                if (iD < 0 || iD > iD2 || iD2 > charSequence.length()) {
                    StringBuilder sbP = cq.p("start(", iD, ") or end(", iD2, ") is out of range [0..");
                    sbP.append(charSequence.length());
                    sbP.append("], or start > end!");
                    a11.a(sbP.toString());
                }
                Path path = new Path();
                ez2 ez2Var = iaVar.d;
                ez2Var.f.getSelectionPath(iD, iD2, path);
                int i4 = ez2Var.h;
                if (i4 != 0 && !path.isEmpty()) {
                    path.offset(0.0f, i4);
                }
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(au1Var.f)) & 4294967295L);
                Matrix matrix = new Matrix();
                matrix.setTranslate(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)));
                path.transform(matrix);
                naVar.a.addPath(path, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ u11(Object obj, int i, int i2, int i3) {
        this.a = i3;
        this.c = obj;
        this.b = i;
        this.e = i2;
    }
}
