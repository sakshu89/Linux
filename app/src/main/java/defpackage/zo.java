package defpackage;

import android.graphics.Matrix;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zo implements yo {
    public final int[] a;
    public final float[] b;

    public zo(ArrayList arrayList, ArrayList arrayList2) {
        int size = arrayList.size();
        this.a = new int[size];
        this.b = new float[size];
        for (int i = 0; i < size; i++) {
            this.a[i] = ((Integer) arrayList.get(i)).intValue();
            this.b[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    @Override // defpackage.yo
    public void a(View view, float[] fArr) {
        ih1.d(fArr);
        b(view, fArr);
    }

    public void b(View view, float[] fArr) {
        Object parent = view.getParent();
        boolean z = parent instanceof View;
        float[] fArr2 = this.b;
        if (z) {
            b((View) parent, fArr);
            float f = -view.getScrollX();
            float f2 = -view.getScrollY();
            ih1.d(fArr2);
            ih1.f(fArr2, f, f2);
            e8.d(fArr, fArr2);
            float left = view.getLeft();
            float top = view.getTop();
            ih1.d(fArr2);
            ih1.f(fArr2, left, top);
            e8.d(fArr, fArr2);
        } else {
            int[] iArr = this.a;
            view.getLocationInWindow(iArr);
            float f3 = -view.getScrollX();
            float f4 = -view.getScrollY();
            ih1.d(fArr2);
            ih1.f(fArr2, f3, f4);
            e8.d(fArr, fArr2);
            float f5 = iArr[0];
            float f6 = iArr[1];
            ih1.d(fArr2);
            ih1.f(fArr2, f5, f6);
            e8.d(fArr, fArr2);
        }
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        hd4.d(matrix, fArr2);
        e8.d(fArr, fArr2);
    }

    public zo(int i, int i2) {
        this.a = new int[]{i, i2};
        this.b = new float[]{0.0f, 1.0f};
    }

    public zo(int i, int i2, int i3) {
        this.a = new int[]{i, i2, i3};
        this.b = new float[]{0.0f, 0.5f, 1.0f};
    }

    public zo(float[] fArr) {
        this.b = fArr;
        this.a = new int[2];
    }
}
