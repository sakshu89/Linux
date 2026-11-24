package defpackage;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xo0 {
    public static final tf1 a = new tf1(2);
    public static final gb b = new gb(2);

    public static c10 a(Context context, List list) {
        String str;
        Typeface typefaceC;
        Trace.beginSection(hd4.e("FontProvider.getFontFamilyResult"));
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                yo0 yo0Var = (yo0) list.get(i);
                if (Build.VERSION.SDK_INT < 31 || (typefaceC = l33.c((str = yo0Var.e))) == null || l33.d(typefaceC) == null) {
                    ProviderInfo providerInfoB = b(context.getPackageManager(), yo0Var, context.getResources());
                    if (providerInfoB == null) {
                        c10 c10Var = new c10();
                        c10Var.a = 1;
                        c10Var.b = Collections.singletonList(null);
                        return c10Var;
                    }
                    arrayList.add(c(context, yo0Var, providerInfoB.authority));
                } else {
                    arrayList.add(new pp0[]{new pp0(str, yo0Var.f)});
                }
            }
            c10 c10Var2 = new c10();
            c10Var2.a = 0;
            c10Var2.b = arrayList;
            return c10Var2;
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, yo0 yo0Var, Resources resources) {
        gb gbVar = b;
        tf1 tf1Var = a;
        Trace.beginSection(hd4.e("FontProvider.getProvider"));
        try {
            List listB = yo0Var.d;
            String str = yo0Var.a;
            String str2 = yo0Var.b;
            if (listB == null) {
                listB = zn4.b(resources, 0);
            }
            wo0 wo0Var = new wo0();
            wo0Var.a = str;
            wo0Var.b = str2;
            wo0Var.c = listB;
            ProviderInfo providerInfo = (ProviderInfo) tf1Var.a(wo0Var);
            if (providerInfo != null) {
                Trace.endSection();
                return providerInfo;
            }
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(str2)) {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, gbVar);
            for (int i = 0; i < listB.size(); i++) {
                ArrayList arrayList2 = new ArrayList((Collection) listB.get(i));
                Collections.sort(arrayList2, gbVar);
                if (arrayList.size() == arrayList2.size()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            tf1Var.b(wo0Var, providerInfoResolveContentProvider);
                            Trace.endSection();
                            return providerInfoResolveContentProvider;
                        }
                        if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                            break;
                        }
                        i2++;
                    }
                }
            }
            Trace.endSection();
            return null;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static pp0[] c(Context context, yo0 yo0Var, String str) {
        Trace.beginSection(hd4.e("FontProvider.query"));
        try {
            ArrayList arrayList = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
            Cursor cursorQuery = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                Trace.beginSection(hd4.e("ContentQueryWrapper.query"));
                try {
                    String[] strArr2 = {yo0Var.c};
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uriBuild, strArr, "query = ?", strArr2, null, null);
                        } catch (RemoteException e) {
                            Log.w("FontsProvider", "Unable to query the content provider", e);
                        }
                    }
                    Trace.endSection();
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        int columnIndex = cursorQuery.getColumnIndex("result_code");
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex2 = cursorQuery.getColumnIndex("_id");
                        int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                        int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                        int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                        while (cursorQuery.moveToNext()) {
                            int i = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                            arrayList2.add(new pp0(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, i));
                        }
                        arrayList = arrayList2;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    pp0[] pp0VarArr = (pp0[]) arrayList.toArray(new pp0[0]);
                    Trace.endSection();
                    return pp0VarArr;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } catch (Throwable th2) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            Trace.endSection();
            throw th3;
        }
    }
}
