package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class er {
    public static final er a = new er();

    public void a(r53 r53Var, ur urVar) {
        lw lwVar = (lw) r53Var.d(r53.P, null);
        gs1 gs1Var = gs1.c;
        bi biVar = lw.i;
        HashSet hashSet = new HashSet();
        zl1 zl1VarM = zl1.m();
        ArrayList arrayList = new ArrayList();
        om1 om1VarA = om1.a();
        ArrayList arrayList2 = new ArrayList(hashSet);
        gs1 gs1VarL = gs1.l(zl1VarM);
        ArrayList arrayList3 = new ArrayList(arrayList);
        iv2 iv2Var = iv2.b;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = om1VarA.a;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        int i = -1;
        new lw(arrayList2, gs1VarL, -1, false, arrayList3, false, new iv2(arrayMap), null);
        if (lwVar != null) {
            i = lwVar.c;
            urVar.a(lwVar.e);
            gs1Var = lwVar.b;
        }
        urVar.e = zl1.o(gs1Var);
        urVar.a = ((Integer) r53Var.d(zr.i, Integer.valueOf(i))).intValue();
        urVar.b(new kw((CameraCaptureSession.CaptureCallback) r53Var.d(zr.s, new dr())));
        urVar.c(yr.e(r53Var).d());
    }
}
