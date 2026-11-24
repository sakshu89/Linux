package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yc0 extends RuntimeException {
    public final l20 a;

    public yc0(l20 l20Var) {
        this.a = l20Var;
        if (l20Var.a()) {
            return;
        }
        ArrayList arrayListA = ej4.a(l20Var);
        int size = arrayListA.size();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[size];
        for (int i = 0; i < size; i++) {
            stackTraceElementArr[i] = new StackTraceElement("$$compose", "m$" + ((m20) arrayListA.get(i)).a, "SourceFile", 1);
        }
        setStackTrace(stackTraceElementArr);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        l20 l20Var = this.a;
        if (!l20Var.a()) {
            return "Composition stack when thrown:";
        }
        StringBuilder sb = new StringBuilder("Composition stack when thrown:\n");
        int i = 0;
        if (l20Var.a()) {
            qc1 qc1VarE = nz.e();
            List list = l20Var.a;
            list.getClass();
            dh1 dh1Var = new dh1(list);
            int iA = dh1Var.a();
            for (int i2 = 0; i2 < iA; i2++) {
                ((m20) dh1Var.get(i2)).getClass();
            }
            qc1 qc1VarC = nz.c(qc1VarE);
            qc1VarC.getClass();
            dh1 dh1Var2 = new dh1(qc1VarC);
            int iA2 = dh1Var2.a();
            while (i < iA2) {
                String str = (String) dh1Var2.get(i);
                sb.append("\tat ");
                sb.append(str);
                sb.append('\n');
                i++;
            }
        } else {
            ArrayList arrayListA = ej4.a(l20Var);
            int size = arrayListA.size();
            while (i < size) {
                m20 m20Var = (m20) arrayListA.get(i);
                sb.append("\tat $$compose.m$");
                sb.append(m20Var.a);
                sb.append("(SourceFile:1)\n");
                i++;
            }
        }
        return sb.toString();
    }
}
