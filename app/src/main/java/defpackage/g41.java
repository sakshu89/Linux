package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g41 extends CancellationException {
    public final transient p41 a;

    public g41(String str, Throwable th, p41 p41Var) {
        super(str);
        this.a = p41Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g41)) {
            return false;
        }
        g41 g41Var = (g41) obj;
        if (!g31.a(g41Var.getMessage(), getMessage())) {
            return false;
        }
        Object obj2 = g41Var.a;
        if (obj2 == null) {
            obj2 = io1.b;
        }
        Object obj3 = this.a;
        if (obj3 == null) {
            obj3 = io1.b;
        }
        return g31.a(obj2, obj3) && g31.a(g41Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        message.getClass();
        int iHashCode = message.hashCode() * 31;
        Object obj = this.a;
        if (obj == null) {
            obj = io1.b;
        }
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Throwable cause = getCause();
        return iHashCode2 + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; job=");
        Object obj = this.a;
        if (obj == null) {
            obj = io1.b;
        }
        sb.append(obj);
        return sb.toString();
    }
}
