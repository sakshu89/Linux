package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z30 {
    public boolean a;
    public boolean b;
    public Object c;
    public Serializable d;

    public z30(int i) {
        switch (i) {
            case 1:
                this.d = "";
                break;
            default:
                this.a = true;
                break;
        }
    }

    public a40 a() {
        return new a40(this.a, this.b, (String[]) this.c, (String[]) this.d);
    }

    public void b(xx... xxVarArr) {
        if (!this.a) {
            og.i("no cipher suites for cleartext connections");
            return;
        }
        ArrayList arrayList = new ArrayList(xxVarArr.length);
        for (xx xxVar : xxVarArr) {
            arrayList.add(xxVar.a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        c((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void c(String... strArr) {
        if (!this.a) {
            og.i("no cipher suites for cleartext connections");
        } else if (strArr.length != 0) {
            this.c = (String[]) strArr.clone();
        } else {
            og.i("At least one cipher suite is required");
        }
    }

    public boolean d() {
        if (this.a || !if4.b((String) this.d)) {
            return false;
        }
        this.a = true;
        return true;
    }

    public void e(c13... c13VarArr) {
        if (!this.a) {
            og.i("no TLS versions for cleartext connections");
            return;
        }
        ArrayList arrayList = new ArrayList(c13VarArr.length);
        for (c13 c13Var : c13VarArr) {
            arrayList.add(c13Var.a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        f((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Serializable, java.lang.String[]] */
    public void f(String... strArr) {
        if (!this.a) {
            og.i("no TLS versions for cleartext connections");
        } else if (strArr.length != 0) {
            this.d = (String[]) strArr.clone();
        } else {
            og.i("At least one TLS version is required");
        }
    }
}
