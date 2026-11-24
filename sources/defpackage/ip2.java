package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ip2 {
    public static final long a = nc4.c(14);
    public static final long b = nc4.c(0);
    public static final long c = sz.f;
    public static final uy2 d;

    static {
        long j = sz.b;
        d = j != 16 ? new f00(j) : el1.j;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x016f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:108:0x0181  */
    /* JADX WARN: Code duplicated, block: B:110:0x0186  */
    /* JADX WARN: Code duplicated, block: B:111:0x0189  */
    /* JADX WARN: Code duplicated, block: B:113:0x018d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0190  */
    /* JADX WARN: Code duplicated, block: B:116:0x0194  */
    /* JADX WARN: Code duplicated, block: B:118:0x0198  */
    /* JADX WARN: Code duplicated, block: B:120:0x019c  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:125:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:129:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:136:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:13:0x0049 A[PHI: r19
      0x0049: PHI (r19v6 el1) = 
      (r19v0 el1)
      (r19v7 el1)
      (r19v7 el1)
      (r19v7 el1)
      (r19v7 el1)
      (r19v7 el1)
      (r19v7 el1)
      (r19v7 el1)
      (r19v7 el1)
      (r19v7 el1)
      (r19v7 el1)
     binds: [B:6:0x0034, B:35:0x0090, B:44:0x00b0, B:41:0x00a6, B:38:0x009c, B:33:0x0084, B:30:0x007a, B:25:0x006b, B:22:0x0065, B:19:0x005b, B:11:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:140:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:142:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x010a  */
    /* JADX WARN: Code duplicated, block: B:77:0x010e  */
    /* JADX WARN: Code duplicated, block: B:79:0x011d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0123  */
    /* JADX WARN: Code duplicated, block: B:81:0x0126  */
    /* JADX WARN: Code duplicated, block: B:83:0x012c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0136  */
    /* JADX WARN: Code duplicated, block: B:86:0x013b  */
    /* JADX WARN: Code duplicated, block: B:88:0x013f  */
    /* JADX WARN: Code duplicated, block: B:91:0x014d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0168 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x016a  */
    public static final hp2 a(hp2 hp2Var, long j, hn hnVar, float f, long j2, np0 np0Var, lp0 lp0Var, mp0 mp0Var, ev2 ev2Var, String str, long j3, rk rkVar, vy2 vy2Var, ne1 ne1Var, long j4, sx2 sx2Var, vj2 vj2Var, wm4 wm4Var) {
        el1 el1Var;
        rk rkVar2;
        wm4 wm4Var2;
        vj2 vj2Var2;
        long j5;
        uy2 f00Var;
        uy2 uy2Var;
        boolean z;
        long j6;
        np0 np0Var2;
        vy2 vy2Var2;
        ne1 ne1Var2;
        sx2 sx2Var2;
        wm4 wm4Var3;
        long jA;
        lp0 lp0Var2 = lp0Var;
        mp0 mp0Var2 = mp0Var;
        ev2 ev2Var2 = ev2Var;
        String str2 = str;
        long j7 = j3;
        el1 el1Var2 = el1.j;
        c03[] c03VarArr = b03.b;
        long j8 = j2 & 1095216660480L;
        if (j8 != 0) {
            el1Var = el1Var2;
            if (!b03.a(j2, hp2Var.b)) {
                rkVar2 = rkVar;
                j5 = j4;
                vj2Var2 = vj2Var;
                wm4Var2 = wm4Var;
            }
            if (hnVar != null) {
                if (hnVar instanceof cn2) {
                    jA = ob4.a(f, ((cn2) hnVar).a);
                    if (jA != 16) {
                        f00Var = new f00(jA);
                    } else {
                        f00Var = el1Var;
                    }
                } else {
                    if (hnVar instanceof tj2) {
                        dk0.l();
                        return null;
                    }
                    f00Var = new jn((tj2) hnVar, f);
                }
            } else if (j != 16) {
                f00Var = new f00(j);
            } else {
                f00Var = el1Var;
            }
            uy2Var = hp2Var.a;
            uy2Var.getClass();
            z = f00Var instanceof jn;
            if (!z && (uy2Var instanceof jn)) {
                jn jnVar = (jn) f00Var;
                tj2 tj2Var = jnVar.a;
                float f2 = jnVar.b;
                if (Float.isNaN(f2)) {
                    f2 = ((jn) uy2Var).b;
                }
                f00Var = new jn(tj2Var, f2);
            } else if ((z || (uy2Var instanceof jn)) && ((!z && (uy2Var instanceof jn)) || f00Var.equals(el1Var))) {
            }
            if (ev2Var2 == null) {
                ev2Var2 = hp2Var.f;
            }
            if (j8 == 0) {
                j6 = hp2Var.b;
            } else {
                j6 = j2;
            }
            if (np0Var == null) {
                np0Var2 = hp2Var.c;
            } else {
                np0Var2 = np0Var;
            }
            if (lp0Var2 == null) {
                lp0Var2 = hp2Var.d;
            }
            if (mp0Var2 == null) {
                mp0Var2 = hp2Var.e;
            }
            if (str2 == null) {
                str2 = hp2Var.g;
            }
            if ((j7 & 1095216660480L) == 0) {
                j7 = hp2Var.h;
            }
            if (rkVar2 == null) {
                rkVar2 = hp2Var.i;
            }
            long j9 = j6;
            if (vy2Var == null) {
                vy2Var2 = hp2Var.j;
            } else {
                vy2Var2 = vy2Var;
            }
            if (ne1Var == null) {
                ne1Var2 = hp2Var.k;
            } else {
                ne1Var2 = ne1Var;
            }
            if (j5 == 16) {
                j5 = hp2Var.l;
            }
            vy2 vy2Var3 = vy2Var2;
            if (sx2Var == null) {
                sx2Var2 = hp2Var.m;
            } else {
                sx2Var2 = sx2Var;
            }
            if (vj2Var2 == null) {
                vj2Var2 = hp2Var.n;
            }
            if (wm4Var2 == null) {
                wm4Var3 = hp2Var.o;
            } else {
                wm4Var3 = wm4Var2;
            }
            return new hp2(f00Var, j9, np0Var2, lp0Var2, mp0Var2, ev2Var2, str2, j7, rkVar2, vy2Var3, ne1Var2, j5, sx2Var2, vj2Var2, wm4Var3);
        }
        el1Var = el1Var2;
        if ((hnVar != null || j == 16 || sz.c(j, hp2Var.a.c())) && ((lp0Var2 == null || lp0Var2.equals(hp2Var.d)) && ((np0Var == null || np0Var.equals(hp2Var.c)) && ((ev2Var2 == null || ev2Var2 == hp2Var.f) && (((j7 & 1095216660480L) == 0 || b03.a(j7, hp2Var.h)) && ((sx2Var == null || sx2Var.equals(hp2Var.m)) && g31.a(hnVar, hp2Var.a.d()) && ((hnVar == null || f == hp2Var.a.a()) && ((mp0Var2 == null || mp0Var2.equals(hp2Var.e)) && (str2 == null || str2.equals(hp2Var.g)))))))))) {
            if (rkVar != null) {
                rkVar2 = rkVar;
                if (rkVar2.equals(hp2Var.i)) {
                }
                if (hnVar != null) {
                    if (hnVar instanceof cn2) {
                        jA = ob4.a(f, ((cn2) hnVar).a);
                        if (jA != 16) {
                            f00Var = new f00(jA);
                        } else {
                            f00Var = el1Var;
                        }
                    } else {
                        if (hnVar instanceof tj2) {
                            dk0.l();
                            return null;
                        }
                        f00Var = new jn((tj2) hnVar, f);
                    }
                } else if (j != 16) {
                    f00Var = new f00(j);
                } else {
                    f00Var = el1Var;
                }
                uy2Var = hp2Var.a;
                uy2Var.getClass();
                z = f00Var instanceof jn;
                if (!z) {
                    f00Var = z ? uy2Var : uy2Var;
                } else if (z) {
                }
                if (ev2Var2 == null) {
                    ev2Var2 = hp2Var.f;
                }
                if (j8 == 0) {
                    j6 = hp2Var.b;
                } else {
                    j6 = j2;
                }
                if (np0Var == null) {
                    np0Var2 = hp2Var.c;
                } else {
                    np0Var2 = np0Var;
                }
                if (lp0Var2 == null) {
                    lp0Var2 = hp2Var.d;
                }
                if (mp0Var2 == null) {
                    mp0Var2 = hp2Var.e;
                }
                if (str2 == null) {
                    str2 = hp2Var.g;
                }
                if ((j7 & 1095216660480L) == 0) {
                    j7 = hp2Var.h;
                }
                if (rkVar2 == null) {
                    rkVar2 = hp2Var.i;
                }
                long j10 = j6;
                if (vy2Var == null) {
                    vy2Var2 = hp2Var.j;
                } else {
                    vy2Var2 = vy2Var;
                }
                if (ne1Var == null) {
                    ne1Var2 = hp2Var.k;
                } else {
                    ne1Var2 = ne1Var;
                }
                if (j5 == 16) {
                    j5 = hp2Var.l;
                }
                vy2 vy2Var4 = vy2Var2;
                if (sx2Var == null) {
                    sx2Var2 = hp2Var.m;
                } else {
                    sx2Var2 = sx2Var;
                }
                if (vj2Var2 == null) {
                    vj2Var2 = hp2Var.n;
                }
                if (wm4Var2 == null) {
                    wm4Var3 = hp2Var.o;
                } else {
                    wm4Var3 = wm4Var2;
                }
                return new hp2(f00Var, j10, np0Var2, lp0Var2, mp0Var2, ev2Var2, str2, j7, rkVar2, vy2Var4, ne1Var2, j5, sx2Var2, vj2Var2, wm4Var3);
            }
            rkVar2 = rkVar;
            if (vy2Var == null || vy2Var.equals(hp2Var.j)) {
                if (ne1Var == null || ne1Var.equals(hp2Var.k)) {
                    j5 = j4;
                    if (j5 == 16 || sz.c(j5, hp2Var.l)) {
                        vj2Var2 = vj2Var;
                        if (vj2Var2 == null || vj2Var2.equals(hp2Var.n)) {
                            wm4Var2 = wm4Var;
                            if (wm4Var2 == null || wm4Var2.equals(hp2Var.o)) {
                                return hp2Var;
                            }
                        }
                    }
                    wm4Var2 = wm4Var;
                }
                vj2Var2 = vj2Var;
                wm4Var2 = wm4Var;
            }
            if (hnVar != null) {
                if (hnVar instanceof cn2) {
                    jA = ob4.a(f, ((cn2) hnVar).a);
                    if (jA != 16) {
                        f00Var = new f00(jA);
                    } else {
                        f00Var = el1Var;
                    }
                } else {
                    if (hnVar instanceof tj2) {
                        dk0.l();
                        return null;
                    }
                    f00Var = new jn((tj2) hnVar, f);
                }
            } else if (j != 16) {
                f00Var = new f00(j);
            } else {
                f00Var = el1Var;
            }
            uy2Var = hp2Var.a;
            uy2Var.getClass();
            z = f00Var instanceof jn;
            if (!z) {
                if (z) {
                }
            } else if (z) {
            }
            if (ev2Var2 == null) {
                ev2Var2 = hp2Var.f;
            }
            if (j8 == 0) {
                j6 = hp2Var.b;
            } else {
                j6 = j2;
            }
            if (np0Var == null) {
                np0Var2 = hp2Var.c;
            } else {
                np0Var2 = np0Var;
            }
            if (lp0Var2 == null) {
                lp0Var2 = hp2Var.d;
            }
            if (mp0Var2 == null) {
                mp0Var2 = hp2Var.e;
            }
            if (str2 == null) {
                str2 = hp2Var.g;
            }
            if ((j7 & 1095216660480L) == 0) {
                j7 = hp2Var.h;
            }
            if (rkVar2 == null) {
                rkVar2 = hp2Var.i;
            }
            long j11 = j6;
            if (vy2Var == null) {
                vy2Var2 = hp2Var.j;
            } else {
                vy2Var2 = vy2Var;
            }
            if (ne1Var == null) {
                ne1Var2 = hp2Var.k;
            } else {
                ne1Var2 = ne1Var;
            }
            if (j5 == 16) {
                j5 = hp2Var.l;
            }
            vy2 vy2Var5 = vy2Var2;
            if (sx2Var == null) {
                sx2Var2 = hp2Var.m;
            } else {
                sx2Var2 = sx2Var;
            }
            if (vj2Var2 == null) {
                vj2Var2 = hp2Var.n;
            }
            if (wm4Var2 == null) {
                wm4Var3 = hp2Var.o;
            } else {
                wm4Var3 = wm4Var2;
            }
            return new hp2(f00Var, j11, np0Var2, lp0Var2, mp0Var2, ev2Var2, str2, j7, rkVar2, vy2Var5, ne1Var2, j5, sx2Var2, vj2Var2, wm4Var3);
        }
        rkVar2 = rkVar;
        j5 = j4;
        vj2Var2 = vj2Var;
        wm4Var2 = wm4Var;
        if (hnVar != null) {
            if (hnVar instanceof cn2) {
                jA = ob4.a(f, ((cn2) hnVar).a);
                if (jA != 16) {
                    f00Var = new f00(jA);
                } else {
                    f00Var = el1Var;
                }
            } else {
                if (hnVar instanceof tj2) {
                    dk0.l();
                    return null;
                }
                f00Var = new jn((tj2) hnVar, f);
            }
        } else if (j != 16) {
            f00Var = new f00(j);
        } else {
            f00Var = el1Var;
        }
        uy2Var = hp2Var.a;
        uy2Var.getClass();
        z = f00Var instanceof jn;
        if (!z) {
            if (z) {
            }
        } else if (z) {
        }
        if (ev2Var2 == null) {
            ev2Var2 = hp2Var.f;
        }
        if (j8 == 0) {
            j6 = hp2Var.b;
        } else {
            j6 = j2;
        }
        if (np0Var == null) {
            np0Var2 = hp2Var.c;
        } else {
            np0Var2 = np0Var;
        }
        if (lp0Var2 == null) {
            lp0Var2 = hp2Var.d;
        }
        if (mp0Var2 == null) {
            mp0Var2 = hp2Var.e;
        }
        if (str2 == null) {
            str2 = hp2Var.g;
        }
        if ((j7 & 1095216660480L) == 0) {
            j7 = hp2Var.h;
        }
        if (rkVar2 == null) {
            rkVar2 = hp2Var.i;
        }
        long j12 = j6;
        if (vy2Var == null) {
            vy2Var2 = hp2Var.j;
        } else {
            vy2Var2 = vy2Var;
        }
        if (ne1Var == null) {
            ne1Var2 = hp2Var.k;
        } else {
            ne1Var2 = ne1Var;
        }
        if (j5 == 16) {
            j5 = hp2Var.l;
        }
        vy2 vy2Var6 = vy2Var2;
        if (sx2Var == null) {
            sx2Var2 = hp2Var.m;
        } else {
            sx2Var2 = sx2Var;
        }
        if (vj2Var2 == null) {
            vj2Var2 = hp2Var.n;
        }
        if (wm4Var2 == null) {
            wm4Var3 = hp2Var.o;
        } else {
            wm4Var3 = wm4Var2;
        }
        return new hp2(f00Var, j12, np0Var2, lp0Var2, mp0Var2, ev2Var2, str2, j7, rkVar2, vy2Var6, ne1Var2, j5, sx2Var2, vj2Var2, wm4Var3);
    }
}
