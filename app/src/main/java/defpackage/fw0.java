package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fw0 implements j92, eq1 {
    public long a;
    public Object b;

    public /* synthetic */ fw0(long j, Object obj) {
        this.b = obj;
        this.a = j;
    }

    public long a(long j, long j2, float f) {
        long jE = jp1.e(this.a, jp1.d(j, j2));
        this.a = jE;
        if ((((js1) this.b) == null ? jp1.c(jE) : Math.abs(b(jE))) < f) {
            return 9205357640488583168L;
        }
        js1 js1Var = (js1) this.b;
        long j3 = this.a;
        if (js1Var == null) {
            float fC = jp1.c(j3);
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) / fC;
            return jp1.d(this.a, jp1.f(f, (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)) / fC)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32)));
        }
        float fB = b(j3) - (Math.signum(b(this.a)) * f);
        long j4 = this.a;
        js1 js1Var2 = (js1) this.b;
        js1 js1Var3 = js1.b;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (js1Var2 == js1Var3 ? j4 & 4294967295L : j4 >> 32));
        if (((js1) this.b) == js1Var3) {
            return (((long) Float.floatToRawIntBits(fB)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
        }
        return (((long) Float.floatToRawIntBits(fB)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32);
    }

    @Override // defpackage.j92
    public Object apply(Object obj) {
        long j = this.a;
        pj pjVar = (pj) this.b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        qi0 qi0Var = l92.f;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        String str = pjVar.a;
        v02 v02Var = pjVar.c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(w02.a(v02Var))}) < 1) {
            contentValues.put("backend_name", str);
            contentValues.put("priority", Integer.valueOf(w02.a(v02Var)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public float b(long j) {
        return Float.intBitsToFloat((int) (((js1) this.b) == js1.b ? j >> 32 : j & 4294967295L));
    }

    public void c() {
        this.a = ((Number) ((fq0) this.b).a()).longValue() + 15000;
    }

    public ew0 d() {
        ArrayList arrayList = new ArrayList(20);
        while (true) {
            String strZ = ((yn) this.b).z(this.a);
            this.a -= (long) strZ.length();
            if (strZ.length() == 0) {
                return new ew0((String[]) arrayList.toArray(new String[0]));
            }
            int iX = cs2.x(strZ, ':', 1, 4);
            if (iX != -1) {
                String strSubstring = strZ.substring(0, iX);
                String strSubstring2 = strZ.substring(iX + 1);
                arrayList.add(strSubstring);
                arrayList.add(cs2.V(strSubstring2).toString());
            } else if (strZ.charAt(0) == ':') {
                String strSubstring3 = strZ.substring(1);
                arrayList.add("");
                arrayList.add(cs2.V(strSubstring3).toString());
            } else {
                arrayList.add("");
                arrayList.add(cs2.V(strZ).toString());
            }
        }
    }

    @Override // defpackage.eq1
    public void q(Exception exc) {
        cu2 cu2Var = (cu2) this.b;
        ((AtomicLong) cu2Var.c).set(this.a);
    }

    public /* synthetic */ fw0(js1 js1Var) {
        this(0L, js1Var);
    }
}
