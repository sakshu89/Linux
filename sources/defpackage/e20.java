package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e20 extends g72 implements vq0 {
    public int c;
    public int e;
    public int f;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ f20 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e20(f20 f20Var, x50 x50Var) {
        super(x50Var);
        this.k = f20Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((e20) q((x50) obj2, (yg2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        e20 e20Var = new e20(this.k, x50Var);
        e20Var.j = obj;
        return e20Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        yg2 yg2Var;
        int i;
        int i2;
        int i3;
        String strH;
        int i4;
        int i5;
        String str;
        f20 f20Var = this.k;
        yl1 yl1Var = f20Var.a;
        ll1 ll1Var = f20Var.c;
        int i6 = this.i;
        if (i6 == 0) {
            bz3.g(obj);
            yg2Var = (yg2) this.j;
            i = 0;
            i2 = 0;
            i3 = 0;
        } else {
            if (i6 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = this.f;
            i2 = this.e;
            i3 = this.c;
            yg2Var = (yg2) this.j;
            bz3.g(obj);
        }
        if (i3 >= Math.min(f20Var.e + 10, ll1Var.b)) {
            return q43.a;
        }
        int i7 = i3 + 1;
        int iC = ll1Var.c(i3);
        switch (iC) {
            case 0:
                strH = "up";
                break;
            case 1:
                Object objF = yl1Var.f(i2);
                i2++;
                strH = "down " + objF;
                break;
            case 2:
                strH = "remove " + ll1Var.c(i7) + ' ' + ll1Var.c(i3 + 2);
                i7 = i3 + 3;
                break;
            case 3:
                strH = "move " + ll1Var.c(i7) + ' ' + ll1Var.c(i3 + 2) + ' ' + ll1Var.c(i3 + 3);
                i7 = i3 + 4;
                break;
            case 4:
                strH = "clear";
                break;
            case 5:
                i4 = i3 + 2;
                int iC2 = ll1Var.c(i7);
                i5 = i2 + 1;
                str = "insertBottomUp " + iC2 + ' ' + yl1Var.f(i2);
                int i8 = i4;
                strH = str;
                i7 = i8;
                i2 = i5;
                break;
            case 6:
                i4 = i3 + 2;
                int iC3 = ll1Var.c(i7);
                i5 = i2 + 1;
                str = "insertTopDown " + iC3 + ' ' + yl1Var.f(i2);
                int i9 = i4;
                strH = str;
                i7 = i9;
                i2 = i5;
                break;
            case 7:
                Object objF2 = yl1Var.f(i2);
                objF2.getClass();
                h33.c(2, objF2);
                i2 += 2;
                strH = "apply " + ((vq0) objF2);
                break;
            case 8:
                strH = "reuse " + f20Var.b.f(i);
                i++;
                break;
            case 9:
                strH = "recompose pending";
                break;
            default:
                strH = ky0.h(iC, "unknown op: ");
                break;
        }
        this.j = yg2Var;
        this.c = i7;
        this.e = i2;
        this.f = i;
        this.i = 1;
        yg2Var.b(this, i3 + ": " + strH);
        return t70.a;
    }
}
