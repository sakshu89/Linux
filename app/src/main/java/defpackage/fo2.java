package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fo2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public final /* synthetic */ so2 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fo2(so2 so2Var, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = so2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) throws Throwable {
        int i = this.f;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                return ((fo2) q(x50Var, s70Var)).s(q43Var);
            case 1:
                ((fo2) q(x50Var, s70Var)).s(q43Var);
                return t70Var;
            case 2:
                ((fo2) q(x50Var, s70Var)).s(q43Var);
                return t70Var;
            case 3:
                ((fo2) q(x50Var, s70Var)).s(q43Var);
                return t70Var;
            case 4:
                return ((fo2) q(x50Var, s70Var)).s(q43Var);
            case 5:
                return ((fo2) q(x50Var, s70Var)).s(q43Var);
            case 6:
                ((fo2) q(x50Var, s70Var)).s(q43Var);
                return t70Var;
            case 7:
                ((fo2) q(x50Var, s70Var)).s(q43Var);
                return t70Var;
            case 8:
                ((fo2) q(x50Var, s70Var)).s(q43Var);
                return t70Var;
            case 9:
                return ((fo2) q(x50Var, s70Var)).s(q43Var);
            case 10:
                return ((fo2) q(x50Var, s70Var)).s(q43Var);
            case 11:
                return ((fo2) q(x50Var, s70Var)).s(q43Var);
            default:
                return ((fo2) q(x50Var, s70Var)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        so2 so2Var = this.j;
        switch (i) {
            case 0:
                return new fo2(so2Var, x50Var, 0);
            case 1:
                return new fo2(so2Var, x50Var, 1);
            case 2:
                return new fo2(so2Var, x50Var, 2);
            case 3:
                return new fo2(so2Var, x50Var, 3);
            case 4:
                return new fo2(so2Var, x50Var, 4);
            case 5:
                return new fo2(so2Var, x50Var, 5);
            case 6:
                return new fo2(so2Var, x50Var, 6);
            case 7:
                return new fo2(so2Var, x50Var, 7);
            case 8:
                return new fo2(so2Var, x50Var, 8);
            case 9:
                return new fo2(so2Var, x50Var, 9);
            case 10:
                return new fo2(so2Var, x50Var, 10);
            case 11:
                return new fo2(so2Var, x50Var, 11);
            default:
                return new fo2(so2Var, x50Var, 12);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        int i = this.f;
        final int i2 = 0;
        int i3 = 2;
        int i4 = 7;
        q43 q43Var = q43.a;
        final so2 so2Var = this.j;
        t70 t70Var = t70.a;
        final int i5 = 1;
        x50 x50Var = null;
        switch (i) {
            case 0:
                int i6 = this.i;
                if (i6 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    return so2.e(so2Var, this) == t70Var ? t70Var : q43Var;
                }
                if (i6 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                int i7 = this.i;
                if (i7 != 0) {
                    if (i7 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        bz3.g(obj);
                        og.k();
                    }
                    return null;
                }
                bz3.g(obj);
                jr2 jr2Var = so2Var.d.d;
                go2 go2Var = new go2(so2Var, i2);
                this.i = 1;
                jr2Var.a(go2Var, this);
                return t70Var;
            case 2:
                int i8 = this.i;
                if (i8 != 0) {
                    if (i8 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        bz3.g(obj);
                        og.k();
                    }
                    return null;
                }
                bz3.g(obj);
                jr2 jr2Var2 = so2Var.d.f;
                go2 go2Var2 = new go2(so2Var, i5);
                this.i = 1;
                jr2Var2.a(go2Var2, this);
                return t70Var;
            case 3:
                int i9 = this.i;
                if (i9 != 0) {
                    if (i9 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        bz3.g(obj);
                        og.k();
                    }
                    return null;
                }
                bz3.g(obj);
                jr2 jr2Var3 = so2Var.d.e;
                go2 go2Var3 = new go2(so2Var, i3);
                this.i = 1;
                jr2Var3.a(go2Var3, this);
                return t70Var;
            case 4:
                int i10 = this.i;
                if (i10 != 0) {
                    if (i10 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                g32 g32Var = so2Var.b.g.g;
                go2 go2Var4 = new go2(so2Var, 3);
                this.i = 1;
                return g32Var.a.a(go2Var4, this) == t70Var ? t70Var : q43Var;
            case 5:
                int i11 = this.i;
                if (i11 != 0) {
                    if (i11 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                i5 i5Var = so2Var.h.b;
                go2 go2Var5 = new go2(so2Var, 4);
                this.i = 1;
                return i5Var.a(go2Var5, this) == t70Var ? t70Var : q43Var;
            case 6:
                int i12 = this.i;
                if (i12 != 0) {
                    if (i12 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        bz3.g(obj);
                    }
                    return null;
                }
                bz3.g(obj);
                g32 g32Var2 = so2Var.j.d;
                go2 go2Var6 = new go2(so2Var, 5);
                this.i = 1;
                if (g32Var2.a.a(go2Var6, this) == t70Var) {
                    return t70Var;
                }
                og.k();
                return null;
            case 7:
                int i13 = this.i;
                if (i13 != 0) {
                    if (i13 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        bz3.g(obj);
                        og.k();
                    }
                    return null;
                }
                bz3.g(obj);
                e32 e32Var = so2Var.k.n;
                go2 go2Var7 = new go2(so2Var, 6);
                this.i = 1;
                e32Var.a.a(go2Var7, this);
                return t70Var;
            case 8:
                int i14 = this.i;
                if (i14 != 0) {
                    if (i14 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        bz3.g(obj);
                    }
                    return null;
                }
                bz3.g(obj);
                g32 g32Var3 = so2Var.k.l;
                go2 go2Var8 = new go2(so2Var, i4);
                this.i = 1;
                if (g32Var3.a.a(go2Var8, this) == t70Var) {
                    return t70Var;
                }
                og.k();
                return null;
            case 9:
                int i15 = this.i;
                if (i15 != 0) {
                    if (i15 == 1 || i15 == 2) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                if (so2Var.o()) {
                    so2Var.F = null;
                    so2Var.j();
                    mt0 mt0Var = so2Var.k;
                    fq0 fq0Var = new fq0() { // from class: lo2
                        @Override // defpackage.fq0
                        public final Object a() {
                            int i16 = i2;
                            x50 x50Var2 = null;
                            so2 so2Var2 = so2Var;
                            switch (i16) {
                                case 0:
                                    in2 in2Var = so2Var2.b;
                                    in2Var.getClass();
                                    return new l90(1, new r0(in2Var, x50Var2, 18));
                                default:
                                    in2 in2Var2 = so2Var2.b;
                                    in2Var2.getClass();
                                    return new l90(1, new sc2(in2Var2, x50Var2, 7));
                            }
                        }
                    };
                    q0 q0Var = new q0(1, this.j, so2.class, "render", "render(Lcom/project/sonic/core/agent/AgentEvent;)V", 0, 0, 15);
                    this.i = 1;
                    if (mt0Var.l(fq0Var, q0Var, this) != t70Var) {
                        return q43Var;
                    }
                } else {
                    in2 in2Var = so2Var.b;
                    in2Var.getClass();
                    l90 l90Var = new l90(1, new r0(in2Var, x50Var, 18));
                    this.i = 2;
                    if (so2Var.u(l90Var, this) != t70Var) {
                        return q43Var;
                    }
                }
                return t70Var;
            case 10:
                int i16 = this.i;
                if (i16 != 0) {
                    if (i16 == 1 || i16 == 2) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                if (so2Var.o()) {
                    so2Var.F = null;
                    so2Var.j();
                    mt0 mt0Var2 = so2Var.k;
                    fq0 fq0Var2 = new fq0() { // from class: lo2
                        @Override // defpackage.fq0
                        public final Object a() {
                            int i17 = i5;
                            x50 x50Var2 = null;
                            so2 so2Var2 = so2Var;
                            switch (i17) {
                                case 0:
                                    in2 in2Var2 = so2Var2.b;
                                    in2Var2.getClass();
                                    return new l90(1, new r0(in2Var2, x50Var2, 18));
                                default:
                                    in2 in2Var3 = so2Var2.b;
                                    in2Var3.getClass();
                                    return new l90(1, new sc2(in2Var3, x50Var2, 7));
                            }
                        }
                    };
                    q0 q0Var2 = new q0(1, this.j, so2.class, "render", "render(Lcom/project/sonic/core/agent/AgentEvent;)V", 0, 0, 16);
                    this.i = 1;
                    if (mt0Var2.l(fq0Var2, q0Var2, this) != t70Var) {
                        return q43Var;
                    }
                } else {
                    in2 in2Var2 = so2Var.b;
                    in2Var2.getClass();
                    l90 l90Var2 = new l90(1, new sc2(in2Var2, x50Var, i4));
                    this.i = 2;
                    if (so2Var.u(l90Var2, this) != t70Var) {
                        return q43Var;
                    }
                }
                return t70Var;
            case 11:
                int i17 = this.i;
                if (i17 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    return so2.f(so2Var, this) == t70Var ? t70Var : q43Var;
                }
                if (i17 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                int i18 = this.i;
                if (i18 != 0) {
                    if (i18 == 1) {
                        bz3.g(obj);
                        return q43Var;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                in2 in2Var3 = so2Var.b;
                in2Var3.getClass();
                l90 l90Var3 = new l90(1, new sc2(in2Var3, x50Var, i4));
                mo2 mo2Var = mo2.b;
                this.i = 1;
                return l90Var3.a(mo2Var, this) == t70Var ? t70Var : q43Var;
        }
    }
}
