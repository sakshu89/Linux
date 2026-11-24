package defpackage;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class na {
    public final Path a;
    public RectF b;
    public float[] c;

    public na(Path path) {
        this.a = path;
    }

    public static void a(na naVar, na naVar2) {
        naVar.a.addPath(naVar2.a, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
    }

    public static void b(na naVar, s82 s82Var) {
        if (naVar.b == null) {
            naVar.b = new RectF();
        }
        RectF rectF = naVar.b;
        rectF.getClass();
        float f = s82Var.a;
        long j = s82Var.h;
        long j2 = s82Var.g;
        long j3 = s82Var.f;
        long j4 = s82Var.e;
        rectF.set(f, s82Var.b, s82Var.c, s82Var.d);
        if (naVar.c == null) {
            naVar.c = new float[8];
        }
        float[] fArr = naVar.c;
        fArr.getClass();
        fArr[0] = Float.intBitsToFloat((int) (j4 >> 32));
        fArr[1] = Float.intBitsToFloat((int) (j4 & 4294967295L));
        fArr[2] = Float.intBitsToFloat((int) (j3 >> 32));
        fArr[3] = Float.intBitsToFloat((int) (j3 & 4294967295L));
        fArr[4] = Float.intBitsToFloat((int) (j2 >> 32));
        fArr[5] = Float.intBitsToFloat((int) (j2 & 4294967295L));
        fArr[6] = Float.intBitsToFloat((int) (j >> 32));
        fArr[7] = Float.intBitsToFloat((int) (j & 4294967295L));
        Path path = naVar.a;
        RectF rectF2 = naVar.b;
        rectF2.getClass();
        float[] fArr2 = naVar.c;
        fArr2.getClass();
        path.addRoundRect(rectF2, fArr2, Path.Direction.CCW);
    }

    public final l42 c() {
        if (this.b == null) {
            this.b = new RectF();
        }
        RectF rectF = this.b;
        rectF.getClass();
        this.a.computeBounds(rectF, true);
        return new l42(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final void d(float f, float f2) {
        this.a.lineTo(f, f2);
    }

    public final boolean e(na naVar, na naVar2, int i) {
        Path.Op op;
        if (i == 0) {
            op = Path.Op.DIFFERENCE;
        } else if (i == 1) {
            op = Path.Op.INTERSECT;
        } else if (i == 4) {
            op = Path.Op.REVERSE_DIFFERENCE;
        } else {
            op = i == 2 ? Path.Op.UNION : Path.Op.XOR;
        }
        if (!(naVar instanceof na)) {
            dk0.r("Unable to obtain android.graphics.Path");
            return false;
        }
        Path path = naVar.a;
        if (naVar2 instanceof na) {
            return this.a.op(path, naVar2.a, op);
        }
        dk0.r("Unable to obtain android.graphics.Path");
        return false;
    }

    public final void f() {
        this.a.reset();
    }
}
