package defpackage;

import android.content.Context;
import android.provider.Settings;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nm {
    public final Context a;
    public final zv1 b;
    public volatile int c;

    public nm(Context context, zv1 zv1Var) {
        zv1Var.getClass();
        this.a = context;
        this.b = zv1Var;
        this.c = 255;
    }

    public final Integer a() {
        Integer numB = b();
        if (numB != null) {
            return Integer.valueOf(ky3.c(hh1.f((numB.intValue() * 100.0f) / this.c), 0, 100));
        }
        return null;
    }

    public final Integer b() {
        try {
            int i = Settings.System.getInt(this.a.getContentResolver(), "screen_brightness");
            if (i > this.c) {
                for (Object obj : zg2.c(255, new j(8))) {
                    if (((Number) obj).intValue() >= i) {
                        this.c = ((Number) obj).intValue();
                    }
                }
                throw new NoSuchElementException("Sequence contains no element matching the predicate.");
            }
            return Integer.valueOf(i);
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }
}
