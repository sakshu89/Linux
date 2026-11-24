package defpackage;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dj1 {
    public final q91 a;
    public final kf b;
    public final HashMap c;

    public dj1(Context context, kf kfVar) {
        q91 q91Var = new q91(context);
        this.c = new HashMap();
        this.a = q91Var;
        this.b = kfVar;
    }

    public final synchronized p23 a(String str) {
        if (this.c.containsKey(str)) {
            return (p23) this.c.get(str);
        }
        CctBackendFactory cctBackendFactoryA = this.a.A(str);
        if (cctBackendFactoryA == null) {
            return null;
        }
        kf kfVar = this.b;
        p23 p23VarCreate = cctBackendFactoryA.create(new ci((Context) kfVar.e, (wy) kfVar.b, (wy) kfVar.c, str));
        this.c.put(str, p23VarCreate);
        return p23VarCreate;
    }
}
