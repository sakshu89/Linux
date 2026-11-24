package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class je0 extends k61 implements hq0 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ o42 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public je0(q82 q82Var, le0 le0Var, o42 o42Var) {
        super(1);
        this.c = o42Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.b;
        s23 s23Var = s23.a;
        o42 o42Var = this.c;
        switch (i) {
            case 0:
                le0 le0Var = (le0) obj;
                if (!le0Var.w) {
                    return s23.b;
                }
                if (le0Var.H != null) {
                    z01.b("DragAndDropTarget self reference must be null at the start of a drag and drop session");
                }
                le0Var.H = null;
                o42Var.a = o42Var.a;
                return s23Var;
            default:
                if (!((ww0) obj).X) {
                    return s23Var;
                }
                o42Var.a = false;
                return s23.c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public je0(o42 o42Var) {
        super(1);
        this.c = o42Var;
    }
}
