package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rm4 {
    public static final Uri d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    public final String a;
    public final String b;
    public final boolean c;

    public rm4(String str, boolean z) {
        jg1.b(str);
        this.a = str;
        jg1.b("com.google.android.gms");
        this.b = "com.google.android.gms";
        this.c = z;
    }

    public final Intent a(Context context) {
        Bundle bundleCall;
        Intent intent = null;
        String str = this.a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.c) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                bundleCall = context.getContentResolver().call(d, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
            }
        }
        return intent == null ? new Intent(str).setPackage(this.b) : intent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rm4)) {
            return false;
        }
        rm4 rm4Var = (rm4) obj;
        return sr4.a(this.a, rm4Var.a) && sr4.a(this.b, rm4Var.b) && sr4.a(null, null) && this.c == rm4Var.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, null, 4225, Boolean.valueOf(this.c)});
    }

    public final String toString() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        jg1.d(null);
        throw null;
    }
}
