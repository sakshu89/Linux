package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ne implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ne(Object obj, int i, int i2) {
        this.a = i2;
        this.c = obj;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ((IntConsumer) this.c).accept(this.b);
                return;
            case 1:
                ((es) this.c).a(this.b);
                return;
            default:
                LinkedHashSet<bv2> linkedHashSet = (LinkedHashSet) this.c;
                int i = this.b;
                for (bv2 bv2Var : linkedHashSet) {
                    if (i == 5) {
                        synchronized (bv2Var.p) {
                            try {
                                if (bv2Var.m() && bv2Var.q != null) {
                                    bv2.l();
                                    ArrayList arrayList = bv2Var.q;
                                    int size = arrayList.size();
                                    int i2 = 0;
                                    while (i2 < size) {
                                        Object obj = arrayList.get(i2);
                                        i2++;
                                        ((ob0) obj).a();
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        bv2Var.getClass();
                    }
                }
                return;
        }
    }
}
