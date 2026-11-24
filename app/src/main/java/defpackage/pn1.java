package defpackage;

import android.speech.tts.UtteranceProgressListener;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pn1 extends UtteranceProgressListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ pn1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public final void onDone(String str) throws IllegalAccessException, InvocationTargetException {
        x00 x00Var;
        x00 x00Var2;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                if (str != null && (x00Var = (x00) ((sn1) obj).e.remove(str)) != null) {
                    x00Var.b0(Boolean.TRUE);
                    break;
                }
                break;
            default:
                if (str != null && (x00Var2 = (x00) ((xx1) obj).b.remove(str)) != null) {
                    x00Var2.b0(Boolean.TRUE);
                    break;
                }
                break;
        }
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public final void onError(String str) throws IllegalAccessException, InvocationTargetException {
        x00 x00Var;
        x00 x00Var2;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                if (str != null && (x00Var = (x00) ((sn1) obj).e.remove(str)) != null) {
                    x00Var.b0(Boolean.FALSE);
                    break;
                }
                break;
            default:
                if (str != null && (x00Var2 = (x00) ((xx1) obj).b.remove(str)) != null) {
                    x00Var2.b0(Boolean.FALSE);
                    break;
                }
                break;
        }
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public final void onStart(String str) {
        int i = this.a;
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public final void onStop(String str, boolean z) throws IllegalAccessException, InvocationTargetException {
        x00 x00Var;
        x00 x00Var2;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                if (str != null && (x00Var = (x00) ((sn1) obj).e.remove(str)) != null) {
                    x00Var.b0(Boolean.FALSE);
                    break;
                }
                break;
            default:
                if (str != null && (x00Var2 = (x00) ((xx1) obj).b.remove(str)) != null) {
                    x00Var2.b0(Boolean.FALSE);
                    break;
                }
                break;
        }
    }

    private final void a(String str) {
    }

    private final void b(String str) {
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public final void onError(String str, int i) throws IllegalAccessException, InvocationTargetException {
        x00 x00Var;
        x00 x00Var2;
        int i2 = this.a;
        Object obj = this.b;
        switch (i2) {
            case 0:
                if (str != null && (x00Var = (x00) ((sn1) obj).e.remove(str)) != null) {
                    x00Var.b0(Boolean.FALSE);
                    break;
                }
                break;
            default:
                if (str != null && (x00Var2 = (x00) ((xx1) obj).b.remove(str)) != null) {
                    x00Var2.b0(Boolean.FALSE);
                    break;
                }
                break;
        }
    }
}
