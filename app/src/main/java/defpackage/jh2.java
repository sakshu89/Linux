package defpackage;

import android.hardware.camera2.params.InputConfiguration;
import android.util.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jh2 extends fh2 {
    public final rh2 i = new rh2(2);
    public boolean j = true;
    public boolean k = false;
    public final ArrayList l = new ArrayList();

    public final void a(kh2 kh2Var) {
        Object objF;
        lw lwVar = kh2Var.g;
        int i = lwVar.c;
        gs1 gs1Var = lwVar.b;
        ur urVar = this.b;
        if (i != -1) {
            this.k = true;
            int i2 = urVar.a;
            List list = kh2.i;
            if (list.indexOf(Integer.valueOf(i)) < list.indexOf(Integer.valueOf(i2))) {
                i = i2;
            }
            urVar.a = i;
        }
        bi biVar = lw.k;
        Object objF2 = fj.f;
        try {
            objF2 = gs1Var.f(biVar);
        } catch (IllegalArgumentException unused) {
        }
        Range range = (Range) objF2;
        Objects.requireNonNull(range);
        Range range2 = fj.f;
        if (!range.equals(range2)) {
            zl1 zl1Var = (zl1) urVar.e;
            bi biVar2 = lw.k;
            zl1Var.getClass();
            try {
                objF = zl1Var.f(biVar2);
            } catch (IllegalArgumentException unused2) {
                objF = range2;
            }
            if (((Range) objF).equals(range2)) {
                ((zl1) urVar.e).v(lw.k, range);
            } else {
                zl1 zl1Var2 = (zl1) urVar.e;
                bi biVar3 = lw.k;
                Object objF3 = fj.f;
                zl1Var2.getClass();
                try {
                    objF3 = zl1Var2.f(biVar3);
                } catch (IllegalArgumentException unused3) {
                }
                if (!((Range) objF3).equals(range)) {
                    this.j = false;
                    xq4.c(3, "ValidatingBuilder");
                }
            }
        }
        int iB = lwVar.b();
        if (iB != 0) {
            urVar.getClass();
            if (iB != 0) {
                ((zl1) urVar.e).v(r53.a0, Integer.valueOf(iB));
            }
        }
        int iC = lwVar.c();
        if (iC != 0) {
            urVar.getClass();
            if (iC != 0) {
                ((zl1) urVar.e).v(r53.b0, Integer.valueOf(iC));
            }
        }
        iv2 iv2Var = lwVar.g;
        om1 om1Var = (om1) urVar.g;
        HashSet hashSet = (HashSet) urVar.d;
        om1Var.a.putAll((Map) iv2Var.a);
        this.c.addAll(kh2Var.c);
        this.d.addAll(kh2Var.d);
        urVar.a(lwVar.e);
        this.e.addAll(kh2Var.e);
        ih2 ih2Var = kh2Var.f;
        if (ih2Var != null) {
            this.l.add(ih2Var);
        }
        InputConfiguration inputConfiguration = kh2Var.h;
        if (inputConfiguration != null) {
            this.g = inputConfiguration;
        }
        ArrayList arrayList = kh2Var.a;
        LinkedHashSet<dj> linkedHashSet = this.a;
        linkedHashSet.addAll(arrayList);
        hashSet.addAll(Collections.unmodifiableList(lwVar.a));
        ArrayList arrayList2 = new ArrayList();
        for (dj djVar : linkedHashSet) {
            arrayList2.add(djVar.a);
            Iterator it = djVar.b.iterator();
            while (it.hasNext()) {
                arrayList2.add((ob0) it.next());
            }
        }
        if (!arrayList2.containsAll(hashSet)) {
            xq4.c(3, "ValidatingBuilder");
            this.j = false;
        }
        dj djVar2 = kh2Var.b;
        if (djVar2 != null) {
            dj djVar3 = this.h;
            if (djVar3 == djVar2 || djVar3 == null) {
                this.h = djVar2;
            } else {
                xq4.c(3, "ValidatingBuilder");
                this.j = false;
            }
        }
        urVar.c(gs1Var);
    }

    public final kh2 b() {
        if (!this.j) {
            og.i("Unsupported session configuration combination");
            return null;
        }
        ArrayList arrayList = new ArrayList(this.a);
        rh2 rh2Var = this.i;
        int i = 3;
        if (rh2Var.a) {
            Collections.sort(arrayList, new w00(i, rh2Var));
        }
        return new kh2(arrayList, new ArrayList(this.c), new ArrayList(this.d), new ArrayList(this.e), this.b.d(), this.l.isEmpty() ? null : new ny0(i, this), this.g, this.h);
    }
}
