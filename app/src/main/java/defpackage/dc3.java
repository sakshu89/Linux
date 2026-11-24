package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import com.project.sonic.R;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dc3 {
    public static final LinkedHashMap a = new LinkedHashMap();

    public static final hr2 a(Context context) {
        hr2 hr2Var;
        LinkedHashMap linkedHashMap = a;
        synchronized (linkedHashMap) {
            try {
                Object objE = linkedHashMap.get(context);
                if (objE == null) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                    un unVarA = nh4.a(-1, 6, null);
                    l90 l90Var = new l90(1, new bt0(contentResolver, uriFor, new g80(unVarA, go4.a(Looper.getMainLooper())), unVarA, context, null));
                    ft2 ft2VarA = wa4.a();
                    xa0 xa0Var = ld0.a;
                    objE = rn4.e(l90Var, new w50(pl4.c(ft2VarA, ig1.a)), new er2(), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                    linkedHashMap.put(context, objE);
                }
                hr2Var = (hr2) objE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hr2Var;
    }

    public static final a30 b(View view) {
        Object tag = view.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof a30) {
            return (a30) tag;
        }
        return null;
    }
}
