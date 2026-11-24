package defpackage;

import com.ibm.icu.impl.locale.BaseLocale;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qi1 {
    public static final char[] a;

    static {
        char[] cArr = new char[80];
        a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(a, 0, i2);
            i -= i2;
        }
    }

    public static void b(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        a(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append(BaseLocale.SEP);
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            no noVar = no.c;
            sb.append(dc4.a(new no(((String) obj).getBytes(x21.a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof no) {
            sb.append(": \"");
            sb.append(dc4.a((no) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof yt0) {
            sb.append(" {");
            c((yt0) obj, sb, i + 2);
            sb.append("\n");
            a(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i3 = i + 2;
        b(sb, i3, "key", entry.getKey());
        b(sb, i3, "value", entry.getValue());
        sb.append("\n");
        a(i, sb);
        sb.append("}");
    }

    /* JADX WARN: Code duplicated, block: B:75:0x0194  */
    /* JADX WARN: Code duplicated, block: B:76:0x0196  */
    public static void c(yt0 yt0Var, StringBuilder sb, int i) {
        int i2;
        int i3;
        boolean zBooleanValue;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = yt0Var.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (!strSubstring.endsWith("List") || strSubstring.endsWith("OrBuilderList") || strSubstring.equals("List") || (method2 = (Method) entry.getValue()) == null) {
                i3 = i2;
            } else {
                i3 = i2;
                if (method2.getReturnType().equals(List.class)) {
                    b(sb, i, strSubstring.substring(0, strSubstring.length() - 4), yt0.e(method2, yt0Var, new Object[0]));
                }
                i2 = i3;
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                b(sb, i, strSubstring.substring(0, strSubstring.length() - 3), yt0.e(method, yt0Var, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(strSubstring.substring(0, strSubstring.length() - 5))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objE = yt0.e(method4, yt0Var, new Object[0]);
                    if (method5 == null) {
                        zBooleanValue = true;
                        if (objE instanceof Boolean) {
                            zEquals = !((Boolean) objE).booleanValue();
                        } else if (objE instanceof Integer) {
                            if (((Integer) objE).intValue() == 0) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objE instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objE).floatValue()) == 0) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objE instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) objE).doubleValue()) == 0) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objE instanceof String) {
                            zEquals = objE.equals("");
                        } else if (objE instanceof no) {
                            zEquals = objE.equals(no.c);
                        } else if (!(objE instanceof j1) ? !((objE instanceof Enum) && ((Enum) objE).ordinal() == 0) : objE != ((yt0) ((yt0) ((j1) objE)).c(6))) {
                            zEquals = false;
                        } else {
                            zEquals = true;
                        }
                        if (zEquals) {
                            zBooleanValue = false;
                        }
                    } else {
                        zBooleanValue = ((Boolean) yt0.e(method5, yt0Var, new Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        b(sb, i, strSubstring, objE);
                    }
                }
            }
            i2 = i3;
        }
        r43 r43Var = yt0Var.unknownFields;
        if (r43Var != null) {
            for (int i5 = 0; i5 < r43Var.a; i5++) {
                b(sb, i, String.valueOf(r43Var.b[i5] >>> 3), r43Var.c[i5]);
            }
        }
    }
}
