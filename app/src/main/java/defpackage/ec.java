package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.View;
import com.project.sonic.background.SonicVoiceService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ec extends nu2 implements hq0 {
    public final /* synthetic */ int f;
    public int i;
    public Object j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ec(Object obj, Object obj2, x50 x50Var, int i) {
        super(1, x50Var);
        this.f = i;
        this.j = obj;
        this.k = obj2;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        Object obj2 = this.k;
        x50 x50Var = (x50) obj;
        switch (i) {
            case 0:
                return new ec((fc) this.j, (dx2) obj2, x50Var, 0).s(q43Var);
            case 1:
                return new ec((wk) this.j, (vk) obj2, x50Var, 1).s(q43Var);
            case 2:
                return new ec((w90) obj2, x50Var, 2).s(q43Var);
            case 3:
                return new ec((so2) this.j, (ho2) obj2, x50Var, 3).s(q43Var);
            default:
                return new ec((SonicVoiceService) obj2, x50Var, 4).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        bc bcVar;
        Throwable th;
        fr2 w22Var;
        o42 o42Var;
        int i = this.f;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        Object obj2 = this.k;
        int i2 = 1;
        x50 x50Var = null;
        switch (i) {
            case 0:
                fc fcVar = (fc) this.j;
                wm2 wm2Var = fcVar.e;
                View view = fcVar.a;
                int i3 = this.i;
                try {
                    if (i3 == 0) {
                        bz3.g(obj);
                        cc ccVar = new cc();
                        dx2 dx2Var = (dx2) obj2;
                        bc bcVar2 = new bc(ccVar, new yb(fcVar, dx2Var, 0), new yb(fcVar, dx2Var, 1), view);
                        hq0 hq0Var = fcVar.b;
                        if (hq0Var != null && (bcVar = (bc) hq0Var.j(bcVar2)) != null) {
                            bcVar2 = bcVar;
                        }
                        Looper looperMyLooper = Looper.myLooper();
                        Handler handler = view.getHandler();
                        if (looperMyLooper != (handler != null ? handler.getLooper() : null)) {
                            dc dcVar = fcVar.i;
                            if (dcVar == null) {
                                dcVar = new dc(fcVar, bcVar2, ccVar, 0);
                                fcVar.i = dcVar;
                            }
                            view.post(dcVar);
                        } else {
                            ActionMode actionModeStartActionMode = view.startActionMode(new lm0(bcVar2), 1);
                            if (actionModeStartActionMode == null) {
                                return q43Var;
                            }
                            fcVar.h = actionModeStartActionMode;
                        }
                        this.i = 1;
                        un unVar = ccVar.a;
                        unVar.getClass();
                        Object objI = un.I(unVar, this);
                        if (objI != t70Var) {
                            objI = q43Var;
                        }
                        if (objI == t70Var) {
                            return t70Var;
                        }
                    } else {
                        if (i3 != 1) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        bz3.g(obj);
                    }
                    wm2Var.a();
                    Looper looperMyLooper2 = Looper.myLooper();
                    Handler handler2 = view.getHandler();
                    if (looperMyLooper2 != (handler2 != null ? handler2.getLooper() : null)) {
                        Runnable s7Var = fcVar.j;
                        if (s7Var == null) {
                            s7Var = new s7(2, fcVar);
                            fcVar.j = s7Var;
                        }
                        view.post(s7Var);
                    } else {
                        ActionMode actionMode = fcVar.h;
                        if (actionMode != null) {
                            actionMode.finish();
                        }
                    }
                    dc dcVar2 = fcVar.i;
                    if (dcVar2 != null) {
                        view.removeCallbacks(dcVar2);
                    }
                    fcVar.h = null;
                    return q43Var;
                } catch (Throwable th2) {
                    wm2Var.a();
                    Looper looperMyLooper3 = Looper.myLooper();
                    Handler handler3 = view.getHandler();
                    if (looperMyLooper3 != (handler3 != null ? handler3.getLooper() : null)) {
                        Runnable s7Var2 = fcVar.j;
                        if (s7Var2 == null) {
                            s7Var2 = new s7(2, fcVar);
                            fcVar.j = s7Var2;
                        }
                        view.post(s7Var2);
                    } else {
                        ActionMode actionMode2 = fcVar.h;
                        if (actionMode2 != null) {
                            actionMode2.finish();
                        }
                    }
                    dc dcVar3 = fcVar.i;
                    if (dcVar3 != null) {
                        view.removeCallbacks(dcVar3);
                    }
                    fcVar.h = null;
                    throw th2;
                }
            case 1:
                vk vkVar = (vk) obj2;
                ku1 ku1Var = ((wk) this.j).c;
                int i4 = this.i;
                try {
                    if (i4 == 0) {
                        bz3.g(obj);
                        ku1Var.setValue(vkVar);
                        this.i = 1;
                        un unVar2 = vkVar.b;
                        unVar2.getClass();
                        Object objI2 = un.I(unVar2, this);
                        if (objI2 != t70Var) {
                            objI2 = q43Var;
                        }
                        if (objI2 == t70Var) {
                            return t70Var;
                        }
                    } else {
                        if (i4 != 1) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        bz3.g(obj);
                    }
                    ku1Var.setValue(null);
                    return q43Var;
                } catch (Throwable th3) {
                    ku1Var.setValue(null);
                    throw th3;
                }
            case 2:
                w90 w90Var = (w90) obj2;
                int i5 = this.i;
                try {
                    if (i5 == 0) {
                        bz3.g(obj);
                        this.i = 1;
                        obj = w90.g(w90Var, true, this);
                        if (obj == t70Var) {
                            return t70Var;
                        }
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                og.n("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            th = (Throwable) this.j;
                            bz3.g(obj);
                            w22Var = new w22(((Number) obj).intValue(), th);
                            return new wt1(w22Var, Boolean.TRUE);
                        }
                        bz3.g(obj);
                    }
                    w22Var = (fr2) obj;
                    break;
                } catch (Throwable th4) {
                    uk2 uk2VarH = w90Var.h();
                    this.j = th4;
                    this.i = 2;
                    Integer numA = uk2VarH.a();
                    if (numA == t70Var) {
                        return t70Var;
                    }
                    obj = numA;
                    th = th4;
                }
                return new wt1(w22Var, Boolean.TRUE);
            case 3:
                int i6 = this.i;
                if (i6 == 0) {
                    bz3.g(obj);
                    this.i = 1;
                    return so2.g((so2) this.j, (ho2) obj2, this) == t70Var ? t70Var : q43Var;
                }
                if (i6 == 1) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                SonicVoiceService sonicVoiceService = (SonicVoiceService) obj2;
                int i7 = this.i;
                if (i7 == 0) {
                    bz3.g(obj);
                    o42 o42Var2 = new o42();
                    mt0 mt0VarE = sonicVoiceService.e();
                    n90 n90Var = new n90(sonicVoiceService, x50Var, i2);
                    o0 o0Var = new o0(18, sonicVoiceService, o42Var2);
                    this.j = o42Var2;
                    this.i = 1;
                    Object objM = mt0VarE.m(n90Var, o0Var, this);
                    if (objM == t70Var) {
                        return t70Var;
                    }
                    obj = objM;
                    o42Var = o42Var2;
                } else {
                    if (i7 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    o42Var = (o42) this.j;
                    bz3.g(obj);
                }
                be1 be1Var = (be1) obj;
                if (!o42Var.a) {
                    return be1Var;
                }
                sonicVoiceService.X.c();
                return be1Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ec(Object obj, x50 x50Var, int i) {
        super(1, x50Var);
        this.f = i;
        this.k = obj;
    }
}
