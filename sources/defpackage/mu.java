package defpackage;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mu extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ np i;
    public final /* synthetic */ Intent j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mu(np npVar, Intent intent, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = npVar;
        this.j = intent;
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
        return ((mu) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Intent intent = this.j;
        np npVar = this.i;
        switch (i) {
            case 0:
                return new mu(npVar, intent, x50Var, 0);
            default:
                return new mu(npVar, intent, x50Var, 1);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        Intent intent = this.j;
        np npVar = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                return ((n21) npVar.e).a(intent, "SONIC's camera");
            default:
                bz3.g(obj);
                return ((n21) npVar.e).a(intent, "the video camera");
        }
    }
}
