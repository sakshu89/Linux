package defpackage;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s93 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ u93 i;
    public final /* synthetic */ Uri j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s93(u93 u93Var, Uri uri, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = u93Var;
        this.j = uri;
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
            case 1:
                break;
        }
        return ((s93) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Uri uri = this.j;
        u93 u93Var = this.i;
        switch (i) {
            case 0:
                return new s93(u93Var, uri, x50Var, 0);
            case 1:
                return new s93(u93Var, uri, x50Var, 1);
            default:
                return new s93(u93Var, uri, x50Var, 2);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        Uri uri = this.j;
        u93 u93Var = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                n21 n21Var = u93Var.a;
                Intent intent = new Intent("android.intent.action.VIEW", uri).setPackage("com.google.android.youtube");
                intent.getClass();
                return n21Var.a(intent, "YouTube results");
            case 1:
                bz3.g(obj);
                uri.getClass();
                return u93Var.o(uri, "the YouTube video", "the video", null);
            default:
                bz3.g(obj);
                n21 n21Var2 = u93Var.a;
                Intent intent2 = new Intent("android.intent.action.VIEW", uri).setPackage("com.google.android.youtube");
                intent2.getClass();
                return n21Var2.a(intent2, "a YouTube video");
        }
    }
}
