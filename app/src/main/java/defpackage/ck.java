package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ck extends dk1 {
    public final /* synthetic */ dk H;
    public n03 x;

    public ck(dk dkVar) {
        this.H = dkVar;
    }

    @Override // defpackage.dk1
    public final void A0() {
        dk dkVar = this.H;
        dkVar.a = this;
        if (dkVar.b != null) {
            I0();
        }
    }

    @Override // defpackage.dk1
    public final void B0() {
        dk dkVar = this.H;
        if (dkVar.a == this) {
            dkVar.a = null;
        }
        n03 n03Var = this.x;
        if (n03Var != null) {
            n03Var.b();
        }
        this.x = null;
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
    public final void I0() {
        o0 o0Var = new o0(2, this, this.H);
        n71 n71VarG = cm4.g(this);
        int i = n71VarG.b;
        n42 rectManager = ((r7) q71.a(n71VarG)).getRectManager();
        o03 o03Var = rectManager.b;
        o03Var.getClass();
        ml1 ml1Var = o03Var.a;
        n03 n03Var = new n03(o03Var, i, this, o0Var);
        Object objB = ml1Var.b(i);
        if (objB == null) {
            ml1Var.h(i, n03Var);
            objB = n03Var;
        }
        n03 n03Var2 = (n03) objB;
        if (n03Var2 != n03Var) {
            while (true) {
                n03 n03Var3 = n03Var2.d;
                if (n03Var3 == null) {
                    break;
                } else {
                    n03Var2 = n03Var3;
                }
            }
            n03Var2.d = n03Var;
        }
        if (cm4.g(this.a).k) {
            rectManager.a.f(i, true);
        }
        rectManager.d = true;
        rectManager.j();
        this.x = n03Var;
    }
}
