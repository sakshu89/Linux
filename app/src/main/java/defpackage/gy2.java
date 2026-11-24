package defpackage;

import android.content.ClipData;
import android.os.Parcel;
import android.text.Annotation;
import android.text.Spanned;
import com.ibm.icu.impl.coll.Collation;
import com.ibm.icu.text.DateTimePatternGenerator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gy2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ ny2 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gy2(ny2 ny2Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = ny2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                long j = ((jp1) obj).a;
                return new gy2(this.j, (x50) obj2, 0).s(q43Var);
            case 1:
                return ((gy2) q((x50) obj2, (s70) obj)).s(q43Var);
            default:
                return ((gy2) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        ny2 ny2Var = this.j;
        switch (i) {
            case 0:
                return new gy2(ny2Var, x50Var, 0);
            case 1:
                return new gy2(ny2Var, x50Var, 1);
            default:
                return new gy2(ny2Var, x50Var, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x014a  */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i;
        be beVarD;
        sy syVar;
        Object oyVar;
        Object beVar;
        CharSequence text;
        int i2;
        uf1 uf1Var;
        be beVar2;
        int i3 = this.f;
        rv0 rv0Var = rv0.a;
        t70 t70Var = t70.a;
        byte b = 1;
        ny2 ny2Var = this.j;
        q43 q43Var = q43.a;
        switch (i3) {
            case 0:
                int i4 = this.i;
                if (i4 != 0) {
                    if (i4 == 1) {
                        bz3.g(obj);
                    } else {
                        if (i4 != 2) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        bz3.g(obj);
                    }
                    return q43Var;
                }
                bz3.g(obj);
                this.i = 1;
                if (ny2Var.s(this) == t70Var) {
                    return t70Var;
                }
                wt1 wt1VarA = ny2.a(ny2Var);
                if (wt1VarA != null) {
                    String str = (String) wt1VarA.a;
                    long j = ((oz2) wt1VarA.b).a;
                    sx1 sx1Var = ny2Var.j;
                    if (sx1Var != null) {
                        this.i = 2;
                        Object objD = (str.length() == 0 || oz2.c(j)) ? q43Var : uf4.d(sx1Var.a, new aa(sx1Var, new s0(j, null, sx1Var, str), null, 7), this);
                        if (objD != t70Var) {
                            objD = q43Var;
                        }
                        if (objD == t70Var) {
                            return t70Var;
                        }
                    }
                }
                return q43Var;
            case 1:
                int i5 = this.i;
                if (i5 == 0) {
                    bz3.g(obj);
                    if (oz2.c(ny2Var.n().b) || !ny2Var.j() || (ny2Var.f instanceof nu1)) {
                        i = 1;
                        beVarD = null;
                    } else {
                        beVarD = bc4.d(ny2Var.n());
                        be beVarF = bc4.f(ny2Var.n(), ny2Var.n().a.b.length());
                        be beVarE = bc4.e(ny2Var.n(), ny2Var.n().a.b.length());
                        zd zdVar = new zd(beVarF);
                        zdVar.a(beVarE);
                        be beVarB = zdVar.b();
                        int iF = oz2.f(ny2Var.n().b);
                        ny2Var.c.j(ny2.e(beVarB, hc4.a(iF, iF)));
                        ny2Var.q(rv0Var);
                        i = 1;
                        ny2Var.a.e = true;
                    }
                    if (beVarD != null && (syVar = ny2Var.h) != null) {
                        oy oyVarA = di4.a(beVarD);
                        this.i = i;
                        ((y6) syVar).a(oyVarA);
                        if (q43Var == t70Var) {
                            return t70Var;
                        }
                    }
                } else {
                    if (i5 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43Var;
            default:
                int i6 = this.i;
                if (i6 == 0) {
                    bz3.g(obj);
                    sy syVar2 = ny2Var.h;
                    if (syVar2 != null) {
                        this.i = 1;
                        ClipData primaryClip = ((y6) syVar2).a.a.getPrimaryClip();
                        oyVar = primaryClip != null ? new oy(primaryClip) : null;
                        if (oyVar == t70Var) {
                            return t70Var;
                        }
                    }
                    return q43Var;
                }
                if (i6 == 1) {
                    bz3.g(obj);
                    oyVar = obj;
                } else {
                    if (i6 != 2) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                    beVar = obj;
                }
                beVar2 = (be) beVar;
                if (beVar2 != null && ny2Var.j()) {
                    zd zdVar2 = new zd(bc4.f(ny2Var.n(), ny2Var.n().a.b.length()));
                    zdVar2.a(beVar2);
                    be beVarB2 = zdVar2.b();
                    be beVarE2 = bc4.e(ny2Var.n(), ny2Var.n().a.b.length());
                    zd zdVar3 = new zd(beVarB2);
                    zdVar3.a(beVarE2);
                    be beVarB3 = zdVar3.b();
                    int length = beVar2.b.length() + oz2.f(ny2Var.n().b);
                    ny2Var.c.j(ny2.e(beVarB3, hc4.a(length, length)));
                    ny2Var.q(rv0Var);
                    ny2Var.a.e = true;
                }
                return q43Var;
                oy oyVar2 = (oy) oyVar;
                if (oyVar2 != null) {
                    this.i = 2;
                    int i7 = 0;
                    ClipData.Item itemAt = oyVar2.a.getItemAt(0);
                    if (itemAt == null || (text = itemAt.getText()) == null) {
                        beVar = null;
                    } else if (text instanceof Spanned) {
                        Spanned spanned = (Spanned) text;
                        Annotation[] annotationArr = (Annotation[]) spanned.getSpans(0, spanned.length(), Annotation.class);
                        ArrayList arrayList = new ArrayList();
                        annotationArr.getClass();
                        int length2 = annotationArr.length - 1;
                        if (length2 >= 0) {
                            int i8 = 0;
                            while (true) {
                                Annotation annotation = annotationArr[i8];
                                int i9 = i7;
                                if (g31.a(annotation.getKey(), "androidx.compose.text.SpanStyle")) {
                                    int spanStart = spanned.getSpanStart(annotation);
                                    int spanEnd = spanned.getSpanEnd(annotation);
                                    uf1 uf1Var2 = new uf1(annotation.getValue());
                                    Parcel parcel = (Parcel) uf1Var2.b;
                                    long jM = sz.g;
                                    long jM2 = jM;
                                    long jN = b03.c;
                                    long jN2 = jN;
                                    np0 np0Var = null;
                                    lp0 lp0Var = null;
                                    mp0 mp0Var = null;
                                    String string = null;
                                    rk rkVar = null;
                                    vy2 vy2Var = null;
                                    sx2 sx2Var = null;
                                    vj2 vj2Var = null;
                                    while (true) {
                                        if (parcel.dataAvail() > b) {
                                            byte b2 = parcel.readByte();
                                            text = text;
                                            if (b2 == b) {
                                                if (parcel.dataAvail() >= 8) {
                                                    jM = uf1Var2.m();
                                                    text = text;
                                                }
                                            } else if (b2 == 2) {
                                                if (parcel.dataAvail() >= 5) {
                                                    jN = uf1Var2.n();
                                                    b = 1;
                                                }
                                            } else if (b2 == 3) {
                                                if (parcel.dataAvail() >= 4) {
                                                    np0Var = new np0(parcel.readInt());
                                                    b = 1;
                                                    text = text;
                                                }
                                            } else if (b2 == 4) {
                                                if (parcel.dataAvail() >= 1) {
                                                    byte b3 = parcel.readByte();
                                                    lp0 lp0Var2 = new lp0((b3 != 0 && b3 == 1) ? 1 : i9);
                                                    text = text;
                                                    lp0Var = lp0Var2;
                                                    b = 1;
                                                }
                                            } else if (b2 != 5) {
                                                if (b2 == 6) {
                                                    string = parcel.readString();
                                                } else if (b2 == 7) {
                                                    if (parcel.dataAvail() >= 5) {
                                                        jN2 = uf1Var2.n();
                                                    }
                                                } else if (b2 == 8) {
                                                    if (parcel.dataAvail() >= 4) {
                                                        rkVar = new rk(parcel.readFloat());
                                                        b = 1;
                                                    }
                                                } else if (b2 == 9) {
                                                    if (parcel.dataAvail() >= 8) {
                                                        vy2Var = new vy2(parcel.readFloat(), parcel.readFloat());
                                                        b = 1;
                                                        text = text;
                                                    }
                                                } else if (b2 == 10) {
                                                    if (parcel.dataAvail() >= 8) {
                                                        jM2 = uf1Var2.m();
                                                    }
                                                } else if (b2 != 11) {
                                                    uf1Var = uf1Var2;
                                                    if (b2 != 12) {
                                                        uf1Var2 = uf1Var;
                                                    } else if (parcel.dataAvail() >= 20) {
                                                        uf1Var2 = uf1Var;
                                                        vj2Var = new vj2(uf1Var.m(), (((long) Float.floatToRawIntBits(parcel.readFloat())) << 32) | (((long) Float.floatToRawIntBits(parcel.readFloat())) & 4294967295L), parcel.readFloat());
                                                    }
                                                    b = 1;
                                                } else if (parcel.dataAvail() >= 4) {
                                                    int i10 = parcel.readInt();
                                                    int i11 = (i10 & 2) != 0 ? 1 : i9;
                                                    int i12 = (i10 & 1) != 0 ? 1 : i9;
                                                    sx2 sx2Var2 = sx2.d;
                                                    int i13 = i12;
                                                    sx2 sx2Var3 = sx2.c;
                                                    if (i11 == 0 || i13 == 0) {
                                                        uf1Var = uf1Var2;
                                                        if (i11 != 0) {
                                                            sx2Var = sx2Var2;
                                                        } else {
                                                            if (i13 == 0) {
                                                                sx2Var3 = sx2.b;
                                                            }
                                                            sx2Var = sx2Var3;
                                                        }
                                                    } else {
                                                        List listI = nz.i(sx2Var2, sx2Var3);
                                                        Integer numValueOf = Integer.valueOf(i9);
                                                        int size = listI.size();
                                                        uf1Var = uf1Var2;
                                                        int i14 = i9;
                                                        while (i14 < size) {
                                                            numValueOf = Integer.valueOf(((sx2) listI.get(i14)).a | numValueOf.intValue());
                                                            i14++;
                                                            listI = listI;
                                                        }
                                                        sx2Var = new sx2(numValueOf.intValue());
                                                    }
                                                    uf1Var2 = uf1Var;
                                                    b = 1;
                                                }
                                                b = 1;
                                            } else if (parcel.dataAvail() >= 1) {
                                                byte b4 = parcel.readByte();
                                                if (b4 == 0) {
                                                    i2 = i9;
                                                } else if (b4 == 1) {
                                                    i2 = DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
                                                } else if (b4 == 3) {
                                                    i2 = 2;
                                                } else if (b4 == 2) {
                                                    i2 = 1;
                                                } else {
                                                    i2 = i9;
                                                }
                                                mp0Var = new mp0(i2);
                                                b = 1;
                                            }
                                        } else {
                                            text = text;
                                        }
                                    }
                                    arrayList.add(new ae(new hp2(jM, jN, np0Var, lp0Var, mp0Var, (ev2) null, string, jN2, rkVar, vy2Var, (ne1) null, jM2, sx2Var, vj2Var, Collation.CASE_MASK), spanStart, spanEnd));
                                } else {
                                    text = text;
                                }
                                if (i8 != length2) {
                                    i8++;
                                    i7 = i9;
                                    text = text;
                                    b = 1;
                                }
                            }
                        } else {
                            text = text;
                        }
                        String string2 = text.toString();
                        be beVar3 = ce.a;
                        beVar = new be(arrayList.isEmpty() ? null : arrayList, string2);
                    } else {
                        beVar = new be(text.toString());
                    }
                    if (beVar == t70Var) {
                        return t70Var;
                    }
                    beVar2 = (be) beVar;
                    if (beVar2 != null) {
                        zd zdVar4 = new zd(bc4.f(ny2Var.n(), ny2Var.n().a.b.length()));
                        zdVar4.a(beVar2);
                        be beVarB4 = zdVar4.b();
                        be beVarE3 = bc4.e(ny2Var.n(), ny2Var.n().a.b.length());
                        zd zdVar5 = new zd(beVarB4);
                        zdVar5.a(beVarE3);
                        be beVarB5 = zdVar5.b();
                        int length3 = beVar2.b.length() + oz2.f(ny2Var.n().b);
                        ny2Var.c.j(ny2.e(beVarB5, hc4.a(length3, length3)));
                        ny2Var.q(rv0Var);
                        ny2Var.a.e = true;
                    }
                }
                return q43Var;
        }
    }
}
