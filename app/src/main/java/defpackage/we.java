package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class we {
    public int a;
    public Object b = new tw0[32];
    public Object c = new float[32];
    public Object d = new byte[32];
    public Object e;
    public Object f;

    public we() {
        hm1 hm1Var = za2.a;
        this.e = new hm1();
        this.f = new hm1();
    }

    public void a() {
        ve veVar = (ve) this.b;
        Drawable background = veVar.getBackground();
        if (background != null) {
            if (((z30) this.d) != null) {
                if (((z30) this.f) == null) {
                    this.f = new z30();
                }
                z30 z30Var = (z30) this.f;
                z30Var.c = null;
                z30Var.b = false;
                z30Var.d = null;
                z30Var.a = false;
                int i = u73.a;
                ColorStateList colorStateListB = o73.b(veVar);
                if (colorStateListB != null) {
                    z30Var.b = true;
                    z30Var.c = colorStateListB;
                }
                PorterDuff.Mode modeC = o73.c(veVar);
                if (modeC != null) {
                    z30Var.a = true;
                    z30Var.d = modeC;
                }
                if (z30Var.b || z30Var.a) {
                    xe.c(background, z30Var, veVar.getDrawableState());
                    return;
                }
            }
            z30 z30Var2 = (z30) this.e;
            if (z30Var2 != null) {
                xe.c(background, z30Var2, veVar.getDrawableState());
                return;
            }
            z30 z30Var3 = (z30) this.d;
            if (z30Var3 != null) {
                xe.c(background, z30Var3, veVar.getDrawableState());
            }
        }
    }

    public boolean b() {
        return this.a < ((List) this.d).size() || !((ArrayList) this.f).isEmpty();
    }

    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((z30) this.d) == null) {
                this.d = new z30();
            }
            z30 z30Var = (z30) this.d;
            z30Var.c = colorStateList;
            z30Var.b = true;
        } else {
            this.d = null;
        }
        a();
    }
}
