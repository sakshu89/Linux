package defpackage;

import android.graphics.Bitmap;
import android.os.SystemClock;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k11 {
    public volatile Bitmap a;
    public final int b;
    public final int c;
    public final int d = -1;

    public k11(Bitmap bitmap) {
        this.a = bitmap;
        this.b = bitmap.getWidth();
        this.c = bitmap.getHeight();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:23:0x00c3  */
    public static k11 a(Bitmap bitmap) throws Throwable {
        nk4 nk4Var;
        pd4 pd4Var;
        et4 et4Var;
        long jElapsedRealtime;
        HashMap map;
        String strA;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        k11 k11Var = new k11(bitmap);
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int allocationByteCount = bitmap.getAllocationByteCount();
        synchronized (zk4.class) {
            ak4 ak4Var = new ak4();
            synchronized (zk4.class) {
                try {
                    int i = 0;
                    if (zk4.a == null) {
                        zk4.a = new xk4(i);
                    }
                    nk4Var = (nk4) zk4.a.d(ak4Var);
                } catch (Throwable th) {
                    throw th;
                }
            }
            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
            pd4Var = pd4.INPUT_IMAGE_CONSTRUCTION;
            et4Var = nk4Var.e;
            jElapsedRealtime = SystemClock.elapsedRealtime();
            map = nk4Var.i;
            if (map.get(pd4Var) != null && jElapsedRealtime - ((Long) map.get(pd4Var)).longValue() <= 30000) {
                return k11Var;
            }
            map.put(pd4Var, Long.valueOf(jElapsedRealtime));
            pi piVar = new pi();
            piVar.c = rc4.BITMAP;
            piVar.b = cd4.BITMAP;
            piVar.d = Integer.valueOf(allocationByteCount & Integer.MAX_VALUE);
            piVar.f = Integer.valueOf(height & Integer.MAX_VALUE);
            piVar.e = Integer.valueOf(width & Integer.MAX_VALUE);
            piVar.a = Long.valueOf(Long.MAX_VALUE & jElapsedRealtime3);
            piVar.g = 0;
            fd4 fd4Var = new fd4(piVar);
            b13 b13Var = new b13();
            b13Var.c = fd4Var;
            cu2 cu2Var = new cu2(b13Var);
            if (et4Var.c()) {
                strA = (String) et4Var.a();
            } else {
                strA = ab1.c.a(nk4Var.g);
            }
            aa4.a.execute(new wa0(nk4Var, cu2Var, strA));
            return k11Var;
        }
        long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
        pd4Var = pd4.INPUT_IMAGE_CONSTRUCTION;
        et4Var = nk4Var.e;
        jElapsedRealtime = SystemClock.elapsedRealtime();
        map = nk4Var.i;
        if (map.get(pd4Var) != null) {
            return k11Var;
        }
        map.put(pd4Var, Long.valueOf(jElapsedRealtime));
        pi piVar2 = new pi();
        piVar2.c = rc4.BITMAP;
        piVar2.b = cd4.BITMAP;
        piVar2.d = Integer.valueOf(allocationByteCount & Integer.MAX_VALUE);
        piVar2.f = Integer.valueOf(height & Integer.MAX_VALUE);
        piVar2.e = Integer.valueOf(width & Integer.MAX_VALUE);
        piVar2.a = Long.valueOf(Long.MAX_VALUE & jElapsedRealtime4);
        piVar2.g = 0;
        fd4 fd4Var2 = new fd4(piVar2);
        b13 b13Var2 = new b13();
        b13Var2.c = fd4Var2;
        cu2 cu2Var2 = new cu2(b13Var2);
        if (et4Var.c()) {
            strA = (String) et4Var.a();
        } else {
            strA = ab1.c.a(nk4Var.g);
        }
        aa4.a.execute(new wa0(nk4Var, cu2Var2, strA));
        return k11Var;
    }
}
