package defpackage;

import android.view.RenderNode;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class t52 {
    public static int a(RenderNode renderNode) {
        return renderNode.getAmbientShadowColor();
    }

    public static int b(RenderNode renderNode) {
        return renderNode.getSpotShadowColor();
    }

    public static void c(RenderNode renderNode, int i) {
        renderNode.setAmbientShadowColor(i);
    }

    public static void d(RenderNode renderNode, int i) {
        renderNode.setSpotShadowColor(i);
    }
}
