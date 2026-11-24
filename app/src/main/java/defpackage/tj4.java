package defpackage;

import android.os.SystemClock;
import com.ibm.icu.text.BreakIterator;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class tj4 implements Closeable {
    public static final HashMap i = new HashMap();
    public int a;
    public long b;
    public long c;
    public long e = 2147483647L;
    public long f = -2147483648L;

    public tj4(String str) {
    }

    public void c() {
        this.b = SystemClock.elapsedRealtimeNanos() / 1000;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.b;
        if (j != 0) {
            j(j);
        } else {
            og.n("Did you forget to call start()?");
        }
    }

    public void e(long j) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j2 = this.c;
        if (j2 != 0 && jElapsedRealtimeNanos - j2 >= 1000000) {
            this.a = 0;
            this.b = 0L;
            this.e = 2147483647L;
            this.f = -2147483648L;
        }
        this.c = jElapsedRealtimeNanos;
        this.a++;
        this.e = Math.min(this.e, j);
        this.f = Math.max(this.f, j);
        if (this.a % 50 == 0) {
            Locale locale = Locale.US;
            fl4.l();
        }
        if (this.a % BreakIterator.WORD_IDEO_LIMIT == 0) {
            this.a = 0;
            this.b = 0L;
            this.e = 2147483647L;
            this.f = -2147483648L;
        }
    }

    public void j(long j) {
        e((SystemClock.elapsedRealtimeNanos() / 1000) - j);
    }
}
