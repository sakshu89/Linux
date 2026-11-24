package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lq implements wu2 {
    public final /* synthetic */ int a;
    public final Object b;
    public int c;
    public final Object e;
    public Object f;
    public final Object i;

    public lq(zt ztVar) {
        this.a = 0;
        this.c = 0;
        HashMap map = new HashMap();
        this.i = map;
        this.b = new HashSet();
        this.e = new ArrayList();
        this.f = new ArrayList();
        Set hashSet = new HashSet();
        try {
            hashSet = ztVar.a.x();
        } catch (ds unused) {
            xq4.a("Camera2CameraCoordinator", "Failed to get concurrent camera ids");
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ArrayList arrayList = new ArrayList((Set) it.next());
            if (arrayList.size() >= 2) {
                String str = (String) arrayList.get(0);
                String str2 = (String) arrayList.get(1);
                try {
                    if (ng4.a(ztVar, str) && ng4.a(ztVar, str2)) {
                        ((HashSet) this.b).add(new HashSet(Arrays.asList(str, str2)));
                        if (!map.containsKey(str)) {
                            map.put(str, new ArrayList());
                        }
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        ((List) map.get(str)).add((String) arrayList.get(1));
                        ((List) map.get(str2)).add((String) arrayList.get(0));
                    }
                } catch (v01 unused2) {
                    xq4.c(3, "Camera2CameraCoordinator");
                }
            }
        }
    }

    public static boolean n(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean o(cd0 cd0Var) {
        return cd0Var == null || cd0Var.e;
    }

    public void a(mc0 mc0Var) {
        if (((HashSet) this.b).contains(mc0Var.a)) {
            og.i("Components are not allowed to depend on interfaces they themselves provide.");
        } else {
            ((HashSet) this.e).add(mc0Var);
        }
    }

    @Override // defpackage.wu2
    public Object b() {
        Boolean bool;
        pi piVar = (pi) this.e;
        kf kfVar = (kf) piVar.d;
        sh shVar = (sh) this.f;
        Iterable iterable = (Iterable) this.i;
        pj pjVar = (pj) this.b;
        int i = this.c;
        int i2 = shVar.a;
        l92 l92Var = (l92) piVar.c;
        if (i2 == 2) {
            l92Var.getClass();
            if (iterable.iterator().hasNext()) {
                String strConcat = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ".concat(l92.q(iterable));
                SQLiteDatabase sQLiteDatabaseC = l92Var.c();
                sQLiteDatabaseC.beginTransaction();
                try {
                    sQLiteDatabaseC.compileStatement(strConcat).execute();
                    sQLiteDatabaseC.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                    sQLiteDatabaseC.setTransactionSuccessful();
                    sQLiteDatabaseC.endTransaction();
                } catch (Throwable th) {
                    sQLiteDatabaseC.endTransaction();
                    throw th;
                }
            }
            kfVar.B(pjVar, i + 1, false);
            return null;
        }
        l92Var.getClass();
        if (iterable.iterator().hasNext()) {
            l92Var.c().compileStatement("DELETE FROM events WHERE _id in ".concat(l92.q(iterable))).execute();
        }
        if (i2 == 1) {
            long jH = ((wy) piVar.g).h() + shVar.b;
            fw0 fw0Var = new fw0();
            fw0Var.a = jH;
            fw0Var.b = pjVar;
            l92Var.j(fw0Var);
        }
        SQLiteDatabase sQLiteDatabaseC2 = l92Var.c();
        sQLiteDatabaseC2.beginTransaction();
        try {
            Long lE = l92.e(sQLiteDatabaseC2, pjVar);
            if (lE == null) {
                bool = Boolean.FALSE;
            } else {
                Cursor cursorRawQuery = l92Var.c().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lE.toString()});
                try {
                    Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                    cursorRawQuery.close();
                    bool = boolValueOf;
                } catch (Throwable th2) {
                    cursorRawQuery.close();
                    throw th2;
                }
            }
            sQLiteDatabaseC2.setTransactionSuccessful();
            sQLiteDatabaseC2.endTransaction();
            if (!bool.booleanValue()) {
                return null;
            }
            kfVar.B(pjVar, 1, true);
            return null;
        } catch (Throwable th3) {
            sQLiteDatabaseC2.endTransaction();
            throw th3;
        }
    }

    public d10 c() {
        if (((p10) this.f) != null) {
            return new d10(new HashSet((HashSet) this.b), new HashSet((HashSet) this.e), this.c, (p10) this.f, (HashSet) this.i);
        }
        og.n("Missing required property: factory.");
        return null;
    }

    public void d() {
        for (cd0 cd0Var : ((cq0) this.i).e()) {
            if (cd0Var != null) {
                cd0Var.c.d();
            }
        }
    }

    public boolean e() {
        if (this.c < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (cd0 cd0Var : ((cq0) this.i).e()) {
            if (cd0Var != null && o(cd0Var) && cd0Var.c.e()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(cd0Var);
                z = true;
            }
        }
        if (((ArrayList) this.f) != null) {
            for (int i = 0; i < ((ArrayList) this.f).size(); i++) {
                cd0 cd0Var2 = (cd0) ((ArrayList) this.f).get(i);
                if (arrayList == null || !arrayList.contains(cd0Var2)) {
                    cd0Var2.getClass();
                }
            }
        }
        this.f = arrayList;
        return z;
    }

    public void f() {
        for (cd0 cd0Var : ((cq0) this.i).e()) {
            if (cd0Var != null) {
                cd0Var.c.f();
            }
        }
    }

    public void g() {
        for (cd0 cd0Var : ((cq0) this.i).e()) {
            if (cd0Var != null) {
                cd0Var.c.g();
            }
        }
    }

    public boolean h() {
        if (this.c < 1) {
            return false;
        }
        for (cd0 cd0Var : ((cq0) this.i).e()) {
            if (cd0Var != null && cd0Var.c.h()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        if (this.c < 1) {
            return;
        }
        for (cd0 cd0Var : ((cq0) this.i).e()) {
            if (cd0Var != null) {
                cd0Var.c.i();
            }
        }
    }

    public void j() {
        for (cd0 cd0Var : ((cq0) this.i).e()) {
            if (cd0Var != null) {
                cd0Var.c.j();
            }
        }
    }

    public boolean k() {
        boolean z = false;
        if (this.c < 1) {
            return false;
        }
        for (cd0 cd0Var : ((cq0) this.i).e()) {
            if (cd0Var != null && o(cd0Var) && cd0Var.c.k()) {
                z = true;
            }
        }
        return z;
    }

    public void l() {
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    }

    public String m(String str) {
        HashMap map = (HashMap) this.i;
        if (!map.containsKey(str)) {
            return null;
        }
        for (String str2 : (List) map.get(str)) {
            ArrayList arrayList = (ArrayList) this.f;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ut utVarH = ((ut) obj).h();
                hh1.a("CameraInfo doesn't contain Camera2 implementation.", utVarH instanceof br);
                if (str2.equals(((br) ((br) utVarH).c.a).a)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public String toString() {
        switch (this.a) {
            case 2:
                StringBuilder sb = new StringBuilder(128);
                sb.append("FragmentManager{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" in ");
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public lq(pi piVar, sh shVar, Iterable iterable, pj pjVar, int i) {
        this.a = 3;
        this.e = piVar;
        this.f = shVar;
        this.i = iterable;
        this.b = pjVar;
        this.c = i;
    }

    public lq() {
        this.a = 2;
        this.e = new ArrayList();
        this.i = new cq0();
        new zp0(this);
        this.b = new AtomicInteger();
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        new su0(this);
        new CopyOnWriteArrayList();
        final int i = 0;
        new s40(this) { // from class: yp0
            public final /* synthetic */ lq b;

            {
                this.b = this;
            }

            @Override // defpackage.s40
            public final void accept(Object obj) {
                int i2 = i;
                lq lqVar = this.b;
                switch (i2) {
                    case 0:
                        lqVar.d();
                        break;
                    case 1:
                        if (((Integer) obj).intValue() == 80) {
                            lqVar.f();
                        }
                        break;
                    case 2:
                        boolean z = ((il1) obj).a;
                        lqVar.g();
                        break;
                    default:
                        boolean z2 = ((ww1) obj).a;
                        lqVar.j();
                        break;
                }
            }
        };
        final int i2 = 1;
        new s40(this) { // from class: yp0
            public final /* synthetic */ lq b;

            {
                this.b = this;
            }

            @Override // defpackage.s40
            public final void accept(Object obj) {
                int i3 = i2;
                lq lqVar = this.b;
                switch (i3) {
                    case 0:
                        lqVar.d();
                        break;
                    case 1:
                        if (((Integer) obj).intValue() == 80) {
                            lqVar.f();
                        }
                        break;
                    case 2:
                        boolean z = ((il1) obj).a;
                        lqVar.g();
                        break;
                    default:
                        boolean z2 = ((ww1) obj).a;
                        lqVar.j();
                        break;
                }
            }
        };
        final int i3 = 2;
        new s40(this) { // from class: yp0
            public final /* synthetic */ lq b;

            {
                this.b = this;
            }

            @Override // defpackage.s40
            public final void accept(Object obj) {
                int i4 = i3;
                lq lqVar = this.b;
                switch (i4) {
                    case 0:
                        lqVar.d();
                        break;
                    case 1:
                        if (((Integer) obj).intValue() == 80) {
                            lqVar.f();
                        }
                        break;
                    case 2:
                        boolean z = ((il1) obj).a;
                        lqVar.g();
                        break;
                    default:
                        boolean z2 = ((ww1) obj).a;
                        lqVar.j();
                        break;
                }
            }
        };
        final int i4 = 3;
        new s40(this) { // from class: yp0
            public final /* synthetic */ lq b;

            {
                this.b = this;
            }

            @Override // defpackage.s40
            public final void accept(Object obj) {
                int i5 = i4;
                lq lqVar = this.b;
                switch (i5) {
                    case 0:
                        lqVar.d();
                        break;
                    case 1:
                        if (((Integer) obj).intValue() == 80) {
                            lqVar.f();
                        }
                        break;
                    case 2:
                        boolean z = ((il1) obj).a;
                        lqVar.g();
                        break;
                    default:
                        boolean z2 = ((ww1) obj).a;
                        lqVar.j();
                        break;
                }
            }
        };
        this.c = -1;
        new ArrayDeque();
        new o7(2, this);
    }

    public lq(Class cls, Class[] clsArr) {
        this.a = 1;
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        this.e = new HashSet();
        this.c = 0;
        this.i = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            kg1.b(cls2, "Null interface");
        }
        Collections.addAll((HashSet) this.b, clsArr);
    }
}
