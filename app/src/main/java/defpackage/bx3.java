package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bx3 {
    public Boolean a;
    public boolean b;
    public final /* synthetic */ a c;
    public final int d;
    public final Bundle e;
    public final /* synthetic */ a f;

    public bx3(a aVar, int i, Bundle bundle) {
        this.f = aVar;
        Boolean bool = Boolean.TRUE;
        this.c = aVar;
        this.a = bool;
        this.b = false;
        this.d = i;
        this.e = bundle;
    }

    public abstract void a(x30 x30Var);

    public abstract boolean b();

    public final void c() {
        synchronized (this) {
            this.a = null;
        }
        synchronized (this.c.k) {
            this.c.k.remove(this);
        }
    }
}
