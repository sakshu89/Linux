package defpackage;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jt2 {
    public final String i;
    public final yp j;
    public final ys k;
    public final uf1 l;
    public final int m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public mj s;
    public final nd0 u;
    public final s9 x;
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public final HashMap e = new HashMap();
    public final ArrayList f = new ArrayList();
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();
    public final ArrayList t = new ArrayList();
    public final y74 v = new y74(19);
    public final py0 w = new py0(11);

    public jt2(Context context, String str, zt ztVar, yp ypVar) throws su {
        int i;
        List listSingletonList;
        int[] outputFormats;
        long[] jArr;
        int[] iArr;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        str.getClass();
        this.i = str;
        ypVar.getClass();
        this.j = ypVar;
        this.l = new uf1(19);
        this.u = nd0.b(context);
        try {
            ys ysVarB = ztVar.b(str);
            this.k = ysVarB;
            Integer num = (Integer) ysVarB.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.m = num != null ? num.intValue() : 2;
            int[] iArr2 = (int[]) ysVarB.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr2 != null) {
                for (int i2 : iArr2) {
                    if (i2 == 3) {
                        this.n = true;
                    } else if (i2 == 6) {
                        this.o = true;
                    } else if (Build.VERSION.SDK_INT >= 31 && i2 == 16) {
                        this.r = true;
                    }
                }
            }
            this.x = new s9(this.k);
            ArrayList arrayList = this.a;
            int i3 = this.m;
            boolean z = this.n;
            boolean z2 = this.o;
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            kt2 kt2Var = new kt2();
            lt2 lt2Var = lt2.MAXIMUM;
            ky0.u(1, lt2Var, 0L, kt2Var);
            kt2 kt2VarF = ky0.f(arrayList3, kt2Var);
            ky0.u(3, lt2Var, 0L, kt2VarF);
            kt2 kt2VarF2 = ky0.f(arrayList3, kt2VarF);
            ky0.u(2, lt2Var, 0L, kt2VarF2);
            kt2 kt2VarF3 = ky0.f(arrayList3, kt2VarF2);
            lt2 lt2Var2 = lt2.PREVIEW;
            kt2VarF3.a(new hj(1, lt2Var2, 0L));
            ky0.u(3, lt2Var, 0L, kt2VarF3);
            kt2 kt2VarF4 = ky0.f(arrayList3, kt2VarF3);
            kt2VarF4.a(new hj(2, lt2Var2, 0L));
            ky0.u(3, lt2Var, 0L, kt2VarF4);
            kt2 kt2VarF5 = ky0.f(arrayList3, kt2VarF4);
            kt2VarF5.a(new hj(1, lt2Var2, 0L));
            ky0.u(1, lt2Var2, 0L, kt2VarF5);
            kt2 kt2VarF6 = ky0.f(arrayList3, kt2VarF5);
            kt2VarF6.a(new hj(1, lt2Var2, 0L));
            ky0.u(2, lt2Var2, 0L, kt2VarF6);
            kt2 kt2VarF7 = ky0.f(arrayList3, kt2VarF6);
            kt2VarF7.a(new hj(1, lt2Var2, 0L));
            kt2VarF7.a(new hj(2, lt2Var2, 0L));
            ky0.u(3, lt2Var, 0L, kt2VarF7);
            arrayList3.add(kt2VarF7);
            arrayList2.addAll(arrayList3);
            lt2 lt2Var3 = lt2.RECORD;
            if (i3 == 0 || i3 == 1 || i3 == 3) {
                ArrayList arrayList4 = new ArrayList();
                kt2 kt2Var2 = new kt2();
                kt2Var2.a(new hj(1, lt2Var2, 0L));
                ky0.u(1, lt2Var3, 0L, kt2Var2);
                kt2 kt2VarF8 = ky0.f(arrayList4, kt2Var2);
                kt2VarF8.a(new hj(1, lt2Var2, 0L));
                ky0.u(2, lt2Var3, 0L, kt2VarF8);
                kt2 kt2VarF9 = ky0.f(arrayList4, kt2VarF8);
                kt2VarF9.a(new hj(2, lt2Var2, 0L));
                ky0.u(2, lt2Var3, 0L, kt2VarF9);
                kt2 kt2VarF10 = ky0.f(arrayList4, kt2VarF9);
                kt2VarF10.a(new hj(1, lt2Var2, 0L));
                kt2VarF10.a(new hj(1, lt2Var3, 0L));
                ky0.u(3, lt2Var3, 0L, kt2VarF10);
                kt2 kt2VarF11 = ky0.f(arrayList4, kt2VarF10);
                kt2VarF11.a(new hj(1, lt2Var2, 0L));
                kt2VarF11.a(new hj(2, lt2Var3, 0L));
                i = 3;
                ky0.u(3, lt2Var3, 0L, kt2VarF11);
                kt2 kt2VarF12 = ky0.f(arrayList4, kt2VarF11);
                kt2VarF12.a(new hj(2, lt2Var2, 0L));
                kt2VarF12.a(new hj(2, lt2Var2, 0L));
                ky0.u(3, lt2Var, 0L, kt2VarF12);
                arrayList4.add(kt2VarF12);
                arrayList2.addAll(arrayList4);
            } else {
                i = 3;
            }
            lt2 lt2Var4 = lt2.VGA;
            if (i3 == 1 || i3 == i) {
                ArrayList arrayList5 = new ArrayList();
                kt2 kt2Var3 = new kt2();
                kt2Var3.a(new hj(1, lt2Var2, 0L));
                ky0.u(1, lt2Var, 0L, kt2Var3);
                kt2 kt2VarF13 = ky0.f(arrayList5, kt2Var3);
                kt2VarF13.a(new hj(1, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF13);
                kt2 kt2VarF14 = ky0.f(arrayList5, kt2VarF13);
                kt2VarF14.a(new hj(2, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF14);
                kt2 kt2VarF15 = ky0.f(arrayList5, kt2VarF14);
                kt2VarF15.a(new hj(1, lt2Var2, 0L));
                kt2VarF15.a(new hj(1, lt2Var2, 0L));
                ky0.u(3, lt2Var, 0L, kt2VarF15);
                kt2 kt2VarF16 = ky0.f(arrayList5, kt2VarF15);
                kt2VarF16.a(new hj(2, lt2Var4, 0L));
                kt2VarF16.a(new hj(1, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF16);
                kt2 kt2VarF17 = ky0.f(arrayList5, kt2VarF16);
                kt2VarF17.a(new hj(2, lt2Var4, 0L));
                kt2VarF17.a(new hj(2, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF17);
                arrayList5.add(kt2VarF17);
                arrayList2.addAll(arrayList5);
            }
            if (z) {
                ArrayList arrayList6 = new ArrayList();
                kt2 kt2Var4 = new kt2();
                ky0.u(5, lt2Var, 0L, kt2Var4);
                kt2 kt2VarF18 = ky0.f(arrayList6, kt2Var4);
                kt2VarF18.a(new hj(1, lt2Var2, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF18);
                kt2 kt2VarF19 = ky0.f(arrayList6, kt2VarF18);
                kt2VarF19.a(new hj(2, lt2Var2, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF19);
                kt2 kt2VarF20 = ky0.f(arrayList6, kt2VarF19);
                kt2VarF20.a(new hj(1, lt2Var2, 0L));
                kt2VarF20.a(new hj(1, lt2Var2, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF20);
                kt2 kt2VarF21 = ky0.f(arrayList6, kt2VarF20);
                kt2VarF21.a(new hj(1, lt2Var2, 0L));
                kt2VarF21.a(new hj(2, lt2Var2, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF21);
                kt2 kt2VarF22 = ky0.f(arrayList6, kt2VarF21);
                kt2VarF22.a(new hj(2, lt2Var2, 0L));
                kt2VarF22.a(new hj(2, lt2Var2, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF22);
                kt2 kt2VarF23 = ky0.f(arrayList6, kt2VarF22);
                kt2VarF23.a(new hj(1, lt2Var2, 0L));
                kt2VarF23.a(new hj(3, lt2Var, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF23);
                kt2 kt2VarF24 = ky0.f(arrayList6, kt2VarF23);
                kt2VarF24.a(new hj(2, lt2Var2, 0L));
                kt2VarF24.a(new hj(3, lt2Var, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF24);
                arrayList6.add(kt2VarF24);
                arrayList2.addAll(arrayList6);
            }
            if (z2 && i3 == 0) {
                ArrayList arrayList7 = new ArrayList();
                kt2 kt2Var5 = new kt2();
                kt2Var5.a(new hj(1, lt2Var2, 0L));
                ky0.u(1, lt2Var, 0L, kt2Var5);
                kt2 kt2VarF25 = ky0.f(arrayList7, kt2Var5);
                kt2VarF25.a(new hj(1, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF25);
                kt2 kt2VarF26 = ky0.f(arrayList7, kt2VarF25);
                kt2VarF26.a(new hj(2, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF26);
                arrayList7.add(kt2VarF26);
                arrayList2.addAll(arrayList7);
            }
            if (i3 == 3) {
                ArrayList arrayList8 = new ArrayList();
                kt2 kt2Var6 = new kt2();
                kt2Var6.a(new hj(1, lt2Var2, 0L));
                kt2Var6.a(new hj(1, lt2Var4, 0L));
                kt2Var6.a(new hj(2, lt2Var, 0L));
                ky0.u(5, lt2Var, 0L, kt2Var6);
                kt2 kt2VarF27 = ky0.f(arrayList8, kt2Var6);
                kt2VarF27.a(new hj(1, lt2Var2, 0L));
                kt2VarF27.a(new hj(1, lt2Var4, 0L));
                kt2VarF27.a(new hj(3, lt2Var, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF27);
                arrayList8.add(kt2VarF27);
                arrayList2.addAll(arrayList8);
            }
            arrayList.addAll(arrayList2);
            uf1 uf1Var = this.l;
            String str2 = this.i;
            if (((ExtraSupportedSurfaceCombinationsQuirk) uf1Var.b) == null) {
                listSingletonList = new ArrayList();
            } else {
                kt2 kt2Var7 = ExtraSupportedSurfaceCombinationsQuirk.a;
                String str3 = Build.DEVICE;
                if ("heroqltevzw".equalsIgnoreCase(str3) || "heroqltetmo".equalsIgnoreCase(str3)) {
                    ArrayList arrayList9 = new ArrayList();
                    listSingletonList = arrayList9;
                    if (str2.equals("1")) {
                        arrayList9.add(ExtraSupportedSurfaceCombinationsQuirk.a);
                        listSingletonList = arrayList9;
                    }
                } else {
                    listSingletonList = ((!"google".equalsIgnoreCase(Build.BRAND) ? false : ExtraSupportedSurfaceCombinationsQuirk.c.contains(Build.MODEL.toUpperCase(Locale.US))) || ExtraSupportedSurfaceCombinationsQuirk.b()) ? Collections.singletonList(ExtraSupportedSurfaceCombinationsQuirk.b) : Collections.EMPTY_LIST;
                }
            }
            arrayList.addAll(listSingletonList);
            if (this.r) {
                ArrayList arrayList10 = this.b;
                ArrayList arrayList11 = new ArrayList();
                kt2 kt2Var8 = new kt2();
                lt2 lt2Var5 = lt2.ULTRA_MAXIMUM;
                kt2Var8.a(new hj(2, lt2Var5, 0L));
                kt2Var8.a(new hj(1, lt2Var2, 0L));
                ky0.u(1, lt2Var3, 0L, kt2Var8);
                kt2 kt2VarF28 = ky0.f(arrayList11, kt2Var8);
                kt2VarF28.a(new hj(3, lt2Var5, 0L));
                kt2VarF28.a(new hj(1, lt2Var2, 0L));
                ky0.u(1, lt2Var3, 0L, kt2VarF28);
                kt2 kt2VarF29 = ky0.f(arrayList11, kt2VarF28);
                kt2VarF29.a(new hj(5, lt2Var5, 0L));
                kt2VarF29.a(new hj(1, lt2Var2, 0L));
                ky0.u(1, lt2Var3, 0L, kt2VarF29);
                kt2 kt2VarF30 = ky0.f(arrayList11, kt2VarF29);
                kt2VarF30.a(new hj(2, lt2Var5, 0L));
                kt2VarF30.a(new hj(1, lt2Var2, 0L));
                ky0.u(3, lt2Var, 0L, kt2VarF30);
                kt2 kt2VarF31 = ky0.f(arrayList11, kt2VarF30);
                kt2VarF31.a(new hj(3, lt2Var5, 0L));
                kt2VarF31.a(new hj(1, lt2Var2, 0L));
                ky0.u(3, lt2Var, 0L, kt2VarF31);
                kt2 kt2VarF32 = ky0.f(arrayList11, kt2VarF31);
                kt2VarF32.a(new hj(5, lt2Var5, 0L));
                kt2VarF32.a(new hj(1, lt2Var2, 0L));
                ky0.u(3, lt2Var, 0L, kt2VarF32);
                kt2 kt2VarF33 = ky0.f(arrayList11, kt2VarF32);
                kt2VarF33.a(new hj(2, lt2Var5, 0L));
                kt2VarF33.a(new hj(1, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF33);
                kt2 kt2VarF34 = ky0.f(arrayList11, kt2VarF33);
                kt2VarF34.a(new hj(3, lt2Var5, 0L));
                kt2VarF34.a(new hj(1, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF34);
                kt2 kt2VarF35 = ky0.f(arrayList11, kt2VarF34);
                kt2VarF35.a(new hj(5, lt2Var5, 0L));
                kt2VarF35.a(new hj(1, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF35);
                kt2 kt2VarF36 = ky0.f(arrayList11, kt2VarF35);
                kt2VarF36.a(new hj(2, lt2Var5, 0L));
                kt2VarF36.a(new hj(1, lt2Var2, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF36);
                kt2 kt2VarF37 = ky0.f(arrayList11, kt2VarF36);
                kt2VarF37.a(new hj(3, lt2Var5, 0L));
                kt2VarF37.a(new hj(1, lt2Var2, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF37);
                kt2 kt2VarF38 = ky0.f(arrayList11, kt2VarF37);
                kt2VarF38.a(new hj(5, lt2Var5, 0L));
                kt2VarF38.a(new hj(1, lt2Var2, 0L));
                ky0.u(5, lt2Var, 0L, kt2VarF38);
                arrayList11.add(kt2VarF38);
                arrayList10.addAll(arrayList11);
            }
            boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
            this.p = zHasSystemFeature;
            lt2 lt2Var6 = lt2.s1440p;
            if (zHasSystemFeature) {
                ArrayList arrayList12 = this.c;
                ArrayList arrayList13 = new ArrayList();
                kt2 kt2Var9 = new kt2();
                ky0.u(2, lt2Var6, 0L, kt2Var9);
                kt2 kt2VarF39 = ky0.f(arrayList13, kt2Var9);
                ky0.u(1, lt2Var6, 0L, kt2VarF39);
                kt2 kt2VarF40 = ky0.f(arrayList13, kt2VarF39);
                ky0.u(3, lt2Var6, 0L, kt2VarF40);
                kt2 kt2VarF41 = ky0.f(arrayList13, kt2VarF40);
                lt2 lt2Var7 = lt2.s720p;
                kt2VarF41.a(new hj(2, lt2Var7, 0L));
                ky0.u(3, lt2Var6, 0L, kt2VarF41);
                kt2 kt2VarF42 = ky0.f(arrayList13, kt2VarF41);
                kt2VarF42.a(new hj(1, lt2Var7, 0L));
                ky0.u(3, lt2Var6, 0L, kt2VarF42);
                kt2 kt2VarF43 = ky0.f(arrayList13, kt2VarF42);
                kt2VarF43.a(new hj(2, lt2Var7, 0L));
                ky0.u(2, lt2Var6, 0L, kt2VarF43);
                kt2 kt2VarF44 = ky0.f(arrayList13, kt2VarF43);
                kt2VarF44.a(new hj(2, lt2Var7, 0L));
                ky0.u(1, lt2Var6, 0L, kt2VarF44);
                kt2 kt2VarF45 = ky0.f(arrayList13, kt2VarF44);
                kt2VarF45.a(new hj(1, lt2Var7, 0L));
                ky0.u(2, lt2Var6, 0L, kt2VarF45);
                kt2 kt2VarF46 = ky0.f(arrayList13, kt2VarF45);
                kt2VarF46.a(new hj(1, lt2Var7, 0L));
                ky0.u(1, lt2Var6, 0L, kt2VarF46);
                arrayList13.add(kt2VarF46);
                arrayList12.addAll(arrayList13);
            }
            if (this.x.b) {
                ArrayList arrayList14 = this.f;
                ArrayList arrayList15 = new ArrayList();
                kt2 kt2Var10 = new kt2();
                ky0.u(1, lt2Var, 0L, kt2Var10);
                kt2 kt2VarF47 = ky0.f(arrayList15, kt2Var10);
                ky0.u(2, lt2Var, 0L, kt2VarF47);
                kt2 kt2VarF48 = ky0.f(arrayList15, kt2VarF47);
                kt2VarF48.a(new hj(1, lt2Var2, 0L));
                ky0.u(3, lt2Var, 0L, kt2VarF48);
                kt2 kt2VarF49 = ky0.f(arrayList15, kt2VarF48);
                kt2VarF49.a(new hj(1, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF49);
                kt2 kt2VarF50 = ky0.f(arrayList15, kt2VarF49);
                kt2VarF50.a(new hj(2, lt2Var2, 0L));
                ky0.u(2, lt2Var, 0L, kt2VarF50);
                kt2 kt2VarF51 = ky0.f(arrayList15, kt2VarF50);
                kt2VarF51.a(new hj(1, lt2Var2, 0L));
                ky0.u(1, lt2Var3, 0L, kt2VarF51);
                kt2 kt2VarF52 = ky0.f(arrayList15, kt2VarF51);
                kt2VarF52.a(new hj(1, lt2Var2, 0L));
                kt2VarF52.a(new hj(1, lt2Var3, 0L));
                ky0.u(2, lt2Var3, 0L, kt2VarF52);
                kt2 kt2VarF53 = ky0.f(arrayList15, kt2VarF52);
                kt2VarF53.a(new hj(1, lt2Var2, 0L));
                kt2VarF53.a(new hj(1, lt2Var3, 0L));
                ky0.u(3, lt2Var3, 0L, kt2VarF53);
                arrayList15.add(kt2VarF53);
                arrayList14.addAll(arrayList15);
            }
            wj1 wj1Var = (wj1) this.k.b().a;
            wj1Var.getClass();
            try {
                outputFormats = ((StreamConfigurationMap) wj1Var.b).getOutputFormats();
            } catch (IllegalArgumentException | NullPointerException e) {
                xq4.e("StreamConfigurationMapCompatBaseImpl", "Failed to get output formats from StreamConfigurationMap", e);
                outputFormats = null;
            }
            int[] iArr3 = outputFormats != null ? (int[]) outputFormats.clone() : null;
            if (iArr3 != null) {
                for (int i4 : iArr3) {
                    if (i4 == 4101) {
                        ArrayList arrayList16 = this.g;
                        ArrayList arrayList17 = new ArrayList();
                        kt2 kt2Var11 = new kt2();
                        ky0.u(4, lt2Var, 0L, kt2Var11);
                        kt2 kt2VarF54 = ky0.f(arrayList17, kt2Var11);
                        kt2VarF54.a(new hj(1, lt2Var2, 0L));
                        ky0.u(4, lt2Var, 0L, kt2VarF54);
                        arrayList17.add(kt2VarF54);
                        arrayList16.addAll(arrayList17);
                        break;
                    }
                }
            }
            ys ysVar = this.k;
            bi biVar = as2.a;
            int i5 = Build.VERSION.SDK_INT;
            boolean z3 = (i5 < 33 || (jArr = (long[]) ysVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) ? false : true;
            this.q = z3;
            if (z3 && i5 >= 33) {
                ArrayList arrayList18 = this.h;
                ArrayList arrayList19 = new ArrayList();
                kt2 kt2Var12 = new kt2();
                ky0.u(1, lt2Var6, 4L, kt2Var12);
                kt2 kt2VarF55 = ky0.f(arrayList19, kt2Var12);
                ky0.u(2, lt2Var6, 4L, kt2VarF55);
                kt2 kt2VarF56 = ky0.f(arrayList19, kt2VarF55);
                ky0.u(1, lt2Var3, 3L, kt2VarF56);
                kt2 kt2VarF57 = ky0.f(arrayList19, kt2VarF56);
                ky0.u(2, lt2Var3, 3L, kt2VarF57);
                kt2 kt2VarF58 = ky0.f(arrayList19, kt2VarF57);
                ky0.u(3, lt2Var, 2L, kt2VarF58);
                kt2 kt2VarF59 = ky0.f(arrayList19, kt2VarF58);
                ky0.u(2, lt2Var, 2L, kt2VarF59);
                kt2 kt2VarF60 = ky0.f(arrayList19, kt2VarF59);
                kt2VarF60.a(new hj(1, lt2Var2, 1L));
                ky0.u(3, lt2Var, 2L, kt2VarF60);
                kt2 kt2VarF61 = ky0.f(arrayList19, kt2VarF60);
                kt2VarF61.a(new hj(1, lt2Var2, 1L));
                ky0.u(2, lt2Var, 2L, kt2VarF61);
                kt2 kt2VarF62 = ky0.f(arrayList19, kt2VarF61);
                kt2VarF62.a(new hj(1, lt2Var2, 1L));
                ky0.u(1, lt2Var3, 3L, kt2VarF62);
                kt2 kt2VarF63 = ky0.f(arrayList19, kt2VarF62);
                kt2VarF63.a(new hj(1, lt2Var2, 1L));
                ky0.u(2, lt2Var3, 3L, kt2VarF63);
                kt2 kt2VarF64 = ky0.f(arrayList19, kt2VarF63);
                kt2VarF64.a(new hj(1, lt2Var2, 1L));
                ky0.u(2, lt2Var2, 1L, kt2VarF64);
                kt2 kt2VarF65 = ky0.f(arrayList19, kt2VarF64);
                kt2VarF65.a(new hj(1, lt2Var2, 1L));
                kt2VarF65.a(new hj(1, lt2Var3, 3L));
                ky0.u(3, lt2Var3, 2L, kt2VarF65);
                kt2 kt2VarF66 = ky0.f(arrayList19, kt2VarF65);
                kt2VarF66.a(new hj(1, lt2Var2, 1L));
                kt2VarF66.a(new hj(2, lt2Var3, 3L));
                ky0.u(3, lt2Var3, 2L, kt2VarF66);
                kt2 kt2VarF67 = ky0.f(arrayList19, kt2VarF66);
                kt2VarF67.a(new hj(1, lt2Var2, 1L));
                kt2VarF67.a(new hj(2, lt2Var2, 1L));
                ky0.u(3, lt2Var, 2L, kt2VarF67);
                arrayList19.add(kt2VarF67);
                arrayList18.addAll(arrayList19);
            }
            ys ysVar2 = this.k;
            if (i5 >= 33 && (iArr = (int[]) ysVar2.a(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) != null && iArr.length != 0) {
                for (int i6 : iArr) {
                    if (i6 == 2) {
                        if (Build.VERSION.SDK_INT < 33) {
                            break;
                        }
                        ArrayList arrayList20 = this.d;
                        ArrayList arrayList21 = new ArrayList();
                        kt2 kt2Var13 = new kt2();
                        ky0.u(1, lt2Var6, 0L, kt2Var13);
                        kt2 kt2VarF68 = ky0.f(arrayList21, kt2Var13);
                        ky0.u(2, lt2Var6, 0L, kt2VarF68);
                        kt2 kt2VarF69 = ky0.f(arrayList21, kt2VarF68);
                        kt2VarF69.a(new hj(1, lt2Var6, 0L));
                        ky0.u(3, lt2Var, 0L, kt2VarF69);
                        kt2 kt2VarF70 = ky0.f(arrayList21, kt2VarF69);
                        kt2VarF70.a(new hj(2, lt2Var6, 0L));
                        ky0.u(3, lt2Var, 0L, kt2VarF70);
                        kt2 kt2VarF71 = ky0.f(arrayList21, kt2VarF70);
                        kt2VarF71.a(new hj(1, lt2Var6, 0L));
                        ky0.u(2, lt2Var, 0L, kt2VarF71);
                        kt2 kt2VarF72 = ky0.f(arrayList21, kt2VarF71);
                        kt2VarF72.a(new hj(2, lt2Var6, 0L));
                        ky0.u(2, lt2Var, 0L, kt2VarF72);
                        kt2 kt2VarF73 = ky0.f(arrayList21, kt2VarF72);
                        kt2VarF73.a(new hj(1, lt2Var2, 0L));
                        ky0.u(1, lt2Var6, 0L, kt2VarF73);
                        kt2 kt2VarF74 = ky0.f(arrayList21, kt2VarF73);
                        kt2VarF74.a(new hj(2, lt2Var2, 0L));
                        ky0.u(1, lt2Var6, 0L, kt2VarF74);
                        kt2 kt2VarF75 = ky0.f(arrayList21, kt2VarF74);
                        kt2VarF75.a(new hj(1, lt2Var2, 0L));
                        ky0.u(2, lt2Var6, 0L, kt2VarF75);
                        kt2 kt2VarF76 = ky0.f(arrayList21, kt2VarF75);
                        kt2VarF76.a(new hj(2, lt2Var2, 0L));
                        ky0.u(2, lt2Var6, 0L, kt2VarF76);
                        arrayList21.add(kt2VarF76);
                        arrayList20.addAll(arrayList21);
                        break;
                    }
                }
            }
            b();
        } catch (ds e2) {
            throw new su(e2);
        }
    }

    public static Size c(StreamConfigurationMap streamConfigurationMap, int i, boolean z) {
        Size[] highResolutionOutputSizes;
        Size[] outputSizes = i == 34 ? streamConfigurationMap.getOutputSizes(SurfaceTexture.class) : streamConfigurationMap.getOutputSizes(i);
        if (outputSizes == null || outputSizes.length == 0) {
            return null;
        }
        v00 v00Var = new v00(false);
        Size size = (Size) Collections.max(Arrays.asList(outputSizes), v00Var);
        Size size2 = al2.a;
        if (z && (highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(i)) != null && highResolutionOutputSizes.length > 0) {
            size2 = (Size) Collections.max(Arrays.asList(highResolutionOutputSizes), v00Var);
        }
        return (Size) Collections.max(Arrays.asList(size, size2), v00Var);
    }

    public static int e(Range range, Range range2) {
        hh1.e("Ranges must not intersect", (range.contains((Integer) range2.getUpper()) || range.contains((Integer) range2.getLower())) ? false : true);
        return ((Integer) range.getLower()).intValue() > ((Integer) range2.getUpper()).intValue() ? ((Integer) range.getLower()).intValue() - ((Integer) range2.getUpper()).intValue() : ((Integer) range2.getLower()).intValue() - ((Integer) range.getUpper()).intValue();
    }

    public static int f(Range range) {
        return (((Integer) range.getUpper()).intValue() - ((Integer) range.getLower()).intValue()) + 1;
    }

    public final boolean a(gj gjVar, List list) {
        List list2;
        HashMap map = this.e;
        if (map.containsKey(gjVar)) {
            list2 = (List) map.get(gjVar);
        } else {
            ArrayList arrayList = new ArrayList();
            boolean z = gjVar.d;
            int i = gjVar.a;
            if (!z) {
                int i2 = gjVar.b;
                if (i2 == 8) {
                    if (i != 1) {
                        ArrayList arrayList2 = this.a;
                        if (i != 2) {
                            if (gjVar.c) {
                                arrayList2 = this.d;
                            }
                            arrayList.addAll(arrayList2);
                        } else {
                            arrayList.addAll(this.b);
                            arrayList.addAll(arrayList2);
                        }
                    } else {
                        list2 = this.c;
                    }
                    map.put(gjVar, list2);
                } else if (i2 == 10 && i == 0) {
                    arrayList.addAll(this.f);
                }
            } else if (i == 0) {
                arrayList.addAll(this.g);
            }
            list2 = arrayList;
            map.put(gjVar, list2);
        }
        Iterator it = list2.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 = ((kt2) it.next()).c(list) != null;
            if (z2) {
                break;
            }
        }
        return z2;
    }

    public final void b() {
        Size size;
        Size size2;
        Size size3;
        Size sizeE = this.u.e();
        try {
            int i = Integer.parseInt(this.i);
            yp ypVar = this.j;
            CamcorderProfile camcorderProfileC = null;
            CamcorderProfile camcorderProfileC2 = ypVar.e(i, 1) ? ypVar.c(i, 1) : null;
            if (camcorderProfileC2 == null) {
                Size size4 = al2.c;
                if (ypVar.e(i, 10)) {
                    camcorderProfileC = ypVar.c(i, 10);
                } else if (ypVar.e(i, 8)) {
                    camcorderProfileC = ypVar.c(i, 8);
                } else if (ypVar.e(i, 12)) {
                    camcorderProfileC = ypVar.c(i, 12);
                } else if (ypVar.e(i, 6)) {
                    camcorderProfileC = ypVar.c(i, 6);
                } else if (ypVar.e(i, 5)) {
                    camcorderProfileC = ypVar.c(i, 5);
                } else if (ypVar.e(i, 4)) {
                    camcorderProfileC = ypVar.c(i, 4);
                }
                if (camcorderProfileC != null) {
                    size2 = new Size(camcorderProfileC.videoFrameWidth, camcorderProfileC.videoFrameHeight);
                } else {
                    size3 = size4;
                }
                this.s = new mj(al2.b, new HashMap(), sizeE, new HashMap(), size3, new HashMap(), new HashMap());
            }
            size2 = new Size(camcorderProfileC2.videoFrameWidth, camcorderProfileC2.videoFrameHeight);
        } catch (NumberFormatException unused) {
            Size[] outputSizes = ((StreamConfigurationMap) ((wj1) this.k.b().a).b).getOutputSizes(MediaRecorder.class);
            if (outputSizes == null) {
                size = al2.c;
            } else {
                Arrays.sort(outputSizes, new v00(true));
                int length = outputSizes.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Size size5 = outputSizes[i2];
                        int width = size5.getWidth();
                        Size size6 = al2.e;
                        if (width <= size6.getWidth() && size5.getHeight() <= size6.getHeight()) {
                            size2 = size5;
                            break;
                        }
                        i2++;
                    } else {
                        size = al2.c;
                    }
                }
            }
            size2 = size;
            break;
        }
        size3 = size2;
        this.s = new mj(al2.b, new HashMap(), sizeE, new HashMap(), size3, new HashMap(), new HashMap());
    }

    public final List d(gj gjVar, List list) {
        bi biVar = as2.a;
        if (gjVar.a != 0 || gjVar.b != 8) {
            return null;
        }
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            List listC = ((kt2) obj).c(list);
            if (listC != null) {
                return listC;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:299:0x0813  */
    /* JADX WARN: Code duplicated, block: B:309:0x0835 A[LOOP:27: B:308:0x0833->B:309:0x0835, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:313:0x084b  */
    /* JADX WARN: Code duplicated, block: B:318:0x0863  */
    /* JADX WARN: Code duplicated, block: B:412:0x0a86  */
    /* JADX WARN: Code duplicated, block: B:413:0x0a88  */
    /* JADX WARN: Code duplicated, block: B:481:0x0be8  */
    /* JADX WARN: Code duplicated, block: B:563:0x0da2  */
    /* JADX WARN: Code duplicated, block: B:565:0x0db6  */
    /* JADX WARN: Code duplicated, block: B:567:0x0dc8  */
    /* JADX WARN: Code duplicated, block: B:569:0x0dce  */
    /* JADX WARN: Code duplicated, block: B:571:0x0dd2  */
    /* JADX WARN: Code duplicated, block: B:573:0x0dd6  */
    /* JADX WARN: Code duplicated, block: B:575:0x0dda  */
    /* JADX WARN: Code duplicated, block: B:584:0x0e08  */
    /* JADX WARN: Code duplicated, block: B:586:0x0e14  */
    /* JADX WARN: Code duplicated, block: B:588:0x0e2c  */
    /* JADX WARN: Code duplicated, block: B:641:0x0292 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:694:0x085e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:722:0x0e41 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:724:0x0dff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:725:0x0df9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:726:0x0df3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:729:0x0e39 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x025c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0266  */
    public final Pair g(int i, ArrayList arrayList, HashMap map, boolean z, boolean z2) {
        boolean z3;
        int i2;
        HashMap map2;
        boolean z4;
        ArrayList arrayList2;
        int i3;
        HashMap map3;
        ArrayList arrayList3;
        String str;
        Range range;
        HashMap map4;
        List list;
        String str2;
        HashMap map5;
        HashMap map6;
        String str3;
        HashMap map7;
        ArrayList arrayList4;
        int i4;
        int i5;
        List list2;
        ArrayList arrayList5;
        List list3;
        List list4;
        Range range2;
        HashMap map8;
        int i6;
        int i7;
        HashMap map9;
        int i8;
        long j;
        HashMap map10;
        HashMap map11;
        r53 r53Var;
        fj fjVar;
        zr zrVarA;
        rh rhVar;
        zr zrVarA2;
        Size size;
        Range range3;
        ig0 ig0Var;
        Range range4;
        Range[] rangeArr;
        int i9;
        Range range5;
        List list5;
        ArrayList arrayList6;
        List list6;
        long[] jArr;
        HashSet hashSet;
        int i10;
        Iterator it;
        int outputMinFrameDuration;
        Rational rational;
        HashMap map12;
        Size sizeB;
        String str4;
        int outputMinFrameDuration2;
        int i11;
        int i12;
        ArrayList arrayList7;
        ArrayList arrayList8;
        Iterator it2;
        ig0 ig0Var2;
        ig0 ig0VarD;
        int i13;
        ArrayList arrayList9 = arrayList;
        ig0 ig0Var3 = ig0.c;
        int i14 = 0;
        nd0 nd0Var = this.u;
        nd0Var.b = nd0Var.a();
        if (this.s == null) {
            b();
        } else {
            Size sizeE = this.u.e();
            mj mjVar = this.s;
            this.s = new mj(mjVar.a, mjVar.b, sizeE, mjVar.d, mjVar.e, mjVar.f, mjVar.g);
        }
        ArrayList arrayList10 = new ArrayList(map.keySet());
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        int size2 = arrayList10.size();
        int i15 = 0;
        while (i15 < size2) {
            Object obj = arrayList10.get(i15);
            i15++;
            Integer num = (Integer) ((r53) obj).d(r53.S, 0);
            num.getClass();
            if (!arrayList12.contains(num)) {
                arrayList12.add(num);
            }
        }
        Collections.sort(arrayList12);
        Collections.reverse(arrayList12);
        int size3 = arrayList12.size();
        int i16 = 0;
        while (i16 < size3) {
            Object obj2 = arrayList12.get(i16);
            i16++;
            int iIntValue = ((Integer) obj2).intValue();
            int size4 = arrayList10.size();
            int i17 = i14;
            while (i17 < size4) {
                Object obj3 = arrayList10.get(i17);
                i17++;
                r53 r53Var2 = (r53) obj3;
                if (iIntValue == ((Integer) r53Var2.d(r53.S, 0)).intValue()) {
                    arrayList11.add(Integer.valueOf(arrayList10.indexOf(r53Var2)));
                }
                i14 = 0;
            }
        }
        s9 s9Var = this.x;
        q82 q82Var = (q82) s9Var.e;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size5 = arrayList9.size();
        int i18 = 0;
        while (i18 < size5) {
            Object obj4 = arrayList9.get(i18);
            i18++;
            linkedHashSet.add(((rh) obj4).d);
        }
        Set setB = ((kg0) q82Var.a).b();
        HashSet hashSet2 = new HashSet(setB);
        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            s9.k(hashSet2, (ig0) it3.next(), q82Var);
        }
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        int size6 = arrayList11.size();
        int i19 = 0;
        while (i19 < size6) {
            Object obj5 = arrayList11.get(i19);
            int i20 = i19 + 1;
            r53 r53Var3 = (r53) arrayList10.get(((Integer) obj5).intValue());
            ig0 ig0Var4 = (ig0) r53Var3.d(wy0.y, ig0Var3);
            ig0Var4.getClass();
            if (ig0Var4.equals(ig0Var3)) {
                arrayList15.add(r53Var3);
                i13 = size6;
            } else {
                i13 = size6;
                int i21 = ig0Var4.a;
                int i22 = ig0Var4.b;
                if (i21 == 2 || ((i21 != 0 && i22 == 0) || (i21 == 0 && i22 != 0))) {
                    arrayList14.add(r53Var3);
                } else {
                    arrayList13.add(r53Var3);
                }
            }
            i19 = i20;
            size6 = i13;
        }
        HashMap map13 = new HashMap();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList arrayList16 = new ArrayList();
        arrayList16.addAll(arrayList13);
        arrayList16.addAll(arrayList14);
        arrayList16.addAll(arrayList15);
        int size7 = arrayList16.size();
        int i23 = 0;
        while (i23 < size7) {
            Object obj6 = arrayList16.get(i23);
            int i24 = i23 + 1;
            r53 r53Var4 = (r53) obj6;
            ArrayList arrayList17 = arrayList16;
            ig0 ig0Var5 = (ig0) r53Var4.d(wy0.y, ig0Var3);
            ig0Var5.getClass();
            ig0 ig0Var6 = ig0Var3;
            ig0 ig0Var7 = ig0.d;
            if (!ig0Var5.b()) {
                i11 = size7;
                int i25 = ig0Var5.a;
                i12 = i24;
                int i26 = ig0Var5.b;
                arrayList7 = arrayList10;
                if (i25 == 1 && i26 == 0) {
                    if (!hashSet2.contains(ig0Var7)) {
                        s9Var = s9Var;
                        arrayList8 = arrayList11;
                        ig0Var7 = null;
                        break;
                    }
                    s9Var = s9Var;
                    arrayList8 = arrayList11;
                } else {
                    ig0 ig0VarF = s9.f(ig0Var5, linkedHashSet, hashSet2);
                    if (ig0VarF == null) {
                        arrayList8 = arrayList11;
                        ig0VarF = s9.f(ig0Var5, linkedHashSet2, hashSet2);
                        if (ig0VarF != null) {
                            ig0Var5.toString();
                            ig0VarF.toString();
                            xq4.c(3, "DynamicRangeResolver");
                        } else if (s9.d(ig0Var5, ig0Var7, hashSet2)) {
                            ig0Var5.toString();
                            ig0Var7.toString();
                            xq4.c(3, "DynamicRangeResolver");
                            s9Var = s9Var;
                        } else if (i25 == 2 && (i26 == 10 || i26 == 0)) {
                            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                            if (Build.VERSION.SDK_INT >= 33 && (ig0VarD = f3.d((ys) s9Var.c)) != null) {
                                linkedHashSet3.add(ig0VarD);
                            }
                            linkedHashSet3.add(ig0.e);
                            ig0 ig0VarF2 = s9.f(ig0Var5, linkedHashSet3, hashSet2);
                            if (ig0VarF2 == null) {
                                it2 = hashSet2.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        s9Var = s9Var;
                                        ig0Var7 = null;
                                        break;
                                    }
                                    ig0Var2 = (ig0) it2.next();
                                    s9Var = s9Var;
                                    hh1.e("Candidate dynamic range must be fully specified.", ig0Var2.b());
                                    if (!ig0Var2.equals(ig0Var7)) {
                                        ig0Var5.toString();
                                        ig0Var2.toString();
                                        xq4.c(3, "DynamicRangeResolver");
                                        ig0Var7 = ig0Var2;
                                        break;
                                    }
                                    s9Var = s9Var;
                                }
                            } else {
                                ig0Var5.toString();
                                ig0VarF2.toString();
                                xq4.c(3, "DynamicRangeResolver");
                                s9Var = s9Var;
                                ig0Var7 = ig0VarF2;
                            }
                        } else {
                            it2 = hashSet2.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    s9Var = s9Var;
                                    ig0Var7 = null;
                                    break;
                                }
                                ig0Var2 = (ig0) it2.next();
                                s9Var = s9Var;
                                hh1.e("Candidate dynamic range must be fully specified.", ig0Var2.b());
                                if (!ig0Var2.equals(ig0Var7) && s9.c(ig0Var5, ig0Var2)) {
                                    ig0Var5.toString();
                                    ig0Var2.toString();
                                    xq4.c(3, "DynamicRangeResolver");
                                    ig0Var7 = ig0Var2;
                                    break;
                                }
                                s9Var = s9Var;
                            }
                        }
                    } else {
                        ig0Var5.toString();
                        ig0VarF.toString();
                        xq4.c(3, "DynamicRangeResolver");
                        arrayList8 = arrayList11;
                    }
                    ig0Var7 = ig0VarF;
                }
            } else {
                if (!hashSet2.contains(ig0Var5)) {
                    s9Var = s9Var;
                    arrayList7 = arrayList10;
                    arrayList8 = arrayList11;
                    i11 = size7;
                    i12 = i24;
                    ig0Var7 = null;
                    break;
                }
                ig0Var7 = ig0Var5;
                s9Var = s9Var;
                arrayList7 = arrayList10;
                arrayList8 = arrayList11;
                i11 = size7;
                i12 = i24;
            }
            if (ig0Var7 == null) {
                throw new IllegalArgumentException("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  " + ((String) r53Var4.f(yv2.M)) + "\nRequested dynamic range:\n  " + ig0Var5 + "\nSupported dynamic ranges:\n  " + TextUtils.join("\n  ", setB) + "\nConstrained set of concurrent dynamic ranges:\n  " + TextUtils.join("\n  ", hashSet2));
            }
            s9.k(hashSet2, ig0Var7, q82Var);
            map13.put(r53Var4, ig0Var7);
            if (!linkedHashSet.contains(ig0Var7)) {
                linkedHashSet2.add(ig0Var7);
            }
            s9Var = s9Var;
            arrayList16 = arrayList17;
            ig0Var3 = ig0Var6;
            size7 = i11;
            i23 = i12;
            arrayList10 = arrayList7;
            arrayList11 = arrayList8;
        }
        ArrayList arrayList18 = arrayList10;
        ArrayList arrayList19 = arrayList11;
        int size8 = arrayList9.size();
        int i27 = 0;
        while (true) {
            if (i27 >= size8) {
                Iterator it4 = map.keySet().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z3 = false;
                        break;
                    }
                    if (((r53) it4.next()).p() == 4101) {
                    }
                }
            } else {
                Object obj7 = arrayList9.get(i27);
                i27++;
                if (((rh) obj7).b == 4101) {
                }
            }
            z3 = true;
            break;
        }
        String str5 = this.i;
        Iterator it5 = map13.values().iterator();
        while (true) {
            if (!it5.hasNext()) {
                i2 = 8;
                break;
            }
            if (((ig0) it5.next()).b == 10) {
                i2 = 10;
                break;
            }
        }
        if (i != 0 && z3) {
            throw new IllegalArgumentException(ky0.l("Camera device id is ", str5, ". Ultra HDR is not currently supported in ", i != 1 ? i != 2 ? "DEFAULT" : "ULTRA_HIGH_RESOLUTION_CAMERA" : "CONCURRENT_CAMERA", " camera mode."));
        }
        if (i != 0 && i2 == 10) {
            throw new IllegalArgumentException(ky0.l("Camera device id is ", str5, ". 10 bit dynamic range is not currently supported in ", i != 1 ? i != 2 ? "DEFAULT" : "ULTRA_HIGH_RESOLUTION_CAMERA" : "CONCURRENT_CAMERA", " camera mode."));
        }
        gj gjVar = new gj(i, i2, z, z3);
        ArrayList arrayList20 = new ArrayList();
        int size9 = arrayList9.size();
        int i28 = 0;
        while (i28 < size9) {
            Object obj8 = arrayList9.get(i28);
            i28++;
            arrayList20.add(((rh) obj8).a);
        }
        v00 v00Var = new v00(false);
        for (r53 r53Var5 : map.keySet()) {
            List list7 = (List) map.get(r53Var5);
            hh1.a("No available output size is found for " + r53Var5 + ".", (list7 == null || list7.isEmpty()) ? false : true);
            Size size10 = (Size) Collections.min(list7, v00Var);
            int iP = r53Var5.p();
            arrayList20.add(hj.b(gjVar.a, iP, size10, i(iP)));
        }
        HashMap map14 = map;
        boolean zA = a(gjVar, arrayList20);
        String str6 = ".  May be attempting to bind too many use cases. Existing surfaces: ";
        String str7 = " New configs: ";
        String str8 = "No supported surface combination is found for camera device - Id : ";
        if (!zA) {
            og.j("No supported surface combination is found for camera device - Id : ", this.i, ".  May be attempting to bind too many use cases. Existing surfaces: ", arrayList9, " New configs: ", arrayList18);
            return null;
        }
        int size11 = arrayList9.size();
        int i29 = 0;
        Range rangeIntersect = null;
        while (i29 < size11) {
            Object obj9 = arrayList9.get(i29);
            i29++;
            Range range6 = ((rh) obj9).g;
            if (rangeIntersect == null) {
                rangeIntersect = range6;
            } else if (range6 != null) {
                try {
                    rangeIntersect = rangeIntersect.intersect(range6);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        int size12 = arrayList19.size();
        Range range7 = rangeIntersect;
        int i30 = 0;
        while (i30 < size12) {
            ArrayList arrayList21 = arrayList19;
            Object obj10 = arrayList21.get(i30);
            int i31 = i30 + 1;
            ArrayList arrayList22 = arrayList18;
            int i32 = size12;
            Range rangeIntersect2 = (Range) ((r53) arrayList22.get(((Integer) obj10).intValue())).d(r53.T, null);
            if (range7 == null) {
                range7 = rangeIntersect2;
            } else if (rangeIntersect2 != null) {
                try {
                    rangeIntersect2 = range7.intersect(rangeIntersect2);
                    range7 = rangeIntersect2;
                } catch (IllegalArgumentException unused2) {
                }
            }
            size12 = i32;
            arrayList19 = arrayList21;
            arrayList18 = arrayList22;
            i30 = i31;
        }
        ArrayList arrayList23 = arrayList18;
        ArrayList arrayList24 = arrayList19;
        HashMap map15 = new HashMap();
        Iterator it6 = map14.keySet().iterator();
        while (it6.hasNext()) {
            r53 r53Var6 = (r53) it6.next();
            ArrayList arrayList25 = new ArrayList();
            Range range8 = range7;
            HashMap map16 = new HashMap();
            for (Size size13 : (List) map14.get(r53Var6)) {
                Iterator it7 = it6;
                int iP2 = r53Var6.p();
                boolean z5 = zA;
                String str9 = str6;
                lt2 lt2Var = hj.b(gjVar.a, iP2, size13, i(iP2)).b;
                if (range8 != null) {
                    str4 = str7;
                    try {
                        outputMinFrameDuration2 = (int) (1.0E9d / ((StreamConfigurationMap) this.k.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(iP2, size13));
                    } catch (Exception unused3) {
                        outputMinFrameDuration2 = 0;
                    }
                } else {
                    str4 = str7;
                    outputMinFrameDuration2 = Integer.MAX_VALUE;
                }
                Set hashSet3 = (Set) map16.get(lt2Var);
                if (hashSet3 == null) {
                    hashSet3 = new HashSet();
                    map16.put(lt2Var, hashSet3);
                }
                if (!hashSet3.contains(Integer.valueOf(outputMinFrameDuration2))) {
                    arrayList25.add(size13);
                    hashSet3.add(Integer.valueOf(outputMinFrameDuration2));
                }
                zA = z5;
                it6 = it7;
                str6 = str9;
                str7 = str4;
            }
            map15.put(r53Var6, arrayList25);
            map14 = map;
            range7 = range8;
        }
        Range range9 = range7;
        boolean z6 = zA;
        String str10 = str6;
        String str11 = str7;
        ArrayList arrayList26 = new ArrayList();
        int size14 = arrayList24.size();
        int i33 = 0;
        while (i33 < size14) {
            Object obj11 = arrayList24.get(i33);
            i33++;
            r53 r53Var7 = (r53) arrayList23.get(((Integer) obj11).intValue());
            List<Size> list8 = (List) map15.get(r53Var7);
            int iP3 = r53Var7.p();
            y74 y74Var = this.v;
            ys ysVar = this.k;
            y74Var.getClass();
            if (((Nexus4AndroidLTargetAspectRatioQuirk) wc0.a.d(Nexus4AndroidLTargetAspectRatioQuirk.class)) == null && ((AspectRatioLegacyApi21Quirk) tg4.a(ysVar).d(AspectRatioLegacyApi21Quirk.class)) == null) {
                rational = null;
            } else {
                Size size15 = (Size) i(256).f.get(256);
                rational = new Rational(size15.getWidth(), size15.getHeight());
            }
            if (rational == null) {
                map12 = map15;
            } else {
                ArrayList arrayList27 = new ArrayList();
                ArrayList arrayList28 = new ArrayList();
                for (Size size16 : list8) {
                    HashMap map17 = map15;
                    if (ug.a(rational, size16)) {
                        arrayList27.add(size16);
                    } else {
                        arrayList28.add(size16);
                    }
                    map15 = map17;
                }
                map12 = map15;
                arrayList28.addAll(0, arrayList27);
                list8 = arrayList28;
            }
            py0 py0Var = this.w;
            int iA = hj.a(iP3);
            if (((ExtraCroppingQuirk) py0Var.b) != null && (sizeB = ExtraCroppingQuirk.b(iA)) != null) {
                ArrayList arrayList29 = new ArrayList();
                arrayList29.add(sizeB);
                for (Size size17 : list8) {
                    if (!size17.equals(sizeB)) {
                        arrayList29.add(size17);
                    }
                }
                list8 = arrayList29;
            }
            arrayList26.add(list8);
            map15 = map12;
        }
        int size18 = arrayList26.size();
        int i34 = 0;
        int size19 = 1;
        while (i34 < size18) {
            Object obj12 = arrayList26.get(i34);
            i34++;
            size19 *= ((List) obj12).size();
        }
        if (size19 == 0) {
            og.i("Failed to find supported resolutions.");
            return null;
        }
        ArrayList arrayList30 = new ArrayList();
        for (int i35 = 0; i35 < size19; i35++) {
            arrayList30.add(new ArrayList());
        }
        int size20 = size19 / ((List) arrayList26.get(0)).size();
        int i36 = size19;
        for (int i37 = 0; i37 < arrayList26.size(); i37++) {
            List list9 = (List) arrayList26.get(i37);
            int i38 = 0;
            while (i38 < size19) {
                int i39 = size20;
                ((List) arrayList30.get(i38)).add((Size) list9.get((i38 % i36) / i39));
                i38++;
                size20 = i39;
            }
            int i40 = size20;
            if (i37 < arrayList26.size() - 1) {
                size20 = i40 / ((List) arrayList26.get(i37 + 1)).size();
                i36 = i40;
            } else {
                size20 = i40;
            }
        }
        HashMap map18 = new HashMap();
        HashMap map19 = new HashMap();
        HashMap map20 = new HashMap();
        HashMap map21 = new HashMap();
        bi biVar = as2.a;
        int size21 = arrayList9.size();
        int i41 = 0;
        while (true) {
            if (i41 >= size21) {
                map2 = map21;
                int size22 = arrayList23.size();
                int i42 = 0;
                while (true) {
                    if (i42 >= size22) {
                        z4 = false;
                        break;
                    }
                    Object obj13 = arrayList23.get(i42);
                    i42++;
                    r53 r53Var8 = (r53) obj13;
                    if (as2.c(r53Var8, r53Var8.j())) {
                    }
                }
            } else {
                Object obj14 = arrayList9.get(i41);
                i41++;
                rh rhVar2 = (rh) obj14;
                map2 = map21;
                if (!as2.c(rhVar2.f, (t53) rhVar2.e.get(0))) {
                    map21 = map2;
                }
            }
            z4 = true;
            break;
        }
        int size23 = arrayList9.size();
        boolean z7 = z4;
        int i43 = 0;
        int iMin = Integer.MAX_VALUE;
        while (i43 < size23) {
            Object obj15 = arrayList9.get(i43);
            i43++;
            rh rhVar3 = (rh) obj15;
            int i44 = size23;
            boolean z8 = z7;
            try {
                outputMinFrameDuration = (int) (1.0E9d / ((StreamConfigurationMap) this.k.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(rhVar3.b, rhVar3.c));
            } catch (Exception unused4) {
                outputMinFrameDuration = 0;
            }
            iMin = Math.min(iMin, outputMinFrameDuration);
            arrayList9 = arrayList;
            size23 = i44;
            z7 = z8;
        }
        boolean z9 = z7;
        String str12 = "SurfaceConfig does not map to any use case";
        if (!this.q || z9) {
            arrayList2 = arrayList24;
            i3 = iMin;
            map3 = map20;
            arrayList3 = arrayList23;
            str = "SurfaceConfig does not map to any use case";
            range = range9;
            map4 = map2;
            list = null;
        } else {
            int size24 = arrayList30.size();
            list = null;
            int i45 = 0;
            loop25: while (true) {
                if (i45 >= size24) {
                    arrayList2 = arrayList24;
                    i3 = iMin;
                    map3 = map20;
                    str = str12;
                    range = range9;
                    map4 = map2;
                    arrayList6 = arrayList23;
                    break;
                }
                int i46 = i45 + 1;
                List list10 = (List) arrayList30.get(i45);
                ArrayList arrayList31 = arrayList23;
                str = str12;
                range = range9;
                HashMap map22 = map2;
                int i47 = size24;
                Pair pairH = h(i, arrayList, list10, arrayList31, arrayList24, iMin, map20, map22);
                HashMap map23 = map20;
                int i48 = iMin;
                map4 = map22;
                List listD = d(gjVar, (List) pairH.first);
                if (listD != null) {
                    t53 t53Var = t53.f;
                    arrayList6 = arrayList31;
                    int i49 = 0;
                    while (true) {
                        if (i49 < listD.size()) {
                            arrayList2 = arrayList24;
                            long j2 = ((hj) listD.get(i49)).c;
                            List list11 = listD;
                            if (map23.containsKey(Integer.valueOf(i49))) {
                                List list12 = ((rh) map23.get(Integer.valueOf(i49))).e;
                                map3 = map23;
                                i3 = i48;
                                if (as2.b(list12.size() == 1 ? (t53) list12.get(0) : t53Var, j2, list12)) {
                                    i49++;
                                    listD = list11;
                                    map23 = map3;
                                    arrayList24 = arrayList2;
                                    i48 = i3;
                                } else {
                                    list6 = null;
                                }
                            } else {
                                map3 = map23;
                                i3 = i48;
                                if (!map4.containsKey(Integer.valueOf(i49))) {
                                    og.m(str);
                                    return null;
                                }
                                r53 r53Var9 = (r53) map4.get(Integer.valueOf(i49));
                                if (as2.b(r53Var9.j(), j2, r53Var9.j() == t53Var ? (List) ((zr2) r53Var9).f(zr2.b) : Collections.EMPTY_LIST)) {
                                    i49++;
                                    listD = list11;
                                    map23 = map3;
                                    arrayList24 = arrayList2;
                                    i48 = i3;
                                } else {
                                    list6 = null;
                                }
                            }
                        }
                        if (list6 != null) {
                            ys ysVar2 = this.k;
                            if (Build.VERSION.SDK_INT >= 33 && (jArr = (long[]) ysVar2.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) != null && jArr.length != 0) {
                                hashSet = new HashSet();
                                for (long j3 : jArr) {
                                    hashSet.add(Long.valueOf(j3));
                                }
                                it = list6.iterator();
                                do {
                                    if (it.hasNext()) {
                                        list = list6;
                                        break loop25;
                                    }
                                } while (hashSet.contains(Long.valueOf(((hj) it.next()).c)));
                            }
                            list = null;
                        } else {
                            list = list6;
                        }
                        map3.clear();
                        map4.clear();
                        arrayList23 = arrayList6;
                        map2 = map4;
                        i45 = i46;
                        size24 = i47;
                        map20 = map3;
                        arrayList24 = arrayList2;
                        iMin = i3;
                        range9 = range;
                        str12 = str;
                    }
                } else {
                    arrayList6 = arrayList31;
                }
                map3 = map23;
                list6 = listD;
                arrayList2 = arrayList24;
                i3 = i48;
                if (list6 != null) {
                    ys ysVar3 = this.k;
                    if (Build.VERSION.SDK_INT >= 33) {
                        hashSet = new HashSet();
                        while (i10 < r3) {
                            hashSet.add(Long.valueOf(j3));
                        }
                        it = list6.iterator();
                        do {
                            if (it.hasNext()) {
                                list = list6;
                                break loop25;
                            }
                        } while (hashSet.contains(Long.valueOf(((hj) it.next()).c)));
                    }
                    list = null;
                } else {
                    list = list6;
                }
                map3.clear();
                map4.clear();
                arrayList23 = arrayList6;
                map2 = map4;
                i45 = i46;
                size24 = i47;
                map20 = map3;
                arrayList24 = arrayList2;
                iMin = i3;
                range9 = range;
                str12 = str;
            }
            if (list == null && !z6) {
                og.j("No supported surface combination is found for camera device - Id : ", this.i, str10, arrayList, str11, arrayList6);
                return null;
            }
            arrayList3 = arrayList6;
        }
        int size25 = arrayList30.size();
        int i50 = 0;
        int iIntValue2 = Integer.MAX_VALUE;
        int i51 = Integer.MAX_VALUE;
        boolean z10 = false;
        boolean z11 = false;
        List list13 = null;
        List list14 = null;
        while (true) {
            if (i50 >= size25) {
                str2 = str8;
                map5 = map4;
                map6 = map18;
                str3 = str11;
                map7 = map3;
                arrayList4 = arrayList2;
                i4 = 1;
                i5 = 0;
                list2 = list;
                arrayList5 = arrayList;
                list3 = list13;
                list4 = list14;
                break;
            }
            int i52 = i50 + 1;
            List list15 = (List) arrayList30.get(i50);
            str2 = str8;
            map5 = map4;
            ArrayList arrayList32 = arrayList30;
            map6 = map18;
            str3 = str11;
            map7 = map3;
            int i53 = i3;
            int i54 = i51;
            list2 = list;
            int i55 = size25;
            int i56 = iIntValue2;
            arrayList4 = arrayList2;
            i4 = 1;
            i5 = 0;
            arrayList5 = arrayList;
            Pair pairH2 = h(i, arrayList5, list15, arrayList3, arrayList4, i53, null, null);
            List list16 = (List) pairH2.first;
            iIntValue2 = ((Integer) pairH2.second).intValue();
            boolean z12 = range == null || i53 <= iIntValue2 || iIntValue2 >= ((Integer) range.getLower()).intValue();
            if (z10 || !a(gjVar, list16)) {
                list5 = list15;
            } else {
                list5 = list15;
                if (i56 == Integer.MAX_VALUE || i56 < iIntValue2) {
                    i56 = iIntValue2;
                    list13 = list5;
                }
                if (z12) {
                    if (z11) {
                        i51 = i54;
                        list4 = list14;
                        list3 = list5;
                        break;
                    }
                    i56 = iIntValue2;
                    z10 = true;
                    list13 = list5;
                }
            }
            if (list2 != null && !z11 && d(gjVar, list16) != null) {
                if (i54 == Integer.MAX_VALUE || i54 < iIntValue2) {
                    i54 = iIntValue2;
                    list14 = list5;
                }
                if (z12) {
                    i51 = iIntValue2;
                    if (z10) {
                        iIntValue2 = i56;
                        list3 = list13;
                        list4 = list5;
                        break;
                    }
                    z11 = true;
                    list14 = list5;
                }
                arrayList2 = arrayList4;
                i3 = i53;
                iIntValue2 = i56;
                list = list2;
                str11 = str3;
                map18 = map6;
                size25 = i55;
                i50 = i52;
                map3 = map7;
                map4 = map5;
                str8 = str2;
                arrayList30 = arrayList32;
            }
            i51 = i54;
            arrayList2 = arrayList4;
            i3 = i53;
            iIntValue2 = i56;
            list = list2;
            str11 = str3;
            map18 = map6;
            size25 = i55;
            i50 = i52;
            map3 = map7;
            map4 = map5;
            str8 = str2;
            arrayList30 = arrayList32;
        }
        if (list3 == null) {
            throw new IllegalArgumentException(str2 + this.i + " and Hardware level: " + this.m + ". May be the specified resolution is too large and not supported. Existing surfaces: " + arrayList5 + str3 + arrayList3);
        }
        if (range != null) {
            range2 = fj.f;
            if (!range.equals(range2) && (rangeArr = (Range[]) this.k.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES)) != null) {
                Range range10 = new Range(Integer.valueOf(Math.min(((Integer) range.getLower()).intValue(), iIntValue2)), Integer.valueOf(Math.min(((Integer) range.getUpper()).intValue(), iIntValue2)));
                int length = rangeArr.length;
                int iF = i5;
                Range range11 = range2;
                int i57 = iF;
                while (i57 < length) {
                    int i58 = i57;
                    Range range12 = rangeArr[i58];
                    int i59 = length;
                    if (iIntValue2 >= ((Integer) range12.getLower()).intValue()) {
                        if (range11.equals(fj.f)) {
                            range11 = range12;
                        }
                        if (range12.equals(range10)) {
                            range11 = range12;
                            break;
                        }
                        try {
                            int iF2 = f(range12.intersect(range10));
                            if (iF == 0) {
                                iF = iF2;
                            } else if (iF2 >= iF) {
                                try {
                                    i9 = iF;
                                    double dF = f(range11.intersect(range10));
                                    try {
                                        range5 = range11;
                                        try {
                                            double dF2 = f(range12.intersect(range10));
                                            double dF3 = dF2 / ((double) f(range12));
                                            double dF4 = dF / ((double) f(range5));
                                            if (dF2 > dF) {
                                                if (dF3 >= 0.5d || dF3 >= dF4) {
                                                    range11 = range12;
                                                } else {
                                                    range11 = range5;
                                                }
                                            } else if (dF2 == dF) {
                                                if (dF3 <= dF4 && (dF3 != dF4 || ((Integer) range12.getLower()).intValue() <= ((Integer) range5.getLower()).intValue())) {
                                                    range11 = range5;
                                                } else {
                                                    range11 = range12;
                                                }
                                            } else if (dF4 >= 0.5d || dF3 <= dF4) {
                                                range11 = range5;
                                            } else {
                                                range11 = range12;
                                            }
                                            try {
                                                iF = f(range10.intersect(range11));
                                                range12 = range11;
                                            } catch (IllegalArgumentException unused5) {
                                                if (i9 == 0 || (e(range12, range10) >= e(range11, range10) && (e(range12, range10) != e(range11, range10) || (((Integer) range12.getLower()).intValue() <= ((Integer) range11.getUpper()).intValue() && f(range12) >= f(range11))))) {
                                                    iF = i9;
                                                } else {
                                                    iF = i9;
                                                }
                                                i57 = i58 + 1;
                                                length = i59;
                                            }
                                        } catch (IllegalArgumentException unused6) {
                                            range11 = range5;
                                            if (i9 == 0) {
                                            }
                                            iF = i9;
                                            i57 = i58 + 1;
                                            length = i59;
                                        }
                                    } catch (IllegalArgumentException unused7) {
                                        range5 = range11;
                                    }
                                } catch (IllegalArgumentException unused8) {
                                    range5 = range11;
                                    i9 = iF;
                                }
                            } else {
                                range12 = range11;
                            }
                        } catch (IllegalArgumentException unused9) {
                            i9 = iF;
                        }
                        range11 = range12;
                    }
                    i57 = i58 + 1;
                    length = i59;
                }
                range2 = range11;
            }
        } else {
            range2 = null;
        }
        int size26 = arrayList3.size();
        int i60 = i5;
        while (i60 < size26) {
            Object obj16 = arrayList3.get(i60);
            i60++;
            Range range13 = range2;
            r53 r53Var10 = (r53) obj16;
            int i61 = size26;
            Size size27 = (Size) list3.get(arrayList4.indexOf(Integer.valueOf(arrayList3.indexOf(r53Var10))));
            Range range14 = fj.f;
            if (size27 == null) {
                dk0.n("Null resolution");
                return null;
            }
            Range range15 = fj.f;
            if (range15 == null) {
                dk0.n("Null expectedFrameRateRange");
                return null;
            }
            ig0 ig0Var8 = (ig0) map13.get(r53Var10);
            ig0Var8.getClass();
            zl1 zl1VarM = zl1.m();
            bi biVar2 = zr.j;
            if (r53Var10.a(biVar2)) {
                zl1VarM.v(biVar2, (Long) r53Var10.f(biVar2));
            }
            bi biVar3 = r53.U;
            if (r53Var10.a(biVar3)) {
                zl1VarM.v(biVar3, (Boolean) r53Var10.f(biVar3));
            }
            bi biVar4 = sy0.b;
            if (r53Var10.a(biVar4)) {
                zl1VarM.v(biVar4, (Integer) r53Var10.f(biVar4));
            }
            bi biVar5 = wy0.r;
            if (r53Var10.a(biVar5)) {
                zl1VarM.v(biVar5, (Integer) r53Var10.f(biVar5));
            }
            map19.put(r53Var10, new fj(size27, ig0Var8, range13 != null ? range13 : range15, new zr(zl1VarM), z2));
            range2 = range13;
            size26 = i61;
            arrayList4 = arrayList4;
        }
        if (list2 == null || iIntValue2 != i51 || list3.size() != list4.size()) {
            map8 = map6;
            break;
        }
        int i62 = i5;
        while (true) {
            if (i62 >= list3.size()) {
                ys ysVar4 = this.k;
                if (Build.VERSION.SDK_INT >= 33) {
                    ArrayList arrayList33 = new ArrayList(map19.keySet());
                    int size28 = arrayList5.size();
                    int i63 = i5;
                    while (i63 < size28) {
                        Object obj17 = arrayList5.get(i63);
                        i63++;
                        ((rh) obj17).f.getClass();
                    }
                    int size29 = arrayList33.size();
                    int i64 = i5;
                    while (i64 < size29) {
                        Object obj18 = arrayList33.get(i64);
                        i64++;
                        fj fjVar2 = (fj) map19.get((r53) obj18);
                        fjVar2.getClass();
                        fjVar2.d.getClass();
                    }
                    long[] jArr2 = (long[]) ysVar4.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
                    if (jArr2 != null && jArr2.length != 0) {
                        HashSet hashSet4 = new HashSet();
                        int length2 = jArr2.length;
                        for (int i65 = i5; i65 < length2; i65++) {
                            hashSet4.add(Long.valueOf(jArr2[i65]));
                        }
                        HashSet hashSet5 = new HashSet();
                        Iterator it8 = arrayList5.iterator();
                        long j4 = 0;
                        if (it8.hasNext()) {
                            rh rhVar4 = (rh) it8.next();
                            s30 s30Var = rhVar4.f;
                            bi biVar6 = zr.j;
                            if (s30Var.a(biVar6) && ((Long) rhVar4.f.f(biVar6)).longValue() != 0) {
                                i7 = i4;
                                i6 = i5;
                            } else {
                                i6 = i4;
                                i7 = i5;
                            }
                        } else {
                            i6 = i5;
                            i7 = i6;
                        }
                        int size30 = arrayList33.size();
                        int i66 = i7;
                        int i67 = i6;
                        int i68 = i5;
                        while (i68 < size30) {
                            Object obj19 = arrayList33.get(i68);
                            i68++;
                            r53 r53Var11 = (r53) obj19;
                            long j5 = j4;
                            bi biVar7 = zr.j;
                            if (r53Var11.a(biVar7)) {
                                Long l = (Long) r53Var11.f(biVar7);
                                if (l.longValue() == j5) {
                                    if (i66 != 0) {
                                        og.i("Either all use cases must have non-default stream use case assigned or none should have it");
                                        return null;
                                    }
                                    i67 = i4;
                                } else {
                                    if (i67 != 0) {
                                        og.i("Either all use cases must have non-default stream use case assigned or none should have it");
                                        return null;
                                    }
                                    hashSet5.add(l);
                                    i66 = i4;
                                }
                            } else {
                                if (i66 != 0) {
                                    og.i("Either all use cases must have non-default stream use case assigned or none should have it");
                                    return null;
                                }
                                i67 = i4;
                            }
                            j4 = j5;
                        }
                        if (i67 != 0) {
                            map8 = map6;
                            i8 = i5;
                            while (i8 < list2.size()) {
                                j = ((hj) list2.get(i8)).c;
                                map10 = map7;
                                if (map10.containsKey(Integer.valueOf(i8))) {
                                    rhVar = (rh) map10.get(Integer.valueOf(i8));
                                    zrVarA2 = as2.a(rhVar.f, j);
                                    if (zrVarA2 != null) {
                                        size = rhVar.c;
                                        Range range16 = fj.f;
                                        if (size != null) {
                                            dk0.n("Null resolution");
                                            return null;
                                        }
                                        range3 = fj.f;
                                        if (range3 != null) {
                                            dk0.n("Null expectedFrameRateRange");
                                            return null;
                                        }
                                        ig0Var = rhVar.d;
                                        if (ig0Var != null) {
                                            dk0.n("Null dynamicRange");
                                            return null;
                                        }
                                        range4 = rhVar.g;
                                        if (range4 != null) {
                                            range3 = range4;
                                        }
                                        map8.put(rhVar, new fj(size, ig0Var, range3, zrVarA2, false));
                                    }
                                    map11 = map5;
                                } else {
                                    map11 = map5;
                                    if (map11.containsKey(Integer.valueOf(i8))) {
                                        og.m(str);
                                        return null;
                                    }
                                    r53Var = (r53) map11.get(Integer.valueOf(i8));
                                    fjVar = (fj) map19.get(r53Var);
                                    zrVarA = as2.a(fjVar.d, j);
                                    if (zrVarA != null) {
                                        cj cjVarA = fjVar.a();
                                        cjVarA.e = zrVarA;
                                        map19.put(r53Var, cjVarA.i());
                                    }
                                }
                                i8++;
                                map7 = map10;
                                map5 = map11;
                            }
                            break;
                            break;
                        }
                        Iterator it9 = hashSet5.iterator();
                        do {
                            if (!it9.hasNext()) {
                                int size31 = arrayList5.size();
                                int i69 = i5;
                                while (i69 < size31) {
                                    Object obj20 = arrayList5.get(i69);
                                    i69++;
                                    rh rhVar5 = (rh) obj20;
                                    s30 s30Var2 = rhVar5.f;
                                    zr zrVarA3 = as2.a(s30Var2, ((Long) s30Var2.f(zr.j)).longValue());
                                    if (zrVarA3 != null) {
                                        Size size32 = rhVar5.c;
                                        Range range17 = fj.f;
                                        if (size32 == null) {
                                            dk0.n("Null resolution");
                                            return null;
                                        }
                                        Range range18 = fj.f;
                                        if (range18 == null) {
                                            dk0.n("Null expectedFrameRateRange");
                                            return null;
                                        }
                                        ig0 ig0Var9 = rhVar5.d;
                                        if (ig0Var9 == null) {
                                            dk0.n("Null dynamicRange");
                                            return null;
                                        }
                                        Range range19 = rhVar5.g;
                                        fj fjVar3 = new fj(size32, ig0Var9, range19 != null ? range19 : range18, zrVarA3, false);
                                        map9 = map6;
                                        map9.put(rhVar5, fjVar3);
                                    } else {
                                        map9 = map6;
                                    }
                                    map6 = map9;
                                }
                                map8 = map6;
                                int size33 = arrayList33.size();
                                int i70 = i5;
                                while (i70 < size33) {
                                    Object obj21 = arrayList33.get(i70);
                                    i70++;
                                    r53 r53Var12 = (r53) obj21;
                                    fj fjVar4 = (fj) map19.get(r53Var12);
                                    s30 s30Var3 = fjVar4.d;
                                    zr zrVarA4 = as2.a(s30Var3, ((Long) s30Var3.f(zr.j)).longValue());
                                    if (zrVarA4 != null) {
                                        cj cjVarA2 = fjVar4.a();
                                        cjVarA2.e = zrVarA4;
                                        map19.put(r53Var12, cjVarA2.i());
                                    }
                                }
                                break;
                            }
                        } while (hashSet4.contains((Long) it9.next()));
                        map8 = map6;
                        i8 = i5;
                        while (i8 < list2.size()) {
                            j = ((hj) list2.get(i8)).c;
                            map10 = map7;
                            if (map10.containsKey(Integer.valueOf(i8))) {
                                rhVar = (rh) map10.get(Integer.valueOf(i8));
                                zrVarA2 = as2.a(rhVar.f, j);
                                if (zrVarA2 != null) {
                                    size = rhVar.c;
                                    Range range110 = fj.f;
                                    if (size != null) {
                                        dk0.n("Null resolution");
                                        return null;
                                    }
                                    range3 = fj.f;
                                    if (range3 != null) {
                                        dk0.n("Null expectedFrameRateRange");
                                        return null;
                                    }
                                    ig0Var = rhVar.d;
                                    if (ig0Var != null) {
                                        dk0.n("Null dynamicRange");
                                        return null;
                                    }
                                    range4 = rhVar.g;
                                    if (range4 != null) {
                                        range3 = range4;
                                    }
                                    map8.put(rhVar, new fj(size, ig0Var, range3, zrVarA2, false));
                                }
                                map11 = map5;
                            } else {
                                map11 = map5;
                                if (map11.containsKey(Integer.valueOf(i8))) {
                                    og.m(str);
                                    return null;
                                }
                                r53Var = (r53) map11.get(Integer.valueOf(i8));
                                fjVar = (fj) map19.get(r53Var);
                                zrVarA = as2.a(fjVar.d, j);
                                if (zrVarA != null) {
                                    cj cjVarA3 = fjVar.a();
                                    cjVarA3.e = zrVarA;
                                    map19.put(r53Var, cjVarA3.i());
                                }
                            }
                            i8++;
                            map7 = map10;
                            map5 = map11;
                        }
                        break;
                        break;
                    }
                    map8 = map6;
                    i8 = i5;
                    while (i8 < list2.size()) {
                        j = ((hj) list2.get(i8)).c;
                        map10 = map7;
                        if (map10.containsKey(Integer.valueOf(i8))) {
                            rhVar = (rh) map10.get(Integer.valueOf(i8));
                            zrVarA2 = as2.a(rhVar.f, j);
                            if (zrVarA2 != null) {
                                size = rhVar.c;
                                Range range111 = fj.f;
                                if (size != null) {
                                    dk0.n("Null resolution");
                                    return null;
                                }
                                range3 = fj.f;
                                if (range3 != null) {
                                    dk0.n("Null expectedFrameRateRange");
                                    return null;
                                }
                                ig0Var = rhVar.d;
                                if (ig0Var != null) {
                                    dk0.n("Null dynamicRange");
                                    return null;
                                }
                                range4 = rhVar.g;
                                if (range4 != null) {
                                    range3 = range4;
                                }
                                map8.put(rhVar, new fj(size, ig0Var, range3, zrVarA2, false));
                            }
                            map11 = map5;
                        } else {
                            map11 = map5;
                            if (map11.containsKey(Integer.valueOf(i8))) {
                                og.m(str);
                                return null;
                            }
                            r53Var = (r53) map11.get(Integer.valueOf(i8));
                            fjVar = (fj) map19.get(r53Var);
                            zrVarA = as2.a(fjVar.d, j);
                            if (zrVarA != null) {
                                cj cjVarA4 = fjVar.a();
                                cjVarA4.e = zrVarA;
                                map19.put(r53Var, cjVarA4.i());
                            }
                        }
                        i8++;
                        map7 = map10;
                        map5 = map11;
                    }
                    break;
                    break;
                }
                map8 = map6;
                i8 = i5;
                while (i8 < list2.size()) {
                    j = ((hj) list2.get(i8)).c;
                    map10 = map7;
                    if (map10.containsKey(Integer.valueOf(i8))) {
                        rhVar = (rh) map10.get(Integer.valueOf(i8));
                        zrVarA2 = as2.a(rhVar.f, j);
                        if (zrVarA2 != null) {
                            size = rhVar.c;
                            Range range112 = fj.f;
                            if (size != null) {
                                dk0.n("Null resolution");
                                return null;
                            }
                            range3 = fj.f;
                            if (range3 != null) {
                                dk0.n("Null expectedFrameRateRange");
                                return null;
                            }
                            ig0Var = rhVar.d;
                            if (ig0Var != null) {
                                dk0.n("Null dynamicRange");
                                return null;
                            }
                            range4 = rhVar.g;
                            if (range4 != null) {
                                range3 = range4;
                            }
                            map8.put(rhVar, new fj(size, ig0Var, range3, zrVarA2, false));
                        }
                        map11 = map5;
                    } else {
                        map11 = map5;
                        if (map11.containsKey(Integer.valueOf(i8))) {
                            og.m(str);
                            return null;
                        }
                        r53Var = (r53) map11.get(Integer.valueOf(i8));
                        fjVar = (fj) map19.get(r53Var);
                        zrVarA = as2.a(fjVar.d, j);
                        if (zrVarA != null) {
                            cj cjVarA5 = fjVar.a();
                            cjVarA5.e = zrVarA;
                            map19.put(r53Var, cjVarA5.i());
                        }
                    }
                    i8++;
                    map7 = map10;
                    map5 = map11;
                }
                break;
            }
            if (!((Size) list3.get(i62)).equals(list4.get(i62))) {
                map8 = map6;
                break;
            }
            i62++;
        }
        return new Pair(map19, map8);
    }

    public final Pair h(int i, ArrayList arrayList, List list, ArrayList arrayList2, ArrayList arrayList3, int i2, HashMap map, HashMap map2) {
        int outputMinFrameDuration;
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            rh rhVar = (rh) obj;
            arrayList4.add(rhVar.a);
            if (map != null) {
                map.put(Integer.valueOf(arrayList4.size() - 1), rhVar);
            }
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            Size size2 = (Size) list.get(i4);
            r53 r53Var = (r53) arrayList2.get(((Integer) arrayList3.get(i4)).intValue());
            int iP = r53Var.p();
            arrayList4.add(hj.b(i, iP, size2, i(iP)));
            if (map2 != null) {
                map2.put(Integer.valueOf(arrayList4.size() - 1), r53Var);
            }
            try {
                outputMinFrameDuration = (int) (1.0E9d / ((StreamConfigurationMap) this.k.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(r53Var.p(), size2));
            } catch (Exception unused) {
                outputMinFrameDuration = 0;
            }
            i2 = Math.min(i2, outputMinFrameDuration);
        }
        return new Pair(arrayList4, Integer.valueOf(i2));
    }

    public final mj i(int i) {
        StreamConfigurationMap streamConfigurationMap;
        Integer numValueOf = Integer.valueOf(i);
        ArrayList arrayList = this.t;
        if (!arrayList.contains(numValueOf)) {
            j(this.s.b, al2.d, i);
            j(this.s.d, al2.f, i);
            HashMap map = this.s.f;
            ys ysVar = this.k;
            Size sizeC = c((StreamConfigurationMap) ((wj1) ysVar.b().a).b, i, true);
            if (sizeC != null) {
                map.put(Integer.valueOf(i), sizeC);
            }
            HashMap map2 = this.s.g;
            if (Build.VERSION.SDK_INT >= 31 && this.r && (streamConfigurationMap = (StreamConfigurationMap) ysVar.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION)) != null) {
                map2.put(Integer.valueOf(i), c(streamConfigurationMap, i, true));
            }
            arrayList.add(Integer.valueOf(i));
        }
        return this.s;
    }

    public final void j(HashMap map, Size size, int i) {
        if (this.p) {
            Size sizeC = c((StreamConfigurationMap) ((wj1) this.k.b().a).b, i, false);
            Integer numValueOf = Integer.valueOf(i);
            if (sizeC != null) {
                size = (Size) Collections.min(Arrays.asList(size, sizeC), new v00(false));
            }
            map.put(numValueOf, size);
        }
    }
}
