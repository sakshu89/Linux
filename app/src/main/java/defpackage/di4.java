package defpackage;

import android.content.ClipData;
import android.os.Parcel;
import android.text.Annotation;
import android.text.SpannableString;
import android.util.Base64;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class di4 {
    /* JADX WARN: Code duplicated, block: B:37:0x00c0  */
    public static final oy a(be beVar) {
        List list = beVar.c;
        ii0 ii0Var = ii0.a;
        List list2 = list == null ? ii0Var : list;
        CharSequence charSequence = beVar.b;
        if (!list2.isEmpty()) {
            SpannableString spannableString = new SpannableString(charSequence);
            q82 q82Var = new q82();
            q82Var.a = Parcel.obtain();
            if (list == null) {
                list = ii0Var;
            }
            int size = list.size();
            int i = 0;
            while (i < size) {
                ae aeVar = (ae) list.get(i);
                hp2 hp2Var = (hp2) aeVar.a;
                int i2 = aeVar.b;
                int i3 = aeVar.c;
                ((Parcel) q82Var.a).recycle();
                q82Var.a = Parcel.obtain();
                uy2 uy2Var = hp2Var.a;
                long j = hp2Var.l;
                long j2 = hp2Var.h;
                int i4 = i;
                long j3 = hp2Var.b;
                List list3 = list;
                int i5 = size;
                long jC = uy2Var.c();
                long j4 = sz.g;
                if (!sz.c(jC, j4)) {
                    q82Var.x((byte) 1);
                    ((Parcel) q82Var.a).writeLong(hp2Var.a.c());
                }
                long j5 = b03.c;
                byte b = 2;
                if (!b03.a(j3, j5)) {
                    q82Var.x((byte) 2);
                    q82Var.z(j3);
                }
                np0 np0Var = hp2Var.c;
                if (np0Var != null) {
                    q82Var.x((byte) 3);
                    ((Parcel) q82Var.a).writeInt(np0Var.a);
                }
                lp0 lp0Var = hp2Var.d;
                if (lp0Var != null) {
                    int i6 = lp0Var.a;
                    q82Var.x((byte) 4);
                    q82Var.x((i6 != 0 && i6 == 1) ? (byte) 1 : (byte) 0);
                }
                mp0 mp0Var = hp2Var.e;
                if (mp0Var != null) {
                    int i7 = mp0Var.a;
                    q82Var.x((byte) 5);
                    if (i7 == 0) {
                        b = 0;
                    } else if (i7 == 65535) {
                        b = 1;
                    } else if (i7 != 1) {
                        if (i7 == 2) {
                            b = 3;
                        } else {
                            b = 0;
                        }
                    }
                    q82Var.x(b);
                }
                String str = hp2Var.g;
                if (str != null) {
                    q82Var.x((byte) 6);
                    ((Parcel) q82Var.a).writeString(str);
                }
                if (!b03.a(j2, j5)) {
                    q82Var.x((byte) 7);
                    q82Var.z(j2);
                }
                rk rkVar = hp2Var.i;
                if (rkVar != null) {
                    float f = rkVar.a;
                    q82Var.x((byte) 8);
                    q82Var.y(f);
                }
                vy2 vy2Var = hp2Var.j;
                if (vy2Var != null) {
                    q82Var.x((byte) 9);
                    q82Var.y(vy2Var.a);
                    q82Var.y(vy2Var.b);
                }
                if (!sz.c(j, j4)) {
                    q82Var.x((byte) 10);
                    ((Parcel) q82Var.a).writeLong(j);
                }
                sx2 sx2Var = hp2Var.m;
                if (sx2Var != null) {
                    q82Var.x((byte) 11);
                    ((Parcel) q82Var.a).writeInt(sx2Var.a);
                }
                vj2 vj2Var = hp2Var.n;
                if (vj2Var != null) {
                    q82Var.x((byte) 12);
                    ((Parcel) q82Var.a).writeLong(vj2Var.a);
                    long j6 = vj2Var.b;
                    q82Var.y(Float.intBitsToFloat((int) (j6 >> 32)));
                    q82Var.y(Float.intBitsToFloat((int) (j6 & 4294967295L)));
                    q82Var.y(vj2Var.c);
                }
                SpannableString spannableString2 = spannableString;
                spannableString2.setSpan(new Annotation("androidx.compose.text.SpanStyle", Base64.encodeToString(((Parcel) q82Var.a).marshall(), 0)), i2, i3, 33);
                i = i4 + 1;
                spannableString = spannableString2;
                list = list3;
                size = i5;
            }
            charSequence = spannableString;
        }
        return new oy(ClipData.newPlainText("plain text", charSequence));
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
