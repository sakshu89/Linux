package defpackage;

import android.content.Context;
import android.os.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y02 {
    public static final y02 g = new y02();
    public wp b;
    public ov d;
    public Context e;
    public final Object a = new Object();
    public final cj c = new cj(8);
    public final HashMap f = new HashMap();

    public static final bt a(y02 y02Var, ju juVar) {
        for (Object obj : juVar.a) {
            obj.getClass();
            ki kiVar = xa1.b;
            if (!g31.a(kiVar, kiVar)) {
                synchronized (uk0.a) {
                }
                y02Var.e.getClass();
            }
        }
        return ct.a;
    }

    public static final void b(y02 y02Var, int i) {
        ov ovVar = y02Var.d;
        if (ovVar == null) {
            return;
        }
        mq mqVar = ovVar.f;
        if (mqVar == null) {
            og.n("CameraX not initialized yet.");
            return;
        }
        lq lqVar = mqVar.b;
        if (i != lqVar.c) {
            ArrayList arrayList = (ArrayList) lqVar.e;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ru ruVar = (ru) obj;
                int i3 = lqVar.c;
                synchronized (ruVar.b) {
                    boolean z = true;
                    ruVar.c = i == 2 ? 2 : 1;
                    boolean z2 = i3 != 2 && i == 2;
                    if (i3 != 2 || i == 2) {
                        z = false;
                    }
                    if (z2 || z) {
                        ruVar.b();
                    }
                }
            }
        }
        if (lqVar.c == 2 && i != 2) {
            ((ArrayList) lqVar.f).clear();
        }
        lqVar.c = i;
    }

    /* JADX WARN: Type inference failed for: r18v1, types: [c72, wt] */
    public final gb1 c(ob1 ob1Var, ju juVar, o53... o53VarArr) {
        gb1 gb1VarM;
        Collection collectionUnmodifiableCollection;
        Object obj;
        boolean zContains;
        Trace.beginSection(hd4.e("CX:bindToLifecycle-internal"));
        try {
            vc4.b();
            ov ovVar = this.d;
            ovVar.getClass();
            wt wtVarC = juVar.c(ovVar.a.w());
            wtVarC.getClass();
            wtVarC.h(true);
            c72 c72VarD = d(juVar);
            cj cjVar = this.c;
            Object obj2 = null;
            yh yhVarS = wu.s(c72VarD, null);
            synchronized (cjVar.b) {
                gb1VarM = (gb1) ((HashMap) cjVar.c).get(new oi(ob1Var, yhVarS));
            }
            cj cjVar2 = this.c;
            synchronized (cjVar2.b) {
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(((HashMap) cjVar2.c).values());
            }
            ArrayList arrayList = (ArrayList) qg.o(o53VarArr);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                i++;
                o53 o53Var = (o53) obj3;
                for (Object obj4 : collectionUnmodifiableCollection) {
                    obj4.getClass();
                    gb1 gb1Var = (gb1) obj4;
                    synchronized (gb1Var.a) {
                        obj = obj2;
                        zContains = ((ArrayList) gb1Var.c.v()).contains(o53Var);
                    }
                    if (zContains && !gb1Var.equals(gb1VarM)) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{o53Var}, 1)));
                    }
                    obj2 = obj;
                }
            }
            ?? r18 = obj2;
            if (gb1VarM == null) {
                cj cjVar3 = this.c;
                ov ovVar2 = this.d;
                ovVar2.getClass();
                mq mqVar = ovVar2.f;
                if (mqVar == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                lq lqVar = mqVar.b;
                ov ovVar3 = this.d;
                ovVar3.getClass();
                l11 l11Var = ovVar3.g;
                if (l11Var == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                ov ovVar4 = this.d;
                ovVar4.getClass();
                bs bsVar = ovVar4.h;
                if (bsVar == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                gb1VarM = cjVar3.m(ob1Var, new wu(wtVarC, r18, c72VarD, r18, lqVar, l11Var, bsVar));
            }
            if (o53VarArr.length != 0) {
                cj cjVar4 = this.c;
                List listI = nz.i(Arrays.copyOf(o53VarArr, o53VarArr.length));
                ov ovVar5 = this.d;
                ovVar5.getClass();
                mq mqVar2 = ovVar5.f;
                if (mqVar2 == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                cjVar4.g(gb1VarM, listI, mqVar2.b);
            }
            Trace.endSection();
            return gb1VarM;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final c72 d(ju juVar) {
        Object c72Var;
        juVar.getClass();
        Trace.beginSection(hd4.e("CX:getCameraInfo"));
        try {
            ov ovVar = this.d;
            ovVar.getClass();
            ut utVarI = juVar.c(ovVar.a.w()).i();
            utVarI.getClass();
            bt btVarA = a(this, juVar);
            yh yhVar = new yh(utVarI.c(), btVarA.a);
            synchronized (this.a) {
                c72Var = this.f.get(yhVar);
                if (c72Var == null) {
                    c72Var = new c72(utVarI, btVarA);
                    this.f.put(yhVar, c72Var);
                }
            }
            c72 c72Var2 = (c72) c72Var;
            Trace.endSection();
            return c72Var2;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
