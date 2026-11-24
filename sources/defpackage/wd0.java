package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wd0 implements nm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public wd0(xd0 xd0Var, t42 t42Var, nm0 nm0Var) {
        this.a = 0;
        this.c = t42Var;
        this.b = nm0Var;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:123:0x0251  */
    /* JADX WARN: Code duplicated, block: B:125:0x0253  */
    /* JADX WARN: Code duplicated, block: B:132:0x026c  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a3  */
    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) {
        vd0 vd0Var;
        xm0 xm0Var;
        an0 an0Var;
        wd0 wd0Var = this;
        Object obj2 = obj;
        int i = wd0Var.a;
        boolean z = true;
        t70 t70Var = t70.a;
        Object obj3 = wd0Var.b;
        Object obj4 = wd0Var.c;
        q43 q43Var = q43.a;
        x50 x50Var2 = null;
        switch (i) {
            case 0:
                t42 t42Var = (t42) obj4;
                if (x50Var instanceof vd0) {
                    vd0Var = (vd0) x50Var;
                    int i2 = vd0Var.i;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        vd0Var.i = i2 - Integer.MIN_VALUE;
                    } else {
                        vd0Var = new vd0(wd0Var, x50Var);
                    }
                } else {
                    vd0Var = new vd0(wd0Var, x50Var);
                }
                Object obj5 = vd0Var.e;
                int i3 = vd0Var.i;
                if (i3 == 0) {
                    bz3.g(obj5);
                    Object obj6 = t42Var.a;
                    if (obj6 == s24.a || !g31.a(obj6, obj2)) {
                        t42Var.a = obj2;
                        vd0Var.i = 1;
                        if (((nm0) obj3).n(obj2, vd0Var) == t70Var) {
                            return t70Var;
                        }
                    }
                } else {
                    if (i3 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj5);
                }
                return q43Var;
            case 1:
                if (x50Var instanceof xm0) {
                    xm0Var = (xm0) x50Var;
                    int i4 = xm0Var.i;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        xm0Var.i = i4 - Integer.MIN_VALUE;
                    } else {
                        xm0Var = new xm0(wd0Var, x50Var);
                    }
                } else {
                    xm0Var = new xm0(wd0Var, x50Var);
                }
                Object objE = xm0Var.f;
                int i5 = xm0Var.i;
                if (i5 != 0) {
                    if (i5 == 1) {
                        Object obj7 = xm0Var.k;
                        wd0 wd0Var2 = xm0Var.e;
                        bz3.g(objE);
                        obj2 = obj7;
                        wd0Var = wd0Var2;
                    } else {
                        if (i5 != 2) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        wd0Var = xm0Var.e;
                        bz3.g(objE);
                    }
                    if (z) {
                        return q43Var;
                    }
                    throw new i0(wd0Var);
                }
                bz3.g(objE);
                xm0Var.e = wd0Var;
                xm0Var.k = obj2;
                xm0Var.i = 1;
                objE = ((z) obj4).e(obj2, xm0Var);
                if (objE == t70Var) {
                    return t70Var;
                }
                if (((Boolean) objE).booleanValue()) {
                    nm0 nm0Var = (nm0) wd0Var.b;
                    xm0Var.e = wd0Var;
                    xm0Var.k = null;
                    xm0Var.i = 2;
                    if (nm0Var.n(obj2, xm0Var) == t70Var) {
                        return t70Var;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    return q43Var;
                }
                throw new i0(wd0Var);
            case 2:
                if (x50Var instanceof an0) {
                    an0Var = (an0) x50Var;
                    int i6 = an0Var.i;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        an0Var.i = i6 - Integer.MIN_VALUE;
                    } else {
                        an0Var = new an0(wd0Var, x50Var);
                    }
                } else {
                    an0Var = new an0(wd0Var, x50Var);
                }
                Object objE2 = an0Var.f;
                int i7 = an0Var.i;
                if (i7 == 0) {
                    bz3.g(objE2);
                    an0Var.e = wd0Var;
                    an0Var.k = obj2;
                    an0Var.i = 1;
                    objE2 = ((vq0) obj3).e(obj2, an0Var);
                    if (objE2 == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i7 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Object obj8 = an0Var.k;
                    wd0 wd0Var3 = an0Var.e;
                    bz3.g(objE2);
                    obj2 = obj8;
                    wd0Var = wd0Var3;
                }
                if (!((Boolean) objE2).booleanValue()) {
                    return q43Var;
                }
                ((t42) wd0Var.c).a = obj2;
                throw new i0(wd0Var);
            case 3:
                r21 r21Var = (r21) obj2;
                lb lbVar = (lb) obj4;
                if (!(r21Var instanceof d02)) {
                    s70 s70Var = (s70) obj3;
                    ux uxVar = lbVar.c0;
                    float f = 0.0f;
                    if (uxVar == null) {
                        boolean z2 = lbVar.H;
                        bc0 bc0Var = lbVar.Z;
                        uxVar = new ux();
                        uxVar.a = z2;
                        uxVar.b = bc0Var;
                        uxVar.c = new bd(Float.valueOf(0.0f), eb4.a, Float.valueOf(0.01f), 8);
                        uxVar.d = new ArrayList();
                        vm4.a(lbVar);
                        lbVar.c0 = uxVar;
                    }
                    ArrayList arrayList = (ArrayList) uxVar.d;
                    if (r21Var instanceof xw0) {
                        arrayList.add(r21Var);
                    } else if (r21Var instanceof yw0) {
                        arrayList.remove(((yw0) r21Var).a);
                    } else if (r21Var instanceof sn0) {
                        arrayList.add(r21Var);
                    } else if (r21Var instanceof tn0) {
                        arrayList.remove(((tn0) r21Var).a);
                    } else if (r21Var instanceof jf0) {
                        arrayList.add(r21Var);
                    } else if (r21Var instanceof kf0) {
                        arrayList.remove(((kf0) r21Var).a);
                    } else if (r21Var instanceof if0) {
                        arrayList.remove(((if0) r21Var).a);
                    }
                    r21 r21Var2 = (r21) mz.E(arrayList);
                    if (!g31.a((r21) uxVar.e, r21Var2)) {
                        if (r21Var2 != null) {
                            ((bc0) uxVar.b).a();
                            boolean z3 = r21Var2 instanceof xw0;
                            if (z3) {
                                f = 0.08f;
                            } else if (r21Var2 instanceof sn0) {
                                f = 0.1f;
                            } else if (r21Var2 instanceof jf0) {
                                f = 0.16f;
                            }
                            f33 f33Var = j82.a;
                            if (!z3 && ((r21Var2 instanceof sn0) || (r21Var2 instanceof jf0))) {
                                f33Var = new f33(45, ug0.b);
                            }
                            uf4.b(s70Var, null, new lr2(uxVar, f, f33Var, null), 3);
                        } else {
                            r21 r21Var3 = (r21) uxVar.e;
                            f33 f33Var2 = j82.a;
                            if (!(r21Var3 instanceof xw0) && !(r21Var3 instanceof sn0) && (r21Var3 instanceof jf0)) {
                                f33Var2 = new f33(150, ug0.b);
                            }
                            uf4.b(s70Var, null, new sc2(uxVar, f33Var2, x50Var2, 11), 3);
                        }
                        uxVar.e = r21Var2;
                    }
                } else if (lbVar.f0) {
                    lbVar.I0((d02) r21Var);
                } else {
                    lbVar.g0.a(r21Var);
                }
                return q43Var;
            default:
                long j = ((jp1) obj2).a;
                bd bdVar = (bd) obj4;
                if ((((jp1) bdVar.d()).a & 9223372034707292159L) == 9205357640488583168L || (j & 9223372034707292159L) == 9205357640488583168L || Float.intBitsToFloat((int) (((jp1) bdVar.d()).a & 4294967295L)) == Float.intBitsToFloat((int) (j & 4294967295L))) {
                    Object objE3 = bdVar.e(x50Var, new jp1(j));
                    return objE3 == t70Var ? objE3 : q43Var;
                }
                uf4.b((s70) obj3, null, new yf2(bdVar, j, (x50) null), 3);
                return q43Var;
        }
    }

    public /* synthetic */ wd0(int i, Object obj, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    public wd0(vq0 vq0Var, t42 t42Var) {
        this.a = 2;
        this.b = vq0Var;
        this.c = t42Var;
    }
}
