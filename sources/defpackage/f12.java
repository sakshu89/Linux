package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ImageReader;
import android.util.Size;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f12 {
    public final Executor a;
    public yi b;
    public nr4 c;
    public uf1 d;
    public el1 e;
    public el1 f;
    public ak1 g;
    public fl4 h;
    public y74 i;
    public nr4 j;
    public final cq0 k;
    public final boolean l;

    public f12(Executor executor) {
        cq0 cq0Var = uc0.a;
        if (uc0.a.d(LowMemoryQuirk.class) != null) {
            this.a = new ch2(executor);
        } else {
            this.a = executor;
        }
        this.k = cq0Var;
        this.l = cq0Var.c(IncorrectJpegMetadataQuirk.class);
    }

    public final zy0 a(zi ziVar) {
        g12 g12Var = ziVar.a;
        wi wiVar = (wi) this.c.apply(ziVar);
        if ((wiVar.c == 35 || this.l) && this.b.d == 256) {
            wi wiVar2 = (wi) this.d.j(new li(wiVar, g12Var.e));
            this.i.getClass();
            m92 m92Var = new m92(new s9(ImageReader.newInstance(wiVar2.d.getWidth(), wiVar2.d.getHeight(), 256, 2)));
            zy0 zy0VarA = ImageProcessingUtil.a(m92Var, (byte[]) wiVar2.a);
            m92Var.c();
            Objects.requireNonNull(zy0VarA);
            xj0 xj0Var = wiVar2.b;
            Objects.requireNonNull(xj0Var);
            Rect rect = wiVar2.e;
            int i = wiVar2.f;
            Matrix matrix = wiVar2.g;
            ls lsVar = wiVar2.h;
            wp0 wp0Var = (wp0) zy0VarA;
            Size size = new Size(wp0Var.b(), wp0Var.a());
            wp0Var.getFormat();
            wiVar = new wi(zy0VarA, xj0Var, wp0Var.getFormat(), size, rect, i, matrix, lsVar);
        }
        this.h.getClass();
        zy0 zy0Var = (zy0) wiVar.a;
        xh2 xh2Var = new xh2(zy0Var, wiVar.d, new mi(zy0Var.m().b(), zy0Var.m().d(), wiVar.f, wiVar.g));
        Rect rect2 = wiVar.e;
        if (rect2 != null) {
            Rect rect3 = new Rect(rect2);
            if (!rect3.intersect(0, 0, xh2Var.i, xh2Var.j)) {
                rect3.setEmpty();
            }
        }
        synchronized (xh2Var.e) {
        }
        return xh2Var;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x016d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.py0 b(defpackage.zi r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f12.b(zi):py0");
    }
}
