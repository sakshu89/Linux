package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g11 {
    public final /* synthetic */ int a;
    public final tw0 b;
    public final tw0 c;
    public final tw0 d;
    public final tw0 e;
    public final Serializable f;

    /* JADX WARN: Multi-variable type inference failed */
    public g11(g11[] g11VarArr) {
        int i = 0;
        this.a = 0;
        this.f = g11VarArr;
        int length = g11VarArr.length;
        tw0[] tw0VarArr = new tw0[length];
        for (int i2 = 0; i2 < length; i2++) {
            tw0VarArr[i2] = ((g11[]) this.f)[i2].b();
        }
        int i3 = 1;
        this.b = new tw0(1, new k73(tw0VarArr, i));
        int length2 = ((g11[]) this.f).length;
        tw0[] tw0VarArr2 = new tw0[length2];
        for (int i4 = 0; i4 < length2; i4++) {
            tw0VarArr2[i4] = ((g11[]) this.f)[i4].d();
        }
        this.c = new tw0(0, new sw0(tw0VarArr2, i));
        int length3 = ((g11[]) this.f).length;
        tw0[] tw0VarArr3 = new tw0[length3];
        for (int i5 = 0; i5 < length3; i5++) {
            tw0VarArr3[i5] = ((g11[]) this.f)[i5].c();
        }
        this.d = new tw0(1, new k73(tw0VarArr3, i3));
        int length4 = ((g11[]) this.f).length;
        tw0[] tw0VarArr4 = new tw0[length4];
        for (int i6 = 0; i6 < length4; i6++) {
            tw0VarArr4[i6] = ((g11[]) this.f)[i6].a();
        }
        this.e = new tw0(0, new sw0(tw0VarArr4, i3));
    }

    public final tw0 a() {
        int i = this.a;
        return this.e;
    }

    public final tw0 b() {
        int i = this.a;
        return this.b;
    }

    public final tw0 c() {
        int i = this.a;
        return this.d;
    }

    public final tw0 d() {
        int i = this.a;
        return this.c;
    }

    public final String toString() {
        int i = this.a;
        Object obj = this.f;
        switch (i) {
            case 0:
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) "innermostOf(");
                int i2 = 0;
                for (g11 g11Var : (g11[]) obj) {
                    i2++;
                    if (i2 > 1) {
                        sb.append((CharSequence) ", ");
                    }
                    ds2.a(sb, g11Var, null);
                }
                sb.append((CharSequence) ")");
                return sb.toString();
            default:
                return "RectRulers(" + ((String) obj) + ')';
        }
    }

    public g11(String str) {
        this.a = 1;
        this.f = str;
        this.b = new tw0(1, null);
        this.c = new tw0(0, null);
        this.d = new tw0(1, null);
        this.e = new tw0(0, null);
    }
}
