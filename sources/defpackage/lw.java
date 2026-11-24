package defpackage;

import android.util.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lw {
    public static final bi i = new bi("camerax.core.captureConfig.rotation", Integer.TYPE, null);
    public static final bi j = new bi("camerax.core.captureConfig.jpegQuality", Integer.class, null);
    public static final bi k = new bi("camerax.core.captureConfig.resolvedFrameRate", Range.class, null);
    public final ArrayList a;
    public final gs1 b;
    public final int c;
    public final boolean d;
    public final List e;
    public final boolean f;
    public final iv2 g;
    public final ls h;

    public lw(ArrayList arrayList, gs1 gs1Var, int i2, boolean z, ArrayList arrayList2, boolean z2, iv2 iv2Var, ls lsVar) {
        this.a = arrayList;
        this.b = gs1Var;
        this.c = i2;
        this.e = Collections.unmodifiableList(arrayList2);
        this.f = z2;
        this.g = iv2Var;
        this.h = lsVar;
        this.d = z;
    }

    public final int a() {
        Object obj = this.g.a.get("CAPTURE_CONFIG_ID_KEY");
        if (obj == null) {
            return -1;
        }
        return ((Integer) obj).intValue();
    }

    public final int b() {
        Object objF = 0;
        try {
            objF = this.b.f(r53.a0);
        } catch (IllegalArgumentException unused) {
        }
        Integer num = (Integer) objF;
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public final int c() {
        Object objF = 0;
        try {
            objF = this.b.f(r53.b0);
        } catch (IllegalArgumentException unused) {
        }
        Integer num = (Integer) objF;
        Objects.requireNonNull(num);
        return num.intValue();
    }
}
