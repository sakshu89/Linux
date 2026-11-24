package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gb4 {
    public static final su0 a = new su0(19);

    public static final void a(gw2 gw2Var, lw2 lw2Var, String str) {
        mw2 mw2Var = mw2.h;
        mw2.i.fine(lw2Var.b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + gw2Var.a);
    }

    public static final String b(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - 500000000) / 1000000000) + " s ";
        } else if (j <= -999500) {
            str = ((j - 500000) / 1000000) + " ms";
        } else if (j <= 0) {
            str = ((j - 500) / 1000) + " µs";
        } else if (j < 999500) {
            str = ((j + 500) / 1000) + " µs";
        } else if (j < 999500000) {
            str = ((j + 500000) / 1000000) + " ms";
        } else {
            str = ((j + 500000000) / 1000000000) + " s ";
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    public static final az c(b83 b83Var) {
        az azVar;
        b83Var.getClass();
        synchronized (a) {
            azVar = (az) b83Var.c("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
            if (azVar == null) {
                j70 j70Var = gi0.a;
                try {
                    xa0 xa0Var = ld0.a;
                    j70Var = ig1.a.i;
                } catch (IllegalStateException | no1 unused) {
                }
                az azVar2 = new az(j70Var.r(wa4.a()));
                b83Var.a("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", azVar2);
                azVar = azVar2;
            }
        }
        return azVar;
    }
}
