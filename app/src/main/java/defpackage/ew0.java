package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ew0 implements Iterable, x41 {
    public final String[] a;

    public ew0(String[] strArr) {
        this.a = strArr;
    }

    public final String a(String str) {
        str.getClass();
        String[] strArr = this.a;
        int length = strArr.length - 2;
        int iA = dy3.a(length, 0, -2);
        if (iA > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(strArr[length])) {
            if (length == iA) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final String b(int i) {
        return this.a[i * 2];
    }

    public final uf1 d() {
        uf1 uf1Var = new uf1(22);
        ArrayList arrayList = (ArrayList) uf1Var.b;
        arrayList.getClass();
        String[] strArr = this.a;
        strArr.getClass();
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        arrayList.addAll(listAsList);
        return uf1Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ew0) {
            return Arrays.equals(this.a, ((ew0) obj).a);
        }
        return false;
    }

    public final String f(int i) {
        return this.a[(i * 2) + 1];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        wt1[] wt1VarArr = new wt1[size];
        for (int i = 0; i < size; i++) {
            wt1VarArr[i] = new wt1(b(i), f(i));
        }
        return new e1(wt1VarArr);
    }

    public final int size() {
        return this.a.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strB = b(i);
            String strF = f(i);
            sb.append(strB);
            sb.append(": ");
            if (z53.q(strB)) {
                strF = "██";
            }
            sb.append(strF);
            sb.append("\n");
        }
        return sb.toString();
    }
}
