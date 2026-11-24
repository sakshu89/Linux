package defpackage;

import android.graphics.Typeface;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ze implements Runnable {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public ze(uc1 uc1Var, int i, wc1 wc1Var) {
        this.e = uc1Var;
        this.b = i;
        this.c = wc1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        tp tpVar;
        ArrayList arrayList2;
        int i = this.a;
        Object obj = this.c;
        int i2 = this.b;
        Object obj2 = this.e;
        switch (i) {
            case 0:
                ((TextView) obj).setTypeface((Typeface) obj2, i2);
                return;
            default:
                uc1 uc1Var = (uc1) obj2;
                wc1 wc1Var = (wc1) obj;
                boolean z = uc1Var.c;
                AtomicInteger atomicInteger = uc1Var.e;
                ArrayList arrayList3 = uc1Var.b;
                if (uc1Var.isDone() || arrayList3 == null) {
                    hh1.e("Future was done before all dependencies completed", z);
                    return;
                }
                try {
                    hh1.e("Tried to set value from future which is not done", wc1Var.isDone());
                    arrayList3.set(i2, oz3.c(wc1Var));
                    int iDecrementAndGet = atomicInteger.decrementAndGet();
                    hh1.e("Less than 0 remaining futures", iDecrementAndGet >= 0);
                    if (iDecrementAndGet == 0) {
                        if (arrayList != null) {
                            tpVar = uc1Var.i;
                            arrayList2 = new ArrayList(arrayList);
                            tpVar.a(arrayList2);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (ExecutionException e) {
                    if (z) {
                        uc1Var.i.b(e.getCause());
                    }
                    int iDecrementAndGet2 = atomicInteger.decrementAndGet();
                    hh1.e("Less than 0 remaining futures", iDecrementAndGet2 >= 0);
                    if (iDecrementAndGet2 == 0) {
                        if (arrayList != null) {
                            tpVar = uc1Var.i;
                            arrayList2 = new ArrayList(arrayList);
                        }
                        return;
                    }
                    return;
                } catch (CancellationException unused) {
                    if (z) {
                        uc1Var.cancel(false);
                    }
                    int iDecrementAndGet3 = atomicInteger.decrementAndGet();
                    hh1.e("Less than 0 remaining futures", iDecrementAndGet3 >= 0);
                    if (iDecrementAndGet3 == 0) {
                        if (arrayList != null) {
                            tpVar = uc1Var.i;
                            arrayList2 = new ArrayList(arrayList);
                        }
                        return;
                    }
                    return;
                } catch (Error e2) {
                    uc1Var.i.b(e2);
                    int iDecrementAndGet4 = atomicInteger.decrementAndGet();
                    hh1.e("Less than 0 remaining futures", iDecrementAndGet4 >= 0);
                    if (iDecrementAndGet4 == 0) {
                        if (arrayList != null) {
                            tpVar = uc1Var.i;
                            arrayList2 = new ArrayList(arrayList);
                        }
                        return;
                    }
                    return;
                } catch (RuntimeException e3) {
                    if (z) {
                        uc1Var.i.b(e3);
                    }
                    int iDecrementAndGet5 = atomicInteger.decrementAndGet();
                    hh1.e("Less than 0 remaining futures", iDecrementAndGet5 >= 0);
                    if (iDecrementAndGet5 == 0) {
                        if (arrayList != null) {
                            tpVar = uc1Var.i;
                            arrayList2 = new ArrayList(arrayList);
                        }
                        return;
                    }
                    return;
                } finally {
                    int iDecrementAndGet6 = atomicInteger.decrementAndGet();
                    hh1.e("Less than 0 remaining futures", iDecrementAndGet6 >= 0);
                    if (iDecrementAndGet6 == 0) {
                        arrayList = uc1Var.b;
                        if (arrayList != null) {
                            uc1Var.i.a(new ArrayList(arrayList));
                        } else {
                            hh1.e(null, uc1Var.isDone());
                        }
                    }
                }
        }
    }

    public ze(TextView textView, Typeface typeface, int i) {
        this.c = textView;
        this.e = typeface;
        this.b = i;
    }
}
