package defpackage;

import android.os.SystemClock;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gu {
    public int a;
    public long b;
    public final Object c;

    public gu(long j, Exception exc) {
        this.b = SystemClock.elapsedRealtime() - j;
        if (exc instanceof xu) {
            this.a = 2;
            this.c = exc;
            return;
        }
        if (!(exc instanceof v01)) {
            this.a = 0;
            this.c = exc;
            return;
        }
        Throwable cause = exc.getCause();
        exc = cause != null ? cause : exc;
        this.c = exc;
        if (exc instanceof su) {
            this.a = 2;
        } else if (exc instanceof IllegalArgumentException) {
            this.a = 1;
        } else {
            this.a = 0;
        }
    }

    public void a(be1 be1Var) {
        dd1 dd1Var;
        if (be1Var.c || (dd1Var = be1Var.a) == dd1.e) {
            this.b = Long.MAX_VALUE;
            return;
        }
        long j = 30000;
        if (be1Var.b >= 30000) {
            this.a = 0;
        }
        int i = this.a + 1;
        if (i > 6) {
            i = 6;
        }
        this.a = i;
        int iOrdinal = dd1Var.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            j = 60000;
        } else {
            long j2 = 1000 << (this.a - 1);
            if (j2 <= 30000) {
                j = j2;
            }
        }
        this.b = ((Number) ((fq0) this.c).a()).longValue() + j;
    }

    public gu() {
        this.c = new e4(22);
    }

    public gu(int i, URL url, long j) {
        this.a = i;
        this.c = url;
        this.b = j;
    }
}
