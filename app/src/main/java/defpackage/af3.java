package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class af3 extends pk3 implements fr3 {
    public final Context a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public ce1 f;

    public af3(Context context, String str, String str2, String str3, boolean z) {
        super("com.google.mlkit.vision.text.aidls.ITextRecognizer");
        this.a = context;
        this.b = str;
        this.d = str2;
        this.e = str3;
        this.c = z;
    }

    @Override // defpackage.pk3
    public final boolean a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        boolean z;
        bf3 bf3VarA;
        int i2;
        pp3 pp3VarA;
        int i3;
        int i4;
        Matrix matrix;
        aq3 aq3VarB;
        tp3 tp3Var;
        aq3 aq3VarB2;
        tp3 tp3Var2;
        tp3 tp3Var3;
        int i5;
        int i6 = 1;
        if (i == 1) {
            String str = this.e;
            if (this.f == null) {
                System.loadLibrary("mlkit_google_ocr_pipeline");
                if (str == null || str.isEmpty()) {
                    str = "";
                }
                String str2 = this.b;
                String str3 = this.d;
                boolean z2 = this.c;
                if (str2 == null) {
                    dk0.n("Null configLabel");
                    return false;
                }
                if (str3 == null) {
                    str3 = "mlkit-google-ocr-models";
                }
                ce1 ce1Var = new ce1(this.a, new vm3(str2, str3, str, z2));
                this.f = ce1Var;
                ok3 ok3VarB = ce1Var.b();
                if (ok3VarB.b.c()) {
                    throw ((RemoteException) ok3VarB.b.a());
                }
            }
            parcel2.writeNoException();
            return true;
        }
        if (i == 2) {
            ce1 ce1Var2 = this.f;
            if (ce1Var2 != null) {
                jo3 jo3Var = (jo3) ce1Var2.e;
                if (jo3Var != null) {
                    if (ce1Var2.a) {
                        long j = jo3Var.c;
                        if (j == 0) {
                            og.n("Pipeline has been closed or was not initialized");
                            return false;
                        }
                        if (!jo3Var.b.stop(j)) {
                            og.n("Pipeline did not stop successfully.");
                            return false;
                        }
                    }
                    jo3 jo3Var2 = (jo3) ce1Var2.e;
                    synchronized (jo3Var2) {
                        long j2 = jo3Var2.c;
                        if (j2 != 0) {
                            jo3Var2.b.stop(j2);
                            jo3Var2.b.close(jo3Var2.c, jo3Var2.d, jo3Var2.e, jo3Var2.f, jo3Var2.g);
                            jo3Var2.c = 0L;
                            jo3Var2.b.a();
                        }
                    }
                    ce1Var2.e = null;
                }
                ce1Var2.a = false;
                z = true;
                ce1Var2.b = true;
                this.f = null;
            } else {
                z = true;
            }
            parcel2.writeNoException();
            return z;
        }
        if (i != 3) {
            if (i != 4) {
                return false;
            }
            ap1.f(parcel.readStrongBinder());
            Parcelable.Creator<er3> creator = er3.CREATOR;
            int i7 = hl3.a;
            er3 er3VarCreateFromParcel = parcel.readInt() == 0 ? null : creator.createFromParcel(parcel);
            hl3.a(parcel);
            throw new RemoteException("#recognizeBitmap should not be triggered from text thick client.");
        }
        ly0 ly0VarF = ap1.f(parcel.readStrongBinder());
        Parcelable.Creator<er3> creator2 = er3.CREATOR;
        int i8 = hl3.a;
        er3 er3VarCreateFromParcel2 = parcel.readInt() == 0 ? null : creator2.createFromParcel(parcel);
        hl3.a(parcel);
        ce1 ce1Var3 = this.f;
        if (ce1Var3 == null) {
            throw new RemoteException("Process is started without initiation.");
        }
        ok3 ok3VarB2 = ce1Var3.b();
        if (ok3VarB2.b.c()) {
            bf3VarA = bf3.a(ok3VarB2);
        } else {
            try {
                int i9 = er3VarCreateFromParcel2.a;
                int i10 = er3VarCreateFromParcel2.e;
                if (i9 == -1) {
                    Bitmap bitmapCopy = (Bitmap) ap1.g(ly0VarF);
                    jg1.d(bitmapCopy);
                    Bitmap.Config config = bitmapCopy.getConfig();
                    Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                    if (config != config2) {
                        String.valueOf(bitmapCopy.getConfig());
                        bitmapCopy = bitmapCopy.copy(config2, bitmapCopy.isMutable());
                    }
                    jo3 jo3Var3 = (jo3) ce1Var3.e;
                    jg1.d(jo3Var3);
                    long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                    if (i10 == 1) {
                        i5 = 4;
                    } else if (i10 != 2) {
                        i5 = i10 != 3 ? 1 : 2;
                    } else {
                        i5 = 3;
                    }
                    pp3VarA = jo3Var3.b(jElapsedRealtime, bitmapCopy, i5);
                } else if (i9 == 35) {
                    Object objG = ap1.g(ly0VarF);
                    jg1.d(objG);
                    Image.Plane[] planes = ((Image) objG).getPlanes();
                    jo3 jo3Var4 = (jo3) ce1Var3.e;
                    jg1.d(jo3Var4);
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() * 1000;
                    Image.Plane plane = planes[0];
                    jg1.d(plane);
                    ByteBuffer buffer = plane.getBuffer();
                    Image.Plane plane2 = planes[1];
                    jg1.d(plane2);
                    ByteBuffer buffer2 = plane2.getBuffer();
                    Image.Plane plane3 = planes[2];
                    jg1.d(plane3);
                    ByteBuffer buffer3 = plane3.getBuffer();
                    int i11 = er3VarCreateFromParcel2.b;
                    int i12 = er3VarCreateFromParcel2.c;
                    Image.Plane plane4 = planes[0];
                    jg1.d(plane4);
                    int rowStride = plane4.getRowStride();
                    Image.Plane plane5 = planes[1];
                    jg1.d(plane5);
                    int rowStride2 = plane5.getRowStride();
                    Image.Plane plane6 = planes[1];
                    jg1.d(plane6);
                    int pixelStride = plane6.getPixelStride();
                    if (i10 != 1) {
                        i3 = i11;
                        i4 = i10 != 2 ? i10 != 3 ? 1 : 2 : 3;
                    } else {
                        i3 = i11;
                        i4 = 4;
                    }
                    pp3VarA = jo3Var4.c(jElapsedRealtime2, buffer, buffer2, buffer3, i3, i12, rowStride, rowStride2, pixelStride, i4);
                } else if (i9 == 17) {
                    ByteBuffer byteBufferWrap = (ByteBuffer) ap1.g(ly0VarF);
                    jg1.d(byteBufferWrap);
                    if (!byteBufferWrap.hasArray()) {
                        byteBufferWrap.rewind();
                        byte[] bArr = new byte[byteBufferWrap.limit()];
                        byteBufferWrap.get(bArr);
                        byteBufferWrap = ByteBuffer.wrap(bArr);
                    }
                    jo3 jo3Var5 = (jo3) ce1Var3.e;
                    jg1.d(jo3Var5);
                    pp3VarA = jo3Var5.a(lg4.b(byteBufferWrap, er3VarCreateFromParcel2));
                } else {
                    if (i9 != 842094169) {
                        throw new uj1("Unsupported image format: " + er3VarCreateFromParcel2.a, 3);
                    }
                    Object objG2 = ap1.g(ly0VarF);
                    jg1.d(objG2);
                    ByteBuffer byteBuffer = (ByteBuffer) objG2;
                    byteBuffer.rewind();
                    int iLimit = byteBuffer.limit();
                    int i13 = iLimit / 6;
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iLimit);
                    int i14 = 0;
                    while (true) {
                        i2 = i13 * 4;
                        if (i14 >= i2) {
                            break;
                        }
                        byteBufferAllocate.put(i14, byteBuffer.get(i14));
                        i14++;
                    }
                    for (int i15 = 0; i15 < i13 + i13; i15++) {
                        byteBufferAllocate.put(i2 + i15, byteBuffer.get((i15 / 2) + ((i15 % 2) * i13) + i2));
                    }
                    jo3 jo3Var6 = (jo3) ce1Var3.e;
                    jg1.d(jo3Var6);
                    pp3VarA = jo3Var6.a(lg4.b(byteBufferAllocate, er3VarCreateFromParcel2));
                }
                if (pp3VarA.c()) {
                    am3 am3Var = (am3) pp3VarA.a();
                    int i16 = er3VarCreateFromParcel2.b;
                    int i17 = er3VarCreateFromParcel2.c;
                    if (i10 == 0) {
                        matrix = null;
                    } else {
                        Matrix matrix2 = new Matrix();
                        matrix2.postTranslate((-i16) / 2.0f, (-i17) / 2.0f);
                        matrix2.postRotate(i10 * 90);
                        int i18 = i10 % 2;
                        int i19 = i18 != 0 ? i17 : i16;
                        if (i18 == 0) {
                            i16 = i17;
                        }
                        matrix2.postTranslate(i19 / 2.0f, i16 / 2.0f);
                        matrix = matrix2;
                    }
                    boolean z3 = ce1Var3.b;
                    ok3 ok3Var = new ok3(0, np3.a);
                    mu3<tf3> mu3VarP = am3Var.q().p();
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    HashMap map3 = new HashMap();
                    for (tf3 tf3Var : mu3VarP) {
                        if (tf3Var.p() == 6) {
                            tr3 tr3VarC = hg4.c(tf3Var.s());
                            List listD = hg4.d(tr3VarC);
                            or3 or3Var = new or3(tf3Var.o(), hg4.b(listD, matrix), listD, tf3Var.q(), tr3VarC.o());
                            Integer numValueOf = Integer.valueOf(tf3Var.r());
                            if (map2.containsKey(numValueOf)) {
                                tp3Var3 = (tp3) map2.get(numValueOf);
                            } else {
                                tp3 tp3Var4 = new tp3();
                                map2.put(numValueOf, tp3Var4);
                                tp3Var3 = tp3Var4;
                            }
                            jg1.d(tp3Var3);
                            tp3Var3.a(or3Var);
                        }
                    }
                    int i20 = 0;
                    while (i20 < mu3VarP.size()) {
                        tf3 tf3Var2 = (tf3) mu3VarP.get(i20);
                        if (tf3Var2.p() == i6) {
                            tr3 tr3VarC2 = hg4.c(tf3Var2.s());
                            List listD2 = hg4.d(tr3VarC2);
                            Integer numValueOf2 = Integer.valueOf(i20);
                            if (map2.containsKey(numValueOf2)) {
                                tp3 tp3Var5 = (tp3) map2.get(numValueOf2);
                                jg1.d(tp3Var5);
                                aq3VarB2 = tp3Var5.b();
                            } else {
                                up3 up3Var = wp3.f;
                                aq3VarB2 = aq3.k;
                            }
                            aq3 aq3Var = aq3VarB2;
                            String strO = tf3Var2.o();
                            Rect rectB = hg4.b(listD2, matrix);
                            String strE = jg4.e(tf3Var2.t().p());
                            float fQ = tf3Var2.q();
                            float fO = tr3VarC2.o();
                            jg1.d(aq3Var);
                            kr3 kr3Var = new kr3(fQ, fO, rectB, strO, strE, listD2, aq3Var);
                            Integer numValueOf3 = Integer.valueOf(tf3Var2.r());
                            if (map.containsKey(numValueOf3)) {
                                tp3Var2 = (tp3) map.get(numValueOf3);
                            } else {
                                tp3 tp3Var6 = new tp3();
                                map.put(numValueOf3, tp3Var6);
                                tp3Var2 = tp3Var6;
                            }
                            jg1.d(tp3Var2);
                            tp3Var2.a(kr3Var);
                        }
                        i20++;
                        i6 = 1;
                    }
                    for (int i21 = 0; i21 < mu3VarP.size(); i21++) {
                        tf3 tf3Var3 = (tf3) mu3VarP.get(i21);
                        if (tf3Var3.p() == 3) {
                            tr3 tr3VarC3 = hg4.c(tf3Var3.s());
                            List listD3 = hg4.d(tr3VarC3);
                            Integer numValueOf4 = Integer.valueOf(i21);
                            if (map.containsKey(numValueOf4)) {
                                tp3 tp3Var7 = (tp3) map.get(numValueOf4);
                                jg1.d(tp3Var7);
                                aq3VarB = tp3Var7.b();
                            } else {
                                up3 up3Var2 = wp3.f;
                                aq3VarB = aq3.k;
                            }
                            aq3 aq3Var2 = aq3VarB;
                            String strO2 = tf3Var3.o();
                            Rect rectB2 = hg4.b(listD3, matrix);
                            String strE2 = jg4.e(tf3Var3.t().p());
                            jg1.d(aq3Var2);
                            lr3 lr3Var = new lr3(tf3Var3.q(), tr3VarC3.o(), rectB2, strO2, strE2, listD3, aq3Var2);
                            Integer numValueOf5 = Integer.valueOf(tf3Var3.r());
                            if (map3.containsKey(numValueOf5)) {
                                tp3Var = (tp3) map3.get(numValueOf5);
                            } else {
                                tp3 tp3Var8 = new tp3();
                                map3.put(Integer.valueOf(tf3Var3.r()), tp3Var8);
                                tp3Var = tp3Var8;
                            }
                            jg1.d(tp3Var);
                            tp3Var.a(lr3Var);
                        }
                    }
                    tp3 tp3Var9 = new tp3();
                    for (int i22 = 0; i22 < mu3VarP.size(); i22++) {
                        tf3 tf3Var4 = (tf3) mu3VarP.get(i22);
                        if (tf3Var4.p() == 4) {
                            List listD4 = hg4.d(hg4.c(tf3Var4.s()));
                            up3 up3Var3 = wp3.f;
                            aq3 aq3VarB3 = aq3.k;
                            Integer numValueOf6 = Integer.valueOf(i22);
                            if (map3.containsKey(numValueOf6)) {
                                tp3 tp3Var10 = (tp3) map3.get(numValueOf6);
                                jg1.d(tp3Var10);
                                aq3VarB3 = tp3Var10.b();
                                map3.remove(numValueOf6);
                            }
                            el1 el1Var = new el1(21);
                            String strB = ng4.b(aq3VarB3 != null ? new yp3((List) aq3VarB3, (op3) el1Var) : new zp3((List) aq3VarB3, (op3) el1Var));
                            Rect rectB3 = hg4.b(listD4, matrix);
                            String strE3 = jg4.e(tf3Var4.t().p());
                            jg1.d(aq3VarB3);
                            tp3Var9.a(new jr3(strB, rectB3, listD4, strE3, aq3VarB3));
                        }
                    }
                    Iterator it = map3.values().iterator();
                    while (it.hasNext()) {
                        aq3 aq3VarB4 = ((tp3) it.next()).b();
                        int i23 = aq3VarB4.j;
                        int i24 = 0;
                        while (i24 < i23) {
                            lr3 lr3Var2 = (lr3) aq3VarB4.get(i24);
                            tp3Var9.a(new jr3(lr3Var2.a, lr3Var2.b, lr3Var2.c, lr3Var2.e, new aq3(1, new Object[]{lr3Var2})));
                            i24++;
                            it = it;
                        }
                    }
                    aq3 aq3VarB5 = tp3Var9.b();
                    fl4 fl4Var = new fl4(21);
                    bf3 bf3Var = new bf3(ok3Var, new mr3(ng4.b(aq3VarB5 != null ? new yp3((List) aq3VarB5, (op3) fl4Var) : new zp3((List) aq3VarB5, (op3) fl4Var)), aq3VarB5), aq3.k, z3);
                    ce1Var3.b = false;
                    bf3VarA = bf3Var;
                } else {
                    bf3VarA = bf3.a(new ok3(3, new qp3(new RemoteException("VisionKit pipeline returns empty result."))));
                }
            } catch (uj1 e) {
                bf3VarA = bf3.a(new ok3(2, new qp3(new RemoteException("Failed to process input image.".concat(String.valueOf(e.getMessage()))))));
            }
        }
        ok3 ok3Var2 = bf3VarA.a;
        if (ok3Var2.b.c()) {
            throw ((RemoteException) ok3Var2.b.a());
        }
        mr3 mr3Var = bf3VarA.b;
        parcel2.writeNoException();
        parcel2.writeInt(1);
        mr3Var.writeToParcel(parcel2, 1);
        return true;
    }
}
