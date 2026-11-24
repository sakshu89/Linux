package defpackage;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ci0 implements TextWatcher {
    public final ve a;
    public bi0 b;
    public boolean c = true;

    public ci0(ve veVar) {
        this.a = veVar;
    }

    public static void a(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            oh0 oh0VarA = oh0.a();
            if (editableText == null) {
                length = 0;
            } else {
                oh0VarA.getClass();
                length = editableText.length();
            }
            oh0VarA.g(editableText, 0, length, 0);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ve veVar = this.a;
        if (!veVar.isInEditMode() && this.c && oh0.d() && i2 <= i3 && (charSequence instanceof Spannable)) {
            int iC = oh0.a().c();
            if (iC != 0) {
                if (iC == 1) {
                    oh0.a().g((Spannable) charSequence, i, i3 + i, 0);
                    return;
                } else if (iC != 3) {
                    return;
                }
            }
            oh0 oh0VarA = oh0.a();
            if (this.b == null) {
                this.b = new bi0(veVar);
            }
            oh0VarA.h(this.b);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
