package defpackage;

import android.text.Layout;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vl implements hq0 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Serializable e;
    public final /* synthetic */ Object f;

    public /* synthetic */ vl(long j, float[] fArr, r42 r42Var, q42 q42Var) {
        this.b = j;
        this.c = fArr;
        this.e = r42Var;
        this.f = q42Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        long j;
        q43 q43Var;
        float[] fArr;
        int i;
        float fA;
        float fA2;
        int i2 = this.a;
        q43 q43Var2 = q43.a;
        Object obj2 = this.f;
        Serializable serializable = this.e;
        Object obj3 = this.c;
        switch (i2) {
            case 0:
                l42 l42Var = (l42) obj3;
                t42 t42Var = (t42) serializable;
                long j2 = this.b;
                nl nlVar = (nl) obj2;
                p71 p71Var = (p71) obj;
                p71Var.a();
                float f = l42Var.a;
                float f2 = l42Var.b;
                ew ewVar = p71Var.a;
                ((q82) ewVar.b.b).J(f, f2);
                try {
                    rf0.T(p71Var, (p9) t42Var.a, j2, 0L, 0.0f, nlVar, 0, 890);
                    return q43Var2;
                } finally {
                    ((q82) ewVar.b.b).J(-f, -f2);
                }
            default:
                float[] fArr2 = (float[]) obj3;
                r42 r42Var = (r42) serializable;
                q42 q42Var = (q42) obj2;
                au1 au1Var = (au1) obj;
                int i3 = au1Var.b;
                ia iaVar = au1Var.a;
                int iE = au1Var.c;
                long j3 = this.b;
                int iF = i3 > oz2.f(j3) ? au1Var.b : oz2.f(j3);
                if (iE >= oz2.e(j3)) {
                    iE = oz2.e(j3);
                }
                long jA = hc4.a(au1Var.d(iF), au1Var.d(iE));
                int i4 = r42Var.a;
                ez2 ez2Var = iaVar.d;
                int iF2 = oz2.f(jA);
                int iE2 = oz2.e(jA);
                Layout layout = ez2Var.f;
                int length = layout.getText().length();
                if (iF2 < 0) {
                    a11.a("startOffset must be > 0");
                }
                if (iF2 >= length) {
                    a11.a("startOffset must be less than text length");
                }
                if (iE2 <= iF2) {
                    a11.a("endOffset must be greater than startOffset");
                }
                if (iE2 > length) {
                    a11.a("endOffset must be smaller or equal to text length");
                }
                if (fArr2.length - i4 < (iE2 - iF2) * 4) {
                    a11.a("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
                }
                int lineForOffset = layout.getLineForOffset(iF2);
                int lineForOffset2 = layout.getLineForOffset(iE2 - 1);
                rw0 rw0Var = new rw0(ez2Var);
                if (lineForOffset <= lineForOffset2) {
                    while (true) {
                        int lineStart = layout.getLineStart(lineForOffset);
                        j = jA;
                        int iF3 = ez2Var.f(lineForOffset);
                        int iMax = Math.max(iF2, lineStart);
                        int iMin = Math.min(iE2, iF3);
                        float fG = ez2Var.g(lineForOffset);
                        float fE = ez2Var.e(lineForOffset);
                        q43Var = q43Var2;
                        fArr = fArr2;
                        boolean z = false;
                        boolean z2 = layout.getParagraphDirection(lineForOffset) == 1;
                        int i5 = i4;
                        int i6 = iMax;
                        while (i6 < iMin) {
                            boolean zIsRtlCharAt = layout.isRtlCharAt(i6);
                            if (!z2 || zIsRtlCharAt) {
                                if (z2 && zIsRtlCharAt) {
                                    z = false;
                                    float fA3 = rw0Var.a(i6, false, false, false);
                                    i = iMin;
                                    fA = rw0Var.a(i6 + 1, true, true, false);
                                    fA2 = fA3;
                                } else {
                                    i = iMin;
                                    z = false;
                                    if (z2 || !zIsRtlCharAt) {
                                        fA = rw0Var.a(i6, false, false, false);
                                        fA2 = rw0Var.a(i6 + 1, true, true, false);
                                    } else {
                                        fA2 = rw0Var.a(i6, false, false, true);
                                        fA = rw0Var.a(i6 + 1, true, true, true);
                                    }
                                }
                                fArr[i5] = fA;
                                fArr[i5 + 1] = fG;
                                fArr[i5 + 2] = fA2;
                                fArr[i5 + 3] = fE;
                                i5 += 4;
                                i6++;
                                iMin = i;
                            } else {
                                fA = rw0Var.a(i6, z, z, true);
                                i = iMin;
                                fA2 = rw0Var.a(i6 + 1, true, true, true);
                            }
                            z = false;
                            fArr[i5] = fA;
                            fArr[i5 + 1] = fG;
                            fArr[i5 + 2] = fA2;
                            fArr[i5 + 3] = fE;
                            i5 += 4;
                            i6++;
                            iMin = i;
                        }
                        if (lineForOffset != lineForOffset2) {
                            lineForOffset++;
                            jA = j;
                            i4 = i5;
                            q43Var2 = q43Var;
                            fArr2 = fArr;
                        }
                    }
                } else {
                    j = jA;
                    q43Var = q43Var2;
                    fArr = fArr2;
                }
                int iD = (oz2.d(j) * 4) + r42Var.a;
                for (int i7 = r42Var.a; i7 < iD; i7 += 4) {
                    int i8 = i7 + 1;
                    float f3 = fArr[i8];
                    float f4 = q42Var.a;
                    fArr[i8] = f3 + f4;
                    int i9 = i7 + 3;
                    fArr[i9] = fArr[i9] + f4;
                }
                r42Var.a = iD;
                q42Var.a = iaVar.b() + q42Var.a;
                return q43Var;
        }
    }

    public /* synthetic */ vl(l42 l42Var, t42 t42Var, long j, nl nlVar) {
        this.c = l42Var;
        this.e = t42Var;
        this.b = j;
        this.f = nlVar;
    }
}
