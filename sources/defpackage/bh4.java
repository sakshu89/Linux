package defpackage;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bh4 {
    public static final u6 a(p9 p9Var) {
        Canvas canvas = v6.a;
        u6 u6Var = new u6();
        u6Var.a = new Canvas(zc4.a(p9Var));
        return u6Var;
    }

    public static Rect b(List list) {
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
        return new Rect(iMin, iMin2, iMax, iMax2);
    }

    public static List c(v54 v54Var) {
        Point[] pointArr = new Point[4];
        double dSin = Math.sin(Math.toRadians(v54Var.f));
        double dCos = Math.cos(Math.toRadians(v54Var.f));
        int i = v54Var.a;
        int i2 = v54Var.b;
        pointArr[0] = new Point(i, i2);
        double d = v54Var.c;
        Point point = new Point((int) (((double) i) + (d * dCos)), (int) ((d * dSin) + ((double) i2)));
        pointArr[1] = point;
        double d2 = point.x;
        int i3 = v54Var.e;
        pointArr[2] = new Point((int) (d2 - (((double) i3) * dSin)), (int) ((((double) i3) * dCos) + ((double) pointArr[1].y)));
        Point point2 = pointArr[0];
        int i4 = point2.x;
        Point point3 = pointArr[2];
        int i5 = point3.x;
        Point point4 = pointArr[1];
        pointArr[3] = new Point((i5 - point4.x) + i4, (point3.y - point4.y) + point2.y);
        return Arrays.asList(pointArr);
    }
}
