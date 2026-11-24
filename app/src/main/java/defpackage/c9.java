package defpackage;

import android.view.DragEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c9 implements View.OnDragListener, ie0 {
    public final le0 a;
    public final pg b;
    public final b9 c;

    public c9() {
        le0 le0Var = new le0();
        le0Var.X = 0L;
        this.a = le0Var;
        this.b = new pg(0);
        this.c = new b9(this);
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        q82 q82Var = new q82(dragEvent);
        int action = dragEvent.getAction();
        s23 s23Var = s23.a;
        pg pgVar = this.b;
        le0 le0Var = this.a;
        switch (action) {
            case 1:
                o42 o42Var = new o42();
                je0 je0Var = new je0(q82Var, le0Var, o42Var);
                if (je0Var.j(le0Var) == s23Var) {
                    jd4.e(le0Var, je0Var);
                }
                boolean z = o42Var.a;
                pgVar.getClass();
                jg jgVar = new jg(pgVar);
                while (jgVar.hasNext()) {
                    ((le0) jgVar.next()).M0();
                }
                return z;
            case 2:
                le0Var.L0(q82Var);
                return false;
            case 3:
                return le0Var.I0();
            case 4:
                h6 h6Var = new h6(10, q82Var);
                if (h6Var.j(le0Var) == s23Var) {
                    jd4.e(le0Var, h6Var);
                }
                pgVar.clear();
                return false;
            case 5:
                le0Var.J0();
                return false;
            case 6:
                le0Var.K0();
                return false;
            default:
                return false;
        }
    }
}
