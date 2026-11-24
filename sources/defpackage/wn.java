package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wn {
    public static final nx a = new nx(-1, null, null, 0);
    public static final int b = ab4.c(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");
    public static final int c = ab4.c(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");
    public static final py0 d;
    public static final py0 e;
    public static final py0 f;
    public static final py0 g;
    public static final py0 h;
    public static final py0 i;
    public static final py0 j;
    public static final py0 k;
    public static final py0 l;
    public static final py0 m;
    public static final py0 n;
    public static final py0 o;
    public static final py0 p;
    public static final py0 q;
    public static final py0 r;
    public static final py0 s;

    static {
        int i2 = 16;
        d = new py0(i2, "BUFFERED");
        e = new py0(i2, "SHOULD_BUFFER");
        f = new py0(i2, "S_RESUMING_BY_RCV");
        g = new py0(i2, "RESUMING_BY_EB");
        h = new py0(i2, "POISONED");
        i = new py0(i2, "DONE_RCV");
        j = new py0(i2, "INTERRUPTED_SEND");
        k = new py0(i2, "INTERRUPTED_RCV");
        l = new py0(i2, "CHANNEL_CLOSED");
        m = new py0(i2, "SUSPEND");
        n = new py0(i2, "SUSPEND_NO_WAITER");
        o = new py0(i2, "FAILED");
        p = new py0(i2, "NO_RECEIVE_RESULT");
        q = new py0(i2, "CLOSE_HANDLER_CLOSED");
        r = new py0(i2, "CLOSE_HANDLER_INVOKED");
        s = new py0(i2, "NO_CLOSE_CAUSE");
    }

    public static final boolean a(wv wvVar, Object obj, wq0 wq0Var) {
        py0 py0VarK = wvVar.k(obj, wq0Var);
        if (py0VarK == null) {
            return false;
        }
        wvVar.u(py0VarK);
        return true;
    }
}
