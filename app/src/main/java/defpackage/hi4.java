package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hi4 {
    public static final boolean a(ArrayList arrayList) {
        List list;
        long j;
        if (arrayList.size() >= 2) {
            if (arrayList.size() <= 1) {
                list = ii0.a;
            } else {
                ArrayList arrayList2 = new ArrayList();
                Object obj = arrayList.get(0);
                int size = arrayList.size() - 1;
                int i = 0;
                while (i < size) {
                    i++;
                    Object obj2 = arrayList.get(i);
                    gg2 gg2Var = (gg2) obj2;
                    gg2 gg2Var2 = (gg2) obj;
                    arrayList2.add(new jp1((((long) Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (gg2Var2.g().b() >> 32)) - Float.intBitsToFloat((int) (gg2Var.g().b() >> 32))))) << 32) | (((long) Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (gg2Var2.g().b() & 4294967295L)) - Float.intBitsToFloat((int) (gg2Var.g().b() & 4294967295L))))) & 4294967295L)));
                    obj = obj2;
                }
                list = arrayList2;
            }
            if (list.size() == 1) {
                j = ((jp1) mz.x(list)).a;
            } else {
                if (list.isEmpty()) {
                    vc1.b("Empty collection can't be reduced.");
                }
                Object objX = mz.x(list);
                int size2 = list.size() - 1;
                if (1 <= size2) {
                    int i2 = 1;
                    while (true) {
                        objX = new jp1(jp1.e(((jp1) objX).a, ((jp1) list.get(i2)).a));
                        if (i2 == size2) {
                            break;
                        }
                        i2++;
                    }
                }
                j = ((jp1) objX).a;
            }
            if (Float.intBitsToFloat((int) (4294967295L & j)) >= Float.intBitsToFloat((int) (j >> 32))) {
                return false;
            }
        }
        return true;
    }

    public static String b(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String strL;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                strL = "null";
            } else {
                try {
                    strL = obj.toString();
                } catch (Exception e) {
                    String strK = cq.k(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strK), (Throwable) e);
                    strL = ky0.l("<", strK, " threw ", e.getClass().getName(), ">");
                }
            }
            objArr[i2] = strL;
            i2++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (iIndexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i3, iIndexOf);
            sb.append(objArr[i]);
            i++;
            i3 = iIndexOf + 2;
        }
        sb.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static boolean c(String str) {
        return str == null || str.isEmpty();
    }
}
