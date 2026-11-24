package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b50 {
    public static final x42 c = new x42("[^\\p{L}\\p{M}\\p{N}\\s]");
    public static final x42 d = new x42("\\s+");
    public final Context a;
    public final zv1 b;

    public b50(Context context, zv1 zv1Var) {
        zv1Var.getClass();
        this.a = context;
        this.b = zv1Var;
    }

    public static z40 a(String str, List list) {
        if (list.size() != 1) {
            return new u40(str, mz.L(list, 4));
        }
        uw1 uw1Var = (uw1) mz.H(list);
        return new y40(uw1Var, "only number for ".concat(uw1Var.b));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0081  */
    /* JADX WARN: Code duplicated, block: B:35:0x0092  */
    /* JADX WARN: Code duplicated, block: B:37:0x0095  */
    /* JADX WARN: Code duplicated, block: B:38:0x0098  */
    public final ArrayList b(ArrayList arrayList) {
        boolean zAreSamePhoneNumber;
        Object h72Var;
        Object simCountryIso;
        String str;
        ArrayList arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            uw1 uw1Var = (uw1) obj;
            Long lValueOf = Long.valueOf(uw1Var.a);
            Object arrayList3 = linkedHashMap.get(lValueOf);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList3);
            }
            List list = (List) arrayList3;
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                do {
                    if (it.hasNext()) {
                        String str2 = ((uw1) it.next()).c;
                        String str3 = uw1Var.c;
                        if (Build.VERSION.SDK_INT >= 31) {
                            TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService(TelephonyManager.class);
                            if (telephonyManager != null) {
                                try {
                                    simCountryIso = telephonyManager.getSimCountryIso();
                                } catch (Throwable th) {
                                    h72Var = new h72(th);
                                }
                            } else {
                                simCountryIso = null;
                            }
                            h72Var = simCountryIso;
                            if (h72Var instanceof h72) {
                                h72Var = null;
                            }
                            String str4 = (String) h72Var;
                            if (str4 == null) {
                                String country = Locale.getDefault().getCountry();
                                country.getClass();
                                str = cs2.A(country) ? null : country;
                                if (str == null) {
                                    str4 = "us";
                                } else {
                                    str4 = str;
                                }
                            } else {
                                if (cs2.A(str4)) {
                                    str4 = null;
                                }
                                if (str4 == null) {
                                    String country2 = Locale.getDefault().getCountry();
                                    country2.getClass();
                                    if (cs2.A(country2)) {
                                    }
                                    if (str == null) {
                                        str4 = "us";
                                    } else {
                                        str4 = str;
                                    }
                                }
                            }
                            Locale locale = Locale.ROOT;
                            locale.getClass();
                            String lowerCase = str4.toLowerCase(locale);
                            lowerCase.getClass();
                            zAreSamePhoneNumber = PhoneNumberUtils.areSamePhoneNumber(str2, str3, lowerCase);
                        } else {
                            String strO = ak1.o(str2);
                            zAreSamePhoneNumber = !cs2.A(strO) && strO.equals(ak1.o(str3));
                        }
                    }
                } while (!zAreSamePhoneNumber);
            }
            list.add(uw1Var);
            arrayList2.add(uw1Var);
        }
        return arrayList2;
    }

    public final uw1 c(List list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (js2.f(((uw1) next).d, ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.a.getResources(), 2, null).toString())) {
                obj = next;
                break;
            }
        }
        uw1 uw1Var = (uw1) obj;
        return uw1Var == null ? (uw1) mz.x(list) : uw1Var;
    }

    public final ArrayList d(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("contact_id");
        int columnIndex2 = cursor.getColumnIndex("display_name");
        int columnIndex3 = cursor.getColumnIndex("data1");
        int columnIndex4 = cursor.getColumnIndex("data2");
        int columnIndex5 = cursor.getColumnIndex("data3");
        int columnIndex6 = cursor.getColumnIndex("starred");
        int columnIndex7 = cursor.getColumnIndex("photo_thumb_uri");
        if (columnIndex < 0 || columnIndex2 < 0 || columnIndex3 < 0) {
            og.i("Contact provider omitted required columns");
            return null;
        }
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndex3);
            String string2 = string != null ? cs2.V(string).toString() : null;
            if (string2 == null) {
                string2 = "";
            }
            ArrayList arrayList2 = new ArrayList(string2.length());
            for (int i = 0; i < string2.length(); i++) {
                char cCharAt = string2.charAt(i);
                if (2406 <= cCharAt && cCharAt < 2416) {
                    cCharAt = (char) (cCharAt - 2358);
                }
                arrayList2.add(Character.valueOf(cCharAt));
            }
            String strC = mz.C(arrayList2, "", null, null, null, 62);
            if (strC.length() != 0) {
                int i2 = columnIndex4 >= 0 ? cursor.getInt(columnIndex4) : 7;
                String string3 = columnIndex5 >= 0 ? cursor.getString(columnIndex5) : null;
                long j = cursor.getLong(columnIndex);
                String string4 = cursor.getString(columnIndex2);
                String string5 = string4 != null ? cs2.V(string4).toString() : null;
                String str = string5 != null ? string5 : "";
                arrayList.add(new uw1(j, str.length() == 0 ? strC : str, strC, ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.a.getResources(), i2, string3).toString(), columnIndex6 >= 0 && cursor.getInt(columnIndex6) == 1, columnIndex7 >= 0 ? cursor.getString(columnIndex7) : null));
            }
        }
        return arrayList;
    }

    public final ArrayList e(Uri uri) throws IllegalAccessException, IOException, InvocationTargetException {
        Uri uri2;
        Iterator it = nz.i(new String[]{"contact_id", "display_name", "data1", "data2", "data3", "starred", "photo_thumb_uri"}, new String[]{"contact_id", "display_name", "data1"}).iterator();
        while (it.hasNext()) {
            try {
                try {
                    uri2 = uri;
                    try {
                        Cursor cursorQuery = this.a.getContentResolver().query(uri2, (String[]) it.next(), null, null, null);
                        if (cursorQuery != null) {
                            try {
                                ArrayList arrayListD = d(cursorQuery);
                                cursorQuery.close();
                                return arrayListD;
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    fi4.a(cursorQuery, th);
                                    throw th2;
                                }
                            }
                        }
                        uri = uri2;
                    } catch (RuntimeException unused) {
                        continue;
                    }
                } catch (RuntimeException unused2) {
                    uri2 = uri;
                }
            } catch (SecurityException e) {
                throw e;
            }
        }
        return null;
    }

    public final z40 f(String str) throws IllegalAccessException, IOException, InvocationTargetException {
        float f;
        float f2;
        float f3;
        if (!this.b.c("android.permission.READ_CONTACTS")) {
            return x40.a;
        }
        String string = cs2.V(str).toString();
        Pattern patternCompile = Pattern.compile("^(?:(?:my|the)\\s+)+", 66);
        patternCompile.getClass();
        string.getClass();
        String strReplaceAll = patternCompile.matcher(string).replaceAll("");
        strReplaceAll.getClass();
        String string2 = cs2.V(strReplaceAll).toString();
        if (string2.length() == 0) {
            return new w40(str);
        }
        Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI, Uri.encode(string2));
        uriWithAppendedPath.getClass();
        ArrayList arrayListE = e(uriWithAppendedPath);
        ArrayList arrayListB = arrayListE != null ? b(arrayListE) : null;
        int i = 4;
        int i2 = 0;
        if (arrayListB == null || arrayListB.isEmpty()) {
            f = 0.08f;
            f2 = 0.7f;
            f3 = 0.88f;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = arrayListB.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListB.get(i3);
                i3++;
                Long lValueOf = Long.valueOf(((uw1) obj).a);
                Object arrayList = linkedHashMap.get(lValueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(lValueOf, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            f = 0.08f;
            f2 = 0.7f;
            f3 = 0.88f;
            z40 z40VarH = h(string2, linkedHashMap.values());
            if (z40VarH != null) {
                return z40VarH;
            }
            z40 z40VarG = g(string2, linkedHashMap.values());
            if (z40VarG != null) {
                return z40VarG;
            }
            String strM = ak1.m(string2);
            Collection collectionValues = linkedHashMap.values();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : collectionValues) {
                if (g31.a(ak1.m(((uw1) mz.x((List) obj2)).b), strM)) {
                    arrayList2.add(obj2);
                }
            }
            if (arrayList2.size() == 1) {
                return a(string2, (List) mz.x(arrayList2));
            }
            if (linkedHashMap.size() == 1) {
                if (new a50(string2).c(c((List) mz.w(linkedHashMap.values())).b) >= 0.68f) {
                    return a(string2, (List) mz.w(linkedHashMap.values()));
                }
            }
            Collection collectionValues2 = linkedHashMap.values();
            ArrayList arrayList3 = new ArrayList(nz.d(collectionValues2));
            Iterator it = collectionValues2.iterator();
            while (it.hasNext()) {
                arrayList3.add(c((List) it.next()));
            }
            a50 a50Var = new a50(string2);
            ArrayList arrayList4 = new ArrayList(nz.d(arrayList3));
            int size2 = arrayList3.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj3 = arrayList3.get(i4);
                i4++;
                uw1 uw1Var = (uw1) obj3;
                arrayList4.add(new wt1(uw1Var, Float.valueOf(a50Var.c(uw1Var.b))));
            }
            ArrayList arrayList5 = new ArrayList();
            int size3 = arrayList4.size();
            int i5 = 0;
            while (i5 < size3) {
                Object obj4 = arrayList4.get(i5);
                i5++;
                if (((Number) ((wt1) obj4).b).floatValue() >= 0.68f) {
                    arrayList5.add(obj4);
                }
            }
            List listK = mz.K(arrayList5, new lo0(13));
            if (!listK.isEmpty()) {
                float fFloatValue = ((Number) ((wt1) mz.x(listK)).b).floatValue();
                wt1 wt1Var = (wt1) mz.z(1, listK);
                float fFloatValue2 = wt1Var != null ? ((Number) wt1Var.b).floatValue() : 0.0f;
                if (fFloatValue >= 0.88f && fFloatValue2 < 0.7f) {
                    return a(string2, (List) bh1.a(Long.valueOf(((uw1) ((wt1) mz.x(listK)).a).a), linkedHashMap));
                }
                ArrayList arrayList6 = new ArrayList();
                for (Object obj5 : listK) {
                    if (((Number) ((wt1) obj5).b).floatValue() >= fFloatValue - 0.08f) {
                        arrayList6.add(obj5);
                    }
                }
                List listL = mz.L(arrayList6, 4);
                ArrayList arrayList7 = new ArrayList(nz.d(listL));
                Iterator it2 = listL.iterator();
                while (it2.hasNext()) {
                    arrayList7.add((uw1) ((wt1) it2.next()).a);
                }
                return new u40(string2, arrayList7);
            }
        }
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        uri.getClass();
        ArrayList arrayListE2 = e(uri);
        if (arrayListE2 == null) {
            return new v40(str);
        }
        ArrayList arrayListB2 = b(arrayListE2);
        if (arrayListB2.isEmpty()) {
            return new w40(string2);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int size4 = arrayListB2.size();
        int i6 = 0;
        while (i6 < size4) {
            Object obj6 = arrayListB2.get(i6);
            i6++;
            Long lValueOf2 = Long.valueOf(((uw1) obj6).a);
            Object arrayList8 = linkedHashMap2.get(lValueOf2);
            if (arrayList8 == null) {
                arrayList8 = new ArrayList();
                linkedHashMap2.put(lValueOf2, arrayList8);
            }
            ((List) arrayList8).add(obj6);
        }
        z40 z40VarH2 = h(string2, linkedHashMap2.values());
        if (z40VarH2 != null) {
            return z40VarH2;
        }
        z40 z40VarG2 = g(string2, linkedHashMap2.values());
        if (z40VarG2 != null) {
            return z40VarG2;
        }
        a50 a50Var2 = new a50(string2);
        Collection collectionValues3 = linkedHashMap2.values();
        ArrayList arrayList9 = new ArrayList(nz.d(collectionValues3));
        Iterator it3 = collectionValues3.iterator();
        while (it3.hasNext()) {
            arrayList9.add(c((List) it3.next()));
        }
        ArrayList arrayList10 = new ArrayList(nz.d(arrayList9));
        int size5 = arrayList9.size();
        int i7 = 0;
        while (i7 < size5) {
            Object obj7 = arrayList9.get(i7);
            i7++;
            uw1 uw1Var2 = (uw1) obj7;
            arrayList10.add(new wt1(uw1Var2, Float.valueOf(a50Var2.c(uw1Var2.b))));
        }
        ArrayList arrayList11 = new ArrayList();
        int size6 = arrayList10.size();
        while (i2 < size6) {
            Object obj8 = arrayList10.get(i2);
            i2++;
            if (((Number) ((wt1) obj8).b).floatValue() >= 0.68f) {
                arrayList11.add(obj8);
            }
        }
        List listK2 = mz.K(arrayList11, new i2(i, new lo0(14)));
        if (listK2.isEmpty()) {
            return new w40(string2);
        }
        wt1 wt1Var2 = (wt1) mz.x(listK2);
        uw1 uw1Var3 = (uw1) wt1Var2.a;
        float fFloatValue3 = ((Number) wt1Var2.b).floatValue();
        wt1 wt1Var3 = (wt1) mz.z(1, listK2);
        float fFloatValue4 = wt1Var3 != null ? ((Number) wt1Var3.b).floatValue() : 0.0f;
        if (listK2.size() == 1 && fFloatValue3 >= 0.9f) {
            return a(string2, (List) bh1.a(Long.valueOf(uw1Var3.a), linkedHashMap2));
        }
        if (fFloatValue3 >= f3 && fFloatValue4 < f2) {
            return a(string2, (List) bh1.a(Long.valueOf(uw1Var3.a), linkedHashMap2));
        }
        ArrayList arrayList12 = new ArrayList();
        for (Object obj9 : listK2) {
            if (((Number) ((wt1) obj9).b).floatValue() >= fFloatValue3 - f) {
                arrayList12.add(obj9);
            }
        }
        List listL2 = mz.L(arrayList12, 4);
        ArrayList arrayList13 = new ArrayList(nz.d(listL2));
        Iterator it4 = listL2.iterator();
        while (it4.hasNext()) {
            arrayList13.add((uw1) ((wt1) it4.next()).a);
        }
        return new u40(string2, arrayList13);
    }

    public final z40 g(String str, Collection collection) {
        String strA = c50.a(str);
        if (cs2.A(strA)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            x42 x42Var = c50.a;
            if (g31.a(c50.a(((uw1) mz.x((List) obj)).b), strA)) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return a(str, (List) mz.x(arrayList));
        }
        ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
        int size2 = arrayList.size();
        int i = 0;
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(c((List) obj2));
        }
        return new u40(str, mz.L(arrayList2, 4));
    }

    public final z40 h(String str, Collection collection) {
        String strJ = ak1.j(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (ak1.j(((uw1) mz.x((List) obj)).b).equals(strJ)) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return a(str, (List) mz.x(arrayList));
        }
        ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
        int size2 = arrayList.size();
        int i = 0;
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(c((List) obj2));
        }
        return new u40(str, mz.L(arrayList2, 4));
    }
}
