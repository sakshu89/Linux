package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gb1 implements nb1, cs {
    public final ob1 b;
    public final wu c;
    public final Object a = new Object();
    public boolean e = false;

    public gb1(ob1 ob1Var, wu wuVar) {
        this.b = ob1Var;
        this.c = wuVar;
        if (ob1Var.f().d.compareTo(eb1.e) >= 0) {
            wuVar.j();
        } else {
            wuVar.r();
        }
        ob1Var.f().a(this);
    }

    @Override // defpackage.cs
    public final ut a() {
        return this.c.H;
    }

    public final List c() {
        List listUnmodifiableList;
        synchronized (this.a) {
            listUnmodifiableList = Collections.unmodifiableList(this.c.v());
        }
        return listUnmodifiableList;
    }

    public final void m() {
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                onStop(this.b);
                this.e = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o() {
        synchronized (this.a) {
            try {
                if (this.e) {
                    this.e = false;
                    if (this.b.f().d.compareTo(eb1.e) >= 0) {
                        onStart(this.b);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @hq1(db1.ON_DESTROY)
    public void onDestroy(ob1 ob1Var) {
        synchronized (this.a) {
            wu wuVar = this.c;
            wuVar.y((ArrayList) wuVar.v());
        }
    }

    @hq1(db1.ON_PAUSE)
    public void onPause(ob1 ob1Var) {
        this.c.a.b(false);
    }

    @hq1(db1.ON_RESUME)
    public void onResume(ob1 ob1Var) {
        this.c.a.b(true);
    }

    @hq1(db1.ON_START)
    public void onStart(ob1 ob1Var) {
        synchronized (this.a) {
            try {
                if (!this.e) {
                    this.c.j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @hq1(db1.ON_STOP)
    public void onStop(ob1 ob1Var) {
        synchronized (this.a) {
            try {
                if (!this.e) {
                    this.c.r();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
