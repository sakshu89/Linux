package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zd implements Appendable {
    public final StringBuilder a = new StringBuilder(16);
    public final ArrayList b;

    public zd(be beVar) {
        new ArrayList();
        this.b = new ArrayList();
        new ArrayList();
        a(beVar);
    }

    public final void a(be beVar) {
        StringBuilder sb = this.a;
        int length = sb.length();
        sb.append(beVar.b);
        List list = beVar.a;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ae aeVar = (ae) list.get(i);
                this.b.add(new yd(aeVar.a, aeVar.b + length, aeVar.c + length, aeVar.d));
            }
        }
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i2) {
        boolean z = charSequence instanceof be;
        StringBuilder sb = this.a;
        if (!z) {
            sb.append(charSequence, i, i2);
            return this;
        }
        be beVar = (be) charSequence;
        int length = sb.length();
        sb.append((CharSequence) beVar.b, i, i2);
        List listA = ce.a(beVar, i, i2, null);
        if (listA != null) {
            int size = listA.size();
            for (int i3 = 0; i3 < size; i3++) {
                ae aeVar = (ae) listA.get(i3);
                this.b.add(new yd(aeVar.a, aeVar.b + length, aeVar.c + length, aeVar.d));
            }
        }
        return this;
    }

    public final be b() {
        StringBuilder sb = this.a;
        String string = sb.toString();
        ArrayList arrayList = this.b;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            yd ydVar = (yd) arrayList.get(i);
            int length = sb.length();
            int i2 = ydVar.c;
            if (i2 != Integer.MIN_VALUE) {
                length = i2;
            }
            if (length == Integer.MIN_VALUE) {
                a11.b("Item.end should be set first");
            }
            arrayList2.add(new ae(ydVar.a, ydVar.b, length, ydVar.d));
        }
        return new be(string, arrayList2);
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence instanceof be) {
            a((be) charSequence);
            return this;
        }
        this.a.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        this.a.append(c);
        return this;
    }
}
