package defpackage;

import android.os.Bundle;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ma2 {
    public final na2 a;
    public final kb b;
    public boolean e;
    public Bundle f;
    public boolean g;
    public final ak1 c = new ak1(19);
    public final LinkedHashMap d = new LinkedHashMap();
    public boolean h = true;

    public ma2(na2 na2Var, kb kbVar) {
        this.a = na2Var;
        this.b = kbVar;
    }

    public final void a() {
        na2 na2Var = this.a;
        if (na2Var.f().d != eb1.b) {
            og.n("Restarter must be created only during owner's initialization stage");
        } else {
            if (this.e) {
                og.n("SavedStateRegistry was already attached.");
                return;
            }
            this.b.a();
            na2Var.f().a(new h10(2, this));
            this.e = true;
        }
    }
}
