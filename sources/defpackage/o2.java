package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o2 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ yv c;

    public o2(yv yvVar, AtomicBoolean atomicBoolean) {
        this.a = 2;
        this.c = yvVar;
        this.b = atomicBoolean;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        AbstractList<rw2> abstractList;
        gp1 gp1Var;
        switch (this.a) {
            case 0:
                Bitmap bitmap = (Bitmap) obj;
                if (this.b.compareAndSet(false, true)) {
                    this.c.i(bitmap, n2.b);
                } else if (bitmap != null) {
                    bitmap.recycle();
                }
                return q43.a;
            case 1:
                ad2 ad2Var = (ad2) obj;
                ad2Var.getClass();
                if (this.b.compareAndSet(false, true)) {
                    this.c.i(ad2Var, n2.c);
                } else {
                    zc2 zc2Var = ad2Var instanceof zc2 ? (zc2) ad2Var : null;
                    if (zc2Var != null) {
                        zc2Var.a.recycle();
                    }
                }
                return q43.a;
            default:
                uw2 uw2Var = (uw2) obj;
                if (this.c.w() instanceof mo1) {
                    List<tw2> listUnmodifiableList = Collections.unmodifiableList(uw2Var.a);
                    listUnmodifiableList.getClass();
                    ArrayList arrayList = new ArrayList();
                    for (tw2 tw2Var : listUnmodifiableList) {
                        synchronized (tw2Var) {
                            abstractList = tw2Var.d;
                        }
                        abstractList.getClass();
                        ArrayList arrayList2 = new ArrayList();
                        for (rw2 rw2Var : abstractList) {
                            Rect rect = rw2Var.b;
                            if (rect == null) {
                                gp1Var = null;
                            } else {
                                String str = rw2Var.a;
                                if (str == null) {
                                    str = "";
                                }
                                gp1Var = new gp1(str, new Rect(rect));
                            }
                            if (gp1Var != null) {
                                arrayList2.add(gp1Var);
                            }
                        }
                        rz.q(arrayList2, arrayList);
                    }
                    if (this.b.compareAndSet(false, true)) {
                        this.c.h(arrayList);
                    }
                }
                return q43.a;
        }
    }

    public /* synthetic */ o2(AtomicBoolean atomicBoolean, yv yvVar, int i) {
        this.a = i;
        this.b = atomicBoolean;
        this.c = yvVar;
    }
}
