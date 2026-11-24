package com.ibm.icu.text;

import com.ibm.icu.impl.UBiDiProps;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.awt.font.NumericShaper;
import java.awt.font.TextAttribute;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Bidi {
    static final byte AL = 13;
    static final byte AN = 5;
    static final byte B = 7;
    static final byte BN = 18;

    @Deprecated
    public static final int CLASS_DEFAULT = 23;
    private static final char CR = '\r';
    static final byte CS = 6;
    public static final int DIRECTION_DEFAULT_LEFT_TO_RIGHT = 126;
    public static final int DIRECTION_DEFAULT_RIGHT_TO_LEFT = 127;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    public static final short DO_MIRRORING = 2;
    static final byte EN = 2;
    static final byte ENL = 23;
    static final byte ENR = 24;
    static final byte ES = 3;
    static final byte ET = 4;
    static final int FIRSTALLOC = 10;
    static final byte FSI = 19;
    private static final int IMPTABLEVELS_COLUMNS = 8;
    private static final int IMPTABLEVELS_RES = 7;
    private static final int IMPTABPROPS_COLUMNS = 16;
    private static final int IMPTABPROPS_RES = 15;
    public static final short INSERT_LRM_FOR_NUMERIC = 4;
    static final short INTERNAL_RUNS_ONLY = 64;
    static final int ISOLATE = 256;
    public static final short KEEP_BASE_COMBINING = 1;
    static final byte L = 0;
    public static final byte LEVEL_DEFAULT_LTR = 126;
    public static final byte LEVEL_DEFAULT_RTL = 127;
    public static final byte LEVEL_OVERRIDE = -128;
    private static final char LF = '\n';
    static final int LOOKING_FOR_PDI = 3;
    static final byte LRE = 11;
    static final byte LRI = 20;
    static final int LRM_AFTER = 2;
    static final int LRM_BEFORE = 1;
    static final byte LRO = 12;
    public static final byte LTR = 0;
    public static final int MAP_NOWHERE = -1;
    static final int MASK_BN_EXPLICIT;
    static final int MASK_B_S;
    static final int MASK_EMBEDDING;
    static final int MASK_EXPLICIT;
    static final int MASK_ISO;
    static final int MASK_POSSIBLE_N;
    static final int MASK_WS;
    public static final byte MAX_EXPLICIT_LEVEL = 125;
    public static final byte MIXED = 2;
    public static final byte NEUTRAL = 3;
    static final int NOT_SEEKING_STRONG = 0;
    static final byte NSM = 17;
    static final byte ON = 10;
    public static final int OPTION_DEFAULT = 0;
    public static final int OPTION_INSERT_MARKS = 1;
    public static final int OPTION_REMOVE_CONTROLS = 2;
    public static final int OPTION_STREAMING = 4;
    public static final short OUTPUT_REVERSE = 16;
    static final byte PDF = 16;
    static final byte PDI = 22;
    static final byte R = 1;
    public static final short REMOVE_BIDI_CONTROLS = 8;
    static final short REORDER_COUNT = 7;
    public static final short REORDER_DEFAULT = 0;
    public static final short REORDER_GROUP_NUMBERS_WITH_R = 2;
    public static final short REORDER_INVERSE_FOR_NUMBERS_SPECIAL = 6;
    public static final short REORDER_INVERSE_LIKE_DIRECT = 5;
    public static final short REORDER_INVERSE_NUMBERS_AS_L = 4;
    static final short REORDER_LAST_LOGICAL_TO_VISUAL = 1;
    public static final short REORDER_NUMBERS_SPECIAL = 1;
    public static final short REORDER_RUNS_ONLY = 3;
    static final byte RLE = 14;
    static final byte RLI = 21;
    static final int RLM_AFTER = 8;
    static final int RLM_BEFORE = 4;
    static final byte RLO = 15;
    public static final byte RTL = 1;
    static final byte S = 8;
    static final int SEEKING_STRONG_FOR_FSI = 2;
    static final int SEEKING_STRONG_FOR_PARA = 1;
    static final int SIMPLE_OPENINGS_COUNT = 20;
    static final int SIMPLE_PARAS_COUNT = 10;
    static final byte WS = 9;
    private static final short _AN = 3;
    private static final short _B = 6;
    private static final short _EN = 2;
    private static final short _L = 0;
    private static final short _ON = 4;
    private static final short _R = 1;
    private static final short _S = 5;
    private static final short[] groupProp;
    private static final short[] impAct0;
    private static final short[] impAct1;
    private static final short[] impAct2;
    private static final short[] impAct3;
    private static final byte[][] impTabL_DEFAULT;
    private static final byte[][] impTabL_GROUP_NUMBERS_WITH_R;
    private static final byte[][] impTabL_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS;
    private static final byte[][] impTabL_INVERSE_LIKE_DIRECT_WITH_MARKS;
    private static final byte[][] impTabL_INVERSE_NUMBERS_AS_L;
    private static final byte[][] impTabL_NUMBERS_SPECIAL;
    private static final short[][] impTabProps;
    private static final byte[][] impTabR_DEFAULT;
    private static final byte[][] impTabR_GROUP_NUMBERS_WITH_R;
    private static final byte[][] impTabR_INVERSE_LIKE_DIRECT;
    private static final byte[][] impTabR_INVERSE_LIKE_DIRECT_WITH_MARKS;
    private static final byte[][] impTabR_INVERSE_NUMBERS_AS_L;
    private static final ImpTabPair impTab_DEFAULT;
    private static final ImpTabPair impTab_GROUP_NUMBERS_WITH_R;
    private static final ImpTabPair impTab_INVERSE_FOR_NUMBERS_SPECIAL;
    private static final ImpTabPair impTab_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS;
    private static final ImpTabPair impTab_INVERSE_LIKE_DIRECT;
    private static final ImpTabPair impTab_INVERSE_LIKE_DIRECT_WITH_MARKS;
    private static final ImpTabPair impTab_INVERSE_NUMBERS_AS_L;
    private static final ImpTabPair impTab_NUMBERS_SPECIAL;
    final UBiDiProps bdp;
    int controlCount;
    BidiClassifier customClassifier;
    byte defaultParaLevel;
    byte[] dirProps;
    byte[] dirPropsMemory;
    byte direction;
    String epilogue;
    int flags;
    ImpTabPair impTabPair;
    InsertPoints insertPoints;
    boolean isGoodLogicalToVisualRunsMap;
    boolean isInverse;
    int isolateCount;
    Isolate[] isolates;
    int lastArabicPos;
    int length;
    byte[] levels;
    byte[] levelsMemory;
    int[] logicalToVisualRunsMap;
    boolean mayAllocateRuns;
    boolean mayAllocateText;
    boolean orderParagraphsLTR;
    int originalLength;
    Bidi paraBidi;
    int paraCount;
    byte paraLevel;
    byte[] paras_level;
    int[] paras_limit;
    String prologue;
    int reorderingMode;
    int reorderingOptions;
    int resultLength;
    int runCount;
    BidiRun[] runs;
    BidiRun[] runsMemory;
    BidiRun[] simpleRuns;
    char[] text;
    int trailingWSStart;
    static final byte FOUND_L = (byte) DirPropFlag((byte) 0);
    static final byte FOUND_R = (byte) DirPropFlag((byte) 1);
    static final int DirPropFlagMultiRuns = DirPropFlag((byte) 31);
    static final int[] DirPropFlagLR = {DirPropFlag((byte) 0), DirPropFlag((byte) 1)};
    static final int[] DirPropFlagE = {DirPropFlag((byte) 11), DirPropFlag((byte) 14)};
    static final int[] DirPropFlagO = {DirPropFlag((byte) 12), DirPropFlag((byte) 15)};
    static final int MASK_LTR = ((((((DirPropFlag((byte) 0) | DirPropFlag((byte) 2)) | DirPropFlag((byte) 23)) | DirPropFlag((byte) 24)) | DirPropFlag((byte) 5)) | DirPropFlag((byte) 11)) | DirPropFlag((byte) 12)) | DirPropFlag((byte) 20);
    static final int MASK_RTL = (((DirPropFlag((byte) 1) | DirPropFlag((byte) 13)) | DirPropFlag((byte) 14)) | DirPropFlag((byte) 15)) | DirPropFlag((byte) 21);
    static final int MASK_R_AL = DirPropFlag((byte) 1) | DirPropFlag((byte) 13);
    static final int MASK_STRONG_EN_AN = (((DirPropFlag((byte) 0) | DirPropFlag((byte) 1)) | DirPropFlag((byte) 13)) | DirPropFlag((byte) 2)) | DirPropFlag((byte) 5);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class BracketData {
        boolean isNumbersSpecial;
        int isoRunLast;
        Opening[] openings = new Opening[20];
        IsoRun[] isoRuns = new IsoRun[127];
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ImpTabPair {
        short[][] impact;
        byte[][][] imptab;

        public ImpTabPair(byte[][] bArr, byte[][] bArr2, short[] sArr, short[] sArr2) {
            this.imptab = new byte[][][]{bArr, bArr2};
            this.impact = new short[][]{sArr, sArr2};
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class InsertPoints {
        int confirmed;
        Point[] points = new Point[0];
        int size;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class IsoRun {
        byte contextDir;
        int contextPos;
        byte lastBase;
        byte lastStrong;
        byte level;
        short limit;
        short start;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Isolate {
        int start1;
        int startON;
        short state;
        short stateImp;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Opening {
        byte contextDir;
        int contextPos;
        short flags;
        int match;
        int position;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Point {
        int flag;
        int pos;
    }

    static {
        int iDirPropFlag = DirPropFlag((byte) 11) | DirPropFlag((byte) 12) | DirPropFlag((byte) 14) | DirPropFlag((byte) 15) | DirPropFlag((byte) 16);
        MASK_EXPLICIT = iDirPropFlag;
        int iDirPropFlag2 = iDirPropFlag | DirPropFlag((byte) 18);
        MASK_BN_EXPLICIT = iDirPropFlag2;
        int iDirPropFlag3 = DirPropFlag((byte) 20) | DirPropFlag((byte) 21) | DirPropFlag((byte) 19) | DirPropFlag((byte) 22);
        MASK_ISO = iDirPropFlag3;
        int iDirPropFlag4 = DirPropFlag((byte) 7) | DirPropFlag((byte) 8);
        MASK_B_S = iDirPropFlag4;
        int iDirPropFlag5 = iDirPropFlag2 | iDirPropFlag4 | DirPropFlag((byte) 9) | iDirPropFlag3;
        MASK_WS = iDirPropFlag5;
        int iDirPropFlag6 = iDirPropFlag5 | DirPropFlag((byte) 10) | DirPropFlag((byte) 6) | DirPropFlag((byte) 3) | DirPropFlag((byte) 4);
        MASK_POSSIBLE_N = iDirPropFlag6;
        MASK_EMBEDDING = iDirPropFlag6 | DirPropFlag((byte) 17);
        groupProp = new short[]{0, 1, 2, REORDER_COUNT, 8, 3, 9, 6, 5, 4, 4, 10, 10, 12, 10, 10, 10, 11, 10, 4, 4, 4, 4, 13, 14};
        impTabProps = new short[][]{new short[]{1, 2, 4, 5, REORDER_COUNT, 15, 17, REORDER_COUNT, 9, REORDER_COUNT, 0, REORDER_COUNT, 3, 18, 21, 4}, new short[]{1, 34, 36, 37, 39, 47, 49, 39, 41, 39, 1, 1, 35, 50, 53, 0}, new short[]{33, 2, 36, 37, 39, 47, 49, 39, 41, 39, 2, 2, 35, 50, 53, 1}, new short[]{33, 34, 38, 38, 40, 48, 49, 40, 40, 40, 3, 3, 3, 50, 53, 1}, new short[]{33, 34, 4, 37, 39, 47, 49, 74, 11, 74, 4, 4, 35, 18, 21, 2}, new short[]{33, 34, 36, 5, 39, 47, 49, 39, 41, 76, 5, 5, 35, 50, 53, 3}, new short[]{33, 34, 6, 6, 40, 48, 49, 40, 40, 77, 6, 6, 35, 18, 21, 3}, new short[]{33, 34, 36, 37, REORDER_COUNT, 47, 49, REORDER_COUNT, 78, REORDER_COUNT, REORDER_COUNT, REORDER_COUNT, 35, 50, 53, 4}, new short[]{33, 34, 38, 38, 8, 48, 49, 8, 8, 8, 8, 8, 35, 50, 53, 4}, new short[]{33, 34, 4, 37, REORDER_COUNT, 47, 49, REORDER_COUNT, 9, REORDER_COUNT, 9, 9, 35, 18, 21, 4}, new short[]{97, 98, 4, 101, 135, 111, 113, 135, 142, 135, 10, 135, 99, 18, 21, 2}, new short[]{33, 34, 4, 37, 39, 47, 49, 39, 11, 39, 11, 11, 35, 18, 21, 2}, new short[]{97, 98, 100, 5, 135, 111, 113, 135, 142, 135, 12, 135, 99, 114, 117, 3}, new short[]{97, 98, 6, 6, 136, 112, 113, 136, 136, 136, 13, 136, 99, 18, 21, 3}, new short[]{33, 34, 132, 37, REORDER_COUNT, 47, 49, REORDER_COUNT, 14, REORDER_COUNT, 14, 14, 35, 146, 149, 4}, new short[]{33, 34, 36, 37, 39, 15, 49, 39, 41, 39, 15, 39, 35, 50, 53, 5}, new short[]{33, 34, 38, 38, 40, 16, 49, 40, 40, 40, 16, 40, 35, 50, 53, 5}, new short[]{33, 34, 36, 37, 39, 47, 17, 39, 41, 39, 17, 39, 35, 50, 53, 6}, new short[]{33, 34, 18, 37, 39, 47, 49, 83, 20, 83, 18, 18, 35, 18, 21, 0}, new short[]{97, 98, 18, 101, 135, 111, 113, 135, 142, 135, 19, 135, 99, 18, 21, 0}, new short[]{33, 34, 18, 37, 39, 47, 49, 39, 20, 39, 20, 20, 35, 18, 21, 0}, new short[]{33, 34, 21, 37, 39, 47, 49, 86, 23, 86, 21, 21, 35, 18, 21, 3}, new short[]{97, 98, 21, 101, 135, 111, 113, 135, 142, 135, 22, 135, 99, 18, 21, 3}, new short[]{33, 34, 21, 37, 39, 47, 49, 39, 23, 39, 23, 23, 35, 18, 21, 3}};
        byte[][] bArr = {new byte[]{0, 1, 0, 2, 0, 0, 0, 0}, new byte[]{0, 1, 3, 3, 20, 20, 0, 1}, new byte[]{0, 1, 0, 2, 21, 21, 0, 2}, new byte[]{0, 1, 3, 3, 20, 20, 0, 2}, new byte[]{0, 33, 51, 51, 4, 4, 0, 0}, new byte[]{0, 33, 0, 50, 5, 5, 0, 0}};
        impTabL_DEFAULT = bArr;
        byte[][] bArr2 = {new byte[]{1, 0, 2, 2, 0, 0, 0, 0}, new byte[]{1, 0, 1, 3, 20, 20, 0, 1}, new byte[]{1, 0, 2, 2, 0, 0, 0, 1}, new byte[]{1, 0, 1, 3, 5, 5, 0, 1}, new byte[]{33, 0, 33, 3, 4, 4, 0, 0}, new byte[]{1, 0, 1, 3, 5, 5, 0, 0}};
        impTabR_DEFAULT = bArr2;
        short[] sArr = {0, 1, 2, 3, 4};
        impAct0 = sArr;
        impTab_DEFAULT = new ImpTabPair(bArr, bArr2, sArr, sArr);
        byte[][] bArr3 = {new byte[]{0, 2, 17, 17, 0, 0, 0, 0}, new byte[]{0, 66, 1, 1, 0, 0, 0, 0}, new byte[]{0, 2, 4, 4, 19, 19, 0, 1}, new byte[]{0, 34, 52, 52, 3, 3, 0, 0}, new byte[]{0, 2, 4, 4, 19, 19, 0, 2}};
        impTabL_NUMBERS_SPECIAL = bArr3;
        impTab_NUMBERS_SPECIAL = new ImpTabPair(bArr3, bArr2, sArr, sArr);
        byte[][] bArr4 = {new byte[]{0, 3, 17, 17, 0, 0, 0, 0}, new byte[]{32, 3, 1, 1, 2, 32, 32, 2}, new byte[]{32, 3, 1, 1, 2, 32, 32, 1}, new byte[]{0, 3, 5, 5, 20, 0, 0, 1}, new byte[]{32, 3, 5, 5, 4, 32, 32, 1}, new byte[]{0, 3, 5, 5, 20, 0, 0, 2}};
        impTabL_GROUP_NUMBERS_WITH_R = bArr4;
        byte[][] bArr5 = {new byte[]{2, 0, 1, 1, 0, 0, 0, 0}, new byte[]{2, 0, 1, 1, 0, 0, 0, 1}, new byte[]{2, 0, 20, 20, 19, 0, 0, 1}, new byte[]{34, 0, 4, 4, 3, 0, 0, 0}, new byte[]{34, 0, 4, 4, 3, 0, 0, 1}};
        impTabR_GROUP_NUMBERS_WITH_R = bArr5;
        impTab_GROUP_NUMBERS_WITH_R = new ImpTabPair(bArr4, bArr5, sArr, sArr);
        byte[][] bArr6 = {new byte[]{0, 1, 0, 0, 0, 0, 0, 0}, new byte[]{0, 1, 0, 0, 20, 20, 0, 1}, new byte[]{0, 1, 0, 0, 21, 21, 0, 2}, new byte[]{0, 1, 0, 0, 20, 20, 0, 2}, new byte[]{32, 1, 32, 32, 4, 4, 32, 1}, new byte[]{32, 1, 32, 32, 5, 5, 32, 1}};
        impTabL_INVERSE_NUMBERS_AS_L = bArr6;
        byte[][] bArr7 = {new byte[]{1, 0, 1, 1, 0, 0, 0, 0}, new byte[]{1, 0, 1, 1, 20, 20, 0, 1}, new byte[]{1, 0, 1, 1, 0, 0, 0, 1}, new byte[]{1, 0, 1, 1, 5, 5, 0, 1}, new byte[]{33, 0, 33, 33, 4, 4, 0, 0}, new byte[]{1, 0, 1, 1, 5, 5, 0, 0}};
        impTabR_INVERSE_NUMBERS_AS_L = bArr7;
        impTab_INVERSE_NUMBERS_AS_L = new ImpTabPair(bArr6, bArr7, sArr, sArr);
        byte[][] bArr8 = {new byte[]{1, 0, 2, 2, 0, 0, 0, 0}, new byte[]{1, 0, 1, 2, 19, 19, 0, 1}, new byte[]{1, 0, 2, 2, 0, 0, 0, 1}, new byte[]{33, 48, 6, 4, 3, 3, 48, 0}, new byte[]{33, 48, 6, 4, 5, 5, 48, 3}, new byte[]{33, 48, 6, 4, 5, 5, 48, 2}, new byte[]{33, 48, 6, 4, 3, 3, 48, 1}};
        impTabR_INVERSE_LIKE_DIRECT = bArr8;
        short[] sArr2 = {0, 1, 13, 14};
        impAct1 = sArr2;
        impTab_INVERSE_LIKE_DIRECT = new ImpTabPair(bArr, bArr8, sArr, sArr2);
        byte[][] bArr9 = {new byte[]{0, 99, 0, 1, 0, 0, 0, 0}, new byte[]{0, 99, 0, 1, 18, 48, 0, 4}, new byte[]{32, 99, 32, 1, 2, 48, 32, 3}, new byte[]{0, 99, 85, 86, 20, 48, 0, 3}, new byte[]{48, 67, 85, 86, 4, 48, 48, 3}, new byte[]{48, 67, 5, 86, 20, 48, 48, 4}, new byte[]{48, 67, 85, 6, 20, 48, 48, 4}};
        impTabL_INVERSE_LIKE_DIRECT_WITH_MARKS = bArr9;
        byte[][] bArr10 = {new byte[]{19, 0, 1, 1, 0, 0, 0, 0}, new byte[]{35, 0, 1, 1, 2, 64, 0, 1}, new byte[]{35, 0, 1, 1, 2, 64, 0, 0}, new byte[]{3, 0, 3, 54, 20, 64, 0, 1}, new byte[]{83, 64, 5, 54, 4, 64, 64, 0}, new byte[]{83, 64, 5, 54, 4, 64, 64, 1}, new byte[]{83, 64, 6, 6, 4, 64, 64, 3}};
        impTabR_INVERSE_LIKE_DIRECT_WITH_MARKS = bArr10;
        short[] sArr3 = {0, 1, 2, 5, 6, REORDER_COUNT, 8};
        impAct2 = sArr3;
        short[] sArr4 = {0, 1, 9, 10, 11, 12};
        impAct3 = sArr4;
        impTab_INVERSE_LIKE_DIRECT_WITH_MARKS = new ImpTabPair(bArr9, bArr10, sArr3, sArr4);
        impTab_INVERSE_FOR_NUMBERS_SPECIAL = new ImpTabPair(bArr3, bArr8, sArr, sArr2);
        byte[][] bArr11 = {new byte[]{0, 98, 1, 1, 0, 0, 0, 0}, new byte[]{0, 98, 1, 1, 0, 48, 0, 4}, new byte[]{0, 98, 84, 84, 19, 48, 0, 3}, new byte[]{48, 66, 84, 84, 3, 48, 48, 3}, new byte[]{48, 66, 4, 4, 19, 48, 48, 4}};
        impTabL_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS = bArr11;
        impTab_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS = new ImpTabPair(bArr11, bArr10, sArr3, sArr4);
    }

    public Bidi(int i, int i2) {
        this.dirPropsMemory = new byte[1];
        this.levelsMemory = new byte[1];
        this.paras_limit = new int[10];
        this.paras_level = new byte[10];
        this.runsMemory = new BidiRun[0];
        this.simpleRuns = new BidiRun[]{new BidiRun()};
        this.customClassifier = null;
        this.insertPoints = new InsertPoints();
        if (i < 0 || i2 < 0) {
            dk0.v();
            throw null;
        }
        this.bdp = UBiDiProps.INSTANCE;
        if (i > 0) {
            getInitialDirPropsMemory(i);
            getInitialLevelsMemory(i);
        } else {
            this.mayAllocateText = true;
        }
        if (i2 <= 0) {
            this.mayAllocateRuns = true;
        } else if (i2 > 1) {
            getInitialRunsMemory(i2);
        }
    }

    public static final byte DirFromStrong(byte b) {
        return b == 0 ? (byte) 0 : (byte) 1;
    }

    public static int DirPropFlag(byte b) {
        return 1 << b;
    }

    public static final int DirPropFlagE(byte b) {
        return DirPropFlagE[b & 1];
    }

    public static final int DirPropFlagLR(byte b) {
        return DirPropFlagLR[b & 1];
    }

    public static final int DirPropFlagO(byte b) {
        return DirPropFlagO[b & 1];
    }

    private static short GetAction(byte b) {
        return (short) (b >> 4);
    }

    private static short GetActionProps(short s) {
        return (short) (s >> 5);
    }

    public static byte GetLRFromLevel(byte b) {
        return (byte) (b & 1);
    }

    private static short GetState(byte b) {
        return (short) (b & 15);
    }

    private static short GetStateProps(short s) {
        return (short) (s & 31);
    }

    public static boolean IsBidiControlChar(int i) {
        if ((i & (-4)) == 8204) {
            return true;
        }
        if (i < 8234 || i > 8238) {
            return i >= 8294 && i <= 8297;
        }
        return true;
    }

    public static boolean IsDefaultLevel(byte b) {
        return (b & LEVEL_DEFAULT_LTR) == 126;
    }

    public static final byte NoOverride(byte b) {
        return (byte) (b & LEVEL_DEFAULT_RTL);
    }

    private void addPoint(int i, int i2) {
        Point point = new Point();
        InsertPoints insertPoints = this.insertPoints;
        int length = insertPoints.points.length;
        if (length == 0) {
            length = 10;
            insertPoints.points = new Point[10];
        }
        if (insertPoints.size >= length) {
            Point[] pointArr = insertPoints.points;
            Point[] pointArr2 = new Point[length * 2];
            insertPoints.points = pointArr2;
            System.arraycopy(pointArr, 0, pointArr2, 0, length);
        }
        point.pos = i;
        point.flag = i2;
        InsertPoints insertPoints2 = this.insertPoints;
        Point[] pointArr3 = insertPoints2.points;
        int i3 = insertPoints2.size;
        pointArr3[i3] = point;
        insertPoints2.size = i3 + 1;
    }

    private void adjustWSLevels() {
        if ((this.flags & MASK_WS) != 0) {
            int i = this.trailingWSStart;
            while (i > 0) {
                while (i > 0) {
                    i--;
                    int iDirPropFlag = DirPropFlag(this.dirProps[i]);
                    if ((MASK_WS & iDirPropFlag) == 0) {
                        break;
                    }
                    if (!this.orderParagraphsLTR || (DirPropFlag((byte) 7) & iDirPropFlag) == 0) {
                        this.levels[i] = GetParaLevelAt(i);
                    } else {
                        this.levels[i] = 0;
                    }
                }
                while (i > 0) {
                    int i2 = i - 1;
                    int iDirPropFlag2 = DirPropFlag(this.dirProps[i2]);
                    if ((MASK_BN_EXPLICIT & iDirPropFlag2) == 0) {
                        if (this.orderParagraphsLTR && (DirPropFlag((byte) 7) & iDirPropFlag2) != 0) {
                            this.levels[i2] = 0;
                        } else if ((MASK_B_S & iDirPropFlag2) != 0) {
                            this.levels[i2] = GetParaLevelAt(i2);
                        }
                        i = i2;
                        break;
                    }
                    byte[] bArr = this.levels;
                    bArr[i2] = bArr[i];
                    i = i2;
                }
            }
        }
    }

    private void bracketAddOpening(BracketData bracketData, char c, int i) {
        IsoRun isoRun = bracketData.isoRuns[bracketData.isoRunLast];
        short s = isoRun.limit;
        Opening[] openingArr = bracketData.openings;
        if (s >= openingArr.length) {
            try {
                int length = openingArr.length;
                Opening[] openingArr2 = new Opening[length * 2];
                bracketData.openings = openingArr2;
                System.arraycopy(openingArr, 0, openingArr2, 0, length);
            } catch (Exception unused) {
                throw new OutOfMemoryError("Failed to allocate memory for openings");
            }
        }
        Opening[] openingArr3 = bracketData.openings;
        short s2 = isoRun.limit;
        Opening opening = openingArr3[s2];
        if (opening == null) {
            opening = new Opening();
            openingArr3[s2] = opening;
        }
        opening.position = i;
        opening.match = c;
        opening.contextDir = isoRun.contextDir;
        opening.contextPos = isoRun.contextPos;
        opening.flags = (short) 0;
        isoRun.limit = (short) (isoRun.limit + 1);
    }

    private void bracketInit(BracketData bracketData) {
        bracketData.isoRunLast = 0;
        bracketData.isoRuns[0] = new IsoRun();
        IsoRun isoRun = bracketData.isoRuns[0];
        isoRun.start = (short) 0;
        isoRun.limit = (short) 0;
        isoRun.level = GetParaLevelAt(0);
        IsoRun isoRun2 = bracketData.isoRuns[0];
        byte bGetParaLevelAt = (byte) (GetParaLevelAt(0) & 1);
        isoRun2.contextDir = bGetParaLevelAt;
        isoRun2.lastBase = bGetParaLevelAt;
        isoRun2.lastStrong = bGetParaLevelAt;
        bracketData.isoRuns[0].contextPos = 0;
        bracketData.openings = new Opening[20];
        int i = this.reorderingMode;
        bracketData.isNumbersSpecial = i == 1 || i == 6;
    }

    private void bracketProcessB(BracketData bracketData, byte b) {
        bracketData.isoRunLast = 0;
        IsoRun isoRun = bracketData.isoRuns[0];
        isoRun.limit = (short) 0;
        isoRun.level = b;
        byte b2 = (byte) (b & 1);
        isoRun.contextDir = b2;
        isoRun.lastBase = b2;
        isoRun.lastStrong = b2;
        isoRun.contextPos = 0;
    }

    private void bracketProcessBoundary(BracketData bracketData, int i, byte b, byte b2) {
        IsoRun isoRun = bracketData.isoRuns[bracketData.isoRunLast];
        if ((DirPropFlag(this.dirProps[i]) & MASK_ISO) != 0) {
            return;
        }
        if (NoOverride(b2) > NoOverride(b)) {
            b = b2;
        }
        isoRun.limit = isoRun.start;
        isoRun.level = b2;
        byte b3 = (byte) (b & 1);
        isoRun.contextDir = b3;
        isoRun.lastBase = b3;
        isoRun.lastStrong = b3;
        isoRun.contextPos = i;
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0121  */
    /* JADX WARN: Code duplicated, block: B:76:0x0129  */
    /* JADX WARN: Code duplicated, block: B:84:0x012f A[SYNTHETIC] */
    private void bracketProcessChar(BracketData bracketData, int i) {
        short sDirPropFlag;
        int i2;
        Opening opening;
        IsoRun isoRun = bracketData.isoRuns[bracketData.isoRunLast];
        byte b = this.dirProps[i];
        byte b2 = 0;
        if (b == 10) {
            char c = this.text[i];
            for (int i3 = isoRun.limit - 1; i3 >= isoRun.start; i3--) {
                if (bracketData.openings[i3].match == c) {
                    byte bBracketProcessClosing = bracketProcessClosing(bracketData, i3, i);
                    if (bBracketProcessClosing == 10) {
                        c = 0;
                        break;
                    }
                    isoRun.lastBase = (byte) 10;
                    isoRun.contextDir = bBracketProcessClosing;
                    isoRun.contextPos = i;
                    byte b3 = this.levels[i];
                    if ((b3 & LEVEL_OVERRIDE) != 0) {
                        byte b4 = (byte) (b3 & 1);
                        isoRun.lastStrong = b4;
                        short sDirPropFlag2 = (short) DirPropFlag(b4);
                        for (int i4 = isoRun.start; i4 < i3; i4++) {
                            Opening opening2 = bracketData.openings[i4];
                            opening2.flags = (short) (opening2.flags | sDirPropFlag2);
                        }
                        byte[] bArr = this.levels;
                        bArr[i] = (byte) (bArr[i] & LEVEL_DEFAULT_RTL);
                    }
                    byte[] bArr2 = this.levels;
                    int i5 = bracketData.openings[i3].position;
                    bArr2[i5] = (byte) (bArr2[i5] & LEVEL_DEFAULT_RTL);
                    return;
                }
            }
            char bidiPairedBracket = c != 0 ? (char) UCharacter.getBidiPairedBracket(c) : (char) 0;
            if (bidiPairedBracket != c && UCharacter.getIntPropertyValue(c, UProperty.BIDI_PAIRED_BRACKET_TYPE) == 1) {
                if (bidiPairedBracket == 9002) {
                    bracketAddOpening(bracketData, (char) 12297, i);
                } else if (bidiPairedBracket == 12297) {
                    bracketAddOpening(bracketData, (char) 9002, i);
                }
                bracketAddOpening(bracketData, bidiPairedBracket, i);
            }
        }
        byte b5 = this.levels[i];
        if ((b5 & LEVEL_OVERRIDE) == 0) {
            if (b <= 1 || b == 13) {
                byte bDirFromStrong = DirFromStrong(b);
                isoRun.lastBase = b;
                isoRun.lastStrong = b;
                isoRun.contextDir = bDirFromStrong;
                isoRun.contextPos = i;
                b = bDirFromStrong;
            } else {
                if (b == 2) {
                    isoRun.lastBase = (byte) 2;
                    byte b6 = isoRun.lastStrong;
                    if (b6 == 0) {
                        if (!bracketData.isNumbersSpecial) {
                            this.dirProps[i] = 23;
                        }
                        isoRun.contextDir = (byte) 0;
                        isoRun.contextPos = i;
                    } else {
                        byte[] bArr3 = this.dirProps;
                        if (b6 == 13) {
                            bArr3[i] = 5;
                        } else {
                            bArr3[i] = 24;
                        }
                        isoRun.contextDir = (byte) 1;
                        isoRun.contextPos = i;
                    }
                } else if (b == 5) {
                    isoRun.lastBase = (byte) 5;
                    isoRun.contextDir = (byte) 1;
                    isoRun.contextPos = i;
                } else if (b == 17) {
                    b = isoRun.lastBase;
                    if (b == 10) {
                        this.dirProps[i] = b;
                    }
                } else {
                    isoRun.lastBase = b;
                }
                b = 1;
            }
            if (b > 1 || b == 13) {
                sDirPropFlag = (short) DirPropFlag(DirFromStrong(b));
                for (i2 = isoRun.start; i2 < isoRun.limit; i2++) {
                    opening = bracketData.openings[i2];
                    if (i > opening.position) {
                        opening.flags = (short) (opening.flags | sDirPropFlag);
                    }
                }
            }
            return;
        }
        b2 = (byte) (b5 & 1);
        if (b != 8 && b != 9 && b != 10) {
            this.dirProps[i] = b2;
        }
        isoRun.lastBase = b2;
        isoRun.lastStrong = b2;
        isoRun.contextDir = b2;
        isoRun.contextPos = i;
        b = b2;
        if (b > 1) {
        }
        sDirPropFlag = (short) DirPropFlag(DirFromStrong(b));
        while (i2 < isoRun.limit) {
            opening = bracketData.openings[i2];
            if (i > opening.position) {
                opening.flags = (short) (opening.flags | sDirPropFlag);
            }
        }
    }

    private byte bracketProcessClosing(BracketData bracketData, int i, int i2) {
        boolean z;
        IsoRun isoRun = bracketData.isoRuns[bracketData.isoRunLast];
        Opening opening = bracketData.openings[i];
        byte b = (byte) (isoRun.level & 1);
        if ((b == 0 && (opening.flags & FOUND_L) > 0) || (b == 1 && (opening.flags & FOUND_R) > 0)) {
            z = true;
        } else {
            if ((opening.flags & (FOUND_L | FOUND_R)) == 0) {
                isoRun.limit = (short) i;
                return (byte) 10;
            }
            z = i == isoRun.start;
            byte b2 = opening.contextDir;
            if (b != b2) {
                b = b2;
            }
        }
        byte[] bArr = this.dirProps;
        int i3 = opening.position;
        bArr[i3] = b;
        bArr[i2] = b;
        fixN0c(bracketData, i, i3, b);
        if (z) {
            isoRun.limit = (short) i;
            while (true) {
                short s = isoRun.limit;
                if (s <= isoRun.start || bracketData.openings[s - 1].position != opening.position) {
                    break;
                }
                isoRun.limit = (short) (s - 1);
            }
        } else {
            opening.match = -i2;
            int i4 = i - 1;
            while (i4 >= isoRun.start) {
                Opening opening2 = bracketData.openings[i4];
                if (opening2.position != opening.position) {
                    break;
                }
                i4--;
                opening2.match = 0;
            }
            for (int i5 = i + 1; i5 < isoRun.limit; i5++) {
                Opening opening3 = bracketData.openings[i5];
                if (opening3.position >= i2) {
                    break;
                }
                if (opening3.match > 0) {
                    opening3.match = 0;
                }
            }
        }
        return b;
    }

    private void bracketProcessLRI_RLI(BracketData bracketData, byte b) {
        IsoRun[] isoRunArr = bracketData.isoRuns;
        int i = bracketData.isoRunLast;
        IsoRun isoRun = isoRunArr[i];
        isoRun.lastBase = (byte) 10;
        short s = isoRun.limit;
        int i2 = i + 1;
        bracketData.isoRunLast = i2;
        IsoRun isoRun2 = isoRunArr[i2];
        if (isoRun2 == null) {
            isoRun2 = new IsoRun();
            isoRunArr[i2] = isoRun2;
        }
        isoRun2.limit = s;
        isoRun2.start = s;
        isoRun2.level = b;
        byte b2 = (byte) (b & 1);
        isoRun2.contextDir = b2;
        isoRun2.lastBase = b2;
        isoRun2.lastStrong = b2;
        isoRun2.contextPos = 0;
    }

    private void bracketProcessPDI(BracketData bracketData) {
        int i = bracketData.isoRunLast - 1;
        bracketData.isoRunLast = i;
        bracketData.isoRuns[i].lastBase = (byte) 10;
    }

    private byte checkExplicitLevels() {
        int i;
        this.flags = 0;
        this.isolateCount = 0;
        int i2 = this.paras_limit[0];
        byte b = this.paraLevel;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.length; i5++) {
            byte[] bArr = this.levels;
            byte b2 = bArr[i5];
            byte b3 = this.dirProps[i5];
            if (b3 == 20 || b3 == 21) {
                i3++;
                if (i3 > this.isolateCount) {
                    this.isolateCount = i3;
                }
            } else if (b3 == 22) {
                i3--;
            } else if (b3 == 7) {
                i3 = 0;
            }
            if (this.defaultParaLevel != 0 && i5 == i2 && (i = i4 + 1) < this.paraCount) {
                b = this.paras_level[i];
                i2 = this.paras_limit[i];
                i4 = i;
            }
            int i6 = b2 & LEVEL_OVERRIDE;
            byte b4 = (byte) (b2 & LEVEL_DEFAULT_RTL);
            if (b4 < b || 125 < b4) {
                if (b4 != 0) {
                    og.i(ky0.i("level ", b4, i5, " out of bounds at "));
                    return (byte) 0;
                }
                if (b3 != 7) {
                    bArr[i5] = (byte) (b | i6);
                    b4 = b;
                }
            }
            int i7 = this.flags;
            if (i6 != 0) {
                this.flags = i7 | DirPropFlagO(b4);
            } else {
                this.flags = i7 | DirPropFlagE(b4) | DirPropFlag(b3);
            }
        }
        int i8 = this.flags;
        if ((MASK_EMBEDDING & i8) != 0) {
            this.flags = i8 | DirPropFlagLR(this.paraLevel);
        }
        return directionFromFlags();
    }

    private void checkParaCount() {
        int i = this.paraCount;
        byte[] bArr = this.paras_level;
        if (i <= bArr.length) {
            return;
        }
        int length = bArr.length;
        int[] iArr = this.paras_limit;
        int i2 = i * 2;
        try {
            int[] iArr2 = new int[i2];
            this.paras_limit = iArr2;
            this.paras_level = new byte[i2];
            System.arraycopy(iArr, 0, iArr2, 0, length);
            System.arraycopy(bArr, 0, this.paras_level, 0, length);
        } catch (Exception unused) {
            throw new OutOfMemoryError("Failed to allocate memory for paras");
        }
    }

    private byte directionFromFlags() {
        int i = this.flags;
        if ((MASK_RTL & i) == 0 && ((i & DirPropFlag((byte) 5)) == 0 || (this.flags & MASK_POSSIBLE_N) == 0)) {
            return (byte) 0;
        }
        return (this.flags & MASK_LTR) == 0 ? (byte) 1 : (byte) 2;
    }

    private byte firstL_R_AL() {
        int iCharCount = 0;
        while (true) {
            byte b = 10;
            while (iCharCount < this.prologue.length()) {
                int iCodePointAt = this.prologue.codePointAt(iCharCount);
                iCharCount += Character.charCount(iCodePointAt);
                byte customizedClass = (byte) getCustomizedClass(iCodePointAt);
                if (b == 10) {
                    if (customizedClass == 0 || customizedClass == 1 || customizedClass == 13) {
                        b = customizedClass;
                    }
                } else if (customizedClass == 7) {
                }
            }
            return b;
        }
    }

    private byte firstL_R_AL_EN_AN() {
        int iCharCount = 0;
        while (iCharCount < this.epilogue.length()) {
            int iCodePointAt = this.epilogue.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            byte customizedClass = (byte) getCustomizedClass(iCodePointAt);
            if (customizedClass == 0) {
                return (byte) 0;
            }
            if (customizedClass == 1 || customizedClass == 13) {
                return (byte) 1;
            }
            if (customizedClass == 2) {
                return (byte) 2;
            }
            if (customizedClass == 5) {
                return (byte) 3;
            }
        }
        return (byte) 4;
    }

    private void fixN0c(BracketData bracketData, int i, int i2, byte b) {
        IsoRun isoRun = bracketData.isoRuns[bracketData.isoRunLast];
        while (true) {
            i++;
            if (i >= isoRun.limit) {
                return;
            }
            Opening opening = bracketData.openings[i];
            int i3 = opening.match;
            if (i3 < 0) {
                if (i2 < opening.contextPos) {
                    return;
                }
                int i4 = opening.position;
                if (i2 >= i4) {
                    continue;
                } else {
                    if (b == opening.contextDir) {
                        return;
                    }
                    byte[] bArr = this.dirProps;
                    bArr[i4] = b;
                    int i5 = -i3;
                    bArr[i5] = b;
                    opening.match = 0;
                    fixN0c(bracketData, i, i4, b);
                    fixN0c(bracketData, i, i5, b);
                }
            }
        }
    }

    public static byte getBaseDirection(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            int length = charSequence.length();
            int iOffsetByCodePoints = 0;
            while (iOffsetByCodePoints < length) {
                byte directionality = UCharacter.getDirectionality(UCharacter.codePointAt(charSequence, iOffsetByCodePoints));
                if (directionality == 0) {
                    return (byte) 0;
                }
                if (directionality == 1 || directionality == 13) {
                    return (byte) 1;
                }
                iOffsetByCodePoints = UCharacter.offsetByCodePoints(charSequence, iOffsetByCodePoints, 1);
            }
        }
        return (byte) 3;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x01c4  */
    private void getDirProps() {
        byte b;
        byte b2;
        byte b3;
        char c;
        byte b4;
        boolean z;
        int i;
        byte bFirstL_R_AL;
        int i2;
        byte b5 = 0;
        this.flags = 0;
        boolean zIsDefaultLevel = IsDefaultLevel(this.paraLevel);
        boolean z2 = zIsDefaultLevel && ((i2 = this.reorderingMode) == 5 || i2 == 6);
        this.lastArabicPos = -1;
        int i3 = this.reorderingOptions;
        boolean z3 = (i3 & 2) != 0;
        int[] iArr = new int[126];
        byte[] bArr = new byte[126];
        if ((i3 & 4) != 0) {
            this.length = 0;
        }
        byte b6 = this.paraLevel;
        byte b7 = (byte) (b6 & 1);
        byte[] bArr2 = this.paras_level;
        if (zIsDefaultLevel) {
            bArr2[0] = b7;
            if (this.prologue == null || (bFirstL_R_AL = firstL_R_AL()) == 10) {
                b = 1;
            } else {
                byte[] bArr3 = this.paras_level;
                if (bFirstL_R_AL == 0) {
                    bArr3[0] = 0;
                } else {
                    bArr3[0] = 1;
                }
                b = 0;
            }
            b2 = b7;
        } else {
            bArr2[0] = b6;
            b = 0;
            b2 = 10;
        }
        int charCount = 0;
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int i6 = this.originalLength;
            if (charCount >= i6) {
                break;
            }
            int iCharAt = UTF16.charAt(this.text, b5, i6, charCount);
            charCount = UTF16.getCharCount(iCharAt) + charCount;
            b5 = b5;
            int i7 = charCount - 1;
            byte customizedClass = (byte) getCustomizedClass(iCharAt);
            zIsDefaultLevel = zIsDefaultLevel;
            int iDirPropFlag = this.flags | DirPropFlag(customizedClass);
            this.flags = iDirPropFlag;
            this.dirProps[i7] = customizedClass;
            if (i7 > charCount) {
                this.flags = iDirPropFlag | DirPropFlag((byte) 18);
                int i8 = i7;
                while (true) {
                    int i9 = i8 - 1;
                    this.dirProps[i9] = 18;
                    if (i9 <= charCount) {
                        break;
                    } else {
                        i8 = i9;
                    }
                }
            }
            if (z3 && IsBidiControlChar(iCharAt)) {
                i4++;
            }
            if (customizedClass == 0) {
                if (b == 1) {
                    this.paras_level[this.paraCount - 1] = b5;
                    b = b5;
                } else if (b == 2) {
                    if (i5 <= 125) {
                        this.flags |= DirPropFlag((byte) 20);
                    }
                    b = 3;
                }
                b5 = b5;
                b2 = b5;
            } else {
                byte b8 = 1;
                if (customizedClass != 1) {
                    if (customizedClass == 13) {
                        b8 = 1;
                    } else if (customizedClass < 19 || customizedClass > 21) {
                        if (customizedClass == 22) {
                            if (b == 2) {
                                i = 125;
                                if (i5 <= 125) {
                                    this.flags |= DirPropFlag((byte) 20);
                                }
                            } else {
                                i = 125;
                            }
                            if (i5 >= 0) {
                                if (i5 <= i) {
                                    b = bArr[i5];
                                }
                                i5--;
                                b5 = b5;
                            }
                        } else if (customizedClass == 7) {
                            int i10 = this.originalLength;
                            if (charCount >= i10 || iCharAt != 13) {
                                c = LF;
                            } else {
                                char c2 = this.text[charCount];
                                c = LF;
                                if (c2 == '\n') {
                                }
                            }
                            int[] iArr2 = this.paras_limit;
                            int i11 = this.paraCount;
                            iArr2[i11 - 1] = charCount;
                            if (z2 && b2 == 1) {
                                this.paras_level[i11 - 1] = 1;
                            }
                            if ((this.reorderingOptions & 4) != 0) {
                                this.length = charCount;
                                this.controlCount = i4;
                            }
                            if (charCount < i10) {
                                this.paraCount = i11 + 1;
                                checkParaCount();
                                byte[] bArr4 = this.paras_level;
                                if (zIsDefaultLevel) {
                                    z = true;
                                    bArr4[this.paraCount - 1] = b7;
                                    b2 = b7;
                                    b = 1;
                                } else {
                                    z = true;
                                    bArr4[this.paraCount - 1] = this.paraLevel;
                                    b = b5;
                                }
                                i5 = -1;
                            }
                        }
                        c = LF;
                    } else {
                        i5++;
                        if (i5 <= 125) {
                            iArr[i5] = i7;
                            bArr[i5] = b;
                        }
                        if (customizedClass == 19) {
                            this.dirProps[i7] = 20;
                            charCount = charCount;
                            b5 = b5;
                            b = 2;
                        } else {
                            charCount = charCount;
                            b5 = b5;
                            b = 3;
                        }
                    }
                }
                c = LF;
                if (b == b8) {
                    this.paras_level[this.paraCount - b8] = b8;
                    b = b5;
                } else {
                    if (b == 2) {
                        if (i5 <= 125) {
                            this.dirProps[iArr[i5]] = 21;
                            this.flags |= DirPropFlag((byte) 21);
                        }
                        b4 = 13;
                        b = 3;
                    }
                    if (customizedClass == b4) {
                        this.lastArabicPos = i7;
                    }
                    b2 = 1;
                }
                b4 = 13;
                if (customizedClass == b4) {
                    this.lastArabicPos = i7;
                }
                b2 = 1;
            }
        }
        byte b9 = b5;
        boolean z4 = zIsDefaultLevel;
        if (i5 > 125) {
            i5 = 125;
            b = 2;
        }
        while (i5 >= 0) {
            if (b == 2) {
                this.flags |= DirPropFlag((byte) 20);
                break;
            } else {
                b = bArr[i5];
                i5--;
            }
        }
        if ((this.reorderingOptions & 4) == 0) {
            b3 = 1;
            this.paras_limit[this.paraCount - 1] = this.originalLength;
            this.controlCount = i4;
        } else if (this.length < this.originalLength) {
            b3 = 1;
            this.paraCount--;
        } else {
            b3 = 1;
        }
        if (z2 && b2 == b3) {
            this.paras_level[this.paraCount - b3] = b3;
        }
        if (z4) {
            this.paraLevel = this.paras_level[b9];
        }
        for (int i12 = b9; i12 < this.paraCount; i12++) {
            this.flags |= DirPropFlagLR(this.paras_level[i12]);
        }
        if (!this.orderParagraphsLTR || (this.flags & DirPropFlag((byte) 7)) == 0) {
            return;
        }
        this.flags |= DirPropFlag(b9);
    }

    private void getDirPropsMemory(boolean z, int i) {
        this.dirPropsMemory = (byte[]) getMemory("DirProps", this.dirPropsMemory, Byte.TYPE, z, i);
    }

    private void getInitialDirPropsMemory(int i) {
        getDirPropsMemory(true, i);
    }

    private void getInitialLevelsMemory(int i) {
        getLevelsMemory(true, i);
    }

    private void getInitialRunsMemory(int i) {
        getRunsMemory(true, i);
    }

    private void getLevelsMemory(boolean z, int i) {
        this.levelsMemory = (byte[]) getMemory("Levels", this.levelsMemory, Byte.TYPE, z, i);
    }

    private Object getMemory(String str, Object obj, Class<?> cls, boolean z, int i) {
        int length = Array.getLength(obj);
        if (i != length) {
            if (z) {
                try {
                    return Array.newInstance(cls, i);
                } catch (Exception unused) {
                    throw new OutOfMemoryError(cq.j("Failed to allocate memory for ", str));
                }
            }
            if (i > length) {
                throw new OutOfMemoryError(cq.j("Failed to allocate memory for ", str));
            }
        }
        return obj;
    }

    private void getRunsMemory(boolean z, int i) {
        this.runsMemory = (BidiRun[]) getMemory("Runs", this.runsMemory, BidiRun.class, z, i);
    }

    public static int[] invertMap(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return BidiLine.invertMap(iArr);
    }

    private byte lastL_R_AL() {
        int length = this.prologue.length();
        while (length > 0) {
            int iCodePointBefore = this.prologue.codePointBefore(length);
            length -= Character.charCount(iCodePointBefore);
            byte customizedClass = (byte) getCustomizedClass(iCodePointBefore);
            if (customizedClass == 0) {
                return (byte) 0;
            }
            if (customizedClass == 1 || customizedClass == 13) {
                return (byte) 1;
            }
            if (customizedClass == 7) {
                return (byte) 4;
            }
        }
        return (byte) 4;
    }

    private void processPropertySeq(LevState levState, short s, int i, int i2) {
        int i3;
        byte[][] bArr = levState.impTab;
        short[] sArr = levState.impAct;
        short s2 = levState.state;
        byte b = bArr[s2][s];
        levState.state = GetState(b);
        short s3 = sArr[GetAction(b)];
        byte b2 = bArr[levState.state][7];
        if (s3 != 0) {
            switch (s3) {
                case 1:
                    levState.startON = i;
                    i3 = i;
                    break;
                case 2:
                    i3 = levState.startON;
                    break;
                case 3:
                    setLevelsOutsideIsolates(levState.startON, i, (byte) (levState.runLevel + 1));
                    i3 = i;
                    break;
                case 4:
                    setLevelsOutsideIsolates(levState.startON, i, (byte) (levState.runLevel + 2));
                    i3 = i;
                    break;
                case 5:
                    int i4 = levState.startL2EN;
                    if (i4 >= 0) {
                        addPoint(i4, 1);
                    }
                    levState.startL2EN = -1;
                    InsertPoints insertPoints = this.insertPoints;
                    if (insertPoints.points.length == 0 || insertPoints.size <= insertPoints.confirmed) {
                        levState.lastStrongRTL = -1;
                        if ((bArr[s2][7] & 1) == 0 || (i3 = levState.startON) <= 0) {
                            i3 = i;
                        }
                        if (s == 5) {
                            addPoint(i, 1);
                            InsertPoints insertPoints2 = this.insertPoints;
                            insertPoints2.confirmed = insertPoints2.size;
                        }
                    } else {
                        for (int i5 = levState.lastStrongRTL + 1; i5 < i; i5++) {
                            byte[] bArr2 = this.levels;
                            bArr2[i5] = (byte) ((bArr2[i5] - 2) & (-2));
                        }
                        InsertPoints insertPoints3 = this.insertPoints;
                        insertPoints3.confirmed = insertPoints3.size;
                        levState.lastStrongRTL = -1;
                        if (s == 5) {
                            addPoint(i, 1);
                            InsertPoints insertPoints4 = this.insertPoints;
                            insertPoints4.confirmed = insertPoints4.size;
                        }
                        i3 = i;
                    }
                    break;
                case 6:
                    InsertPoints insertPoints5 = this.insertPoints;
                    if (insertPoints5.points.length > 0) {
                        insertPoints5.size = insertPoints5.confirmed;
                    }
                    levState.startON = -1;
                    levState.startL2EN = -1;
                    levState.lastStrongRTL = i2 - 1;
                    i3 = i;
                    break;
                case 7:
                    if (s == 3 && this.dirProps[i] == 5 && this.reorderingMode != 6) {
                        int i6 = levState.startL2EN;
                        if (i6 == -1) {
                            levState.lastStrongRTL = i2 - 1;
                        } else {
                            if (i6 >= 0) {
                                addPoint(i6, 1);
                                levState.startL2EN = -2;
                            }
                            addPoint(i, 1);
                        }
                    } else if (levState.startL2EN == -1) {
                        levState.startL2EN = i;
                    }
                    i3 = i;
                    break;
                case 8:
                    levState.lastStrongRTL = i2 - 1;
                    levState.startON = -1;
                    i3 = i;
                    break;
                case 9:
                    int i7 = i - 1;
                    while (i7 >= 0 && (this.levels[i7] & 1) == 0) {
                        i7--;
                    }
                    if (i7 >= 0) {
                        addPoint(i7, 4);
                        InsertPoints insertPoints6 = this.insertPoints;
                        insertPoints6.confirmed = insertPoints6.size;
                    }
                    levState.startON = i;
                    i3 = i;
                    break;
                case 10:
                    addPoint(i, 1);
                    addPoint(i, 2);
                    i3 = i;
                    break;
                case 11:
                    InsertPoints insertPoints7 = this.insertPoints;
                    insertPoints7.size = insertPoints7.confirmed;
                    if (s == 5) {
                        addPoint(i, 4);
                        InsertPoints insertPoints8 = this.insertPoints;
                        insertPoints8.confirmed = insertPoints8.size;
                    }
                    i3 = i;
                    break;
                case 12:
                    byte b3 = (byte) (levState.runLevel + b2);
                    for (int i8 = levState.startON; i8 < i; i8++) {
                        byte[] bArr3 = this.levels;
                        if (bArr3[i8] < b3) {
                            bArr3[i8] = b3;
                        }
                    }
                    InsertPoints insertPoints9 = this.insertPoints;
                    insertPoints9.confirmed = insertPoints9.size;
                    levState.startON = i;
                    i3 = i;
                    break;
                case 13:
                    byte b4 = levState.runLevel;
                    int i9 = i - 1;
                    while (i9 >= levState.startON) {
                        int i10 = b4 + 3;
                        if (this.levels[i9] == i10) {
                            while (true) {
                                byte[] bArr4 = this.levels;
                                byte b5 = bArr4[i9];
                                if (b5 == i10) {
                                    bArr4[i9] = (byte) (b5 - 2);
                                    i9--;
                                } else {
                                    while (this.levels[i9] == b4) {
                                        i9--;
                                    }
                                }
                            }
                        }
                        byte[] bArr5 = this.levels;
                        if (bArr5[i9] == b4 + 2) {
                            bArr5[i9] = b4;
                        } else {
                            bArr5[i9] = (byte) (b4 + 1);
                        }
                        i9--;
                    }
                    i3 = i;
                    break;
                case 14:
                    byte b6 = (byte) (levState.runLevel + 1);
                    for (int i11 = i - 1; i11 >= levState.startON; i11--) {
                        byte[] bArr6 = this.levels;
                        byte b7 = bArr6[i11];
                        if (b7 > b6) {
                            bArr6[i11] = (byte) (b7 - 2);
                        }
                    }
                    i3 = i;
                    break;
                default:
                    og.n("Internal ICU error in processPropertySeq");
                    break;
            }
            return;
        }
        i3 = i;
        if (b2 != 0 || i3 < i) {
            byte b8 = (byte) (levState.runLevel + b2);
            if (i3 < levState.runStart) {
                setLevelsOutsideIsolates(i3, i2, b8);
                return;
            }
            while (i3 < i2) {
                this.levels[i3] = b8;
                i3++;
            }
        }
    }

    public static int[] reorderLogical(byte[] bArr) {
        return BidiLine.reorderLogical(bArr);
    }

    public static int[] reorderVisual(byte[] bArr) {
        return BidiLine.reorderVisual(bArr);
    }

    public static void reorderVisually(byte[] bArr, int i, Object[] objArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        int[] iArrReorderVisual = reorderVisual(bArr2);
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, i2, objArr2, 0, i3);
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i2 + i4] = objArr2[iArrReorderVisual[i4]];
        }
    }

    public static boolean requiresBidi(char[] cArr, int i, int i2) {
        while (i < i2) {
            if (((1 << UCharacter.getDirection(cArr[i])) & 57378) != 0) {
                return true;
            }
            i++;
        }
        return false;
    }

    private byte resolveExplicitLevels() {
        byte b;
        byte bNoOverride;
        byte bGetParaLevelAt = GetParaLevelAt(0);
        this.isolateCount = 0;
        byte bDirectionFromFlags = directionFromFlags();
        if (bDirectionFromFlags == 2) {
            boolean z = true;
            if (this.reorderingMode > 1) {
                int i = 0;
                while (i < this.paraCount) {
                    int i2 = this.paras_limit[i];
                    byte b2 = this.paras_level[i];
                    for (int i3 = i == 0 ? 0 : this.paras_limit[i - 1]; i3 < i2; i3++) {
                        this.levels[i3] = b2;
                    }
                    i++;
                }
            } else {
                byte b3 = 7;
                byte b4 = 18;
                if ((this.flags & (MASK_EXPLICIT | MASK_ISO)) != 0) {
                    short[] sArr = new short[127];
                    BracketData bracketData = new BracketData();
                    bracketInit(bracketData);
                    sArr[0] = bGetParaLevelAt;
                    this.flags = 0;
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    byte b5 = bGetParaLevelAt;
                    while (i4 < this.length) {
                        byte b6 = this.dirProps[i4];
                        boolean z2 = z;
                        byte b7 = b3;
                        switch (b6) {
                            case 7:
                                b = b4;
                                this.flags |= DirPropFlag(b7);
                                this.levels[i4] = GetParaLevelAt(i4);
                                int i10 = i4 + 1;
                                if (i10 < this.length) {
                                    char[] cArr = this.text;
                                    if (cArr[i4] != '\r' || cArr[i10] != '\n') {
                                        byte bGetParaLevelAt2 = GetParaLevelAt(i10);
                                        sArr[0] = bGetParaLevelAt2;
                                        bracketProcessB(bracketData, bGetParaLevelAt2);
                                        bGetParaLevelAt = bGetParaLevelAt2;
                                        b5 = bGetParaLevelAt;
                                        i5 = 0;
                                        i7 = 0;
                                        i8 = 0;
                                        i9 = 0;
                                    }
                                }
                                break;
                            case 8:
                            case 9:
                            case 10:
                            case 13:
                            case 17:
                            case 19:
                            default:
                                if (NoOverride(bGetParaLevelAt) != NoOverride(b5)) {
                                    bracketProcessBoundary(bracketData, i6, b5, bGetParaLevelAt);
                                    int i11 = this.flags | DirPropFlagMultiRuns;
                                    this.flags = i11;
                                    if ((bGetParaLevelAt & LEVEL_OVERRIDE) != 0) {
                                        this.flags = i11 | DirPropFlagO(bGetParaLevelAt);
                                    } else {
                                        this.flags = i11 | DirPropFlagE(bGetParaLevelAt);
                                    }
                                }
                                this.levels[i4] = bGetParaLevelAt;
                                bracketProcessChar(bracketData, i4);
                                this.flags |= DirPropFlag(this.dirProps[i4]);
                                b5 = bGetParaLevelAt;
                                b = b4;
                                break;
                            case 11:
                            case 12:
                            case 14:
                            case 15:
                                b = b4;
                                this.flags |= DirPropFlag(b);
                                this.levels[i4] = b5;
                                bNoOverride = (byte) ((b6 == 11 || b6 == 12) ? (bGetParaLevelAt + 2) & 126 : (NoOverride(bGetParaLevelAt) + 1) | 1);
                                if (bNoOverride <= 125 && i5 == 0 && i7 == 0) {
                                    if (b6 == 12 || b6 == 15) {
                                        bNoOverride = (byte) (bNoOverride | LEVEL_OVERRIDE);
                                    }
                                    i8++;
                                    sArr[i8] = bNoOverride;
                                    bGetParaLevelAt = bNoOverride;
                                    i6 = i4;
                                } else if (i5 == 0) {
                                    i7++;
                                }
                                break;
                            case 16:
                                b = b4;
                                this.flags |= DirPropFlag(b);
                                this.levels[i4] = b5;
                                if (i5 <= 0) {
                                    if (i7 > 0) {
                                        i7--;
                                    } else if (i8 > 0 && sArr[i8] < 256) {
                                        i8--;
                                        bGetParaLevelAt = (byte) sArr[i8];
                                        i6 = i4;
                                    }
                                }
                                break;
                            case 18:
                                b = b4;
                                this.levels[i4] = b5;
                                this.flags |= DirPropFlag(b);
                                break;
                            case 20:
                            case 21:
                                this.flags |= DirPropFlag((byte) 10) | DirPropFlagLR(bGetParaLevelAt);
                                this.levels[i4] = NoOverride(bGetParaLevelAt);
                                b = b4;
                                if (NoOverride(bGetParaLevelAt) != NoOverride(b5)) {
                                    bracketProcessBoundary(bracketData, i6, b5, bGetParaLevelAt);
                                    this.flags |= DirPropFlagMultiRuns;
                                }
                                bNoOverride = (byte) (b6 == 20 ? (bGetParaLevelAt + 2) & 126 : (NoOverride(bGetParaLevelAt) + 1) | 1);
                                if (bNoOverride <= 125 && i5 == 0 && i7 == 0) {
                                    this.flags = DirPropFlag(b6) | this.flags;
                                    int i12 = i9 + 1;
                                    if (i12 > this.isolateCount) {
                                        this.isolateCount = i12;
                                    }
                                    i8++;
                                    sArr[i8] = (short) (bNoOverride + 256);
                                    bracketProcessLRI_RLI(bracketData, bNoOverride);
                                    i9 = i12;
                                    b5 = bGetParaLevelAt;
                                    bGetParaLevelAt = bNoOverride;
                                    i6 = i4;
                                } else {
                                    this.dirProps[i4] = 9;
                                    i5++;
                                    b5 = bGetParaLevelAt;
                                }
                                break;
                            case 22:
                                if (NoOverride(bGetParaLevelAt) != NoOverride(b5)) {
                                    bracketProcessBoundary(bracketData, i6, b5, bGetParaLevelAt);
                                    this.flags |= DirPropFlagMultiRuns;
                                }
                                if (i5 > 0) {
                                    i5--;
                                    this.dirProps[i4] = 9;
                                } else if (i9 > 0) {
                                    this.flags |= DirPropFlag((byte) 22);
                                    while (sArr[i8] < 256) {
                                        i8--;
                                    }
                                    i8--;
                                    i9--;
                                    bracketProcessPDI(bracketData);
                                    i6 = i4;
                                    i7 = 0;
                                } else {
                                    this.dirProps[i4] = 9;
                                }
                                byte b8 = (byte) (sArr[i8] & (-257));
                                this.flags |= DirPropFlag((byte) 10) | DirPropFlagLR(b8);
                                this.levels[i4] = NoOverride(b8);
                                bGetParaLevelAt = b8;
                                b5 = bGetParaLevelAt;
                                b = b4;
                                break;
                        }
                        i4++;
                        z = z2;
                        b3 = b7;
                        b4 = b;
                    }
                    byte b9 = b3;
                    int i13 = this.flags;
                    if ((MASK_EMBEDDING & i13) != 0) {
                        this.flags = i13 | DirPropFlagLR(this.paraLevel);
                    }
                    if (this.orderParagraphsLTR && (this.flags & DirPropFlag(b9)) != 0) {
                        this.flags |= DirPropFlag((byte) 0);
                    }
                    return directionFromFlags();
                }
                BracketData bracketData2 = new BracketData();
                bracketInit(bracketData2);
                int i14 = 0;
                while (i14 < this.paraCount) {
                    int i15 = this.paras_limit[i14];
                    byte b10 = this.paras_level[i14];
                    for (int i16 = i14 == 0 ? 0 : this.paras_limit[i14 - 1]; i16 < i15; i16++) {
                        this.levels[i16] = b10;
                        byte b11 = this.dirProps[i16];
                        if (b11 != 18) {
                            if (b11 == 7) {
                                int i17 = i16 + 1;
                                if (i17 < this.length) {
                                    char[] cArr2 = this.text;
                                    if (cArr2[i16] != '\r' || cArr2[i17] != '\n') {
                                        bracketProcessB(bracketData2, b10);
                                    }
                                }
                            } else {
                                bracketProcessChar(bracketData2, i16);
                            }
                        }
                    }
                    i14++;
                }
            }
        }
        return bDirectionFromFlags;
    }

    private void resolveImplicitLevels(int i, int i2, short s, short s2) {
        short s3;
        int i3;
        byte bFirstL_R_AL_EN_AN;
        short s4;
        byte bLastL_R_AL;
        int i4;
        LevState levState = new LevState(0);
        boolean z = i < this.lastArabicPos && (GetParaLevelAt(i) & 1) > 0 && ((i4 = this.reorderingMode) == 5 || i4 == 6);
        levState.startL2EN = -1;
        levState.lastStrongRTL = -1;
        levState.runStart = i;
        byte b = this.levels[i];
        levState.runLevel = b;
        ImpTabPair impTabPair = this.impTabPair;
        int i5 = b & 1;
        levState.impTab = impTabPair.imptab[i5];
        levState.impAct = impTabPair.impact[i5];
        short s5 = (i != 0 || this.prologue == null || (bLastL_R_AL = lastL_R_AL()) == 4) ? s : bLastL_R_AL;
        byte b2 = this.dirProps[i];
        if (b2 == 22) {
            Isolate[] isolateArr = this.isolates;
            int i6 = this.isolateCount;
            Isolate isolate = isolateArr[i6];
            levState.startON = isolate.startON;
            i3 = isolate.start1;
            s3 = isolate.stateImp;
            levState.state = isolate.state;
            this.isolateCount = i6 - 1;
        } else {
            levState.startON = -1;
            s3 = b2 == 17 ? (short) (s5 + 1) : (short) 0;
            levState.state = (short) 0;
            processPropertySeq(levState, s5, i, i);
            i3 = i;
        }
        int i7 = i;
        int i8 = i7;
        short s6 = 1;
        int i9 = -1;
        while (i7 <= i2) {
            if (i7 >= i2) {
                int i10 = i2 - 1;
                while (i10 > i && (DirPropFlag(this.dirProps[i10]) & MASK_BN_EXPLICIT) != 0) {
                    i10--;
                }
                byte b3 = this.dirProps[i10];
                if (b3 == 20 || b3 == 21) {
                    break;
                } else {
                    s4 = s2;
                }
            } else {
                byte b4 = this.dirProps[i7];
                if (b4 == 7) {
                    this.isolateCount = -1;
                }
                if (z) {
                    if (b4 == 13) {
                        b4 = 1;
                    } else if (b4 == 2) {
                        if (i9 <= i7) {
                            i9 = i7 + 1;
                            while (true) {
                                if (i9 >= i2) {
                                    i9 = i2;
                                    s6 = 1;
                                    break;
                                }
                                byte b5 = this.dirProps[i9];
                                if (b5 == 0 || b5 == 1 || b5 == 13) {
                                    s6 = b5;
                                    break;
                                }
                                i9++;
                            }
                        }
                        if (s6 == 13) {
                            b4 = 5;
                        }
                    }
                }
                s4 = groupProp[b4];
            }
            short[][] sArr = impTabProps;
            short s7 = sArr[s3][s4];
            short sGetStateProps = GetStateProps(s7);
            short sGetActionProps = GetActionProps(s7);
            if (i7 == i2 && sGetActionProps == 0) {
                sGetActionProps = 1;
            }
            if (sGetActionProps != 0) {
                short s8 = sArr[s3][15];
                if (sGetActionProps != 1) {
                    if (sGetActionProps != 2) {
                        if (sGetActionProps == 3) {
                            processPropertySeq(levState, s8, i3, i8);
                            processPropertySeq(levState, (short) 4, i8, i7);
                        } else if (sGetActionProps != 4) {
                            og.n("Internal ICU error in resolveImplicitLevels");
                            return;
                        } else {
                            processPropertySeq(levState, s8, i3, i8);
                            i3 = i8;
                        }
                    }
                    i8 = i7;
                } else {
                    processPropertySeq(levState, s8, i3, i7);
                }
                i3 = i7;
            }
            i7++;
            s3 = sGetStateProps;
        }
        short s9 = (i2 != this.length || this.epilogue == null || (bFirstL_R_AL_EN_AN = firstL_R_AL_EN_AN()) == 4) ? s2 : bFirstL_R_AL_EN_AN;
        int i11 = i2 - 1;
        while (i11 > i && (DirPropFlag(this.dirProps[i11]) & MASK_BN_EXPLICIT) != 0) {
            i11--;
        }
        byte b6 = this.dirProps[i11];
        if ((b6 != 20 && b6 != 21) || i2 >= this.length) {
            processPropertySeq(levState, s9, i2, i2);
            return;
        }
        int i12 = this.isolateCount + 1;
        this.isolateCount = i12;
        Isolate[] isolateArr2 = this.isolates;
        if (isolateArr2[i12] == null) {
            isolateArr2[i12] = new Isolate();
        }
        Isolate isolate2 = this.isolates[this.isolateCount];
        isolate2.stateImp = s3;
        isolate2.state = levState.state;
        isolate2.start1 = i3;
        isolate2.startON = levState.startON;
    }

    private void setLevelsOutsideIsolates(int i, int i2, byte b) {
        int i3 = 0;
        while (i < i2) {
            byte b2 = this.dirProps[i];
            if (b2 == 22) {
                i3--;
            }
            if (i3 == 0) {
                this.levels[i] = b;
            }
            if (b2 == 20 || b2 == 21) {
                i3++;
            }
            i++;
        }
    }

    private void setParaSuccess() {
        this.prologue = null;
        this.epilogue = null;
        this.paraBidi = this;
    }

    public static String writeReverse(String str, int i) {
        if (str != null) {
            return str.length() > 0 ? BidiWriter.writeReverse(str, i) : "";
        }
        dk0.v();
        return null;
    }

    public int Bidi_Abs(int i) {
        return i >= 0 ? i : -i;
    }

    public int Bidi_Min(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public byte GetParaLevelAt(int i) {
        int i2;
        if (this.defaultParaLevel == 0 || i < this.paras_limit[0]) {
            return this.paraLevel;
        }
        int i3 = 1;
        while (true) {
            i2 = this.paraCount;
            if (i3 >= i2 || i < this.paras_limit[i3]) {
                break;
            }
            i3++;
        }
        if (i3 >= i2) {
            i3 = i2 - 1;
        }
        return this.paras_level[i3];
    }

    public boolean baseIsLeftToRight() {
        return getParaLevel() == 0;
    }

    public int countParagraphs() {
        verifyValidParaOrLine();
        return this.paraCount;
    }

    public int countRuns() {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        return this.runCount;
    }

    public Bidi createLineBidi(int i, int i2) {
        return setLine(i, i2);
    }

    public int getBaseLevel() {
        return getParaLevel();
    }

    public BidiClassifier getCustomClassifier() {
        return this.customClassifier;
    }

    public int getCustomizedClass(int i) {
        int iClassify;
        BidiClassifier bidiClassifier = this.customClassifier;
        if (bidiClassifier == null || (iClassify = bidiClassifier.classify(i)) == 23) {
            iClassify = this.bdp.getClass(i);
        }
        if (iClassify >= 23) {
            return 10;
        }
        return iClassify;
    }

    public byte getDirection() {
        verifyValidParaOrLine();
        return this.direction;
    }

    public int getLength() {
        verifyValidParaOrLine();
        return this.originalLength;
    }

    public byte getLevelAt(int i) {
        verifyValidParaOrLine();
        verifyRange(i, 0, this.length);
        return BidiLine.getLevelAt(this, i);
    }

    public byte[] getLevels() {
        verifyValidParaOrLine();
        return this.length <= 0 ? new byte[0] : BidiLine.getLevels(this);
    }

    public int getLogicalIndex(int i) {
        verifyValidParaOrLine();
        verifyRange(i, 0, this.resultLength);
        if (this.insertPoints.size == 0 && this.controlCount == 0) {
            byte b = this.direction;
            if (b == 0) {
                return i;
            }
            if (b == 1) {
                return (this.length - i) - 1;
            }
        }
        BidiLine.getRuns(this);
        return BidiLine.getLogicalIndex(this, i);
    }

    public int[] getLogicalMap() {
        countRuns();
        return this.length <= 0 ? new int[0] : BidiLine.getLogicalMap(this);
    }

    public BidiRun getLogicalRun(int i) {
        verifyValidParaOrLine();
        verifyRange(i, 0, this.length);
        return BidiLine.getLogicalRun(this, i);
    }

    public void getLogicalToVisualRunsMap() {
        if (this.isGoodLogicalToVisualRunsMap) {
            return;
        }
        int iCountRuns = countRuns();
        int[] iArr = this.logicalToVisualRunsMap;
        if (iArr == null || iArr.length < iCountRuns) {
            this.logicalToVisualRunsMap = new int[iCountRuns];
        }
        long[] jArr = new long[iCountRuns];
        for (int i = 0; i < iCountRuns; i++) {
            jArr[i] = (((long) this.runs[i].start) << 32) + ((long) i);
        }
        Arrays.sort(jArr);
        for (int i2 = 0; i2 < iCountRuns; i2++) {
            this.logicalToVisualRunsMap[i2] = (int) jArr[i2];
        }
        this.isGoodLogicalToVisualRunsMap = true;
    }

    public byte getParaLevel() {
        verifyValidParaOrLine();
        return this.paraLevel;
    }

    public BidiRun getParagraph(int i) {
        verifyValidParaOrLine();
        Bidi bidi = this.paraBidi;
        int i2 = 0;
        verifyRange(i, 0, bidi.length);
        while (i >= bidi.paras_limit[i2]) {
            i2++;
        }
        return getParagraphByIndex(i2);
    }

    public BidiRun getParagraphByIndex(int i) {
        verifyValidParaOrLine();
        verifyRange(i, 0, this.paraCount);
        Bidi bidi = this.paraBidi;
        int i2 = i != 0 ? bidi.paras_limit[i - 1] : 0;
        BidiRun bidiRun = new BidiRun();
        bidiRun.start = i2;
        bidiRun.limit = bidi.paras_limit[i];
        bidiRun.level = GetParaLevelAt(i2);
        return bidiRun;
    }

    public int getParagraphIndex(int i) {
        verifyValidParaOrLine();
        Bidi bidi = this.paraBidi;
        int i2 = 0;
        verifyRange(i, 0, bidi.length);
        while (i >= bidi.paras_limit[i2]) {
            i2++;
        }
        return i2;
    }

    public int getProcessedLength() {
        verifyValidParaOrLine();
        return this.length;
    }

    public int getReorderingMode() {
        return this.reorderingMode;
    }

    public int getReorderingOptions() {
        return this.reorderingOptions;
    }

    public int getResultLength() {
        verifyValidParaOrLine();
        return this.resultLength;
    }

    public int getRunCount() {
        return countRuns();
    }

    public int getRunLevel(int i) {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        verifyRange(i, 0, this.runCount);
        getLogicalToVisualRunsMap();
        return this.runs[this.logicalToVisualRunsMap[i]].level;
    }

    public int getRunLimit(int i) {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        verifyRange(i, 0, this.runCount);
        getLogicalToVisualRunsMap();
        int i2 = this.logicalToVisualRunsMap[i];
        BidiRun[] bidiRunArr = this.runs;
        return this.runs[i2].start + (i2 == 0 ? bidiRunArr[i2].limit : bidiRunArr[i2].limit - bidiRunArr[i2 - 1].limit);
    }

    public int getRunStart(int i) {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        verifyRange(i, 0, this.runCount);
        getLogicalToVisualRunsMap();
        return this.runs[this.logicalToVisualRunsMap[i]].start;
    }

    public char[] getText() {
        verifyValidParaOrLine();
        return this.text;
    }

    public String getTextAsString() {
        verifyValidParaOrLine();
        return new String(this.text);
    }

    public int getVisualIndex(int i) {
        verifyValidParaOrLine();
        verifyRange(i, 0, this.length);
        return BidiLine.getVisualIndex(this, i);
    }

    public int[] getVisualMap() {
        countRuns();
        return this.resultLength <= 0 ? new int[0] : BidiLine.getVisualMap(this);
    }

    public BidiRun getVisualRun(int i) {
        verifyValidParaOrLine();
        BidiLine.getRuns(this);
        verifyRange(i, 0, this.runCount);
        return BidiLine.getVisualRun(this, i);
    }

    public boolean isInverse() {
        return this.isInverse;
    }

    public boolean isLeftToRight() {
        return getDirection() == 0 && (this.paraLevel & 1) == 0;
    }

    public boolean isMixed() {
        return (isLeftToRight() || isRightToLeft()) ? false : true;
    }

    public boolean isOrderParagraphsLTR() {
        return this.orderParagraphsLTR;
    }

    public boolean isRightToLeft() {
        return getDirection() == 1 && (this.paraLevel & 1) == 1;
    }

    public void orderParagraphsLTR(boolean z) {
        this.orderParagraphsLTR = z;
    }

    public void setContext(String str, String str2) {
        if (str == null || str.length() <= 0) {
            str = null;
        }
        this.prologue = str;
        if (str2 == null || str2.length() <= 0) {
            str2 = null;
        }
        this.epilogue = str2;
    }

    public void setCustomClassifier(BidiClassifier bidiClassifier) {
        this.customClassifier = bidiClassifier;
    }

    public void setInverse(boolean z) {
        this.isInverse = z;
        this.reorderingMode = z ? 4 : 0;
    }

    public Bidi setLine(int i, int i2) {
        verifyValidPara();
        verifyRange(i, 0, i2);
        verifyRange(i2, 0, this.length + 1);
        if (getParagraphIndex(i) == getParagraphIndex(i2 - 1)) {
            return BidiLine.setLine(this, i, i2);
        }
        dk0.v();
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:141:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x0157 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x0190 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:59:0x0114  */
    /* JADX WARN: Code duplicated, block: B:61:0x011e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0125  */
    /* JADX WARN: Code duplicated, block: B:65:0x012c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0143  */
    /* JADX WARN: Code duplicated, block: B:78:0x015b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0160  */
    /* JADX WARN: Code duplicated, block: B:82:0x0170  */
    /* JADX WARN: Code duplicated, block: B:84:0x0176  */
    /* JADX WARN: Code duplicated, block: B:87:0x017f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0183 A[LOOP:5: B:88:0x0183->B:94:0x019c, LOOP_START, PHI: r2
      0x0183: PHI (r2v8 int) = (r2v7 int), (r2v9 int) binds: [B:86:0x017d, B:94:0x019c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:93:0x0198 A[LOOP:3: B:64:0x012a->B:93:0x0198, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:94:0x019c A[LOOP:5: B:88:0x0183->B:94:0x019c, LOOP_END] */
    public void setPara(char[] cArr, byte b, byte[] bArr) {
        int i;
        byte bGetParaLevelAt;
        byte b2;
        byte bGetLRFromLevel;
        short sGetLRFromLevel;
        int i2;
        int i3;
        int i4;
        byte bGetParaLevelAt2;
        byte bGetLRFromLevel2;
        short s;
        int i5;
        Isolate[] isolateArr;
        if (b < 126) {
            verifyRange(b, 0, 126);
        }
        if (cArr == null) {
            cArr = new char[0];
        }
        if (this.reorderingMode == 3) {
            setParaRunsOnly(cArr, b);
            return;
        }
        this.paraBidi = null;
        this.text = cArr;
        int length = cArr.length;
        this.resultLength = length;
        this.originalLength = length;
        this.length = length;
        this.paraLevel = b;
        this.direction = (byte) (b & 1);
        this.paraCount = 1;
        this.dirProps = new byte[0];
        this.levels = new byte[0];
        this.runs = new BidiRun[0];
        this.isGoodLogicalToVisualRunsMap = false;
        InsertPoints insertPoints = this.insertPoints;
        insertPoints.size = 0;
        insertPoints.confirmed = 0;
        this.defaultParaLevel = IsDefaultLevel(b) ? b : (byte) 0;
        int i6 = this.length;
        if (i6 == 0) {
            if (IsDefaultLevel(b)) {
                this.paraLevel = (byte) (1 & this.paraLevel);
                this.defaultParaLevel = (byte) 0;
            }
            this.flags = DirPropFlagLR(b);
            this.runCount = 0;
            this.paraCount = 0;
            setParaSuccess();
            return;
        }
        this.runCount = -1;
        getDirPropsMemory(i6);
        this.dirProps = this.dirPropsMemory;
        getDirProps();
        int i7 = this.length;
        this.trailingWSStart = i7;
        if (bArr == null) {
            getLevelsMemory(i7);
            this.levels = this.levelsMemory;
            this.direction = resolveExplicitLevels();
        } else {
            this.levels = bArr;
            this.direction = checkExplicitLevels();
        }
        int i8 = this.isolateCount;
        if (i8 > 0 && ((isolateArr = this.isolates) == null || isolateArr.length < i8)) {
            this.isolates = new Isolate[i8 + 3];
        }
        this.isolateCount = -1;
        byte b3 = this.direction;
        if (b3 != 0 && b3 != 1) {
            switch (this.reorderingMode) {
                case 0:
                    this.impTabPair = impTab_DEFAULT;
                    if (bArr == null || this.paraCount > 1 || (this.flags & DirPropFlagMultiRuns) != 0) {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0 && this.dirProps[i2 - 1] == 7) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length || (this.levels[i3] != b2 && (DirPropFlag(this.dirProps[i3]) & MASK_BN_EXPLICIT) == 0)) {
                                }
                            }
                            i4 = this.length;
                            if (i3 < i4) {
                                bGetParaLevelAt2 = this.levels[i3];
                            } else {
                                bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                            }
                            if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                            } else {
                                bGetLRFromLevel2 = GetLRFromLevel(b2);
                            }
                            s = bGetLRFromLevel2;
                            if ((b2 & LEVEL_OVERRIDE) == 0) {
                                resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                            } else {
                                while (true) {
                                    byte[] bArr2 = this.levels;
                                    i5 = i2 + 1;
                                    bArr2[i2] = (byte) (bArr2[i2] & LEVEL_DEFAULT_RTL);
                                    if (i5 < i3) {
                                        i2 = i5;
                                    }
                                }
                            }
                            if (i3 < this.length) {
                                i2 = i3;
                                b2 = bGetParaLevelAt2;
                                sGetLRFromLevel = s;
                            }
                        }
                    } else {
                        resolveImplicitLevels(0, this.length, GetLRFromLevel(GetParaLevelAt(0)), GetLRFromLevel(GetParaLevelAt(this.length - 1)));
                    }
                    adjustWSLevels();
                    break;
                case 1:
                    this.impTabPair = impTab_NUMBERS_SPECIAL;
                    if (bArr == null) {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr3 = this.levels;
                                        i5 = i2 + 1;
                                        bArr3[i2] = (byte) (bArr3[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    } else {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr4 = this.levels;
                                        i5 = i2 + 1;
                                        bArr4[i2] = (byte) (bArr4[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    }
                    adjustWSLevels();
                    break;
                case 2:
                    this.impTabPair = impTab_GROUP_NUMBERS_WITH_R;
                    if (bArr == null) {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr5 = this.levels;
                                        i5 = i2 + 1;
                                        bArr5[i2] = (byte) (bArr5[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    } else {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr6 = this.levels;
                                        i5 = i2 + 1;
                                        bArr6[i2] = (byte) (bArr6[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    }
                    adjustWSLevels();
                    break;
                case 3:
                    throw new InternalError("Internal ICU error in setPara");
                case 4:
                    this.impTabPair = impTab_INVERSE_NUMBERS_AS_L;
                    if (bArr == null) {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr7 = this.levels;
                                        i5 = i2 + 1;
                                        bArr7[i2] = (byte) (bArr7[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    } else {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr8 = this.levels;
                                        i5 = i2 + 1;
                                        bArr8[i2] = (byte) (bArr8[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    }
                    adjustWSLevels();
                    break;
                case 5:
                    if ((this.reorderingOptions & 1) != 0) {
                        this.impTabPair = impTab_INVERSE_LIKE_DIRECT_WITH_MARKS;
                    } else {
                        this.impTabPair = impTab_INVERSE_LIKE_DIRECT;
                    }
                    if (bArr == null) {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr9 = this.levels;
                                        i5 = i2 + 1;
                                        bArr9[i2] = (byte) (bArr9[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    } else {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr10 = this.levels;
                                        i5 = i2 + 1;
                                        bArr10[i2] = (byte) (bArr10[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    }
                    adjustWSLevels();
                    break;
                case 6:
                    if ((this.reorderingOptions & 1) != 0) {
                        this.impTabPair = impTab_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS;
                    } else {
                        this.impTabPair = impTab_INVERSE_FOR_NUMBERS_SPECIAL;
                    }
                    if (bArr == null) {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr11 = this.levels;
                                        i5 = i2 + 1;
                                        bArr11[i2] = (byte) (bArr11[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    } else {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr12 = this.levels;
                                        i5 = i2 + 1;
                                        bArr12[i2] = (byte) (bArr12[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    }
                    adjustWSLevels();
                    break;
                default:
                    if (bArr == null) {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr13 = this.levels;
                                        i5 = i2 + 1;
                                        bArr13[i2] = (byte) (bArr13[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    } else {
                        bGetParaLevelAt = GetParaLevelAt(0);
                        b2 = this.levels[0];
                        if (bGetParaLevelAt < b2) {
                            bGetLRFromLevel = GetLRFromLevel(b2);
                        } else {
                            bGetLRFromLevel = GetLRFromLevel(bGetParaLevelAt);
                        }
                        sGetLRFromLevel = bGetLRFromLevel;
                        i2 = 0;
                        while (true) {
                            if (i2 > 0) {
                                sGetLRFromLevel = GetLRFromLevel(GetParaLevelAt(i2));
                            }
                            i3 = i2;
                            while (true) {
                                i3++;
                                if (i3 < this.length) {
                                }
                                i4 = this.length;
                                if (i3 < i4) {
                                    bGetParaLevelAt2 = this.levels[i3];
                                } else {
                                    bGetParaLevelAt2 = GetParaLevelAt(i4 - 1);
                                }
                                if (NoOverride(b2) < NoOverride(bGetParaLevelAt2)) {
                                    bGetLRFromLevel2 = GetLRFromLevel(bGetParaLevelAt2);
                                } else {
                                    bGetLRFromLevel2 = GetLRFromLevel(b2);
                                }
                                s = bGetLRFromLevel2;
                                if ((b2 & LEVEL_OVERRIDE) == 0) {
                                    resolveImplicitLevels(i2, i3, sGetLRFromLevel, s);
                                } else {
                                    while (true) {
                                        byte[] bArr14 = this.levels;
                                        i5 = i2 + 1;
                                        bArr14[i2] = (byte) (bArr14[i2] & LEVEL_DEFAULT_RTL);
                                        if (i5 < i3) {
                                            i2 = i5;
                                        }
                                    }
                                }
                                if (i3 < this.length) {
                                    i2 = i3;
                                    b2 = bGetParaLevelAt2;
                                    sGetLRFromLevel = s;
                                }
                            }
                        }
                    }
                    adjustWSLevels();
                    break;
            }
        } else {
            this.trailingWSStart = 0;
        }
        if (this.defaultParaLevel > 0 && (this.reorderingOptions & 1) != 0 && ((i = this.reorderingMode) == 5 || i == 6)) {
            int i9 = 0;
            while (i9 < this.paraCount) {
                int[] iArr = this.paras_limit;
                int i10 = iArr[i9] - 1;
                if (this.paras_level[i9] != 0) {
                    int i11 = i9 == 0 ? 0 : iArr[i9 - 1];
                    for (int i12 = i10; i12 >= i11; i12--) {
                        byte b4 = this.dirProps[i12];
                        if (b4 == 0) {
                            if (i12 < i10) {
                                while (this.dirProps[i10] == 7) {
                                    i10--;
                                }
                            }
                            addPoint(i10, 4);
                            break;
                        }
                        if ((DirPropFlag(b4) & MASK_R_AL) != 0) {
                            break;
                        }
                    }
                }
                i9++;
            }
        }
        int i13 = this.reorderingOptions & 2;
        int i14 = this.resultLength;
        if (i13 != 0) {
            this.resultLength = i14 - this.controlCount;
        } else {
            this.resultLength = i14 + this.insertPoints.size;
        }
        setParaSuccess();
    }

    public void setParaRunsOnly(char[] cArr, byte b) {
        int i;
        int i2;
        int i3 = 0;
        this.reorderingMode = 0;
        int length = cArr.length;
        if (length == 0) {
            setPara(cArr, b, (byte[]) null);
            this.reorderingMode = 3;
            return;
        }
        int i4 = this.reorderingOptions;
        int i5 = 2;
        if ((i4 & 1) > 0) {
            this.reorderingOptions = (i4 & (-2)) | 2;
        }
        byte b2 = (byte) (b & 1);
        setPara(cArr, b2, (byte[]) null);
        byte[] bArr = new byte[this.length];
        System.arraycopy(getLevels(), 0, bArr, 0, this.length);
        int i6 = this.trailingWSStart;
        String strWriteReordered = writeReordered((i4 & 2) | 64);
        int[] visualMap = getVisualMap();
        this.reorderingOptions = i4;
        int i7 = this.length;
        byte b3 = this.direction;
        this.reorderingMode = 5;
        setPara(strWriteReordered, (byte) (b2 ^ 1), (byte[]) null);
        BidiLine.getRuns(this);
        int i8 = this.runCount;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < i8) {
            BidiRun bidiRun = this.runs[i9];
            int i12 = i3;
            int i13 = bidiRun.limit - i11;
            if (i13 >= i5) {
                int i14 = bidiRun.start;
                int i15 = i14 + 1;
                while (i15 < i14 + i13) {
                    int i16 = visualMap[i15];
                    int i17 = visualMap[i15 - 1];
                    int i18 = i8;
                    int i19 = i13;
                    if (Bidi_Abs(i16 - i17) != 1 || bArr[i16] != bArr[i17]) {
                        i10++;
                    }
                    i15++;
                    i8 = i18;
                    i13 = i19;
                }
            }
            i9++;
            i11 += i13;
            i8 = i8;
            i3 = i12;
            i5 = 2;
        }
        int i20 = i8;
        int i21 = i3;
        if (i10 > 0) {
            getRunsMemory(i20 + i10);
            int i22 = this.runCount;
            if (i22 == 1) {
                this.runsMemory[i21] = this.runs[i21];
            } else {
                System.arraycopy(this.runs, i21, this.runsMemory, i21, i22);
            }
            this.runs = this.runsMemory;
            this.runCount += i10;
            for (int i23 = i20; i23 < this.runCount; i23++) {
                BidiRun[] bidiRunArr = this.runs;
                if (bidiRunArr[i23] == null) {
                    bidiRunArr[i23] = new BidiRun(0, 0, (byte) 0);
                }
            }
        }
        int i24 = i20 - 1;
        while (i24 >= 0) {
            int i25 = i24 + i10;
            BidiRun[] bidiRunArr2 = this.runs;
            int i26 = i24 == 0 ? bidiRunArr2[0].limit : bidiRunArr2[i24].limit - bidiRunArr2[i24 - 1].limit;
            BidiRun[] bidiRunArr3 = this.runs;
            BidiRun bidiRun2 = bidiRunArr3[i24];
            int i27 = bidiRun2.start;
            int i28 = bidiRun2.level & 1;
            int i29 = i24;
            if (i26 < 2) {
                if (i10 > 0) {
                    bidiRunArr3[i25].copyFrom(bidiRun2);
                }
                int i30 = visualMap[i27];
                BidiRun bidiRun3 = this.runs[i25];
                bidiRun3.start = i30;
                bidiRun3.level = (byte) (bArr[i30] ^ i28);
            } else {
                if (i28 > 0) {
                    i = (i26 + i27) - 1;
                    i2 = 1;
                } else {
                    i = i27;
                    i27 = (i26 + i27) - 1;
                    i2 = -1;
                }
                int i31 = i27;
                while (i27 != i) {
                    int i32 = visualMap[i27];
                    int i33 = i27 + i2;
                    int i34 = visualMap[i33];
                    int i35 = i25;
                    int i36 = i2;
                    if (Bidi_Abs(i32 - i34) == 1 && bArr[i32] == bArr[i34]) {
                        i25 = i35;
                    } else {
                        int iBidi_Min = Bidi_Min(visualMap[i31], i32);
                        BidiRun[] bidiRunArr4 = this.runs;
                        BidiRun bidiRun4 = bidiRunArr4[i35];
                        bidiRun4.start = iBidi_Min;
                        bidiRun4.level = (byte) (bArr[iBidi_Min] ^ i28);
                        BidiRun bidiRun5 = bidiRunArr4[i29];
                        bidiRun4.limit = bidiRun5.limit;
                        bidiRun5.limit -= Bidi_Abs(i27 - i31) + 1;
                        BidiRun[] bidiRunArr5 = this.runs;
                        BidiRun bidiRun6 = bidiRunArr5[i29];
                        int i37 = bidiRun6.insertRemove & 10;
                        bidiRunArr5[i35].insertRemove = i37;
                        bidiRun6.insertRemove &= ~i37;
                        i10--;
                        i25 = i35 - 1;
                        i31 = i33;
                    }
                    i27 = i33;
                    i2 = i36;
                }
                int i38 = i25;
                if (i10 > 0) {
                    BidiRun[] bidiRunArr6 = this.runs;
                    bidiRunArr6[i38].copyFrom(bidiRunArr6[i29]);
                }
                int iBidi_Min2 = Bidi_Min(visualMap[i31], visualMap[i]);
                BidiRun bidiRun7 = this.runs[i38];
                bidiRun7.start = iBidi_Min2;
                bidiRun7.level = (byte) (bArr[iBidi_Min2] ^ i28);
            }
            i24 = i29 - 1;
        }
        this.paraLevel = (byte) (this.paraLevel ^ 1);
        this.text = cArr;
        this.length = i7;
        this.originalLength = length;
        this.direction = b3;
        this.levels = bArr;
        this.trailingWSStart = i6;
        if (this.runCount > 1) {
            this.direction = (byte) 2;
        }
        this.reorderingMode = 3;
    }

    public void setReorderingMode(int i) {
        if (i < 0 || i >= 7) {
            return;
        }
        this.reorderingMode = i;
        this.isInverse = i == 4;
    }

    public void setReorderingOptions(int i) {
        if ((i & 2) != 0) {
            this.reorderingOptions = i & (-2);
        } else {
            this.reorderingOptions = i;
        }
    }

    public boolean testDirPropFlagAt(int i, int i2) {
        return (DirPropFlag(this.dirProps[i2]) & i) != 0;
    }

    public void verifyRange(int i, int i2, int i3) {
        if (i < i2 || i >= i3) {
            og.e(i3, cq.p("Value ", i, " is out of range ", i2, " to "));
        }
    }

    public void verifyValidPara() {
        if (this != this.paraBidi) {
            throw new IllegalStateException();
        }
    }

    public void verifyValidParaOrLine() {
        Bidi bidi = this.paraBidi;
        if (this == bidi) {
            return;
        }
        if (bidi == null || bidi != bidi.paraBidi) {
            throw new IllegalStateException();
        }
    }

    public String writeReordered(int i) {
        verifyValidParaOrLine();
        return this.length == 0 ? "" : BidiWriter.writeReordered(this, i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LevState {
        short[] impAct;
        byte[][] impTab;
        int lastStrongRTL;
        byte runLevel;
        int runStart;
        int startL2EN;
        int startON;
        short state;

        public /* synthetic */ LevState(int i) {
            this();
        }

        private LevState() {
        }
    }

    public void getDirPropsMemory(int i) {
        getDirPropsMemory(this.mayAllocateText, i);
    }

    public void getLevelsMemory(int i) {
        getLevelsMemory(this.mayAllocateText, i);
    }

    public void getRunsMemory(int i) {
        getRunsMemory(this.mayAllocateRuns, i);
    }

    public Bidi() {
        this(0, 0);
    }

    public Bidi(String str, int i) {
        this(str.toCharArray(), 0, null, 0, str.length(), i);
    }

    public Bidi(AttributedCharacterIterator attributedCharacterIterator) {
        this();
        setPara(attributedCharacterIterator);
    }

    public Bidi(char[] cArr, int i, byte[] bArr, int i2, int i3, int i4) {
        byte[] bArr2;
        this();
        byte b = 1;
        if (i4 != 1) {
            b = LEVEL_DEFAULT_LTR;
            if (i4 != 126) {
                b = LEVEL_DEFAULT_RTL;
                if (i4 != 127) {
                    b = 0;
                }
            }
        }
        if (bArr == null) {
            bArr2 = null;
        } else {
            byte[] bArr3 = new byte[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                byte b2 = bArr[i5 + i2];
                if (b2 < 0) {
                    b2 = (byte) ((-b2) | (-128));
                }
                bArr3[i5] = b2;
            }
            bArr2 = bArr3;
        }
        if (i == 0 && i3 == cArr.length) {
            setPara(cArr, b, bArr2);
            return;
        }
        char[] cArr2 = new char[i3];
        System.arraycopy(cArr, i, cArr2, 0, i3);
        setPara(cArr2, b, bArr2);
    }

    public void setPara(String str, byte b, byte[] bArr) {
        if (str == null) {
            setPara(new char[0], b, bArr);
        } else {
            setPara(str.toCharArray(), b, bArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPara(AttributedCharacterIterator attributedCharacterIterator) {
        byte bByteValue;
        Boolean bool = (Boolean) attributedCharacterIterator.getAttribute(TextAttribute.RUN_DIRECTION);
        byte b = bool == null ? 126 : !bool.equals(TextAttribute.RUN_DIRECTION_LTR);
        int endIndex = attributedCharacterIterator.getEndIndex() - attributedCharacterIterator.getBeginIndex();
        byte[] bArr = new byte[endIndex];
        char[] cArr = new char[endIndex];
        char cFirst = attributedCharacterIterator.first();
        byte[] bArr2 = null;
        int i = 0;
        while (cFirst != 65535) {
            cArr[i] = cFirst;
            Integer num = (Integer) attributedCharacterIterator.getAttribute(TextAttribute.BIDI_EMBEDDING);
            if (num != null && (bByteValue = num.byteValue()) != 0) {
                if (bByteValue < 0) {
                    bArr[i] = (byte) ((0 - bByteValue) | (-128));
                } else {
                    bArr[i] = bByteValue;
                }
                bArr2 = bArr;
            }
            cFirst = attributedCharacterIterator.next();
            i++;
        }
        NumericShaper numericShaper = (NumericShaper) attributedCharacterIterator.getAttribute(TextAttribute.NUMERIC_SHAPING);
        if (numericShaper != null) {
            numericShaper.shape(cArr, 0, endIndex);
        }
        setPara(cArr, b, bArr2);
    }
}
