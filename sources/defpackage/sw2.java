package defpackage;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class sw2 {
    public final String a;
    public final Rect b;
    public final String c;

    public sw2(String str, Rect rect, List list, String str2, Matrix matrix) {
        this.a = str;
        Rect rect2 = new Rect(rect);
        if (matrix != null) {
            RectF rectF = new RectF(rect2);
            matrix.mapRect(rectF);
            rect2.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
        this.b = rect2;
        int size = list.size();
        Point[] pointArr = new Point[size];
        for (int i = 0; i < list.size(); i++) {
            pointArr[i] = new Point((Point) list.get(i));
        }
        if (matrix != null) {
            float[] fArr = new float[size + size];
            for (int i2 = 0; i2 < size; i2++) {
                Point point = pointArr[i2];
                int i3 = i2 + i2;
                fArr[i3] = point.x;
                fArr[i3 + 1] = point.y;
            }
            matrix.mapPoints(fArr);
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = i4 + i4;
                pointArr[i4].set((int) fArr[i5], (int) fArr[i5 + 1]);
            }
        }
        this.c = str2;
    }
}
