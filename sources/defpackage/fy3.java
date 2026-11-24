package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fy3 {
    public static final w10 a = new w10(636288403, false, new z10(0));
    public static final w10 b = new w10(-1357803046, false, new z10(1));

    public static y12 a(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return y12.HTTP_1_0;
        }
        if (str.equals("http/1.1")) {
            return y12.HTTP_1_1;
        }
        if (str.equals("h2_prior_knowledge")) {
            return y12.H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals("h2")) {
            return y12.HTTP_2;
        }
        if (str.equals("spdy/3.1")) {
            return y12.SPDY_3;
        }
        if (str.equals("quic")) {
            return y12.QUIC;
        }
        dk0.h("Unexpected protocol: ".concat(str));
        return null;
    }
}
