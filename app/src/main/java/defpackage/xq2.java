package defpackage;

import com.ibm.icu.impl.locale.BaseLocale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xq2 {
    public static final /* synthetic */ int a = 0;

    static {
        Object h72Var;
        Object h72Var2;
        Exception exc = new Exception();
        String simpleName = pd3.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), BaseLocale.SEP, stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            h72Var = pk.class.getCanonicalName();
        } catch (Throwable th) {
            h72Var = new h72(th);
        }
        if (i72.a(h72Var) != null) {
            h72Var = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            h72Var2 = xq2.class.getCanonicalName();
        } catch (Throwable th2) {
            h72Var2 = new h72(th2);
        }
        if (i72.a(h72Var2) != null) {
            h72Var2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
