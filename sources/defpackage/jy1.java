package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jy1 extends ik1 {
    @Override // defpackage.ik1
    public final dk1 e() {
        return new ky1(m34.b, null);
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
        if (!(obj instanceof jy1)) {
            return false;
        }
        va vaVar = m34.b;
        return vaVar.equals(vaVar);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ky1 ky1Var = (ky1) dk1Var;
        va vaVar = ky1Var.H;
        va vaVar2 = m34.b;
        if (g31.a(vaVar, vaVar2)) {
            return;
        }
        ky1Var.H = vaVar2;
        if (ky1Var.X) {
            ky1Var.K0();
        }
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (1008 * 31);
    }

    public final String toString() {
        return "PointerHoverIconModifierElement(icon=" + m34.b + ", overrideDescendants=false)";
    }
}
