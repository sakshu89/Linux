package defpackage;

import android.os.Build;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class on2 extends nu2 implements vq0 {
    public int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ pn2 j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ Locale n;
    public final /* synthetic */ boolean s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public on2(pn2 pn2Var, boolean z, Locale locale, boolean z2, x50 x50Var) {
        super(2, x50Var);
        this.j = pn2Var;
        this.k = z;
        this.n = locale;
        this.s = z2;
    }

    public static final void v(AtomicBoolean atomicBoolean, t42 t42Var, pn2 pn2Var, j12 j12Var, long j, z83 z83Var) {
        if (atomicBoolean.get()) {
            return;
        }
        Runnable runnable = (Runnable) t42Var.a;
        if (runnable != null) {
            pn2Var.b.removeCallbacks(runnable);
        }
        bl blVar = new bl(z83Var, atomicBoolean, t42Var, pn2Var, j12Var, 1);
        pn2Var.b.postDelayed(blVar, j);
        t42Var.a = blVar;
    }

    public static final void w(AtomicBoolean atomicBoolean, t42 t42Var, pn2 pn2Var, j12 j12Var, z83 z83Var) {
        if (atomicBoolean.compareAndSet(false, true)) {
            Runnable runnable = (Runnable) t42Var.a;
            if (runnable != null) {
                pn2Var.b.removeCallbacks(runnable);
            }
            j12Var.s(z83Var);
            j12Var.b(null);
        }
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((on2) q((x50) obj2, (j12) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        on2 on2Var = new on2(this.j, this.k, this.n, this.s, x50Var);
        on2Var.i = obj;
        return on2Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        final j12 j12Var = (j12) this.i;
        int i = this.f;
        q43 q43Var = q43.a;
        if (i != 0) {
            if (i == 1) {
                bz3.g(obj);
                return q43Var;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        pn2 pn2Var = this.j;
        final long j = pn2Var.e.get();
        boolean z = this.k;
        if (z && !pn2Var.b()) {
            j12Var.s(new s83("On-device speech recognition is unavailable. Install an offline speech language pack on Android 12 or later, or type your request.", true, false));
            j12Var.b(null);
            return q43Var;
        }
        if (!z && !SpeechRecognizer.isRecognitionAvailable(pn2Var.a)) {
            j12Var.s(new s83("This device has no speech recognition service.", true, false));
            j12Var.b(null);
            return q43Var;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        final t42 t42Var = new t42();
        final t42 t42Var2 = new t42();
        final pn2 pn2Var2 = this.j;
        final boolean z2 = this.k;
        final Locale locale = this.n;
        final nn2 nn2Var = new nn2(atomicBoolean, pn2Var2, j12Var, t42Var2, z2, locale, jCurrentTimeMillis);
        Handler handler = pn2Var2.b;
        final boolean z3 = this.s;
        handler.post(new Runnable() { // from class: mn2
            /* JADX WARN: Code duplicated, block: B:32:0x0081  */
            @Override // java.lang.Runnable
            public final void run() {
                SpeechRecognizer speechRecognizerCreateOnDeviceSpeechRecognizer;
                Throwable th;
                boolean z4;
                AtomicBoolean atomicBoolean3 = atomicBoolean;
                long j2 = j;
                pn2 pn2Var3 = pn2Var2;
                boolean z5 = z2;
                boolean z6 = z3;
                t42 t42Var3 = t42Var;
                nn2 nn2Var2 = nn2Var;
                Locale locale2 = locale;
                t42 t42Var4 = t42Var2;
                j12 j12Var2 = j12Var;
                AtomicBoolean atomicBoolean4 = atomicBoolean2;
                if (atomicBoolean3.get()) {
                    return;
                }
                if (j2 != pn2Var3.e.get()) {
                    on2.w(atomicBoolean3, t42Var4, pn2Var3, j12Var2, new x83("Microphone stopped."));
                    return;
                }
                try {
                    try {
                        if (z5 || z6) {
                            try {
                                if (pn2Var3.b() && Build.VERSION.SDK_INT >= 31) {
                                    speechRecognizerCreateOnDeviceSpeechRecognizer = SpeechRecognizer.createOnDeviceSpeechRecognizer(pn2Var3.a);
                                }
                                pn2Var3.c = speechRecognizerCreateOnDeviceSpeechRecognizer;
                                t42Var3.a = speechRecognizerCreateOnDeviceSpeechRecognizer;
                                l52 l52Var = new l52(atomicBoolean4, j12Var2, pn2Var3, speechRecognizerCreateOnDeviceSpeechRecognizer, atomicBoolean3, t42Var4, 2);
                                SpeechRecognizer speechRecognizer = speechRecognizerCreateOnDeviceSpeechRecognizer;
                                atomicBoolean3 = atomicBoolean3;
                                pn2Var3.d = l52Var;
                                speechRecognizer.setRecognitionListener(nn2Var2);
                                on2.v(atomicBoolean3, t42Var4, pn2Var3, j12Var2, 5000L, new s83("The microphone did not become ready.", false, false));
                                t42Var4 = t42Var4;
                                j12Var2 = j12Var2;
                                if (!z6 || z5) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                speechRecognizer.startListening(pn2.a(pn2Var3, z4, locale2));
                                return;
                            } catch (SecurityException unused) {
                                on2.w(atomicBoolean3, t42Var4, pn2Var3, j12Var2, new s83("Microphone permission is not granted.", true, false));
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                on2.w(atomicBoolean3, t42Var4, pn2Var3, j12Var2, new s83(cq.j("Could not start the microphone: ", th.getMessage()), false, false));
                                return;
                            }
                        }
                        on2.v(atomicBoolean3, t42Var4, pn2Var3, j12Var2, 5000L, new s83("The microphone did not become ready.", false, false));
                        t42Var4 = t42Var4;
                        j12Var2 = j12Var2;
                        if (z6) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        speechRecognizer.startListening(pn2.a(pn2Var3, z4, locale2));
                        return;
                    } catch (SecurityException unused2) {
                        t42Var4 = t42Var4;
                        j12Var2 = j12Var2;
                        on2.w(atomicBoolean3, t42Var4, pn2Var3, j12Var2, new s83("Microphone permission is not granted.", true, false));
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        t42Var4 = t42Var4;
                        j12Var2 = j12Var2;
                        on2.w(atomicBoolean3, t42Var4, pn2Var3, j12Var2, new s83(cq.j("Could not start the microphone: ", th.getMessage()), false, false));
                        return;
                    }
                    l52 l52Var2 = new l52(atomicBoolean4, j12Var2, pn2Var3, speechRecognizerCreateOnDeviceSpeechRecognizer, atomicBoolean3, t42Var4, 2);
                    SpeechRecognizer speechRecognizer2 = speechRecognizerCreateOnDeviceSpeechRecognizer;
                    atomicBoolean3 = atomicBoolean3;
                    pn2Var3.d = l52Var2;
                    speechRecognizer2.setRecognitionListener(nn2Var2);
                } catch (SecurityException unused3) {
                    atomicBoolean3 = atomicBoolean3;
                } catch (Throwable th4) {
                    th = th4;
                    atomicBoolean3 = atomicBoolean3;
                }
                speechRecognizerCreateOnDeviceSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(pn2Var3.a);
                pn2Var3.c = speechRecognizerCreateOnDeviceSpeechRecognizer;
                t42Var3.a = speechRecognizerCreateOnDeviceSpeechRecognizer;
            }
        });
        l52 l52Var = new l52(atomicBoolean, t42Var2, this.j, t42Var, atomicBoolean2, j12Var, 1);
        this.i = null;
        this.f = 1;
        Object objA = zt3.a(j12Var, l52Var, this);
        t70 t70Var = t70.a;
        return objA == t70Var ? t70Var : q43Var;
    }
}
