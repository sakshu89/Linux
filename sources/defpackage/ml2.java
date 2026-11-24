package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ml2 extends g72 implements vq0 {
    public Object c;
    public Iterator e;
    public int f;
    public int i;
    public int j;
    public /* synthetic */ Object k;
    public final /* synthetic */ Iterator n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ml2(Iterator it, x50 x50Var) {
        super(x50Var);
        this.n = it;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((ml2) q((x50) obj2, (yg2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        ml2 ml2Var = new ml2(this.n, x50Var);
        ml2Var.k = obj;
        return ml2Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i;
        int i2;
        ArrayList arrayList;
        Iterator it;
        int i3;
        int i4;
        int i5;
        d82 d82Var;
        yg2 yg2Var = (yg2) this.k;
        int i6 = this.j;
        boolean z = true;
        t70 t70Var = t70.a;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        i4 = this.i;
                        int i7 = this.f;
                        Iterator it2 = this.e;
                        d82 d82Var2 = (d82) this.c;
                        bz3.g(obj);
                        d82Var2.b();
                        while (true) {
                            int i8 = d82Var2.b;
                            Object[] objArr = d82Var2.a;
                            if (!it2.hasNext()) {
                                i5 = i7;
                                d82Var = d82Var2;
                                break;
                            }
                            Object next = it2.next();
                            boolean z2 = z;
                            if (d82Var2.a() == i8) {
                                og.n("ring buffer is full");
                                return null;
                            }
                            int i9 = d82Var2.c;
                            int i10 = d82Var2.e;
                            objArr[(i9 + i10) % i8] = next;
                            d82Var2.e = i10 + 1;
                            if (d82Var2.a() == i8) {
                                if (d82Var2.e >= 2) {
                                    ArrayList arrayList2 = new ArrayList(d82Var2);
                                    this.k = yg2Var;
                                    this.c = d82Var2;
                                    this.e = it2;
                                    this.f = i7;
                                    this.i = i4;
                                    this.j = 3;
                                    yg2Var.b(this, arrayList2);
                                    return t70Var;
                                }
                                int i11 = i8 + (i8 >> 1) + 1;
                                if (i11 > 2) {
                                    i11 = 2;
                                }
                                d82Var2 = new d82(d82Var2.e, d82Var2.c == 0 ? Arrays.copyOf(objArr, i11) : d82Var2.toArray(new Object[i11]));
                            }
                            z = z2;
                        }
                    } else if (i6 == 4) {
                        i4 = this.i;
                        i5 = this.f;
                        d82Var = (d82) this.c;
                        bz3.g(obj);
                        d82Var.b();
                    } else {
                        if (i6 != 5) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                    }
                    if (d82Var.e > 2) {
                        ArrayList arrayList3 = new ArrayList(d82Var);
                        this.k = yg2Var;
                        this.c = d82Var;
                        this.e = null;
                        this.f = i5;
                        this.i = i4;
                        this.j = 4;
                        yg2Var.b(this, arrayList3);
                        return t70Var;
                    }
                    if (!d82Var.isEmpty()) {
                        this.k = null;
                        this.c = null;
                        this.e = null;
                        this.f = i5;
                        this.i = i4;
                        this.j = 5;
                        yg2Var.b(this, d82Var);
                        return t70Var;
                    }
                }
                bz3.g(obj);
            } else {
                i = this.i;
                int i12 = this.f;
                Iterator it3 = this.e;
                bz3.g(obj);
                arrayList = new ArrayList(2);
                it = it3;
                i3 = i12;
                i2 = i;
            }
            return q43.a;
        }
        bz3.g(obj);
        i = 0;
        i2 = 0;
        arrayList = new ArrayList(2);
        it = this.n;
        i3 = 2;
        while (it.hasNext()) {
            Object next2 = it.next();
            if (i > 0) {
                i--;
            } else {
                arrayList.add(next2);
                if (arrayList.size() == 2) {
                    this.k = yg2Var;
                    this.c = arrayList;
                    this.e = it;
                    this.f = i3;
                    this.i = i2;
                    this.j = 1;
                    yg2Var.b(this, arrayList);
                    return t70Var;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.k = null;
            this.c = null;
            this.e = null;
            this.f = i3;
            this.i = i2;
            this.j = 2;
            yg2Var.b(this, arrayList);
            return t70Var;
        }
        return q43.a;
    }
}
