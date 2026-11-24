package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rd3 {
    public final /* synthetic */ int a;

    public static final int b(int i, int i2) {
        return (i >> i2) & 31;
    }

    public je a(Context context, Looper looper, lj1 lj1Var, Object obj, ou0 ou0Var, pu0 pu0Var) {
        int i = this.a;
        switch (i) {
            case 0:
                lj1Var.getClass();
                Integer num = (Integer) lj1Var.g;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new nk2(context, looper, lj1Var, bundle, ou0Var, pu0Var);
            case 1:
                throw ky0.g(obj);
            default:
                wd3 wd3Var = (wd3) ou0Var;
                wd3 wd3Var2 = (wd3) pu0Var;
                switch (i) {
                    case 2:
                        return new te3(context, looper, lj1Var, (pw2) obj, wd3Var, wd3Var2);
                    case 3:
                        return new ye3(context, looper, UCharacter.UnicodeBlock.YEZIDI_ID, lj1Var, wd3Var, wd3Var2);
                    default:
                        throw new UnsupportedOperationException("buildClient must be implemented");
                }
        }
    }
}
