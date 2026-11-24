package defpackage;

import com.ibm.icu.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m91 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ o91 b;

    public /* synthetic */ m91(o91 o91Var, int i) {
        this.a = i;
        this.b = o91Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        o91 o91Var = this.b;
        switch (i) {
            case 0:
                ea1 ea1Var = o91Var.H.b;
                return Float.valueOf((ea1Var.g() * BreakIterator.WORD_IDEO_LIMIT) + ea1Var.h());
            case 1:
                ea1 ea1Var2 = o91Var.H.b;
                int iG = ea1Var2.g();
                int iH = ea1Var2.h();
                return Float.valueOf(ea1Var2.c() ? (iG * BreakIterator.WORD_IDEO_LIMIT) + iH + 100.0f : (iG * BreakIterator.WORD_IDEO_LIMIT) + iH);
            default:
                ea1 ea1Var3 = o91Var.H.b;
                int iG2 = (int) (ea1Var3.i().o == js1.a ? ea1Var3.i().g() & 4294967295L : ea1Var3.i().g() >> 32);
                ea1 ea1Var4 = o91Var.H.b;
                return Float.valueOf(iG2 - ((-ea1Var4.i().l) + ea1Var4.i().p));
        }
    }
}
