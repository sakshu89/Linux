package defpackage;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nu extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ np i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nu(np npVar, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = npVar;
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
        return ((nu) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        np npVar = this.i;
        switch (i) {
            case 0:
                return new nu(npVar, x50Var, 0);
            default:
                return new nu(npVar, x50Var, 1);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        ActivityInfo activityInfo;
        int i = this.f;
        np npVar = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setType("image/*");
                n21 n21Var = (n21) npVar.e;
                t61 t61VarA = n21Var.a(intent, "your photos");
                if (t61VarA instanceof p61) {
                    return np.s((p61) t61VarA);
                }
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                intent2.setType("image/*");
                intent2.addCategory("android.intent.category.OPENABLE");
                t61 t61VarA2 = n21Var.a(intent2, "your photos");
                return t61VarA2 instanceof p61 ? np.s((p61) t61VarA2) : new fl2("I couldn't find a photo app to open.", "neither ACTION_VIEW image/* nor ACTION_GET_CONTENT resolved", null, false, 4);
            default:
                bz3.g(obj);
                ResolveInfo resolveInfoB = ((n21) npVar.e).b(new Intent("android.media.action.VIDEO_CAPTURE"));
                if (resolveInfoB == null || (activityInfo = resolveInfoB.activityInfo) == null) {
                    return null;
                }
                return activityInfo.packageName;
        }
    }
}
