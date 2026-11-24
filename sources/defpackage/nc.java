package defpackage;

import android.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nc extends nu2 implements vq0 {
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nc(int i, x50 x50Var, int i2) {
        super(i, x50Var);
        this.f = i2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((nc) q((x50) obj2, (s70) obj)).s(q43Var);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                ((nc) q((x50) obj2, bool)).s(q43Var);
                return q43Var;
            case 2:
                ((nc) q((x50) obj2, (q43) obj)).s(q43Var);
                return q43Var;
            case 3:
                ((nc) q((x50) obj2, (String) obj)).s(q43Var);
                return q43Var;
            case 4:
                ((nc) q((x50) obj2, (q43) obj)).s(q43Var);
                return q43Var;
            case 5:
                ((nc) q((x50) obj2, (q43) obj)).s(q43Var);
                throw null;
            default:
                ((nc) q((x50) obj2, (nm0) obj)).s(q43Var);
                return q43Var;
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                return new nc(2, x50Var, 0);
            case 1:
                return new nc(2, x50Var, 1);
            case 2:
                return new nc(2, x50Var, 2);
            case 3:
                return new nc(2, x50Var, 3);
            case 4:
                return new nc(2, x50Var, 4);
            case 5:
                return new nc(2, x50Var, 5);
            default:
                return new nc(2, x50Var, 6);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                bz3.g(obj);
                return Choreographer.getInstance();
            case 1:
                bz3.g(obj);
                return q43Var;
            case 2:
                bz3.g(obj);
                return q43Var;
            case 3:
                bz3.g(obj);
                return q43Var;
            case 4:
                bz3.g(obj);
                return q43Var;
            case 5:
                bz3.g(obj);
                throw new IllegalStateException("Live session ended before audio setup.");
            default:
                bz3.g(obj);
                return q43Var;
        }
    }
}
