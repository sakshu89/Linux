package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a50 implements xj4 {
    public final /* synthetic */ int a;
    public boolean b;
    public final Object c;
    public Object d;
    public Object e;

    public a50(int i) {
        this.a = i;
        switch (i) {
            case 3:
                this.c = new Object();
                this.d = new ArrayDeque();
                this.e = new AtomicReference();
                break;
            default:
                this.c = new Object();
                this.d = new ArrayList();
                this.e = new ArrayList();
                this.b = true;
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x02d1  */
    @Override // defpackage.xj4
    public uw2 a(k11 k11Var) throws uj1 {
        Bitmap bitmapCreateBitmap;
        String str;
        if (((z94) this.e) == null) {
            zzb();
        }
        if (((z94) this.e) == null) {
            throw new uj1("Waiting for the text recognition module to be downloaded. Please wait.", 14);
        }
        int i = k11Var.d;
        int i2 = 0;
        if (i == -1) {
            bitmapCreateBitmap = k11Var.a;
        } else {
            if (i != -1) {
                if (i == 17) {
                    jg1.d(null);
                    throw null;
                }
                if (i == 35) {
                    jg1.d(null);
                    throw null;
                }
                if (i != 842094169) {
                    throw new uj1("Unsupported image format", 13);
                }
                jg1.d(null);
                throw null;
            }
            Bitmap bitmap = k11Var.a;
            jg1.d(bitmap);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, k11Var.b, k11Var.c);
        }
        ap1 ap1Var = new ap1(bitmapCreateBitmap);
        int i3 = k11Var.b;
        int i4 = k11Var.c;
        try {
            z94 z94Var = (z94) this.e;
            jg1.d(z94Var);
            Parcel parcelC = z94Var.c();
            int i5 = j04.a;
            parcelC.writeStrongBinder(ap1Var);
            char c = 1;
            parcelC.writeInt(1);
            int iE = mz3.e(parcelC, 20293);
            int i6 = 4;
            char c2 = 2;
            mz3.g(parcelC, 2, 4);
            parcelC.writeInt(i3);
            char c3 = 3;
            mz3.g(parcelC, 3, 4);
            parcelC.writeInt(i4);
            mz3.g(parcelC, 4, 4);
            parcelC.writeInt(0);
            mz3.g(parcelC, 5, 8);
            parcelC.writeLong(0L);
            mz3.g(parcelC, 6, 4);
            parcelC.writeInt(0);
            mz3.f(parcelC, iE);
            Parcel parcelD = z94Var.d(parcelC, 1);
            zh4[] zh4VarArr = (zh4[]) parcelD.createTypedArray(zh4.CREATOR);
            parcelD.recycle();
            SparseArray sparseArray = new SparseArray();
            for (zh4 zh4Var : zh4VarArr) {
                SparseArray sparseArray2 = (SparseArray) sparseArray.get(zh4Var.s);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    sparseArray.append(zh4Var.s, sparseArray2);
                }
                sparseArray2.append(zh4Var.t, zh4Var);
            }
            Object[] objArrCopyOf = new Object[4];
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int i9 = 24;
                if (i7 >= sparseArray.size()) {
                    q04 q04VarL = nz3.l(i8, objArrCopyOf);
                    vh4.b(jh4.b(q04VarL, new ak1(24)));
                    return new uw2(q04VarL);
                }
                SparseArray sparseArray3 = (SparseArray) sparseArray.valueAt(i7);
                Object[] objArrCopyOf2 = new Object[i6];
                int i10 = i2;
                int i11 = i10;
                while (i10 < sparseArray3.size()) {
                    zh4 zh4Var2 = (zh4) sparseArray3.valueAt(i10);
                    zh4Var2.getClass();
                    char c4 = c3;
                    int i12 = i11 + 1;
                    char c5 = c;
                    int length = objArrCopyOf2.length;
                    if (length < i12) {
                        int i13 = length + (length >> 1) + 1;
                        if (i13 < i12) {
                            int iHighestOneBit = Integer.highestOneBit(i11);
                            i13 = iHighestOneBit + iHighestOneBit;
                        }
                        objArrCopyOf2 = Arrays.copyOf(objArrCopyOf2, i13 < 0 ? Integer.MAX_VALUE : i13);
                    }
                    objArrCopyOf2[i11] = zh4Var2;
                    i10++;
                    c = c5;
                    i11 = i12;
                    c3 = c4;
                }
                char c6 = c3;
                char c7 = c;
                q04 q04VarL2 = nz3.l(i11, objArrCopyOf2);
                AbstractList abstractListB = jh4.b(q04VarL2, new y74(i9));
                v54 v54Var = ((zh4) q04VarL2.get(i2)).b;
                jz3 jz3VarListIterator = q04VarL2.listIterator(i2);
                int iMax = Integer.MIN_VALUE;
                int iMax2 = Integer.MIN_VALUE;
                int iMin = Integer.MAX_VALUE;
                int iMin2 = Integer.MAX_VALUE;
                while (jz3VarListIterator.hasNext()) {
                    int i14 = i2;
                    v54 v54Var2 = ((zh4) jz3VarListIterator.next()).b;
                    char c8 = c2;
                    int i15 = v54Var.a;
                    float f = v54Var.f;
                    int i16 = -v54Var.b;
                    double d = f;
                    double dSin = Math.sin(Math.toRadians(d));
                    double dCos = Math.cos(Math.toRadians(d));
                    SparseArray sparseArray4 = sparseArray;
                    Point[] pointArr = new Point[4];
                    int i17 = v54Var2.a;
                    jz3 jz3Var = jz3VarListIterator;
                    int i18 = v54Var2.e;
                    int i19 = v54Var2.c;
                    Point point = new Point(i17, v54Var2.b);
                    pointArr[i14] = point;
                    point.offset(-i15, i16);
                    Point point2 = pointArr[i14];
                    int i20 = point2.x;
                    double d2 = ((double) i20) * dCos;
                    double d3 = point2.y;
                    int i21 = i7;
                    int i22 = (int) (d2 + (d3 * dSin));
                    point2.x = i22;
                    int i23 = (int) ((((double) (-i20)) * dSin) + (d3 * dCos));
                    point2.y = i23;
                    int i24 = i19 + i22;
                    pointArr[c7] = new Point(i24, i23);
                    int i25 = i23 + i18;
                    pointArr[c8] = new Point(i24, i25);
                    pointArr[c6] = new Point(i22, i25);
                    for (int i26 = i14; i26 < 4; i26++) {
                        Point point3 = pointArr[i26];
                        iMin = Math.min(iMin, point3.x);
                        iMax = Math.max(iMax, point3.x);
                        iMin2 = Math.min(iMin2, point3.y);
                        iMax2 = Math.max(iMax2, point3.y);
                    }
                    i7 = i21;
                    jz3VarListIterator = jz3Var;
                    i2 = i14;
                    c2 = c8;
                    sparseArray = sparseArray4;
                }
                SparseArray sparseArray5 = sparseArray;
                int i27 = i2;
                int i28 = i7;
                char c9 = c2;
                int i29 = v54Var.a;
                float f2 = v54Var.f;
                int i30 = v54Var.b;
                double d4 = f2;
                double dSin2 = Math.sin(Math.toRadians(d4));
                double dCos2 = Math.cos(Math.toRadians(d4));
                Point[] pointArr2 = {new Point(iMin, iMin2), new Point(iMax, iMin2), new Point(iMax, iMax2), new Point(iMin, iMax2)};
                int i31 = i27;
                while (i31 < 4) {
                    Point point4 = pointArr2[i31];
                    double d5 = point4.x;
                    double d6 = d5 * dCos2;
                    double d7 = dCos2;
                    double d8 = point4.y;
                    point4.x = (int) (d6 - (d8 * dSin2));
                    point4.y = (int) ((d5 * dSin2) + (d8 * d7));
                    point4.offset(i29, i30);
                    i31++;
                    dCos2 = d7;
                }
                List listAsList = Arrays.asList(pointArr2);
                String strB = vh4.b(jh4.b(abstractListB, new fl4(24)));
                Rect rectB = bh4.b(listAsList);
                HashMap map = new HashMap();
                Iterator it = abstractListB.iterator();
                while (it.hasNext()) {
                    String str2 = ((rw2) it.next()).c;
                    map.put(str2, Integer.valueOf((map.containsKey(str2) ? ((Integer) map.get(str2)).intValue() : i27) + 1));
                }
                Set setEntrySet = map.entrySet();
                if (setEntrySet.isEmpty()) {
                    str = "und";
                } else {
                    str = (String) ((Map.Entry) Collections.max(setEntrySet, sb4.a)).getKey();
                    if (hi4.c(str)) {
                        str = "und";
                    }
                }
                tw2 tw2Var = new tw2(strB, rectB, listAsList, str, abstractListB);
                int i32 = i8 + 1;
                int length2 = objArrCopyOf.length;
                if (length2 < i32) {
                    int i33 = length2 + (length2 >> 1) + 1;
                    if (i33 < i32) {
                        int iHighestOneBit2 = Integer.highestOneBit(i8);
                        i33 = iHighestOneBit2 + iHighestOneBit2;
                    }
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i33 < 0 ? Integer.MAX_VALUE : i33);
                }
                objArrCopyOf[i8] = tw2Var;
                i7 = i28 + 1;
                c3 = c6;
                c = c7;
                i8 = i32;
                i2 = i27;
                c2 = c9;
                sparseArray = sparseArray5;
                i6 = 4;
            }
        } catch (RemoteException e) {
            throw new uj1("Failed to run legacy text recognizer.", e);
        }
    }

    @Override // defpackage.xj4
    public void b() {
        switch (this.a) {
            case 3:
                synchronized (this.c) {
                    try {
                        if (((ArrayDeque) this.d).isEmpty()) {
                            this.b = false;
                            return;
                        }
                        xs4 xs4Var = (xs4) ((ArrayDeque) this.d).remove();
                        e(xs4Var.b, xs4Var.a);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            default:
                z94 z94Var = (z94) this.e;
                if (z94Var != null) {
                    try {
                        z94Var.e(z94Var.c(), 2);
                        break;
                    } catch (RemoteException e) {
                        Log.e("LegacyTextDelegate", "Failed to release legacy text recognizer.", e);
                    }
                    this.e = null;
                    return;
                }
                return;
        }
    }

    public float c(String str) {
        boolean z;
        boolean z2;
        float f;
        float f2;
        f81 f81Var = (f81) this.e;
        x42 x42Var = b50.c;
        float fK = ak1.k((String) this.d, ak1.m(str));
        if (fK >= 0.9f) {
            return fK;
        }
        String strA = c50.a(str);
        float fK2 = ak1.k((String) f81Var.getValue(), strA);
        List listN = cs2.N(strA, new char[]{' '}, 6);
        if (cs2.A((String) f81Var.getValue())) {
            z = false;
        } else {
            List listN2 = cs2.N((String) f81Var.getValue(), new char[]{' '}, 6);
            if (!listN2.isEmpty()) {
                Iterator it = listN2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!listN.contains((String) it.next())) {
                            z = false;
                        }
                    }
                }
            }
            z = true;
        }
        boolean z3 = this.b;
        x42 x42Var2 = c50.a;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z2 = false;
                break;
            }
            char cCharAt = str.charAt(i);
            if (2304 <= cCharAt && cCharAt < 2432) {
                z2 = true;
                break;
            }
            i++;
        }
        if (z3 == z2 || !z) {
            if (fK2 > 0.84f) {
                fK2 = 0.84f;
            }
            f = fK2;
        } else {
            f = 0.96f;
        }
        x42 x42Var3 = b50.c;
        List listN3 = cs2.N((String) f81Var.getValue(), new char[]{' '}, 6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN3) {
            if (!cs2.A((String) obj)) {
                arrayList.add(obj);
            }
        }
        List listN4 = cs2.N(strA, new char[]{' '}, 6);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listN4) {
            if (!cs2.A((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        if (arrayList.isEmpty() || arrayList.size() > arrayList3.size()) {
            f2 = 0.0f;
        } else {
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    Object obj3 = arrayList.get(i2);
                    i2++;
                    String str2 = (String) obj3;
                    int size2 = arrayList3.size();
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size2) {
                            i3 = -1;
                            break;
                        }
                        Object obj4 = arrayList3.get(i4);
                        i4++;
                        String str3 = (String) obj4;
                        if (g31.a(str2, str3)) {
                            break;
                        }
                        if (str2.length() >= 3 && str3.length() >= 3 && cs2.t(str2) == cs2.t(str3) && Math.min(str2.length(), str3.length()) * 2 >= Math.max(str2.length(), str3.length()) && js2.e(str2, "sh", false) == js2.e(str3, "sh", false)) {
                            x42 x42Var4 = b50.c;
                            if (ak1.n(str2).length() >= 2 && ak1.n(str2).equals(ak1.n(str3))) {
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    arrayList3.remove(i3);
                } else {
                    f2 = 0.8f;
                }
            }
            f2 = 0.0f;
        }
        return Math.max(fK, Math.max(f, f2));
    }

    public void d(Runnable runnable, Executor executor) {
        synchronized (this.c) {
            try {
                if (this.b) {
                    ((ArrayDeque) this.d).add(new xs4(runnable, executor));
                } else {
                    this.b = true;
                    e(runnable, executor);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(new or0(17, this, runnable));
        } catch (RejectedExecutionException unused) {
            b();
        }
    }

    @Override // defpackage.xj4
    public void zzb() throws uj1 {
        yf4 zb4Var;
        Context context = (Context) this.c;
        if (((z94) this.e) != null) {
            return;
        }
        try {
            IBinder iBinderB = sg0.c(context, sg0.b, "com.google.android.gms.vision.dynamite").b("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator");
            int i = wd4.b;
            if (iBinderB == null) {
                zb4Var = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
                zb4Var = iInterfaceQueryLocalInterface instanceof yf4 ? (yf4) iInterfaceQueryLocalInterface : new zb4(iBinderB, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator", 2);
            }
            z94 z94VarF = ((zb4) zb4Var).f(new ap1(context), (nn4) this.d);
            this.e = z94VarF;
            if (z94VarF != null || this.b) {
                return;
            }
            ds1.a(context);
            this.b = true;
        } catch (RemoteException e) {
            throw new uj1("Failed to create legacy text recognizer.", e);
        } catch (og0 e2) {
            throw new uj1("Failed to load deprecated vision dynamite module.", e2);
        }
    }

    public a50(Context context) {
        this.a = 4;
        this.d = new nn4(null);
        this.c = context;
    }

    public a50(String str) {
        boolean z = false;
        this.a = 0;
        this.c = str;
        x42 x42Var = b50.c;
        this.d = ak1.m(str);
        x42 x42Var2 = c50.a;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (2304 <= cCharAt && cCharAt < 2432) {
                z = true;
                break;
            }
        }
        this.b = z;
        this.e = yp4.a(new kb(3, this));
    }

    public a50(v81 v81Var, ws2 ws2Var, uz1 uz1Var) {
        this.a = 2;
        this.c = v81Var;
        this.d = ws2Var;
        this.e = uz1Var;
        this.b = true;
    }
}
