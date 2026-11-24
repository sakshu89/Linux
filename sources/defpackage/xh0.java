package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xh0 implements wh0 {
    public final int a;
    public int b = -1;
    public int c = -1;

    public xh0(int i) {
        this.a = i;
    }

    @Override // defpackage.wh0
    public final boolean f(CharSequence charSequence, int i, int i2, q33 q33Var) {
        int i3 = this.a;
        if (i > i3 || i3 >= i2) {
            return i2 <= i3;
        }
        this.b = i;
        this.c = i2;
        return false;
    }

    @Override // defpackage.wh0
    public final Object e() {
        return this;
    }
}
