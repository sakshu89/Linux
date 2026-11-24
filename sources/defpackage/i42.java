package defpackage;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UCharacter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i42 implements InputConnection {
    public final uf1 a;
    public final boolean b;
    public final ua1 c;
    public final ny2 d;
    public final w73 e;
    public int f;
    public ty2 g;
    public int h;
    public boolean i;
    public final ArrayList j = new ArrayList();
    public boolean k = true;

    public i42(ty2 ty2Var, uf1 uf1Var, boolean z, ua1 ua1Var, ny2 ny2Var, w73 w73Var) {
        this.a = uf1Var;
        this.b = z;
        this.c = ua1Var;
        this.d = ny2Var;
        this.e = w73Var;
        this.g = ty2Var;
    }

    public final void a(fh0 fh0Var) {
        this.f++;
        try {
            this.j.add(fh0Var);
        } finally {
            b();
        }
    }

    public final boolean b() {
        int i = this.f - 1;
        this.f = i;
        if (i == 0) {
            ArrayList arrayList = this.j;
            if (!arrayList.isEmpty()) {
                ((wa1) this.a.b).c.j(new ArrayList(arrayList));
                arrayList.clear();
            }
        }
        return this.f > 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        this.f++;
        return true;
    }

    public final void c(int i) {
        sendKeyEvent(new KeyEvent(0, i));
        sendKeyEvent(new KeyEvent(1, i));
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean clearMetaKeyStates(int i) {
        boolean z = this.k;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final void closeConnection() {
        this.j.clear();
        this.f = 0;
        this.k = false;
        ArrayList arrayList = ((wa1) this.a.b).j;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (g31.a(((WeakReference) arrayList.get(i)).get(), this)) {
                arrayList.remove(i);
                return;
            }
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z = this.k;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        boolean z = this.k;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z = this.k;
        return z ? this.b : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i) {
        boolean z = this.k;
        if (z) {
            a(new r00(String.valueOf(charSequence), i));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        a(new ec0(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        a(new fc0(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        return b();
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        a(new xl0());
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int i) {
        ty2 ty2Var = this.g;
        return TextUtils.getCapsMode(ty2Var.a.b, oz2.f(ty2Var.b), i);
    }

    @Override // android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = (i & 1) != 0;
        this.i = z;
        if (z) {
            this.h = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return oy3.a(this.g);
    }

    @Override // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int i) {
        if (oz2.c(this.g.b)) {
            return null;
        }
        return bc4.d(this.g).b;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int i, int i2) {
        return bc4.e(this.g, i).b;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int i, int i2) {
        return bc4.f(this.g, i).b;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int i) {
        boolean z = this.k;
        if (z) {
            z = false;
            switch (i) {
                case R.id.selectAll:
                    a(new vh2(0, this.g.a.b.length()));
                    break;
                case R.id.cut:
                    c(UCharacter.UnicodeBlock.NUSHU_ID);
                    return false;
                case R.id.copy:
                    c(UCharacter.UnicodeBlock.SOYOMBO_ID);
                    return false;
                case R.id.paste:
                    c(UCharacter.UnicodeBlock.SYRIAC_SUPPLEMENT_ID);
                    return false;
                default:
                    return false;
            }
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int i) {
        int i2;
        boolean z = this.k;
        if (z) {
            z = true;
            if (i != 0) {
                switch (i) {
                    case 2:
                        i2 = 2;
                        break;
                    case 3:
                        i2 = 3;
                        break;
                    case 4:
                        i2 = 4;
                        break;
                    case 5:
                        i2 = 6;
                        break;
                    case 6:
                        i2 = 7;
                        break;
                    case 7:
                        i2 = 5;
                        break;
                    default:
                        Log.w("RecordingIC", "IME sends unsupported Editor Action: " + i);
                        i2 = 1;
                        break;
                }
            } else {
                i2 = 1;
            }
            ((wa1) this.a.b).d.j(new jz0(i2));
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:121:0x026e  */
    @Override // android.view.inputmethod.InputConnection
    public final void performHandwritingGesture(HandwritingGesture handwritingGesture, Executor executor, IntConsumer intConsumer) {
        be beVar;
        long jH;
        int i;
        hz2 hz2VarD;
        hz2 hz2VarD2;
        fz2 fz2Var;
        if (Build.VERSION.SDK_INT >= 34) {
            x0 x0Var = new x0(23, this);
            ua1 ua1Var = this.c;
            int iA = 3;
            if (ua1Var != null && (beVar = ua1Var.j) != null) {
                hz2 hz2VarD3 = ua1Var.d();
                if (beVar.equals((hz2VarD3 == null || (fz2Var = hz2VarD3.a.a) == null) ? null : fz2Var.a)) {
                    boolean zS = u9.s(handwritingGesture);
                    ny2 ny2Var = this.d;
                    if (zS) {
                        SelectGesture selectGestureP = zv0.p(handwritingGesture);
                        long jF = jo4.f(ua1Var, py3.c(selectGestureP.getSelectionArea()), selectGestureP.getGranularity() != 1 ? 0 : 1);
                        if (oz2.c(jF)) {
                            iA = io4.a(zv0.l(selectGestureP), x0Var);
                        } else {
                            x0Var.j(new vh2((int) (jF >> 32), (int) (jF & 4294967295L)));
                            if (ny2Var != null) {
                                ny2Var.h(true);
                            }
                            iA = 1;
                        }
                    } else if (zv0.B(handwritingGesture)) {
                        DeleteGesture deleteGestureJ = zv0.j(handwritingGesture);
                        int i2 = deleteGestureJ.getGranularity() != 1 ? 0 : 1;
                        long jF2 = jo4.f(ua1Var, py3.c(deleteGestureJ.getDeletionArea()), i2);
                        if (oz2.c(jF2)) {
                            iA = io4.a(zv0.l(deleteGestureJ), x0Var);
                        } else {
                            io4.b(jF2, beVar, i2 == 1, x0Var);
                            iA = 1;
                        }
                    } else if (zv0.C(handwritingGesture)) {
                        SelectRangeGesture selectRangeGestureQ = zv0.q(handwritingGesture);
                        long jB = jo4.b(ua1Var, py3.c(selectRangeGestureQ.getSelectionStartArea()), py3.c(selectRangeGestureQ.getSelectionEndArea()), selectRangeGestureQ.getGranularity() != 1 ? 0 : 1);
                        if (oz2.c(jB)) {
                            iA = io4.a(zv0.l(selectRangeGestureQ), x0Var);
                        } else {
                            x0Var.j(new vh2((int) (jB >> 32), (int) (jB & 4294967295L)));
                            if (ny2Var != null) {
                                ny2Var.h(true);
                            }
                            iA = 1;
                        }
                    } else if (zv0.D(handwritingGesture)) {
                        DeleteRangeGesture deleteRangeGestureK = zv0.k(handwritingGesture);
                        int i3 = deleteRangeGestureK.getGranularity() != 1 ? 0 : 1;
                        long jB2 = jo4.b(ua1Var, py3.c(deleteRangeGestureK.getDeletionStartArea()), py3.c(deleteRangeGestureK.getDeletionEndArea()), i3);
                        if (oz2.c(jB2)) {
                            iA = io4.a(zv0.l(deleteRangeGestureK), x0Var);
                        } else {
                            io4.b(jB2, beVar, i3 == 1, x0Var);
                            iA = 1;
                        }
                    } else {
                        boolean zA = zv0.A(handwritingGesture);
                        w73 w73Var = this.e;
                        if (zA) {
                            JoinOrSplitGesture joinOrSplitGestureN = zv0.n(handwritingGesture);
                            if (w73Var == null) {
                                iA = io4.a(zv0.z(joinOrSplitGestureN), x0Var);
                            } else {
                                int iA2 = jo4.a(ua1Var, jo4.d(joinOrSplitGestureN.getJoinOrSplitPoint()), w73Var);
                                if (iA2 == -1 || ((hz2VarD2 = ua1Var.d()) != null && jo4.c(hz2VarD2.a, iA2))) {
                                    iA = io4.a(zv0.l(joinOrSplitGestureN), x0Var);
                                } else {
                                    int iCharCount = iA2;
                                    while (iCharCount > 0) {
                                        int iCodePointBefore = Character.codePointBefore(beVar, iCharCount);
                                        if (!jo4.h(iCodePointBefore)) {
                                            break;
                                        } else {
                                            iCharCount -= Character.charCount(iCodePointBefore);
                                        }
                                    }
                                    while (iA2 < beVar.b.length()) {
                                        int iCodePointAt = Character.codePointAt(beVar, iA2);
                                        if (!jo4.h(iCodePointAt)) {
                                            break;
                                        } else {
                                            iA2 += Character.charCount(iCodePointAt);
                                        }
                                    }
                                    long jA = hc4.a(iCharCount, iA2);
                                    if (oz2.c(jA)) {
                                        int i4 = (int) (jA >> 32);
                                        x0Var.j(new aw0(new fh0[]{new vh2(i4, i4), new r00(Padder.FALLBACK_PADDING_STRING, 1)}));
                                    } else {
                                        io4.b(jA, beVar, false, x0Var);
                                    }
                                    iA = 1;
                                }
                            }
                        } else if (nb3.b(handwritingGesture)) {
                            InsertGesture insertGestureM = zv0.m(handwritingGesture);
                            if (w73Var == null) {
                                iA = io4.a(zv0.z(insertGestureM), x0Var);
                            } else {
                                int iA3 = jo4.a(ua1Var, jo4.d(insertGestureM.getInsertionPoint()), w73Var);
                                if (iA3 == -1 || ((hz2VarD = ua1Var.d()) != null && jo4.c(hz2VarD.a, iA3))) {
                                    iA = io4.a(zv0.l(insertGestureM), x0Var);
                                } else {
                                    x0Var.j(new aw0(new fh0[]{new vh2(iA3, iA3), new r00(insertGestureM.getTextToInsert(), 1)}));
                                    iA = 1;
                                }
                            }
                        } else if (zv0.w(handwritingGesture)) {
                            RemoveSpaceGesture removeSpaceGestureO = zv0.o(handwritingGesture);
                            hz2 hz2VarD4 = ua1Var.d();
                            gz2 gz2Var = hz2VarD4 != null ? hz2VarD4.a : null;
                            long jD = jo4.d(removeSpaceGestureO.getStartPoint());
                            long jD2 = jo4.d(removeSpaceGestureO.getEndPoint());
                            y61 y61VarC = ua1Var.c();
                            if (gz2Var != null) {
                                fl1 fl1Var = gz2Var.b;
                                if (y61VarC == null) {
                                    jH = oz2.b;
                                } else {
                                    long jA2 = y61VarC.A(jD);
                                    long jA3 = y61VarC.A(jD2);
                                    int iE = jo4.e(fl1Var, jA2, w73Var);
                                    int iE2 = jo4.e(fl1Var, jA3, w73Var);
                                    if (iE != -1) {
                                        if (iE2 != -1) {
                                            iE = Math.min(iE, iE2);
                                        }
                                        iE2 = iE;
                                    } else if (iE2 == -1) {
                                        jH = oz2.b;
                                    }
                                    float fB = (fl1Var.b(iE2) + fl1Var.f(iE2)) / 2.0f;
                                    int i5 = (int) (jA2 >> 32);
                                    int i6 = (int) (jA3 >> 32);
                                    jH = fl1Var.h(new l42(Math.min(Float.intBitsToFloat(i5), Float.intBitsToFloat(i6)), fB - 0.1f, Math.max(Float.intBitsToFloat(i5), Float.intBitsToFloat(i6)), fB + 0.1f), 0, y74.j);
                                }
                            } else {
                                jH = oz2.b;
                            }
                            if (oz2.c(jH)) {
                                iA = io4.a(zv0.l(removeSpaceGestureO), x0Var);
                            } else {
                                r42 r42Var = new r42();
                                r42Var.a = -1;
                                r42 r42Var2 = new r42();
                                r42Var2.a = -1;
                                String strG = new x42("\\s+").g(beVar.subSequence(oz2.f(jH), oz2.e(jH)).b, new o0(9, r42Var, r42Var2));
                                int i7 = r42Var.a;
                                if (i7 == -1 || (i = r42Var2.a) == -1) {
                                    iA = io4.a(zv0.l(removeSpaceGestureO), x0Var);
                                } else {
                                    int i8 = (int) (jH >> 32);
                                    x0Var.j(new aw0(new fh0[]{new vh2(i8 + i7, i8 + i), new r00(strG.substring(i7, strG.length() - (oz2.d(jH) - r42Var2.a)), 1)}));
                                    iA = 1;
                                }
                            }
                        } else {
                            iA = 2;
                        }
                    }
                }
            }
            if (intConsumer == null) {
                return;
            }
            if (executor != null) {
                executor.execute(new ne(intConsumer, iA, 0));
            } else {
                intConsumer.accept(iA);
            }
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z = this.k;
        if (z) {
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        ua1 ua1Var;
        be beVar;
        fz2 fz2Var;
        if (Build.VERSION.SDK_INT >= 34 && (ua1Var = this.c) != null && (beVar = ua1Var.j) != null) {
            hz2 hz2VarD = ua1Var.d();
            if (beVar.equals((hz2VarD == null || (fz2Var = hz2VarD.a.a) == null) ? null : fz2Var.a)) {
                boolean zS = u9.s(previewableHandwritingGesture);
                int i = 1;
                rv0 rv0Var = rv0.a;
                ny2 ny2Var = this.d;
                if (zS) {
                    SelectGesture selectGestureP = zv0.p(previewableHandwritingGesture);
                    if (ny2Var != null) {
                        long jF = jo4.f(ua1Var, py3.c(selectGestureP.getSelectionArea()), selectGestureP.getGranularity() != 1 ? 0 : 1);
                        ua1 ua1Var2 = ny2Var.d;
                        if (ua1Var2 != null) {
                            ua1Var2.f(jF);
                        }
                        ua1 ua1Var3 = ny2Var.d;
                        if (ua1Var3 != null) {
                            ua1Var3.e(oz2.b);
                        }
                        if (!oz2.c(jF)) {
                            ny2Var.t(false);
                            ny2Var.q(rv0Var);
                        }
                    }
                } else if (zv0.B(previewableHandwritingGesture)) {
                    DeleteGesture deleteGestureJ = zv0.j(previewableHandwritingGesture);
                    if (ny2Var != null) {
                        long jF2 = jo4.f(ua1Var, py3.c(deleteGestureJ.getDeletionArea()), deleteGestureJ.getGranularity() != 1 ? 0 : 1);
                        ua1 ua1Var4 = ny2Var.d;
                        if (ua1Var4 != null) {
                            ua1Var4.e(jF2);
                        }
                        ua1 ua1Var5 = ny2Var.d;
                        if (ua1Var5 != null) {
                            ua1Var5.f(oz2.b);
                        }
                        if (!oz2.c(jF2)) {
                            ny2Var.t(false);
                            ny2Var.q(rv0Var);
                        }
                    }
                } else if (zv0.C(previewableHandwritingGesture)) {
                    SelectRangeGesture selectRangeGestureQ = zv0.q(previewableHandwritingGesture);
                    if (ny2Var != null) {
                        long jB = jo4.b(ua1Var, py3.c(selectRangeGestureQ.getSelectionStartArea()), py3.c(selectRangeGestureQ.getSelectionEndArea()), selectRangeGestureQ.getGranularity() != 1 ? 0 : 1);
                        ua1 ua1Var6 = ny2Var.d;
                        if (ua1Var6 != null) {
                            ua1Var6.f(jB);
                        }
                        ua1 ua1Var7 = ny2Var.d;
                        if (ua1Var7 != null) {
                            ua1Var7.e(oz2.b);
                        }
                        if (!oz2.c(jB)) {
                            ny2Var.t(false);
                            ny2Var.q(rv0Var);
                        }
                    }
                } else if (zv0.D(previewableHandwritingGesture)) {
                    DeleteRangeGesture deleteRangeGestureK = zv0.k(previewableHandwritingGesture);
                    if (ny2Var != null) {
                        long jB2 = jo4.b(ua1Var, py3.c(deleteRangeGestureK.getDeletionStartArea()), py3.c(deleteRangeGestureK.getDeletionEndArea()), deleteRangeGestureK.getGranularity() != 1 ? 0 : 1);
                        ua1 ua1Var8 = ny2Var.d;
                        if (ua1Var8 != null) {
                            ua1Var8.e(jB2);
                        }
                        ua1 ua1Var9 = ny2Var.d;
                        if (ua1Var9 != null) {
                            ua1Var9.f(oz2.b);
                        }
                        if (!oz2.c(jB2)) {
                            ny2Var.t(false);
                            ny2Var.q(rv0Var);
                        }
                    }
                }
                if (cancellationSignal != null) {
                    cancellationSignal.setOnCancelListener(new k20(i, ny2Var));
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean reportFullscreenMode(boolean z) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0065 A[Catch: all -> 0x006f, TryCatch #0 {all -> 0x006f, blocks: (B:44:0x005b, B:46:0x0065, B:48:0x006b, B:51:0x0071), top: B:57:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:48:0x006b A[Catch: all -> 0x006f, TryCatch #0 {all -> 0x006f, blocks: (B:44:0x005b, B:46:0x0065, B:48:0x006b, B:51:0x0071), top: B:57:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:57:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        qa1 qa1Var;
        boolean z4 = this.k;
        if (!z4) {
            return z4;
        }
        boolean z5 = false;
        boolean z6 = (i & 1) != 0;
        boolean z7 = (i & 2) != 0;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            z2 = (i & 16) != 0;
            z3 = (i & 8) != 0;
            boolean z8 = (i & 4) != 0;
            if (i2 >= 34 && (i & 32) != 0) {
                z5 = true;
            }
            if (z2 || z3 || z8 || z5) {
                z = z5;
                z5 = z8;
            } else {
                if (i2 >= 34) {
                    z = true;
                    z5 = true;
                } else {
                    z = z5;
                    z5 = true;
                }
                z2 = z5;
            }
            qa1Var = ((wa1) this.a.b).m;
            synchronized (qa1Var.c) {
                try {
                    qa1Var.f = z2;
                    qa1Var.g = z3;
                    qa1Var.h = z5;
                    qa1Var.i = z;
                    if (z6) {
                        qa1Var.e = true;
                        if (qa1Var.j != null) {
                            qa1Var.a();
                        }
                    }
                    qa1Var.d = z7;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        z = false;
        z2 = true;
        z3 = z2;
        qa1Var = ((wa1) this.a.b).m;
        synchronized (qa1Var.c) {
            qa1Var.f = z2;
            qa1Var.g = z3;
            qa1Var.h = z5;
            qa1Var.i = z;
            if (z6) {
                qa1Var.e = true;
                if (qa1Var.j != null) {
                    qa1Var.a();
                }
            }
            qa1Var.d = z7;
            return true;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        ((BaseInputConnection) ((wa1) this.a.b).k.getValue()).sendKeyEvent(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int i, int i2) {
        boolean z = this.k;
        if (z) {
            a(new th2(i, i2));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i) {
        boolean z = this.k;
        if (z) {
            a(new uh2(String.valueOf(charSequence), i));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setSelection(int i, int i2) {
        boolean z = this.k;
        if (!z) {
            return z;
        }
        a(new vh2(i, i2));
        return true;
    }
}
