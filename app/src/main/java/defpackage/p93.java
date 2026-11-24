package defpackage;

import android.net.Uri;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p93 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ u93 i;
    public final /* synthetic */ f5 j;
    public final /* synthetic */ cl2 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p93(u93 u93Var, f5 f5Var, cl2 cl2Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = u93Var;
        this.j = f5Var;
        this.k = cl2Var;
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
        return ((p93) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                return new p93(this.i, this.j, this.k, x50Var, 0);
            case 1:
                return new p93(this.i, this.j, this.k, x50Var, 1);
            default:
                return new p93(this.i, this.j, this.k, x50Var, 2);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        Uri uri;
        String host;
        int i = this.f;
        cl2 cl2Var = this.k;
        f5 f5Var = this.j;
        u93 u93Var = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                String strC = f5Var.c("url");
                if (strC == null && (strC = cl2Var.f.h) == null) {
                    return new fl2("Which page would you like me to open?", "OPEN_URL with no url", null, false, 12);
                }
                Set set = n21.b;
                String string = cs2.V(strC).toString();
                if (string.length() == 0) {
                    uri = null;
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 < string.length()) {
                            if (!ph4.c(string.charAt(i2))) {
                                i2++;
                            }
                        } else if (js2.k(string, "https://", true) || js2.k(string, "http://", true)) {
                            uri = Uri.parse(string);
                            host = uri.getHost();
                            if (host != null) {
                            }
                        } else if (!cs2.n(string, "://", false) && !cs2.o(string, ':') && cs2.o(string, '.')) {
                            string = "https://".concat(string);
                            uri = Uri.parse(string);
                            host = uri.getHost();
                            if (host != null || cs2.A(host)) {
                            }
                        }
                        uri = null;
                    }
                }
                return uri == null ? new fl2(cq.v("\"", strC, "\" doesn't look like a web address I can open."), cq.v("webUri rejected \"", strC, "\": not an http(s) address with a host"), null, true, 4) : u93Var.o(uri, String.valueOf(uri), "the page", null);
            case 1:
                bz3.g(obj);
                String strC2 = f5Var.c("query");
                if (strC2 == null && (strC2 = cl2Var.f.g) == null) {
                    return new fl2("What should I look for on YouTube?", "YOUTUBE_SEARCH with no query", null, false, 12);
                }
                Uri uriBuild = Uri.parse("https://www.youtube.com/results").buildUpon().appendQueryParameter("search_query", n61.a.d(strC2)).build();
                uriBuild.getClass();
                return u93Var.o(uriBuild, cq.v("YouTube results for \"", strC2, "\""), "the results", "com.google.android.youtube");
            default:
                bz3.g(obj);
                String strC3 = f5Var.c("query");
                if (strC3 == null && (strC3 = cl2Var.f.g) == null) {
                    return new fl2("What would you like me to search for?", "WEB_SEARCH with no query", null, false, 12);
                }
                Uri uriBuild2 = Uri.parse("https://www.google.com/search").buildUpon().appendQueryParameter("q", n61.a.d(strC3)).build();
                uriBuild2.getClass();
                return u93Var.o(uriBuild2, cq.v("search results for \"", strC3, "\""), "the results", null);
        }
    }
}
