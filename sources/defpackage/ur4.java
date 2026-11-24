package defpackage;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ur4 {
    public static final boolean a(AssertionError assertionError) {
        Logger logger = sp1.a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? cs2.n(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }
}
