package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yl4 {
    public static ap0 a(Context context) {
        ProviderInfo providerInfo;
        yo0 yo0Var;
        ApplicationInfo applicationInfo;
        int i = 11;
        qs4 ga0Var = Build.VERSION.SDK_INT >= 28 ? new ga0(i) : new qs4(i);
        PackageManager packageManager = context.getPackageManager();
        hh1.d(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            yo0Var = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArrP = ga0Var.p(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrP) {
                    arrayList.add(signature.toByteArray());
                }
                yo0Var = new yo0(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList), null, null);
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e);
                yo0Var = null;
            }
        }
        if (yo0Var == null) {
            return null;
        }
        return new ap0(new zo0(context, yo0Var));
    }
}
