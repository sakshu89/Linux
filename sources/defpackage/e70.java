package defpackage;

import android.view.autofill.AutofillValue;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e70 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ f70 b;

    public /* synthetic */ e70(f70 f70Var, og2 og2Var) {
        this.a = 3;
        this.b = f70Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        boolean z = false;
        f70 f70Var = this.b;
        switch (i) {
            case 0:
                ku1 ku1Var = f70Var.Z.t;
                Boolean bool = Boolean.TRUE;
                ku1Var.setValue(bool);
                f70Var.Z.s.setValue(bool);
                ua1 ua1Var = f70Var.Z;
                AutofillValue autofillValue = ((i9) obj).a;
                CharSequence textValue = autofillValue.isText() ? autofillValue.getTextValue() : null;
                textValue.getClass();
                f70.L0(ua1Var, (String) textValue, f70Var.c0);
                return bool;
            case 1:
                List list = (List) obj;
                if (f70Var.Z.d() != null) {
                    hz2 hz2VarD = f70Var.Z.d();
                    hz2VarD.getClass();
                    list.add(hz2VarD.a);
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                f70.L0(f70Var.Z, ((be) obj).b, f70Var.c0);
                return Boolean.TRUE;
            default:
                be beVar = (be) obj;
                if (f70Var.c0) {
                    bz2 bz2Var = f70Var.Z.e;
                    if (bz2Var != null) {
                        List listI = nz.i(new xl0(), new r00(beVar, 1));
                        ua1 ua1Var2 = f70Var.Z;
                        l11 l11Var = ua1Var2.d;
                        q60 q60Var = ua1Var2.v;
                        ty2 ty2VarL = l11Var.l(listI);
                        bz2Var.a(null, ty2VarL);
                        q60Var.j(ty2VarL);
                    } else {
                        ty2 ty2Var = f70Var.Y;
                        String str = ty2Var.a.b;
                        long j = ty2Var.b;
                        int i2 = oz2.c;
                        String string = cs2.K(str, (int) (j >> 32), beVar, (int) (j & 4294967295L)).toString();
                        int length = beVar.b.length() + ((int) (f70Var.Y.b >> 32));
                        f70Var.Z.v.j(new ty2(4, hc4.a(length, length), string));
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
        }
    }

    public /* synthetic */ e70(f70 f70Var, int i) {
        this.a = i;
        this.b = f70Var;
    }
}
