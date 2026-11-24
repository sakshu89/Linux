package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xb4 implements vo1 {
    public static final xb4 a = new xb4();
    public static final fl0 b = new fl0("imageFormat", ky0.r(w14.b(t14.class, new l14(1))));
    public static final fl0 c = new fl0("originalImageSize", ky0.r(w14.b(t14.class, new l14(2))));
    public static final fl0 d = new fl0("compressedImageSize", ky0.r(w14.b(t14.class, new l14(3))));
    public static final fl0 e = new fl0("isOdmlImage", ky0.r(w14.b(t14.class, new l14(4))));

    @Override // defpackage.oi0
    public final void a(Object obj, Object obj2) {
        tm4 tm4Var = (tm4) obj;
        wo1 wo1Var = (wo1) obj2;
        wo1Var.a(b, tm4Var.a);
        wo1Var.a(c, tm4Var.b);
        wo1Var.a(d, null);
        wo1Var.a(e, null);
    }
}
