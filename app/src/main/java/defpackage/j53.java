package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j53 implements h70 {
    public final j53 a;
    public final w90 b;

    public j53(j53 j53Var, w90 w90Var) {
        this.a = j53Var;
        this.b = w90Var;
    }

    @Override // defpackage.j70
    public final j70 D(i70 i70Var) {
        return pl4.b(this, i70Var);
    }

    public final void a(w90 w90Var) {
        if (this.b == w90Var) {
            og.n("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
            return;
        }
        j53 j53Var = this.a;
        if (j53Var != null) {
            j53Var.a(w90Var);
        }
    }

    @Override // defpackage.h70
    public final i70 getKey() {
        return nr4.t;
    }

    @Override // defpackage.j70
    public final j70 r(j70 j70Var) {
        return pl4.c(this, j70Var);
    }

    @Override // defpackage.j70
    public final h70 v(i70 i70Var) {
        return pl4.a(this, i70Var);
    }

    @Override // defpackage.j70
    public final Object y(vq0 vq0Var, Object obj) {
        return vq0Var.e(obj, this);
    }
}
