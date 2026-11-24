package defpackage;

import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ws0 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ mt0 i;
    public final /* synthetic */ x00 j;
    public final /* synthetic */ hd1 k;
    public final /* synthetic */ s70 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ws0(mt0 mt0Var, x00 x00Var, hd1 hd1Var, s70 s70Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = mt0Var;
        this.j = x00Var;
        this.k = hd1Var;
        this.n = s70Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) throws JSONException, IllegalAccessException, InvocationTargetException {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                ((ws0) q(x50Var, s70Var)).s(q43Var);
                break;
            default:
                ((ws0) q(x50Var, s70Var)).s(q43Var);
                break;
        }
        return q43Var;
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                return new ws0(this.i, this.j, this.k, this.n, x50Var, 0);
            default:
                return new ws0(this.i, this.j, this.k, this.n, x50Var, 1);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws JSONException, IllegalAccessException, InvocationTargetException {
        int i = this.f;
        q43 q43Var = q43.a;
        hd1 hd1Var = this.k;
        x00 x00Var = this.j;
        mt0 mt0Var = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                dt0.x(mt0Var, x00Var, hd1Var);
                break;
            default:
                bz3.g(obj);
                dt0.x(mt0Var, x00Var, hd1Var);
                break;
        }
        return q43Var;
    }
}
