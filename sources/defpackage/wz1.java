package defpackage;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wz1 {
    public static final vz1 a;

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    static {
        vz1 vz1Var;
        String str = Build.FINGERPRINT;
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            if (lowerCase.equals("robolectric")) {
                vz1Var = new vz1();
            } else {
                vz1Var = null;
            }
        } else {
            vz1Var = null;
        }
        a = vz1Var;
    }
}
