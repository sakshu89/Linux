package defpackage;

import android.text.Spanned;
import java.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ra4 {
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.text.BreakIterator] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, kf] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final int a(int i, String str) {
        ?? r5;
        ?? r6;
        int spanEnd;
        oh0 oh0VarC = c();
        Integer num = null;
        if (oh0VarC != null) {
            hh1.e("Not initialized yet", oh0VarC.c() == 1);
            hh1.d(str, "charSequence cannot be null");
            ?? r4 = oh0VarC.e.b;
            r4.getClass();
            if (i < 0 || i >= str.length()) {
                r6 = str;
                spanEnd = -1;
            } else if (str instanceof Spanned) {
                Spanned spanned = (Spanned) str;
                r33[] r33VarArr = (r33[]) spanned.getSpans(i, i + 1, r33.class);
                if (r33VarArr.length > 0) {
                    spanEnd = spanned.getSpanEnd(r33VarArr[0]);
                    r6 = str;
                } else {
                    ?? r7 = str;
                    spanEnd = ((xh0) r4.y(r7, Math.max(0, i - 16), Math.min(str.length(), i + 16), Integer.MAX_VALUE, true, new xh0(i))).c;
                    r6 = r7;
                }
            } else {
                ?? r8 = str;
                spanEnd = ((xh0) r4.y(r8, Math.max(0, i - 16), Math.min(str.length(), i + 16), Integer.MAX_VALUE, true, new xh0(i))).c;
                r6 = r8;
            }
            Integer numValueOf = Integer.valueOf(spanEnd);
            r5 = r6;
            if (spanEnd != -1) {
                num = numValueOf;
                r5 = r6;
            }
        } else {
            r5 = str;
        }
        if (num != null) {
            return num.intValue();
        }
        ?? characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(r5);
        return characterInstance.following(i);
    }

    public static final int b(int i, String str) {
        oh0 oh0VarC = c();
        Integer num = null;
        if (oh0VarC != null) {
            Integer numValueOf = Integer.valueOf(oh0VarC.b(str, Math.max(0, i - 1)));
            if (numValueOf.intValue() != -1) {
                num = numValueOf;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.preceding(i);
    }

    public static final oh0 c() {
        if (!oh0.d()) {
            return null;
        }
        oh0 oh0VarA = oh0.a();
        if (oh0VarA.c() == 1) {
            return oh0VarA;
        }
        return null;
    }
}
