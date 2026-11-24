package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gd implements nm0 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;
    public final Object e;

    public gd(nm0 nm0Var, j70 j70Var) {
        this.a = 3;
        this.b = j70Var;
        this.c = ab4.d(j70Var);
        this.e = new sc2(nm0Var, null, 14);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) {
        vm0 vm0Var;
        nm0 nm0Var;
        Object objN;
        int i = this.a;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        Object obj2 = this.e;
        Object obj3 = this.c;
        Object obj4 = this.b;
        switch (i) {
            case 0:
                j23 j23Var = (j23) obj3;
                ((i12) obj4).setValue(Boolean.valueOf(((Boolean) obj).booleanValue() ? ((Boolean) ((vq0) ((mm1) obj2).getValue()).e(j23Var.c(), j23Var.d.getValue())).booleanValue() : false));
                return q43Var;
            case 1:
                if (x50Var instanceof vm0) {
                    vm0Var = (vm0) x50Var;
                    int i2 = vm0Var.k;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        vm0Var.k = i2 - Integer.MIN_VALUE;
                    } else {
                        vm0Var = new vm0(this, x50Var);
                    }
                } else {
                    vm0Var = new vm0(this, x50Var);
                }
                Object objE = vm0Var.i;
                int i3 = vm0Var.k;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            obj = vm0Var.f;
                            this = vm0Var.e;
                            bz3.g(objE);
                            if (!((Boolean) objE).booleanValue()) {
                                ((o42) this.b).a = true;
                                nm0Var = (nm0) this.c;
                                vm0Var.e = null;
                                vm0Var.f = null;
                                vm0Var.k = 3;
                                if (nm0Var.n(obj, vm0Var) == t70Var) {
                                    return t70Var;
                                }
                            }
                        } else if (i3 != 3) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                    }
                    bz3.g(objE);
                } else {
                    bz3.g(objE);
                    if (((o42) obj4).a) {
                        vm0Var.k = 1;
                        if (((nm0) obj3).n(obj, vm0Var) == t70Var) {
                            return t70Var;
                        }
                    } else {
                        vm0Var.e = this;
                        vm0Var.f = obj;
                        vm0Var.k = 2;
                        objE = ((vq0) obj2).e(obj, vm0Var);
                        if (objE == t70Var) {
                            return t70Var;
                        }
                        if (!((Boolean) objE).booleanValue()) {
                            ((o42) this.b).a = true;
                            nm0Var = (nm0) this.c;
                            vm0Var.e = null;
                            vm0Var.f = null;
                            vm0Var.k = 3;
                            if (nm0Var.n(obj, vm0Var) == t70Var) {
                                return t70Var;
                            }
                        }
                    }
                }
                return q43Var;
            case 2:
                e5 e5Var = (e5) obj;
                nm0 nm0Var2 = (nm0) obj2;
                rv1 rv1Var = (rv1) obj3;
                if (e5Var instanceof z4) {
                    z4 z4Var = (z4) e5Var;
                    if (z4Var.b == null) {
                        ((in2) obj4).g.c(rv1Var);
                        objN = nm0Var2.n(new z4(z4Var.a, rv1Var), x50Var);
                        if (objN != t70Var) {
                            return q43Var;
                        }
                    } else {
                        objN = nm0Var2.n(e5Var, x50Var);
                        if (objN != t70Var) {
                            return q43Var;
                        }
                    }
                } else {
                    objN = nm0Var2.n(e5Var, x50Var);
                    if (objN != t70Var) {
                        return q43Var;
                    }
                }
                return objN;
            default:
                Object objA = lh4.a((j70) obj4, obj, obj3, (sc2) obj2, x50Var);
                return objA == t70Var ? objA : q43Var;
        }
    }

    public /* synthetic */ gd(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
    }
}
