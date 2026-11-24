package defpackage;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xx1 {
    public Locale c;
    public final TextToSpeech e;
    public final x00 a = ui4.a();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public float d = 1.05f;

    public xx1(Context context) {
        this.e = new TextToSpeech(context, new on1(1, this));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(y50 y50Var) {
        vx1 vx1Var;
        if (y50Var instanceof vx1) {
            vx1Var = (vx1) y50Var;
            int i = vx1Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                vx1Var.i = i - Integer.MIN_VALUE;
            } else {
                vx1Var = new vx1(this, y50Var);
            }
        } else {
            vx1Var = new vx1(this, y50Var);
        }
        Object objC = vx1Var.e;
        int i2 = vx1Var.i;
        x50 x50Var = null;
        if (i2 == 0) {
            bz3.g(objC);
            l2 l2Var = new l2(this, x50Var, 15);
            vx1Var.i = 1;
            objC = xc4.c(5000L, l2Var, vx1Var);
            t70 t70Var = t70.a;
            if (objC == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(objC);
        }
        return Boolean.valueOf(g31.a(objC, Boolean.TRUE));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d2 A[Catch: all -> 0x0036, CancellationException -> 0x0039, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0031, B:97:0x01ce, B:99:0x01d2, B:100:0x01d5, B:107:0x01e8, B:108:0x01eb), top: B:111:0x0029 }] */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String str, Locale locale, String str2, y50 y50Var) throws Throwable {
        wx1 wx1Var;
        Locale locale2;
        String str3;
        String str4;
        Object next;
        Object obj;
        Voice voice;
        Boolean bool;
        if (y50Var instanceof wx1) {
            wx1 wx1Var2 = (wx1) y50Var;
            int i = wx1Var2.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                wx1Var2.n = i - Integer.MIN_VALUE;
                wx1Var = wx1Var2;
            } else {
                wx1Var = new wx1(this, y50Var);
            }
        } else {
            wx1Var = new wx1(this, y50Var);
        }
        Object objC = wx1Var.j;
        int i2 = wx1Var.n;
        ConcurrentHashMap concurrentHashMap = this.b;
        int i3 = 1;
        TextToSpeech textToSpeech = this.e;
        Object obj2 = t70.a;
        try {
            if (i2 == 0) {
                bz3.g(objC);
                wx1Var.e = str;
                locale2 = locale;
                wx1Var.f = locale2;
                str3 = str2;
                wx1Var.i = str3;
                wx1Var.n = 1;
                Object objA = a(wx1Var);
                if (objA != obj2) {
                    str4 = str;
                    objC = objA;
                }
                return obj2;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                obj = wx1Var.i;
                try {
                    bz3.g(objC);
                    bool = (Boolean) objC;
                    if (bool == null) {
                        textToSpeech.stop();
                    }
                    boolean zA = g31.a(bool, Boolean.TRUE);
                    concurrentHashMap.remove(obj);
                    return Boolean.valueOf(zA);
                } catch (CancellationException e) {
                    e = e;
                    textToSpeech.stop();
                    throw e;
                }
            }
            String str5 = wx1Var.i;
            Locale locale3 = wx1Var.f;
            str4 = wx1Var.e;
            bz3.g(objC);
            str3 = str5;
            locale2 = locale3;
            if (!((Boolean) objC).booleanValue()) {
                return Boolean.FALSE;
            }
            int i4 = 0;
            if (!g31.a(this.c, locale2) || (voice = textToSpeech.getVoice()) == null || voice.isNetworkConnectionRequired()) {
                if (textToSpeech.setLanguage(locale2) >= 0) {
                    Set<Voice> voices = textToSpeech.getVoices();
                    mi0 mi0Var = mi0.a;
                    if (voices == null) {
                        voices = mi0Var;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : voices) {
                        Voice voice2 = (Voice) obj3;
                        int i5 = i3;
                        if (g31.a(voice2.getLocale().getLanguage(), locale2.getLanguage()) && !voice2.isNetworkConnectionRequired()) {
                            Set<String> features = voice2.getFeatures();
                            if (features == null) {
                                features = mi0Var;
                            }
                            if (!features.contains("notInstalled")) {
                                arrayList.add(obj3);
                            }
                        }
                        i3 = i5;
                    }
                    int i6 = i3;
                    lo0 lo0Var = new lo0(19);
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        next = it.next();
                        while (it.hasNext()) {
                            Object next2 = it.next();
                            Integer numValueOf = Integer.valueOf(i4);
                            Integer numValueOf2 = Integer.valueOf(i6);
                            int iCompare = lo0Var.compare(next, next2);
                            if (iCompare == 0) {
                                iCompare = si4.a(Integer.valueOf(((Voice) next).getQuality()), Integer.valueOf(((Voice) next2).getQuality()));
                            }
                            if (iCompare == 0) {
                                Integer num = g31.a(((Voice) next).getLocale().getCountry(), locale2.getCountry()) ? numValueOf2 : numValueOf;
                                if (g31.a(((Voice) next2).getLocale().getCountry(), locale2.getCountry())) {
                                    numValueOf = numValueOf2;
                                }
                                iCompare = si4.a(num, numValueOf);
                            }
                            lo0Var = lo0Var;
                            if (iCompare < 0) {
                                next = next2;
                            }
                            i4 = 0;
                        }
                    } else {
                        next = null;
                    }
                    Voice voice3 = (Voice) next;
                    if (voice3 != null && textToSpeech.setVoice(voice3) == 0) {
                        this.c = locale2;
                    }
                }
                return Boolean.FALSE;
            }
            textToSpeech.setSpeechRate(this.d);
            x00 x00VarA = ui4.a();
            concurrentHashMap.put(str3, x00VarA);
            if (textToSpeech.speak(str4, 0, null, str3) != 0) {
                concurrentHashMap.remove(str3);
                return Boolean.FALSE;
            }
            try {
                long jD = ky3.d(((long) str4.length()) * 120, 4000L, 30000L);
                d60 d60Var = new d60(x00VarA, null, 3);
                wx1Var.e = null;
                wx1Var.f = null;
                wx1Var.i = str3;
                wx1Var.n = 2;
                objC = xc4.c(jD, d60Var, wx1Var);
                if (objC != obj2) {
                    obj = str3;
                    bool = (Boolean) objC;
                    if (bool == null) {
                        textToSpeech.stop();
                    }
                    boolean zA2 = g31.a(bool, Boolean.TRUE);
                    concurrentHashMap.remove(obj);
                    return Boolean.valueOf(zA2);
                }
                return obj2;
            } catch (CancellationException e2) {
                e = e2;
                textToSpeech.stop();
                throw e;
            } catch (Throwable th) {
                th = th;
                wx1Var = str3;
                concurrentHashMap.remove(wx1Var);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
