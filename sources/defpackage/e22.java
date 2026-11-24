package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e22 extends IOException {
    public final int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e22(int i, String str) {
        super("HTTP " + i + ": " + str);
        str.getClass();
        this.a = i;
    }
}
