package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sp extends dx {
    public final on2 e;
    public final on2 f;

    public sp(on2 on2Var, j70 j70Var, int i, nn nnVar) {
        super(j70Var, i, nnVar);
        this.e = on2Var;
        this.f = on2Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // defpackage.dx
    public final Object d(j12 j12Var, x50 x50Var) {
        rp rpVar;
        if (x50Var instanceof rp) {
            rpVar = (rp) x50Var;
            int i = rpVar.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                rpVar.j = i - Integer.MIN_VALUE;
            } else {
                rpVar = new rp(this, (y50) x50Var);
            }
        } else {
            rpVar = new rp(this, (y50) x50Var);
        }
        Object obj = rpVar.f;
        int i2 = rpVar.j;
        q43 q43Var = q43.a;
        if (i2 == 0) {
            bz3.g(obj);
            rpVar.e = j12Var;
            rpVar.j = 1;
            Object objE = this.e.e(j12Var, rpVar);
            t70 t70Var = t70.a;
            if (objE != t70Var) {
                objE = q43Var;
            }
            if (objE == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j12Var = rpVar.e;
            bz3.g(obj);
        }
        if (j12Var.i.D()) {
            return q43Var;
        }
        og.n("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
        return null;
    }

    @Override // defpackage.dx
    public final dx e(j70 j70Var, int i, nn nnVar) {
        return new sp(this.f, j70Var, i, nnVar);
    }

    @Override // defpackage.dx
    public final String toString() {
        return "block[" + this.e + "] -> " + super.toString();
    }
}
