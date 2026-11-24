package defpackage;

import android.os.Bundle;
import android.speech.RecognitionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nn2 implements RecognitionListener {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ pn2 b;
    public final /* synthetic */ j12 c;
    public final /* synthetic */ t42 d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Locale f;

    public nn2(AtomicBoolean atomicBoolean, pn2 pn2Var, j12 j12Var, t42 t42Var, boolean z, Locale locale, long j) {
        this.a = atomicBoolean;
        this.b = pn2Var;
        this.c = j12Var;
        this.d = t42Var;
        this.e = z;
        this.f = locale;
    }

    @Override // android.speech.RecognitionListener
    public final void onBeginningOfSpeech() {
        on2.v(this.a, this.d, this.b, this.c, 30000L, new s83("Speech recognition stopped responding.", false, false));
    }

    @Override // android.speech.RecognitionListener
    public final void onEndOfSpeech() {
        this.b.f = 0.0f;
        this.c.s(r83.a);
        on2.v(this.a, this.d, this.b, this.c, 4000L, new s83("Speech recognition did not return words in time.", false, false));
    }

    @Override // android.speech.RecognitionListener
    public final void onError(int i) {
        z83 s83Var;
        pn2 pn2Var = this.b;
        pn2Var.getClass();
        switch (i) {
            case 1:
                s83Var = new s83("The recogniser timed out.", false, false);
                break;
            case 2:
                s83Var = new s83("The recogniser couldn't reach the network.", false, false);
                break;
            case 3:
                s83Var = new s83("Couldn't read from the microphone.", false, false);
                break;
            case 4:
                s83Var = new s83("The recognition service returned an error.", false, false);
                break;
            case 5:
                s83Var = new s83("The microphone session ended early.", false, false);
                break;
            case 6:
                s83Var = new x83("Silence.");
                break;
            case 7:
                s83Var = new x83("No speech detected.");
                break;
            case 8:
                s83Var = new s83("The recogniser is busy.", false, false);
                break;
            case 9:
                s83Var = new s83("Microphone permission is not granted.", true, false);
                break;
            case 10:
            default:
                s83Var = new s83(cq.h("Speech recognition error ", i, "."), false, false);
                break;
            case 11:
                s83Var = new s83("Server disconnected, retrying after backoff.", false, true);
                break;
            case 12:
                s83Var = new y83("That language isn't supported by the recogniser.");
                break;
            case 13:
                s83Var = new y83("That language pack isn't installed on this device.");
                break;
        }
        if (this.e && (s83Var instanceof y83)) {
            s83Var = new s83(cq.v("Install the offline ", this.f.getDisplayLanguage(), " speech recognition pack in Android's speech settings, then restart continuous listening."), true, false);
        }
        on2.w(this.a, this.d, pn2Var, this.c, s83Var);
    }

    @Override // android.speech.RecognitionListener
    public final void onPartialResults(Bundle bundle) {
        ArrayList<String> stringArrayList;
        String str;
        String string;
        if (this.a.get() || bundle == null || (stringArrayList = bundle.getStringArrayList("results_recognition")) == null || (str = (String) mz.y(stringArrayList)) == null || (string = cs2.V(str).toString()) == null) {
            return;
        }
        if (string.length() <= 0) {
            string = null;
        }
        if (string != null) {
            this.c.i.s(new w83(string));
        }
    }

    @Override // android.speech.RecognitionListener
    public final void onReadyForSpeech(Bundle bundle) {
        AtomicBoolean atomicBoolean = this.a;
        if (atomicBoolean.get()) {
            return;
        }
        this.b.f = 0.0f;
        this.c.s(v83.a);
        on2.v(atomicBoolean, this.d, this.b, this.c, 12000L, new x83("Silence."));
    }

    @Override // android.speech.RecognitionListener
    public final void onResults(Bundle bundle) {
        List stringArrayList;
        System.currentTimeMillis();
        if (bundle == null || (stringArrayList = bundle.getStringArrayList("results_recognition")) == null) {
            stringArrayList = ii0.a;
        }
        String str = (String) mz.y(stringArrayList);
        String string = str != null ? cs2.V(str).toString() : null;
        if (string == null) {
            string = "";
        }
        List<String> listU = mz.u(1, stringArrayList);
        ArrayList arrayList = new ArrayList(nz.d(listU));
        for (String str2 : listU) {
            str2.getClass();
            arrayList.add(cs2.V(str2).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        on2.w(this.a, this.d, this.b, this.c, string.length() == 0 ? new x83("Recogniser returned no text.") : new t83(string, arrayList2));
    }

    @Override // android.speech.RecognitionListener
    public final void onRmsChanged(float f) {
        pn2 pn2Var = this.b;
        float f2 = pn2Var.h;
        float f3 = f <= f2 ? 0.0f : f - f2;
        float f4 = pn2Var.f;
        float f5 = ((f3 - f4) * pn2Var.g) + f4;
        pn2Var.f = f5;
        this.c.s(new u83(ky3.b(f5 / 10.0f, 0.0f, 1.0f)));
    }

    @Override // android.speech.RecognitionListener
    public final void onBufferReceived(byte[] bArr) {
    }

    @Override // android.speech.RecognitionListener
    public final void onEvent(int i, Bundle bundle) {
    }
}
