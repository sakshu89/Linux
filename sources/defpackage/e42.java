package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e42 extends nu2 implements wq0 {
    public List f;
    public List i;
    public List j;
    public hm1 k;
    public hm1 n;
    public hm1 s;
    public Set t;
    public hm1 u;
    public int v;
    public /* synthetic */ sc w;
    public final /* synthetic */ f42 x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e42(f42 f42Var, x50 x50Var) {
        super(3, x50Var);
        this.x = f42Var;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0077 A[Catch: all -> 0x0029, LOOP:1: B:12:0x0041->B:22:0x0077, LOOP_END, TryCatch #0 {all -> 0x0029, blocks: (B:4:0x000b, B:6:0x0018, B:9:0x002c, B:12:0x0041, B:14:0x0052, B:16:0x005c, B:18:0x0062, B:19:0x006f, B:24:0x0082, B:27:0x008f, B:29:0x009a, B:31:0x00a4, B:33:0x00aa, B:34:0x00b4, B:37:0x00bc, B:38:0x00bf, B:41:0x00cf, B:43:0x00da, B:45:0x00e4, B:47:0x00ea, B:48:0x00f7, B:51:0x00ff, B:52:0x0102, B:22:0x0077), top: B:57:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bc A[Catch: all -> 0x0029, LOOP:3: B:27:0x008f->B:37:0x00bc, LOOP_END, TryCatch #0 {all -> 0x0029, blocks: (B:4:0x000b, B:6:0x0018, B:9:0x002c, B:12:0x0041, B:14:0x0052, B:16:0x005c, B:18:0x0062, B:19:0x006f, B:24:0x0082, B:27:0x008f, B:29:0x009a, B:31:0x00a4, B:33:0x00aa, B:34:0x00b4, B:37:0x00bc, B:38:0x00bf, B:41:0x00cf, B:43:0x00da, B:45:0x00e4, B:47:0x00ea, B:48:0x00f7, B:51:0x00ff, B:52:0x0102, B:22:0x0077), top: B:57:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ff A[Catch: all -> 0x0029, LOOP:5: B:41:0x00cf->B:51:0x00ff, LOOP_END, TryCatch #0 {all -> 0x0029, blocks: (B:4:0x000b, B:6:0x0018, B:9:0x002c, B:12:0x0041, B:14:0x0052, B:16:0x005c, B:18:0x0062, B:19:0x006f, B:24:0x0082, B:27:0x008f, B:29:0x009a, B:31:0x00a4, B:33:0x00aa, B:34:0x00b4, B:37:0x00bc, B:38:0x00bf, B:41:0x00cf, B:43:0x00da, B:45:0x00e4, B:47:0x00ea, B:48:0x00f7, B:51:0x00ff, B:52:0x0102, B:22:0x0077), top: B:57:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0082 A[EDGE_INSN: B:61:0x0082->B:24:0x0082 BREAK  A[LOOP:1: B:12:0x0041->B:22:0x0077], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00bf A[EDGE_INSN: B:66:0x00bf->B:38:0x00bf BREAK  A[LOOP:3: B:27:0x008f->B:37:0x00bc], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0102 A[EDGE_INSN: B:71:0x0102->B:52:0x0102 BREAK  A[LOOP:5: B:41:0x00cf->B:51:0x00ff], SYNTHETIC] */
    public static final void v(f42 f42Var, List list, List list2, List list3, hm1 hm1Var, hm1 hm1Var2, hm1 hm1Var3, hm1 hm1Var4) {
        char c;
        long j;
        long j2;
        synchronized (f42Var.c) {
            try {
                list.clear();
                list2.clear();
                int size = list3.size();
                for (int i = 0; i < size; i++) {
                    g30 g30Var = (g30) list3.get(i);
                    g30Var.a();
                    f42Var.L(g30Var);
                }
                list3.clear();
                Object[] objArr = hm1Var.b;
                long[] jArr = hm1Var.a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i2 = 0;
                    j = 255;
                    while (true) {
                        long j3 = jArr[i2];
                        c = 7;
                        j2 = -9187201950435737472L;
                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i2 != length) {
                                break;
                                break;
                            }
                            i2++;
                        } else {
                            int i3 = 8 - ((~(i2 - length)) >>> 31);
                            for (int i4 = 0; i4 < i3; i4++) {
                                if ((j3 & 255) < 128) {
                                    g30 g30Var2 = (g30) objArr[(i2 << 3) + i4];
                                    g30Var2.a();
                                    f42Var.L(g30Var2);
                                }
                                j3 >>= 8;
                            }
                            if (i3 != 8) {
                                break;
                            } else if (i2 != length) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                } else {
                    c = 7;
                    j = 255;
                    j2 = -9187201950435737472L;
                }
                hm1Var.b();
                Object[] objArr2 = hm1Var2.b;
                long[] jArr2 = hm1Var2.a;
                int length2 = jArr2.length - 2;
                if (length2 >= 0) {
                    int i5 = 0;
                    while (true) {
                        long j4 = jArr2[i5];
                        if ((((~j4) << c) & j4 & j2) == j2) {
                            if (i5 != length2) {
                                break;
                                break;
                            }
                            i5++;
                        } else {
                            int i6 = 8 - ((~(i5 - length2)) >>> 31);
                            for (int i7 = 0; i7 < i6; i7++) {
                                if ((j4 & j) < 128) {
                                    ((g30) objArr2[(i5 << 3) + i7]).g();
                                }
                                j4 >>= 8;
                            }
                            if (i6 != 8) {
                                break;
                            } else if (i5 != length2) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                }
                hm1Var2.b();
                hm1Var3.b();
                Object[] objArr3 = hm1Var4.b;
                long[] jArr3 = hm1Var4.a;
                int length3 = jArr3.length - 2;
                if (length3 >= 0) {
                    int i8 = 0;
                    while (true) {
                        long j5 = jArr3[i8];
                        if ((((~j5) << c) & j5 & j2) == j2) {
                            if (i8 != length3) {
                                break;
                                break;
                            }
                            i8++;
                        } else {
                            int i9 = 8 - ((~(i8 - length3)) >>> 31);
                            for (int i10 = 0; i10 < i9; i10++) {
                                if ((j5 & j) < 128) {
                                    g30 g30Var3 = (g30) objArr3[(i8 << 3) + i10];
                                    g30Var3.a();
                                    f42Var.L(g30Var3);
                                }
                                j5 >>= 8;
                            }
                            if (i9 != 8) {
                                break;
                            } else if (i8 != length3) {
                                break;
                            } else {
                                i8++;
                            }
                        }
                    }
                }
                hm1Var4.b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final void w(List list, f42 f42Var) {
        list.clear();
        synchronized (f42Var.c) {
            try {
                ArrayList arrayList = f42Var.k;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    list.add((bl1) arrayList.get(i));
                }
                f42Var.k.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        e42 e42Var = new e42(this.x, (x50) obj3);
        e42Var.w = (sc) obj2;
        e42Var.s(q43.a);
        return t70.a;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0098 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:17:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:21:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:22:0x00cf A[Catch: all -> 0x00e6, TRY_LEAVE, TryCatch #0 {, blocks: (B:19:0x00c7, B:22:0x00cf), top: B:63:0x00c7 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:43:0x0124  */
    /* JADX WARN: Code duplicated, block: B:62:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0124 -> B:44:0x012c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01d8 -> B:12:0x0093). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e42.s(java.lang.Object):java.lang.Object");
    }
}
