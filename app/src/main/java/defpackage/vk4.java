package defpackage;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vk4 implements dk4 {
    public final g81 a;
    public final ak4 b;

    public vk4(Context context, ak4 ak4Var) {
        this.b = ak4Var;
        po poVar = po.e;
        r23.b(context);
        b13 b13VarC = r23.a().c(poVar);
        if (po.d.contains(new qi0("json"))) {
            new g81(new rk4(0, b13VarC));
        }
        this.a = new g81(new rk4(1, b13VarC));
    }

    @Override // defpackage.dk4
    public final void a(cu2 cu2Var) {
        ak4 ak4Var = this.b;
        ak4Var.getClass();
        q23 q23Var = (q23) this.a.get();
        ak4Var.getClass();
        y74 y74Var = y74.n;
        b13 b13Var = (b13) cu2Var.b;
        ((i52) cu2Var.c).i = false;
        i52 i52Var = (i52) cu2Var.c;
        i52Var.g = Boolean.FALSE;
        b13Var.a = new bi4(i52Var);
        try {
            fl4.l();
            td4 td4Var = new td4(b13Var);
            b13 b13Var2 = new b13(5);
            y74Var.t(b13Var2);
            HashMap map = new HashMap((HashMap) b13Var2.a);
            HashMap map2 = new HashMap((HashMap) b13Var2.b);
            r41 r41Var = (r41) b13Var2.c;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                tx3 tx3Var = new tx3(byteArrayOutputStream, map, map2, r41Var);
                vo1 vo1Var = (vo1) map.get(td4.class);
                if (vo1Var == null) {
                    throw new ri0("No encoder for ".concat(String.valueOf(td4.class)));
                }
                vo1Var.a(td4Var, tx3Var);
                q23Var.a(new gi(byteArrayOutputStream.toByteArray(), v02.b));
            } catch (IOException unused) {
            }
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
