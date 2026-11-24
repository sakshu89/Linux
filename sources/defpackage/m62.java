package defpackage;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m62 {
    public static final double h = Math.sqrt(2.3703703703703702d);
    public final Size a;
    public final Rational b;
    public final Rational c;
    public final HashSet d;
    public final kf e;
    public final ut f;
    public final HashMap g;

    public m62(wt wtVar, HashSet hashSet) {
        Size sizeE = z13.e(wtVar.l().e());
        ut utVarI = wtVar.i();
        kf kfVar = new kf(utVarI, sizeE);
        this.g = new HashMap();
        this.a = sizeE;
        Rational rational = ((double) sizeE.getWidth()) / ((double) sizeE.getHeight()) > h ? ug.c : ug.a;
        sizeE.toString();
        Objects.toString(rational);
        xq4.c(3, "ResolutionsMerger");
        this.b = rational;
        Rational rational2 = ug.a;
        if (rational.equals(rational2)) {
            rational2 = ug.c;
        } else if (!rational.equals(ug.c)) {
            dk0.y(rational, "Invalid sensor aspect-ratio: ");
            throw null;
        }
        this.c = rational2;
        this.f = utVarI;
        this.d = hashSet;
        this.e = kfVar;
    }

    public static Rect a(Size size, Size size2) {
        RectF rectF;
        RectF rectF2;
        Rational rationalG = g(size2);
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rationalG2 = g(size);
        if (rationalG.floatValue() == rationalG2.floatValue()) {
            rectF2 = new RectF(0.0f, 0.0f, width, height);
        } else {
            if (rationalG.floatValue() > rationalG2.floatValue()) {
                float f = width;
                float fFloatValue = f / rationalG.floatValue();
                float f2 = (height - fFloatValue) / 2.0f;
                rectF = new RectF(0.0f, f2, f, fFloatValue + f2);
            } else {
                float f3 = height;
                float fFloatValue2 = rationalG.floatValue() * f3;
                float f4 = (width - fFloatValue2) / 2.0f;
                rectF = new RectF(f4, 0.0f, fFloatValue2 + f4, f3);
            }
            rectF2 = rectF;
        }
        Rect rect = new Rect();
        rectF2.round(rect);
        return rect;
    }

    public static boolean c(Size size, Size size2) {
        return size.getHeight() > size2.getHeight() || size.getWidth() > size2.getWidth();
    }

    public static Rational g(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    public final List b(r53 r53Var) {
        Rational rationalG;
        if (!this.d.contains(r53Var)) {
            dk0.y(r53Var, "Invalid child config: ");
            return null;
        }
        HashMap map = this.g;
        if (map.containsKey(r53Var)) {
            List list = (List) map.get(r53Var);
            Objects.requireNonNull(list);
            return list;
        }
        ArrayList arrayListS = this.e.s(r53Var);
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        int size = arrayListS.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListS.get(i);
            i++;
            Size size2 = (Size) obj;
            Iterator it = map2.keySet().iterator();
            do {
                if (!it.hasNext()) {
                    rationalG = null;
                    break;
                }
                rationalG = (Rational) it.next();
            } while (!ug.a(rationalG, size2));
            if (rationalG != null) {
                Size size3 = (Size) map2.get(rationalG);
                Objects.requireNonNull(size3);
                if (size2.getHeight() > size3.getHeight() || size2.getWidth() > size3.getWidth() || (size2.getWidth() == size3.getWidth() && size2.getHeight() == size3.getHeight())) {
                }
            } else {
                rationalG = g(size2);
            }
            arrayList.add(size2);
            map2.put(rationalG, size2);
        }
        map.put(r53Var, arrayList);
        return arrayList;
    }

    public final boolean d(Rational rational, Size size) {
        Rational rational2 = this.b;
        if (rational2.equals(rational) || ug.a(rational, size)) {
            return false;
        }
        float fFloatValue = rational2.floatValue();
        float fFloatValue2 = rational.floatValue();
        Rational rationalG = ug.a;
        if (!ug.a(rationalG, size)) {
            rationalG = ug.c;
            if (!ug.a(rationalG, size)) {
                rationalG = g(size);
            }
        }
        float fFloatValue3 = rationalG.floatValue();
        if (fFloatValue == fFloatValue2 || fFloatValue2 == fFloatValue3) {
            return false;
        }
        if (fFloatValue > fFloatValue2) {
            return fFloatValue2 < fFloatValue3;
        }
        return fFloatValue2 > fFloatValue3;
    }

    public final ArrayList e(List list, boolean z) {
        int i;
        List arrayList;
        HashMap map = new HashMap();
        Rational rational = ug.a;
        map.put(rational, new ArrayList());
        Rational rational2 = ug.c;
        map.put(rational2, new ArrayList());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(rational);
        arrayList2.add(rational2);
        Iterator it = list.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Size size = (Size) it.next();
            if (size.getHeight() > 0) {
                int size2 = arrayList2.size();
                while (true) {
                    if (i >= size2) {
                        arrayList = null;
                        break;
                    }
                    Object obj = arrayList2.get(i);
                    i++;
                    Rational rational3 = (Rational) obj;
                    if (ug.a(rational3, size)) {
                        arrayList = (List) map.get(rational3);
                        break;
                    }
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    Rational rationalG = g(size);
                    arrayList2.add(rationalG);
                    map.put(rationalG, arrayList);
                }
                arrayList.add(size);
            }
        }
        ArrayList arrayList3 = new ArrayList(map.keySet());
        Collections.sort(arrayList3, new i2(10, g(this.a)));
        ArrayList arrayList4 = new ArrayList();
        int size3 = arrayList3.size();
        while (i < size3) {
            Object obj2 = arrayList3.get(i);
            i++;
            Rational rational4 = (Rational) obj2;
            if (!rational4.equals(ug.c) && !rational4.equals(ug.a)) {
                List list2 = (List) map.get(rational4);
                Objects.requireNonNull(list2);
                arrayList4.addAll(f(rational4, list2, z));
            }
        }
        return arrayList4;
    }

    public final ArrayList f(Rational rational, List list, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (ug.a(rational, size)) {
                arrayList2.add(size);
            }
        }
        Collections.sort(arrayList2, new v00(true));
        HashSet hashSet = new HashSet(arrayList2);
        Iterator it2 = this.d.iterator();
        while (true) {
            int i = 0;
            if (!it2.hasNext()) {
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList2.size();
                while (i < size2) {
                    Object obj = arrayList2.get(i);
                    i++;
                    Size size3 = (Size) obj;
                    if (!hashSet.contains(size3)) {
                        arrayList3.add(size3);
                    }
                }
                return arrayList3;
            }
            List<Size> listB = b((r53) it2.next());
            if (!z) {
                ArrayList arrayList4 = new ArrayList();
                for (Size size4 : listB) {
                    if (!d(rational, size4)) {
                        arrayList4.add(size4);
                    }
                }
                listB = arrayList4;
            }
            if (listB.isEmpty()) {
                return new ArrayList();
            }
            if (listB.isEmpty() || arrayList2.isEmpty()) {
                arrayList2 = new ArrayList();
            } else {
                ArrayList arrayList5 = new ArrayList();
                int size5 = arrayList2.size();
                int i2 = 0;
                while (i2 < size5) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    Size size6 = (Size) obj2;
                    Iterator it3 = listB.iterator();
                    while (it3.hasNext()) {
                        if (!c((Size) it3.next(), size6)) {
                            arrayList5.add(size6);
                            break;
                        }
                    }
                }
                arrayList2 = arrayList5;
            }
            if (listB.isEmpty() || arrayList2.isEmpty()) {
                arrayList = new ArrayList();
            } else {
                ArrayList arrayList6 = arrayList2.isEmpty() ? arrayList2 : new ArrayList(new LinkedHashSet(arrayList2));
                arrayList = new ArrayList();
                int size7 = arrayList6.size();
                while (i < size7) {
                    Object obj3 = arrayList6.get(i);
                    i++;
                    Size size8 = (Size) obj3;
                    Iterator it4 = listB.iterator();
                    do {
                        if (!it4.hasNext()) {
                            arrayList.add(size8);
                            break;
                        }
                    } while (!c((Size) it4.next(), size8));
                }
                if (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
            hashSet.retainAll(arrayList);
        }
    }
}
