package defpackage;

import android.os.Build;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rx1 extends nu2 implements vq0 {
    public an1 f;
    public sx1 i;
    public CharSequence j;
    public long k;
    public int n;
    public /* synthetic */ Object s;
    public final /* synthetic */ CharSequence t;
    public final /* synthetic */ long u;
    public final /* synthetic */ sx1 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rx1(long j, x50 x50Var, sx1 sx1Var, CharSequence charSequence) {
        super(2, x50Var);
        this.t = charSequence;
        this.u = j;
        this.v = sx1Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((rx1) q((x50) obj2, (TextClassifier) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        rx1 rx1Var = new rx1(this.u, x50Var, this.v, this.t);
        rx1Var.s = obj;
        return rx1Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        long j;
        an1 an1Var;
        TextSelection textSelection;
        CharSequence charSequence;
        sx1 sx1Var;
        int i = this.n;
        if (i == 0) {
            bz3.g(obj);
            TextClassifier textClassifier = (TextClassifier) this.s;
            c2.A();
            long j2 = this.u;
            int iF = oz2.f(j2);
            int iE = oz2.e(j2);
            CharSequence charSequence2 = this.t;
            TextSelection.Request.Builder builderK = c2.k(charSequence2, iF, iE);
            sx1 sx1Var2 = this.v;
            TextSelection.Request.Builder defaultLocales = builderK.setDefaultLocales(sx1Var2.b());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 31) {
                defaultLocales.setIncludeTextClassification(true);
            }
            TextSelection textSelectionSuggestSelection = textClassifier.suggestSelection(defaultLocales.build());
            long jA = hc4.a(textSelectionSuggestSelection.getSelectionStartIndex(), textSelectionSuggestSelection.getSelectionEndIndex());
            t70 t70Var = t70.a;
            if (i2 < 31 || textSelectionSuggestSelection.getTextClassification() == null) {
                this.k = jA;
                this.n = 2;
                if (sx1.a(this.v, this.t, jA, textClassifier, this) != t70Var) {
                    j = jA;
                }
            } else {
                an1Var = sx1Var2.e;
                this.s = textSelectionSuggestSelection;
                this.f = an1Var;
                this.i = sx1Var2;
                this.j = charSequence2;
                this.k = jA;
                this.n = 1;
                if (an1Var.e(this) != t70Var) {
                    textSelection = textSelectionSuggestSelection;
                    charSequence = charSequence2;
                    sx1Var = sx1Var2;
                    j = jA;
                    TextClassification textClassification = textSelection.getTextClassification();
                    textClassification.getClass();
                    sx1Var.g.setValue(new yw2(charSequence, j, textClassification));
                }
            }
            return t70Var;
        }
        if (i == 1) {
            j = this.k;
            charSequence = this.j;
            sx1Var = this.i;
            an1Var = this.f;
            textSelection = (TextSelection) this.s;
            bz3.g(obj);
            try {
                TextClassification textClassification2 = textSelection.getTextClassification();
                textClassification2.getClass();
                sx1Var.g.setValue(new yw2(charSequence, j, textClassification2));
            } finally {
                an1Var.h(null);
            }
        } else {
            if (i != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = this.k;
            bz3.g(obj);
        }
        return new oz2(j);
    }
}
