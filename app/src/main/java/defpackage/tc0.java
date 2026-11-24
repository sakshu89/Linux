package defpackage;

import android.os.Build;
import android.util.Pair;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionShouldUseMrirQuirk;
import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import androidx.camera.camera2.internal.compat.quirk.InvalidVideoProfilesQuirk;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.camera2.internal.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.internal.compat.quirk.CaptureFailedRetryQuirk;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tc0 implements s40 {
    public final /* synthetic */ int a;

    public /* synthetic */ tc0(int i) {
        this.a = i;
    }

    /* JADX WARN: Code duplicated, block: B:143:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:147:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:149:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:152:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:163:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:193:0x0390  */
    /* JADX WARN: Code duplicated, block: B:203:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:83:0x0180  */
    @Override // defpackage.s40
    public final void accept(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        boolean z4;
        switch (this.a) {
            case 0:
                i22 i22Var = (i22) obj;
                ArrayList arrayList = new ArrayList();
                String str2 = Build.BRAND;
                if (("HUAWEI".equalsIgnoreCase(str2) && "SNE-LX1".equalsIgnoreCase(Build.MODEL)) || ("HONOR".equalsIgnoreCase(str2) && "STK-LX1".equalsIgnoreCase(Build.MODEL))) {
                    z = true;
                } else {
                    String str3 = Build.FINGERPRINT;
                    if (!str3.startsWith("generic") && !str3.startsWith("unknown")) {
                        String str4 = Build.MODEL;
                        if (!str4.contains("google_sdk") && !str4.contains("Emulator") && !str4.contains("Cuttlefish") && !str4.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!str2.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !Build.PRODUCT.equals("google_sdk"))) {
                            Build.HARDWARE.contains("ranchu");
                        }
                    }
                    z = false;
                }
                if (i22Var.a(ImageCaptureRotationOptionQuirk.class, z)) {
                    arrayList.add(new ImageCaptureRotationOptionQuirk());
                }
                if (i22Var.a(SurfaceOrderQuirk.class, true)) {
                    arrayList.add(new SurfaceOrderQuirk());
                }
                HashSet hashSet = CaptureFailedRetryQuirk.a;
                Locale locale = Locale.US;
                String upperCase = str2.toUpperCase(locale);
                String str5 = Build.MODEL;
                if (i22Var.a(CaptureFailedRetryQuirk.class, CaptureFailedRetryQuirk.a.contains(Pair.create(upperCase, str5.toUpperCase(locale))))) {
                    arrayList.add(new CaptureFailedRetryQuirk());
                }
                if (i22Var.a(LowMemoryQuirk.class, LowMemoryQuirk.a.contains(str5.toUpperCase(locale)))) {
                    arrayList.add(new LowMemoryQuirk());
                }
                HashSet hashSet2 = LargeJpegImageQuirk.a;
                if (i22Var.a(LargeJpegImageQuirk.class, "Samsung".equalsIgnoreCase(str2) || LargeJpegImageQuirk.b())) {
                    arrayList.add(new LargeJpegImageQuirk());
                }
                HashSet hashSet3 = IncorrectJpegMetadataQuirk.a;
                if (i22Var.a(IncorrectJpegMetadataQuirk.class, "Samsung".equalsIgnoreCase(str2) && IncorrectJpegMetadataQuirk.a.contains(Build.DEVICE.toUpperCase(locale)))) {
                    arrayList.add(new IncorrectJpegMetadataQuirk());
                }
                uc0.a = new cq0(arrayList);
                cq0.f(uc0.a);
                xq4.c(3, "DeviceQuirks");
                break;
            case 1:
                i22 i22Var2 = (i22) obj;
                ArrayList arrayList2 = new ArrayList();
                if (Build.VERSION.SDK_INT < 33) {
                    String str6 = Build.MANUFACTURER;
                    if ("SAMSUNG".equalsIgnoreCase(str6)) {
                        String str7 = Build.DEVICE;
                        if (!"F2Q".equalsIgnoreCase(str7) && !"Q2Q".equalsIgnoreCase(str7)) {
                            if (("OPPO".equalsIgnoreCase(str6) || !"OP4E75L1".equalsIgnoreCase(Build.DEVICE)) && (!"LENOVO".equalsIgnoreCase(str6) || !"Q706F".equalsIgnoreCase(Build.DEVICE))) {
                                z2 = false;
                            }
                        }
                        z2 = true;
                    } else if ("OPPO".equalsIgnoreCase(str6)) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (i22Var2.a(SurfaceViewStretchedQuirk.class, z2)) {
                    arrayList2.add(new SurfaceViewStretchedQuirk());
                }
                if (i22Var2.a(SurfaceViewNotCroppedByParentQuirk.class, "XIAOMI".equalsIgnoreCase(Build.MANUFACTURER) && "M2101K7AG".equalsIgnoreCase(Build.MODEL))) {
                    arrayList2.add(new SurfaceViewNotCroppedByParentQuirk());
                }
                vc0.a = new cq0(arrayList2);
                cq0.f(vc0.a);
                xq4.c(3, "DeviceQuirks");
                break;
            default:
                i22 i22Var3 = (i22) obj;
                ArrayList arrayList3 = new ArrayList();
                List list = ImageCapturePixelHDRPlusQuirk.a;
                String str8 = Build.MODEL;
                if (i22Var3.a(ImageCapturePixelHDRPlusQuirk.class, list.contains(str8) && "Google".equals(Build.MANUFACTURER))) {
                    arrayList3.add(new ImageCapturePixelHDRPlusQuirk());
                }
                if (i22Var3.a(ExtraCroppingQuirk.class, ExtraCroppingQuirk.c())) {
                    arrayList3.add(new ExtraCroppingQuirk());
                }
                int i = Nexus4AndroidLTargetAspectRatioQuirk.a;
                String str9 = Build.BRAND;
                "GOOGLE".equalsIgnoreCase(str9);
                if (i22Var3.a(Nexus4AndroidLTargetAspectRatioQuirk.class, false)) {
                    arrayList3.add(new Nexus4AndroidLTargetAspectRatioQuirk());
                }
                if (i22Var3.a(ExcludedSupportedSizesQuirk.class, ("OnePlus".equalsIgnoreCase(str9) && "OnePlus6".equalsIgnoreCase(Build.DEVICE)) || ("OnePlus".equalsIgnoreCase(str9) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE)) || (("HUAWEI".equalsIgnoreCase(str9) && "HWANE".equalsIgnoreCase(Build.DEVICE)) || ExcludedSupportedSizesQuirk.c() || ExcludedSupportedSizesQuirk.b() || ("REDMI".equalsIgnoreCase(str9) && "joyeuse".equalsIgnoreCase(Build.DEVICE))))) {
                    arrayList3.add(new ExcludedSupportedSizesQuirk());
                }
                List list2 = CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.a;
                Locale locale2 = Locale.US;
                if (i22Var3.a(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class, list2.contains(str8.toUpperCase(locale2)))) {
                    arrayList3.add(new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk());
                }
                List list3 = PreviewPixelHDRnetQuirk.a;
                String str10 = Build.MANUFACTURER;
                if (i22Var3.a(PreviewPixelHDRnetQuirk.class, "Google".equals(str10) && PreviewPixelHDRnetQuirk.a.contains(Build.DEVICE.toLowerCase(Locale.getDefault())))) {
                    arrayList3.add(new PreviewPixelHDRnetQuirk());
                }
                if (i22Var3.a(StillCaptureFlashStopRepeatingQuirk.class, "SAMSUNG".equals(str10.toUpperCase(locale2)) && str8.toUpperCase(locale2).startsWith("SM-A716"))) {
                    arrayList3.add(new StillCaptureFlashStopRepeatingQuirk());
                }
                kt2 kt2Var = ExtraSupportedSurfaceCombinationsQuirk.a;
                String str11 = Build.DEVICE;
                if ("heroqltevzw".equalsIgnoreCase(str11) || "heroqltetmo".equalsIgnoreCase(str11)) {
                    z3 = true;
                } else {
                    if ((!"google".equalsIgnoreCase(str9) ? false : ExtraSupportedSurfaceCombinationsQuirk.c.contains(str8.toUpperCase(locale2))) || ExtraSupportedSurfaceCombinationsQuirk.b()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (i22Var3.a(ExtraSupportedSurfaceCombinationsQuirk.class, z3)) {
                    arrayList3.add(new ExtraSupportedSurfaceCombinationsQuirk());
                }
                if (i22Var3.a(FlashAvailabilityBufferUnderflowQuirk.class, FlashAvailabilityBufferUnderflowQuirk.a.contains(new Pair(str10.toLowerCase(locale2), str8.toLowerCase(locale2))))) {
                    arrayList3.add(new FlashAvailabilityBufferUnderflowQuirk());
                }
                if (i22Var3.a(RepeatingStreamConstraintForVideoRecordingQuirk.class, "Huawei".equalsIgnoreCase(str9) && "mha-l29".equalsIgnoreCase(str8))) {
                    arrayList3.add(new RepeatingStreamConstraintForVideoRecordingQuirk());
                }
                if (i22Var3.a(TextureViewIsClosedQuirk.class, false)) {
                    arrayList3.add(new TextureViewIsClosedQuirk());
                }
                if (i22Var3.a(CaptureSessionOnClosedNotCalledQuirk.class, false)) {
                    arrayList3.add(new CaptureSessionOnClosedNotCalledQuirk());
                }
                if (i22Var3.a(TorchIsClosedAfterImageCapturingQuirk.class, TorchIsClosedAfterImageCapturingQuirk.a.contains(str8.toLowerCase(locale2)))) {
                    arrayList3.add(new TorchIsClosedAfterImageCapturingQuirk());
                }
                List list4 = ZslDisablerQuirk.a;
                if (i22Var3.a(ZslDisablerQuirk.class, ("samsung".equalsIgnoreCase(str9) && ZslDisablerQuirk.b(ZslDisablerQuirk.a)) || ("xiaomi".equalsIgnoreCase(str9) && ZslDisablerQuirk.b(ZslDisablerQuirk.b)))) {
                    arrayList3.add(new ZslDisablerQuirk());
                }
                if (i22Var3.a(ExtraSupportedOutputSizeQuirk.class, "motorola".equalsIgnoreCase(str9) && "moto e5 play".equalsIgnoreCase(str8))) {
                    arrayList3.add(new ExtraSupportedOutputSizeQuirk());
                }
                List list5 = InvalidVideoProfilesQuirk.a;
                if ("samsung".equalsIgnoreCase(str9) && Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a")) {
                    z4 = true;
                } else {
                    List list6 = InvalidVideoProfilesQuirk.a;
                    Locale locale3 = Locale.ROOT;
                    if (list6.contains(str8.toLowerCase(locale3))) {
                        String str12 = Build.ID;
                        if (str12.toLowerCase(locale3).startsWith("tp1a") || str12.toLowerCase(locale3).startsWith("td1a")) {
                            z4 = true;
                        } else if (!"redmi".equalsIgnoreCase(str9) || "xiaomi".equalsIgnoreCase(str9)) {
                            str = Build.ID;
                            if (!str.toLowerCase(locale3).startsWith("tkq1") || str.toLowerCase(locale3).startsWith("tp1a")) {
                                z4 = true;
                            } else if ((!InvalidVideoProfilesQuirk.b.contains(str8.toLowerCase(locale3)) && Build.VERSION.SDK_INT == 33) || (InvalidVideoProfilesQuirk.c.contains(str8.toLowerCase(locale3)) && Build.VERSION.SDK_INT == 33)) {
                                z4 = true;
                            }
                        } else {
                            z4 = !InvalidVideoProfilesQuirk.b.contains(str8.toLowerCase(locale3)) ? false : false;
                        }
                    } else {
                        if ("redmi".equalsIgnoreCase(str9)) {
                            str = Build.ID;
                            if (str.toLowerCase(locale3).startsWith("tkq1")) {
                            }
                        } else {
                            str = Build.ID;
                            if (str.toLowerCase(locale3).startsWith("tkq1")) {
                            }
                        }
                        z4 = true;
                    }
                }
                if (i22Var3.a(InvalidVideoProfilesQuirk.class, z4)) {
                    arrayList3.add(new InvalidVideoProfilesQuirk());
                }
                if (i22Var3.a(Preview3AThreadCrashQuirk.class, "samsungexynos7870".equalsIgnoreCase(Build.HARDWARE))) {
                    arrayList3.add(new Preview3AThreadCrashQuirk());
                }
                if (i22Var3.a(SmallDisplaySizeQuirk.class, SmallDisplaySizeQuirk.a.containsKey(str8.toUpperCase(locale2)))) {
                    arrayList3.add(new SmallDisplaySizeQuirk());
                }
                if (i22Var3.a(CaptureSessionShouldUseMrirQuirk.class, "google".equalsIgnoreCase(str9) && Build.VERSION.SDK_INT >= 35)) {
                    arrayList3.add(new CaptureSessionShouldUseMrirQuirk());
                }
                wc0.a = new cq0(arrayList3);
                cq0.f(wc0.a);
                xq4.c(3, "DeviceQuirks");
                break;
        }
    }
}
