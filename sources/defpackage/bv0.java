package defpackage;

import android.app.role.RoleManager;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class bv0 {
    public static /* bridge */ /* synthetic */ RoleManager d(Object obj) {
        return (RoleManager) obj;
    }

    public static /* synthetic */ RenderNode f() {
        return new RenderNode("AndroidEdgeEffectOverscrollEffect");
    }

    public static /* synthetic */ FontFamily.Builder g(Font font) {
        return new FontFamily.Builder(font);
    }

    public static /* bridge */ /* synthetic */ Class h() {
        return RoleManager.class;
    }

    public static /* synthetic */ FontFamily.Builder x(Font font) {
        return new FontFamily.Builder(font);
    }
}
