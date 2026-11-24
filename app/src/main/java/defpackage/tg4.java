package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.quirk.AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.camera2.internal.compat.quirk.AfRegionFlipHorizontallyQuirk;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.internal.compat.quirk.CameraNoResponseWhenEnablingFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.FlashTooSlowQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedWhenVideoCaptureIsBoundQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFlashNotFireQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureWashedOutImageQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureWithFlashUnderexposureQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import androidx.camera.camera2.internal.compat.quirk.JpegCaptureDownsizingQuirk;
import androidx.camera.camera2.internal.compat.quirk.JpegHalCorruptImageQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewDelayWhenVideoCaptureIsBoundQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewStretchWhenVideoCaptureIsBoundQuirk;
import androidx.camera.camera2.internal.compat.quirk.TemporalNoiseQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchFlashRequiredFor3aUpdateQuirk;
import androidx.camera.camera2.internal.compat.quirk.YuvImageOnePixelShiftQuirk;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.Bidi;
import com.ibm.icu.text.UTF16;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tg4 {
    /* JADX WARN: Code duplicated, block: B:302:0x0510  */
    /* JADX WARN: Code duplicated, block: B:335:0x05a0  */
    public static cq0 a(ys ysVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Integer num;
        j22 j22Var = j22.c;
        j22Var.getClass();
        try {
            try {
                Object obj = ((AtomicReference) j22Var.a.e).get();
                i22 i22Var = (i22) (obj instanceof ej ? new mz0(1, null) : oz3.d(obj)).get();
                ArrayList arrayList = new ArrayList();
                CameraCharacteristics.Key key = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
                Integer num2 = (Integer) ysVar.a(key);
                if (i22Var.a(AeFpsRangeLegacyQuirk.class, num2 != null && num2.intValue() == 2)) {
                    arrayList.add(new AeFpsRangeLegacyQuirk(ysVar));
                }
                if (i22Var.a(AspectRatioLegacyApi21Quirk.class, false)) {
                    arrayList.add(new AspectRatioLegacyApi21Quirk());
                }
                HashSet hashSet = JpegHalCorruptImageQuirk.a;
                String str = Build.DEVICE;
                Locale locale = Locale.US;
                if (i22Var.a(JpegHalCorruptImageQuirk.class, hashSet.contains(str.toLowerCase(locale)))) {
                    arrayList.add(new JpegHalCorruptImageQuirk());
                }
                HashSet hashSet2 = JpegCaptureDownsizingQuirk.a;
                String str2 = Build.MODEL;
                if (i22Var.a(JpegCaptureDownsizingQuirk.class, hashSet2.contains(str2.toLowerCase(locale)) && ((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new JpegCaptureDownsizingQuirk());
                }
                Integer num3 = (Integer) ysVar.a(key);
                if (i22Var.a(CamcorderProfileResolutionQuirk.class, num3 != null && num3.intValue() == 2)) {
                    CamcorderProfileResolutionQuirk camcorderProfileResolutionQuirk = new CamcorderProfileResolutionQuirk();
                    ysVar.b();
                    arrayList.add(camcorderProfileResolutionQuirk);
                }
                String str3 = Build.HARDWARE;
                if (i22Var.a(CaptureNoResponseQuirk.class, ("samsungexynos7420".equalsIgnoreCase(str3) || "universal7420".equalsIgnoreCase(str3)) && ((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new CaptureNoResponseQuirk());
                }
                Integer num4 = (Integer) ysVar.a(key);
                if (i22Var.a(LegacyCameraOutputConfigNullPointerQuirk.class, num4 != null && num4.intValue() == 2)) {
                    arrayList.add(new LegacyCameraOutputConfigNullPointerQuirk());
                }
                if (i22Var.a(LegacyCameraSurfaceCleanupQuirk.class, Build.VERSION.SDK_INT < 29 && (num = (Integer) ysVar.a(key)) != null && num.intValue() == 2)) {
                    arrayList.add(new LegacyCameraSurfaceCleanupQuirk());
                }
                if (i22Var.a(ImageCaptureWashedOutImageQuirk.class, ImageCaptureWashedOutImageQuirk.a.contains(str2.toUpperCase(locale)) && ((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new ImageCaptureWashedOutImageQuirk());
                }
                if (i22Var.a(CameraNoResponseWhenEnablingFlashQuirk.class, CameraNoResponseWhenEnablingFlashQuirk.a.contains(str2.toUpperCase(locale)) && ((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new CameraNoResponseWhenEnablingFlashQuirk());
                }
                String str4 = Build.BRAND;
                if (i22Var.a(YuvImageOnePixelShiftQuirk.class, ("motorola".equalsIgnoreCase(str4) && "MotoG3".equalsIgnoreCase(str2)) || ("samsung".equalsIgnoreCase(str4) && "SM-G532F".equalsIgnoreCase(str2)) || (("samsung".equalsIgnoreCase(str4) && "SM-J700F".equalsIgnoreCase(str2)) || (("samsung".equalsIgnoreCase(str4) && "SM-A920F".equalsIgnoreCase(str2)) || (("samsung".equalsIgnoreCase(str4) && "SM-J415F".equalsIgnoreCase(str2)) || ("xiaomi".equalsIgnoreCase(str4) && "Mi A1".equalsIgnoreCase(str2))))))) {
                    arrayList.add(new YuvImageOnePixelShiftQuirk());
                }
                Iterator it = FlashTooSlowQuirk.a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Build.MODEL.toUpperCase(Locale.US).startsWith((String) it.next())) {
                            if (((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    break;
                }
                if (i22Var.a(FlashTooSlowQuirk.class, z)) {
                    arrayList.add(new FlashTooSlowQuirk());
                }
                if (i22Var.a(AfRegionFlipHorizontallyQuirk.class, Build.BRAND.equalsIgnoreCase("SAMSUNG") && Build.VERSION.SDK_INT < 33 && ((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new AfRegionFlipHorizontallyQuirk());
                }
                CameraCharacteristics.Key key2 = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
                Integer num5 = (Integer) ysVar.a(key2);
                if (i22Var.a(ConfigureSurfaceToSecondarySessionFailQuirk.class, num5 != null && num5.intValue() == 2)) {
                    arrayList.add(new ConfigureSurfaceToSecondarySessionFailQuirk());
                }
                Integer num6 = (Integer) ysVar.a(key2);
                if (i22Var.a(PreviewOrientationIncorrectQuirk.class, num6 != null && num6.intValue() == 2)) {
                    arrayList.add(new PreviewOrientationIncorrectQuirk());
                }
                Integer num7 = (Integer) ysVar.a(key2);
                if (i22Var.a(CaptureSessionStuckQuirk.class, num7 != null && num7.intValue() == 2)) {
                    arrayList.add(new CaptureSessionStuckQuirk());
                }
                List list = ImageCaptureFlashNotFireQuirk.b;
                String str5 = Build.MODEL;
                Locale locale2 = Locale.US;
                if (i22Var.a(ImageCaptureFlashNotFireQuirk.class, (list.contains(str5.toLowerCase(locale2)) && ((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0) || ImageCaptureFlashNotFireQuirk.a.contains(str5.toLowerCase(locale2)))) {
                    arrayList.add(new ImageCaptureFlashNotFireQuirk());
                }
                if (i22Var.a(ImageCaptureWithFlashUnderexposureQuirk.class, ImageCaptureWithFlashUnderexposureQuirk.a.contains(str5.toLowerCase(locale2)) && ((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new ImageCaptureWithFlashUnderexposureQuirk());
                }
                if (i22Var.a(ImageCaptureFailWithAutoFlashQuirk.class, ImageCaptureFailWithAutoFlashQuirk.a.contains(str5.toLowerCase(locale2)) && ((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new ImageCaptureFailWithAutoFlashQuirk());
                }
                Integer num8 = (Integer) ysVar.a(key2);
                if (i22Var.a(IncorrectCaptureStateQuirk.class, num8 != null && num8.intValue() == 2)) {
                    arrayList.add(new IncorrectCaptureStateQuirk());
                }
                Iterator it2 = TorchFlashRequiredFor3aUpdateQuirk.b.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (Build.MODEL.toUpperCase(Locale.US).equals((String) it2.next())) {
                            if (((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    break;
                }
                if (i22Var.a(TorchFlashRequiredFor3aUpdateQuirk.class, z2)) {
                    arrayList.add(new TorchFlashRequiredFor3aUpdateQuirk(ysVar));
                }
                String str6 = Build.MANUFACTURER;
                if (i22Var.a(PreviewStretchWhenVideoCaptureIsBoundQuirk.class, ("HUAWEI".equalsIgnoreCase(str6) && "HUAWEI ALE-L04".equalsIgnoreCase(Build.MODEL)) || ("Samsung".equalsIgnoreCase(str6) && "sm-j320f".equalsIgnoreCase(Build.MODEL)) || (("Samsung".equalsIgnoreCase(str6) && "sm-j700f".equalsIgnoreCase(Build.MODEL)) || (("Samsung".equalsIgnoreCase(str6) && "sm-j111f".equalsIgnoreCase(Build.MODEL)) || (("OPPO".equalsIgnoreCase(str6) && "A37F".equalsIgnoreCase(Build.MODEL)) || ("Samsung".equalsIgnoreCase(str6) && "sm-j510fn".equalsIgnoreCase(Build.MODEL))))))) {
                    arrayList.add(new PreviewStretchWhenVideoCaptureIsBoundQuirk());
                }
                if (i22Var.a(PreviewDelayWhenVideoCaptureIsBoundQuirk.class, "Huawei".equalsIgnoreCase(str6))) {
                    arrayList.add(new PreviewDelayWhenVideoCaptureIsBoundQuirk());
                }
                String str7 = Build.BRAND;
                if (("blu".equalsIgnoreCase(str7) && "studio x10".equalsIgnoreCase(Build.MODEL)) || (("itel".equalsIgnoreCase(str7) && "itel w6004".equalsIgnoreCase(Build.MODEL)) || (("vivo".equalsIgnoreCase(str7) && "vivo 1805".equalsIgnoreCase(Build.MODEL)) || ("positivo".equalsIgnoreCase(str7) && "twist 2 pro".equalsIgnoreCase(Build.MODEL))))) {
                    z3 = true;
                } else {
                    String str8 = Build.MODEL;
                    if (("pixel 4 xl".equalsIgnoreCase(str8) && Build.VERSION.SDK_INT == 29) || ("motorola".equalsIgnoreCase(str7) && "moto e13".equalsIgnoreCase(str8))) {
                        z3 = true;
                    } else {
                        if ("samsung".equalsIgnoreCase(str7)) {
                            String str9 = Build.DEVICE;
                            if ("gta8".equalsIgnoreCase(str9) || "gta8wifi".equalsIgnoreCase(str9)) {
                                z3 = true;
                            }
                        }
                        z3 = false;
                    }
                }
                if (i22Var.a(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class, z3)) {
                    arrayList.add(new ImageCaptureFailedWhenVideoCaptureIsBoundQuirk());
                }
                String str10 = Build.MODEL;
                if (i22Var.a(TemporalNoiseQuirk.class, "Pixel 8".equalsIgnoreCase(str10) && ((Integer) ysVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new TemporalNoiseQuirk());
                }
                HashSet hashSet3 = ImageCaptureFailedForVideoSnapshotQuirk.a;
                Locale locale3 = Locale.US;
                if (hashSet3.contains(str10.toLowerCase(locale3)) || (Build.VERSION.SDK_INT >= 31 && "Spreadtrum".equalsIgnoreCase(Build.SOC_MANUFACTURER))) {
                    z4 = true;
                } else {
                    String str11 = Build.HARDWARE;
                    if (str11.toLowerCase(locale3).startsWith("ums") || (("itel".equalsIgnoreCase(str7) && str11.toLowerCase(locale3).startsWith("sp")) || ("HUAWEI".equalsIgnoreCase(str7) && "FIG-LX1".equalsIgnoreCase(str10)))) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                }
                if (i22Var.a(ImageCaptureFailedForVideoSnapshotQuirk.class, z4)) {
                    arrayList.add(new ImageCaptureFailedForVideoSnapshotQuirk());
                }
                if (i22Var.a(AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk.class, "samsung".equalsIgnoreCase(str7) && str10.toLowerCase(locale3).startsWith("sm-m556"))) {
                    arrayList.add(new AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk());
                }
                cq0 cq0Var = new cq0(arrayList);
                cq0.f(cq0Var);
                xq4.c(3, "CameraQuirks");
                return cq0Var;
            } catch (InterruptedException e) {
                e = e;
                throw new AssertionError("Unexpected error in QuirkSettings StateObservable", e);
            }
        } catch (InterruptedException | ExecutionException e2) {
            e = e2;
        }
    }

    public static int b(byte[] bArr, int i, nt3 nt3Var) {
        int i2 = i(bArr, i, nt3Var);
        int i3 = nt3Var.a;
        if (i3 < 0) {
            kf2.j("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i3 > bArr.length - i2) {
            kf2.j("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        if (i3 == 0) {
            nt3Var.c = rt3.b;
            return i2;
        }
        nt3Var.c = rt3.g(i2, bArr, i3);
        return i2 + i3;
    }

    public static int c(byte[] bArr, int i) {
        int i2 = bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        int i3 = bArr[i + 1] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        int i4 = bArr[i + 2] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        return ((bArr[i + 3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int d(ev3 ev3Var, byte[] bArr, int i, int i2, nt3 nt3Var) {
        Object objI = ev3Var.i();
        int iN = n(objI, ev3Var, bArr, i, i2, nt3Var);
        ev3Var.g(objI);
        nt3Var.c = objI;
        return iN;
    }

    public static int e(ev3 ev3Var, int i, byte[] bArr, int i2, int i3, mu3 mu3Var, nt3 nt3Var) {
        int iD = d(ev3Var, bArr, i2, i3, nt3Var);
        mu3Var.add(nt3Var.c);
        while (iD < i3) {
            int i4 = i(bArr, iD, nt3Var);
            if (i != nt3Var.a) {
                break;
            }
            iD = d(ev3Var, bArr, i4, i3, nt3Var);
            mu3Var.add(nt3Var.c);
        }
        return iD;
    }

    public static int f(byte[] bArr, int i, mu3 mu3Var, nt3 nt3Var) {
        hu3 hu3Var = (hu3) mu3Var;
        int i2 = i(bArr, i, nt3Var);
        int i3 = nt3Var.a + i2;
        while (i2 < i3) {
            i2 = i(bArr, i2, nt3Var);
            hu3Var.d(nt3Var.a);
        }
        if (i2 == i3) {
            return i2;
        }
        kf2.j("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x009e  */
    /* JADX WARN: Code duplicated, block: B:48:0x009f A[PHI: r5
      0x009f: PHI (r5v6 byte) = (r5v5 byte), (r5v9 byte) binds: [B:45:0x009a, B:47:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:89:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00b7 A[SYNTHETIC] */
    public static int g(byte[] bArr, int i, nt3 nt3Var) {
        int i2 = i(bArr, i, nt3Var);
        int i3 = nt3Var.a;
        if (i3 < 0) {
            kf2.j("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i3 == 0) {
            nt3Var.c = "";
            return i2;
        }
        int i4 = rv3.a;
        int length = bArr.length;
        if ((((length - i2) - i3) | i2 | i3) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        int i5 = i2 + i3;
        char[] cArr = new char[i3];
        int i6 = 0;
        while (i2 < i5) {
            byte b = bArr[i2];
            if (b < 0) {
                break;
            }
            i2++;
            cArr[i6] = (char) b;
            i6++;
        }
        while (i2 < i5) {
            int i7 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                cArr[i6] = (char) b2;
                i6++;
                i2 = i7;
                while (i2 < i5) {
                    byte b3 = bArr[i2];
                    if (b3 < 0) {
                        break;
                    }
                    i2++;
                    cArr[i6] = (char) b3;
                    i6++;
                }
            } else {
                if (b2 >= -32) {
                    if (b2 >= -16) {
                        if (i7 >= i5 - 2) {
                            kf2.j("Protocol message had invalid UTF-8.");
                            return 0;
                        }
                        byte b4 = bArr[i7];
                        int i8 = i2 + 3;
                        byte b5 = bArr[i2 + 2];
                        i2 += 4;
                        byte b6 = bArr[i8];
                        if (!zg4.b(b4)) {
                            if ((((b4 + 112) + (b2 << 28)) >> 30) == 0 && !zg4.b(b5) && !zg4.b(b6)) {
                                int i9 = ((b4 & 63) << 12) | ((b2 & 7) << 18) | ((b5 & 63) << 6) | (b6 & 63);
                                cArr[i6] = (char) ((i9 >>> 10) + 55232);
                                cArr[i6 + 1] = (char) ((i9 & UCharacterProperty.MAX_SCRIPT) + UTF16.TRAIL_SURROGATE_MIN_VALUE);
                                i6 += 2;
                            }
                        }
                        kf2.j("Protocol message had invalid UTF-8.");
                        return 0;
                    }
                    if (i7 >= i5 - 1) {
                        kf2.j("Protocol message had invalid UTF-8.");
                        return 0;
                    }
                    int i10 = i6 + 1;
                    int i11 = i2 + 2;
                    byte b7 = bArr[i7];
                    i2 += 3;
                    byte b8 = bArr[i11];
                    if (!zg4.b(b7)) {
                        if (b2 != -32) {
                            if (b2 != -19) {
                                if (!zg4.b(b8)) {
                                    cArr[i6] = (char) (((b7 & 63) << 6) | ((b2 & 15) << 12) | (b8 & 63));
                                    i6 = i10;
                                }
                            } else if (b7 < -96) {
                                b2 = -19;
                                if (!zg4.b(b8)) {
                                    cArr[i6] = (char) (((b7 & 63) << 6) | ((b2 & 15) << 12) | (b8 & 63));
                                    i6 = i10;
                                }
                            }
                        } else if (b7 >= -96) {
                            b2 = -32;
                            if (b2 != -19) {
                                if (!zg4.b(b8)) {
                                    cArr[i6] = (char) (((b7 & 63) << 6) | ((b2 & 15) << 12) | (b8 & 63));
                                    i6 = i10;
                                }
                            } else if (b7 < -96) {
                                b2 = -19;
                                if (!zg4.b(b8)) {
                                    cArr[i6] = (char) (((b7 & 63) << 6) | ((b2 & 15) << 12) | (b8 & 63));
                                    i6 = i10;
                                }
                            }
                        }
                    }
                    kf2.j("Protocol message had invalid UTF-8.");
                    return 0;
                }
                if (i7 >= i5) {
                    kf2.j("Protocol message had invalid UTF-8.");
                    return 0;
                }
                int i12 = i6 + 1;
                i2 += 2;
                byte b9 = bArr[i7];
                if (b2 < -62 || zg4.b(b9)) {
                    kf2.j("Protocol message had invalid UTF-8.");
                    return 0;
                }
                cArr[i6] = (char) ((b9 & 63) | ((b2 & 31) << 6));
                i6 = i12;
            }
        }
        nt3Var.c = new String(cArr, 0, i6);
        return i5;
    }

    public static int h(int i, byte[] bArr, int i2, int i3, kv3 kv3Var, nt3 nt3Var) {
        if ((i >>> 3) == 0) {
            kf2.j("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iL = l(bArr, i2, nt3Var);
            kv3Var.c(i, Long.valueOf(nt3Var.b));
            return iL;
        }
        if (i4 == 1) {
            kv3Var.c(i, Long.valueOf(p(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int i5 = i(bArr, i2, nt3Var);
            int i6 = nt3Var.a;
            if (i6 < 0) {
                kf2.j("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                return 0;
            }
            if (i6 > bArr.length - i5) {
                kf2.j("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return 0;
            }
            if (i6 == 0) {
                kv3Var.c(i, rt3.b);
            } else {
                kv3Var.c(i, rt3.g(i5, bArr, i6));
            }
            return i5 + i6;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                kv3Var.c(i, Integer.valueOf(c(bArr, i2)));
                return i2 + 4;
            }
            kf2.j("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i7 = (i & (-8)) | 4;
        kv3 kv3VarB = kv3.b();
        int i8 = nt3Var.e + 1;
        nt3Var.e = i8;
        if (i8 >= 100) {
            kf2.j("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i9 = 0;
        while (i2 < i3) {
            int i10 = i(bArr, i2, nt3Var);
            int i11 = nt3Var.a;
            if (i11 == i7) {
                i9 = i11;
                i2 = i10;
                break;
            }
            i2 = h(i11, bArr, i10, i3, kv3VarB, nt3Var);
            i9 = i11;
        }
        nt3Var.e--;
        if (i2 > i3 || i9 != i7) {
            kf2.j("Failed to parse the message.");
            return 0;
        }
        kv3Var.c(i, kv3VarB);
        return i2;
    }

    public static int i(byte[] bArr, int i, nt3 nt3Var) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return j(b, bArr, i2, nt3Var);
        }
        nt3Var.a = b;
        return i2;
    }

    public static int j(int i, byte[] bArr, int i2, nt3 nt3Var) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            nt3Var.a = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Bidi.LEVEL_DEFAULT_RTL) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            nt3Var.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Bidi.LEVEL_DEFAULT_RTL) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            nt3Var.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Bidi.LEVEL_DEFAULT_RTL) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            nt3Var.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Bidi.LEVEL_DEFAULT_RTL) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                nt3Var.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int k(int i, byte[] bArr, int i2, int i3, mu3 mu3Var, nt3 nt3Var) {
        hu3 hu3Var = (hu3) mu3Var;
        int i4 = i(bArr, i2, nt3Var);
        hu3Var.d(nt3Var.a);
        while (i4 < i3) {
            int i5 = i(bArr, i4, nt3Var);
            if (i != nt3Var.a) {
                break;
            }
            i4 = i(bArr, i5, nt3Var);
            hu3Var.d(nt3Var.a);
        }
        return i4;
    }

    public static int l(byte[] bArr, int i, nt3 nt3Var) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            nt3Var.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Bidi.LEVEL_DEFAULT_RTL)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Bidi.LEVEL_DEFAULT_RTL)) << i4;
            b = b2;
            i3 = i5;
        }
        nt3Var.b = j2;
        return i3;
    }

    public static int m(Object obj, ev3 ev3Var, byte[] bArr, int i, int i2, int i3, nt3 nt3Var) {
        yu3 yu3Var = (yu3) ev3Var;
        int i4 = nt3Var.e + 1;
        nt3Var.e = i4;
        if (i4 >= 100) {
            kf2.j("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int iU = yu3Var.u(obj, bArr, i, i2, i3, nt3Var);
        nt3Var.e--;
        nt3Var.c = obj;
        return iU;
    }

    public static int n(Object obj, ev3 ev3Var, byte[] bArr, int i, int i2, nt3 nt3Var) {
        int iJ = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iJ = j(i3, bArr, iJ, nt3Var);
            i3 = nt3Var.a;
        }
        int i4 = iJ;
        if (i3 < 0 || i3 > i2 - i4) {
            kf2.j("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        int i5 = nt3Var.e + 1;
        nt3Var.e = i5;
        if (i5 >= 100) {
            kf2.j("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i6 = i4 + i3;
        ev3Var.b(obj, bArr, i4, i6, nt3Var);
        nt3Var.e--;
        nt3Var.c = obj;
        return i6;
    }

    public static int o(int i, byte[] bArr, int i2, int i3, nt3 nt3Var) {
        if ((i >>> 3) == 0) {
            kf2.j("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return l(bArr, i2, nt3Var);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return i(bArr, i2, nt3Var) + nt3Var.a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            kf2.j("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = i(bArr, i2, nt3Var);
            i6 = nt3Var.a;
            if (i6 == i5) {
                break;
            }
            i2 = o(i6, bArr, i2, i3, nt3Var);
        }
        if (i2 <= i3 && i6 == i5) {
            return i2;
        }
        kf2.j("Failed to parse the message.");
        return 0;
    }

    public static long p(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
