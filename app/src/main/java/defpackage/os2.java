package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class os2 extends ik1 {
    public final he0 a;

    public os2(he0 he0Var) {
        this.a = he0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new ps2(ya4.a, this.a);
    }

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
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof os2)) {
            return false;
        }
        os2 os2Var = (os2) obj;
        va vaVar = ya4.a;
        return vaVar.equals(vaVar) && g31.a(this.a, os2Var.a);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ps2 ps2Var = (ps2) dk1Var;
        va vaVar = ps2Var.H;
        va vaVar2 = ya4.a;
        if (!g31.a(vaVar, vaVar2)) {
            ps2Var.H = vaVar2;
            if (ps2Var.X) {
                ps2Var.K0();
            }
        }
        ps2Var.x = this.a;
    }

    public final int hashCode() {
        int iE = ky0.e(1022 * 31, 31, false);
        he0 he0Var = this.a;
        return iE + (he0Var != null ? he0Var.hashCode() : 0);
    }

    public final String toString() {
        return "StylusHoverIconModifierElement(icon=" + ya4.a + ", overrideDescendants=false, touchBoundsExpansion=" + this.a + ')';
    }
}
