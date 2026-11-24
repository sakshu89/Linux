package defpackage;

import android.app.RemoteAction;
import android.graphics.RectF;
import android.view.textclassifier.TextClassification;
import com.project.sonic.MainActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ha implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ha(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:132:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:142:0x02cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:14:0x0083  */
    /* JADX WARN: Code duplicated, block: B:176:0x0376 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:177:0x0378 A[Catch: all -> 0x036b, LOOP:10: B:160:0x033c->B:177:0x0378, LOOP_END, TryCatch #0 {all -> 0x036b, blocks: (B:153:0x0319, B:155:0x0329, B:157:0x032f, B:160:0x033c, B:162:0x0348, B:164:0x0352, B:166:0x0358, B:168:0x0361, B:173:0x036d, B:174:0x0370, B:177:0x0378, B:187:0x039d, B:178:0x037b, B:179:0x0381, B:181:0x0387, B:183:0x038f, B:186:0x0399), top: B:249:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:251:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:0x0083 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x010b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:0x0083 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x039d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00dd A[LOOP:0: B:25:0x00ad->B:36:0x00dd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x0115 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0117 A[LOOP:2: B:42:0x00e8->B:53:0x0117, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:145:0x02d3, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        boolean zG;
        ba2 ba2Var;
        char c;
        long j;
        Collection collectionG;
        Object next;
        String str;
        wt1 wt1Var;
        String str2;
        Object next2;
        String str3;
        String str4;
        char c2 = 7;
        long j2 = -9187201950435737472L;
        Object objY = null;
        switch (this.a) {
            case 0:
                kf2 kf2Var = (kf2) this.b;
                l42 l42VarC = py3.c((RectF) obj);
                l42 l42VarC2 = py3.c((RectF) obj2);
                switch (kf2Var.a) {
                    case 4:
                        zG = l42VarC.g(l42VarC2);
                        break;
                    default:
                        zG = l42VarC2.a(l42VarC.b());
                        break;
                }
                return Boolean.valueOf(zG);
            case 1:
                i52 i52Var = (i52) this.b;
                ((Integer) obj).getClass();
                if (obj2 instanceof d20) {
                    d20 d20Var = (d20) obj2;
                    hm1 hm1Var = (hm1) i52Var.h;
                    if (hm1Var == null) {
                        hm1 hm1Var2 = za2.a;
                        hm1Var = new hm1();
                        i52Var.h = hm1Var;
                    }
                    hm1Var.k(d20Var);
                    ((pm1) i52Var.e).b(d20Var);
                }
                if (obj2 instanceof k52) {
                    i52Var.e((k52) obj2);
                }
                if (obj2 instanceof a42) {
                    ((a42) obj2).c();
                }
                return q43.a;
            case 2:
                ((Integer) obj2).getClass();
                hl4.d((ny2) this.b, (x20) obj, ny3.c(1));
                return q43.a;
            case 3:
                jx2 jx2Var = (jx2) this.b;
                x20 x20Var = (x20) obj;
                ((Integer) obj2).getClass();
                x20Var.W(666084174);
                String str5 = jx2Var.b;
                x20Var.p(false);
                return str5;
            case 4:
                ((Integer) obj2).getClass();
                ((s01) this.b).a((x20) obj, ny3.c(1));
                return q43.a;
            case 5:
                x92 x92Var = (x92) obj;
                List list = (List) ((vq0) this.b).e(x92Var, obj2);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Object obj3 = list.get(i);
                    if (obj3 != null && (ba2Var = x92Var.b) != null && !ba2Var.c(obj3)) {
                        throw new IllegalArgumentException(("item at index " + i + " can't be saved: " + obj3).toString());
                    }
                }
                if (list.isEmpty()) {
                    return null;
                }
                return new ArrayList(list);
            case 6:
                ((wx2) this.b).e(((jp1) obj2).a);
                return q43.a;
            case 7:
                MainActivity mainActivity = (MainActivity) this.b;
                x20 x20Var2 = (x20) obj;
                int iIntValue = ((Integer) obj2).intValue();
                Set set = MainActivity.m0;
                if (x20Var2.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    g03.a(yi4.b(1123005944, new bg1(mainActivity, qn4.a(new g32(mainActivity.s().g), x20Var2, 0), qn4.a(new g32(mainActivity.s().f), x20Var2, 0), qn4.a(new g32(mainActivity.q().n), x20Var2, 0), qn4.a(new g32(mainActivity.r().j), x20Var2, 0), 0), x20Var2), x20Var2, 6);
                } else {
                    x20Var2.R();
                }
                return q43.a;
            case 8:
                f42 f42Var = (f42) this.b;
                Set set2 = (Set) obj;
                synchronized (f42Var.c) {
                    try {
                        if (((c42) f42Var.u.getValue()).compareTo(c42.f) >= 0) {
                            hm1 hm1Var3 = f42Var.h;
                            if (set2 instanceof ab2) {
                                hm1 hm1Var4 = ((ab2) set2).a;
                                Object[] objArr = hm1Var4.b;
                                long[] jArr = hm1Var4.a;
                                int length = jArr.length - 2;
                                if (length >= 0) {
                                    int i2 = 0;
                                    while (true) {
                                        long j3 = jArr[i2];
                                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i3 = 8 - ((~(i2 - length)) >>> 31);
                                            for (int i4 = 0; i4 < i3; i4++) {
                                                if ((j3 & 255) < 128) {
                                                    Object obj4 = objArr[(i2 << 3) + i4];
                                                    if (!(obj4 instanceof or2) || ((or2) obj4).e(1)) {
                                                        hm1Var3.a(obj4);
                                                    }
                                                }
                                                j3 >>= 8;
                                            }
                                            if (i3 == 8) {
                                                if (i2 != length) {
                                                    i2++;
                                                }
                                            }
                                        } else if (i2 != length) {
                                            i2++;
                                        }
                                    }
                                }
                            } else {
                                for (Object obj5 : set2) {
                                    if (!(obj5 instanceof or2) || ((or2) obj5).e(1)) {
                                        hm1Var3.a(obj5);
                                    }
                                }
                            }
                            objY = f42Var.y();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (objY != null) {
                    ((yv) objY).h(q43.a);
                }
                return q43.a;
            case 9:
                n92 n92Var = (n92) this.b;
                int iIntValue2 = ((Integer) obj).intValue();
                h70 h70Var = (h70) obj2;
                i70 key = h70Var.getKey();
                h70 h70VarV = n92Var.f.v(key);
                if (key == nr4.k) {
                    f41 f41Var = (f41) h70VarV;
                    f41 parent = (f41) h70Var;
                    while (parent != null) {
                        if (parent != f41Var && (parent instanceof hb2)) {
                            sx sxVarT = ((hb2) parent).T();
                            parent = sxVarT != null ? sxVarT.getParent() : null;
                        } else {
                            objY = parent;
                            if (objY == f41Var) {
                                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + objY + ", expected child of " + f41Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                            }
                            if (f41Var != null) {
                                iIntValue2++;
                            }
                        }
                    }
                    if (objY == f41Var) {
                        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + objY + ", expected child of " + f41Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                    }
                    if (f41Var != null) {
                        iIntValue2++;
                    }
                } else if (h70Var != h70VarV) {
                    iIntValue2 = Integer.MIN_VALUE;
                } else {
                    iIntValue2++;
                }
                return Integer.valueOf(iIntValue2);
            case 10:
                ae2 ae2Var = (ae2) this.b;
                uf4.b(ae2Var.w0(), null, new zd2(ae2Var, ((Float) obj).floatValue(), ((Float) obj2).floatValue(), null), 3);
                return Boolean.TRUE;
            case 11:
                s42 s42Var = (s42) this.b;
                ((ny1) obj).a();
                s42Var.a = ((jp1) obj2).a;
                return q43.a;
            case 12:
                un unVar = (un) this.b;
                Set set3 = (Set) obj;
                if (set3 instanceof ab2) {
                    hm1 hm1Var5 = ((ab2) set3).a;
                    Object[] objArr2 = hm1Var5.b;
                    long[] jArr2 = hm1Var5.a;
                    int length2 = jArr2.length - 2;
                    if (length2 >= 0) {
                        int i5 = 0;
                        while (true) {
                            long j4 = jArr2[i5];
                            if ((((~j4) << c2) & j4 & j2) != j2) {
                                int i6 = 8 - ((~(i5 - length2)) >>> 31);
                                int i7 = 0;
                                while (true) {
                                    if (i7 < i6) {
                                        if ((j4 & 255) < 128) {
                                            Object obj6 = objArr2[(i5 << 3) + i7];
                                            if (!(obj6 instanceof or2) || ((or2) obj6).e(4)) {
                                            }
                                        }
                                        j4 >>= 8;
                                        i7++;
                                        c2 = c2;
                                        j2 = j2;
                                    } else {
                                        c = c2;
                                        j = j2;
                                        if (i6 == 8) {
                                        }
                                    }
                                }
                            } else {
                                c = c2;
                                j = j2;
                            }
                            if (i5 != length2) {
                                i5++;
                                c2 = c;
                                j2 = j;
                            }
                        }
                        unVar.s(set3);
                    }
                } else {
                    Set set4 = set3;
                    if (!(set4 instanceof Collection) || !set4.isEmpty()) {
                        for (Object obj7 : set4) {
                            if (!(obj7 instanceof or2) || ((or2) obj7).e(4)) {
                                unVar.s(set3);
                            }
                        }
                    }
                }
                return q43.a;
            case 13:
                wm2 wm2Var = (wm2) this.b;
                Collection collection = (Set) obj;
                AtomicReference atomicReference = wm2Var.b;
                while (true) {
                    Object obj8 = atomicReference.get();
                    if (obj8 == null) {
                        collectionG = collection;
                    } else if (obj8 instanceof Set) {
                        collectionG = nz.i(obj8, collection);
                    } else {
                        if (!(obj8 instanceof List)) {
                            y20.b("Unexpected notification");
                            og.k();
                            return null;
                        }
                        collectionG = mz.G((Collection) obj8, nz.h(collection));
                    }
                    do {
                        if (atomicReference.compareAndSet(obj8, collectionG)) {
                            if (wm2Var.b()) {
                                wm2Var.a.j(new kb(21, wm2Var));
                            }
                            return q43.a;
                        }
                    } while (atomicReference.get() == obj8);
                }
                break;
            case 14:
                ((Integer) obj2).getClass();
                dp2.a((ek1) this.b, (x20) obj, ny3.c(55));
                return q43.a;
            case 15:
                char[] cArr = (char[]) this.b;
                CharSequence charSequence = (CharSequence) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                charSequence.getClass();
                int iZ = cs2.z(charSequence, cArr, iIntValue3, false);
                if (iZ < 0) {
                    return null;
                }
                return new wt1(Integer.valueOf(iZ), 1);
            case 16:
                List list2 = (List) this.b;
                CharSequence charSequence2 = (CharSequence) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                charSequence2.getClass();
                if (list2.size() == 1) {
                    String str6 = (String) mz.H(list2);
                    int iY = cs2.y(charSequence2, str6, iIntValue4, false, 4);
                    if (iY < 0) {
                        wt1Var = null;
                    } else {
                        wt1Var = new wt1(Integer.valueOf(iY), str6);
                    }
                } else {
                    if (iIntValue4 < 0) {
                        iIntValue4 = 0;
                    }
                    h21 h21Var = new h21(iIntValue4, charSequence2.length(), 1);
                    int i8 = h21Var.c;
                    int i9 = h21Var.b;
                    if (charSequence2 instanceof String) {
                        if ((i8 <= 0 || iIntValue4 > i9) && (i8 >= 0 || i9 > iIntValue4)) {
                            wt1Var = null;
                        } else {
                            while (true) {
                                Iterator it = list2.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next2 = it.next();
                                        str4 = (String) next2;
                                    } else {
                                        next2 = null;
                                    }
                                    str3 = (String) next2;
                                    if (str3 != null) {
                                        wt1Var = new wt1(Integer.valueOf(iIntValue4), str3);
                                    } else if (iIntValue4 != i9) {
                                        iIntValue4 += i8;
                                    } else {
                                        wt1Var = null;
                                    }
                                } while (!str4.regionMatches(0, (String) charSequence2, iIntValue4, str4.length()));
                                str3 = (String) next2;
                                if (str3 != null) {
                                    wt1Var = new wt1(Integer.valueOf(iIntValue4), str3);
                                } else if (iIntValue4 != i9) {
                                    iIntValue4 += i8;
                                } else {
                                    wt1Var = null;
                                }
                            }
                        }
                    } else if ((i8 <= 0 || iIntValue4 > i9) && (i8 >= 0 || i9 > iIntValue4)) {
                        wt1Var = null;
                    } else {
                        int i10 = iIntValue4;
                        while (true) {
                            Iterator it2 = list2.iterator();
                            do {
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    str2 = (String) next;
                                } else {
                                    next = null;
                                }
                                str = (String) next;
                                if (str != null) {
                                    wt1Var = new wt1(Integer.valueOf(i10), str);
                                } else if (i10 != i9) {
                                    i10 += i8;
                                } else {
                                    wt1Var = null;
                                }
                            } while (!cs2.F(str2, 0, charSequence2, i10, str2.length(), false));
                            str = (String) next;
                            if (str != null) {
                                wt1Var = new wt1(Integer.valueOf(i10), str);
                            } else if (i10 != i9) {
                                i10 += i8;
                            } else {
                                wt1Var = null;
                            }
                        }
                    }
                }
                if (wt1Var != null) {
                    return new wt1(wt1Var.a, Integer.valueOf(((String) wt1Var.b).length()));
                }
                return null;
            case 17:
                TextClassification textClassification = (TextClassification) this.b;
                x20 x20Var3 = (x20) obj;
                ((Integer) obj2).getClass();
                x20Var3.W(950061013);
                String strValueOf = String.valueOf(textClassification.getLabel());
                x20Var3.p(false);
                return strValueOf;
            case 18:
                RemoteAction remoteAction = (RemoteAction) this.b;
                x20 x20Var4 = (x20) obj;
                ((Integer) obj2).intValue();
                x20Var4.W(-1376593684);
                String string = remoteAction.getTitle().toString();
                x20Var4.p(false);
                return string;
            default:
                ((hq0) this.b).j(obj);
                return q43.a;
        }
    }

    public /* synthetic */ ha(Object obj, int i, int i2) {
        this.a = i2;
        this.b = obj;
    }
}
