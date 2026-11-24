package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class w1 implements wc1 {
    public static final boolean e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger f = Logger.getLogger(w1.class.getName());
    public static final bc4 i;
    public static final Object j;
    public volatile Object a;
    public volatile s1 b;
    public volatile v1 c;

    static {
        bc4 u1Var;
        try {
            u1Var = new t1(AtomicReferenceFieldUpdater.newUpdater(v1.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(v1.class, v1.class, "b"), AtomicReferenceFieldUpdater.newUpdater(w1.class, v1.class, "c"), AtomicReferenceFieldUpdater.newUpdater(w1.class, s1.class, "b"), AtomicReferenceFieldUpdater.newUpdater(w1.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            u1Var = new u1();
        }
        i = u1Var;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        j = new Object();
    }

    public static void c(w1 w1Var) {
        v1 v1Var;
        s1 s1Var;
        s1 s1Var2;
        s1 s1Var3;
        do {
            v1Var = w1Var.c;
        } while (!i.c(w1Var, v1Var, v1.c));
        while (true) {
            s1Var = null;
            if (v1Var == null) {
                break;
            }
            Thread thread = v1Var.a;
            if (thread != null) {
                v1Var.a = null;
                LockSupport.unpark(thread);
            }
            v1Var = v1Var.b;
        }
        do {
            s1Var2 = w1Var.b;
        } while (!i.a(w1Var, s1Var2, s1.d));
        while (true) {
            s1Var3 = s1Var;
            s1Var = s1Var2;
            if (s1Var == null) {
                break;
            }
            s1Var2 = s1Var.c;
            s1Var.c = s1Var3;
        }
        while (s1Var3 != null) {
            s1 s1Var4 = s1Var3.c;
            d(s1Var3.a, s1Var3.b);
            s1Var3 = s1Var4;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof p1) {
            Throwable th = ((p1) obj).a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof r1) {
            throw new ExecutionException(((r1) obj).a);
        }
        if (obj == j) {
            return null;
        }
        return obj;
    }

    public static Object f(w1 w1Var) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = w1Var.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override // defpackage.wc1
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        s1 s1Var = this.b;
        s1 s1Var2 = s1.d;
        if (s1Var != s1Var2) {
            s1 s1Var3 = new s1(runnable, executor);
            do {
                s1Var3.c = s1Var;
                if (i.a(this, s1Var, s1Var3)) {
                    return;
                } else {
                    s1Var = this.b;
                }
            } while (s1Var != s1Var2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        try {
            Object objF = f(this);
            sb.append("SUCCESS, result=[");
            sb.append(objF == this ? "this future" : String.valueOf(objF));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        p1 p1Var;
        Object obj = this.a;
        if (obj != null) {
            return false;
        }
        if (e) {
            p1Var = new p1(new CancellationException("Future.cancel() was called."), z);
        } else {
            p1Var = z ? p1.b : p1.c;
        }
        if (!i.b(this, obj, p1Var)) {
            return false;
        }
        c(this);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String g() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        v1 v1Var = v1.c;
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if (obj != null) {
            return e(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            v1 v1Var2 = this.c;
            if (v1Var2 != v1Var) {
                v1 v1Var3 = new v1();
                while (true) {
                    bc4 bc4Var = i;
                    bc4Var.g(v1Var3, v1Var2);
                    if (bc4Var.c(this, v1Var2, v1Var3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(v1Var3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if (obj2 != null) {
                                return e(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        h(v1Var3);
                        break;
                    }
                    v1Var2 = this.c;
                    if (v1Var2 == v1Var) {
                    }
                }
            }
            return e(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if (obj3 != null) {
                return e(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strConcat = "Waited " + j2 + Padder.FALLBACK_PADDING_STRING + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strConcat2 = strConcat.concat(" (plus ");
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strConcat3 = strConcat2 + jConvert + Padder.FALLBACK_PADDING_STRING + lowerCase;
                if (z) {
                    strConcat3 = strConcat3.concat(",");
                }
                strConcat2 = strConcat3.concat(Padder.FALLBACK_PADDING_STRING);
            }
            if (z) {
                strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
            }
            strConcat = strConcat2.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(cq.k(strConcat, " for ", string));
    }

    public final void h(v1 v1Var) {
        v1Var.a = null;
        while (true) {
            v1 v1Var2 = this.c;
            if (v1Var2 == v1.c) {
                return;
            }
            v1 v1Var3 = null;
            while (v1Var2 != null) {
                v1 v1Var4 = v1Var2.b;
                if (v1Var2.a != null) {
                    v1Var3 = v1Var2;
                } else if (v1Var3 != null) {
                    v1Var3.b = v1Var4;
                    if (v1Var3.a == null) {
                    }
                } else if (!i.c(this, v1Var2, v1Var4)) {
                }
                v1Var2 = v1Var4;
            }
            return;
        }
    }

    public boolean i(Throwable th) {
        th.getClass();
        if (!i.b(this, null, new r1(th))) {
            return false;
        }
        c(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a instanceof p1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.a != null;
    }

    public final String toString() {
        String strG;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.a instanceof p1) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                strG = g();
            } catch (RuntimeException e2) {
                strG = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strG != null && !strG.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strG);
                sb.append("]");
            } else if (isDone()) {
                b(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        v1 v1Var = v1.c;
        if (!Thread.interrupted()) {
            Object obj2 = this.a;
            if (obj2 != null) {
                return e(obj2);
            }
            v1 v1Var2 = this.c;
            if (v1Var2 != v1Var) {
                v1 v1Var3 = new v1();
                do {
                    bc4 bc4Var = i;
                    bc4Var.g(v1Var3, v1Var2);
                    if (bc4Var.c(this, v1Var2, v1Var3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.a;
                            } else {
                                h(v1Var3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return e(obj);
                    }
                    v1Var2 = this.c;
                } while (v1Var2 != v1Var);
            }
            return e(this.a);
        }
        throw new InterruptedException();
    }
}
