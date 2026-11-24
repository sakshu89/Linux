package defpackage;

import android.graphics.Rect;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s6 extends vj implements wn0 {
    public final wj1 a;
    public final jg2 b;
    public final r7 c;
    public final n42 e;
    public final String f;
    public final Rect i = new Rect();
    public final AutofillId j;
    public final nl1 k;
    public boolean n;

    public s6(wj1 wj1Var, jg2 jg2Var, r7 r7Var, n42 n42Var, String str) {
        this.a = wj1Var;
        this.b = jg2Var;
        this.c = r7Var;
        this.e = n42Var;
        this.f = str;
        r7Var.setImportantForAutofill(1);
        AutofillId autofillId = r7Var.getAutofillId();
        if (autofillId == null) {
            throw cq.e("Required value was null.");
        }
        this.j = autofillId;
        this.k = new nl1();
    }

    @Override // defpackage.wn0
    public final void a(ko0 ko0Var, ko0 ko0Var2) {
        n71 n71VarG;
        cg2 cg2VarW;
        n71 n71VarG2;
        cg2 cg2VarW2;
        if (ko0Var != null && (n71VarG2 = cm4.g(ko0Var)) != null && (cg2VarW2 = n71VarG2.w()) != null) {
            gm1 gm1Var = cg2VarW2.a;
            if (gm1Var.b(bg2.g) || gm1Var.b(bg2.h)) {
                ((AutofillManager) this.a.b).notifyViewExited(this.c, n71VarG2.b);
            }
        }
        if (ko0Var2 == null || (n71VarG = cm4.g(ko0Var2)) == null || (cg2VarW = n71VarG.w()) == null) {
            return;
        }
        gm1 gm1Var2 = cg2VarW.a;
        if (gm1Var2.b(bg2.g) || gm1Var2.b(bg2.h)) {
            int i = n71VarG.b;
            this.e.a.h(i, new q6(this, i));
        }
    }
}
