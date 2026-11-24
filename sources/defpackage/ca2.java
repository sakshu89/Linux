package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ca2 implements ba2 {
    public final hq0 a;
    public final gm1 b;
    public gm1 c;

    public ca2(Map map, hq0 hq0Var) {
        gm1 gm1Var;
        this.a = hq0Var;
        if (map == null || map.isEmpty()) {
            gm1Var = null;
        } else {
            gm1Var = new gm1(map.size());
            for (Map.Entry entry : map.entrySet()) {
                gm1Var.m(entry.getKey(), entry.getValue());
            }
        }
        this.b = gm1Var;
    }

    @Override // defpackage.ba2
    public final kf a(String str, fq0 fq0Var) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!ph4.c(str.charAt(i))) {
                gm1 gm1Var = this.c;
                if (gm1Var == null) {
                    long[] jArr = ya2.a;
                    gm1Var = new gm1();
                    this.c = gm1Var;
                }
                Object objG = gm1Var.g(str);
                if (objG == null) {
                    objG = new ArrayList();
                    gm1Var.m(str, objG);
                }
                ((List) objG).add(fq0Var);
                return new kf(gm1Var, str, fq0Var, 25);
            }
        }
        og.i("Registered key is empty or blank");
        return null;
    }

    @Override // defpackage.ba2
    public final boolean c(Object obj) {
        return ((Boolean) this.a.j(obj)).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x008e  */
    @Override // defpackage.ba2
    public final Map d() {
        char c;
        long j;
        long j2;
        long j3;
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        gm1 gm1Var = this.b;
        if (gm1Var == null && this.c == null) {
            return ji0.a;
        }
        int i3 = 0;
        int i4 = gm1Var != null ? gm1Var.e : 0;
        gm1 gm1Var2 = this.c;
        HashMap map = new HashMap(i4 + (gm1Var2 != null ? gm1Var2.e : 0));
        char c2 = 7;
        long j4 = -9187201950435737472L;
        int i5 = 8;
        if (gm1Var != null) {
            Object[] objArr = gm1Var.b;
            Object[] objArr2 = gm1Var.c;
            long[] jArr3 = gm1Var.a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i6 = 0;
                j2 = 128;
                while (true) {
                    long j5 = jArr3[i6];
                    j3 = 255;
                    if ((((~j5) << c2) & j5 & j4) != j4) {
                        int i7 = 8 - ((~(i6 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j5 & 255) < 128) {
                                int i9 = (i6 << 3) + i8;
                                map.put((String) objArr[i9], (List) objArr2[i9]);
                            }
                            j5 >>= 8;
                            i8++;
                            c2 = c2;
                            j4 = j4;
                        }
                        c = c2;
                        j = j4;
                        if (i7 != 8) {
                            break;
                        }
                    } else {
                        c = c2;
                        j = j4;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    c2 = c;
                    j4 = j;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 128;
                j3 = 255;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 128;
            j3 = 255;
        }
        gm1 gm1Var3 = this.c;
        if (gm1Var3 != null) {
            Object[] objArr3 = gm1Var3.b;
            Object[] objArr4 = gm1Var3.c;
            long[] jArr4 = gm1Var3.a;
            int length2 = jArr4.length - 2;
            if (length2 >= 0) {
                int i10 = 0;
                while (true) {
                    long j6 = jArr4[i10];
                    if ((((~j6) << c) & j6 & j) != j) {
                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                        int i12 = i3;
                        while (i12 < i11) {
                            if ((j6 & j3) < j2) {
                                int i13 = (i10 << 3) + i12;
                                Object obj = objArr3[i13];
                                List list = (List) objArr4[i13];
                                String str = (String) obj;
                                i2 = i5;
                                if (list.size() == 1) {
                                    Object objA = ((fq0) list.get(i3)).a();
                                    if (objA != null) {
                                        if (!c(objA)) {
                                            kf2.e(yy3.a(objA));
                                            return null;
                                        }
                                        map.put(str, nz.a(objA));
                                    }
                                    jArr2 = jArr4;
                                } else {
                                    int size = list.size();
                                    ArrayList arrayList = new ArrayList(size);
                                    while (i3 < size) {
                                        long[] jArr5 = jArr4;
                                        Object objA2 = ((fq0) list.get(i3)).a();
                                        if (objA2 != null && !c(objA2)) {
                                            kf2.e(yy3.a(objA2));
                                            return null;
                                        }
                                        arrayList.add(objA2);
                                        i3++;
                                        jArr4 = jArr5;
                                    }
                                    jArr2 = jArr4;
                                    map.put(str, arrayList);
                                }
                            } else {
                                jArr2 = jArr4;
                                i2 = i5;
                            }
                            j6 >>= i2;
                            i12++;
                            i5 = i2;
                            jArr4 = jArr2;
                            i3 = 0;
                        }
                        jArr = jArr4;
                        i = i5;
                        if (i11 != i) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                        i = i5;
                    }
                    if (i10 == length2) {
                        break;
                    }
                    i10++;
                    i5 = i;
                    jArr4 = jArr;
                    i3 = 0;
                }
            }
        }
        return map;
    }

    @Override // defpackage.ba2
    public final Object e(String str) {
        gm1 gm1Var = this.b;
        List list = gm1Var != null ? (List) gm1Var.k(str) : null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() > 1 && gm1Var != null) {
            List listSubList = list.subList(1, list.size());
            int iF = gm1Var.f(str);
            if (iF < 0) {
                iF = ~iF;
            }
            Object[] objArr = gm1Var.c;
            Object obj = objArr[iF];
            gm1Var.b[iF] = str;
            objArr[iF] = listSubList;
        }
        return list.get(0);
    }
}
