package defpackage;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aa4 implements Executor {
    public static final aa4 a;
    public static final /* synthetic */ aa4[] b;

    static {
        aa4 aa4Var = new aa4("INSTANCE", 0);
        a = aa4Var;
        b = new aa4[]{aa4Var};
    }

    public static aa4[] values() {
        return (aa4[]) b.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        ((we3) uf1.q().b).post(runnable);
    }
}
