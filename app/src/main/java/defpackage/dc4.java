package defpackage;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import com.ibm.icu.impl.PatternTokenizer;
import com.project.sonic.SonicService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dc4 {
    public static String a(no noVar) {
        StringBuilder sb = new StringBuilder(noVar.size());
        for (int i = 0; i < noVar.size(); i++) {
            byte bA = noVar.a(i);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append(PatternTokenizer.BACK_SLASH);
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static boolean b(Context context) {
        Object h72Var;
        Object h72Var2;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        String packageName = context.getPackageName();
        String name = SonicService.class.getName();
        try {
            h72Var = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        } catch (Throwable th) {
            h72Var = new h72(th);
        }
        if (h72Var instanceof h72) {
            h72Var = null;
        }
        String str = (String) h72Var;
        packageName.getClass();
        if (str == null) {
            str = "";
        }
        boolean z = true;
        List listN = cs2.N(str, new char[]{':'}, 6);
        if (!listN.isEmpty()) {
            Iterator it = listN.iterator();
            while (it.hasNext()) {
                List listN2 = cs2.N(cs2.V((String) it.next()).toString(), new char[]{'/'}, 2);
                if (listN2.size() == 2 && g31.a(listN2.get(0), packageName)) {
                    String strConcat = (String) listN2.get(1);
                    if (cs2.Q(strConcat, '.')) {
                        strConcat = packageName.concat(strConcat);
                    }
                    if (strConcat.equals(name)) {
                        return true;
                    }
                }
            }
        }
        try {
            Object systemService = context.getSystemService("accessibility");
            AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
            if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null && !enabledAccessibilityServiceList.isEmpty()) {
                Iterator<T> it2 = enabledAccessibilityServiceList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    ResolveInfo resolveInfo = ((AccessibilityServiceInfo) it2.next()).getResolveInfo();
                    ServiceInfo serviceInfo = resolveInfo != null ? resolveInfo.serviceInfo : null;
                    if (serviceInfo != null && g31.a(serviceInfo.packageName, packageName)) {
                        String str2 = serviceInfo.name;
                        str2.getClass();
                        if (cs2.Q(str2, '.')) {
                            str2 = packageName + str2;
                        }
                        if (str2.equals(name)) {
                            break;
                        }
                    }
                }
            } else {
                z = false;
                break;
            }
            h72Var2 = Boolean.valueOf(z);
        } catch (Throwable th2) {
            h72Var2 = new h72(th2);
        }
        Object obj = Boolean.FALSE;
        if (h72Var2 instanceof h72) {
            h72Var2 = obj;
        }
        return ((Boolean) h72Var2).booleanValue();
    }
}
