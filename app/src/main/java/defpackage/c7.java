package defpackage;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c7 implements Runnable {
    public final /* synthetic */ int a;

    public /* synthetic */ c7(ye yeVar, int i) {
        this.a = 2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                yl1 yl1Var = r7.v1;
                synchronized (yl1Var) {
                    try {
                        int i = Build.VERSION.SDK_INT;
                        Object[] objArr = yl1Var.a;
                        int i2 = yl1Var.b;
                        int i3 = 0;
                        if (i < 30) {
                            while (i3 < i2) {
                                r7 r7Var = (r7) objArr[i3];
                                boolean showLayoutBounds = r7Var.getShowLayoutBounds();
                                Class cls = r7.s1;
                                r7Var.setShowLayoutBounds(lc4.a());
                                if (showLayoutBounds != r7Var.getShowLayoutBounds()) {
                                    r7.i(r7Var.getRoot());
                                }
                                i3++;
                            }
                        } else {
                            while (i3 < i2) {
                                r7.i(((r7) objArr[i3]).getRoot());
                                i3++;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
            case 2:
                return;
            case 3:
                throw null;
            case 4:
            default:
                return;
        }
    }

    public /* synthetic */ c7(int i) {
        this.a = i;
    }

    public /* synthetic */ c7(oj ojVar) {
        this.a = 5;
    }

    public /* synthetic */ c7(oj ojVar, Object obj, int i) {
        this.a = i;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void c() {
    }

    private final void d() {
    }
}
