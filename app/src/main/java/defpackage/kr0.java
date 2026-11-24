package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kr0 implements up {
    public final /* synthetic */ int a;
    public final /* synthetic */ ScheduledExecutorService b;
    public final /* synthetic */ long c;
    public final /* synthetic */ wc1 e;

    public /* synthetic */ kr0(wc1 wc1Var, ScheduledExecutorService scheduledExecutorService, long j, int i) {
        this.a = i;
        this.e = wc1Var;
        this.b = scheduledExecutorService;
        this.c = j;
    }

    @Override // defpackage.up
    public final Object d(final tp tpVar) {
        int i = this.a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        final long j = this.c;
        ScheduledExecutorService scheduledExecutorService = this.b;
        final wc1 wc1Var = this.e;
        final int i2 = 1;
        switch (i) {
            case 0:
                oz3.f(true, wc1Var, tpVar, xg4.a());
                if (!wc1Var.isDone()) {
                    final ScheduledFuture scheduledFutureSchedule = scheduledExecutorService.schedule(new Callable() { // from class: lr0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return Boolean.valueOf(tpVar.b(new TimeoutException("Future[" + wc1Var + "] is not done within " + j + " ms.")));
                        }
                    }, j, timeUnit);
                    final int i3 = 0;
                    wc1Var.a(new Runnable() { // from class: mr0
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i4 = i3;
                            ScheduledFuture scheduledFuture = scheduledFutureSchedule;
                            switch (i4) {
                                case 0:
                                    scheduledFuture.cancel(true);
                                    break;
                                default:
                                    scheduledFuture.cancel(true);
                                    break;
                            }
                        }
                    }, xg4.a());
                }
                return "TimeoutFuture[" + wc1Var + "]";
            default:
                wp wpVar = (wp) wc1Var;
                oz3.f(true, wpVar, tpVar, xg4.a());
                vp vpVar = wpVar.b;
                if (!vpVar.isDone()) {
                    final ScheduledFuture<?> scheduledFutureSchedule2 = scheduledExecutorService.schedule(new o8(18, tpVar, wpVar), j, timeUnit);
                    vpVar.a(new Runnable() { // from class: mr0
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i4 = i2;
                            ScheduledFuture scheduledFuture = scheduledFutureSchedule2;
                            switch (i4) {
                                case 0:
                                    scheduledFuture.cancel(true);
                                    break;
                                default:
                                    scheduledFuture.cancel(true);
                                    break;
                            }
                        }
                    }, xg4.a());
                }
                return "TimeoutFuture[" + wpVar + "]";
        }
    }
}
