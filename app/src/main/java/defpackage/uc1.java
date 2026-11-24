package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uc1 implements wc1 {
    public ArrayList a;
    public ArrayList b;
    public final boolean c;
    public final AtomicInteger e;
    public final wp f = hg4.a(new uf1(27, this));
    public tp i;

    public uc1(ArrayList arrayList, boolean z, dd0 dd0Var) {
        this.a = arrayList;
        this.b = new ArrayList(arrayList.size());
        this.c = z;
        this.e = new AtomicInteger(arrayList.size());
        a(new o7(5, this), xg4.a());
        if (this.a.isEmpty()) {
            this.i.a(new ArrayList(this.b));
            return;
        }
        for (int i = 0; i < this.a.size(); i++) {
            this.b.add(null);
        }
        ArrayList arrayList2 = this.a;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            wc1 wc1Var = (wc1) arrayList2.get(i2);
            wc1Var.a(new ze(this, i2, wc1Var), dd0Var);
        }
    }

    @Override // defpackage.wc1
    public final void a(Runnable runnable, Executor executor) {
        this.f.b.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        ArrayList arrayList = this.a;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((wc1) obj).cancel(z);
            }
        }
        return this.f.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        ArrayList arrayList = this.a;
        if (arrayList != null && !isDone()) {
            int size = arrayList.size();
            int i = 0;
            loop0: while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                wc1 wc1Var = (wc1) obj;
                while (!wc1Var.isDone()) {
                    try {
                        wc1Var.get();
                    } catch (Error e) {
                        throw e;
                    } catch (InterruptedException e2) {
                        throw e2;
                    } catch (Throwable unused) {
                        if (this.c) {
                            return (List) this.f.b.get();
                        }
                    }
                }
            }
        }
        return (List) this.f.b.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f.b.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return (List) this.f.b.get(j, timeUnit);
    }
}
