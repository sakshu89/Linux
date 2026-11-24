package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jg implements Iterator, x41 {
    public int a;
    public int b;
    public boolean c;
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jg(ng ngVar, int i) {
        this(ngVar.c);
        this.e = i;
        switch (i) {
            case 1:
                this.f = ngVar;
                this(ngVar.c);
                break;
            default:
                this.f = ngVar;
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objE;
        if (!hasNext()) {
            dk0.d();
            return null;
        }
        int i = this.b;
        int i2 = this.e;
        Object obj = this.f;
        switch (i2) {
            case 0:
                objE = ((ng) obj).e(i);
                break;
            case 1:
                objE = ((ng) obj).h(i);
                break;
            default:
                objE = ((pg) obj).b[i];
                break;
        }
        this.b++;
        this.c = true;
        return objE;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.c) {
            og.n("Call next() before removing an element.");
            return;
        }
        int i = this.b - 1;
        this.b = i;
        int i2 = this.e;
        Object obj = this.f;
        switch (i2) {
            case 0:
                ((ng) obj).f(i);
                break;
            case 1:
                ((ng) obj).f(i);
                break;
            default:
                ((pg) obj).a(i);
                break;
        }
        this.a--;
        this.c = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jg(pg pgVar) {
        this(pgVar.c);
        this.e = 2;
        this.f = pgVar;
    }

    public jg(int i) {
        this.a = i;
    }
}
