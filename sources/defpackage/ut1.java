package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class ut1 extends ik1 {
    public final tt1 a;
    public final nl b;

    public ut1(tt1 tt1Var, nl nlVar) {
        this.a = tt1Var;
        this.b = nlVar;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        ll llVar = xy.i;
        vt1 vt1Var = new vt1();
        vt1Var.x = this.a;
        vt1Var.H = true;
        vt1Var.X = llVar;
        vt1Var.Y = l50.a;
        vt1Var.Z = 1.0f;
        vt1Var.c0 = this.b;
        return vt1Var;
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
        if (!(obj instanceof ut1)) {
            return false;
        }
        ut1 ut1Var = (ut1) obj;
        if (!g31.a(this.a, ut1Var.a)) {
            return false;
        }
        ll llVar = xy.i;
        return llVar.equals(llVar) && Float.compare(1.0f, 1.0f) == 0 && g31.a(this.b, ut1Var.b);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        vt1 vt1Var = (vt1) dk1Var;
        boolean z = vt1Var.H;
        tt1 tt1Var = this.a;
        boolean z2 = (z && xk2.a(vt1Var.x.d(), tt1Var.d())) ? false : true;
        vt1Var.x = tt1Var;
        vt1Var.H = true;
        vt1Var.X = xy.i;
        vt1Var.Y = l50.a;
        vt1Var.Z = 1.0f;
        vt1Var.c0 = this.b;
        if (z2) {
            up4.a(vt1Var);
        }
        vm4.a(vt1Var);
    }

    public final int hashCode() {
        int iB = cq.b((l50.a.hashCode() + ((Float.hashCode(0.0f) + (Float.hashCode(0.0f) * 31) + ky0.e(this.a.hashCode() * 31, 31, true)) * 31)) * 31, 1.0f, 31);
        nl nlVar = this.b;
        return iB + (nlVar == null ? 0 : nlVar.hashCode());
    }

    public final String toString() {
        return "PainterElement(painter=" + this.a + ", sizeToIntrinsics=true, alignment=" + xy.i + ", contentScale=" + l50.a + ", alpha=1.0, colorFilter=" + this.b + ')';
    }
}
