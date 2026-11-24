package defpackage;

import com.ibm.icu.lang.UCharacter;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ck0 {
    public static final lk0[] c;
    public static final lk0[][] d;
    public static final HashSet e;
    public final ArrayList a;
    public final ByteOrder b;

    static {
        lk0[] lk0VarArr = {new lk0("ImageWidth", 256, 3, 4), new lk0("ImageLength", UCharacter.UnicodeBlock.EARLY_DYNASTIC_CUNEIFORM_ID, 3, 4), new lk0("Make", UCharacter.UnicodeBlock.OSAGE_ID, 2), new lk0("Model", UCharacter.UnicodeBlock.TANGUT_ID, 2), new lk0("Orientation", UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F_ID, 3), new lk0("XResolution", UCharacter.UnicodeBlock.DOGRA_ID, 5), new lk0("YResolution", UCharacter.UnicodeBlock.GEORGIAN_EXTENDED_ID, 5), new lk0("ResolutionUnit", UCharacter.UnicodeBlock.OTTOMAN_SIYAQ_NUMBERS_ID, 3), new lk0("Software", UCharacter.UnicodeBlock.LISU_SUPPLEMENT_ID, 2), new lk0("DateTime", UCharacter.UnicodeBlock.SYMBOLS_FOR_LEGACY_COMPUTING_ID, 2), new lk0("YCbCrPositioning", 531, 3), new lk0("SubIFDPointer", UCharacter.UnicodeBlock.GARAY_ID, 4), new lk0("ExifIFDPointer", 34665, 4), new lk0("GPSInfoIFDPointer", 34853, 4)};
        lk0[] lk0VarArr2 = {new lk0("ExposureTime", 33434, 5), new lk0("FNumber", 33437, 5), new lk0("ExposureProgram", 34850, 3), new lk0("PhotographicSensitivity", 34855, 3), new lk0("SensitivityType", 34864, 3), new lk0("ExifVersion", 36864, 2), new lk0("DateTimeOriginal", 36867, 2), new lk0("DateTimeDigitized", 36868, 2), new lk0("ComponentsConfiguration", 37121, 7), new lk0("ShutterSpeedValue", 37377, 10), new lk0("ApertureValue", 37378, 5), new lk0("BrightnessValue", 37379, 10), new lk0("ExposureBiasValue", 37380, 10), new lk0("MaxApertureValue", 37381, 5), new lk0("MeteringMode", 37383, 3), new lk0("LightSource", 37384, 3), new lk0("Flash", 37385, 3), new lk0("FocalLength", 37386, 5), new lk0("SubSecTime", 37520, 2), new lk0("SubSecTimeOriginal", 37521, 2), new lk0("SubSecTimeDigitized", 37522, 2), new lk0("FlashpixVersion", 40960, 7), new lk0("ColorSpace", 40961, 3), new lk0("PixelXDimension", 40962, 3, 4), new lk0("PixelYDimension", 40963, 3, 4), new lk0("InteroperabilityIFDPointer", 40965, 4), new lk0("FocalPlaneResolutionUnit", 41488, 3), new lk0("SensingMethod", 41495, 3), new lk0("FileSource", 41728, 7), new lk0("SceneType", 41729, 7), new lk0("CustomRendered", 41985, 3), new lk0("ExposureMode", 41986, 3), new lk0("WhiteBalance", 41987, 3), new lk0("SceneCaptureType", 41990, 3), new lk0("Contrast", 41992, 3), new lk0("Saturation", 41993, 3), new lk0("Sharpness", 41994, 3)};
        lk0[] lk0VarArr3 = {new lk0("GPSVersionID", 0, 1), new lk0("GPSLatitudeRef", 1, 2), new lk0("GPSLatitude", 2, 5, 10), new lk0("GPSLongitudeRef", 3, 2), new lk0("GPSLongitude", 4, 5, 10), new lk0("GPSAltitudeRef", 5, 1), new lk0("GPSAltitude", 6, 5), new lk0("GPSTimeStamp", 7, 5), new lk0("GPSSpeedRef", 12, 2), new lk0("GPSTrackRef", 14, 2), new lk0("GPSImgDirectionRef", 16, 2), new lk0("GPSDestBearingRef", 23, 2), new lk0("GPSDestDistanceRef", 25, 2)};
        c = new lk0[]{new lk0("SubIFDPointer", UCharacter.UnicodeBlock.GARAY_ID, 4), new lk0("ExifIFDPointer", 34665, 4), new lk0("GPSInfoIFDPointer", 34853, 4), new lk0("InteroperabilityIFDPointer", 40965, 4)};
        d = new lk0[][]{lk0VarArr, lk0VarArr2, lk0VarArr3, new lk0[]{new lk0("InteroperabilityIndex", 1, 2)}};
        e = new HashSet(Arrays.asList("FNumber", "ExposureTime", "GPSTimeStamp"));
    }

    public ck0(ByteOrder byteOrder, ArrayList arrayList) {
        hh1.e("Malformed attributes list. Number of IFDs mismatch.", arrayList.size() == 4);
        this.b = byteOrder;
        this.a = arrayList;
    }

    public final Map a(int i) {
        hh1.c(i, 0, 4, cq.h("Invalid IFD index: ", i, ". Index should be between [0, EXIF_TAGS.length] "));
        return (Map) this.a.get(i);
    }
}
