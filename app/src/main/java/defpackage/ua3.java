package defpackage;

import android.os.Build;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ua3 extends WindowInsetsAnimation$Callback {
    public final hz a;
    public List b;
    public ArrayList c;
    public final HashMap d;

    public ua3(hz hzVar) {
        super(hzVar.a);
        this.d = new HashMap();
        this.a = hzVar;
    }

    public final xa3 a(WindowInsetsAnimation windowInsetsAnimation) {
        HashMap map = this.d;
        xa3 xa3Var = (xa3) map.get(windowInsetsAnimation);
        if (xa3Var == null) {
            xa3Var = new xa3(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                xa3Var.a = new va3(windowInsetsAnimation);
            }
            map.put(windowInsetsAnimation, xa3Var);
        }
        return xa3Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.a.e(a(windowInsetsAnimation));
        this.d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        this.a.f();
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.c = arrayList2;
            this.b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimationE = ta3.e(list.get(size));
            xa3 xa3VarA = a(windowInsetsAnimationE);
            xa3VarA.a.e(windowInsetsAnimationE.getFraction());
            this.c.add(xa3VarA);
        }
        return this.a.g(pb3.b(windowInsets, null), this.b).a();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        cu2 cu2VarH = this.a.h(a(windowInsetsAnimation), new cu2(bounds));
        cu2VarH.getClass();
        d2.o();
        return d2.j(((q11) cu2VarH.b).d(), ((q11) cu2VarH.c).d());
    }
}
