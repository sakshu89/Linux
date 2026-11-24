package defpackage;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.util.Log;
import android.view.textclassifier.TextClassification;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zb implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ zb(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:173:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:198:0x024e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0249 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x024b A[LOOP:0: B:80:0x0217->B:90:0x024b, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.fq0
    public final Object a() throws PendingIntent.CanceledException {
        List listG;
        nl2 nl2VarD;
        long j;
        hz2 hz2VarD;
        ua1 ua1Var;
        be beVar;
        zo1 zo1Var = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        int i = 1;
        switch (this.a) {
            case 0:
                ((t42) this.b).a = ((fq0) this.c).a();
                return q43.a;
            case 1:
                ((bx) this.b).s(this.c);
                return q43.a;
            case 2:
                nk nkVar = (nk) this.b;
                p71 p71Var = (p71) this.c;
                nkVar.f0 = nkVar.Y.a(p71Var.a.c(), p71Var.getLayoutDirection(), p71Var);
                return q43.a;
            case 3:
                ty2 ty2Var = (ty2) this.b;
                mm1 mm1Var = (mm1) this.c;
                if (!oz2.b(ty2Var.b, ((ty2) mm1Var.getValue()).b) || !g31.a(ty2Var.c, ((ty2) mm1Var.getValue()).c)) {
                    mm1Var.setValue(ty2Var);
                }
                return q43.a;
            case 4:
                e30 e30Var = (e30) this.b;
                Object obj = this.c;
                x20 x20Var = e30Var.a;
                ol2 ol2Var = x20Var.c;
                nl2 nl2VarD2 = ol2Var.d();
                int i2 = 0;
                while (true) {
                    try {
                        if (i2 < ol2Var.b) {
                            if (nl2VarD2.l(i2)) {
                                Object objN = nl2VarD2.n(i2);
                                if (objN != obj) {
                                    k52 k52Var = objN instanceof k52 ? (k52) objN : null;
                                    if ((k52Var != null ? k52Var.a : null) == obj) {
                                    }
                                }
                                zo1 zo1Var2 = new zo1(i2, null);
                                nl2VarD2.c();
                                zo1Var = zo1Var2;
                                if (zo1Var != null) {
                                    int i3 = zo1Var.a;
                                    Integer num = zo1Var.b;
                                    nl2VarD = ol2Var.d();
                                    try {
                                        ArrayList arrayListC = cj4.c(nl2VarD, i3, num);
                                        nl2VarD.c();
                                        listG = mz.G(arrayListC, x20Var.E());
                                    } catch (Throwable th) {
                                        nl2VarD.c();
                                        throw th;
                                    }
                                } else {
                                    listG = ii0.a;
                                }
                                return new l20(listG);
                            }
                            int[] iArr = nl2VarD2.b;
                            int i4 = i2 + 1;
                            int iB = (i4 < nl2VarD2.c ? iArr[(i4 * 5) + 4] : nl2VarD2.e) - ql2.b(i2, iArr);
                            int i5 = 0;
                            while (true) {
                                if (i5 >= iB) {
                                    i2 = i4;
                                } else {
                                    Object objH = nl2VarD2.h(i2, i5);
                                    if (objH != obj) {
                                        k52 k52Var2 = objH instanceof k52 ? (k52) objH : null;
                                        if ((k52Var2 != null ? k52Var2.a : null) != obj) {
                                            i5++;
                                        }
                                    }
                                    zo1Var = new zo1(i2, Integer.valueOf(i5));
                                }
                            }
                        }
                        nl2VarD2.c();
                        if (zo1Var != null) {
                            int i6 = zo1Var.a;
                            Integer num2 = zo1Var.b;
                            nl2VarD = ol2Var.d();
                            ArrayList arrayListC2 = cj4.c(nl2VarD, i6, num2);
                            nl2VarD.c();
                            listG = mz.G(arrayListC2, x20Var.E());
                        } else {
                            listG = ii0.a;
                        }
                        return new l20(listG);
                    } catch (Throwable th2) {
                        nl2VarD2.c();
                        throw th2;
                    }
                }
            case 5:
                return new e21(ap4.b(((dx2) this.b).f((y61) ((fq0) this.c).a())));
            case 6:
                ((jx2) this.b).d.j((ox2) this.c);
                return q43.a;
            case 7:
                ((t42) this.b).a = ij4.a((no0) this.c, xw1.a);
                return q43.a;
            case 8:
                mt0 mt0Var = (mt0) this.b;
                zc1 zc1Var = (zc1) this.c;
                AudioTrack.Builder builder = new AudioTrack.Builder();
                AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(16).setContentType(1).build();
                audioAttributesBuild.getClass();
                AudioTrack audioTrackBuild = builder.setAudioAttributes(audioAttributesBuild).setAudioFormat(new AudioFormat.Builder().setSampleRate(24000).setChannelMask(4).setEncoding(2).build()).setBufferSizeInBytes(Math.max(9600, AudioTrack.getMinBufferSize(24000, 4, 2))).setTransferMode(1).build();
                audioTrackBuild.getClass();
                try {
                    if (audioTrackBuild.getState() != 1) {
                        throw new IllegalStateException("Could not open audio playback.");
                    }
                    if (Build.VERSION.SDK_INT >= 31) {
                        audioTrackBuild.setStartThresholdInFrames(1);
                    }
                    mt0Var.s = audioTrackBuild;
                    mt0.f(mt0Var, "nativeAudioTracksCreated");
                    return new kf(audioTrackBuild, mt0Var, zc1Var, 12);
                } catch (Throwable th3) {
                    audioTrackBuild.release();
                    throw th3;
                }
            case 9:
                return new ha1((ba2) this.b, ji0.a, (aa2) this.c);
            case 10:
                kf kfVar = (kf) this.b;
                b42 b42Var = (b42) this.c;
                if (((hh) kfVar.b).get() == 0) {
                    b42Var.a();
                }
                return q43.a;
            case 11:
                ((hq0) this.b).j(((zx) this.c).b);
                return q43.a;
            case 12:
                ((hq0) this.b).j((h52) this.c);
                return q43.a;
            case 13:
                hm1 hm1Var = (hm1) this.b;
                g30 g30Var = (g30) this.c;
                Object[] objArr4 = hm1Var.b;
                long[] jArr = hm1Var.a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i7 = 0;
                    while (true) {
                        long j2 = jArr[i7];
                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i8 = 8 - ((~(i7 - length)) >>> 31);
                            for (int i9 = 0; i9 < i8; i9++) {
                                if ((255 & j2) < 128) {
                                    g30Var.A(objArr4[(i7 << 3) + i9]);
                                }
                                j2 >>= 8;
                            }
                            if (i8 == 8) {
                                if (i7 != length) {
                                    i7++;
                                }
                            }
                        } else if (i7 != length) {
                            i7++;
                        }
                    }
                }
                return q43.a;
            case 14:
                x42 x42Var = (x42) this.b;
                CharSequence charSequence = (CharSequence) this.c;
                x42Var.getClass();
                charSequence.getClass();
                Matcher matcher = x42Var.a.matcher(charSequence);
                matcher.getClass();
                return ty3.a(matcher, 0, charSequence);
            case 15:
                gj2 gj2Var = (gj2) this.b;
                fq0 fq0Var = (fq0) this.c;
                if (!(gj2Var.f instanceof q51)) {
                    fq0Var.a();
                }
                return q43.a;
            case 16:
                ((hq0) this.b).j((b60) this.c);
                return q43.a;
            case 17:
                ((hq0) this.b).j(Boolean.valueOf(!((eo2) this.c).m));
                return q43.a;
            case 18:
                hq0 hq0Var = (hq0) this.b;
                zt1 zt1Var = (zt1) this.c;
                zt1 zt1Var2 = zt1.a;
                if (zt1Var == zt1Var2) {
                    zt1Var2 = zt1.c;
                }
                hq0Var.j(zt1Var2);
                return q43.a;
            case 19:
                so2 so2Var = (so2) this.b;
                String str = (String) this.c;
                in2 in2Var = so2Var.b;
                in2Var.getClass();
                str.getClass();
                return new l90(i, new aa(in2Var, str, objArr == true ? 1 : 0, 14));
            case 20:
                so2 so2Var2 = (so2) this.b;
                Map map = (Map) this.c;
                in2 in2Var2 = so2Var2.b;
                in2Var2.getClass();
                map.getClass();
                return new l90(i, new aa(in2Var2, map, objArr2 == true ? 1 : 0, 15));
            case 21:
                Context context = (Context) this.b;
                TextClassification textClassification = (TextClassification) this.c;
                String text = textClassification.getText();
                PendingIntent activity = PendingIntent.getActivity(context, text != null ? text.hashCode() : 0, textClassification.getIntent(), 201326592);
                if (Build.VERSION.SDK_INT >= 34) {
                    try {
                        activity.send(ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());
                    } catch (PendingIntent.CanceledException e) {
                        Log.e("TextClassification", "error sending pendingIntent: " + activity + " error: " + e);
                    }
                    break;
                } else {
                    activity.send();
                }
                return q43.a;
            case 22:
                ny2 ny2Var = (ny2) this.b;
                long j3 = ((l21) ((mm1) this.c).getValue()).a;
                jp1 jp1VarI = ny2Var.i();
                long jFloatToRawIntBits = 9205357640488583168L;
                if (jp1VarI != null) {
                    long j4 = jp1VarI.a;
                    be beVarM = ny2Var.m();
                    if (beVarM != null && beVarM.b.length() != 0) {
                        pv0 pv0Var = (pv0) ny2Var.r.getValue();
                        int i10 = pv0Var == null ? -1 : py2.a[pv0Var.ordinal()];
                        if (i10 != -1) {
                            if (i10 == 1 || i10 == 2) {
                                long j5 = ny2Var.n().b;
                                int i11 = oz2.c;
                                j = j5 >> 32;
                            } else {
                                if (i10 != 3) {
                                    dk0.l();
                                    return null;
                                }
                                long j6 = ny2Var.n().b;
                                int i12 = oz2.c;
                                j = j6 & 4294967295L;
                            }
                            int i13 = (int) j;
                            ua1 ua1Var2 = ny2Var.d;
                            if (ua1Var2 != null && (hz2VarD = ua1Var2.d()) != null && (ua1Var = ny2Var.d) != null && (beVar = ua1Var.a.a) != null) {
                                int iC = ky3.c(ny2Var.b.l(i13), 0, beVar.b.length());
                                float fIntBitsToFloat = Float.intBitsToFloat((int) (hz2VarD.d(j4) >> 32));
                                gz2 gz2Var = hz2VarD.a;
                                fl1 fl1Var = gz2Var.b;
                                int iD = fl1Var.d(iC);
                                float fD = gz2Var.d(iD);
                                float fE = gz2Var.e(iD);
                                float fB = ky3.b(fIntBitsToFloat, Math.min(fD, fE), Math.max(fD, fE));
                                if (l21.a(j3, 0L) || Math.abs(fIntBitsToFloat - fB) <= ((int) (j3 >> 32)) / 2) {
                                    float f = fl1Var.f(iD);
                                    jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fB)) << 32) | (((long) Float.floatToRawIntBits(((fl1Var.b(iD) - f) / 2.0f) + f)) & 4294967295L);
                                }
                            }
                        }
                    }
                }
                return new jp1(jFloatToRawIntBits);
            default:
                uf4.b((s70) this.b, null, new l2(this.c, (x50) (objArr3 == true ? 1 : 0), 18), 1);
                return q43.a;
        }
    }
}
