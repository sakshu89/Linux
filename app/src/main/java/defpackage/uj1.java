package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uj1 extends Exception {
    public final int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uj1(String str, Exception exc) {
        super(str, exc);
        jg1.c(str, "Provided message must not be empty.");
        this.a = 13;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uj1(String str, int i) {
        super(str);
        jg1.c(str, "Provided message must not be empty.");
        this.a = i;
    }
}
