package androidx.camera.camera2.internal.compat.quirk;

import defpackage.h22;
import defpackage.ys;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TorchFlashRequiredFor3aUpdateQuirk implements h22 {
    public static final List b = Arrays.asList("PIXEL 6A", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7A", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO");
    public final ys a;

    public TorchFlashRequiredFor3aUpdateQuirk(ys ysVar) {
        this.a = ysVar;
    }
}
