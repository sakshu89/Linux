package defpackage;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s81 implements Comparator {
    public final /* synthetic */ int a;
    public final /* synthetic */ t9 b;

    public /* synthetic */ s81(t9 t9Var, int i) {
        this.a = i;
        this.b = t9Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.a;
        t9 t9Var = this.b;
        switch (i) {
            case 0:
                return si4.a(Integer.valueOf(t9Var.c(((y91) obj).g)), Integer.valueOf(t9Var.c(((y91) obj2).g)));
            case 1:
                return si4.a(Integer.valueOf(t9Var.c(((y91) obj).g)), Integer.valueOf(t9Var.c(((y91) obj2).g)));
            case 2:
                return si4.a(Integer.valueOf(t9Var.c(((y91) obj2).g)), Integer.valueOf(t9Var.c(((y91) obj).g)));
            default:
                return si4.a(Integer.valueOf(t9Var.c(((y91) obj2).g)), Integer.valueOf(t9Var.c(((y91) obj).g)));
        }
    }
}
