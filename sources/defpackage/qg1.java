package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qg1 {
    public int a;
    public int b;
    public int c;
    public Object e;

    public qg1() {
        if (el1.n == null) {
            el1.n = new el1(20);
        }
    }

    public int a(int i) {
        if (i < this.c) {
            return ((ByteBuffer) this.e).getShort(this.b + i);
        }
        return 0;
    }

    public void b() {
        if (((rg1) this.e).k == this.c) {
            return;
        }
        og.d();
    }

    public void c() {
        while (true) {
            int i = this.a;
            rg1 rg1Var = (rg1) this.e;
            if (i >= rg1Var.i || rg1Var.c[i] >= 0) {
                return;
            } else {
                this.a = i + 1;
            }
        }
    }

    public boolean hasNext() {
        return this.a < ((rg1) this.e).i;
    }

    public void remove() {
        rg1 rg1Var = (rg1) this.e;
        b();
        if (this.b == -1) {
            og.n("Call next() before removing element from the iterator.");
            return;
        }
        rg1Var.c();
        rg1Var.k(this.b);
        this.b = -1;
        this.c = rg1Var.k;
    }
}
