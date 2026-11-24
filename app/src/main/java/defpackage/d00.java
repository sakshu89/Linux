package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d00 {
    public static final float[] a;
    public static final float[] b;
    public static final x13 c;
    public static final x13 d;
    public static final y72 e;
    public static final y72 f;
    public static final y72 g;
    public static final y72 h;
    public static final y72 i;
    public static final y72 j;
    public static final y72 k;
    public static final y72 l;
    public static final y72 m;
    public static final y72 n;
    public static final y72 o;
    public static final y72 p;
    public static final y72 q;
    public static final y72 r;
    public static final j61 s;
    public static final j61 t;
    public static final y72 u;
    public static final y72 v;
    public static final y72 w;
    public static final tp1 x;
    public static final b00[] y;

    static {
        float[] fArr = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        a = fArr;
        float[] fArr2 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        b = fArr2;
        float[] fArr3 = {0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f};
        x13 x13Var = new x13(2.4d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d);
        x13 x13Var2 = new x13(2.2d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d);
        x13 x13Var3 = new x13(-3.0d, 2.0d, 2.0d, 5.591816309728916d, 0.28466892d, 0.55991073d, -0.685490157d);
        c = x13Var3;
        x13 x13Var4 = new x13(-2.0d, -1.555223d, 1.860454d, 0.012683313515655966d, 18.8515625d, -18.6875d, 6.277394636015326d);
        d = x13Var4;
        ka3 ka3Var = qz3.d;
        y72 y72Var = new y72("sRGB IEC61966-2.1", fArr, ka3Var, x13Var, 0);
        e = y72Var;
        y72 y72Var2 = new y72("sRGB IEC61966-2.1 (Linear)", fArr, ka3Var, 1.0d, 0.0f, 1.0f, 1);
        f = y72Var2;
        y72 y72Var3 = new y72("scRGB-nl IEC 61966-2-2:2003", fArr, ka3Var, null, new og(18), new og(19), -0.799f, 2.399f, x13Var, 2);
        g = y72Var3;
        y72 y72Var4 = new y72("scRGB IEC 61966-2-2:2003", fArr, ka3Var, 1.0d, -0.5f, 7.499f, 3);
        h = y72Var4;
        y72 y72Var5 = new y72("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, ka3Var, new x13(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d), 4);
        i = y72Var5;
        y72 y72Var6 = new y72("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, ka3Var, new x13(2.2222222222222223d, 0.9096697898662786d, 0.09033021013372146d, 0.2222222222222222d, 0.08145d), 5);
        j = y72Var6;
        y72 y72Var7 = new y72("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new ka3(0.314f, 0.351f), 2.6d, 0.0f, 1.0f, 6);
        k = y72Var7;
        y72 y72Var8 = new y72("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, ka3Var, x13Var, 7);
        l = y72Var8;
        double d2 = 0.2222222222222222d;
        double d3 = 0.081d;
        double d4 = 2.2222222222222223d;
        double d5 = 0.9099181073703367d;
        double d6 = 0.09008189262966333d;
        y72 y72Var9 = new y72("NTSC (1953)", fArr2, qz3.a, new x13(d4, d5, d6, d2, d3), 8);
        m = y72Var9;
        y72 y72Var10 = new y72("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, ka3Var, new x13(d4, d5, d6, d2, d3), 9);
        n = y72Var10;
        y72 y72Var11 = new y72("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, ka3Var, 2.2d, 0.0f, 1.0f, 10);
        o = y72Var11;
        y72 y72Var12 = new y72("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 1.0E-4f}, qz3.b, new x13(1.8d, 1.0d, 0.0d, 0.0625d, 0.031248d), 11);
        p = y72Var12;
        ka3 ka3Var2 = qz3.c;
        y72 y72Var13 = new y72("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 1.0E-4f, -0.077f}, ka3Var2, 1.0d, -65504.0f, 65504.0f, 12);
        q = y72Var13;
        y72 y72Var14 = new y72("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, ka3Var2, 1.0d, -65504.0f, 65504.0f, 13);
        r = y72Var14;
        j61 j61Var = new j61(14, 1, 12884901889L, "Generic XYZ");
        s = j61Var;
        j61 j61Var2 = new j61(15, 0, 12884901890L, "Generic L*a*b*");
        t = j61Var2;
        y72 y72Var15 = new y72("None", fArr, ka3Var, x13Var2, 16);
        u = y72Var15;
        y72 y72Var16 = new y72("Hybrid Log Gamma encoding", fArr3, ka3Var, null, new og(20), new og(21), 0.0f, 1.0f, x13Var3, 17);
        v = y72Var16;
        y72 y72Var17 = new y72("Perceptual Quantizer encoding", fArr3, ka3Var, null, new og(22), new og(23), 0.0f, 1.0f, x13Var4, 18);
        w = y72Var17;
        tp1 tp1Var = new tp1(19, 12884901890L, "Oklab");
        x = tp1Var;
        y = new b00[]{y72Var, y72Var2, y72Var3, y72Var4, y72Var5, y72Var6, y72Var7, y72Var8, y72Var9, y72Var10, y72Var11, y72Var12, y72Var13, y72Var14, j61Var, j61Var2, y72Var15, y72Var16, y72Var17, tp1Var};
    }

    public static double a(x13 x13Var, double d2) {
        double d3 = d2 < 0.0d ? -1.0d : 1.0d;
        double d4 = d2 * d3;
        double d5 = x13Var.b;
        double d6 = x13Var.c;
        double d7 = x13Var.d;
        double d8 = x13Var.e;
        double d9 = x13Var.f;
        double d10 = d5 * d4;
        return (x13Var.g + 1.0d) * d3 * (d10 <= 1.0d ? Math.pow(d10, d6) : Math.exp((d4 - d9) * d7) + d8);
    }

    public static double b(x13 x13Var, double d2) {
        double d3 = d2 < 0.0d ? -1.0d : 1.0d;
        double d4 = 1.0d / x13Var.b;
        double d5 = 1.0d / x13Var.c;
        double d6 = 1.0d / x13Var.d;
        double d7 = x13Var.e;
        double d8 = x13Var.f;
        double d9 = (d2 * d3) / (x13Var.g + 1.0d);
        return d3 * (d9 <= 1.0d ? Math.pow(d9, d5) * d4 : (Math.log(d9 - d7) * d6) + d8);
    }

    public static double c(x13 x13Var, double d2) {
        double d3 = d2 < 0.0d ? -1.0d : 1.0d;
        double d4 = d2 * d3;
        double d5 = x13Var.b;
        double d6 = x13Var.d;
        double dPow = (Math.pow(d4, d6) * x13Var.c) + d5;
        return Math.pow((dPow >= 0.0d ? dPow : 0.0d) / ((Math.pow(d4, d6) * x13Var.f) + x13Var.e), x13Var.g) * d3;
    }

    public static double d(x13 x13Var, double d2) {
        double d3 = d2 < 0.0d ? -1.0d : 1.0d;
        double d4 = d2 * d3;
        double d5 = -x13Var.b;
        double d6 = x13Var.e;
        double d7 = 1.0d / x13Var.g;
        return Math.pow(Math.max((Math.pow(d4, d7) * d6) + d5, 0.0d) / ((Math.pow(d4, d7) * (-x13Var.f)) + x13Var.c), 1.0d / x13Var.d) * d3;
    }
}
