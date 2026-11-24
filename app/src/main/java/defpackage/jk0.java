package defpackage;

import android.media.MediaMetadataRetriever;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.DateFormat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jk0 {
    public static final byte[] A;
    public static final byte[] B;
    public static final byte[] C;
    public static final byte[] D;
    public static final byte[] E;
    public static final byte[] F;
    public static final byte[] G;
    public static final byte[] H;
    public static final byte[] I;
    public static final byte[] J;
    public static final byte[] K;
    public static final byte[] L;
    public static final byte[] M;
    public static final String[] N;
    public static final int[] O;
    public static final byte[] P;
    public static final hk0 Q;
    public static final hk0[][] R;
    public static final hk0[] S;
    public static final hk0 T;
    public static final hk0 U;
    public static final HashMap[] V;
    public static final HashMap[] W;
    public static final HashSet X;
    public static final HashMap Y;
    public static final Charset Z;
    public static final byte[] a0;
    public static final byte[] b0;
    public static final Pattern c0;
    public static final Pattern d0;
    public static final Pattern e0;
    public static final boolean r = Log.isLoggable("ExifInterface", 3);
    public static final int[] s;
    public static final int[] t;
    public static final byte[] u;
    public static final byte[] v;
    public static final byte[] w;
    public static final byte[] x;
    public static final byte[] y;
    public static final byte[] z;
    public final String a;
    public final FileDescriptor b;
    public int c;
    public final HashMap[] d;
    public final HashSet e;
    public ByteOrder f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public byte[] k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        s = new int[]{8, 8, 8};
        t = new int[]{8};
        u = new byte[]{-1, -40, -1};
        v = new byte[]{102, 116, 121, 112};
        w = new byte[]{109, 105, 102, 49};
        x = new byte[]{104, 101, 105, 99};
        y = new byte[]{79, 76, 89, 77, 80, 0};
        z = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        A = new byte[]{-119, 80, 78, 71, 13, 10, UCharacterEnums.ECharacterCategory.MODIFIER_SYMBOL, 10};
        B = new byte[]{101, 88, 73, 102};
        C = new byte[]{73, 72, 68, 82};
        D = new byte[]{73, 69, 78, 68};
        E = new byte[]{82, 73, 70, 70};
        F = new byte[]{87, 69, 66, 80};
        G = new byte[]{69, 88, 73, 70};
        H = new byte[]{-99, 1, 42};
        I = "VP8X".getBytes(Charset.defaultCharset());
        J = "VP8L".getBytes(Charset.defaultCharset());
        K = "VP8 ".getBytes(Charset.defaultCharset());
        L = "ANIM".getBytes(Charset.defaultCharset());
        M = "ANMF".getBytes(Charset.defaultCharset());
        N = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        O = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        P = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        hk0[] hk0VarArr = {new hk0("NewSubfileType", 254, 4), new hk0("SubfileType", 255, 4), new hk0("ImageWidth", 256, 3, 4), new hk0("ImageLength", UCharacter.UnicodeBlock.EARLY_DYNASTIC_CUNEIFORM_ID, 3, 4), new hk0("BitsPerSample", UCharacter.UnicodeBlock.HATRAN_ID, 3), new hk0("Compression", UCharacter.UnicodeBlock.MULTANI_ID, 3), new hk0("PhotometricInterpretation", UCharacter.UnicodeBlock.SUTTON_SIGNWRITING_ID, 3), new hk0("ImageDescription", UCharacter.UnicodeBlock.NEWA_ID, 2), new hk0("Make", UCharacter.UnicodeBlock.OSAGE_ID, 2), new hk0("Model", UCharacter.UnicodeBlock.TANGUT_ID, 2), new hk0("StripOffsets", UCharacter.UnicodeBlock.TANGUT_COMPONENTS_ID, 3, 4), new hk0("Orientation", UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F_ID, 3), new hk0("SamplesPerPixel", UCharacter.UnicodeBlock.NUSHU_ID, 3), new hk0("RowsPerStrip", UCharacter.UnicodeBlock.SOYOMBO_ID, 3, 4), new hk0("StripByteCounts", UCharacter.UnicodeBlock.SYRIAC_SUPPLEMENT_ID, 3, 4), new hk0("XResolution", UCharacter.UnicodeBlock.DOGRA_ID, 5), new hk0("YResolution", UCharacter.UnicodeBlock.GEORGIAN_EXTENDED_ID, 5), new hk0("PlanarConfiguration", UCharacter.UnicodeBlock.GUNJALA_GONDI_ID, 3), new hk0("ResolutionUnit", UCharacter.UnicodeBlock.OTTOMAN_SIYAQ_NUMBERS_ID, 3), new hk0("TransferFunction", UCharacter.UnicodeBlock.CHORASMIAN_ID, 3), new hk0("Software", UCharacter.UnicodeBlock.LISU_SUPPLEMENT_ID, 2), new hk0("DateTime", UCharacter.UnicodeBlock.SYMBOLS_FOR_LEGACY_COMPUTING_ID, 2), new hk0("Artist", UCharacter.UnicodeBlock.OLD_UYGHUR_ID, 2), new hk0("WhitePoint", UCharacter.UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED_A_ID, 5), new hk0("PrimaryChromaticities", UCharacter.UnicodeBlock.VITHKUQI_ID, 5), new hk0("SubIFDPointer", UCharacter.UnicodeBlock.GARAY_ID, 4), new hk0("JPEGInterchangeFormat", 513, 4), new hk0("JPEGInterchangeFormatLength", 514, 4), new hk0("YCbCrCoefficients", 529, 5), new hk0("YCbCrSubSampling", 530, 3), new hk0("YCbCrPositioning", 531, 3), new hk0("ReferenceBlackWhite", 532, 5), new hk0("Copyright", 33432, 2), new hk0("ExifIFDPointer", 34665, 4), new hk0("GPSInfoIFDPointer", 34853, 4), new hk0("SensorTopBorder", 4, 4), new hk0("SensorLeftBorder", 5, 4), new hk0("SensorBottomBorder", 6, 4), new hk0("SensorRightBorder", 7, 4), new hk0("ISO", 23, 3), new hk0("JpgFromRaw", 46, 7), new hk0("Xmp", 700, 1)};
        hk0[] hk0VarArr2 = {new hk0("ExposureTime", 33434, 5), new hk0("FNumber", 33437, 5), new hk0("ExposureProgram", 34850, 3), new hk0("SpectralSensitivity", 34852, 2), new hk0("PhotographicSensitivity", 34855, 3), new hk0("OECF", 34856, 7), new hk0("SensitivityType", 34864, 3), new hk0("StandardOutputSensitivity", 34865, 4), new hk0("RecommendedExposureIndex", 34866, 4), new hk0("ISOSpeed", 34867, 4), new hk0("ISOSpeedLatitudeyyy", 34868, 4), new hk0("ISOSpeedLatitudezzz", 34869, 4), new hk0("ExifVersion", 36864, 2), new hk0("DateTimeOriginal", 36867, 2), new hk0("DateTimeDigitized", 36868, 2), new hk0("OffsetTime", 36880, 2), new hk0("OffsetTimeOriginal", 36881, 2), new hk0("OffsetTimeDigitized", 36882, 2), new hk0("ComponentsConfiguration", 37121, 7), new hk0("CompressedBitsPerPixel", 37122, 5), new hk0("ShutterSpeedValue", 37377, 10), new hk0("ApertureValue", 37378, 5), new hk0("BrightnessValue", 37379, 10), new hk0("ExposureBiasValue", 37380, 10), new hk0("MaxApertureValue", 37381, 5), new hk0("SubjectDistance", 37382, 5), new hk0("MeteringMode", 37383, 3), new hk0("LightSource", 37384, 3), new hk0("Flash", 37385, 3), new hk0("FocalLength", 37386, 5), new hk0("SubjectArea", 37396, 3), new hk0("MakerNote", 37500, 7), new hk0("UserComment", 37510, 7), new hk0("SubSecTime", 37520, 2), new hk0("SubSecTimeOriginal", 37521, 2), new hk0("SubSecTimeDigitized", 37522, 2), new hk0("FlashpixVersion", 40960, 7), new hk0("ColorSpace", 40961, 3), new hk0("PixelXDimension", 40962, 3, 4), new hk0("PixelYDimension", 40963, 3, 4), new hk0("RelatedSoundFile", 40964, 2), new hk0("InteroperabilityIFDPointer", 40965, 4), new hk0("FlashEnergy", 41483, 5), new hk0("SpatialFrequencyResponse", 41484, 7), new hk0("FocalPlaneXResolution", 41486, 5), new hk0("FocalPlaneYResolution", 41487, 5), new hk0("FocalPlaneResolutionUnit", 41488, 3), new hk0("SubjectLocation", 41492, 3), new hk0("ExposureIndex", 41493, 5), new hk0("SensingMethod", 41495, 3), new hk0("FileSource", 41728, 7), new hk0("SceneType", 41729, 7), new hk0("CFAPattern", 41730, 7), new hk0("CustomRendered", 41985, 3), new hk0("ExposureMode", 41986, 3), new hk0("WhiteBalance", 41987, 3), new hk0("DigitalZoomRatio", 41988, 5), new hk0("FocalLengthIn35mmFilm", 41989, 3), new hk0("SceneCaptureType", 41990, 3), new hk0("GainControl", 41991, 3), new hk0("Contrast", 41992, 3), new hk0("Saturation", 41993, 3), new hk0("Sharpness", 41994, 3), new hk0("DeviceSettingDescription", 41995, 7), new hk0("SubjectDistanceRange", 41996, 3), new hk0("ImageUniqueID", 42016, 2), new hk0("CameraOwnerName", 42032, 2), new hk0("BodySerialNumber", 42033, 2), new hk0("LensSpecification", 42034, 5), new hk0("LensMake", 42035, 2), new hk0("LensModel", 42036, 2), new hk0("Gamma", 42240, 5), new hk0("DNGVersion", 50706, 1), new hk0("DefaultCropSize", 50720, 3, 4)};
        hk0[] hk0VarArr3 = {new hk0("GPSVersionID", 0, 1), new hk0("GPSLatitudeRef", 1, 2), new hk0("GPSLatitude", 2, 5, 10), new hk0("GPSLongitudeRef", 3, 2), new hk0("GPSLongitude", 4, 5, 10), new hk0("GPSAltitudeRef", 5, 1), new hk0("GPSAltitude", 6, 5), new hk0("GPSTimeStamp", 7, 5), new hk0("GPSSatellites", 8, 2), new hk0("GPSStatus", 9, 2), new hk0("GPSMeasureMode", 10, 2), new hk0("GPSDOP", 11, 5), new hk0("GPSSpeedRef", 12, 2), new hk0("GPSSpeed", 13, 5), new hk0("GPSTrackRef", 14, 2), new hk0("GPSTrack", 15, 5), new hk0("GPSImgDirectionRef", 16, 2), new hk0("GPSImgDirection", 17, 5), new hk0("GPSMapDatum", 18, 2), new hk0("GPSDestLatitudeRef", 19, 2), new hk0("GPSDestLatitude", 20, 5), new hk0("GPSDestLongitudeRef", 21, 2), new hk0("GPSDestLongitude", 22, 5), new hk0("GPSDestBearingRef", 23, 2), new hk0("GPSDestBearing", 24, 5), new hk0("GPSDestDistanceRef", 25, 2), new hk0("GPSDestDistance", 26, 5), new hk0("GPSProcessingMethod", 27, 7), new hk0("GPSAreaInformation", 28, 7), new hk0("GPSDateStamp", 29, 2), new hk0("GPSDifferential", 30, 3), new hk0("GPSHPositioningError", 31, 5)};
        hk0[] hk0VarArr4 = {new hk0("InteroperabilityIndex", 1, 2)};
        hk0[] hk0VarArr5 = {new hk0("NewSubfileType", 254, 4), new hk0("SubfileType", 255, 4), new hk0("ThumbnailImageWidth", 256, 3, 4), new hk0("ThumbnailImageLength", UCharacter.UnicodeBlock.EARLY_DYNASTIC_CUNEIFORM_ID, 3, 4), new hk0("BitsPerSample", UCharacter.UnicodeBlock.HATRAN_ID, 3), new hk0("Compression", UCharacter.UnicodeBlock.MULTANI_ID, 3), new hk0("PhotometricInterpretation", UCharacter.UnicodeBlock.SUTTON_SIGNWRITING_ID, 3), new hk0("ImageDescription", UCharacter.UnicodeBlock.NEWA_ID, 2), new hk0("Make", UCharacter.UnicodeBlock.OSAGE_ID, 2), new hk0("Model", UCharacter.UnicodeBlock.TANGUT_ID, 2), new hk0("StripOffsets", UCharacter.UnicodeBlock.TANGUT_COMPONENTS_ID, 3, 4), new hk0("ThumbnailOrientation", UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F_ID, 3), new hk0("SamplesPerPixel", UCharacter.UnicodeBlock.NUSHU_ID, 3), new hk0("RowsPerStrip", UCharacter.UnicodeBlock.SOYOMBO_ID, 3, 4), new hk0("StripByteCounts", UCharacter.UnicodeBlock.SYRIAC_SUPPLEMENT_ID, 3, 4), new hk0("XResolution", UCharacter.UnicodeBlock.DOGRA_ID, 5), new hk0("YResolution", UCharacter.UnicodeBlock.GEORGIAN_EXTENDED_ID, 5), new hk0("PlanarConfiguration", UCharacter.UnicodeBlock.GUNJALA_GONDI_ID, 3), new hk0("ResolutionUnit", UCharacter.UnicodeBlock.OTTOMAN_SIYAQ_NUMBERS_ID, 3), new hk0("TransferFunction", UCharacter.UnicodeBlock.CHORASMIAN_ID, 3), new hk0("Software", UCharacter.UnicodeBlock.LISU_SUPPLEMENT_ID, 2), new hk0("DateTime", UCharacter.UnicodeBlock.SYMBOLS_FOR_LEGACY_COMPUTING_ID, 2), new hk0("Artist", UCharacter.UnicodeBlock.OLD_UYGHUR_ID, 2), new hk0("WhitePoint", UCharacter.UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED_A_ID, 5), new hk0("PrimaryChromaticities", UCharacter.UnicodeBlock.VITHKUQI_ID, 5), new hk0("SubIFDPointer", UCharacter.UnicodeBlock.GARAY_ID, 4), new hk0("JPEGInterchangeFormat", 513, 4), new hk0("JPEGInterchangeFormatLength", 514, 4), new hk0("YCbCrCoefficients", 529, 5), new hk0("YCbCrSubSampling", 530, 3), new hk0("YCbCrPositioning", 531, 3), new hk0("ReferenceBlackWhite", 532, 5), new hk0("Copyright", 33432, 2), new hk0("ExifIFDPointer", 34665, 4), new hk0("GPSInfoIFDPointer", 34853, 4), new hk0("DNGVersion", 50706, 1), new hk0("DefaultCropSize", 50720, 3, 4)};
        Q = new hk0("StripOffsets", UCharacter.UnicodeBlock.TANGUT_COMPONENTS_ID, 3);
        R = new hk0[][]{hk0VarArr, hk0VarArr2, hk0VarArr3, hk0VarArr4, hk0VarArr5, hk0VarArr, new hk0[]{new hk0("ThumbnailImage", 256, 7), new hk0("CameraSettingsIFDPointer", 8224, 4), new hk0("ImageProcessingIFDPointer", 8256, 4)}, new hk0[]{new hk0("PreviewImageStart", UCharacter.UnicodeBlock.EARLY_DYNASTIC_CUNEIFORM_ID, 4), new hk0("PreviewImageLength", UCharacter.UnicodeBlock.HATRAN_ID, 4)}, new hk0[]{new hk0("AspectFrame", Normalizer2Impl.Hangul.JAMO_L_LIMIT, 3)}, new hk0[]{new hk0("ColorSpace", 55, 3)}};
        S = new hk0[]{new hk0("SubIFDPointer", UCharacter.UnicodeBlock.GARAY_ID, 4), new hk0("ExifIFDPointer", 34665, 4), new hk0("GPSInfoIFDPointer", 34853, 4), new hk0("InteroperabilityIFDPointer", 40965, 4), new hk0("CameraSettingsIFDPointer", 8224, 1), new hk0("ImageProcessingIFDPointer", 8256, 1)};
        T = new hk0("JPEGInterchangeFormat", 513, 4);
        U = new hk0("JPEGInterchangeFormatLength", 514, 4);
        V = new HashMap[10];
        W = new HashMap[10];
        X = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        Y = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        Z = charsetForName;
        a0 = "Exif\u0000\u0000".getBytes(charsetForName);
        b0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            hk0[][] hk0VarArr6 = R;
            if (i >= hk0VarArr6.length) {
                HashMap map = Y;
                hk0[] hk0VarArr7 = S;
                map.put(Integer.valueOf(hk0VarArr7[0].a), 5);
                map.put(Integer.valueOf(hk0VarArr7[1].a), 1);
                map.put(Integer.valueOf(hk0VarArr7[2].a), 2);
                map.put(Integer.valueOf(hk0VarArr7[3].a), 3);
                map.put(Integer.valueOf(hk0VarArr7[4].a), 7);
                map.put(Integer.valueOf(hk0VarArr7[5].a), 8);
                Pattern.compile(".*[1-9].*");
                c0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                d0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                e0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            V[i] = new HashMap();
            W[i] = new HashMap();
            for (hk0 hk0Var : hk0VarArr6[i]) {
                V[i].put(Integer.valueOf(hk0Var.a), hk0Var);
                W[i].put(hk0Var.b, hk0Var);
            }
            i++;
        }
    }

    public jk0(String str) throws Throwable {
        boolean z2;
        hk0[][] hk0VarArr = R;
        this.d = new HashMap[hk0VarArr.length];
        this.e = new HashSet(hk0VarArr.length);
        this.f = ByteOrder.BIG_ENDIAN;
        FileInputStream fileInputStream = null;
        if (str == null) {
            dk0.n("filename cannot be null");
            throw null;
        }
        this.a = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                try {
                    Os.lseek(fileInputStream2.getFD(), 0L, OsConstants.SEEK_CUR);
                    z2 = true;
                } catch (Exception unused) {
                    z2 = false;
                }
                if (z2) {
                    this.b = fileInputStream2.getFD();
                } else {
                    this.b = null;
                }
                y(fileInputStream2);
                c(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                c(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static ByteOrder B(fk0 fk0Var) throws IOException {
        short s2 = fk0Var.readShort();
        if (s2 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        dk0.g(Integer.toHexString(s2), "Invalid byte order: ");
        return null;
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static double d(String str, String str2) {
        try {
            String[] strArrSplit = str.split(",", -1);
            String[] strArrSplit2 = strArrSplit[0].split("/", -1);
            double d = Double.parseDouble(strArrSplit2[0].trim()) / Double.parseDouble(strArrSplit2[1].trim());
            String[] strArrSplit3 = strArrSplit[1].split("/", -1);
            double d2 = Double.parseDouble(strArrSplit3[0].trim()) / Double.parseDouble(strArrSplit3[1].trim());
            String[] strArrSplit4 = strArrSplit[2].split("/", -1);
            double d3 = ((Double.parseDouble(strArrSplit4[0].trim()) / Double.parseDouble(strArrSplit4[1].trim())) / 3600.0d) + (d2 / 60.0d) + d;
            if (!str2.equals("S") && !str2.equals("W")) {
                if (!str2.equals("N") && !str2.equals(DateFormat.ABBR_WEEKDAY)) {
                    throw new IllegalArgumentException();
                }
                return d3;
            }
            return -d3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            dk0.v();
            return 0.0d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] e(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static void f(InputStream inputStream, jo joVar, int i) throws IOException {
        byte[] bArr = new byte[8192];
        while (i > 0) {
            int iMin = Math.min(i, 8192);
            int i2 = inputStream.read(bArr, 0, iMin);
            if (i2 != iMin) {
                dk0.h("Failed to copy the given amount of bytes from the inputstream to the output stream.");
                return;
            } else {
                i -= i2;
                joVar.write(bArr, 0, i2);
            }
        }
    }

    public static void g(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static void h(fk0 fk0Var, jo joVar, byte[] bArr, byte[] bArr2) throws IOException {
        while (true) {
            byte[] bArr3 = new byte[4];
            if (fk0Var.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = Z;
                sb.append(new String(bArr, charset));
                sb.append(bArr2 == null ? "" : " or ".concat(new String(bArr2, charset)));
                throw new IOException(sb.toString());
            }
            int i = fk0Var.readInt();
            joVar.write(bArr3);
            joVar.e(i);
            if (i % 2 == 1) {
                i++;
            }
            f(fk0Var, joVar, i);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    public static Pair v(String str) {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair pairV = v(strArrSplit[0]);
            if (((Integer) pairV.first).intValue() == 2) {
                return pairV;
            }
            for (int i = 1; i < strArrSplit.length; i++) {
                Pair pairV2 = v(strArrSplit[i]);
                int iIntValue = (((Integer) pairV2.first).equals(pairV.first) || ((Integer) pairV2.second).equals(pairV.first)) ? ((Integer) pairV.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairV.second).intValue() == -1 || !(((Integer) pairV2.first).equals(pairV.second) || ((Integer) pairV2.second).equals(pairV.second))) ? -1 : ((Integer) pairV.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairV = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairV = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairV;
        }
        if (!str.contains("/")) {
            try {
                try {
                    long j = Long.parseLong(str);
                    if (j < 0 || j > 65535) {
                        return j < 0 ? new Pair(9, -1) : new Pair(4, -1);
                    }
                    return new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split("/", -1);
        if (strArrSplit2.length == 2) {
            try {
                long j2 = (long) Double.parseDouble(strArrSplit2[0]);
                long j3 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j2 >= 0 && j3 >= 0) {
                    if (j2 <= 2147483647L && j3 <= 2147483647L) {
                        return new Pair(10, 5);
                    }
                    return new Pair(5, -1);
                }
                return new Pair(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair(2, -1);
    }

    public final void A() throws Throwable {
        int i = 0;
        while (true) {
            HashMap[] mapArr = this.d;
            if (i >= mapArr.length) {
                return;
            }
            mapArr[i].size();
            for (Map.Entry entry : mapArr[i].entrySet()) {
                gk0 gk0Var = (gk0) entry.getValue();
                gk0Var.toString();
                gk0Var.i(this.f);
            }
            i++;
        }
    }

    public final void C(byte[] bArr, int i) throws IOException {
        fk0 fk0Var = new fk0(bArr);
        z(fk0Var, bArr.length);
        D(fk0Var, i);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:23:0x008b  */
    public final void D(fk0 fk0Var, int i) throws IOException {
        boolean z2;
        HashMap[] mapArr;
        long j;
        long j2;
        int i2;
        boolean z3;
        int unsignedShort;
        long j3;
        Integer numValueOf = Integer.valueOf(fk0Var.e);
        HashSet hashSet = this.e;
        hashSet.add(numValueOf);
        int i3 = fk0Var.e + 2;
        int i4 = fk0Var.c;
        if (i3 > i4) {
            return;
        }
        short s2 = fk0Var.readShort();
        if ((s2 * 12) + fk0Var.e > i4 || s2 <= 0) {
            return;
        }
        short s3 = 0;
        while (true) {
            z2 = r;
            mapArr = this.d;
            if (s3 >= s2) {
                break;
            }
            int unsignedShort2 = fk0Var.readUnsignedShort();
            int unsignedShort3 = fk0Var.readUnsignedShort();
            int i5 = fk0Var.readInt();
            long j4 = ((long) fk0Var.e) + 4;
            hk0 hk0Var = (hk0) V[i].get(Integer.valueOf(unsignedShort2));
            if (z2) {
                String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", Integer.valueOf(i), Integer.valueOf(unsignedShort2), hk0Var != null ? hk0Var.b : null, Integer.valueOf(unsignedShort3), Integer.valueOf(i5));
            }
            if (hk0Var != null && unsignedShort3 > 0) {
                int[] iArr = O;
                if (unsignedShort3 < iArr.length) {
                    int i6 = hk0Var.c;
                    if (i6 == 7 || unsignedShort3 == 7 || i6 == unsignedShort3 || (i2 = hk0Var.d) == unsignedShort3 || (((i6 == 4 || i2 == 4) && unsignedShort3 == 3) || (((i6 == 9 || i2 == 9) && unsignedShort3 == 8) || ((i6 == 12 || i2 == 12) && unsignedShort3 == 11)))) {
                        if (unsignedShort3 == 7) {
                            unsignedShort3 = i6;
                        }
                        j = j4;
                        j2 = ((long) i5) * ((long) iArr[unsignedShort3]);
                        z3 = j2 >= 0 && j2 <= 2147483647L;
                    } else {
                        if (z2 != 0) {
                            String str = N[unsignedShort3];
                        }
                        j = j4;
                        j2 = 0;
                    }
                } else {
                    j = j4;
                    j2 = 0;
                }
            } else {
                j = j4;
                j2 = 0;
            }
            if (z3) {
                long j5 = j;
                if (j2 > 4) {
                    int i7 = fk0Var.readInt();
                    if (this.c == 7) {
                        if ("MakerNote".equals(hk0Var.b)) {
                            this.n = i7;
                        } else if (i == 6 && "ThumbnailImage".equals(hk0Var.b)) {
                            this.o = i7;
                            this.p = i5;
                            gk0 gk0VarE = gk0.e(6, this.f);
                            gk0 gk0VarB = gk0.b(this.o, this.f);
                            gk0 gk0VarB2 = gk0.b(this.p, this.f);
                            mapArr[4].put("Compression", gk0VarE);
                            mapArr[4].put("JPEGInterchangeFormat", gk0VarB);
                            mapArr[4].put("JPEGInterchangeFormatLength", gk0VarB2);
                        }
                    }
                    long j6 = i7;
                    if (j6 + j2 <= i4) {
                        fk0Var.c(j6);
                    } else {
                        fk0Var.c(j5);
                    }
                } else {
                    j2 = j2;
                    unsignedShort3 = unsignedShort3;
                }
                Integer num = (Integer) Y.get(Integer.valueOf(unsignedShort2));
                if (num != null) {
                    int i8 = unsignedShort3;
                    if (i8 != 3) {
                        if (i8 == 4) {
                            j3 = ((long) fk0Var.readInt()) & 4294967295L;
                        } else if (i8 == 8) {
                            unsignedShort = fk0Var.readShort();
                        } else if (i8 == 9 || i8 == 13) {
                            unsignedShort = fk0Var.readInt();
                        } else {
                            j3 = -1;
                        }
                        if (z2) {
                            String.format("Offset: %d, tagName: %s", Long.valueOf(j3), hk0Var.b);
                        }
                        if (j3 > 0 && j3 < i4 && !hashSet.contains(Integer.valueOf((int) j3))) {
                            fk0Var.c(j3);
                            D(fk0Var, num.intValue());
                        }
                        fk0Var.c(j5);
                    } else {
                        unsignedShort = fk0Var.readUnsignedShort();
                    }
                    j3 = unsignedShort;
                    if (z2) {
                        String.format("Offset: %d, tagName: %s", Long.valueOf(j3), hk0Var.b);
                    }
                    if (j3 > 0) {
                        fk0Var.c(j3);
                        D(fk0Var, num.intValue());
                    }
                    fk0Var.c(j5);
                } else {
                    int i9 = fk0Var.e + this.m;
                    byte[] bArr = new byte[(int) j2];
                    fk0Var.readFully(bArr);
                    gk0 gk0Var = new gk0(i9, bArr, unsignedShort3, i5);
                    HashMap map = mapArr[i];
                    String str2 = hk0Var.b;
                    map.put(str2, gk0Var);
                    if ("DNGVersion".equals(str2)) {
                        this.c = 3;
                    }
                    if ((("Make".equals(str2) || "Model".equals(str2)) && gk0Var.i(this.f).contains("PENTAX")) || ("Compression".equals(str2) && gk0Var.h(this.f) == 65535)) {
                        this.c = 8;
                    }
                    if (fk0Var.e != j5) {
                        fk0Var.c(j5);
                    }
                }
            } else {
                fk0Var.c(j);
            }
            s3 = (short) (s3 + 1);
            s2 = s2;
        }
        if (fk0Var.e + 4 <= i4) {
            int i10 = fk0Var.readInt();
            if (z2) {
                String.format("nextIfdOffset: %d", Integer.valueOf(i10));
            }
            long j7 = i10;
            if (j7 <= 0 || i10 >= i4 || hashSet.contains(Integer.valueOf(i10))) {
                return;
            }
            fk0Var.c(j7);
            if (mapArr[4].isEmpty()) {
                D(fk0Var, 4);
            } else if (mapArr[5].isEmpty()) {
                D(fk0Var, 5);
            }
        }
    }

    public final void E(String str) {
        for (int i = 0; i < R.length; i++) {
            this.d[i].remove(str);
        }
    }

    public final void F(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws IOException {
        if (r) {
            Objects.toString(bufferedInputStream);
            Objects.toString(bufferedOutputStream);
        }
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        jo joVar = new jo(bufferedOutputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != -1) {
            dk0.h("Invalid marker");
            return;
        }
        joVar.c(-1);
        if (dataInputStream.readByte() != -40) {
            dk0.h("Invalid marker");
            return;
        }
        joVar.c(-40);
        String strI = i("Xmp");
        HashMap[] mapArr = this.d;
        gk0 gk0Var = (strI == null || !this.q) ? null : (gk0) mapArr[0].remove("Xmp");
        joVar.c(-1);
        joVar.c(-31);
        N(joVar);
        if (gk0Var != null) {
            mapArr[0].put("Xmp", gk0Var);
        }
        byte[] bArr = new byte[4096];
        while (dataInputStream.readByte() == -1) {
            byte b = dataInputStream.readByte();
            if (b == -39 || b == -38) {
                joVar.c(-1);
                joVar.c(b);
                g(dataInputStream, joVar);
                return;
            }
            if (b != -31) {
                joVar.c(-1);
                joVar.c(b);
                int unsignedShort = dataInputStream.readUnsignedShort();
                joVar.j((short) unsignedShort);
                int i = unsignedShort - 2;
                if (i < 0) {
                    dk0.h("Invalid length");
                    return;
                }
                while (i > 0) {
                    int i2 = dataInputStream.read(bArr, 0, Math.min(i, 4096));
                    if (i2 < 0) {
                        break;
                    }
                    joVar.write(bArr, 0, i2);
                    i -= i2;
                }
            } else {
                int unsignedShort2 = dataInputStream.readUnsignedShort();
                int i3 = unsignedShort2 - 2;
                if (i3 < 0) {
                    dk0.h("Invalid length");
                    return;
                }
                byte[] bArr2 = new byte[6];
                if (i3 >= 6) {
                    if (dataInputStream.read(bArr2) != 6) {
                        dk0.h("Invalid exif");
                        return;
                    } else if (Arrays.equals(bArr2, a0)) {
                        int i4 = unsignedShort2 - 8;
                        if (dataInputStream.skipBytes(i4) != i4) {
                            dk0.h("Invalid length");
                            return;
                        }
                    }
                }
                joVar.c(-1);
                joVar.c(b);
                joVar.j((short) unsignedShort2);
                if (i3 >= 6) {
                    i3 = unsignedShort2 - 8;
                    joVar.write(bArr2);
                }
                while (i3 > 0) {
                    int i5 = dataInputStream.read(bArr, 0, Math.min(i3, 4096));
                    if (i5 < 0) {
                        break;
                    }
                    joVar.write(bArr, 0, i5);
                    i3 -= i5;
                }
            }
        }
        dk0.h("Invalid marker");
    }

    public final void G(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws Throwable {
        if (r) {
            Objects.toString(bufferedInputStream);
            Objects.toString(bufferedOutputStream);
        }
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        jo joVar = new jo(bufferedOutputStream, byteOrder);
        byte[] bArr = A;
        f(dataInputStream, joVar, bArr.length);
        int i = this.m;
        if (i == 0) {
            int i2 = dataInputStream.readInt();
            joVar.e(i2);
            f(dataInputStream, joVar, i2 + 8);
        } else {
            f(dataInputStream, joVar, (i - bArr.length) - 8);
            dataInputStream.skipBytes(dataInputStream.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                jo joVar2 = new jo(byteArrayOutputStream2, byteOrder);
                N(joVar2);
                byte[] byteArray = ((ByteArrayOutputStream) joVar2.b).toByteArray();
                joVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                joVar.e((int) crc32.getValue());
                c(byteArrayOutputStream2);
                g(dataInputStream, joVar);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r2v1, types: [fk0, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public final void H(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws Throwable {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        ByteArrayOutputStream byteArrayOutputStream;
        if (r) {
            Objects.toString(bufferedInputStream);
            Objects.toString(bufferedOutputStream);
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        var fk0Var = new fk0(bufferedInputStream, byteOrder);
        jo joVar = new jo(bufferedOutputStream, byteOrder);
        byte[] bArr = E;
        f(fk0Var, joVar, bArr.length);
        byte[] bArr2 = F;
        fk0Var.skipBytes(bArr2.length + 4);
        var r7 = 0;
        r7 = 0;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    jo joVar2 = new jo(byteArrayOutputStream2, byteOrder);
                    int i6 = this.m;
                    try {
                        try {
                            if (i6 == 0) {
                                byte[] bArr3 = new byte[4];
                                if (fk0Var.read(bArr3) != 4) {
                                    throw new IOException("Encountered invalid length while parsing WebP chunk type");
                                }
                                byte[] bArr4 = I;
                                boolean zEquals = Arrays.equals(bArr3, bArr4);
                                byte[] bArr5 = K;
                                byte[] bArr6 = J;
                                if (!zEquals) {
                                    if (Arrays.equals(bArr3, bArr5) || Arrays.equals(bArr3, bArr6)) {
                                        int i7 = fk0Var.readInt();
                                        int i8 = i7 % 2 == 1 ? i7 + 1 : i7;
                                        byte[] bArr7 = new byte[3];
                                        boolean zEquals2 = Arrays.equals(bArr3, bArr5);
                                        byte[] bArr8 = H;
                                        if (zEquals2) {
                                            fk0Var.read(bArr7);
                                            byte[] bArr9 = new byte[3];
                                            int i9 = i8;
                                            if (fk0Var.read(bArr9) != 3 || !Arrays.equals(bArr8, bArr9)) {
                                                throw new IOException("Encountered error while checking VP8 signature");
                                            }
                                            i2 = fk0Var.readInt();
                                            i3 = (i2 << 18) >> 18;
                                            i = i9 - 10;
                                            i4 = (i2 << 2) >> 18;
                                            i5 = 0;
                                        } else {
                                            int i10 = i8;
                                            if (!Arrays.equals(bArr3, bArr6)) {
                                                i = i10;
                                                i2 = 0;
                                                i3 = 0;
                                                i4 = 0;
                                                i5 = 0;
                                            } else {
                                                if (fk0Var.readByte() != 47) {
                                                    throw new IOException("Encountered error while checking VP8L signature");
                                                }
                                                i2 = fk0Var.readInt();
                                                i5 = i2 & 8;
                                                i3 = ((i2 << 18) >> 18) + 1;
                                                i = i10 - 5;
                                                i4 = ((i2 << 4) >> 18) + 1;
                                            }
                                        }
                                        joVar2.write(bArr4);
                                        joVar2.e(10);
                                        byte[] bArr10 = new byte[10];
                                        int i11 = i3;
                                        byte b = (byte) (bArr10[0] | 8);
                                        bArr10[0] = b;
                                        bArr10[0] = (byte) (b | (i5 << 4));
                                        int i12 = i11 - 1;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        int i13 = i4 - 1;
                                        try {
                                            bArr10[4] = (byte) i12;
                                            bArr10[5] = (byte) (i12 >> 8);
                                            bArr10[6] = (byte) (i12 >> 16);
                                            bArr10[7] = (byte) i13;
                                            bArr10[8] = (byte) (i13 >> 8);
                                            bArr10[9] = (byte) (i13 >> 16);
                                            joVar2.write(bArr10);
                                            joVar2.write(bArr3);
                                            joVar2.e(i7);
                                            try {
                                                if (Arrays.equals(bArr3, bArr5)) {
                                                    joVar2.write(bArr7);
                                                    joVar2.write(bArr8);
                                                    joVar2.e(i2);
                                                } else {
                                                    if (Arrays.equals(bArr3, bArr6)) {
                                                        joVar2.write(47);
                                                        joVar2.e(i2);
                                                    }
                                                    f(fk0Var, joVar2, i);
                                                    N(joVar2);
                                                }
                                                f(fk0Var, joVar2, i);
                                                N(joVar2);
                                            } catch (Exception e) {
                                                e = e;
                                                r7 = byteArrayOutputStream;
                                            } catch (Throwable th) {
                                                th = th;
                                                r7 = byteArrayOutputStream;
                                                c(r7);
                                                throw th;
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            fk0Var = byteArrayOutputStream;
                                            r7 = fk0Var;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fk0Var = byteArrayOutputStream;
                                            r7 = fk0Var;
                                            c(r7);
                                            throw th;
                                        }
                                    }
                                    g(fk0Var, joVar2);
                                    joVar.e(byteArrayOutputStream.size() + bArr2.length);
                                    joVar.write(bArr2);
                                    ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
                                    byteArrayOutputStream3.writeTo(joVar);
                                    c(byteArrayOutputStream3);
                                }
                                int i14 = fk0Var.readInt();
                                byte[] bArr11 = new byte[i14 % 2 == 1 ? i14 + 1 : i14];
                                fk0Var.read(bArr11);
                                byte b2 = (byte) (bArr11[0] | 8);
                                bArr11[0] = b2;
                                var r15 = ((b2 >> 1) & 1) == 1;
                                joVar2.write(bArr4);
                                joVar2.e(i14);
                                joVar2.write(bArr11);
                                if (r15 == true) {
                                    h(fk0Var, joVar2, L, null);
                                    while (true) {
                                        byte[] bArr12 = new byte[4];
                                        bufferedInputStream.read(bArr12);
                                        if (!Arrays.equals(bArr12, M)) {
                                            break;
                                        }
                                        int i15 = fk0Var.readInt();
                                        joVar2.write(bArr12);
                                        joVar2.e(i15);
                                        if (i15 % 2 == 1) {
                                            i15++;
                                        }
                                        f(fk0Var, joVar2, i15);
                                    }
                                    N(joVar2);
                                } else {
                                    h(fk0Var, joVar2, bArr5, bArr6);
                                    N(joVar2);
                                }
                                r7 = fk0Var;
                                throw new IOException("Failed to save WebP file", e);
                            }
                            f(fk0Var, joVar2, (i6 - ((bArr.length + 4) + bArr2.length)) - 8);
                            fk0Var.skipBytes(4);
                            fk0Var.skipBytes(fk0Var.readInt());
                            N(joVar2);
                            byteArrayOutputStream = byteArrayOutputStream2;
                            g(fk0Var, joVar2);
                            joVar.e(byteArrayOutputStream.size() + bArr2.length);
                            joVar.write(bArr2);
                            ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream;
                            byteArrayOutputStream4.writeTo(joVar);
                            c(byteArrayOutputStream4);
                        } catch (Exception e3) {
                            e = e3;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        r7 = byteArrayOutputStream2;
                    } catch (Throwable th4) {
                        th = th4;
                        r7 = byteArrayOutputStream2;
                    }
                } catch (Exception e5) {
                    e = e5;
                    fk0Var = byteArrayOutputStream2;
                } catch (Throwable th5) {
                    th = th5;
                    fk0Var = byteArrayOutputStream2;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:0x028d A[LOOP:5: B:100:0x028a->B:102:0x028d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:105:0x02ae A[LOOP:6: B:104:0x02ac->B:105:0x02ae, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:107:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:110:0x02d5 A[LOOP:7: B:108:0x02d2->B:110:0x02d5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:112:0x0300  */
    /* JADX WARN: Code duplicated, block: B:115:0x0312 A[LOOP:8: B:113:0x030f->B:115:0x0312, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:117:0x032a  */
    /* JADX WARN: Code duplicated, block: B:120:0x033c A[LOOP:9: B:118:0x0339->B:120:0x033c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:122:0x0354  */
    /* JADX WARN: Code duplicated, block: B:123:0x0365  */
    /* JADX WARN: Code duplicated, block: B:125:0x0375  */
    /* JADX WARN: Code duplicated, block: B:127:0x037f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0397  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:85:0x01cc A[LOOP:1: B:83:0x01c9->B:85:0x01cc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:88:0x01ec A[LOOP:2: B:87:0x01ea->B:88:0x01ec, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x0202  */
    /* JADX WARN: Code duplicated, block: B:93:0x020d A[LOOP:3: B:91:0x020a->B:93:0x020d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x0258 A[LOOP:4: B:95:0x0256->B:96:0x0258, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:99:0x027b  */
    public final void I(String str, String str2) {
        hk0 hk0Var;
        int[] iArr;
        int i;
        int i2;
        int i3;
        int i4;
        gk0 gk0Var;
        int i5;
        int i6;
        String[] strArrSplit;
        int[] iArr2;
        int i7;
        String[] strArrSplit2;
        long[] jArr;
        int i8;
        String[] strArrSplit3;
        ik0[] ik0VarArr;
        int i9;
        String[] strArrSplit4;
        int length;
        int[] iArr3;
        int i10;
        ByteBuffer byteBufferWrap;
        int i11;
        String[] strArrSplit5;
        int length2;
        ik0[] ik0VarArr2;
        int i12;
        ByteBuffer byteBufferWrap2;
        int i13;
        String[] strArrSplit6;
        int length3;
        double[] dArr;
        int i14;
        ByteBuffer byteBufferWrap3;
        int i15;
        String str3 = str;
        String strReplaceAll = str2;
        if (("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) && strReplaceAll != null) {
            boolean zFind = d0.matcher(strReplaceAll).find();
            boolean zFind2 = e0.matcher(strReplaceAll).find();
            if (strReplaceAll.length() != 19 || (!zFind && !zFind2)) {
                Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll(LanguageTag.SEP, ":");
            }
        }
        if ("ISOSpeedRatings".equals(str3)) {
            str3 = "PhotographicSensitivity";
        }
        int i16 = 2;
        int i17 = 1;
        if (strReplaceAll != null && X.contains(str3)) {
            if (str3.equals("GPSTimeStamp")) {
                Matcher matcher = c0.matcher(strReplaceAll);
                if (!matcher.find()) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    long j = (long) (Double.parseDouble(strReplaceAll) * 10000.0d);
                    long j2 = 10000;
                    if (10000 == 0) {
                        j2 = 1;
                        j = 0;
                    }
                    strReplaceAll = j + "/" + j2;
                } catch (NumberFormatException unused) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
            }
        }
        int i18 = 0;
        int i19 = 0;
        while (i19 < R.length) {
            if ((i19 != 4 || this.g) && (hk0Var = (hk0) W[i19].get(str3)) != null) {
                int i20 = hk0Var.d;
                int i21 = hk0Var.c;
                HashMap[] mapArr = this.d;
                if (strReplaceAll != null) {
                    Pair pairV = v(strReplaceAll);
                    if (i21 == ((Integer) pairV.first).intValue() || i21 == ((Integer) pairV.second).intValue()) {
                        i20 = i21;
                        iArr = O;
                        switch (i20) {
                            case 1:
                                i = i18;
                                i2 = i19;
                                HashMap map = mapArr[i2];
                                i3 = i17;
                                if (strReplaceAll.length() == i3) {
                                    i4 = i;
                                    if (strReplaceAll.charAt(i4) < '0' && strReplaceAll.charAt(i4) <= '1') {
                                        byte[] bArr = new byte[i3];
                                        bArr[i4] = (byte) (strReplaceAll.charAt(i4) - '0');
                                        gk0Var = new gk0(i3, bArr, i3);
                                    }
                                    map.put(str3, gk0Var);
                                } else {
                                    i4 = i;
                                }
                                byte[] bytes = strReplaceAll.getBytes(Z);
                                gk0Var = new gk0(i3, bytes, bytes.length);
                                map.put(str3, gk0Var);
                                break;
                            case 2:
                            case 7:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                mapArr[i2].put(str3, gk0.a(strReplaceAll));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 3:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit = strReplaceAll.split(",", -1);
                                iArr2 = new int[strArrSplit.length];
                                while (i7 < strArrSplit.length) {
                                    iArr2[i7] = Integer.parseInt(strArrSplit[i7]);
                                }
                                mapArr[i2].put(str3, gk0.f(iArr2, this.f));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 4:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit2 = strReplaceAll.split(",", -1);
                                jArr = new long[strArrSplit2.length];
                                while (i8 < strArrSplit2.length) {
                                    jArr[i8] = Long.parseLong(strArrSplit2[i8]);
                                }
                                mapArr[i2].put(str3, gk0.c(jArr, this.f));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 5:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit3 = strReplaceAll.split(",", -1);
                                ik0VarArr = new ik0[strArrSplit3.length];
                                while (i9 < strArrSplit3.length) {
                                    String[] strArrSplit7 = strArrSplit3[i9].split("/", -1);
                                    ik0VarArr[i9] = new ik0((long) Double.parseDouble(strArrSplit7[i5]), (long) Double.parseDouble(strArrSplit7[i6]));
                                }
                                mapArr[i2].put(str3, gk0.d(ik0VarArr, this.f));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 9:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit4 = strReplaceAll.split(",", -1);
                                length = strArrSplit4.length;
                                iArr3 = new int[length];
                                while (i10 < strArrSplit4.length) {
                                    iArr3[i10] = Integer.parseInt(strArrSplit4[i10]);
                                }
                                HashMap map2 = mapArr[i2];
                                ByteOrder byteOrder = this.f;
                                byteBufferWrap = ByteBuffer.wrap(new byte[iArr[9] * length]);
                                byteBufferWrap.order(byteOrder);
                                while (i11 < length) {
                                    byteBufferWrap.putInt(iArr3[i11]);
                                }
                                map2.put(str3, new gk0(9, byteBufferWrap.array(), length));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 10:
                                strArrSplit5 = strReplaceAll.split(",", -1);
                                length2 = strArrSplit5.length;
                                ik0VarArr2 = new ik0[length2];
                                i12 = i18;
                                while (i12 < strArrSplit5.length) {
                                    String[] strArrSplit8 = strArrSplit5[i12].split("/", -1);
                                    ik0VarArr2[i12] = new ik0((long) Double.parseDouble(strArrSplit8[i18]), (long) Double.parseDouble(strArrSplit8[i17]));
                                    i12++;
                                    i18 = i18;
                                    i17 = i17;
                                    i19 = i19;
                                    strArrSplit5 = strArrSplit5;
                                }
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                HashMap map3 = mapArr[i2];
                                ByteOrder byteOrder2 = this.f;
                                byteBufferWrap2 = ByteBuffer.wrap(new byte[iArr[10] * length2]);
                                byteBufferWrap2.order(byteOrder2);
                                while (i13 < length2) {
                                    ik0 ik0Var = ik0VarArr2[i13];
                                    byteBufferWrap2.putInt((int) ik0Var.a);
                                    byteBufferWrap2.putInt((int) ik0Var.b);
                                }
                                map3.put(str3, new gk0(10, byteBufferWrap2.array(), length2));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 12:
                                strArrSplit6 = strReplaceAll.split(",", -1);
                                length3 = strArrSplit6.length;
                                dArr = new double[length3];
                                while (i14 < strArrSplit6.length) {
                                    dArr[i14] = Double.parseDouble(strArrSplit6[i14]);
                                }
                                HashMap map4 = mapArr[i19];
                                ByteOrder byteOrder3 = this.f;
                                byteBufferWrap3 = ByteBuffer.wrap(new byte[iArr[12] * length3]);
                                byteBufferWrap3.order(byteOrder3);
                                while (i15 < length3) {
                                    byteBufferWrap3.putDouble(dArr[i15]);
                                }
                                map4.put(str3, new gk0(12, byteBufferWrap3.array(), length3));
                                break;
                        }
                    } else if (i20 != -1 && (i20 == ((Integer) pairV.first).intValue() || i20 == ((Integer) pairV.second).intValue())) {
                        iArr = O;
                        switch (i20) {
                            case 1:
                                i = i18;
                                i2 = i19;
                                HashMap map5 = mapArr[i2];
                                i3 = i17;
                                if (strReplaceAll.length() == i3) {
                                    i4 = i;
                                    if (strReplaceAll.charAt(i4) < '0') {
                                    }
                                    map5.put(str3, gk0Var);
                                } else {
                                    i4 = i;
                                }
                                byte[] bytes2 = strReplaceAll.getBytes(Z);
                                gk0Var = new gk0(i3, bytes2, bytes2.length);
                                map5.put(str3, gk0Var);
                                break;
                            case 2:
                            case 7:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                mapArr[i2].put(str3, gk0.a(strReplaceAll));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 3:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit = strReplaceAll.split(",", -1);
                                iArr2 = new int[strArrSplit.length];
                                for (i7 = i5; i7 < strArrSplit.length; i7++) {
                                    iArr2[i7] = Integer.parseInt(strArrSplit[i7]);
                                }
                                mapArr[i2].put(str3, gk0.f(iArr2, this.f));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 4:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit2 = strReplaceAll.split(",", -1);
                                jArr = new long[strArrSplit2.length];
                                for (i8 = i5; i8 < strArrSplit2.length; i8++) {
                                    jArr[i8] = Long.parseLong(strArrSplit2[i8]);
                                }
                                mapArr[i2].put(str3, gk0.c(jArr, this.f));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 5:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit3 = strReplaceAll.split(",", -1);
                                ik0VarArr = new ik0[strArrSplit3.length];
                                for (i9 = i5; i9 < strArrSplit3.length; i9++) {
                                    String[] strArrSplit9 = strArrSplit3[i9].split("/", -1);
                                    ik0VarArr[i9] = new ik0((long) Double.parseDouble(strArrSplit9[i5]), (long) Double.parseDouble(strArrSplit9[i6]));
                                }
                                mapArr[i2].put(str3, gk0.d(ik0VarArr, this.f));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 9:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit4 = strReplaceAll.split(",", -1);
                                length = strArrSplit4.length;
                                iArr3 = new int[length];
                                for (i10 = i5; i10 < strArrSplit4.length; i10++) {
                                    iArr3[i10] = Integer.parseInt(strArrSplit4[i10]);
                                }
                                HashMap map6 = mapArr[i2];
                                ByteOrder byteOrder4 = this.f;
                                byteBufferWrap = ByteBuffer.wrap(new byte[iArr[9] * length]);
                                byteBufferWrap.order(byteOrder4);
                                for (i11 = i5; i11 < length; i11++) {
                                    byteBufferWrap.putInt(iArr3[i11]);
                                }
                                map6.put(str3, new gk0(9, byteBufferWrap.array(), length));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 10:
                                strArrSplit5 = strReplaceAll.split(",", -1);
                                length2 = strArrSplit5.length;
                                ik0VarArr2 = new ik0[length2];
                                i12 = i18;
                                while (i12 < strArrSplit5.length) {
                                    String[] strArrSplit10 = strArrSplit5[i12].split("/", -1);
                                    ik0VarArr2[i12] = new ik0((long) Double.parseDouble(strArrSplit10[i18]), (long) Double.parseDouble(strArrSplit10[i17]));
                                    i12++;
                                    i18 = i18;
                                    i17 = i17;
                                    i19 = i19;
                                    strArrSplit5 = strArrSplit5;
                                }
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                HashMap map7 = mapArr[i2];
                                ByteOrder byteOrder5 = this.f;
                                byteBufferWrap2 = ByteBuffer.wrap(new byte[iArr[10] * length2]);
                                byteBufferWrap2.order(byteOrder5);
                                for (i13 = i5; i13 < length2; i13++) {
                                    ik0 ik0Var2 = ik0VarArr2[i13];
                                    byteBufferWrap2.putInt((int) ik0Var2.a);
                                    byteBufferWrap2.putInt((int) ik0Var2.b);
                                }
                                map7.put(str3, new gk0(10, byteBufferWrap2.array(), length2));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 12:
                                strArrSplit6 = strReplaceAll.split(",", -1);
                                length3 = strArrSplit6.length;
                                dArr = new double[length3];
                                for (i14 = i18; i14 < strArrSplit6.length; i14++) {
                                    dArr[i14] = Double.parseDouble(strArrSplit6[i14]);
                                }
                                HashMap map8 = mapArr[i19];
                                ByteOrder byteOrder6 = this.f;
                                byteBufferWrap3 = ByteBuffer.wrap(new byte[iArr[12] * length3]);
                                byteBufferWrap3.order(byteOrder6);
                                for (i15 = i18; i15 < length3; i15++) {
                                    byteBufferWrap3.putDouble(dArr[i15]);
                                }
                                map8.put(str3, new gk0(12, byteBufferWrap3.array(), length3));
                                break;
                        }
                    } else if (i21 == i17 || i21 == 7 || i21 == i16) {
                        i20 = i21;
                        iArr = O;
                        switch (i20) {
                            case 1:
                                i = i18;
                                i2 = i19;
                                HashMap map9 = mapArr[i2];
                                i3 = i17;
                                if (strReplaceAll.length() == i3) {
                                    i4 = i;
                                    if (strReplaceAll.charAt(i4) < '0') {
                                    }
                                    map9.put(str3, gk0Var);
                                } else {
                                    i4 = i;
                                }
                                byte[] bytes3 = strReplaceAll.getBytes(Z);
                                gk0Var = new gk0(i3, bytes3, bytes3.length);
                                map9.put(str3, gk0Var);
                                break;
                            case 2:
                            case 7:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                mapArr[i2].put(str3, gk0.a(strReplaceAll));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 3:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit = strReplaceAll.split(",", -1);
                                iArr2 = new int[strArrSplit.length];
                                while (i7 < strArrSplit.length) {
                                    iArr2[i7] = Integer.parseInt(strArrSplit[i7]);
                                }
                                mapArr[i2].put(str3, gk0.f(iArr2, this.f));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 4:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit2 = strReplaceAll.split(",", -1);
                                jArr = new long[strArrSplit2.length];
                                while (i8 < strArrSplit2.length) {
                                    jArr[i8] = Long.parseLong(strArrSplit2[i8]);
                                }
                                mapArr[i2].put(str3, gk0.c(jArr, this.f));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 5:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit3 = strReplaceAll.split(",", -1);
                                ik0VarArr = new ik0[strArrSplit3.length];
                                while (i9 < strArrSplit3.length) {
                                    String[] strArrSplit11 = strArrSplit3[i9].split("/", -1);
                                    ik0VarArr[i9] = new ik0((long) Double.parseDouble(strArrSplit11[i5]), (long) Double.parseDouble(strArrSplit11[i6]));
                                }
                                mapArr[i2].put(str3, gk0.d(ik0VarArr, this.f));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 9:
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                strArrSplit4 = strReplaceAll.split(",", -1);
                                length = strArrSplit4.length;
                                iArr3 = new int[length];
                                while (i10 < strArrSplit4.length) {
                                    iArr3[i10] = Integer.parseInt(strArrSplit4[i10]);
                                }
                                HashMap map10 = mapArr[i2];
                                ByteOrder byteOrder7 = this.f;
                                byteBufferWrap = ByteBuffer.wrap(new byte[iArr[9] * length]);
                                byteBufferWrap.order(byteOrder7);
                                while (i11 < length) {
                                    byteBufferWrap.putInt(iArr3[i11]);
                                }
                                map10.put(str3, new gk0(9, byteBufferWrap.array(), length));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 10:
                                strArrSplit5 = strReplaceAll.split(",", -1);
                                length2 = strArrSplit5.length;
                                ik0VarArr2 = new ik0[length2];
                                i12 = i18;
                                while (i12 < strArrSplit5.length) {
                                    String[] strArrSplit12 = strArrSplit5[i12].split("/", -1);
                                    ik0VarArr2[i12] = new ik0((long) Double.parseDouble(strArrSplit12[i18]), (long) Double.parseDouble(strArrSplit12[i17]));
                                    i12++;
                                    i18 = i18;
                                    i17 = i17;
                                    i19 = i19;
                                    strArrSplit5 = strArrSplit5;
                                }
                                i5 = i18;
                                i2 = i19;
                                i6 = i17;
                                HashMap map11 = mapArr[i2];
                                ByteOrder byteOrder8 = this.f;
                                byteBufferWrap2 = ByteBuffer.wrap(new byte[iArr[10] * length2]);
                                byteBufferWrap2.order(byteOrder8);
                                while (i13 < length2) {
                                    ik0 ik0Var3 = ik0VarArr2[i13];
                                    byteBufferWrap2.putInt((int) ik0Var3.a);
                                    byteBufferWrap2.putInt((int) ik0Var3.b);
                                }
                                map11.put(str3, new gk0(10, byteBufferWrap2.array(), length2));
                                i4 = i5;
                                i3 = i6;
                                break;
                            case 12:
                                strArrSplit6 = strReplaceAll.split(",", -1);
                                length3 = strArrSplit6.length;
                                dArr = new double[length3];
                                while (i14 < strArrSplit6.length) {
                                    dArr[i14] = Double.parseDouble(strArrSplit6[i14]);
                                }
                                HashMap map12 = mapArr[i19];
                                ByteOrder byteOrder9 = this.f;
                                byteBufferWrap3 = ByteBuffer.wrap(new byte[iArr[12] * length3]);
                                byteBufferWrap3.order(byteOrder9);
                                while (i15 < length3) {
                                    byteBufferWrap3.putDouble(dArr[i15]);
                                }
                                map12.put(str3, new gk0(12, byteBufferWrap3.array(), length3));
                                break;
                        }
                    } else if (r) {
                        String[] strArr = N;
                        String str4 = strArr[i21];
                        if (i20 != -1) {
                            String str5 = strArr[i20];
                        }
                        String str6 = strArr[((Integer) pairV.first).intValue()];
                        if (((Integer) pairV.second).intValue() != -1) {
                            String str7 = strArr[((Integer) pairV.second).intValue()];
                        }
                    }
                } else {
                    mapArr[i19].remove(str3);
                }
                i2 = i19;
                i3 = i17;
                i4 = i18;
            } else {
                i2 = i19;
                i3 = i17;
                i4 = i18;
            }
            int i22 = i4;
            i19 = i2 + 1;
            i18 = i22;
            i17 = i3;
            i16 = 2;
        }
    }

    public final void J(fk0 fk0Var) throws Throwable {
        gk0 gk0Var;
        HashMap map = this.d[4];
        gk0 gk0Var2 = (gk0) map.get("Compression");
        if (gk0Var2 == null) {
            this.l = 6;
            w(fk0Var, map);
            return;
        }
        int iH = gk0Var2.h(this.f);
        this.l = iH;
        if (iH != 1) {
            if (iH == 6) {
                w(fk0Var, map);
                return;
            } else if (iH != 7) {
                return;
            }
        }
        gk0 gk0Var3 = (gk0) map.get("BitsPerSample");
        if (gk0Var3 != null) {
            int[] iArr = (int[]) gk0Var3.j(this.f);
            int[] iArr2 = s;
            if (!Arrays.equals(iArr2, iArr)) {
                if (this.c != 3 || (gk0Var = (gk0) map.get("PhotometricInterpretation")) == null) {
                    return;
                }
                int iH2 = gk0Var.h(this.f);
                if ((iH2 != 1 || !Arrays.equals(iArr, t)) && (iH2 != 6 || !Arrays.equals(iArr, iArr2))) {
                    return;
                }
            }
            gk0 gk0Var4 = (gk0) map.get("StripOffsets");
            gk0 gk0Var5 = (gk0) map.get("StripByteCounts");
            if (gk0Var4 == null || gk0Var5 == null) {
                return;
            }
            long[] jArrE = e(gk0Var4.j(this.f));
            long[] jArrE2 = e(gk0Var5.j(this.f));
            if (jArrE == null || jArrE.length == 0) {
                Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                return;
            }
            if (jArrE2 == null || jArrE2.length == 0) {
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                return;
            }
            if (jArrE.length != jArrE2.length) {
                Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                return;
            }
            long j = 0;
            for (long j2 : jArrE2) {
                j += j2;
            }
            int i = (int) j;
            byte[] bArr = new byte[i];
            this.h = true;
            this.g = true;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < jArrE.length; i4++) {
                int i5 = (int) jArrE[i4];
                int i6 = (int) jArrE2[i4];
                if (i4 < jArrE.length - 1 && i5 + i6 != jArrE[i4 + 1]) {
                    this.h = false;
                }
                int i7 = i5 - i2;
                if (i7 < 0) {
                    return;
                }
                long j3 = i7;
                if (fk0Var.skip(j3) != j3) {
                    return;
                }
                int i8 = i2 + i7;
                byte[] bArr2 = new byte[i6];
                if (fk0Var.read(bArr2) != i6) {
                    return;
                }
                i2 = i8 + i6;
                System.arraycopy(bArr2, 0, bArr, i3, i6);
                i3 += i6;
            }
            this.k = bArr;
            if (this.h) {
                this.i = (int) jArrE[0];
                this.j = i;
            }
        }
    }

    public final void K(int i, int i2) throws Throwable {
        HashMap[] mapArr = this.d;
        if (mapArr[i].isEmpty() || mapArr[i2].isEmpty()) {
            return;
        }
        gk0 gk0Var = (gk0) mapArr[i].get("ImageLength");
        gk0 gk0Var2 = (gk0) mapArr[i].get("ImageWidth");
        gk0 gk0Var3 = (gk0) mapArr[i2].get("ImageLength");
        gk0 gk0Var4 = (gk0) mapArr[i2].get("ImageWidth");
        if (gk0Var == null || gk0Var2 == null || gk0Var3 == null || gk0Var4 == null) {
            return;
        }
        int iH = gk0Var.h(this.f);
        int iH2 = gk0Var2.h(this.f);
        int iH3 = gk0Var3.h(this.f);
        int iH4 = gk0Var4.h(this.f);
        if (iH >= iH3 || iH2 >= iH4) {
            return;
        }
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    public final void L(fk0 fk0Var, int i) throws Throwable {
        gk0 gk0VarE;
        gk0 gk0VarE2;
        HashMap[] mapArr = this.d;
        gk0 gk0Var = (gk0) mapArr[i].get("DefaultCropSize");
        gk0 gk0Var2 = (gk0) mapArr[i].get("SensorTopBorder");
        gk0 gk0Var3 = (gk0) mapArr[i].get("SensorLeftBorder");
        gk0 gk0Var4 = (gk0) mapArr[i].get("SensorBottomBorder");
        gk0 gk0Var5 = (gk0) mapArr[i].get("SensorRightBorder");
        if (gk0Var != null) {
            int i2 = gk0Var.a;
            ByteOrder byteOrder = this.f;
            if (i2 == 5) {
                ik0[] ik0VarArr = (ik0[]) gk0Var.j(byteOrder);
                if (ik0VarArr == null || ik0VarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(ik0VarArr));
                    return;
                } else {
                    gk0VarE = gk0.d(new ik0[]{ik0VarArr[0]}, this.f);
                    gk0VarE2 = gk0.d(new ik0[]{ik0VarArr[1]}, this.f);
                }
            } else {
                int[] iArr = (int[]) gk0Var.j(byteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                gk0VarE = gk0.e(iArr[0], this.f);
                gk0VarE2 = gk0.e(iArr[1], this.f);
            }
            mapArr[i].put("ImageWidth", gk0VarE);
            mapArr[i].put("ImageLength", gk0VarE2);
            return;
        }
        if (gk0Var2 != null && gk0Var3 != null && gk0Var4 != null && gk0Var5 != null) {
            int iH = gk0Var2.h(this.f);
            int iH2 = gk0Var4.h(this.f);
            int iH3 = gk0Var5.h(this.f);
            int iH4 = gk0Var3.h(this.f);
            if (iH2 <= iH || iH3 <= iH4) {
                return;
            }
            gk0 gk0VarE3 = gk0.e(iH2 - iH, this.f);
            gk0 gk0VarE4 = gk0.e(iH3 - iH4, this.f);
            mapArr[i].put("ImageLength", gk0VarE3);
            mapArr[i].put("ImageWidth", gk0VarE4);
            return;
        }
        gk0 gk0Var6 = (gk0) mapArr[i].get("ImageLength");
        gk0 gk0Var7 = (gk0) mapArr[i].get("ImageWidth");
        if (gk0Var6 == null || gk0Var7 == null) {
            gk0 gk0Var8 = (gk0) mapArr[i].get("JPEGInterchangeFormat");
            gk0 gk0Var9 = (gk0) mapArr[i].get("JPEGInterchangeFormatLength");
            if (gk0Var8 == null || gk0Var9 == null) {
                return;
            }
            int iH5 = gk0Var8.h(this.f);
            int iH6 = gk0Var8.h(this.f);
            fk0Var.c(iH5);
            byte[] bArr = new byte[iH6];
            fk0Var.read(bArr);
            m(new fk0(bArr), iH5, i);
        }
    }

    public final void M() throws Throwable {
        K(0, 5);
        K(0, 4);
        K(5, 4);
        HashMap[] mapArr = this.d;
        gk0 gk0Var = (gk0) mapArr[1].get("PixelXDimension");
        gk0 gk0Var2 = (gk0) mapArr[1].get("PixelYDimension");
        if (gk0Var != null && gk0Var2 != null) {
            mapArr[0].put("ImageWidth", gk0Var);
            mapArr[0].put("ImageLength", gk0Var2);
        }
        if (mapArr[4].isEmpty() && x(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        x(mapArr[4]);
    }

    public final void N(jo joVar) throws IOException {
        HashMap[] mapArr;
        int[] iArr;
        int i;
        hk0[][] hk0VarArr = R;
        int[] iArr2 = new int[hk0VarArr.length];
        int[] iArr3 = new int[hk0VarArr.length];
        hk0[] hk0VarArr2 = S;
        for (hk0 hk0Var : hk0VarArr2) {
            E(hk0Var.b);
        }
        hk0 hk0Var2 = T;
        String str = hk0Var2.b;
        String str2 = hk0Var2.b;
        E(str);
        hk0 hk0Var3 = U;
        E(hk0Var3.b);
        int i2 = 0;
        while (true) {
            int length = hk0VarArr.length;
            mapArr = this.d;
            if (i2 >= length) {
                break;
            }
            for (Object obj : mapArr[i2].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    mapArr[i2].remove(entry.getKey());
                }
            }
            i2++;
        }
        int i3 = 1;
        if (!mapArr[1].isEmpty()) {
            mapArr[0].put(hk0VarArr2[1].b, gk0.b(0L, this.f));
        }
        if (!mapArr[2].isEmpty()) {
            mapArr[0].put(hk0VarArr2[2].b, gk0.b(0L, this.f));
        }
        if (!mapArr[3].isEmpty()) {
            mapArr[1].put(hk0VarArr2[3].b, gk0.b(0L, this.f));
        }
        if (this.g) {
            mapArr[4].put(str2, gk0.b(0L, this.f));
            mapArr[4].put(hk0Var3.b, gk0.b(this.j, this.f));
        }
        int i4 = 0;
        while (true) {
            int length2 = hk0VarArr.length;
            iArr = O;
            if (i4 >= length2) {
                break;
            }
            Iterator it = mapArr[i4].entrySet().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                gk0 gk0Var = (gk0) ((Map.Entry) it.next()).getValue();
                gk0Var.getClass();
                int i6 = i3;
                int i7 = iArr[gk0Var.a] * gk0Var.b;
                if (i7 > 4) {
                    i5 += i7;
                }
                i3 = i6;
            }
            iArr3[i4] = iArr3[i4] + i5;
            i4++;
            i3 = i3;
        }
        int i8 = i3;
        int size = 8;
        for (int i9 = 0; i9 < hk0VarArr.length; i9++) {
            if (!mapArr[i9].isEmpty()) {
                iArr2[i9] = size;
                size += (mapArr[i9].size() * 12) + 6 + iArr3[i9];
            }
        }
        if (this.g) {
            i = 0;
            mapArr[4].put(str2, gk0.b(size, this.f));
            this.i = size;
            size += this.j;
        } else {
            i = 0;
        }
        if (this.c == 4) {
            size += 8;
        }
        if (r) {
            for (int i10 = i; i10 < hk0VarArr.length; i10++) {
                String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i10), Integer.valueOf(iArr2[i10]), Integer.valueOf(mapArr[i10].size()), Integer.valueOf(iArr3[i10]), Integer.valueOf(size));
            }
        }
        if (!mapArr[i8].isEmpty()) {
            mapArr[i].put(hk0VarArr2[i8].b, gk0.b(iArr2[i8], this.f));
        }
        if (!mapArr[r10].isEmpty()) {
            mapArr[i].put(hk0VarArr2[r10].b, gk0.b(iArr2[2], this.f));
        }
        if (!mapArr[r10].isEmpty()) {
            mapArr[i8].put(hk0VarArr2[r10].b, gk0.b(iArr2[3], this.f));
        }
        int i11 = this.c;
        if (i11 == 4) {
            joVar.j((short) size);
            joVar.write(a0);
        } else if (i11 == 13) {
            joVar.e(size);
            joVar.write(B);
        } else if (i11 == 14) {
            joVar.write(G);
            joVar.e(size);
        }
        joVar.j(this.f == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        joVar.c = this.f;
        joVar.j((short) 42);
        joVar.e(8);
        int i12 = i;
        while (i12 < hk0VarArr.length) {
            if (!mapArr[i12].isEmpty()) {
                joVar.j((short) mapArr[i12].size());
                int size2 = (mapArr[i12].size() * 12) + iArr2[i12] + 2 + 4;
                for (Map.Entry entry2 : mapArr[i12].entrySet()) {
                    int i13 = ((hk0) W[i12].get(entry2.getKey())).a;
                    gk0 gk0Var2 = (gk0) entry2.getValue();
                    gk0Var2.getClass();
                    int i14 = gk0Var2.b;
                    int i15 = gk0Var2.a;
                    int i16 = iArr[i15] * i14;
                    joVar.j((short) i13);
                    joVar.j((short) i15);
                    joVar.e(i14);
                    if (i16 > 4) {
                        joVar.e(size2);
                        size2 += i16;
                    } else {
                        joVar.write(gk0Var2.d);
                        if (i16 < 4) {
                            while (i16 < 4) {
                                joVar.c(i);
                                i16++;
                                i = 0;
                            }
                        }
                    }
                    i = 0;
                }
                if (i12 != 0 || mapArr[4].isEmpty()) {
                    joVar.e(0);
                } else {
                    joVar.e(iArr2[4]);
                }
                Iterator it2 = mapArr[i12].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((gk0) ((Map.Entry) it2.next()).getValue()).d;
                    if (bArr.length > 4) {
                        joVar.write(bArr, 0, bArr.length);
                    }
                }
            }
            i12++;
            i = 0;
        }
        if (this.g) {
            joVar.write(t());
        }
        if (this.c == 14 && size % 2 == i8) {
            joVar.c(0);
        }
        joVar.c = ByteOrder.BIG_ENDIAN;
    }

    public final void a() {
        String strI = i("DateTimeOriginal");
        HashMap[] mapArr = this.d;
        if (strI != null && i("DateTime") == null) {
            mapArr[0].put("DateTime", gk0.a(strI));
        }
        if (i("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", gk0.b(0L, this.f));
        }
        if (i("ImageLength") == null) {
            mapArr[0].put("ImageLength", gk0.b(0L, this.f));
        }
        if (i("Orientation") == null) {
            mapArr[0].put("Orientation", gk0.b(0L, this.f));
        }
        if (i("LightSource") == null) {
            mapArr[1].put("LightSource", gk0.b(0L, this.f));
        }
    }

    public final String i(String str) {
        if (str == null) {
            dk0.n("tag shouldn't be null");
            return null;
        }
        gk0 gk0VarK = k(str);
        if (gk0VarK != null) {
            int i = gk0VarK.a;
            if (!X.contains(str)) {
                return gk0VarK.i(this.f);
            }
            if (str.equals("GPSTimeStamp")) {
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i);
                    return null;
                }
                ik0[] ik0VarArr = (ik0[]) gk0VarK.j(this.f);
                if (ik0VarArr == null || ik0VarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(ik0VarArr));
                    return null;
                }
                ik0 ik0Var = ik0VarArr[0];
                Integer numValueOf = Integer.valueOf((int) (ik0Var.a / ik0Var.b));
                ik0 ik0Var2 = ik0VarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (ik0Var2.a / ik0Var2.b));
                ik0 ik0Var3 = ik0VarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (ik0Var3.a / ik0Var3.b)));
            }
            try {
                return Double.toString(gk0VarK.g(this.f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final int j(int i, String str) {
        gk0 gk0VarK = k(str);
        if (gk0VarK != null) {
            try {
                return gk0VarK.h(this.f);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public final gk0 k(String str) {
        if (str == null) {
            dk0.n("tag shouldn't be null");
            return null;
        }
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < R.length; i++) {
            gk0 gk0Var = (gk0) this.d[i].get(str);
            if (gk0Var != null) {
                return gk0Var;
            }
        }
        return null;
    }

    public final void l(fk0 fk0Var) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(new ek0(fk0Var));
            String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
            String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
            String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
            String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(strExtractMetadata6)) {
                strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(strExtractMetadata7)) {
                strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                strExtractMetadata = null;
                strExtractMetadata2 = null;
                strExtractMetadata3 = null;
            }
            HashMap[] mapArr = this.d;
            if (strExtractMetadata != null) {
                mapArr[0].put("ImageWidth", gk0.e(Integer.parseInt(strExtractMetadata), this.f));
            }
            if (strExtractMetadata2 != null) {
                mapArr[0].put("ImageLength", gk0.e(Integer.parseInt(strExtractMetadata2), this.f));
            }
            if (strExtractMetadata3 != null) {
                int i2 = Integer.parseInt(strExtractMetadata3);
                if (i2 == 90) {
                    i = 6;
                } else if (i2 != 180) {
                    i = i2 != 270 ? 1 : 8;
                } else {
                    i = 3;
                }
                mapArr[0].put("Orientation", gk0.e(i, this.f));
            }
            if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                int i3 = Integer.parseInt(strExtractMetadata4);
                int i4 = Integer.parseInt(strExtractMetadata5);
                if (i4 <= 6) {
                    throw new IOException("Invalid exif length");
                }
                fk0Var.c(i3);
                byte[] bArr = new byte[6];
                if (fk0Var.read(bArr) != 6) {
                    throw new IOException("Can't read identifier");
                }
                int i5 = i3 + 6;
                int i6 = i4 - 6;
                if (!Arrays.equals(bArr, a0)) {
                    throw new IOException("Invalid identifier");
                }
                byte[] bArr2 = new byte[i6];
                if (fk0Var.read(bArr2) != i6) {
                    throw new IOException("Can't read exif");
                }
                this.m = i5;
                C(bArr2, 0);
            }
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006f A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:99:0x009c A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void m(defpackage.fk0 r24, int r25, int r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jk0.m(fk0, int, int):void");
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0137 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x013a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0141  */
    /* JADX WARN: Code duplicated, block: B:115:0x014e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0155 A[LOOP:3: B:113:0x0149->B:118:0x0155, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:122:0x015f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0169 A[LOOP:4: B:120:0x015a->B:125:0x0169, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:128:0x016f A[LOOP:2: B:108:0x013c->B:128:0x016f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:145:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x0147 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0168 A[EDGE_INSN: B:160:0x0168->B:124:0x0168 BREAK  A[LOOP:3: B:113:0x0149->B:118:0x0155], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x016c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0168 A[EDGE_INSN: B:162:0x0168->B:124:0x0168 BREAK  A[LOOP:3: B:113:0x0149->B:118:0x0155], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x0104 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x011c  */
    public final int n(BufferedInputStream bufferedInputStream) throws Throwable {
        int i;
        fk0 fk0Var;
        fk0 fk0Var2;
        int i2;
        int i3;
        int i4;
        byte[] bArr;
        int i5;
        byte[] bArr2;
        int i6;
        byte[] bArr3;
        fk0 fk0Var3;
        short s2;
        long j;
        bufferedInputStream.mark(5000);
        byte[] bArr4 = new byte[5000];
        bufferedInputStream.read(bArr4);
        bufferedInputStream.reset();
        int i7 = 0;
        while (true) {
            byte[] bArr5 = u;
            if (i7 >= bArr5.length) {
                return 4;
            }
            if (bArr4[i7] != bArr5[i7]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i8 = 0; i8 < bytes.length; i8++) {
                    if (bArr4[i8] != bytes[i8]) {
                        fk0 fk0Var4 = null;
                        try {
                            try {
                                try {
                                    fk0Var = new fk0(bArr4);
                                    try {
                                        try {
                                            long j2 = fk0Var.readInt();
                                            byte[] bArr6 = new byte[4];
                                            fk0Var.read(bArr6);
                                            if (Arrays.equals(bArr6, v)) {
                                                if (j2 == 1) {
                                                    j2 = fk0Var.readLong();
                                                    j = 16;
                                                    if (j2 < 16) {
                                                    }
                                                } else {
                                                    j = 8;
                                                }
                                                if (j2 > 5000) {
                                                    j2 = 5000;
                                                }
                                                long j3 = j2 - j;
                                                if (j3 >= 8) {
                                                    byte[] bArr7 = new byte[4];
                                                    long j4 = 0;
                                                    boolean z2 = false;
                                                    boolean z3 = false;
                                                    while (true) {
                                                        if (j4 >= j3 / 4) {
                                                            i = 0;
                                                            break;
                                                        }
                                                        i = 0;
                                                        try {
                                                            if (fk0Var.read(bArr7) != 4) {
                                                                break;
                                                            }
                                                            if (j4 != 1) {
                                                                if (Arrays.equals(bArr7, w)) {
                                                                    z2 = true;
                                                                } else if (Arrays.equals(bArr7, x)) {
                                                                    z3 = true;
                                                                }
                                                                if (z2 && z3) {
                                                                    fk0Var.close();
                                                                    return 12;
                                                                }
                                                            }
                                                            j4++;
                                                        } catch (Exception unused) {
                                                            if (fk0Var != null) {
                                                                break;
                                                            }
                                                            fk0Var2 = new fk0(bArr4);
                                                            ByteOrder byteOrderB = B(fk0Var2);
                                                            this.f = byteOrderB;
                                                            fk0Var2.b = byteOrderB;
                                                            s2 = fk0Var2.readShort();
                                                            if (s2 != 20306) {
                                                                i2 = 1;
                                                            } else {
                                                                i2 = 1;
                                                            }
                                                            fk0Var2.close();
                                                            if (i2 != 0) {
                                                                return 7;
                                                            }
                                                            try {
                                                                fk0Var3 = new fk0(bArr4);
                                                                try {
                                                                    ByteOrder byteOrderB2 = B(fk0Var3);
                                                                    this.f = byteOrderB2;
                                                                    fk0Var3.b = byteOrderB2;
                                                                    i3 = fk0Var3.readShort() != 85 ? i : 1;
                                                                    fk0Var3.close();
                                                                } catch (Exception unused2) {
                                                                    fk0Var4 = fk0Var3;
                                                                    if (fk0Var4 != null) {
                                                                        fk0Var4.close();
                                                                    }
                                                                    i3 = i;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    fk0Var4 = fk0Var3;
                                                                    if (fk0Var4 != null) {
                                                                        fk0Var4.close();
                                                                    }
                                                                    throw th;
                                                                }
                                                            } catch (Exception unused3) {
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                            }
                                                            if (i3 != 0) {
                                                                return 10;
                                                            }
                                                            i4 = i;
                                                            while (true) {
                                                                bArr = A;
                                                                if (i4 >= bArr.length) {
                                                                    return 13;
                                                                }
                                                                if (bArr4[i4] != bArr[i4]) {
                                                                    i5 = i;
                                                                    while (true) {
                                                                        bArr2 = E;
                                                                        if (i5 >= bArr2.length) {
                                                                            i6 = i;
                                                                            while (true) {
                                                                                bArr3 = F;
                                                                                if (i6 >= bArr3.length) {
                                                                                    return 14;
                                                                                }
                                                                                if (bArr4[bArr2.length + i6 + 4] != bArr3[i6]) {
                                                                                    break;
                                                                                }
                                                                                i6++;
                                                                            }
                                                                        } else {
                                                                            if (bArr4[i5] != bArr2[i5]) {
                                                                                break;
                                                                            }
                                                                            i5++;
                                                                        }
                                                                    }
                                                                    return i;
                                                                }
                                                                i4++;
                                                            }
                                                        }
                                                    }
                                                    fk0Var.close();
                                                    fk0Var2 = new fk0(bArr4);
                                                    ByteOrder byteOrderB3 = B(fk0Var2);
                                                    this.f = byteOrderB3;
                                                    fk0Var2.b = byteOrderB3;
                                                    s2 = fk0Var2.readShort();
                                                    if (s2 != 20306 || s2 == 21330) {
                                                        i2 = 1;
                                                    } else {
                                                        i2 = i;
                                                    }
                                                    fk0Var2.close();
                                                    if (i2 != 0) {
                                                        return 7;
                                                    }
                                                    fk0Var3 = new fk0(bArr4);
                                                    ByteOrder byteOrderB4 = B(fk0Var3);
                                                    this.f = byteOrderB4;
                                                    fk0Var3.b = byteOrderB4;
                                                    if (fk0Var3.readShort() != 85) {
                                                    }
                                                    fk0Var3.close();
                                                    if (i3 != 0) {
                                                        return 10;
                                                    }
                                                    i4 = i;
                                                    while (true) {
                                                        bArr = A;
                                                        if (i4 >= bArr.length) {
                                                            return 13;
                                                        }
                                                        if (bArr4[i4] != bArr[i4]) {
                                                            i5 = i;
                                                            while (true) {
                                                                bArr2 = E;
                                                                if (i5 >= bArr2.length) {
                                                                    i6 = i;
                                                                    while (true) {
                                                                        bArr3 = F;
                                                                        if (i6 >= bArr3.length) {
                                                                            return 14;
                                                                        }
                                                                        if (bArr4[bArr2.length + i6 + 4] != bArr3[i6]) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i6++;
                                                                    }
                                                                } else {
                                                                    if (bArr4[i5] != bArr2[i5]) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    i5++;
                                                                }
                                                            }
                                                            return i;
                                                        }
                                                        i4++;
                                                    }
                                                }
                                            }
                                            fk0Var.close();
                                            i = 0;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            fk0Var4 = fk0Var;
                                            if (fk0Var4 != null) {
                                                fk0Var4.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception unused4) {
                                        i = 0;
                                    }
                                } catch (Exception unused5) {
                                    i = 0;
                                    fk0Var = null;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                                ByteOrder byteOrderB5 = B(fk0Var2);
                                this.f = byteOrderB5;
                                fk0Var2.b = byteOrderB5;
                                s2 = fk0Var2.readShort();
                                if (s2 != 20306) {
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                                fk0Var2.close();
                            } catch (Exception unused6) {
                                if (fk0Var2 != null) {
                                    fk0Var2.close();
                                }
                                i2 = i;
                            } catch (Throwable th5) {
                                th = th5;
                                fk0Var4 = fk0Var2;
                                if (fk0Var4 != null) {
                                    fk0Var4.close();
                                }
                                throw th;
                            }
                            fk0Var2 = new fk0(bArr4);
                        } catch (Exception unused7) {
                            fk0Var2 = null;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                        if (i2 != 0) {
                            return 7;
                        }
                        fk0Var3 = new fk0(bArr4);
                        ByteOrder byteOrderB6 = B(fk0Var3);
                        this.f = byteOrderB6;
                        fk0Var3.b = byteOrderB6;
                        if (fk0Var3.readShort() != 85) {
                        }
                        fk0Var3.close();
                        if (i3 != 0) {
                            return 10;
                        }
                        i4 = i;
                        while (true) {
                            bArr = A;
                            if (i4 >= bArr.length) {
                                return 13;
                            }
                            if (bArr4[i4] != bArr[i4]) {
                                i5 = i;
                                while (true) {
                                    bArr2 = E;
                                    if (i5 >= bArr2.length) {
                                        i6 = i;
                                        while (true) {
                                            bArr3 = F;
                                            if (i6 >= bArr3.length) {
                                                return 14;
                                            }
                                            if (bArr4[bArr2.length + i6 + 4] != bArr3[i6]) {
                                                break;
                                                break;
                                            }
                                            i6++;
                                        }
                                    } else {
                                        if (bArr4[i5] != bArr2[i5]) {
                                            break;
                                            break;
                                        }
                                        i5++;
                                    }
                                }
                                return i;
                            }
                            i4++;
                        }
                    }
                }
                return 9;
            }
            i7++;
        }
    }

    public final void o(fk0 fk0Var) throws Throwable {
        int i;
        int i2;
        r(fk0Var);
        HashMap[] mapArr = this.d;
        gk0 gk0Var = (gk0) mapArr[1].get("MakerNote");
        if (gk0Var != null) {
            fk0 fk0Var2 = new fk0(gk0Var.d);
            fk0Var2.b = this.f;
            byte[] bArr = y;
            byte[] bArr2 = new byte[bArr.length];
            fk0Var2.readFully(bArr2);
            fk0Var2.c(0L);
            byte[] bArr3 = z;
            byte[] bArr4 = new byte[bArr3.length];
            fk0Var2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fk0Var2.c(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fk0Var2.c(12L);
            }
            D(fk0Var2, 6);
            gk0 gk0Var2 = (gk0) mapArr[7].get("PreviewImageStart");
            gk0 gk0Var3 = (gk0) mapArr[7].get("PreviewImageLength");
            if (gk0Var2 != null && gk0Var3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", gk0Var2);
                mapArr[5].put("JPEGInterchangeFormatLength", gk0Var3);
            }
            gk0 gk0Var4 = (gk0) mapArr[8].get("AspectFrame");
            if (gk0Var4 != null) {
                int[] iArr = (int[]) gk0Var4.j(this.f);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                gk0 gk0VarE = gk0.e(i5, this.f);
                gk0 gk0VarE2 = gk0.e(i6, this.f);
                mapArr[0].put("ImageWidth", gk0VarE);
                mapArr[0].put("ImageLength", gk0VarE2);
            }
        }
    }

    public final void p(fk0 fk0Var) throws Throwable {
        if (r) {
            Objects.toString(fk0Var);
        }
        fk0Var.mark(0);
        fk0Var.b = ByteOrder.BIG_ENDIAN;
        byte[] bArr = A;
        fk0Var.skipBytes(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = fk0Var.readInt();
                byte[] bArr2 = new byte[4];
                if (fk0Var.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i2 = length + 8;
                if (i2 == 16 && !Arrays.equals(bArr2, C)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, D)) {
                    return;
                }
                if (Arrays.equals(bArr2, B)) {
                    byte[] bArr3 = new byte[i];
                    if (fk0Var.read(bArr3) != i) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + b(bArr2));
                    }
                    int i3 = fk0Var.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i3) {
                        this.m = i2;
                        C(bArr3, 0);
                        M();
                        J(new fk0(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i3 + ", calculated CRC value: " + crc32.getValue());
                }
                int i4 = i + 4;
                fk0Var.skipBytes(i4);
                length = i2 + i4;
            } catch (EOFException unused) {
                dk0.h("Encountered corrupt PNG file.");
                return;
            }
        }
    }

    public final void q(fk0 fk0Var) throws Throwable {
        if (r) {
            Objects.toString(fk0Var);
        }
        fk0Var.mark(0);
        fk0Var.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        fk0Var.read(bArr);
        fk0Var.read(bArr2);
        fk0Var.read(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        fk0Var.c(i);
        fk0Var.read(bArr4);
        m(new fk0(bArr4), i, 5);
        fk0Var.c(i3);
        fk0Var.b = ByteOrder.BIG_ENDIAN;
        int i4 = fk0Var.readInt();
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = fk0Var.readUnsignedShort();
            int unsignedShort2 = fk0Var.readUnsignedShort();
            if (unsignedShort == Q.a) {
                short s2 = fk0Var.readShort();
                short s3 = fk0Var.readShort();
                gk0 gk0VarE = gk0.e(s2, this.f);
                gk0 gk0VarE2 = gk0.e(s3, this.f);
                HashMap[] mapArr = this.d;
                mapArr[0].put("ImageLength", gk0VarE);
                mapArr[0].put("ImageWidth", gk0VarE2);
                return;
            }
            fk0Var.skipBytes(unsignedShort2);
        }
    }

    public final void r(fk0 fk0Var) throws Throwable {
        z(fk0Var, fk0Var.a.available());
        D(fk0Var, 0);
        L(fk0Var, 0);
        L(fk0Var, 5);
        L(fk0Var, 4);
        M();
        if (this.c == 8) {
            HashMap[] mapArr = this.d;
            gk0 gk0Var = (gk0) mapArr[1].get("MakerNote");
            if (gk0Var != null) {
                fk0 fk0Var2 = new fk0(gk0Var.d);
                fk0Var2.b = this.f;
                fk0Var2.c(6L);
                D(fk0Var2, 9);
                gk0 gk0Var2 = (gk0) mapArr[9].get("ColorSpace");
                if (gk0Var2 != null) {
                    mapArr[1].put("ColorSpace", gk0Var2);
                }
            }
        }
    }

    public final void s(fk0 fk0Var) throws Throwable {
        if (r) {
            Objects.toString(fk0Var);
        }
        r(fk0Var);
        HashMap[] mapArr = this.d;
        gk0 gk0Var = (gk0) mapArr[0].get("JpgFromRaw");
        if (gk0Var != null) {
            m(new fk0(gk0Var.d), (int) gk0Var.c, 5);
        }
        gk0 gk0Var2 = (gk0) mapArr[0].get("ISO");
        gk0 gk0Var3 = (gk0) mapArr[1].get("PhotographicSensitivity");
        if (gk0Var2 == null || gk0Var3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", gk0Var2);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final byte[] t() throws Throwable {
        FileDescriptor fileDescriptorDup;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (this.g) {
            byte[] bArr = this.k;
            if (bArr != null) {
                return bArr;
            }
            String str = this.a;
            try {
                if (str != null) {
                    fileInputStream = new FileInputStream(str);
                    fileDescriptorDup = null;
                } else {
                    fileDescriptorDup = Os.dup(this.b);
                    try {
                        Os.lseek(fileDescriptorDup, 0L, OsConstants.SEEK_SET);
                        fileInputStream = new FileInputStream(fileDescriptorDup);
                    } catch (Exception unused) {
                        fileInputStream = null;
                        c(fileInputStream);
                        if (fileDescriptorDup != null) {
                            try {
                                Os.close(fileDescriptorDup);
                            } catch (Exception unused2) {
                                Log.e("ExifInterface", "Error closing fd.");
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        c(fileInputStream2);
                        if (fileDescriptorDup != null) {
                            try {
                                Os.close(fileDescriptorDup);
                            } catch (Exception unused3) {
                                Log.e("ExifInterface", "Error closing fd.");
                            }
                        }
                        throw th;
                    }
                }
                try {
                    if (fileInputStream.skip(this.i + this.m) != this.i + this.m) {
                        throw new IOException("Corrupted image");
                    }
                    byte[] bArr2 = new byte[this.j];
                    if (fileInputStream.read(bArr2) != this.j) {
                        throw new IOException("Corrupted image");
                    }
                    this.k = bArr2;
                    c(fileInputStream);
                    if (fileDescriptorDup != null) {
                        try {
                            Os.close(fileDescriptorDup);
                            return bArr2;
                        } catch (Exception unused4) {
                            Log.e("ExifInterface", "Error closing fd.");
                        }
                    }
                    return bArr2;
                } catch (Exception unused5) {
                    c(fileInputStream);
                    if (fileDescriptorDup != null) {
                        Os.close(fileDescriptorDup);
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    c(fileInputStream2);
                    if (fileDescriptorDup != null) {
                        Os.close(fileDescriptorDup);
                    }
                    throw th;
                }
            } catch (Exception unused6) {
                fileDescriptorDup = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileDescriptorDup = null;
            }
        }
        return null;
    }

    public final void u(fk0 fk0Var) throws Throwable {
        if (r) {
            Objects.toString(fk0Var);
        }
        fk0Var.mark(0);
        fk0Var.b = ByteOrder.LITTLE_ENDIAN;
        fk0Var.skipBytes(E.length);
        int i = fk0Var.readInt() + 8;
        int iSkipBytes = fk0Var.skipBytes(F.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (fk0Var.read(bArr) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i2 = fk0Var.readInt();
                int i3 = iSkipBytes + 8;
                if (Arrays.equals(G, bArr)) {
                    byte[] bArr2 = new byte[i2];
                    if (fk0Var.read(bArr2) == i2) {
                        this.m = i3;
                        C(bArr2, 0);
                        J(new fk0(bArr2));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + b(bArr));
                    }
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                int i4 = i3 + i2;
                if (i4 == i) {
                    return;
                }
                if (i4 > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                int iSkipBytes2 = fk0Var.skipBytes(i2);
                if (iSkipBytes2 != i2) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                iSkipBytes = i3 + iSkipBytes2;
            } catch (EOFException unused) {
                dk0.h("Encountered corrupt WebP file.");
                return;
            }
        }
    }

    public final void w(fk0 fk0Var, HashMap map) throws Throwable {
        gk0 gk0Var = (gk0) map.get("JPEGInterchangeFormat");
        gk0 gk0Var2 = (gk0) map.get("JPEGInterchangeFormatLength");
        if (gk0Var == null || gk0Var2 == null) {
            return;
        }
        int iH = gk0Var.h(this.f);
        int iH2 = gk0Var2.h(this.f);
        if (this.c == 7) {
            iH += this.n;
        }
        int iMin = Math.min(iH2, fk0Var.c - iH);
        if (iH <= 0 || iMin <= 0) {
            return;
        }
        this.g = true;
        if (this.a == null && this.b == null) {
            byte[] bArr = new byte[iMin];
            fk0Var.skip(iH);
            fk0Var.read(bArr);
            this.k = bArr;
        }
        this.i = iH;
        this.j = iMin;
    }

    public final boolean x(HashMap map) {
        gk0 gk0Var = (gk0) map.get("ImageLength");
        gk0 gk0Var2 = (gk0) map.get("ImageWidth");
        if (gk0Var == null || gk0Var2 == null) {
            return false;
        }
        return gk0Var.h(this.f) <= 512 && gk0Var2.h(this.f) <= 512;
    }

    public final void y(InputStream inputStream) throws Throwable {
        boolean z2 = r;
        for (int i = 0; i < R.length; i++) {
            try {
                try {
                    this.d[i] = new HashMap();
                } catch (IOException e) {
                    if (z2) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                    }
                    a();
                    if (z2) {
                        A();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                a();
                if (z2) {
                    A();
                }
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.c = n(bufferedInputStream);
        fk0 fk0Var = new fk0(bufferedInputStream);
        switch (this.c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                r(fk0Var);
                break;
            case 4:
                m(fk0Var, 0, 0);
                a();
                if (z2) {
                    A();
                    return;
                }
                return;
            case 7:
                o(fk0Var);
                break;
            case 9:
                q(fk0Var);
                a();
                if (z2) {
                    A();
                    return;
                }
                return;
            case 10:
                s(fk0Var);
                a();
                if (z2) {
                    A();
                    return;
                }
                return;
            case 12:
                l(fk0Var);
                break;
            case 13:
                p(fk0Var);
                a();
                if (z2) {
                    A();
                    return;
                }
                return;
            case 14:
                u(fk0Var);
                a();
                if (z2) {
                    A();
                    return;
                }
                return;
        }
        fk0Var.c(this.m);
        J(fk0Var);
        a();
        if (z2) {
            A();
        }
    }

    public final void z(fk0 fk0Var, int i) throws IOException {
        ByteOrder byteOrderB = B(fk0Var);
        this.f = byteOrderB;
        fk0Var.b = byteOrderB;
        int unsignedShort = fk0Var.readUnsignedShort();
        int i2 = this.c;
        if (i2 != 7 && i2 != 10 && unsignedShort != 42) {
            dk0.g(Integer.toHexString(unsignedShort), "Invalid start code: ");
            return;
        }
        int i3 = fk0Var.readInt();
        if (i3 < 8 || i3 >= i) {
            dk0.h(ky0.h(i3, "Invalid first Ifd offset: "));
            return;
        }
        int i4 = i3 - 8;
        if (i4 <= 0 || fk0Var.skipBytes(i4) == i4) {
            return;
        }
        dk0.h(ky0.h(i4, "Couldn't jump to first Ifd: "));
    }

    public jk0(ByteArrayInputStream byteArrayInputStream) throws Throwable {
        hk0[][] hk0VarArr = R;
        this.d = new HashMap[hk0VarArr.length];
        this.e = new HashSet(hk0VarArr.length);
        this.f = ByteOrder.BIG_ENDIAN;
        this.a = null;
        this.b = null;
        y(byteArrayInputStream);
    }
}
