package defpackage;

import android.speech.tts.TextToSpeech;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class on1 implements TextToSpeech.OnInitListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ on1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public final void onInit(int i) throws IllegalAccessException, InvocationTargetException {
        int i2 = this.a;
        Object obj = this.b;
        int i3 = 1;
        switch (i2) {
            case 0:
                ((x00) obj).b0(Boolean.valueOf(i == 0));
                break;
            default:
                xx1 xx1Var = (xx1) obj;
                boolean z = i == 0;
                if (z) {
                    TextToSpeech textToSpeech = xx1Var.e;
                    textToSpeech.setSpeechRate(1.0f);
                    textToSpeech.setOnUtteranceProgressListener(new pn1(i3, xx1Var));
                }
                xx1Var.a.b0(Boolean.valueOf(z));
                break;
        }
    }
}
