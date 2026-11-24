package defpackage;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lu extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ np i;
    public final /* synthetic */ f5 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lu(np npVar, f5 f5Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = npVar;
        this.j = f5Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
        }
        return ((lu) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        f5 f5Var = this.j;
        np npVar = this.i;
        switch (i) {
            case 0:
                return new lu(npVar, f5Var, x50Var, 0);
            default:
                return new lu(npVar, f5Var, x50Var, 1);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        fl2 fl2Var;
        int i = this.f;
        f5 f5Var = this.j;
        np npVar = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                List listC = npVar.c(f5Var);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : listC) {
                    if (((Context) npVar.d).checkSelfPermission((String) obj2) != 0) {
                        arrayList.add(obj2);
                    }
                }
                return arrayList;
            default:
                bz3.g(obj);
                String strC = f5Var.c("camera_facing");
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                np.n(intent, strC);
                t61 t61VarA = ((n21) npVar.e).a(intent, "the camera");
                if (t61VarA instanceof p61) {
                    String strV = cq.v("Camera's open", g31.a(strC, "front") ? ", front camera if it'll take the hint" : g31.a(strC, "rear") ? ", rear camera if it'll take the hint" : "", ".");
                    p61 p61Var = (p61) t61VarA;
                    String str = p61Var.b;
                    if (str == null) {
                        str = p61Var.a;
                    }
                    return new hl2(strV, "This opens the viewfinder; say take a photo to start SONIC's countdown", new c73(cq.v("SONIC opened ", str, "; it does not capture images itself and cannot see whether one was taken")), null, false, 24);
                }
                if (t61VarA instanceof q61) {
                    fl2Var = new fl2("There's no camera app on this phone I can open.", "no activity resolved for android.media.action.IMAGE_CAPTURE", null, false, 4);
                } else if (t61VarA instanceof r61) {
                    fl2Var = new fl2("Android wouldn't let me open the camera just now.", "startActivity refused: ".concat(((r61) t61VarA).a), null, false, 12);
                } else if (t61VarA instanceof s61) {
                    fl2Var = new fl2("I didn't open the camera.", "rejected by IntentLauncher validation: ".concat(((s61) t61VarA).a), null, false, 4);
                } else {
                    if (!(t61VarA instanceof o61)) {
                        dk0.l();
                        return null;
                    }
                    fl2Var = new fl2("I couldn't open the camera.", ((o61) t61VarA).a, null, false, 12);
                }
                return fl2Var;
        }
    }
}
