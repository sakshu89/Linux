package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class e8 {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static ia a(String str, yz2 yz2Var, long j, jc0 jc0Var, qo0 qo0Var, int i, int i2) {
        ii0 ii0Var = ii0.a;
        return new ia(new ma(str, yz2Var, ii0Var, ii0Var, qo0Var, jc0Var), i, 1, j);
    }

    public static final int b(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final float c(float[] fArr, int i, float[] fArr2, int i2) {
        int i3 = i * 4;
        return (fArr[i3 + 3] * fArr2[12 + i2]) + (fArr[i3 + 2] * fArr2[8 + i2]) + (fArr[i3 + 1] * fArr2[4 + i2]) + (fArr[i3] * fArr2[i2]);
    }

    public static final void d(float[] fArr, float[] fArr2) {
        float fC = c(fArr2, 0, fArr, 0);
        float fC2 = c(fArr2, 0, fArr, 1);
        float fC3 = c(fArr2, 0, fArr, 2);
        float fC4 = c(fArr2, 0, fArr, 3);
        float fC5 = c(fArr2, 1, fArr, 0);
        float fC6 = c(fArr2, 1, fArr, 1);
        float fC7 = c(fArr2, 1, fArr, 2);
        float fC8 = c(fArr2, 1, fArr, 3);
        float fC9 = c(fArr2, 2, fArr, 0);
        float fC10 = c(fArr2, 2, fArr, 1);
        float fC11 = c(fArr2, 2, fArr, 2);
        float fC12 = c(fArr2, 2, fArr, 3);
        float fC13 = c(fArr2, 3, fArr, 0);
        float fC14 = c(fArr2, 3, fArr, 1);
        float fC15 = c(fArr2, 3, fArr, 2);
        float fC16 = c(fArr2, 3, fArr, 3);
        fArr[0] = fC;
        fArr[1] = fC2;
        fArr[2] = fC3;
        fArr[3] = fC4;
        fArr[4] = fC5;
        fArr[5] = fC6;
        fArr[6] = fC7;
        fArr[7] = fC8;
        fArr[8] = fC9;
        fArr[9] = fC10;
        fArr[10] = fC11;
        fArr[11] = fC12;
        fArr[12] = fC13;
        fArr[13] = fC14;
        fArr[14] = fC15;
        fArr[15] = fC16;
    }
}
