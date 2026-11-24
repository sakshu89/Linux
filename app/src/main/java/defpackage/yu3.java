package defpackage;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yu3 implements ev3 {
    public static final int[] l = new int[0];
    public static final Unsafe m = pv3.i();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final jt3 e;
    public final boolean f;
    public final int[] g;
    public final int h;
    public final int i;
    public final el1 j;
    public final nr4 k;

    public yu3(int[] iArr, Object[] objArr, int i, int i2, jt3 jt3Var, int[] iArr2, int i3, int i4, el1 el1Var, nr4 nr4Var) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        boolean z = false;
        if (nr4Var != null && (jt3Var instanceof du3)) {
            z = true;
        }
        this.f = z;
        this.g = iArr2;
        this.h = i3;
        this.i = i4;
        this.j = el1Var;
        this.k = nr4Var;
        this.e = jt3Var;
    }

    public static long B(long j, Object obj) {
        return ((Long) pv3.h(j, obj)).longValue();
    }

    public static Field G(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sbQ = cq.q("Field ", str, " for ", name, " not found. Known fields are ");
            sbQ.append(string);
            throw new RuntimeException(sbQ.toString());
        }
    }

    public static boolean r(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof gu3) {
            return ((gu3) obj).g();
        }
        return true;
    }

    public static final int t(byte[] bArr, int i, int i2, sv3 sv3Var, Class cls, nt3 nt3Var) {
        sv3 sv3Var2 = sv3.c;
        switch (sv3Var.ordinal()) {
            case 0:
                int i3 = i + 8;
                nt3Var.c = Double.valueOf(Double.longBitsToDouble(tg4.p(bArr, i)));
                return i3;
            case 1:
                int i4 = i + 4;
                nt3Var.c = Float.valueOf(Float.intBitsToFloat(tg4.c(bArr, i)));
                return i4;
            case 2:
            case 3:
                int iL = tg4.l(bArr, i, nt3Var);
                nt3Var.c = Long.valueOf(nt3Var.b);
                return iL;
            case 4:
            case 12:
            case 13:
                int i5 = tg4.i(bArr, i, nt3Var);
                nt3Var.c = Integer.valueOf(nt3Var.a);
                return i5;
            case 5:
            case 15:
                int i6 = i + 8;
                nt3Var.c = Long.valueOf(tg4.p(bArr, i));
                return i6;
            case 6:
            case 14:
                int i7 = i + 4;
                nt3Var.c = Integer.valueOf(tg4.c(bArr, i));
                return i7;
            case 7:
                int iL2 = tg4.l(bArr, i, nt3Var);
                nt3Var.c = Boolean.valueOf(nt3Var.b != 0);
                return iL2;
            case 8:
                return tg4.g(bArr, i, nt3Var);
            case 9:
            default:
                og.p("unsupported field type.");
                return 0;
            case 10:
                return tg4.d(bv3.c.a(cls), bArr, i, i2, nt3Var);
            case 11:
                return tg4.b(bArr, i, nt3Var);
            case 16:
                int i8 = tg4.i(bArr, i, nt3Var);
                nt3Var.c = Integer.valueOf(vg4.b(nt3Var.a));
                return i8;
            case 17:
                int iL3 = tg4.l(bArr, i, nt3Var);
                nt3Var.c = Long.valueOf(vg4.c(nt3Var.b));
                return iL3;
        }
    }

    public static kv3 v(Object obj) {
        gu3 gu3Var = (gu3) obj;
        kv3 kv3Var = gu3Var.zbc;
        if (kv3Var != kv3.f) {
            return kv3Var;
        }
        kv3 kv3VarB = kv3.b();
        gu3Var.zbc = kv3VarB;
        return kv3VarB;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0274  */
    /* JADX WARN: Code duplicated, block: B:126:0x0277  */
    /* JADX WARN: Code duplicated, block: B:129:0x0290  */
    /* JADX WARN: Code duplicated, block: B:130:0x0293  */
    /* JADX WARN: Code duplicated, block: B:171:0x035d  */
    /* JADX WARN: Code duplicated, block: B:186:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:189:0x03b5  */
    public static yu3 w(dv3 dv3Var, el1 el1Var, nr4 nr4Var) {
        int i;
        int iCharAt;
        int i2;
        int[] iArr;
        int i3;
        int i4;
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
        Object[] objArr;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        Field fieldG;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldG2;
        int i28;
        Object obj2;
        Field fieldG3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(dv3Var instanceof dv3)) {
            dk0.t();
            return null;
        }
        String str = dv3Var.b;
        int length = str.length();
        int i33 = 55296;
        if (str.charAt(0) >= 55296) {
            int i34 = 1;
            while (true) {
                i = i34 + 1;
                if (str.charAt(i34) < 55296) {
                    break;
                }
                i34 = i;
            }
        } else {
            i = 1;
        }
        int i35 = i + 1;
        int iCharAt2 = str.charAt(i);
        if (iCharAt2 >= 55296) {
            int i36 = iCharAt2 & 8191;
            int i37 = 13;
            while (true) {
                i32 = i35 + 1;
                cCharAt13 = str.charAt(i35);
                if (cCharAt13 < 55296) {
                    break;
                }
                i36 |= (cCharAt13 & 8191) << i37;
                i37 += 13;
                i35 = i32;
            }
            iCharAt2 = i36 | (cCharAt13 << i37);
            i35 = i32;
        }
        if (iCharAt2 == 0) {
            i4 = 0;
            i6 = 0;
            iCharAt = 0;
            i3 = 0;
            i5 = 0;
            i7 = 0;
            iArr = l;
            i2 = 0;
        } else {
            int i38 = i35 + 1;
            int iCharAt3 = str.charAt(i35);
            if (iCharAt3 >= 55296) {
                int i39 = iCharAt3 & 8191;
                int i40 = 13;
                while (true) {
                    i15 = i38 + 1;
                    cCharAt8 = str.charAt(i38);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt8 & 8191) << i40;
                    i40 += 13;
                    i38 = i15;
                }
                iCharAt3 = i39 | (cCharAt8 << i40);
                i38 = i15;
            }
            int i41 = i38 + 1;
            int iCharAt4 = str.charAt(i38);
            if (iCharAt4 >= 55296) {
                int i42 = iCharAt4 & 8191;
                int i43 = 13;
                while (true) {
                    i14 = i41 + 1;
                    cCharAt7 = str.charAt(i41);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt7 & 8191) << i43;
                    i43 += 13;
                    i41 = i14;
                }
                iCharAt4 = i42 | (cCharAt7 << i43);
                i41 = i14;
            }
            int i44 = i41 + 1;
            int iCharAt5 = str.charAt(i41);
            if (iCharAt5 >= 55296) {
                int i45 = iCharAt5 & 8191;
                int i46 = 13;
                while (true) {
                    i13 = i44 + 1;
                    cCharAt6 = str.charAt(i44);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt6 & 8191) << i46;
                    i46 += 13;
                    i44 = i13;
                }
                iCharAt5 = i45 | (cCharAt6 << i46);
                i44 = i13;
            }
            int i47 = i44 + 1;
            int iCharAt6 = str.charAt(i44);
            if (iCharAt6 >= 55296) {
                int i48 = iCharAt6 & 8191;
                int i49 = 13;
                while (true) {
                    i12 = i47 + 1;
                    cCharAt5 = str.charAt(i47);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt5 & 8191) << i49;
                    i49 += 13;
                    i47 = i12;
                }
                iCharAt6 = i48 | (cCharAt5 << i49);
                i47 = i12;
            }
            int i50 = i47 + 1;
            iCharAt = str.charAt(i47);
            if (iCharAt >= 55296) {
                int i51 = iCharAt & 8191;
                int i52 = 13;
                while (true) {
                    i11 = i50 + 1;
                    cCharAt4 = str.charAt(i50);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt4 & 8191) << i52;
                    i52 += 13;
                    i50 = i11;
                }
                iCharAt = i51 | (cCharAt4 << i52);
                i50 = i11;
            }
            int i53 = i50 + 1;
            int iCharAt7 = str.charAt(i50);
            if (iCharAt7 >= 55296) {
                int i54 = iCharAt7 & 8191;
                int i55 = 13;
                while (true) {
                    i10 = i53 + 1;
                    cCharAt3 = str.charAt(i53);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt3 & 8191) << i55;
                    i55 += 13;
                    i53 = i10;
                }
                iCharAt7 = i54 | (cCharAt3 << i55);
                i53 = i10;
            }
            int i56 = i53 + 1;
            int iCharAt8 = str.charAt(i53);
            if (iCharAt8 >= 55296) {
                int i57 = iCharAt8 & 8191;
                int i58 = 13;
                while (true) {
                    i9 = i56 + 1;
                    cCharAt2 = str.charAt(i56);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt2 & 8191) << i58;
                    i58 += 13;
                    i56 = i9;
                }
                iCharAt8 = i57 | (cCharAt2 << i58);
                i56 = i9;
            }
            int i59 = i56 + 1;
            int iCharAt9 = str.charAt(i56);
            if (iCharAt9 >= 55296) {
                int i60 = iCharAt9 & 8191;
                int i61 = 13;
                while (true) {
                    i8 = i59 + 1;
                    cCharAt = str.charAt(i59);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i60 |= (cCharAt & 8191) << i61;
                    i61 += 13;
                    i59 = i8;
                }
                iCharAt9 = i60 | (cCharAt << i61);
                i59 = i8;
            }
            int i62 = iCharAt3 + iCharAt3 + iCharAt4;
            i2 = iCharAt3;
            i35 = i59;
            iArr = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i63 = iCharAt7;
            i3 = iCharAt5;
            i4 = i63;
            i5 = iCharAt6;
            i6 = i62;
            i7 = iCharAt9;
        }
        Unsafe unsafe = m;
        Object[] objArr2 = dv3Var.c;
        Class<?> cls = dv3Var.a.getClass();
        int i64 = i7 + i4;
        int i65 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr3 = new Object[i65];
        int i66 = i64;
        int i67 = i7;
        int i68 = 0;
        int i69 = 0;
        while (i35 < length) {
            int i70 = i35 + 1;
            int iCharAt10 = str.charAt(i35);
            if (iCharAt10 >= i33) {
                int i71 = iCharAt10 & 8191;
                int i72 = i70;
                int i73 = 13;
                while (true) {
                    i31 = i72 + 1;
                    cCharAt12 = str.charAt(i72);
                    i16 = length;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i71 |= (cCharAt12 & 8191) << i73;
                    i73 += 13;
                    i72 = i31;
                    length = i16;
                }
                iCharAt10 = i71 | (cCharAt12 << i73);
                i17 = i31;
            } else {
                i16 = length;
                i17 = i70;
            }
            int i74 = i17 + 1;
            int iCharAt11 = str.charAt(i17);
            Object[] objArr4 = objArr2;
            char c = 55296;
            if (iCharAt11 >= 55296) {
                int i75 = iCharAt11 & 8191;
                int i76 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = str.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i75 |= (cCharAt11 & 8191) << i76;
                    i76 += 13;
                    i74 = i30;
                    c = 55296;
                }
                iCharAt11 = i75 | (cCharAt11 << i76);
                i74 = i30;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i68] = i69;
                i68++;
            }
            int i77 = iCharAt11 & 255;
            int i78 = iCharAt10;
            int i79 = iCharAt11 & 2048;
            if (i77 >= 51) {
                int i80 = i74 + 1;
                int iCharAt12 = str.charAt(i74);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = str.charAt(i82);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        c2 = 55296;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i24 = i29;
                } else {
                    i24 = i80;
                }
                int i84 = i24;
                int i85 = i77 - 51;
                int i86 = iCharAt12;
                if (i85 == 9 || i85 == 17) {
                    i25 = i6 + 1;
                    int i87 = i69 / 3;
                    objArr3[i87 + i87 + 1] = objArr4[i6];
                } else {
                    if (i85 != 12) {
                        i26 = i79;
                    } else if (dv3Var.a() == 1 || i79 != 0) {
                        i25 = i6 + 1;
                        int i88 = i69 / 3;
                        objArr3[i88 + i88 + 1] = objArr4[i6];
                    } else {
                        i26 = 0;
                    }
                    i27 = i86 + i86;
                    i79 = i26;
                    obj = objArr4[i27];
                    if (obj instanceof Field) {
                        fieldG2 = (Field) obj;
                    } else {
                        fieldG2 = G(cls, (String) obj);
                        objArr4[i27] = fieldG2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldG2);
                    i28 = i27 + 1;
                    obj2 = objArr4[i28];
                    if (obj2 instanceof Field) {
                        fieldG3 = (Field) obj2;
                    } else {
                        fieldG3 = G(cls, (String) obj2);
                        objArr4[i28] = fieldG3;
                    }
                    i19 = i84;
                    i22 = iObjectFieldOffset3;
                    i18 = 55296;
                    objArr = objArr3;
                    i2 = i2;
                    cls = cls;
                    i21 = 0;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldG3);
                }
                i6 = i25;
                i26 = i79;
                i27 = i86 + i86;
                i79 = i26;
                obj = objArr4[i27];
                if (obj instanceof Field) {
                    fieldG2 = (Field) obj;
                } else {
                    fieldG2 = G(cls, (String) obj);
                    objArr4[i27] = fieldG2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldG2);
                i28 = i27 + 1;
                obj2 = objArr4[i28];
                if (obj2 instanceof Field) {
                    fieldG3 = (Field) obj2;
                } else {
                    fieldG3 = G(cls, (String) obj2);
                    objArr4[i28] = fieldG3;
                }
                i19 = i84;
                i22 = iObjectFieldOffset4;
                i18 = 55296;
                objArr = objArr3;
                i2 = i2;
                cls = cls;
                i21 = 0;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldG3);
            } else {
                int i89 = i6 + 1;
                Field fieldG4 = G(cls, (String) objArr4[i6]);
                objArr = objArr3;
                if (i77 == 9 || i77 == 17) {
                    int i90 = i69 / 3;
                    objArr[i90 + i90 + 1] = fieldG4.getType();
                } else {
                    if (i77 != 27) {
                        if (i77 == 49) {
                            i6 += 2;
                            i23 = 1;
                        } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                            i2 = i2;
                            if (dv3Var.a() == 1 || i79 != 0) {
                                i6 += 2;
                                int i91 = i69 / 3;
                                objArr[i91 + i91 + 1] = objArr4[i89];
                                cls = cls;
                            } else {
                                cls = cls;
                                i6 = i89;
                                i79 = 0;
                            }
                        } else if (i77 == 50) {
                            int i92 = i6 + 2;
                            i67++;
                            iArr[i67] = i69;
                            int i93 = i69 / 3;
                            int i94 = i93 + i93;
                            objArr[i94] = objArr4[i89];
                            if (i79 != 0) {
                                i6 += 3;
                                objArr[i94 + 1] = objArr4[i92];
                            } else {
                                i6 = i92;
                                i79 = 0;
                            }
                            i2 = i2;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldG4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i77 > 17) {
                            i18 = 55296;
                            i19 = i74;
                            i20 = 0;
                        } else {
                            int i95 = i74 + 1;
                            int iCharAt13 = str.charAt(i74);
                            if (iCharAt13 >= 55296) {
                                int i96 = iCharAt13 & 8191;
                                int i97 = 13;
                                while (true) {
                                    i19 = i95 + 1;
                                    cCharAt9 = str.charAt(i95);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i96 |= (cCharAt9 & 8191) << i97;
                                    i97 += 13;
                                    i95 = i19;
                                }
                                iCharAt13 = i96 | (cCharAt9 << i97);
                            } else {
                                i19 = i95;
                            }
                            int i98 = (iCharAt13 / 32) + i2 + i2;
                            Object obj3 = objArr4[i98];
                            if (obj3 instanceof Field) {
                                fieldG = (Field) obj3;
                            } else {
                                fieldG = G(cls, (String) obj3);
                                objArr4[i98] = fieldG;
                            }
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldG);
                            i18 = 55296;
                        }
                        if (i77 >= 18 && i77 <= 49) {
                            iArr[i66] = iObjectFieldOffset;
                            i66++;
                        }
                        i21 = i20;
                        i22 = iObjectFieldOffset;
                    } else {
                        i23 = 1;
                        i6 += 2;
                    }
                    int i99 = i69 / 3;
                    objArr[i99 + i99 + i23] = objArr4[i89];
                    cls = cls;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldG4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0) {
                        i18 = 55296;
                        i19 = i74;
                        i20 = 0;
                    } else {
                        i18 = 55296;
                        i19 = i74;
                        i20 = 0;
                    }
                    if (i77 >= 18) {
                        iArr[i66] = iObjectFieldOffset;
                        i66++;
                    }
                    i21 = i20;
                    i22 = iObjectFieldOffset;
                }
                cls = cls;
                i6 = i89;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldG4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i18 = 55296;
                    i19 = i74;
                    i20 = 0;
                } else {
                    i18 = 55296;
                    i19 = i74;
                    i20 = 0;
                }
                if (i77 >= 18) {
                    iArr[i66] = iObjectFieldOffset;
                    i66++;
                }
                i21 = i20;
                i22 = iObjectFieldOffset;
            }
            int i100 = i79;
            int i101 = i69 + 1;
            iArr2[i69] = i78;
            int i102 = i69 + 2;
            String str2 = str;
            iArr2[i101] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i100 != 0 ? Integer.MIN_VALUE : 0) | (i77 << 20) | i22;
            i69 += 3;
            iArr2[i102] = (i21 << 20) | iObjectFieldOffset2;
            cls = cls;
            objArr2 = objArr4;
            i33 = i18;
            length = i16;
            objArr3 = objArr;
            i2 = i2;
            i35 = i19;
            str = str2;
        }
        return new yu3(iArr2, objArr3, i3, i5, dv3Var.a, iArr, i7, i64, el1Var, nr4Var);
    }

    public static int x(long j, Object obj) {
        return ((Integer) pv3.h(j, obj)).intValue();
    }

    public static int z(int i) {
        return (i >>> 20) & 255;
    }

    public final int A(int i) {
        return this.a[i + 1];
    }

    public final iu3 C(int i) {
        int i2 = i / 3;
        return (iu3) this.b[i2 + i2 + 1];
    }

    public final ev3 D(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        Object[] objArr = this.b;
        ev3 ev3Var = (ev3) objArr[i3];
        if (ev3Var != null) {
            return ev3Var;
        }
        ev3 ev3VarA = bv3.c.a((Class) objArr[i3 + 1]);
        objArr[i3] = ev3VarA;
        return ev3VarA;
    }

    public final Object E(int i, Object obj) {
        ev3 ev3VarD = D(i);
        int iA = A(i) & 1048575;
        if (!p(i, obj)) {
            return ev3VarD.i();
        }
        Object object = m.getObject(obj, iA);
        if (r(object)) {
            return object;
        }
        Object objI = ev3VarD.i();
        if (object != null) {
            ev3VarD.e(objI, object);
        }
        return objI;
    }

    public final Object F(int i, int i2, Object obj) {
        ev3 ev3VarD = D(i2);
        if (!s(i, i2, obj)) {
            return ev3VarD.i();
        }
        Object object = m.getObject(obj, A(i2) & 1048575);
        if (r(object)) {
            return object;
        }
        Object objI = ev3VarD.i();
        if (object != null) {
            ev3VarD.e(objI, object);
        }
        return objI;
    }

    @Override // defpackage.ev3
    public final boolean a(gu3 gu3Var, gu3 gu3Var2) {
        boolean zE;
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i < iArr.length) {
                int iA = A(i);
                long j = iA & 1048575;
                switch (z(iA)) {
                    case 0:
                        if (o(gu3Var, gu3Var2, i)) {
                            ov3 ov3Var = pv3.c;
                            if (Double.doubleToLongBits(ov3Var.f(j, gu3Var)) == Double.doubleToLongBits(ov3Var.f(j, gu3Var2))) {
                                continue;
                                i += 3;
                            }
                        }
                        break;
                    case 1:
                        if (o(gu3Var, gu3Var2, i)) {
                            ov3 ov3Var2 = pv3.c;
                            if (Float.floatToIntBits(ov3Var2.g(j, gu3Var)) == Float.floatToIntBits(ov3Var2.g(j, gu3Var2))) {
                                continue;
                                i += 3;
                            }
                        }
                        break;
                    case 2:
                        if (o(gu3Var, gu3Var2, i) && pv3.f(j, gu3Var) == pv3.f(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 3:
                        if (o(gu3Var, gu3Var2, i) && pv3.f(j, gu3Var) == pv3.f(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 4:
                        if (o(gu3Var, gu3Var2, i) && pv3.e(j, gu3Var) == pv3.e(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 5:
                        if (o(gu3Var, gu3Var2, i) && pv3.f(j, gu3Var) == pv3.f(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 6:
                        if (o(gu3Var, gu3Var2, i) && pv3.e(j, gu3Var) == pv3.e(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 7:
                        if (o(gu3Var, gu3Var2, i)) {
                            ov3 ov3Var3 = pv3.c;
                            if (ov3Var3.l(j, gu3Var) == ov3Var3.l(j, gu3Var2)) {
                                continue;
                                i += 3;
                            }
                        }
                        break;
                    case 8:
                        if (o(gu3Var, gu3Var2, i) && fv3.e(pv3.h(j, gu3Var), pv3.h(j, gu3Var2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 9:
                        if (o(gu3Var, gu3Var2, i) && fv3.e(pv3.h(j, gu3Var), pv3.h(j, gu3Var2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 10:
                        if (o(gu3Var, gu3Var2, i) && fv3.e(pv3.h(j, gu3Var), pv3.h(j, gu3Var2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 11:
                        if (o(gu3Var, gu3Var2, i) && pv3.e(j, gu3Var) == pv3.e(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 12:
                        if (o(gu3Var, gu3Var2, i) && pv3.e(j, gu3Var) == pv3.e(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 13:
                        if (o(gu3Var, gu3Var2, i) && pv3.e(j, gu3Var) == pv3.e(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 14:
                        if (o(gu3Var, gu3Var2, i) && pv3.f(j, gu3Var) == pv3.f(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 15:
                        if (o(gu3Var, gu3Var2, i) && pv3.e(j, gu3Var) == pv3.e(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 16:
                        if (o(gu3Var, gu3Var2, i) && pv3.f(j, gu3Var) == pv3.f(j, gu3Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 17:
                        if (o(gu3Var, gu3Var2, i) && fv3.e(pv3.h(j, gu3Var), pv3.h(j, gu3Var2))) {
                            continue;
                            i += 3;
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
                        zE = fv3.e(pv3.h(j, gu3Var), pv3.h(j, gu3Var2));
                        break;
                    case 50:
                        zE = fv3.e(pv3.h(j, gu3Var), pv3.h(j, gu3Var2));
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
                        if (pv3.e(j2, gu3Var) == pv3.e(j2, gu3Var2) && fv3.e(pv3.h(j, gu3Var), pv3.h(j, gu3Var2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    default:
                        continue;
                        i += 3;
                        break;
                }
                if (zE) {
                    i += 3;
                }
            } else if (gu3Var.zbc.equals(gu3Var2.zbc)) {
                if (this.f) {
                    return ((du3) gu3Var).zbb.equals(((du3) gu3Var2).zbb);
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.ev3
    public final void b(Object obj, byte[] bArr, int i, int i2, nt3 nt3Var) throws pu3 {
        u(obj, bArr, i, i2, 0, nt3Var);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00db A[PHI: r1
      0x00db: PHI (r1v34 int) = (r1v10 int), (r1v35 int) binds: [B:85:0x01ea, B:43:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.ev3
    public final int c(gu3 gu3Var) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i5 >= iArr.length) {
                int iHashCode = gu3Var.zbc.hashCode() + (i6 * 53);
                if (!this.f) {
                    return iHashCode;
                }
                return ((du3) gu3Var).zbb.a.hashCode() + (iHashCode * 53);
            }
            int iA = A(i5);
            int i7 = 1048575 & iA;
            int iZ = z(iA);
            int i8 = iArr[i5];
            long j = i7;
            int i9 = 1237;
            int iHashCode2 = 37;
            switch (iZ) {
                case 0:
                    i = i6 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(pv3.c.f(j, gu3Var));
                    Charset charset = nu3.a;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i2 = i6 * 53;
                    iFloatToIntBits = Float.floatToIntBits(pv3.c.g(j, gu3Var));
                    i6 = iFloatToIntBits + i2;
                    break;
                case 2:
                    i = i6 * 53;
                    jDoubleToLongBits = pv3.f(j, gu3Var);
                    Charset charset2 = nu3.a;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i = i6 * 53;
                    jDoubleToLongBits = pv3.f(j, gu3Var);
                    Charset charset3 = nu3.a;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i2 = i6 * 53;
                    iFloatToIntBits = pv3.e(j, gu3Var);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 5:
                    i = i6 * 53;
                    jDoubleToLongBits = pv3.f(j, gu3Var);
                    Charset charset4 = nu3.a;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i2 = i6 * 53;
                    iFloatToIntBits = pv3.e(j, gu3Var);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 7:
                    i3 = i6 * 53;
                    boolean zL = pv3.c.l(j, gu3Var);
                    Charset charset5 = nu3.a;
                    if (zL) {
                        i9 = 1231;
                    }
                    i6 = i9 + i3;
                    break;
                case 8:
                    i2 = i6 * 53;
                    iFloatToIntBits = ((String) pv3.h(j, gu3Var)).hashCode();
                    i6 = iFloatToIntBits + i2;
                    break;
                case 9:
                    i4 = i6 * 53;
                    Object objH = pv3.h(j, gu3Var);
                    if (objH != null) {
                        iHashCode2 = objH.hashCode();
                    }
                    i6 = i4 + iHashCode2;
                    break;
                case 10:
                    i2 = i6 * 53;
                    iFloatToIntBits = pv3.h(j, gu3Var).hashCode();
                    i6 = iFloatToIntBits + i2;
                    break;
                case 11:
                    i2 = i6 * 53;
                    iFloatToIntBits = pv3.e(j, gu3Var);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 12:
                    i2 = i6 * 53;
                    iFloatToIntBits = pv3.e(j, gu3Var);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 13:
                    i2 = i6 * 53;
                    iFloatToIntBits = pv3.e(j, gu3Var);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 14:
                    i = i6 * 53;
                    jDoubleToLongBits = pv3.f(j, gu3Var);
                    Charset charset6 = nu3.a;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i2 = i6 * 53;
                    iFloatToIntBits = pv3.e(j, gu3Var);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 16:
                    i = i6 * 53;
                    jDoubleToLongBits = pv3.f(j, gu3Var);
                    Charset charset7 = nu3.a;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i4 = i6 * 53;
                    Object objH2 = pv3.h(j, gu3Var);
                    if (objH2 != null) {
                        iHashCode2 = objH2.hashCode();
                    }
                    i6 = i4 + iHashCode2;
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
                    i2 = i6 * 53;
                    iFloatToIntBits = pv3.h(j, gu3Var).hashCode();
                    i6 = iFloatToIntBits + i2;
                    break;
                case 50:
                    i2 = i6 * 53;
                    iFloatToIntBits = pv3.h(j, gu3Var).hashCode();
                    i6 = iFloatToIntBits + i2;
                    break;
                case 51:
                    if (s(i8, i5, gu3Var)) {
                        i = i6 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) pv3.h(j, gu3Var)).doubleValue());
                        Charset charset8 = nu3.a;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) pv3.h(j, gu3Var)).floatValue());
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 53:
                    if (s(i8, i5, gu3Var)) {
                        i = i6 * 53;
                        jDoubleToLongBits = B(j, gu3Var);
                        Charset charset9 = nu3.a;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 54:
                    if (s(i8, i5, gu3Var)) {
                        i = i6 * 53;
                        jDoubleToLongBits = B(j, gu3Var);
                        Charset charset10 = nu3.a;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 55:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = x(j, gu3Var);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 56:
                    if (s(i8, i5, gu3Var)) {
                        i = i6 * 53;
                        jDoubleToLongBits = B(j, gu3Var);
                        Charset charset11 = nu3.a;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 57:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = x(j, gu3Var);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 58:
                    if (s(i8, i5, gu3Var)) {
                        i3 = i6 * 53;
                        boolean zBooleanValue = ((Boolean) pv3.h(j, gu3Var)).booleanValue();
                        Charset charset12 = nu3.a;
                        if (zBooleanValue) {
                            i9 = 1231;
                        }
                        i6 = i9 + i3;
                    }
                    break;
                case 59:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = ((String) pv3.h(j, gu3Var)).hashCode();
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 60:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = pv3.h(j, gu3Var).hashCode();
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 61:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = pv3.h(j, gu3Var).hashCode();
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 62:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = x(j, gu3Var);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 63:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = x(j, gu3Var);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 64:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = x(j, gu3Var);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 65:
                    if (s(i8, i5, gu3Var)) {
                        i = i6 * 53;
                        jDoubleToLongBits = B(j, gu3Var);
                        Charset charset13 = nu3.a;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = x(j, gu3Var);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 67:
                    if (s(i8, i5, gu3Var)) {
                        i = i6 * 53;
                        jDoubleToLongBits = B(j, gu3Var);
                        Charset charset14 = nu3.a;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (s(i8, i5, gu3Var)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = pv3.h(j, gu3Var).hashCode();
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
            }
            i5 += 3;
        }
    }

    @Override // defpackage.ev3
    public final boolean d(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.h) {
            int i6 = this.g[i4];
            int[] iArr = this.a;
            int i7 = iArr[i6];
            int iA = A(i6);
            int i8 = iArr[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = m.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                int i11 = i3;
                i = i5;
                i2 = i11;
            }
            if ((268435456 & iA) == 0 || q(obj, i6, i, i2, i10)) {
                int iZ = z(iA);
                if (iZ != 9 && iZ != 17) {
                    if (iZ != 27) {
                        if (iZ == 60 || iZ == 68) {
                            if (!s(i7, i6, obj) || D(i6).d(pv3.h(iA & 1048575, obj))) {
                                i4++;
                                i5 = i;
                                i3 = i2;
                            }
                        } else if (iZ != 49) {
                            if (iZ != 50) {
                                continue;
                            } else {
                                uu3 uu3Var = (uu3) pv3.h(iA & 1048575, obj);
                                if (uu3Var.isEmpty()) {
                                    continue;
                                } else {
                                    int i12 = i6 / 3;
                                    if (((sv3) ((tu3) this.b[i12 + i12]).a.c).a == tv3.n) {
                                        ev3 ev3VarA = null;
                                        for (Object obj2 : uu3Var.values()) {
                                            if (ev3VarA == null) {
                                                ev3VarA = bv3.c.a(obj2.getClass());
                                            }
                                            if (!ev3VarA.d(obj2)) {
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            i4++;
                            i5 = i;
                            i3 = i2;
                        }
                    }
                    List list = (List) pv3.h(iA & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        ev3 ev3VarD = D(i6);
                        for (int i13 = 0; i13 < list.size(); i13++) {
                            if (ev3VarD.d(list.get(i13))) {
                            }
                        }
                    }
                    i4++;
                    i5 = i;
                    i3 = i2;
                } else if (!q(obj, i6, i, i2, i10) || D(i6).d(pv3.h(iA & 1048575, obj))) {
                    i4++;
                    i5 = i;
                    i3 = i2;
                }
            }
        }
        return !this.f || ((du3) obj).zbb.f();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // defpackage.ev3
    public final void e(Object obj, Object obj2) {
        Object obj3;
        if (!r(obj)) {
            og.i("Mutating immutable message: ".concat(String.valueOf(obj)));
            return;
        }
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                Object obj4 = obj;
                fv3.p(obj4, obj2);
                if (this.f) {
                    fv3.o(obj4, obj2);
                    return;
                }
                return;
            }
            int iA = A(i);
            int i2 = iA & 1048575;
            int iZ = z(iA);
            int i3 = iArr[i];
            long j = i2;
            switch (iZ) {
                case 0:
                    if (!p(i, obj2)) {
                        obj3 = obj;
                    } else {
                        ov3 ov3Var = pv3.c;
                        obj3 = obj;
                        ov3Var.j(obj3, j, ov3Var.f(j, obj2));
                        l(i, obj3);
                    }
                    break;
                case 1:
                    if (p(i, obj2)) {
                        ov3 ov3Var2 = pv3.c;
                        ov3Var2.k(obj, j, ov3Var2.g(j, obj2));
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 2:
                    if (p(i, obj2)) {
                        pv3.k(obj, j, pv3.f(j, obj2));
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 3:
                    if (p(i, obj2)) {
                        pv3.k(obj, j, pv3.f(j, obj2));
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 4:
                    if (p(i, obj2)) {
                        pv3.j(pv3.e(j, obj2), j, obj);
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 5:
                    if (p(i, obj2)) {
                        pv3.k(obj, j, pv3.f(j, obj2));
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 6:
                    if (p(i, obj2)) {
                        pv3.j(pv3.e(j, obj2), j, obj);
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 7:
                    if (p(i, obj2)) {
                        ov3 ov3Var3 = pv3.c;
                        ov3Var3.h(obj, j, ov3Var3.l(j, obj2));
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 8:
                    if (p(i, obj2)) {
                        pv3.l(obj, j, pv3.h(j, obj2));
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 9:
                    j(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 10:
                    if (p(i, obj2)) {
                        pv3.l(obj, j, pv3.h(j, obj2));
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 11:
                    if (p(i, obj2)) {
                        pv3.j(pv3.e(j, obj2), j, obj);
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 12:
                    if (p(i, obj2)) {
                        pv3.j(pv3.e(j, obj2), j, obj);
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 13:
                    if (p(i, obj2)) {
                        pv3.j(pv3.e(j, obj2), j, obj);
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 14:
                    if (p(i, obj2)) {
                        pv3.k(obj, j, pv3.f(j, obj2));
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 15:
                    if (p(i, obj2)) {
                        pv3.j(pv3.e(j, obj2), j, obj);
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 16:
                    if (p(i, obj2)) {
                        pv3.k(obj, j, pv3.f(j, obj2));
                        l(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 17:
                    j(i, obj, obj2);
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
                    mu3 mu3VarC = (mu3) pv3.h(j, obj);
                    mu3 mu3Var = (mu3) pv3.h(j, obj2);
                    int size = mu3VarC.size();
                    int size2 = mu3Var.size();
                    if (size > 0 && size2 > 0) {
                        if (!((kt3) mu3VarC).a) {
                            mu3VarC = mu3VarC.c(size2 + size);
                        }
                        mu3VarC.addAll(mu3Var);
                    }
                    if (size > 0) {
                        mu3Var = mu3VarC;
                    }
                    pv3.l(obj, j, mu3Var);
                    obj3 = obj;
                    break;
                case 50:
                    el1 el1Var = fv3.a;
                    pv3.l(obj, j, su0.p(pv3.h(j, obj), pv3.h(j, obj2)));
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
                    if (s(i3, i, obj2)) {
                        pv3.l(obj, j, pv3.h(j, obj2));
                        pv3.j(i3, iArr[i + 2] & 1048575, obj);
                    }
                    obj3 = obj;
                    break;
                case 60:
                    k(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (s(i3, i, obj2)) {
                        pv3.l(obj, j, pv3.h(j, obj2));
                        pv3.j(i3, iArr[i + 2] & 1048575, obj);
                    }
                    obj3 = obj;
                    break;
                case 68:
                    k(i, obj, obj2);
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

    /* JADX WARN: Code duplicated, block: B:144:0x03a9 A[PHI: r18
      0x03a9: PHI (r18v21 int) = (r18v3 int), (r18v4 int), (r18v10 int), (r18v12 int), (r18v13 int), (r18v14 int), (r18v18 int), (r18v22 int) binds: [B:198:0x052f, B:194:0x0511, B:177:0x049b, B:164:0x0438, B:160:0x041c, B:156:0x0400, B:149:0x03c8, B:143:0x03a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:188:0x04d7 A[PHI: r18
      0x04d7: PHI (r18v8 int) = (r18v2 int), (r18v9 int) binds: [B:202:0x054d, B:187:0x04d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:221:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:224:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    @Override // defpackage.ev3
    public final int f(jt3 jt3Var) {
        int i;
        int iB;
        int iC;
        int iB2;
        int iD;
        int iB3;
        int iA;
        int i2;
        int iB4;
        int i3;
        int iA2;
        int iH;
        int iB5;
        int size;
        int iN;
        int iB6;
        int iB7;
        int iB8;
        int size2;
        int iB9;
        int iA3;
        int iB10;
        int iC2;
        int iB11;
        int iD2;
        int iX;
        int iB12;
        yu3 yu3Var = this;
        Unsafe unsafe = m;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int iA4 = 0;
        while (true) {
            int[] iArr = yu3Var.a;
            if (i6 >= iArr.length) {
                int iA5 = ((gu3) jt3Var).zbc.a() + iA4;
                if (yu3Var.f) {
                    hv3 hv3Var = ((du3) jt3Var).zbb.a;
                    if (hv3Var.b > 0) {
                        throw null;
                    }
                    Iterator it = hv3Var.a().iterator();
                    if (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        entry.getValue();
                        throw null;
                    }
                }
                return iA5;
            }
            int iA6 = yu3Var.A(i6);
            int iZ = z(iA6);
            int i8 = iArr[i6];
            int i9 = iArr[i6 + 2];
            int i10 = i9 & i4;
            if (iZ <= 17) {
                if (i10 != i5) {
                    i7 = i10 == i4 ? 0 : unsafe.getInt(jt3Var, i10);
                    i5 = i10;
                }
                i = 1 << (i9 >>> 20);
            } else {
                i = 0;
            }
            int i11 = iA6 & i4;
            if (iZ >= xt3.b.a) {
                xt3.c.getClass();
            }
            long j = i11;
            switch (iZ) {
                case 0:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        iA4 = ky0.A(i8 << 3, 8, iA4);
                    }
                    break;
                case 1:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        iA4 = ky0.A(i8 << 3, 4, iA4);
                    }
                    yu3Var = this;
                    break;
                case 2:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        long j2 = unsafe.getLong(jt3Var, j);
                        iB = st3.b(i8 << 3);
                        iC = st3.c(j2);
                        iA4 += iC + iB;
                    }
                    yu3Var = this;
                    break;
                case 3:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        long j3 = unsafe.getLong(jt3Var, j);
                        iB = st3.b(i8 << 3);
                        iC = st3.c(j3);
                        iA4 += iC + iB;
                    }
                    yu3Var = this;
                    break;
                case 4:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        long j4 = unsafe.getInt(jt3Var, j);
                        iB = st3.b(i8 << 3);
                        iC = st3.c(j4);
                        iA4 += iC + iB;
                    }
                    yu3Var = this;
                    break;
                case 5:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        iA4 = ky0.A(i8 << 3, 8, iA4);
                    }
                    yu3Var = this;
                    break;
                case 6:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        iA4 = ky0.A(i8 << 3, 4, iA4);
                    }
                    yu3Var = this;
                    break;
                case 7:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        iA4 = ky0.A(i8 << 3, 1, iA4);
                    }
                    yu3Var = this;
                    break;
                case 8:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        int i12 = i8 << 3;
                        Object object = unsafe.getObject(jt3Var, j);
                        if (object instanceof rt3) {
                            iB2 = st3.b(i12);
                            iD = ((rt3) object).d();
                            iA4 = ky0.b(iD, iD, iB2, iA4);
                        } else {
                            iB = st3.b(i12);
                            iC = st3.a((String) object);
                            iA4 += iC + iB;
                        }
                    }
                    yu3Var = this;
                    break;
                case 9:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        Object object2 = unsafe.getObject(jt3Var, j);
                        ev3 ev3VarD = yu3Var.D(i6);
                        el1 el1Var = fv3.a;
                        iB3 = st3.b(i8 << 3);
                        iA = ((jt3) object2).a(ev3VarD);
                        iA4 = ky0.b(iA, iA, iB3, iA4);
                    }
                    break;
                case 10:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        rt3 rt3Var = (rt3) unsafe.getObject(jt3Var, j);
                        iB2 = st3.b(i8 << 3);
                        iD = rt3Var.d();
                        iA4 = ky0.b(iD, iD, iB2, iA4);
                    }
                    yu3Var = this;
                    break;
                case 11:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        i2 = unsafe.getInt(jt3Var, j);
                        iB4 = st3.b(i8 << 3);
                        iA4 = ky0.A(i2, iB4, iA4);
                    }
                    yu3Var = this;
                    break;
                case 12:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        long j5 = unsafe.getInt(jt3Var, j);
                        iB = st3.b(i8 << 3);
                        iC = st3.c(j5);
                        iA4 += iC + iB;
                    }
                    yu3Var = this;
                    break;
                case 13:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        iA4 = ky0.A(i8 << 3, 4, iA4);
                    }
                    yu3Var = this;
                    break;
                case 14:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        iA4 = ky0.A(i8 << 3, 8, iA4);
                    }
                    yu3Var = this;
                    break;
                case 15:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        int i13 = unsafe.getInt(jt3Var, j);
                        iB4 = st3.b(i8 << 3);
                        i2 = (i13 >> 31) ^ (i13 + i13);
                        iA4 = ky0.A(i2, iB4, iA4);
                    }
                    yu3Var = this;
                    break;
                case 16:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        long j6 = unsafe.getLong(jt3Var, j);
                        iB = st3.b(i8 << 3);
                        iC = st3.c((j6 >> 63) ^ (j6 + j6));
                        iA4 += iC + iB;
                    }
                    yu3Var = this;
                    break;
                case 17:
                    if (yu3Var.q(jt3Var, i6, i5, i7, i)) {
                        jt3 jt3Var2 = (jt3) unsafe.getObject(jt3Var, j);
                        ev3 ev3VarD2 = yu3Var.D(i6);
                        int iB13 = st3.b(i8 << 3);
                        i3 = iB13 + iB13;
                        iA2 = jt3Var2.a(ev3VarD2);
                        iA4 += iA2 + i3;
                    }
                    break;
                case 18:
                    iH = fv3.h(i8, (List) unsafe.getObject(jt3Var, j));
                    iA4 += iH;
                    i5 = i5;
                    break;
                case 19:
                    iH = fv3.g(i8, (List) unsafe.getObject(jt3Var, j));
                    iA4 += iH;
                    i5 = i5;
                    break;
                case 20:
                    i5 = i5;
                    List list = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var2 = fv3.a;
                    if (list.size() == 0) {
                        iB5 = 0;
                    } else {
                        iB5 = (st3.b(i8 << 3) * list.size()) + fv3.j(list);
                    }
                    iA4 += iB5;
                    i5 = i5;
                    break;
                case 21:
                    i5 = i5;
                    List list2 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var3 = fv3.a;
                    size = list2.size();
                    if (size == 0) {
                        iB7 = 0;
                    } else {
                        iN = fv3.n(list2);
                        iB6 = st3.b(i8 << 3);
                        iB7 = (iB6 * size) + iN;
                    }
                    iA4 += iB7;
                    i5 = i5;
                    break;
                case 22:
                    i5 = i5;
                    List list3 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var4 = fv3.a;
                    size = list3.size();
                    if (size == 0) {
                        iB7 = 0;
                    } else {
                        iN = fv3.i(list3);
                        iB6 = st3.b(i8 << 3);
                        iB7 = (iB6 * size) + iN;
                    }
                    iA4 += iB7;
                    i5 = i5;
                    break;
                case 23:
                    iH = fv3.h(i8, (List) unsafe.getObject(jt3Var, j));
                    iA4 += iH;
                    i5 = i5;
                    break;
                case 24:
                    iH = fv3.g(i8, (List) unsafe.getObject(jt3Var, j));
                    iA4 += iH;
                    i5 = i5;
                    break;
                case 25:
                    i5 = i5;
                    List list4 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var5 = fv3.a;
                    int size3 = list4.size();
                    if (size3 == 0) {
                        iB5 = 0;
                    } else {
                        iB5 = (st3.b(i8 << 3) + 1) * size3;
                    }
                    iA4 += iB5;
                    i5 = i5;
                    break;
                case 26:
                    i5 = i5;
                    List list5 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var6 = fv3.a;
                    int size4 = list5.size();
                    if (size4 == 0) {
                        iB7 = 0;
                    } else {
                        iB7 = st3.b(i8 << 3) * size4;
                        for (int i14 = 0; i14 < size4; i14++) {
                            Object obj = list5.get(i14);
                            if (obj instanceof rt3) {
                                int iD3 = ((rt3) obj).d();
                                iB7 = ky0.A(iD3, iD3, iB7);
                            } else {
                                iB7 = st3.a((String) obj) + iB7;
                            }
                        }
                    }
                    iA4 += iB7;
                    i5 = i5;
                    break;
                case 27:
                    i5 = i5;
                    List list6 = (List) unsafe.getObject(jt3Var, j);
                    ev3 ev3VarD3 = yu3Var.D(i6);
                    el1 el1Var7 = fv3.a;
                    int size5 = list6.size();
                    if (size5 == 0) {
                        iB8 = 0;
                    } else {
                        iB8 = st3.b(i8 << 3) * size5;
                        for (int i15 = 0; i15 < size5; i15++) {
                            int iA7 = ((jt3) list6.get(i15)).a(ev3VarD3);
                            iB8 = ky0.A(iA7, iA7, iB8);
                        }
                    }
                    iA4 += iB8;
                    i5 = i5;
                    break;
                case 28:
                    i5 = i5;
                    List list7 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var8 = fv3.a;
                    int size6 = list7.size();
                    if (size6 == 0) {
                        iB7 = 0;
                    } else {
                        iB7 = st3.b(i8 << 3) * size6;
                        for (int i16 = 0; i16 < list7.size(); i16++) {
                            int iD4 = ((rt3) list7.get(i16)).d();
                            iB7 = ky0.A(iD4, iD4, iB7);
                        }
                    }
                    iA4 += iB7;
                    i5 = i5;
                    break;
                case 29:
                    i5 = i5;
                    List list8 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var9 = fv3.a;
                    size = list8.size();
                    if (size == 0) {
                        iB7 = 0;
                    } else {
                        iN = fv3.m(list8);
                        iB6 = st3.b(i8 << 3);
                        iB7 = (iB6 * size) + iN;
                    }
                    iA4 += iB7;
                    i5 = i5;
                    break;
                case 30:
                    i5 = i5;
                    List list9 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var10 = fv3.a;
                    size = list9.size();
                    if (size == 0) {
                        iB7 = 0;
                    } else {
                        iN = fv3.f(list9);
                        iB6 = st3.b(i8 << 3);
                        iB7 = (iB6 * size) + iN;
                    }
                    iA4 += iB7;
                    i5 = i5;
                    break;
                case 31:
                    iH = fv3.g(i8, (List) unsafe.getObject(jt3Var, j));
                    iA4 += iH;
                    i5 = i5;
                    break;
                case 32:
                    iH = fv3.h(i8, (List) unsafe.getObject(jt3Var, j));
                    iA4 += iH;
                    i5 = i5;
                    break;
                case 33:
                    i5 = i5;
                    List list10 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var11 = fv3.a;
                    size = list10.size();
                    if (size == 0) {
                        iB7 = 0;
                    } else {
                        iN = fv3.k(list10);
                        iB6 = st3.b(i8 << 3);
                        iB7 = (iB6 * size) + iN;
                    }
                    iA4 += iB7;
                    i5 = i5;
                    break;
                case 34:
                    i5 = i5;
                    List list11 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var12 = fv3.a;
                    size = list11.size();
                    if (size == 0) {
                        iB7 = 0;
                    } else {
                        iN = fv3.l(list11);
                        iB6 = st3.b(i8 << 3);
                        iB7 = (iB6 * size) + iN;
                    }
                    iA4 += iB7;
                    i5 = i5;
                    break;
                case 35:
                    i5 = i5;
                    List list12 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var13 = fv3.a;
                    size2 = list12.size() * 8;
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 36:
                    i5 = i5;
                    List list13 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var14 = fv3.a;
                    size2 = list13.size() * 4;
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 37:
                    i5 = i5;
                    size2 = fv3.j((List) unsafe.getObject(jt3Var, j));
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 38:
                    i5 = i5;
                    size2 = fv3.n((List) unsafe.getObject(jt3Var, j));
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 39:
                    i5 = i5;
                    size2 = fv3.i((List) unsafe.getObject(jt3Var, j));
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 40:
                    i5 = i5;
                    List list14 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var15 = fv3.a;
                    size2 = list14.size() * 8;
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 41:
                    i5 = i5;
                    List list15 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var16 = fv3.a;
                    size2 = list15.size() * 4;
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 42:
                    i5 = i5;
                    List list16 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var17 = fv3.a;
                    size2 = list16.size();
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 43:
                    i5 = i5;
                    size2 = fv3.m((List) unsafe.getObject(jt3Var, j));
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 44:
                    i5 = i5;
                    size2 = fv3.f((List) unsafe.getObject(jt3Var, j));
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 45:
                    i5 = i5;
                    List list17 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var18 = fv3.a;
                    size2 = list17.size() * 4;
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 46:
                    i5 = i5;
                    List list18 = (List) unsafe.getObject(jt3Var, j);
                    el1 el1Var19 = fv3.a;
                    size2 = list18.size() * 8;
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 47:
                    i5 = i5;
                    size2 = fv3.k((List) unsafe.getObject(jt3Var, j));
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 48:
                    i5 = i5;
                    size2 = fv3.l((List) unsafe.getObject(jt3Var, j));
                    if (size2 > 0) {
                        iB9 = st3.b(i8 << 3);
                        iA4 = ky0.b(size2, iB9, size2, iA4);
                    }
                    i5 = i5;
                    break;
                case 49:
                    i5 = i5;
                    List list19 = (List) unsafe.getObject(jt3Var, j);
                    ev3 ev3VarD4 = yu3Var.D(i6);
                    el1 el1Var20 = fv3.a;
                    int size7 = list19.size();
                    if (size7 == 0) {
                        iA3 = 0;
                    } else {
                        iA3 = 0;
                        for (int i17 = 0; i17 < size7; i17++) {
                            jt3 jt3Var3 = (jt3) list19.get(i17);
                            int iB14 = st3.b(i8 << 3);
                            iA3 += jt3Var3.a(ev3VarD4) + iB14 + iB14;
                        }
                    }
                    iA4 += iA3;
                    i5 = i5;
                    break;
                case 50:
                    Object object3 = unsafe.getObject(jt3Var, j);
                    int i18 = i6 / 3;
                    uu3 uu3Var = (uu3) object3;
                    tu3 tu3Var = (tu3) yu3Var.b[i18 + i18];
                    if (uu3Var.isEmpty()) {
                        iB8 = 0;
                    } else {
                        iB8 = 0;
                        for (Map.Entry entry2 : uu3Var.entrySet()) {
                            Object key = entry2.getKey();
                            Object value = entry2.getValue();
                            p6 p6Var = tu3Var.a;
                            int iB15 = st3.b(i8 << 3);
                            int i19 = i5;
                            int iA8 = wt3.a((sv3) p6Var.c, 2, value) + wt3.a((sv3) p6Var.a, 1, key);
                            iB8 = ky0.b(iA8, iA8, iB15, iB8);
                            i5 = i19;
                        }
                    }
                    i5 = i5;
                    iA4 += iB8;
                    i5 = i5;
                    break;
                case 51:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        iA4 = ky0.A(i8 << 3, 8, iA4);
                    }
                    break;
                case 52:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        iA4 = ky0.A(i8 << 3, 4, iA4);
                    }
                    break;
                case 53:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        long jB = B(j, jt3Var);
                        iB10 = st3.b(i8 << 3);
                        iC2 = st3.c(jB);
                        iA4 += iC2 + iB10;
                    }
                    break;
                case 54:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        long jB2 = B(j, jt3Var);
                        iB10 = st3.b(i8 << 3);
                        iC2 = st3.c(jB2);
                        iA4 += iC2 + iB10;
                    }
                    break;
                case 55:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        long jX = x(j, jt3Var);
                        iB10 = st3.b(i8 << 3);
                        iC2 = st3.c(jX);
                        iA4 += iC2 + iB10;
                    }
                    break;
                case 56:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        iA4 = ky0.A(i8 << 3, 8, iA4);
                    }
                    break;
                case 57:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        iA4 = ky0.A(i8 << 3, 4, iA4);
                    }
                    break;
                case 58:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        iA4 = ky0.A(i8 << 3, 1, iA4);
                    }
                    break;
                case 59:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        int i20 = i8 << 3;
                        Object object4 = unsafe.getObject(jt3Var, j);
                        if (object4 instanceof rt3) {
                            iB11 = st3.b(i20);
                            iD2 = ((rt3) object4).d();
                            iA4 = ky0.b(iD2, iD2, iB11, iA4);
                        } else {
                            iB10 = st3.b(i20);
                            iC2 = st3.a((String) object4);
                            iA4 += iC2 + iB10;
                        }
                    }
                    break;
                case 60:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        Object object5 = unsafe.getObject(jt3Var, j);
                        ev3 ev3VarD5 = yu3Var.D(i6);
                        el1 el1Var21 = fv3.a;
                        iB3 = st3.b(i8 << 3);
                        iA = ((jt3) object5).a(ev3VarD5);
                        iA4 = ky0.b(iA, iA, iB3, iA4);
                    }
                    break;
                case 61:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        rt3 rt3Var2 = (rt3) unsafe.getObject(jt3Var, j);
                        iB11 = st3.b(i8 << 3);
                        iD2 = rt3Var2.d();
                        iA4 = ky0.b(iD2, iD2, iB11, iA4);
                    }
                    break;
                case 62:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        iX = x(j, jt3Var);
                        iB12 = st3.b(i8 << 3);
                        iA4 = ky0.A(iX, iB12, iA4);
                    }
                    break;
                case 63:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        long jX2 = x(j, jt3Var);
                        iB10 = st3.b(i8 << 3);
                        iC2 = st3.c(jX2);
                        iA4 += iC2 + iB10;
                    }
                    break;
                case 64:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        iA4 = ky0.A(i8 << 3, 4, iA4);
                    }
                    break;
                case 65:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        iA4 = ky0.A(i8 << 3, 8, iA4);
                    }
                    break;
                case 66:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        int iX2 = x(j, jt3Var);
                        iB12 = st3.b(i8 << 3);
                        iX = (iX2 >> 31) ^ (iX2 + iX2);
                        iA4 = ky0.A(iX, iB12, iA4);
                    }
                    break;
                case 67:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        long jB3 = B(j, jt3Var);
                        iB10 = st3.b(i8 << 3);
                        iC2 = st3.c((jB3 >> 63) ^ (jB3 + jB3));
                        iA4 += iC2 + iB10;
                    }
                    break;
                case 68:
                    if (yu3Var.s(i8, i6, jt3Var)) {
                        jt3 jt3Var4 = (jt3) unsafe.getObject(jt3Var, j);
                        ev3 ev3VarD6 = yu3Var.D(i6);
                        int iB16 = st3.b(i8 << 3);
                        i3 = iB16 + iB16;
                        iA2 = jt3Var4.a(ev3VarD6);
                        iA4 += iA2 + i3;
                    }
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0071  */
    /* JADX WARN: Code duplicated, block: B:30:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084 A[SYNTHETIC] */
    @Override // defpackage.ev3
    public final void g(Object obj) {
        if (!r(obj)) {
            return;
        }
        if (obj instanceof gu3) {
            gu3 gu3Var = (gu3) obj;
            gu3Var.e();
            gu3Var.zba = 0;
            gu3Var.c();
        }
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                this.j.getClass();
                kv3 kv3Var = ((gu3) obj).zbc;
                if (kv3Var.e) {
                    kv3Var.e = false;
                }
                if (this.f) {
                    this.k.getClass();
                    ((du3) obj).zbb.d();
                    return;
                }
                return;
            }
            int iA = A(i);
            int i2 = 1048575 & iA;
            int iZ = z(iA);
            long j = i2;
            if (iZ != 9) {
                if (iZ != 60 && iZ != 68) {
                    switch (iZ) {
                        case 17:
                            if (p(i, obj)) {
                                D(i).g(m.getObject(obj, j));
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
                            kt3 kt3Var = (kt3) ((mu3) pv3.h(j, obj));
                            if (kt3Var.a) {
                                kt3Var.a = false;
                            }
                            break;
                        case 50:
                            Unsafe unsafe = m;
                            Object object = unsafe.getObject(obj, j);
                            if (object != null) {
                                ((uu3) object).a = false;
                                unsafe.putObject(obj, j, object);
                            }
                            break;
                    }
                } else if (s(iArr[i], i, obj)) {
                    D(i).g(m.getObject(obj, j));
                }
            } else if (p(i, obj)) {
                D(i).g(m.getObject(obj, j));
            }
            i += 3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // defpackage.ev3
    public final void h(Object obj, py0 py0Var) throws jz {
        Map.Entry entry;
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        yu3 yu3Var = this;
        if (yu3Var.f) {
            wt3 wt3Var = ((du3) obj).zbb;
            if (wt3Var.a.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) wt3Var.c().next();
            }
        } else {
            entry = null;
        }
        Unsafe unsafe = m;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr = yu3Var.a;
            int length = iArr.length;
            nr4 nr4Var = yu3Var.k;
            if (i6 >= length) {
                if (entry == null) {
                    ((gu3) obj).zbc.d(py0Var);
                    return;
                }
                nr4Var.getClass();
                sv3 sv3Var = sv3.c;
                throw null;
            }
            int iA = yu3Var.A(i6);
            int iZ = z(iA);
            int i8 = iArr[i6];
            if (iZ <= 17) {
                int i9 = iArr[i6 + 2];
                z = true;
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i7 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = 1 << (i9 >>> 20);
            } else {
                z = true;
                i = 0;
            }
            if (entry != null) {
                if (i8 >= 32149011) {
                    nr4Var.getClass();
                    sv3 sv3Var2 = sv3.c;
                    throw null;
                }
            }
            long j = iA & i4;
            switch (iZ) {
                case 0:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).i(i8, Double.doubleToRawLongBits(pv3.c.f(j, obj)));
                    }
                    break;
                case 1:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).g(i8, Float.floatToRawIntBits(pv3.c.g(j, obj)));
                    }
                    break;
                case 2:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).q(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).q(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).k(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).i(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).g(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        boolean zL = pv3.c.l(j, obj);
                        st3 st3Var = (st3) py0Var.b;
                        st3Var.p(i8 << 3);
                        st3Var.d(zL ? (byte) 1 : (byte) 0);
                    }
                    break;
                case 8:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof String) {
                            st3 st3Var2 = (st3) py0Var.b;
                            st3Var2.p((i8 << 3) | 2);
                            st3Var2.m((String) object);
                        } else {
                            st3 st3Var3 = (st3) py0Var.b;
                            st3Var3.p((i8 << 3) | 2);
                            st3Var3.f((rt3) object);
                        }
                    }
                    break;
                case 9:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        py0Var.l(i8, unsafe.getObject(obj, j), yu3Var.D(i6));
                    }
                    break;
                case 10:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        rt3 rt3Var = (rt3) unsafe.getObject(obj, j);
                        st3 st3Var4 = (st3) py0Var.b;
                        st3Var4.p((i8 << 3) | 2);
                        st3Var4.f(rt3Var);
                    }
                    break;
                case 11:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).o(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).k(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).g(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        ((st3) py0Var.b).i(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        int i11 = unsafe.getInt(obj, j);
                        ((st3) py0Var.b).o(i8, (i11 >> 31) ^ (i11 + i11));
                    }
                    break;
                case 16:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        ((st3) py0Var.b).q(i8, (j2 + j2) ^ (j2 >> 63));
                    }
                    break;
                case 17:
                    if (yu3Var.q(obj, i6, i5, i7, i)) {
                        py0Var.k(i8, unsafe.getObject(obj, j), yu3Var.D(i6));
                    }
                    break;
                case 18:
                    i5 = i5;
                    i7 = i7;
                    fv3.r(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 19:
                    i5 = i5;
                    i7 = i7;
                    fv3.v(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 20:
                    i5 = i5;
                    i7 = i7;
                    fv3.x(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 21:
                    i5 = i5;
                    i7 = i7;
                    fv3.d(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 22:
                    i5 = i5;
                    i7 = i7;
                    fv3.w(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 23:
                    i5 = i5;
                    i7 = i7;
                    fv3.u(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 24:
                    i5 = i5;
                    i7 = i7;
                    fv3.t(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 25:
                    i5 = i5;
                    i7 = i7;
                    fv3.q(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 26:
                    i2 = i5;
                    i3 = i7;
                    int i12 = iArr[i6];
                    List list = (List) unsafe.getObject(obj, j);
                    el1 el1Var = fv3.a;
                    if (list != null && !list.isEmpty()) {
                        py0Var.getClass();
                        for (int i13 = 0; i13 < list.size(); i13++) {
                            st3 st3Var5 = (st3) py0Var.b;
                            String str = (String) list.get(i13);
                            st3Var5.p((i12 << 3) | 2);
                            st3Var5.m(str);
                        }
                    }
                    i5 = i2;
                    i7 = i3;
                    break;
                case 27:
                    i2 = i5;
                    i3 = i7;
                    int i14 = iArr[i6];
                    List list2 = (List) unsafe.getObject(obj, j);
                    ev3 ev3VarD = yu3Var.D(i6);
                    el1 el1Var2 = fv3.a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            py0Var.l(i14, list2.get(i15), ev3VarD);
                        }
                    }
                    i5 = i2;
                    i7 = i3;
                    break;
                case 28:
                    i2 = i5;
                    i3 = i7;
                    int i16 = iArr[i6];
                    List list3 = (List) unsafe.getObject(obj, j);
                    el1 el1Var3 = fv3.a;
                    if (list3 != null && !list3.isEmpty()) {
                        py0Var.getClass();
                        for (int i17 = 0; i17 < list3.size(); i17++) {
                            st3 st3Var6 = (st3) py0Var.b;
                            rt3 rt3Var2 = (rt3) list3.get(i17);
                            st3Var6.p((i16 << 3) | 2);
                            st3Var6.f(rt3Var2);
                        }
                    }
                    i5 = i2;
                    i7 = i3;
                    break;
                case 29:
                    z2 = false;
                    fv3.c(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 30:
                    z2 = false;
                    fv3.s(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 31:
                    z2 = false;
                    fv3.y(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 32:
                    z2 = false;
                    fv3.z(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 33:
                    z2 = false;
                    fv3.a(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 34:
                    z2 = false;
                    fv3.b(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, false);
                    i5 = i5;
                    i7 = i7;
                    break;
                case 35:
                    i2 = i5;
                    i3 = i7;
                    fv3.r(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 36:
                    i2 = i5;
                    i3 = i7;
                    fv3.v(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 37:
                    i2 = i5;
                    i3 = i7;
                    fv3.x(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 38:
                    i2 = i5;
                    i3 = i7;
                    fv3.d(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 39:
                    i2 = i5;
                    i3 = i7;
                    fv3.w(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 40:
                    i2 = i5;
                    i3 = i7;
                    fv3.u(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 41:
                    i2 = i5;
                    i3 = i7;
                    fv3.t(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 42:
                    i2 = i5;
                    i3 = i7;
                    fv3.q(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 43:
                    i2 = i5;
                    i3 = i7;
                    fv3.c(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 44:
                    i2 = i5;
                    i3 = i7;
                    fv3.s(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 45:
                    i2 = i5;
                    i3 = i7;
                    fv3.y(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 46:
                    i2 = i5;
                    i3 = i7;
                    fv3.z(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 47:
                    i2 = i5;
                    i3 = i7;
                    fv3.a(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, z);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 48:
                    i2 = i5;
                    i3 = i7;
                    fv3.b(iArr[i6], (List) unsafe.getObject(obj, j), py0Var, true);
                    i5 = i2;
                    i7 = i3;
                    break;
                case 49:
                    i2 = i5;
                    i3 = i7;
                    int i18 = iArr[i6];
                    List list4 = (List) unsafe.getObject(obj, j);
                    ev3 ev3VarD2 = yu3Var.D(i6);
                    el1 el1Var4 = fv3.a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i19 = 0; i19 < list4.size(); i19++) {
                            py0Var.k(i18, list4.get(i19), ev3VarD2);
                        }
                    }
                    i5 = i2;
                    i7 = i3;
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j);
                    if (object2 != null) {
                        int i20 = i6 / 3;
                        p6 p6Var = ((tu3) yu3Var.b[i20 + i20]).a;
                        sv3 sv3Var3 = (sv3) p6Var.c;
                        sv3 sv3Var4 = (sv3) p6Var.a;
                        st3 st3Var7 = (st3) py0Var.b;
                        for (Map.Entry entry2 : ((uu3) object2).entrySet()) {
                            st3Var7.n(i8, 2);
                            int i21 = i5;
                            int i22 = i7;
                            boolean z3 = z;
                            st3Var7.p(wt3.a(sv3Var3, 2, entry2.getValue()) + wt3.a(sv3Var4, z3 ? 1 : 0, entry2.getKey()));
                            Object key = entry2.getKey();
                            Object value = entry2.getValue();
                            wt3.e(st3Var7, sv3Var4, z3 ? 1 : 0, key);
                            wt3.e(st3Var7, sv3Var3, 2, value);
                            i5 = i21;
                            i7 = i22;
                            z = true;
                        }
                    }
                    break;
                case 51:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).i(i8, Double.doubleToRawLongBits(((Double) pv3.h(j, obj)).doubleValue()));
                    }
                    break;
                case 52:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).g(i8, Float.floatToRawIntBits(((Float) pv3.h(j, obj)).floatValue()));
                    }
                    break;
                case 53:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).q(i8, B(j, obj));
                    }
                    break;
                case 54:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).q(i8, B(j, obj));
                    }
                    break;
                case 55:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).k(i8, x(j, obj));
                    }
                    break;
                case 56:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).i(i8, B(j, obj));
                    }
                    break;
                case 57:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).g(i8, x(j, obj));
                    }
                    break;
                case 58:
                    if (yu3Var.s(i8, i6, obj)) {
                        boolean zBooleanValue = ((Boolean) pv3.h(j, obj)).booleanValue();
                        st3 st3Var8 = (st3) py0Var.b;
                        st3Var8.p(i8 << 3);
                        st3Var8.d(zBooleanValue ? (byte) 1 : (byte) 0);
                    }
                    break;
                case 59:
                    if (yu3Var.s(i8, i6, obj)) {
                        Object object3 = unsafe.getObject(obj, j);
                        if (object3 instanceof String) {
                            st3 st3Var9 = (st3) py0Var.b;
                            st3Var9.p(2 | (i8 << 3));
                            st3Var9.m((String) object3);
                        } else {
                            st3 st3Var10 = (st3) py0Var.b;
                            st3Var10.p(2 | (i8 << 3));
                            st3Var10.f((rt3) object3);
                        }
                    }
                    break;
                case 60:
                    if (yu3Var.s(i8, i6, obj)) {
                        py0Var.l(i8, unsafe.getObject(obj, j), yu3Var.D(i6));
                    }
                    break;
                case 61:
                    if (yu3Var.s(i8, i6, obj)) {
                        rt3 rt3Var3 = (rt3) unsafe.getObject(obj, j);
                        st3 st3Var11 = (st3) py0Var.b;
                        st3Var11.p(2 | (i8 << 3));
                        st3Var11.f(rt3Var3);
                    }
                    break;
                case 62:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).o(i8, x(j, obj));
                    }
                    break;
                case 63:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).k(i8, x(j, obj));
                    }
                    break;
                case 64:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).g(i8, x(j, obj));
                    }
                    break;
                case 65:
                    if (yu3Var.s(i8, i6, obj)) {
                        ((st3) py0Var.b).i(i8, B(j, obj));
                    }
                    break;
                case 66:
                    if (yu3Var.s(i8, i6, obj)) {
                        int iX = x(j, obj);
                        ((st3) py0Var.b).o(i8, (iX >> 31) ^ (iX + iX));
                    }
                    break;
                case 67:
                    if (yu3Var.s(i8, i6, obj)) {
                        long jB = B(j, obj);
                        ((st3) py0Var.b).q(i8, (jB + jB) ^ (jB >> 63));
                    }
                    break;
                case 68:
                    if (yu3Var.s(i8, i6, obj)) {
                        py0Var.k(i8, unsafe.getObject(obj, j), yu3Var.D(i6));
                    }
                    break;
                default:
                    break;
            }
            i6 += 3;
            i4 = 1048575;
            yu3Var = this;
        }
    }

    @Override // defpackage.ev3
    public final Object i() {
        return (gu3) ((gu3) this.e).i(4, null);
    }

    public final void j(int i, Object obj, Object obj2) {
        if (p(i, obj2)) {
            int iA = A(i) & 1048575;
            Unsafe unsafe = m;
            long j = iA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2.toString());
            }
            ev3 ev3VarD = D(i);
            if (!p(i, obj)) {
                if (r(object)) {
                    Object objI = ev3VarD.i();
                    ev3VarD.e(objI, object);
                    unsafe.putObject(obj, j, objI);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                l(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!r(object2)) {
                Object objI2 = ev3VarD.i();
                ev3VarD.e(objI2, object2);
                unsafe.putObject(obj, j, objI2);
                object2 = objI2;
            }
            ev3VarD.e(object2, object);
        }
    }

    public final void k(int i, Object obj, Object obj2) {
        int[] iArr = this.a;
        int i2 = iArr[i];
        if (s(i2, i, obj2)) {
            int iA = A(i) & 1048575;
            Unsafe unsafe = m;
            long j = iA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            ev3 ev3VarD = D(i);
            if (!s(i2, i, obj)) {
                if (r(object)) {
                    Object objI = ev3VarD.i();
                    ev3VarD.e(objI, object);
                    unsafe.putObject(obj, j, objI);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                pv3.j(i2, iArr[i + 2] & 1048575, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!r(object2)) {
                Object objI2 = ev3VarD.i();
                ev3VarD.e(objI2, object2);
                unsafe.putObject(obj, j, objI2);
                object2 = objI2;
            }
            ev3VarD.e(object2, object);
        }
    }

    public final void l(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        pv3.j((1 << (i2 >>> 20)) | pv3.e(j, obj), j, obj);
    }

    public final void m(int i, Object obj, Object obj2) {
        m.putObject(obj, A(i) & 1048575, obj2);
        l(i, obj);
    }

    public final void n(int i, int i2, Object obj, Object obj2) {
        m.putObject(obj, A(i2) & 1048575, obj2);
        pv3.j(i, this.a[i2 + 2] & 1048575, obj);
    }

    public final boolean o(gu3 gu3Var, gu3 gu3Var2, int i) {
        return p(i, gu3Var) == p(i, gu3Var2);
    }

    /* JADX WARN: Code duplicated, block: B:72:0x00f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x00f6 A[RETURN] */
    public final boolean p(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            if (((1 << (i2 >>> 20)) & pv3.e(j, obj)) != 0) {
                return true;
            }
            return false;
        }
        int iA = A(i);
        long j2 = iA & 1048575;
        switch (z(iA)) {
            case 0:
                if (Double.doubleToRawLongBits(pv3.c.f(j2, obj)) != 0) {
                    return true;
                }
                return false;
            case 1:
                if (Float.floatToRawIntBits(pv3.c.g(j2, obj)) != 0) {
                    return true;
                }
                return false;
            case 2:
                if (pv3.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 3:
                if (pv3.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 4:
                if (pv3.e(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 5:
                if (pv3.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 6:
                if (pv3.e(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 7:
                return pv3.c.l(j2, obj);
            case 8:
                Object objH = pv3.h(j2, obj);
                if (objH instanceof String) {
                    if (((String) objH).isEmpty()) {
                        return false;
                    }
                    return true;
                }
                if (!(objH instanceof rt3)) {
                    dk0.v();
                    return false;
                }
                if (rt3.b.equals(objH)) {
                    return false;
                }
                return true;
            case 9:
                if (pv3.h(j2, obj) != null) {
                    return true;
                }
                return false;
            case 10:
                if (rt3.b.equals(pv3.h(j2, obj))) {
                    return false;
                }
                return true;
            case 11:
                if (pv3.e(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 12:
                if (pv3.e(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 13:
                if (pv3.e(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 14:
                if (pv3.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 15:
                if (pv3.e(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 16:
                if (pv3.f(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 17:
                if (pv3.h(j2, obj) != null) {
                    return true;
                }
                return false;
            default:
                dk0.v();
                return false;
        }
    }

    public final boolean q(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return p(i, obj);
        }
        return (i3 & i4) != 0;
    }

    public final boolean s(int i, int i2, Object obj) {
        return pv3.e((long) (this.a[i2 + 2] & 1048575), obj) == i;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 42441. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int u(java.lang.Object r43, byte[] r44, int r45, int r46, int r47, defpackage.nt3 r48) throws defpackage.pu3 {
        /*
            Method dump skipped, instruction units count: 4244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yu3.u(java.lang.Object, byte[], int, int, int, nt3):int");
    }

    public final int y(int i, int i2) {
        int[] iArr = this.a;
        int length = (iArr.length / 3) - 1;
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
}
