package defpackage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ui1 implements db2 {
    public static final int[] n = new int[0];
    public static final Unsafe o = c53.i();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final j1 e;
    public final boolean f;
    public final int[] g;
    public final int h;
    public final int i;
    public final tn1 j;
    public final sc1 k;
    public final s43 l;
    public final yg1 m;

    public ui1(int[] iArr, Object[] objArr, int i, int i2, j1 j1Var, int[] iArr2, int i3, int i4, tn1 tn1Var, sc1 sc1Var, s43 s43Var, xk0 xk0Var, yg1 yg1Var) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.f = j1Var instanceof yt0;
        this.g = iArr2;
        this.h = i3;
        this.i = i4;
        this.j = tn1Var;
        this.k = sc1Var;
        this.l = s43Var;
        this.e = j1Var;
        this.m = yg1Var;
    }

    public static Field F(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static int K(int i) {
        return (i & 267386880) >>> 20;
    }

    public static boolean p(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof yt0) {
            return ((yt0) obj).g();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:120:0x025b  */
    /* JADX WARN: Code duplicated, block: B:121:0x025e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0275  */
    /* JADX WARN: Code duplicated, block: B:125:0x0278  */
    /* JADX WARN: Code duplicated, block: B:162:0x0334  */
    /* JADX WARN: Code duplicated, block: B:177:0x037e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0388  */
    /* JADX WARN: Code duplicated, block: B:183:0x0398  */
    public static ui1 w(v22 v22Var, tn1 tn1Var, sc1 sc1Var, s43 s43Var, xk0 xk0Var, yg1 yg1Var) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        int i22;
        int i23;
        Field fieldF;
        char cCharAt9;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldF2;
        int i27;
        Object obj2;
        Field fieldF3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        String str = v22Var.b;
        int length = str.length();
        int i32 = 55296;
        if (str.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (str.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt2 = str.charAt(i);
        if (iCharAt2 >= 55296) {
            int i35 = iCharAt2 & 8191;
            int i36 = 13;
            while (true) {
                i31 = i34 + 1;
                cCharAt13 = str.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i31;
            }
            iCharAt2 = i35 | (cCharAt13 << i36);
            i34 = i31;
        }
        if (iCharAt2 == 0) {
            i3 = 0;
            i6 = 0;
            iCharAt = 0;
            i2 = 0;
            i5 = 0;
            i7 = 0;
            iArr = n;
            i4 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt3 = str.charAt(i34);
            if (iCharAt3 >= 55296) {
                int i38 = iCharAt3 & 8191;
                int i39 = 13;
                while (true) {
                    i15 = i37 + 1;
                    cCharAt8 = str.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i15;
                }
                iCharAt3 = i38 | (cCharAt8 << i39);
                i37 = i15;
            }
            int i40 = i37 + 1;
            int iCharAt4 = str.charAt(i37);
            if (iCharAt4 >= 55296) {
                int i41 = iCharAt4 & 8191;
                int i42 = 13;
                while (true) {
                    i14 = i40 + 1;
                    cCharAt7 = str.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i14;
                }
                iCharAt4 = i41 | (cCharAt7 << i42);
                i40 = i14;
            }
            int i43 = i40 + 1;
            int iCharAt5 = str.charAt(i40);
            if (iCharAt5 >= 55296) {
                int i44 = iCharAt5 & 8191;
                int i45 = 13;
                while (true) {
                    i13 = i43 + 1;
                    cCharAt6 = str.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i13;
                }
                iCharAt5 = i44 | (cCharAt6 << i45);
                i43 = i13;
            }
            int i46 = i43 + 1;
            int iCharAt6 = str.charAt(i43);
            if (iCharAt6 >= 55296) {
                int i47 = iCharAt6 & 8191;
                int i48 = 13;
                while (true) {
                    i12 = i46 + 1;
                    cCharAt5 = str.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i12;
                }
                iCharAt6 = i47 | (cCharAt5 << i48);
                i46 = i12;
            }
            int i49 = i46 + 1;
            iCharAt = str.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i11 = i49 + 1;
                    cCharAt4 = str.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i11;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i11;
            }
            int i52 = i49 + 1;
            int iCharAt7 = str.charAt(i49);
            if (iCharAt7 >= 55296) {
                int i53 = iCharAt7 & 8191;
                int i54 = 13;
                while (true) {
                    i10 = i52 + 1;
                    cCharAt3 = str.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i10;
                }
                iCharAt7 = i53 | (cCharAt3 << i54);
                i52 = i10;
            }
            int i55 = i52 + 1;
            int iCharAt8 = str.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i9 = i55 + 1;
                    cCharAt2 = str.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i9;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i9;
            }
            int i58 = i55 + 1;
            int iCharAt9 = str.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i8 = i58 + 1;
                    cCharAt = str.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i8;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i8;
            }
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i61 = (iCharAt3 * 2) + iCharAt4;
            int i62 = iCharAt7;
            i2 = iCharAt5;
            i3 = i62;
            i4 = iCharAt3;
            i34 = i58;
            iArr = iArr2;
            i5 = iCharAt6;
            i6 = i61;
            i7 = iCharAt9;
        }
        Unsafe unsafe = o;
        Object[] objArr = v22Var.c;
        Class<?> cls = v22Var.a.getClass();
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr2 = new Object[iCharAt * 2];
        int i63 = i7 + i3;
        int i64 = i63;
        int i65 = i7;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = str.charAt(i34);
            if (iCharAt10 >= i32) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i30 = i70 + 1;
                    cCharAt12 = str.charAt(i70);
                    i16 = length;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i30;
                    length = i16;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i17 = i30;
            } else {
                i16 = length;
                i17 = i68;
            }
            int i72 = i17 + 1;
            int iCharAt11 = str.charAt(i17);
            Object[] objArr3 = objArr;
            char c = 55296;
            if (iCharAt11 >= 55296) {
                int i73 = iCharAt11 & 8191;
                int i74 = 13;
                while (true) {
                    i29 = i72 + 1;
                    cCharAt11 = str.charAt(i72);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i74;
                    i74 += 13;
                    i72 = i29;
                    c = 55296;
                }
                iCharAt11 = i73 | (cCharAt11 << i74);
                i72 = i29;
            }
            int i75 = iCharAt11 & 255;
            int i76 = iCharAt10;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int[] iArr4 = iArr3;
            if (i75 >= 51) {
                int i77 = i72 + 1;
                int iCharAt12 = str.charAt(i72);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i78 = iCharAt12 & 8191;
                    int i79 = 13;
                    while (true) {
                        i28 = i77 + 1;
                        cCharAt10 = str.charAt(i77);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i78 |= (cCharAt10 & 8191) << i79;
                        i79 += 13;
                        i77 = i28;
                        c2 = 55296;
                    }
                    iCharAt12 = i78 | (cCharAt10 << i79);
                    i77 = i28;
                }
                int i80 = i75 - 51;
                int i81 = i77;
                if (i80 == 9 || i80 == 17) {
                    i25 = i6 + 1;
                    objArr2[((i67 / 3) * 2) + 1] = objArr3[i6];
                } else {
                    if (i80 == 12 && (cq.a(v22Var.a(), 1) || (iCharAt11 & 2048) != 0)) {
                        i25 = i6 + 1;
                        objArr2[((i67 / 3) * 2) + 1] = objArr3[i6];
                    }
                    i26 = iCharAt12 * 2;
                    obj = objArr3[i26];
                    if (obj instanceof Field) {
                        fieldF2 = (Field) obj;
                    } else {
                        fieldF2 = F(cls, (String) obj);
                        objArr3[i26] = fieldF2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldF2);
                    i27 = i26 + 1;
                    obj2 = objArr3[i27];
                    if (obj2 instanceof Field) {
                        fieldF3 = (Field) obj2;
                    } else {
                        fieldF3 = F(cls, (String) obj2);
                        objArr3[i27] = fieldF3;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldF3);
                    int i82 = i4;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    i23 = iObjectFieldOffset3;
                    i18 = i82;
                    i22 = i6;
                    i20 = i81;
                    i21 = 0;
                    cls = cls;
                }
                i6 = i25;
                i26 = iCharAt12 * 2;
                obj = objArr3[i26];
                if (obj instanceof Field) {
                    fieldF2 = (Field) obj;
                } else {
                    fieldF2 = F(cls, (String) obj);
                    objArr3[i26] = fieldF2;
                }
                int iObjectFieldOffset5 = (int) unsafe.objectFieldOffset(fieldF2);
                i27 = i26 + 1;
                obj2 = objArr3[i27];
                if (obj2 instanceof Field) {
                    fieldF3 = (Field) obj2;
                } else {
                    fieldF3 = F(cls, (String) obj2);
                    objArr3[i27] = fieldF3;
                }
                int iObjectFieldOffset6 = (int) unsafe.objectFieldOffset(fieldF3);
                int i83 = i4;
                iObjectFieldOffset2 = iObjectFieldOffset6;
                i23 = iObjectFieldOffset5;
                i18 = i83;
                i22 = i6;
                i20 = i81;
                i21 = 0;
                cls = cls;
            } else {
                int i84 = i6 + 1;
                Field fieldF4 = F(cls, (String) objArr3[i6]);
                if (i75 == 9 || i75 == 17) {
                    i18 = i4;
                    objArr2[((i67 / 3) * 2) + 1] = fieldF4.getType();
                } else {
                    if (i75 == 27 || i75 == 49) {
                        i18 = i4;
                        i24 = i6 + 2;
                        objArr2[((i67 / 3) * 2) + 1] = objArr3[i84];
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        i18 = i4;
                        if (v22Var.a() == 1 || (iCharAt11 & 2048) != 0) {
                            i24 = i6 + 2;
                            objArr2[((i67 / 3) * 2) + 1] = objArr3[i84];
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldF4);
                        if ((iCharAt11 & 4096) != 0 || i75 > 17) {
                            iObjectFieldOffset2 = 1048575;
                            i20 = i72;
                            i21 = 0;
                        } else {
                            int i85 = i72 + 1;
                            int iCharAt13 = str.charAt(i72);
                            if (iCharAt13 >= 55296) {
                                int i86 = iCharAt13 & 8191;
                                int i87 = 13;
                                while (true) {
                                    i20 = i85 + 1;
                                    cCharAt9 = str.charAt(i85);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i86 |= (cCharAt9 & 8191) << i87;
                                    i87 += 13;
                                    i85 = i20;
                                }
                                iCharAt13 = i86 | (cCharAt9 << i87);
                            } else {
                                i20 = i85;
                            }
                            int i88 = (iCharAt13 / 32) + (i18 * 2);
                            Object obj3 = objArr3[i88];
                            if (obj3 instanceof Field) {
                                fieldF = (Field) obj3;
                            } else {
                                fieldF = F(cls, (String) obj3);
                                objArr3[i88] = fieldF;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldF);
                            i21 = iCharAt13 % 32;
                        }
                        if (i75 >= 18 || i75 > 49) {
                            i22 = i19;
                            i23 = iObjectFieldOffset;
                        } else {
                            iArr[i64] = iObjectFieldOffset;
                            i22 = i19;
                            i23 = iObjectFieldOffset;
                            i64++;
                        }
                    } else {
                        if (i75 == 50) {
                            int i89 = i65 + 1;
                            iArr[i65] = i67;
                            int i90 = (i67 / 3) * 2;
                            int i91 = i6 + 2;
                            objArr2[i90] = objArr3[i84];
                            if ((iCharAt11 & 2048) != 0) {
                                i19 = i6 + 3;
                                objArr2[i90 + 1] = objArr3[i91];
                                i18 = i4;
                                i65 = i89;
                            } else {
                                i19 = i91;
                                i65 = i89;
                                i18 = i4;
                            }
                        } else {
                            i18 = i4;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldF4);
                        if ((iCharAt11 & 4096) != 0) {
                            iObjectFieldOffset2 = 1048575;
                            i20 = i72;
                            i21 = 0;
                        } else {
                            iObjectFieldOffset2 = 1048575;
                            i20 = i72;
                            i21 = 0;
                        }
                        if (i75 >= 18) {
                            i22 = i19;
                            i23 = iObjectFieldOffset;
                        } else {
                            i22 = i19;
                            i23 = iObjectFieldOffset;
                        }
                    }
                    i19 = i24;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldF4);
                    if ((iCharAt11 & 4096) != 0) {
                        iObjectFieldOffset2 = 1048575;
                        i20 = i72;
                        i21 = 0;
                    } else {
                        iObjectFieldOffset2 = 1048575;
                        i20 = i72;
                        i21 = 0;
                    }
                    if (i75 >= 18) {
                        i22 = i19;
                        i23 = iObjectFieldOffset;
                    } else {
                        i22 = i19;
                        i23 = iObjectFieldOffset;
                    }
                }
                i19 = i84;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldF4);
                if ((iCharAt11 & 4096) != 0) {
                    iObjectFieldOffset2 = 1048575;
                    i20 = i72;
                    i21 = 0;
                } else {
                    iObjectFieldOffset2 = 1048575;
                    i20 = i72;
                    i21 = 0;
                }
                if (i75 >= 18) {
                    i22 = i19;
                    i23 = iObjectFieldOffset;
                } else {
                    i22 = i19;
                    i23 = iObjectFieldOffset;
                }
            }
            int i92 = i67 + 1;
            iArr4[i67] = i76;
            int i93 = i67 + 2;
            String str2 = str;
            iArr4[i92] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i75 << 20) | i23;
            i67 += 3;
            iArr4[i93] = (i21 << 20) | iObjectFieldOffset2;
            cls = cls;
            objArr = objArr3;
            str = str2;
            length = i16;
            i4 = i18;
            i34 = i20;
            i32 = 55296;
            i6 = i22;
            iArr3 = iArr4;
        }
        return new ui1(iArr3, objArr2, i2, i5, v22Var.a, iArr, i7, i63, tn1Var, sc1Var, s43Var, xk0Var, yg1Var);
    }

    public static long x(int i) {
        return i & 1048575;
    }

    public static int y(long j, Object obj) {
        return ((Integer) c53.c.h(j, obj)).intValue();
    }

    public static long z(long j, Object obj) {
        return ((Long) c53.c.h(j, obj)).longValue();
    }

    public final int A(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        int[] iArr = this.a;
        int length = (iArr.length / 3) - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final void B(Object obj, long j, iz izVar, db2 db2Var, wk0 wk0Var) throws n31 {
        int iZ;
        this.k.getClass();
        w21 w21VarA = sc1.a(j, obj);
        hz hzVar = (hz) izVar.e;
        int i = izVar.b;
        if ((i & 7) != 3) {
            throw o31.b();
        }
        do {
            yt0 yt0VarI = db2Var.i();
            izVar.f(yt0VarI, db2Var, wk0Var);
            db2Var.c(yt0VarI);
            ((x12) w21VarA).add(yt0VarI);
            if (hzVar.d() || izVar.d != 0) {
                return;
            } else {
                iZ = hzVar.z();
            }
        } while (iZ == i);
        izVar.d = iZ;
    }

    public final void C(Object obj, int i, iz izVar, db2 db2Var, wk0 wk0Var) throws o31 {
        int iZ;
        this.k.getClass();
        w21 w21VarA = sc1.a(i & 1048575, obj);
        hz hzVar = (hz) izVar.e;
        int i2 = izVar.b;
        if ((i2 & 7) != 2) {
            throw o31.b();
        }
        do {
            yt0 yt0VarI = db2Var.i();
            izVar.g(yt0VarI, db2Var, wk0Var);
            db2Var.c(yt0VarI);
            ((x12) w21VarA).add(yt0VarI);
            if (hzVar.d() || izVar.d != 0) {
                return;
            } else {
                iZ = hzVar.z();
            }
        } while (iZ == i2);
        izVar.d = iZ;
    }

    public final void D(int i, iz izVar, Object obj) throws n31 {
        if ((536870912 & i) != 0) {
            izVar.A(2);
            c53.o(obj, i & 1048575, ((hz) izVar.e).y());
        } else if (!this.f) {
            c53.o(obj, i & 1048575, izVar.i());
        } else {
            izVar.A(2);
            c53.o(obj, i & 1048575, ((hz) izVar.e).x());
        }
    }

    public final void E(int i, iz izVar, Object obj) throws n31 {
        boolean z = (536870912 & i) != 0;
        sc1 sc1Var = this.k;
        if (z) {
            sc1Var.getClass();
            izVar.w(sc1.a(i & 1048575, obj), true);
        } else {
            sc1Var.getClass();
            izVar.w(sc1.a(i & 1048575, obj), false);
        }
    }

    public final void G(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        c53.m((1 << (i2 >>> 20)) | c53.c.f(j, obj), j, obj);
    }

    public final void H(int i, int i2, Object obj) {
        c53.m(i, this.a[i2 + 2] & 1048575, obj);
    }

    public final void I(Object obj, int i, j1 j1Var) {
        o.putObject(obj, L(i) & 1048575, j1Var);
        G(i, obj);
    }

    public final void J(Object obj, int i, int i2, j1 j1Var) {
        o.putObject(obj, L(i2) & 1048575, j1Var);
        H(i, i2, obj);
    }

    public final int L(int i) {
        return this.a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:117:0x035a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0367  */
    /* JADX WARN: Code duplicated, block: B:124:0x037a  */
    /* JADX WARN: Code duplicated, block: B:125:0x038a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0394  */
    /* JADX WARN: Code duplicated, block: B:129:0x039e  */
    /* JADX WARN: Code duplicated, block: B:130:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:131:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:133:0x03be  */
    /* JADX WARN: Code duplicated, block: B:135:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:136:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:137:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:138:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:140:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:141:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:142:0x0405  */
    /* JADX WARN: Code duplicated, block: B:143:0x040e  */
    /* JADX WARN: Code duplicated, block: B:144:0x0415  */
    /* JADX WARN: Code duplicated, block: B:145:0x041d  */
    /* JADX WARN: Code duplicated, block: B:146:0x042a  */
    /* JADX WARN: Code duplicated, block: B:147:0x0436  */
    /* JADX WARN: Code duplicated, block: B:148:0x0442  */
    /* JADX WARN: Code duplicated, block: B:149:0x044a  */
    /* JADX WARN: Code duplicated, block: B:278:0x0363 A[SYNTHETIC] */
    public final void M(Object obj, uf1 uf1Var) throws IOException {
        int i;
        int i2;
        int i3;
        boolean z;
        int iJ;
        int size;
        int i4;
        int iA;
        int i5;
        int i6;
        int iH;
        int iJ2;
        int size2;
        int i7;
        ui1 ui1Var = this;
        int[] iArr = ui1Var.a;
        int length = iArr.length;
        Unsafe unsafe = o;
        int i8 = 1048575;
        int i9 = 1048575;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int iL = ui1Var.L(i10);
            int i12 = iArr[i10];
            int iK = K(iL);
            int i13 = 1;
            if (iK <= 17) {
                int i14 = iArr[i10 + 2];
                int i15 = i14 & i8;
                if (i15 != i9) {
                    i11 = i15 == i8 ? 0 : unsafe.getInt(obj, i15);
                    i9 = i15;
                }
                i = 1 << (i14 >>> 20);
            } else {
                i = 0;
            }
            long j = iL & i8;
            switch (iK) {
                case 0:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        double d = c53.c.d(j, obj);
                        kz kzVar = (kz) uf1Var.b;
                        kzVar.getClass();
                        kzVar.t(i12, Double.doubleToRawLongBits(d));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 1:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        float fE = c53.c.e(j, obj);
                        kz kzVar2 = (kz) uf1Var.b;
                        kzVar2.getClass();
                        kzVar2.r(i12, Float.floatToRawIntBits(fE));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 2:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).E(i12, unsafe.getLong(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 3:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).E(i12, unsafe.getLong(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 4:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).v(i12, unsafe.getInt(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 5:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).t(i12, unsafe.getLong(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 6:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).r(i12, unsafe.getInt(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 7:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).o(i12, c53.c.c(j, obj));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 8:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof String) {
                            ((kz) uf1Var.b).z(i12, (String) object);
                        } else {
                            ((kz) uf1Var.b).p(i12, (no) object);
                        }
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 9:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).y(i12, (j1) unsafe.getObject(obj, j), ui1Var.m(i10));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 10:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).p(i12, (no) unsafe.getObject(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 11:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).C(i12, unsafe.getInt(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 12:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).v(i12, unsafe.getInt(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 13:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).r(i12, unsafe.getInt(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 14:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        ((kz) uf1Var.b).t(i12, unsafe.getLong(obj, j));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 15:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        int i16 = unsafe.getInt(obj, j);
                        ((kz) uf1Var.b).C(i12, (i16 >> 31) ^ (i16 << 1));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 16:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        ((kz) uf1Var.b).E(i12, (j2 >> 63) ^ (j2 << 1));
                    }
                    ui1Var = this;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 17:
                    if (ui1Var.o(obj, i10, i9, i11, i)) {
                        uf1Var.z(i12, unsafe.getObject(obj, j), ui1Var.m(i10));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 18:
                    i9 = i9;
                    i11 = i11;
                    gb2.n(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 19:
                    i9 = i9;
                    i11 = i11;
                    gb2.r(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 20:
                    i9 = i9;
                    i11 = i11;
                    gb2.t(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 21:
                    i9 = i9;
                    i11 = i11;
                    gb2.z(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 22:
                    i9 = i9;
                    i11 = i11;
                    gb2.s(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 23:
                    i9 = i9;
                    i11 = i11;
                    gb2.q(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 24:
                    i9 = i9;
                    i11 = i11;
                    gb2.p(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 25:
                    i9 = i9;
                    i11 = i11;
                    gb2.m(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 26:
                    i2 = i9;
                    i3 = i11;
                    int i17 = iArr[i10];
                    List list = (List) unsafe.getObject(obj, j);
                    Class cls = gb2.a;
                    if (list != null && !list.isEmpty()) {
                        uf1Var.getClass();
                        for (int i18 = 0; i18 < list.size(); i18++) {
                            ((kz) uf1Var.b).z(i17, (String) list.get(i18));
                        }
                    }
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 27:
                    i2 = i9;
                    i3 = i11;
                    int i19 = iArr[i10];
                    List list2 = (List) unsafe.getObject(obj, j);
                    db2 db2VarM = ui1Var.m(i10);
                    Class cls2 = gb2.a;
                    if (list2 != null && !list2.isEmpty()) {
                        uf1Var.getClass();
                        for (int i20 = 0; i20 < list2.size(); i20++) {
                            ((kz) uf1Var.b).y(i19, (j1) list2.get(i20), db2VarM);
                        }
                    }
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 28:
                    i2 = i9;
                    i3 = i11;
                    int i21 = iArr[i10];
                    List list3 = (List) unsafe.getObject(obj, j);
                    Class cls3 = gb2.a;
                    if (list3 != null && !list3.isEmpty()) {
                        uf1Var.getClass();
                        for (int i22 = 0; i22 < list3.size(); i22++) {
                            ((kz) uf1Var.b).p(i21, (no) list3.get(i22));
                        }
                    }
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 29:
                    z = false;
                    gb2.y(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 30:
                    z = false;
                    gb2.o(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 31:
                    z = false;
                    gb2.u(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 32:
                    z = false;
                    gb2.v(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 33:
                    z = false;
                    gb2.w(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 34:
                    z = false;
                    gb2.x(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, false);
                    i9 = i9;
                    i11 = i11;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 35:
                    i2 = i9;
                    i3 = i11;
                    gb2.n(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 36:
                    i2 = i9;
                    i3 = i11;
                    gb2.r(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 37:
                    i2 = i9;
                    i3 = i11;
                    gb2.t(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 38:
                    i2 = i9;
                    i3 = i11;
                    gb2.z(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 39:
                    i2 = i9;
                    i3 = i11;
                    gb2.s(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 40:
                    i2 = i9;
                    i3 = i11;
                    gb2.q(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 41:
                    i2 = i9;
                    i3 = i11;
                    gb2.p(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 42:
                    i2 = i9;
                    i3 = i11;
                    gb2.m(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 43:
                    i2 = i9;
                    i3 = i11;
                    gb2.y(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 44:
                    i2 = i9;
                    i3 = i11;
                    gb2.o(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 45:
                    i2 = i9;
                    i3 = i11;
                    gb2.u(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 46:
                    i2 = i9;
                    i3 = i11;
                    gb2.v(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 47:
                    i2 = i9;
                    i3 = i11;
                    gb2.w(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 48:
                    i2 = i9;
                    i3 = i11;
                    gb2.x(iArr[i10], (List) unsafe.getObject(obj, j), uf1Var, true);
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 49:
                    i2 = i9;
                    i3 = i11;
                    int i23 = iArr[i10];
                    List list4 = (List) unsafe.getObject(obj, j);
                    db2 db2VarM2 = ui1Var.m(i10);
                    Class cls4 = gb2.a;
                    if (list4 != null && !list4.isEmpty()) {
                        uf1Var.getClass();
                        for (int i24 = 0; i24 < list4.size(); i24++) {
                            uf1Var.z(i23, list4.get(i24), db2VarM2);
                        }
                    }
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j);
                    if (object2 != null) {
                        int i25 = 2;
                        Object obj2 = ui1Var.b[(i10 / 3) * 2];
                        ui1Var.m.getClass();
                        kf kfVar = ((wg1) obj2).a;
                        jc3 jc3Var = (jc3) kfVar.c;
                        jc3 jc3Var2 = (jc3) kfVar.b;
                        kz kzVar3 = (kz) uf1Var.b;
                        kzVar3.getClass();
                        Iterator it = ((xg1) object2).entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            kzVar3.B(i12, i25);
                            int i26 = i25;
                            Object key = entry.getKey();
                            int i27 = i13;
                            Object value = entry.getValue();
                            int i28 = gl0.c;
                            int iH2 = kz.h(i27);
                            int i29 = i9;
                            gc3 gc3Var = jc3.e;
                            if (jc3Var2 == gc3Var) {
                                iH2 *= 2;
                            }
                            int i30 = i11;
                            switch (jc3Var2.ordinal()) {
                                case 0:
                                    ((Double) key).getClass();
                                    iJ = 8;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key2 = entry.getKey();
                                            Object value2 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key2);
                                            gl0.b(kzVar3, jc3Var, i26, value2);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key3 = entry.getKey();
                                            Object value3 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key3);
                                            gl0.b(kzVar3, jc3Var, i26, value3);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key4 = entry.getKey();
                                            Object value4 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key4);
                                            gl0.b(kzVar3, jc3Var, i26, value4);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key5 = entry.getKey();
                                            Object value5 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key5);
                                            gl0.b(kzVar3, jc3Var, i26, value5);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key6 = entry.getKey();
                                            Object value6 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key6);
                                            gl0.b(kzVar3, jc3Var, i26, value6);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key7 = entry.getKey();
                                            Object value7 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key7);
                                            gl0.b(kzVar3, jc3Var, i26, value7);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key8 = entry.getKey();
                                            Object value8 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key8);
                                            gl0.b(kzVar3, jc3Var, i26, value8);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key9 = entry.getKey();
                                            Object value9 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key9);
                                            gl0.b(kzVar3, jc3Var, i26, value9);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key10 = entry.getKey();
                                            Object value10 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key10);
                                            gl0.b(kzVar3, jc3Var, i26, value10);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11 = entry.getKey();
                                            Object value11 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11);
                                            gl0.b(kzVar3, jc3Var, i26, value11);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key12 = entry.getKey();
                                            Object value12 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key12);
                                            gl0.b(kzVar3, jc3Var, i26, value12);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key13 = entry.getKey();
                                            Object value13 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key13);
                                            gl0.b(kzVar3, jc3Var, i26, value13);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key14 = entry.getKey();
                                            Object value14 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key14);
                                            gl0.b(kzVar3, jc3Var, i26, value14);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key15 = entry.getKey();
                                            Object value15 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key15);
                                            gl0.b(kzVar3, jc3Var, i26, value15);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key16 = entry.getKey();
                                            Object value16 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key16);
                                            gl0.b(kzVar3, jc3Var, i26, value16);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key17 = entry.getKey();
                                            Object value17 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key17);
                                            gl0.b(kzVar3, jc3Var, i26, value17);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue >> 31) ^ (iIntValue << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key18 = entry.getKey();
                                            Object value18 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key18);
                                            gl0.b(kzVar3, jc3Var, i26, value18);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue << i27) ^ (jLongValue >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key19 = entry.getKey();
                                            Object value19 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key19);
                                            gl0.b(kzVar3, jc3Var, i26, value19);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 1:
                                    ((Float) key).getClass();
                                    iJ = 4;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key110 = entry.getKey();
                                            Object value110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key110);
                                            gl0.b(kzVar3, jc3Var, i26, value110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111 = entry.getKey();
                                            Object value111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111);
                                            gl0.b(kzVar3, jc3Var, i26, value111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key112 = entry.getKey();
                                            Object value112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key112);
                                            gl0.b(kzVar3, jc3Var, i26, value112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key113 = entry.getKey();
                                            Object value113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key113);
                                            gl0.b(kzVar3, jc3Var, i26, value113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key114 = entry.getKey();
                                            Object value114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key114);
                                            gl0.b(kzVar3, jc3Var, i26, value114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key115 = entry.getKey();
                                            Object value115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key115);
                                            gl0.b(kzVar3, jc3Var, i26, value115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key116 = entry.getKey();
                                            Object value116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key116);
                                            gl0.b(kzVar3, jc3Var, i26, value116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key117 = entry.getKey();
                                            Object value117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key117);
                                            gl0.b(kzVar3, jc3Var, i26, value117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key118 = entry.getKey();
                                            Object value118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key118);
                                            gl0.b(kzVar3, jc3Var, i26, value118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key119 = entry.getKey();
                                            Object value119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key119);
                                            gl0.b(kzVar3, jc3Var, i26, value119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1110 = entry.getKey();
                                            Object value1110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1110);
                                            gl0.b(kzVar3, jc3Var, i26, value1110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111 = entry.getKey();
                                            Object value1111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1112 = entry.getKey();
                                            Object value1112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1112);
                                            gl0.b(kzVar3, jc3Var, i26, value1112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1113 = entry.getKey();
                                            Object value1113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1113);
                                            gl0.b(kzVar3, jc3Var, i26, value1113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1114 = entry.getKey();
                                            Object value1114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1114);
                                            gl0.b(kzVar3, jc3Var, i26, value1114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1115 = entry.getKey();
                                            Object value1115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1115);
                                            gl0.b(kzVar3, jc3Var, i26, value1115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue2 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue2 >> 31) ^ (iIntValue2 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1116 = entry.getKey();
                                            Object value1116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1116);
                                            gl0.b(kzVar3, jc3Var, i26, value1116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue2 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue2 << i27) ^ (jLongValue2 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1117 = entry.getKey();
                                            Object value1117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1117);
                                            gl0.b(kzVar3, jc3Var, i26, value1117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 2:
                                    it = it;
                                    iJ = kz.j(((Long) key).longValue());
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1118 = entry.getKey();
                                            Object value1118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1118);
                                            gl0.b(kzVar3, jc3Var, i26, value1118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1119 = entry.getKey();
                                            Object value1119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1119);
                                            gl0.b(kzVar3, jc3Var, i26, value1119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11110 = entry.getKey();
                                            Object value11110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11110);
                                            gl0.b(kzVar3, jc3Var, i26, value11110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111 = entry.getKey();
                                            Object value11111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11112 = entry.getKey();
                                            Object value11112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11112);
                                            gl0.b(kzVar3, jc3Var, i26, value11112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11113 = entry.getKey();
                                            Object value11113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11113);
                                            gl0.b(kzVar3, jc3Var, i26, value11113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11114 = entry.getKey();
                                            Object value11114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11114);
                                            gl0.b(kzVar3, jc3Var, i26, value11114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11115 = entry.getKey();
                                            Object value11115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11115);
                                            gl0.b(kzVar3, jc3Var, i26, value11115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11116 = entry.getKey();
                                            Object value11116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11116);
                                            gl0.b(kzVar3, jc3Var, i26, value11116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11117 = entry.getKey();
                                            Object value11117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11117);
                                            gl0.b(kzVar3, jc3Var, i26, value11117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11118 = entry.getKey();
                                            Object value11118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11118);
                                            gl0.b(kzVar3, jc3Var, i26, value11118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11119 = entry.getKey();
                                            Object value11119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11119);
                                            gl0.b(kzVar3, jc3Var, i26, value11119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111110 = entry.getKey();
                                            Object value111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111 = entry.getKey();
                                            Object value111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111112 = entry.getKey();
                                            Object value111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111113 = entry.getKey();
                                            Object value111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue3 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue3 >> 31) ^ (iIntValue3 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111114 = entry.getKey();
                                            Object value111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue3 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue3 << i27) ^ (jLongValue3 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111115 = entry.getKey();
                                            Object value111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 3:
                                    it = it;
                                    iJ = kz.j(((Long) key).longValue());
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111116 = entry.getKey();
                                            Object value111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111116);
                                            gl0.b(kzVar3, jc3Var, i26, value111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111117 = entry.getKey();
                                            Object value111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111117);
                                            gl0.b(kzVar3, jc3Var, i26, value111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111118 = entry.getKey();
                                            Object value111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111118);
                                            gl0.b(kzVar3, jc3Var, i26, value111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111119 = entry.getKey();
                                            Object value111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111119);
                                            gl0.b(kzVar3, jc3Var, i26, value111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111110 = entry.getKey();
                                            Object value1111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111110);
                                            gl0.b(kzVar3, jc3Var, i26, value1111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111 = entry.getKey();
                                            Object value1111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111112 = entry.getKey();
                                            Object value1111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111112);
                                            gl0.b(kzVar3, jc3Var, i26, value1111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111113 = entry.getKey();
                                            Object value1111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111113);
                                            gl0.b(kzVar3, jc3Var, i26, value1111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111114 = entry.getKey();
                                            Object value1111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111114);
                                            gl0.b(kzVar3, jc3Var, i26, value1111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111115 = entry.getKey();
                                            Object value1111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111115);
                                            gl0.b(kzVar3, jc3Var, i26, value1111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111116 = entry.getKey();
                                            Object value1111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111116);
                                            gl0.b(kzVar3, jc3Var, i26, value1111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111117 = entry.getKey();
                                            Object value1111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111117);
                                            gl0.b(kzVar3, jc3Var, i26, value1111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111118 = entry.getKey();
                                            Object value1111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111118);
                                            gl0.b(kzVar3, jc3Var, i26, value1111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111119 = entry.getKey();
                                            Object value1111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111119);
                                            gl0.b(kzVar3, jc3Var, i26, value1111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111110 = entry.getKey();
                                            Object value11111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111110);
                                            gl0.b(kzVar3, jc3Var, i26, value11111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111 = entry.getKey();
                                            Object value11111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue4 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue4 >> 31) ^ (iIntValue4 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111112 = entry.getKey();
                                            Object value11111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111112);
                                            gl0.b(kzVar3, jc3Var, i26, value11111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue4 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue4 << i27) ^ (jLongValue4 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111113 = entry.getKey();
                                            Object value11111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111113);
                                            gl0.b(kzVar3, jc3Var, i26, value11111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 4:
                                    it = it;
                                    iJ = kz.j(((Integer) key).intValue());
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111114 = entry.getKey();
                                            Object value11111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111114);
                                            gl0.b(kzVar3, jc3Var, i26, value11111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111115 = entry.getKey();
                                            Object value11111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111115);
                                            gl0.b(kzVar3, jc3Var, i26, value11111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111116 = entry.getKey();
                                            Object value11111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111116);
                                            gl0.b(kzVar3, jc3Var, i26, value11111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111117 = entry.getKey();
                                            Object value11111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111117);
                                            gl0.b(kzVar3, jc3Var, i26, value11111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111118 = entry.getKey();
                                            Object value11111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111118);
                                            gl0.b(kzVar3, jc3Var, i26, value11111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111119 = entry.getKey();
                                            Object value11111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111119);
                                            gl0.b(kzVar3, jc3Var, i26, value11111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111110 = entry.getKey();
                                            Object value111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111 = entry.getKey();
                                            Object value111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111112 = entry.getKey();
                                            Object value111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111113 = entry.getKey();
                                            Object value111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111114 = entry.getKey();
                                            Object value111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111115 = entry.getKey();
                                            Object value111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111116 = entry.getKey();
                                            Object value111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111117 = entry.getKey();
                                            Object value111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111118 = entry.getKey();
                                            Object value111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111119 = entry.getKey();
                                            Object value111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue5 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue5 >> 31) ^ (iIntValue5 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111110 = entry.getKey();
                                            Object value1111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue5 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue5 << i27) ^ (jLongValue5 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111 = entry.getKey();
                                            Object value1111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 5:
                                    ((Long) key).getClass();
                                    iJ = 8;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111112 = entry.getKey();
                                            Object value1111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111113 = entry.getKey();
                                            Object value1111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111114 = entry.getKey();
                                            Object value1111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111115 = entry.getKey();
                                            Object value1111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111116 = entry.getKey();
                                            Object value1111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111117 = entry.getKey();
                                            Object value1111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111118 = entry.getKey();
                                            Object value1111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111119 = entry.getKey();
                                            Object value1111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111110 = entry.getKey();
                                            Object value11111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111 = entry.getKey();
                                            Object value11111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111112 = entry.getKey();
                                            Object value11111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111113 = entry.getKey();
                                            Object value11111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111114 = entry.getKey();
                                            Object value11111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111115 = entry.getKey();
                                            Object value11111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111116 = entry.getKey();
                                            Object value11111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111117 = entry.getKey();
                                            Object value11111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue6 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue6 >> 31) ^ (iIntValue6 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111118 = entry.getKey();
                                            Object value11111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue6 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue6 << i27) ^ (jLongValue6 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111119 = entry.getKey();
                                            Object value11111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 6:
                                    ((Integer) key).getClass();
                                    iJ = 4;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111110 = entry.getKey();
                                            Object value111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111 = entry.getKey();
                                            Object value111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111112 = entry.getKey();
                                            Object value111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111113 = entry.getKey();
                                            Object value111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111114 = entry.getKey();
                                            Object value111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111115 = entry.getKey();
                                            Object value111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111116 = entry.getKey();
                                            Object value111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111117 = entry.getKey();
                                            Object value111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111118 = entry.getKey();
                                            Object value111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111119 = entry.getKey();
                                            Object value111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111110 = entry.getKey();
                                            Object value1111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111 = entry.getKey();
                                            Object value1111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111112 = entry.getKey();
                                            Object value1111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111113 = entry.getKey();
                                            Object value1111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111114 = entry.getKey();
                                            Object value1111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111115 = entry.getKey();
                                            Object value1111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue7 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue7 >> 31) ^ (iIntValue7 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111116 = entry.getKey();
                                            Object value1111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue7 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue7 << i27) ^ (jLongValue7 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111117 = entry.getKey();
                                            Object value1111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 7:
                                    it = it;
                                    ((Boolean) key).getClass();
                                    iJ = i27;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111118 = entry.getKey();
                                            Object value1111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111119 = entry.getKey();
                                            Object value1111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111110 = entry.getKey();
                                            Object value11111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111 = entry.getKey();
                                            Object value11111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111112 = entry.getKey();
                                            Object value11111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111113 = entry.getKey();
                                            Object value11111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111114 = entry.getKey();
                                            Object value11111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111115 = entry.getKey();
                                            Object value11111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111116 = entry.getKey();
                                            Object value11111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111117 = entry.getKey();
                                            Object value11111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111118 = entry.getKey();
                                            Object value11111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111119 = entry.getKey();
                                            Object value11111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111110 = entry.getKey();
                                            Object value111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111 = entry.getKey();
                                            Object value111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111112 = entry.getKey();
                                            Object value111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111113 = entry.getKey();
                                            Object value111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue8 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue8 >> 31) ^ (iIntValue8 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111114 = entry.getKey();
                                            Object value111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue8 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue8 << i27) ^ (jLongValue8 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111115 = entry.getKey();
                                            Object value111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 8:
                                    it = it;
                                    if (key instanceof no) {
                                        size = ((no) key).size();
                                        i4 = kz.i(size);
                                        iJ = size + i4;
                                    } else {
                                        iJ = kz.g((String) key);
                                    }
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111116 = entry.getKey();
                                            Object value111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111117 = entry.getKey();
                                            Object value111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111118 = entry.getKey();
                                            Object value111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111119 = entry.getKey();
                                            Object value111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111110 = entry.getKey();
                                            Object value1111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111 = entry.getKey();
                                            Object value1111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111112 = entry.getKey();
                                            Object value1111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111113 = entry.getKey();
                                            Object value1111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111114 = entry.getKey();
                                            Object value1111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111115 = entry.getKey();
                                            Object value1111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111116 = entry.getKey();
                                            Object value1111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111117 = entry.getKey();
                                            Object value1111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111118 = entry.getKey();
                                            Object value1111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111119 = entry.getKey();
                                            Object value1111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111110 = entry.getKey();
                                            Object value11111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111 = entry.getKey();
                                            Object value11111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue9 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue9 >> 31) ^ (iIntValue9 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111112 = entry.getKey();
                                            Object value11111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue9 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue9 << i27) ^ (jLongValue9 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111113 = entry.getKey();
                                            Object value11111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 9:
                                    iA = ((yt0) ((j1) key)).a(null);
                                    iJ = iA;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111114 = entry.getKey();
                                            Object value11111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111115 = entry.getKey();
                                            Object value11111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111116 = entry.getKey();
                                            Object value11111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111117 = entry.getKey();
                                            Object value11111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111118 = entry.getKey();
                                            Object value11111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111119 = entry.getKey();
                                            Object value11111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111110 = entry.getKey();
                                            Object value111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111 = entry.getKey();
                                            Object value111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111112 = entry.getKey();
                                            Object value111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111113 = entry.getKey();
                                            Object value111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111114 = entry.getKey();
                                            Object value111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111115 = entry.getKey();
                                            Object value111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111116 = entry.getKey();
                                            Object value111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111117 = entry.getKey();
                                            Object value111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111118 = entry.getKey();
                                            Object value111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111119 = entry.getKey();
                                            Object value111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue10 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue10 >> 31) ^ (iIntValue10 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111110 = entry.getKey();
                                            Object value1111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue10 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue10 << i27) ^ (jLongValue10 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111 = entry.getKey();
                                            Object value1111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 10:
                                    int iA2 = ((yt0) ((j1) key)).a(null);
                                    iA = iA2 + kz.i(iA2);
                                    iJ = iA;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111112 = entry.getKey();
                                            Object value1111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111113 = entry.getKey();
                                            Object value1111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111114 = entry.getKey();
                                            Object value1111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111115 = entry.getKey();
                                            Object value1111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111116 = entry.getKey();
                                            Object value1111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111117 = entry.getKey();
                                            Object value1111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111118 = entry.getKey();
                                            Object value1111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111119 = entry.getKey();
                                            Object value1111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111110 = entry.getKey();
                                            Object value11111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111 = entry.getKey();
                                            Object value11111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111112 = entry.getKey();
                                            Object value11111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111113 = entry.getKey();
                                            Object value11111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111114 = entry.getKey();
                                            Object value11111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111115 = entry.getKey();
                                            Object value11111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111116 = entry.getKey();
                                            Object value11111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111117 = entry.getKey();
                                            Object value11111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue11 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue11 >> 31) ^ (iIntValue11 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111118 = entry.getKey();
                                            Object value11111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue11 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue11 << i27) ^ (jLongValue11 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111119 = entry.getKey();
                                            Object value11111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 11:
                                    it = it;
                                    if (key instanceof no) {
                                        size = ((no) key).size();
                                        i4 = kz.i(size);
                                    } else {
                                        size = ((byte[]) key).length;
                                        i4 = kz.i(size);
                                    }
                                    iJ = size + i4;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111110 = entry.getKey();
                                            Object value111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111 = entry.getKey();
                                            Object value111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111112 = entry.getKey();
                                            Object value111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111113 = entry.getKey();
                                            Object value111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111114 = entry.getKey();
                                            Object value111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111115 = entry.getKey();
                                            Object value111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111116 = entry.getKey();
                                            Object value111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111117 = entry.getKey();
                                            Object value111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111118 = entry.getKey();
                                            Object value111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111119 = entry.getKey();
                                            Object value111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111110 = entry.getKey();
                                            Object value1111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111 = entry.getKey();
                                            Object value1111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111112 = entry.getKey();
                                            Object value1111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111113 = entry.getKey();
                                            Object value1111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111114 = entry.getKey();
                                            Object value1111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111115 = entry.getKey();
                                            Object value1111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue12 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue12 >> 31) ^ (iIntValue12 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111116 = entry.getKey();
                                            Object value1111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue12 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue12 << i27) ^ (jLongValue12 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111117 = entry.getKey();
                                            Object value1111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 12:
                                    it = it;
                                    iJ = kz.i(((Integer) key).intValue());
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111118 = entry.getKey();
                                            Object value1111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111119 = entry.getKey();
                                            Object value1111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111110 = entry.getKey();
                                            Object value11111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111 = entry.getKey();
                                            Object value11111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111112 = entry.getKey();
                                            Object value11111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111113 = entry.getKey();
                                            Object value11111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111114 = entry.getKey();
                                            Object value11111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111115 = entry.getKey();
                                            Object value11111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111116 = entry.getKey();
                                            Object value11111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111117 = entry.getKey();
                                            Object value11111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111118 = entry.getKey();
                                            Object value11111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111119 = entry.getKey();
                                            Object value11111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111110 = entry.getKey();
                                            Object value111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111 = entry.getKey();
                                            Object value111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111112 = entry.getKey();
                                            Object value111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111113 = entry.getKey();
                                            Object value111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue13 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue13 >> 31) ^ (iIntValue13 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111114 = entry.getKey();
                                            Object value111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue13 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue13 << i27) ^ (jLongValue13 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111115 = entry.getKey();
                                            Object value111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 13:
                                    it = it;
                                    iJ = kz.j(((Integer) key).intValue());
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111116 = entry.getKey();
                                            Object value111111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111117 = entry.getKey();
                                            Object value111111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111118 = entry.getKey();
                                            Object value111111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111119 = entry.getKey();
                                            Object value111111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111110 = entry.getKey();
                                            Object value1111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111 = entry.getKey();
                                            Object value1111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111112 = entry.getKey();
                                            Object value1111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111113 = entry.getKey();
                                            Object value1111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111114 = entry.getKey();
                                            Object value1111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111115 = entry.getKey();
                                            Object value1111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111116 = entry.getKey();
                                            Object value1111111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111117 = entry.getKey();
                                            Object value1111111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111118 = entry.getKey();
                                            Object value1111111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111119 = entry.getKey();
                                            Object value1111111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111110 = entry.getKey();
                                            Object value11111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111 = entry.getKey();
                                            Object value11111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue14 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue14 >> 31) ^ (iIntValue14 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111112 = entry.getKey();
                                            Object value11111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue14 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue14 << i27) ^ (jLongValue14 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111113 = entry.getKey();
                                            Object value11111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 14:
                                    ((Integer) key).getClass();
                                    iJ = 4;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111114 = entry.getKey();
                                            Object value11111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111115 = entry.getKey();
                                            Object value11111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111116 = entry.getKey();
                                            Object value11111111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111117 = entry.getKey();
                                            Object value11111111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111118 = entry.getKey();
                                            Object value11111111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111119 = entry.getKey();
                                            Object value11111111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111110 = entry.getKey();
                                            Object value111111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111 = entry.getKey();
                                            Object value111111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111112 = entry.getKey();
                                            Object value111111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111113 = entry.getKey();
                                            Object value111111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111114 = entry.getKey();
                                            Object value111111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111115 = entry.getKey();
                                            Object value111111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111116 = entry.getKey();
                                            Object value111111111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111117 = entry.getKey();
                                            Object value111111111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111118 = entry.getKey();
                                            Object value111111111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111119 = entry.getKey();
                                            Object value111111111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue15 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue15 >> 31) ^ (iIntValue15 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111110 = entry.getKey();
                                            Object value1111111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue15 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue15 << i27) ^ (jLongValue15 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111 = entry.getKey();
                                            Object value1111111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 15:
                                    ((Long) key).getClass();
                                    iJ = 8;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111112 = entry.getKey();
                                            Object value1111111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111113 = entry.getKey();
                                            Object value1111111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111114 = entry.getKey();
                                            Object value1111111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111115 = entry.getKey();
                                            Object value1111111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111116 = entry.getKey();
                                            Object value1111111111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111117 = entry.getKey();
                                            Object value1111111111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111118 = entry.getKey();
                                            Object value1111111111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111119 = entry.getKey();
                                            Object value1111111111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111110 = entry.getKey();
                                            Object value11111111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111 = entry.getKey();
                                            Object value11111111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111112 = entry.getKey();
                                            Object value11111111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111113 = entry.getKey();
                                            Object value11111111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111114 = entry.getKey();
                                            Object value11111111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111115 = entry.getKey();
                                            Object value11111111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111116 = entry.getKey();
                                            Object value11111111111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111117 = entry.getKey();
                                            Object value11111111111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue16 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue16 >> 31) ^ (iIntValue16 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111118 = entry.getKey();
                                            Object value11111111111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue16 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue16 << i27) ^ (jLongValue16 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111119 = entry.getKey();
                                            Object value11111111111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 16:
                                    int iIntValue17 = ((Integer) key).intValue();
                                    i5 = kz.i((iIntValue17 << 1) ^ (iIntValue17 >> 31));
                                    it = it;
                                    iJ = i5;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111110 = entry.getKey();
                                            Object value111111111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111111 = entry.getKey();
                                            Object value111111111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111112 = entry.getKey();
                                            Object value111111111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111113 = entry.getKey();
                                            Object value111111111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111114 = entry.getKey();
                                            Object value111111111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111115 = entry.getKey();
                                            Object value111111111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111116 = entry.getKey();
                                            Object value111111111111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111117 = entry.getKey();
                                            Object value111111111111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111118 = entry.getKey();
                                            Object value111111111111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111119 = entry.getKey();
                                            Object value111111111111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111110 = entry.getKey();
                                            Object value1111111111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111111 = entry.getKey();
                                            Object value1111111111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111112 = entry.getKey();
                                            Object value1111111111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111113 = entry.getKey();
                                            Object value1111111111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111114 = entry.getKey();
                                            Object value1111111111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111115 = entry.getKey();
                                            Object value1111111111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue18 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue18 >> 31) ^ (iIntValue18 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111116 = entry.getKey();
                                            Object value1111111111111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue17 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue17 << i27) ^ (jLongValue17 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111117 = entry.getKey();
                                            Object value1111111111111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                case 17:
                                    long jLongValue18 = ((Long) key).longValue();
                                    i5 = kz.j((jLongValue18 << i27) ^ (jLongValue18 >> 63));
                                    it = it;
                                    iJ = i5;
                                    i6 = iJ + iH2;
                                    iH = kz.h(i26);
                                    if (jc3Var == gc3Var) {
                                        iH *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111118 = entry.getKey();
                                            Object value1111111111111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key1111111111111111111111111111119 = entry.getKey();
                                            Object value1111111111111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key1111111111111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value1111111111111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 2:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111110 = entry.getKey();
                                            Object value11111111111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 3:
                                            i6 = i6;
                                            iJ2 = kz.j(((Long) value).longValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111111 = entry.getKey();
                                            Object value11111111111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 4:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111112 = entry.getKey();
                                            Object value11111111111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111113 = entry.getKey();
                                            Object value11111111111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111114 = entry.getKey();
                                            Object value11111111111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 7:
                                            i6 = i6;
                                            ((Boolean) value).getClass();
                                            iJ2 = i27;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111115 = entry.getKey();
                                            Object value11111111111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 8:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                                iJ2 = size2 + i7;
                                            } else {
                                                iJ2 = kz.g((String) value);
                                            }
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111116 = entry.getKey();
                                            Object value11111111111111111111111111111116 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111116);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111116);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 9:
                                            i6 = i6;
                                            iJ2 = ((yt0) ((j1) value)).a(null);
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111117 = entry.getKey();
                                            Object value11111111111111111111111111111117 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111117);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111117);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 10:
                                            i6 = i6;
                                            size2 = ((yt0) ((j1) value)).a(null);
                                            i7 = kz.i(size2);
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111118 = entry.getKey();
                                            Object value11111111111111111111111111111118 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111118);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111118);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 11:
                                            i6 = i6;
                                            if (value instanceof no) {
                                                size2 = ((no) value).size();
                                                i7 = kz.i(size2);
                                            } else {
                                                size2 = ((byte[]) value).length;
                                                i7 = kz.i(size2);
                                            }
                                            iJ2 = size2 + i7;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key11111111111111111111111111111119 = entry.getKey();
                                            Object value11111111111111111111111111111119 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key11111111111111111111111111111119);
                                            gl0.b(kzVar3, jc3Var, i26, value11111111111111111111111111111119);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 12:
                                            i6 = i6;
                                            iJ2 = kz.i(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111111110 = entry.getKey();
                                            Object value111111111111111111111111111111110 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111111110);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111111110);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 13:
                                            i6 = i6;
                                            iJ2 = kz.j(((Integer) value).intValue());
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111111111 = entry.getKey();
                                            Object value111111111111111111111111111111111 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111111111);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111111111);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ2 = 4;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111111112 = entry.getKey();
                                            Object value111111111111111111111111111111112 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111111112);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111111112);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ2 = 8;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111111113 = entry.getKey();
                                            Object value111111111111111111111111111111113 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111111113);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111111113);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 16:
                                            int iIntValue19 = ((Integer) value).intValue();
                                            iJ2 = kz.i((iIntValue19 >> 31) ^ (iIntValue19 << 1));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111111114 = entry.getKey();
                                            Object value111111111111111111111111111111114 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111111114);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111111114);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        case 17:
                                            long jLongValue19 = ((Long) value).longValue();
                                            iJ2 = kz.j((jLongValue19 << i27) ^ (jLongValue19 >> 63));
                                            i6 = i6;
                                            kzVar3.D(iJ2 + iH + i6);
                                            Object key111111111111111111111111111111115 = entry.getKey();
                                            Object value111111111111111111111111111111115 = entry.getValue();
                                            gl0.b(kzVar3, jc3Var2, i27, key111111111111111111111111111111115);
                                            gl0.b(kzVar3, jc3Var, i26, value111111111111111111111111111111115);
                                            i25 = i26;
                                            i9 = i29;
                                            it = it;
                                            i11 = i30;
                                            i13 = 1;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            break;
                                    }
                                    break;
                                default:
                                    og.p("There is no way to get here, but the compiler thinks otherwise.");
                                    break;
                            }
                        }
                    }
                    i2 = i9;
                    i3 = i11;
                    i9 = i2;
                    i11 = i3;
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 51:
                    if (ui1Var.q(i12, i10, obj)) {
                        double dDoubleValue = ((Double) c53.c.h(j, obj)).doubleValue();
                        kz kzVar4 = (kz) uf1Var.b;
                        kzVar4.getClass();
                        kzVar4.t(i12, Double.doubleToRawLongBits(dDoubleValue));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 52:
                    if (ui1Var.q(i12, i10, obj)) {
                        float fFloatValue = ((Float) c53.c.h(j, obj)).floatValue();
                        kz kzVar5 = (kz) uf1Var.b;
                        kzVar5.getClass();
                        kzVar5.r(i12, Float.floatToRawIntBits(fFloatValue));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 53:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).E(i12, z(j, obj));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 54:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).E(i12, z(j, obj));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 55:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).v(i12, y(j, obj));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 56:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).t(i12, z(j, obj));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 57:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).r(i12, y(j, obj));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 58:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).o(i12, ((Boolean) c53.c.h(j, obj)).booleanValue());
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 59:
                    if (ui1Var.q(i12, i10, obj)) {
                        Object object3 = unsafe.getObject(obj, j);
                        if (object3 instanceof String) {
                            ((kz) uf1Var.b).z(i12, (String) object3);
                        } else {
                            ((kz) uf1Var.b).p(i12, (no) object3);
                        }
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 60:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).y(i12, (j1) unsafe.getObject(obj, j), ui1Var.m(i10));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 61:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).p(i12, (no) unsafe.getObject(obj, j));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 62:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).C(i12, y(j, obj));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 63:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).v(i12, y(j, obj));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 64:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).r(i12, y(j, obj));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 65:
                    if (ui1Var.q(i12, i10, obj)) {
                        ((kz) uf1Var.b).t(i12, z(j, obj));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 66:
                    if (ui1Var.q(i12, i10, obj)) {
                        int iY = y(j, obj);
                        ((kz) uf1Var.b).C(i12, (iY >> 31) ^ (iY << 1));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 67:
                    if (ui1Var.q(i12, i10, obj)) {
                        long jZ = z(j, obj);
                        ((kz) uf1Var.b).E(i12, (jZ << 1) ^ (jZ >> 63));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                case 68:
                    if (ui1Var.q(i12, i10, obj)) {
                        uf1Var.z(i12, unsafe.getObject(obj, j), ui1Var.m(i10));
                    }
                    i10 += 3;
                    i8 = 1048575;
                    break;
                default:
                    i10 += 3;
                    i8 = 1048575;
                    break;
            }
            return;
        }
        ui1Var.l.getClass();
        ((yt0) obj).unknownFields.d(uf1Var);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.db2
    public final int a(yt0 yt0Var) {
        int i;
        int iB;
        int i2;
        int[] iArr = this.a;
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iL = L(i4);
            int i5 = iArr[i4];
            long j = 1048575 & iL;
            int i6 = 1237;
            int iHashCode = 37;
            switch (K(iL)) {
                case 0:
                    i = i3 * 53;
                    iB = x21.b(Double.doubleToLongBits(c53.c.d(j, yt0Var)));
                    i3 = iB + i;
                    break;
                case 1:
                    i = i3 * 53;
                    iB = Float.floatToIntBits(c53.c.e(j, yt0Var));
                    i3 = iB + i;
                    break;
                case 2:
                    i = i3 * 53;
                    iB = x21.b(c53.c.g(j, yt0Var));
                    i3 = iB + i;
                    break;
                case 3:
                    i = i3 * 53;
                    iB = x21.b(c53.c.g(j, yt0Var));
                    i3 = iB + i;
                    break;
                case 4:
                    i = i3 * 53;
                    iB = c53.c.f(j, yt0Var);
                    i3 = iB + i;
                    break;
                case 5:
                    i = i3 * 53;
                    iB = x21.b(c53.c.g(j, yt0Var));
                    i3 = iB + i;
                    break;
                case 6:
                    i = i3 * 53;
                    iB = c53.c.f(j, yt0Var);
                    i3 = iB + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    boolean zC = c53.c.c(j, yt0Var);
                    Charset charset = x21.a;
                    if (zC) {
                        i6 = 1231;
                    }
                    i3 = i6 + i2;
                    break;
                case 8:
                    i = i3 * 53;
                    iB = ((String) c53.c.h(j, yt0Var)).hashCode();
                    i3 = iB + i;
                    break;
                case 9:
                    Object objH = c53.c.h(j, yt0Var);
                    if (objH != null) {
                        iHashCode = objH.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iB = c53.c.h(j, yt0Var).hashCode();
                    i3 = iB + i;
                    break;
                case 11:
                    i = i3 * 53;
                    iB = c53.c.f(j, yt0Var);
                    i3 = iB + i;
                    break;
                case 12:
                    i = i3 * 53;
                    iB = c53.c.f(j, yt0Var);
                    i3 = iB + i;
                    break;
                case 13:
                    i = i3 * 53;
                    iB = c53.c.f(j, yt0Var);
                    i3 = iB + i;
                    break;
                case 14:
                    i = i3 * 53;
                    iB = x21.b(c53.c.g(j, yt0Var));
                    i3 = iB + i;
                    break;
                case 15:
                    i = i3 * 53;
                    iB = c53.c.f(j, yt0Var);
                    i3 = iB + i;
                    break;
                case 16:
                    i = i3 * 53;
                    iB = x21.b(c53.c.g(j, yt0Var));
                    i3 = iB + i;
                    break;
                case 17:
                    Object objH2 = c53.c.h(j, yt0Var);
                    if (objH2 != null) {
                        iHashCode = objH2.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    iB = c53.c.h(j, yt0Var).hashCode();
                    i3 = iB + i;
                    break;
                case 50:
                    i = i3 * 53;
                    iB = c53.c.h(j, yt0Var).hashCode();
                    i3 = iB + i;
                    break;
                case 51:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = x21.b(Double.doubleToLongBits(((Double) c53.c.h(j, yt0Var)).doubleValue()));
                        i3 = iB + i;
                    }
                    break;
                case 52:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = Float.floatToIntBits(((Float) c53.c.h(j, yt0Var)).floatValue());
                        i3 = iB + i;
                    }
                    break;
                case 53:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = x21.b(z(j, yt0Var));
                        i3 = iB + i;
                    }
                    break;
                case 54:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = x21.b(z(j, yt0Var));
                        i3 = iB + i;
                    }
                    break;
                case 55:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = y(j, yt0Var);
                        i3 = iB + i;
                    }
                    break;
                case 56:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = x21.b(z(j, yt0Var));
                        i3 = iB + i;
                    }
                    break;
                case 57:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = y(j, yt0Var);
                        i3 = iB + i;
                    }
                    break;
                case 58:
                    if (q(i5, i4, yt0Var)) {
                        i2 = i3 * 53;
                        boolean zBooleanValue = ((Boolean) c53.c.h(j, yt0Var)).booleanValue();
                        Charset charset2 = x21.a;
                        if (zBooleanValue) {
                            i6 = 1231;
                        }
                        i3 = i6 + i2;
                    }
                    break;
                case 59:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = ((String) c53.c.h(j, yt0Var)).hashCode();
                        i3 = iB + i;
                    }
                    break;
                case 60:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = c53.c.h(j, yt0Var).hashCode();
                        i3 = iB + i;
                    }
                    break;
                case 61:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = c53.c.h(j, yt0Var).hashCode();
                        i3 = iB + i;
                    }
                    break;
                case 62:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = y(j, yt0Var);
                        i3 = iB + i;
                    }
                    break;
                case 63:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = y(j, yt0Var);
                        i3 = iB + i;
                    }
                    break;
                case 64:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = y(j, yt0Var);
                        i3 = iB + i;
                    }
                    break;
                case 65:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = x21.b(z(j, yt0Var));
                        i3 = iB + i;
                    }
                    break;
                case 66:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = y(j, yt0Var);
                        i3 = iB + i;
                    }
                    break;
                case 67:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = x21.b(z(j, yt0Var));
                        i3 = iB + i;
                    }
                    break;
                case 68:
                    if (q(i5, i4, yt0Var)) {
                        i = i3 * 53;
                        iB = c53.c.h(j, yt0Var).hashCode();
                        i3 = iB + i;
                    }
                    break;
            }
        }
        this.l.getClass();
        return yt0Var.unknownFields.hashCode() + (i3 * 53);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    @Override // defpackage.db2
    public final void b(Object obj, Object obj2) {
        Object obj3;
        if (!p(obj)) {
            dk0.y(obj, "Mutating immutable message: ");
            return;
        }
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                gb2.k(this.l, obj, obj2);
                return;
            }
            int iL = L(i);
            long j = 1048575 & iL;
            int i2 = iArr[i];
            switch (K(iL)) {
                case 0:
                    if (!n(i, obj2)) {
                        obj3 = obj;
                    } else {
                        b53 b53Var = c53.c;
                        obj3 = obj;
                        b53Var.l(obj3, j, b53Var.d(j, obj2));
                        G(i, obj3);
                    }
                    break;
                case 1:
                    if (n(i, obj2)) {
                        b53 b53Var2 = c53.c;
                        b53Var2.m(obj, j, b53Var2.e(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 2:
                    if (n(i, obj2)) {
                        c53.n(obj, j, c53.c.g(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 3:
                    if (n(i, obj2)) {
                        c53.n(obj, j, c53.c.g(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 4:
                    if (n(i, obj2)) {
                        c53.m(c53.c.f(j, obj2), j, obj);
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 5:
                    if (n(i, obj2)) {
                        c53.n(obj, j, c53.c.g(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 6:
                    if (n(i, obj2)) {
                        c53.m(c53.c.f(j, obj2), j, obj);
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 7:
                    if (n(i, obj2)) {
                        b53 b53Var3 = c53.c;
                        b53Var3.j(obj, j, b53Var3.c(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 8:
                    if (n(i, obj2)) {
                        c53.o(obj, j, c53.c.h(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 9:
                    s(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 10:
                    if (n(i, obj2)) {
                        c53.o(obj, j, c53.c.h(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 11:
                    if (n(i, obj2)) {
                        c53.m(c53.c.f(j, obj2), j, obj);
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 12:
                    if (n(i, obj2)) {
                        c53.m(c53.c.f(j, obj2), j, obj);
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 13:
                    if (n(i, obj2)) {
                        c53.m(c53.c.f(j, obj2), j, obj);
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 14:
                    if (n(i, obj2)) {
                        c53.n(obj, j, c53.c.g(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 15:
                    if (n(i, obj2)) {
                        c53.m(c53.c.f(j, obj2), j, obj);
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 16:
                    if (n(i, obj2)) {
                        c53.n(obj, j, c53.c.g(j, obj2));
                        G(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 17:
                    s(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.k.getClass();
                    b53 b53Var4 = c53.c;
                    w21 w21VarD = (w21) b53Var4.h(j, obj);
                    w21 w21Var = (w21) b53Var4.h(j, obj2);
                    int i3 = ((x12) w21VarD).c;
                    int i4 = ((x12) w21Var).c;
                    if (i3 > 0 && i4 > 0) {
                        if (!((x12) w21VarD).a) {
                            w21VarD = ((x12) w21VarD).d(i4 + i3);
                        }
                        ((x12) w21VarD).addAll(w21Var);
                    }
                    if (i3 > 0) {
                        w21Var = w21VarD;
                    }
                    c53.o(obj, j, w21Var);
                    obj3 = obj;
                    break;
                case 50:
                    Class cls = gb2.a;
                    b53 b53Var5 = c53.c;
                    Object objH = b53Var5.h(j, obj);
                    Object objH2 = b53Var5.h(j, obj2);
                    this.m.getClass();
                    c53.o(obj, j, yg1.a(objH, objH2));
                    obj3 = obj;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (q(i2, i, obj2)) {
                        c53.o(obj, j, c53.c.h(j, obj2));
                        H(i2, i, obj);
                    }
                    obj3 = obj;
                    break;
                case 60:
                    t(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (q(i2, i, obj2)) {
                        c53.o(obj, j, c53.c.h(j, obj2));
                        H(i2, i, obj);
                    }
                    obj3 = obj;
                    break;
                case 68:
                    t(i, obj, obj2);
                    obj3 = obj;
                    break;
                default:
                    obj3 = obj;
                    break;
            }
            i += 3;
            obj = obj3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0080  */
    /* JADX WARN: Code duplicated, block: B:29:0x0086  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093 A[SYNTHETIC] */
    @Override // defpackage.db2
    public final void c(Object obj) {
        if (p(obj)) {
            if (obj instanceof yt0) {
                yt0 yt0Var = (yt0) obj;
                yt0Var.k(Integer.MAX_VALUE);
                yt0Var.memoizedHashCode = 0;
                yt0Var.h();
            }
            int[] iArr = this.a;
            int length = iArr.length;
            for (int i = 0; i < length; i += 3) {
                int iL = L(i);
                long j = 1048575 & iL;
                int iK = K(iL);
                if (iK != 9) {
                    if (iK != 60 && iK != 68) {
                        switch (iK) {
                            case 17:
                                if (n(i, obj)) {
                                    m(i).c(o.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.k.getClass();
                                x12 x12Var = (x12) ((w21) c53.c.h(j, obj));
                                if (x12Var.a) {
                                    x12Var.a = false;
                                }
                                break;
                            case 50:
                                Unsafe unsafe = o;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    this.m.getClass();
                                    ((xg1) object).a = false;
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (q(iArr[i], i, obj)) {
                        m(i).c(o.getObject(obj, j));
                    }
                } else if (n(i, obj)) {
                    m(i).c(o.getObject(obj, j));
                }
            }
            this.l.getClass();
            r43 r43Var = ((yt0) obj).unknownFields;
            if (r43Var.e) {
                r43Var.e = false;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:129:0x0320  */
    /* JADX WARN: Code duplicated, block: B:134:0x032d  */
    /* JADX WARN: Code duplicated, block: B:135:0x033f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0350  */
    /* JADX WARN: Code duplicated, block: B:138:0x0359  */
    /* JADX WARN: Code duplicated, block: B:140:0x0362  */
    /* JADX WARN: Code duplicated, block: B:141:0x036f  */
    /* JADX WARN: Code duplicated, block: B:142:0x037b  */
    /* JADX WARN: Code duplicated, block: B:144:0x037f  */
    /* JADX WARN: Code duplicated, block: B:146:0x038c  */
    /* JADX WARN: Code duplicated, block: B:147:0x0394  */
    /* JADX WARN: Code duplicated, block: B:148:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:149:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:151:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:152:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:153:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:154:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:155:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:156:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:157:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:158:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:159:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:160:0x0400  */
    /* JADX WARN: Code duplicated, block: B:217:0x05fe A[PHI: r10 r19 r25
      0x05fe: PHI (r10v25 int) = 
      (r10v9 int)
      (r10v10 int)
      (r10v11 int)
      (r10v15 int)
      (r10v17 int)
      (r10v18 int)
      (r10v19 int)
      (r10v22 int)
      (r10v26 int)
     binds: [B:276:0x07c7, B:272:0x07a8, B:268:0x0789, B:251:0x0706, B:237:0x0698, B:233:0x067b, B:229:0x065e, B:222:0x061f, B:216:0x05fc] A[DONT_GENERATE, DONT_INLINE]
      0x05fe: PHI (r19v35 int) = 
      (r19v21 int)
      (r19v22 int)
      (r19v23 int)
      (r19v27 int)
      (r19v29 int)
      (r19v30 int)
      (r19v31 int)
      (r19v34 int)
      (r19v36 int)
     binds: [B:276:0x07c7, B:272:0x07a8, B:268:0x0789, B:251:0x0706, B:237:0x0698, B:233:0x067b, B:229:0x065e, B:222:0x061f, B:216:0x05fc] A[DONT_GENERATE, DONT_INLINE]
      0x05fe: PHI (r25v19 int) = 
      (r25v2 int)
      (r25v3 int)
      (r25v4 int)
      (r25v8 int)
      (r25v10 int)
      (r25v11 int)
      (r25v12 int)
      (r25v16 int)
      (r25v20 int)
     binds: [B:276:0x07c7, B:272:0x07a8, B:268:0x0789, B:251:0x0706, B:237:0x0698, B:233:0x067b, B:229:0x065e, B:222:0x061f, B:216:0x05fc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:353:0x0329 A[SYNTHETIC] */
    @Override // defpackage.db2
    public final int d(yt0 yt0Var) {
        int i;
        int iH;
        int iH2;
        int iH3;
        int iJ;
        int iH4;
        int iJ2;
        int iH5;
        int iH6;
        int iF;
        int iC;
        int i2;
        int i3;
        int iH7;
        int size;
        int i4;
        int iH8;
        int iH9;
        int size2;
        int iH10;
        int i5;
        int iA;
        int i6;
        int iJ3;
        int size3;
        int i7;
        int i8;
        jc3 jc3Var;
        int iH11;
        int iJ4;
        int size4;
        int i9;
        int iH12;
        int iH13;
        int iH14;
        int iJ5;
        int iH15;
        int iJ6;
        int iH16;
        int i10;
        ui1 ui1Var = this;
        yt0 yt0Var2 = yt0Var;
        Unsafe unsafe = o;
        int i11 = 1048575;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        int iF2 = 0;
        while (true) {
            int[] iArr = ui1Var.a;
            if (i13 >= iArr.length) {
                ui1Var.l.getClass();
                return yt0Var2.unknownFields.b() + iF2;
            }
            int iL = ui1Var.L(i13);
            int iK = K(iL);
            int i15 = iArr[i13];
            int i16 = iArr[i13 + 2];
            int i17 = i16 & i11;
            int i18 = 1;
            if (iK <= 17) {
                if (i17 != i12) {
                    i14 = i17 == i11 ? 0 : unsafe.getInt(yt0Var2, i17);
                    i12 = i17;
                }
                i = 1 << (i16 >>> 20);
            } else {
                i = 0;
            }
            long j = iL & i11;
            if (iK >= hl0.b.a) {
                int i19 = hl0.c.a;
            }
            char c = '?';
            switch (iK) {
                case 0:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        iH = kz.h(i15) + 8;
                        iF2 += iH;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 1:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        iH2 = kz.h(i15);
                        iH6 = iH2 + 4;
                        iF2 += iH6;
                    }
                    ui1Var = this;
                    yt0Var2 = yt0Var;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 2:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        long j2 = unsafe.getLong(yt0Var2, j);
                        iH3 = kz.h(i15);
                        iJ = kz.j(j2);
                        iF2 += iJ + iH3;
                    }
                    ui1Var = this;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 3:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        long j3 = unsafe.getLong(yt0Var2, j);
                        iH3 = kz.h(i15);
                        iJ = kz.j(j3);
                        iF2 += iJ + iH3;
                    }
                    ui1Var = this;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 4:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        int i20 = unsafe.getInt(yt0Var2, j);
                        iH4 = kz.h(i15);
                        iJ2 = kz.j(i20);
                        iF = iJ2 + iH4;
                        iF2 += iF;
                    }
                    ui1Var = this;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 5:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        iH5 = kz.h(i15);
                        iH6 = iH5 + 8;
                        iF2 += iH6;
                    }
                    ui1Var = this;
                    yt0Var2 = yt0Var;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 6:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        iH2 = kz.h(i15);
                        iH6 = iH2 + 4;
                        iF2 += iH6;
                    }
                    ui1Var = this;
                    yt0Var2 = yt0Var;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 7:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        iH6 = kz.h(i15) + 1;
                        iF2 += iH6;
                    }
                    ui1Var = this;
                    yt0Var2 = yt0Var;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 8:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        Object object = unsafe.getObject(yt0Var2, j);
                        iF2 = (object instanceof no ? kz.f(i15, (no) object) : kz.g((String) object) + kz.h(i15)) + iF2;
                    }
                    ui1Var = this;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 9:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        Object object2 = unsafe.getObject(yt0Var2, j);
                        db2 db2VarM = ui1Var.m(i13);
                        Class cls = gb2.a;
                        int iH17 = kz.h(i15);
                        int iA2 = ((j1) object2).a(db2VarM);
                        iF2 += kz.i(iA2) + iA2 + iH17;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 10:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        iF = kz.f(i15, (no) unsafe.getObject(yt0Var2, j));
                        iF2 += iF;
                    }
                    ui1Var = this;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 11:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        int i21 = unsafe.getInt(yt0Var2, j);
                        iH4 = kz.h(i15);
                        iJ2 = kz.i(i21);
                        iF = iJ2 + iH4;
                        iF2 += iF;
                    }
                    ui1Var = this;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 12:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        int i22 = unsafe.getInt(yt0Var2, j);
                        iH4 = kz.h(i15);
                        iJ2 = kz.j(i22);
                        iF = iJ2 + iH4;
                        iF2 += iF;
                    }
                    ui1Var = this;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 13:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        iH2 = kz.h(i15);
                        iH6 = iH2 + 4;
                        iF2 += iH6;
                    }
                    ui1Var = this;
                    yt0Var2 = yt0Var;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 14:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        iH5 = kz.h(i15);
                        iH6 = iH5 + 8;
                        iF2 += iH6;
                    }
                    ui1Var = this;
                    yt0Var2 = yt0Var;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 15:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        int i23 = unsafe.getInt(yt0Var2, j);
                        iH4 = kz.h(i15);
                        iJ2 = kz.i((i23 >> 31) ^ (i23 << 1));
                        iF = iJ2 + iH4;
                        iF2 += iF;
                    }
                    ui1Var = this;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 16:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        long j4 = unsafe.getLong(yt0Var2, j);
                        iH3 = kz.h(i15);
                        iJ = kz.j((j4 >> 63) ^ (j4 << 1));
                        iF2 += iJ + iH3;
                    }
                    ui1Var = this;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 17:
                    if (ui1Var.o(yt0Var2, i13, i12, i14, i)) {
                        iH = ((j1) unsafe.getObject(yt0Var2, j)).a(ui1Var.m(i13)) + (kz.h(i15) * 2);
                        iF2 += iH;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 18:
                    iC = gb2.c(i15, (List) unsafe.getObject(yt0Var2, j));
                    iF2 += iC;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 19:
                    iC = gb2.b(i15, (List) unsafe.getObject(yt0Var2, j));
                    iF2 += iC;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 20:
                    i12 = i12;
                    i2 = i14;
                    i3 = 0;
                    List list = (List) unsafe.getObject(yt0Var2, j);
                    Class cls2 = gb2.a;
                    if (list.size() == 0) {
                        iH7 = i3;
                    } else {
                        iH7 = (kz.h(i15) * list.size()) + gb2.e(list);
                    }
                    iF2 += iH7;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 21:
                    i12 = i12;
                    i2 = i14;
                    i3 = 0;
                    List list2 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls3 = gb2.a;
                    size = list2.size();
                    if (size == 0) {
                        iH7 = i3;
                    } else {
                        i4 = gb2.i(list2);
                        iH8 = kz.h(i15);
                        iH7 = (iH8 * size) + i4;
                    }
                    iF2 += iH7;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 22:
                    i12 = i12;
                    i2 = i14;
                    i3 = 0;
                    List list3 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls4 = gb2.a;
                    size = list3.size();
                    if (size == 0) {
                        iH7 = i3;
                    } else {
                        i4 = gb2.d(list3);
                        iH8 = kz.h(i15);
                        iH7 = (iH8 * size) + i4;
                    }
                    iF2 += iH7;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 23:
                    iC = gb2.c(i15, (List) unsafe.getObject(yt0Var2, j));
                    iF2 += iC;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 24:
                    iC = gb2.b(i15, (List) unsafe.getObject(yt0Var2, j));
                    iF2 += iC;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 25:
                    i12 = i12;
                    i2 = i14;
                    List list4 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls5 = gb2.a;
                    int size5 = list4.size();
                    iF2 += size5 == 0 ? 0 : (kz.h(i15) + 1) * size5;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 26:
                    i12 = i12;
                    i2 = i14;
                    i3 = 0;
                    List list5 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls6 = gb2.a;
                    int size6 = list5.size();
                    if (size6 == 0) {
                        iH7 = i3;
                    } else {
                        iH7 = kz.h(i15) * size6;
                        for (int i24 = 0; i24 < size6; i24++) {
                            Object obj = list5.get(i24);
                            if (obj instanceof no) {
                                int size7 = ((no) obj).size();
                                iH7 = kz.i(size7) + size7 + iH7;
                            } else {
                                iH7 = kz.g((String) obj) + iH7;
                            }
                        }
                    }
                    iF2 += iH7;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 27:
                    i12 = i12;
                    i2 = i14;
                    List list6 = (List) unsafe.getObject(yt0Var2, j);
                    db2 db2VarM2 = ui1Var.m(i13);
                    Class cls7 = gb2.a;
                    int size8 = list6.size();
                    if (size8 == 0) {
                        iH9 = 0;
                    } else {
                        iH9 = kz.h(i15) * size8;
                        for (int i25 = 0; i25 < size8; i25++) {
                            int iA3 = ((j1) list6.get(i25)).a(db2VarM2);
                            iH9 += kz.i(iA3) + iA3;
                        }
                    }
                    iF2 += iH9;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 28:
                    i12 = i12;
                    i2 = i14;
                    i3 = 0;
                    List list7 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls8 = gb2.a;
                    int size9 = list7.size();
                    if (size9 == 0) {
                        iH7 = i3;
                    } else {
                        iH7 = kz.h(i15) * size9;
                        for (int i26 = 0; i26 < list7.size(); i26++) {
                            int size10 = ((no) list7.get(i26)).size();
                            iH7 += kz.i(size10) + size10;
                        }
                    }
                    iF2 += iH7;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 29:
                    i12 = i12;
                    i2 = i14;
                    i3 = 0;
                    List list8 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls9 = gb2.a;
                    size = list8.size();
                    if (size == 0) {
                        iH7 = i3;
                    } else {
                        i4 = gb2.h(list8);
                        iH8 = kz.h(i15);
                        iH7 = (iH8 * size) + i4;
                    }
                    iF2 += iH7;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 30:
                    i12 = i12;
                    i2 = i14;
                    i3 = 0;
                    List list9 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls10 = gb2.a;
                    size = list9.size();
                    if (size == 0) {
                        iH7 = i3;
                    } else {
                        i4 = gb2.a(list9);
                        iH8 = kz.h(i15);
                        iH7 = (iH8 * size) + i4;
                    }
                    iF2 += iH7;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 31:
                    iC = gb2.b(i15, (List) unsafe.getObject(yt0Var2, j));
                    iF2 += iC;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 32:
                    iC = gb2.c(i15, (List) unsafe.getObject(yt0Var2, j));
                    iF2 += iC;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 33:
                    i12 = i12;
                    i2 = i14;
                    i3 = 0;
                    List list10 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls11 = gb2.a;
                    size = list10.size();
                    if (size == 0) {
                        iH7 = i3;
                    } else {
                        i4 = gb2.f(list10);
                        iH8 = kz.h(i15);
                        iH7 = (iH8 * size) + i4;
                    }
                    iF2 += iH7;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 34:
                    i12 = i12;
                    i2 = i14;
                    i3 = 0;
                    List list11 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls12 = gb2.a;
                    size = list11.size();
                    if (size == 0) {
                        iH7 = i3;
                    } else {
                        i4 = gb2.g(list11);
                        iH8 = kz.h(i15);
                        iH7 = (iH8 * size) + i4;
                    }
                    iF2 += iH7;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 35:
                    i12 = i12;
                    i2 = i14;
                    List list12 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls13 = gb2.a;
                    size2 = list12.size() * 8;
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 36:
                    i12 = i12;
                    i2 = i14;
                    List list13 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls14 = gb2.a;
                    size2 = list13.size() * 4;
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 37:
                    i12 = i12;
                    i2 = i14;
                    size2 = gb2.e((List) unsafe.getObject(yt0Var2, j));
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 38:
                    i12 = i12;
                    i2 = i14;
                    size2 = gb2.i((List) unsafe.getObject(yt0Var2, j));
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 39:
                    i12 = i12;
                    i2 = i14;
                    size2 = gb2.d((List) unsafe.getObject(yt0Var2, j));
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 40:
                    i12 = i12;
                    i2 = i14;
                    List list14 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls15 = gb2.a;
                    size2 = list14.size() * 8;
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 41:
                    i12 = i12;
                    i2 = i14;
                    List list15 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls16 = gb2.a;
                    size2 = list15.size() * 4;
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 42:
                    i12 = i12;
                    i2 = i14;
                    List list16 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls17 = gb2.a;
                    size2 = list16.size();
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 43:
                    i12 = i12;
                    i2 = i14;
                    size2 = gb2.h((List) unsafe.getObject(yt0Var2, j));
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 44:
                    i12 = i12;
                    i2 = i14;
                    size2 = gb2.a((List) unsafe.getObject(yt0Var2, j));
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 45:
                    i12 = i12;
                    i2 = i14;
                    List list17 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls18 = gb2.a;
                    size2 = list17.size() * 4;
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 46:
                    i12 = i12;
                    i2 = i14;
                    List list18 = (List) unsafe.getObject(yt0Var2, j);
                    Class cls19 = gb2.a;
                    size2 = list18.size() * 8;
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 47:
                    i12 = i12;
                    i2 = i14;
                    size2 = gb2.f((List) unsafe.getObject(yt0Var2, j));
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 48:
                    i12 = i12;
                    i2 = i14;
                    size2 = gb2.g((List) unsafe.getObject(yt0Var2, j));
                    if (size2 > 0) {
                        iH10 = kz.h(i15);
                        i5 = kz.i(size2);
                        iF2 += i5 + iH10 + size2;
                    }
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 49:
                    i12 = i12;
                    i2 = i14;
                    List list19 = (List) unsafe.getObject(yt0Var2, j);
                    db2 db2VarM3 = ui1Var.m(i13);
                    Class cls20 = gb2.a;
                    int size11 = list19.size();
                    if (size11 == 0) {
                        iA = 0;
                    } else {
                        iA = 0;
                        for (int i27 = 0; i27 < size11; i27++) {
                            iA += ((j1) list19.get(i27)).a(db2VarM3) + (kz.h(i15) * 2);
                        }
                    }
                    iF2 += iA;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 50:
                    Object object3 = unsafe.getObject(yt0Var2, j);
                    Object obj2 = ui1Var.b[(i13 / 3) * 2];
                    ui1Var.m.getClass();
                    xg1 xg1Var = (xg1) object3;
                    wg1 wg1Var = (wg1) obj2;
                    if (xg1Var.isEmpty()) {
                        i6 = 0;
                    } else {
                        i6 = 0;
                        for (Map.Entry entry : xg1Var.entrySet()) {
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            wg1Var.getClass();
                            int iH18 = kz.h(i15);
                            kf kfVar = wg1Var.a;
                            char c2 = c;
                            jc3 jc3Var2 = (jc3) kfVar.b;
                            int i28 = gl0.c;
                            int iH19 = kz.h(i18);
                            int i29 = i18;
                            gc3 gc3Var = jc3.e;
                            if (jc3Var2 == gc3Var) {
                                iH19 *= 2;
                            }
                            int i30 = i12;
                            switch (jc3Var2.ordinal()) {
                                case 0:
                                    ((Double) key).getClass();
                                    iJ3 = 8;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i31 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31) + i31 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i32 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i32) + i32 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i33 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i33) + i33 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i34 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i34) + i34 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i35 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i35) + i35 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i36 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i36) + i36 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i37 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i37) + i37 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i38 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i38) + i38 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i39 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i39) + i39 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i310 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i310) + i310 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i311 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311) + i311 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i312 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i312) + i312 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i313 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i313) + i313 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i314 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i314) + i314 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i315 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i315) + i315 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i316 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i316) + i316 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue >> 31) ^ (iIntValue << 1));
                                            int i317 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i317) + i317 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue << i29) ^ (jLongValue >> c2));
                                            int i318 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i318) + i318 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 1:
                                    ((Float) key).getClass();
                                    iJ3 = 4;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i319 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i319) + i319 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i3110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3110) + i3110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111) + i3111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3112) + i3112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3113) + i3113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3114) + i3114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3115) + i3115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i3116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3116) + i3116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i3117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3117) + i3117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i3118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3118) + i3118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i3119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3119) + i3119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i31110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31110) + i31110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i31111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111) + i31111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31112) + i31112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31113) + i31113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31114) + i31114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue2 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue2 >> 31) ^ (iIntValue2 << 1));
                                            int i31115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31115) + i31115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue2 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue2 << i29) ^ (jLongValue2 >> c2));
                                            int i31116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31116) + i31116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 2:
                                    i14 = i14;
                                    iJ3 = kz.j(((Long) key).longValue());
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i31117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31117) + i31117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i31118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31118) + i31118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31119) + i31119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311110) + i311110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111) + i311111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311112) + i311112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311113) + i311113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i311114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311114) + i311114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i311115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311115) + i311115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i311116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311116) + i311116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i311117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311117) + i311117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i311118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311118) + i311118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i311119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311119) + i311119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111110) + i3111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111) + i3111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111112) + i3111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue3 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue3 >> 31) ^ (iIntValue3 << 1));
                                            int i3111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111113) + i3111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue3 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue3 << i29) ^ (jLongValue3 >> c2));
                                            int i3111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111114) + i3111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 3:
                                    i14 = i14;
                                    iJ3 = kz.j(((Long) key).longValue());
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i3111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111115) + i3111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i3111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111116) + i3111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111117) + i3111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111118) + i3111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111119) + i3111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111110) + i31111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111) + i31111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i31111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111112) + i31111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i31111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111113) + i31111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i31111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111114) + i31111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i31111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111115) + i31111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i31111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111116) + i31111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i31111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111117) + i31111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111118) + i31111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111119) + i31111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111110) + i311111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue4 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue4 >> 31) ^ (iIntValue4 << 1));
                                            int i311111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111) + i311111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue4 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue4 << i29) ^ (jLongValue4 >> c2));
                                            int i311111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111112) + i311111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 4:
                                    i14 = i14;
                                    iJ3 = kz.j(((Integer) key).intValue());
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i311111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111113) + i311111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i311111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111114) + i311111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111115) + i311111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111116) + i311111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111117) + i311111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111118) + i311111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111119) + i311111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i3111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111110) + i3111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i3111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111) + i3111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i3111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111112) + i3111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i3111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111113) + i3111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i3111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111114) + i3111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i3111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111115) + i3111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111116) + i3111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111117) + i3111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111118) + i3111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue5 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue5 >> 31) ^ (iIntValue5 << 1));
                                            int i3111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111119) + i3111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue5 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue5 << i29) ^ (jLongValue5 >> c2));
                                            int i31111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111110) + i31111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 5:
                                    ((Long) key).getClass();
                                    iJ3 = 8;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111) + i31111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i31111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111112) + i31111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111113) + i31111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111114) + i31111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111115) + i31111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111116) + i31111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111117) + i31111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i31111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111118) + i31111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i31111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111119) + i31111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i311111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111110) + i311111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i311111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111) + i311111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i311111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111112) + i311111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i311111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111113) + i311111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111114) + i311111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111115) + i311111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111116) + i311111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue6 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue6 >> 31) ^ (iIntValue6 << 1));
                                            int i311111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111117) + i311111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue6 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue6 << i29) ^ (jLongValue6 >> c2));
                                            int i311111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111118) + i311111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 6:
                                    ((Integer) key).getClass();
                                    iJ3 = 4;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i311111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111119) + i311111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111110) + i3111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111) + i3111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111112) + i3111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111113) + i3111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111114) + i3111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111115) + i3111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i3111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111116) + i3111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i3111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111117) + i3111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i3111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111118) + i3111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i3111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111119) + i3111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i31111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111110) + i31111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i31111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111) + i31111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111112) + i31111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111113) + i31111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111114) + i31111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue7 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue7 >> 31) ^ (iIntValue7 << 1));
                                            int i31111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111115) + i31111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue7 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue7 << i29) ^ (jLongValue7 >> c2));
                                            int i31111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111116) + i31111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 7:
                                    i14 = i14;
                                    ((Boolean) key).getClass();
                                    iJ3 = i29;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111117) + i31111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111118) + i31111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111119) + i31111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111110) + i311111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111) + i311111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111112) + i311111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111113) + i311111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i311111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111114) + i311111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i311111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111115) + i311111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i311111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111116) + i311111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i311111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111117) + i311111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i311111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111118) + i311111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i311111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111119) + i311111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111110) + i3111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111) + i3111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111112) + i3111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue8 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue8 >> 31) ^ (iIntValue8 << 1));
                                            int i3111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111113) + i3111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue8 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue8 << i29) ^ (jLongValue8 >> c2));
                                            int i3111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111114) + i3111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 8:
                                    i14 = i14;
                                    if (key instanceof no) {
                                        size3 = ((no) key).size();
                                        i7 = kz.i(size3);
                                        iJ3 = i7 + size3;
                                    } else {
                                        iJ3 = kz.g((String) key);
                                    }
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111115) + i3111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111116) + i3111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111117) + i3111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111118) + i3111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111119) + i3111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111110) + i31111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111) + i31111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i31111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111112) + i31111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i31111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111113) + i31111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i31111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111114) + i31111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i31111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111115) + i31111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i31111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111116) + i31111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i31111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111117) + i31111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111118) + i31111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111119) + i31111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111110) + i311111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue9 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue9 >> 31) ^ (iIntValue9 << 1));
                                            int i311111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111) + i311111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue9 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue9 << i29) ^ (jLongValue9 >> c2));
                                            int i311111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111112) + i311111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 9:
                                    i14 = i14;
                                    iJ3 = ((yt0) ((j1) key)).a(null);
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111113) + i311111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i311111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111114) + i311111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111115) + i311111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111116) + i311111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111117) + i311111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111118) + i311111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111119) + i311111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i3111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111110) + i3111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i3111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111) + i3111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i3111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111112) + i3111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i3111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111113) + i3111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i3111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111114) + i3111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i3111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111115) + i3111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111116) + i3111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111117) + i3111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111118) + i3111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue10 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue10 >> 31) ^ (iIntValue10 << 1));
                                            int i3111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111119) + i3111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue10 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue10 << i29) ^ (jLongValue10 >> c2));
                                            int i31111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111110) + i31111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 10:
                                    i14 = i14;
                                    int iA4 = ((yt0) ((j1) key)).a(null);
                                    iJ3 = kz.i(iA4) + iA4;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111) + i31111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111112) + i31111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111113) + i31111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111114) + i31111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111115) + i31111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111116) + i31111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111117) + i31111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i31111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111118) + i31111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i31111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111119) + i31111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i311111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111110) + i311111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i311111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111) + i311111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i311111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111112) + i311111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i311111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111113) + i311111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111114) + i311111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111115) + i311111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111116) + i311111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue11 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue11 >> 31) ^ (iIntValue11 << 1));
                                            int i311111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111117) + i311111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue11 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue11 << i29) ^ (jLongValue11 >> c2));
                                            int i311111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111118) + i311111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 11:
                                    i14 = i14;
                                    if (key instanceof no) {
                                        size3 = ((no) key).size();
                                        i7 = kz.i(size3);
                                    } else {
                                        size3 = ((byte[]) key).length;
                                        i7 = kz.i(size3);
                                    }
                                    iJ3 = i7 + size3;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111119) + i311111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111110) + i3111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111) + i3111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111112) + i3111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111113) + i3111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111114) + i3111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111115) + i3111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i3111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111116) + i3111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i3111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111117) + i3111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i3111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111118) + i3111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i3111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111119) + i3111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i31111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111110) + i31111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i31111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111) + i31111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111112) + i31111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111113) + i31111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111114) + i31111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue12 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue12 >> 31) ^ (iIntValue12 << 1));
                                            int i31111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111115) + i31111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue12 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue12 << i29) ^ (jLongValue12 >> c2));
                                            int i31111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111116) + i31111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 12:
                                    i14 = i14;
                                    iJ3 = kz.i(((Integer) key).intValue());
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111117) + i31111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111118) + i31111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111119) + i31111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111110) + i311111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111) + i311111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111112) + i311111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111113) + i311111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i311111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111114) + i311111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i311111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111115) + i311111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i311111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111116) + i311111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i311111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111117) + i311111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i311111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111118) + i311111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i311111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111119) + i311111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111110) + i3111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111) + i3111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111112) + i3111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue13 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue13 >> 31) ^ (iIntValue13 << 1));
                                            int i3111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111113) + i3111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue13 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue13 << i29) ^ (jLongValue13 >> c2));
                                            int i3111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111114) + i3111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 13:
                                    i14 = i14;
                                    iJ3 = kz.j(((Integer) key).intValue());
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111115) + i3111111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111116) + i3111111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111117) + i3111111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111118) + i3111111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111119) + i3111111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111110) + i31111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111) + i31111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i31111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111112) + i31111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i31111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111113) + i31111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i31111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111114) + i31111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i31111111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111115) + i31111111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i31111111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111116) + i31111111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i31111111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111117) + i31111111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31111111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111118) + i31111111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111119) + i31111111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111110) + i311111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue14 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue14 >> 31) ^ (iIntValue14 << 1));
                                            int i311111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111) + i311111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue14 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue14 << i29) ^ (jLongValue14 >> c2));
                                            int i311111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111112) + i311111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 14:
                                    ((Integer) key).getClass();
                                    iJ3 = 4;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111113) + i311111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i311111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111114) + i311111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311111111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111115) + i311111111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311111111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111116) + i311111111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111117) + i311111111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111118) + i311111111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311111111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111119) + i311111111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i3111111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111110) + i3111111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i3111111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111) + i3111111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i3111111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111112) + i3111111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i3111111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111113) + i3111111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i3111111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111114) + i3111111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i3111111111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111115) + i3111111111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111116) + i3111111111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111117) + i3111111111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111118) + i3111111111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue15 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue15 >> 31) ^ (iIntValue15 << 1));
                                            int i3111111111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111119) + i3111111111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue15 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue15 << i29) ^ (jLongValue15 >> c2));
                                            int i31111111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111110) + i31111111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 15:
                                    ((Long) key).getClass();
                                    iJ3 = 8;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111) + i31111111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111112) + i31111111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31111111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111113) + i31111111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31111111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111114) + i31111111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31111111111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111115) + i31111111111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111116) + i31111111111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111117) + i31111111111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i31111111111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111118) + i31111111111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i31111111111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111119) + i31111111111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i311111111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111110) + i311111111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i311111111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111) + i311111111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i311111111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111112) + i311111111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i311111111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111113) + i311111111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111114) + i311111111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311111111111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111115) + i311111111111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111116) + i311111111111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue16 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue16 >> 31) ^ (iIntValue16 << 1));
                                            int i311111111111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111117) + i311111111111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue16 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue16 << i29) ^ (jLongValue16 >> c2));
                                            int i311111111111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111118) + i311111111111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 16:
                                    int iIntValue17 = ((Integer) key).intValue();
                                    iJ3 = kz.i((iIntValue17 >> 31) ^ (iIntValue17 << 1));
                                    i14 = i14;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111119) + i311111111111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111110) + i3111111111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111111) + i3111111111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i3111111111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111112) + i3111111111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111113) + i3111111111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111114) + i3111111111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111115) + i3111111111111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i3111111111111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111116) + i3111111111111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i3111111111111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111117) + i3111111111111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i3111111111111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111118) + i3111111111111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i3111111111111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111119) + i3111111111111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i31111111111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111110) + i31111111111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i31111111111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111111) + i31111111111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i31111111111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111112) + i31111111111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111113) + i31111111111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111114) + i31111111111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue18 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue18 >> 31) ^ (iIntValue18 << 1));
                                            int i31111111111111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111115) + i31111111111111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue17 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue17 << i29) ^ (jLongValue17 >> c2));
                                            int i31111111111111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111116) + i31111111111111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                case 17:
                                    long jLongValue18 = ((Long) key).longValue();
                                    iJ3 = kz.j((jLongValue18 << i29) ^ (jLongValue18 >> c2));
                                    i14 = i14;
                                    i8 = iJ3 + iH19;
                                    jc3Var = (jc3) kfVar.c;
                                    iH11 = kz.h(2);
                                    if (jc3Var == gc3Var) {
                                        iH11 *= 2;
                                    }
                                    switch (jc3Var.ordinal()) {
                                        case 0:
                                            ((Double) value).getClass();
                                            iJ4 = 8;
                                            int i31111111111111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111117) + i31111111111111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 1:
                                            ((Float) value).getClass();
                                            iJ4 = 4;
                                            int i31111111111111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111118) + i31111111111111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 2:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i31111111111111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i31111111111111111111111111111119) + i31111111111111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 3:
                                            iJ4 = kz.j(((Long) value).longValue());
                                            int i311111111111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111110) + i311111111111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 4:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i311111111111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111111) + i311111111111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 5:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i311111111111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111112) + i311111111111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 6:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i311111111111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111113) + i311111111111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 7:
                                            ((Boolean) value).getClass();
                                            iJ4 = i29;
                                            int i311111111111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111114) + i311111111111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 8:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                                iJ4 = size4 + i9;
                                            } else {
                                                iJ4 = kz.g((String) value);
                                            }
                                            int i311111111111111111111111111111115 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111115) + i311111111111111111111111111111115 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 9:
                                            iJ4 = ((yt0) ((j1) value)).a(null);
                                            int i311111111111111111111111111111116 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111116) + i311111111111111111111111111111116 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 10:
                                            size4 = ((yt0) ((j1) value)).a(null);
                                            i9 = kz.i(size4);
                                            iJ4 = size4 + i9;
                                            int i311111111111111111111111111111117 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111117) + i311111111111111111111111111111117 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 11:
                                            if (value instanceof no) {
                                                size4 = ((no) value).size();
                                                i9 = kz.i(size4);
                                            } else {
                                                size4 = ((byte[]) value).length;
                                                i9 = kz.i(size4);
                                            }
                                            iJ4 = size4 + i9;
                                            int i311111111111111111111111111111118 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111118) + i311111111111111111111111111111118 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 12:
                                            iJ4 = kz.i(((Integer) value).intValue());
                                            int i311111111111111111111111111111119 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i311111111111111111111111111111119) + i311111111111111111111111111111119 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 13:
                                            iJ4 = kz.j(((Integer) value).intValue());
                                            int i3111111111111111111111111111111110 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111111110) + i3111111111111111111111111111111110 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 14:
                                            ((Integer) value).getClass();
                                            iJ4 = 4;
                                            int i3111111111111111111111111111111111 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111111111) + i3111111111111111111111111111111111 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 15:
                                            ((Long) value).getClass();
                                            iJ4 = 8;
                                            int i3111111111111111111111111111111112 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111111112) + i3111111111111111111111111111111112 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 16:
                                            int iIntValue19 = ((Integer) value).intValue();
                                            iJ4 = kz.i((iIntValue19 >> 31) ^ (iIntValue19 << 1));
                                            int i3111111111111111111111111111111113 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111111113) + i3111111111111111111111111111111113 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        case 17:
                                            long jLongValue19 = ((Long) value).longValue();
                                            iJ4 = kz.j((jLongValue19 << i29) ^ (jLongValue19 >> c2));
                                            int i3111111111111111111111111111111114 = iJ4 + iH11 + i8;
                                            i6 += kz.i(i3111111111111111111111111111111114) + i3111111111111111111111111111111114 + iH18;
                                            i14 = i14;
                                            c = c2;
                                            i18 = i29;
                                            i12 = i30;
                                            break;
                                        default:
                                            og.p("There is no way to get here, but the compiler thinks otherwise.");
                                            return 0;
                                    }
                                    break;
                                default:
                                    og.p("There is no way to get here, but the compiler thinks otherwise.");
                                    return 0;
                            }
                        }
                    }
                    i12 = i12;
                    i2 = i14;
                    iF2 += i6;
                    i14 = i2;
                    i12 = i12;
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 51:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        iH12 = kz.h(i15);
                        iH16 = iH12 + 8;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 52:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        iH13 = kz.h(i15);
                        iH16 = iH13 + 4;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 53:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        long jZ = z(j, yt0Var2);
                        iH14 = kz.h(i15);
                        iJ5 = kz.j(jZ);
                        i10 = iJ5 + iH14;
                        iF2 += i10;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 54:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        long jZ2 = z(j, yt0Var2);
                        iH14 = kz.h(i15);
                        iJ5 = kz.j(jZ2);
                        i10 = iJ5 + iH14;
                        iF2 += i10;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 55:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        int iY = y(j, yt0Var2);
                        iH15 = kz.h(i15);
                        iJ6 = kz.j(iY);
                        iH16 = iJ6 + iH15;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 56:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        iH12 = kz.h(i15);
                        iH16 = iH12 + 8;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 57:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        iH13 = kz.h(i15);
                        iH16 = iH13 + 4;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 58:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        iH16 = kz.h(i15) + 1;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 59:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        Object object4 = unsafe.getObject(yt0Var2, j);
                        iF2 = (object4 instanceof no ? kz.f(i15, (no) object4) : kz.g((String) object4) + kz.h(i15)) + iF2;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 60:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        Object object5 = unsafe.getObject(yt0Var2, j);
                        db2 db2VarM4 = ui1Var.m(i13);
                        Class cls21 = gb2.a;
                        int iH20 = kz.h(i15);
                        int iA5 = ((j1) object5).a(db2VarM4);
                        i10 = kz.i(iA5) + iA5 + iH20;
                        iF2 += i10;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 61:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        iH16 = kz.f(i15, (no) unsafe.getObject(yt0Var2, j));
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 62:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        int iY2 = y(j, yt0Var2);
                        iH15 = kz.h(i15);
                        iJ6 = kz.i(iY2);
                        iH16 = iJ6 + iH15;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 63:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        int iY3 = y(j, yt0Var2);
                        iH15 = kz.h(i15);
                        iJ6 = kz.j(iY3);
                        iH16 = iJ6 + iH15;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 64:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        iH13 = kz.h(i15);
                        iH16 = iH13 + 4;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 65:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        iH12 = kz.h(i15);
                        iH16 = iH12 + 8;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 66:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        int iY4 = y(j, yt0Var2);
                        iH15 = kz.h(i15);
                        iJ6 = kz.i((iY4 >> 31) ^ (iY4 << 1));
                        iH16 = iJ6 + iH15;
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 67:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        long jZ3 = z(j, yt0Var2);
                        iH14 = kz.h(i15);
                        iJ5 = kz.j((jZ3 << 1) ^ (jZ3 >> 63));
                        i10 = iJ5 + iH14;
                        iF2 += i10;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                case 68:
                    if (ui1Var.q(i15, i13, yt0Var2)) {
                        iH16 = ((j1) unsafe.getObject(yt0Var2, j)).a(ui1Var.m(i13)) + (kz.h(i15) * 2);
                        iF2 += iH16;
                    }
                    i13 += 3;
                    i11 = 1048575;
                    break;
                default:
                    i13 += 3;
                    i11 = 1048575;
                    break;
            }
        }
    }

    @Override // defpackage.db2
    public final void e(Object obj, uf1 uf1Var) throws IOException {
        uf1Var.getClass();
        M(obj, uf1Var);
    }

    @Override // defpackage.db2
    public final boolean f(Object obj) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.h) {
            int i6 = this.g[i5];
            int[] iArr = this.a;
            int i7 = iArr[i6];
            int iL = L(i6);
            int i8 = iArr[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = o.getInt(obj, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                int i11 = i4;
                i = i3;
                i2 = i11;
            }
            if ((268435456 & iL) == 0 || o(obj, i6, i, i2, i10)) {
                int iK = K(iL);
                if (iK == 9 || iK == 17) {
                    if (o(obj, i6, i, i2, i10)) {
                        if (!m(i6).f(c53.c.h(iL & 1048575, obj))) {
                        }
                    } else {
                        continue;
                    }
                    i5++;
                    i3 = i;
                    i4 = i2;
                } else {
                    if (iK != 27) {
                        if (iK == 60 || iK == 68) {
                            if (q(i7, i6, obj)) {
                                if (!m(i6).f(c53.c.h(iL & 1048575, obj))) {
                                }
                            } else {
                                continue;
                            }
                            i5++;
                            i3 = i;
                            i4 = i2;
                        } else if (iK != 49) {
                            if (iK != 50) {
                                continue;
                            } else {
                                Object objH = c53.c.h(iL & 1048575, obj);
                                this.m.getClass();
                                xg1 xg1Var = (xg1) objH;
                                if (xg1Var.isEmpty()) {
                                    continue;
                                } else {
                                    if (((jc3) ((wg1) this.b[(i6 / 3) * 2]).a.c).a != kc3.MESSAGE) {
                                        continue;
                                    } else {
                                        db2 db2VarA = null;
                                        for (Object obj2 : xg1Var.values()) {
                                            if (db2VarA == null) {
                                                db2VarA = w12.c.a(obj2.getClass());
                                            }
                                            if (!db2VarA.f(obj2)) {
                                            }
                                        }
                                    }
                                }
                            }
                            i5++;
                            i3 = i;
                            i4 = i2;
                        }
                    }
                    List list = (List) c53.c.h(iL & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        db2 db2VarM = m(i6);
                        for (int i12 = 0; i12 < list.size(); i12++) {
                            if (db2VarM.f(list.get(i12))) {
                            }
                        }
                    }
                    i5++;
                    i3 = i;
                    i4 = i2;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003d  */
    @Override // defpackage.db2
    public final boolean g(yt0 yt0Var, yt0 yt0Var2) {
        int[] iArr = this.a;
        int length = iArr.length;
        int i = 0;
        while (true) {
            boolean zL = true;
            if (i < length) {
                int iL = L(i);
                long j = iL & 1048575;
                switch (K(iL)) {
                    case 0:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var = c53.c;
                            if (Double.doubleToLongBits(b53Var.d(j, yt0Var)) != Double.doubleToLongBits(b53Var.d(j, yt0Var2))) {
                                zL = false;
                            }
                        }
                        break;
                    case 1:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var2 = c53.c;
                            if (Float.floatToIntBits(b53Var2.e(j, yt0Var)) != Float.floatToIntBits(b53Var2.e(j, yt0Var2))) {
                                zL = false;
                            }
                        }
                        break;
                    case 2:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var3 = c53.c;
                            if (b53Var3.g(j, yt0Var) != b53Var3.g(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 3:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var4 = c53.c;
                            if (b53Var4.g(j, yt0Var) != b53Var4.g(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 4:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var5 = c53.c;
                            if (b53Var5.f(j, yt0Var) != b53Var5.f(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 5:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var6 = c53.c;
                            if (b53Var6.g(j, yt0Var) != b53Var6.g(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 6:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var7 = c53.c;
                            if (b53Var7.f(j, yt0Var) != b53Var7.f(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 7:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var8 = c53.c;
                            if (b53Var8.c(j, yt0Var) != b53Var8.c(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 8:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var9 = c53.c;
                            if (!gb2.l(b53Var9.h(j, yt0Var), b53Var9.h(j, yt0Var2))) {
                                zL = false;
                            }
                        }
                        break;
                    case 9:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var10 = c53.c;
                            if (!gb2.l(b53Var10.h(j, yt0Var), b53Var10.h(j, yt0Var2))) {
                                zL = false;
                            }
                        }
                        break;
                    case 10:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var11 = c53.c;
                            if (!gb2.l(b53Var11.h(j, yt0Var), b53Var11.h(j, yt0Var2))) {
                                zL = false;
                            }
                        }
                        break;
                    case 11:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var12 = c53.c;
                            if (b53Var12.f(j, yt0Var) != b53Var12.f(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 12:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var13 = c53.c;
                            if (b53Var13.f(j, yt0Var) != b53Var13.f(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 13:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var14 = c53.c;
                            if (b53Var14.f(j, yt0Var) != b53Var14.f(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 14:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var15 = c53.c;
                            if (b53Var15.g(j, yt0Var) != b53Var15.g(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 15:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var16 = c53.c;
                            if (b53Var16.f(j, yt0Var) != b53Var16.f(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 16:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var17 = c53.c;
                            if (b53Var17.g(j, yt0Var) != b53Var17.g(j, yt0Var2)) {
                                zL = false;
                            }
                        }
                        break;
                    case 17:
                        if (!j(yt0Var, yt0Var2, i)) {
                            zL = false;
                        } else {
                            b53 b53Var18 = c53.c;
                            if (!gb2.l(b53Var18.h(j, yt0Var), b53Var18.h(j, yt0Var2))) {
                                zL = false;
                            }
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        b53 b53Var19 = c53.c;
                        zL = gb2.l(b53Var19.h(j, yt0Var), b53Var19.h(j, yt0Var2));
                        break;
                    case 50:
                        b53 b53Var20 = c53.c;
                        zL = gb2.l(b53Var20.h(j, yt0Var), b53Var20.h(j, yt0Var2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j2 = iArr[i + 2] & 1048575;
                        b53 b53Var21 = c53.c;
                        if (b53Var21.f(j2, yt0Var) != b53Var21.f(j2, yt0Var2) || !gb2.l(b53Var21.h(j, yt0Var), b53Var21.h(j, yt0Var2))) {
                            zL = false;
                        }
                        break;
                }
                if (zL) {
                    i += 3;
                }
            } else {
                this.l.getClass();
                if (yt0Var.unknownFields.equals(yt0Var2.unknownFields)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 19221. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // defpackage.db2
    public final void h(java.lang.Object r19, defpackage.iz r20, defpackage.wk0 r21) {
        /*
            Method dump skipped, instruction units count: 1922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ui1.h(java.lang.Object, iz, wk0):void");
    }

    @Override // defpackage.db2
    public final yt0 i() {
        this.j.getClass();
        return ((yt0) this.e).i();
    }

    public final boolean j(yt0 yt0Var, yt0 yt0Var2, int i) {
        return n(i, yt0Var) == n(i, yt0Var2);
    }

    public final void k(int i, Object obj, Object obj2) {
        int i2 = this.a[i];
        if (c53.c.h(L(i) & 1048575, obj) == null) {
            return;
        }
        l(i);
    }

    public final void l(int i) {
        if (this.b[((i / 3) * 2) + 1] == null) {
            return;
        }
        dk0.t();
    }

    public final db2 m(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.b;
        db2 db2Var = (db2) objArr[i2];
        if (db2Var != null) {
            return db2Var;
        }
        db2 db2VarA = w12.c.a((Class) objArr[i2 + 1]);
        objArr[i2] = db2VarA;
        return db2VarA;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0110 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x0111 A[RETURN] */
    public final boolean n(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            if (((1 << (i2 >>> 20)) & c53.c.f(j, obj)) != 0) {
                return true;
            }
            return false;
        }
        int iL = L(i);
        long j2 = iL & 1048575;
        switch (K(iL)) {
            case 0:
                if (Double.doubleToRawLongBits(c53.c.d(j2, obj)) != 0) {
                    return true;
                }
                return false;
            case 1:
                if (Float.floatToRawIntBits(c53.c.e(j2, obj)) != 0) {
                    return true;
                }
                return false;
            case 2:
                if (c53.c.g(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 3:
                if (c53.c.g(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 4:
                if (c53.c.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 5:
                if (c53.c.g(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 6:
                if (c53.c.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 7:
                return c53.c.c(j2, obj);
            case 8:
                Object objH = c53.c.h(j2, obj);
                if (objH instanceof String) {
                    return !((String) objH).isEmpty();
                }
                if (objH instanceof no) {
                    return !no.c.equals(objH);
                }
                dk0.v();
                return false;
            case 9:
                if (c53.c.h(j2, obj) != null) {
                    return true;
                }
                return false;
            case 10:
                return !no.c.equals(c53.c.h(j2, obj));
            case 11:
                if (c53.c.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 12:
                if (c53.c.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 13:
                if (c53.c.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 14:
                if (c53.c.g(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 15:
                if (c53.c.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 16:
                if (c53.c.g(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 17:
                if (c53.c.h(j2, obj) != null) {
                    return true;
                }
                return false;
            default:
                dk0.v();
                return false;
        }
    }

    public final boolean o(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return n(i, obj);
        }
        return (i3 & i4) != 0;
    }

    public final boolean q(int i, int i2, Object obj) {
        return c53.c.f((long) (this.a[i2 + 2] & 1048575), obj) == i;
    }

    public final void r(Object obj, int i, Object obj2, wk0 wk0Var, iz izVar) throws n31 {
        long jL = L(i) & 1048575;
        Object objH = c53.c.h(jL, obj);
        yg1 yg1Var = this.m;
        if (objH == null) {
            yg1Var.getClass();
            objH = xg1.b.b();
            c53.o(obj, jL, objH);
        } else {
            yg1Var.getClass();
            if (!((xg1) objH).a) {
                xg1 xg1VarB = xg1.b.b();
                yg1.a(xg1VarB, objH);
                c53.o(obj, jL, xg1VarB);
                objH = xg1VarB;
            }
        }
        yg1Var.getClass();
        xg1 xg1Var = (xg1) objH;
        kf kfVar = ((wg1) obj2).a;
        izVar.A(2);
        hz hzVar = (hz) izVar.e;
        int iJ = hzVar.j(hzVar.A());
        Object obj3 = kfVar.e;
        Object objM = "";
        Object objM2 = obj3;
        while (true) {
            try {
                int iC = izVar.c();
                if (iC == Integer.MAX_VALUE || hzVar.d()) {
                    break;
                }
                if (iC == 1) {
                    objM = izVar.m((jc3) kfVar.b, null, null);
                } else if (iC != 2) {
                    try {
                        if (!izVar.B()) {
                            throw new o31("Unable to parse map entry.");
                        }
                    } catch (n31 unused) {
                        if (!izVar.B()) {
                            throw new o31("Unable to parse map entry.");
                        }
                    }
                } else {
                    objM2 = izVar.m((jc3) kfVar.c, obj3.getClass(), wk0Var);
                }
            } catch (Throwable th) {
                hzVar.i(iJ);
                throw th;
            }
        }
        xg1Var.put(objM, objM2);
        hzVar.i(iJ);
    }

    public final void s(int i, Object obj, Object obj2) {
        if (n(i, obj2)) {
            long jL = L(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, jL);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2);
            }
            db2 db2VarM = m(i);
            if (!n(i, obj)) {
                if (p(object)) {
                    yt0 yt0VarI = db2VarM.i();
                    db2VarM.b(yt0VarI, object);
                    unsafe.putObject(obj, jL, yt0VarI);
                } else {
                    unsafe.putObject(obj, jL, object);
                }
                G(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jL);
            if (!p(object2)) {
                yt0 yt0VarI2 = db2VarM.i();
                db2VarM.b(yt0VarI2, object2);
                unsafe.putObject(obj, jL, yt0VarI2);
                object2 = yt0VarI2;
            }
            db2VarM.b(object2, object);
        }
    }

    public final void t(int i, Object obj, Object obj2) {
        int[] iArr = this.a;
        int i2 = iArr[i];
        if (q(i2, i, obj2)) {
            long jL = L(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, jL);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2);
            }
            db2 db2VarM = m(i);
            if (!q(i2, i, obj)) {
                if (p(object)) {
                    yt0 yt0VarI = db2VarM.i();
                    db2VarM.b(yt0VarI, object);
                    unsafe.putObject(obj, jL, yt0VarI);
                } else {
                    unsafe.putObject(obj, jL, object);
                }
                H(i2, i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jL);
            if (!p(object2)) {
                yt0 yt0VarI2 = db2VarM.i();
                db2VarM.b(yt0VarI2, object2);
                unsafe.putObject(obj, jL, yt0VarI2);
                object2 = yt0VarI2;
            }
            db2VarM.b(object2, object);
        }
    }

    public final Object u(int i, Object obj) {
        db2 db2VarM = m(i);
        long jL = L(i) & 1048575;
        if (!n(i, obj)) {
            return db2VarM.i();
        }
        Object object = o.getObject(obj, jL);
        if (p(object)) {
            return object;
        }
        yt0 yt0VarI = db2VarM.i();
        if (object != null) {
            db2VarM.b(yt0VarI, object);
        }
        return yt0VarI;
    }

    public final Object v(int i, int i2, Object obj) {
        db2 db2VarM = m(i2);
        if (!q(i, i2, obj)) {
            return db2VarM.i();
        }
        Object object = o.getObject(obj, L(i2) & 1048575);
        if (p(object)) {
            return object;
        }
        yt0 yt0VarI = db2VarM.i();
        if (object != null) {
            db2VarM.b(yt0VarI, object);
        }
        return yt0VarI;
    }
}
