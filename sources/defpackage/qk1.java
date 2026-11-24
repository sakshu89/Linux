package defpackage;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qk1 {
    public long a;
    public final SparseLongArray b = new SparseLongArray();
    public final SparseBooleanArray c = new SparseBooleanArray();
    public final ArrayList d = new ArrayList();
    public final if1 e = new if1((Object) null);
    public int f = -1;
    public int g = -1;

    public final void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        SparseLongArray sparseLongArray = this.b;
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (sparseLongArray.indexOfKey(pointerId) < 0) {
                long j = this.a;
                this.a = 1 + j;
                sparseLongArray.put(pointerId, j);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (sparseLongArray.indexOfKey(pointerId2) < 0) {
            long j2 = this.a;
            this.a = 1 + j2;
            sparseLongArray.put(pointerId2, j2);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.c.put(pointerId2, true);
            }
        }
    }

    public final void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.f && source == this.g) {
            return;
        }
        this.f = toolType;
        this.g = source;
        this.c.clear();
        this.b.clear();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0103  */
    /* JADX WARN: Code duplicated, block: B:51:0x0106  */
    /* JADX WARN: Code duplicated, block: B:53:0x0109 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x010b  */
    /* JADX WARN: Code duplicated, block: B:57:0x0111  */
    /* JADX WARN: Code duplicated, block: B:58:0x0114  */
    /* JADX WARN: Code duplicated, block: B:59:0x0118  */
    /* JADX WARN: Code duplicated, block: B:60:0x011c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0120  */
    /* JADX WARN: Code duplicated, block: B:64:0x0132  */
    /* JADX WARN: Code duplicated, block: B:66:0x0149  */
    /* JADX WARN: Code duplicated, block: B:69:0x0174  */
    /* JADX WARN: Code duplicated, block: B:73:0x018e  */
    /* JADX WARN: Code duplicated, block: B:75:0x01af  */
    public final q91 c(MotionEvent motionEvent, r7 r7Var) {
        int actionIndex;
        long jValueAt;
        float f;
        long j;
        long jP;
        long jB;
        int toolType;
        int i;
        int historySize;
        int i2;
        char c;
        char c2;
        long jFloatToRawIntBits;
        float historicalX;
        qk1 qk1Var = this;
        int actionMasked = motionEvent.getActionMasked();
        SparseLongArray sparseLongArray = qk1Var.b;
        SparseBooleanArray sparseBooleanArray = qk1Var.c;
        int i3 = 3;
        if (actionMasked == 3 || actionMasked == 4) {
            sparseLongArray.clear();
            sparseBooleanArray.clear();
            return null;
        }
        b(motionEvent);
        a(motionEvent);
        boolean z = true;
        boolean z2 = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z3 = actionMasked == 8;
        if (z2) {
            sparseBooleanArray.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked != 1) {
            actionIndex = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            actionIndex = 0;
        }
        ArrayList arrayList = qk1Var.d;
        arrayList.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i4 = 0;
        while (i4 < pointerCount) {
            boolean z4 = (z2 || i4 == actionIndex || (z3 && motionEvent.getButtonState() == 0)) ? false : z;
            int pointerId = motionEvent.getPointerId(i4);
            int iIndexOfKey = sparseLongArray.indexOfKey(pointerId);
            if (iIndexOfKey >= 0) {
                jValueAt = sparseLongArray.valueAt(iIndexOfKey);
            } else {
                long j2 = qk1Var.a;
                qk1Var.a = j2 + 1;
                sparseLongArray.put(pointerId, j2);
                jValueAt = j2;
            }
            float pressure = motionEvent.getPressure(i4);
            char c3 = ' ';
            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(motionEvent.getY(i4))) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getX(i4))) << 32);
            long jA = jp1.a(jFloatToRawIntBits2, 0.0f, i3);
            if (i4 == 0) {
                f = 0.0f;
                jP = (((long) Float.floatToRawIntBits(motionEvent.getRawY())) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getRawX())) << 32);
                jB = r7Var.B(jP);
            } else {
                f = 0.0f;
                if (Build.VERSION.SDK_INT >= 29) {
                    jP = (((long) Float.floatToRawIntBits(motionEvent.getRawY(i4))) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getRawX(i4))) << 32);
                    jB = r7Var.B(jP);
                } else {
                    j = jFloatToRawIntBits2;
                    jP = r7Var.p(jFloatToRawIntBits2);
                }
                toolType = motionEvent.getToolType(i4);
                if (toolType == 0) {
                    if (toolType != 1) {
                        i = 1;
                    } else if (toolType != 2) {
                        i = i3;
                    } else if (toolType != i3) {
                        i = 2;
                    } else if (toolType != 4) {
                        i = 4;
                    }
                    ArrayList arrayList2 = new ArrayList(motionEvent.getHistorySize());
                    historySize = motionEvent.getHistorySize();
                    i2 = 0;
                    while (i2 < historySize) {
                        historicalX = motionEvent.getHistoricalX(i4, i2);
                        float historicalY = motionEvent.getHistoricalY(i4, i2);
                        char c4 = c3;
                        if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) >= 2139095040 && (Float.floatToRawIntBits(historicalY) & Integer.MAX_VALUE) < 2139095040) {
                            long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(historicalX)) << c4) | (((long) Float.floatToRawIntBits(historicalY)) & 4294967295L);
                            arrayList2.add(new lw0(motionEvent.getHistoricalEventTime(i2), jFloatToRawIntBits3, jFloatToRawIntBits3));
                        }
                        i2++;
                        c3 = c4;
                        actionIndex = actionIndex;
                    }
                    int i5 = actionIndex;
                    c = c3;
                    if (motionEvent.getActionMasked() == 8) {
                        c2 = '\n';
                        jFloatToRawIntBits = (((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + f)) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c);
                    } else {
                        c2 = '\n';
                        jFloatToRawIntBits = 0;
                    }
                    arrayList.add(new py1(jValueAt, motionEvent.getEventTime(), jP, j, z4, pressure, i, sparseBooleanArray.get(motionEvent.getPointerId(i4), false), arrayList2, jFloatToRawIntBits, jA));
                    i4++;
                    i3 = 3;
                    z = true;
                    z2 = z2;
                    z3 = z3;
                    actionIndex = i5;
                    qk1Var = this;
                }
                i = 0;
                ArrayList arrayList3 = new ArrayList(motionEvent.getHistorySize());
                historySize = motionEvent.getHistorySize();
                i2 = 0;
                while (i2 < historySize) {
                    historicalX = motionEvent.getHistoricalX(i4, i2);
                    float historicalY2 = motionEvent.getHistoricalY(i4, i2);
                    char c5 = c3;
                    if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) >= 2139095040) {
                    }
                    i2++;
                    c3 = c5;
                    actionIndex = actionIndex;
                }
                int i6 = actionIndex;
                c = c3;
                if (motionEvent.getActionMasked() == 8) {
                    c2 = '\n';
                    jFloatToRawIntBits = (((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + f)) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c);
                } else {
                    c2 = '\n';
                    jFloatToRawIntBits = 0;
                }
                arrayList.add(new py1(jValueAt, motionEvent.getEventTime(), jP, j, z4, pressure, i, sparseBooleanArray.get(motionEvent.getPointerId(i4), false), arrayList3, jFloatToRawIntBits, jA));
                i4++;
                i3 = 3;
                z = true;
                z2 = z2;
                z3 = z3;
                actionIndex = i6;
                qk1Var = this;
            }
            j = jB;
            toolType = motionEvent.getToolType(i4);
            if (toolType == 0) {
                if (toolType != 1) {
                    i = 1;
                } else if (toolType != 2) {
                    i = i3;
                } else if (toolType != i3) {
                    i = 2;
                } else if (toolType != 4) {
                    i = 4;
                }
                ArrayList arrayList4 = new ArrayList(motionEvent.getHistorySize());
                historySize = motionEvent.getHistorySize();
                i2 = 0;
                while (i2 < historySize) {
                    historicalX = motionEvent.getHistoricalX(i4, i2);
                    float historicalY3 = motionEvent.getHistoricalY(i4, i2);
                    char c6 = c3;
                    if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) >= 2139095040) {
                    }
                    i2++;
                    c3 = c6;
                    actionIndex = actionIndex;
                }
                int i7 = actionIndex;
                c = c3;
                if (motionEvent.getActionMasked() == 8) {
                    c2 = '\n';
                    jFloatToRawIntBits = (((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + f)) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c);
                } else {
                    c2 = '\n';
                    jFloatToRawIntBits = 0;
                }
                arrayList.add(new py1(jValueAt, motionEvent.getEventTime(), jP, j, z4, pressure, i, sparseBooleanArray.get(motionEvent.getPointerId(i4), false), arrayList4, jFloatToRawIntBits, jA));
                i4++;
                i3 = 3;
                z = true;
                z2 = z2;
                z3 = z3;
                actionIndex = i7;
                qk1Var = this;
            }
            i = 0;
            ArrayList arrayList5 = new ArrayList(motionEvent.getHistorySize());
            historySize = motionEvent.getHistorySize();
            i2 = 0;
            while (i2 < historySize) {
                historicalX = motionEvent.getHistoricalX(i4, i2);
                float historicalY4 = motionEvent.getHistoricalY(i4, i2);
                char c7 = c3;
                if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) >= 2139095040) {
                }
                i2++;
                c3 = c7;
                actionIndex = actionIndex;
            }
            int i8 = actionIndex;
            c = c3;
            if (motionEvent.getActionMasked() == 8) {
                c2 = '\n';
                jFloatToRawIntBits = (((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + f)) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c);
            } else {
                c2 = '\n';
                jFloatToRawIntBits = 0;
            }
            arrayList.add(new py1(jValueAt, motionEvent.getEventTime(), jP, j, z4, pressure, i, sparseBooleanArray.get(motionEvent.getPointerId(i4), false), arrayList5, jFloatToRawIntBits, jA));
            i4++;
            i3 = 3;
            z = true;
            z2 = z2;
            z3 = z3;
            actionIndex = i8;
            qk1Var = this;
        }
        d(motionEvent);
        motionEvent.getEventTime();
        return new q91(19, arrayList, motionEvent);
    }

    public final void d(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        SparseBooleanArray sparseBooleanArray = this.c;
        SparseLongArray sparseLongArray = this.b;
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!sparseBooleanArray.get(pointerId, false)) {
                sparseLongArray.delete(pointerId);
                sparseBooleanArray.delete(pointerId);
            }
        }
        if (sparseLongArray.size() > motionEvent.getPointerCount()) {
            for (int size = sparseLongArray.size() - 1; -1 < size; size--) {
                int iKeyAt = sparseLongArray.keyAt(size);
                int pointerCount = motionEvent.getPointerCount();
                int i = 0;
                while (true) {
                    if (i >= pointerCount) {
                        sparseLongArray.removeAt(size);
                        sparseBooleanArray.delete(iKeyAt);
                        break;
                    } else if (motionEvent.getPointerId(i) == iKeyAt) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }
}
