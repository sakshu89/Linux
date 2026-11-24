package defpackage;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qb1 {
    public final boolean b;
    public eb1 d;
    public final WeakReference e;
    public int f;
    public boolean g;
    public boolean h;
    public final ArrayList i;
    public final jr2 j;
    public final uf1 a = new uf1(6);
    public dl0 c = new dl0();

    public qb1(ob1 ob1Var, boolean z) {
        this.b = z;
        eb1 eb1Var = eb1.b;
        this.d = eb1Var;
        this.i = new ArrayList();
        this.e = new WeakReference(ob1Var);
        this.j = o54.a(eb1Var);
    }

    public final void a(nb1 nb1Var) {
        lb1 va0Var;
        Object obj;
        ob1 ob1Var;
        db1 db1Var;
        nb1Var.getClass();
        c("addObserver");
        eb1 eb1Var = this.d;
        eb1 eb1Var2 = eb1.a;
        if (eb1Var != eb1Var2) {
            eb1Var2 = eb1.b;
        }
        pb1 pb1Var = new pb1();
        HashMap map = ub1.a;
        boolean z = nb1Var instanceof lb1;
        boolean z2 = nb1Var instanceof ta0;
        int i = 2;
        if (z && z2) {
            va0Var = new va0((ta0) nb1Var, (lb1) nb1Var);
        } else if (z2) {
            va0Var = new va0((ta0) nb1Var, (lb1) null);
        } else if (z) {
            va0Var = (lb1) nb1Var;
        } else {
            Class<?> cls = nb1Var.getClass();
            if (ub1.b(cls) == 2) {
                Object obj2 = ub1.b.get(cls);
                obj2.getClass();
                List list = (List) obj2;
                if (list.size() == 1) {
                    ub1.a((Constructor) list.get(0), nb1Var);
                    throw null;
                }
                int size = list.size();
                ut0[] ut0VarArr = new ut0[size];
                if (size > 0) {
                    ub1.a((Constructor) list.get(0), nb1Var);
                    throw null;
                }
                va0Var = new k42(i, ut0VarArr);
            } else {
                va0Var = new va0(nb1Var);
            }
        }
        pb1Var.b = va0Var;
        pb1Var.a = eb1Var2;
        dl0 dl0Var = this.c;
        s92 s92VarA = dl0Var.a(nb1Var);
        if (s92VarA != null) {
            obj = s92VarA.b;
        } else {
            HashMap map2 = dl0Var.f;
            s92 s92Var = new s92(nb1Var, pb1Var);
            dl0Var.e++;
            s92 s92Var2 = dl0Var.b;
            if (s92Var2 == null) {
                dl0Var.a = s92Var;
                dl0Var.b = s92Var;
            } else {
                s92Var2.c = s92Var;
                s92Var.e = s92Var2;
                dl0Var.b = s92Var;
            }
            map2.put(nb1Var, s92Var);
            obj = null;
        }
        if (((pb1) obj) == null && (ob1Var = (ob1) this.e.get()) != null) {
            boolean z3 = this.f != 0 || this.g;
            eb1 eb1VarB = b(nb1Var);
            this.f++;
            while (pb1Var.a.compareTo(eb1VarB) < 0 && this.c.f.containsKey(nb1Var)) {
                eb1 eb1Var3 = pb1Var.a;
                ArrayList arrayList = this.i;
                arrayList.add(eb1Var3);
                bb1 bb1Var = db1.Companion;
                eb1 eb1Var4 = pb1Var.a;
                bb1Var.getClass();
                eb1Var4.getClass();
                int iOrdinal = eb1Var4.ordinal();
                if (iOrdinal == 1) {
                    db1Var = db1.ON_CREATE;
                } else if (iOrdinal != 2) {
                    db1Var = iOrdinal != 3 ? null : db1.ON_RESUME;
                } else {
                    db1Var = db1.ON_START;
                }
                if (db1Var == null) {
                    dk0.x(pb1Var.a, "no event up from ");
                    return;
                } else {
                    pb1Var.a(ob1Var, db1Var);
                    arrayList.remove(arrayList.size() - 1);
                    eb1VarB = b(nb1Var);
                }
            }
            if (!z3) {
                g();
            }
            this.f--;
        }
    }

    public final eb1 b(nb1 nb1Var) {
        HashMap map = this.c.f;
        s92 s92Var = map.containsKey(nb1Var) ? ((s92) map.get(nb1Var)).e : null;
        eb1 eb1Var = s92Var != null ? ((pb1) s92Var.b).a : null;
        ArrayList arrayList = this.i;
        eb1 eb1Var2 = arrayList.isEmpty() ? null : (eb1) arrayList.get(arrayList.size() - 1);
        eb1 eb1Var3 = this.d;
        eb1Var3.getClass();
        if (eb1Var == null || eb1Var.compareTo(eb1Var3) >= 0) {
            eb1Var = eb1Var3;
        }
        return (eb1Var2 == null || eb1Var2.compareTo(eb1Var) >= 0) ? eb1Var : eb1Var2;
    }

    public final void c(String str) {
        if (this.b) {
            zf.a().j.getClass();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                return;
            }
            kf2.e(cq.v("Method ", str, " must be called on the main thread"));
        }
    }

    public final void d(db1 db1Var) {
        db1Var.getClass();
        c("handleLifecycleEvent");
        e(db1Var.a());
    }

    public final void e(eb1 eb1Var) {
        if (this.d == eb1Var) {
            return;
        }
        ob1 ob1Var = (ob1) this.e.get();
        eb1 eb1Var2 = this.d;
        eb1Var2.getClass();
        eb1 eb1Var3 = eb1.b;
        eb1 eb1Var4 = eb1.a;
        if (eb1Var2 == eb1Var3 && eb1Var == eb1Var4) {
            throw new IllegalStateException(("State must be at least '" + eb1.c + "' to be moved to '" + eb1Var + "' in component " + ob1Var).toString());
        }
        if (eb1Var2 == eb1Var4 && eb1Var2 != eb1Var) {
            throw new IllegalStateException(("State is '" + eb1Var4 + "' and cannot be moved to `" + eb1Var + "` in component " + ob1Var).toString());
        }
        this.d = eb1Var;
        if (this.g || this.f != 0) {
            this.h = true;
            return;
        }
        this.g = true;
        g();
        this.g = false;
        if (this.d == eb1Var4) {
            this.c = new dl0();
        }
    }

    public final void f(nb1 nb1Var) {
        nb1Var.getClass();
        c("removeObserver");
        this.c.b(nb1Var);
    }

    public final void g() {
        db1 db1Var;
        db1 db1Var2;
        ob1 ob1Var = (ob1) this.e.get();
        if (ob1Var == null) {
            og.n("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
            return;
        }
        while (true) {
            dl0 dl0Var = this.c;
            if (dl0Var.e != 0) {
                s92 s92Var = dl0Var.a;
                s92Var.getClass();
                eb1 eb1Var = ((pb1) s92Var.b).a;
                s92 s92Var2 = this.c.b;
                s92Var2.getClass();
                eb1 eb1Var2 = ((pb1) s92Var2.b).a;
                if (eb1Var == eb1Var2 && this.d == eb1Var2) {
                    break;
                }
                this.h = false;
                eb1 eb1Var3 = this.d;
                s92 s92Var3 = this.c.a;
                s92Var3.getClass();
                int iCompareTo = eb1Var3.compareTo(((pb1) s92Var3.b).a);
                ArrayList arrayList = this.i;
                if (iCompareTo < 0) {
                    dl0 dl0Var2 = this.c;
                    r92 r92Var = new r92(dl0Var2.b, dl0Var2.a, 1);
                    dl0Var2.c.put(r92Var, Boolean.FALSE);
                    while (r92Var.hasNext() && !this.h) {
                        Map.Entry entry = (Map.Entry) r92Var.next();
                        entry.getClass();
                        nb1 nb1Var = (nb1) entry.getKey();
                        pb1 pb1Var = (pb1) entry.getValue();
                        while (pb1Var.a.compareTo(this.d) > 0 && !this.h && this.c.f.containsKey(nb1Var)) {
                            bb1 bb1Var = db1.Companion;
                            eb1 eb1Var4 = pb1Var.a;
                            bb1Var.getClass();
                            eb1Var4.getClass();
                            int iOrdinal = eb1Var4.ordinal();
                            if (iOrdinal == 2) {
                                db1Var2 = db1.ON_DESTROY;
                            } else if (iOrdinal != 3) {
                                db1Var2 = iOrdinal != 4 ? null : db1.ON_PAUSE;
                            } else {
                                db1Var2 = db1.ON_STOP;
                            }
                            if (db1Var2 == null) {
                                dk0.x(pb1Var.a, "no event down from ");
                                return;
                            } else {
                                arrayList.add(db1Var2.a());
                                pb1Var.a(ob1Var, db1Var2);
                                arrayList.remove(arrayList.size() - 1);
                            }
                        }
                    }
                }
                s92 s92Var4 = this.c.b;
                if (!this.h && s92Var4 != null && this.d.compareTo(((pb1) s92Var4.b).a) > 0) {
                    dl0 dl0Var3 = this.c;
                    dl0Var3.getClass();
                    t92 t92Var = new t92(dl0Var3);
                    dl0Var3.c.put(t92Var, Boolean.FALSE);
                    while (t92Var.hasNext() && !this.h) {
                        Map.Entry entry2 = (Map.Entry) t92Var.next();
                        nb1 nb1Var2 = (nb1) entry2.getKey();
                        pb1 pb1Var2 = (pb1) entry2.getValue();
                        while (pb1Var2.a.compareTo(this.d) < 0 && !this.h && this.c.f.containsKey(nb1Var2)) {
                            arrayList.add(pb1Var2.a);
                            bb1 bb1Var2 = db1.Companion;
                            eb1 eb1Var5 = pb1Var2.a;
                            bb1Var2.getClass();
                            eb1Var5.getClass();
                            int iOrdinal2 = eb1Var5.ordinal();
                            if (iOrdinal2 == 1) {
                                db1Var = db1.ON_CREATE;
                            } else if (iOrdinal2 != 2) {
                                db1Var = iOrdinal2 != 3 ? null : db1.ON_RESUME;
                            } else {
                                db1Var = db1.ON_START;
                            }
                            if (db1Var == null) {
                                dk0.x(pb1Var2.a, "no event up from ");
                                return;
                            } else {
                                pb1Var2.a(ob1Var, db1Var);
                                arrayList.remove(arrayList.size() - 1);
                            }
                        }
                    }
                }
            } else {
                break;
            }
        }
        this.h = false;
        this.j.i(this.d);
    }
}
