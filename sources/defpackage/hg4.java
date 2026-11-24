package defpackage;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hg4 {
    public static wp a(up upVar) {
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = upVar.getClass();
        try {
            Object objD = upVar.d(tpVar);
            if (objD == null) {
                return wpVar;
            }
            tpVar.a = objD;
            return wpVar;
        } catch (Exception e) {
            wpVar.b(e);
            return wpVar;
        }
    }

    public static Rect b(List list, Matrix matrix) {
        Iterator it = list.iterator();
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        RectF rectF = new RectF(iMin, iMin2, iMax, iMax2);
        if (matrix != null) {
            matrix.mapRect(rectF);
        }
        Rect rect = new Rect();
        rectF.round(rect);
        return rect;
    }

    public static tr3 c(jf3 jf3Var) {
        if (jf3Var.t()) {
            return jf3Var.p().p();
        }
        return jf3Var.o() ? jf3Var.r().o() : jf3Var.q();
    }

    public static List d(tr3 tr3Var) {
        double dSin = Math.sin(Math.toRadians(tr3Var.o()));
        double dCos = Math.cos(Math.toRadians(tr3Var.o()));
        Point point = new Point((int) (((double) tr3Var.q()) + (((double) tr3Var.s()) * dCos)), (int) ((((double) tr3Var.s()) * dSin) + ((double) tr3Var.r())));
        double d = point.x;
        double dP = ((double) tr3Var.p()) * dSin;
        double dP2 = (((double) tr3Var.p()) * dCos) + ((double) pointArr[1].y);
        Point point2 = pointArr[0];
        int i = point2.x;
        Point point3 = pointArr[2];
        int i2 = point3.x;
        Point point4 = pointArr[1];
        Point[] pointArr = {new Point(tr3Var.q(), tr3Var.r()), point, new Point((int) (d - dP), (int) dP2), new Point((i2 - point4.x) + i, (point3.y - point4.y) + point2.y)};
        return Arrays.asList(pointArr);
    }
}
