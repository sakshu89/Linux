package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l92 implements Closeable {
    public static final qi0 f = new qi0("proto");
    public final fb2 a;
    public final wy b;
    public final wy c;
    public final ii e;

    public l92(wy wyVar, wy wyVar2, ii iiVar, fb2 fb2Var) {
        this.a = fb2Var;
        this.b = wyVar;
        this.c = wyVar2;
        this.e = iiVar;
    }

    public static Long e(SQLiteDatabase sQLiteDatabase, pj pjVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(pjVar.a, String.valueOf(w02.a(pjVar.c))));
        byte[] bArr = pjVar.b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public static String q(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((xi) it.next()).a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object r(Cursor cursor, j92 j92Var) {
        try {
            return j92Var.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase c() {
        fb2 fb2Var = this.a;
        fb2Var.getClass();
        wy wyVar = this.c;
        long jH = wyVar.h();
        while (true) {
            try {
                return fb2Var.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e) {
                if (wyVar.h() >= ((long) this.e.c) + jH) {
                    throw new vu2("Timed out while trying to open db.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    public final Object j(j92 j92Var) {
        SQLiteDatabase sQLiteDatabaseC = c();
        sQLiteDatabaseC.beginTransaction();
        try {
            Object objApply = j92Var.apply(sQLiteDatabaseC);
            sQLiteDatabaseC.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseC.endTransaction();
        }
    }

    public final Object o(wu2 wu2Var) {
        SQLiteDatabase sQLiteDatabaseC = c();
        wy wyVar = this.c;
        long jH = wyVar.h();
        while (true) {
            try {
                sQLiteDatabaseC.beginTransaction();
                try {
                    Object objB = wu2Var.b();
                    sQLiteDatabaseC.setTransactionSuccessful();
                    return objB;
                } finally {
                    sQLiteDatabaseC.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e) {
                if (wyVar.h() >= ((long) this.e.c) + jH) {
                    throw new vu2("Timed out while trying to acquire the lock.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
