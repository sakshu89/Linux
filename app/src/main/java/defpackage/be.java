package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class be implements CharSequence {
    public final List a;
    public final String b;
    public final ArrayList c;
    public final ArrayList e;

    static {
        q91 q91Var = wa2.a;
    }

    public be(List list, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.a = list;
        this.b = str;
        if (list != null) {
            int size = list.size();
            arrayList = null;
            arrayList2 = null;
            for (int i = 0; i < size; i++) {
                ae aeVar = (ae) list.get(i);
                Object obj = aeVar.a;
                if (obj instanceof hp2) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aeVar);
                } else if (obj instanceof eu1) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aeVar);
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        this.c = arrayList;
        this.e = arrayList2;
        List listK = arrayList2 != null ? mz.K(arrayList2, new lo0(8)) : null;
        if (listK == null || listK.isEmpty()) {
            return;
        }
        int i2 = ((ae) mz.x(listK)).c;
        ll1 ll1Var = b21.a;
        ll1 ll1Var2 = new ll1(1);
        ll1Var2.a(i2);
        int size2 = listK.size();
        for (int i3 = 1; i3 < size2; i3++) {
            ae aeVar2 = (ae) listK.get(i3);
            while (ll1Var2.b != 0) {
                int iD = ll1Var2.d();
                int i4 = aeVar2.b;
                int i5 = aeVar2.c;
                if (i4 < iD) {
                    if (i5 > iD) {
                        a11.a("Paragraph overlap not allowed, end " + i5 + " should be less than or equal to " + iD);
                        break;
                    }
                    break;
                }
                ll1Var2.e(ll1Var2.b - 1);
            }
            ll1Var2.a(aeVar2.c);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0099  */
    @Override // java.lang.CharSequence
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final be subSequence(int i, int i2) {
        ArrayList arrayList;
        if (!(i <= i2)) {
            a11.a("start (" + i + ") should be less or equal to end (" + i2 + ')');
        }
        String str = this.b;
        if (i == 0 && i2 == str.length()) {
            return this;
        }
        String strSubstring = str.substring(i, i2);
        be beVar = ce.a;
        if (i > i2) {
            a11.a("start (" + i + ") should be less than or equal to end (" + i2 + ')');
        }
        List list = this.a;
        if (list == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ae aeVar = (ae) list.get(i3);
                int i4 = aeVar.b;
                int i5 = aeVar.c;
                if (ce.b(i, i2, i4, i5)) {
                    arrayList.add(new ae(aeVar.a, Math.max(i, aeVar.b) - i, Math.min(i2, i5) - i, aeVar.d));
                }
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
        }
        return new be(arrayList, strSubstring);
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.b.charAt(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof be)) {
            return false;
        }
        be beVar = (be) obj;
        return g31.a(this.b, beVar.b) && g31.a(this.a, beVar.a);
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        List list = this.a;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.b.length();
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.b;
    }

    public /* synthetic */ be(String str) {
        this(str, ii0.a);
    }

    public be(String str, List list) {
        this(list.isEmpty() ? null : list, str);
    }
}
