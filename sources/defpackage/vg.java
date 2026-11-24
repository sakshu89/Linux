package defpackage;

import android.content.Context;
import android.content.Intent;
import com.project.sonic.MainActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vg {
    public static final l11 a = new l11(5);

    public static Intent a(Context context, boolean z) {
        String string;
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setAction("android.intent.action.ASSIST");
        intent.setFlags(872415232);
        intent.putExtra("com.project.sonic.extra.FROM_ENABLED_WAKE", z);
        l11 l11Var = a;
        synchronized (l11Var) {
            try {
                long jLongValue = ((Number) ((fq0) l11Var.b).a()).longValue();
                Set setEntrySet = ((LinkedHashMap) l11Var.c).entrySet();
                setEntrySet.getClass();
                Iterator it = setEntrySet.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    entry.getClass();
                    if (jLongValue - ((wg) entry.getValue()).b >= 15000) {
                        it.remove();
                    }
                }
                while (((LinkedHashMap) l11Var.c).size() >= 8) {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) l11Var.c;
                    Set setKeySet = linkedHashMap.keySet();
                    setKeySet.getClass();
                    linkedHashMap.remove(mz.w(setKeySet));
                }
                string = UUID.randomUUID().toString();
                string.getClass();
                ((LinkedHashMap) l11Var.c).put(string, new wg(jLongValue, z));
            } catch (Throwable th) {
                throw th;
            }
        }
        intent.putExtra("com.project.sonic.extra.ASSISTANT_INVOCATION", string);
        return intent;
    }
}
