package defpackage;

import android.database.Cursor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q52 implements j92 {
    public final HashMap a;

    public q52(Set set) {
        this.a = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            p52 p52Var = (p52) it.next();
            HashMap map = this.a;
            p52Var.getClass();
            map.put(n80.class, p52Var.a);
        }
    }

    @Override // defpackage.j92
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        qi0 qi0Var = l92.f;
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Long lValueOf = Long.valueOf(j);
            HashMap map = this.a;
            Set hashSet = (Set) map.get(lValueOf);
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j), hashSet);
            }
            hashSet.add(new k92(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    public q52(HashMap map) {
        this.a = map;
    }
}
