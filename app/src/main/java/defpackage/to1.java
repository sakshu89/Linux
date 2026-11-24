package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class to1 implements InputConnection {
    public final h6 a;
    public i42 b;

    public to1(i42 i42Var, h6 h6Var) {
        this.a = h6Var;
        this.b = i42Var;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.beginBatchEdit();
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean clearMetaKeyStates(int i) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.clearMetaKeyStates(i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final void closeConnection() {
        i42 i42Var = this.b;
        if (i42Var != null) {
            if (i42Var != null) {
                i42Var.closeConnection();
                this.b = null;
            }
            this.a.j(this);
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCompletion(CompletionInfo completionInfo) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.commitCompletion(completionInfo);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.commitContent(inputContentInfo, i, bundle);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCorrection(CorrectionInfo correctionInfo) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.commitCorrection(correctionInfo);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.commitText(charSequence, i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.deleteSurroundingText(i, i2);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.deleteSurroundingTextInCodePoints(i, i2);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.b();
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.finishComposingText();
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int i) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.getCursorCapsMode(i);
        }
        return 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.getExtractedText(extractedTextRequest, i);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int i) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.getSelectedText(i);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int i, int i2) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.getTextAfterCursor(i, i2);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int i, int i2) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.getTextBeforeCursor(i, i2);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int i) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.performContextMenuAction(i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int i) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.performEditorAction(i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.performPrivateCommand(str, bundle);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean reportFullscreenMode(boolean z) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int i) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.requestCursorUpdates(i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.sendKeyEvent(keyEvent);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int i, int i2) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.setComposingRegion(i, i2);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.setComposingText(charSequence, i);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setSelection(int i, int i2) {
        i42 i42Var = this.b;
        if (i42Var != null) {
            return i42Var.setSelection(i, i2);
        }
        return false;
    }
}
