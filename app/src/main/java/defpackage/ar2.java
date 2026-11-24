package defpackage;

import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ar2 {
    public final float[] a = new float[145];
    public final float[] b = new float[145];
    public final float[] c = new float[145];
    public final float[] d = new float[145];
    public final float[] e = new float[145];

    public ar2() {
        Random random = new Random(357812816195L);
        for (int i = 0; i < 145; i++) {
            this.a[i] = random.nextFloat();
            this.b[i] = random.nextFloat() * 0.97f;
            this.c[i] = (random.nextFloat() * 1.1f) + 0.55f;
            this.d[i] = (random.nextFloat() * 0.31f) + 0.08f;
            this.e[i] = (random.nextFloat() * 0.45f) + 0.32f;
        }
    }
}
