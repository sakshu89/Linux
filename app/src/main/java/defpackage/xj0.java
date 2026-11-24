package defpackage;

import android.system.Os;
import android.system.OsConstants;
import com.ibm.icu.lang.UCharacter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xj0 {
    public static final oc b = new oc(2);
    public static final oc c = new oc(3);
    public static final oc d = new oc(4);
    public static final List e = Arrays.asList("ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation", "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType");
    public static final List f = Arrays.asList("ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation");
    public final jk0 a;

    public xj0(jk0 jk0Var) {
        this.a = jk0Var;
    }

    public final int a() {
        switch (this.a.j(0, "Orientation")) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return UCharacter.UnicodeBlock.NEWA_ID;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public final void b(int i) {
        int i2 = i % 90;
        jk0 jk0Var = this.a;
        if (i2 != 0) {
            Locale locale = Locale.US;
            xq4.d("xj0", "Can only rotate in right angles (eg. 0, 90, 180, 270). " + i + " is unsupported.");
            jk0Var.I("Orientation", String.valueOf(0));
            return;
        }
        int i3 = i % 360;
        int iJ = jk0Var.j(0, "Orientation");
        while (i3 < 0) {
            i3 += 90;
            switch (iJ) {
                case 2:
                    iJ = 5;
                    break;
                case 3:
                case 8:
                    iJ = 6;
                    break;
                case 4:
                    iJ = 7;
                    break;
                case 5:
                    iJ = 4;
                    break;
                case 6:
                    iJ = 1;
                    break;
                case 7:
                    iJ = 2;
                    break;
                default:
                    iJ = 8;
                    break;
            }
        }
        while (i3 > 0) {
            i3 -= 90;
            switch (iJ) {
                case 2:
                    iJ = 7;
                    break;
                case 3:
                    iJ = 8;
                    break;
                case 4:
                    iJ = 5;
                    break;
                case 5:
                    iJ = 2;
                    break;
                case 6:
                    iJ = 3;
                    break;
                case 7:
                    iJ = 4;
                    break;
                case 8:
                    iJ = 1;
                    break;
                default:
                    iJ = 6;
                    break;
            }
        }
        jk0Var.I("Orientation", String.valueOf(iJ));
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0114 A[Catch: all -> 0x0124, Exception -> 0x0127, TryCatch #19 {Exception -> 0x0127, all -> 0x0124, blocks: (B:72:0x0110, B:74:0x0114, B:81:0x0132, B:80:0x012a), top: B:124:0x0110 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x012a A[Catch: all -> 0x0124, Exception -> 0x0127, TryCatch #19 {Exception -> 0x0127, all -> 0x0124, blocks: (B:72:0x0110, B:74:0x0114, B:81:0x0132, B:80:0x012a), top: B:124:0x0110 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x016c  */
    public final void c() throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream3;
        Object obj;
        long jCurrentTimeMillis = System.currentTimeMillis();
        oc ocVar = d;
        String str = ((SimpleDateFormat) ocVar.get()).format(new Date(jCurrentTimeMillis));
        jk0 jk0Var = this.a;
        jk0Var.I("DateTime", str);
        try {
            jk0Var.I("SubSecTime", Long.toString(jCurrentTimeMillis - ((SimpleDateFormat) ocVar.get()).parse(str).getTime()));
        } catch (ParseException unused) {
        }
        int i = jk0Var.c;
        if (i != 4 && i != 13 && i != 14) {
            dk0.h("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
            return;
        }
        if (jk0Var.b == null && jk0Var.a == null) {
            dk0.h("ExifInterface does not support saving attributes for the current input.");
            return;
        }
        int i2 = jk0Var.l;
        Closeable closeable = null;
        jk0Var.k = (i2 == 6 || i2 == 7) ? jk0Var.t() : null;
        try {
            File fileCreateTempFile = File.createTempFile("temp", "tmp");
            if (jk0Var.a != null) {
                fileInputStream = new FileInputStream(jk0Var.a);
            } else {
                Os.lseek(jk0Var.b, 0L, OsConstants.SEEK_SET);
                fileInputStream = new FileInputStream(jk0Var.b);
            }
            try {
                fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    jk0.g(fileInputStream, fileOutputStream);
                    jk0.c(fileInputStream);
                    jk0.c(fileOutputStream);
                    try {
                        try {
                            try {
                                FileInputStream fileInputStream3 = new FileInputStream(fileCreateTempFile);
                                try {
                                    if (jk0Var.a != null) {
                                        fileOutputStream2 = new FileOutputStream(jk0Var.a);
                                    } else {
                                        Os.lseek(jk0Var.b, 0L, OsConstants.SEEK_SET);
                                        fileOutputStream2 = new FileOutputStream(jk0Var.b);
                                    }
                                    try {
                                        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream3);
                                        try {
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                                            try {
                                                int i3 = jk0Var.c;
                                                if (i3 == 4) {
                                                    jk0Var.F(bufferedInputStream, bufferedOutputStream);
                                                } else if (i3 == 13) {
                                                    jk0Var.G(bufferedInputStream, bufferedOutputStream);
                                                } else if (i3 == 14) {
                                                    jk0Var.H(bufferedInputStream, bufferedOutputStream);
                                                }
                                                jk0.c(bufferedInputStream);
                                                jk0.c(bufferedOutputStream);
                                                fileCreateTempFile.delete();
                                                jk0Var.k = null;
                                            } catch (Exception e2) {
                                                e = e2;
                                                closeable = fileInputStream3;
                                                try {
                                                    try {
                                                        fileInputStream2 = new FileInputStream(fileCreateTempFile);
                                                        try {
                                                            if (jk0Var.a == null) {
                                                                Os.lseek(jk0Var.b, 0L, OsConstants.SEEK_SET);
                                                                fileOutputStream3 = new FileOutputStream(jk0Var.b);
                                                            } else {
                                                                fileOutputStream3 = new FileOutputStream(jk0Var.a);
                                                            }
                                                            fileOutputStream2 = fileOutputStream3;
                                                            jk0.g(fileInputStream2, fileOutputStream2);
                                                            jk0.c(fileInputStream2);
                                                            jk0.c(fileOutputStream2);
                                                            throw new IOException("Failed to save new file", e);
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            closeable = fileInputStream2;
                                                            throw new IOException("Failed to save new file. Original file is stored in " + fileCreateTempFile.getAbsolutePath(), e);
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            closeable = fileInputStream2;
                                                            jk0.c(closeable);
                                                            jk0.c(fileOutputStream2);
                                                            throw th;
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                }
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            closeable = bufferedInputStream;
                                            jk0.c(closeable);
                                            jk0.c(0);
                                            if (0 == 0) {
                                                fileCreateTempFile.delete();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        obj = null;
                                        closeable = fileInputStream3;
                                        fileInputStream2 = new FileInputStream(fileCreateTempFile);
                                        if (jk0Var.a == null) {
                                            Os.lseek(jk0Var.b, 0L, OsConstants.SEEK_SET);
                                            fileOutputStream3 = new FileOutputStream(jk0Var.b);
                                        } else {
                                            fileOutputStream3 = new FileOutputStream(jk0Var.a);
                                        }
                                        fileOutputStream2 = fileOutputStream3;
                                        jk0.g(fileInputStream2, fileOutputStream2);
                                        jk0.c(fileInputStream2);
                                        jk0.c(fileOutputStream2);
                                        throw new IOException("Failed to save new file", e);
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    fileOutputStream2 = null;
                                    obj = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            jk0.c(closeable);
                            jk0.c(0);
                            if (0 == 0) {
                                fileCreateTempFile.delete();
                            }
                            throw th;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        fileOutputStream2 = null;
                    }
                } catch (Exception e9) {
                    e = e9;
                    closeable = fileInputStream;
                    try {
                        throw new IOException("Failed to copy original file to temp file", e);
                    } catch (Throwable th6) {
                        th = th6;
                        jk0.c(closeable);
                        jk0.c(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    closeable = fileInputStream;
                    jk0.c(closeable);
                    jk0.c(fileOutputStream);
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } catch (Exception e11) {
            e = e11;
            fileOutputStream = null;
        } catch (Throwable th9) {
            th = th9;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:108:0x01f6 A[Catch: NumberFormatException -> 0x01fd, TRY_LEAVE, TryCatch #2 {NumberFormatException -> 0x01fd, blocks: (B:105:0x01ec, B:108:0x01f6), top: B:124:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:111:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:124:0x01ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:54:0x0115 A[Catch: ParseException -> 0x010e, TRY_ENTER, TryCatch #5 {ParseException -> 0x010e, blocks: (B:54:0x0115, B:57:0x012a), top: B:130:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0128 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x012a A[Catch: ParseException -> 0x010e, TRY_LEAVE, TryCatch #5 {ParseException -> 0x010e, blocks: (B:54:0x0115, B:57:0x012a), top: B:130:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x013b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0153  */
    /* JADX WARN: Code duplicated, block: B:63:0x0159 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x015b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0160  */
    /* JADX WARN: Code duplicated, block: B:69:0x0179  */
    /* JADX WARN: Code duplicated, block: B:72:0x0180  */
    /* JADX WARN: Code duplicated, block: B:74:0x018d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0191  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:87:0x01af  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:99:0x01dd  */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ac, code lost:
    
        if (r3.equals(com.ibm.icu.text.DateFormat.NUM_MONTH) != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xj0.toString():java.lang.String");
    }
}
