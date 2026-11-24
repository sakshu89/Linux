package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v91 {
    public final ml1 a;
    public final t91 b;
    public final y81 c;
    public final long d;
    public final /* synthetic */ y81 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ jl h;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;
    public final /* synthetic */ long k;
    public final /* synthetic */ ea1 l;

    public v91(long j, t91 t91Var, y81 y81Var, int i, int i2, jl jlVar, int i3, int i4, long j2, ea1 ea1Var) {
        this.e = y81Var;
        this.f = i;
        this.g = i2;
        this.h = jlVar;
        this.i = i3;
        this.j = i4;
        this.k = j2;
        this.l = ea1Var;
        ml1 ml1Var = d21.a;
        this.a = new ml1();
        this.b = t91Var;
        this.c = y81Var;
        this.d = r40.b(q40.h(j), Integer.MAX_VALUE, 5);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final y91 a(int i, long j) {
        List list;
        t91 t91Var = this.b;
        Object objD = t91Var.d(i);
        t91Var.b(i);
        ml1 ml1Var = this.a;
        List list2 = (List) ml1Var.b(i);
        if (list2 != null) {
            list = list2;
        } else {
            y81 y81Var = this.c;
            t91 t91Var2 = y81Var.c;
            ml1 ml1Var2 = y81Var.e;
            List listF = (List) ml1Var2.b(i);
            if (listF == null) {
                Object objD2 = t91Var2.d(i);
                t91Var2.b(i);
                listF = y81Var.b.F(y81Var.a.a(i, objD2, null), objD2);
                ml1Var2.h(i, listF);
            }
            int size = listF.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(((jh1) listF.get(i2)).e(j));
            }
            ml1Var.h(i, arrayList);
            list = arrayList;
        }
        return new y91(i, list, this.h, this.e.b.getLayoutDirection(), this.i, this.j, i != this.f + (-1) ? this.g : 0, this.k, objD, null, this.l.n, j);
    }
}
